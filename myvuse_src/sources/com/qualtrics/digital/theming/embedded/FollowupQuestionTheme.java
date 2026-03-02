package com.qualtrics.digital.theming.embedded;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.fonts.FontTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FollowupQuestionTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0018"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/FollowupQuestionTheme;", "", "color", "", "followupQuestionFont", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "followupQuestionTextInputFont", "(ILcom/qualtrics/digital/theming/fonts/FontTheme;Lcom/qualtrics/digital/theming/fonts/FontTheme;)V", "getFollowupQuestionFont", "()Lcom/qualtrics/digital/theming/fonts/FontTheme;", "getFollowupQuestionTextInputFont", "component1", "component2", "component3", "copy", "equals", "", "other", "getColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FollowupQuestionTheme {
    private final int color;
    private final FontTheme followupQuestionFont;
    private final FontTheme followupQuestionTextInputFont;

    public FollowupQuestionTheme() {
        this(0, null, null, 7, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getColor() {
        return this.color;
    }

    public static /* synthetic */ FollowupQuestionTheme copy$default(FollowupQuestionTheme followupQuestionTheme, int i, FontTheme fontTheme, FontTheme fontTheme2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = followupQuestionTheme.color;
        }
        if ((i2 & 2) != 0) {
            fontTheme = followupQuestionTheme.followupQuestionFont;
        }
        if ((i2 & 4) != 0) {
            fontTheme2 = followupQuestionTheme.followupQuestionTextInputFont;
        }
        return followupQuestionTheme.copy(i, fontTheme, fontTheme2);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FontTheme getFollowupQuestionFont() {
        return this.followupQuestionFont;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FontTheme getFollowupQuestionTextInputFont() {
        return this.followupQuestionTextInputFont;
    }

    public final FollowupQuestionTheme copy(int color, FontTheme followupQuestionFont, FontTheme followupQuestionTextInputFont) {
        Intrinsics.checkNotNullParameter(followupQuestionFont, "followupQuestionFont");
        Intrinsics.checkNotNullParameter(followupQuestionTextInputFont, "followupQuestionTextInputFont");
        return new FollowupQuestionTheme(color, followupQuestionFont, followupQuestionTextInputFont);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowupQuestionTheme)) {
            return false;
        }
        FollowupQuestionTheme followupQuestionTheme = (FollowupQuestionTheme) other;
        return this.color == followupQuestionTheme.color && Intrinsics.areEqual(this.followupQuestionFont, followupQuestionTheme.followupQuestionFont) && Intrinsics.areEqual(this.followupQuestionTextInputFont, followupQuestionTheme.followupQuestionTextInputFont);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.color) * 31) + this.followupQuestionFont.hashCode()) * 31) + this.followupQuestionTextInputFont.hashCode();
    }

    public String toString() {
        return "FollowupQuestionTheme(color=" + this.color + ", followupQuestionFont=" + this.followupQuestionFont + ", followupQuestionTextInputFont=" + this.followupQuestionTextInputFont + ')';
    }

    public FollowupQuestionTheme(int i, FontTheme followupQuestionFont, FontTheme followupQuestionTextInputFont) {
        Intrinsics.checkNotNullParameter(followupQuestionFont, "followupQuestionFont");
        Intrinsics.checkNotNullParameter(followupQuestionTextInputFont, "followupQuestionTextInputFont");
        this.color = i;
        this.followupQuestionFont = followupQuestionFont;
        this.followupQuestionTextInputFont = followupQuestionTextInputFont;
    }

    public /* synthetic */ FollowupQuestionTheme(int i, FontTheme fontTheme, FontTheme fontTheme2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C3902R.color.qualtricsDefaultText : i, (i2 & 2) != 0 ? new FontTheme(0, 20, 1, null) : fontTheme, (i2 & 4) != 0 ? new FontTheme(0, 18, 1, null) : fontTheme2);
    }

    public final FontTheme getFollowupQuestionFont() {
        return this.followupQuestionFont;
    }

    public final FontTheme getFollowupQuestionTextInputFont() {
        return this.followupQuestionTextInputFont;
    }

    public final int getColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.color);
    }
}
