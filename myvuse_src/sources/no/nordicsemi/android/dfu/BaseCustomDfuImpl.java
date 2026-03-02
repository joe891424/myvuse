package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes6.dex */
abstract class BaseCustomDfuImpl extends BaseDfuImpl {
    boolean mFirmwareUploadInProgress;
    private boolean mInitPacketInProgress;
    int mPacketsBeforeNotification;
    private int mPacketsSentSinceNotification;
    boolean mRemoteErrorOccurred;

    protected abstract UUID getControlPointCharacteristicUUID();

    protected abstract UUID getDfuServiceUUID();

    protected abstract UUID getPacketCharacteristicUUID();

    static /* synthetic */ int access$108(BaseCustomDfuImpl baseCustomDfuImpl) {
        int i = baseCustomDfuImpl.mPacketsSentSinceNotification;
        baseCustomDfuImpl.mPacketsSentSinceNotification = i + 1;
        return i;
    }

    class BaseCustomBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        protected void onPacketCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
        }

        BaseCustomBluetoothCallback() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
            if (status == 0) {
                if (characteristic.getUuid().equals(BaseCustomDfuImpl.this.getPacketCharacteristicUUID())) {
                    if (BaseCustomDfuImpl.this.mInitPacketInProgress) {
                        BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
                        BaseCustomDfuImpl.this.mInitPacketInProgress = false;
                    } else if (BaseCustomDfuImpl.this.mFirmwareUploadInProgress) {
                        BaseCustomDfuImpl.this.mProgressInfo.addBytesSent(characteristic.getValue().length);
                        BaseCustomDfuImpl.access$108(BaseCustomDfuImpl.this);
                        boolean z = BaseCustomDfuImpl.this.mPacketsBeforeNotification > 0 && BaseCustomDfuImpl.this.mPacketsSentSinceNotification >= BaseCustomDfuImpl.this.mPacketsBeforeNotification;
                        boolean zIsComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                        boolean zIsObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                        if (z) {
                            return;
                        }
                        if (zIsComplete || zIsObjectComplete) {
                            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                            BaseCustomDfuImpl.this.notifyLock();
                            return;
                        }
                        try {
                            BaseCustomDfuImpl.this.waitIfPaused();
                            if (!BaseCustomDfuImpl.this.mAborted && BaseCustomDfuImpl.this.mError == 0 && !BaseCustomDfuImpl.this.mRemoteErrorOccurred && !BaseCustomDfuImpl.this.mResetRequestSent) {
                                int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                                byte[] bArr = BaseCustomDfuImpl.this.mBuffer;
                                if (availableObjectSizeIsBytes < bArr.length) {
                                    bArr = new byte[availableObjectSizeIsBytes];
                                }
                                BaseCustomDfuImpl.this.writePacket(gatt, characteristic, bArr, BaseCustomDfuImpl.this.mFirmwareStream.read(bArr));
                                return;
                            }
                            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                            BaseCustomDfuImpl.this.mService.sendLogBroadcast(15, "Upload terminated");
                            BaseCustomDfuImpl.this.notifyLock();
                            return;
                        } catch (HexFileValidationException unused) {
                            BaseCustomDfuImpl.this.loge("Invalid HEX file");
                            BaseCustomDfuImpl.this.mError = 4099;
                        } catch (IOException e) {
                            BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                            BaseCustomDfuImpl.this.mError = 4100;
                        }
                    } else {
                        onPacketCharacteristicWrite(gatt, characteristic, status);
                    }
                } else {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
                    BaseCustomDfuImpl.this.mRequestCompleted = true;
                }
            } else if (BaseCustomDfuImpl.this.mResetRequestSent) {
                BaseCustomDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseCustomDfuImpl.this.loge("Characteristic write error: " + status);
                BaseCustomDfuImpl.this.mError = status | 16384;
            }
            BaseCustomDfuImpl.this.notifyLock();
        }

        void handlePacketReceiptNotification(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            if (!BaseCustomDfuImpl.this.mFirmwareUploadInProgress) {
                handleNotification(gatt, characteristic);
                return;
            }
            BluetoothGattCharacteristic characteristic2 = gatt.getService(BaseCustomDfuImpl.this.getDfuServiceUUID()).getCharacteristic(BaseCustomDfuImpl.this.getPacketCharacteristicUUID());
            try {
                BaseCustomDfuImpl.this.mPacketsSentSinceNotification = 0;
                BaseCustomDfuImpl.this.waitIfPaused();
                if (!BaseCustomDfuImpl.this.mAborted && BaseCustomDfuImpl.this.mError == 0 && !BaseCustomDfuImpl.this.mRemoteErrorOccurred && !BaseCustomDfuImpl.this.mResetRequestSent) {
                    boolean zIsComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                    boolean zIsObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (!zIsComplete && !zIsObjectComplete) {
                        int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                        byte[] bArr = BaseCustomDfuImpl.this.mBuffer;
                        if (availableObjectSizeIsBytes < bArr.length) {
                            bArr = new byte[availableObjectSizeIsBytes];
                        }
                        BaseCustomDfuImpl.this.writePacket(gatt, characteristic2, bArr, BaseCustomDfuImpl.this.mFirmwareStream.read(bArr));
                        return;
                    }
                    BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                    BaseCustomDfuImpl.this.notifyLock();
                    return;
                }
                BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                BaseCustomDfuImpl.this.mService.sendLogBroadcast(15, "Upload terminated");
            } catch (HexFileValidationException unused) {
                BaseCustomDfuImpl.this.loge("Invalid HEX file");
                BaseCustomDfuImpl.this.mError = 4099;
            } catch (IOException e) {
                BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                BaseCustomDfuImpl.this.mError = 4100;
            }
        }

        void handleNotification(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Notification received from " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
            BaseCustomDfuImpl.this.mReceivedData = characteristic.getValue();
            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
        }
    }

    BaseCustomDfuImpl(final Intent intent, final DfuBaseService service) {
        super(intent, service);
        int i = 12;
        if (intent.hasExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED)) {
            boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, false);
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, 12);
            if (intExtra >= 0 && intExtra <= 65535) {
                i = intExtra;
            }
            this.mPacketsBeforeNotification = booleanExtra ? i : 0;
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(service);
        boolean z = defaultSharedPreferences.getBoolean(DfuSettingsConstants.SETTINGS_PACKET_RECEIPT_NOTIFICATION_ENABLED, false);
        try {
            int i2 = Integer.parseInt(defaultSharedPreferences.getString(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS, String.valueOf(12)));
            if (i2 >= 0 && i2 <= 65535) {
                i = i2;
            }
        } catch (NumberFormatException unused) {
        }
        this.mPacketsBeforeNotification = z ? i : 0;
    }

    void writeInitData(final BluetoothGattCharacteristic characteristic, final CRC32 crc32) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        try {
            byte[] bArr = this.mBuffer;
            while (true) {
                int i = this.mInitPacketStream.read(bArr, 0, bArr.length);
                if (i == -1) {
                    return;
                }
                writeInitPacket(characteristic, bArr, i);
                if (crc32 != null) {
                    crc32.update(bArr, 0, i);
                }
            }
        } catch (IOException e) {
            loge("Error while reading Init packet file", e);
            throw new DfuException("Error while reading Init packet file", 4098);
        }
    }

    private void writeInitPacket(final BluetoothGattCharacteristic characteristic, final byte[] buffer, final int size) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (buffer.length != size) {
            byte[] bArr = new byte[size];
            System.arraycopy(buffer, 0, bArr, 0, size);
            buffer = bArr;
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mInitPacketInProgress = true;
        characteristic.setWriteType(1);
        characteristic.setValue(buffer);
        logi("Sending init packet (Value = " + parse(buffer) + ")");
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + characteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + characteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(characteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mInitPacketInProgress || !this.mConnected || this.mError != 0) && !this.mPaused) {
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
            throw new DeviceDisconnectedException("Unable to write Init DFU Parameters: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to write Init DFU Parameters", this.mError);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void uploadFirmwareImage(final android.bluetooth.BluetoothGattCharacteristic r7) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            r6 = this;
            java.lang.String r0 = "Sending firmware to characteristic "
            boolean r1 = r6.mAborted
            if (r1 != 0) goto L9c
            r1 = 0
            r6.mReceivedData = r1
            r1 = 0
            r6.mError = r1
            r2 = 1
            r6.mFirmwareUploadInProgress = r2
            r6.mPacketsSentSinceNotification = r1
            no.nordicsemi.android.dfu.DfuProgressInfo r1 = r6.mProgressInfo     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            int r1 = r1.getAvailableObjectSizeIsBytes()     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            byte[] r3 = r6.mBuffer     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            int r4 = r3.length     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            if (r1 >= r4) goto L1e
            byte[] r3 = new byte[r1]     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
        L1e:
            java.io.InputStream r1 = r6.mFirmwareStream     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            int r1 = r1.read(r3)     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            no.nordicsemi.android.dfu.DfuBaseService r4 = r6.mService     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            r5.<init>(r0)     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            java.util.UUID r0 = r7.getUuid()     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            java.lang.String r5 = "..."
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            r4.sendLogBroadcast(r2, r0)     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            android.bluetooth.BluetoothGatt r0 = r6.mGatt     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            r6.writePacket(r0, r7, r3, r1)     // Catch: java.io.IOException -> L88 no.nordicsemi.android.dfu.internal.exception.HexFileValidationException -> L92
            java.lang.Object r7 = r6.mLock     // Catch: java.lang.InterruptedException -> L67
            monitor-enter(r7)     // Catch: java.lang.InterruptedException -> L67
        L48:
            boolean r0 = r6.mFirmwareUploadInProgress     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L58
            byte[] r0 = r6.mReceivedData     // Catch: java.lang.Throwable -> L64
            if (r0 != 0) goto L58
            boolean r0 = r6.mConnected     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L58
            int r0 = r6.mError     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L5c
        L58:
            boolean r0 = r6.mPaused     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L62
        L5c:
            java.lang.Object r0 = r6.mLock     // Catch: java.lang.Throwable -> L64
            r0.wait()     // Catch: java.lang.Throwable -> L64
            goto L48
        L62:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L64
            goto L6d
        L64:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L64
            throw r0     // Catch: java.lang.InterruptedException -> L67
        L67:
            r7 = move-exception
            java.lang.String r0 = "Sleeping interrupted"
            r6.loge(r0, r7)
        L6d:
            boolean r7 = r6.mConnected
            if (r7 == 0) goto L80
            int r7 = r6.mError
            if (r7 != 0) goto L76
            return
        L76:
            no.nordicsemi.android.dfu.internal.exception.DfuException r7 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r0 = "Uploading Firmware Image failed"
            int r1 = r6.mError
            r7.<init>(r0, r1)
            throw r7
        L80:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r7 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r0 = "Uploading Firmware Image failed: device disconnected"
            r7.<init>(r0)
            throw r7
        L88:
            no.nordicsemi.android.dfu.internal.exception.DfuException r7 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r0 = "Error while reading file"
            r1 = 4100(0x1004, float:5.745E-42)
            r7.<init>(r0, r1)
            throw r7
        L92:
            no.nordicsemi.android.dfu.internal.exception.DfuException r7 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r0 = "HEX file not valid"
            r1 = 4099(0x1003, float:5.744E-42)
            r7.<init>(r0, r1)
            throw r7
        L9c:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r7 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseCustomDfuImpl.uploadFirmwareImage(android.bluetooth.BluetoothGattCharacteristic):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePacket(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final byte[] buffer, final int size) {
        if (size <= 0) {
            return;
        }
        if (buffer.length != size) {
            byte[] bArr = new byte[size];
            System.arraycopy(buffer, 0, bArr, 0, size);
            buffer = bArr;
        }
        characteristic.setWriteType(1);
        characteristic.setValue(buffer);
        gatt.writeCharacteristic(characteristic);
    }

    void finalize(final Intent intent, final boolean forceRefresh) {
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        this.mService.refreshDeviceCache(this.mGatt, forceRefresh || !booleanExtra);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra(DfuBaseService.EXTRA_RESTORE_BOND, false);
            if (booleanExtra2 || !booleanExtra) {
                removeBond();
                this.mService.waitFor(FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS);
            }
            if (booleanExtra2 && (this.mFileType & 4) > 0 && !createBond()) {
                logw("Creating bond failed");
            }
        }
        if (this.mProgressInfo.isLastPart()) {
            this.mProgressInfo.setProgress(-6);
            return;
        }
        logi("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, DfuBaseService.MIME_TYPE_ZIP);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_TYPE, 4);
        intent2.putExtra(DfuBaseService.EXTRA_PART_CURRENT, this.mProgressInfo.getCurrentPart() + 1);
        intent2.putExtra(DfuBaseService.EXTRA_PARTS_TOTAL, this.mProgressInfo.getTotalParts());
        restartService(intent2, true);
    }
}
