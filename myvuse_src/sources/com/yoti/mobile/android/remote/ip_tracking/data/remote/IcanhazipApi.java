package com.yoti.mobile.android.remote.ip_tracking.data.remote;

import com.haroldadmin.cnradapter.NetworkResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;

/* JADX INFO: compiled from: IcanhazipApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IcanhazipApi;", "", "getIp", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IcanhazipApi {
    @GET(".")
    Object getIp(Continuation<? super NetworkResponse<String, ? extends Object>> continuation);
}
