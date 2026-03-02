package com.yoti.mobile.android.yotisdkcore.applicant_profile.data;

import com.yoti.mobile.android.commons.functional.Either;
import com.yoti.mobile.android.remote.exception.RemoteError;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model.ApplicantProfile;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/IApplicantProfileDataSource;", "", "getApplicantProfile", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/ApplicantProfile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IApplicantProfileDataSource {
    Object getApplicantProfile(Continuation<? super Either<? extends RemoteError, ApplicantProfile>> continuation);
}
