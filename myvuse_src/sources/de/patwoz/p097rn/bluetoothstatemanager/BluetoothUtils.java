package de.patwoz.p097rn.bluetoothstatemanager;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes4.dex */
public final class BluetoothUtils {
    public static boolean isBluetoothSupported() {
        return BluetoothAdapter.getDefaultAdapter() != null;
    }

    public static boolean hasBluetoothAdminPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.BLUETOOTH_ADMIN") == 0;
    }
}
