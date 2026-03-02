package com.yoti.mobile.android.remote.ip_tracking.data;

import com.yoti.mobile.android.remote.ip_tracking.domain.IIpRepository;
import com.yoti.mobile.android.remote.p075di.ForRemoteDataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IpRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ip_tracking/data/IpRepository;", "Lcom/yoti/mobile/android/remote/ip_tracking/domain/IIpRepository;", "remoteDataSource", "Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpRemoteDataSource;", "cacheDataSource", "Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpCacheDataSource;", "(Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpRemoteDataSource;Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpCacheDataSource;)V", "getIp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IpRepository implements IIpRepository {
    private final IIpCacheDataSource cacheDataSource;
    private final IIpRemoteDataSource remoteDataSource;

    /* JADX INFO: renamed from: com.yoti.mobile.android.remote.ip_tracking.data.IpRepository$getIp$1 */
    /* JADX INFO: compiled from: IpRepository.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.remote.ip_tracking.data.IpRepository", m5608f = "IpRepository.kt", m5609i = {0, 1}, m5610l = {13, 13, 14}, m5611m = "getIp", m5612n = {"this", "this"}, m5613s = {"L$0", "L$0"})
    static final class C49241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C49241(Continuation<? super C49241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IpRepository.this.getIp(this);
        }
    }

    @Inject
    public IpRepository(@ForRemoteDataSource IIpRemoteDataSource remoteDataSource, IIpCacheDataSource cacheDataSource) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(cacheDataSource, "cacheDataSource");
        this.remoteDataSource = remoteDataSource;
        this.cacheDataSource = cacheDataSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.yoti.mobile.android.remote.ip_tracking.domain.IIpRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getIp(kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.yoti.mobile.android.remote.ip_tracking.data.IpRepository.C49241
            if (r0 == 0) goto L14
            r0 = r7
            com.yoti.mobile.android.remote.ip_tracking.data.IpRepository$getIp$1 r0 = (com.yoti.mobile.android.remote.ip_tracking.data.IpRepository.C49241) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.yoti.mobile.android.remote.ip_tracking.data.IpRepository$getIp$1 r0 = new com.yoti.mobile.android.remote.ip_tracking.data.IpRepository$getIp$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4c
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L80
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.L$0
            com.yoti.mobile.android.remote.ip_tracking.data.IpRepository r2 = (com.yoti.mobile.android.remote.ip_tracking.data.IpRepository) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6e
        L44:
            java.lang.Object r2 = r0.L$0
            com.yoti.mobile.android.remote.ip_tracking.data.IpRepository r2 = (com.yoti.mobile.android.remote.ip_tracking.data.IpRepository) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5d
        L4c:
            kotlin.ResultKt.throwOnFailure(r7)
            com.yoti.mobile.android.remote.ip_tracking.data.IIpCacheDataSource r7 = r6.cacheDataSource
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r7.getIp(r0)
            if (r7 != r1) goto L5c
            return r1
        L5c:
            r2 = r6
        L5d:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L83
            com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource r7 = r2.remoteDataSource
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.getIp(r0)
            if (r7 != r1) goto L6e
            return r1
        L6e:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L82
            com.yoti.mobile.android.remote.ip_tracking.data.IIpCacheDataSource r2 = r2.cacheDataSource
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = r2.setIp(r7, r0)
            if (r0 != r1) goto L7f
            return r1
        L7f:
            r0 = r7
        L80:
            r7 = r0
            goto L83
        L82:
            r7 = 0
        L83:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.remote.ip_tracking.data.IpRepository.getIp(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
