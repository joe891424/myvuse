package com.qualtrics.digital;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class ButtonOptions implements Cloneable {
    String Action;
    String BackgroundColor;
    String BorderColor;
    String Color;
    String Text;

    ButtonOptions() {
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ButtonOptions m6379clone() {
        try {
            return (ButtonOptions) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
