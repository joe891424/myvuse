package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import no.nordicsemi.android.dfu.BaseDfuImpl;

/* JADX INFO: loaded from: classes6.dex */
abstract class BaseButtonlessDfuImpl extends BaseDfuImpl {
    private final ButtonlessBluetoothCallback mBluetoothCallback;

    protected class ButtonlessBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        protected ButtonlessBluetoothCallback() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
            BaseButtonlessDfuImpl.this.mService.sendLogBroadcast(5, "Notification received from " + characteristic.getUuid() + ", value (0x): " + parse(characteristic));
            BaseButtonlessDfuImpl.this.mReceivedData = characteristic.getValue();
            BaseButtonlessDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
            BaseButtonlessDfuImpl.this.mRequestCompleted = true;
            BaseButtonlessDfuImpl.this.notifyLock();
        }
    }

    BaseButtonlessDfuImpl(final Intent intent, final DfuBaseService service) {
        super(intent, service);
        this.mBluetoothCallback = new ButtonlessBluetoothCallback();
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    void finalize(final Intent intent, final boolean forceRefresh, final boolean scanForBootloader) {
        this.mService.refreshDeviceCache(this.mGatt, forceRefresh || !intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false));
        this.mService.close(this.mGatt);
        logi("Restarting to bootloader mode");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, scanForBootloader);
    }
}
