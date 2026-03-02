package com.yoti.mobile.android.common.p049ui.widgets.educationCard;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
public final class EducationCardViewKt$sam$i$android_view_View_OnClickListener$0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private final /* synthetic */ Function1 f6438a;

    public EducationCardViewKt$sam$i$android_view_View_OnClickListener$0(Function1 function1) {
        this.f6438a = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(this.f6438a.invoke(view), "invoke(...)");
    }
}
