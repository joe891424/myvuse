package com.yoti.mobile.android.documentcapture.domain;

import com.yoti.mobile.android.documentcapture.domain.model.DocumentFeatureError;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/DocumentFeatureErrorToSessionStatusTypeMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;)V", "map", "from", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentFeatureErrorToSessionStatusTypeMapper implements Mapper<Throwable, SessionStatusType> {
    private final ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper;

    @Inject
    public DocumentFeatureErrorToSessionStatusTypeMapper(ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public SessionStatusType map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (from instanceof DocumentFeatureError.DocumentResourceConfigError) {
            return this.errorToSessionStatusTypeMapper.map((Throwable) ((DocumentFeatureError.DocumentResourceConfigError) from).getErrorCause());
        }
        if (from instanceof DocumentFeatureError.DocumentScanConfigError) {
            return this.errorToSessionStatusTypeMapper.map((Throwable) ((DocumentFeatureError.DocumentScanConfigError) from).getErrorCause());
        }
        return Intrinsics.areEqual(from, DocumentFeatureError.DocumentNotOwnedError.INSTANCE) ? true : Intrinsics.areEqual(from, DocumentFeatureError.DocumentCountryNotListedError.INSTANCE) ? SessionStatusType.MANDATORY_DOCUMENT_NOT_PROVIDED : this.errorToSessionStatusTypeMapper.map(from);
    }
}
