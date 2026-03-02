package com.qualtrics.digital.theming.embedded.response;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThumbsButtonsTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/response/ThumbsButtonsTheme;", "", "thumbUpBorderColor", "", "thumbUpFillColor", "thumbDownBorderColor", "thumbDownFillColor", "(IIII)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getThumbDownBorderColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "getThumbDownFillColor", "getThumbUpBorderColor", "getThumbUpFillColor", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ThumbsButtonsTheme {
    private final int thumbDownBorderColor;
    private final int thumbDownFillColor;
    private final int thumbUpBorderColor;
    private final int thumbUpFillColor;

    public ThumbsButtonsTheme() {
        this(0, 0, 0, 0, 15, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getThumbUpBorderColor() {
        return this.thumbUpBorderColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getThumbUpFillColor() {
        return this.thumbUpFillColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getThumbDownBorderColor() {
        return this.thumbDownBorderColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final int getThumbDownFillColor() {
        return this.thumbDownFillColor;
    }

    public static /* synthetic */ ThumbsButtonsTheme copy$default(ThumbsButtonsTheme thumbsButtonsTheme, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = thumbsButtonsTheme.thumbUpBorderColor;
        }
        if ((i5 & 2) != 0) {
            i2 = thumbsButtonsTheme.thumbUpFillColor;
        }
        if ((i5 & 4) != 0) {
            i3 = thumbsButtonsTheme.thumbDownBorderColor;
        }
        if ((i5 & 8) != 0) {
            i4 = thumbsButtonsTheme.thumbDownFillColor;
        }
        return thumbsButtonsTheme.copy(i, i2, i3, i4);
    }

    public final ThumbsButtonsTheme copy(int thumbUpBorderColor, int thumbUpFillColor, int thumbDownBorderColor, int thumbDownFillColor) {
        return new ThumbsButtonsTheme(thumbUpBorderColor, thumbUpFillColor, thumbDownBorderColor, thumbDownFillColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbsButtonsTheme)) {
            return false;
        }
        ThumbsButtonsTheme thumbsButtonsTheme = (ThumbsButtonsTheme) other;
        return this.thumbUpBorderColor == thumbsButtonsTheme.thumbUpBorderColor && this.thumbUpFillColor == thumbsButtonsTheme.thumbUpFillColor && this.thumbDownBorderColor == thumbsButtonsTheme.thumbDownBorderColor && this.thumbDownFillColor == thumbsButtonsTheme.thumbDownFillColor;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.thumbUpBorderColor) * 31) + Integer.hashCode(this.thumbUpFillColor)) * 31) + Integer.hashCode(this.thumbDownBorderColor)) * 31) + Integer.hashCode(this.thumbDownFillColor);
    }

    public String toString() {
        return "ThumbsButtonsTheme(thumbUpBorderColor=" + this.thumbUpBorderColor + ", thumbUpFillColor=" + this.thumbUpFillColor + ", thumbDownBorderColor=" + this.thumbDownBorderColor + ", thumbDownFillColor=" + this.thumbDownFillColor + ')';
    }

    public ThumbsButtonsTheme(int i, int i2, int i3, int i4) {
        this.thumbUpBorderColor = i;
        this.thumbUpFillColor = i2;
        this.thumbDownBorderColor = i3;
        this.thumbDownFillColor = i4;
    }

    public /* synthetic */ ThumbsButtonsTheme(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? C3902R.color.qualtricsDefaultButton : i, (i5 & 2) != 0 ? C3902R.color.qualtricsDefaultBackground : i2, (i5 & 4) != 0 ? C3902R.color.qualtricsDefaultButton : i3, (i5 & 8) != 0 ? C3902R.color.qualtricsDefaultBackground : i4);
    }

    public final int getThumbUpBorderColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.thumbUpBorderColor);
    }

    public final int getThumbUpFillColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.thumbUpFillColor);
    }

    public final int getThumbDownBorderColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.thumbDownBorderColor);
    }

    public final int getThumbDownFillColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.thumbDownFillColor);
    }
}
