package com.reactnativenavigation.options.params;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public enum TitleDisplayMode {
    ALWAYS_SHOW(AHBottomNavigation.TitleState.ALWAYS_SHOW),
    SHOW_WHEN_ACTIVE(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE),
    ALWAYS_HIDE(AHBottomNavigation.TitleState.ALWAYS_HIDE),
    SHOW_WHEN_ACTIVE_FORCE(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE_FORCE),
    UNDEFINED(null);


    @Nullable
    private AHBottomNavigation.TitleState state;

    public static TitleDisplayMode fromString(String str) {
        str.hashCode();
        switch (str) {
            case "showWhenActiveForce":
                return SHOW_WHEN_ACTIVE_FORCE;
            case "alwaysHide":
                return ALWAYS_HIDE;
            case "alwaysShow":
                return ALWAYS_SHOW;
            case "showWhenActive":
                return SHOW_WHEN_ACTIVE;
            default:
                return UNDEFINED;
        }
    }

    TitleDisplayMode(@Nullable AHBottomNavigation.TitleState titleState) {
        this.state = titleState;
    }

    public boolean hasValue() {
        return this.state != null;
    }

    public AHBottomNavigation.TitleState get(AHBottomNavigation.TitleState titleState) {
        AHBottomNavigation.TitleState titleState2 = this.state;
        return titleState2 == null ? titleState : titleState2;
    }

    public AHBottomNavigation.TitleState toState() {
        AHBottomNavigation.TitleState titleState = this.state;
        if (titleState != null) {
            return titleState;
        }
        throw new RuntimeException("TitleDisplayMode is undefined");
    }

    private static class Constants {
        static final String ALWAYS_HIDE = "alwaysHide";
        static final String ALWAYS_SHOW = "alwaysShow";
        static final String SHOW_WHEN_ACTIVE = "showWhenActive";
        static final String SHOW_WHEN_ACTIVE_FORCE = "showWhenActiveForce";

        private Constants() {
        }
    }
}
