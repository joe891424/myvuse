package de.patwoz.p097rn.bluetoothstatemanager;

import de.patwoz.p097rn.bluetoothstatemanager.Constants;

/* JADX INFO: loaded from: classes4.dex */
public final class BridgeUtils {
    public static String fromBluetoothState(int i) {
        switch (i) {
            case 10:
                return Constants.BluetoothState.POWERED_OFF;
            case 11:
            case 13:
                return Constants.BluetoothState.RESETTING;
            case 12:
                return Constants.BluetoothState.POWERED_ON;
            default:
                return "Unknown";
        }
    }
}
