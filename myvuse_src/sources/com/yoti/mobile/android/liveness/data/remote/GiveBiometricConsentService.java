package com.yoti.mobile.android.liveness.data.remote;

import com.yoti.mobile.android.remote.CompletableService;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/data/remote/GiveBiometricConsentService;", "Lcom/yoti/mobile/android/remote/CompletableService;", "", "apiService", "Lcom/yoti/mobile/android/liveness/data/remote/LivenessCoreApiService;", "(Lcom/yoti/mobile/android/liveness/data/remote/LivenessCoreApiService;)V", "buildRequest", "Lio/reactivex/Completable;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "(Lkotlin/Unit;)Lio/reactivex/Completable;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class GiveBiometricConsentService extends CompletableService<Unit> {
    private final LivenessCoreApiService apiService;

    @Inject
    public GiveBiometricConsentService(LivenessCoreApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.remote.CompletableService
    public Completable buildRequest(Unit params) {
        return this.apiService.giveBiometricConsent();
    }
}
