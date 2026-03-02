package com.bat.sdk.remote;

import com.bat.sdk.BatSdk;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: AsavCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/remote/AsavCaller;", "", "baseUrl", "", "url", "id", "token", "tenant", "accessToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getId", "getToken", "getAccessToken", "api", "Lcom/bat/sdk/remote/AsavApi;", "requestChallenge", "Lkotlin/Result;", "Lcom/bat/sdk/remote/data/AsavResponse;", ClientData.KEY_CHALLENGE, "requestChallenge-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavCaller {
    private final String accessToken;
    private final AsavApi api;
    private final String id;
    private final String tenant;
    private final String token;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public AsavCaller(String baseUrl, String url, String id, String token, String str, String str2) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(token, "token");
        this.url = url;
        this.id = id;
        this.token = token;
        this.tenant = str;
        this.accessToken = str2;
        GsonConverterFactory gsonConverterFactoryCreate = GsonConverterFactory.create(new GsonBuilder().create());
        OkHttpClient.Builder builderWriteTimeout = new OkHttpClient.Builder().connectTimeout(45L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        builderWriteTimeout.addInterceptor(httpLoggingInterceptor);
        AuthenticationErrorInterceptor authenticationErrorInterceptor = BatSdk.INSTANCE.getAuthenticationErrorInterceptor();
        if (authenticationErrorInterceptor != null) {
            builderWriteTimeout.addInterceptor(authenticationErrorInterceptor);
        }
        this.api = (AsavApi) new Retrofit.Builder().client(builderWriteTimeout.build()).baseUrl(baseUrl).addConverterFactory(gsonConverterFactoryCreate).addCallAdapterFactory(new ResultCallAdapterFactory()).build().create(AsavApi.class);
    }

    public /* synthetic */ AsavCaller(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? null : str6);
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getId() {
        return this.id;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestChallenge-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m5933requestChallengegIAlus(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Result<com.bat.sdk.remote.data.AsavResponse>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.bat.sdk.remote.AsavCaller$requestChallenge$1
            if (r0 == 0) goto L14
            r0 = r12
            com.bat.sdk.remote.AsavCaller$requestChallenge$1 r0 = (com.bat.sdk.remote.AsavCaller$requestChallenge$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.bat.sdk.remote.AsavCaller$requestChallenge$1 r0 = new com.bat.sdk.remote.AsavCaller$requestChallenge$1
            r0.<init>(r10, r12)
        L19:
            r8 = r0
            java.lang.Object r12 = r8.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r11 = r12.getValue()
            goto L6a
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.ResultKt.throwOnFailure(r12)
            com.bat.sdk.remote.AsavApi r1 = r10.api
            java.lang.String r12 = r10.url
            java.lang.String r3 = r10.id
            java.lang.String r4 = r10.token
            java.lang.String r5 = r10.tenant
            java.lang.String r6 = r10.accessToken
            if (r6 == 0) goto L5a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "Bearer "
            r7.<init>(r9)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r6 = r6.toString()
            goto L5b
        L5a:
            r6 = 0
        L5b:
            com.bat.sdk.remote.data.AsavRequest r7 = new com.bat.sdk.remote.data.AsavRequest
            r7.<init>(r11)
            r8.label = r2
            r2 = r12
            java.lang.Object r11 = r1.m5932postSecureAvbMdYcbs(r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L6a
            return r0
        L6a:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.remote.AsavCaller.m5933requestChallengegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
