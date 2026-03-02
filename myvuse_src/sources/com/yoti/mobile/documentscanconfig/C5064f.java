package com.yoti.mobile.documentscanconfig;

import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.f */
/* JADX INFO: loaded from: classes4.dex */
public final class C5064f {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5066h f7922a;

    public C5064f(InterfaceC5066h countriesRepository) {
        Intrinsics.checkParameterIsNotNull(countriesRepository, "countriesRepository");
        this.f7922a = countriesRepository;
    }

    /* JADX INFO: renamed from: a */
    public final Single<List<CountryCode>> m5370a() {
        return this.f7922a.mo5368a();
    }
}
