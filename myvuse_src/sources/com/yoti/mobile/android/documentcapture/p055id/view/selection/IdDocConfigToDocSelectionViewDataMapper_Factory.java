package com.yoti.mobile.android.documentcapture.p055id.view.selection;

import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.selection.CountryEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocConfigToDocSelectionViewDataMapper_Factory implements Factory<IdDocConfigToDocSelectionViewDataMapper> {
    private final Provider<CountryEntityToViewDataMapper> countryEntityToViewDataMapperProvider;
    private final Provider<CaptureObjectiveTypeEntityToViewDataMapper> objectiveTypeEntityToViewDataMapperProvider;

    public IdDocConfigToDocSelectionViewDataMapper_Factory(Provider<CountryEntityToViewDataMapper> provider, Provider<CaptureObjectiveTypeEntityToViewDataMapper> provider2) {
        this.countryEntityToViewDataMapperProvider = provider;
        this.objectiveTypeEntityToViewDataMapperProvider = provider2;
    }

    public static IdDocConfigToDocSelectionViewDataMapper_Factory create(Provider<CountryEntityToViewDataMapper> provider, Provider<CaptureObjectiveTypeEntityToViewDataMapper> provider2) {
        return new IdDocConfigToDocSelectionViewDataMapper_Factory(provider, provider2);
    }

    public static IdDocConfigToDocSelectionViewDataMapper newInstance(CountryEntityToViewDataMapper countryEntityToViewDataMapper, CaptureObjectiveTypeEntityToViewDataMapper captureObjectiveTypeEntityToViewDataMapper) {
        return new IdDocConfigToDocSelectionViewDataMapper(countryEntityToViewDataMapper, captureObjectiveTypeEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public IdDocConfigToDocSelectionViewDataMapper get() {
        return newInstance(this.countryEntityToViewDataMapperProvider.get(), this.objectiveTypeEntityToViewDataMapperProvider.get());
    }
}
