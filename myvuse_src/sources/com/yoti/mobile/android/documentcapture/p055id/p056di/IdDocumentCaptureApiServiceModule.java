package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCapture;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.DocumentCaptureApiService;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.MrzSerializer;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.MrzType;
import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
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

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0004H\u0017J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010\u0012\u001a\u00020\u0013H\u0017¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureApiServiceModule;", "", "()V", "makeGson", "Lcom/google/gson/Gson;", "gsonBuilder", "Lcom/google/gson/GsonBuilder;", "mrzSerializer", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/MrzSerializer;", "providesApiService", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/DocumentCaptureApiService;", "apiServiceFactory", "Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "okHttpClient", "Lokhttp3/OkHttpClient;", "gson", "providesSessionConfigurationApiService", "Lcom/yoti/mobile/android/yotisdkcore/core/data/remote/SdkCoreApiService;", "providesSessionFeedbackActivationFlag", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class IdDocumentCaptureApiServiceModule {
    @Provides
    @Singleton
    @DocumentCapture
    public Gson makeGson(GsonBuilder gsonBuilder, MrzSerializer mrzSerializer) {
        Intrinsics.checkNotNullParameter(gsonBuilder, "gsonBuilder");
        Intrinsics.checkNotNullParameter(mrzSerializer, "mrzSerializer");
        Gson gsonCreate = gsonBuilder.registerTypeAdapter(MrzType.class, mrzSerializer).create();
        Intrinsics.checkNotNullExpressionValue(gsonCreate, "gsonBuilder\n            …                .create()");
        return gsonCreate;
    }

    @Provides
    @Singleton
    public DocumentCaptureApiService providesApiService(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, @DocumentCapture Gson gson) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        RxJava2CallAdapterFactory rxJava2CallAdapterFactoryCreate = RxJava2CallAdapterFactory.create();
        Intrinsics.checkNotNullExpressionValue(rxJava2CallAdapterFactoryCreate, "create()");
        return (DocumentCaptureApiService) new Retrofit.Builder().baseUrl(apiServiceFactory.getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(rxJava2CallAdapterFactoryCreate).addConverterFactory(GsonConverterFactory.create(gson)).build().create(DocumentCaptureApiService.class);
    }

    @Provides
    @Singleton
    public SdkCoreApiService providesSessionConfigurationApiService(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Gson gsonMakeGson = apiServiceFactory.makeGson();
        RxJava2CallAdapterFactory rxJava2CallAdapterFactoryCreate = RxJava2CallAdapterFactory.create();
        Intrinsics.checkNotNullExpressionValue(rxJava2CallAdapterFactoryCreate, "create()");
        return (SdkCoreApiService) new Retrofit.Builder().baseUrl(apiServiceFactory.getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(rxJava2CallAdapterFactoryCreate).addConverterFactory(GsonConverterFactory.create(gsonMakeGson)).build().create(SdkCoreApiService.class);
    }

    @Provides
    @ForSessionFeedbackActivation
    public boolean providesSessionFeedbackActivationFlag() {
        return !Intrinsics.areEqual("production", "automation");
    }
}
