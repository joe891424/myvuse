package com.qualtrics.digital.theming.embedded;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.fonts.FontTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThankYouTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/ThankYouTheme;", "", "color", "", "thankYouTextFont", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "(ILcom/qualtrics/digital/theming/fonts/FontTheme;)V", "getThankYouTextFont", "()Lcom/qualtrics/digital/theming/fonts/FontTheme;", "component1", "component2", "copy", "equals", "", "other", "getColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ThankYouTheme {
    private final int color;
    private final FontTheme thankYouTextFont;

    /* JADX WARN: Multi-variable type inference failed */
    public ThankYouTheme() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getColor() {
        return this.color;
    }

    public static /* synthetic */ ThankYouTheme copy$default(ThankYouTheme thankYouTheme, int i, FontTheme fontTheme, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = thankYouTheme.color;
        }
        if ((i2 & 2) != 0) {
            fontTheme = thankYouTheme.thankYouTextFont;
        }
        return thankYouTheme.copy(i, fontTheme);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FontTheme getThankYouTextFont() {
        return this.thankYouTextFont;
    }

    public final ThankYouTheme copy(int color, FontTheme thankYouTextFont) {
        Intrinsics.checkNotNullParameter(thankYouTextFont, "thankYouTextFont");
        return new ThankYouTheme(color, thankYouTextFont);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThankYouTheme)) {
            return false;
        }
        ThankYouTheme thankYouTheme = (ThankYouTheme) other;
        return this.color == thankYouTheme.color && Intrinsics.areEqual(this.thankYouTextFont, thankYouTheme.thankYouTextFont);
    }

    public int hashCode() {
        return (Integer.hashCode(this.color) * 31) + this.thankYouTextFont.hashCode();
    }

    public String toString() {
        return "ThankYouTheme(color=" + this.color + ", thankYouTextFont=" + this.thankYouTextFont + ')';
    }

    public ThankYouTheme(int i, FontTheme thankYouTextFont) {
        Intrinsics.checkNotNullParameter(thankYouTextFont, "thankYouTextFont");
        this.color = i;
        this.thankYouTextFont = thankYouTextFont;
    }

    public /* synthetic */ ThankYouTheme(int i, FontTheme fontTheme, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C3902R.color.qualtricsDefaultText : i, (i2 & 2) != 0 ? new FontTheme(0, 20, 1, null) : fontTheme);
    }

    public final FontTheme getThankYouTextFont() {
        return this.thankYouTextFont;
    }

    public final int getColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.color);
    }
}
