package com.microblink.blinkid.secured;

import com.microblink.blinkid.secured.IlIIIlIIIl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlllllIIIl {
    private lIlIlIIIII IIlIIIllIl;
    private String IlIllIlIIl;
    private lIlIlIIIII IlIllIlllI;
    private int IllIIIIllI;
    private IlIIIlIIIl.llIIlIlIIl IllIIIllII;
    private lIlIlIIIII IllIIlIIII;
    private lIlIlIIIII lIIIIIlIlI;
    private lIlIlIIIII lIIIIIllll;
    private double lIlIIIIlIl;
    private IlIIIlIIIl.llIIlIlIIl llIIIlllll;
    private double llIIlIIlll;
    private String llIIlIlIIl;
    private lIlIlIIIII lllIIIlIlI;
    private lIlIlIIIII lllIlIlIIl;

    public IlllllIIIl(String str, String str2) {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = 0.0d;
        this.llIIlIIlll = 1.0d;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Device and Model cannot be null");
        }
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
    }

    lIlIlIIIII IIlIIIllIl() {
        return this.lIIIIIllll;
    }

    lIlIlIIIII IlIllIlIIl() {
        return this.IIlIIIllIl;
    }

    lIlIlIIIII IlIllIlllI() {
        return this.lllIlIlIIl;
    }

    public double IllIIIIllI() {
        return this.llIIlIIlll;
    }

    lIlIlIIIII IllIIIllII() {
        return this.lllIIIlIlI;
    }

    public String IllIIlIIII() {
        return this.llIIlIlIIl + "::" + this.IlIllIlIIl;
    }

    public IlIIIlIIIl.llIIlIlIIl lIIIIIllll() {
        return this.IllIIIllII;
    }

    lIlIlIIIII lIlIIIIlIl() {
        return this.IlIllIlllI;
    }

    lIlIlIIIII llIIIlllll() {
        return this.IllIIlIIII;
    }

    public double llIIlIIlll() {
        return this.lIlIIIIlIl;
    }

    public int llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    public IlIIIlIIIl.llIIlIlIIl lllIIIlIlI() {
        return this.llIIIlllll;
    }

    lIlIlIIIII lllIlIlIIl() {
        return this.lIIIIIlIlI;
    }

    public String toString() {
        return IIllIllIIl.llIIlIlIIl("DeviceInfo{mDevice='").append(this.llIIlIlIIl).append('\'').append(", mModel='").append(this.IlIllIlIIl).append('\'').append('}').toString();
    }

    public IlllllIIIl(JSONObject jSONObject, String str) throws JSONException {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = 0.0d;
        this.llIIlIIlll = 1.0d;
        String[] strArrSplit = str.split("::");
        this.IlIllIlIIl = strArrSplit[1];
        this.llIIlIlIIl = strArrSplit[0];
        if (jSONObject.has("backFacingPreviewSize")) {
            JSONArray jSONArray = jSONObject.getJSONArray("backFacingPreviewSize");
            this.IllIIIllII = new IlIIIlIIIl.llIIlIlIIl(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("frontFacingPreviewSize")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("frontFacingPreviewSize");
            this.llIIIlllll = new IlIIIlIIIl.llIIlIlIIl(jSONArray2.getInt(0), jSONArray2.getInt(1));
        }
        if (jSONObject.has("cameraInitDelayMs")) {
            this.IllIIIIllI = jSONObject.getInt("cameraInitDelayMs");
        }
        if (jSONObject.has("minZoomLevel")) {
            this.lIlIIIIlIl = jSONObject.getDouble("minZoomLevel");
        }
        if (jSONObject.has("maxZoomLevel")) {
            this.llIIlIIlll = jSONObject.getDouble("maxZoomLevel");
        }
        if (jSONObject.has("displayOrientationNotWorking")) {
            this.IIlIIIllIl = new lIlIlIIIII(jSONObject.getString("displayOrientationNotWorking"));
        }
        if (jSONObject.has("naturalOrientationIsLandscapeLeft")) {
            this.lIIIIIllll = new lIlIlIIIII(jSONObject.getString("naturalOrientationIsLandscapeLeft"));
        }
        if (jSONObject.has("focusUntrusty")) {
            this.lllIIIlIlI = new lIlIlIIIII(jSONObject.getString("focusUntrusty"));
        }
        if (jSONObject.has("meteringNotWorking")) {
            this.IlIllIlllI = new lIlIlIIIII(jSONObject.getString("meteringNotWorking"));
        }
        if (jSONObject.has("phaseAutoFocusSupported")) {
            this.lllIlIlIIl = new lIlIlIIIII(jSONObject.getString("phaseAutoFocusSupported"));
        }
        if (jSONObject.has("forceUseLegacyCamera")) {
            this.IllIIlIIII = new lIlIlIIIII(jSONObject.getString("forceUseLegacyCamera"));
        }
        if (jSONObject.has("preferTextureView")) {
            this.lIIIIIlIlI = new lIlIlIIIII(jSONObject.getString("preferTextureView"));
        }
    }
}
