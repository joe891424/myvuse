package com.qualtrics.digital.theming.embedded;

import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.fonts.FontTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultipleChoiceTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/MultipleChoiceTheme;", "", "questionTextFont", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "otherAnswerTextColor", "", "otherAnswerTextFont", "otherAnswerBackgroundColor", "radioButtonsTheme", "Lcom/qualtrics/digital/theming/embedded/RadioButtonsTheme;", "(Lcom/qualtrics/digital/theming/fonts/FontTheme;ILcom/qualtrics/digital/theming/fonts/FontTheme;ILcom/qualtrics/digital/theming/embedded/RadioButtonsTheme;)V", "getOtherAnswerTextFont", "()Lcom/qualtrics/digital/theming/fonts/FontTheme;", "getQuestionTextFont", "getRadioButtonsTheme", "()Lcom/qualtrics/digital/theming/embedded/RadioButtonsTheme;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "getOtherAnswerBackgroundColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "getOtherAnswerTextColor", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MultipleChoiceTheme {
    private final int otherAnswerBackgroundColor;
    private final int otherAnswerTextColor;
    private final FontTheme otherAnswerTextFont;
    private final FontTheme questionTextFont;
    private final RadioButtonsTheme radioButtonsTheme;

    public MultipleChoiceTheme() {
        this(null, 0, null, 0, null, 31, null);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getOtherAnswerTextColor() {
        return this.otherAnswerTextColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final int getOtherAnswerBackgroundColor() {
        return this.otherAnswerBackgroundColor;
    }

    public static /* synthetic */ MultipleChoiceTheme copy$default(MultipleChoiceTheme multipleChoiceTheme, FontTheme fontTheme, int i, FontTheme fontTheme2, int i2, RadioButtonsTheme radioButtonsTheme, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            fontTheme = multipleChoiceTheme.questionTextFont;
        }
        if ((i3 & 2) != 0) {
            i = multipleChoiceTheme.otherAnswerTextColor;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            fontTheme2 = multipleChoiceTheme.otherAnswerTextFont;
        }
        FontTheme fontTheme3 = fontTheme2;
        if ((i3 & 8) != 0) {
            i2 = multipleChoiceTheme.otherAnswerBackgroundColor;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            radioButtonsTheme = multipleChoiceTheme.radioButtonsTheme;
        }
        return multipleChoiceTheme.copy(fontTheme, i4, fontTheme3, i5, radioButtonsTheme);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FontTheme getQuestionTextFont() {
        return this.questionTextFont;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FontTheme getOtherAnswerTextFont() {
        return this.otherAnswerTextFont;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final RadioButtonsTheme getRadioButtonsTheme() {
        return this.radioButtonsTheme;
    }

    public final MultipleChoiceTheme copy(FontTheme questionTextFont, int otherAnswerTextColor, FontTheme otherAnswerTextFont, int otherAnswerBackgroundColor, RadioButtonsTheme radioButtonsTheme) {
        Intrinsics.checkNotNullParameter(questionTextFont, "questionTextFont");
        Intrinsics.checkNotNullParameter(otherAnswerTextFont, "otherAnswerTextFont");
        Intrinsics.checkNotNullParameter(radioButtonsTheme, "radioButtonsTheme");
        return new MultipleChoiceTheme(questionTextFont, otherAnswerTextColor, otherAnswerTextFont, otherAnswerBackgroundColor, radioButtonsTheme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultipleChoiceTheme)) {
            return false;
        }
        MultipleChoiceTheme multipleChoiceTheme = (MultipleChoiceTheme) other;
        return Intrinsics.areEqual(this.questionTextFont, multipleChoiceTheme.questionTextFont) && this.otherAnswerTextColor == multipleChoiceTheme.otherAnswerTextColor && Intrinsics.areEqual(this.otherAnswerTextFont, multipleChoiceTheme.otherAnswerTextFont) && this.otherAnswerBackgroundColor == multipleChoiceTheme.otherAnswerBackgroundColor && Intrinsics.areEqual(this.radioButtonsTheme, multipleChoiceTheme.radioButtonsTheme);
    }

    public int hashCode() {
        return (((((((this.questionTextFont.hashCode() * 31) + Integer.hashCode(this.otherAnswerTextColor)) * 31) + this.otherAnswerTextFont.hashCode()) * 31) + Integer.hashCode(this.otherAnswerBackgroundColor)) * 31) + this.radioButtonsTheme.hashCode();
    }

    public String toString() {
        return "MultipleChoiceTheme(questionTextFont=" + this.questionTextFont + ", otherAnswerTextColor=" + this.otherAnswerTextColor + ", otherAnswerTextFont=" + this.otherAnswerTextFont + ", otherAnswerBackgroundColor=" + this.otherAnswerBackgroundColor + ", radioButtonsTheme=" + this.radioButtonsTheme + ')';
    }

    public MultipleChoiceTheme(FontTheme questionTextFont, int i, FontTheme otherAnswerTextFont, int i2, RadioButtonsTheme radioButtonsTheme) {
        Intrinsics.checkNotNullParameter(questionTextFont, "questionTextFont");
        Intrinsics.checkNotNullParameter(otherAnswerTextFont, "otherAnswerTextFont");
        Intrinsics.checkNotNullParameter(radioButtonsTheme, "radioButtonsTheme");
        this.questionTextFont = questionTextFont;
        this.otherAnswerTextColor = i;
        this.otherAnswerTextFont = otherAnswerTextFont;
        this.otherAnswerBackgroundColor = i2;
        this.radioButtonsTheme = radioButtonsTheme;
    }

    public /* synthetic */ MultipleChoiceTheme(FontTheme fontTheme, int i, FontTheme fontTheme2, int i2, RadioButtonsTheme radioButtonsTheme, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new FontTheme(0, 20, 1, null) : fontTheme, (i3 & 2) != 0 ? C3902R.color.qualtricsDefaultTextInput : i, (i3 & 4) != 0 ? new FontTheme(0, 18, 1, null) : fontTheme2, (i3 & 8) != 0 ? C3902R.color.qualtricsDefaultTextInputBackground : i2, (i3 & 16) != 0 ? new RadioButtonsTheme(null, 0, 0, 0, 15, null) : radioButtonsTheme);
    }

    public final FontTheme getQuestionTextFont() {
        return this.questionTextFont;
    }

    public final FontTheme getOtherAnswerTextFont() {
        return this.otherAnswerTextFont;
    }

    public final RadioButtonsTheme getRadioButtonsTheme() {
        return this.radioButtonsTheme;
    }

    public final int getOtherAnswerBackgroundColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.otherAnswerBackgroundColor);
    }

    public final int getOtherAnswerTextColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.otherAnswerTextColor);
    }
}
