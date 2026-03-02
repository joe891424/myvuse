package com.yoti.mobile.android.yotisdkcore.core.domain;

import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;", "", "getSessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "setSessionStatus", "", "sessionStatusType", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ISessionStatusRepository {
    SessionStatusType getSessionStatus();

    void setSessionStatus(SessionStatusType sessionStatusType);
}
