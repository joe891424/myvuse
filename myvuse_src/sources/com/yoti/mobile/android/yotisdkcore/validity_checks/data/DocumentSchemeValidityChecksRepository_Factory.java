package com.yoti.mobile.android.yotisdkcore.validity_checks.data;

import com.yoti.mobile.android.yotisdkcore.core.data.remote.RemoteErrorToYdsErrorMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentSchemeValidityChecksRepository_Factory implements Factory<DocumentSchemeValidityChecksRepository> {

    /* JADX INFO: renamed from: a */
    private final Provider<IDocumentSchemeValidityChecksDataSource> f7875a;

    /* JADX INFO: renamed from: b */
    private final Provider<DocumentSchemeAssessmentEntityToValidityCheckRequestMapper> f7876b;

    /* JADX INFO: renamed from: c */
    private final Provider<DocumentSchemeValidityCheckDataToEntityMapper> f7877c;

    /* JADX INFO: renamed from: d */
    private final Provider<RemoteErrorToYdsErrorMapper> f7878d;

    public DocumentSchemeValidityChecksRepository_Factory(Provider<IDocumentSchemeValidityChecksDataSource> provider, Provider<DocumentSchemeAssessmentEntityToValidityCheckRequestMapper> provider2, Provider<DocumentSchemeValidityCheckDataToEntityMapper> provider3, Provider<RemoteErrorToYdsErrorMapper> provider4) {
        this.f7875a = provider;
        this.f7876b = provider2;
        this.f7877c = provider3;
        this.f7878d = provider4;
    }

    public static DocumentSchemeValidityChecksRepository_Factory create(Provider<IDocumentSchemeValidityChecksDataSource> provider, Provider<DocumentSchemeAssessmentEntityToValidityCheckRequestMapper> provider2, Provider<DocumentSchemeValidityCheckDataToEntityMapper> provider3, Provider<RemoteErrorToYdsErrorMapper> provider4) {
        return new DocumentSchemeValidityChecksRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static DocumentSchemeValidityChecksRepository newInstance(IDocumentSchemeValidityChecksDataSource iDocumentSchemeValidityChecksDataSource, DocumentSchemeAssessmentEntityToValidityCheckRequestMapper documentSchemeAssessmentEntityToValidityCheckRequestMapper, DocumentSchemeValidityCheckDataToEntityMapper documentSchemeValidityCheckDataToEntityMapper, RemoteErrorToYdsErrorMapper remoteErrorToYdsErrorMapper) {
        return new DocumentSchemeValidityChecksRepository(iDocumentSchemeValidityChecksDataSource, documentSchemeAssessmentEntityToValidityCheckRequestMapper, documentSchemeValidityCheckDataToEntityMapper, remoteErrorToYdsErrorMapper);
    }

    @Override // javax.inject.Provider
    public DocumentSchemeValidityChecksRepository get() {
        return newInstance(this.f7875a.get(), this.f7876b.get(), this.f7877c.get(), this.f7878d.get());
    }
}
