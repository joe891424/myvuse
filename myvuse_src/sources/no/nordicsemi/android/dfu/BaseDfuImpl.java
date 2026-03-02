package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import com.google.common.base.Ascii;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;

/* JADX INFO: loaded from: classes6.dex */
abstract class BaseDfuImpl implements DfuService {
    static final int INDICATIONS = 2;
    private static final int MAX_PACKET_SIZE_DEFAULT = 20;
    static final int NOTIFICATIONS = 1;
    private static final String TAG = "DfuImpl";
    boolean mAborted;
    private int mCurrentMtu;
    int mError;
    int mFileType;
    InputStream mFirmwareStream;
    BluetoothGatt mGatt;
    int mImageSizeInBytes;
    int mInitPacketSizeInBytes;
    InputStream mInitPacketStream;
    boolean mPaused;
    DfuProgressInfo mProgressInfo;
    boolean mRequestCompleted;
    boolean mResetRequestSent;
    DfuBaseService mService;
    static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    private static final char[] HEX_ARRAY = BinTools.hex.toCharArray();
    final Object mLock = new Object();
    byte[] mReceivedData = null;
    byte[] mBuffer = new byte[20];
    boolean mConnected = true;

    protected class BaseBluetoothGattCallback extends DfuCallback.DfuGattCallback {
        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(final BluetoothGatt gatt, final int txPhy, final int rxPhy, final int status) {
        }

        protected BaseBluetoothGattCallback() {
        }

        @Override // no.nordicsemi.android.dfu.DfuCallback.DfuGattCallback
        public void onDisconnected() {
            BaseDfuImpl.this.mConnected = false;
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
            if (status == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
                BaseDfuImpl.this.mReceivedData = characteristic.getValue();
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl.this.loge("Characteristic read error: " + status);
                BaseDfuImpl.this.mError = status | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(final BluetoothGatt gatt, final BluetoothGattDescriptor descriptor, final int status) {
            if (status == 0) {
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(descriptor.getUuid())) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from descr." + descriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(descriptor));
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(descriptor.getCharacteristic().getUuid())) {
                        BaseDfuImpl.this.mRequestCompleted = true;
                    } else {
                        BaseDfuImpl.this.loge("Unknown descriptor read");
                    }
                }
            } else {
                BaseDfuImpl.this.loge("Descriptor read error: " + status);
                BaseDfuImpl.this.mError = status | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(final BluetoothGatt gatt, final BluetoothGattDescriptor descriptor, final int status) {
            if (status == 0) {
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(descriptor.getUuid())) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(5, "Data written to descr." + descriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(descriptor));
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(descriptor.getCharacteristic().getUuid())) {
                        BaseDfuImpl.this.mService.sendLogBroadcast(1, "Indications enabled for " + descriptor.getCharacteristic().getUuid());
                    } else {
                        BaseDfuImpl.this.mService.sendLogBroadcast(1, "Notifications enabled for " + descriptor.getCharacteristic().getUuid());
                    }
                }
            } else {
                BaseDfuImpl.this.loge("Descriptor write error: " + status);
                BaseDfuImpl.this.mError = status | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(final BluetoothGatt gatt, final int mtu, final int status) {
            if (status == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "MTU changed to: " + mtu);
                int i = mtu - 3;
                if (i > BaseDfuImpl.this.mBuffer.length) {
                    BaseDfuImpl.this.mBuffer = new byte[i];
                }
                BaseDfuImpl.this.logi("MTU changed to: " + mtu);
            } else {
                BaseDfuImpl.this.logw("Changing MTU failed: " + status + " (mtu: " + mtu + ")");
                if (status == 4 && BaseDfuImpl.this.mCurrentMtu > 23 && BaseDfuImpl.this.mCurrentMtu - 3 > BaseDfuImpl.this.mBuffer.length) {
                    BaseDfuImpl.this.mBuffer = new byte[r3.mCurrentMtu - 3];
                    BaseDfuImpl.this.logi("MTU restored to: " + BaseDfuImpl.this.mCurrentMtu);
                }
            }
            BaseDfuImpl.this.mRequestCompleted = true;
            BaseDfuImpl.this.notifyLock();
        }

        protected String parse(final BluetoothGattCharacteristic characteristic) {
            return parse(characteristic.getValue());
        }

        protected String parse(final BluetoothGattDescriptor descriptor) {
            return parse(descriptor.getValue());
        }

        private String parse(final byte[] data) {
            int length;
            if (data == null || (length = data.length) == 0) {
                return "";
            }
            char[] cArr = new char[(length * 3) - 1];
            for (int i = 0; i < length; i++) {
                byte b = data[i];
                int i2 = i * 3;
                cArr[i2] = BaseDfuImpl.HEX_ARRAY[(b & 255) >>> 4];
                cArr[i2 + 1] = BaseDfuImpl.HEX_ARRAY[b & Ascii.f3756SI];
                if (i != length - 1) {
                    cArr[i2 + 2] = '-';
                }
            }
            return new String(cArr);
        }

        private String phyToString(final int phy) {
            if (phy == 1) {
                return "LE 1M";
            }
            if (phy == 2) {
                return "LE 2M";
            }
            if (phy == 3) {
                return "LE Coded";
            }
            return "UNKNOWN (" + phy + ")";
        }
    }

    BaseDfuImpl(final Intent intent, final DfuBaseService service) {
        this.mService = service;
        this.mProgressInfo = service.mProgressInfo;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void release() {
        this.mService = null;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        this.mPaused = true;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        this.mPaused = false;
        notifyLock();
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        this.mPaused = false;
        this.mAborted = true;
        notifyLock();
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public void onBondStateChanged(final int state) {
        this.mRequestCompleted = true;
        notifyLock();
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean initialize(final Intent intent, final BluetoothGatt gatt, final int fileType, final InputStream firmwareStream, final InputStream initPacketStream) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        int iAvailable;
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        this.mGatt = gatt;
        this.mFileType = fileType;
        this.mFirmwareStream = firmwareStream;
        this.mInitPacketStream = initPacketStream;
        int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PART_CURRENT, 1);
        int intExtra2 = intent.getIntExtra(DfuBaseService.EXTRA_PARTS_TOTAL, 1);
        this.mCurrentMtu = intent.getIntExtra(DfuBaseService.EXTRA_CURRENT_MTU, 23);
        if (fileType > 4) {
            logw("DFU target does not support (SD/BL)+App update, splitting into 2 parts");
            this.mService.sendLogBroadcast(15, "Sending system components");
            int i = this.mFileType & (-5);
            this.mFileType = i;
            ((ArchiveInputStream) this.mFirmwareStream).setContentType(i);
            intExtra2 = 2;
        }
        if (intExtra == 2) {
            this.mService.sendLogBroadcast(15, "Sending application");
        }
        int iAvailable2 = 0;
        if (initPacketStream != null) {
            try {
                if (initPacketStream.markSupported()) {
                    initPacketStream.reset();
                }
                iAvailable = initPacketStream.available();
            } catch (Exception unused) {
                iAvailable = 0;
            }
        } else {
            iAvailable = 0;
        }
        this.mInitPacketSizeInBytes = iAvailable;
        try {
            if (firmwareStream.markSupported()) {
                if (firmwareStream instanceof ArchiveInputStream) {
                    ((ArchiveInputStream) firmwareStream).fullReset();
                } else {
                    firmwareStream.reset();
                }
            }
            iAvailable2 = firmwareStream.available();
        } catch (Exception unused2) {
        }
        this.mImageSizeInBytes = iAvailable2;
        this.mProgressInfo.init(iAvailable2, intExtra, intExtra2);
        if (gatt.getDevice().getBondState() == 12 && (service = gatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID)) != null && (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) != null) {
            if (!isServiceChangedCCCDEnabled()) {
                enableCCCD(characteristic, 2);
            }
            logi("Service Changed indications enabled");
            this.mService.sendLogBroadcast(10, "Service Changed indications enabled");
        }
        return true;
    }

    void notifyLock() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    void waitIfPaused() {
        try {
            synchronized (this.mLock) {
                while (this.mPaused) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    void enableCCCD(final BluetoothGattCharacteristic characteristic, final int type) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGatt bluetoothGatt = this.mGatt;
        String str = type == 1 ? "notifications" : "indications";
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
        boolean z = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
        if (z) {
            return;
        }
        logi("Enabling " + str + "...");
        this.mService.sendLogBroadcast(1, "Enabling " + str + " for " + characteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.setCharacteristicNotification(" + characteristic.getUuid() + ", true)");
        bluetoothGatt.setCharacteristicNotification(characteristic, true);
        descriptor.setValue(type == 1 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        this.mService.sendLogBroadcast(0, "gatt.writeDescriptor(" + descriptor.getUuid() + (type == 1 ? ", value=0x01-00)" : ", value=0x02-00)"));
        bluetoothGatt.writeDescriptor(descriptor);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (!z) {
                        if (!this.mConnected || this.mError != 0) {
                        }
                        this.mLock.wait();
                        z = descriptor.getValue() == null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
                    }
                    if (!this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                    if (descriptor.getValue() == null) {
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to set " + str + " state", this.mError);
        }
    }

    private boolean isServiceChangedCCCDEnabled() throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        BluetoothGatt bluetoothGatt = this.mGatt;
        BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) == null || (descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG)) == null) {
            return false;
        }
        this.mRequestCompleted = false;
        this.mError = 0;
        logi("Reading Service Changed CCCD value...");
        this.mService.sendLogBroadcast(1, "Reading Service Changed CCCD value...");
        this.mService.sendLogBroadcast(0, "gatt.readDescriptor(" + descriptor.getUuid() + ")");
        bluetoothGatt.readDescriptor(descriptor);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
        }
        if (this.mError == 0) {
            return descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] == BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0] && descriptor.getValue()[1] == BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1];
        }
        throw new DfuException("Unable to read Service Changed CCCD", this.mError);
    }

    void writeOpCode(final BluetoothGattCharacteristic characteristic, final byte[] value, final boolean reset) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mRequestCompleted = false;
        this.mResetRequestSent = reset;
        characteristic.setWriteType(2);
        characteristic.setValue(value);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + characteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + characteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(characteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        boolean z = this.mResetRequestSent;
        if (!z && !this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Op Code " + ((int) value[0]) + ": device disconnected");
        }
        if (!z && this.mError != 0) {
            throw new DfuException("Unable to write Op Code " + ((int) value[0]), this.mError);
        }
    }

    boolean createBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Starting pairing...");
        this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond()");
        boolean zCreateBond = device.createBond();
        try {
            synchronized (this.mLock) {
                while (zCreateBond) {
                    if (this.mRequestCompleted || this.mAborted) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return zCreateBond;
    }

    private boolean createBondApi18(final BluetoothDevice device) {
        try {
            Method method = device.getClass().getMethod("createBond", new Class[0]);
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
            return ((Boolean) method.invoke(device, new Object[0])).booleanValue();
        } catch (Exception e) {
            LogInstrumentation.m2735w(TAG, "An exception occurred while creating bond", e);
            return false;
        }
    }

    boolean removeBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 10) {
            return true;
        }
        this.mService.sendLogBroadcast(1, "Removing bond information...");
        boolean zBooleanValue = false;
        try {
            Method method = device.getClass().getMethod("removeBond", new Class[0]);
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
            zBooleanValue = ((Boolean) method.invoke(device, new Object[0])).booleanValue();
            try {
                synchronized (this.mLock) {
                    while (!this.mRequestCompleted && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        } catch (Exception e2) {
            LogInstrumentation.m2735w(TAG, "An exception occurred while removing bond information", e2);
        }
        return zBooleanValue;
    }

    boolean isBonded() {
        return this.mGatt.getDevice().getBondState() == 12;
    }

    void requestMtu(final int mtu) throws UploadAbortedException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Requesting new MTU...");
        this.mService.sendLogBroadcast(0, "gatt.requestMtu(" + mtu + ")");
        if (this.mGatt.requestMtu(mtu)) {
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                            break;
                        } else {
                            this.mLock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
            if (!this.mConnected) {
                throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
            }
        }
    }

    byte[] readNotificationResponse() throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mReceivedData != null || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Op Code: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to write Op Code", this.mError);
        }
        return this.mReceivedData;
    }

    void restartService(final Intent intent, final boolean scanForBootloader) {
        String strSearchUsing;
        if (scanForBootloader) {
            long longExtra = intent.getLongExtra(DfuBaseService.EXTRA_SCAN_DELAY, 0L);
            long longExtra2 = intent.getLongExtra(DfuBaseService.EXTRA_SCAN_TIMEOUT, 5000L);
            this.mService.sendLogBroadcast(1, "Scanning for the DFU Bootloader... (timeout " + longExtra2 + " ms)");
            if (longExtra > 0) {
                this.mService.waitFor(longExtra);
            }
            strSearchUsing = BootloaderScannerFactory.getScanner(this.mGatt.getDevice().getAddress()).searchUsing(this.mService.getDeviceSelector(), longExtra2);
            logi("Scanning for new address finished with: " + strSearchUsing);
            if (strSearchUsing != null) {
                this.mService.sendLogBroadcast(5, "DFU Bootloader found with address " + strSearchUsing);
            } else {
                this.mService.sendLogBroadcast(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            strSearchUsing = null;
        }
        if (strSearchUsing != null) {
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, strSearchUsing);
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT", 0);
        this.mService.startService(intent);
    }

    protected String parse(final byte[] data) {
        int length;
        if (data == null || (length = data.length) == 0) {
            return "";
        }
        char[] cArr = new char[(length * 3) - 1];
        for (int i = 0; i < length; i++) {
            byte b = data[i];
            int i2 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f3756SI];
            if (i != length - 1) {
                cArr[i2 + 2] = '-';
            }
        }
        return new String(cArr);
    }

    void loge(final String message) {
        LogInstrumentation.m2728e(TAG, message);
    }

    void loge(final String message, final Throwable e) {
        LogInstrumentation.m2729e(TAG, message, e);
    }

    void logw(final String message) {
        if (DfuBaseService.DEBUG) {
            LogInstrumentation.m2734w(TAG, message);
        }
    }

    void logi(final String message) {
        if (DfuBaseService.DEBUG) {
            LogInstrumentation.m2730i(TAG, message);
        }
    }
}
