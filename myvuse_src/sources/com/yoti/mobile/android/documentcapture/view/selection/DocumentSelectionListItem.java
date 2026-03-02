package com.yoti.mobile.android.documentcapture.view.selection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItem;", "", "itemType", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemType;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemType;)V", "getItemType", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItemType;", "DoNotHaveDocumentsListItem", "DocumentListItem", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItem$DocumentListItem;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItem$DoNotHaveDocumentsListItem;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentSelectionListItem {
    private final DocumentSelectionListItemType itemType;

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItem$DoNotHaveDocumentsListItem;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItem;", "labelId", "", "(I)V", "getLabelId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DoNotHaveDocumentsListItem extends DocumentSelectionListItem {
        private final int labelId;

        public DoNotHaveDocumentsListItem(int i) {
            super(DocumentSelectionListItemType.DO_NOT_HAVE_DOCUMENTS, null);
            this.labelId = i;
        }

        public static /* synthetic */ DoNotHaveDocumentsListItem copy$default(DoNotHaveDocumentsListItem doNotHaveDocumentsListItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = doNotHaveDocumentsListItem.labelId;
            }
            return doNotHaveDocumentsListItem.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getLabelId() {
            return this.labelId;
        }

        public final DoNotHaveDocumentsListItem copy(int labelId) {
            return new DoNotHaveDocumentsListItem(labelId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DoNotHaveDocumentsListItem) && this.labelId == ((DoNotHaveDocumentsListItem) other).labelId;
        }

        public final int getLabelId() {
            return this.labelId;
        }

        public int hashCode() {
            return Integer.hashCode(this.labelId);
        }

        public String toString() {
            return "DoNotHaveDocumentsListItem(labelId=" + this.labelId + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItem$DocumentListItem;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionListItem;", "document", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;)V", "getDocument", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentListItem extends DocumentSelectionListItem {
        private final DocumentViewData document;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DocumentListItem(DocumentViewData document) {
            super(DocumentSelectionListItemType.DOCUMENT_NAME, null);
            Intrinsics.checkNotNullParameter(document, "document");
            this.document = document;
        }

        public static /* synthetic */ DocumentListItem copy$default(DocumentListItem documentListItem, DocumentViewData documentViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                documentViewData = documentListItem.document;
            }
            return documentListItem.copy(documentViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentViewData getDocument() {
            return this.document;
        }

        public final DocumentListItem copy(DocumentViewData document) {
            Intrinsics.checkNotNullParameter(document, "document");
            return new DocumentListItem(document);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DocumentListItem) && Intrinsics.areEqual(this.document, ((DocumentListItem) other).document);
        }

        public final DocumentViewData getDocument() {
            return this.document;
        }

        public int hashCode() {
            return this.document.hashCode();
        }

        public String toString() {
            return "DocumentListItem(document=" + this.document + ')';
        }
    }

    private DocumentSelectionListItem(DocumentSelectionListItemType documentSelectionListItemType) {
        this.itemType = documentSelectionListItemType;
    }

    public /* synthetic */ DocumentSelectionListItem(DocumentSelectionListItemType documentSelectionListItemType, DefaultConstructorMarker defaultConstructorMarker) {
        this(documentSelectionListItemType);
    }

    public final DocumentSelectionListItemType getItemType() {
        return this.itemType;
    }
}
