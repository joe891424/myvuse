package com.facetec.sdk;

import android.app.Fragment;
import android.widget.RelativeLayout;
import com.facetec.sdk.C2188cb;

/* JADX INFO: renamed from: com.facetec.sdk.n */
/* JADX INFO: loaded from: classes3.dex */
final class C2224n extends AbstractRunnableC2150ap {

    /* JADX INFO: renamed from: Z */
    final /* synthetic */ GuidanceCenterContentFragment f3523Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2224n(GuidanceCenterContentFragment guidanceCenterContentFragment, Fragment fragment) {
        super(fragment);
        this.f3523Z = guidanceCenterContentFragment;
    }

    @Override // com.facetec.sdk.AbstractRunnableC2150ap
    final void Code() {
        boolean z;
        boolean z2;
        int i;
        int i2;
        float fM1644I = C2156av.m1644I();
        int iRound = Math.round(C2156av.m1675V() * C2156av.Code());
        int iRound2 = Math.round(C2188cb.m1993V(C2156av.f2639Z) * C2156av.Code() * fM1644I);
        int iRound3 = Math.round(C2188cb.m1993V(5) * C2156av.Code() * fM1644I);
        float f = this.f3523Z.getArguments().getFloat("bottomOval");
        float f2 = this.f3523Z.getArguments().getFloat("topOval") - (iRound << 1);
        int i3 = iRound3 << 1;
        float f3 = i3;
        float f4 = f2 - f3;
        float measuredHeight = (this.f3523Z.f2264e.getMeasuredHeight() - f) - f3;
        int measuredHeight2 = this.f3523Z.f2253D.getMeasuredHeight() - i3;
        int iFloor = (int) Math.floor(f4);
        if (f4 < measuredHeight2) {
            iFloor = measuredHeight2 + (iRound3 << 2);
            z = true;
        } else {
            z = false;
        }
        int measuredHeight3 = this.f3523Z.f2257S.getMeasuredHeight() - i3;
        int iFloor2 = (int) Math.floor(measuredHeight);
        if (measuredHeight < measuredHeight3) {
            iFloor2 = measuredHeight3 + (iRound3 << 2);
            z2 = true;
        } else {
            z2 = false;
        }
        int i4 = (z && C2156av.m1717aU()) ? iRound2 : 0;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iFloor);
        layoutParams.setMargins(i4, 0, i4, 0);
        layoutParams.addRule(10);
        this.f3523Z.f2261b.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, iFloor2);
        layoutParams2.setMargins(0, 0, 0, iRound3);
        layoutParams2.addRule(12);
        this.f3523Z.f2263d.setLayoutParams(layoutParams2);
        if (z) {
            this.f3523Z.f2253D.setPadding(iRound3, iRound3, iRound3, iRound3);
            this.f3523Z.f2253D.setBackground(this.f3523Z.f2260a);
            this.f3523Z.f2253D.invalidate();
        }
        if (z2) {
            this.f3523Z.f2257S.setPadding(iRound3, iRound3, iRound3, iRound3);
            this.f3523Z.f2257S.setBackground(this.f3523Z.f2262c);
            this.f3523Z.f2257S.invalidate();
        }
        if (FaceTecSDK.f2235I.f2218Z) {
            this.f3523Z.f2257S.setOnClickRunnable(new Runnable() { // from class: com.facetec.sdk.n.5
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g abstractActivityC2219g = (AbstractActivityC2219g) C2224n.this.f3523Z.getActivity();
                    if (abstractActivityC2219g != null) {
                        abstractActivityC2219g.m2207n();
                    }
                }
            });
        }
        int iFloor3 = (int) Math.floor((((double) iFloor) / 2.0d) / 1.3d);
        int iFloor4 = (int) Math.floor((((double) iFloor2) / 2.0d) / 1.3d);
        int width = this.f3523Z.f2261b.getWidth();
        int width2 = this.f3523Z.f2263d.getWidth();
        if (z) {
            iFloor3 = (int) Math.floor(((double) (iFloor - i3)) / 2.0d);
            i = width - i3;
            i2 = i;
        } else {
            if (!C2156av.m1717aU()) {
                iRound2 = 0;
            }
            i = width - (iRound2 << 1);
            i2 = width;
        }
        if (z2) {
            iFloor4 = (int) Math.floor(((double) (iFloor2 - i3)) / 2.0d);
            width2 = this.f3523Z.f2263d.getWidth() - i3;
        }
        C2188cb.V v = new C2188cb.V(i, iFloor3);
        C2188cb.V v2 = new C2188cb.V(i2, iFloor3);
        C2188cb.V v3 = new C2188cb.V(width2, iFloor4);
        int iRound4 = Math.round(C2188cb.m1986B(8));
        int iRound5 = Math.round(C2188cb.m1986B(40));
        int iRound6 = Math.round(C2188cb.m1986B(5));
        int iRound7 = Math.round(C2188cb.m1986B(36));
        int iM1990I = C2188cb.m1990I(this.f3523Z.f2258V, v, iRound4, iRound5);
        int iM1990I2 = C2188cb.m1990I(this.f3523Z.f2254F, v2, iRound4, iRound5);
        int iM1990I3 = C2188cb.m1990I(this.f3523Z.f2256L, v3, iRound6, iRound7);
        int iM1990I4 = C2188cb.m1990I(this.f3523Z.f2252C, v3, iRound6, iRound7);
        int iMin = Math.min(iM1990I, iM1990I2);
        int iRound8 = (int) Math.round(((double) iMin) * 0.85d);
        if (iM1990I3 >= iRound8) {
            iM1990I3 = iRound8;
        }
        if (iM1990I4 >= iM1990I3) {
            iM1990I4 = iM1990I3;
        }
        float f5 = iMin;
        this.f3523Z.f2258V.setTextSize(0, f5);
        this.f3523Z.f2254F.setTextSize(0, f5);
        float f6 = iM1990I4;
        this.f3523Z.f2256L.setTextSize(0, f6);
        this.f3523Z.f2252C.setTextSize(0, f6);
    }
}
