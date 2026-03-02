package com.yoti.mobile.android.yotisdkcore.core.data;

import android.content.SharedPreferences;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/SessionStatusRepository;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getSessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "setSessionStatus", "", "sessionStatus", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionStatusRepository implements ISessionStatusRepository {
    private final SharedPreferences sharedPreferences;

    @Inject
    public SessionStatusRepository(@SessionStatus SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository
    public SessionStatusType getSessionStatus() {
        String string = this.sharedPreferences.getString(SessionStatusRepositoryKt.PREFS_KEY_SESSION_STATUS, SessionStatusType.INSTANCE.getDefault().name());
        Intrinsics.checkNotNull(string);
        return SessionStatusType.valueOf(string);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository
    public void setSessionStatus(SessionStatusType sessionStatus) {
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        this.sharedPreferences.edit().putString(SessionStatusRepositoryKt.PREFS_KEY_SESSION_STATUS, sessionStatus.name()).apply();
    }
}
