package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di;

import com.yoti.mobile.android.yotisdkcore.feature.FeatureComponent;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {StepTrackerModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerComponent;", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "inject", "", "stepTrackerActivity", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/StepTrackerActivity;", "stepTrackerSession", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerSession;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface StepTrackerComponent extends FeatureComponent {
    /* JADX INFO: renamed from: a */
    void mo5183a(StepTrackerSession stepTrackerSession);
}
