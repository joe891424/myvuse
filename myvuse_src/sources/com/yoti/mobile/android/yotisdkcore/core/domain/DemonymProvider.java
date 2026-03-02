package com.yoti.mobile.android.yotisdkcore.core.domain;

import com.yoti.mobile.android.common.p049ui.components.utils.Demonym;
import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/domain/DemonymProvider;", "Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;", "defaultDemonymProvider", "sdkLocale", "Ljava/util/Locale;", "(Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;Ljava/util/Locale;)V", "getDemonym", "Lcom/yoti/mobile/android/common/ui/components/utils/Demonym;", "iso3Code", "", "isSdkLanguageEnglish", "", "isUkIsoCode", "shouldOverrideName", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DemonymProvider implements IDemonymProvider {
    private final IDemonymProvider defaultDemonymProvider;
    private final Locale sdkLocale;

    public DemonymProvider(IDemonymProvider defaultDemonymProvider, Locale sdkLocale) {
        Intrinsics.checkNotNullParameter(defaultDemonymProvider, "defaultDemonymProvider");
        Intrinsics.checkNotNullParameter(sdkLocale, "sdkLocale");
        this.defaultDemonymProvider = defaultDemonymProvider;
        this.sdkLocale = sdkLocale;
    }

    private final boolean isSdkLanguageEnglish() {
        return Intrinsics.areEqual(this.sdkLocale.getLanguage(), Locale.ENGLISH.getLanguage());
    }

    private final boolean isUkIsoCode(String iso3Code) {
        return Intrinsics.areEqual(iso3Code, DemonymProviderKt.UK_ISO3_CODE);
    }

    private final boolean shouldOverrideName(String iso3Code) {
        return isUkIsoCode(iso3Code) && isSdkLanguageEnglish();
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider
    public Demonym getDemonym(String iso3Code) {
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        Demonym demonym = this.defaultDemonymProvider.getDemonym(iso3Code);
        if (demonym != null) {
            return shouldOverrideName(iso3Code) ? new Demonym(DemonymProviderKt.UK_DEMONYM, demonym.getLocale()) : demonym;
        }
        return null;
    }
}
