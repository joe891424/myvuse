package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import com.yoti.mobile.android.remote.ServiceLocation;
import com.yoti.mobile.android.remote.model.ClientType;
import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.remote.model.TokenAuthenticationData;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import com.yoti.mobile.android.yotisdkcore.core.view.YotiSdkConfiguration;
import com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.di.StepTrackerSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J(\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/launcher/StepTrackerLauncher;", "", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;)V", "config", "Lcom/yoti/mobile/android/yotisdkcore/core/view/YotiSdkConfiguration;", "checkCameraAvailability", "", "context", "Landroid/content/Context;", "checkSessionValues", "resetSessionStatusType", "", "session", "serviceLocation", "Lcom/yoti/mobile/android/remote/ServiceLocation;", "sessionId", "", "sessionToken", "clientType", "Lcom/yoti/mobile/android/remote/model/ClientType;", "start", "activity", "Landroid/app/Activity;", "requestCode", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class StepTrackerLauncher {

    /* JADX INFO: renamed from: a */
    private final SessionStatus f7692a;

    /* JADX INFO: renamed from: b */
    private YotiSdkConfiguration f7693b;

    @Inject
    public StepTrackerLauncher(SessionStatus sessionStatus) {
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        this.f7692a = sessionStatus;
    }

    /* JADX INFO: renamed from: a */
    private final boolean m5173a() {
        SessionStatus sessionStatus;
        SessionStatusType sessionStatusType;
        YotiSdkConfiguration yotiSdkConfiguration = this.f7693b;
        YotiSdkConfiguration yotiSdkConfiguration2 = null;
        if (yotiSdkConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            yotiSdkConfiguration = null;
        }
        if (C5011b.m5179b(yotiSdkConfiguration.getSession().getAuthData())) {
            YotiSdkConfiguration yotiSdkConfiguration3 = this.f7693b;
            if (yotiSdkConfiguration3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            } else {
                yotiSdkConfiguration2 = yotiSdkConfiguration3;
            }
            if (yotiSdkConfiguration2.getSession().getId().length() != 0) {
                return true;
            }
            sessionStatus = this.f7692a;
            sessionStatusType = SessionStatusType.NO_SESSION_ID;
        } else {
            sessionStatus = this.f7692a;
            sessionStatusType = SessionStatusType.NO_SESSION_TOKEN;
        }
        sessionStatus.setSessionStatus(sessionStatusType);
        return false;
    }

    /* JADX INFO: renamed from: a */
    private final boolean m5174a(Context context) throws CameraAccessException {
        Object systemService = context.getSystemService("camera");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        }
        String[] cameraIdList = ((CameraManager) systemService).getCameraIdList();
        Intrinsics.checkNotNullExpressionValue(cameraIdList, "cameraManager.cameraIdList");
        if (cameraIdList.length != 0) {
            return true;
        }
        this.f7692a.setSessionStatus(SessionStatusType.NO_CAMERA);
        return false;
    }

    /* JADX INFO: renamed from: b */
    private final void m5175b() {
        this.f7692a.resetSessionStatusType();
    }

    /* JADX INFO: renamed from: a */
    public final StepTrackerLauncher m5176a(ServiceLocation serviceLocation, String sessionId, String sessionToken, ClientType clientType) {
        Intrinsics.checkNotNullParameter(serviceLocation, "serviceLocation");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(clientType, "clientType");
        this.f7693b = new YotiSdkConfiguration(new Session(sessionId, new TokenAuthenticationData(sessionToken), serviceLocation, clientType));
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m5177a(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        m5175b();
        if (!m5174a(activity) || !m5173a()) {
            return false;
        }
        StepTrackerSession stepTrackerSessionM5196a = StepTrackerSession.f7751c.m5196a();
        YotiSdkConfiguration yotiSdkConfiguration = this.f7693b;
        if (yotiSdkConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            yotiSdkConfiguration = null;
        }
        stepTrackerSessionM5196a.start(yotiSdkConfiguration, activity, i);
        return true;
    }
}
