package com.reactnativenavigation.options.params;

/* JADX INFO: loaded from: classes6.dex */
public class NullColor extends Colour {
    @Override // com.reactnativenavigation.options.params.Param
    public boolean hasValue() {
        return false;
    }

    public NullColor() {
        super(0);
    }

    @Override // com.reactnativenavigation.options.params.Colour
    public String toString() {
        return "Null Color";
    }
}
