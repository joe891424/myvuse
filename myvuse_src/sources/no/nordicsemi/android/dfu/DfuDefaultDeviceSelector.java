package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes6.dex */
class DfuDefaultDeviceSelector implements DfuDeviceSelector {
    DfuDefaultDeviceSelector() {
    }

    @Override // no.nordicsemi.android.dfu.DfuDeviceSelector
    public boolean matches(final BluetoothDevice device, final int rssi, final byte[] scanRecord, final String originalAddress, final String incrementedAddress) {
        return originalAddress.equals(device.getAddress()) || incrementedAddress.equals(device.getAddress());
    }
}
