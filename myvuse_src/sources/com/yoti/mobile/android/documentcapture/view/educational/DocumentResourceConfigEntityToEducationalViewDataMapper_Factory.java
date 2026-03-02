package com.yoti.mobile.android.documentcapture.view.educational;

import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentResourceConfigEntityToEducationalViewDataMapper_Factory implements Factory<DocumentResourceConfigEntityToEducationalViewDataMapper> {
    private final Provider<CountryEntityToViewDataMapper> countryEntityToViewDataMapperProvider;
    private final Provider<DocumentEducationalArgumentsToViewDataMapper> documentEducationalArgumentsToViewDataMapperProvider;
    private final Provider<CaptureObjectiveTypeEntityToViewDataMapper> objectiveTypeEntityToViewDataMapperProvider;

    public DocumentResourceConfigEntityToEducationalViewDataMapper_Factory(Provider<DocumentEducationalArgumentsToViewDataMapper> provider, Provider<CountryEntityToViewDataMapper> provider2, Provider<CaptureObjectiveTypeEntityToViewDataMapper> provider3) {
        this.documentEducationalArgumentsToViewDataMapperProvider = provider;
        this.countryEntityToViewDataMapperProvider = provider2;
        this.objectiveTypeEntityToViewDataMapperProvider = provider3;
    }

    public static DocumentResourceConfigEntityToEducationalViewDataMapper_Factory create(Provider<DocumentEducationalArgumentsToViewDataMapper> provider, Provider<CountryEntityToViewDataMapper> provider2, Provider<CaptureObjectiveTypeEntityToViewDataMapper> provider3) {
        return new DocumentResourceConfigEntityToEducationalViewDataMapper_Factory(provider, provider2, provider3);
    }

    public static DocumentResourceConfigEntityToEducationalViewDataMapper newInstance(DocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper, CountryEntityToViewDataMapper countryEntityToViewDataMapper, CaptureObjectiveTypeEntityToViewDataMapper captureObjectiveTypeEntityToViewDataMapper) {
        return new DocumentResourceConfigEntityToEducationalViewDataMapper(documentEducationalArgumentsToViewDataMapper, countryEntityToViewDataMapper, captureObjectiveTypeEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public DocumentResourceConfigEntityToEducationalViewDataMapper get() {
        return newInstance(this.documentEducationalArgumentsToViewDataMapperProvider.get(), this.countryEntityToViewDataMapperProvider.get(), this.objectiveTypeEntityToViewDataMapperProvider.get());
    }
}
