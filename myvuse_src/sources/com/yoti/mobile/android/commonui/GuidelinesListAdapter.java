package com.yoti.mobile.android.commonui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.commonui.databinding.YdsGuidelinesGridCellBinding;
import com.yoti.mobile.android.commonui.databinding.YdsGuidelinesListCellBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuidelinesListAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GuidelinesListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/commonui/GuidelinesViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yoti/mobile/android/commonui/GuidelinesItem;", "isListView", "", "(Ljava/util/List;Z)V", "getItemCount", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class GuidelinesListAdapter extends RecyclerView.Adapter<GuidelinesViewHolder> {
    private final boolean isListView;
    private final List<GuidelinesItem> items;

    public GuidelinesListAdapter(List<GuidelinesItem> items, boolean z) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
        this.isListView = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuidelinesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.isListView) {
            YdsGuidelinesListCellBinding ydsGuidelinesListCellBindingBind = YdsGuidelinesListCellBinding.bind(LayoutInflater.from(parent.getContext()).inflate(C4590R.layout.yds_guidelines_list_cell, parent, false));
            Intrinsics.checkNotNullExpressionValue(ydsGuidelinesListCellBindingBind, "bind(\n                  …  )\n                    )");
            return new GuidelinesListViewHolder(ydsGuidelinesListCellBindingBind);
        }
        YdsGuidelinesGridCellBinding ydsGuidelinesGridCellBindingBind = YdsGuidelinesGridCellBinding.bind(LayoutInflater.from(parent.getContext()).inflate(C4590R.layout.yds_guidelines_grid_cell, parent, false));
        Intrinsics.checkNotNullExpressionValue(ydsGuidelinesGridCellBindingBind, "bind(\n                  …  )\n                    )");
        return new GuidelinesGridViewHolder(ydsGuidelinesGridCellBindingBind);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GuidelinesViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        GuidelinesItem guidelinesItem = (GuidelinesItem) CollectionsKt.getOrNull(this.items, position);
        if (guidelinesItem != null) {
            holder.bind(guidelinesItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
