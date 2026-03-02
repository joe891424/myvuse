package com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote;

import io.reactivex.Completable;
import kotlin.Metadata;
import retrofit2.http.DELETE;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/data/remote/DeleteSessionTokenApiService;", "", "deleteSessionToken", "Lio/reactivex/Completable;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface DeleteSessionTokenApiService {
    @DELETE("/idverify/v1/sessions/{session_id}/client-session-token")
    /* JADX INFO: renamed from: a */
    Completable m5132a();
}
