package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentImageLoader;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class TextExtractionErrorViewModel_Factory implements Factory<TextExtractionErrorViewModel> {
    private final Provider<ErrorToSessionStatusTypeMapper> errorToSessionStatusTypeMapperProvider;
    private final Provider<DocumentImageLoader> imageLoaderProvider;
    private final Provider<LocalisedCountriesProvider> localisedCountriesProvider;
    private final Provider<SessionStatus> sessionStatusProvider;

    public TextExtractionErrorViewModel_Factory(Provider<DocumentImageLoader> provider, Provider<LocalisedCountriesProvider> provider2, Provider<SessionStatus> provider3, Provider<ErrorToSessionStatusTypeMapper> provider4) {
        this.imageLoaderProvider = provider;
        this.localisedCountriesProvider = provider2;
        this.sessionStatusProvider = provider3;
        this.errorToSessionStatusTypeMapperProvider = provider4;
    }

    public static TextExtractionErrorViewModel_Factory create(Provider<DocumentImageLoader> provider, Provider<LocalisedCountriesProvider> provider2, Provider<SessionStatus> provider3, Provider<ErrorToSessionStatusTypeMapper> provider4) {
        return new TextExtractionErrorViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static TextExtractionErrorViewModel newInstance(DocumentImageLoader documentImageLoader, LocalisedCountriesProvider localisedCountriesProvider, SessionStatus sessionStatus, ErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        return new TextExtractionErrorViewModel(documentImageLoader, localisedCountriesProvider, sessionStatus, errorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public TextExtractionErrorViewModel get() {
        return newInstance(this.imageLoaderProvider.get(), this.localisedCountriesProvider.get(), this.sessionStatusProvider.get(), this.errorToSessionStatusTypeMapperProvider.get());
    }
}
