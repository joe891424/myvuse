package com.yoti.mobile.android.documentcapture.view.educational;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.commonui.MediaResource;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DoNotHaveDocumentsViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u0010HÆ\u0003Jc\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0003\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0007HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001b¨\u00067"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;", "Landroid/os/Parcelable;", "title", "Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "message", "requirements", "", "", "ctaText", "mediaResource", "Lcom/yoti/mobile/android/commonui/MediaResource;", "documentViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "doNotHaveDocumentsViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;", "(Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;Ljava/util/List;ILcom/yoti/mobile/android/commonui/MediaResource;Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;)V", "getCtaText", "()I", "getDoNotHaveDocumentsViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;", "getDocumentViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "getMediaResource", "()Lcom/yoti/mobile/android/commonui/MediaResource;", "getMessage", "()Lcom/yoti/mobile/android/common/ui/widgets/CompoundTextResource;", "getObjective", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "getRequirements", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentEducationalViewData implements Parcelable {
    public static final Parcelable.Creator<DocumentEducationalViewData> CREATOR = new Creator();
    private final int ctaText;
    private final DoNotHaveDocumentsViewData doNotHaveDocumentsViewData;
    private final DocumentViewData documentViewData;
    private final MediaResource mediaResource;
    private final CompoundTextResource message;
    private final CaptureObjectiveTypeViewData objective;
    private final List<Integer> requirements;
    private final CompoundTextResource title;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentEducationalViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentEducationalViewData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            CompoundTextResource compoundTextResource = (CompoundTextResource) parcel.readParcelable(DocumentEducationalViewData.class.getClassLoader());
            CompoundTextResource compoundTextResource2 = (CompoundTextResource) parcel.readParcelable(DocumentEducationalViewData.class.getClassLoader());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(Integer.valueOf(parcel.readInt()));
                }
                arrayList = arrayList2;
            }
            return new DocumentEducationalViewData(compoundTextResource, compoundTextResource2, arrayList, parcel.readInt(), (MediaResource) parcel.readParcelable(DocumentEducationalViewData.class.getClassLoader()), DocumentViewData.CREATOR.createFromParcel(parcel), CaptureObjectiveTypeViewData.CREATOR.createFromParcel(parcel), DoNotHaveDocumentsViewData.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentEducationalViewData[] newArray(int i) {
            return new DocumentEducationalViewData[i];
        }
    }

    public DocumentEducationalViewData(CompoundTextResource title, CompoundTextResource message, List<Integer> list, int i, MediaResource mediaResource, DocumentViewData documentViewData, CaptureObjectiveTypeViewData objective, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(documentViewData, "documentViewData");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(doNotHaveDocumentsViewData, "doNotHaveDocumentsViewData");
        this.title = title;
        this.message = message;
        this.requirements = list;
        this.ctaText = i;
        this.mediaResource = mediaResource;
        this.documentViewData = documentViewData;
        this.objective = objective;
        this.doNotHaveDocumentsViewData = doNotHaveDocumentsViewData;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CompoundTextResource getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CompoundTextResource getMessage() {
        return this.message;
    }

    public final List<Integer> component3() {
        return this.requirements;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCtaText() {
        return this.ctaText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MediaResource getMediaResource() {
        return this.mediaResource;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DocumentViewData getDocumentViewData() {
        return this.documentViewData;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final CaptureObjectiveTypeViewData getObjective() {
        return this.objective;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DoNotHaveDocumentsViewData getDoNotHaveDocumentsViewData() {
        return this.doNotHaveDocumentsViewData;
    }

    public final DocumentEducationalViewData copy(CompoundTextResource title, CompoundTextResource message, List<Integer> requirements, int ctaText, MediaResource mediaResource, DocumentViewData documentViewData, CaptureObjectiveTypeViewData objective, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(documentViewData, "documentViewData");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(doNotHaveDocumentsViewData, "doNotHaveDocumentsViewData");
        return new DocumentEducationalViewData(title, message, requirements, ctaText, mediaResource, documentViewData, objective, doNotHaveDocumentsViewData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentEducationalViewData)) {
            return false;
        }
        DocumentEducationalViewData documentEducationalViewData = (DocumentEducationalViewData) other;
        return Intrinsics.areEqual(this.title, documentEducationalViewData.title) && Intrinsics.areEqual(this.message, documentEducationalViewData.message) && Intrinsics.areEqual(this.requirements, documentEducationalViewData.requirements) && this.ctaText == documentEducationalViewData.ctaText && Intrinsics.areEqual(this.mediaResource, documentEducationalViewData.mediaResource) && Intrinsics.areEqual(this.documentViewData, documentEducationalViewData.documentViewData) && this.objective == documentEducationalViewData.objective && Intrinsics.areEqual(this.doNotHaveDocumentsViewData, documentEducationalViewData.doNotHaveDocumentsViewData);
    }

    public final int getCtaText() {
        return this.ctaText;
    }

    public final DoNotHaveDocumentsViewData getDoNotHaveDocumentsViewData() {
        return this.doNotHaveDocumentsViewData;
    }

    public final DocumentViewData getDocumentViewData() {
        return this.documentViewData;
    }

    public final MediaResource getMediaResource() {
        return this.mediaResource;
    }

    public final CompoundTextResource getMessage() {
        return this.message;
    }

    public final CaptureObjectiveTypeViewData getObjective() {
        return this.objective;
    }

    public final List<Integer> getRequirements() {
        return this.requirements;
    }

    public final CompoundTextResource getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((this.title.hashCode() * 31) + this.message.hashCode()) * 31;
        List<Integer> list = this.requirements;
        int iHashCode2 = (((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.ctaText)) * 31;
        MediaResource mediaResource = this.mediaResource;
        return ((((((iHashCode2 + (mediaResource != null ? mediaResource.hashCode() : 0)) * 31) + this.documentViewData.hashCode()) * 31) + this.objective.hashCode()) * 31) + this.doNotHaveDocumentsViewData.hashCode();
    }

    public String toString() {
        return "DocumentEducationalViewData(title=" + this.title + ", message=" + this.message + ", requirements=" + this.requirements + ", ctaText=" + this.ctaText + ", mediaResource=" + this.mediaResource + ", documentViewData=" + this.documentViewData + ", objective=" + this.objective + ", doNotHaveDocumentsViewData=" + this.doNotHaveDocumentsViewData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.title, flags);
        parcel.writeParcelable(this.message, flags);
        List<Integer> list = this.requirements;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                parcel.writeInt(it2.next().intValue());
            }
        }
        parcel.writeInt(this.ctaText);
        parcel.writeParcelable(this.mediaResource, flags);
        this.documentViewData.writeToParcel(parcel, flags);
        this.objective.writeToParcel(parcel, flags);
        this.doNotHaveDocumentsViewData.writeToParcel(parcel, flags);
    }

    public /* synthetic */ DocumentEducationalViewData(CompoundTextResource compoundTextResource, CompoundTextResource compoundTextResource2, List list, int i, MediaResource mediaResource, DocumentViewData documentViewData, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(compoundTextResource, compoundTextResource2, (i2 & 4) != 0 ? null : list, i, (i2 & 16) != 0 ? null : mediaResource, documentViewData, captureObjectiveTypeViewData, doNotHaveDocumentsViewData);
    }
}
