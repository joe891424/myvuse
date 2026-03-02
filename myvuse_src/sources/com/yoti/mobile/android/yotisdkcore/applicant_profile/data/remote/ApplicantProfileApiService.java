package com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote;

import com.haroldadmin.cnradapter.NetworkResponse;
import com.yoti.mobile.android.remote.model.ErrorResponse;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model.ApplicantProfile;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/remote/ApplicantProfileApiService;", "", "getApplicantProfile", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/ApplicantProfile;", "Lcom/yoti/mobile/android/remote/model/ErrorResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ApplicantProfileApiService {
    @GET("/idverify/v1/sessions/{session_id}/resources/applicant-profile")
    Object getApplicantProfile(Continuation<? super NetworkResponse<ApplicantProfile, ErrorResponse>> continuation);
}
