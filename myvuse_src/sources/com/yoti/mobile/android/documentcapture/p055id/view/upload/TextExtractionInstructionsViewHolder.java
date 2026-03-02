package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsItemTextExtractionErrorInstructionBinding;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionInstructionsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsItemTextExtractionErrorInstructionBinding;", "(Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsItemTextExtractionErrorInstructionBinding;)V", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsItemTextExtractionErrorInstructionBinding;", "bind", "", "item", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$InstructionItem;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TextExtractionInstructionsViewHolder extends RecyclerView.ViewHolder {
    private final YdsItemTextExtractionErrorInstructionBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextExtractionInstructionsViewHolder(YdsItemTextExtractionErrorInstructionBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void bind(TextExtractionUploadFailureType.DocumentTextExtractionError.InstructionItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        YdsItemTextExtractionErrorInstructionBinding ydsItemTextExtractionErrorInstructionBinding = this.binding;
        ydsItemTextExtractionErrorInstructionBinding.errorInstructionImage.setImageResource(item.getImageId());
        ydsItemTextExtractionErrorInstructionBinding.errorInstructionText.setText(item.getTextId());
    }

    public final YdsItemTextExtractionErrorInstructionBinding getBinding() {
        return this.binding;
    }
}
