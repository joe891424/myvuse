package com.yoti.mobile.android.yotisdkcore.applicant_profile.p080di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.IApplicantProfileDataSource;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileApiService;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/di/ApplicantProfileModule;", "", "()V", "providesApplicantProfileApiService", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/remote/ApplicantProfileApiService;", "apiServiceFactory", "Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "okHttpClient", "Lokhttp3/OkHttpClient;", "callAdapterFactory", "Lretrofit2/CallAdapter$Factory;", "providesApplicantProfileDataSource", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/IApplicantProfileDataSource;", "actual", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/remote/ApplicantProfileRemoteDataSource;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {RemoteModule.class})
public final class ApplicantProfileModule {
    @Provides
    public final ApplicantProfileApiService providesApplicantProfileApiService(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, CallAdapter.Factory callAdapterFactory) {
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(callAdapterFactory, "callAdapterFactory");
        return (ApplicantProfileApiService) new Retrofit.Builder().baseUrl(apiServiceFactory.getServiceLocation().getUrl()).client(okHttpClient).addCallAdapterFactory(callAdapterFactory).addConverterFactory(GsonConverterFactory.create(apiServiceFactory.makeGson())).build().create(ApplicantProfileApiService.class);
    }

    @Provides
    public final IApplicantProfileDataSource providesApplicantProfileDataSource(ApplicantProfileRemoteDataSource actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }
}
