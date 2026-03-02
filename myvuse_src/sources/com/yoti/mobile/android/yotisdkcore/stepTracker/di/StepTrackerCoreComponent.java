package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import com.yoti.mobile.android.yotisdkcore.feature.FeatureComponent;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerFragment;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {StepTrackerCoreModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreComponent;", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "inject", "", "fragment", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerFragment;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface StepTrackerCoreComponent extends FeatureComponent {
    /* JADX INFO: renamed from: a */
    void mo5137a(StepTrackerFragment stepTrackerFragment);
}
