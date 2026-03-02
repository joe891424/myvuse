package com.yoti.mobile.android.facecapture.view.capture;

import com.yoti.mobile.android.facecapture.view.capture.mapper.ViewEventToStateMachineMapper;
import com.yoti.mobile.android.facecapture.view.capture.util.CaptureConfigurationProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureViewModel_Factory implements Factory<FaceCaptureViewModel> {
    private final Provider<CaptureConfigurationProvider> captureConfigurationProvider;
    private final Provider<CaptureResultProcessor> captureProcessorProvider;
    private final Provider<CoroutineContext> computationContextProvider;
    private final Provider<ViewEventToStateMachineMapper> eventMapperProvider;
    private final Provider<IFaceCaptureStateMachineFactory> stateMachineFactoryProvider;

    public FaceCaptureViewModel_Factory(Provider<IFaceCaptureStateMachineFactory> provider, Provider<ViewEventToStateMachineMapper> provider2, Provider<CaptureResultProcessor> provider3, Provider<CaptureConfigurationProvider> provider4, Provider<CoroutineContext> provider5) {
        this.stateMachineFactoryProvider = provider;
        this.eventMapperProvider = provider2;
        this.captureProcessorProvider = provider3;
        this.captureConfigurationProvider = provider4;
        this.computationContextProvider = provider5;
    }

    public static FaceCaptureViewModel_Factory create(Provider<IFaceCaptureStateMachineFactory> provider, Provider<ViewEventToStateMachineMapper> provider2, Provider<CaptureResultProcessor> provider3, Provider<CaptureConfigurationProvider> provider4, Provider<CoroutineContext> provider5) {
        return new FaceCaptureViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FaceCaptureViewModel newInstance(IFaceCaptureStateMachineFactory iFaceCaptureStateMachineFactory, ViewEventToStateMachineMapper viewEventToStateMachineMapper, CaptureResultProcessor captureResultProcessor, CaptureConfigurationProvider captureConfigurationProvider, CoroutineContext coroutineContext) {
        return new FaceCaptureViewModel(iFaceCaptureStateMachineFactory, viewEventToStateMachineMapper, captureResultProcessor, captureConfigurationProvider, coroutineContext);
    }

    @Override // javax.inject.Provider
    public FaceCaptureViewModel get() {
        return newInstance(this.stateMachineFactoryProvider.get(), this.eventMapperProvider.get(), this.captureProcessorProvider.get(), this.captureConfigurationProvider.get(), this.computationContextProvider.get());
    }
}
