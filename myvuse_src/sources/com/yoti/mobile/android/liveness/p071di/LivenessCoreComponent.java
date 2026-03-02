package com.yoti.mobile.android.liveness.p071di;

import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreEducationalModule;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreUploadModule;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentFragment;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalFragment;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorFragment;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFragment;
import com.yoti.mobile.android.yotisdkcore.feature.FeatureComponent;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {LivenessCoreUploadModule.class, LivenessCoreEducationalModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/LivenessCoreComponent;", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "inject", "", "fragment", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentFragment;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalFragment;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorFragment;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFragment;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface LivenessCoreComponent extends FeatureComponent {
    void inject(BiometricConsentFragment fragment);

    void inject(LivenessEducationalFragment fragment);

    void inject(LivenessUploadErrorFragment fragment);

    void inject(LivenessUploadFragment fragment);
}
