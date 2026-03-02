package com.yoti.mobile.android.common.p049ui.components.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\n\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m5598d2 = {"Landroid/content/Context;", "Ljava/util/Locale;", "locale", "getLocalisedContext", "(Landroid/content/Context;Ljava/util/Locale;)Landroid/content/Context;", "Landroid/content/res/Resources;", "context", "", "iso3Code", "", "getStringId", "(Landroid/content/res/Resources;Landroid/content/Context;Ljava/lang/String;)I", "uiComponents_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class ResourcesDemonymProviderKt {
    public static final Context getLocalisedContext(Context getLocalisedContext, Locale locale) {
        Intrinsics.checkNotNullParameter(getLocalisedContext, "$this$getLocalisedContext");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Resources resources = getLocalisedContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);
        Context contextCreateConfigurationContext = getLocalisedContext.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(resourceConfiguration)");
        return contextCreateConfigurationContext;
    }

    public static final int getStringId(Resources getStringId, Context context, String iso3Code) {
        Intrinsics.checkNotNullParameter(getStringId, "$this$getStringId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        String lowerCase = iso3Code.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return getStringId.getIdentifier("loc.countryname." + lowerCase + ".demonym", TypedValues.Custom.S_STRING, context.getPackageName());
    }
}
