package com.qualtrics.digital;

import android.R;
import android.content.res.ColorStateList;
import androidx.exifinterface.media.ExifInterface;
import com.bat.sdk.domain.device.FirmwareInstallationState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class EmbeddedFeedbackUtilsJava {
    static final String MULTIPLE_CHOICE_KEY_PREFIX = "MultipleChoiceChoicesText_";
    static final String MULTIPLE_CHOICE_OTHER_TEXT_KEY = "MultipleChoiceOtherText";
    private static final String QUESTION_FORMAT_DISPLAY_TEXT = "embedded-feedback-question-format-display-text";
    private static final String QUESTION_FORMAT_MULTIPLE_CHOICE = "embedded-feedback-question-format-multiple-choice";
    private static final String QUESTION_FORMAT_OPEN_TEXT = "embedded-feedback-question-format-open-text";

    EmbeddedFeedbackUtilsJava() {
    }

    static String getTranslation(String str, Map<String, Map<String, String>> map, String str2, String str3) {
        try {
            Map<String, String> map2 = map.get(str2);
            return (map2 == null || map2.get(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) == null || !Boolean.parseBoolean(map2.get(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) || map2.get(str3) == null) ? str : map2.get(str3);
        } catch (Exception unused) {
            return str;
        }
    }

    static EmbeddedFeedbackCreativeQuestion getFollowupQuestion(List<EmbeddedFeedbackCreativeQuestion> list) {
        for (EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion : list) {
            if (embeddedFeedbackCreativeQuestion.Format.equals(QUESTION_FORMAT_OPEN_TEXT)) {
                return embeddedFeedbackCreativeQuestion;
            }
        }
        return null;
    }

    static EmbeddedFeedbackCreativeQuestion getMultipleChoiceQuestion(List<EmbeddedFeedbackCreativeQuestion> list) {
        for (EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion : list) {
            if (embeddedFeedbackCreativeQuestion.Format.equals(QUESTION_FORMAT_MULTIPLE_CHOICE)) {
                return embeddedFeedbackCreativeQuestion;
            }
        }
        return null;
    }

    static EmbeddedFeedbackCreativeQuestion getThankYouMessage(List<EmbeddedFeedbackCreativeQuestion> list) {
        for (EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion : list) {
            if (embeddedFeedbackCreativeQuestion.Format.equals(QUESTION_FORMAT_DISPLAY_TEXT)) {
                return embeddedFeedbackCreativeQuestion;
            }
        }
        return null;
    }

    static List<String> getActiveLocalizedMultipleChoices(EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion, Map<String, Map<String, String>> map, String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < embeddedFeedbackCreativeQuestion.Choices.size()) {
            EmbeddedFeedbackChoice embeddedFeedbackChoice = embeddedFeedbackCreativeQuestion.Choices.get(i);
            i++;
            String str2 = String.format("%s%s", MULTIPLE_CHOICE_KEY_PREFIX, Integer.valueOf(i));
            if (embeddedFeedbackChoice.Active && !embeddedFeedbackChoice.CId.equals(FirmwareInstallationState.Error.ERROR_OTHER_DESC)) {
                arrayList.add(getTranslation(embeddedFeedbackChoice.Display, map, str, str2));
            }
        }
        return arrayList;
    }

    static String getTranslatedMultipleChoiceOtherOption(EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion, Map<String, Map<String, String>> map, String str) {
        if (embeddedFeedbackCreativeQuestion.Choices.get(embeddedFeedbackCreativeQuestion.Choices.size() - 1).CId.equals(FirmwareInstallationState.Error.ERROR_OTHER_DESC) && embeddedFeedbackCreativeQuestion.Choices.get(embeddedFeedbackCreativeQuestion.Choices.size() - 1).Active) {
            return getTranslation(embeddedFeedbackCreativeQuestion.Choices.get(embeddedFeedbackCreativeQuestion.Choices.size() - 1).Display, map, str, MULTIPLE_CHOICE_OTHER_TEXT_KEY);
        }
        return null;
    }

    static ColorStateList getRadioButtonColorList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{R.attr.state_checked}}, new int[]{i2, i});
    }

    static int getRadioGroupBottomPadding(List<EmbeddedFeedbackCreativeQuestion> list) {
        return getFollowupQuestion(list) == null ? 20 : 40;
    }
}
