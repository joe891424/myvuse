package com.yoti.mobile.android.yotisdkcore.validity_checks.di;

import com.yoti.mobile.android.yotisdkcore.validity_checks.data.IDocumentSchemeValidityChecksDataSource;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.remote.DocumentSchemeValidityChecksRemoteDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.di.DocumentSchemeValidityChecksModule_ProvidesDocumentSchemeValidityCheckDataSourceFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C5055x912f1917 implements Factory<IDocumentSchemeValidityChecksDataSource> {

    /* JADX INFO: renamed from: a */
    private final DocumentSchemeValidityChecksModule f7898a;

    /* JADX INFO: renamed from: b */
    private final Provider<DocumentSchemeValidityChecksRemoteDataSource> f7899b;

    public C5055x912f1917(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, Provider<DocumentSchemeValidityChecksRemoteDataSource> provider) {
        this.f7899b = provider;
    }

    public static C5055x912f1917 create(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, Provider<DocumentSchemeValidityChecksRemoteDataSource> provider) {
        return new C5055x912f1917(documentSchemeValidityChecksModule, provider);
    }

    public static IDocumentSchemeValidityChecksDataSource providesDocumentSchemeValidityCheckDataSource(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, DocumentSchemeValidityChecksRemoteDataSource documentSchemeValidityChecksRemoteDataSource) {
        return (IDocumentSchemeValidityChecksDataSource) Preconditions.checkNotNullFromProvides(documentSchemeValidityChecksModule.m5359a(documentSchemeValidityChecksRemoteDataSource));
    }

    @Override // javax.inject.Provider
    public IDocumentSchemeValidityChecksDataSource get() {
        return providesDocumentSchemeValidityCheckDataSource(this.f7898a, this.f7899b.get());
    }
}
