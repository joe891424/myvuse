package com.yoti.mobile.android.yotisdkcore.core.data;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.extension.SingleKt;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.domain.IResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationRepository;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/IResourceConfigurationRepository;", "resourceConfigurationDataSource", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;", "resourceMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "errorMapper", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;Lcom/yoti/mobile/android/yotidocs/common/Mapper;Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;)V", "getResourceConfiguration", "Lio/reactivex/Single;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class ResourceConfigurationRepository<T extends ResourceConfigurationEntity> implements IResourceConfigurationRepository<T> {
    private final RemoteExceptionToEntityMapper errorMapper;
    private final IResourceConfigurationCacheDataStore resourceConfigurationDataSource;
    private final Mapper<ResourceConfiguration, T> resourceMapper;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceConfigurationRepository(IResourceConfigurationCacheDataStore resourceConfigurationDataSource, Mapper<? super ResourceConfiguration, ? extends T> resourceMapper, RemoteExceptionToEntityMapper errorMapper) {
        Intrinsics.checkNotNullParameter(resourceConfigurationDataSource, "resourceConfigurationDataSource");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(errorMapper, "errorMapper");
        this.resourceConfigurationDataSource = resourceConfigurationDataSource;
        this.resourceMapper = resourceMapper;
        this.errorMapper = errorMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getResourceConfiguration$lambda-0, reason: not valid java name */
    public static final ResourceConfigurationEntity m6903getResourceConfiguration$lambda0(ResourceConfigurationRepository this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.resourceMapper.map(this$0.resourceConfigurationDataSource.getResourceConfiguration());
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.IResourceConfigurationRepository
    public Single<T> getResourceConfiguration() {
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ResourceConfigurationRepository.m6903getResourceConfiguration$lambda0(this.f$0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(singleFromCallable, "fromCallable {\n        v…ourceConfiguration)\n    }");
        return SingleKt.onErrorMapToErrorEntity(singleFromCallable, this.errorMapper);
    }
}
