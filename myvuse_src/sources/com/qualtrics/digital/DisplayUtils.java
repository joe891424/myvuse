package com.qualtrics.digital;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes6.dex */
class DisplayUtils {
    DisplayUtils() {
    }

    static int convertDpToPixel(float f, Resources resources) {
        return (int) (f * (resources.getDisplayMetrics().densityDpi / 160.0f));
    }
}
