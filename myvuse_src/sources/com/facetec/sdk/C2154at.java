package com.facetec.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facetec.sdk.at */
/* JADX INFO: loaded from: classes3.dex */
class C2154at extends RelativeLayout {

    /* JADX INFO: renamed from: B */
    private int f2628B;

    public C2154at(Context context) {
        super(context);
        this.f2628B = (int) (Resources.getSystem().getDisplayMetrics().widthPixels * C2156av.Code());
    }

    public C2154at(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2628B = (int) (Resources.getSystem().getDisplayMetrics().widthPixels * C2156av.Code());
    }

    public void setXFraction(float f) {
        int i = this.f2628B;
        setX(i > 0 ? f * i : -9999.0f);
    }
}
