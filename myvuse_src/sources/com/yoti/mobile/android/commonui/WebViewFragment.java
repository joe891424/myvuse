package com.yoti.mobile.android.commonui;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.navigation.NavArgsLazy;
import com.yoti.mobile.android.commonui.databinding.YdsFragmentWebviewBinding;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WebViewFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/WebViewFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentWebviewBinding;", "getBinding", "()Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentWebviewBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "fragmentArgs", "Lcom/yoti/mobile/android/commonui/WebViewFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/commonui/WebViewFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "onDestroyView", "", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class WebViewFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(WebViewFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentWebviewBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;

    public WebViewFragment() {
        super(C4590R.layout.yds_fragment_webview);
        final WebViewFragment webViewFragment = this;
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(WebViewFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.commonui.WebViewFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = webViewFragment.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + webViewFragment + " has null arguments");
            }
        });
        this.binding = FragmentKt.viewBindingLazy(webViewFragment, new Function0<YdsFragmentWebviewBinding>() { // from class: com.yoti.mobile.android.commonui.WebViewFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentWebviewBinding invoke() {
                return YdsFragmentWebviewBinding.bind(this.this$0.requireView());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final WebViewFragmentArgs getFragmentArgs() {
        return (WebViewFragmentArgs) this.fragmentArgs.getValue();
    }

    private final YdsFragmentWebviewBinding getBinding() {
        return (YdsFragmentWebviewBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        final YdsFragmentWebviewBinding binding = getBinding();
        binding.webView.setWebViewClient(new WebViewClient() { // from class: com.yoti.mobile.android.commonui.WebViewFragment$onViewCreated$1$1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view2, String url) {
                ProgressBar progressBar = binding.progressBar;
                if (progressBar == null) {
                    return;
                }
                progressBar.setVisibility(8);
            }
        });
        binding.webView.loadUrl(getFragmentArgs().getUrl());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getBinding().webView.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        getBinding().webView.onPause();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        getBinding().webView.destroy();
        super.onDestroyView();
    }
}
