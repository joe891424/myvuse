package com.yoti.mobile.android.yotisdkcore.core.p085di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class ResourceConfigurationModule_ProvidesRequirementIdFactory implements Factory<String> {
    private final ResourceConfigurationModule module;

    public ResourceConfigurationModule_ProvidesRequirementIdFactory(ResourceConfigurationModule resourceConfigurationModule) {
        this.module = resourceConfigurationModule;
    }

    public static ResourceConfigurationModule_ProvidesRequirementIdFactory create(ResourceConfigurationModule resourceConfigurationModule) {
        return new ResourceConfigurationModule_ProvidesRequirementIdFactory(resourceConfigurationModule);
    }

    public static String providesRequirementId(ResourceConfigurationModule resourceConfigurationModule) {
        return (String) Preconditions.checkNotNullFromProvides(resourceConfigurationModule.getRequirementId());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesRequirementId(this.module);
    }
}
