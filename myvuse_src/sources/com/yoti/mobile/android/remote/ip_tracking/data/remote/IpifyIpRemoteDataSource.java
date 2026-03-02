package com.yoti.mobile.android.remote.ip_tracking.data.remote;

import com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IpRemoteDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IpifyIpRemoteDataSource;", "Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpRemoteDataSource;", "apiService", "Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IpifyApi;", "(Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IpifyApi;)V", "getIp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IpifyIpRemoteDataSource implements IIpRemoteDataSource {
    private final IpifyApi apiService;

    /* JADX INFO: renamed from: com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource$getIp$1 */
    /* JADX INFO: compiled from: IpRemoteDataSource.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource", m5608f = "IpRemoteDataSource.kt", m5609i = {}, m5610l = {21}, m5611m = "getIp", m5612n = {}, m5613s = {})
    static final class C49271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C49271(Continuation<? super C49271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IpifyIpRemoteDataSource.this.getIp(this);
        }
    }

    @Inject
    public IpifyIpRemoteDataSource(IpifyApi apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getIp(kotlin.coroutines.Continuation<? super java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource.C49271
            if (r0 == 0) goto L14
            r0 = r5
            com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource$getIp$1 r0 = (com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource.C49271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource$getIp$1 r0 = new com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource$getIp$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyApi r5 = r4.apiService
            r0.label = r3
            java.lang.Object r5 = r5.getIp(r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            boolean r0 = r5 instanceof com.haroldadmin.cnradapter.NetworkResponse.Success
            r1 = 0
            if (r0 == 0) goto L48
            com.haroldadmin.cnradapter.NetworkResponse$Success r5 = (com.haroldadmin.cnradapter.NetworkResponse.Success) r5
            goto L49
        L48:
            r5 = r1
        L49:
            if (r5 == 0) goto L57
            java.lang.Object r5 = r5.getBody()
            com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyResponse r5 = (com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyResponse) r5
            if (r5 == 0) goto L57
            java.lang.String r1 = r5.getIp()
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource.getIp(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
