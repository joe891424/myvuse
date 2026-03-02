package com.yoti.mobile.android.facecapture.p070di.module;

import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.capture.IFaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureModule_ProvidesFaceCaptureStateMachineFactoryFactory implements Factory<IFaceCaptureStateMachineFactory> {
    private final Provider<AutomationFaceCaptureStateMachineFactory> automationStateMachineFactoryProvider;
    private final FaceCaptureModule module;
    private final Provider<FaceCaptureStateMachineFactory> stateMachineFactoryProvider;

    public FaceCaptureModule_ProvidesFaceCaptureStateMachineFactoryFactory(FaceCaptureModule faceCaptureModule, Provider<FaceCaptureStateMachineFactory> provider, Provider<AutomationFaceCaptureStateMachineFactory> provider2) {
        this.module = faceCaptureModule;
        this.stateMachineFactoryProvider = provider;
        this.automationStateMachineFactoryProvider = provider2;
    }

    public static FaceCaptureModule_ProvidesFaceCaptureStateMachineFactoryFactory create(FaceCaptureModule faceCaptureModule, Provider<FaceCaptureStateMachineFactory> provider, Provider<AutomationFaceCaptureStateMachineFactory> provider2) {
        return new FaceCaptureModule_ProvidesFaceCaptureStateMachineFactoryFactory(faceCaptureModule, provider, provider2);
    }

    public static IFaceCaptureStateMachineFactory providesFaceCaptureStateMachineFactory(FaceCaptureModule faceCaptureModule, FaceCaptureStateMachineFactory faceCaptureStateMachineFactory, AutomationFaceCaptureStateMachineFactory automationFaceCaptureStateMachineFactory) {
        return (IFaceCaptureStateMachineFactory) Preconditions.checkNotNullFromProvides(faceCaptureModule.providesFaceCaptureStateMachineFactory(faceCaptureStateMachineFactory, automationFaceCaptureStateMachineFactory));
    }

    @Override // javax.inject.Provider
    public IFaceCaptureStateMachineFactory get() {
        return providesFaceCaptureStateMachineFactory(this.module, this.stateMachineFactoryProvider.get(), this.automationStateMachineFactoryProvider.get());
    }
}
