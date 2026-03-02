package com.qualtrics.digital;

import com.facebook.react.uimanager.ViewProps;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class TextOptions {
    String Alignment;
    boolean Bold;
    String Color;
    String Size;
    String Text;

    abstract int getTextSize();

    TextOptions() {
    }

    int getAlignment() {
        String str = this.Alignment;
        str.hashCode();
        if (str.equals(ViewProps.LEFT)) {
            return 2;
        }
        return !str.equals(ViewProps.RIGHT) ? 4 : 3;
    }
}
