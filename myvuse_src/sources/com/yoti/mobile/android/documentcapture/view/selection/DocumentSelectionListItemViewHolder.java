package com.yoti.mobile.android.documentcapture.view.selection;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.button.YotiOptionButton;
import com.yoti.mobile.android.documentcapture.databinding.YdsDoNotHaveDocumentCellBinding;
import com.yoti.mobile.android.documentcapture.databinding.YdsDocumentTypeCellBinding;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionListItemViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "DoNotHaveDocumentsItemViewHolder", "DocumentNameItemViewHolder", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemViewHolder$DocumentNameItemViewHolder;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemViewHolder$DoNotHaveDocumentsItemViewHolder;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentSelectionListItemViewHolder extends RecyclerView.ViewHolder {

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemViewHolder$DoNotHaveDocumentsItemViewHolder;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemViewHolder;", "binding", "Lcom/yoti/mobile/android/documentcapture/databinding/YdsDoNotHaveDocumentCellBinding;", "(Lcom/yoti/mobile/android/documentcapture/databinding/YdsDoNotHaveDocumentCellBinding;)V", "bind", "", "labelId", "", "onClick", "Lkotlin/Function0;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DoNotHaveDocumentsItemViewHolder extends DocumentSelectionListItemViewHolder {
        private final YdsDoNotHaveDocumentCellBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public DoNotHaveDocumentsItemViewHolder(YdsDoNotHaveDocumentCellBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            LinearLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            super(root, null);
            this.binding = binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: bind$lambda-1$lambda-0, reason: not valid java name */
        public static final void m6854bind$lambda1$lambda0(Function0 onClick, View view) {
            Intrinsics.checkNotNullParameter(onClick, "$onClick");
            onClick.invoke();
        }

        public final void bind(int labelId, final Function0<Unit> onClick) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            YotiOptionButton yotiOptionButton = this.binding.buttonDoNotHaveDocuments;
            yotiOptionButton.setTitle(labelId);
            yotiOptionButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionListItemViewHolder$DoNotHaveDocumentsItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentSelectionListItemViewHolder.DoNotHaveDocumentsItemViewHolder.m6854bind$lambda1$lambda0(onClick, view);
                }
            });
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemViewHolder$DocumentNameItemViewHolder;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemViewHolder;", "binding", "Lcom/yoti/mobile/android/documentcapture/databinding/YdsDocumentTypeCellBinding;", "(Lcom/yoti/mobile/android/documentcapture/databinding/YdsDocumentTypeCellBinding;)V", "bind", "", "documentName", "", "onClick", "Lkotlin/Function0;", "selected", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DocumentNameItemViewHolder extends DocumentSelectionListItemViewHolder {
        private final YdsDocumentTypeCellBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public DocumentNameItemViewHolder(YdsDocumentTypeCellBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            YotiOptionButton root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            super(root, null);
            this.binding = binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: bind$lambda-1$lambda-0, reason: not valid java name */
        public static final void m6855bind$lambda1$lambda0(Function0 onClick, View view) {
            Intrinsics.checkNotNullParameter(onClick, "$onClick");
            onClick.invoke();
        }

        public final void bind(int documentName, final Function0<Unit> onClick, boolean selected) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            YotiOptionButton yotiOptionButton = this.binding.buttonDocument;
            yotiOptionButton.setTitle(yotiOptionButton.getContext().getString(documentName));
            if (selected) {
                yotiOptionButton.showProgress();
            } else {
                yotiOptionButton.hideProgress();
            }
            yotiOptionButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionListItemViewHolder$DocumentNameItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentSelectionListItemViewHolder.DocumentNameItemViewHolder.m6855bind$lambda1$lambda0(onClick, view);
                }
            });
        }
    }

    private DocumentSelectionListItemViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ DocumentSelectionListItemViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
