package com.qualtrics.digital.theming.embedded.response;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StarTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0007J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/response/StarTheme;", "", "borderColor", "", "(I)V", "component1", "copy", "equals", "", "other", "getBorderColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class StarTheme {
    private final int borderColor;

    public StarTheme() {
        this(0, 1, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getBorderColor() {
        return this.borderColor;
    }

    public static /* synthetic */ StarTheme copy$default(StarTheme starTheme, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = starTheme.borderColor;
        }
        return starTheme.copy(i);
    }

    public final StarTheme copy(int borderColor) {
        return new StarTheme(borderColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StarTheme) && this.borderColor == ((StarTheme) other).borderColor;
    }

    public int hashCode() {
        return Integer.hashCode(this.borderColor);
    }

    public String toString() {
        return "StarTheme(borderColor=" + this.borderColor + ')';
    }

    public StarTheme(int i) {
        this.borderColor = i;
    }

    public /* synthetic */ StarTheme(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C3902R.color.qualtricsDefaultStartBorder : i);
    }

    public final int getBorderColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.borderColor);
    }
}
