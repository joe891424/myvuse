package com.yoti.mobile.android.yotisdkcore.p081b;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.yotisdkcore.C4957R;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.b.a */
/* JADX INFO: loaded from: classes4.dex */
public final class C4965a implements ViewBinding {

    /* JADX INFO: renamed from: a */
    private final ConstraintLayout f7572a;

    /* JADX INFO: renamed from: b */
    public final C4966b f7573b;

    /* JADX INFO: renamed from: c */
    public final C4967c f7574c;

    private C4965a(ConstraintLayout constraintLayout, C4966b c4966b, C4967c c4967c) {
        this.f7572a = constraintLayout;
        this.f7573b = c4966b;
        this.f7574c = c4967c;
    }

    /* JADX INFO: renamed from: a */
    public static C4965a m5098a(View view) {
        int i = C4957R.id.loadingView;
        View viewFindViewById = view.findViewById(i);
        if (viewFindViewById != null) {
            C4966b c4966bM5100a = C4966b.m5100a(viewFindViewById);
            int i2 = C4957R.id.successView;
            View viewFindViewById2 = view.findViewById(i2);
            if (viewFindViewById2 != null) {
                return new C4965a((ConstraintLayout) view, c4966bM5100a, C4967c.m5102a(viewFindViewById2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f7572a;
    }
}
