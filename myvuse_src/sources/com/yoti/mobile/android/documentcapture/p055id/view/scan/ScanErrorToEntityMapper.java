package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentScanError;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanErrorToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "()V", "map", "from", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class ScanErrorToEntityMapper implements Mapper<Throwable, Throwable> {
    @Inject
    public ScanErrorToEntityMapper() {
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public Throwable map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return from instanceof DocumentCaptureException.ScanResultConversionException ? new IdDocumentScanError.ScanResultConversionError(from) : new IdDocumentScanError.UnexpectedScanError(from);
    }
}
