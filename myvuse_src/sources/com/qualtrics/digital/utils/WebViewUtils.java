package com.qualtrics.digital.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/qualtrics/digital/utils/WebViewUtils;", "", "()V", "BROWSER_URI_SCHEMA", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "createBrowsingIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "url", "", "isNullOrGenericHandler", "", "filter", "Landroid/content/IntentFilter;", "isSpecializedHandlerAvailable", "intent", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class WebViewUtils {
    public static final WebViewUtils INSTANCE = new WebViewUtils();
    private static final Pattern BROWSER_URI_SCHEMA = Pattern.compile("(?i)((?:http|https|file):\\/\\/|(?:inline|data|about|chrome|javascript):)(.*)");

    private WebViewUtils() {
    }

    public final Intent createBrowsingIntent(Context context, String url) throws ActivityNotFoundException, URISyntaxException, SecurityException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = Intent.parseUri(url, 1);
        if (BROWSER_URI_SCHEMA.matcher(url).matches()) {
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            if (!isSpecializedHandlerAvailable(context, intent)) {
                return null;
            }
        }
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setComponent(null);
        Intent selector = intent.getSelector();
        if (selector != null) {
            selector.addCategory("android.intent.category.BROWSABLE");
            selector.setComponent(null);
        }
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        intent.addFlags(1476395008);
        return intent;
    }

    private final boolean isSpecializedHandlerAvailable(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "pm.queryIntentActivities…RESOLVED_FILTER\n        )");
        if (listQueryIntentActivities.isEmpty()) {
            return false;
        }
        Iterator<ResolveInfo> it2 = listQueryIntentActivities.iterator();
        while (it2.hasNext()) {
            if (!isNullOrGenericHandler(it2.next().filter)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNullOrGenericHandler(IntentFilter filter) {
        return filter == null || (filter.countDataAuthorities() == 0 && filter.countDataPaths() == 0);
    }
}
