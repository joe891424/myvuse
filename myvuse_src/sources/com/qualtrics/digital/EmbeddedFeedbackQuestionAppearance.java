package com.qualtrics.digital;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class EmbeddedFeedbackQuestionAppearance implements Cloneable {
    String BorderColor;
    String ButtonBorderColor;
    String ButtonFillColor;
    String ButtonTextColor;
    String EmojiBorderColor;
    String EmojiFillColor;
    String EmojiTintColor;
    String FillColor;
    String NoButtonBorderColor;
    String NoButtonFillColor;
    String NoButtonTextColor;
    String QuestionTextColor;
    String RadioButtonFillColor;
    String RadioButtonUnselectedCircleColor;
    String StarsColor;
    String Style;
    String TextFieldColumns;
    String TextFieldRows;
    String ThumbDownBorderColor;
    String ThumbDownFillColor;
    String ThumbUpBorderColor;
    String ThumbUpFillColor;

    EmbeddedFeedbackQuestionAppearance() {
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public EmbeddedFeedbackQuestionAppearance m6385clone() {
        try {
            return (EmbeddedFeedbackQuestionAppearance) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
