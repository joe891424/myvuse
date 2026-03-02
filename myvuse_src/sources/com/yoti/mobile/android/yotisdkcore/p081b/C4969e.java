package com.yoti.mobile.android.yotisdkcore.p081b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.yotisdkcore.C4957R;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.b.e */
/* JADX INFO: loaded from: classes4.dex */
public final class C4969e implements ViewBinding {

    /* JADX INFO: renamed from: a */
    private final ConstraintLayout f7589a;

    private C4969e(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f7589a = constraintLayout;
    }

    /* JADX INFO: renamed from: a */
    public static C4969e m5106a(View view) {
        int i = C4957R.id.imageViewHead;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4957R.id.tvCompleteViewMessage;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4957R.id.tvCompleteViewTitle;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new C4969e((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f7589a;
    }
}
