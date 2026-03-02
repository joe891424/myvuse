package com.yoti.mobile.android.yotisdkcore.core.p085di;

import android.content.Context;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.ResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/di/ResourceConfigurationModule;", "Lcom/yoti/mobile/android/yotisdkcore/core/di/ConfigurationPreferencesModule;", "applicationContext", "Landroid/content/Context;", "requirementId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "providesRequirementId", "providesResourceConfigurationDataStore", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;", "resourceConfigurationDataStore", "Lcom/yoti/mobile/android/yotisdkcore/core/data/cache/ResourceConfigurationCacheDataStore;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class ResourceConfigurationModule extends ConfigurationPreferencesModule {
    private final String requirementId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResourceConfigurationModule(Context applicationContext, String requirementId) {
        super(applicationContext);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        this.requirementId = requirementId;
    }

    @Provides
    @Singleton
    @RequirementId
    /* JADX INFO: renamed from: providesRequirementId, reason: from getter */
    public final String getRequirementId() {
        return this.requirementId;
    }

    @Provides
    @Singleton
    public IResourceConfigurationCacheDataStore providesResourceConfigurationDataStore(ResourceConfigurationCacheDataStore resourceConfigurationDataStore) {
        Intrinsics.checkNotNullParameter(resourceConfigurationDataStore, "resourceConfigurationDataStore");
        return resourceConfigurationDataStore;
    }
}
