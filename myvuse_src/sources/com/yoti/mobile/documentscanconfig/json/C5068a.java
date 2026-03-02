package com.yoti.mobile.documentscanconfig.json;

import com.yoti.mobile.documentscanconfig.CountryCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.json.a */
/* JADX INFO: loaded from: classes4.dex */
public final class C5068a {
    /* JADX INFO: renamed from: a */
    public final List<CountryCode> m5372a(Map<String, CountrySupportedDocumentsJsonConfig> countriesConfigSupported) {
        Intrinsics.checkParameterIsNotNull(countriesConfigSupported, "countriesConfigSupported");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, CountrySupportedDocumentsJsonConfig>> it2 = countriesConfigSupported.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add(new CountryCode(CountryCode.Type.ISO_ALPHA_3, it2.next().getValue().getCodeAlpha3()));
        }
        return arrayList;
    }
}
