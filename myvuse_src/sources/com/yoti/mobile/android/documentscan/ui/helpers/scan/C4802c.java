package com.yoti.mobile.android.documentscan.ui.helpers.scan;

import com.facebook.imagepipeline.common.RotationOptions;
import com.microblink.hardware.orientation.Orientation;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.helpers.scan.c */
/* JADX INFO: loaded from: classes5.dex */
public final class C4802c {
    /* JADX INFO: renamed from: a */
    public final int m5007a(Orientation orientation) {
        if (orientation != null) {
            int i = C4801b.$EnumSwitchMapping$0[orientation.ordinal()];
            if (i == 1) {
                return RotationOptions.ROTATE_180;
            }
            if (i == 2) {
                return 90;
            }
            if (i == 3) {
                return RotationOptions.ROTATE_270;
            }
        }
        return 0;
    }
}
