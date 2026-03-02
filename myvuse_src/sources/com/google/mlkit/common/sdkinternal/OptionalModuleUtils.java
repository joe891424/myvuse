package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class OptionalModuleUtils {
    public static final String BARCODE = "barcode";
    public static final String FACE = "face";
    public static final String ICA = "ica";
    public static final String OCR = "ocr";

    private OptionalModuleUtils() {
    }

    public static void requestDownload(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str);
        context.sendBroadcast(intent);
    }
}
