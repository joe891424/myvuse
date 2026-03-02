package com.yoti.mobile.android.yotisdkcore.core.p085di;

import android.content.Context;
import android.content.res.Resources;
import com.yoti.mobile.android.common.p049ui.components.utils.CountryCodeHelper;
import com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider;
import com.yoti.mobile.android.common.p049ui.components.utils.LocaleCountryCodeHelper;
import com.yoti.mobile.android.common.p049ui.components.utils.ResourcesDemonymProvider;
import com.yoti.mobile.android.commonui.localisation.LanguageCompatKt;
import com.yoti.mobile.android.yotisdkcore.core.domain.DemonymProvider;
import com.yoti.mobile.android.yotisdkcore.core.view.localisation.LocalisedCountriesProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/di/CountryHelperModule;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "providesCountryCodeHelper", "Lcom/yoti/mobile/android/common/ui/components/utils/CountryCodeHelper;", "demonymProvider", "Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;", "providesExternalDemonymProvider", "providesLocalisedCountriesProvider", "Lcom/yoti/mobile/android/yotisdkcore/core/view/localisation/LocalisedCountriesProvider;", "providesYdsDemonymProvider", "externalDemonymProvider", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public final class CountryHelperModule {
    private final Context applicationContext;

    public CountryHelperModule(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    @Provides
    public final CountryCodeHelper providesCountryCodeHelper(@YdsDemonymProvider IDemonymProvider demonymProvider) {
        Intrinsics.checkNotNullParameter(demonymProvider, "demonymProvider");
        Resources resources = this.applicationContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "applicationContext.resources");
        return new LocaleCountryCodeHelper(resources, demonymProvider);
    }

    @Provides
    @ExternalDemonymProvider
    public final IDemonymProvider providesExternalDemonymProvider() {
        return new ResourcesDemonymProvider(this.applicationContext, LanguageCompatKt.getLanguagesCompat());
    }

    @Provides
    @Singleton
    public final LocalisedCountriesProvider providesLocalisedCountriesProvider() {
        return new LocalisedCountriesProvider();
    }

    @Provides
    @YdsDemonymProvider
    public final IDemonymProvider providesYdsDemonymProvider(@ExternalDemonymProvider IDemonymProvider externalDemonymProvider) {
        Intrinsics.checkNotNullParameter(externalDemonymProvider, "externalDemonymProvider");
        return new DemonymProvider(externalDemonymProvider, LanguageCompatKt.getLocaleCompat());
    }
}
