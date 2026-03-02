package com.yoti.mobile.android.documentcapture.view.selection;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentRequirementViewData;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "Landroid/os/Parcelable;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "documentRequirements", "", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;Ljava/util/Set;)V", "dateFromRequirement", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData$DateFromViewData;", "getDateFromRequirement", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData$DateFromViewData;", "getDocumentRequirements", "()Ljava/util/Set;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentViewData implements Parcelable {
    public static final Parcelable.Creator<DocumentViewData> CREATOR = new Creator();
    private final Set<DocumentRequirementViewData> documentRequirements;
    private final DocumentTypeViewData documentType;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            DocumentTypeViewData documentTypeViewData = (DocumentTypeViewData) parcel.readParcelable(DocumentViewData.class.getClassLoader());
            int i = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(i);
            for (int i2 = 0; i2 != i; i2++) {
                linkedHashSet.add(parcel.readParcelable(DocumentViewData.class.getClassLoader()));
            }
            return new DocumentViewData(documentTypeViewData, linkedHashSet);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentViewData[] newArray(int i) {
            return new DocumentViewData[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocumentViewData(DocumentTypeViewData documentType, Set<? extends DocumentRequirementViewData> documentRequirements) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(documentRequirements, "documentRequirements");
        this.documentType = documentType;
        this.documentRequirements = documentRequirements;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentViewData copy$default(DocumentViewData documentViewData, DocumentTypeViewData documentTypeViewData, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            documentTypeViewData = documentViewData.documentType;
        }
        if ((i & 2) != 0) {
            set = documentViewData.documentRequirements;
        }
        return documentViewData.copy(documentTypeViewData, set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DocumentTypeViewData getDocumentType() {
        return this.documentType;
    }

    public final Set<DocumentRequirementViewData> component2() {
        return this.documentRequirements;
    }

    public final DocumentViewData copy(DocumentTypeViewData documentType, Set<? extends DocumentRequirementViewData> documentRequirements) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(documentRequirements, "documentRequirements");
        return new DocumentViewData(documentType, documentRequirements);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentViewData)) {
            return false;
        }
        DocumentViewData documentViewData = (DocumentViewData) other;
        return this.documentType == documentViewData.documentType && Intrinsics.areEqual(this.documentRequirements, documentViewData.documentRequirements);
    }

    public final DocumentRequirementViewData.DateFromViewData getDateFromRequirement() {
        Set<DocumentRequirementViewData> set = this.documentRequirements;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (obj instanceof DocumentRequirementViewData.DateFromViewData) {
                arrayList.add(obj);
            }
        }
        return (DocumentRequirementViewData.DateFromViewData) CollectionsKt.firstOrNull((List) arrayList);
    }

    public final Set<DocumentRequirementViewData> getDocumentRequirements() {
        return this.documentRequirements;
    }

    public final DocumentTypeViewData getDocumentType() {
        return this.documentType;
    }

    public int hashCode() {
        return (this.documentType.hashCode() * 31) + this.documentRequirements.hashCode();
    }

    public String toString() {
        return "DocumentViewData(documentType=" + this.documentType + ", documentRequirements=" + this.documentRequirements + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.documentType, flags);
        Set<DocumentRequirementViewData> set = this.documentRequirements;
        parcel.writeInt(set.size());
        Iterator<DocumentRequirementViewData> it2 = set.iterator();
        while (it2.hasNext()) {
            parcel.writeParcelable(it2.next(), flags);
        }
    }

    public /* synthetic */ DocumentViewData(DocumentTypeViewData documentTypeViewData, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(documentTypeViewData, (i & 2) != 0 ? SetsKt.emptySet() : set);
    }
}
