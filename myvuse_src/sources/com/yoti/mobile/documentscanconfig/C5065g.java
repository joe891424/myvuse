package com.yoti.mobile.documentscanconfig;

import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.g */
/* JADX INFO: loaded from: classes4.dex */
public final class C5065g {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5067i f7923a;

    public C5065g(InterfaceC5067i scanConfigRepository) {
        Intrinsics.checkParameterIsNotNull(scanConfigRepository, "scanConfigRepository");
        this.f7923a = scanConfigRepository;
    }

    /* JADX INFO: renamed from: a */
    public final Single<List<String>> m5371a(CountryCode country) {
        Intrinsics.checkParameterIsNotNull(country, "country");
        return this.f7923a.mo5369a(country);
    }
}
