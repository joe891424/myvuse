package com.reactnativenavigation.options.params;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes6.dex */
public class DontApplyColour extends Colour {
    @Override // com.reactnativenavigation.options.params.Param
    public boolean canApplyValue() {
        return false;
    }

    @Override // com.reactnativenavigation.options.params.Param
    public boolean hasValue() {
        return true;
    }

    public DontApplyColour() {
        super(0);
    }

    @Override // com.reactnativenavigation.options.params.Colour
    @Nonnull
    public String toString() {
        return "NoColor";
    }
}
