package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializer;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecInitializer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecModule_ProvidesFaceTecInitializerFactory implements Factory<IFaceTecInitializer> {
    private final Provider<AutomationFaceTecInitializer> automationFaceTecInitializerProvider;
    private final Provider<FaceTecInitializer> faceTecInitializerProvider;
    private final LivenessFaceTecModule module;

    public LivenessFaceTecModule_ProvidesFaceTecInitializerFactory(LivenessFaceTecModule livenessFaceTecModule, Provider<FaceTecInitializer> provider, Provider<AutomationFaceTecInitializer> provider2) {
        this.module = livenessFaceTecModule;
        this.faceTecInitializerProvider = provider;
        this.automationFaceTecInitializerProvider = provider2;
    }

    public static LivenessFaceTecModule_ProvidesFaceTecInitializerFactory create(LivenessFaceTecModule livenessFaceTecModule, Provider<FaceTecInitializer> provider, Provider<AutomationFaceTecInitializer> provider2) {
        return new LivenessFaceTecModule_ProvidesFaceTecInitializerFactory(livenessFaceTecModule, provider, provider2);
    }

    public static IFaceTecInitializer providesFaceTecInitializer(LivenessFaceTecModule livenessFaceTecModule, FaceTecInitializer faceTecInitializer, AutomationFaceTecInitializer automationFaceTecInitializer) {
        return (IFaceTecInitializer) Preconditions.checkNotNullFromProvides(livenessFaceTecModule.providesFaceTecInitializer(faceTecInitializer, automationFaceTecInitializer));
    }

    @Override // javax.inject.Provider
    public IFaceTecInitializer get() {
        return providesFaceTecInitializer(this.module, this.faceTecInitializerProvider.get(), this.automationFaceTecInitializerProvider.get());
    }
}
