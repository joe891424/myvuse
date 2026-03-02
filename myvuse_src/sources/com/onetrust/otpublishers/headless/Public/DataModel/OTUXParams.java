package com.onetrust.otpublishers.headless.Public.DataModel;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class OTUXParams {

    /* JADX INFO: renamed from: a */
    public final JSONObject f4101a;

    /* JADX INFO: renamed from: b */
    public final String f4102b;

    public static class OTUXParamsBuilder {

        /* JADX INFO: renamed from: a */
        public String f4103a;

        /* JADX INFO: renamed from: b */
        public JSONObject f4104b;

        public static OTUXParamsBuilder newInstance() {
            return new OTUXParamsBuilder();
        }

        public OTUXParams build() {
            return new OTUXParams(this);
        }

        public OTUXParamsBuilder setOTSDKTheme(String str) {
            this.f4103a = str;
            return this;
        }

        public OTUXParamsBuilder setUXParams(JSONObject jSONObject) {
            this.f4104b = jSONObject;
            return this;
        }
    }

    public OTUXParams(OTUXParamsBuilder oTUXParamsBuilder) {
        this.f4101a = oTUXParamsBuilder.f4104b;
        this.f4102b = oTUXParamsBuilder.f4103a;
    }

    public String getOTSDKTheme() {
        return this.f4102b;
    }

    public JSONObject getUxParam() {
        return this.f4101a;
    }

    public String toString() {
        return "OTUXParams{uxParam=" + this.f4101a + ", otSDKTheme='" + this.f4102b + "'}";
    }
}
