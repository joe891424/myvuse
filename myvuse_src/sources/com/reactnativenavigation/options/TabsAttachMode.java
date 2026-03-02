package com.reactnativenavigation.options;

/* JADX INFO: loaded from: classes6.dex */
public enum TabsAttachMode {
    TOGETHER,
    AFTER_INITIAL_TAB,
    ON_SWITCH_TO_TAB,
    UNDEFINED;

    public static TabsAttachMode fromString(String str) {
        str.hashCode();
        switch (str) {
            case "onSwitchToTab":
                return ON_SWITCH_TO_TAB;
            case "together":
                return TOGETHER;
            case "afterInitialTab":
                return AFTER_INITIAL_TAB;
            default:
                return UNDEFINED;
        }
    }

    public boolean hasValue() {
        return this != UNDEFINED;
    }
}
