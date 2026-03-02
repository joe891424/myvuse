package com.yoti.mobile.android.documentcapture.sup.data;

import com.yoti.mobile.android.documentcapture.data.remote.model.CaptureMethodType;
import com.yoti.mobile.android.documentcapture.data.remote.model.DocumentResourceInfo;
import com.yoti.mobile.android.documentcapture.data.remote.model.PageInfo;
import com.yoti.mobile.android.documentcapture.domain.model.CaptureMethodTypeEntity;
import com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupplementaryDocument;
import com.yoti.mobile.android.documentcapture.sup.domain.model.SupplementaryDocumentEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentEntityToDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupplementaryDocumentEntity;", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/SupplementaryDocument;", "documentTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;)V", "map", "from", "mapCaptureMethodType", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/CaptureMethodType;", "document", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentEntityToDataMapper implements Mapper<SupplementaryDocumentEntity, SupplementaryDocument> {
    private final DocumentTypeEntityToDataMapper documentTypeMapper;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CaptureMethodTypeEntity.values().length];
            iArr[CaptureMethodTypeEntity.UPLOAD.ordinal()] = 1;
            iArr[CaptureMethodTypeEntity.CAMERA.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public SupDocumentEntityToDataMapper(DocumentTypeEntityToDataMapper documentTypeMapper) {
        Intrinsics.checkNotNullParameter(documentTypeMapper, "documentTypeMapper");
        this.documentTypeMapper = documentTypeMapper;
    }

    private final CaptureMethodType mapCaptureMethodType(SupplementaryDocumentEntity document) {
        int i = WhenMappings.$EnumSwitchMapping$0[document.getCaptureMethod().ordinal()];
        if (i == 1) {
            return CaptureMethodType.UPLOAD;
        }
        if (i == 2) {
            return CaptureMethodType.CAMERA;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public SupplementaryDocument map(SupplementaryDocumentEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new SupplementaryDocument(new DocumentResourceInfo(from.getResourceInfo().getId(), this.documentTypeMapper.map(from.getResourceInfo().getDocumentType()), from.getResourceInfo().getCountryIso3Code()), from.getDocument(), new PageInfo(mapCaptureMethodType(from), null, null, 6, null), null, 8, null);
    }
}
