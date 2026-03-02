package com.microblink.blinkid.secured;

import android.os.Build;
import com.brentvatne.react.ReactVideoView;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class lIlIIlllII {
    private llIllIlIll IlIllIlIIl;
    private lIIIIIllIl IllIIIllII = lIIIIIllIl.llIIlIlIIl;
    private Map<String, String> llIIIlllll = new TreeMap();
    private llIllIlIII llIIlIlIIl;

    lIlIIlllII(llIllIlIII llilliliii, llIllIlIll llillilill) {
        this.llIIlIlIIl = llilliliii;
        this.IlIllIlIIl = llillilill;
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;)Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>; */
    Map llIIlIlIIl(int i) {
        Map<String, String> map = this.llIIIlllll;
        this.llIIlIlIIl.getClass();
        map.put("fileType", "JPEG");
        this.llIIIlllll.put("platform", "ANDROID");
        this.llIIIlllll.put("app", this.llIIlIlIIl.llIIlIlIIl());
        this.llIIIlllll.put("appVersion", this.llIIlIlIIl.IlIllIlIIl());
        this.llIIIlllll.put(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, Build.VERSION.RELEASE);
        this.llIIIlllll.put("device", Build.MANUFACTURER + " - " + Build.MODEL);
        Map<String, String> map2 = this.llIIIlllll;
        JSONObject jSONObjectLlIIIlllll = this.llIIlIlIIl.llIIIlllll();
        if (jSONObjectLlIIIlllll == null) {
            jSONObjectLlIIIlllll = new JSONObject();
        }
        try {
            jSONObjectLlIIIlllll.put("documentSide", lIIIIIllll.llIIlIlIIl(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            llIllIlIll llillilill = this.IlIllIlIIl;
            if (llillilill != null) {
                jSONObjectLlIIIlllll.put("userData", llillilill.llIIlIlIIl());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        map2.put(ReactVideoView.EVENT_PROP_METADATA, !(jSONObjectLlIIIlllll instanceof JSONObject) ? jSONObjectLlIIIlllll.toString() : JSONObjectInstrumentation.toString(jSONObjectLlIIIlllll));
        if (this.llIIlIlIIl.IllIIIIllI() != null && !this.llIIlIlIIl.IllIIIIllI().isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("recognizerResult", this.llIIlIlIIl.IllIIIIllI());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            this.llIIIlllll.put("encMetadata", this.IllIIIllII.llIIlIlIIl(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
        }
        return this.llIIIlllll;
    }

    void llIIlIlIIl(lIIIIIllIl liiiiillil) {
        this.IllIIIllII = liiiiillil;
    }
}
