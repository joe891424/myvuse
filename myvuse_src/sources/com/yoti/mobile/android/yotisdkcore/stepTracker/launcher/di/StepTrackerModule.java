package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di;

import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SdkCoreApiServiceModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionTokenApiServiceModule;
import com.yoti.mobile.android.yotisdkcore.stepTracker.di.IStepTrackerCoreDependencyProvider;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerModule;", "", "()V", "providesStepTrackerDependencyProvider", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/IStepTrackerCoreDependencyProvider;", "actual", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerDependencyProvider;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {CommonModule.class, SdkCoreApiServiceModule.class, SessionTokenApiServiceModule.class, SessionConfigurationModule.class, RemoteModule.class})
public final class StepTrackerModule {
    @Provides
    /* JADX INFO: renamed from: a */
    public final IStepTrackerCoreDependencyProvider m5188a(StepTrackerDependencyProvider actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }
}
