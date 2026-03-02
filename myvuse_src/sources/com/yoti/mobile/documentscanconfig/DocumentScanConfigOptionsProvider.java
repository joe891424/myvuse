package com.yoti.mobile.documentscanconfig;

import android.content.Context;
import com.yoti.mobile.documentscanconfig.json.C5068a;
import com.yoti.mobile.documentscanconfig.json.C5069b;
import com.yoti.mobile.documentscanconfig.json.C5070c;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/documentscanconfig/DocumentScanConfigOptionsProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "configRepository", "Lcom/yoti/mobile/documentscanconfig/EmbeddedScanConfigRepository;", "getSupportedCountries", "Lio/reactivex/Single;", "", "Lcom/yoti/mobile/documentscanconfig/CountryCode;", "getSupportedDocuments", "", "country", "documentscanconfig_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class DocumentScanConfigOptionsProvider {

    /* JADX INFO: renamed from: a */
    private final C5063e f7907a;

    public DocumentScanConfigOptionsProvider(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f7907a = new C5063e(context, new C5069b(), new C5068a(), new C5070c());
    }

    public final Single<List<CountryCode>> getSupportedCountries() {
        return new C5064f(this.f7907a).m5370a();
    }

    public final Single<List<String>> getSupportedDocuments(CountryCode country) {
        Intrinsics.checkParameterIsNotNull(country, "country");
        return new C5065g(this.f7907a).m5371a(country);
    }
}
