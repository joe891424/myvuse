package com.qualtrics.digital.theming.embedded.response;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextInputTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0007J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/response/TextInputTheme;", "", "multilineTextInputColor", "", "multilineTextInputBackgroundColor", "(II)V", "component1", "component2", "copy", "equals", "", "other", "getMultilineTextInputBackgroundColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "getMultilineTextInputColor", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class TextInputTheme {
    private final int multilineTextInputBackgroundColor;
    private final int multilineTextInputColor;

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputTheme() {
        int i = 0;
        this(i, i, 3, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getMultilineTextInputColor() {
        return this.multilineTextInputColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getMultilineTextInputBackgroundColor() {
        return this.multilineTextInputBackgroundColor;
    }

    public static /* synthetic */ TextInputTheme copy$default(TextInputTheme textInputTheme, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = textInputTheme.multilineTextInputColor;
        }
        if ((i3 & 2) != 0) {
            i2 = textInputTheme.multilineTextInputBackgroundColor;
        }
        return textInputTheme.copy(i, i2);
    }

    public final TextInputTheme copy(int multilineTextInputColor, int multilineTextInputBackgroundColor) {
        return new TextInputTheme(multilineTextInputColor, multilineTextInputBackgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextInputTheme)) {
            return false;
        }
        TextInputTheme textInputTheme = (TextInputTheme) other;
        return this.multilineTextInputColor == textInputTheme.multilineTextInputColor && this.multilineTextInputBackgroundColor == textInputTheme.multilineTextInputBackgroundColor;
    }

    public int hashCode() {
        return (Integer.hashCode(this.multilineTextInputColor) * 31) + Integer.hashCode(this.multilineTextInputBackgroundColor);
    }

    public String toString() {
        return "TextInputTheme(multilineTextInputColor=" + this.multilineTextInputColor + ", multilineTextInputBackgroundColor=" + this.multilineTextInputBackgroundColor + ')';
    }

    public TextInputTheme(int i, int i2) {
        this.multilineTextInputColor = i;
        this.multilineTextInputBackgroundColor = i2;
    }

    public /* synthetic */ TextInputTheme(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? C3902R.color.qualtricsDefaultTextInput : i, (i3 & 2) != 0 ? C3902R.color.qualtricsDefaultTextInputBackground : i2);
    }

    public final int getMultilineTextInputBackgroundColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.multilineTextInputBackgroundColor);
    }

    public final int getMultilineTextInputColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.multilineTextInputColor);
    }
}
