package com.yoti.mobile.android.documentcapture.view.educational;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0019\u001a\u00020\fHÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\f8G¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArguments;", "Landroid/os/Parcelable;", "documentViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "countryIso3Code", "", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;)V", "getCountryIso3Code", "()Ljava/lang/String;", "documentName", "", "getDocumentName$annotations", "()V", "getDocumentName", "()I", "getDocumentViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "getObjective", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentEducationalArguments implements Parcelable {
    public static final Parcelable.Creator<DocumentEducationalArguments> CREATOR = new Creator();
    private final String countryIso3Code;
    private final DocumentViewData documentViewData;
    private final CaptureObjectiveTypeViewData objective;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentEducationalArguments> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentEducationalArguments createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DocumentEducationalArguments(DocumentViewData.CREATOR.createFromParcel(parcel), parcel.readString(), CaptureObjectiveTypeViewData.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentEducationalArguments[] newArray(int i) {
            return new DocumentEducationalArguments[i];
        }
    }

    public DocumentEducationalArguments(DocumentViewData documentViewData, String countryIso3Code, CaptureObjectiveTypeViewData objective) {
        Intrinsics.checkNotNullParameter(documentViewData, "documentViewData");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(objective, "objective");
        this.documentViewData = documentViewData;
        this.countryIso3Code = countryIso3Code;
        this.objective = objective;
    }

    public static /* synthetic */ DocumentEducationalArguments copy$default(DocumentEducationalArguments documentEducationalArguments, DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, int i, Object obj) {
        if ((i & 1) != 0) {
            documentViewData = documentEducationalArguments.documentViewData;
        }
        if ((i & 2) != 0) {
            str = documentEducationalArguments.countryIso3Code;
        }
        if ((i & 4) != 0) {
            captureObjectiveTypeViewData = documentEducationalArguments.objective;
        }
        return documentEducationalArguments.copy(documentViewData, str, captureObjectiveTypeViewData);
    }

    public static /* synthetic */ void getDocumentName$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DocumentViewData getDocumentViewData() {
        return this.documentViewData;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CaptureObjectiveTypeViewData getObjective() {
        return this.objective;
    }

    public final DocumentEducationalArguments copy(DocumentViewData documentViewData, String countryIso3Code, CaptureObjectiveTypeViewData objective) {
        Intrinsics.checkNotNullParameter(documentViewData, "documentViewData");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(objective, "objective");
        return new DocumentEducationalArguments(documentViewData, countryIso3Code, objective);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentEducationalArguments)) {
            return false;
        }
        DocumentEducationalArguments documentEducationalArguments = (DocumentEducationalArguments) other;
        return Intrinsics.areEqual(this.documentViewData, documentEducationalArguments.documentViewData) && Intrinsics.areEqual(this.countryIso3Code, documentEducationalArguments.countryIso3Code) && this.objective == documentEducationalArguments.objective;
    }

    public final String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    public final int getDocumentName() {
        return this.documentViewData.getDocumentType().getDocumentName(this.countryIso3Code).getLowercaseName();
    }

    public final DocumentViewData getDocumentViewData() {
        return this.documentViewData;
    }

    public final CaptureObjectiveTypeViewData getObjective() {
        return this.objective;
    }

    public int hashCode() {
        return (((this.documentViewData.hashCode() * 31) + this.countryIso3Code.hashCode()) * 31) + this.objective.hashCode();
    }

    public String toString() {
        return "DocumentEducationalArguments(documentViewData=" + this.documentViewData + ", countryIso3Code=" + this.countryIso3Code + ", objective=" + this.objective + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.documentViewData.writeToParcel(parcel, flags);
        parcel.writeString(this.countryIso3Code);
        this.objective.writeToParcel(parcel, flags);
    }
}
