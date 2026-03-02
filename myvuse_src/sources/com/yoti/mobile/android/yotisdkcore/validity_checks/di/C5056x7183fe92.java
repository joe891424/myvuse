package com.yoti.mobile.android.yotisdkcore.validity_checks.di;

import com.yoti.mobile.android.yotisdkcore.p082c.domain.IDocumentSchemeValidityChecksRepository;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.DocumentSchemeValidityChecksRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.di.DocumentSchemeValidityChecksModule_ProvidesDocumentSchemeValidityCheckRepositoryFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C5056x7183fe92 implements Factory<IDocumentSchemeValidityChecksRepository> {

    /* JADX INFO: renamed from: a */
    private final DocumentSchemeValidityChecksModule f7900a;

    /* JADX INFO: renamed from: b */
    private final Provider<DocumentSchemeValidityChecksRepository> f7901b;

    public C5056x7183fe92(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, Provider<DocumentSchemeValidityChecksRepository> provider) {
        this.f7901b = provider;
    }

    public static C5056x7183fe92 create(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, Provider<DocumentSchemeValidityChecksRepository> provider) {
        return new C5056x7183fe92(documentSchemeValidityChecksModule, provider);
    }

    public static IDocumentSchemeValidityChecksRepository providesDocumentSchemeValidityCheckRepository(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, DocumentSchemeValidityChecksRepository documentSchemeValidityChecksRepository) {
        return (IDocumentSchemeValidityChecksRepository) Preconditions.checkNotNullFromProvides(documentSchemeValidityChecksModule.m5358a(documentSchemeValidityChecksRepository));
    }

    @Override // javax.inject.Provider
    public IDocumentSchemeValidityChecksRepository get() {
        return providesDocumentSchemeValidityCheckRepository(this.f7900a, this.f7901b.get());
    }
}
