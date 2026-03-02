package com.yoti.mobile.android.liveness.data.remote;

import io.reactivex.Completable;
import kotlin.Metadata;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/data/remote/LivenessCoreApiService;", "", "giveBiometricConsent", "Lio/reactivex/Completable;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface LivenessCoreApiService {
    @POST(LivenessCoreApiDefsKt.URL_GIVE_BIOMETRIC_CONSENT)
    Completable giveBiometricConsent();
}
