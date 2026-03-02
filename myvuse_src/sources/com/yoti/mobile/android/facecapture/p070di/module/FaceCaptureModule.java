package com.yoti.mobile.android.facecapture.p070di.module;

import com.yoti.mobile.android.facecapture.p070di.FaceCaptureEducationalDependeciesProvider;
import com.yoti.mobile.android.facecapture.p070di.FaceCaptureUploadDependenciesProvider;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.capture.IFaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.educational.FaceCaptureGuidelinesViewDataFactory;
import com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider;
import com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.p071di.module.LivenessFeatureConfigurationModule;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.SchedulersModule;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/di/module/FaceCaptureModule;", "", "()V", "providesFaceCaptureStateMachineFactory", "Lcom/yoti/mobile/android/facecapture/view/capture/IFaceCaptureStateMachineFactory;", "stateMachineFactory", "Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureStateMachineFactory;", "automationStateMachineFactory", "Lcom/yoti/mobile/android/facecapture/view/capture/automation/AutomationFaceCaptureStateMachineFactory;", "providesLivenessCoreEducationalDependenciesProvider", "Lcom/yoti/mobile/android/liveness/di/ILivenessEducationalDependeciesProvider;", "educationalDependeciesProvider", "Lcom/yoti/mobile/android/facecapture/di/FaceCaptureEducationalDependeciesProvider;", "providesLivenessCoreUploadDependenciesProvider", "Lcom/yoti/mobile/android/liveness/di/ILivenessUploadDependenciesProvider;", "uploadDependenciesProvider", "Lcom/yoti/mobile/android/facecapture/di/FaceCaptureUploadDependenciesProvider;", "providesLivenessGuidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "actual", "Lcom/yoti/mobile/android/facecapture/view/educational/FaceCaptureGuidelinesViewDataFactory;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {ResourceConfigurationModule.class, RemoteModule.class, SchedulersModule.class, CommonModule.class, FaceCaptureViewModelModule.class, FaceCaptureApiServiceModule.class, CoroutineContextModule.class, LivenessFeatureConfigurationModule.class})
public class FaceCaptureModule {
    @Provides
    public IFaceCaptureStateMachineFactory providesFaceCaptureStateMachineFactory(FaceCaptureStateMachineFactory stateMachineFactory, AutomationFaceCaptureStateMachineFactory automationStateMachineFactory) {
        Intrinsics.checkNotNullParameter(stateMachineFactory, "stateMachineFactory");
        Intrinsics.checkNotNullParameter(automationStateMachineFactory, "automationStateMachineFactory");
        return Intrinsics.areEqual("production", "automation") ? automationStateMachineFactory : stateMachineFactory;
    }

    @Provides
    public ILivenessEducationalDependeciesProvider providesLivenessCoreEducationalDependenciesProvider(FaceCaptureEducationalDependeciesProvider educationalDependeciesProvider) {
        Intrinsics.checkNotNullParameter(educationalDependeciesProvider, "educationalDependeciesProvider");
        return educationalDependeciesProvider;
    }

    @Provides
    public ILivenessUploadDependenciesProvider providesLivenessCoreUploadDependenciesProvider(FaceCaptureUploadDependenciesProvider uploadDependenciesProvider) {
        Intrinsics.checkNotNullParameter(uploadDependenciesProvider, "uploadDependenciesProvider");
        return uploadDependenciesProvider;
    }

    @Provides
    public LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> providesLivenessGuidelinesViewDataFactory(FaceCaptureGuidelinesViewDataFactory actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }
}
