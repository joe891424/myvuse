package com.yoti.mobile.android.yotisdkcore.stepTracker.launcher;

import com.yoti.mobile.android.remote.model.AuthenticationData;
import com.yoti.mobile.android.remote.model.TokenAuthenticationData;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.b */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m5598d2 = {"isValid", "", "Lcom/yoti/mobile/android/remote/model/AuthenticationData;", "yoti-sdk-core_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5011b {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static final boolean m5179b(AuthenticationData authenticationData) {
        return (authenticationData instanceof TokenAuthenticationData) && ((TokenAuthenticationData) authenticationData).getToken().length() > 0;
    }
}
