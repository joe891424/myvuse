package com.bat.sdk.age;

import com.bat.sdk.BatSdk;
import com.bat.sdk.remote.AuthenticationErrorInterceptor;
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

/* JADX INFO: compiled from: AgeVerificationCaller.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationCaller;", "", "<init>", "()V", "api", "Lcom/bat/sdk/age/AgeVerificationApi;", "verify", "Lcom/bat/sdk/age/AgeVerificationResponse;", "message", "", "url", AnalyticsAttribute.USER_ID_ATTRIBUTE, "token", "tenant", "deviceType", "Lcom/bat/sdk/model/DeviceType;", "isProductionDevice", "", "accessToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bat/sdk/model/DeviceType;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AgeVerificationCaller {
    private final AgeVerificationApi api;

    /* JADX INFO: renamed from: com.bat.sdk.age.AgeVerificationCaller$verify$1 */
    /* JADX INFO: compiled from: AgeVerificationCaller.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.age.AgeVerificationCaller", m5608f = "AgeVerificationCaller.kt", m5609i = {0}, m5610l = {64}, m5611m = "verify", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C14831 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14831(Continuation<? super C14831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgeVerificationCaller.this.verify(null, null, null, null, null, null, false, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AgeVerificationCaller() {
        GsonConverterFactory gsonConverterFactoryCreate = GsonConverterFactory.create(new GsonBuilder().create());
        OkHttpClient.Builder builderWriteTimeout = new OkHttpClient.Builder().connectTimeout(45L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        builderWriteTimeout.addInterceptor(httpLoggingInterceptor);
        AuthenticationErrorInterceptor authenticationErrorInterceptor = BatSdk.INSTANCE.getAuthenticationErrorInterceptor();
        if (authenticationErrorInterceptor != null) {
            builderWriteTimeout.addInterceptor(authenticationErrorInterceptor);
        }
        this.api = (AgeVerificationApi) new Retrofit.Builder().client(builderWriteTimeout.build()).baseUrl("http://localhost/").addConverterFactory(gsonConverterFactoryCreate).build().create(AgeVerificationApi.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object verify(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.bat.sdk.model.DeviceType r22, boolean r23, java.lang.String r24, kotlin.coroutines.Continuation<? super com.bat.sdk.age.AgeVerificationResponse> r25) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.age.AgeVerificationCaller.verify(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.bat.sdk.model.DeviceType, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
