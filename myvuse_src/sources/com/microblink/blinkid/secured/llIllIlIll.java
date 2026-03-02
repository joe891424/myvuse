package com.microblink.blinkid.secured;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIllIlIll {
    private final String llIIlIlIIl;

    public llIllIlIll(String str) {
        this.llIIlIlIIl = str;
    }

    public JSONObject llIIlIlIIl() {
        if (this.llIIlIlIIl != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userID", this.llIIlIlIIl);
                return jSONObject;
            } catch (JSONException unused) {
            }
        }
        return null;
    }
}
