package com.bat.sdk.payload;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* JADX INFO: compiled from: PayloadApi.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadApi;", "", "postPayloadCode", "Lcom/bat/sdk/payload/PayloadResponse;", "url", "", AnalyticsAttribute.USER_ID_ATTRIBUTE, "token", "tenant", "accessToken", "payloadRequest", "Lcom/bat/sdk/payload/PayloadRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bat/sdk/payload/PayloadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface PayloadApi {
    @POST
    Object postPayloadCode(@Url String str, @Header("X-Ecommerce-Customer-Id") String str2, @Header("X-Ecommerce-Customer-Token") String str3, @Header("x-tenant-id") String str4, @Header("authorization") String str5, @Body PayloadRequest payloadRequest, Continuation<? super PayloadResponse> continuation);
}
