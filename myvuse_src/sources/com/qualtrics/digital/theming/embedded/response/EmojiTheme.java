package com.qualtrics.digital.theming.embedded.response;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/response/EmojiTheme;", "", "borderColor", "", "fillColor", "tintColor", "(III)V", "getBorderColor", "()I", "getFillColor", "getTintColor", "component1", "component2", "component3", "copy", "equals", "", "other", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class EmojiTheme {
    private final int borderColor;
    private final int fillColor;
    private final int tintColor;

    public EmojiTheme() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ EmojiTheme copy$default(EmojiTheme emojiTheme, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = emojiTheme.borderColor;
        }
        if ((i4 & 2) != 0) {
            i2 = emojiTheme.fillColor;
        }
        if ((i4 & 4) != 0) {
            i3 = emojiTheme.tintColor;
        }
        return emojiTheme.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBorderColor() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFillColor() {
        return this.fillColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTintColor() {
        return this.tintColor;
    }

    public final EmojiTheme copy(int borderColor, int fillColor, int tintColor) {
        return new EmojiTheme(borderColor, fillColor, tintColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiTheme)) {
            return false;
        }
        EmojiTheme emojiTheme = (EmojiTheme) other;
        return this.borderColor == emojiTheme.borderColor && this.fillColor == emojiTheme.fillColor && this.tintColor == emojiTheme.tintColor;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.borderColor) * 31) + Integer.hashCode(this.fillColor)) * 31) + Integer.hashCode(this.tintColor);
    }

    public String toString() {
        return "EmojiTheme(borderColor=" + this.borderColor + ", fillColor=" + this.fillColor + ", tintColor=" + this.tintColor + ')';
    }

    public EmojiTheme(int i, int i2, int i3) {
        this.borderColor = i;
        this.fillColor = i2;
        this.tintColor = i3;
    }

    public /* synthetic */ EmojiTheme(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? C3902R.color.qualtricsDefaultCustomEmojiBorder : i, (i4 & 2) != 0 ? C3902R.color.qualtricsDefaultCustomEmojiFill : i2, (i4 & 4) != 0 ? C3902R.color.qualtricsDefaultCustomEmojiBorder : i3);
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final int getTintColor() {
        return this.tintColor;
    }

    public final int getBorderColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.borderColor);
    }

    public final int getFillColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.fillColor);
    }

    public final int getTintColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.tintColor);
    }
}
