package com.yoti.mobile.android.liveness.zoom.p072di.module;

import com.yoti.mobile.android.liveness.p071di.ILivenessEducationalDependeciesProvider;
import com.yoti.mobile.android.liveness.p071di.ILivenessUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewDataFactory;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecEducationalDependenciesProvider;
import com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecUploadDependenciesProvider;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecInitializer;
import com.yoti.mobile.android.liveness.zoom.view.capture.FaceTecResultProcessor;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecInitializer;
import com.yoti.mobile.android.liveness.zoom.view.capture.IFaceTecResultProcessor;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecInitializer;
import com.yoti.mobile.android.liveness.zoom.view.capture.automation.AutomationFaceTecResultProcessor;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.SchedulersModule;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\b\u0010\u0019\u001a\u00020\u0003H\u0017J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/di/module/LivenessFaceTecModule;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "providesFaceTecInitializer", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecInitializer;", "faceTecInitializer", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecInitializer;", "automationFaceTecInitializer", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/automation/AutomationFaceTecInitializer;", "providesFaceTecResultProcessor", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecResultProcessor;", "processor", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecResultProcessor;", "automationProcessor", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/automation/AutomationFaceTecResultProcessor;", "providesLivenessCoreEducationalDependenciesProvider", "Lcom/yoti/mobile/android/liveness/di/ILivenessEducationalDependeciesProvider;", "educationalDependeciesProvider", "Lcom/yoti/mobile/android/liveness/zoom/di/LivenessFaceTecEducationalDependenciesProvider;", "providesLivenessCoreUploadDependenciesProvider", "Lcom/yoti/mobile/android/liveness/di/ILivenessUploadDependenciesProvider;", "uploadDependenciesProvider", "Lcom/yoti/mobile/android/liveness/zoom/di/LivenessFaceTecUploadDependenciesProvider;", "providesLivenessFeatureConfiguration", "providesLivenessGuidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "actual", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewDataFactory;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {ResourceConfigurationModule.class, LivenessFaceTecApiServiceModule.class, LivenessFaceTecViewModelModule.class, SessionStatusModule.class, RemoteModule.class, SchedulersModule.class, CommonModule.class})
public class LivenessFaceTecModule {
    private final LivenessFeatureConfiguration featureConfiguration;

    public LivenessFaceTecModule(LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.featureConfiguration = featureConfiguration;
    }

    @Provides
    @Singleton
    public IFaceTecInitializer providesFaceTecInitializer(FaceTecInitializer faceTecInitializer, AutomationFaceTecInitializer automationFaceTecInitializer) {
        Intrinsics.checkNotNullParameter(faceTecInitializer, "faceTecInitializer");
        Intrinsics.checkNotNullParameter(automationFaceTecInitializer, "automationFaceTecInitializer");
        return Intrinsics.areEqual("production", "automation") ? automationFaceTecInitializer : faceTecInitializer;
    }

    @Provides
    public IFaceTecResultProcessor providesFaceTecResultProcessor(FaceTecResultProcessor processor, AutomationFaceTecResultProcessor automationProcessor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(automationProcessor, "automationProcessor");
        return Intrinsics.areEqual("production", "automation") ? automationProcessor : processor;
    }

    @Provides
    public ILivenessEducationalDependeciesProvider providesLivenessCoreEducationalDependenciesProvider(LivenessFaceTecEducationalDependenciesProvider educationalDependeciesProvider) {
        Intrinsics.checkNotNullParameter(educationalDependeciesProvider, "educationalDependeciesProvider");
        return educationalDependeciesProvider;
    }

    @Provides
    public ILivenessUploadDependenciesProvider providesLivenessCoreUploadDependenciesProvider(LivenessFaceTecUploadDependenciesProvider uploadDependenciesProvider) {
        Intrinsics.checkNotNullParameter(uploadDependenciesProvider, "uploadDependenciesProvider");
        return uploadDependenciesProvider;
    }

    @Provides
    /* JADX INFO: renamed from: providesLivenessFeatureConfiguration, reason: from getter */
    public LivenessFeatureConfiguration getFeatureConfiguration() {
        return this.featureConfiguration;
    }

    @Provides
    public LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> providesLivenessGuidelinesViewDataFactory(LivenessGuidelinesViewDataFactory actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }
}
