package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApiFeature implements ConditionallySupportedFeature {
    private static final Set<ApiFeature> sValues = new HashSet();
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    public abstract boolean isSupportedByFramework();

    ApiFeature(String str, String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public String getPublicFeatureName() {
        return this.mPublicFeatureValue;
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public boolean isSupported() {
        return isSupportedByFramework() || isSupportedByWebView();
    }

    public boolean isSupportedByWebView() {
        return BoundaryInterfaceReflectionUtil.containsFeature(LAZY_HOLDER.WEBVIEW_APK_FEATURES, this.mInternalFeatureValue);
    }

    public static Set<ApiFeature> values() {
        return Collections.unmodifiableSet(sValues);
    }

    public static Set<String> getWebViewApkFeaturesForTesting() {
        return LAZY_HOLDER.WEBVIEW_APK_FEATURES;
    }

    private static class LAZY_HOLDER {
        static final Set<String> WEBVIEW_APK_FEATURES = new HashSet(Arrays.asList(WebViewGlueCommunicator.getFactory().getWebViewFeatures()));

        private LAZY_HOLDER() {
        }
    }

    public static class NoFramework extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return false;
        }

        NoFramework(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiFeature$M */
    public static class C1225M extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return true;
        }

        C1225M(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiFeature$N */
    public static class C1226N extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return true;
        }

        C1226N(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiFeature$O */
    public static class C1227O extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return true;
        }

        C1227O(String str, String str2) {
            super(str, str2);
        }
    }

    public static class O_MR1 extends ApiFeature {
        O_MR1(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiFeature$P */
    public static class C1228P extends ApiFeature {
        C1228P(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiFeature$Q */
    public static class C1229Q extends ApiFeature {
        C1229Q(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiFeature$T */
    public static class C1230T extends ApiFeature {
        C1230T(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }
}
