package com.yoti.mobile.documentscanconfig;

import android.content.Context;
import com.yoti.mobile.documentscanconfig.json.C5068a;
import com.yoti.mobile.documentscanconfig.json.C5069b;
import com.yoti.mobile.documentscanconfig.json.C5070c;
import com.yoti.mobile.documentscanconfig.json.CountrySupportedDocumentsJsonConfig;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.e */
/* JADX INFO: loaded from: classes4.dex */
public final class C5063e implements InterfaceC5067i, InterfaceC5066h {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ KProperty[] f7914a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C5063e.class), "jsonConfig", "getJsonConfig()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: b */
    private final Lazy f7915b;

    /* JADX INFO: renamed from: c */
    private final List<String> f7916c;

    /* JADX INFO: renamed from: d */
    private final List<CountryCode> f7917d;

    /* JADX INFO: renamed from: e */
    private final Context f7918e;

    /* JADX INFO: renamed from: f */
    private final C5069b f7919f;

    /* JADX INFO: renamed from: g */
    private final C5068a f7920g;

    /* JADX INFO: renamed from: h */
    private final C5070c f7921h;

    public C5063e(Context context, C5069b supportedCountryDocumentsJson, C5068a countrySupportedDocumentsJsonConfigMapper, C5070c countrySupportedDocumentsJsonMapper) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(supportedCountryDocumentsJson, "supportedCountryDocumentsJson");
        Intrinsics.checkParameterIsNotNull(countrySupportedDocumentsJsonConfigMapper, "countrySupportedDocumentsJsonConfigMapper");
        Intrinsics.checkParameterIsNotNull(countrySupportedDocumentsJsonMapper, "countrySupportedDocumentsJsonMapper");
        this.f7918e = context;
        this.f7919f = supportedCountryDocumentsJson;
        this.f7920g = countrySupportedDocumentsJsonConfigMapper;
        this.f7921h = countrySupportedDocumentsJsonMapper;
        this.f7915b = LazyKt.lazy(new C5062d(this));
        this.f7916c = new ArrayList();
        this.f7917d = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final List<CountryCode> m5364b() {
        if (this.f7917d.isEmpty()) {
            this.f7917d.addAll(this.f7920g.m5372a(m5367c()));
        }
        return this.f7917d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final List<String> m5365b(CountryCode countryCode) {
        if (this.f7916c.isEmpty()) {
            this.f7916c.addAll(this.f7921h.m5374a(countryCode, m5367c()));
        }
        return this.f7916c;
    }

    /* JADX INFO: renamed from: c */
    private final Map<String, CountrySupportedDocumentsJsonConfig> m5367c() {
        Lazy lazy = this.f7915b;
        KProperty kProperty = f7914a[0];
        return (Map) lazy.getValue();
    }

    @Override // com.yoti.mobile.documentscanconfig.InterfaceC5066h
    /* JADX INFO: renamed from: a */
    public Single<List<CountryCode>> mo5368a() {
        Single<List<CountryCode>> singleFromCallable = Single.fromCallable(new CallableC5060b(this));
        Intrinsics.checkExpressionValueIsNotNull(singleFromCallable, "Single.fromCallable {\n  …dCountriesMap()\n        }");
        return singleFromCallable;
    }

    @Override // com.yoti.mobile.documentscanconfig.InterfaceC5067i
    /* JADX INFO: renamed from: a */
    public Single<List<String>> mo5369a(CountryCode countryCode) {
        Intrinsics.checkParameterIsNotNull(countryCode, "countryCode");
        Single<List<String>> singleFromCallable = Single.fromCallable(new CallableC5061c(this, countryCode));
        Intrinsics.checkExpressionValueIsNotNull(singleFromCallable, "Single.fromCallable {\n  …ap(countryCode)\n        }");
        return singleFromCallable;
    }
}
