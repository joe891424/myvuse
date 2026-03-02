package com.qualtrics.digital;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class Creative {
    String surveyUrl;

    abstract boolean display(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6, Map<String, String> map, boolean z);

    abstract CreativeType getCreativeType();

    String getSurveyUrl() {
        return this.surveyUrl;
    }

    void setSurveyUrl(String str) {
        this.surveyUrl = str;
    }

    Creative() {
    }
}
