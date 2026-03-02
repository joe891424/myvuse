package com.qualtrics.digital.theming.embedded;

import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.fonts.FontTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubmitButtonTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/SubmitButtonTheme;", "", OTUXParamsKeys.OT_UX_TEXT_COLOR, "", "fillColor", "font", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "(IILcom/qualtrics/digital/theming/fonts/FontTheme;)V", "getFont", "()Lcom/qualtrics/digital/theming/fonts/FontTheme;", "component1", "component2", "component3", "copy", "equals", "", "other", "getFillColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "getTextColor", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class SubmitButtonTheme {
    private final int fillColor;
    private final FontTheme font;
    private final int textColor;

    public SubmitButtonTheme() {
        this(0, 0, null, 7, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getFillColor() {
        return this.fillColor;
    }

    public static /* synthetic */ SubmitButtonTheme copy$default(SubmitButtonTheme submitButtonTheme, int i, int i2, FontTheme fontTheme, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = submitButtonTheme.textColor;
        }
        if ((i3 & 2) != 0) {
            i2 = submitButtonTheme.fillColor;
        }
        if ((i3 & 4) != 0) {
            fontTheme = submitButtonTheme.font;
        }
        return submitButtonTheme.copy(i, i2, fontTheme);
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FontTheme getFont() {
        return this.font;
    }

    public final SubmitButtonTheme copy(int textColor, int fillColor, FontTheme font) {
        Intrinsics.checkNotNullParameter(font, "font");
        return new SubmitButtonTheme(textColor, fillColor, font);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubmitButtonTheme)) {
            return false;
        }
        SubmitButtonTheme submitButtonTheme = (SubmitButtonTheme) other;
        return this.textColor == submitButtonTheme.textColor && this.fillColor == submitButtonTheme.fillColor && Intrinsics.areEqual(this.font, submitButtonTheme.font);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.textColor) * 31) + Integer.hashCode(this.fillColor)) * 31) + this.font.hashCode();
    }

    public String toString() {
        return "SubmitButtonTheme(textColor=" + this.textColor + ", fillColor=" + this.fillColor + ", font=" + this.font + ')';
    }

    public SubmitButtonTheme(int i, int i2, FontTheme font) {
        Intrinsics.checkNotNullParameter(font, "font");
        this.textColor = i;
        this.fillColor = i2;
        this.font = font;
    }

    public /* synthetic */ SubmitButtonTheme(int i, int i2, FontTheme fontTheme, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? C3902R.color.qualtricsDefaultBackground : i, (i3 & 2) != 0 ? C3902R.color.qualtricsDefaultButton : i2, (i3 & 4) != 0 ? new FontTheme(0, 14, 1, null) : fontTheme);
    }

    public final FontTheme getFont() {
        return this.font;
    }

    public final int getTextColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.textColor);
    }

    public final int getFillColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.fillColor);
    }
}
