package com.reactnativenavigation.options.params;

/* JADX INFO: loaded from: classes6.dex */
public class Text extends Param<String> {
    public Text(String str) {
        super(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int length() {
        if (hasValue()) {
            return ((String) this.value).length();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        return hasValue() ? (String) this.value : "No Value";
    }
}
