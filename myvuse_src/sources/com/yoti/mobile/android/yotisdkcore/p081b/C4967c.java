package com.yoti.mobile.android.yotisdkcore.p081b;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.yotisdkcore.C4957R;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.b.c */
/* JADX INFO: loaded from: classes4.dex */
public final class C4967c implements ViewBinding {

    /* JADX INFO: renamed from: a */
    private final ConstraintLayout f7576a;

    /* JADX INFO: renamed from: b */
    public final YotiAppbar f7577b;

    /* JADX INFO: renamed from: c */
    public final YotiButton f7578c;

    /* JADX INFO: renamed from: d */
    public final YotiButton f7579d;

    /* JADX INFO: renamed from: e */
    public final C4969e f7580e;

    /* JADX INFO: renamed from: f */
    public final NestedScrollView f7581f;

    /* JADX INFO: renamed from: g */
    public final View f7582g;

    /* JADX INFO: renamed from: h */
    public final C4970f f7583h;

    private C4967c(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, Barrier barrier, YotiButton yotiButton, YotiButton yotiButton2, C4969e c4969e, NestedScrollView nestedScrollView, View view, C4970f c4970f, FrameLayout frameLayout) {
        this.f7576a = constraintLayout;
        this.f7577b = yotiAppbar;
        this.f7578c = yotiButton;
        this.f7579d = yotiButton2;
        this.f7580e = c4969e;
        this.f7581f = nestedScrollView;
        this.f7582g = view;
        this.f7583h = c4970f;
    }

    /* JADX INFO: renamed from: a */
    public static C4967c m5102a(View view) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        int i = C4957R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4957R.id.barrier;
            Barrier barrier = (Barrier) view.findViewById(i);
            if (barrier != null) {
                i = C4957R.id.buttonContinue;
                YotiButton yotiButton = (YotiButton) view.findViewById(i);
                if (yotiButton != null) {
                    i = C4957R.id.buttonGotIt;
                    YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
                    if (yotiButton2 != null && (viewFindViewById = view.findViewById((i = C4957R.id.completedView))) != null) {
                        C4969e c4969eM5106a = C4969e.m5106a(viewFindViewById);
                        i = C4957R.id.nestedScrollView;
                        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(i);
                        if (nestedScrollView != null && (viewFindViewById2 = view.findViewById((i = C4957R.id.shadow))) != null && (viewFindViewById3 = view.findViewById((i = C4957R.id.stepsView))) != null) {
                            C4970f c4970fM5108a = C4970f.m5108a(viewFindViewById3);
                            i = C4957R.id.stepsViewLayout;
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                            if (frameLayout != null) {
                                return new C4967c((ConstraintLayout) view, yotiAppbar, barrier, yotiButton, yotiButton2, c4969eM5106a, nestedScrollView, viewFindViewById2, c4970fM5108a, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f7576a;
    }
}
