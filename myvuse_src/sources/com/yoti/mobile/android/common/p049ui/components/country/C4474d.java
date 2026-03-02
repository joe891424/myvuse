package com.yoti.mobile.android.common.p049ui.components.country;

import com.yoti.mobile.android.common.p049ui.components.utils.CountryCodeHelper;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.components.country.d */
/* JADX INFO: loaded from: classes5.dex */
class C4474d implements InterfaceC4471a {

    /* JADX INFO: renamed from: a */
    private InterfaceC4472b f5887a;

    /* JADX INFO: renamed from: b */
    private C4473c f5888b;

    /* JADX INFO: renamed from: c */
    private CompositeDisposable f5889c;

    C4474d(InterfaceC4472b interfaceC4472b, C4473c c4473c) {
        this.f5889c = new CompositeDisposable();
        this.f5887a = interfaceC4472b;
        this.f5888b = c4473c;
    }

    public C4474d(InterfaceC4472b interfaceC4472b, CountryCodeHelper countryCodeHelper) {
        this(interfaceC4472b, new C4473c(countryCodeHelper));
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.country.InterfaceC4471a
    /* JADX INFO: renamed from: a */
    public void mo4371a() {
        this.f5887a.showCountryAsSelected(this.f5888b.m4378b());
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.country.InterfaceC4471a
    /* JADX INFO: renamed from: a */
    public void mo4372a(String str) {
        this.f5887a.showCountryAsSelected(this.f5888b.m4376a(str));
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.country.InterfaceC4471a
    /* JADX INFO: renamed from: b */
    public void mo4373b() {
        CompositeDisposable compositeDisposable = this.f5889c;
        Single<List<Country>> singleObserveOn = this.f5888b.m4377a().subscribeOn(Schedulers.m5595io()).observeOn(AndroidSchedulers.mainThread());
        final InterfaceC4472b interfaceC4472b = this.f5887a;
        interfaceC4472b.getClass();
        compositeDisposable.add(singleObserveOn.subscribe(new Consumer() { // from class: com.yoti.mobile.android.common.ui.components.country.d$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                interfaceC4472b.setCountries((List) obj);
            }
        }));
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.country.InterfaceC4471a
    /* JADX INFO: renamed from: c */
    public void mo4374c() {
        this.f5889c.clear();
    }
}
