package com.yoti.mobile.android.documentcapture.view.selection;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.databinding.YdsDoNotHaveDocumentCellBinding;
import com.yoti.mobile.android.documentcapture.databinding.YdsDocumentTypeCellBinding;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionListItem;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionListItemViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0006\u0010\u001b\u001a\u00020\u000bJ5\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemViewHolder;", "()V", "countrySelectionOption", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "listItems", "", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItem;", "onItemClick", "Lkotlin/Function1;", "", "value", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "selectedDocument", "setSelectedDocument", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;)V", "getItemCount", "", "getItemViewType", ViewProps.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetViews", "setup", "doNotHaveDocuments", "Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;", "setup$documentcapture_core_productionRelease", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentsAdapter extends RecyclerView.Adapter<DocumentSelectionListItemViewHolder> {
    private CountrySelectionOptionViewData countrySelectionOption;
    private List<? extends DocumentSelectionListItem> listItems = CollectionsKt.emptyList();
    private Function1<? super DocumentSelectionListItem, Unit> onItemClick;
    private DocumentViewData selectedDocument;

    @Inject
    public DocumentsAdapter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSelectedDocument(DocumentViewData documentViewData) {
        this.selectedDocument = documentViewData;
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setup$documentcapture_core_productionRelease$default(DocumentsAdapter documentsAdapter, CountrySelectionOptionViewData countrySelectionOptionViewData, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<DocumentSelectionListItem, Unit>() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentsAdapter$setup$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DocumentSelectionListItem documentSelectionListItem) {
                    invoke2(documentSelectionListItem);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DocumentSelectionListItem documentSelectionListItem) {
                    Intrinsics.checkNotNullParameter(documentSelectionListItem, "<anonymous parameter 0>");
                }
            };
        }
        documentsAdapter.setup$documentcapture_core_productionRelease(countrySelectionOptionViewData, doNotHaveDocumentsViewData, function1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.listItems.get(position).getItemType().ordinal();
    }

    public final void resetViews() {
        setSelectedDocument(null);
        notifyDataSetChanged();
    }

    public final void setup$documentcapture_core_productionRelease(CountrySelectionOptionViewData countrySelectionOption, DoNotHaveDocumentsViewData doNotHaveDocuments, Function1<? super DocumentSelectionListItem, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(countrySelectionOption, "countrySelectionOption");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.countrySelectionOption = countrySelectionOption;
        this.onItemClick = onItemClick;
        List<? extends DocumentSelectionListItem> listEmptyList = null;
        CountryViewData countryViewData = countrySelectionOption instanceof CountryViewData ? (CountryViewData) countrySelectionOption : null;
        if (countryViewData != null) {
            List<DocumentViewData> documents = countryViewData.getDocuments();
            listEmptyList = new ArrayList<>();
            Iterator<T> it2 = documents.iterator();
            while (it2.hasNext()) {
                listEmptyList.add(new DocumentSelectionListItem.DocumentListItem((DocumentViewData) it2.next()));
            }
            if (doNotHaveDocuments != null && !countryViewData.getDocuments().isEmpty()) {
                listEmptyList.add(new DocumentSelectionListItem.DoNotHaveDocumentsListItem(doNotHaveDocuments.getLabelId()));
            }
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        this.listItems = listEmptyList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DocumentSelectionListItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final DocumentSelectionListItem documentSelectionListItem = this.listItems.get(position);
        if (!(documentSelectionListItem instanceof DocumentSelectionListItem.DocumentListItem)) {
            if (documentSelectionListItem instanceof DocumentSelectionListItem.DoNotHaveDocumentsListItem) {
                ((DocumentSelectionListItemViewHolder.DoNotHaveDocumentsItemViewHolder) holder).bind(((DocumentSelectionListItem.DoNotHaveDocumentsListItem) documentSelectionListItem).getLabelId(), new Function0<Unit>() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentsAdapter.onBindViewHolder.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function1 function1 = DocumentsAdapter.this.onItemClick;
                        if (function1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("onItemClick");
                            function1 = null;
                        }
                        function1.invoke(documentSelectionListItem);
                    }
                });
                return;
            }
            return;
        }
        CountrySelectionOptionViewData countrySelectionOptionViewData = this.countrySelectionOption;
        if (countrySelectionOptionViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countrySelectionOption");
            countrySelectionOptionViewData = null;
        }
        CountryViewData countryViewData = countrySelectionOptionViewData instanceof CountryViewData ? (CountryViewData) countrySelectionOptionViewData : null;
        String iso3Code = countryViewData != null ? countryViewData.getIso3Code() : null;
        DocumentSelectionListItem.DocumentListItem documentListItem = (DocumentSelectionListItem.DocumentListItem) documentSelectionListItem;
        ((DocumentSelectionListItemViewHolder.DocumentNameItemViewHolder) holder).bind(documentListItem.getDocument().getDocumentType().getDocumentName(iso3Code).getName(), new Function0<Unit>() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentsAdapter.onBindViewHolder.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DocumentsAdapter.this.setSelectedDocument(((DocumentSelectionListItem.DocumentListItem) documentSelectionListItem).getDocument());
                Function1 function1 = DocumentsAdapter.this.onItemClick;
                if (function1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("onItemClick");
                    function1 = null;
                }
                function1.invoke(documentSelectionListItem);
            }
        }, Intrinsics.areEqual(documentListItem.getDocument(), this.selectedDocument));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DocumentSelectionListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == DocumentSelectionListItemType.DOCUMENT_NAME.ordinal()) {
            YdsDocumentTypeCellBinding ydsDocumentTypeCellBindingBind = YdsDocumentTypeCellBinding.bind(LayoutInflater.from(parent.getContext()).inflate(C4597R.layout.yds_document_type_cell, parent, false));
            Intrinsics.checkNotNullExpressionValue(ydsDocumentTypeCellBindingBind, "bind(\n                  …se)\n                    )");
            return new DocumentSelectionListItemViewHolder.DocumentNameItemViewHolder(ydsDocumentTypeCellBindingBind);
        }
        if (viewType != DocumentSelectionListItemType.DO_NOT_HAVE_DOCUMENTS.ordinal()) {
            throw new IllegalArgumentException("Unsupported viewType=" + viewType);
        }
        YdsDoNotHaveDocumentCellBinding ydsDoNotHaveDocumentCellBindingBind = YdsDoNotHaveDocumentCellBinding.bind(LayoutInflater.from(parent.getContext()).inflate(C4597R.layout.yds_do_not_have_document_cell, parent, false));
        Intrinsics.checkNotNullExpressionValue(ydsDoNotHaveDocumentCellBindingBind, "bind(\n                  …se)\n                    )");
        return new DocumentSelectionListItemViewHolder.DoNotHaveDocumentsItemViewHolder(ydsDoNotHaveDocumentCellBindingBind);
    }
}
