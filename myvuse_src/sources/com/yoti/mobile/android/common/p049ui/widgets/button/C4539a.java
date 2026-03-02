package com.yoti.mobile.android.common.p049ui.widgets.button;

import android.content.Context;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.button.a */
/* JADX INFO: loaded from: classes5.dex */
final class C4539a extends CircularProgressDrawable {

    /* JADX INFO: renamed from: a */
    private final int f6316a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4539a(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setStyle(1);
        int centerRadius = ((int) (getCenterRadius() + getStrokeWidth())) * 2;
        this.f6316a = centerRadius;
        setBounds(0, 0, centerRadius, centerRadius);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f6316a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f6316a;
    }
}
