package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di;

import android.app.Activity;
import android.content.Context;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.YotiSdkConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession;
import com.yoti.mobile.android.yotisdkcore.stepTracker.di.StepTrackerCoreSession;
import com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.StepTrackerActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.e, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerSession;", "Lcom/yoti/mobile/android/yotisdkcore/feature/SingleComponentFeatureSession;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerComponent;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/StepTrackerActivity;", "()V", "featureConfigurationKey", "", "getFeatureConfigurationKey", "()Ljava/lang/String;", "stepTrackerCoreSession", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreSession;", "getStepTrackerCoreSession", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreSession;", "setStepTrackerCoreSession", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreSession;)V", "buildFeatureComponent", "activity", "Landroid/app/Activity;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "buildStepTrackerComponent", "appContext", "Landroid/content/Context;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/YotiSdkConfiguration;", "destroy", "", "Companion", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class StepTrackerSession extends SingleComponentFeatureSession<StepTrackerComponent, StepTrackerActivity> {

    /* JADX INFO: renamed from: c */
    public static final a f7751c = new a(null);

    /* JADX INFO: renamed from: d */
    private static volatile StepTrackerSession f7752d;

    /* JADX INFO: renamed from: a */
    @Inject
    public StepTrackerCoreSession f7753a;

    /* JADX INFO: renamed from: b */
    private final String f7754b;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.e$a */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerSession$Companion;", "", "()V", "value", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerSession;", "INSTANCE", "setINSTANCE", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerSession;)V", "instance", "getInstance", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/di/StepTrackerSession;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public final void m5195a(StepTrackerSession stepTrackerSession) {
            synchronized (this) {
                StepTrackerSession.f7752d = stepTrackerSession;
            }
        }

        /* JADX INFO: renamed from: a */
        public final StepTrackerSession m5196a() {
            StepTrackerSession stepTrackerSession = StepTrackerSession.f7752d;
            if (stepTrackerSession == null) {
                synchronized (this) {
                    stepTrackerSession = new StepTrackerSession(null);
                    StepTrackerSession.f7751c.m5195a(stepTrackerSession);
                }
            }
            return stepTrackerSession;
        }
    }

    private StepTrackerSession() {
        super(Reflection.getOrCreateKotlinClass(StepTrackerActivity.class));
        this.f7754b = "StepTrackerCoreSession.featureConfiguration";
    }

    public /* synthetic */ StepTrackerSession(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: renamed from: a */
    private final StepTrackerComponent m5189a(Context context, YotiSdkConfiguration yotiSdkConfiguration) {
        StepTrackerComponent stepTrackerComponentM5187a = C5012a.m5180a().m5186a(new SessionConfigurationModule(context)).m5184a(new RemoteModule(yotiSdkConfiguration.getSession())).m5185a(new CommonModule(context)).m5187a();
        Intrinsics.checkNotNullExpressionValue(stepTrackerComponentM5187a, "builder()\n            .s…xt))\n            .build()");
        return stepTrackerComponentM5187a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.yotisdkcore.feature.SingleComponentFeatureSession
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public StepTrackerComponent buildFeatureComponent(Activity activity, IFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
        StepTrackerComponent stepTrackerComponentM5189a = m5189a(applicationContext, (YotiSdkConfiguration) featureConfiguration);
        stepTrackerComponentM5189a.mo5183a(this);
        m5193b().m5157a(featureConfiguration);
        return stepTrackerComponentM5189a;
    }

    /* JADX INFO: renamed from: b */
    public final StepTrackerCoreSession m5193b() {
        StepTrackerCoreSession stepTrackerCoreSession = this.f7753a;
        if (stepTrackerCoreSession != null) {
            return stepTrackerCoreSession;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stepTrackerCoreSession");
        return null;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    protected void destroy() {
        m5193b().m5159b();
        f7751c.m5195a(null);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.feature.FeatureSession
    /* JADX INFO: renamed from: getFeatureConfigurationKey, reason: from getter */
    protected String getF7754b() {
        return this.f7754b;
    }
}
