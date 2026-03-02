package com.qualtrics.digital;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class PopOverOptions implements Cloneable {
    Buttons Buttons;
    DescriptionTextOptions Description;
    SizeAndStyle SizeAndStyle;
    TitleTextOptions Title;

    @SerializedName("ThemeOverriddenThroughSdk")
    Boolean themeOverriddenThroughSdk = false;
    Divider Divider = new Divider();

    PopOverOptions() {
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PopOverOptions m6390clone() {
        try {
            PopOverOptions popOverOptions = (PopOverOptions) super.clone();
            popOverOptions.Title = popOverOptions.Title.m6396clone();
            popOverOptions.Description = popOverOptions.Description.m6381clone();
            popOverOptions.Buttons = popOverOptions.Buttons.m6380clone();
            popOverOptions.SizeAndStyle = popOverOptions.SizeAndStyle.m6395clone();
            popOverOptions.Divider = popOverOptions.Divider.m6382clone();
            return popOverOptions;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
