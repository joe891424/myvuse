package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$AbstractDocumentViewEvent;", "()V", "ChangeCountry", "CountryNotListed", "CountrySelected", "DocumentSelected", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent$DocumentSelected;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent$CountrySelected;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent$ChangeCountry;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent$CountryNotListed;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentSelectionViewEvent extends DocumentViewEvent.AbstractDocumentViewEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent$ChangeCountry;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ChangeCountry extends DocumentSelectionViewEvent {
        public static final ChangeCountry INSTANCE = new ChangeCountry();

        private ChangeCountry() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent$CountryNotListed;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CountryNotListed extends DocumentSelectionViewEvent {
        public static final CountryNotListed INSTANCE = new CountryNotListed();

        private CountryNotListed() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent$CountrySelected;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent;", "country", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;)V", "getCountry", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CountrySelected extends DocumentSelectionViewEvent {
        private final CountrySelectionOptionViewData country;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountrySelected(CountrySelectionOptionViewData country) {
            super(null);
            Intrinsics.checkNotNullParameter(country, "country");
            this.country = country;
        }

        public static /* synthetic */ CountrySelected copy$default(CountrySelected countrySelected, CountrySelectionOptionViewData countrySelectionOptionViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                countrySelectionOptionViewData = countrySelected.country;
            }
            return countrySelected.copy(countrySelectionOptionViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CountrySelectionOptionViewData getCountry() {
            return this.country;
        }

        public final CountrySelected copy(CountrySelectionOptionViewData country) {
            Intrinsics.checkNotNullParameter(country, "country");
            return new CountrySelected(country);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CountrySelected) && Intrinsics.areEqual(this.country, ((CountrySelected) other).country);
        }

        public final CountrySelectionOptionViewData getCountry() {
            return this.country;
        }

        public int hashCode() {
            return this.country.hashCode();
        }

        public String toString() {
            return "CountrySelected(country=" + this.country + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent$DocumentSelected;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewEvent;", "document", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "isCameraPermissionNeeded", "", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;Z)V", "getDocument", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentSelected extends DocumentSelectionViewEvent {
        private final DocumentViewData document;
        private final boolean isCameraPermissionNeeded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DocumentSelected(DocumentViewData document, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(document, "document");
            this.document = document;
            this.isCameraPermissionNeeded = z;
        }

        public static /* synthetic */ DocumentSelected copy$default(DocumentSelected documentSelected, DocumentViewData documentViewData, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                documentViewData = documentSelected.document;
            }
            if ((i & 2) != 0) {
                z = documentSelected.isCameraPermissionNeeded;
            }
            return documentSelected.copy(documentViewData, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentViewData getDocument() {
            return this.document;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsCameraPermissionNeeded() {
            return this.isCameraPermissionNeeded;
        }

        public final DocumentSelected copy(DocumentViewData document, boolean isCameraPermissionNeeded) {
            Intrinsics.checkNotNullParameter(document, "document");
            return new DocumentSelected(document, isCameraPermissionNeeded);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DocumentSelected)) {
                return false;
            }
            DocumentSelected documentSelected = (DocumentSelected) other;
            return Intrinsics.areEqual(this.document, documentSelected.document) && this.isCameraPermissionNeeded == documentSelected.isCameraPermissionNeeded;
        }

        public final DocumentViewData getDocument() {
            return this.document;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iHashCode = this.document.hashCode() * 31;
            boolean z = this.isCameraPermissionNeeded;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isCameraPermissionNeeded() {
            return this.isCameraPermissionNeeded;
        }

        public String toString() {
            return "DocumentSelected(document=" + this.document + ", isCameraPermissionNeeded=" + this.isCameraPermissionNeeded + ')';
        }
    }

    private DocumentSelectionViewEvent() {
    }

    public /* synthetic */ DocumentSelectionViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
