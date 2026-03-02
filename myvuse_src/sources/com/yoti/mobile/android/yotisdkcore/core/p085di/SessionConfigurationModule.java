package com.yoti.mobile.android.yotisdkcore.core.p085di;

import android.content.Context;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.SessionConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.ISessionConfigurationCacheDataStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/di/SessionConfigurationModule;", "Lcom/yoti/mobile/android/yotisdkcore/core/di/ConfigurationPreferencesModule;", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "providesSessionConfigurationDataStore", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/ISessionConfigurationCacheDataStore;", "dataStore", "Lcom/yoti/mobile/android/yotisdkcore/core/data/cache/SessionConfigurationCacheDataStore;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public final class SessionConfigurationModule extends ConfigurationPreferencesModule {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionConfigurationModule(Context applicationContext) {
        super(applicationContext);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
    }

    @Provides
    @Singleton
    public final ISessionConfigurationCacheDataStore providesSessionConfigurationDataStore(SessionConfigurationCacheDataStore dataStore) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        return dataStore;
    }
}
