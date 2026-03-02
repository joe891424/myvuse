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
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IpRemoteDataSourceWithFallback;", "Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpRemoteDataSource;", "primaryApiService", "fallbackApiService", "(Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpRemoteDataSource;Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpRemoteDataSource;)V", "getIp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IpRemoteDataSourceWithFallback implements IIpRemoteDataSource {
    private final IIpRemoteDataSource fallbackApiService;
    private final IIpRemoteDataSource primaryApiService;

    /* JADX INFO: renamed from: com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback$getIp$1 */
    /* JADX INFO: compiled from: IpRemoteDataSource.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback", m5608f = "IpRemoteDataSource.kt", m5609i = {0}, m5610l = {13, 13}, m5611m = "getIp", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C49261 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C49261(Continuation<? super C49261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IpRemoteDataSourceWithFallback.this.getIp(this);
        }
    }

    @Inject
    public IpRemoteDataSourceWithFallback(IIpRemoteDataSource primaryApiService, IIpRemoteDataSource fallbackApiService) {
        Intrinsics.checkNotNullParameter(primaryApiService, "primaryApiService");
        Intrinsics.checkNotNullParameter(fallbackApiService, "fallbackApiService");
        this.primaryApiService = primaryApiService;
        this.fallbackApiService = fallbackApiService;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getIp(kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback.C49261
            if (r0 == 0) goto L14
            r0 = r6
            com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback$getIp$1 r0 = (com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback.C49261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback$getIp$1 r0 = new com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback$getIp$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L60
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            java.lang.Object r2 = r0.L$0
            com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback r2 = (com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource r6 = r5.primaryApiService
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getIp(r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r2 = r5
        L4e:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L60
            com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource r6 = r2.fallbackApiService
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.getIp(r0)
            if (r6 != r1) goto L60
            return r1
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback.getIp(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
