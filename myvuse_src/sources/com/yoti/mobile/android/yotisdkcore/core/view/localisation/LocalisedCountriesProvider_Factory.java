package com.yoti.mobile.android.yotisdkcore.core.view.localisation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalisedCountriesProvider_Factory implements Factory<LocalisedCountriesProvider> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider_Factory$a */
    private static final class C4985a {

        /* JADX INFO: renamed from: a */
        private static final LocalisedCountriesProvider_Factory f7611a = new LocalisedCountriesProvider_Factory();
    }

    public static LocalisedCountriesProvider_Factory create() {
        return C4985a.f7611a;
    }

    public static LocalisedCountriesProvider newInstance() {
        return new LocalisedCountriesProvider();
    }

    @Override // javax.inject.Provider
    public LocalisedCountriesProvider get() {
        return newInstance();
    }
}
