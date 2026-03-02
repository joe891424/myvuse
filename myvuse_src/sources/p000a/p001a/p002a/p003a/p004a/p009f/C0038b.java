package p000a.p001a.p002a.p003a.p004a.p009f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.brentvatne.react.ReactVideoView;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0022q;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: renamed from: a.a.a.a.a.f.b */
/* JADX INFO: loaded from: classes.dex */
public class C0038b {

    /* JADX INFO: renamed from: a */
    public final Context f76a;

    /* JADX INFO: renamed from: b */
    public String f77b;

    /* JADX INFO: renamed from: c */
    public C0045d f78c;

    /* JADX INFO: renamed from: d */
    public C0048h f79d = new C0048h();

    /* JADX INFO: renamed from: a.a.a.a.a.f.b$a */
    public class a implements Callback<String> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f80a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ OTCallback f81b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ OTPublishersHeadlessSDK f82c;

        public a(String str, OTCallback oTCallback, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
            this.f80a = str;
            this.f81b = oTCallback;
            this.f82c = oTPublishersHeadlessSDK;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m258a(Response response, String str, OTCallback oTCallback, Handler handler, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
            OTLogger.m2743a(4, "NetworkRequestHandler", "parsing appdata in BG thread");
            C0038b.this.m257a((Response<String>) response, str, oTCallback, handler, oTPublishersHeadlessSDK, true);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<String> call, Throwable th) {
            OTLogger.m2743a(6, "NetworkRequestHandler", " network call response error out = " + th.getMessage());
            C0038b c0038b = C0038b.this;
            OTCallback oTCallback = this.f81b;
            c0038b.getClass();
            if (oTCallback != null) {
                oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 3, c0038b.f76a.getResources().getString(C3896R.string.err_ott_callback_failure), ""));
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<String> call, final Response<String> response) {
            OTResponse oTResponse;
            final String strBody = response.body();
            OTLogger.m2743a(4, "NetworkRequestHandler", " OTT response? = " + strBody);
            if (response.raw() != null) {
                long jReceivedResponseAtMillis = response.raw().receivedResponseAtMillis() - response.raw().sentRequestAtMillis();
                OTLogger.m2743a(3, "OneTrust", String.format("%s %d.%d s", "Time taken for OT SDK setup data fetch: ", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(jReceivedResponseAtMillis)), Long.valueOf(jReceivedResponseAtMillis % 1000)));
            }
            String str = this.f80a;
            String string = C0038b.this.f76a.getResources().getString(C3896R.string.warn_ot_failure);
            if (C0048h.m305b(strBody)) {
                oTResponse = new OTResponse(OTResponseType.OT_ERROR, 2, string.replace("SDK_VERSION", str), "");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(strBody);
                    if (jSONObject.has("culture") && jSONObject.has("domain") && jSONObject.has(Scopes.PROFILE)) {
                        oTResponse = null;
                    } else {
                        OTLogger.m2743a(6, "OneTrust", "SDK Initialization failed, Cannot parse the data received from Server because it is corrupted");
                        oTResponse = new OTResponse(OTResponseType.OT_ERROR, 7, "SDK Initialization failed, Cannot parse the data received from Server because it is corrupted", "");
                    }
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "OneTrust", "SDK Initialization failed, Cannot parse the data received from Server because it is corrupted" + e.toString());
                    oTResponse = new OTResponse(OTResponseType.OT_ERROR, 7, "SDK Initialization failed, Cannot parse the data received from Server because it is corrupted", "");
                }
            }
            if (oTResponse != null) {
                OTCallback oTCallback = this.f81b;
                if (oTCallback != null) {
                    oTCallback.onFailure(oTResponse);
                    return;
                }
                return;
            }
            final Handler handler = new Handler(Looper.getMainLooper());
            final OTCallback oTCallback2 = this.f81b;
            final OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f82c;
            new Thread(new Runnable() { // from class: a.a.a.a.a.f.b$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m258a(response, strBody, oTCallback2, handler, oTPublishersHeadlessSDK);
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: a.a.a.a.a.f.b$b */
    public class b implements Callback<String> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ OTCallback f84a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ OTResponse f85b;

        public b(OTCallback oTCallback, OTResponse oTResponse) {
            this.f84a = oTCallback;
            this.f85b = oTResponse;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m260a(Response response, final OTCallback oTCallback, Handler handler, final OTResponse oTResponse) {
            OTLogger.m2743a(4, "NetworkRequestHandler", "Parsing IAB data in BG thread.");
            Context context = C0038b.this.f76a;
            new C0022q(context).m135a(context, (String) response.body());
            if (oTCallback != null) {
                OTLogger.m2743a(3, "NetworkRequestHandler", "Parsing IAB data complete, sending app callback.");
                handler.post(new Runnable() { // from class: a.a.a.a.a.f.b$b$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        oTCallback.onSuccess(oTResponse);
                    }
                });
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<String> call, Throwable th) {
            OTLogger.m2743a(6, "NetworkRequestHandler", " IAB Vendorlist Api Failed  :  " + th.getMessage());
            OTCallback oTCallback = this.f84a;
            if (oTCallback != null) {
                oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 102, " IAB Vendorlist Api Failed ", ""));
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<String> call, final Response<String> response) {
            OTLogger.m2743a(4, "NetworkRequestHandler", " IAB Vendorlist Api Success : " + response.body());
            if (response.raw() != null) {
                long jReceivedResponseAtMillis = response.raw().receivedResponseAtMillis() - response.raw().sentRequestAtMillis();
                OTLogger.m2743a(3, "OneTrust", String.format("%s %d.%d s", "Time taken for IAB Vendor data fetch: ", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(jReceivedResponseAtMillis)), Long.valueOf(jReceivedResponseAtMillis % 1000)));
            }
            final Handler handler = new Handler(Looper.getMainLooper());
            final OTCallback oTCallback = this.f84a;
            final OTResponse oTResponse = this.f85b;
            new Thread(new Runnable() { // from class: a.a.a.a.a.f.b$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m260a(response, oTCallback, handler, oTResponse);
                }
            }).start();
        }
    }

    public C0038b(Context context) {
        this.f76a = context;
        this.f78c = new C0045d(context, "OTT_DEFAULT_USER");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ea A[Catch: JSONException -> 0x02ab, TRY_LEAVE, TryCatch #3 {JSONException -> 0x02ab, blocks: (B:24:0x00b7, B:27:0x00d0, B:30:0x00d8, B:33:0x00ec, B:35:0x00f1, B:39:0x00fa, B:41:0x010c, B:43:0x012a, B:42:0x0124, B:44:0x0149, B:46:0x0162, B:50:0x0172, B:52:0x0192, B:57:0x01a6, B:61:0x01b1, B:69:0x01e2, B:71:0x01ea, B:74:0x01f6, B:80:0x0222, B:87:0x0250, B:86:0x024b, B:85:0x0235, B:88:0x0259, B:92:0x026d, B:96:0x027d, B:100:0x0297, B:93:0x0271, B:95:0x0279, B:68:0x01dd, B:67:0x01c7, B:82:0x022e, B:64:0x01c0), top: B:117:0x00b7, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0271 A[Catch: JSONException -> 0x02ab, TryCatch #3 {JSONException -> 0x02ab, blocks: (B:24:0x00b7, B:27:0x00d0, B:30:0x00d8, B:33:0x00ec, B:35:0x00f1, B:39:0x00fa, B:41:0x010c, B:43:0x012a, B:42:0x0124, B:44:0x0149, B:46:0x0162, B:50:0x0172, B:52:0x0192, B:57:0x01a6, B:61:0x01b1, B:69:0x01e2, B:71:0x01ea, B:74:0x01f6, B:80:0x0222, B:87:0x0250, B:86:0x024b, B:85:0x0235, B:88:0x0259, B:92:0x026d, B:96:0x027d, B:100:0x0297, B:93:0x0271, B:95:0x0279, B:68:0x01dd, B:67:0x01c7, B:82:0x022e, B:64:0x01c0), top: B:117:0x00b7, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0295  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m254a(java.lang.String r28, java.lang.String r29, java.lang.String r30, int r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p009f.C0038b.m254a(java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    /* JADX INFO: renamed from: a */
    public final void m255a(final String str, final String str2, final String str3, final OTSdkParams oTSdkParams, OkHttpClient.Builder builder, final String str4) {
        builder.addInterceptor(new Interceptor() { // from class: a.a.a.a.a.f.b$$ExternalSyntheticLambda1
            @Override // okhttp3.Interceptor
            public final okhttp3.Response intercept(Interceptor.Chain chain) {
                return this.f$0.m251a(str, str2, str3, str4, oTSdkParams, chain);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m253a(String str, OTCallback oTCallback, OTResponse oTResponse) {
        OTLogger.m2743a(3, "NetworkRequestHandler", "IAB Vendor list Api called ");
        ((InterfaceC0037a) new Retrofit.Builder().baseUrl("https://geolocation.1trust.app/").addConverterFactory(ScalarsConverterFactory.create()).client(new OkHttpClient.Builder().build()).build().create(InterfaceC0037a.class)).m248a(str).enqueue(new b(oTCallback, oTResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public okhttp3.Response m251a(String str, String str2, String str3, String str4, OTSdkParams oTSdkParams, Interceptor.Chain chain) {
        Request.Builder builderHeader;
        String str5;
        Request request = chain.request();
        Request.Builder builderHeader2 = request.newBuilder().header(FirebaseAnalytics.Param.LOCATION, str).header("application", str2).header("lang", str3).header(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, str4);
        String string = this.f78c.m271a().contains("OT_SDK_API_FETCH_TIMESTAMP") ? this.f78c.m271a().getString("OT_SDK_API_FETCH_TIMESTAMP", null) : null;
        OTLogger.m2743a(3, "NetworkRequestHandler", "Last launch timestamp : " + string);
        if (!C0048h.m305b(string)) {
            builderHeader2 = builderHeader2.header("x-onetrust-lastlaunch", string);
            OTLogger.m2743a(3, "NetworkRequestHandler", "Added Last launch timestamp to header");
        }
        if (!C0048h.m305b(oTSdkParams.getOTRegionCode())) {
            builderHeader2 = builderHeader2.header("OT-Region-Code", oTSdkParams.getOTRegionCode());
        }
        if (!C0048h.m305b(oTSdkParams.getOTCountryCode())) {
            builderHeader2 = builderHeader2.header("OT-Country-Code", oTSdkParams.getOTCountryCode());
        }
        OTProfileSyncParams otProfileSyncParams = oTSdkParams.getOtProfileSyncParams();
        if (otProfileSyncParams != null && !C0048h.m305b(otProfileSyncParams.getSyncProfile()) && Boolean.parseBoolean(otProfileSyncParams.getSyncProfile())) {
            builderHeader = builderHeader2.header("fetchType", "APP_DATA_AND_SYNC_PROFILE");
            if (!C0048h.m305b(otProfileSyncParams.getIdentifier())) {
                builderHeader = builderHeader.header(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER, otProfileSyncParams.getIdentifier());
            }
            if (!C0048h.m305b(otProfileSyncParams.getSyncProfileAuth())) {
                builderHeader = builderHeader.header("syncProfileAuth", otProfileSyncParams.getSyncProfileAuth());
            }
            if (!C0048h.m305b(otProfileSyncParams.getTenantId())) {
                builderHeader = builderHeader.header("tenantId", otProfileSyncParams.getTenantId());
            }
            if (!C0048h.m305b(otProfileSyncParams.getSyncGroupId())) {
                builderHeader = builderHeader.header("syncGroupId", otProfileSyncParams.getSyncGroupId());
            }
            String string2 = this.f78c.m271a().getString("OT_ProfileSyncETag", null);
            if (C0048h.m305b(string2)) {
                str5 = "Empty ETag.";
            } else {
                builderHeader = builderHeader.header("profileSyncETag", string2);
                str5 = "ETag set to Header = " + string2;
            }
            OTLogger.m2743a(3, "NetworkRequestHandler", str5);
        } else {
            OTLogger.m2743a(4, "NetworkRequestHandler", "OT Profile Sync params not set, sending syncProfile false.");
            builderHeader = builderHeader2.header("fetchType", "APP_DATA_ONLY");
        }
        builderHeader.method(request.method(), request.body());
        return chain.proceed(!(builderHeader instanceof Request.Builder) ? builderHeader.build() : OkHttp3Instrumentation.build(builderHeader));
    }

    /* JADX INFO: renamed from: a */
    public void m256a(String str, String str2, String str3, OTCallback oTCallback, String str4, String str5, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        String string;
        String str6;
        String str7;
        Context context = this.f76a;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            z = true;
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        } else {
            sharedPreferencesC0047f = null;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        String string2 = sharedPreferences.getString("OTT_REGION_CODE", null);
        String string3 = sharedPreferences.getString("OTT_COUNTRY_CODE", null);
        String string4 = sharedPreferences.getString("OTT_CREATE_CONSENT_PROFILE_STRING", null);
        String string5 = sharedPreferences.getString("OTT_PROFILE_SYNC_PROFILE_STRING", null);
        String string6 = sharedPreferences.getString("OTT_DATA_SUBJECT_IDENTIFIER", null);
        String string7 = sharedPreferences.getString("OTT_PROFILE_SYNC_PROFILE_AUTH", null);
        String string8 = sharedPreferences.getString("OTT_PROFILE_TENANT_ID", null);
        String string9 = sharedPreferences.getString("OTT_PROFILE_SYNC_GROUP_ID", null);
        OTProfileSyncParams.OTProfileSyncParamsBuilder oTProfileSyncParamsBuilderNewInstance = OTProfileSyncParams.OTProfileSyncParamsBuilder.newInstance();
        if (string5 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setSyncProfile(string5);
        }
        if (string6 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setIdentifier(string6);
        }
        if (string7 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setSyncProfileAuth(string7);
        }
        if (string8 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setTenantId(string8);
        }
        if (string9 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setSyncGroupId(string9);
        }
        OTSdkParams.SdkParamsBuilder profileSyncParams = OTSdkParams.SdkParamsBuilder.newInstance().setProfileSyncParams(oTProfileSyncParamsBuilderNewInstance.build());
        if (string4 != null) {
            profileSyncParams = profileSyncParams.shouldCreateProfile(string4);
        }
        String string10 = sharedPreferences.getString("OTT_SDK_API_VERSION", null);
        if (string10 != null) {
            profileSyncParams = profileSyncParams.setAPIVersion(string10);
        }
        if (string2 != null) {
            profileSyncParams = profileSyncParams.setOTRegionCode(string2);
        }
        if (string3 != null) {
            profileSyncParams = profileSyncParams.setOTCountryCode(string3);
        }
        OTSdkParams oTSdkParamsBuild = profileSyncParams.build();
        if (C0048h.m305b(str5)) {
            StringBuilder sb = new StringBuilder("https://mobile-data.");
            String str8 = str4 != null ? str4 : "";
            str7 = "onetrust.io";
            if (!C0048h.m305b(str8)) {
                String strTrim = str8.trim();
                if (!C0048h.m305b(strTrim)) {
                    str7 = "qa".equals(strTrim) ? "1trust.app" : "onetrust.io";
                    if ("dev".equals(strTrim)) {
                        str7 = "onetrust.dev";
                    }
                }
            }
            string = sb.append(str7).append("/bannersdk/v2/applicationdata").toString();
        } else {
            string = str5;
        }
        this.f77b = string;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        String oTSdkAPIVersion = oTSdkParamsBuild.getOTSdkAPIVersion();
        if (!C0048h.m305b(oTSdkAPIVersion) && !"202307.1.0".equals(oTSdkAPIVersion)) {
            OTLogger.m2743a(5, "OneTrust", "API version has been overridden. This feature is for testing only. Do not go live with an overridden API version.");
            str6 = oTSdkAPIVersion;
        } else {
            OTLogger.m2743a(4, "NetworkRequestHandler", "SDK api version not overridden, using SDK version = 202307.1.0");
            str6 = "202307.1.0";
        }
        m255a(str, str2, str3, oTSdkParamsBuild, builder, str6);
        InterfaceC0037a interfaceC0037a = (InterfaceC0037a) new Retrofit.Builder().baseUrl("https://mobile-data.onetrust.io/").addConverterFactory(ScalarsConverterFactory.create()).client(builder.build()).build().create(InterfaceC0037a.class);
        OTLogger.m2743a(4, "NetworkRequestHandler", "Requesting OTT data from : " + this.f77b);
        OTLogger.m2743a(3, "NetworkRequestHandler", "Requesting OTT data parameters : " + str + ", " + str2 + ", " + str3 + "," + oTSdkParamsBuild.getOTCountryCode() + "," + oTSdkParamsBuild.getOTRegionCode() + ", " + str6 + ", Profile : " + (oTSdkParamsBuild.getOtProfileSyncParams() != null ? oTSdkParamsBuild.getOtProfileSyncParams().toString() : null));
        Call<String> callM250b = interfaceC0037a.m250b(this.f77b);
        OTLogger.m2743a(4, "NetworkRequestHandler", " OTT data Download : Download OTT data started");
        callM250b.enqueue(new a(str6, oTCallback, oTPublishersHeadlessSDK));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(33:0|2|(45:4|(1:6)(1:7)|(1:9)|10|(1:12)|13|(1:15)|16|(1:18)(1:19)|(1:21)|22|(2:24|(3:34|(1:36)(1:37)|38))(1:39)|40|(4:42|(1:44)(1:45)|(1:47)|48)|49|(4:51|76|314|77)(3:312|52|(5:54|(11:56|57|305|58|(1:60)(1:61)|62|(1:64)|65|66|320|67)(0)|76|314|77)(0))|83|307|84|(1:86)(1:87)|(1:89)|90|(24:308|92|93|100|(1:106)|113|(1:115)(1:116)|(1:118)|301|119|(1:121)(1:125)|126|(2:128|(11:130|(1:159)(16:133|299|134|135|295|136|137|293|138|(1:140)(1:141)|(1:143)|144|145|146|(1:148)(1:149)|150)|(1:194)(13:162|318|163|(4:166|(5:168|169|316|170|324)(2:171|(2:173|323)(1:325))|174|164)|322|175|(1:177)(1:178)|(1:180)|181|182|183|(1:185)(1:186)|187)|195|(1:199)|200|(1:202)(1:203)|204|(1:206)|207|(1:(2:(1:231)|259)(5:213|(4:216|(5:327|218|(1:222)|223|(1:333)(3:329|227|334))(1:331)|330|214)|326|258|259))(2:(3:(3:238|(4:241|(2:243|336)(1:337)|244|239)|335)|(4:250|(1:252)|253|(1:257))|258)|259))(1:260))(0)|297|261|(4:263|264|303|265)(1:269)|273|(1:275)|276|(1:278)|279|(1:281)|(1:286)|(1:340)(2:291|292))(1:98)|99|100|(3:102|104|106)|113|(0)(0)|(0)|301|119|(0)(0)|126|(0)(0)|297|261|(0)(0)|273|(0)|276|(0)|279|(0)|(2:284|286)|(1:339)(1:338))(1:81)|82|83|307|84|(0)(0)|(0)|90|(0)(0)|99|100|(0)|113|(0)(0)|(0)|301|119|(0)(0)|126|(0)(0)|297|261|(0)(0)|273|(0)|276|(0)|279|(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0320, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0321, code lost:
    
        r4 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x037f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0380, code lost:
    
        com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r12, r4, "error while getting mobile data json, err: " + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0905, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0906, code lost:
    
        r2 = r25;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02db A[Catch: Exception -> 0x031e, TryCatch #9 {Exception -> 0x031e, blocks: (B:100:0x02d3, B:102:0x02db, B:104:0x02e3, B:106:0x02fc, B:99:0x02ce, B:97:0x02c8), top: B:310:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0379 A[Catch: JSONException -> 0x037f, TRY_LEAVE, TryCatch #4 {JSONException -> 0x037f, blocks: (B:119:0x036d, B:121:0x0379), top: B:301:0x036d }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x08ef A[Catch: JSONException -> 0x0905, TRY_LEAVE, TryCatch #2 {JSONException -> 0x0905, blocks: (B:261:0x08e9, B:263:0x08ef), top: B:297:0x08e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0980  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0989  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0995 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x09a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x028c A[Catch: Exception -> 0x0320, TryCatch #7 {Exception -> 0x0320, blocks: (B:84:0x0272, B:86:0x028c, B:90:0x029d, B:92:0x02a9, B:95:0x02b3), top: B:307:0x0272, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02cc  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m257a(retrofit2.Response<java.lang.String> r26, java.lang.String r27, final com.onetrust.otpublishers.headless.Public.OTCallback r28, android.os.Handler r29, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r30, boolean r31) {
        /*
            Method dump skipped, instruction units count: 2528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p009f.C0038b.m257a(retrofit2.Response, java.lang.String, com.onetrust.otpublishers.headless.Public.OTCallback, android.os.Handler, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK, boolean):void");
    }
}
