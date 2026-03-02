package com.yoti.mobile.android.liveness.p071di;

import android.content.Context;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreEducationalModule;
import com.yoti.mobile.android.liveness.p071di.module.LivenessCoreUploadModule;
import com.yoti.mobile.android.liveness.p071di.module.LivenessFeatureConfigurationModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Singleton
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/LivenessCoreSession;", "", "appContext", "Landroid/content/Context;", "educationalDependeciesProvider", "Lcom/yoti/mobile/android/liveness/di/ILivenessEducationalDependeciesProvider;", "uploadDependenciesProvider", "Lcom/yoti/mobile/android/liveness/di/ILivenessUploadDependenciesProvider;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Landroid/content/Context;Lcom/yoti/mobile/android/liveness/di/ILivenessEducationalDependeciesProvider;Lcom/yoti/mobile/android/liveness/di/ILivenessUploadDependenciesProvider;Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "featureComponent", "Lcom/yoti/mobile/android/liveness/di/LivenessCoreComponent;", "getFeatureComponent", "()Lcom/yoti/mobile/android/liveness/di/LivenessCoreComponent;", "setFeatureComponent", "(Lcom/yoti/mobile/android/liveness/di/LivenessCoreComponent;)V", "buildLivenessCoreComponent", "", "destroy", "Companion", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessCoreSession {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile LivenessCoreSession INSTANCE;
    private final Context appContext;
    private final ILivenessEducationalDependeciesProvider educationalDependeciesProvider;
    public LivenessCoreComponent featureComponent;
    private final LivenessFeatureConfiguration featureConfiguration;
    private final ILivenessUploadDependenciesProvider uploadDependenciesProvider;

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/LivenessCoreSession$Companion;", "", "()V", "value", "Lcom/yoti/mobile/android/liveness/di/LivenessCoreSession;", "INSTANCE", "setINSTANCE", "(Lcom/yoti/mobile/android/liveness/di/LivenessCoreSession;)V", "instance", "getInstance", "()Lcom/yoti/mobile/android/liveness/di/LivenessCoreSession;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setINSTANCE(LivenessCoreSession livenessCoreSession) {
            synchronized (this) {
                LivenessCoreSession.INSTANCE = livenessCoreSession;
            }
        }

        public final LivenessCoreSession getInstance() {
            LivenessCoreSession livenessCoreSession = LivenessCoreSession.INSTANCE;
            if (livenessCoreSession != null) {
                return livenessCoreSession;
            }
            throw new IllegalStateException("LivenessCoreSession class constructor has to be called before access to its instance");
        }
    }

    @Inject
    public LivenessCoreSession(Context appContext, ILivenessEducationalDependeciesProvider educationalDependeciesProvider, ILivenessUploadDependenciesProvider uploadDependenciesProvider, LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(educationalDependeciesProvider, "educationalDependeciesProvider");
        Intrinsics.checkNotNullParameter(uploadDependenciesProvider, "uploadDependenciesProvider");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.appContext = appContext;
        this.educationalDependeciesProvider = educationalDependeciesProvider;
        this.uploadDependenciesProvider = uploadDependenciesProvider;
        this.featureConfiguration = featureConfiguration;
        INSTANCE.setINSTANCE(this);
    }

    public final void buildLivenessCoreComponent() {
        LivenessCoreComponent livenessCoreComponentBuild = DaggerLivenessCoreComponent.builder().remoteModule(new RemoteModule(this.featureConfiguration.getSession())).commonModule(new CommonModule(this.appContext)).livenessFeatureConfigurationModule(new LivenessFeatureConfigurationModule(this.featureConfiguration)).livenessCoreEducationalModule(new LivenessCoreEducationalModule(this.educationalDependeciesProvider)).livenessCoreUploadModule(new LivenessCoreUploadModule(this.uploadDependenciesProvider)).build();
        Intrinsics.checkNotNullExpressionValue(livenessCoreComponentBuild, "builder()\n              …\n                .build()");
        setFeatureComponent(livenessCoreComponentBuild);
    }

    public final void destroy() {
        INSTANCE.setINSTANCE(null);
    }

    public final LivenessCoreComponent getFeatureComponent() {
        LivenessCoreComponent livenessCoreComponent = this.featureComponent;
        if (livenessCoreComponent != null) {
            return livenessCoreComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureComponent");
        return null;
    }

    public final void setFeatureComponent(LivenessCoreComponent livenessCoreComponent) {
        Intrinsics.checkNotNullParameter(livenessCoreComponent, "<set-?>");
        this.featureComponent = livenessCoreComponent;
    }
}
