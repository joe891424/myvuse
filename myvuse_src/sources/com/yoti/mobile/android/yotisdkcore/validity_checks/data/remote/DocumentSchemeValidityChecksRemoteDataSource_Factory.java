package com.yoti.mobile.android.yotisdkcore.validity_checks.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentSchemeValidityChecksRemoteDataSource_Factory implements Factory<DocumentSchemeValidityChecksRemoteDataSource> {

    /* JADX INFO: renamed from: a */
    private final Provider<DocumentSchemeValidityChecksApiService> f7892a;

    public DocumentSchemeValidityChecksRemoteDataSource_Factory(Provider<DocumentSchemeValidityChecksApiService> provider) {
        this.f7892a = provider;
    }

    public static DocumentSchemeValidityChecksRemoteDataSource_Factory create(Provider<DocumentSchemeValidityChecksApiService> provider) {
        return new DocumentSchemeValidityChecksRemoteDataSource_Factory(provider);
    }

    public static DocumentSchemeValidityChecksRemoteDataSource newInstance(DocumentSchemeValidityChecksApiService documentSchemeValidityChecksApiService) {
        return new DocumentSchemeValidityChecksRemoteDataSource(documentSchemeValidityChecksApiService);
    }

    @Override // javax.inject.Provider
    public DocumentSchemeValidityChecksRemoteDataSource get() {
        return newInstance(this.f7892a.get());
    }
}
