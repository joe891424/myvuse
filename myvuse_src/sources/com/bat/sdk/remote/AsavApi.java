package com.bat.sdk.remote;

import com.bat.sdk.remote.data.AsavRequest;
import com.bat.sdk.remote.data.AsavResponse;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* JADX INFO: compiled from: AsavApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JV\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/bat/sdk/remote/AsavApi;", "", "postSecureAv", "Lkotlin/Result;", "Lcom/bat/sdk/remote/data/AsavResponse;", "url", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "token", "tenant", "accessToken", "body", "Lcom/bat/sdk/remote/data/AsavRequest;", "postSecureAv-bMdYcbs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bat/sdk/remote/data/AsavRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface AsavApi {
    @POST
    /* JADX INFO: renamed from: postSecureAv-bMdYcbs, reason: not valid java name */
    Object m5932postSecureAvbMdYcbs(@Url String str, @Header("X-Ecommerce-Customer-Id") String str2, @Header("X-Ecommerce-Customer-Token") String str3, @Header("x-tenant-id") String str4, @Header("authorization") String str5, @Body AsavRequest asavRequest, Continuation<? super Result<AsavResponse>> continuation);
}
