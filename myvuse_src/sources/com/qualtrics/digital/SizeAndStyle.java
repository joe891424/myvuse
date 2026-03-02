package com.qualtrics.digital;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class SizeAndStyle implements Cloneable {
    String BackgroundScreen;
    int BorderRadius;
    String ContentSpacing;
    String DropShadow;
    String InterceptColor;

    SizeAndStyle() {
    }

    float getDropShadow() {
        String str = this.DropShadow;
        if (str == null) {
            return 0.0f;
        }
        str.hashCode();
        switch (str) {
        }
        return 0.0f;
    }

    int getShadowBoxColor() {
        String str = this.BackgroundScreen;
        if (str == null) {
            return 0;
        }
        str.hashCode();
        switch (str) {
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    int getContentSpacing() {
        String str = this.ContentSpacing;
        if (str == null) {
            return 7;
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1078030475:
                if (str.equals("medium")) {
                    b = 0;
                }
                break;
            case 950483747:
                if (str.equals("compact")) {
                    b = 1;
                }
                break;
            case 2047584771:
                if (str.equals("spacious")) {
                    b = 2;
                }
                break;
        }
        switch (b) {
            case 0:
            default:
                return 10;
            case 1:
                return 3;
            case 2:
                return 15;
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SizeAndStyle m6395clone() {
        try {
            return (SizeAndStyle) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
