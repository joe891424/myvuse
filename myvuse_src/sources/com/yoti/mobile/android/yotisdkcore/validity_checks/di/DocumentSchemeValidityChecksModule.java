package com.yoti.mobile.android.yotisdkcore.validity_checks.di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotisdkcore.p082c.domain.IDocumentSchemeValidityChecksRepository;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.DocumentSchemeValidityChecksRepository;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.IDocumentSchemeValidityChecksDataSource;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.remote.DocumentSchemeValidityChecksApiService;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.remote.DocumentSchemeValidityChecksRemoteDataSource;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.di.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/di/DocumentSchemeValidityChecksModule;", "", "()V", "providesDocumentSchemeValidityCheckApiService", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/remote/DocumentSchemeValidityChecksApiService;", "apiServiceFactory", "Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "okHttpClient", "Lokhttp3/OkHttpClient;", "networkAdapterResponseFactory", "Lretrofit2/CallAdapter$Factory;", "providesDocumentSchemeValidityCheckDataSource", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/IDocumentSchemeValidityChecksDataSource;", "actual", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/remote/DocumentSchemeValidityChecksRemoteDataSource;", "providesDocumentSchemeValidityCheckRepository", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/IDocumentSchemeValidityChecksRepository;", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/DocumentSchemeValidityChecksRepository;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {RemoteModule.class})
public final class DocumentSchemeValidityChecksModule {
    @Provides
    /* JADX INFO: renamed from: a */
    public final IDocumentSchemeValidityChecksRepository m5358a(DocumentSchemeValidityChecksRepository documentSchemeValidityChecksRepository) {
        throw null;
    }

    @Provides
    /* JADX INFO: renamed from: a */
    public final IDocumentSchemeValidityChecksDataSource m5359a(DocumentSchemeValidityChecksRemoteDataSource documentSchemeValidityChecksRemoteDataSource) {
        throw null;
    }

    @Provides
    /* JADX INFO: renamed from: a */
    public final DocumentSchemeValidityChecksApiService m5360a(ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, CallAdapter.Factory factory) {
        throw null;
    }
}
