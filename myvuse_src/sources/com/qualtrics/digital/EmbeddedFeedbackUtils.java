package com.qualtrics.digital;

import android.R;
import android.content.res.ColorStateList;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qualtrics.digital.theming.embedded.EmbeddedAppFeedbackTheme;
import com.qualtrics.digital.theming.embedded.response.YesNoButtonsTheme;
import com.qualtrics.digital.theming.fonts.FontTheme;
import com.qualtrics.digital.utils.TranslationUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddedFeedbackUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0007J\u001e\u0010<\u001a\u0004\u0018\u00010\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u000bH\u0007J&\u0010?\u001a\u0004\u0018\u00010\u000b2\u0006\u0010@\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010A\u001a\u00020B2\b\b\u0001\u0010C\u001a\u00020\u00042\b\b\u0001\u0010D\u001a\u00020\u0004H\u0007J\u001e\u0010E\u001a\u0004\u0018\u00010\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u000bH\u0007J\u001e\u0010F\u001a\u0004\u0018\u00010\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u000bH\u0007JR\u0010G\u001a\u0004\u0018\u00010\u000b2\b\u0010H\u001a\u0004\u0018\u00010\u000b2(\u0010I\u001a$\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010J\u0018\u00010J2\b\u0010>\u001a\u0004\u0018\u00010\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u000bH\u0007J4\u0010L\u001a\u0004\u0018\u00010\u000b2\u0014\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0J2\b\u0010N\u001a\u0004\u0018\u00010\u000b2\b\u0010O\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, m5598d2 = {"Lcom/qualtrics/digital/EmbeddedFeedbackUtils;", "", "()V", "BORDER_CORNER_RADIUS", "", "BORDER_WIDTH", "BUTTON_BORDER_MARGIN", "BUTTON_FONT_SIZE", "BUTTON_PADDING", "CUSTOM_EMOJI_BORDER", "EMBEDDED_FEEDBACK_BACKGROUND_COLOR", "", "END_QUESTIONS_TAG", "EXTREMELY_HELPFUL", "EXTREMELY_UNHELPFUL", "FIVE_POINT_QUESTION_OPTIONS", "", "[Ljava/lang/String;", "FOLLOW_UP_QUESTION_KEY", "MAIN_QUESTION_KEY", "MAIN_QUESTION_PADDING", "MAIN_QUESTION_TOP_PADDING", "MULTIPLE_CHOICE_OTHER_OPTION_HEIGHT", "MULTIPLE_CHOICE_OTHER_OPTION_LEFT_PADDING", "MULTIPLE_CHOICE_OTHER_OPTION_RIGHT_PADDING", "MULTIPLE_CHOICE_PADDING", "MULTIPLE_CHOICE_QUESTION_BOTTOM_PADDING", "MULTIPLE_CHOICE_QUESTION_KEY", "MULTIPLE_CHOICE_RADIO_GROUP_LEFT_MARGIN", "MULTIPLE_CHOICE_RADIO_GROUP_TOP_MARGIN", "MULTIPLE_CHOICE_TEXT_SIZE", "MULTIPLE_CHOICE_TOP_PADDING", "NEITHER_HELPFUL_NOR_UNHELPFUL", "NO_BUTTON_KEY", "QUESTION_ID_FOLLOW_UP_QUESTION", "QUESTION_ID_MULTIPLE_CHOICE", "QUESTION_ID_THANK_YOU_MESSAGE", "QUESTION_STYLE_CUSTOM", "QUESTION_STYLE_DEFAULT", "QUESTION_STYLE_EMOJI", "QUESTION_STYLE_STARS", "QUESTION_STYLE_THUMBS", "QUESTION_STYLE_YES_NO", "SOMEWHAT_HELPFUL", "SOMEWHAT_UNHELPFUL", "SUBMIT_BUTTON_TEXT_KEY", "THANK_YOU_KEY", "THUMBS_DOWN", "THUMBS_UP", "THUMB_HEIGHT", "THUMB_WIDTH", "YES_BUTTON_KEY", "translationUtils", "Lcom/qualtrics/digital/utils/TranslationUtils;", "getButtonFontTheme", "Lcom/qualtrics/digital/theming/fonts/FontTheme;", "embeddedAppFeedbackTheme", "Lcom/qualtrics/digital/theming/embedded/EmbeddedAppFeedbackTheme;", "isYes", "", "getCloseTranslation", "defaultTranslation", "langCode", "getFivePointChoiceTranslation", FirebaseAnalytics.Param.INDEX, "getRadioButtonColorList", "Landroid/content/res/ColorStateList;", "checkedColor", "radioUnselectedCircleColor", "getThumbsDownTranslation", "getThumbsUpTranslation", "getTranslation", "defaultText", "translations", "", "translationsKey", "translateOrDefault", "map", "originalLangKey", Constants.COLLATION_DEFAULT, "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class EmbeddedFeedbackUtils {
    public static final int BORDER_CORNER_RADIUS = 4;
    public static final int BORDER_WIDTH = 2;
    public static final int BUTTON_BORDER_MARGIN = 10;
    public static final int BUTTON_FONT_SIZE = 16;
    public static final int BUTTON_PADDING = 12;
    public static final int CUSTOM_EMOJI_BORDER = 40;
    public static final String EMBEDDED_FEEDBACK_BACKGROUND_COLOR = "#f5f5f5";
    public static final String END_QUESTIONS_TAG = "End";
    public static final String FOLLOW_UP_QUESTION_KEY = "FollowUpQuestionText";
    public static final String MAIN_QUESTION_KEY = "MainQuestionText";
    public static final int MAIN_QUESTION_PADDING = 16;
    public static final int MAIN_QUESTION_TOP_PADDING = 8;
    public static final int MULTIPLE_CHOICE_OTHER_OPTION_HEIGHT = 40;
    public static final int MULTIPLE_CHOICE_OTHER_OPTION_LEFT_PADDING = 30;
    public static final int MULTIPLE_CHOICE_OTHER_OPTION_RIGHT_PADDING = 20;
    public static final int MULTIPLE_CHOICE_PADDING = 10;
    public static final int MULTIPLE_CHOICE_QUESTION_BOTTOM_PADDING = 10;
    public static final String MULTIPLE_CHOICE_QUESTION_KEY = "MultipleChoiceQuestionText";
    public static final int MULTIPLE_CHOICE_RADIO_GROUP_LEFT_MARGIN = 18;
    public static final int MULTIPLE_CHOICE_RADIO_GROUP_TOP_MARGIN = 10;
    public static final int MULTIPLE_CHOICE_TEXT_SIZE = 18;
    public static final int MULTIPLE_CHOICE_TOP_PADDING = 10;
    public static final String NO_BUTTON_KEY = "NoButtonText";
    public static final String QUESTION_ID_FOLLOW_UP_QUESTION = "embedded-feedback-question-id-follow-up-question";
    public static final String QUESTION_ID_MULTIPLE_CHOICE = "embedded-feedback-question-id-multiple-choice-question";
    public static final String QUESTION_ID_THANK_YOU_MESSAGE = "embedded-feedback-question-id-thank-you-message";
    public static final String QUESTION_STYLE_CUSTOM = "embedded-feedback-emoji-style-custom";
    public static final String QUESTION_STYLE_DEFAULT = "embedded-feedback-emoji-style-default";
    public static final String QUESTION_STYLE_EMOJI = "embedded-feedback-question-style-emoji";
    public static final String QUESTION_STYLE_STARS = "embedded-feedback-question-style-stars";
    public static final String QUESTION_STYLE_THUMBS = "embedded-feedback-question-style-thumbs";
    public static final String QUESTION_STYLE_YES_NO = "embedded-feedback-question-style-yes-no";
    public static final String SUBMIT_BUTTON_TEXT_KEY = "SubmitButtonText";
    public static final String THANK_YOU_KEY = "ThankYouMessage";
    public static final String THUMBS_DOWN = "ThumbsDown";
    public static final String THUMBS_UP = "ThumbsUp";
    public static final int THUMB_HEIGHT = 44;
    public static final int THUMB_WIDTH = 52;
    public static final String YES_BUTTON_KEY = "YesButtonText";
    public static final EmbeddedFeedbackUtils INSTANCE = new EmbeddedFeedbackUtils();
    public static final String EXTREMELY_UNHELPFUL = "ExtremelyUnhelpful";
    public static final String SOMEWHAT_UNHELPFUL = "SomewhatUnhelpful";
    public static final String NEITHER_HELPFUL_NOR_UNHELPFUL = "NeitherHelpfulNorUnhelpful";
    public static final String SOMEWHAT_HELPFUL = "SomewhatHelpful";
    public static final String EXTREMELY_HELPFUL = "ExtremelyHelpful";
    public static final String[] FIVE_POINT_QUESTION_OPTIONS = {EXTREMELY_UNHELPFUL, SOMEWHAT_UNHELPFUL, NEITHER_HELPFUL_NOR_UNHELPFUL, SOMEWHAT_HELPFUL, EXTREMELY_HELPFUL};
    private static final TranslationUtils translationUtils = new TranslationUtils();

    private EmbeddedFeedbackUtils() {
    }

    @JvmStatic
    public static final String getTranslation(String defaultText, Map<String, ? extends Map<String, String>> translations, String langCode, String translationsKey) {
        if (translations == null) {
            return defaultText;
        }
        try {
            Map<String, String> translationsInSupportedLang = translationUtils.getTranslationsInSupportedLang(translations, langCode);
            return (translationsInSupportedLang == null || translationsInSupportedLang.get(translationsKey) == null) ? defaultText : translationsInSupportedLang.get(translationsKey);
        } catch (Exception unused) {
            return defaultText;
        }
    }

    @JvmStatic
    public static final FontTheme getButtonFontTheme(EmbeddedAppFeedbackTheme embeddedAppFeedbackTheme, boolean isYes) {
        YesNoButtonsTheme yesNoButtonsTheme;
        YesNoButtonsTheme yesNoButtonsTheme2;
        if (isYes) {
            if (embeddedAppFeedbackTheme == null || (yesNoButtonsTheme2 = embeddedAppFeedbackTheme.getYesNoButtonsTheme()) == null) {
                return null;
            }
            return yesNoButtonsTheme2.getYesButtonFont();
        }
        if (embeddedAppFeedbackTheme == null || (yesNoButtonsTheme = embeddedAppFeedbackTheme.getYesNoButtonsTheme()) == null) {
            return null;
        }
        return yesNoButtonsTheme.getNoButtonFont();
    }

    @JvmStatic
    public static final ColorStateList getRadioButtonColorList(int checkedColor, int radioUnselectedCircleColor) {
        return new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{R.attr.state_checked}}, new int[]{radioUnselectedCircleColor, checkedColor});
    }

    @JvmStatic
    public static final String getThumbsUpTranslation(String defaultTranslation, String langCode) {
        EmbeddedFeedbackUtils embeddedFeedbackUtils = INSTANCE;
        Map<String, String> THUMBS_UP_LANGUAGES = EmbeddedFeedbackAccessibilityConstants.THUMBS_UP_LANGUAGES;
        Intrinsics.checkNotNullExpressionValue(THUMBS_UP_LANGUAGES, "THUMBS_UP_LANGUAGES");
        return embeddedFeedbackUtils.translateOrDefault(THUMBS_UP_LANGUAGES, langCode, defaultTranslation);
    }

    @JvmStatic
    public static final String getThumbsDownTranslation(String defaultTranslation, String langCode) {
        EmbeddedFeedbackUtils embeddedFeedbackUtils = INSTANCE;
        Map<String, String> THUMBS_DOWN_LANGUAGES = EmbeddedFeedbackAccessibilityConstants.THUMBS_DOWN_LANGUAGES;
        Intrinsics.checkNotNullExpressionValue(THUMBS_DOWN_LANGUAGES, "THUMBS_DOWN_LANGUAGES");
        return embeddedFeedbackUtils.translateOrDefault(THUMBS_DOWN_LANGUAGES, langCode, defaultTranslation);
    }

    @JvmStatic
    public static final String getCloseTranslation(String defaultTranslation, String langCode) {
        EmbeddedFeedbackUtils embeddedFeedbackUtils = INSTANCE;
        Map<String, String> CLOSE_LANGUAGES = EmbeddedFeedbackAccessibilityConstants.CLOSE_LANGUAGES;
        Intrinsics.checkNotNullExpressionValue(CLOSE_LANGUAGES, "CLOSE_LANGUAGES");
        return embeddedFeedbackUtils.translateOrDefault(CLOSE_LANGUAGES, langCode, defaultTranslation);
    }

    @JvmStatic
    public static final String getFivePointChoiceTranslation(int index, String defaultTranslation, String langCode) {
        if (index == 0) {
            EmbeddedFeedbackUtils embeddedFeedbackUtils = INSTANCE;
            Map<String, String> ExtremelyUnhelpful_LANGUAGES = EmbeddedFeedbackAccessibilityConstants.ExtremelyUnhelpful_LANGUAGES;
            Intrinsics.checkNotNullExpressionValue(ExtremelyUnhelpful_LANGUAGES, "ExtremelyUnhelpful_LANGUAGES");
            return embeddedFeedbackUtils.translateOrDefault(ExtremelyUnhelpful_LANGUAGES, langCode, defaultTranslation);
        }
        if (index == 1) {
            EmbeddedFeedbackUtils embeddedFeedbackUtils2 = INSTANCE;
            Map<String, String> SomewhatUnhelpful_LANGUAGES = EmbeddedFeedbackAccessibilityConstants.SomewhatUnhelpful_LANGUAGES;
            Intrinsics.checkNotNullExpressionValue(SomewhatUnhelpful_LANGUAGES, "SomewhatUnhelpful_LANGUAGES");
            return embeddedFeedbackUtils2.translateOrDefault(SomewhatUnhelpful_LANGUAGES, langCode, defaultTranslation);
        }
        if (index == 2) {
            EmbeddedFeedbackUtils embeddedFeedbackUtils3 = INSTANCE;
            Map<String, String> NeitherHelpfulNorUnhelpful_LANGUAGES = EmbeddedFeedbackAccessibilityConstants.NeitherHelpfulNorUnhelpful_LANGUAGES;
            Intrinsics.checkNotNullExpressionValue(NeitherHelpfulNorUnhelpful_LANGUAGES, "NeitherHelpfulNorUnhelpful_LANGUAGES");
            return embeddedFeedbackUtils3.translateOrDefault(NeitherHelpfulNorUnhelpful_LANGUAGES, langCode, defaultTranslation);
        }
        if (index == 3) {
            EmbeddedFeedbackUtils embeddedFeedbackUtils4 = INSTANCE;
            Map<String, String> SomewhatHelpful_LANGUAGES = EmbeddedFeedbackAccessibilityConstants.SomewhatHelpful_LANGUAGES;
            Intrinsics.checkNotNullExpressionValue(SomewhatHelpful_LANGUAGES, "SomewhatHelpful_LANGUAGES");
            return embeddedFeedbackUtils4.translateOrDefault(SomewhatHelpful_LANGUAGES, langCode, defaultTranslation);
        }
        if (index != 4) {
            return defaultTranslation;
        }
        EmbeddedFeedbackUtils embeddedFeedbackUtils5 = INSTANCE;
        Map<String, String> ExtremelyHelpful_LANGUAGES = EmbeddedFeedbackAccessibilityConstants.ExtremelyHelpful_LANGUAGES;
        Intrinsics.checkNotNullExpressionValue(ExtremelyHelpful_LANGUAGES, "ExtremelyHelpful_LANGUAGES");
        return embeddedFeedbackUtils5.translateOrDefault(ExtremelyHelpful_LANGUAGES, langCode, defaultTranslation);
    }

    private final String translateOrDefault(Map<String, String> map, String originalLangKey, String str) {
        return translationUtils.getTranslationFromMapOrDefault(map, originalLangKey, str);
    }
}
