package com.google.mlkit.common;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class MlKit {
    private MlKit() {
    }

    public static void initialize(Context context) {
        MlKitContext.zza(context);
    }
}
