package com.microblink.blinkid.secured;

import android.content.Context;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.generic.DataMatchDetailedInfo;
import com.microblink.entities.recognizers.blinkid.generic.ProcessingStatus;
import com.microblink.entities.recognizers.blinkid.generic.RecognitionMode;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfo;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.Region;
import com.microblink.recognition.RightsManager;
import com.microblink.settings.NativeLibraryInfo;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class lIIlIIIlII {

    /* JADX INFO: compiled from: line */
    static class llIIlIlIIl {
        private final Recognizer.Result.State IlIllIlIIl;
        private DataMatchDetailedInfo IllIIIIllI = null;
        private final ProcessingStatus IllIIIllII;
        private final RecognitionMode llIIIlllll;
        private final ClassInfo llIIlIlIIl;

        llIIlIlIIl(ClassInfo classInfo, Recognizer.Result.State state, ProcessingStatus processingStatus, RecognitionMode recognitionMode) {
            this.llIIlIlIIl = classInfo;
            this.IlIllIlIIl = state;
            this.IllIIIllII = processingStatus;
            this.llIIIlllll = recognitionMode;
        }

        public void llIIlIlIIl(DataMatchDetailedInfo dataMatchDetailedInfo) {
            this.IllIIIIllI = dataMatchDetailedInfo;
        }
    }

    static JSONObject llIIlIlIIl(Context context, llIIlIlIIl lliililiil) {
        String str;
        JSONObject jSONObject = new JSONObject();
        llIIlIlIIl(jSONObject, "licenseId", RightsManager.llIIlIlIIl());
        llIIlIlIIl(jSONObject, "licensee", RightsManager.IlIllIlIIl());
        llIIlIlIIl(jSONObject, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, context.getPackageName());
        lIllIIIlll lilliiilllIllIIIllII = NativeLibraryInfo.IllIIIllII();
        llIIlIlIIl(jSONObject, "product", IIIIIIIlII.llIIlIlIIl(lilliiilllIllIIIllII.llIIlIlIIl()));
        llIIlIlIIl(jSONObject, "productVersion", lilliiilllIllIIIllII.IlIllIlIIl());
        ClassInfo classInfo = lliililiil.llIIlIlIIl;
        if (classInfo.getIsoAlpha2CountryCode().isEmpty()) {
            str = "unknown";
        } else {
            String isoAlpha2CountryCode = classInfo.getIsoAlpha2CountryCode();
            Locale locale = Locale.ROOT;
            String lowerCase = isoAlpha2CountryCode.toLowerCase(locale);
            String lowerCase2 = classInfo.getRegion().toString().toLowerCase(locale);
            String lowerCase3 = classInfo.getType().toString().toLowerCase(locale);
            str = (lowerCase2.isEmpty() || classInfo.getRegion() == Region.NONE) ? lowerCase + "-" + lowerCase3 : lowerCase + "-" + lowerCase2 + "-" + lowerCase3;
        }
        llIIlIlIIl(jSONObject, BlinkIdCombinedRecognizer.VerificationConstants.ClassInfo, str);
        llIIlIlIIl(jSONObject, "resultState", lliililiil.IlIllIlIIl.toString());
        llIIlIlIIl(jSONObject, "type", lliililiil.llIIlIlIIl.getType().toString());
        llIIlIlIIl(jSONObject, "country", lliililiil.llIIlIlIIl.getIsoAlpha2CountryCode());
        llIIlIlIIl(jSONObject, BlinkIdCombinedRecognizer.VerificationConstants.ProcessingStatus, lliililiil.IllIIIllII.toString());
        llIIlIlIIl(jSONObject, BlinkIdCombinedRecognizer.VerificationConstants.RecognitionMode, lliililiil.llIIIlllll.toString());
        if (lliililiil.IllIIIIllI != null) {
            try {
                jSONObject.put(BlinkIdCombinedRecognizer.VerificationConstants.DataMatchDetailedInfo, llIIlIlIIl(lliililiil.IllIIIIllI));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    static void llIIlIlIIl(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject llIIlIlIIl(DataMatchDetailedInfo dataMatchDetailedInfo) {
        JSONObject jSONObject = new JSONObject();
        llIIlIlIIl(jSONObject, "dataMatchResult", dataMatchDetailedInfo.getDataMatchResult().toString());
        llIIlIlIIl(jSONObject, "documentNumber", dataMatchDetailedInfo.getDocumentNumber().toString());
        llIIlIlIIl(jSONObject, "dateOfExpiry", dataMatchDetailedInfo.getDateOfExpiry().toString());
        llIIlIlIIl(jSONObject, "dateOfBirth", dataMatchDetailedInfo.getDateOfBirth().toString());
        return jSONObject;
    }
}
