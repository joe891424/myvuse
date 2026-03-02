package com.yoti.mobile.android.documentcapture.view.requirements;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentDocumentRequirementsCellBinding;
import com.yoti.mobile.android.documentcapture.view.selection.RequirementListItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewHolder;", "()V", "value", "", "Lcom/yoti/mobile/android/documentcapture/view/selection/RequirementListItem;", FirebaseAnalytics.Param.ITEMS, "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentRequirementsAdapter extends RecyclerView.Adapter<DocumentRequirementsViewHolder> {
    private List<RequirementListItem> items = CollectionsKt.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final List<RequirementListItem> getItems() {
        return this.items;
    }

    public final void setItems(List<RequirementListItem> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.items = value;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DocumentRequirementsViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        RequirementListItem requirementListItem = (RequirementListItem) CollectionsKt.getOrNull(this.items, position);
        if (requirementListItem != null) {
            holder.bind(requirementListItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DocumentRequirementsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        YdsFragmentDocumentRequirementsCellBinding ydsFragmentDocumentRequirementsCellBindingBind = YdsFragmentDocumentRequirementsCellBinding.bind(LayoutInflater.from(parent.getContext()).inflate(C4597R.layout.yds_fragment_document_requirements_cell, parent, false));
        Intrinsics.checkNotNullExpressionValue(ydsFragmentDocumentRequirementsCellBindingBind, "bind(\n                  …          )\n            )");
        return new DocumentRequirementsViewHolder(ydsFragmentDocumentRequirementsCellBindingBind);
    }
}
