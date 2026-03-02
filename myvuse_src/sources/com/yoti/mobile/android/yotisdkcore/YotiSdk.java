package com.yoti.mobile.android.yotisdkcore;

import android.app.Activity;
import android.content.Context;
import com.yoti.mobile.android.remote.ServiceLocation;
import com.yoti.mobile.android.remote.model.ClientType;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotisdkcore.core.SessionStatusProvider;
import com.yoti.mobile.android.yotisdkcore.core.p085di.DaggerYotiSdkComponent;
import com.yoti.mobile.android.yotisdkcore.core.p085di.YotiSdkComponent;
import com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.StepTrackerLauncher;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\u0000J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u000fJ\u0006\u0010)\u001a\u00020\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006*"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/YotiSdk;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appComponent", "Lcom/yoti/mobile/android/yotisdkcore/core/di/YotiSdkComponent;", "clientSessionToken", "", "clientType", "Lcom/yoti/mobile/android/remote/model/ClientType;", "serviceLocation", "Lcom/yoti/mobile/android/remote/ServiceLocation;", "sessionId", "sessionStatusCode", "", "getSessionStatusCode", "()I", "sessionStatusDescription", "getSessionStatusDescription", "()Ljava/lang/String;", "sessionStatusProvider", "Lcom/yoti/mobile/android/yotisdkcore/core/SessionStatusProvider;", "getSessionStatusProvider$yoti_sdk_core_productionRelease", "()Lcom/yoti/mobile/android/yotisdkcore/core/SessionStatusProvider;", "setSessionStatusProvider$yoti_sdk_core_productionRelease", "(Lcom/yoti/mobile/android/yotisdkcore/core/SessionStatusProvider;)V", "stepTrackerLauncher", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/StepTrackerLauncher;", "getStepTrackerLauncher$yoti_sdk_core_productionRelease", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/StepTrackerLauncher;", "setStepTrackerLauncher$yoti_sdk_core_productionRelease", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/StepTrackerLauncher;)V", "configureReactNativeClient", "setClientSessionToken", "setSessionId", "start", "", "activity", "Landroid/app/Activity;", "requestCode", "useCanadaService", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class YotiSdk {
    private final YotiSdkComponent appComponent;
    private String clientSessionToken;
    private ClientType clientType;
    private ServiceLocation serviceLocation;
    private String sessionId;

    @Inject
    public SessionStatusProvider sessionStatusProvider;

    @Inject
    public StepTrackerLauncher stepTrackerLauncher;

    public YotiSdk(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerYotiSdkComponent.Builder builder = DaggerYotiSdkComponent.builder();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        YotiSdkComponent yotiSdkComponentBuild = builder.commonModule(new CommonModule(applicationContext)).build();
        Intrinsics.checkNotNullExpressionValue(yotiSdkComponentBuild, "builder()\n            .c…xt))\n            .build()");
        this.appComponent = yotiSdkComponentBuild;
        yotiSdkComponentBuild.inject(this);
        this.sessionId = "";
        this.clientSessionToken = "";
        this.clientType = ClientType.ANDROID;
        this.serviceLocation = ServiceLocation.DEFAULT;
    }

    public static /* synthetic */ boolean start$default(YotiSdk yotiSdk, Activity activity, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 9001;
        }
        return yotiSdk.start(activity, i);
    }

    public final YotiSdk configureReactNativeClient() {
        this.clientType = ClientType.RN_ANDROID;
        return this;
    }

    public final int getSessionStatusCode() {
        return getSessionStatusProvider$yoti_sdk_core_productionRelease().getSessionStatusCode();
    }

    public final String getSessionStatusDescription() {
        return getSessionStatusProvider$yoti_sdk_core_productionRelease().getSessionStatusDescription();
    }

    public final SessionStatusProvider getSessionStatusProvider$yoti_sdk_core_productionRelease() {
        SessionStatusProvider sessionStatusProvider = this.sessionStatusProvider;
        if (sessionStatusProvider != null) {
            return sessionStatusProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sessionStatusProvider");
        return null;
    }

    public final StepTrackerLauncher getStepTrackerLauncher$yoti_sdk_core_productionRelease() {
        StepTrackerLauncher stepTrackerLauncher = this.stepTrackerLauncher;
        if (stepTrackerLauncher != null) {
            return stepTrackerLauncher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stepTrackerLauncher");
        return null;
    }

    public final YotiSdk setClientSessionToken(String clientSessionToken) {
        Intrinsics.checkNotNullParameter(clientSessionToken, "clientSessionToken");
        this.clientSessionToken = clientSessionToken;
        return this;
    }

    public final YotiSdk setSessionId(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        return this;
    }

    public final void setSessionStatusProvider$yoti_sdk_core_productionRelease(SessionStatusProvider sessionStatusProvider) {
        Intrinsics.checkNotNullParameter(sessionStatusProvider, "<set-?>");
        this.sessionStatusProvider = sessionStatusProvider;
    }

    public final void setStepTrackerLauncher$yoti_sdk_core_productionRelease(StepTrackerLauncher stepTrackerLauncher) {
        Intrinsics.checkNotNullParameter(stepTrackerLauncher, "<set-?>");
        this.stepTrackerLauncher = stepTrackerLauncher;
    }

    public final boolean start(Activity activity, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return getStepTrackerLauncher$yoti_sdk_core_productionRelease().m5176a(this.serviceLocation, this.sessionId, this.clientSessionToken, this.clientType).m5177a(activity, requestCode);
    }

    public final YotiSdk useCanadaService() {
        this.serviceLocation = ServiceLocation.CANADA;
        return this;
    }
}
