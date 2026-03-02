package com.yoti.mobile.android.yotisdkcore.p081b;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.yotisdkcore.C4957R;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.b.d */
/* JADX INFO: loaded from: classes4.dex */
public final class C4968d implements ViewBinding {

    /* JADX INFO: renamed from: a */
    private final ConstraintLayout f7584a;

    /* JADX INFO: renamed from: b */
    public final YotiAppbar f7585b;

    /* JADX INFO: renamed from: c */
    public final ImageView f7586c;

    /* JADX INFO: renamed from: d */
    public final ProgressBar f7587d;

    /* JADX INFO: renamed from: e */
    public final TextView f7588e;

    private C4968d(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, ImageView imageView, ProgressBar progressBar, TextView textView) {
        this.f7584a = constraintLayout;
        this.f7585b = yotiAppbar;
        this.f7586c = imageView;
        this.f7587d = progressBar;
        this.f7588e = textView;
    }

    /* JADX INFO: renamed from: a */
    public static C4968d m5104a(View view) {
        int i = C4957R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4957R.id.imageUploadIcon;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4957R.id.progressBar;
                ProgressBar progressBar = (ProgressBar) view.findViewById(i);
                if (progressBar != null) {
                    i = C4957R.id.textViewDocumentUploadTitle;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        return new C4968d((ConstraintLayout) view, yotiAppbar, imageView, progressBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f7584a;
    }
}
