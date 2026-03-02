package com.yoti.mobile.android.commonui;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewFragmentArgs.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/WebViewFragmentArgs;", "Landroidx/navigation/NavArgs;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "Companion", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class WebViewFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String url;

    public static /* synthetic */ WebViewFragmentArgs copy$default(WebViewFragmentArgs webViewFragmentArgs, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webViewFragmentArgs.url;
        }
        return webViewFragmentArgs.copy(str);
    }

    @JvmStatic
    public static final WebViewFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final WebViewFragmentArgs copy(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new WebViewFragmentArgs(url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof WebViewFragmentArgs) && Intrinsics.areEqual(this.url, ((WebViewFragmentArgs) other).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "WebViewFragmentArgs(url=" + this.url + ')';
    }

    public WebViewFragmentArgs(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("url", this.url);
        return bundle;
    }

    /* JADX INFO: compiled from: WebViewFragmentArgs.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/WebViewFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/commonui/WebViewFragmentArgs;", "bundle", "Landroid/os/Bundle;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WebViewFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(WebViewFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("url")) {
                String string = bundle.getString("url");
                if (string == null) {
                    throw new IllegalArgumentException("Argument \"url\" is marked as non-null but was passed a null value.");
                }
                return new WebViewFragmentArgs(string);
            }
            throw new IllegalArgumentException("Required argument \"url\" is missing and does not have an android:defaultValue");
        }
    }
}
