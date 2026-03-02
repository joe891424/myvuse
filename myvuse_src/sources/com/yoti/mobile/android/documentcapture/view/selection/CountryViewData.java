package com.yoti.mobile.android.documentcapture.view.selection;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/CountryViewData;", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "iso3Code", "", BlinkIdCombinedRecognizer.VerificationConstants.LocalizedName, "documents", "", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDocuments", "()Ljava/util/List;", "getIso3Code", "()Ljava/lang/String;", "getLocalizedName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getLabel", "context", "Landroid/content/Context;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CountryViewData extends CountrySelectionOptionViewData {
    public static final Parcelable.Creator<CountryViewData> CREATOR = new Creator();
    private final List<DocumentViewData> documents;
    private final String iso3Code;
    private final String localizedName;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<CountryViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CountryViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(DocumentViewData.CREATOR.createFromParcel(parcel));
            }
            return new CountryViewData(string, string2, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CountryViewData[] newArray(int i) {
            return new CountryViewData[i];
        }
    }

    public /* synthetic */ CountryViewData(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CountryViewData copy$default(CountryViewData countryViewData, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countryViewData.iso3Code;
        }
        if ((i & 2) != 0) {
            str2 = countryViewData.localizedName;
        }
        if ((i & 4) != 0) {
            list = countryViewData.documents;
        }
        return countryViewData.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIso3Code() {
        return this.iso3Code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLocalizedName() {
        return this.localizedName;
    }

    public final List<DocumentViewData> component3() {
        return this.documents;
    }

    public final CountryViewData copy(String iso3Code, String localizedName, List<DocumentViewData> documents) {
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        Intrinsics.checkNotNullParameter(localizedName, "localizedName");
        Intrinsics.checkNotNullParameter(documents, "documents");
        return new CountryViewData(iso3Code, localizedName, documents);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryViewData)) {
            return false;
        }
        CountryViewData countryViewData = (CountryViewData) other;
        return Intrinsics.areEqual(this.iso3Code, countryViewData.iso3Code) && Intrinsics.areEqual(this.localizedName, countryViewData.localizedName) && Intrinsics.areEqual(this.documents, countryViewData.documents);
    }

    public final List<DocumentViewData> getDocuments() {
        return this.documents;
    }

    public final String getIso3Code() {
        return this.iso3Code;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.selection.CountrySelectionOptionViewData
    public String getLabel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.localizedName;
    }

    public final String getLocalizedName() {
        return this.localizedName;
    }

    public int hashCode() {
        return (((this.iso3Code.hashCode() * 31) + this.localizedName.hashCode()) * 31) + this.documents.hashCode();
    }

    public String toString() {
        return "CountryViewData(iso3Code=" + this.iso3Code + ", localizedName=" + this.localizedName + ", documents=" + this.documents + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.iso3Code);
        parcel.writeString(this.localizedName);
        List<DocumentViewData> list = this.documents;
        parcel.writeInt(list.size());
        Iterator<DocumentViewData> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryViewData(String iso3Code, String localizedName, List<DocumentViewData> documents) {
        super(null);
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        Intrinsics.checkNotNullParameter(localizedName, "localizedName");
        Intrinsics.checkNotNullParameter(documents, "documents");
        this.iso3Code = iso3Code;
        this.localizedName = localizedName;
        this.documents = documents;
    }
}
