package com.yoti.mobile.android.facecapture.p070di;

import android.app.Activity;
import android.content.Context;
import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureApiServiceModule;
import com.yoti.mobile.android.facecapture.view.FaceCaptureActivity;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import com.yoti.mobile.android.liveness.p071di.module.LivenessFeatureConfigurationModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/di/FaceCaptureSession;", "Lcom/yoti/mobile/android/yotisdkcore/feature/SingleComponentFeatureSession;", "Lcom/yoti/mobile/android/facecapture/di/FaceCaptureComponent;", "Lcom/yoti/mobile/android/facecapture/view/FaceCaptureActivity;", "()V", "coreSession", "Lcom/yoti/mobile/android/liveness/di/LivenessCoreSession;", "getCoreSession", "()Lcom/yoti/mobile/android/liveness/di/LivenessCoreSession;", "setCoreSession", "(Lcom/yoti/mobile/android/liveness/di/LivenessCoreSession;)V", "featureConfigurationKey", "", "getFeatureConfigurationKey", "()Ljava/lang/String;", "buildFaceCaptureComponent", "appContext", "Landroid/content/Context;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "buildFeatureComponent", "activity", "Landroid/app/Activity;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "destroy", "", "Companion", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureSession extends SingleComponentFeatureSession<FaceCaptureComponent, FaceCaptureActivity> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile FaceCaptureSession INSTANCE;

    @Inject
    public LivenessCoreSession coreSession;

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/di/FaceCaptureSession$Companion;", "", "()V", "value", "Lcom/yoti/mobile/android/facecapture/di/FaceCaptureSession;", "INSTANCE", "setINSTANCE", "(Lcom/yoti/mobile/android/facecapture/di/FaceCaptureSession;)V", "instance", "getInstance", "()Lcom/yoti/mobile/android/facecapture/di/FaceCaptureSession;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setINSTANCE(FaceCaptureSession faceCaptureSession) {
            synchronized (this) {
                FaceCaptureSession.INSTANCE = faceCaptureSession;
            }
        }

        public final FaceCaptureSession getInstance() {
            FaceCaptureSession faceCaptureSession = FaceCaptureSession.INSTANCE;
            if (faceCaptureSession == null) {
                synchronized (this) {
                    faceCaptureSession = new FaceCaptureSession(null);
                    FaceCaptureSession.INSTANCE.setINSTANCE(faceCaptureSession);
                }
            }
            return faceCaptureSession;
        }
    }

    private FaceCaptureSession() {
        super(Reflection.getOrCreateKotlinClass(FaceCaptureActivity.class));
    }

    public /* synthetic */ FaceCaptureSession(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final FaceCaptureComponent buildFaceCaptureComponent(Context appContext, LivenessFeatureConfiguration featureConfiguration) {
        FaceCaptureComponent faceCaptureComponentBuild = DaggerFaceCaptureComponent.builder().faceCaptureApiServiceModule(new FaceCaptureApiServiceModule(featureConfiguration)).remoteModule(new RemoteModule(featureConfiguration.getSession())).commonModule(new CommonModule(appContext)).resourceConfigurationModule(new ResourceConfigurationModule(appContext, featureConfiguration.getRequirementId())).livenessFeatureConfigurationModule(new LivenessFeatureConfigurationModule(featureConfiguration)).build();
        Intrinsics.checkNotNullExpressionValue(faceCaptureComponentBuild, "builder()\n            .f…on))\n            .build()");
        return faceCaptureComponentBuild;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    protected void destroy() {
        getCoreSession().destroy();
        INSTANCE.setINSTANCE(null);
    }

    public final LivenessCoreSession getCoreSession() {
        LivenessCoreSession livenessCoreSession = this.coreSession;
        if (livenessCoreSession != null) {
            return livenessCoreSession;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coreSession");
        return null;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    /* JADX INFO: renamed from: getFeatureConfigurationKey */
    protected String getF7754b() {
        return "FaceCaptureSession.featureConfiguration";
    }

    public final void setCoreSession(LivenessCoreSession livenessCoreSession) {
        Intrinsics.checkNotNullParameter(livenessCoreSession, "<set-?>");
        this.coreSession = livenessCoreSession;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession
    public FaceCaptureComponent buildFeatureComponent(Activity activity, IFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Context appContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        FaceCaptureComponent faceCaptureComponentBuildFaceCaptureComponent = buildFaceCaptureComponent(appContext, (LivenessFeatureConfiguration) featureConfiguration);
        faceCaptureComponentBuildFaceCaptureComponent.inject(this);
        getCoreSession().buildLivenessCoreComponent();
        return faceCaptureComponentBuildFaceCaptureComponent;
    }
}
