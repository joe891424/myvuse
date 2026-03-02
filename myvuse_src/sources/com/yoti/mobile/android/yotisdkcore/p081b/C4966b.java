package com.yoti.mobile.android.yotisdkcore.p081b;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.HorizontalScrollingGradient;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.yotisdkcore.C4957R;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.b.b */
/* JADX INFO: loaded from: classes4.dex */
public final class C4966b implements ViewBinding {

    /* JADX INFO: renamed from: a */
    private final ConstraintLayout f7575a;

    private C4966b(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, HorizontalScrollingGradient horizontalScrollingGradient, View view, View view2, View view3, View view4) {
        this.f7575a = constraintLayout;
    }

    /* JADX INFO: renamed from: a */
    public static C4966b m5100a(View view) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        View viewFindViewById4;
        int i = C4957R.id.appBarLoading;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4957R.id.loadingShimmerView;
            HorizontalScrollingGradient horizontalScrollingGradient = (HorizontalScrollingGradient) view.findViewById(i);
            if (horizontalScrollingGradient != null && (viewFindViewById = view.findViewById((i = C4957R.id.viewFindOutHowLinkLoading))) != null && (viewFindViewById2 = view.findViewById((i = C4957R.id.viewMessageLoading))) != null && (viewFindViewById3 = view.findViewById((i = C4957R.id.viewStepsLoading))) != null && (viewFindViewById4 = view.findViewById((i = C4957R.id.viewTitleLoading))) != null) {
                return new C4966b((ConstraintLayout) view, yotiAppbar, horizontalScrollingGradient, viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f7575a;
    }
}
