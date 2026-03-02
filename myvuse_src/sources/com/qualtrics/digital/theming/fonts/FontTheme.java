package com.qualtrics.digital.theming.fonts;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FontTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, m5598d2 = {"Lcom/qualtrics/digital/theming/fonts/FontTheme;", "", "fontRes", "", "size", "(II)V", "getFontRes", "()I", "getSize", "component1", "component2", "copy", "equals", "", "other", "hasCustomTypeface", "hasDefaultTypeface", "hashCode", "toString", "", "Companion", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FontTheme {
    public static final int DEFAULT_FONT_RES = 0;
    public static final int DEFAULT_FONT_SIZE = 16;
    private final int fontRes;
    private final int size;

    /* JADX WARN: Illegal instructions before constructor call */
    public FontTheme() {
        int i = 0;
        this(i, i, 3, null);
    }

    public static /* synthetic */ FontTheme copy$default(FontTheme fontTheme, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = fontTheme.fontRes;
        }
        if ((i3 & 2) != 0) {
            i2 = fontTheme.size;
        }
        return fontTheme.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFontRes() {
        return this.fontRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final FontTheme copy(int fontRes, int size) {
        return new FontTheme(fontRes, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FontTheme)) {
            return false;
        }
        FontTheme fontTheme = (FontTheme) other;
        return this.fontRes == fontTheme.fontRes && this.size == fontTheme.size;
    }

    public int hashCode() {
        return (Integer.hashCode(this.fontRes) * 31) + Integer.hashCode(this.size);
    }

    public String toString() {
        return "FontTheme(fontRes=" + this.fontRes + ", size=" + this.size + ')';
    }

    public FontTheme(int i, int i2) {
        this.fontRes = i;
        this.size = i2;
    }

    public /* synthetic */ FontTheme(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 16 : i2);
    }

    public final int getFontRes() {
        return this.fontRes;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean hasDefaultTypeface() {
        return this.fontRes == 0;
    }

    public final boolean hasCustomTypeface() {
        return !hasDefaultTypeface();
    }
}
