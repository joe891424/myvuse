package com.microblink.entities.recognizers.blinkid.imageoptions.dpi;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class DpiOptionsUtils {
    public static void checkDpiRange(int i) {
        if (i < 100 || i > 400) {
            throw new IllegalArgumentException("DPI value must be in range [100, 400], you are trying to set DPI to: " + i + ".");
        }
    }
}
