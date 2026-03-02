package com.yoti.mobile.android.documentcapture.view.selection;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003JO\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010.\u001a\u00020\u0011HÖ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0011HÖ\u0001J\t\u00104\u001a\u00020 HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\t8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006:"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "Landroid/os/Parcelable;", "title", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "selectedCountryOption", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "countries", "", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryViewData;", "countryNotListedOption", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryNotListedViewData;", "doNotHaveDocumentsViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;", "(Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;Ljava/util/List;Lcom/yoti/mobile/android/documentcapture/view/selection/CountryNotListedViewData;Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;)V", "buttonChangeCountryLinkVisibility", "", "getButtonChangeCountryLinkVisibility", "()I", "getCountries", "()Ljava/util/List;", "getCountryNotListedOption", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CountryNotListedViewData;", "getDoNotHaveDocumentsViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;", "getObjective", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "selectedCountryDocuments", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getSelectedCountryDocuments", "selectedCountryName", "", "getSelectedCountryName", "()Ljava/lang/String;", "getSelectedCountryOption", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "getTitle", "()Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentSelectionViewData implements Parcelable {
    public static final Parcelable.Creator<DocumentSelectionViewData> CREATOR = new Creator();
    private final List<CountryViewData> countries;
    private final CountryNotListedViewData countryNotListedOption;
    private final DoNotHaveDocumentsViewData doNotHaveDocumentsViewData;
    private final CaptureObjectiveTypeViewData objective;
    private final CountrySelectionOptionViewData selectedCountryOption;
    private final CompoundTextResource title;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentSelectionViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentSelectionViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            CompoundTextResource compoundTextResource = (CompoundTextResource) parcel.readParcelable(DocumentSelectionViewData.class.getClassLoader());
            CaptureObjectiveTypeViewData captureObjectiveTypeViewDataCreateFromParcel = CaptureObjectiveTypeViewData.CREATOR.createFromParcel(parcel);
            CountrySelectionOptionViewData countrySelectionOptionViewData = (CountrySelectionOptionViewData) parcel.readParcelable(DocumentSelectionViewData.class.getClassLoader());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(CountryViewData.CREATOR.createFromParcel(parcel));
            }
            return new DocumentSelectionViewData(compoundTextResource, captureObjectiveTypeViewDataCreateFromParcel, countrySelectionOptionViewData, arrayList, parcel.readInt() == 0 ? null : CountryNotListedViewData.CREATOR.createFromParcel(parcel), DoNotHaveDocumentsViewData.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentSelectionViewData[] newArray(int i) {
            return new DocumentSelectionViewData[i];
        }
    }

    public DocumentSelectionViewData(CompoundTextResource title, CaptureObjectiveTypeViewData objective, CountrySelectionOptionViewData countrySelectionOptionViewData, List<CountryViewData> countries, CountryNotListedViewData countryNotListedViewData, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(countries, "countries");
        Intrinsics.checkNotNullParameter(doNotHaveDocumentsViewData, "doNotHaveDocumentsViewData");
        this.title = title;
        this.objective = objective;
        this.selectedCountryOption = countrySelectionOptionViewData;
        this.countries = countries;
        this.countryNotListedOption = countryNotListedViewData;
        this.doNotHaveDocumentsViewData = doNotHaveDocumentsViewData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentSelectionViewData copy$default(DocumentSelectionViewData documentSelectionViewData, CompoundTextResource compoundTextResource, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, CountrySelectionOptionViewData countrySelectionOptionViewData, List list, CountryNotListedViewData countryNotListedViewData, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData, int i, Object obj) {
        if ((i & 1) != 0) {
            compoundTextResource = documentSelectionViewData.title;
        }
        if ((i & 2) != 0) {
            captureObjectiveTypeViewData = documentSelectionViewData.objective;
        }
        CaptureObjectiveTypeViewData captureObjectiveTypeViewData2 = captureObjectiveTypeViewData;
        if ((i & 4) != 0) {
            countrySelectionOptionViewData = documentSelectionViewData.selectedCountryOption;
        }
        CountrySelectionOptionViewData countrySelectionOptionViewData2 = countrySelectionOptionViewData;
        if ((i & 8) != 0) {
            list = documentSelectionViewData.countries;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            countryNotListedViewData = documentSelectionViewData.countryNotListedOption;
        }
        CountryNotListedViewData countryNotListedViewData2 = countryNotListedViewData;
        if ((i & 32) != 0) {
            doNotHaveDocumentsViewData = documentSelectionViewData.doNotHaveDocumentsViewData;
        }
        return documentSelectionViewData.copy(compoundTextResource, captureObjectiveTypeViewData2, countrySelectionOptionViewData2, list2, countryNotListedViewData2, doNotHaveDocumentsViewData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CompoundTextResource getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CaptureObjectiveTypeViewData getObjective() {
        return this.objective;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CountrySelectionOptionViewData getSelectedCountryOption() {
        return this.selectedCountryOption;
    }

    public final List<CountryViewData> component4() {
        return this.countries;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CountryNotListedViewData getCountryNotListedOption() {
        return this.countryNotListedOption;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DoNotHaveDocumentsViewData getDoNotHaveDocumentsViewData() {
        return this.doNotHaveDocumentsViewData;
    }

    public final DocumentSelectionViewData copy(CompoundTextResource title, CaptureObjectiveTypeViewData objective, CountrySelectionOptionViewData selectedCountryOption, List<CountryViewData> countries, CountryNotListedViewData countryNotListedOption, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(countries, "countries");
        Intrinsics.checkNotNullParameter(doNotHaveDocumentsViewData, "doNotHaveDocumentsViewData");
        return new DocumentSelectionViewData(title, objective, selectedCountryOption, countries, countryNotListedOption, doNotHaveDocumentsViewData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentSelectionViewData)) {
            return false;
        }
        DocumentSelectionViewData documentSelectionViewData = (DocumentSelectionViewData) other;
        return Intrinsics.areEqual(this.title, documentSelectionViewData.title) && this.objective == documentSelectionViewData.objective && Intrinsics.areEqual(this.selectedCountryOption, documentSelectionViewData.selectedCountryOption) && Intrinsics.areEqual(this.countries, documentSelectionViewData.countries) && Intrinsics.areEqual(this.countryNotListedOption, documentSelectionViewData.countryNotListedOption) && Intrinsics.areEqual(this.doNotHaveDocumentsViewData, documentSelectionViewData.doNotHaveDocumentsViewData);
    }

    public final int getButtonChangeCountryLinkVisibility() {
        return this.countries.size() > 1 ? 0 : 8;
    }

    public final List<CountryViewData> getCountries() {
        return this.countries;
    }

    public final CountryNotListedViewData getCountryNotListedOption() {
        return this.countryNotListedOption;
    }

    public final DoNotHaveDocumentsViewData getDoNotHaveDocumentsViewData() {
        return this.doNotHaveDocumentsViewData;
    }

    public final CaptureObjectiveTypeViewData getObjective() {
        return this.objective;
    }

    public final List<DocumentTypeViewData> getSelectedCountryDocuments() {
        List<DocumentViewData> documents;
        CountrySelectionOptionViewData countrySelectionOptionViewData = this.selectedCountryOption;
        ArrayList arrayList = null;
        CountryViewData countryViewData = countrySelectionOptionViewData instanceof CountryViewData ? (CountryViewData) countrySelectionOptionViewData : null;
        if (countryViewData != null && (documents = countryViewData.getDocuments()) != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(documents, 10));
            Iterator<T> it2 = documents.iterator();
            while (it2.hasNext()) {
                arrayList.add(((DocumentViewData) it2.next()).getDocumentType());
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public final String getSelectedCountryName() {
        String localizedName;
        CountrySelectionOptionViewData countrySelectionOptionViewData = this.selectedCountryOption;
        CountryViewData countryViewData = countrySelectionOptionViewData instanceof CountryViewData ? (CountryViewData) countrySelectionOptionViewData : null;
        return (countryViewData == null || (localizedName = countryViewData.getLocalizedName()) == null) ? "" : localizedName;
    }

    public final CountrySelectionOptionViewData getSelectedCountryOption() {
        return this.selectedCountryOption;
    }

    public final CompoundTextResource getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((this.title.hashCode() * 31) + this.objective.hashCode()) * 31;
        CountrySelectionOptionViewData countrySelectionOptionViewData = this.selectedCountryOption;
        int iHashCode2 = (((iHashCode + (countrySelectionOptionViewData == null ? 0 : countrySelectionOptionViewData.hashCode())) * 31) + this.countries.hashCode()) * 31;
        CountryNotListedViewData countryNotListedViewData = this.countryNotListedOption;
        return ((iHashCode2 + (countryNotListedViewData != null ? countryNotListedViewData.hashCode() : 0)) * 31) + this.doNotHaveDocumentsViewData.hashCode();
    }

    public String toString() {
        return "DocumentSelectionViewData(title=" + this.title + ", objective=" + this.objective + ", selectedCountryOption=" + this.selectedCountryOption + ", countries=" + this.countries + ", countryNotListedOption=" + this.countryNotListedOption + ", doNotHaveDocumentsViewData=" + this.doNotHaveDocumentsViewData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.title, flags);
        this.objective.writeToParcel(parcel, flags);
        parcel.writeParcelable(this.selectedCountryOption, flags);
        List<CountryViewData> list = this.countries;
        parcel.writeInt(list.size());
        Iterator<CountryViewData> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        CountryNotListedViewData countryNotListedViewData = this.countryNotListedOption;
        if (countryNotListedViewData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            countryNotListedViewData.writeToParcel(parcel, flags);
        }
        this.doNotHaveDocumentsViewData.writeToParcel(parcel, flags);
    }

    public /* synthetic */ DocumentSelectionViewData(CompoundTextResource compoundTextResource, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, CountrySelectionOptionViewData countrySelectionOptionViewData, List list, CountryNotListedViewData countryNotListedViewData, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compoundTextResource, captureObjectiveTypeViewData, (i & 4) != 0 ? null : countrySelectionOptionViewData, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : countryNotListedViewData, doNotHaveDocumentsViewData);
    }
}
