package com.onetrust.otpublishers.headless.Public;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTCache;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p007c.C0005a0;
import p000a.p001a.p002a.p003a.p004a.p007c.C0007b0;
import p000a.p001a.p002a.p003a.p004a.p007c.C0011f;
import p000a.p001a.p002a.p003a.p004a.p007c.C0014i;
import p000a.p001a.p002a.p003a.p004a.p007c.C0015j;
import p000a.p001a.p002a.p003a.p004a.p007c.C0022q;
import p000a.p001a.p002a.p003a.p004a.p007c.C0025t;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p007c.C0027v;
import p000a.p001a.p002a.p003a.p004a.p007c.C0028w;
import p000a.p001a.p002a.p003a.p004a.p007c.C0031z;
import p000a.p001a.p002a.p003a.p004a.p008e.C0036d;
import p000a.p001a.p002a.p003a.p004a.p009f.C0038b;
import p000a.p001a.p002a.p003a.p004a.p009f.C0040d;
import p000a.p001a.p002a.p003a.p004a.p009f.C0041e;
import p000a.p001a.p002a.p003a.p004a.p010g.C0043b;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p004a.p011i.C0052d;
import p000a.p001a.p002a.p003a.p004a.p013k.C0057a;
import p000a.p001a.p002a.p003a.p014b.fragment.OTBannerFragment;
import p000a.p001a.p002a.p003a.p014b.fragment.OTSDKListFragment;
import p000a.p001a.p002a.p003a.p014b.fragment.OTVendorListFragment;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0158d;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0159e;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0160f;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0164j;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0168n;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.C0093d;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: loaded from: classes6.dex */
public class OTPublishersHeadlessSDK {
    public static final String VENDOR_DETAILS_ERROR_MSG = "Error in getting vendorDetails , error = ";

    /* JADX INFO: renamed from: a */
    public Context f4107a;

    /* JADX INFO: renamed from: b */
    public C0015j f4108b;

    /* JADX INFO: renamed from: c */
    public OTVendorUtils f4109c;

    /* JADX INFO: renamed from: d */
    public C0031z f4110d;

    /* JADX INFO: renamed from: e */
    public String f4111e;

    /* JADX INFO: renamed from: f */
    public String f4112f;

    /* JADX INFO: renamed from: g */
    public C0002a f4113g;

    public OTPublishersHeadlessSDK(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f4107a = applicationContext;
        this.f4108b = new C0015j(applicationContext);
        this.f4109c = new OTVendorUtils(getVendorListData(), getVendorListData(OTVendorListMode.GOOGLE), getVendorListData(OTVendorListMode.GENERAL));
        this.f4113g = new C0002a();
        this.f4110d = new C0031z(this.f4107a);
    }

    public static void enableOTSDKLog(int i) {
        OTLogger.f4050a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[Catch: Exception -> 0x0082, TryCatch #0 {Exception -> 0x0082, blocks: (B:9:0x003e, B:11:0x004a, B:16:0x006a, B:18:0x0070, B:20:0x0074, B:21:0x0079, B:15:0x0065, B:14:0x0051), top: B:30:0x003e, inners: #1 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2774a(androidx.fragment.app.FragmentActivity r9, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r10) {
        /*
            r8 = this;
            java.lang.String r0 = "OneTrust"
            java.lang.String r1 = "error while returning culture domain data, err: "
            android.content.Context r2 = r8.f4107a
            java.lang.String r3 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r4 = 0
            android.content.SharedPreferences r3 = r2.getSharedPreferences(r3, r4)
            a.a.a.a.a.g.d r5 = new a.a.a.a.a.g.d
            java.lang.String r6 = "OTT_DEFAULT_USER"
            r5.<init>(r2, r6, r4)
            android.content.SharedPreferences r5 = r5.m271a()
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "OT_ENABLE_MULTI_PROFILE"
            java.lang.String r5 = r5.getString(r7, r6)
            boolean r5 = p000a.p001a.p002a.p003a.p004a.p007c.C0026u.m181a(r5, r4)
            java.lang.String r6 = ""
            if (r5 == 0) goto L39
            java.lang.String r4 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r4 = r3.getString(r4, r6)
            a.a.a.a.a.g.f r5 = new a.a.a.a.a.g.f
            r5.<init>(r2, r3, r4)
            r4 = 1
            goto L3a
        L39:
            r5 = 0
        L3a:
            if (r4 == 0) goto L3d
            r3 = r5
        L3d:
            r2 = 6
            java.lang.String r4 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r3 = r3.getString(r4, r6)     // Catch: java.lang.Exception -> L82
            boolean r4 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r3)     // Catch: java.lang.Exception -> L82
            if (r4 != 0) goto L65
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L50 java.lang.Exception -> L82
            r4.<init>(r3)     // Catch: org.json.JSONException -> L50 java.lang.Exception -> L82
            goto L6a
        L50:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L82
            r4.<init>(r1)     // Catch: java.lang.Exception -> L82
            java.lang.String r1 = r3.getMessage()     // Catch: java.lang.Exception -> L82
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Exception -> L82
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L82
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r2, r0, r1)     // Catch: java.lang.Exception -> L82
        L65:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L82
            r4.<init>()     // Catch: java.lang.Exception -> L82
        L6a:
            int r1 = r4.length()     // Catch: java.lang.Exception -> L82
            if (r1 <= 0) goto L9a
            boolean r1 = r4 instanceof org.json.JSONObject     // Catch: java.lang.Exception -> L82
            if (r1 != 0) goto L79
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L82
            goto L80
        L79:
            r1 = r4
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Exception -> L82
            java.lang.String r1 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4)     // Catch: java.lang.Exception -> L82
        L80:
            r6 = r1
            goto L9a
        L82:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "empty data as SDK not yet initialized "
            r3.<init>(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r3 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r3, r0, r1)
        L9a:
            boolean r1 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r6)
            if (r1 != 0) goto Lb6
            a.a.a.a.b.b.b r0 = new a.a.a.a.b.b.b
            r0.<init>()
            a.a.a.a.a.b.a r1 = r8.f4113g
            com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason r2 = new com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason
            r3 = 110(0x6e, float:1.54E-43)
            java.lang.String r4 = com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason.getResponseMessage(r3)
            r2.<init>(r3, r4)
            r0.m380a(r9, r1, r10, r2)
            goto Lc1
        Lb6:
            android.content.Context r9 = r8.f4107a
            int r10 = com.onetrust.otpublishers.headless.C3896R.string.str_ot_renderui_error_msg
            java.lang.String r9 = r9.getString(r10)
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r2, r0, r9)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.m2774a(androidx.fragment.app.FragmentActivity, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    public void addEventListener(FragmentActivity fragmentActivity, OTEventListener oTEventListener) {
        if (!C0170b.m959a(fragmentActivity, "OTPublishersHeadlessSDK")) {
            OTLogger.m2743a(5, "OneTrust", "addEventListener: activity passed - null");
            return;
        }
        addEventListener(oTEventListener);
        C0002a eventListenerSetter = this.f4113g;
        ArrayList arrayList = new ArrayList();
        arrayList.add(OTFragmentTags.OT_BANNER_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG);
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            Fragment fragmentFindFragmentByTag = C0048h.m302a(fragmentActivity, str) ? fragmentActivity.getSupportFragmentManager().findFragmentByTag(str) : null;
            if (fragmentFindFragmentByTag instanceof OTBannerFragment) {
                OTBannerFragment oTBannerFragment = (OTBannerFragment) fragmentFindFragmentByTag;
                oTBannerFragment.getClass();
                Intrinsics.checkNotNullParameter(eventListenerSetter, "eventListenerSetter");
                oTBannerFragment.f1140c = eventListenerSetter;
            }
            if (fragmentFindFragmentByTag instanceof ViewOnClickListenerC0159e) {
                ((ViewOnClickListenerC0159e) fragmentFindFragmentByTag).f1253B = eventListenerSetter;
            }
            if (fragmentFindFragmentByTag instanceof ViewOnClickListenerC0158d) {
                ((ViewOnClickListenerC0158d) fragmentFindFragmentByTag).f1209X = eventListenerSetter;
            }
            if (fragmentFindFragmentByTag instanceof OTVendorListFragment) {
                OTVendorListFragment oTVendorListFragment = (OTVendorListFragment) fragmentFindFragmentByTag;
                oTVendorListFragment.getClass();
                Intrinsics.checkNotNullParameter(eventListenerSetter, "eventListenerSetter");
                oTVendorListFragment.f1398c = eventListenerSetter;
            }
        }
    }

    public void appendCustomDataElements(JSONObject jSONObject) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f4107a;
        new JSONObject();
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        sharedPreferences.edit().putString("OT_DS_DATA_ELEMENT_OBJECT", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[Catch: Exception -> 0x0082, TryCatch #0 {Exception -> 0x0082, blocks: (B:9:0x003e, B:11:0x004a, B:16:0x006a, B:18:0x0070, B:20:0x0074, B:21:0x0079, B:15:0x0065, B:14:0x0051), top: B:30:0x003e, inners: #1 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2777b(androidx.fragment.app.FragmentActivity r9, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r10) {
        /*
            r8 = this;
            java.lang.String r0 = "OneTrust"
            java.lang.String r1 = "error while returning culture domain data, err: "
            android.content.Context r2 = r8.f4107a
            java.lang.String r3 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r4 = 0
            android.content.SharedPreferences r3 = r2.getSharedPreferences(r3, r4)
            a.a.a.a.a.g.d r5 = new a.a.a.a.a.g.d
            java.lang.String r6 = "OTT_DEFAULT_USER"
            r5.<init>(r2, r6, r4)
            android.content.SharedPreferences r5 = r5.m271a()
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "OT_ENABLE_MULTI_PROFILE"
            java.lang.String r5 = r5.getString(r7, r6)
            boolean r5 = p000a.p001a.p002a.p003a.p004a.p007c.C0026u.m181a(r5, r4)
            java.lang.String r6 = ""
            if (r5 == 0) goto L39
            java.lang.String r4 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r4 = r3.getString(r4, r6)
            a.a.a.a.a.g.f r5 = new a.a.a.a.a.g.f
            r5.<init>(r2, r3, r4)
            r4 = 1
            goto L3a
        L39:
            r5 = 0
        L3a:
            if (r4 == 0) goto L3d
            r3 = r5
        L3d:
            r2 = 6
            java.lang.String r4 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r3 = r3.getString(r4, r6)     // Catch: java.lang.Exception -> L82
            boolean r4 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r3)     // Catch: java.lang.Exception -> L82
            if (r4 != 0) goto L65
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L50 java.lang.Exception -> L82
            r4.<init>(r3)     // Catch: org.json.JSONException -> L50 java.lang.Exception -> L82
            goto L6a
        L50:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L82
            r4.<init>(r1)     // Catch: java.lang.Exception -> L82
            java.lang.String r1 = r3.getMessage()     // Catch: java.lang.Exception -> L82
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Exception -> L82
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L82
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r2, r0, r1)     // Catch: java.lang.Exception -> L82
        L65:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L82
            r4.<init>()     // Catch: java.lang.Exception -> L82
        L6a:
            int r1 = r4.length()     // Catch: java.lang.Exception -> L82
            if (r1 <= 0) goto L9a
            boolean r1 = r4 instanceof org.json.JSONObject     // Catch: java.lang.Exception -> L82
            if (r1 != 0) goto L79
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L82
            goto L80
        L79:
            r1 = r4
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Exception -> L82
            java.lang.String r1 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4)     // Catch: java.lang.Exception -> L82
        L80:
            r6 = r1
            goto L9a
        L82:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "empty data as SDK not yet initialized "
            r3.<init>(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r3 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r3, r0, r1)
        L9a:
            boolean r1 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r6)
            if (r1 != 0) goto Lb6
            a.a.a.a.b.b.c r0 = new a.a.a.a.b.b.c
            r0.<init>()
            a.a.a.a.a.b.a r1 = r8.f4113g
            com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason r2 = new com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason
            r3 = 210(0xd2, float:2.94E-43)
            java.lang.String r4 = com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason.getResponseMessage(r3)
            r2.<init>(r3, r4)
            r0.m381a(r9, r1, r10, r2)
            goto Lc1
        Lb6:
            android.content.Context r9 = r8.f4107a
            int r10 = com.onetrust.otpublishers.headless.C3896R.string.str_ot_renderui_error_msg
            java.lang.String r9 = r9.getString(r10)
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r2, r0, r9)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.m2777b(androidx.fragment.app.FragmentActivity, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callSetupUI(androidx.fragment.app.FragmentActivity r17, int r18, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r19) {
        /*
            Method dump skipped, instruction units count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.callSetupUI(androidx.fragment.app.FragmentActivity, int, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[Catch: Exception -> 0x0058, TryCatch #3 {Exception -> 0x0058, blocks: (B:3:0x0011, B:5:0x0021, B:10:0x0041, B:12:0x0047, B:14:0x004b, B:15:0x0050, B:9:0x003c, B:8:0x0028), top: B:56:0x0011, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callShowConsentPreferencesUI(final androidx.fragment.app.FragmentActivity r7, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r8) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.callShowConsentPreferencesUI(androidx.fragment.app.FragmentActivity, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    public void clearOTSDKConfigurationData() {
        this.f4107a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).edit().clear().apply();
    }

    public void clearOTSDKData() {
        new C0048h().m319h(this.f4107a);
        reInitiateLocalVariable();
    }

    public void deleteProfile(String str, OTCallback oTCallback) {
        if (str == null || C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OneTrust", "Empty profileId passed to delete the profile.");
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 13, this.f4107a.getResources().getString(C3896R.string.ott_profile_delete_profile_error), ""));
        } else {
            new C0052d(this.f4107a).m335a(str, this, oTCallback, this.f4107a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getBoolean("OT_MULTI_PROFILE_DOWNLOAD_DATA_AFTER_SWITCH", false), this.f4111e, this.f4112f);
            reInitiateLocalVariable();
        }
    }

    public void dismissUI(FragmentActivity fragmentActivity) {
        if (!isOTUIPresent(fragmentActivity)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "No OneTrust UI is present.");
            return;
        }
        try {
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_BANNER_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_BANNER_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag instanceof OTBannerFragment) {
                    ((OTBannerFragment) fragmentFindFragmentByTag).dismiss();
                }
            }
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag2 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag2 instanceof ViewOnClickListenerC0159e) {
                    ((ViewOnClickListenerC0159e) fragmentFindFragmentByTag2).dismiss();
                }
            }
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag3 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag3 instanceof ViewOnClickListenerC0158d) {
                    ((ViewOnClickListenerC0158d) fragmentFindFragmentByTag3).dismiss();
                }
            }
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag4 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag4 instanceof OTVendorListFragment) {
                    ((OTVendorListFragment) fragmentFindFragmentByTag4).dismiss();
                }
            }
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag5 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag5 instanceof ViewOnClickListenerC0168n) {
                    ((ViewOnClickListenerC0168n) fragmentFindFragmentByTag5).dismiss();
                }
            }
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag6 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag6 instanceof OTSDKListFragment) {
                    ((OTSDKListFragment) fragmentFindFragmentByTag6).dismiss();
                }
            }
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag7 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag7 instanceof ViewOnClickListenerC0160f) {
                    ((ViewOnClickListenerC0160f) fragmentFindFragmentByTag7).dismiss();
                }
            }
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag8 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag8 instanceof ViewOnClickListenerC0164j) {
                    ((ViewOnClickListenerC0164j) fragmentFindFragmentByTag8).dismiss();
                }
            }
            if (C0048h.m302a(fragmentActivity, OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag9 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag9 instanceof C0093d) {
                    ((C0093d) fragmentFindFragmentByTag9).dismiss();
                }
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "UIUtils", "Something went wrong while closing UI: " + e.getMessage());
        }
    }

    public int getAgeGatePromptValue() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f4107a;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        int i = sharedPreferences.getInt("OT_AGE_GATE_USER_CONSENT_STATUS", -1);
        OTLogger.m2743a(3, "AgeGateConsentHandler", "Default Age Gate Consent status :" + i);
        return i;
    }

    public JSONObject getBannerData() {
        Context context = this.f4107a;
        C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER");
        new C0046e(context);
        new C0036d(context);
        String string = c0045d.m271a().getString("OTT_BANNER_DATA", null);
        if (C0048h.m305b(string)) {
            return null;
        }
        return new JSONObject(string);
    }

    public JSONObject getCommonData() {
        String string = new C0045d(this.f4107a, "OTT_DEFAULT_USER").m271a().getString("OTT_CULTURE_COMMON_DATA", "");
        if (!C0048h.m305b(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while returning common data, err: " + e.getMessage());
            }
        }
        return new JSONObject();
    }

    public int getConsentStatusForGroupId(String str) {
        return new C0046e(this.f4107a).m272a(str);
    }

    public int getConsentStatusForGroupId(String str, String str2) {
        if (C0048h.m305b(str)) {
            OTLogger.m2743a(4, "OTPublishersHeadlessSDK", "Invalid custom group Id passed - " + str);
            return -1;
        }
        int iM272a = new C0046e(this.f4107a).m272a(str);
        return iM272a == -1 ? "active".equalsIgnoreCase(str2) ? 1 : 0 : iM272a;
    }

    public int getConsentStatusForSDKId(String str) {
        return this.f4108b.f34g.m189a(str, false);
    }

    public String getCurrentActiveProfile() {
        return new C0045d(this.f4107a, "OTT_DEFAULT_USER", false).m271a().getString("OT_ACTIVE_PROFILE_ID", "");
    }

    public JSONObject getDomainGroupData() {
        String string = new C0045d(this.f4107a, "OTT_DEFAULT_USER").m271a().getString("OTT_CULTURE_DOMAIN_DATA", "");
        if (!C0048h.m305b(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while returning culture domain data, err: " + e.getMessage());
            }
        }
        return new JSONObject();
    }

    public JSONObject getDomainInfo() {
        String string = new C0045d(this.f4107a, "OTT_DEFAULT_USER").m271a().getString("OTT_DOMAIN_DATA", "");
        if (!C0048h.m305b(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while returning domain data, err: " + e.getMessage());
            }
        }
        return new JSONObject();
    }

    public OTGeolocationModel getLastDataDownloadedLocation() {
        String string = new C0045d(this.f4107a, "OTT_DEFAULT_USER").m271a().getString("OT_DATA_DOWNLOADED_GEO_LOCATION", "");
        if (C0048h.m305b(string)) {
            return null;
        }
        OTGeolocationModel oTGeolocationModel = new OTGeolocationModel();
        try {
            JSONObject jSONObject = new JSONObject(string);
            oTGeolocationModel.country = jSONObject.optString("country");
            oTGeolocationModel.state = jSONObject.optString("state");
            return oTGeolocationModel;
        } catch (JSONException e) {
            OTLogger.m2743a(6, "GLDataHandler", "error in formatting ott data with err = " + e.getMessage());
            return oTGeolocationModel;
        }
    }

    public OTGeolocationModel getLastUserConsentedLocation() {
        String string = new C0045d(this.f4107a, "OTT_DEFAULT_USER").m271a().getString("OT_CONSENTED_LOCATION", "");
        if (C0048h.m305b(string)) {
            return null;
        }
        OTGeolocationModel oTGeolocationModel = new OTGeolocationModel();
        try {
            JSONObject jSONObject = new JSONObject(string);
            oTGeolocationModel.country = jSONObject.optString("country");
            oTGeolocationModel.state = jSONObject.optString("state");
            return oTGeolocationModel;
        } catch (JSONException e) {
            OTLogger.m2743a(6, "GLDataHandler", "error in formatting ott data with err = " + e.getMessage());
            return oTGeolocationModel;
        }
    }

    public OTCache getOTCache() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f4107a;
        OTCache.OTCacheBuilder oTCacheBuilderNewInstance = OTCache.OTCacheBuilder.newInstance();
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
        String string = sharedPreferences.getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
        oTCacheBuilderNewInstance.setDataSubjectIdentifier(string != null ? string : "");
        return oTCacheBuilderNewInstance.build();
    }

    public String getOTConsentJSForWebView() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        Context context = this.f4107a;
        C0007b0 c0007b0 = new C0007b0(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
            z = false;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        if (!"0".equals(sharedPreferences.getString("OTT_LAST_GIVEN_CONSENT", "0"))) {
            return c0007b0.m42a(true);
        }
        OTLogger.m2743a(3, "WebviewConsentHelper", "WebviewConsent : user is not interacted, returning default ccpa, groups values. ");
        return c0007b0.m42a(false);
    }

    public OTVendorUtils getOtVendorUtils() {
        return this.f4109c;
    }

    public JSONObject getPreferenceCenterData() {
        String string = new C0045d(this.f4107a, "OTT_DEFAULT_USER").m271a().getString("OTT_PC_DATA", null);
        if (C0048h.m305b(string)) {
            return null;
        }
        return new JSONObject(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[Catch: Exception -> 0x0058, TryCatch #1 {Exception -> 0x0058, blocks: (B:3:0x0010, B:5:0x0020, B:10:0x0041, B:12:0x0047, B:14:0x004b, B:15:0x0050, B:9:0x003c, B:8:0x0027), top: B:31:0x0010, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getPurposeConsentLocal(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "OneTrust"
            java.lang.String r2 = "error while returning culture domain data, err: "
            android.content.Context r3 = r6.f4107a
            a.a.a.a.a.g.d r4 = new a.a.a.a.a.g.d
            java.lang.String r5 = "OTT_DEFAULT_USER"
            r4.<init>(r3, r5)
            r3 = 3
            android.content.SharedPreferences r4 = r4.m271a()     // Catch: java.lang.Exception -> L58
            java.lang.String r5 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r4 = r4.getString(r5, r0)     // Catch: java.lang.Exception -> L58
            boolean r5 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r4)     // Catch: java.lang.Exception -> L58
            if (r5 != 0) goto L3c
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L26 java.lang.Exception -> L58
            r5.<init>(r4)     // Catch: org.json.JSONException -> L26 java.lang.Exception -> L58
            goto L41
        L26:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L58
            r5.<init>(r2)     // Catch: java.lang.Exception -> L58
            java.lang.String r2 = r4.getMessage()     // Catch: java.lang.Exception -> L58
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch: java.lang.Exception -> L58
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L58
            r4 = 6
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r4, r1, r2)     // Catch: java.lang.Exception -> L58
        L3c:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L58
            r5.<init>()     // Catch: java.lang.Exception -> L58
        L41:
            int r2 = r5.length()     // Catch: java.lang.Exception -> L58
            if (r2 <= 0) goto L6f
            boolean r2 = r5 instanceof org.json.JSONObject     // Catch: java.lang.Exception -> L58
            if (r2 != 0) goto L50
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L58
            goto L6f
        L50:
            r2 = r5
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch: java.lang.Exception -> L58
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r5)     // Catch: java.lang.Exception -> L58
            goto L6f
        L58:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "empty data as SDK not yet initialized "
            r4.<init>(r5)
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r2 = r2.toString()
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r3, r1, r2)
        L6f:
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            r1 = -1
            r2 = 5
            java.lang.String r4 = "Purpose Consent Update for id "
            java.lang.String r5 = "OTPublishersHeadlessSDK"
            if (r0 == 0) goto L92
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r0 = " : -1, SDK not finished processing"
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r2, r5, r7)
            return r1
        L92:
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r7)
            if (r0 == 0) goto L9e
            java.lang.String r7 = "Empty purpose id passed to get Purpose Consent Update"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r2, r5, r7)
            return r1
        L9e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r1 = " : "
            java.lang.StringBuilder r0 = r0.append(r1)
            a.a.a.a.a.c.j r1 = r6.f4108b
            int r1 = r1.m96b(r7)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r3, r5, r0)
            a.a.a.a.a.c.j r0 = r6.f4108b
            int r7 = r0.m96b(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.getPurposeConsentLocal(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[Catch: Exception -> 0x0058, TryCatch #1 {Exception -> 0x0058, blocks: (B:3:0x0010, B:5:0x0020, B:10:0x0041, B:12:0x0047, B:14:0x004b, B:15:0x0050, B:9:0x003c, B:8:0x0027), top: B:35:0x0010, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getPurposeLegitInterestLocal(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.getPurposeLegitInterestLocal(java.lang.String):int");
    }

    public int getUCPurposeConsent(String str) {
        if (!C0048h.m305b(str)) {
            return this.f4110d.m237d(str);
        }
        OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Invalid id passed to get Purposes Consent Status");
        return -1;
    }

    public C0031z getUcpHandler() {
        return this.f4110d;
    }

    @Deprecated
    public JSONObject getVendorDetails(int i) {
        try {
            JSONObject vendorListWithUserSelectionWithoutFallback = this.f4109c.getVendorListWithUserSelectionWithoutFallback(OTVendorListMode.IAB);
            if (vendorListWithUserSelectionWithoutFallback == null) {
                vendorListWithUserSelectionWithoutFallback = getVendorListData(OTVendorListMode.IAB);
            }
            if (vendorListWithUserSelectionWithoutFallback == null) {
                vendorListWithUserSelectionWithoutFallback = new JSONObject();
            }
            return new C0005a0().m3a(this.f4107a, i, OTVendorUtils.getVendorsListObject(vendorListWithUserSelectionWithoutFallback, String.valueOf(i)));
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPublishersHeadlessSDK", VENDOR_DETAILS_ERROR_MSG + e.getMessage());
            return null;
        }
    }

    @Deprecated
    public JSONObject getVendorDetails(String str, int i) {
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            return getVendorDetails(str, String.valueOf(i));
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            return getVendorDetails(i);
        }
        return null;
    }

    @Deprecated
    public final JSONObject getVendorListData() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f4107a;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        String string = sharedPreferences.getString("OT_IAB_ACTIVE_VENDORLIST", "");
        OTLogger.m2743a(3, "IABHelper", !C0048h.m305b(string) ? "Saved IAB Active Vendor List : " + string : "Vendor List is empty");
        if (C0048h.m305b(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPublishersHeadlessSDK", "Error on Json object creation, error msg = " + e.getMessage());
            return null;
        }
    }

    @Deprecated
    public JSONObject getVendorListUI() {
        JSONObject vendorListWithUserSelection = this.f4109c.getVendorListWithUserSelection(OTVendorListMode.IAB);
        if ((vendorListWithUserSelection == null || vendorListWithUserSelection.length() <= 0) && (vendorListWithUserSelection = getVendorListData(OTVendorListMode.IAB)) == null) {
            vendorListWithUserSelection = new JSONObject();
        }
        LogInstrumentation.m2726d("OTPublishersHeadlessSDK", "getVendorListUI: " + vendorListWithUserSelection.length() + "," + vendorListWithUserSelection);
        return vendorListWithUserSelection;
    }

    public JSONObject getVendorListUI(String str) {
        if (!OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            return OTVendorListMode.IAB.equalsIgnoreCase(str) ? getVendorListUI() : this.f4109c.getVendorListWithUserSelection(OTVendorListMode.GENERAL);
        }
        JSONObject vendorListWithUserSelection = this.f4109c.getVendorListWithUserSelection(str);
        if (vendorListWithUserSelection.length() > 0) {
            return vendorListWithUserSelection;
        }
        JSONObject vendorListData = getVendorListData(str);
        return vendorListData == null ? new JSONObject() : vendorListData;
    }

    public int isBannerShown(Context context) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        int i = sharedPreferences.getInt("OneTrustBannerShownToUser", -1);
        OTLogger.m2743a(4, "OneTrust", "Banner shown status : " + i);
        return i;
    }

    public boolean isOTUIPresent(FragmentActivity fragmentActivity) {
        return C0048h.m302a(fragmentActivity, OTFragmentTags.OT_BANNER_FRAGMENT_TAG) || C0048h.m302a(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG) || C0048h.m302a(fragmentActivity, OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG);
    }

    public void loadData(String str, String str2, String str3, OTCallback oTCallback, boolean z) {
        if (z) {
            OTLogger.m2743a(4, "OTPublishersHeadlessSDK", "Starting OT SDK network call.");
            if (!C0048h.m308c(str3)) {
                OTLogger.m2743a(5, "OTPublishersHeadlessSDK", this.f4107a.getResources().getString(C3896R.string.warn_invalid_lang));
            }
            new C0038b(this.f4107a).m256a(str, str2, str3, oTCallback, this.f4111e, this.f4112f, this);
            return;
        }
        if (new C0045d(this.f4107a, "OTT_DEFAULT_USER").m271a().getBoolean("OTT_OFFLINE_DATA_SET_FLAG", false)) {
            OTLogger.m2743a(4, "OTPublishersHeadlessSDK", "Load offline data flag set false. Network not reachable. Offline data set. Loading offline data.");
            m2775a(oTCallback);
        } else {
            OTLogger.m2743a(6, "OTPublishersHeadlessSDK", "Server not reachable");
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 6, this.f4107a.getResources().getString(C3896R.string.err_ott_callback_failure) + " as server was not reachable", ""));
        }
    }

    public void optIntoSaleOfData() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        Context context = this.f4107a;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        sharedPreferences.edit().putString("INTERACTION_TYPE", OTConsentInteractionType.PC_CONFIRM).apply();
        if (new C0011f(this.f4107a).m68a(true, true)) {
            Context context2 = this.f4107a;
            OTLogger.m2743a(4, "OTConsentChanges", "Sending OTConsentUpdated action broadcast. Interaction type = Preference Center - Confirm");
            Intent intent = new Intent();
            intent.setAction(OTBroadcastServiceKeys.OT_CONSENT_UPDATED);
            intent.setPackage(context2.getApplicationContext().getPackageName());
            context2.sendBroadcast(intent);
        }
    }

    public void optOutOfSaleOfData() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        Context context = this.f4107a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
            z = false;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        sharedPreferences.edit().putString("INTERACTION_TYPE", OTConsentInteractionType.PC_CONFIRM).apply();
        if (new C0011f(this.f4107a).m68a(false, true)) {
            Context context2 = this.f4107a;
            OTLogger.m2743a(4, "OTConsentChanges", "Sending OTConsentUpdated action broadcast. Interaction type = Preference Center - Confirm");
            Intent intent = new Intent();
            intent.setAction(OTBroadcastServiceKeys.OT_CONSENT_UPDATED);
            intent.setPackage(context2.getApplicationContext().getPackageName());
            context2.sendBroadcast(intent);
        }
    }

    @Deprecated
    public boolean overrideDataSubjectIdentifier(String str) {
        if (str == null) {
            OTLogger.m2743a(4, "OTPublishersHeadlessSDK", "overrideDataSubjectIdentifier: Pass a valid identifier!!");
            return false;
        }
        if (C0026u.m181a(new C0045d(this.f4107a, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "This method is now deprecated and replaced with renameProfile().");
            return C0048h.m305b(str) ? switchUserProfile(str) : renameProfile("", str);
        }
        if (!str.isEmpty()) {
            try {
                C0014i c0014i = new C0014i(this.f4107a);
                c0014i.m80a(this.f4107a, str);
                c0014i.m78a(2);
                return true;
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTPublishersHeadlessSDK", "error in updating consent : " + e.getMessage());
                return false;
            }
        }
        Context context = this.f4107a;
        C0014i c0014i2 = new C0014i(context);
        if (str.isEmpty()) {
            C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER", false);
            String string = c0045d.m271a().getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
            if (C0048h.m305b(string)) {
                string = UUID.randomUUID().toString();
                c0045d.m271a().edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", string).apply();
            }
            str = string;
            OTLogger.m2743a(4, "OTUtils", "Generated identifier = " + str);
            c0014i2.m78a(1);
        } else {
            c0014i2.m78a(2);
        }
        c0014i2.m81a(str);
        c0014i2.m82b();
        return true;
    }

    public void reInitVendorArray() {
        this.f4109c = new OTVendorUtils(getVendorListData(OTVendorListMode.IAB), getVendorListData(OTVendorListMode.GOOGLE), getVendorListData(OTVendorListMode.GENERAL));
    }

    public void reInitiateLocalVariable() {
        this.f4108b = new C0015j(this.f4107a);
        this.f4110d = new C0031z(this.f4107a);
        reInitVendorArray();
    }

    public void renameProfile(String str, String str2, OTCallback oTCallback) {
        if (C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OneTrust", "Empty oldProfileID passed,  using the generic profile Id as oldProfileID.");
            str = new C0045d(this.f4107a, "OTT_DEFAULT_USER", false).m271a().getString("OT_ACTIVE_PROFILE_ID", "");
            if (C0048h.m305b(str)) {
                OTLogger.m2743a(5, "OneTrust", "Empty oldProfileID passed,  and no Active profile exist. Rename profile failed.");
                oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 15, this.f4107a.getResources().getString(C3896R.string.ott_profile_rename_profile_error), ""));
                return;
            }
        }
        if (C0048h.m305b(str2)) {
            OTLogger.m2743a(5, "OneTrust", "Empty newProfileID passed,  Please pass a valid user ID to update.");
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 15, this.f4107a.getResources().getString(C3896R.string.ott_profile_rename_profile_error), ""));
        } else if (new C0052d(this.f4107a).m336a(str, str2)) {
            oTCallback.onSuccess(new OTResponse(OTResponseType.OT_SUCCESS, 16, this.f4107a.getResources().getString(C3896R.string.ott_profile_rename_profile_success), ""));
        } else {
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 15, this.f4107a.getResources().getString(C3896R.string.ott_profile_rename_profile_error), ""));
        }
    }

    public void resetUpdatedConsent() {
        OTLogger.m2743a(4, "OTPublishersHeadlessSDK", "Clearing user selections/local variables.");
        reInitiateLocalVariable();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029e A[Catch: JSONException -> 0x02da, TryCatch #7 {JSONException -> 0x02da, blocks: (B:118:0x0289, B:120:0x0290, B:122:0x029e, B:124:0x02aa, B:126:0x02bd, B:128:0x02c9, B:127:0x02c2, B:123:0x02a3), top: B:252:0x0289 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02a3 A[Catch: JSONException -> 0x02da, TryCatch #7 {JSONException -> 0x02da, blocks: (B:118:0x0289, B:120:0x0290, B:122:0x029e, B:124:0x02aa, B:126:0x02bd, B:128:0x02c9, B:127:0x02c2, B:123:0x02a3), top: B:252:0x0289 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02bd A[Catch: JSONException -> 0x02da, TryCatch #7 {JSONException -> 0x02da, blocks: (B:118:0x0289, B:120:0x0290, B:122:0x029e, B:124:0x02aa, B:126:0x02bd, B:128:0x02c9, B:127:0x02c2, B:123:0x02a3), top: B:252:0x0289 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02c2 A[Catch: JSONException -> 0x02da, TryCatch #7 {JSONException -> 0x02da, blocks: (B:118:0x0289, B:120:0x0290, B:122:0x029e, B:124:0x02aa, B:126:0x02bd, B:128:0x02c9, B:127:0x02c2, B:123:0x02a3), top: B:252:0x0289 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0349 A[Catch: JSONException -> 0x04a8, TryCatch #4 {JSONException -> 0x04a8, blocks: (B:144:0x0336, B:147:0x0349, B:148:0x0350, B:150:0x0356, B:154:0x0367, B:156:0x036c, B:159:0x0378), top: B:246:0x0336 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0492 A[Catch: JSONException -> 0x04a6, TryCatch #2 {JSONException -> 0x04a6, blocks: (B:198:0x0482, B:200:0x048e, B:202:0x0492, B:204:0x049e, B:203:0x0497, B:177:0x03e3, B:197:0x0476, B:180:0x03f9, B:183:0x0403, B:196:0x0467, B:187:0x040c, B:189:0x0412, B:191:0x0444, B:193:0x0450, B:192:0x0449), top: B:242:0x036a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0497 A[Catch: JSONException -> 0x04a6, TryCatch #2 {JSONException -> 0x04a6, blocks: (B:198:0x0482, B:200:0x048e, B:202:0x0492, B:204:0x049e, B:203:0x0497, B:177:0x03e3, B:197:0x0476, B:180:0x03f9, B:183:0x0403, B:196:0x0467, B:187:0x040c, B:189:0x0412, B:191:0x0444, B:193:0x0450, B:192:0x0449), top: B:242:0x036a, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019d  */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v24, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r4v13, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r4v14, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void saveConsent(java.lang.String r25) {
        /*
            Method dump skipped, instruction units count: 1626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.saveConsent(java.lang.String):void");
    }

    public void setEnvironment(String str) {
        this.f4111e = str;
    }

    public void setFetchDataURL(String str) {
        this.f4112f = str;
    }

    public boolean setMultiProfileConfig(OTSdkParams oTSdkParams, OTCallback oTCallback, C0052d c0052d) {
        String strM330a = c0052d.m330a(oTSdkParams);
        if (!c0052d.m347e(strM330a)) {
            c0052d.m348f(c0052d.m330a(oTSdkParams));
            OTLogger.m2743a(3, "MultiprofileConsent", "Downloading the data for dsid = " + c0052d.m339b());
            return true;
        }
        SharedPreferences sharedPreferences = this.f4107a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (sharedPreferences.getBoolean("OT_MULTI_PROFILE_CONSENT_ENABLED", false)) {
            int iM344d = c0052d.m344d();
            int i = sharedPreferences.getInt("OT_MULTI_PROFILE_MAXIMUM_PROFILES_LIMIT", 6);
            if (iM344d < i) {
                OTLogger.m2743a(3, "MultiprofileConsent", "setMultiProfileConfig: profile created and set to " + strM330a);
                c0052d.m348f(c0052d.m330a(oTSdkParams));
                return true;
            }
            OTLogger.m2743a(5, "MultiprofileConsent", "Max number of profiles already created. Please delete one of the profiles to be able to add a new one.");
            OTLogger.m2743a(3, "MultiprofileConsent", "multiProfileCount = " + iM344d + ", multiProfileLimit = " + i);
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 8, this.f4107a.getResources().getString(C3896R.string.err_ott_empty_parameters), ""));
            return false;
        }
        String strM339b = c0052d.m339b();
        OTLogger.m2743a(4, "MultiprofileConsent", "Multi Profile Consent is disabled.");
        if (strM339b != null && !C0048h.m305b(strM339b)) {
            try {
                c0052d.m334a(strM339b);
                OTLogger.m2743a(4, "MultiprofileConsent", "Deleting the current profile : " + strM339b);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "MultiprofileConsent", "Error on profile delete : " + strM339b + " , error = " + e.getMessage());
            }
            c0052d.m349g("");
        }
        c0052d.m348f(c0052d.m330a(oTSdkParams));
        return true;
    }

    public boolean setOTCache(OTCache oTCache) {
        return new C0025t().m158a(this.f4107a, this, oTCache);
    }

    public void setOTOfflineData(JSONObject jSONObject) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        SharedPreferencesC0047f sharedPreferencesC0047f2 = null;
        boolean z2 = true;
        try {
            new C0041e().m262a(this.f4107a, this, jSONObject);
            Context context = this.f4107a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z = true;
            } else {
                sharedPreferencesC0047f = null;
                z = false;
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            sharedPreferences.edit().putBoolean("OTT_OFFLINE_DATA_SET_FLAG", true).apply();
        } catch (JSONException unused) {
            OTLogger.m2743a(6, "OTPublishersHeadlessSDK", "Error on setting offline data.");
            OTLogger.m2743a(3, "OTPublishersHeadlessSDK", "Setting OfflineDataSetFlag to false.");
            Context context2 = this.f4107a;
            SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f2 = new SharedPreferencesC0047f(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
            } else {
                z2 = false;
            }
            if (z2) {
                sharedPreferences2 = sharedPreferencesC0047f2;
            }
            sharedPreferences2.edit().putBoolean("OTT_OFFLINE_DATA_SET_FLAG", false).apply();
        }
    }

    public boolean setOTUXParams(OTUXParams oTUXParams) {
        return new C0027v().m188a(this.f4107a, oTUXParams);
    }

    public void setupUI(AppCompatActivity appCompatActivity, int i) {
        callSetupUI(appCompatActivity, i, null);
    }

    public void setupUI(FragmentActivity fragmentActivity, int i) {
        callSetupUI(fragmentActivity, i, null);
    }

    public void setupUI(FragmentActivity fragmentActivity, int i, OTConfiguration oTConfiguration) {
        callSetupUI(fragmentActivity, i, oTConfiguration);
    }

    public boolean shouldShowBanner() {
        return showBannerReason() > -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049 A[Catch: Exception -> 0x005a, TryCatch #0 {Exception -> 0x005a, blocks: (B:4:0x0013, B:6:0x0023, B:11:0x0043, B:13:0x0049, B:15:0x004d, B:16:0x0052, B:10:0x003e, B:9:0x002a), top: B:28:0x0013, outer: #1, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int showBannerReason() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "OneTrust"
            java.lang.String r2 = "error while returning culture domain data, err: "
            java.lang.String r3 = "empty data as SDK not yet initialized "
            r4 = 6
            r5 = -1
            android.content.Context r6 = r9.f4107a     // Catch: org.json.JSONException -> L87
            a.a.a.a.a.g.d r7 = new a.a.a.a.a.g.d     // Catch: org.json.JSONException -> L87
            java.lang.String r8 = "OTT_DEFAULT_USER"
            r7.<init>(r6, r8)     // Catch: org.json.JSONException -> L87
            android.content.SharedPreferences r6 = r7.m271a()     // Catch: java.lang.Exception -> L5a
            java.lang.String r7 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r6 = r6.getString(r7, r0)     // Catch: java.lang.Exception -> L5a
            boolean r7 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r6)     // Catch: java.lang.Exception -> L5a
            if (r7 != 0) goto L3e
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L29 java.lang.Exception -> L5a
            r7.<init>(r6)     // Catch: org.json.JSONException -> L29 java.lang.Exception -> L5a
            goto L43
        L29:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5a
            r7.<init>(r2)     // Catch: java.lang.Exception -> L5a
            java.lang.String r2 = r6.getMessage()     // Catch: java.lang.Exception -> L5a
            java.lang.StringBuilder r2 = r7.append(r2)     // Catch: java.lang.Exception -> L5a
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L5a
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r4, r1, r2)     // Catch: java.lang.Exception -> L5a
        L3e:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5a
            r7.<init>()     // Catch: java.lang.Exception -> L5a
        L43:
            int r2 = r7.length()     // Catch: java.lang.Exception -> L5a
            if (r2 <= 0) goto L70
            boolean r2 = r7 instanceof org.json.JSONObject     // Catch: java.lang.Exception -> L5a
            if (r2 != 0) goto L52
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Exception -> L5a
            goto L70
        L52:
            r2 = r7
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch: java.lang.Exception -> L5a
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r7)     // Catch: java.lang.Exception -> L5a
            goto L70
        L5a:
            r2 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L87
            r6.<init>(r3)     // Catch: org.json.JSONException -> L87
            java.lang.String r2 = r2.getMessage()     // Catch: org.json.JSONException -> L87
            java.lang.StringBuilder r2 = r6.append(r2)     // Catch: org.json.JSONException -> L87
            java.lang.String r2 = r2.toString()     // Catch: org.json.JSONException -> L87
            r3 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r3, r1, r2)     // Catch: org.json.JSONException -> L87
        L70:
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)     // Catch: org.json.JSONException -> L87
            if (r0 == 0) goto L77
            return r5
        L77:
            a.a.a.a.a.e.d r0 = new a.a.a.a.a.e.d     // Catch: org.json.JSONException -> L87
            android.content.Context r1 = r9.f4107a     // Catch: org.json.JSONException -> L87
            r0.<init>(r1)     // Catch: org.json.JSONException -> L87
            org.json.JSONObject r1 = r9.getBannerData()     // Catch: org.json.JSONException -> L87
            int r5 = r0.m247b(r1)     // Catch: org.json.JSONException -> L87
            goto La0
        L87:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error while computing show banner status,returning default value as false: "
            r1.<init>(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "OTPublishersHeadlessSDK"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r4, r1, r0)
        La0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.showBannerReason():int");
    }

    public void showBannerUI(AppCompatActivity appCompatActivity) {
        m2774a(appCompatActivity, null);
    }

    public void showBannerUI(FragmentActivity fragmentActivity) {
        m2774a(fragmentActivity, null);
    }

    public void showBannerUI(FragmentActivity fragmentActivity, OTConfiguration oTConfiguration) {
        m2774a(fragmentActivity, oTConfiguration);
    }

    public void showConsentPurposesUI(FragmentActivity fragmentActivity) {
        callShowConsentPreferencesUI(fragmentActivity, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[Catch: Exception -> 0x0058, TryCatch #3 {Exception -> 0x0058, blocks: (B:3:0x0011, B:5:0x0021, B:10:0x0041, B:12:0x0047, B:14:0x004b, B:15:0x0050, B:9:0x003c, B:8:0x0028), top: B:49:0x0011, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showConsentUI(final androidx.fragment.app.FragmentActivity r8, int r9, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r10, com.onetrust.otpublishers.headless.Public.OTConsentUICallback r11) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.showConsentUI(androidx.fragment.app.FragmentActivity, int, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration, com.onetrust.otpublishers.headless.Public.OTConsentUICallback):void");
    }

    public void showPreferenceCenterUI(AppCompatActivity appCompatActivity) {
        m2777b(appCompatActivity, null);
    }

    public void showPreferenceCenterUI(FragmentActivity fragmentActivity) {
        m2777b(fragmentActivity, null);
    }

    public void showPreferenceCenterUI(FragmentActivity fragmentActivity, OTConfiguration oTConfiguration) {
        m2777b(fragmentActivity, oTConfiguration);
    }

    public void startSDK(String str, String str2, String str3, OTSdkParams oTSdkParams, OTCallback oTCallback) {
        m2776a(str, str2, str3, oTSdkParams, false, oTCallback);
    }

    public void startSDK(String str, String str2, String str3, OTSdkParams oTSdkParams, boolean z, OTCallback oTCallback) {
        m2776a(str, str2, str3, oTSdkParams, z, oTCallback);
    }

    public void switchUserProfile(String str, OTCallback oTCallback) {
        if (new C0052d(this.f4107a).m341b(str, this, oTCallback, this.f4107a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getBoolean("OT_MULTI_PROFILE_DOWNLOAD_DATA_AFTER_SWITCH", false), this.f4111e, this.f4112f)) {
            reInitiateLocalVariable();
        }
    }

    @Deprecated
    public boolean switchUserProfile(String str) {
        boolean zM341b = new C0052d(this.f4107a).m341b(str, this, null, false, this.f4111e, this.f4112f);
        if (zM341b) {
            reInitiateLocalVariable();
        }
        return zM341b;
    }

    public void updateAllSDKConsentStatus(JSONArray jSONArray, boolean z) {
        C0028w c0028w = this.f4108b.f34g;
        String string = c0028w.f51a.getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        if (C0048h.m305b(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                String string2 = jSONArray.get(i).toString();
                if (jSONObject.has(string2) && 2 != jSONObject.getInt(string2)) {
                    c0028w.f53c.put(string2, z ? 1 : 0);
                }
            }
            OTLogger.m2743a(4, "SdkListHelper", "Updated All SDK status for  - " + c0028w.f53c);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "SdkListHelper", "Error while updating all sdk status " + e.getMessage());
        }
    }

    public void updateAllVendorsConsentLocal(String str, boolean z) {
        this.f4109c.updateAllVendorsConsentLocal(str, z);
    }

    public void updateAllVendorsConsentLocal(boolean z) {
        this.f4109c.updateAllVendorsConsentLocal(OTVendorListMode.IAB, z);
    }

    public void updatePurposeConsent(String str, boolean z) {
        this.f4108b.m99b(str, z);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void updatePurposeConsent(String str, boolean z, boolean z2) {
        if (!z2) {
            updatePurposeConsent(str, z);
            return;
        }
        C0015j c0015j = this.f4108b;
        if (c0015j.m99b(str, z)) {
            if (C0048h.m305b(c0015j.f33f)) {
                try {
                    c0015j.f33f = c0015j.m83a();
                } catch (JSONException unused) {
                    OTLogger.m2743a(6, "CustomGroupDetails", "Error on creating valid consent able parent child map.");
                }
            }
            String str2 = c0015j.f33f;
            if (C0048h.m305b(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean z3 = false;
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        c0015j.m99b(jSONArray.get(i).toString(), z);
                    }
                    return;
                }
                String strM84a = c0015j.m84a(str);
                if (strM84a != null && !C0048h.m305b(strM84a)) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray(strM84a);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray2.length()) {
                            z3 = true;
                            break;
                        } else if (c0015j.m96b(jSONArray2.get(i2).toString()) != 1) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    c0015j.m99b(strM84a, z3);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "CustomGroupDetails", "Error on getting parent child JSON. Error message = " + e.getMessage());
            }
        }
    }

    public void updatePurposeLegitInterest(String str, boolean z) {
        if (C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Empty purpose id passed to update Purpose LegitInterest method.");
            return;
        }
        if (!str.startsWith("IABV2")) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Invalid ID " + str + " passed to update Purpose LegitInterest");
            return;
        }
        C0015j c0015j = this.f4108b;
        try {
            if (new JSONObject(c0015j.f31d.getString("OTT_IAB_CONSENTABLE_PURPOSES", "")).getJSONObject("purposeLegitimateInterests").has(C0022q.m123b(str))) {
                c0015j.f30c.put(str, z ? 1 : 0);
                OTLogger.m2743a(4, "CustomGroupDetails", "Legitimate Interest value updated for Purpose " + str + " with value : " + z);
            } else {
                OTLogger.m2743a(5, "CustomGroupDetails", "Legitimate Interest value not updated for Purpose " + str);
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "CustomGroupDetails", "error in updating purpose legitimate interest status. err = " + e.getMessage());
        }
    }

    public void updateSDKConsentStatus(String str, boolean z) {
        this.f4108b.m101c(str, z);
    }

    public void updateUCPurposeConsent(String str, String str2, String str3, boolean z) {
        if (C0048h.m305b(str3) || C0048h.m305b(str2) || C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Invalid id passed to update Custom Preference Options");
        } else if (getUCPurposeConsent(str3) < 1) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Purpose consent for " + str3 + " is disabled, thus Custom Preference cannot be enabled");
        } else {
            this.f4110d.m224a(str2, str.trim() + str3.trim() + str2.trim(), z, str);
        }
    }

    public void updateVendorConsent(String str, String str2, boolean z) {
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str) || OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            if (C0048h.m305b(str2)) {
                OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Empty vendor id passed to updateVendorConsent method.");
                return;
            }
        } else {
            if (!OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
                return;
            }
            if (C0048h.m305b(str2)) {
                OTLogger.m2743a(5, "GeneralVendors", "Empty vendor id passed to updateVendorConsent method.");
                return;
            }
            C0043b c0043b = new C0043b(new C0045d(this.f4107a, "OTT_DEFAULT_USER"));
            if (!c0043b.m269b() || !c0043b.m270c()) {
                OTLogger.m2743a(5, "GeneralVendors", "Cannot update consent for the Vendor ID:General Vendor data with opt-out not found in template settings");
                return;
            }
        }
        this.f4109c.updateVendorConsentStatus(str, str2, z);
    }

    public void updateVendorLegitInterest(String str, String str2, boolean z) {
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Legitimate Interest not supported for Google vendors.");
        } else {
            updateVendorLegitInterest(str2, z);
        }
    }

    public void writeLogsToFile(boolean z, boolean z2) {
        if (z) {
            OTLogger.open(this.f4107a.getFilesDir() + "/OTPublisherHeadlessSDKLogs.log", 2, DurationKt.NANOS_IN_MILLIS);
        } else if (z2 && !z) {
            OTLogger.m2743a(4, "OTPublishersHeadlessSDK", "Write To File Should be Enabled!");
        }
        OTLogger.f4056g = z;
        OTLogger.f4057h = z2;
    }

    public JSONObject getVendorDetails(String str, String str2) {
        try {
            if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
                JSONObject vendorDetails = getVendorDetails(Integer.parseInt(str2));
                OTLogger.m2743a(3, "OTPublishersHeadlessSDK", "Vendor mode = " + str + ", Vendor details for ID:" + str2 + " " + vendorDetails);
                return vendorDetails;
            }
            if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
                JSONObject vendorListWithUserSelectionWithoutFallback = this.f4109c.getVendorListWithUserSelectionWithoutFallback(str);
                if (vendorListWithUserSelectionWithoutFallback == null) {
                    vendorListWithUserSelectionWithoutFallback = getVendorListData(str);
                }
                if (vendorListWithUserSelectionWithoutFallback == null) {
                    vendorListWithUserSelectionWithoutFallback = new JSONObject();
                }
                JSONObject vendorsListObject = OTVendorUtils.getVendorsListObject(vendorListWithUserSelectionWithoutFallback, str2);
                OTLogger.m2743a(3, "OTPublishersHeadlessSDK", "Vendor mode = " + str + ", Vendor details for ID:" + str2 + " " + vendorsListObject);
                return vendorsListObject;
            }
            JSONObject vendorListWithUserSelectionWithoutFallback2 = this.f4109c.getVendorListWithUserSelectionWithoutFallback(str);
            if (vendorListWithUserSelectionWithoutFallback2 == null) {
                vendorListWithUserSelectionWithoutFallback2 = getVendorListData(str);
            }
            if (vendorListWithUserSelectionWithoutFallback2 == null) {
                vendorListWithUserSelectionWithoutFallback2 = new JSONObject();
            }
            JSONObject vendorsListObject2 = OTVendorUtils.getVendorsListObject(vendorListWithUserSelectionWithoutFallback2, str2);
            OTLogger.m2743a(3, "OTPublishersHeadlessSDK", "Vendor mode = " + str + ", Vendor details for ID:" + str2 + " " + vendorsListObject2);
            return vendorsListObject2;
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTPublishersHeadlessSDK", VENDOR_DETAILS_ERROR_MSG + e.getMessage());
            return null;
        }
    }

    public int getUCPurposeConsent(String str, String str2) {
        if (!C0048h.m305b(str2) && !C0048h.m305b(str)) {
            return this.f4110d.m218a(str, str2);
        }
        OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Invalid id passed to get UCP Topic Consent Status");
        return -1;
    }

    @Deprecated
    public void updateVendorLegitInterest(String str, boolean z) {
        if (C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Empty vendor id passed to updateVendorLegitInterest method.");
            return;
        }
        try {
            if (!getDomainGroupData().isNull("LegIntSettings")) {
                if (getDomainGroupData().getJSONObject("LegIntSettings").getBoolean("PAllowLI")) {
                    this.f4109c.updateVendorLegitInterest(OTVendorListMode.IAB, str, z);
                } else {
                    OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Not updated LI value for vendor ID " + str + ", LI not configured for this vendor Id.");
                }
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OTPublishersHeadlessSDK", "Error while checking LI feature toggle" + e.getMessage());
        }
    }

    public int getUCPurposeConsent(String str, String str2, String str3) {
        if (!C0048h.m305b(str3) && !C0048h.m305b(str2) && !C0048h.m305b(str)) {
            return this.f4110d.m219a(str, str3, str2);
        }
        OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Invalid id passed to get UCP Custom Preference Option Consent Status");
        return -1;
    }

    public void updateUCPurposeConsent(String str, String str2, boolean z) {
        if (C0048h.m305b(str2) || C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Invalid id passed to update Topics");
        } else if (getUCPurposeConsent(str2) < 1) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Purpose consent for " + str2 + " is disabled, thus topic cannot be enabled");
        } else {
            this.f4110d.m236c(str.trim() + str2.trim(), str, z);
        }
    }

    @Deprecated
    public boolean deleteProfile(String str) {
        if (str == null || C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OneTrust", "Empty profileId passed to delete the profile.");
            return false;
        }
        boolean zM335a = new C0052d(this.f4107a).m335a(str, this, null, false, this.f4111e, this.f4112f);
        reInitiateLocalVariable();
        return zM335a;
    }

    public void updateUCPurposeConsent(String str, boolean z) {
        if (C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Invalid id passed to update Purposes");
        } else {
            this.f4110d.m225a(str, z);
        }
    }

    public JSONObject getVendorListData(String str) {
        C0045d c0045d = new C0045d(this.f4107a, "OTT_DEFAULT_USER");
        C0043b c0043b = new C0043b(c0045d);
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            JSONObject jSONObjectM268a = c0043b.m268a();
            OTLogger.m2743a(4, "OTPublishersHeadlessSDK", "Saved General Vendors : " + jSONObjectM268a);
            return jSONObjectM268a;
        }
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            try {
                String string = c0045d.m271a().getString("OT_GOOGLE_ACTIVE_VENDOR_LIST", null);
                if (C0048h.m305b(string)) {
                    return null;
                }
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while getting culture data json on getActiveGoogleVendors, err: " + e.getMessage());
                return null;
            }
        }
        return getVendorListData();
    }

    @Deprecated
    public void updateVendorConsent(String str, boolean z) {
        if (C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "Empty vendor id passed to updateVendorConsent method.");
        } else {
            this.f4109c.updateVendorConsentStatus(OTVendorListMode.IAB, str, z);
        }
    }

    @Deprecated
    public boolean renameProfile(String str, String str2) {
        if (C0048h.m305b(str)) {
            OTLogger.m2743a(5, "OneTrust", "Empty oldProfileID passed,  using the generic profile Id as oldProfileID.");
            str = new C0045d(this.f4107a, "OTT_DEFAULT_USER", false).m271a().getString("OT_ACTIVE_PROFILE_ID", "");
            if (C0048h.m305b(str)) {
                OTLogger.m2743a(5, "OneTrust", "Empty oldProfileID passed,  and no Active profile exist. Rename profile failed.");
                return false;
            }
        }
        if (C0048h.m305b(str2)) {
            OTLogger.m2743a(5, "OneTrust", "Empty newProfileID passed,  Please pass a valid user ID to update.");
            return false;
        }
        return new C0052d(this.f4107a).m336a(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0078 A[Catch: Exception -> 0x0089, TryCatch #1 {Exception -> 0x0089, blocks: (B:9:0x0045, B:11:0x0051, B:16:0x0072, B:18:0x0078, B:20:0x007c, B:21:0x0081, B:15:0x006d, B:14:0x0058), top: B:46:0x0045, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2775a(com.onetrust.otpublishers.headless.Public.OTCallback r14) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.m2775a(com.onetrust.otpublishers.headless.Public.OTCallback):void");
    }

    public void addEventListener(OTEventListener oTEventListener) {
        C0002a c0002a = this.f4113g;
        c0002a.getClass();
        OTLogger.m2743a(3, "EventListenerSetter", "clear OTEventListener.");
        c0002a.f1a.clear();
        C0002a c0002a2 = this.f4113g;
        c0002a2.getClass();
        if (oTEventListener == null) {
            OTLogger.m2743a(3, "EventListenerSetter", "OtEventListener set with null called.");
        } else {
            OTLogger.m2743a(3, "EventListenerSetter", "Add OtEventListener, value = " + oTEventListener);
            c0002a2.f1a.add(oTEventListener);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2776a(String str, String str2, String str3, OTSdkParams oTSdkParams, boolean z, OTCallback oTCallback) {
        boolean z2;
        SharedPreferences sharedPreferencesC0047f;
        SharedPreferences sharedPreferences;
        int i;
        String str4;
        OTSdkParams oTSdkParams2;
        String str5;
        String str6;
        boolean multiProfileConfig;
        String str7;
        String str8;
        SharedPreferencesC0047f sharedPreferencesC0047f2;
        boolean z3;
        String str9;
        boolean z4;
        SharedPreferencesC0047f sharedPreferencesC0047f3;
        boolean z5;
        int i2;
        boolean z6;
        SharedPreferencesC0047f sharedPreferencesC0047f4;
        if (C0048h.m305b(str) || C0048h.m305b(str2)) {
            OTLogger.m2743a(5, "OTPublishersHeadlessSDK", "empty parameters passed");
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 4, this.f4107a.getResources().getString(C3896R.string.err_ott_empty_parameters), ""));
        }
        new C0057a(this.f4107a).m371b();
        C0048h c0048h = new C0048h();
        Context context = this.f4107a;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        Boolean bool = Boolean.FALSE;
        if (C0026u.m181a(sharedPreferences3.getString("OT_ENABLE_MULTI_PROFILE", bool.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
            z2 = true;
        } else {
            z2 = false;
            sharedPreferencesC0047f = null;
        }
        SharedPreferences sharedPreferences4 = sharedPreferencesC0047f;
        if (z2) {
            sharedPreferences = sharedPreferences2;
        } else {
            sharedPreferencesC0047f = sharedPreferences2;
            sharedPreferences = sharedPreferencesC0047f;
        }
        String string = sharedPreferencesC0047f.getString("OTT_BLOBLOCATION", "");
        String string2 = (z2 ? sharedPreferences4 : sharedPreferences).getString("OTT_DOMAIN", "");
        String string3 = (z2 ? sharedPreferences4 : sharedPreferences).getString("OTT_LANG_CODE", "");
        String str10 = string.trim() + string2.trim();
        String str11 = str.trim() + str2.trim();
        OTLogger.m2743a(4, "OTUtils", "OTT data parameters" + str10 + "," + str11);
        boolean zEquals = str10.equals(str11);
        if (C0048h.m305b(string) && C0048h.m305b(string2) && C0048h.m305b(string3)) {
            if (!z2) {
                sharedPreferences4 = sharedPreferences;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences4.edit();
            editorEdit.putString("OTT_BLOBLOCATION", str);
            editorEdit.putString("OTT_DOMAIN", str2);
            editorEdit.putString("OTT_LANG_CODE", str3);
            editorEdit.apply();
            OTLogger.m2743a(4, "OTUtils", "saving init parameters to preferences");
        } else {
            if (zEquals) {
                i = 4;
                str4 = "OTT data parameters not changed";
            } else {
                c0048h.m319h(context);
                reInitiateLocalVariable();
                if (!z2) {
                    sharedPreferences4 = sharedPreferences;
                }
                SharedPreferences.Editor editorEdit2 = sharedPreferences4.edit();
                editorEdit2.putString("OTT_BLOBLOCATION", str);
                editorEdit2.putString("OTT_DOMAIN", str2);
                editorEdit2.putString("OTT_LANG_CODE", str3);
                editorEdit2.apply();
                i = 4;
                OTLogger.m2743a(4, "OTUtils", "saving init parameters to preferences");
                str4 = "OTT data parameters changed";
            }
            OTLogger.m2743a(i, "OTUtils", str4);
        }
        C0052d c0052d = new C0052d(this.f4107a);
        if (!C0048h.m305b(c0052d.m339b()) && c0052d.m344d() != 0) {
            oTSdkParams2 = oTSdkParams;
            multiProfileConfig = setMultiProfileConfig(oTSdkParams2, oTCallback, c0052d);
            str5 = "OT_ENABLE_MULTI_PROFILE";
            str6 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
        } else {
            oTSdkParams2 = oTSdkParams;
            OTLogger.m2743a(3, "MultiprofileConsent", "Setting first profile configuration.");
            if (c0052d.m348f(c0052d.m330a(oTSdkParams2)) < 0 || c0052d.m346e()) {
                str5 = "OT_ENABLE_MULTI_PROFILE";
                str6 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
            } else {
                OTLogger.m2743a(3, "multiProfileEnabled", "startOTSDKFlow flow ,calling enableMultiProfile.");
                str6 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
                SharedPreferences sharedPreferences5 = this.f4107a.getSharedPreferences(str6, 0);
                OTLogger.m2743a(3, "multiProfileEnabled", "enableMultiProfile called.");
                str5 = "OT_ENABLE_MULTI_PROFILE";
                sharedPreferences5.edit().putString(str5, Boolean.TRUE.toString()).apply();
                OTLogger.m2743a(3, "multiProfileEnabled", "startOTSDKFlow flow ,reinitializing  the shared preference related variables.");
                reInitiateLocalVariable();
            }
            multiProfileConfig = true;
        }
        if (multiProfileConfig) {
            Context context2 = this.f4107a;
            SharedPreferences sharedPreferences6 = context2.getSharedPreferences(str6, 0);
            if (C0026u.m181a(context2.getSharedPreferences(str6, 0).getString(str5, bool.toString()), false)) {
                str7 = "OT_ACTIVE_PROFILE_ID";
                str8 = "";
                sharedPreferencesC0047f2 = new SharedPreferencesC0047f(context2, sharedPreferences6, sharedPreferences6.getString(str7, str8));
                z3 = true;
            } else {
                str7 = "OT_ACTIVE_PROFILE_ID";
                str8 = "";
                sharedPreferencesC0047f2 = null;
                z3 = false;
            }
            if (z3) {
                sharedPreferences6 = sharedPreferencesC0047f2;
            }
            SharedPreferences.Editor editorEdit3 = sharedPreferences6.edit();
            if (oTSdkParams2 != null) {
                if (oTSdkParams.getCreateProfile() != null) {
                    editorEdit3.putString("OTT_CREATE_CONSENT_PROFILE_STRING", oTSdkParams.getCreateProfile());
                }
                if (oTSdkParams.getOTCountryCode() != null) {
                    editorEdit3.putString("OTT_COUNTRY_CODE", oTSdkParams.getOTCountryCode());
                }
                if (oTSdkParams.getOTRegionCode() != null) {
                    editorEdit3.putString("OTT_REGION_CODE", oTSdkParams.getOTRegionCode());
                }
                if (oTSdkParams.getOTSdkAPIVersion() != null) {
                    editorEdit3.putString("OTT_SDK_API_VERSION", oTSdkParams.getOTSdkAPIVersion());
                }
                if (oTSdkParams.getOtBannerHeight() != null) {
                    editorEdit3.putString("OTT_BANNER_POSITION", oTSdkParams.getOtBannerHeight());
                } else {
                    editorEdit3.putString("OTT_BANNER_POSITION", str8);
                }
                boolean syncWebSDKConsent = oTSdkParams.getSyncWebSDKConsent();
                SharedPreferences sharedPreferences7 = context2.getSharedPreferences(str6, 0);
                if (C0026u.m181a(context2.getSharedPreferences(str6, 0).getString(str5, bool.toString()), false)) {
                    sharedPreferencesC0047f4 = new SharedPreferencesC0047f(context2, sharedPreferences7, sharedPreferences7.getString(str7, str8));
                    z6 = true;
                } else {
                    z6 = false;
                    sharedPreferencesC0047f4 = null;
                }
                if (!syncWebSDKConsent) {
                    if (z6) {
                        sharedPreferences7 = sharedPreferencesC0047f4;
                    }
                    sharedPreferences7.edit().putInt("OT_MIGRATION_STATUS", 5).apply();
                    OTLogger.m2743a(4, "OTUtils", "syncWebSDKConsent Disabled.");
                    str9 = "OTT_DEFAULT_USER";
                } else {
                    String string4 = (z6 ? sharedPreferencesC0047f4 : sharedPreferences7).getString("OTT_DOMAIN", str8);
                    SharedPreferences sharedPreferences8 = context2.getSharedPreferences(str6, 0);
                    SharedPreferencesC0047f sharedPreferencesC0047f5 = sharedPreferencesC0047f4;
                    str9 = "OTT_DEFAULT_USER";
                    if (C0026u.m181a(new C0045d(context2, "OTT_DEFAULT_USER", false).m271a().getString(str5, Boolean.FALSE.toString()), false)) {
                        new SharedPreferencesC0047f(context2, sharedPreferences8, sharedPreferences8.getString(str7, str8));
                    }
                    if (!string4.trim().equals(context2.getSharedPreferences("com.onetrust.otpublisherssdk.Internal.preference", 0).getString("APPLICATION_ID_TO_LOAD", str8).trim())) {
                        (z6 ? sharedPreferencesC0047f5 : sharedPreferences7).edit().putInt("OT_MIGRATION_STATUS", 4).apply();
                        OTLogger.m2743a(5, "OneTrust", "No data found in Web SDK for the domain id passed. Hence cannot sync Web SDK consent data. \nTo sync Web SDK consent data, please pass same appID as Web SDK.");
                    } else {
                        if ((z6 ? sharedPreferencesC0047f5 : sharedPreferences7).getInt("OT_MIGRATION_STATUS", 5) != 3) {
                            (z6 ? sharedPreferencesC0047f5 : sharedPreferences7).edit().putInt("OT_MIGRATION_STATUS", 0).apply();
                            OTLogger.m2743a(4, "OneTrust", "Configured for Syncing data from Web SDK");
                        }
                    }
                }
                OTProfileSyncParams otProfileSyncParams = oTSdkParams.getOtProfileSyncParams();
                if (otProfileSyncParams != null) {
                    if (otProfileSyncParams.getSyncProfile() != null) {
                        editorEdit3.putString("OTT_PROFILE_SYNC_PROFILE_STRING", otProfileSyncParams.getSyncProfile());
                    }
                    String identifier = otProfileSyncParams.getIdentifier();
                    if (identifier == null) {
                        OTLogger.m2743a(4, "OTUtils", "setDataSubjectIdentifier: Pass a valid identifier.");
                        z4 = true;
                        sharedPreferencesC0047f3 = null;
                    } else {
                        C0014i c0014i = new C0014i(context2);
                        if (identifier.isEmpty()) {
                            SharedPreferences sharedPreferences9 = context2.getSharedPreferences(str6, 0);
                            sharedPreferencesC0047f3 = null;
                            String string5 = sharedPreferences9.getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
                            if (C0048h.m305b(string5)) {
                                string5 = UUID.randomUUID().toString();
                                sharedPreferences9.edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", string5).apply();
                            }
                            identifier = string5;
                            OTLogger.m2743a(4, "OTUtils", "Generated identifier = " + identifier);
                            z4 = true;
                            c0014i.m78a(1);
                        } else {
                            z4 = true;
                            sharedPreferencesC0047f3 = null;
                            c0014i.m78a(2);
                        }
                        c0014i.m81a(identifier);
                        c0014i.m82b();
                    }
                    if (otProfileSyncParams.getSyncProfileAuth() != null) {
                        editorEdit3.putString("OTT_PROFILE_SYNC_PROFILE_AUTH", otProfileSyncParams.getSyncProfileAuth());
                    }
                    if (otProfileSyncParams.getTenantId() != null) {
                        editorEdit3.putString("OTT_PROFILE_TENANT_ID", otProfileSyncParams.getTenantId());
                    }
                    if (otProfileSyncParams.getSyncGroupId() != null) {
                        editorEdit3.putString("OTT_PROFILE_SYNC_GROUP_ID", otProfileSyncParams.getSyncGroupId());
                    }
                    OTLogger.m2743a(3, "OTUtils", "OTSync Profile params : " + otProfileSyncParams.toString());
                } else {
                    z4 = true;
                    sharedPreferencesC0047f3 = null;
                }
                OTUXParams oTUXParams = oTSdkParams.getOTUXParams();
                if (oTUXParams != null) {
                    if (oTUXParams.getUxParam() != null) {
                        C0048h.m300a(context2, oTUXParams.getUxParam());
                    }
                    if (oTUXParams.getOTSDKTheme() != null) {
                        C0048h.m307c(context2, oTUXParams.getOTSDKTheme());
                    }
                }
            } else {
                str9 = "OTT_DEFAULT_USER";
                z4 = true;
                sharedPreferencesC0047f3 = null;
            }
            editorEdit3.putBoolean("OTT_LOAD_OFFLINE_DATA", z);
            editorEdit3.apply();
            OTLogger.m2743a(4, "OTUtils", "saving OTSDK parameters to preferences");
            Context context3 = this.f4107a;
            UiModeManager uiModeManager = (UiModeManager) context3.getSystemService("uimode");
            SharedPreferences sharedPreferences10 = context3.getSharedPreferences(str6, 0);
            if (C0026u.m181a(new C0045d(context3, str9, false).m271a().getString(str5, Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f3 = new SharedPreferencesC0047f(context3, sharedPreferences10, sharedPreferences10.getString(str7, str8));
                z5 = z4;
            } else {
                z5 = false;
            }
            if (uiModeManager.getCurrentModeType() == 4) {
                OTLogger.m2743a(4, "OneTrust", "SDK rendering on TV device");
                i2 = 101;
            } else {
                OTLogger.m2743a(4, "OneTrust", "SDK rendering on mobile device");
                i2 = 102;
            }
            if (z5) {
                sharedPreferences10 = sharedPreferencesC0047f3;
            }
            sharedPreferences10.edit().putInt("OT_UI_MODE_TYPE", i2).apply();
            if (!z) {
                loadData(str, str2, str3, oTCallback, new C0040d().m261a(this.f4107a));
            } else {
                OTLogger.m2743a(4, "OTPublishersHeadlessSDK", "Loading offline data.");
                m2775a(oTCallback);
            }
        }
    }
}
