package com.yoti.mobile.android.documentcapture.p055id.data;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class NfcPassportCountriesRepository_Factory implements Factory<NfcPassportCountriesRepository> {
    private final Provider<INfcPassportCountriesDataSource> dataSourceProvider;

    public NfcPassportCountriesRepository_Factory(Provider<INfcPassportCountriesDataSource> provider) {
        this.dataSourceProvider = provider;
    }

    public static NfcPassportCountriesRepository_Factory create(Provider<INfcPassportCountriesDataSource> provider) {
        return new NfcPassportCountriesRepository_Factory(provider);
    }

    public static NfcPassportCountriesRepository newInstance(INfcPassportCountriesDataSource iNfcPassportCountriesDataSource) {
        return new NfcPassportCountriesRepository(iNfcPassportCountriesDataSource);
    }

    @Override // javax.inject.Provider
    public NfcPassportCountriesRepository get() {
        return newInstance(this.dataSourceProvider.get());
    }
}
