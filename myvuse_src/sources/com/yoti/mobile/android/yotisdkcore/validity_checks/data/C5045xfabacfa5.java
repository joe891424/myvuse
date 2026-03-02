package com.yoti.mobile.android.yotisdkcore.validity_checks.data;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.DocumentSchemeAssessmentEntityToValidityCheckRequestMapper_Factory */
/* JADX INFO: loaded from: classes4.dex */
public final class C5045xfabacfa5 implements Factory<DocumentSchemeAssessmentEntityToValidityCheckRequestMapper> {

    /* JADX INFO: renamed from: a */
    private final Provider<DocumentTypeEntityToDataMapper> f7873a;

    public C5045xfabacfa5(Provider<DocumentTypeEntityToDataMapper> provider) {
        this.f7873a = provider;
    }

    public static C5045xfabacfa5 create(Provider<DocumentTypeEntityToDataMapper> provider) {
        return new C5045xfabacfa5(provider);
    }

    public static DocumentSchemeAssessmentEntityToValidityCheckRequestMapper newInstance(DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper) {
        return new DocumentSchemeAssessmentEntityToValidityCheckRequestMapper(documentTypeEntityToDataMapper);
    }

    @Override // javax.inject.Provider
    public DocumentSchemeAssessmentEntityToValidityCheckRequestMapper get() {
        return newInstance(this.f7873a.get());
    }
}
