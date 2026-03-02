package com.qualtrics.digital;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: compiled from: QualtricsSurveyFragment.java */
/* JADX INFO: loaded from: classes6.dex */
class WebViewInterface {
    boolean autoCloseAtEndOfSurvey;
    QualtricsSurveyFragment instanceContext;
    Context mContext;

    WebViewInterface(Context context, QualtricsSurveyFragment qualtricsSurveyFragment, boolean z) {
        this.mContext = context;
        this.instanceContext = qualtricsSurveyFragment;
        this.autoCloseAtEndOfSurvey = z;
    }

    @JavascriptInterface
    public void postMessage(String str) {
        if (str != null && str.startsWith("SV_")) {
            Qualtrics.instance().properties.setSurveyHasBeenTaken(str);
            if (this.autoCloseAtEndOfSurvey) {
                this.instanceContext.getActivity().finish();
                return;
            }
            return;
        }
        LogInstrumentation.m2730i("Qualtrics", "Unable to set SurveyHasBeenTaken property with invalid SurveyID");
    }

    @JavascriptInterface
    public void recordPayload(String str, String str2, String str3) {
        this.instanceContext.webRequestBody = str3;
    }
}
