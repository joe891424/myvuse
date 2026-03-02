package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes6.dex */
class LegacyDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static final UUID DEFAULT_DFU_VERSION_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET;
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE;
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE;
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET;
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU;
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1;
    private static final byte[] OP_CODE_VALIDATE;
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = uuid4;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        DFU_VERSION_UUID = uuid4;
        OP_CODE_START_DFU = new byte[]{1, 0};
        OP_CODE_START_DFU_V1 = new byte[]{1};
        OP_CODE_INIT_DFU_PARAMS = new byte[]{2};
        OP_CODE_INIT_DFU_PARAMS_START = new byte[]{2, 0};
        OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[]{2, 1};
        OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[]{3};
        OP_CODE_VALIDATE = new byte[]{4};
        OP_CODE_ACTIVATE_AND_RESET = new byte[]{5};
        OP_CODE_RESET = new byte[]{6};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{8, 0, 0};
    }

    protected class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected LegacyBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl.BaseCustomBluetoothCallback
        protected void onPacketCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                LegacyDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            if (characteristic.getIntValue(17, 0).intValue() == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(characteristic.getIntValue(20, 1).intValue());
                handlePacketReceiptNotification(gatt, characteristic);
            } else if (!LegacyDfuImpl.this.mRemoteErrorOccurred) {
                if (characteristic.getIntValue(17, 2).intValue() != 1) {
                    LegacyDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(gatt, characteristic);
            }
            LegacyDfuImpl.this.notifyLock();
        }
    }

    LegacyDfuImpl(final Intent intent, final DfuBaseService service) {
        super(intent, service);
        this.mBluetoothCallback = new LegacyBluetoothCallback();
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(final Intent intent, final BluetoothGatt gatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = gatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        return characteristic2 != null;
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(6:177|43|44|172|45|46)|(4:48|175|49|50)(12:53|(5:56|57|183|58|59)|84|107|(5:109|110|(1:112)(1:113)|114|(1:116)(2:117|118))|(1:126)(1:125)|(1:128)|129|179|130|131|(2:133|(4:135|(1:137)(1:138)|139|190)(2:140|141))(2:142|143))|69|70|181|71|174|(1:(2:87|88)(4:76|77|78|(2:80|81)(12:82|(2:85|86)|84|107|(0)|(4:120|122|124|126)(0)|(0)|129|179|130|131|(0)(0))))(2:89|90)|95|171|96|(1:149)(2:100|(2:102|103)(2:104|(10:106|107|(0)|(0)(0)|(0)|129|179|130|131|(0)(0))(2:147|148)))) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:177|43|44|172|45|46|(4:48|175|49|50)(12:53|(5:56|57|183|58|59)|84|107|(5:109|110|(1:112)(1:113)|114|(1:116)(2:117|118))|(1:126)(1:125)|(1:128)|129|179|130|131|(2:133|(4:135|(1:137)(1:138)|139|190)(2:140|141))(2:142|143))|69|70|181|71|174|(1:(2:87|88)(4:76|77|78|(2:80|81)(12:82|(2:85|86)|84|107|(0)|(4:120|122|124|126)(0)|(0)|129|179|130|131|(0)(0))))(2:89|90)|95|171|96|(1:149)(2:100|(2:102|103)(2:104|(10:106|107|(0)|(0)(0)|(0)|129|179|130|131|(0)(0))(2:147|148)))) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x033e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0340, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0341, code lost:
    
        r27 = "Firmware image size sent (";
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03f5 A[Catch: UnknownResponseException -> 0x0234, UploadAbortedException -> 0x0237, RemoteDfuException -> 0x0694, TRY_LEAVE, TryCatch #0 {RemoteDfuException -> 0x0694, blocks: (B:107:0x03f1, B:109:0x03f5, B:112:0x0402, B:114:0x046c, B:117:0x049c, B:118:0x04a3, B:113:0x0442, B:120:0x04a6, B:122:0x04aa, B:128:0x04b8, B:129:0x04f4, B:130:0x0513, B:131:0x0526, B:133:0x0588, B:135:0x0640, B:139:0x066f, B:140:0x0674, B:141:0x067b, B:142:0x067c, B:143:0x0683, B:145:0x0685, B:146:0x068b, B:126:0x04b4, B:96:0x0344, B:100:0x034e, B:102:0x03e9, B:147:0x068c, B:148:0x0691, B:149:0x0692, B:150:0x0693), top: B:171:0x0344 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04a6 A[Catch: UnknownResponseException -> 0x0234, UploadAbortedException -> 0x0237, RemoteDfuException -> 0x0694, TryCatch #0 {RemoteDfuException -> 0x0694, blocks: (B:107:0x03f1, B:109:0x03f5, B:112:0x0402, B:114:0x046c, B:117:0x049c, B:118:0x04a3, B:113:0x0442, B:120:0x04a6, B:122:0x04aa, B:128:0x04b8, B:129:0x04f4, B:130:0x0513, B:131:0x0526, B:133:0x0588, B:135:0x0640, B:139:0x066f, B:140:0x0674, B:141:0x067b, B:142:0x067c, B:143:0x0683, B:145:0x0685, B:146:0x068b, B:126:0x04b4, B:96:0x0344, B:100:0x034e, B:102:0x03e9, B:147:0x068c, B:148:0x0691, B:149:0x0692, B:150:0x0693), top: B:171:0x0344 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04b4 A[Catch: UnknownResponseException -> 0x0234, UploadAbortedException -> 0x0237, RemoteDfuException -> 0x0694, TryCatch #0 {RemoteDfuException -> 0x0694, blocks: (B:107:0x03f1, B:109:0x03f5, B:112:0x0402, B:114:0x046c, B:117:0x049c, B:118:0x04a3, B:113:0x0442, B:120:0x04a6, B:122:0x04aa, B:128:0x04b8, B:129:0x04f4, B:130:0x0513, B:131:0x0526, B:133:0x0588, B:135:0x0640, B:139:0x066f, B:140:0x0674, B:141:0x067b, B:142:0x067c, B:143:0x0683, B:145:0x0685, B:146:0x068b, B:126:0x04b4, B:96:0x0344, B:100:0x034e, B:102:0x03e9, B:147:0x068c, B:148:0x0691, B:149:0x0692, B:150:0x0693), top: B:171:0x0344 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04b8 A[Catch: UnknownResponseException -> 0x0234, UploadAbortedException -> 0x0237, RemoteDfuException -> 0x0694, TryCatch #0 {RemoteDfuException -> 0x0694, blocks: (B:107:0x03f1, B:109:0x03f5, B:112:0x0402, B:114:0x046c, B:117:0x049c, B:118:0x04a3, B:113:0x0442, B:120:0x04a6, B:122:0x04aa, B:128:0x04b8, B:129:0x04f4, B:130:0x0513, B:131:0x0526, B:133:0x0588, B:135:0x0640, B:139:0x066f, B:140:0x0674, B:141:0x067b, B:142:0x067c, B:143:0x0683, B:145:0x0685, B:146:0x068b, B:126:0x04b4, B:96:0x0344, B:100:0x034e, B:102:0x03e9, B:147:0x068c, B:148:0x0691, B:149:0x0692, B:150:0x0693), top: B:171:0x0344 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0588 A[Catch: UnknownResponseException -> 0x0234, UploadAbortedException -> 0x0237, RemoteDfuException -> 0x0694, TryCatch #0 {RemoteDfuException -> 0x0694, blocks: (B:107:0x03f1, B:109:0x03f5, B:112:0x0402, B:114:0x046c, B:117:0x049c, B:118:0x04a3, B:113:0x0442, B:120:0x04a6, B:122:0x04aa, B:128:0x04b8, B:129:0x04f4, B:130:0x0513, B:131:0x0526, B:133:0x0588, B:135:0x0640, B:139:0x066f, B:140:0x0674, B:141:0x067b, B:142:0x067c, B:143:0x0683, B:145:0x0685, B:146:0x068b, B:126:0x04b4, B:96:0x0344, B:100:0x034e, B:102:0x03e9, B:147:0x068c, B:148:0x0691, B:149:0x0692, B:150:0x0693), top: B:171:0x0344 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x067c A[Catch: UnknownResponseException -> 0x0234, UploadAbortedException -> 0x0237, RemoteDfuException -> 0x0694, TryCatch #0 {RemoteDfuException -> 0x0694, blocks: (B:107:0x03f1, B:109:0x03f5, B:112:0x0402, B:114:0x046c, B:117:0x049c, B:118:0x04a3, B:113:0x0442, B:120:0x04a6, B:122:0x04aa, B:128:0x04b8, B:129:0x04f4, B:130:0x0513, B:131:0x0526, B:133:0x0588, B:135:0x0640, B:139:0x066f, B:140:0x0674, B:141:0x067b, B:142:0x067c, B:143:0x0683, B:145:0x0685, B:146:0x068b, B:126:0x04b4, B:96:0x0344, B:100:0x034e, B:102:0x03e9, B:147:0x068c, B:148:0x0691, B:149:0x0692, B:150:0x0693), top: B:171:0x0344 }] */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void performDfu(final android.content.Intent r37) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            Method dump skipped, instruction units count: 1880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.performDfu(android.content.Intent):void");
    }

    private void setNumberOfPackets(final byte[] data, final int value) {
        data[1] = (byte) (value & 255);
        data[2] = (byte) ((value >> 8) & 255);
    }

    private int getStatusCode(final byte[] response, final int request) throws UnknownResponseException {
        byte b;
        if (response == null || response.length != 3 || response[0] != 16 || response[1] != request || (b = response[2]) < 1 || b > 6) {
            throw new UnknownResponseException("Invalid response received", response, 16, request);
        }
        return b;
    }

    private int readVersion(final BluetoothGattCharacteristic characteristic) {
        if (characteristic != null) {
            return characteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void writeOpCode(final BluetoothGattCharacteristic characteristic, final byte[] value) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        byte b = value[0];
        writeOpCode(characteristic, value, b == 6 || b == 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeImageSize(final android.bluetooth.BluetoothGattCharacteristic r5, final int r6) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            r4 = this;
            r0 = 0
            r4.mReceivedData = r0
            r0 = 0
            r4.mError = r0
            r1 = 1
            r4.mImageSizeInProgress = r1
            r5.setWriteType(r1)
            r2 = 4
            byte[] r2 = new byte[r2]
            r5.setValue(r2)
            r2 = 20
            r5.setValue(r6, r2, r0)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Writing to characteristic "
            r2.<init>(r3)
            java.util.UUID r3 = r5.getUuid()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.sendLogBroadcast(r1, r2)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.mService
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "gatt.writeCharacteristic("
            r1.<init>(r2)
            java.util.UUID r2 = r5.getUuid()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ")"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.sendLogBroadcast(r0, r1)
            android.bluetooth.BluetoothGatt r6 = r4.mGatt
            r6.writeCharacteristic(r5)
            java.lang.Object r5 = r4.mLock     // Catch: java.lang.InterruptedException -> L74
            monitor-enter(r5)     // Catch: java.lang.InterruptedException -> L74
        L55:
            boolean r6 = r4.mImageSizeInProgress     // Catch: java.lang.Throwable -> L71
            if (r6 == 0) goto L65
            boolean r6 = r4.mConnected     // Catch: java.lang.Throwable -> L71
            if (r6 == 0) goto L65
            int r6 = r4.mError     // Catch: java.lang.Throwable -> L71
            if (r6 != 0) goto L65
            boolean r6 = r4.mAborted     // Catch: java.lang.Throwable -> L71
            if (r6 == 0) goto L69
        L65:
            boolean r6 = r4.mPaused     // Catch: java.lang.Throwable -> L71
            if (r6 == 0) goto L6f
        L69:
            java.lang.Object r6 = r4.mLock     // Catch: java.lang.Throwable -> L71
            r6.wait()     // Catch: java.lang.Throwable -> L71
            goto L55
        L6f:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L71
            goto L7a
        L71:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L71
            throw r6     // Catch: java.lang.InterruptedException -> L74
        L74:
            r5 = move-exception
            java.lang.String r6 = "Sleeping interrupted"
            r4.loge(r6, r5)
        L7a:
            boolean r5 = r4.mAborted
            if (r5 != 0) goto L99
            boolean r5 = r4.mConnected
            if (r5 == 0) goto L91
            int r5 = r4.mError
            if (r5 != 0) goto L87
            return
        L87:
            no.nordicsemi.android.dfu.internal.exception.DfuException r5 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r6 = "Unable to write Image Size"
            int r0 = r4.mError
            r5.<init>(r6, r0)
            throw r5
        L91:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r6 = "Unable to write Image Size: device disconnected"
            r5.<init>(r6)
            throw r5
        L99:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.writeImageSize(android.bluetooth.BluetoothGattCharacteristic, int):void");
    }

    private void writeImageSize(final BluetoothGattCharacteristic characteristic, final int softDeviceImageSize, final int bootloaderImageSize, final int appImageSize) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        characteristic.setWriteType(1);
        characteristic.setValue(new byte[12]);
        characteristic.setValue(softDeviceImageSize, 20, 0);
        characteristic.setValue(bootloaderImageSize, 20, 4);
        characteristic.setValue(appImageSize, 20, 8);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + characteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + characteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(characteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to write Image Sizes", this.mError);
        }
    }

    private void resetAndRestart(final BluetoothGatt gatt, final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = gatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(gatt, !((service == null || service.getCharacteristic(SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(gatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }
}
