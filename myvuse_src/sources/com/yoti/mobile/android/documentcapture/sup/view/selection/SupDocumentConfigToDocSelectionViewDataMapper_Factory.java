package com.yoti.mobile.android.documentcapture.sup.view.selection;

import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentConfigToDocSelectionViewDataMapper_Factory implements Factory<SupDocumentConfigToDocSelectionViewDataMapper> {
    private final Provider<CountryEntityToViewDataMapper> countryEntityToViewDataMapperProvider;
    private final Provider<CaptureObjectiveTypeEntityToViewDataMapper> objectiveTypeToViewDataMapperProvider;

    public SupDocumentConfigToDocSelectionViewDataMapper_Factory(Provider<CountryEntityToViewDataMapper> provider, Provider<CaptureObjectiveTypeEntityToViewDataMapper> provider2) {
        this.countryEntityToViewDataMapperProvider = provider;
        this.objectiveTypeToViewDataMapperProvider = provider2;
    }

    public static SupDocumentConfigToDocSelectionViewDataMapper_Factory create(Provider<CountryEntityToViewDataMapper> provider, Provider<CaptureObjectiveTypeEntityToViewDataMapper> provider2) {
        return new SupDocumentConfigToDocSelectionViewDataMapper_Factory(provider, provider2);
    }

    public static SupDocumentConfigToDocSelectionViewDataMapper newInstance(CountryEntityToViewDataMapper countryEntityToViewDataMapper, CaptureObjectiveTypeEntityToViewDataMapper captureObjectiveTypeEntityToViewDataMapper) {
        return new SupDocumentConfigToDocSelectionViewDataMapper(countryEntityToViewDataMapper, captureObjectiveTypeEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public SupDocumentConfigToDocSelectionViewDataMapper get() {
        return newInstance(this.countryEntityToViewDataMapperProvider.get(), this.objectiveTypeToViewDataMapperProvider.get());
    }
}
