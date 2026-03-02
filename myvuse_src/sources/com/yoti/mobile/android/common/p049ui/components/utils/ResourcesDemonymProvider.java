package com.yoti.mobile.android.common.p049ui.components.utils;

import android.content.Context;
import android.content.res.Resources;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0010\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0014J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/components/utils/ResourcesDemonymProvider;", "Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;", "", "iso3Code", "Lcom/yoti/mobile/android/common/ui/components/utils/Demonym;", "getDemonym", "(Ljava/lang/String;)Lcom/yoti/mobile/android/common/ui/components/utils/Demonym;", "", "Ljava/util/Locale;", "b", "Ljava/util/List;", "locales", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "locale", "(Landroid/content/Context;Ljava/util/Locale;)V", "(Landroid/content/Context;)V", "uiComponents_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class ResourcesDemonymProvider implements IDemonymProvider {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<Locale> locales;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourcesDemonymProvider(Context context) {
        this(context, (List<Locale>) CollectionsKt.listOf((Object[]) new Locale[]{Locale.ENGLISH, Locale.FRENCH}));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public ResourcesDemonymProvider(Context context, List<Locale> locales) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locales, "locales");
        this.context = context;
        this.locales = locales;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourcesDemonymProvider(Context context, Locale locale) {
        this(context, (List<Locale>) CollectionsKt.listOf(locale));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locale, "locale");
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.utils.IDemonymProvider
    public Demonym getDemonym(String iso3Code) {
        Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
        Resources resources = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        int stringId = ResourcesDemonymProviderKt.getStringId(resources, this.context, iso3Code);
        Object obj = null;
        if (stringId <= 0) {
            return null;
        }
        Iterator<T> it2 = this.locales.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            String language = ((Locale) next).getLanguage();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            if (Intrinsics.areEqual(language, locale.getLanguage())) {
                obj = next;
                break;
            }
        }
        Locale integratorLocale = (Locale) obj;
        if (integratorLocale == null) {
            integratorLocale = Locale.ENGLISH;
        }
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(integratorLocale, "integratorLocale");
        String string = ResourcesDemonymProviderKt.getLocalisedContext(context, integratorLocale).getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getLocalisedCont…le).getString(resourceId)");
        return new Demonym(string, integratorLocale);
    }
}
