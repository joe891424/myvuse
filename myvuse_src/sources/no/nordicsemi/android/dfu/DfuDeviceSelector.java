package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes6.dex */
public interface DfuDeviceSelector {
    boolean matches(final BluetoothDevice device, final int rssi, final byte[] scanRecord, final String originalAddress, final String incrementedAddress);
}
