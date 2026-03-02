package com.qualtrics.digital;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: CreativeJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class EmbeddedFeedbackCreative extends Creative {
    EmbeddedFeedbackCreativeDefinition CreativeDefinition;

    EmbeddedFeedbackCreative() {
    }

    @Override // com.qualtrics.digital.Creative
    boolean display(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6, Map<String, String> map, boolean z) {
        Intent intent = new Intent(context, (Class<?>) QualtricsEmbeddedFeedbackActivity.class);
        Gson gson = new Gson();
        intent.putExtra("CREATIVE", !(gson instanceof Gson) ? gson.toJson(this) : GsonInstrumentation.toJson(gson, this));
        intent.putExtra("SURVEY_ID", str5);
        intent.putExtra("INTERCEPT_ID", str2);
        intent.putExtra("ACTION_SET_ID", str4);
        intent.putExtra("CREATIVE_ID", str3);
        intent.putExtra("BASE_URL", str6);
        intent.putExtra("EMBEDDED_DATA", (Serializable) map);
        context.startActivity(intent);
        return true;
    }

    @Override // com.qualtrics.digital.Creative
    CreativeType getCreativeType() {
        return CreativeType.MobileEmbeddedFeedback;
    }
}
