package com.qualtrics.digital;

import com.qualtrics.digital.theming.embedded.EmbeddedAppFeedbackTheme;
import com.qualtrics.digital.theming.prompt.MobileAppPromptTheme;

/* JADX INFO: loaded from: classes6.dex */
class ThemeApplier {
    ThemingUtils themingUtils;

    public ThemeApplier(ThemingUtils themingUtils) {
        this.themingUtils = themingUtils;
    }

    public boolean shouldPopOverUseTheming(PopOverOptions popOverOptions) {
        Boolean bool = popOverOptions.themeOverriddenThroughSdk;
        return bool != null && bool.booleanValue();
    }

    public boolean shouldEmbeddedFeedbackUseTheming(EmbeddedFeedbackCreativeOptions embeddedFeedbackCreativeOptions) {
        Boolean bool = embeddedFeedbackCreativeOptions.themeOverriddenThroughSdk;
        return bool != null && bool.booleanValue();
    }

    public PopOverOptions computePopOverOptionsTheming(PopOverOptions popOverOptions, QualtricsTheme qualtricsTheme) {
        MobileAppPromptTheme mobileAppPromptTheme = qualtricsTheme.getMobileAppPromptTheme();
        PopOverOptions popOverOptionsM6390clone = popOverOptions.m6390clone();
        Buttons buttons = popOverOptionsM6390clone.Buttons;
        if (buttons.hasCloseButton()) {
            ThemingUtils themingUtils = this.themingUtils;
            buttons.CloseButtonColor = themingUtils.getHexColor(mobileAppPromptTheme.getCloseButtonColor(themingUtils));
            ThemingUtils themingUtils2 = this.themingUtils;
            buttons.CloseButtonBackgroundColor = themingUtils2.getHexColor(mobileAppPromptTheme.getCloseButtonBackgroundColor(themingUtils2));
        }
        SizeAndStyle sizeAndStyle = popOverOptionsM6390clone.SizeAndStyle;
        ThemingUtils themingUtils3 = this.themingUtils;
        sizeAndStyle.InterceptColor = themingUtils3.getHexColor(mobileAppPromptTheme.getBackgroundColor(themingUtils3));
        TitleTextOptions titleTextOptions = popOverOptionsM6390clone.Title;
        ThemingUtils themingUtils4 = this.themingUtils;
        titleTextOptions.Color = themingUtils4.getHexColor(mobileAppPromptTheme.getHeadlineTextColor(themingUtils4));
        DescriptionTextOptions descriptionTextOptions = popOverOptionsM6390clone.Description;
        ThemingUtils themingUtils5 = this.themingUtils;
        descriptionTextOptions.Color = themingUtils5.getHexColor(mobileAppPromptTheme.getDescriptionTextColor(themingUtils5));
        ButtonOptions buttonOptions = buttons.ButtonOne;
        ButtonOptions buttonOptions2 = buttons.ButtonTwo;
        buttonOptions.Color = this.themingUtils.getHexColor(mobileAppPromptTheme.getButtonOneTheme().getLabelColor(this.themingUtils));
        buttonOptions.BackgroundColor = this.themingUtils.getHexColor(mobileAppPromptTheme.getButtonOneTheme().getBackgroundColor(this.themingUtils));
        buttonOptions.BorderColor = this.themingUtils.getHexColor(mobileAppPromptTheme.getButtonOneTheme().getBorderColor(this.themingUtils));
        buttonOptions2.Color = this.themingUtils.getHexColor(mobileAppPromptTheme.getButtonTwoTheme().getLabelColor(this.themingUtils));
        buttonOptions2.BackgroundColor = this.themingUtils.getHexColor(mobileAppPromptTheme.getButtonTwoTheme().getBackgroundColor(this.themingUtils));
        buttonOptions2.BorderColor = this.themingUtils.getHexColor(mobileAppPromptTheme.getButtonTwoTheme().getBorderColor(this.themingUtils));
        if (buttons.ButtonStyle.equals("link")) {
            buttonOptions.Color = this.themingUtils.getHexColor(mobileAppPromptTheme.getButtonOneTheme().getLinkColor(this.themingUtils));
            buttonOptions2.Color = this.themingUtils.getHexColor(mobileAppPromptTheme.getButtonTwoTheme().getLinkColor(this.themingUtils));
        }
        return popOverOptionsM6390clone;
    }

    public EmbeddedFeedbackCreativeOptions computeEmbeddedFeedbackCreativeOptionsTheming(EmbeddedFeedbackCreativeOptions embeddedFeedbackCreativeOptions, QualtricsTheme qualtricsTheme) {
        EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme = qualtricsTheme.getEmbeddedAppFeedbackTheme();
        EmbeddedFeedbackCreativeOptions embeddedFeedbackCreativeOptionsM6383clone = embeddedFeedbackCreativeOptions.m6383clone();
        embeddedFeedbackCreativeOptionsM6383clone.SubmitButtonAppearance.ButtonTextColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getSubmitButtonTheme().getTextColor(this.themingUtils));
        embeddedFeedbackCreativeOptionsM6383clone.SubmitButtonAppearance.ButtonFillColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getSubmitButtonTheme().getFillColor(this.themingUtils));
        for (EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion : embeddedFeedbackCreativeOptionsM6383clone.Questions) {
            embeddedFeedbackCreativeQuestion.Appearance.QuestionTextColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getFollowupQuestionTheme().getColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.StarsColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getStarTheme().getBorderColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.EmojiBorderColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getEmojiTheme().getBorderColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.EmojiFillColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getEmojiTheme().getFillColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.EmojiTintColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getEmojiTheme().getTintColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.ButtonBorderColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getYesNoButtonsTheme().getYesButtonBorderColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.ButtonFillColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getYesNoButtonsTheme().getYesButtonFillColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.ButtonTextColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getYesNoButtonsTheme().getYesButtonTextColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.NoButtonBorderColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getYesNoButtonsTheme().getNoButtonBorderColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.NoButtonFillColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getYesNoButtonsTheme().getNoButtonFillColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.NoButtonTextColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getYesNoButtonsTheme().getNoButtonTextColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.ThumbUpBorderColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getThumbsButtonsTheme().getThumbUpBorderColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.ThumbUpFillColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getThumbsButtonsTheme().getThumbUpFillColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.ThumbDownBorderColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getThumbsButtonsTheme().getThumbDownBorderColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.ThumbDownFillColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getThumbsButtonsTheme().getThumbDownFillColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.RadioButtonFillColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getMultipleChoiceTheme().getRadioButtonsTheme().getSelectedCircleColor(this.themingUtils));
            embeddedFeedbackCreativeQuestion.Appearance.RadioButtonUnselectedCircleColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getMultipleChoiceTheme().getRadioButtonsTheme().getUnselectedCircleColor(this.themingUtils));
        }
        EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion2 = embeddedFeedbackCreativeOptionsM6383clone.Questions.get(0);
        if (embeddedFeedbackCreativeQuestion2 != null) {
            embeddedFeedbackCreativeQuestion2.Appearance.QuestionTextColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getInitialQuestionTheme().getColor(this.themingUtils));
        }
        EmbeddedFeedbackCreativeQuestion thankYouMessage = EmbeddedFeedbackUtilsJava.getThankYouMessage(embeddedFeedbackCreativeOptionsM6383clone.Questions);
        if (thankYouMessage != null) {
            thankYouMessage.Appearance.QuestionTextColor = this.themingUtils.getHexColor(embeddedAppFeedbackTheme.getThankYouTheme().getColor(this.themingUtils));
        }
        return embeddedFeedbackCreativeOptionsM6383clone;
    }
}
