package com.yoti.mobile.android.remote.ip_tracking.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IIpDataSourceContract.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpRemoteDataSource;", "", "getIp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IIpRemoteDataSource {
    Object getIp(Continuation<? super String> continuation);
}
