package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsItemTextExtractionErrorInstructionBinding;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionInstructionsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionInstructionsViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$InstructionItem;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TextExtractionInstructionsListAdapter extends RecyclerView.Adapter<TextExtractionInstructionsViewHolder> {
    private final List<TextExtractionUploadFailureType.DocumentTextExtractionError.InstructionItem> items;

    public TextExtractionInstructionsListAdapter(List<TextExtractionUploadFailureType.DocumentTextExtractionError.InstructionItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TextExtractionInstructionsViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextExtractionUploadFailureType.DocumentTextExtractionError.InstructionItem instructionItem = (TextExtractionUploadFailureType.DocumentTextExtractionError.InstructionItem) CollectionsKt.getOrNull(this.items, position);
        if (instructionItem != null) {
            holder.bind(instructionItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TextExtractionInstructionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        YdsItemTextExtractionErrorInstructionBinding ydsItemTextExtractionErrorInstructionBindingBind = YdsItemTextExtractionErrorInstructionBinding.bind(LayoutInflater.from(parent.getContext()).inflate(C4608R.layout.yds_item_text_extraction_error_instruction, parent, false));
        Intrinsics.checkNotNullExpressionValue(ydsItemTextExtractionErrorInstructionBindingBind, "bind(\n                  …          )\n            )");
        return new TextExtractionInstructionsViewHolder(ydsItemTextExtractionErrorInstructionBindingBind);
    }
}
