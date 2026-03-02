package com.yoti.mobile.android.liveness.p071di.module;

import com.google.gson.Gson;
import com.yoti.mobile.android.liveness.data.remote.LivenessCoreApiService;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/module/LivenessCoreApiServiceModule;", "", "()V", "providesApiService", "Lcom/yoti/mobile/android/liveness/data/remote/LivenessCoreApiService;", "apiServiceFactory", "Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "okHttpClient", "Lokhttp3/OkHttpClient;", "gson", "Lcom/google/gson/Gson;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public final class LivenessCoreApiServiceModule {
    @Provides
    public final LivenessCoreApiService providesApiService(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        RxJava2CallAdapterFactory rxJava2CallAdapterFactoryCreate = RxJava2CallAdapterFactory.create();
        Intrinsics.checkNotNullExpressionValue(rxJava2CallAdapterFactoryCreate, "create()");
        return (LivenessCoreApiService) new Retrofit.Builder().baseUrl(apiServiceFactory.getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(rxJava2CallAdapterFactoryCreate).addConverterFactory(GsonConverterFactory.create(gson)).build().create(LivenessCoreApiService.class);
    }
}
