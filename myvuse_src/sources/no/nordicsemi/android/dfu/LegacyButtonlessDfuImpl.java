package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import com.bat.sdk.domain.device.FirmwareInstallationState;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes6.dex */
class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;
    static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};

    LegacyButtonlessDfuImpl(final Intent intent, final DfuBaseService service) {
        super(intent, service);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(final Intent intent, final BluetoothGatt gatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGattCharacteristic characteristic;
        int version;
        BluetoothGattService service = gatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            version = readVersion(gatt, characteristic2);
            this.mVersion = version;
            int i = version & 15;
            int i2 = version >> 8;
            logi("Version number read: " + i2 + "." + i + " -> " + getVersionFeatures(version));
            this.mService.sendLogBroadcast(10, "Version number read: " + i2 + "." + i);
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            version = 0;
        }
        boolean booleanExtra = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra(DfuBaseService.EXTRA_FORCE_DFU)) {
            booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_DFU, false);
        }
        boolean z = gatt.getServices().size() > 3;
        if (version == 0 && z) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        return version == 1 || (!booleanExtra && version == 0 && z);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logw("Application with legacy buttonless update found");
        LogInstrumentation.m2730i("LegacyButtonlessDfu", "performing LegacyButtonlessDfu");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        boolean z = true;
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU)) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, FirmwareInstallationState.Error.ERROR_PREVALIDATION);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        BluetoothGatt bluetoothGatt = this.mGatt;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU, false);
        if (booleanExtra || this.mVersion == 0) {
            this.mService.disconnect(bluetoothGatt);
        } else {
            this.mService.waitUntilDisconnected();
            LogInstrumentation.m2730i("LegacyButtonlessDfu", "Device successfully disconnected");
            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        }
        logi("Device disconnected");
        if (!booleanExtra && this.mVersion != 0) {
            z = false;
        }
        finalize(intent, false, z);
    }

    private int readVersion(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (characteristic == null) {
            return 0;
        }
        this.mReceivedData = null;
        this.mError = 0;
        logi("Reading DFU version number...");
        this.mService.sendLogBroadcast(1, "Reading DFU version number...");
        characteristic.setValue((byte[]) null);
        this.mService.sendLogBroadcast(0, "gatt.readCharacteristic(" + characteristic.getUuid() + ")");
        gatt.readCharacteristic(characteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (((this.mRequestCompleted && characteristic.getValue() != null) || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mRequestCompleted = false;
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to read version number", this.mError);
        }
        if (characteristic.getValue() == null || characteristic.getValue().length < 2) {
            return 0;
        }
        return characteristic.getIntValue(18, 0).intValue();
    }

    private String getVersionFeatures(final int version) {
        if (version == 0) {
            return "Bootloader from SDK 6.1 or older";
        }
        if (version == 1) {
            return "Application with Legacy buttonless update from SDK 7.0 or newer";
        }
        if (version == 5) {
            return "Bootloader from SDK 7.0 or newer. No bond sharing";
        }
        if (version == 6) {
            return "Bootloader from SDK 8.0 or newer. Bond sharing supported";
        }
        if (version == 7) {
            return "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet";
        }
        if (version == 8) {
            return "Bootloader from SDK 9.0 or newer. Signature supported";
        }
        return "Unknown version";
    }
}
