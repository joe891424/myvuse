package com.reactnativenavigation.options.params;

/* JADX INFO: loaded from: classes6.dex */
public class NullFloatParam extends FloatParam {
    @Override // com.reactnativenavigation.options.params.Param
    public boolean hasValue() {
        return false;
    }

    public NullFloatParam() {
        super(Float.valueOf(0.0f));
    }
}
