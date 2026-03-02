package com.onetrust.otpublishers.headless.Public.Response;

/* JADX INFO: loaded from: classes6.dex */
public class OTResponse {

    /* JADX INFO: renamed from: a */
    public final String f4117a;

    /* JADX INFO: renamed from: b */
    public final int f4118b;

    /* JADX INFO: renamed from: c */
    public final String f4119c;

    /* JADX INFO: renamed from: d */
    public final String f4120d;

    public OTResponse(String str, int i, String str2, String str3) {
        this.f4117a = str;
        this.f4118b = i;
        this.f4119c = str2;
        this.f4120d = str3;
    }

    public int getResponseCode() {
        return this.f4118b;
    }

    public String getResponseData() {
        return this.f4120d;
    }

    public String getResponseMessage() {
        return this.f4119c;
    }

    public String getResponseType() {
        return this.f4117a;
    }

    public String toString() {
        return "OTResponse{responseType='" + this.f4117a + "', responseCode=" + this.f4118b + ", responseMessage='" + this.f4119c + "', responseData='" + this.f4120d + "'}";
    }
}
