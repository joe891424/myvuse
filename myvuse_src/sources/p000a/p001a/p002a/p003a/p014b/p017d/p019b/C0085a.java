package p000a.p001a.p002a.p003a.p014b.p017d.p019b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.SpannableStringBuilder;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesEditorC0044c;
import p000a.p001a.p002a.p003a.p004a.p011i.C0052d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0069a;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0109d;
import p000a.p001a.p002a.p003a.p014b.p021e.C0117k;
import p000a.p001a.p002a.p003a.p014b.p021e.C0118l;
import p000a.p001a.p002a.p003a.p014b.p021e.C0120n;
import p000a.p001a.p002a.p003a.p014b.p021e.C0123q;

/* JADX INFO: renamed from: a.a.a.a.b.d.b.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0085a {

    /* JADX INFO: renamed from: h */
    public static C0085a f337h;

    /* JADX INFO: renamed from: a */
    public JSONObject f338a;

    /* JADX INFO: renamed from: c */
    public boolean f340c;

    /* JADX INFO: renamed from: e */
    public C0069a f342e;

    /* JADX INFO: renamed from: f */
    public C0123q f343f;

    /* JADX INFO: renamed from: b */
    public String f339b = "";

    /* JADX INFO: renamed from: d */
    public String f341d = "";

    /* JADX INFO: renamed from: g */
    public C0107c f344g = new C0107c();

    /* JADX INFO: renamed from: b */
    public static synchronized C0085a m469b() {
        if (f337h == null) {
            f337h = new C0085a();
        }
        return f337h;
    }

    /* JADX INFO: renamed from: a */
    public final void m472a(C0109d c0109d) {
        C0069a c0069a;
        this.f342e = new C0069a();
        int i = 0;
        if (!C0026u.m181a(c0109d.f743d, false)) {
            C0069a c0069a2 = this.f342e;
            c0069a2.f229m = 8;
            c0069a2.f233q = 8;
            return;
        }
        if (!C0026u.m181a(c0109d.f742c, false) || C0048h.m305b(c0109d.f745f.mo376a())) {
            C0107c c0107c = new C0107c();
            c0107c.f736i = C0086b.m475a().f350e;
            c0107c.f737j = C0086b.m475a().f351f;
            c0069a = this.f342e;
            c0069a.f232p = c0107c;
            c0069a.f229m = 0;
            i = 8;
        } else {
            this.f342e.f734g = c0109d.f745f.mo376a();
            String strOptString = c0109d.f740a;
            JSONObject jSONObject = this.f338a;
            if (strOptString == null || C0048h.m305b(strOptString)) {
                strOptString = jSONObject != null ? jSONObject.optString("BannerLinksTextColor") : "#E8E8E8";
            }
            if (!C0048h.m305b(strOptString)) {
                this.f342e.f730c = strOptString;
            }
            C0107c c0107c2 = c0109d.f745f;
            c0107c2.f736i = C0086b.m475a().f350e;
            c0107c2.f737j = C0086b.m475a().f351f;
            c0107c2.f730c = strOptString;
            c0069a = this.f342e;
            c0069a.f232p = c0107c2;
            c0069a.f229m = 8;
        }
        c0069a.f233q = i;
    }

    /* JADX INFO: renamed from: a */
    public String m470a() {
        String str = this.f343f.f785a;
        return str != null ? str : "#FFFFFF";
    }

    /* JADX INFO: renamed from: a */
    public void m473a(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String strReplace;
        boolean z;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        try {
            JSONObject jSONObject = this.f338a;
            String str6 = "";
            if (jSONObject == null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                Boolean bool = Boolean.FALSE;
                if (C0026u.m181a(sharedPreferences2.getString("OT_ENABLE_MULTI_PROFILE", bool.toString()), false)) {
                    sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z = true;
                } else {
                    z = false;
                    sharedPreferencesC0047f = null;
                }
                SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                    new SharedPreferencesC0047f(context, sharedPreferences3, sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", ""));
                }
                SharedPreferences sharedPreferences4 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", bool.toString()), false)) {
                    new SharedPreferencesEditorC0044c(sharedPreferences4, context.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new C0052d(context).m343c(sharedPreferences4.getString("OT_ACTIVE_PROFILE_ID", "")), 0));
                }
                if (z) {
                    sharedPreferences = sharedPreferencesC0047f;
                }
                String string = sharedPreferences.getString("OTT_BANNER_DATA", null);
                jSONObject = !C0048h.m305b(string) ? new JSONObject(string) : null;
            }
            this.f338a = jSONObject;
            String strOptString = jSONObject.optString("BackgroundColor");
            this.f339b = this.f338a.optString("TextColor");
            String strOptString2 = this.f338a.optString("BannerTitle");
            String strOptString3 = this.f338a.optString("AlertNoticeText");
            String strOptString4 = this.f338a.optString("AlertAllowCookiesText");
            String strOptString5 = this.f338a.optString("BannerRejectAllButtonText");
            String strOptString6 = this.f338a.optString("AlertMoreInfoText");
            String strOptString7 = this.f338a.optString("ButtonColor");
            String strOptString8 = this.f338a.optString("ButtonColor");
            String strOptString9 = this.f338a.optString("BannerMPButtonColor");
            String strOptString10 = this.f338a.optString("ButtonTextColor");
            String strOptString11 = this.f338a.optString("BannerMPButtonTextColor");
            this.f340c = this.f338a.optBoolean("IsIabEnabled");
            String strOptString12 = this.f338a.optString("BannerDPDTitle");
            String strOptString13 = this.f338a.optString("BannerDPDDescription");
            if (strOptString13.isEmpty()) {
                str3 = strOptString;
                str2 = strOptString2;
                str = strOptString3;
                str4 = strOptString6;
                str5 = strOptString9;
            } else {
                str = strOptString3;
                str2 = strOptString2;
                str3 = strOptString;
                str4 = strOptString6;
                if (Pattern.compile(".*\\<[^>]+>.*", 32).matcher(strOptString13).matches()) {
                    str5 = strOptString9;
                    String strReplace2 = strOptString13.replace("\\/", "/");
                    if (strReplace2.startsWith("[") || strReplace2.endsWith("]")) {
                        strReplace2 = strReplace2.replace("[", "").replace("]", "").replace("\"", "").replace("\\", "");
                    }
                    strReplace = new SpannableStringBuilder(Html.fromHtml(strReplace2, null, new C0074f.a())).toString();
                } else {
                    str5 = strOptString9;
                    strReplace = strOptString13.replace("[", "").replace("]", "").replace("\"", "").replace("\\", "");
                }
                str6 = strReplace;
            }
            String strOptString14 = this.f338a.optString("OptanonLogo");
            String strOptString15 = this.f338a.optString("BannerAdditionalDescription");
            this.f341d = this.f338a.optString("BannerAdditionalDescPlacement");
            C0123q c0123qM664b = new C0120n(context).m664b();
            this.f343f = c0123qM664b;
            if (c0123qM664b != null) {
                m472a(c0123qM664b.f792h);
                m468a(this.f343f.f793i, strOptString4, strOptString7, strOptString10);
                m468a(this.f343f.f794j, strOptString5, strOptString8, strOptString10);
                m468a(this.f343f.f795k, str4, str5, strOptString11);
                C0086b c0086bM475a = C0086b.m475a();
                C0107c c0107c = c0086bM475a.f367v;
                String strMo378b = c0107c.mo378b();
                C0107c c0107c2 = this.f343f.f795k;
                if (!C0048h.m305b(strMo378b)) {
                    c0107c2.f730c = strMo378b;
                    if (c0086bM475a.f364s) {
                        c0107c2.f731d = strMo378b;
                    }
                }
                String str7 = c0107c.f729b;
                if (!C0048h.m305b(str7)) {
                    c0107c2.f729b = str7;
                }
                m474a(this.f338a);
                if (C0048h.m305b(this.f343f.f785a)) {
                    this.f343f.f785a = str3;
                }
                m471a(this.f343f.f787c, str2);
                m471a(this.f343f.f789e, str);
                C0106b0 c0106b0 = this.f343f.f788d;
                m471a(c0106b0, strOptString12);
                String str8 = c0106b0.f726e;
                c0106b0.f727f = (str8 == null || C0048h.m305b(str8) || !this.f340c) ? 8 : 0;
                C0106b0 c0106b02 = this.f343f.f790f;
                m471a(c0106b02, str6);
                String str9 = c0106b02.f726e;
                c0106b02.f727f = (str9 == null || C0048h.m305b(str9) || !this.f340c) ? 8 : 0;
                m471a(this.f343f.f791g, strOptString15);
                C0118l c0118l = this.f343f.f798n;
                if (C0048h.m305b(c0118l.m650a())) {
                    c0118l.f761b = strOptString14;
                }
                C0117k c0117k = this.f343f.f796l;
                if (C0048h.m305b(c0117k.f755a.f726e)) {
                    c0117k.f755a.f726e = this.f338a.optString("BannerLinkText");
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error while parsing Banner data, error: " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m467a(C0107c c0107c, String str, C0086b c0086b) {
        String str2;
        if (c0086b.f364s) {
            c0107c.f731d = str;
            str2 = c0086b.f351f;
        } else {
            str2 = "";
            c0107c.f731d = "";
        }
        c0107c.f738k = str2;
    }

    /* JADX INFO: renamed from: a */
    public static void m468a(C0107c c0107c, String str, String str2, String str3) {
        if (C0048h.m305b(c0107c.mo376a())) {
            c0107c.f734g = str;
        }
        if (C0048h.m305b(c0107c.f729b)) {
            c0107c.f729b = str2;
        }
        C0086b c0086bM475a = C0086b.m475a();
        if (C0048h.m305b(c0107c.mo378b())) {
            c0107c.f730c = str3;
        }
        m467a(c0107c, str3, c0086bM475a);
        c0107c.mo377a((!C0026u.m181a(c0107c.f735h, false) || C0048h.m305b(c0107c.mo376a())) ? 8 : 0);
        c0107c.f736i = c0086bM475a.f350e;
        c0107c.f737j = c0086bM475a.f351f;
    }

    /* JADX INFO: renamed from: a */
    public final void m471a(C0106b0 c0106b0, String str) {
        if (C0048h.m305b(c0106b0.f724c)) {
            c0106b0.f724c = this.f339b;
        }
        if (C0048h.m305b(c0106b0.f726e)) {
            c0106b0.f726e = str;
        }
        c0106b0.f727f = C0048h.m305b(c0106b0.f726e) ? 8 : 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m474a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("BannerIABPartnersLink");
        C0117k c0117k = this.f343f.f797m;
        C0106b0 c0106b0 = c0117k.f755a;
        C0107c c0107c = new C0107c();
        if (C0048h.m305b(c0106b0.f726e)) {
            c0106b0.f726e = strOptString;
        }
        c0107c.f734g = c0106b0.f726e;
        int i = (C0026u.m181a(c0117k.f758d, false) && this.f340c) ? 0 : 8;
        c0117k.f757c = i;
        c0107c.f739l = i;
        C0086b c0086bM475a = C0086b.m475a();
        C0107c c0107c2 = c0086bM475a.f366u;
        String strMo378b = c0107c2.mo378b();
        if (C0048h.m305b(strMo378b)) {
            strMo378b = c0106b0.f724c;
            if (C0048h.m305b(strMo378b)) {
                strMo378b = jSONObject.optString("BannerLinksTextColor");
            }
        }
        c0107c.f730c = strMo378b;
        String str = c0107c2.f729b;
        C0107c c0107c3 = this.f343f.f795k;
        if (C0048h.m305b(str)) {
            str = c0107c3.f729b;
        }
        if (!C0048h.m305b(str)) {
            c0107c.f729b = str;
        }
        String str2 = c0107c3.f736i;
        if (str2 != null) {
            c0107c.f736i = str2;
        }
        String str3 = c0107c3.f737j;
        if (str3 != null) {
            c0107c.f737j = str3;
        }
        m467a(c0107c, strMo378b, c0086bM475a);
        this.f344g = c0107c;
    }
}
