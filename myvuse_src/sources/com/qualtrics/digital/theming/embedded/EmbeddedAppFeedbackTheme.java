package com.qualtrics.digital.theming.embedded;

import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.qualtrics.C3902R;
import com.qualtrics.digital.ThemingUtils;
import com.qualtrics.digital.theming.embedded.response.EmojiTheme;
import com.qualtrics.digital.theming.embedded.response.StarTheme;
import com.qualtrics.digital.theming.embedded.response.TextInputTheme;
import com.qualtrics.digital.theming.embedded.response.ThumbsButtonsTheme;
import com.qualtrics.digital.theming.embedded.response.YesNoButtonsTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddedAppFeedbackTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\t\u0010/\u001a\u00020\u0003HÂ\u0003J\t\u00100\u001a\u00020\u0013HÆ\u0003J\t\u00101\u001a\u00020\u0015HÆ\u0003J\t\u00102\u001a\u00020\u0017HÆ\u0003J\t\u00103\u001a\u00020\u0019HÆ\u0003J\t\u00104\u001a\u00020\u0003HÂ\u0003J\t\u00105\u001a\u00020\u0003HÂ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003J\t\u0010;\u001a\u00020\u0011HÆ\u0003J\u008b\u0001\u0010<\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BH\u0007J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BH\u0007J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BH\u0007J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020GHÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006H"}, m5598d2 = {"Lcom/qualtrics/digital/theming/embedded/EmbeddedAppFeedbackTheme;", "", "dialogBackgroundColor", "", OTUXParamsKeys.OT_UX_CLOSE_BUTTON_COLOR, "closeButtonBackgroundColor", "initialQuestionTheme", "Lcom/qualtrics/digital/theming/embedded/InitialQuestionTheme;", "followupQuestionTheme", "Lcom/qualtrics/digital/theming/embedded/FollowupQuestionTheme;", "thankYouTheme", "Lcom/qualtrics/digital/theming/embedded/ThankYouTheme;", "yesNoButtonsTheme", "Lcom/qualtrics/digital/theming/embedded/response/YesNoButtonsTheme;", "thumbsButtonsTheme", "Lcom/qualtrics/digital/theming/embedded/response/ThumbsButtonsTheme;", "emojiTheme", "Lcom/qualtrics/digital/theming/embedded/response/EmojiTheme;", "starTheme", "Lcom/qualtrics/digital/theming/embedded/response/StarTheme;", "multipleChoiceTheme", "Lcom/qualtrics/digital/theming/embedded/MultipleChoiceTheme;", "submitButtonTheme", "Lcom/qualtrics/digital/theming/embedded/SubmitButtonTheme;", "textInputTheme", "Lcom/qualtrics/digital/theming/embedded/response/TextInputTheme;", "(IIILcom/qualtrics/digital/theming/embedded/InitialQuestionTheme;Lcom/qualtrics/digital/theming/embedded/FollowupQuestionTheme;Lcom/qualtrics/digital/theming/embedded/ThankYouTheme;Lcom/qualtrics/digital/theming/embedded/response/YesNoButtonsTheme;Lcom/qualtrics/digital/theming/embedded/response/ThumbsButtonsTheme;Lcom/qualtrics/digital/theming/embedded/response/EmojiTheme;Lcom/qualtrics/digital/theming/embedded/response/StarTheme;Lcom/qualtrics/digital/theming/embedded/MultipleChoiceTheme;Lcom/qualtrics/digital/theming/embedded/SubmitButtonTheme;Lcom/qualtrics/digital/theming/embedded/response/TextInputTheme;)V", "getEmojiTheme", "()Lcom/qualtrics/digital/theming/embedded/response/EmojiTheme;", "getFollowupQuestionTheme", "()Lcom/qualtrics/digital/theming/embedded/FollowupQuestionTheme;", "getInitialQuestionTheme", "()Lcom/qualtrics/digital/theming/embedded/InitialQuestionTheme;", "getMultipleChoiceTheme", "()Lcom/qualtrics/digital/theming/embedded/MultipleChoiceTheme;", "getStarTheme", "()Lcom/qualtrics/digital/theming/embedded/response/StarTheme;", "getSubmitButtonTheme", "()Lcom/qualtrics/digital/theming/embedded/SubmitButtonTheme;", "getTextInputTheme", "()Lcom/qualtrics/digital/theming/embedded/response/TextInputTheme;", "getThankYouTheme", "()Lcom/qualtrics/digital/theming/embedded/ThankYouTheme;", "getThumbsButtonsTheme", "()Lcom/qualtrics/digital/theming/embedded/response/ThumbsButtonsTheme;", "getYesNoButtonsTheme", "()Lcom/qualtrics/digital/theming/embedded/response/YesNoButtonsTheme;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getCloseButtonBackgroundColor", "themingUtils", "Lcom/qualtrics/digital/ThemingUtils;", "getCloseButtonColor", "getDialogBackgroundColor", "hashCode", "toString", "", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class EmbeddedAppFeedbackTheme {
    private final int closeButtonBackgroundColor;
    private final int closeButtonColor;
    private final int dialogBackgroundColor;
    private final EmojiTheme emojiTheme;
    private final FollowupQuestionTheme followupQuestionTheme;
    private final InitialQuestionTheme initialQuestionTheme;
    private final MultipleChoiceTheme multipleChoiceTheme;
    private final StarTheme starTheme;
    private final SubmitButtonTheme submitButtonTheme;
    private final TextInputTheme textInputTheme;
    private final ThankYouTheme thankYouTheme;
    private final ThumbsButtonsTheme thumbsButtonsTheme;
    private final YesNoButtonsTheme yesNoButtonsTheme;

    public EmbeddedAppFeedbackTheme() {
        this(0, 0, 0, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getDialogBackgroundColor() {
        return this.dialogBackgroundColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getCloseButtonColor() {
        return this.closeButtonColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getCloseButtonBackgroundColor() {
        return this.closeButtonBackgroundColor;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final StarTheme getStarTheme() {
        return this.starTheme;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MultipleChoiceTheme getMultipleChoiceTheme() {
        return this.multipleChoiceTheme;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final SubmitButtonTheme getSubmitButtonTheme() {
        return this.submitButtonTheme;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final TextInputTheme getTextInputTheme() {
        return this.textInputTheme;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final InitialQuestionTheme getInitialQuestionTheme() {
        return this.initialQuestionTheme;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FollowupQuestionTheme getFollowupQuestionTheme() {
        return this.followupQuestionTheme;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ThankYouTheme getThankYouTheme() {
        return this.thankYouTheme;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final YesNoButtonsTheme getYesNoButtonsTheme() {
        return this.yesNoButtonsTheme;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ThumbsButtonsTheme getThumbsButtonsTheme() {
        return this.thumbsButtonsTheme;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final EmojiTheme getEmojiTheme() {
        return this.emojiTheme;
    }

    public final EmbeddedAppFeedbackTheme copy(int dialogBackgroundColor, int closeButtonColor, int closeButtonBackgroundColor, InitialQuestionTheme initialQuestionTheme, FollowupQuestionTheme followupQuestionTheme, ThankYouTheme thankYouTheme, YesNoButtonsTheme yesNoButtonsTheme, ThumbsButtonsTheme thumbsButtonsTheme, EmojiTheme emojiTheme, StarTheme starTheme, MultipleChoiceTheme multipleChoiceTheme, SubmitButtonTheme submitButtonTheme, TextInputTheme textInputTheme) {
        Intrinsics.checkNotNullParameter(initialQuestionTheme, "initialQuestionTheme");
        Intrinsics.checkNotNullParameter(followupQuestionTheme, "followupQuestionTheme");
        Intrinsics.checkNotNullParameter(thankYouTheme, "thankYouTheme");
        Intrinsics.checkNotNullParameter(yesNoButtonsTheme, "yesNoButtonsTheme");
        Intrinsics.checkNotNullParameter(thumbsButtonsTheme, "thumbsButtonsTheme");
        Intrinsics.checkNotNullParameter(emojiTheme, "emojiTheme");
        Intrinsics.checkNotNullParameter(starTheme, "starTheme");
        Intrinsics.checkNotNullParameter(multipleChoiceTheme, "multipleChoiceTheme");
        Intrinsics.checkNotNullParameter(submitButtonTheme, "submitButtonTheme");
        Intrinsics.checkNotNullParameter(textInputTheme, "textInputTheme");
        return new EmbeddedAppFeedbackTheme(dialogBackgroundColor, closeButtonColor, closeButtonBackgroundColor, initialQuestionTheme, followupQuestionTheme, thankYouTheme, yesNoButtonsTheme, thumbsButtonsTheme, emojiTheme, starTheme, multipleChoiceTheme, submitButtonTheme, textInputTheme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddedAppFeedbackTheme)) {
            return false;
        }
        EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme = (EmbeddedAppFeedbackTheme) other;
        return this.dialogBackgroundColor == embeddedAppFeedbackTheme.dialogBackgroundColor && this.closeButtonColor == embeddedAppFeedbackTheme.closeButtonColor && this.closeButtonBackgroundColor == embeddedAppFeedbackTheme.closeButtonBackgroundColor && Intrinsics.areEqual(this.initialQuestionTheme, embeddedAppFeedbackTheme.initialQuestionTheme) && Intrinsics.areEqual(this.followupQuestionTheme, embeddedAppFeedbackTheme.followupQuestionTheme) && Intrinsics.areEqual(this.thankYouTheme, embeddedAppFeedbackTheme.thankYouTheme) && Intrinsics.areEqual(this.yesNoButtonsTheme, embeddedAppFeedbackTheme.yesNoButtonsTheme) && Intrinsics.areEqual(this.thumbsButtonsTheme, embeddedAppFeedbackTheme.thumbsButtonsTheme) && Intrinsics.areEqual(this.emojiTheme, embeddedAppFeedbackTheme.emojiTheme) && Intrinsics.areEqual(this.starTheme, embeddedAppFeedbackTheme.starTheme) && Intrinsics.areEqual(this.multipleChoiceTheme, embeddedAppFeedbackTheme.multipleChoiceTheme) && Intrinsics.areEqual(this.submitButtonTheme, embeddedAppFeedbackTheme.submitButtonTheme) && Intrinsics.areEqual(this.textInputTheme, embeddedAppFeedbackTheme.textInputTheme);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Integer.hashCode(this.dialogBackgroundColor) * 31) + Integer.hashCode(this.closeButtonColor)) * 31) + Integer.hashCode(this.closeButtonBackgroundColor)) * 31) + this.initialQuestionTheme.hashCode()) * 31) + this.followupQuestionTheme.hashCode()) * 31) + this.thankYouTheme.hashCode()) * 31) + this.yesNoButtonsTheme.hashCode()) * 31) + this.thumbsButtonsTheme.hashCode()) * 31) + this.emojiTheme.hashCode()) * 31) + this.starTheme.hashCode()) * 31) + this.multipleChoiceTheme.hashCode()) * 31) + this.submitButtonTheme.hashCode()) * 31) + this.textInputTheme.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EmbeddedAppFeedbackTheme(dialogBackgroundColor=");
        sb.append(this.dialogBackgroundColor).append(", closeButtonColor=").append(this.closeButtonColor).append(", closeButtonBackgroundColor=").append(this.closeButtonBackgroundColor).append(", initialQuestionTheme=").append(this.initialQuestionTheme).append(", followupQuestionTheme=").append(this.followupQuestionTheme).append(", thankYouTheme=").append(this.thankYouTheme).append(", yesNoButtonsTheme=").append(this.yesNoButtonsTheme).append(", thumbsButtonsTheme=").append(this.thumbsButtonsTheme).append(", emojiTheme=").append(this.emojiTheme).append(", starTheme=").append(this.starTheme).append(", multipleChoiceTheme=").append(this.multipleChoiceTheme).append(", submitButtonTheme=");
        sb.append(this.submitButtonTheme).append(", textInputTheme=").append(this.textInputTheme).append(')');
        return sb.toString();
    }

    public EmbeddedAppFeedbackTheme(int i, int i2, int i3, InitialQuestionTheme initialQuestionTheme, FollowupQuestionTheme followupQuestionTheme, ThankYouTheme thankYouTheme, YesNoButtonsTheme yesNoButtonsTheme, ThumbsButtonsTheme thumbsButtonsTheme, EmojiTheme emojiTheme, StarTheme starTheme, MultipleChoiceTheme multipleChoiceTheme, SubmitButtonTheme submitButtonTheme, TextInputTheme textInputTheme) {
        Intrinsics.checkNotNullParameter(initialQuestionTheme, "initialQuestionTheme");
        Intrinsics.checkNotNullParameter(followupQuestionTheme, "followupQuestionTheme");
        Intrinsics.checkNotNullParameter(thankYouTheme, "thankYouTheme");
        Intrinsics.checkNotNullParameter(yesNoButtonsTheme, "yesNoButtonsTheme");
        Intrinsics.checkNotNullParameter(thumbsButtonsTheme, "thumbsButtonsTheme");
        Intrinsics.checkNotNullParameter(emojiTheme, "emojiTheme");
        Intrinsics.checkNotNullParameter(starTheme, "starTheme");
        Intrinsics.checkNotNullParameter(multipleChoiceTheme, "multipleChoiceTheme");
        Intrinsics.checkNotNullParameter(submitButtonTheme, "submitButtonTheme");
        Intrinsics.checkNotNullParameter(textInputTheme, "textInputTheme");
        this.dialogBackgroundColor = i;
        this.closeButtonColor = i2;
        this.closeButtonBackgroundColor = i3;
        this.initialQuestionTheme = initialQuestionTheme;
        this.followupQuestionTheme = followupQuestionTheme;
        this.thankYouTheme = thankYouTheme;
        this.yesNoButtonsTheme = yesNoButtonsTheme;
        this.thumbsButtonsTheme = thumbsButtonsTheme;
        this.emojiTheme = emojiTheme;
        this.starTheme = starTheme;
        this.multipleChoiceTheme = multipleChoiceTheme;
        this.submitButtonTheme = submitButtonTheme;
        this.textInputTheme = textInputTheme;
    }

    public /* synthetic */ EmbeddedAppFeedbackTheme(int i, int i2, int i3, InitialQuestionTheme initialQuestionTheme, FollowupQuestionTheme followupQuestionTheme, ThankYouTheme thankYouTheme, YesNoButtonsTheme yesNoButtonsTheme, ThumbsButtonsTheme thumbsButtonsTheme, EmojiTheme emojiTheme, StarTheme starTheme, MultipleChoiceTheme multipleChoiceTheme, SubmitButtonTheme submitButtonTheme, TextInputTheme textInputTheme, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? C3902R.color.qualtricsDefaultBackground : i, (i4 & 2) != 0 ? C3902R.color.qualtricsDefaultCloseButton : i2, (i4 & 4) != 0 ? C3902R.color.transparent : i3, (i4 & 8) != 0 ? new InitialQuestionTheme(0, null, 3, null) : initialQuestionTheme, (i4 & 16) != 0 ? new FollowupQuestionTheme(0, null, null, 7, null) : followupQuestionTheme, (i4 & 32) != 0 ? new ThankYouTheme(0, null, 3, null) : thankYouTheme, (i4 & 64) != 0 ? new YesNoButtonsTheme(0, 0, 0, null, 0, 0, 0, null, 255, null) : yesNoButtonsTheme, (i4 & 128) != 0 ? new ThumbsButtonsTheme(0, 0, 0, 0, 15, null) : thumbsButtonsTheme, (i4 & 256) != 0 ? new EmojiTheme(0, 0, 0, 7, null) : emojiTheme, (i4 & 512) != 0 ? new StarTheme(0, 1, null) : starTheme, (i4 & 1024) != 0 ? new MultipleChoiceTheme(null, 0, null, 0, null, 31, null) : multipleChoiceTheme, (i4 & 2048) != 0 ? new SubmitButtonTheme(0, 0, null, 7, null) : submitButtonTheme, (i4 & 4096) != 0 ? new TextInputTheme(0, 0, 3, null) : textInputTheme);
    }

    public final InitialQuestionTheme getInitialQuestionTheme() {
        return this.initialQuestionTheme;
    }

    public final FollowupQuestionTheme getFollowupQuestionTheme() {
        return this.followupQuestionTheme;
    }

    public final ThankYouTheme getThankYouTheme() {
        return this.thankYouTheme;
    }

    public final YesNoButtonsTheme getYesNoButtonsTheme() {
        return this.yesNoButtonsTheme;
    }

    public final ThumbsButtonsTheme getThumbsButtonsTheme() {
        return this.thumbsButtonsTheme;
    }

    public final EmojiTheme getEmojiTheme() {
        return this.emojiTheme;
    }

    public final StarTheme getStarTheme() {
        return this.starTheme;
    }

    public final MultipleChoiceTheme getMultipleChoiceTheme() {
        return this.multipleChoiceTheme;
    }

    public final SubmitButtonTheme getSubmitButtonTheme() {
        return this.submitButtonTheme;
    }

    public final TextInputTheme getTextInputTheme() {
        return this.textInputTheme;
    }

    public final int getDialogBackgroundColor(ThemingUtils themingUtils) {
        Intrinsics.checkNotNullParameter(themingUtils, "themingUtils");
        return themingUtils.getColorByResource(this.dialogBackgroundColor);
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
