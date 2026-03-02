package com.qualtrics.digital.theming.prompt;

import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.fonts.FontTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J;\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m5598d2 = {"Lcom/qualtrics/digital/theming/prompt/ButtonTheme;", "", "labelColor", "", "font", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "backgroundColor", "borderColor", OTUXParamsKeys.OT_UX_LINK_COLOR, "(ILcom/qualtrics/digital/theming/fonts/FontTheme;III)V", "getFont", "()Lcom/qualtrics/digital/theming/fonts/FontTheme;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "getBackgroundColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "getBorderColor", "getLabelColor", "getLinkColor", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ButtonTheme {
    private final int backgroundColor;
    private final int borderColor;
    private final FontTheme font;
    private final int labelColor;
    private final int linkColor;

    public ButtonTheme() {
        this(0, null, 0, 0, 0, 31, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getLabelColor() {
        return this.labelColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final int getBorderColor() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final int getLinkColor() {
        return this.linkColor;
    }

    public static /* synthetic */ ButtonTheme copy$default(ButtonTheme buttonTheme, int i, FontTheme fontTheme, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = buttonTheme.labelColor;
        }
        if ((i5 & 2) != 0) {
            fontTheme = buttonTheme.font;
        }
        FontTheme fontTheme2 = fontTheme;
        if ((i5 & 4) != 0) {
            i2 = buttonTheme.backgroundColor;
        }
        int i6 = i2;
        if ((i5 & 8) != 0) {
            i3 = buttonTheme.borderColor;
        }
        int i7 = i3;
        if ((i5 & 16) != 0) {
            i4 = buttonTheme.linkColor;
        }
        return buttonTheme.copy(i, fontTheme2, i6, i7, i4);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FontTheme getFont() {
        return this.font;
    }

    public final ButtonTheme copy(int labelColor, FontTheme font, int backgroundColor, int borderColor, int linkColor) {
        Intrinsics.checkNotNullParameter(font, "font");
        return new ButtonTheme(labelColor, font, backgroundColor, borderColor, linkColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonTheme)) {
            return false;
        }
        ButtonTheme buttonTheme = (ButtonTheme) other;
        return this.labelColor == buttonTheme.labelColor && Intrinsics.areEqual(this.font, buttonTheme.font) && this.backgroundColor == buttonTheme.backgroundColor && this.borderColor == buttonTheme.borderColor && this.linkColor == buttonTheme.linkColor;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.labelColor) * 31) + this.font.hashCode()) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Integer.hashCode(this.borderColor)) * 31) + Integer.hashCode(this.linkColor);
    }

    public String toString() {
        return "ButtonTheme(labelColor=" + this.labelColor + ", font=" + this.font + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", linkColor=" + this.linkColor + ')';
    }

    public ButtonTheme(int i, FontTheme font, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(font, "font");
        this.labelColor = i;
        this.font = font;
        this.backgroundColor = i2;
        this.borderColor = i3;
        this.linkColor = i4;
    }

    public /* synthetic */ ButtonTheme(int i, FontTheme fontTheme, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? C3902R.color.qualtricsDefaultButton : i, (i5 & 2) != 0 ? new FontTheme(0, 18, 1, null) : fontTheme, (i5 & 4) != 0 ? C3902R.color.white : i2, (i5 & 8) != 0 ? C3902R.color.qualtricsDefaultButton : i3, (i5 & 16) != 0 ? C3902R.color.qualtricsDefaultButton : i4);
    }

    public final FontTheme getFont() {
        return this.font;
    }

    public final int getLabelColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.labelColor);
    }

    public final int getBackgroundColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.backgroundColor);
    }

    public final int getBorderColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.borderColor);
    }

    public final int getLinkColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.linkColor);
    }
}
