package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.TextExtractionException;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/UploadExceptionToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "textExtractionExceptionToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/id/data/TextExtractionExceptionToEntityMapper;", "dataExceptionToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/data/TextExtractionExceptionToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;)V", "map", "from", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class UploadExceptionToEntityMapper implements Mapper<Throwable, YotiDocsError> {
    private final DataExceptionToEntityMapper dataExceptionToEntityMapper;
    private final TextExtractionExceptionToEntityMapper textExtractionExceptionToEntityMapper;

    @Inject
    public UploadExceptionToEntityMapper(TextExtractionExceptionToEntityMapper textExtractionExceptionToEntityMapper, DataExceptionToEntityMapper dataExceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(textExtractionExceptionToEntityMapper, "textExtractionExceptionToEntityMapper");
        Intrinsics.checkNotNullParameter(dataExceptionToEntityMapper, "dataExceptionToEntityMapper");
        this.textExtractionExceptionToEntityMapper = textExtractionExceptionToEntityMapper;
        this.dataExceptionToEntityMapper = dataExceptionToEntityMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public YotiDocsError map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return from instanceof TextExtractionException ? this.textExtractionExceptionToEntityMapper.map((TextExtractionException) from) : this.dataExceptionToEntityMapper.map(from);
    }
}
