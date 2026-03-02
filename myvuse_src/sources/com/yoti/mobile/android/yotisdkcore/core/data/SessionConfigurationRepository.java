package com.yoti.mobile.android.yotisdkcore.core.data;

import com.yoti.mobile.android.remote.SingleService;
import com.yoti.mobile.android.yotidocs.common.extension.SingleKt;
import com.yoti.mobile.android.yotisdkcore.core.data.model.SessionConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SessionConfigurationService;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.ISessionConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/SessionConfigurationRepository;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "configurationService", "Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SessionConfigurationService;", "configurationCache", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/ISessionConfigurationCacheDataStore;", "sessionConfigurationDataToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/SessionConfigurationDataToEntityMapper;", "exceptionToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SessionConfigurationService;Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/ISessionConfigurationCacheDataStore;Lcom/yoti/mobile/android/yotisdkcore/core/data/SessionConfigurationDataToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;)V", "clearSessionConfiguration", "", "getSessionConfiguration", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionConfigurationRepository implements ISessionConfigurationRepository {
    private final ISessionConfigurationCacheDataStore configurationCache;
    private final SessionConfigurationService configurationService;
    private final DataExceptionToEntityMapper exceptionToEntityMapper;
    private final SessionConfigurationDataToEntityMapper sessionConfigurationDataToEntityMapper;

    @Inject
    public SessionConfigurationRepository(SessionConfigurationService configurationService, ISessionConfigurationCacheDataStore configurationCache, SessionConfigurationDataToEntityMapper sessionConfigurationDataToEntityMapper, DataExceptionToEntityMapper exceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(configurationService, "configurationService");
        Intrinsics.checkNotNullParameter(configurationCache, "configurationCache");
        Intrinsics.checkNotNullParameter(sessionConfigurationDataToEntityMapper, "sessionConfigurationDataToEntityMapper");
        Intrinsics.checkNotNullParameter(exceptionToEntityMapper, "exceptionToEntityMapper");
        this.configurationService = configurationService;
        this.configurationCache = configurationCache;
        this.sessionConfigurationDataToEntityMapper = sessionConfigurationDataToEntityMapper;
        this.exceptionToEntityMapper = exceptionToEntityMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getSessionConfiguration$lambda-0, reason: not valid java name */
    public static final SessionConfiguration m6905getSessionConfiguration$lambda0(SessionConfigurationRepository this$0, SessionConfiguration it2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it2, "it");
        this$0.configurationCache.deleteConfigurations();
        this$0.configurationCache.saveConfigurations(it2.getResourcesConfiguration());
        return it2;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository
    public void clearSessionConfiguration() {
        this.configurationCache.deleteConfigurations();
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository
    public Single<SessionConfigurationEntity> getSessionConfiguration() {
        Single map = SingleService.execute$default(this.configurationService, null, 1, null).map(new Function() { // from class: com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SessionConfigurationRepository.m6905getSessionConfiguration$lambda0(this.f$0, (SessionConfiguration) obj);
            }
        });
        final SessionConfigurationDataToEntityMapper sessionConfigurationDataToEntityMapper = this.sessionConfigurationDataToEntityMapper;
        Single map2 = map.map(new Function() { // from class: com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return sessionConfigurationDataToEntityMapper.map((SessionConfiguration) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "configurationService\n   …nDataToEntityMapper::map)");
        return SingleKt.onErrorMapToErrorEntity(map2, this.exceptionToEntityMapper);
    }
}
