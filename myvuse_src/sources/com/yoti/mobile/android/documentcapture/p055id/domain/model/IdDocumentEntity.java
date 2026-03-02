package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import com.yoti.mobile.android.documentcapture.domain.model.DocumentPageEntity;
import com.yoti.mobile.android.documentcapture.domain.model.DocumentResourceInfoEntity;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0004\u0018\u0001`\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÂ\u0003J\u001d\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0004\u0018\u0001`\u0010HÆ\u0003Ja\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0004\u0018\u0001`\u0010HÆ\u0001J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000eHÖ\u0001J\u0006\u0010)\u001a\u00020\bJ\t\u0010*\u001a\u00020+HÖ\u0001R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0004\u0018\u0001`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentEntity;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;", "resourceInfo", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentResourceInfoEntity;", "pages", "", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentPageEntity;", "ocrRequired", "", "nfcAvailable", "_ocrData", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultEntity;", "chipData", "", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "(Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentResourceInfoEntity;Ljava/util/List;ZZLcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultEntity;Ljava/util/Map;)V", "getChipData", "()Ljava/util/Map;", "getNfcAvailable", "()Z", "ocrData", "getOcrData", "()Lcom/yoti/mobile/android/documentcapture/id/domain/model/OcrResultEntity;", "getOcrRequired", "getPages", "()Ljava/util/List;", "getResourceInfo", "()Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentResourceInfoEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "isOcrDataValidForNfcRead", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class IdDocumentEntity implements IDocumentEntity {
    private final OcrResultEntity _ocrData;
    private final Map<Integer, byte[]> chipData;
    private final boolean nfcAvailable;
    private final OcrResultEntity ocrData;
    private final boolean ocrRequired;
    private final List<DocumentPageEntity> pages;
    private final DocumentResourceInfoEntity resourceInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public IdDocumentEntity(DocumentResourceInfoEntity resourceInfo, List<DocumentPageEntity> pages, boolean z, boolean z2, OcrResultEntity ocrResultEntity, Map<Integer, byte[]> map) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.resourceInfo = resourceInfo;
        this.pages = pages;
        this.ocrRequired = z;
        this.nfcAvailable = z2;
        this._ocrData = ocrResultEntity;
        this.chipData = map;
        DocumentFieldsEntity documentFieldsEntity = null;
        Object[] objArr = 0;
        if (!z) {
            ocrResultEntity = null;
        } else if (ocrResultEntity == null) {
            ocrResultEntity = new OcrResultEntity(new OcrOriginEntity(getResourceInfo().getDocumentType(), getResourceInfo().getCountryIso3Code()), documentFieldsEntity, 2, objArr == true ? 1 : 0);
        }
        this.ocrData = ocrResultEntity;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final OcrResultEntity get_ocrData() {
        return this._ocrData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IdDocumentEntity copy$default(IdDocumentEntity idDocumentEntity, DocumentResourceInfoEntity documentResourceInfoEntity, List list, boolean z, boolean z2, OcrResultEntity ocrResultEntity, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            documentResourceInfoEntity = idDocumentEntity.getResourceInfo();
        }
        if ((i & 2) != 0) {
            list = idDocumentEntity.pages;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            z = idDocumentEntity.ocrRequired;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = idDocumentEntity.nfcAvailable;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            ocrResultEntity = idDocumentEntity._ocrData;
        }
        OcrResultEntity ocrResultEntity2 = ocrResultEntity;
        if ((i & 32) != 0) {
            map = idDocumentEntity.chipData;
        }
        return idDocumentEntity.copy(documentResourceInfoEntity, list2, z3, z4, ocrResultEntity2, map);
    }

    public final DocumentResourceInfoEntity component1() {
        return getResourceInfo();
    }

    public final List<DocumentPageEntity> component2() {
        return this.pages;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getNfcAvailable() {
        return this.nfcAvailable;
    }

    public final Map<Integer, byte[]> component6() {
        return this.chipData;
    }

    public final IdDocumentEntity copy(DocumentResourceInfoEntity resourceInfo, List<DocumentPageEntity> pages, boolean ocrRequired, boolean nfcAvailable, OcrResultEntity _ocrData, Map<Integer, byte[]> chipData) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        Intrinsics.checkNotNullParameter(pages, "pages");
        return new IdDocumentEntity(resourceInfo, pages, ocrRequired, nfcAvailable, _ocrData, chipData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdDocumentEntity)) {
            return false;
        }
        IdDocumentEntity idDocumentEntity = (IdDocumentEntity) other;
        return Intrinsics.areEqual(getResourceInfo(), idDocumentEntity.getResourceInfo()) && Intrinsics.areEqual(this.pages, idDocumentEntity.pages) && this.ocrRequired == idDocumentEntity.ocrRequired && this.nfcAvailable == idDocumentEntity.nfcAvailable && Intrinsics.areEqual(this._ocrData, idDocumentEntity._ocrData) && Intrinsics.areEqual(this.chipData, idDocumentEntity.chipData);
    }

    public final Map<Integer, byte[]> getChipData() {
        return this.chipData;
    }

    public final boolean getNfcAvailable() {
        return this.nfcAvailable;
    }

    public final OcrResultEntity getOcrData() {
        return this.ocrData;
    }

    public final boolean getOcrRequired() {
        return this.ocrRequired;
    }

    public final List<DocumentPageEntity> getPages() {
        return this.pages;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity
    public DocumentResourceInfoEntity getResourceInfo() {
        return this.resourceInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        int iHashCode = ((getResourceInfo().hashCode() * 31) + this.pages.hashCode()) * 31;
        boolean z = this.ocrRequired;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.nfcAvailable;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        OcrResultEntity ocrResultEntity = this._ocrData;
        int iHashCode2 = (i2 + (ocrResultEntity == null ? 0 : ocrResultEntity.hashCode())) * 31;
        Map<Integer, byte[]> map = this.chipData;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isOcrDataValidForNfcRead() {
        DocumentFieldsEntity documentFields;
        OcrResultEntity ocrResultEntity = this._ocrData;
        if (ocrResultEntity != null && (documentFields = ocrResultEntity.getDocumentFields()) != null) {
            HolderEntity holder = documentFields.getHolder();
            if ((holder != null ? holder.getDateOfBirth() : null) != null && documentFields.getDocumentNumber() != null && documentFields.getExpiryDate() != null) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "IdDocumentEntity(resourceInfo=" + getResourceInfo() + ", pages=" + this.pages + ", ocrRequired=" + this.ocrRequired + ", nfcAvailable=" + this.nfcAvailable + ", _ocrData=" + this._ocrData + ", chipData=" + this.chipData + ')';
    }

    public /* synthetic */ IdDocumentEntity(DocumentResourceInfoEntity documentResourceInfoEntity, List list, boolean z, boolean z2, OcrResultEntity ocrResultEntity, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(documentResourceInfoEntity, list, z, z2, (i & 16) != 0 ? null : ocrResultEntity, (i & 32) != 0 ? null : map);
    }
}
