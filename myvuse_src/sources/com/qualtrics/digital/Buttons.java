package com.qualtrics.digital;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class Buttons implements Cloneable {
    int BorderRadius;
    ButtonOptions ButtonOne;
    String ButtonStyle;
    ButtonOptions ButtonTwo;
    String CloseButtonBackgroundColor = "#00FFFFFF";
    String CloseButtonColor;
    String LinkAlignment;
    String LinkColor;
    int Number;

    public boolean hasCloseButton() {
        String str = this.CloseButtonColor;
        return (str == null || str.equals("")) ? false : true;
    }

    Buttons() {
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Buttons m6380clone() {
        try {
            Buttons buttons = (Buttons) super.clone();
            buttons.ButtonOne = buttons.ButtonOne.m6379clone();
            buttons.ButtonTwo = buttons.ButtonTwo.m6379clone();
            return buttons;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
