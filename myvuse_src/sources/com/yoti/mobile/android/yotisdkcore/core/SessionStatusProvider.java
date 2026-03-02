package com.yoti.mobile.android.yotisdkcore.core;

import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/SessionStatusProvider;", "", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;)V", "sessionStatusCode", "", "getSessionStatusCode", "()I", "sessionStatusDescription", "", "getSessionStatusDescription", "()Ljava/lang/String;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionStatusProvider {
    private final SessionStatus sessionStatus;

    @Inject
    public SessionStatusProvider(SessionStatus sessionStatus) {
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        this.sessionStatus = sessionStatus;
    }

    public final int getSessionStatusCode() {
        return this.sessionStatus.getSessionStatus().getCode();
    }

    public final String getSessionStatusDescription() {
        return this.sessionStatus.getSessionStatus().getDescription();
    }
}
