package com.yoti.mobile.android.yotisdkcore.core.domain.model;

import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0006\u0010\u0006\u001a\u00020\u0007J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;", "repository", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/ISessionStatusRepository;)V", "getSessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatusType;", "resetSessionStatusType", "", "setSessionStatus", "sessionStatusType", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionStatus implements ISessionStatusRepository {
    private final ISessionStatusRepository repository;

    @Inject
    public SessionStatus(ISessionStatusRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository
    public SessionStatusType getSessionStatus() {
        return this.repository.getSessionStatus();
    }

    public final void resetSessionStatusType() {
        setSessionStatus(SessionStatusType.INSTANCE.getDefault());
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository
    public void setSessionStatus(SessionStatusType sessionStatusType) {
        Intrinsics.checkNotNullParameter(sessionStatusType, "sessionStatusType");
        this.repository.setSessionStatus(sessionStatusType);
    }
}
