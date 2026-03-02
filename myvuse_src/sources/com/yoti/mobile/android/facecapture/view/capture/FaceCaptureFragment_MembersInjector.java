package com.yoti.mobile.android.facecapture.view.capture;

import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.facecapture.view.capture.util.CaptureConfigurationProvider;
import com.yoti.mobile.android.facecapture.view.capture.util.LightSensor;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureFragment_MembersInjector implements MembersInjector<FaceCaptureFragment> {
    private final Provider<CaptureConfigurationProvider> configProvider;
    private final Provider<LightSensor> lightSensorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public FaceCaptureFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<CaptureConfigurationProvider> provider2, Provider<LightSensor> provider3) {
        this.viewModelFactoryProvider = provider;
        this.configProvider = provider2;
        this.lightSensorProvider = provider3;
    }

    public static MembersInjector<FaceCaptureFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<CaptureConfigurationProvider> provider2, Provider<LightSensor> provider3) {
        return new FaceCaptureFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectConfigProvider(FaceCaptureFragment faceCaptureFragment, CaptureConfigurationProvider captureConfigurationProvider) {
        faceCaptureFragment.configProvider = captureConfigurationProvider;
    }

    public static void injectLightSensor(FaceCaptureFragment faceCaptureFragment, LightSensor lightSensor) {
        faceCaptureFragment.lightSensor = lightSensor;
    }

    public static void injectViewModelFactory(FaceCaptureFragment faceCaptureFragment, ViewModelProvider.Factory factory) {
        faceCaptureFragment.viewModelFactory = factory;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FaceCaptureFragment faceCaptureFragment) {
        injectViewModelFactory(faceCaptureFragment, this.viewModelFactoryProvider.get());
        injectConfigProvider(faceCaptureFragment, this.configProvider.get());
        injectLightSensor(faceCaptureFragment, this.lightSensorProvider.get());
    }
}
