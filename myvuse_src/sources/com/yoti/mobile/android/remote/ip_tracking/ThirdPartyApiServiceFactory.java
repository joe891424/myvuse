package com.yoti.mobile.android.remote.ip_tracking;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: ThirdPartyApiServiceFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J:\u0010\n\u001a\u0002H\u000b\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ip_tracking/ThirdPartyApiServiceFactory;", "", "()V", "makeLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "makeOkHttpClient", "Lokhttp3/OkHttpClient;", "interceptors", "", "Lokhttp3/Interceptor;", "makeService", ExifInterface.GPS_DIRECTION_TRUE, "baseUrl", "", "gson", "Lcom/google/gson/Gson;", "okHttpClient", "callAdapterFactory", "Lretrofit2/CallAdapter$Factory;", "(Ljava/lang/String;Lcom/google/gson/Gson;Lokhttp3/OkHttpClient;Lretrofit2/CallAdapter$Factory;)Ljava/lang/Object;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ThirdPartyApiServiceFactory {
    public static final ThirdPartyApiServiceFactory INSTANCE = new ThirdPartyApiServiceFactory();

    private ThirdPartyApiServiceFactory() {
    }

    public static /* synthetic */ Object makeService$default(ThirdPartyApiServiceFactory thirdPartyApiServiceFactory, String baseUrl, Gson gson, OkHttpClient okHttpClient, CallAdapter.Factory callAdapterFactory, int i, Object obj) {
        if ((i & 4) != 0) {
            okHttpClient = thirdPartyApiServiceFactory.makeOkHttpClient(SetsKt.setOf(thirdPartyApiServiceFactory.makeLoggingInterceptor()));
        }
        if ((i & 8) != 0) {
            callAdapterFactory = new NetworkResponseAdapterFactory();
        }
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(callAdapterFactory, "callAdapterFactory");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient).addCallAdapterFactory(callAdapterFactory).addConverterFactory(GsonConverterFactory.create(gson)).build();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return retrofitBuild.create(Object.class);
    }

    public final /* synthetic */ <T> T makeService(String baseUrl, Gson gson, OkHttpClient okHttpClient, CallAdapter.Factory callAdapterFactory) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(callAdapterFactory, "callAdapterFactory");
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient).addCallAdapterFactory(callAdapterFactory).addConverterFactory(GsonConverterFactory.create(gson)).build();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) retrofitBuild.create(Object.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient makeOkHttpClient(Set<? extends Interceptor> interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Iterator<T> it2 = interceptors.iterator();
        while (it2.hasNext()) {
            builder.addInterceptor((Interceptor) it2.next());
        }
        builder.connectTimeout(10L, TimeUnit.SECONDS);
        builder.readTimeout(10L, TimeUnit.SECONDS);
        builder.writeTimeout(10L, TimeUnit.SECONDS);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final HttpLoggingInterceptor makeLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, 0 == true ? 1 : 0);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        return httpLoggingInterceptor;
    }
}
