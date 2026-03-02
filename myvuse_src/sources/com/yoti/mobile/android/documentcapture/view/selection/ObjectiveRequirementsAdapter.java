package com.yoti.mobile.android.documentcapture.view.selection;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.documentcapture.databinding.YdsObjectiveRequirementCellBinding;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/ObjectiveRequirementsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/documentcapture/view/selection/ObjectiveRequirementsAdapter$ObjectiveRequirementViewHolder;", "()V", "requirements", "", "", "getRequirements", "()Ljava/util/List;", "setRequirements", "(Ljava/util/List;)V", "getItemCount", "onBindViewHolder", "", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ObjectiveRequirementViewHolder", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ObjectiveRequirementsAdapter extends RecyclerView.Adapter<ObjectiveRequirementViewHolder> {
    private List<Integer> requirements = CollectionsKt.emptyList();

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/ObjectiveRequirementsAdapter$ObjectiveRequirementViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yoti/mobile/android/documentcapture/databinding/YdsObjectiveRequirementCellBinding;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/ObjectiveRequirementsAdapter;Lcom/yoti/mobile/android/documentcapture/databinding/YdsObjectiveRequirementCellBinding;)V", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/databinding/YdsObjectiveRequirementCellBinding;", "bind", "", "item", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public final class ObjectiveRequirementViewHolder extends RecyclerView.ViewHolder {
        private final YdsObjectiveRequirementCellBinding binding;
        final /* synthetic */ ObjectiveRequirementsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ObjectiveRequirementViewHolder(ObjectiveRequirementsAdapter objectiveRequirementsAdapter, YdsObjectiveRequirementCellBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = objectiveRequirementsAdapter;
            this.binding = binding;
        }

        public final void bind(int item) {
            this.binding.objectiveRequirement.setText("- " + ((Object) this.itemView.getContext().getText(item)));
        }

        public final YdsObjectiveRequirementCellBinding getBinding() {
            return this.binding;
        }
    }

    @Inject
    public ObjectiveRequirementsAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.requirements.size();
    }

    public final List<Integer> getRequirements() {
        return this.requirements;
    }

    public final void setRequirements(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.requirements = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ObjectiveRequirementViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.requirements.get(position).intValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ObjectiveRequirementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        YdsObjectiveRequirementCellBinding ydsObjectiveRequirementCellBindingInflate = YdsObjectiveRequirementCellBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(ydsObjectiveRequirementCellBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ObjectiveRequirementViewHolder(this, ydsObjectiveRequirementCellBindingInflate);
    }
}
