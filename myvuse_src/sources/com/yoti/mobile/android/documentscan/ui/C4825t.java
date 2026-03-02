package com.yoti.mobile.android.documentscan.ui;

import com.microblink.hardware.orientation.Orientation;
import com.microblink.view.OrientationAllowedListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.t */
/* JADX INFO: loaded from: classes5.dex */
final class C4825t implements OrientationAllowedListener {

    /* JADX INFO: renamed from: a */
    public static final C4825t f7161a = new C4825t();

    C4825t() {
    }

    @Override // com.microblink.view.OrientationAllowedListener
    public final boolean isOrientationAllowed(Orientation orientation) {
        Intrinsics.checkParameterIsNotNull(orientation, "orientation");
        return orientation == Orientation.ORIENTATION_PORTRAIT;
    }
}
