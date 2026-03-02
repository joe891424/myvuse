package com.google.android.gms.internal.mlkit_vision_common;

import com.bat.sdk.domain.device.FirmwareInstallationState;
import java.io.PrintStream;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzy {
    static final zzs zza;

    static {
        zzs zzwVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e.printStackTrace(System.err);
            }
            zzwVar = (num == null || num.intValue() < 19) ? !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new zzv() : new zzw() : new zzx();
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zzw.class.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + FirmwareInstallationState.Error.ERROR_BLE_LINK_LOSS_GATT);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            zzwVar = new zzw();
        }
        zza = zzwVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void zza(Throwable th, Throwable th2) {
        zza.zza(th, th2);
    }
}
