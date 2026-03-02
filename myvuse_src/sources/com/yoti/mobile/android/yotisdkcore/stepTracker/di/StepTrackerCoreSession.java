package com.yoti.mobile.android.yotisdkcore.stepTracker.di;

import android.content.Context;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule;
import com.yoti.mobile.android.yotisdkcore.core.view.IFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.view.YotiSdkConfiguration;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.e, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Singleton
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreSession;", "", "appContext", "Landroid/content/Context;", "stepTrackerDependenciesProvider", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/IStepTrackerCoreDependencyProvider;", "(Landroid/content/Context;Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/IStepTrackerCoreDependencyProvider;)V", "featureCoreComponent", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreComponent;", "getFeatureCoreComponent", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreComponent;", "setFeatureCoreComponent", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreComponent;)V", "buildStepTrackerComponent", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/IFeatureConfiguration;", "destroy", "Companion", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class StepTrackerCoreSession {

    /* JADX INFO: renamed from: d */
    public static final a f7673d = new a(null);

    /* JADX INFO: renamed from: e */
    private static volatile StepTrackerCoreSession f7674e;

    /* JADX INFO: renamed from: a */
    private final Context f7675a;

    /* JADX INFO: renamed from: b */
    private final IStepTrackerCoreDependencyProvider f7676b;

    /* JADX INFO: renamed from: c */
    public StepTrackerCoreComponent f7677c;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.di.e$a */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreSession$Companion;", "", "()V", "value", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreSession;", "INSTANCE", "setINSTANCE", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreSession;)V", "instance", "getInstance", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/di/StepTrackerCoreSession;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public final void m5162a(StepTrackerCoreSession stepTrackerCoreSession) {
            synchronized (this) {
                StepTrackerCoreSession.f7674e = stepTrackerCoreSession;
            }
        }

        /* JADX INFO: renamed from: a */
        public final StepTrackerCoreSession m5163a() {
            StepTrackerCoreSession stepTrackerCoreSession = StepTrackerCoreSession.f7674e;
            if (stepTrackerCoreSession != null) {
                return stepTrackerCoreSession;
            }
            throw new IllegalStateException("StepTrackerCoreSession class constructor has to be called before access to its instance");
        }
    }

    @Inject
    public StepTrackerCoreSession(Context appContext, IStepTrackerCoreDependencyProvider stepTrackerDependenciesProvider) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(stepTrackerDependenciesProvider, "stepTrackerDependenciesProvider");
        this.f7675a = appContext;
        this.f7676b = stepTrackerDependenciesProvider;
        f7673d.m5162a(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m5157a(IFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        StepTrackerCoreComponent stepTrackerCoreComponentM5142a = C5000a.m5134a().m5138a(new RemoteModule(((YotiSdkConfiguration) featureConfiguration).getSession())).m5141a(new StepTrackerCoreModule(this.f7676b)).m5140a(new CountryHelperModule(this.f7675a)).m5139a(new CommonModule(this.f7675a)).m5142a();
        Intrinsics.checkNotNullExpressionValue(stepTrackerCoreComponentM5142a, "builder()\n              …\n                .build()");
        m5158a(stepTrackerCoreComponentM5142a);
    }

    /* JADX INFO: renamed from: a */
    public final void m5158a(StepTrackerCoreComponent stepTrackerCoreComponent) {
        Intrinsics.checkNotNullParameter(stepTrackerCoreComponent, "<set-?>");
        this.f7677c = stepTrackerCoreComponent;
    }

    /* JADX INFO: renamed from: b */
    public final void m5159b() {
        f7673d.m5162a(null);
    }

    /* JADX INFO: renamed from: c */
    public final StepTrackerCoreComponent m5160c() {
        StepTrackerCoreComponent stepTrackerCoreComponent = this.f7677c;
        if (stepTrackerCoreComponent != null) {
            return stepTrackerCoreComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureCoreComponent");
        return null;
    }
}
