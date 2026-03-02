package com.yoti.mobile.android.facecapture.p070di.module;

import com.google.gson.Gson;
import com.yoti.mobile.android.facecapture.data.remote.IFaceCaptureApiService;
import com.yoti.mobile.android.facecapture.data.remote.SelfieApiService;
import com.yoti.mobile.android.facecapture.data.remote.SelfieApiServiceAdapter;
import com.yoti.mobile.android.facecapture.data.remote.StaticLivenessApiService;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.core.view.LivenessFeatureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.LivenessResourceConfigEntity;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/di/module/FaceCaptureApiServiceModule;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/LivenessFeatureConfiguration;)V", "providesApiService", "Lcom/yoti/mobile/android/facecapture/data/remote/IFaceCaptureApiService;", "apiServiceFactory", "Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "okHttpClient", "Lokhttp3/OkHttpClient;", "gson", "Lcom/google/gson/Gson;", "selfieApiServiceAdapter", "Lcom/yoti/mobile/android/facecapture/data/remote/SelfieApiServiceAdapter;", "providesSelfieApiService", "Lcom/yoti/mobile/android/facecapture/data/remote/SelfieApiService;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public final class FaceCaptureApiServiceModule {
    private final LivenessFeatureConfiguration featureConfiguration;

    public FaceCaptureApiServiceModule(LivenessFeatureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.featureConfiguration = featureConfiguration;
    }

    @Provides
    public final IFaceCaptureApiService providesApiService(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson, SelfieApiServiceAdapter selfieApiServiceAdapter) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(selfieApiServiceAdapter, "selfieApiServiceAdapter");
        if (this.featureConfiguration.getLivenessType() != LivenessResourceConfigEntity.LivenessTypeEntity.STATIC) {
            return selfieApiServiceAdapter;
        }
        RxJava2CallAdapterFactory rxJava2CallAdapterFactoryCreate = RxJava2CallAdapterFactory.create();
        Intrinsics.checkNotNullExpressionValue(rxJava2CallAdapterFactoryCreate, "create()");
        return (IFaceCaptureApiService) new Retrofit.Builder().baseUrl(apiServiceFactory.getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(rxJava2CallAdapterFactoryCreate).addConverterFactory(GsonConverterFactory.create(gson)).build().create(StaticLivenessApiService.class);
    }

    @Provides
    public final SelfieApiService providesSelfieApiService(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, Gson gson) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        RxJava2CallAdapterFactory rxJava2CallAdapterFactoryCreate = RxJava2CallAdapterFactory.create();
        Intrinsics.checkNotNullExpressionValue(rxJava2CallAdapterFactoryCreate, "create()");
        return (SelfieApiService) new Retrofit.Builder().baseUrl(apiServiceFactory.getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(rxJava2CallAdapterFactoryCreate).addConverterFactory(GsonConverterFactory.create(gson)).build().create(SelfieApiService.class);
    }
}
