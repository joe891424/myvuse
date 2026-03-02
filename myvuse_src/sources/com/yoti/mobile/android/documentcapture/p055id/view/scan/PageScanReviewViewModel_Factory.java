package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class PageScanReviewViewModel_Factory implements Factory<PageScanReviewViewModel> {
    private final Provider<ErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<SessionStatus> sessionStatusProvider;

    public PageScanReviewViewModel_Factory(Provider<SessionStatus> provider, Provider<ErrorToSessionStatusTypeMapper> provider2) {
        this.sessionStatusProvider = provider;
        this.errorToSessionStatusTypeMapperProvider = provider2;
    }

    public static PageScanReviewViewModel_Factory create(Provider<SessionStatus> provider, Provider<ErrorToSessionStatusTypeMapper> provider2) {
        return new PageScanReviewViewModel_Factory(provider, provider2);
    }

    public static PageScanReviewViewModel newInstance(SessionStatus sessionStatus, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        return new PageScanReviewViewModel(sessionStatus, errorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public PageScanReviewViewModel get() {
        return newInstance(this.sessionStatusProvider.get(), this.errorToSessionStatusTypeMapperProvider.get());
    }
}
