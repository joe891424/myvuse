package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes6.dex */
interface DfuService extends DfuCallback {
    boolean initialize(final Intent intent, final BluetoothGatt gatt, final int fileType, final InputStream firmwareStream, final InputStream initPacketStream) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    boolean isClientCompatible(final Intent intent, final BluetoothGatt gatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    void performDfu(final Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException;

    void release();
}
