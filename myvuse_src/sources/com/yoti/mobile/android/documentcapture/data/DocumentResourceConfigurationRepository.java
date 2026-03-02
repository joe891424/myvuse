package com.yoti.mobile.android.documentcapture.data;

import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentResourceConfigurationToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/DocumentResourceConfigurationRepository;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationRepository;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "resourceConfigurationDataSource", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;", "resourceMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentResourceConfigurationToEntityMapper;", "errorMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentResourceConfigurationToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;)V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentResourceConfigurationRepository extends ResourceConfigurationRepository<DocumentResourceConfigEntity> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DocumentResourceConfigurationRepository(IResourceConfigurationCacheDataStore resourceConfigurationDataSource, DocumentResourceConfigurationToEntityMapper resourceMapper, DataExceptionToEntityMapper errorMapper) {
        super(resourceConfigurationDataSource, resourceMapper, errorMapper);
        Intrinsics.checkNotNullParameter(resourceConfigurationDataSource, "resourceConfigurationDataSource");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(errorMapper, "errorMapper");
    }
}
