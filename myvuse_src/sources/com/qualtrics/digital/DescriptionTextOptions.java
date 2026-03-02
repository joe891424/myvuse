package com.qualtrics.digital;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class DescriptionTextOptions extends TextOptions implements Cloneable {
    DescriptionTextOptions() {
    }

    @Override // com.qualtrics.digital.TextOptions
    int getTextSize() {
        if (this.Size == null) {
            return 13;
        }
        String str = this.Size;
        str.hashCode();
        if (str.equals("medium")) {
            return 15;
        }
        return !str.equals("large") ? 13 : 17;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DescriptionTextOptions m6381clone() {
        try {
            return (DescriptionTextOptions) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
