package com.qualtrics.digital.theming.prompt;

import androidx.core.app.FrameMetricsAggregator;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.fonts.FontTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MobileAppPromptTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0007J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006-"}, m5598d2 = {"Lcom/qualtrics/digital/theming/prompt/MobileAppPromptTheme;", "", "backgroundColor", "", "headlineTextColor", "headlineFont", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "descriptionTextColor", "descriptionFont", OTUXParamsKeys.OT_UX_CLOSE_BUTTON_COLOR, "closeButtonBackgroundColor", "buttonOneTheme", "Lcom/qualtrics/digital/theming/prompt/ButtonTheme;", "buttonTwoTheme", "(IILcom/qualtrics/digital/theming/fonts/FontTheme;ILcom/qualtrics/digital/theming/fonts/FontTheme;IILcom/qualtrics/digital/theming/prompt/ButtonTheme;Lcom/qualtrics/digital/theming/prompt/ButtonTheme;)V", "getBackgroundColor", "()I", "getButtonOneTheme", "()Lcom/qualtrics/digital/theming/prompt/ButtonTheme;", "getButtonTwoTheme", "getCloseButtonBackgroundColor", "getCloseButtonColor", "getDescriptionFont", "()Lcom/qualtrics/digital/theming/fonts/FontTheme;", "getDescriptionTextColor", "getHeadlineFont", "getHeadlineTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MobileAppPromptTheme {
    private final int backgroundColor;
    private final ButtonTheme buttonOneTheme;
    private final ButtonTheme buttonTwoTheme;
    private final int closeButtonBackgroundColor;
    private final int closeButtonColor;
    private final FontTheme descriptionFont;
    private final int descriptionTextColor;
    private final FontTheme headlineFont;
    private final int headlineTextColor;

    public MobileAppPromptTheme() {
        this(0, 0, null, 0, null, 0, 0, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeadlineTextColor() {
        return this.headlineTextColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FontTheme getHeadlineFont() {
        return this.headlineFont;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDescriptionTextColor() {
        return this.descriptionTextColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FontTheme getDescriptionFont() {
        return this.descriptionFont;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCloseButtonColor() {
        return this.closeButtonColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCloseButtonBackgroundColor() {
        return this.closeButtonBackgroundColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ButtonTheme getButtonOneTheme() {
        return this.buttonOneTheme;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ButtonTheme getButtonTwoTheme() {
        return this.buttonTwoTheme;
    }

    public final MobileAppPromptTheme copy(int backgroundColor, int headlineTextColor, FontTheme headlineFont, int descriptionTextColor, FontTheme descriptionFont, int closeButtonColor, int closeButtonBackgroundColor, ButtonTheme buttonOneTheme, ButtonTheme buttonTwoTheme) {
        Intrinsics.checkNotNullParameter(headlineFont, "headlineFont");
        Intrinsics.checkNotNullParameter(descriptionFont, "descriptionFont");
        Intrinsics.checkNotNullParameter(buttonOneTheme, "buttonOneTheme");
        Intrinsics.checkNotNullParameter(buttonTwoTheme, "buttonTwoTheme");
        return new MobileAppPromptTheme(backgroundColor, headlineTextColor, headlineFont, descriptionTextColor, descriptionFont, closeButtonColor, closeButtonBackgroundColor, buttonOneTheme, buttonTwoTheme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileAppPromptTheme)) {
            return false;
        }
        MobileAppPromptTheme mobileAppPromptTheme = (MobileAppPromptTheme) other;
        return this.backgroundColor == mobileAppPromptTheme.backgroundColor && this.headlineTextColor == mobileAppPromptTheme.headlineTextColor && Intrinsics.areEqual(this.headlineFont, mobileAppPromptTheme.headlineFont) && this.descriptionTextColor == mobileAppPromptTheme.descriptionTextColor && Intrinsics.areEqual(this.descriptionFont, mobileAppPromptTheme.descriptionFont) && this.closeButtonColor == mobileAppPromptTheme.closeButtonColor && this.closeButtonBackgroundColor == mobileAppPromptTheme.closeButtonBackgroundColor && Intrinsics.areEqual(this.buttonOneTheme, mobileAppPromptTheme.buttonOneTheme) && Intrinsics.areEqual(this.buttonTwoTheme, mobileAppPromptTheme.buttonTwoTheme);
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.backgroundColor) * 31) + Integer.hashCode(this.headlineTextColor)) * 31) + this.headlineFont.hashCode()) * 31) + Integer.hashCode(this.descriptionTextColor)) * 31) + this.descriptionFont.hashCode()) * 31) + Integer.hashCode(this.closeButtonColor)) * 31) + Integer.hashCode(this.closeButtonBackgroundColor)) * 31) + this.buttonOneTheme.hashCode()) * 31) + this.buttonTwoTheme.hashCode();
    }

    public String toString() {
        return "MobileAppPromptTheme(backgroundColor=" + this.backgroundColor + ", headlineTextColor=" + this.headlineTextColor + ", headlineFont=" + this.headlineFont + ", descriptionTextColor=" + this.descriptionTextColor + ", descriptionFont=" + this.descriptionFont + ", closeButtonColor=" + this.closeButtonColor + ", closeButtonBackgroundColor=" + this.closeButtonBackgroundColor + ", buttonOneTheme=" + this.buttonOneTheme + ", buttonTwoTheme=" + this.buttonTwoTheme + ')';
    }

    public MobileAppPromptTheme(int i, int i2, FontTheme headlineFont, int i3, FontTheme descriptionFont, int i4, int i5, ButtonTheme buttonOneTheme, ButtonTheme buttonTwoTheme) {
        Intrinsics.checkNotNullParameter(headlineFont, "headlineFont");
        Intrinsics.checkNotNullParameter(descriptionFont, "descriptionFont");
        Intrinsics.checkNotNullParameter(buttonOneTheme, "buttonOneTheme");
        Intrinsics.checkNotNullParameter(buttonTwoTheme, "buttonTwoTheme");
        this.backgroundColor = i;
        this.headlineTextColor = i2;
        this.headlineFont = headlineFont;
        this.descriptionTextColor = i3;
        this.descriptionFont = descriptionFont;
        this.closeButtonColor = i4;
        this.closeButtonBackgroundColor = i5;
        this.buttonOneTheme = buttonOneTheme;
        this.buttonTwoTheme = buttonTwoTheme;
    }

    public /* synthetic */ MobileAppPromptTheme(int i, int i2, FontTheme fontTheme, int i3, FontTheme fontTheme2, int i4, int i5, ButtonTheme buttonTheme, ButtonTheme buttonTheme2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? C3902R.color.qualtricsDefaultBackground : i, (i6 & 2) != 0 ? C3902R.color.qualtricsDefaultText : i2, (i6 & 4) != 0 ? new FontTheme(0, 17, 1, null) : fontTheme, (i6 & 8) != 0 ? C3902R.color.qualtricsDefaultText : i3, (i6 & 16) != 0 ? new FontTheme(0, 13, 1, null) : fontTheme2, (i6 & 32) != 0 ? C3902R.color.qualtricsDefaultCloseButton : i4, (i6 & 64) != 0 ? C3902R.color.transparent : i5, (i6 & 128) != 0 ? new ButtonTheme(C3902R.color.qualtricsDefaultButton, null, C3902R.color.white, C3902R.color.qualtricsDefaultButton, C3902R.color.qualtricsDefaultButton, 2, null) : buttonTheme, (i6 & 256) != 0 ? new ButtonTheme(C3902R.color.white, null, C3902R.color.qualtricsDefaultButton, C3902R.color.qualtricsDefaultButton, C3902R.color.qualtricsDefaultButton, 2, null) : buttonTheme2);
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getHeadlineTextColor() {
        return this.headlineTextColor;
    }

    public final FontTheme getHeadlineFont() {
        return this.headlineFont;
    }

    public final int getDescriptionTextColor() {
        return this.descriptionTextColor;
    }

    public final FontTheme getDescriptionFont() {
        return this.descriptionFont;
    }

    public final int getCloseButtonColor() {
        return this.closeButtonColor;
    }

    public final int getCloseButtonBackgroundColor() {
        return this.closeButtonBackgroundColor;
    }

    public final ButtonTheme getButtonOneTheme() {
        return this.buttonOneTheme;
    }

    public final ButtonTheme getButtonTwoTheme() {
        return this.buttonTwoTheme;
    }

    public final int getBackgroundColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.backgroundColor);
    }

    public final int getHeadlineTextColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.headlineTextColor);
    }

    public final int getDescriptionTextColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.descriptionTextColor);
    }

    public final int getCloseButtonColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.closeButtonColor);
    }

    public final int getCloseButtonBackgroundColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.closeButtonBackgroundColor);
    }
}
