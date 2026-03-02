package com.yoti.mobile.android.yotisdkcore.core.domain;

import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionConfigurationRepository;", "", "clearSessionConfiguration", "", "getSessionConfiguration", "Lio/reactivex/Single;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ISessionConfigurationRepository {
    void clearSessionConfiguration();

    Single<SessionConfigurationEntity> getSessionConfiguration();
}
