package com.qualtrics.digital.theming.embedded.response;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.fonts.FontTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YesNoButtonsTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003JY\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/response/YesNoButtonsTheme;", "", "yesButtonTextColor", "", "yesButtonBorderColor", "yesButtonFillColor", "yesButtonFont", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "noButtonTextColor", "noButtonBorderColor", "noButtonFillColor", "noButtonFont", "(IIILcom/qualtrics/digital/theming/fonts/FontTheme;IIILcom/qualtrics/digital/theming/fonts/FontTheme;)V", "getNoButtonFont", "()Lcom/qualtrics/digital/theming/fonts/FontTheme;", "getYesButtonFont", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "getNoButtonBorderColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "getNoButtonFillColor", "getNoButtonTextColor", "getYesButtonBorderColor", "getYesButtonFillColor", "getYesButtonTextColor", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class YesNoButtonsTheme {
    private final int noButtonBorderColor;
    private final int noButtonFillColor;
    private final FontTheme noButtonFont;
    private final int noButtonTextColor;
    private final int yesButtonBorderColor;
    private final int yesButtonFillColor;
    private final FontTheme yesButtonFont;
    private final int yesButtonTextColor;

    public YesNoButtonsTheme() {
        this(0, 0, 0, null, 0, 0, 0, null, 255, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getYesButtonTextColor() {
        return this.yesButtonTextColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getYesButtonBorderColor() {
        return this.yesButtonBorderColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getYesButtonFillColor() {
        return this.yesButtonFillColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final int getNoButtonTextColor() {
        return this.noButtonTextColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final int getNoButtonBorderColor() {
        return this.noButtonBorderColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final int getNoButtonFillColor() {
        return this.noButtonFillColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final FontTheme getYesButtonFont() {
        return this.yesButtonFont;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final FontTheme getNoButtonFont() {
        return this.noButtonFont;
    }

    public final YesNoButtonsTheme copy(int yesButtonTextColor, int yesButtonBorderColor, int yesButtonFillColor, FontTheme yesButtonFont, int noButtonTextColor, int noButtonBorderColor, int noButtonFillColor, FontTheme noButtonFont) {
        Intrinsics.checkNotNullParameter(yesButtonFont, "yesButtonFont");
        Intrinsics.checkNotNullParameter(noButtonFont, "noButtonFont");
        return new YesNoButtonsTheme(yesButtonTextColor, yesButtonBorderColor, yesButtonFillColor, yesButtonFont, noButtonTextColor, noButtonBorderColor, noButtonFillColor, noButtonFont);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YesNoButtonsTheme)) {
            return false;
        }
        YesNoButtonsTheme yesNoButtonsTheme = (YesNoButtonsTheme) other;
        return this.yesButtonTextColor == yesNoButtonsTheme.yesButtonTextColor && this.yesButtonBorderColor == yesNoButtonsTheme.yesButtonBorderColor && this.yesButtonFillColor == yesNoButtonsTheme.yesButtonFillColor && Intrinsics.areEqual(this.yesButtonFont, yesNoButtonsTheme.yesButtonFont) && this.noButtonTextColor == yesNoButtonsTheme.noButtonTextColor && this.noButtonBorderColor == yesNoButtonsTheme.noButtonBorderColor && this.noButtonFillColor == yesNoButtonsTheme.noButtonFillColor && Intrinsics.areEqual(this.noButtonFont, yesNoButtonsTheme.noButtonFont);
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.yesButtonTextColor) * 31) + Integer.hashCode(this.yesButtonBorderColor)) * 31) + Integer.hashCode(this.yesButtonFillColor)) * 31) + this.yesButtonFont.hashCode()) * 31) + Integer.hashCode(this.noButtonTextColor)) * 31) + Integer.hashCode(this.noButtonBorderColor)) * 31) + Integer.hashCode(this.noButtonFillColor)) * 31) + this.noButtonFont.hashCode();
    }

    public String toString() {
        return "YesNoButtonsTheme(yesButtonTextColor=" + this.yesButtonTextColor + ", yesButtonBorderColor=" + this.yesButtonBorderColor + ", yesButtonFillColor=" + this.yesButtonFillColor + ", yesButtonFont=" + this.yesButtonFont + ", noButtonTextColor=" + this.noButtonTextColor + ", noButtonBorderColor=" + this.noButtonBorderColor + ", noButtonFillColor=" + this.noButtonFillColor + ", noButtonFont=" + this.noButtonFont + ')';
    }

    public YesNoButtonsTheme(int i, int i2, int i3, FontTheme yesButtonFont, int i4, int i5, int i6, FontTheme noButtonFont) {
        Intrinsics.checkNotNullParameter(yesButtonFont, "yesButtonFont");
        Intrinsics.checkNotNullParameter(noButtonFont, "noButtonFont");
        this.yesButtonTextColor = i;
        this.yesButtonBorderColor = i2;
        this.yesButtonFillColor = i3;
        this.yesButtonFont = yesButtonFont;
        this.noButtonTextColor = i4;
        this.noButtonBorderColor = i5;
        this.noButtonFillColor = i6;
        this.noButtonFont = noButtonFont;
    }

    public /* synthetic */ YesNoButtonsTheme(int i, int i2, int i3, FontTheme fontTheme, int i4, int i5, int i6, FontTheme fontTheme2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? C3902R.color.qualtricsDefaultButton : i, (i7 & 2) != 0 ? C3902R.color.qualtricsDefaultButton : i2, (i7 & 4) != 0 ? C3902R.color.qualtricsDefaultBackground : i3, (i7 & 8) != 0 ? new FontTheme(0, 16, 1, null) : fontTheme, (i7 & 16) != 0 ? C3902R.color.qualtricsDefaultButton : i4, (i7 & 32) != 0 ? C3902R.color.qualtricsDefaultButton : i5, (i7 & 64) != 0 ? C3902R.color.qualtricsDefaultBackground : i6, (i7 & 128) != 0 ? new FontTheme(0, 16, 1, null) : fontTheme2);
    }

    public final FontTheme getYesButtonFont() {
        return this.yesButtonFont;
    }

    public final FontTheme getNoButtonFont() {
        return this.noButtonFont;
    }

    public final int getYesButtonTextColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.yesButtonTextColor);
    }

    public final int getYesButtonBorderColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.yesButtonBorderColor);
    }

    public final int getYesButtonFillColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.yesButtonFillColor);
    }

    public final int getNoButtonTextColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.noButtonTextColor);
    }

    public final int getNoButtonBorderColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.noButtonBorderColor);
    }

    public final int getNoButtonFillColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.noButtonFillColor);
    }
}
