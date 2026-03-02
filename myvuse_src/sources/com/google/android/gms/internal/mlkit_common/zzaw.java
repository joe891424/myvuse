package com.google.android.gms.internal.mlkit_common;

import com.bat.sdk.domain.device.FirmwareInstallationState;
import java.io.PrintStream;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaw {
    static final zzaq zza;

    static {
        zzaq zzauVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(System.err);
            }
            zzauVar = (num == null || num.intValue() < 19) ? !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new zzat() : new zzau() : new zzav();
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zzau.class.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + FirmwareInstallationState.Error.ERROR_BLE_LINK_LOSS_GATT);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            zzauVar = new zzau();
        }
        zza = zzauVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void zza(Throwable th, Throwable th2) {
        zza.zza(th, th2);
    }
}
