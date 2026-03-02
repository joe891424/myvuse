package com.yoti.mobile.android.yotisdkcore.p081b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.yotisdkcore.C4957R;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.b.f */
/* JADX INFO: loaded from: classes4.dex */
public final class C4970f implements ViewBinding {

    /* JADX INFO: renamed from: a */
    private final ConstraintLayout f7590a;

    /* JADX INFO: renamed from: b */
    public final RecyclerView f7591b;

    /* JADX INFO: renamed from: c */
    public final TextView f7592c;

    /* JADX INFO: renamed from: d */
    public final TextView f7593d;

    private C4970f(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f7590a = constraintLayout;
        this.f7591b = recyclerView;
        this.f7592c = textView;
        this.f7593d = textView2;
    }

    /* JADX INFO: renamed from: a */
    public static C4970f m5108a(View view) {
        int i = C4957R.id.stepRecyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        if (recyclerView != null) {
            i = C4957R.id.textViewMessage;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4957R.id.textViewTitle;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new C4970f((ConstraintLayout) view, recyclerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f7590a;
    }
}
