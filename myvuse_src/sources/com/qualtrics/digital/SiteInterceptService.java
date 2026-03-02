package com.qualtrics.digital;

import android.os.Build;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.qualtrics.BuildConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: classes6.dex */
class SiteInterceptService {
    private static final String CANNOT_BE_PERFORMED = " cannot be performed";
    private static final String FLUTTER_PROPERTY = "Qualtrics_IS_FLUTTER";
    private static String INTERCEPT_TYPE = "intercept";
    private static final String LOG_TAG = "Qualtrics";
    private static final String REACT_NATIVE_PROPERTY = "Qualtrics_IS_REACT_NATIVE";
    private static final String SERVICE_NOT_INITIALIZED = "Service not initialized, ";
    private static String ZONE_TYPE = "zone";
    private static String ZONE_TYPE_REGEX = "Q_ZN(.*)";
    private static String clientType = "MobileAndroid";
    private static SiteInterceptService mInstance;
    private String mAppName;
    private String mBrandId;
    private Double mErrorLogSampling = Double.valueOf(0.0d);
    private ISiteInterceptService mService;
    protected String mZoneID;

    SiteInterceptService() {
    }

    void initialize(String str, String str2, String str3) {
        this.mAppName = str3;
        this.mBrandId = str;
        this.mZoneID = str2;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (QualtricsLog.mLogLevel == QualtricsLogLevel.INFO) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Logic.class, new LogicDeserializer());
        Gson gsonCreate = gsonBuilder.create();
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(String.format(Locale.US, "https://%s-%s.%s", makeURLFriendlyZoneId(str2), str, BuildConfig.SI_ENDPOINT_URL)).client(new OkHttpClient.Builder().addInterceptor(new ServiceInterceptor(this.mAppName)).addInterceptor(httpLoggingInterceptor).addInterceptor(new RequestInterceptor()).build()).addConverterFactory(GsonConverterFactory.create(gsonCreate)).addConverterFactory(ScalarsConverterFactory.create()).build();
        String string = Qualtrics.instance().properties.getString(REACT_NATIVE_PROPERTY);
        String string2 = Qualtrics.instance().properties.getString(FLUTTER_PROPERTY);
        if (string != null && string.equals("true")) {
            clientType = "MobileAndroidReactNative";
        } else if (string2 != null && string2.equals("true")) {
            clientType = "MobileAndroidFlutter";
        }
        this.mService = (ISiteInterceptService) retrofitBuild.create(ISiteInterceptService.class);
    }

    static SiteInterceptService instance() {
        if (mInstance == null) {
            mInstance = new SiteInterceptService();
        }
        return mInstance;
    }

    private String stacktraceToString(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    void setErrorLogSampling(Double d) {
        this.mErrorLogSampling = d;
    }

    private void logUninitializedError(String str) {
        QualtricsLog.logError(String.format(Locale.US, "%s %s %s", SERVICE_NOT_INITIALIZED, str, CANNOT_BE_PERFORMED));
    }

    void postErrorLog(Throwable th) {
        postErrorLog(null, false, th);
    }

    void postErrorLog(String str, boolean z, Throwable th) {
        StringBuilder sb = new StringBuilder("QualtricsAndroidSDKError\\n");
        if (str != null) {
            sb.append(str);
            sb.append("\\n");
        }
        if (th != null) {
            sb.append(th.getMessage() != null ? th.getMessage() : "");
            sb.append("\\n");
            sb.append(stacktraceToString(th));
        }
        QualtricsLog.logError(sb.toString());
        if (this.mService == null) {
            logUninitializedError("post error");
        } else if (z || SamplingUtil.checkSampling(this.mErrorLogSampling)) {
            this.mService.postErrorLog("error", sb.toString(), "ClientLog", clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL).enqueue(new Callback<Void>() { // from class: com.qualtrics.digital.SiteInterceptService.1
                @Override // retrofit2.Callback
                public void onResponse(Call<Void> call, Response<Void> response) {
                    QualtricsLog.logInfo("Post error log onResponse: " + response.code());
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<Void> call, Throwable th2) {
                    QualtricsLog.logError("Post error log onFailure: " + th2.getMessage(), th2);
                }
            });
        }
    }

    void getMobileTargeting(String str, String str2, Callback<TargetingResponse> callback) throws NoSuchAlgorithmException {
        String strHashSHA256;
        if (this.mService == null) {
            logUninitializedError("get mobile targeting");
            return;
        }
        String strEncode = "";
        if (str2 == null) {
            str2 = "";
        }
        try {
            strHashSHA256 = HashingUtils.hashSHA256(str2);
        } catch (NoSuchAlgorithmException e) {
            QualtricsLog.logError("Error hashing extRefId for mobile targeting request: " + e.getMessage());
            strHashSHA256 = "";
        }
        try {
            strEncode = URLEncoder.encode(str2, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e2) {
            QualtricsLog.logError("Error encoding extRefId for mobile targeting request: " + e2.getMessage());
        }
        this.mService.getMobileTargeting(str, strEncode, strHashSHA256, clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL).enqueue(callback);
    }

    void getAssetVersions(String str, Callback<ProjectAssetVersions> callback) {
        ISiteInterceptService iSiteInterceptService = this.mService;
        if (iSiteInterceptService == null) {
            logUninitializedError("get asset versions");
        } else {
            iSiteInterceptService.getAssetVersions(str, clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL).enqueue(callback);
        }
    }

    void requestXMDContactFrequency(String str, String str2, Map<String, String> map, Callback<ContactFrequencyResponse> callback) {
        if (this.mService == null) {
            logUninitializedError("get XMD contact frequency results");
            return;
        }
        StringBuilder sb = new StringBuilder("{");
        Iterator<String> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            sb.append("\"" + next + "\":\"" + map.get(next) + "\"");
            if (it2.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("}");
        this.mService.requestXMDContactFrequency(str, str2, sb.toString(), clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL).enqueue(callback);
    }

    void getInterceptDefinition(String str, int i, Callback<Intercept> callback) {
        ISiteInterceptService iSiteInterceptService = this.mService;
        if (iSiteInterceptService == null) {
            logUninitializedError("get intercept definition");
        } else {
            iSiteInterceptService.getInterceptDefinition(str, i, true, clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL).enqueue(callback);
        }
    }

    void getCreativeDefinition(String str, int i, String str2, Callback<JsonObject> callback) {
        ISiteInterceptService iSiteInterceptService = this.mService;
        if (iSiteInterceptService == null) {
            logUninitializedError("get creative definition");
        } else {
            iSiteInterceptService.getCreativeDefinition(str, i, str2, clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL).enqueue(callback);
        }
    }

    void recordPageView(String str, String str2, String str3) {
        String str4;
        if (this.mService == null) {
            logUninitializedError("record page view");
            return;
        }
        if (str.matches(ZONE_TYPE_REGEX)) {
            str4 = ZONE_TYPE;
        } else {
            str4 = INTERCEPT_TYPE;
        }
        QualtricsLog.logInfo("Recording page view...");
        if (str4.equals("zone")) {
            this.mService.zoneRecordPageView(1, str, this.mAppName, (System.currentTimeMillis() / 1000) + "", clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL, this.mBrandId, this.mZoneID).enqueue(new Callback<Void>() { // from class: com.qualtrics.digital.SiteInterceptService.2
                @Override // retrofit2.Callback
                public void onResponse(Call<Void> call, Response<Void> response) {
                    QualtricsLog.logInfo("Zone page view recorded");
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<Void> call, Throwable th) {
                    QualtricsLog.logError("Error recording page view: " + th.getMessage());
                }
            });
        } else {
            this.mService.interceptRecordPageView(1, str, str2, str3, this.mAppName, (System.currentTimeMillis() / 1000) + "", clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL, this.mBrandId, this.mZoneID).enqueue(new Callback<Void>() { // from class: com.qualtrics.digital.SiteInterceptService.3
                @Override // retrofit2.Callback
                public void onResponse(Call<Void> call, Response<Void> response) {
                    QualtricsLog.logInfo("Intercept page view recorded");
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<Void> call, Throwable th) {
                    QualtricsLog.logError("Error recording page view: " + th.getMessage());
                }
            });
        }
    }

    void recordImpression(final String str, String str2, String str3) {
        String str4;
        String str5;
        String strEncode;
        String str6;
        String str7;
        String str8;
        if (this.mService == null) {
            logUninitializedError("record impression");
            return;
        }
        ClientSideInterceptUtils clientSideInterceptUtilsInstance = ClientSideInterceptUtils.instance();
        if (clientSideInterceptUtilsInstance.passingActionSetXmdAttributes.containsKey(str)) {
            XmdAttributes xmdAttributes = clientSideInterceptUtilsInstance.passingActionSetXmdAttributes.get(str);
            XMDUtils xMDUtils = XMDUtils.getInstance();
            String str9 = xMDUtils.extRefId;
            String str10 = xMDUtils.brandDC;
            String str11 = xmdAttributes.SurveyId;
            String str12 = xmdAttributes.DistributionId;
            String str13 = xmdAttributes.ContactId;
            String str14 = xmdAttributes.DirectoryId;
            try {
                strEncode = URLEncoder.encode(str9, StandardCharsets.UTF_8.toString());
                str5 = str10;
            } catch (UnsupportedEncodingException e) {
                QualtricsLog.logError("Error encoding extRefId for record impression request: " + e.getMessage());
                str5 = str10;
                strEncode = null;
            }
            str8 = str11;
            str4 = str12;
            str6 = str13;
            str7 = str14;
        } else {
            str4 = null;
            str5 = null;
            strEncode = null;
            str6 = null;
            str7 = null;
            str8 = null;
        }
        QualtricsLog.logInfo("Recording impression...");
        this.mService.recordImpression(1, str, str2, str3, this.mAppName, (System.currentTimeMillis() / 1000) + "", clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL, str5, strEncode, str4, str6, str7, str8, this.mZoneID, this.mBrandId).enqueue(new Callback<Void>() { // from class: com.qualtrics.digital.SiteInterceptService.4
            @Override // retrofit2.Callback
            public void onResponse(Call<Void> call, Response<Void> response) {
                QualtricsLog.logInfo("Impression recorded for " + str);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<Void> call, Throwable th) {
                QualtricsLog.logError("Error recording impression for " + str + ": " + th.getMessage());
            }
        });
    }

    void recordClick(String str, String str2, String str3) {
        if (this.mService == null) {
            logUninitializedError("record click");
        } else {
            QualtricsLog.logInfo("Recording click...");
            this.mService.recordClick(1, str, str2, str3, this.mAppName, (System.currentTimeMillis() / 1000) + "", clientType, BuildConfig.VERSION_NAME, Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT, Build.MANUFACTURER + "_" + Build.MODEL, this.mZoneID, this.mBrandId).enqueue(new Callback<Void>() { // from class: com.qualtrics.digital.SiteInterceptService.5
                @Override // retrofit2.Callback
                public void onResponse(Call<Void> call, Response<Void> response) {
                    QualtricsLog.logInfo("Click recorded");
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<Void> call, Throwable th) {
                    QualtricsLog.logError("Error recording click: " + th.getMessage());
                }
            });
        }
    }

    void postResponse(String str, String str2, String str3, String str4, String str5) {
        this.mService.postSurveyResponse(str, str3, str2, str4, str5).enqueue(new Callback<ResponseBody>() { // from class: com.qualtrics.digital.SiteInterceptService.6
            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                QualtricsLog.logInfo("Qualtrics: Response saved");
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable th) {
                QualtricsLog.logError("Qualtrics: Error recording response:" + th.getMessage());
            }
        });
    }

    void startSurveySession(String str, Map map, Callback<JsonObject> callback) {
        JSONObject jSONObject = new JSONObject(map);
        String string = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        Gson gson = new Gson();
        this.mService.startSurveySession(str, (JsonObject) (!(gson instanceof Gson) ? gson.fromJson(string, JsonObject.class) : GsonInstrumentation.fromJson(gson, string, JsonObject.class))).enqueue(callback);
    }

    void updateSurveySession(String str, Map map) {
        JSONObject jSONObject = new JSONObject(map);
        String string = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        Gson gson = new Gson();
        this.mService.updateSurveySession(str, (JsonObject) (!(gson instanceof Gson) ? gson.fromJson(string, JsonObject.class) : GsonInstrumentation.fromJson(gson, string, JsonObject.class))).enqueue(new Callback<ResponseBody>() { // from class: com.qualtrics.digital.SiteInterceptService.7
            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                QualtricsLog.logInfo("Qualtrics: Survey Response saved");
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable th) {
                QualtricsLog.logError("Qualtrics: Error recording survey response:" + th.getMessage());
            }
        });
    }

    String makeURLFriendlyZoneId(String str) {
        return str.replace("_", "").toLowerCase();
    }
}
