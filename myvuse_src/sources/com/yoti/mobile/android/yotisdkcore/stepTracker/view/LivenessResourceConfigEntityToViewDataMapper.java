package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.commonui.UiSessionConfiguration;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.view.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.CaptureCameraProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.LivenessResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.f, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ.\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/LivenessResourceConfigEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/ResourceConfigEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity;", "session", "Lcom/yoti/mobile/android/remote/model/Session;", "cameraProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/CaptureCameraProperties;", "uiSessionProperties", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;", "(Lcom/yoti/mobile/android/remote/model/Session;Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/CaptureCameraProperties;Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/UiSessionProperties;)V", "mapResource", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/Step;", "resources", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "resource", FirebaseAnalytics.Param.INDEX, "", "uiSessionConfiguration", "Lcom/yoti/mobile/android/commonui/UiSessionConfiguration;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessResourceConfigEntityToViewDataMapper extends ResourceConfigEntityToViewDataMapper<LivenessResourceConfigEntity> {

    /* JADX INFO: renamed from: a */
    private final Session f7811a;

    /* JADX INFO: renamed from: b */
    private final CaptureCameraProperties f7812b;

    /* JADX INFO: renamed from: c */
    private final UiSessionProperties f7813c;

    @Inject
    public LivenessResourceConfigEntityToViewDataMapper(Session session, CaptureCameraProperties cameraProperties, UiSessionProperties uiSessionProperties) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(uiSessionProperties, "uiSessionProperties");
        this.f7811a = session;
        this.f7812b = cameraProperties;
        this.f7813c = uiSessionProperties;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.stepTracker.view.ResourceConfigEntityToViewDataMapper
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ Step mo5228a(List list, ResourceConfigurationEntity resourceConfigurationEntity, int i, UiSessionConfiguration uiSessionConfiguration) {
        return m5254a((List<? extends ResourceConfigurationEntity>) list, (LivenessResourceConfigEntity) resourceConfigurationEntity, i, uiSessionConfiguration);
    }

    /* JADX INFO: renamed from: a */
    protected Step m5254a(List<? extends ResourceConfigurationEntity> resources, LivenessResourceConfigEntity resource, int i, UiSessionConfiguration uiSessionConfiguration) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(uiSessionConfiguration, "uiSessionConfiguration");
        LivenessStepComposition livenessStepComposition = new LivenessStepComposition(resource.getType());
        String str = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i + 1)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return new Step(new SignpostStep(livenessStepComposition, str, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C4957R.string.f7521xed8f2560), Integer.valueOf(C4957R.string.f7540xf9425d42)})), new LivenessFeatureConfiguration(uiSessionConfiguration, this.f7811a, resource.getRequirementId(), resource.getBiometricConsent().getIsBiometricConsentNeeded(), resource.getBiometricConsent().getBiometricPolicyUsUrl(), resources.size() == 1, this.f7812b.getUseBackCamera(), this.f7812b.isAutomaticCapture(), this.f7813c.isMoreAboutVerificationEnabled(), resource.getType()), CaptureObjectiveTypeViewData.PROOF_OF_IDENTITY, resource.getFeature().getLauncher(), false, resource.isCompleted(), 16, null);
    }
}
