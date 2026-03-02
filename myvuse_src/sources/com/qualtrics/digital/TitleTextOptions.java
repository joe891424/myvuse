package com.qualtrics.digital;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class TitleTextOptions extends TextOptions implements Cloneable {
    TitleTextOptions() {
    }

    @Override // com.qualtrics.digital.TextOptions
    int getTextSize() {
        if (this.Size == null) {
            return 17;
        }
        String str = this.Size;
        str.hashCode();
        if (str.equals("large")) {
            return 21;
        }
        return !str.equals("small") ? 17 : 13;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TitleTextOptions m6396clone() {
        try {
            return (TitleTextOptions) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
