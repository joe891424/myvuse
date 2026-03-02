package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentWebviewBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final WebView webView;

    private YdsFragmentWebviewBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, WebView webView) {
        this.rootView = constraintLayout;
        this.progressBar = progressBar;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static YdsFragmentWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_fragment_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsFragmentWebviewBinding bind(View view) {
        int i = C4590R.id.progressBar;
        ProgressBar progressBar = (ProgressBar) view.findViewById(i);
        if (progressBar != null) {
            i = C4590R.id.webView;
            WebView webView = (WebView) view.findViewById(i);
            if (webView != null) {
                return new YdsFragmentWebviewBinding((ConstraintLayout) view, progressBar, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
