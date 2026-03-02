package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.n, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepViewHolder;", "()V", "SINGLE_STEP_VIEW_TYPE", "", "STEP_VIEW_TYPE", "stepList", "", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SignpostStep;", "getStepList", "()Ljava/util/List;", "setStepList", "(Ljava/util/List;)V", "getItemCount", "getItemViewType", ViewProps.POSITION, "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class StepTrackerListAdapter extends RecyclerView.Adapter<StepViewHolder> {

    /* JADX INFO: renamed from: a */
    private final int f7834a = C4957R.layout.yds_steptracker_singlestep_cell;

    /* JADX INFO: renamed from: b */
    private final int f7835b = C4957R.layout.yds_steptracker_step_cell;

    /* JADX INFO: renamed from: c */
    private List<SignpostStep> f7836c = CollectionsKt.emptyList();

    @Inject
    public StepTrackerListAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public StepViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(i, parent, false);
        if (i == this.f7834a) {
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new SingleStepViewHolder(itemView);
        }
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new StepViewHolder(itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(StepViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.mo5272a(this.f7836c.get(i), i == this.f7836c.size() - 1);
    }

    /* JADX INFO: renamed from: a */
    public final void m5287a(List<SignpostStep> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f7836c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f7836c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItemCount() == 1 ? this.f7834a : this.f7835b;
    }
}
