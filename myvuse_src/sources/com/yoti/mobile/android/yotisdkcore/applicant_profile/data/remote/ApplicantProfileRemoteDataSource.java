package com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote;

import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.IApplicantProfileDataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/remote/ApplicantProfileRemoteDataSource;", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/IApplicantProfileDataSource;", "apiService", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/remote/ApplicantProfileApiService;", "(Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/remote/ApplicantProfileApiService;)V", "getApplicantProfile", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/remote/exception/RemoteError;", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/ApplicantProfile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ApplicantProfileRemoteDataSource implements IApplicantProfileDataSource {
    private final ApplicantProfileApiService apiService;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource", m5608f = "ApplicantProfileRemoteDataSource.kt", m5609i = {}, m5610l = {15}, m5611m = "getApplicantProfile", m5612n = {}, m5613s = {})
    static final class C4960a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        /* synthetic */ Object f7565a;

        /* JADX INFO: renamed from: c */
        int f7567c;

        C4960a(Continuation<? super C4960a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7565a = obj;
            this.f7567c |= Integer.MIN_VALUE;
            return ApplicantProfileRemoteDataSource.this.getApplicantProfile(this);
        }
    }

    @Inject
    public ApplicantProfileRemoteDataSource(ApplicantProfileApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.yoti.mobile.android.yotisdkcore.applicant_profile.data.IApplicantProfileDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getApplicantProfile(kotlin.coroutines.Continuation<? super com.yoti.mobile.android.commons.functional.Either<? extends com.yoti.mobile.android.remote.exception.RemoteError, com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model.ApplicantProfile>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource.C4960a
            if (r0 == 0) goto L13
            r0 = r5
            com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource$a r0 = (com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource.C4960a) r0
            int r1 = r0.f7567c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7567c = r1
            goto L18
        L13:
            com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource$a r0 = new com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f7565a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f7567c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileApiService r5 = r4.apiService
            r0.f7567c = r3
            java.lang.Object r5 = r5.getApplicantProfile(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            com.haroldadmin.cnradapter.NetworkResponse r5 = (com.haroldadmin.cnradapter.NetworkResponse) r5
            com.yoti.mobile.android.commons.functional.Either r5 = com.yoti.mobile.android.remote.NetworkResponseToRemoteResponseKt.toEither(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource.getApplicantProfile(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
