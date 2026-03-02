package com.microblink.blinkid.secured;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IllllIlIIl {

    /* JADX INFO: compiled from: line */
    static class IlIllIlIIl {
        private final int llIIlIlIIl;

        IlIllIlIIl(int i) {
            this.llIIlIlIIl = i;
        }

        boolean llIIlIlIIl() {
            return this.llIIlIlIIl == 201;
        }
    }

    /* JADX INFO: compiled from: line */
    static class llIIlIlIIl {
        final String IIlIIIllIl;
        final String IlIllIlIIl;
        final String IllIIIIllI;
        final String IllIIIllII;
        final String lIIIIIllll;
        final String lIlIIIIlIl;
        final String llIIIlllll;
        final lIIllllIIl llIIlIIlll;
        final String llIIlIlIIl;
        final String lllIIIlIlI;

        llIIlIlIIl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, lIIllllIIl liilllliil) {
            this.llIIlIlIIl = str;
            this.IlIllIlIIl = str2;
            this.lIlIIIIlIl = str3;
            this.IllIIIllII = str4;
            this.llIIIlllll = str5;
            this.IIlIIIllIl = str6;
            this.lIIIIIllll = str7;
            this.lllIIIlIlI = str8;
            this.IllIIIIllI = str9;
            this.llIIlIIlll = liilllliil;
        }
    }

    IllllIlIIl() {
    }

    IlIllIlIIl llIIlIlIIl(llIIlIlIIl lliililiil) throws Exception {
        IIIlIIlIll iIIlIIlIllLlIIlIlIIl = IIIlIIlIll.llIIlIlIIl("https://ping.microblink.com/api/v1/ping");
        iIIlIIlIllLlIIlIlIIl.llIIlIlIIl(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("product", lliililiil.llIIlIlIIl);
        jSONObject.put("productVersion", lliililiil.IlIllIlIIl);
        jSONObject.put("licensee", lliililiil.IllIIIllII);
        jSONObject.put("licenseId", lliililiil.llIIIlllll);
        jSONObject.put(AnalyticsAttribute.USER_ID_ATTRIBUTE, lliililiil.lIlIIIIlIl);
        jSONObject.put("scans", lliililiil.llIIlIIlll.IlIllIlIIl());
        jSONObject.put("successfulScans", lliililiil.llIIlIIlll.IllIIIllII());
        jSONObject.put("uncertainScans", lliililiil.llIIlIIlll.llIIIlllll());
        llllllllIl llllllllilLlIIlIlIIl = lliililiil.llIIlIIlll.llIIlIlIIl();
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<IlIIlIIIll, lIlIIIIIll> entry : llllllllilLlIIlIlIIl.llIIlIlIIl().entrySet()) {
            IlIIlIIIll key = entry.getKey();
            lIlIIIIIll value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("recognizer", key.IlIllIlIIl());
            Map<String, String> mapLlIIlIlIIl = key.llIIlIlIIl();
            if (mapLlIIlIlIIl != null) {
                jSONObject2.put(BlinkIdCombinedRecognizer.VerificationConstants.ClassInfo, new JSONObject(mapLlIIlIlIIl));
            }
            jSONObject2.put("successfulScans", value.llIIlIlIIl());
            jSONObject2.put("unsuccessfulScans", value.IllIIIllII());
            jSONObject2.put("uncertainScans", value.IlIllIlIIl());
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("recognizerScans", jSONArray);
        jSONObject.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, lliililiil.IIlIIIllIl);
        jSONObject.put("device", lliililiil.IllIIIIllI);
        jSONObject.put(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, lliililiil.lllIIIlIlI);
        jSONObject.put("platform", lliililiil.lIIIIIllll);
        iIIlIIlIllLlIIlIlIIl.llIIlIlIIl(jSONObject);
        return new IlIllIlIIl(iIIlIIlIllLlIIlIlIIl.IlIllIlIIl());
    }
}
