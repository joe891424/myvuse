package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.CaptureCameraProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.DocumentCaptureProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.ISessionTokenRepository;
import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.SessionConfigurationFilterProcessor;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreModule;", "", "stepTrackerDependencyProvider", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/IStepTrackerCoreDependencyProvider;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/IStepTrackerCoreDependencyProvider;)V", "getStepTrackerDependencyProvider", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/IStepTrackerCoreDependencyProvider;", "providesCameraProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/CaptureCameraProperties;", "providesDocumentCaptureProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/DocumentCaptureProperties;", "providesSessionConfigurationFilterOptions", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/SessionConfigurationFilterProcessor$FilterProcessorOptions;", "providesSessionTokenRepository", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/domain/ISessionTokenRepository;", "providesStepRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "providesUiSessionProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {RemoteModule.class, CountryHelperModule.class, SessionStatusModule.class, ViewModelModule.class, CommonModule.class})
public final class StepTrackerCoreModule {

    /* JADX INFO: renamed from: a */
    private final IStepTrackerCoreDependencyProvider f7672a;

    public StepTrackerCoreModule(IStepTrackerCoreDependencyProvider stepTrackerDependencyProvider) {
        Intrinsics.checkNotNullParameter(stepTrackerDependencyProvider, "stepTrackerDependencyProvider");
        this.f7672a = stepTrackerDependencyProvider;
    }

    @Provides
    /* JADX INFO: renamed from: a */
    public final CaptureCameraProperties m5149a() {
        return this.f7672a.mo5147e();
    }

    @Provides
    /* JADX INFO: renamed from: b */
    public final DocumentCaptureProperties m5150b() {
        return this.f7672a.mo5145c();
    }

    @Provides
    /* JADX INFO: renamed from: c */
    public final SessionConfigurationFilterProcessor.a m5151c() {
        return this.f7672a.mo5146d();
    }

    @Provides
    /* JADX INFO: renamed from: d */
    public final ISessionTokenRepository m5152d() {
        return this.f7672a.mo5143a();
    }

    @Provides
    /* JADX INFO: renamed from: e */
    public final ISessionConfigurationRepository m5153e() {
        return this.f7672a.mo5148f();
    }

    @Provides
    /* JADX INFO: renamed from: f */
    public final UiSessionProperties m5154f() {
        return this.f7672a.mo5144b();
    }
}
