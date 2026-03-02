package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u001d\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000eHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003Ji\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\t\u0010+\u001a\u00020\fHÖ\u0001J\u0013\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\fHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\fHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00066"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "resourceId", "", "countryIso3Code", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "ocrRequired", "", "nfcAvailable", "mrtdCaptureResult", "", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "scanResults", "", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;ZZLjava/util/Map;Ljava/util/List;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "getMrtdCaptureResult", "()Ljava/util/Map;", "setMrtdCaptureResult", "(Ljava/util/Map;)V", "getNfcAvailable", "()Z", "getOcrRequired", "getResourceId", "getScanResults", "()Ljava/util/List;", "setScanResults", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentScanResultViewData implements IDocumentViewData {
    public static final Parcelable.Creator<DocumentScanResultViewData> CREATOR = new Creator();
    private final String countryIso3Code;
    private final DocumentTypeViewData documentType;
    private Map<Integer, byte[]> mrtdCaptureResult;
    private final boolean nfcAvailable;
    private final boolean ocrRequired;
    private final String resourceId;
    private List<DocumentCaptureResult> scanResults;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentScanResultViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentScanResultViewData createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            DocumentTypeViewData documentTypeViewData = (DocumentTypeViewData) parcel.readParcelable(DocumentScanResultViewData.class.getClassLoader());
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i = parcel.readInt();
                linkedHashMap = new LinkedHashMap(i);
                for (int i2 = 0; i2 != i; i2++) {
                    linkedHashMap.put(Integer.valueOf(parcel.readInt()), parcel.createByteArray());
                }
            }
            int i3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList.add(parcel.readParcelable(DocumentScanResultViewData.class.getClassLoader()));
            }
            return new DocumentScanResultViewData(string, string2, documentTypeViewData, z, z2, linkedHashMap, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentScanResultViewData[] newArray(int i) {
            return new DocumentScanResultViewData[i];
        }
    }

    public DocumentScanResultViewData(String resourceId, String countryIso3Code, DocumentTypeViewData documentType, boolean z, boolean z2, Map<Integer, byte[]> map, List<DocumentCaptureResult> scanResults) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(scanResults, "scanResults");
        this.resourceId = resourceId;
        this.countryIso3Code = countryIso3Code;
        this.documentType = documentType;
        this.ocrRequired = z;
        this.nfcAvailable = z2;
        this.mrtdCaptureResult = map;
        this.scanResults = scanResults;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentScanResultViewData copy$default(DocumentScanResultViewData documentScanResultViewData, String str, String str2, DocumentTypeViewData documentTypeViewData, boolean z, boolean z2, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentScanResultViewData.getResourceId();
        }
        if ((i & 2) != 0) {
            str2 = documentScanResultViewData.getCountryIso3Code();
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            documentTypeViewData = documentScanResultViewData.getDocumentType();
        }
        DocumentTypeViewData documentTypeViewData2 = documentTypeViewData;
        if ((i & 8) != 0) {
            z = documentScanResultViewData.ocrRequired;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = documentScanResultViewData.nfcAvailable;
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            map = documentScanResultViewData.mrtdCaptureResult;
        }
        Map map2 = map;
        if ((i & 64) != 0) {
            list = documentScanResultViewData.scanResults;
        }
        return documentScanResultViewData.copy(str, str3, documentTypeViewData2, z3, z4, map2, list);
    }

    public final String component1() {
        return getResourceId();
    }

    public final String component2() {
        return getCountryIso3Code();
    }

    public final DocumentTypeViewData component3() {
        return getDocumentType();
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getNfcAvailable() {
        return this.nfcAvailable;
    }

    public final Map<Integer, byte[]> component6() {
        return this.mrtdCaptureResult;
    }

    public final List<DocumentCaptureResult> component7() {
        return this.scanResults;
    }

    public final DocumentScanResultViewData copy(String resourceId, String countryIso3Code, DocumentTypeViewData documentType, boolean ocrRequired, boolean nfcAvailable, Map<Integer, byte[]> mrtdCaptureResult, List<DocumentCaptureResult> scanResults) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(scanResults, "scanResults");
        return new DocumentScanResultViewData(resourceId, countryIso3Code, documentType, ocrRequired, nfcAvailable, mrtdCaptureResult, scanResults);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentScanResultViewData)) {
            return false;
        }
        DocumentScanResultViewData documentScanResultViewData = (DocumentScanResultViewData) other;
        return Intrinsics.areEqual(getResourceId(), documentScanResultViewData.getResourceId()) && Intrinsics.areEqual(getCountryIso3Code(), documentScanResultViewData.getCountryIso3Code()) && getDocumentType() == documentScanResultViewData.getDocumentType() && this.ocrRequired == documentScanResultViewData.ocrRequired && this.nfcAvailable == documentScanResultViewData.nfcAvailable && Intrinsics.areEqual(this.mrtdCaptureResult, documentScanResultViewData.mrtdCaptureResult) && Intrinsics.areEqual(this.scanResults, documentScanResultViewData.scanResults);
    }

    @Override // com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData
    public String getCountryIso3Code() {
        return this.countryIso3Code;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData
    public DocumentTypeViewData getDocumentType() {
        return this.documentType;
    }

    public final Map<Integer, byte[]> getMrtdCaptureResult() {
        return this.mrtdCaptureResult;
    }

    public final boolean getNfcAvailable() {
        return this.nfcAvailable;
    }

    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData
    public String getResourceId() {
        return this.resourceId;
    }

    public final List<DocumentCaptureResult> getScanResults() {
        return this.scanResults;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((getResourceId().hashCode() * 31) + getCountryIso3Code().hashCode()) * 31) + getDocumentType().hashCode()) * 31;
        boolean z = this.ocrRequired;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.nfcAvailable;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        Map<Integer, byte[]> map = this.mrtdCaptureResult;
        return ((i2 + (map == null ? 0 : map.hashCode())) * 31) + this.scanResults.hashCode();
    }

    public final void setMrtdCaptureResult(Map<Integer, byte[]> map) {
        this.mrtdCaptureResult = map;
    }

    public final void setScanResults(List<DocumentCaptureResult> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.scanResults = list;
    }

    public String toString() {
        return "DocumentScanResultViewData(resourceId=" + getResourceId() + ", countryIso3Code=" + getCountryIso3Code() + ", documentType=" + getDocumentType() + ", ocrRequired=" + this.ocrRequired + ", nfcAvailable=" + this.nfcAvailable + ", mrtdCaptureResult=" + this.mrtdCaptureResult + ", scanResults=" + this.scanResults + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.resourceId);
        parcel.writeString(this.countryIso3Code);
        parcel.writeParcelable(this.documentType, flags);
        parcel.writeInt(this.ocrRequired ? 1 : 0);
        parcel.writeInt(this.nfcAvailable ? 1 : 0);
        Map<Integer, byte[]> map = this.mrtdCaptureResult;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<Integer, byte[]> entry : map.entrySet()) {
                parcel.writeInt(entry.getKey().intValue());
                parcel.writeByteArray(entry.getValue());
            }
        }
        List<DocumentCaptureResult> list = this.scanResults;
        parcel.writeInt(list.size());
        Iterator<DocumentCaptureResult> it2 = list.iterator();
        while (it2.hasNext()) {
            parcel.writeParcelable(it2.next(), flags);
        }
    }
}
