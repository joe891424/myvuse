package androidx.webkit;

import android.webkit.WebResourceRequest;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ApiHelperForN;
import androidx.webkit.internal.WebResourceRequestAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;

/* JADX INFO: loaded from: classes.dex */
public class WebResourceRequestCompat {
    private WebResourceRequestCompat() {
    }

    public static boolean isRedirect(WebResourceRequest webResourceRequest) {
        ApiFeature.C1226N c1226n = WebViewFeatureInternal.WEB_RESOURCE_REQUEST_IS_REDIRECT;
        if (c1226n.isSupportedByFramework()) {
            return ApiHelperForN.isRedirect(webResourceRequest);
        }
        if (c1226n.isSupportedByWebView()) {
            return getAdapter(webResourceRequest).isRedirect();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private static WebResourceRequestAdapter getAdapter(WebResourceRequest webResourceRequest) {
        return WebViewGlueCommunicator.getCompatConverter().convertWebResourceRequest(webResourceRequest);
    }
}
