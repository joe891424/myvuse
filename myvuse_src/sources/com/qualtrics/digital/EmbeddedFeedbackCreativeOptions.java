package com.qualtrics.digital;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class EmbeddedFeedbackCreativeOptions implements Cloneable {
    List<EmbeddedFeedbackCreativeQuestion> Questions;
    EmbeddedFeedbackSubmitButtonAppearance SubmitButtonAppearance;
    String SurveyVersionId;
    Map<String, Map<String, String>> Translations;

    @SerializedName("ThemeOverriddenThroughSdk")
    Boolean themeOverriddenThroughSdk = false;

    EmbeddedFeedbackCreativeOptions() {
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public EmbeddedFeedbackCreativeOptions m6383clone() {
        try {
            EmbeddedFeedbackCreativeOptions embeddedFeedbackCreativeOptions = (EmbeddedFeedbackCreativeOptions) super.clone();
            embeddedFeedbackCreativeOptions.Questions = new ArrayList();
            Iterator<EmbeddedFeedbackCreativeQuestion> it2 = this.Questions.iterator();
            while (it2.hasNext()) {
                embeddedFeedbackCreativeOptions.Questions.add(it2.next().m6384clone());
            }
            embeddedFeedbackCreativeOptions.SubmitButtonAppearance = this.SubmitButtonAppearance.m6386clone();
            return embeddedFeedbackCreativeOptions;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
