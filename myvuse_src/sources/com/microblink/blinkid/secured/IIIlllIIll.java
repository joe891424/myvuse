package com.microblink.blinkid.secured;

import android.content.Context;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.util.Log;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IIIlllIIll extends lIlIIlIlll {
    IIIlllIIll(Context context) {
        super(context, "com.microblink.ping.preferences");
    }

    lIIllllIIl IlIllIlIIl() {
        String strIllIIIllII = IllIIIllII("com.microblink.ping.preferences.scansCount.V2");
        if (strIllIIIllII == null) {
            return new lIIllllIIl(0L, 0L, 0L, new llllllllIl(Collections.emptyList()));
        }
        try {
            JSONObject jSONObject = new JSONObject(strIllIIIllII);
            return new lIIllllIIl(jSONObject.getLong("totalScans"), jSONObject.getLong("totalSuccessfulScans"), jSONObject.getLong("totalUncertainScans"), new llllllllIl(llIIlIlIIl(jSONObject.getJSONArray("recognizerScans"))));
        } catch (Exception unused) {
            return new lIIllllIIl(0L, 0L, 0L, new llllllllIl(Collections.emptyList()));
        }
    }

    void IllIIIllII() {
        llIIIlllll("com.microblink.ping.preferences.scansCount.V2");
    }

    void llIIlIlIIl(lIIllllIIl liilllliil) {
        String string;
        if (liilllliil.IllIIIIllI()) {
            return;
        }
        lIIllllIIl liilllliilLlIIlIlIIl = lIIllllIIl.llIIlIlIIl(IlIllIlIIl(), liilllliil);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("totalScans", liilllliilLlIIlIlIIl.IlIllIlIIl());
            jSONObject.put("totalSuccessfulScans", liilllliilLlIIlIlIIl.IllIIIllII());
            jSONObject.put("totalUncertainScans", liilllliilLlIIlIlIIl.llIIIlllll());
            jSONObject.put("recognizerScans", llIIlIlIIl(liilllliilLlIIlIlIIl.llIIlIlIIl()));
            if (jSONObject instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject);
            } else {
                string = jSONObject.toString();
            }
            llIIlIlIIl("com.microblink.ping.preferences.scansCount.V2", string);
        } catch (JSONException e) {
            Log.m2710e(this, e, "PingStorage.setScanCount failed.", new Object[0]);
        }
    }

    public void llIIlIlIIl(long j) {
        llIIlIlIIl("com.microblink.ping.preferences.lastPing", j);
    }

    long llIIlIlIIl() {
        return IlIllIlIIl("com.microblink.ping.preferences.lastPing");
    }

    private static List<llIlIlIlII> llIIlIlIIl(JSONArray jSONArray) throws JSONException {
        HashMap map;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.has(BlinkIdCombinedRecognizer.VerificationConstants.ClassInfo)) {
                map = new HashMap();
                JSONObject jSONObject2 = jSONObject.getJSONObject(BlinkIdCombinedRecognizer.VerificationConstants.ClassInfo);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        map.put(next, (String) obj);
                    } else {
                        Log.m2709e(IIIlllIIll.class, "PingStorage: String value is expected for key {}", next);
                    }
                }
            } else {
                map = null;
            }
            arrayList.add(new llIlIlIlII(new IlIIlIIIll(jSONObject.getString("recognizerId"), map), new lIlIIIIIll(jSONObject.getLong("successfulScans"), jSONObject.getLong("unsuccessfulScans"), jSONObject.getLong("uncertainScans"))));
        }
        return arrayList;
    }

    private static JSONArray llIIlIlIIl(llllllllIl llllllllil) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<IlIIlIIIll, lIlIIIIIll> entry : llllllllil.llIIlIlIIl().entrySet()) {
            IlIIlIIIll key = entry.getKey();
            lIlIIIIIll value = entry.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("recognizerId", key.IlIllIlIIl());
            Map<String, String> mapLlIIlIlIIl = key.llIIlIlIIl();
            if (mapLlIIlIlIIl != null) {
                jSONObject.put(BlinkIdCombinedRecognizer.VerificationConstants.ClassInfo, new JSONObject(mapLlIIlIlIIl));
            }
            jSONObject.put("successfulScans", value.llIIlIlIIl());
            jSONObject.put("unsuccessfulScans", value.IllIIIllII());
            jSONObject.put("uncertainScans", value.IlIllIlIIl());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
