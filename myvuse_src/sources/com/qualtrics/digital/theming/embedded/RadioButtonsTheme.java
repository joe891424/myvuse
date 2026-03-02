package com.qualtrics.digital.theming.embedded;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.fonts.FontTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RadioButtonsTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÂ\u0003J\t\u0010\r\u001a\u00020\u0005HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÂ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/RadioButtonsTheme;", "", "textFont", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "selectedCircleColor", "", "selectedBackgroundColor", "unselectedCircleColor", "(Lcom/qualtrics/digital/theming/fonts/FontTheme;III)V", "getTextFont", "()Lcom/qualtrics/digital/theming/fonts/FontTheme;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getSelectedBackgroundColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "getSelectedCircleColor", "getUnselectedCircleColor", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class RadioButtonsTheme {
    private final int selectedBackgroundColor;
    private final int selectedCircleColor;
    private final FontTheme textFont;
    private final int unselectedCircleColor;

    public RadioButtonsTheme() {
        this(null, 0, 0, 0, 15, null);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getSelectedCircleColor() {
        return this.selectedCircleColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getSelectedBackgroundColor() {
        return this.selectedBackgroundColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final int getUnselectedCircleColor() {
        return this.unselectedCircleColor;
    }

    public static /* synthetic */ RadioButtonsTheme copy$default(RadioButtonsTheme radioButtonsTheme, FontTheme fontTheme, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fontTheme = radioButtonsTheme.textFont;
        }
        if ((i4 & 2) != 0) {
            i = radioButtonsTheme.selectedCircleColor;
        }
        if ((i4 & 4) != 0) {
            i2 = radioButtonsTheme.selectedBackgroundColor;
        }
        if ((i4 & 8) != 0) {
            i3 = radioButtonsTheme.unselectedCircleColor;
        }
        return radioButtonsTheme.copy(fontTheme, i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FontTheme getTextFont() {
        return this.textFont;
    }

    public final RadioButtonsTheme copy(FontTheme textFont, int selectedCircleColor, int selectedBackgroundColor, int unselectedCircleColor) {
        Intrinsics.checkNotNullParameter(textFont, "textFont");
        return new RadioButtonsTheme(textFont, selectedCircleColor, selectedBackgroundColor, unselectedCircleColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadioButtonsTheme)) {
            return false;
        }
        RadioButtonsTheme radioButtonsTheme = (RadioButtonsTheme) other;
        return Intrinsics.areEqual(this.textFont, radioButtonsTheme.textFont) && this.selectedCircleColor == radioButtonsTheme.selectedCircleColor && this.selectedBackgroundColor == radioButtonsTheme.selectedBackgroundColor && this.unselectedCircleColor == radioButtonsTheme.unselectedCircleColor;
    }

    public int hashCode() {
        return (((((this.textFont.hashCode() * 31) + Integer.hashCode(this.selectedCircleColor)) * 31) + Integer.hashCode(this.selectedBackgroundColor)) * 31) + Integer.hashCode(this.unselectedCircleColor);
    }

    public String toString() {
        return "RadioButtonsTheme(textFont=" + this.textFont + ", selectedCircleColor=" + this.selectedCircleColor + ", selectedBackgroundColor=" + this.selectedBackgroundColor + ", unselectedCircleColor=" + this.unselectedCircleColor + ')';
    }

    public RadioButtonsTheme(FontTheme textFont, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(textFont, "textFont");
        this.textFont = textFont;
        this.selectedCircleColor = i;
        this.selectedBackgroundColor = i2;
        this.unselectedCircleColor = i3;
    }

    public /* synthetic */ RadioButtonsTheme(FontTheme fontTheme, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? new FontTheme(0, 18, 1, null) : fontTheme, (i4 & 2) != 0 ? C3902R.color.qualtricsDefaultMultipleChoiceSelection : i, (i4 & 4) != 0 ? C3902R.color.qualtricsDefaultMultipleChoiceSelectionBackground : i2, (i4 & 8) != 0 ? C3902R.color.qualtricsDefaultMultipleChoiceUnselectedCircle : i3);
    }

    public final FontTheme getTextFont() {
        return this.textFont;
    }

    public final int getUnselectedCircleColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.unselectedCircleColor);
    }

    public final int getSelectedBackgroundColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.selectedBackgroundColor);
    }

    public final int getSelectedCircleColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.selectedCircleColor);
    }
}
