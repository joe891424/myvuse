package com.yoti.mobile.android.remote.p075di;

import com.google.gson.Gson;
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory;
import com.yoti.mobile.android.remote.ip_tracking.ThirdPartyApiServiceFactory;
import com.yoti.mobile.android.remote.ip_tracking.data.IIpCacheDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.IIpRemoteDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.IpRepository;
import com.yoti.mobile.android.remote.ip_tracking.data.cache.IpCacheDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IcanhazipApi;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IcanhazipApiKt;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IcanhazipIpRemoteDataSource;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpRemoteDataSourceWithFallback;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyApi;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyApiKt;
import com.yoti.mobile.android.remote.ip_tracking.data.remote.IpifyIpRemoteDataSource;
import com.yoti.mobile.android.remote.ip_tracking.domain.IIpRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: IpTrackingModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007J\r\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\nJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0019¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/di/IpTrackingModule;", "", "()V", "providesIcanhazipApiService", "Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IcanhazipApi;", "gson", "Lcom/google/gson/Gson;", "providesIcanhazipApiService$remote_productionRelease", "providesIpCacheDataSource", "Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpCacheDataSource;", "providesIpCacheDataSource$remote_productionRelease", "providesIpRemoteDataSource", "Lcom/yoti/mobile/android/remote/ip_tracking/data/IIpRemoteDataSource;", "primary", "Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IpifyIpRemoteDataSource;", "fallback", "Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IcanhazipIpRemoteDataSource;", "providesIpRemoteDataSource$remote_productionRelease", "providesIpRepository", "Lcom/yoti/mobile/android/remote/ip_tracking/domain/IIpRepository;", "actual", "Lcom/yoti/mobile/android/remote/ip_tracking/data/IpRepository;", "providesIpRepository$remote_productionRelease", "providesIpifyApiService", "Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IpifyApi;", "providesIpifyApiService$remote_productionRelease", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public final class IpTrackingModule {
    @Provides
    public final IIpCacheDataSource providesIpCacheDataSource$remote_productionRelease() {
        return IpCacheDataSource.INSTANCE;
    }

    @Provides
    @ForRemoteDataSource
    public final IIpRemoteDataSource providesIpRemoteDataSource$remote_productionRelease(IpifyIpRemoteDataSource primary, IcanhazipIpRemoteDataSource fallback) {
        Intrinsics.checkNotNullParameter(primary, "primary");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        return new IpRemoteDataSourceWithFallback(primary, fallback);
    }

    @Provides
    public final IIpRepository providesIpRepository$remote_productionRelease(IpRepository actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        return actual;
    }

    @Provides
    @Singleton
    public final IpifyApi providesIpifyApiService$remote_productionRelease(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        ThirdPartyApiServiceFactory thirdPartyApiServiceFactory = ThirdPartyApiServiceFactory.INSTANCE;
        OkHttpClient okHttpClientMakeOkHttpClient = thirdPartyApiServiceFactory.makeOkHttpClient(SetsKt.setOf(thirdPartyApiServiceFactory.makeLoggingInterceptor()));
        return (IpifyApi) new Retrofit.Builder().baseUrl(IpifyApiKt.IPIFY_BASE_URL).client(okHttpClientMakeOkHttpClient).addCallAdapterFactory(new NetworkResponseAdapterFactory()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(IpifyApi.class);
    }

    @Provides
    @Singleton
    public final IcanhazipApi providesIcanhazipApiService$remote_productionRelease(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        ThirdPartyApiServiceFactory thirdPartyApiServiceFactory = ThirdPartyApiServiceFactory.INSTANCE;
        OkHttpClient okHttpClientMakeOkHttpClient = thirdPartyApiServiceFactory.makeOkHttpClient(SetsKt.setOf(thirdPartyApiServiceFactory.makeLoggingInterceptor()));
        return (IcanhazipApi) new Retrofit.Builder().baseUrl(IcanhazipApiKt.ICANHAZIP_BASE_URL).client(okHttpClientMakeOkHttpClient).addCallAdapterFactory(new NetworkResponseAdapterFactory()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(IcanhazipApi.class);
    }
}
