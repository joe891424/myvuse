package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.SignpostStep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.t, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u0006*\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u00020\u0006*\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\rH\u0002¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "step", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep;", "isLastStep", "", "setBackgroundColorResource", "id", "", "setTextAppearanceAndBackground", "Landroid/widget/TextView;", "textAppearanceResId", "bgResId", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class StepViewHolder extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: renamed from: a */
    private final void m5342a(View view, int i) {
        view.setBackgroundColor(ContextCompat.getColor(view.getContext(), i));
    }

    /* JADX INFO: renamed from: a */
    private final void m5343a(TextView textView, int i, int i2) {
        textView.setBackgroundResource(i2);
        TextViewCompat.setTextAppearance(textView, i);
    }

    /* JADX INFO: renamed from: a */
    public void mo5272a(SignpostStep step, boolean z) {
        Intrinsics.checkNotNullParameter(step, "step");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C4957R.id.stepTitle);
        IStepComposition f7820a = step.getF7820a();
        Resources resources = this.itemView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(f7820a.mo5250a(resources));
        View viewFindViewById = view.findViewById(C4957R.id.stepNumber);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<TextView>(R.id.stepNumber)");
        m5343a((TextView) viewFindViewById, step.m5264c().getF7825a(), step.m5264c().getF7826b());
        View viewFindViewById2 = view.findViewById(C4957R.id.verticalLine);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "");
        m5342a(viewFindViewById2, step.m5264c().getF7827c());
        if (z) {
            viewFindViewById2.setVisibility(8);
        }
        ((TextView) view.findViewById(C4957R.id.stepNumber)).setText(step.m5264c() != SignpostStep.b.COMPLETED ? step.getF7821b() : "");
    }
}
