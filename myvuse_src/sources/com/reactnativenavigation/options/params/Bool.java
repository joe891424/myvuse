package com.reactnativenavigation.options.params;

/* JADX INFO: loaded from: classes6.dex */
public class Bool extends Param<Boolean> {
    public Bool(Boolean bool) {
        super(bool);
    }

    public boolean isFalseOrUndefined() {
        return (hasValue() && get().booleanValue()) ? false : true;
    }

    public boolean isTrueOrUndefined() {
        return !hasValue() || get().booleanValue();
    }

    public boolean isTrue() {
        return hasValue() && get().booleanValue();
    }

    public boolean isFalse() {
        return hasValue() && !get().booleanValue();
    }
}
