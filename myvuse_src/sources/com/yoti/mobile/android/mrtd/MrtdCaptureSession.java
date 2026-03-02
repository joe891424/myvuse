package com.yoti.mobile.android.mrtd;

import android.app.Activity;
import android.content.Context;
import com.yoti.mobile.android.mrtd.p073di.DaggerMrtdCaptureComponent;
import com.yoti.mobile.android.mrtd.p073di.MrtdCaptureComponent;
import com.yoti.mobile.android.mrtd.p073di.MrtdCaptureModule;
import com.yoti.mobile.android.mrtd.view.MrtdCaptureActivity;
import com.yoti.mobile.android.mrtd.view.MrtdFeatureConfiguration;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014R\u0014\u0010\u0005\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/MrtdCaptureSession;", "Lcom/yoti/mobile/android/yotisdkcore/feature/SingleComponentFeatureSession;", "Lcom/yoti/mobile/android/mrtd/di/MrtdCaptureComponent;", "Lcom/yoti/mobile/android/mrtd/view/MrtdCaptureActivity;", "()V", "featureConfigurationKey", "", "getFeatureConfigurationKey", "()Ljava/lang/String;", "buildFeatureComponent", "activity", "Landroid/app/Activity;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "destroy", "", "Companion", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdCaptureSession extends SingleComponentFeatureSession<MrtdCaptureComponent, MrtdCaptureActivity> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile MrtdCaptureSession INSTANCE;

    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/MrtdCaptureSession$Companion;", "", "()V", "value", "Lcom/yoti/mobile/android/mrtd/MrtdCaptureSession;", "INSTANCE", "setINSTANCE", "(Lcom/yoti/mobile/android/mrtd/MrtdCaptureSession;)V", "instance", "getInstance", "()Lcom/yoti/mobile/android/mrtd/MrtdCaptureSession;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setINSTANCE(MrtdCaptureSession mrtdCaptureSession) {
            synchronized (this) {
                MrtdCaptureSession.INSTANCE = mrtdCaptureSession;
            }
        }

        public final MrtdCaptureSession getInstance() {
            MrtdCaptureSession mrtdCaptureSession = MrtdCaptureSession.INSTANCE;
            if (mrtdCaptureSession == null) {
                synchronized (this) {
                    mrtdCaptureSession = new MrtdCaptureSession();
                    MrtdCaptureSession.INSTANCE.setINSTANCE(mrtdCaptureSession);
                }
            }
            return mrtdCaptureSession;
        }
    }

    public MrtdCaptureSession() {
        super(Reflection.getOrCreateKotlinClass(MrtdCaptureActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession
    public MrtdCaptureComponent buildFeatureComponent(Activity activity, IFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        DaggerMrtdCaptureComponent.Builder builder = DaggerMrtdCaptureComponent.builder();
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
        MrtdCaptureComponent mrtdCaptureComponentBuild = builder.commonModule(new CommonModule(applicationContext)).mrtdCaptureModule(new MrtdCaptureModule(((MrtdFeatureConfiguration) featureConfiguration).getAuthData())).build();
        Intrinsics.checkNotNullExpressionValue(mrtdCaptureComponentBuild, "builder()\n            .c…ta))\n            .build()");
        return mrtdCaptureComponentBuild;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    protected void destroy() {
        INSTANCE.setINSTANCE(null);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    /* JADX INFO: renamed from: getFeatureConfigurationKey */
    protected String getF7754b() {
        return "MrtdCaptureSession.featureConfiguration";
    }
}
