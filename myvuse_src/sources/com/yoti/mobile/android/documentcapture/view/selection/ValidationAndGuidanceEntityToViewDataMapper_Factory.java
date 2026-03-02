package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileAddressFormatter;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileDateOfBirthFormatter;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ValidationAndGuidanceEntityToViewDataMapper_Factory implements Factory<ValidationAndGuidanceEntityToViewDataMapper> {
    private final Provider<ApplicantProfileAddressFormatter> applicantProfileAddressFormatterProvider;
    private final Provider<ApplicantProfileDateOfBirthFormatter> applicantProfileDateOfBirthFormatterProvider;
    private final Provider<DocumentTypeEntityToViewDataMapper> documentTypeEntityToViewDataMapperProvider;
    private final Provider<LocalisedCountriesProvider> localisedCountriesProvider;

    public ValidationAndGuidanceEntityToViewDataMapper_Factory(Provider<DocumentTypeEntityToViewDataMapper> provider, Provider<LocalisedCountriesProvider> provider2, Provider<ApplicantProfileAddressFormatter> provider3, Provider<ApplicantProfileDateOfBirthFormatter> provider4) {
        this.documentTypeEntityToViewDataMapperProvider = provider;
        this.localisedCountriesProvider = provider2;
        this.applicantProfileAddressFormatterProvider = provider3;
        this.applicantProfileDateOfBirthFormatterProvider = provider4;
    }

    public static ValidationAndGuidanceEntityToViewDataMapper_Factory create(Provider<DocumentTypeEntityToViewDataMapper> provider, Provider<LocalisedCountriesProvider> provider2, Provider<ApplicantProfileAddressFormatter> provider3, Provider<ApplicantProfileDateOfBirthFormatter> provider4) {
        return new ValidationAndGuidanceEntityToViewDataMapper_Factory(provider, provider2, provider3, provider4);
    }

    public static ValidationAndGuidanceEntityToViewDataMapper newInstance(DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper, LocalisedCountriesProvider localisedCountriesProvider, ApplicantProfileAddressFormatter applicantProfileAddressFormatter, ApplicantProfileDateOfBirthFormatter applicantProfileDateOfBirthFormatter) {
        return new ValidationAndGuidanceEntityToViewDataMapper(documentTypeEntityToViewDataMapper, localisedCountriesProvider, applicantProfileAddressFormatter, applicantProfileDateOfBirthFormatter);
    }

    @Override // javax.inject.Provider
    public ValidationAndGuidanceEntityToViewDataMapper get() {
        return newInstance(this.documentTypeEntityToViewDataMapperProvider.get(), this.localisedCountriesProvider.get(), this.applicantProfileAddressFormatterProvider.get(), this.applicantProfileDateOfBirthFormatterProvider.get());
    }
}
