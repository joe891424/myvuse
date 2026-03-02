package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.google.gson.Gson;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SdkCoreApiService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/di/SdkCoreApiServiceModule;", "", "()V", "providesApiService", "Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SdkCoreApiService;", "apiServiceFactory", "Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "okHttpClient", "Lokhttp3/OkHttpClient;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class SdkCoreApiServiceModule {
    @Provides
    @Singleton
    public SdkCoreApiService providesApiService(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Gson gsonMakeGson = apiServiceFactory.makeGson();
        RxJava2CallAdapterFactory rxJava2CallAdapterFactoryCreate = RxJava2CallAdapterFactory.create();
        Intrinsics.checkNotNullExpressionValue(rxJava2CallAdapterFactoryCreate, "create()");
        return (SdkCoreApiService) new Retrofit.Builder().baseUrl(apiServiceFactory.getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(rxJava2CallAdapterFactoryCreate).addConverterFactory(GsonConverterFactory.create(gsonMakeGson)).build().create(SdkCoreApiService.class);
    }
}
