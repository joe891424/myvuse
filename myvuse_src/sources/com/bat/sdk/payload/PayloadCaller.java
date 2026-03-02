package com.bat.sdk.payload;

import com.bat.sdk.BatSdk;
import com.bat.sdk.remote.AuthenticationErrorInterceptor;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: PayloadCaller.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadCaller;", "", "<init>", "()V", "api", "Lcom/bat/sdk/payload/PayloadApi;", "requestPayload", "", "", ClientData.KEY_CHALLENGE, "", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "payloadCode", "url", AnalyticsAttribute.USER_ID_ATTRIBUTE, "token", "tenant", "accessToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class PayloadCaller {
    private final PayloadApi api;

    /* JADX INFO: renamed from: com.bat.sdk.payload.PayloadCaller$requestPayload$1 */
    /* JADX INFO: compiled from: PayloadCaller.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.payload.PayloadCaller", m5608f = "PayloadCaller.kt", m5609i = {}, m5610l = {56}, m5611m = "requestPayload", m5612n = {}, m5613s = {})
    static final class C15131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C15131(Continuation<? super C15131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PayloadCaller.this.requestPayload(null, null, null, null, null, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PayloadCaller() {
        GsonConverterFactory gsonConverterFactoryCreate = GsonConverterFactory.create(new GsonBuilder().create());
        OkHttpClient.Builder builderWriteTimeout = new OkHttpClient.Builder().connectTimeout(45L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        builderWriteTimeout.addInterceptor(httpLoggingInterceptor);
        AuthenticationErrorInterceptor authenticationErrorInterceptor = BatSdk.INSTANCE.getAuthenticationErrorInterceptor();
        if (authenticationErrorInterceptor != null) {
            builderWriteTimeout.addInterceptor(authenticationErrorInterceptor);
        }
        this.api = (PayloadApi) new Retrofit.Builder().client(builderWriteTimeout.build()).baseUrl("http://localhost/").addConverterFactory(gsonConverterFactoryCreate).build().create(PayloadApi.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestPayload(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<byte[]>> r21) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.payload.PayloadCaller.requestPayload(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
