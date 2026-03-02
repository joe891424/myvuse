package com.yoti.mobile.android.yotisdkcore.core.p085di;

import android.content.Context;
import android.content.SharedPreferences;
import com.yoti.mobile.android.yotisdkcore.core.data.cache.CacheDefsKt;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/di/ConfigurationPreferencesModule;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "providesConfigurationPreferences", "Landroid/content/SharedPreferences;", "providesConfigurationPreferences$yoti_sdk_core_productionRelease", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class ConfigurationPreferencesModule {
    private final Context applicationContext;

    public ConfigurationPreferencesModule(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    @Provides
    @Singleton
    @ConfigurationPreferences
    public final SharedPreferences providesConfigurationPreferences$yoti_sdk_core_productionRelease() {
        SharedPreferences sharedPreferences = this.applicationContext.getSharedPreferences(CacheDefsKt.PREFS_SESSION_CONFIGURATION, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "applicationContext.getSh…ODE_PRIVATE\n            )");
        return sharedPreferences;
    }
}
