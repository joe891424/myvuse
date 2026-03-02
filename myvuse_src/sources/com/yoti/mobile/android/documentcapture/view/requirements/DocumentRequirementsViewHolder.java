package com.yoti.mobile.android.documentcapture.view.requirements;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentDocumentRequirementsCellBinding;
import com.yoti.mobile.android.documentcapture.view.selection.RequirementListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u0006*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentRequirementsCellBinding;", "(Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentRequirementsCellBinding;)V", "bind", "", "item", "Lcom/yoti/mobile/android/documentcapture/view/selection/RequirementListItem;", "setText", "Landroid/widget/TextView;", "compoundTextResource", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentRequirementsViewHolder extends RecyclerView.ViewHolder {
    private final YdsFragmentDocumentRequirementsCellBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentRequirementsViewHolder(YdsFragmentDocumentRequirementsCellBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setText(android.widget.TextView r3, com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L1b
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.CharSequence r4 = r4.getValue(r0)
            if (r4 == 0) goto L1b
            r0 = 0
            r3.setVisibility(r0)
            r3.setText(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L1c
        L1b:
            r4 = 0
        L1c:
            if (r4 != 0) goto L23
            r4 = 8
            r3.setVisibility(r4)
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewHolder.setText(android.widget.TextView, com.yoti.mobile.android.common.ui.widgets.CompoundTextResource):void");
    }

    public final void bind(RequirementListItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        YdsFragmentDocumentRequirementsCellBinding ydsFragmentDocumentRequirementsCellBinding = this.binding;
        ydsFragmentDocumentRequirementsCellBinding.imageViewRequirementsItem.setImageResource(item.getIcon());
        ydsFragmentDocumentRequirementsCellBinding.textViewRequirementsItemHeader.setText(item.getHeader());
        TextView textViewRequirementsItemText = ydsFragmentDocumentRequirementsCellBinding.textViewRequirementsItemText;
        Intrinsics.checkNotNullExpressionValue(textViewRequirementsItemText, "textViewRequirementsItemText");
        setText(textViewRequirementsItemText, item.getText());
        TextView textViewRequirementsItemTextSecondary = ydsFragmentDocumentRequirementsCellBinding.textViewRequirementsItemTextSecondary;
        Intrinsics.checkNotNullExpressionValue(textViewRequirementsItemTextSecondary, "textViewRequirementsItemTextSecondary");
        setText(textViewRequirementsItemTextSecondary, item.getTextSecondary());
    }
}
