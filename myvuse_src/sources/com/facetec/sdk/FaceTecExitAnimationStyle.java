package com.facetec.sdk;

/* JADX INFO: loaded from: classes3.dex */
public enum FaceTecExitAnimationStyle {
    CIRCLE_FADE(0),
    RIPPLE_OUT(1),
    RIPPLE_IN(2),
    NONE(3);

    private final int Code;

    FaceTecExitAnimationStyle(int i) {
        this.Code = i;
    }

    public final int getValue() {
        return this.Code;
    }
}
