package com.yoti.mobile.android.remote.ip_tracking.data.cache;

import com.yoti.mobile.android.remote.ip_tracking.data.IIpCacheDataSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IpCacheDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ip_tracking/data/cache/IpCacheDataSource;", "Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpCacheDataSource;", "()V", "ip", "", "getIp$annotations", "getIp", "()Ljava/lang/String;", "setIp", "(Ljava/lang/String;)V", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IpCacheDataSource implements IIpCacheDataSource {
    public static final IpCacheDataSource INSTANCE = new IpCacheDataSource();
    private static String ip;

    public static /* synthetic */ void getIp$annotations() {
    }

    private IpCacheDataSource() {
    }

    public final String getIp() {
        return ip;
    }

    public final void setIp(String str) {
        ip = str;
    }

    @Override // com.yoti.mobile.android.remote.ip_tracking.data.IIpCacheDataSource
    public Object getIp(Continuation<? super String> continuation) {
        return ip;
    }

    @Override // com.yoti.mobile.android.remote.ip_tracking.data.IIpCacheDataSource
    public Object setIp(String str, Continuation<? super Unit> continuation) {
        ip = str;
        return Unit.INSTANCE;
    }
}
