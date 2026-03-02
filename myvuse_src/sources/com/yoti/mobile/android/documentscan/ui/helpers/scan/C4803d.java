package com.yoti.mobile.android.documentscan.ui.helpers.scan;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.helpers.scan.d */
/* JADX INFO: loaded from: classes5.dex */
public final class C4803d {

    /* JADX INFO: renamed from: a */
    private final RectF f7114a = new RectF();

    /* JADX INFO: renamed from: b */
    private boolean f7115b;

    /* JADX INFO: renamed from: a */
    public final RectF m5008a(int i, int i2) {
        RectF rectF = this.f7114a;
        float f = i;
        float f2 = i2;
        return new RectF(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    /* JADX INFO: renamed from: a */
    public final void m5009a(int i, int i2, RectF cameraVisibleWindow, RectF screenDocumentRect, int i3) {
        Intrinsics.checkParameterIsNotNull(cameraVisibleWindow, "cameraVisibleWindow");
        Intrinsics.checkParameterIsNotNull(screenDocumentRect, "screenDocumentRect");
        boolean z = i3 == 90 || i3 == 270;
        this.f7115b = z;
        if (z) {
            cameraVisibleWindow.set(cameraVisibleWindow.top, cameraVisibleWindow.left, cameraVisibleWindow.bottom, cameraVisibleWindow.right);
        }
        float f = i2;
        float fHeight = (screenDocumentRect.top / f) * cameraVisibleWindow.height();
        float f2 = i;
        float fWidth = (screenDocumentRect.left / f2) * cameraVisibleWindow.width();
        float fHeight2 = (screenDocumentRect.bottom / f) * cameraVisibleWindow.height();
        float fWidth2 = (screenDocumentRect.right / f2) * cameraVisibleWindow.width();
        RectF rectF = this.f7114a;
        float f3 = cameraVisibleWindow.left;
        float f4 = cameraVisibleWindow.top;
        rectF.set(fWidth + f3, fHeight + f4, fWidth2 + f3, fHeight2 + f4);
    }
}
