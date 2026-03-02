package com.yoti.mobile.android.common.p049ui.components.country;

import com.yoti.mobile.android.common.p049ui.components.utils.CountryCodeHelper;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.components.country.c */
/* JADX INFO: loaded from: classes5.dex */
class C4473c {

    /* JADX INFO: renamed from: a */
    private CountryCodeHelper f5885a;

    /* JADX INFO: renamed from: b */
    private List<Country> f5886b;

    C4473c(CountryCodeHelper countryCodeHelper) {
        this.f5885a = countryCodeHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public List<Country> m4375c() {
        if (this.f5886b == null) {
            this.f5886b = this.f5885a.getCountriesForDeviceSupportedPhoneCode();
        }
        return this.f5886b;
    }

    /* JADX INFO: renamed from: a */
    Country m4376a(String str) {
        return this.f5885a.getCountryForCode(str);
    }

    /* JADX INFO: renamed from: a */
    Single<List<Country>> m4377a() {
        return Single.fromCallable(new Callable() { // from class: com.yoti.mobile.android.common.ui.components.country.c$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m4375c();
            }
        });
    }

    /* JADX INFO: renamed from: b */
    Country m4378b() {
        return m4376a(this.f5885a.getSuitableLocale(null).getCountry());
    }
}
