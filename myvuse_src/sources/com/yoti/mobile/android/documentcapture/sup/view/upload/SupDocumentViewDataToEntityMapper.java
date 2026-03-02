package com.yoti.mobile.android.documentcapture.sup.view.upload;

import android.net.Uri;
import com.yoti.mobile.android.documentcapture.domain.model.CaptureMethodTypeEntity;
import com.yoti.mobile.android.documentcapture.domain.model.DocumentResourceInfoEntity;
import com.yoti.mobile.android.documentcapture.sup.domain.model.SupplementaryDocumentEntity;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentFileProvider;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/upload/SupDocumentViewDataToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupplementaryDocumentEntity;", "documentTypeViewDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;", "fileProvider", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentFileProvider;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentFileProvider;)V", "map", "from", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapCaptureMethod", "Lcom/yoti/mobile/android/documentcapture/domain/model/CaptureMethodTypeEntity;", "uri", "Landroid/net/Uri;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentViewDataToEntityMapper implements SuspendMapper<SupplementaryDocumentViewData, SupplementaryDocumentEntity> {
    private final DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper;
    private final SupDocumentFileProvider fileProvider;

    @Inject
    public SupDocumentViewDataToEntityMapper(DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper, SupDocumentFileProvider fileProvider) {
        Intrinsics.checkNotNullParameter(documentTypeViewDataToEntityMapper, "documentTypeViewDataToEntityMapper");
        Intrinsics.checkNotNullParameter(fileProvider, "fileProvider");
        this.documentTypeViewDataToEntityMapper = documentTypeViewDataToEntityMapper;
        this.fileProvider = fileProvider;
    }

    private final CaptureMethodTypeEntity mapCaptureMethod(Uri uri) {
        return this.fileProvider.isSupDocumentFileUri(uri) ? CaptureMethodTypeEntity.CAMERA : CaptureMethodTypeEntity.UPLOAD;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.SuspendMapper
    public Object map(SupplementaryDocumentViewData supplementaryDocumentViewData, Continuation<? super SupplementaryDocumentEntity> continuation) {
        return new SupplementaryDocumentEntity(new DocumentResourceInfoEntity(supplementaryDocumentViewData.getResourceId(), this.documentTypeViewDataToEntityMapper.map(supplementaryDocumentViewData.getDocumentType()), supplementaryDocumentViewData.getCountryIso3Code()), supplementaryDocumentViewData.getFilePath(), mapCaptureMethod(supplementaryDocumentViewData.getFilePath()));
    }
}
