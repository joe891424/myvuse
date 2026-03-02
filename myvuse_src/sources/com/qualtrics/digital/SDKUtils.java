package com.qualtrics.digital;

import android.content.Context;
import com.google.gson.JsonObject;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes6.dex */
public class SDKUtils {
    static String deactivatedProjectResponseKey = "This zone has been deactivated";
    private static SDKUtils mInstance;
    String mAppName;
    private String mBrandId;
    private String mZoneId;
    private boolean useHeadlessApis = false;
    SiteInterceptService mSiteInterceptService = SiteInterceptService.instance();
    LatencyReportingService mLatencyReportingService = LatencyReportingService.instance();

    SDKUtils() {
    }

    SDKUtils(SiteInterceptService siteInterceptService, LatencyReportingService latencyReportingService) {
    }

    void initialize(String str, String str2, String str3, String str4) {
        this.mBrandId = str;
        this.mZoneId = str2;
        this.mAppName = str4;
        this.mSiteInterceptService.initialize(str, str2, str4);
        this.mLatencyReportingService.initialize(this.mAppName, str, str2, str3);
    }

    static SDKUtils instance() {
        if (mInstance == null) {
            mInstance = new SDKUtils();
        }
        return mInstance;
    }

    void setErrorLogSampling(Double d) {
        this.mSiteInterceptService.setErrorLogSampling(d);
    }

    void setUseHeadlessApis(boolean z) {
        this.useHeadlessApis = z;
    }

    void postErrorLog(Throwable th) {
        this.mSiteInterceptService.postErrorLog(th);
    }

    void postErrorLog(String str, Throwable th) {
        this.mSiteInterceptService.postErrorLog(str, false, th);
    }

    void postErrorLog(String str, Throwable th, boolean z) {
        this.mSiteInterceptService.postErrorLog(str, z, th);
    }

    void recordPageView(String str, String str2, String str3) {
        this.mSiteInterceptService.recordPageView(str, str2, str3);
    }

    void setBenchmarkSampleRate(Double d) {
        this.mLatencyReportingService.setBenchmarkSampleRate(d.doubleValue());
    }

    void getInterceptDefinition(String str, int i, Callback<Intercept> callback) {
        this.mSiteInterceptService.getInterceptDefinition(str, i, callback);
    }

    void getCreativeDefinition(String str, int i, String str2, Callback<JsonObject> callback) {
        this.mSiteInterceptService.getCreativeDefinition(str, i, str2, callback);
    }

    String getBrandId() {
        return this.mBrandId;
    }

    boolean getUseHeadlessApis() {
        return this.useHeadlessApis;
    }

    private String getApplicationName(Context context) {
        return context.getPackageName();
    }
}
