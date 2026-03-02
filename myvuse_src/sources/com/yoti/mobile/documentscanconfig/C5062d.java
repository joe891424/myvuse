package com.yoti.mobile.documentscanconfig;

import com.yoti.mobile.documentscanconfig.json.C5069b;
import com.yoti.mobile.documentscanconfig.json.CountrySupportedDocumentsJsonConfig;
import java.io.InputStream;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.d */
/* JADX INFO: loaded from: classes4.dex */
final class C5062d extends Lambda implements Function0<Map<String, ? extends CountrySupportedDocumentsJsonConfig>> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5063e f7913a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C5062d(C5063e c5063e) {
        super(0);
        this.f7913a = c5063e;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends CountrySupportedDocumentsJsonConfig> invoke() {
        InputStream supportedCountriesInput = this.f7913a.f7918e.getResources().openRawResource(C5058R.raw.supported_documents_by_country);
        C5069b c5069b = this.f7913a.f7919f;
        Intrinsics.checkExpressionValueIsNotNull(supportedCountriesInput, "supportedCountriesInput");
        return c5069b.m5373a(supportedCountriesInput);
    }
}
