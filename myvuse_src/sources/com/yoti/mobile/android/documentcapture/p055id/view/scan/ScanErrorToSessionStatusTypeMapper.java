package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentScanError;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanErrorToSessionStatusTypeMapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "()V", "map", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "from", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ScanErrorToSessionStatusTypeMapper extends ErrorToSessionStatusTypeMapper {
    @Inject
    public ScanErrorToSessionStatusTypeMapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper, com.yoti.mobile.android.yotidocs.common.Mapper
    public SessionStatusType map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return from instanceof IdDocumentScanError.ScanResultConversionError ? SessionStatusType.STORAGE_ERROR : from instanceof IdDocumentScanError.UnexpectedScanError ? SessionStatusType.UNEXPECTED_DOCUMENT_SCANNING_ERROR : super.map(from);
    }
}
