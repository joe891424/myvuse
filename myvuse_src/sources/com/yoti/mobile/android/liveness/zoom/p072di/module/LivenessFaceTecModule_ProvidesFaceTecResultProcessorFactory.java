package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecResultProcessor;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecResultProcessor;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecResultProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecModule_ProvidesFaceTecResultProcessorFactory implements Factory<IFaceTecResultProcessor> {
    private final Provider<AutomationFaceTecResultProcessor> automationProcessorProvider;
    private final LivenessFaceTecModule module;
    private final Provider<FaceTecResultProcessor> processorProvider;

    public LivenessFaceTecModule_ProvidesFaceTecResultProcessorFactory(LivenessFaceTecModule livenessFaceTecModule, Provider<FaceTecResultProcessor> provider, Provider<AutomationFaceTecResultProcessor> provider2) {
        this.module = livenessFaceTecModule;
        this.processorProvider = provider;
        this.automationProcessorProvider = provider2;
    }

    public static LivenessFaceTecModule_ProvidesFaceTecResultProcessorFactory create(LivenessFaceTecModule livenessFaceTecModule, Provider<FaceTecResultProcessor> provider, Provider<AutomationFaceTecResultProcessor> provider2) {
        return new LivenessFaceTecModule_ProvidesFaceTecResultProcessorFactory(livenessFaceTecModule, provider, provider2);
    }

    public static IFaceTecResultProcessor providesFaceTecResultProcessor(LivenessFaceTecModule livenessFaceTecModule, FaceTecResultProcessor faceTecResultProcessor, AutomationFaceTecResultProcessor automationFaceTecResultProcessor) {
        return (IFaceTecResultProcessor) Preconditions.checkNotNullFromProvides(livenessFaceTecModule.providesFaceTecResultProcessor(faceTecResultProcessor, automationFaceTecResultProcessor));
    }

    @Override // javax.inject.Provider
    public IFaceTecResultProcessor get() {
        return providesFaceTecResultProcessor(this.module, this.processorProvider.get(), this.automationProcessorProvider.get());
    }
}
