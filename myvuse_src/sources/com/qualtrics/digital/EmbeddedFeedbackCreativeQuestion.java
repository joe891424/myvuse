package com.qualtrics.digital;

import java.util.List;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class EmbeddedFeedbackCreativeQuestion implements Cloneable {
    EmbeddedFeedbackQuestionAppearance Appearance;
    List<EmbeddedFeedbackChoice> Choices;
    String Format;
    String QID;
    String QuestionText;
    String Style;
    String SurveyQuestionId;

    EmbeddedFeedbackCreativeQuestion() {
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public EmbeddedFeedbackCreativeQuestion m6384clone() {
        try {
            EmbeddedFeedbackCreativeQuestion embeddedFeedbackCreativeQuestion = (EmbeddedFeedbackCreativeQuestion) super.clone();
            embeddedFeedbackCreativeQuestion.Appearance = this.Appearance.m6385clone();
            return embeddedFeedbackCreativeQuestion;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
