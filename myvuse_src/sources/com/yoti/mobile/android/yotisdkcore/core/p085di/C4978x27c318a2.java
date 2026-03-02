package com.yoti.mobile.android.yotisdkcore.core.p085di;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.di.ConfigurationPreferencesModule_ProvidesConfigurationPreferences$yoti_sdk_core_productionReleaseFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C4978x27c318a2 implements Factory<SharedPreferences> {
    private final ConfigurationPreferencesModule module;

    public C4978x27c318a2(ConfigurationPreferencesModule configurationPreferencesModule) {
        this.module = configurationPreferencesModule;
    }

    public static C4978x27c318a2 create(ConfigurationPreferencesModule configurationPreferencesModule) {
        return new C4978x27c318a2(configurationPreferencesModule);
    }

    public static SharedPreferences providesConfigurationPreferences$yoti_sdk_core_productionRelease(ConfigurationPreferencesModule configurationPreferencesModule) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(configurationPreferencesModule.providesConfigurationPreferences$yoti_sdk_core_productionRelease());
    }

    @Override // javax.inject.Provider
    public SharedPreferences get() {
        return providesConfigurationPreferences$yoti_sdk_core_productionRelease(this.module);
    }
}
