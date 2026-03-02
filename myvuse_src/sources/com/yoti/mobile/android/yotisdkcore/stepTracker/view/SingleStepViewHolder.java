package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.view.View;
import com.yoti.mobile.android.commonui.BulletTextLayout;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.k, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SingleStepViewHolder;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "step", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep;", "isLastStep", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SingleStepViewHolder extends StepViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleStepViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepViewHolder
    /* JADX INFO: renamed from: a */
    public void mo5272a(SignpostStep step, boolean z) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (!step.m5263b().isEmpty()) {
            ((BulletTextLayout) this.itemView.findViewById(C4957R.id.txtBullet1)).setText(step.m5263b().get(0).intValue());
        }
        if (step.m5263b().size() > 1) {
            ((BulletTextLayout) this.itemView.findViewById(C4957R.id.txtBullet2)).setText(step.m5263b().get(1).intValue());
        }
    }
}
