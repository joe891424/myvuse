package p000a.p001a.p002a.p003a.p004a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.salesforce.marketingcloud.sfmcsdk.components.http.NetworkManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
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

/* JADX INFO: renamed from: a.a.a.a.a.h */
/* JADX INFO: loaded from: classes.dex */
public class C0048h {
    /* JADX INFO: renamed from: a */
    public static int m296a(JSONArray jSONArray, int i) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (i == jSONArray.getInt(i2)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public static Date m299a(Date date) {
        Date date2 = new Date();
        return new Date(date2.getTime() - (date2.getTime() % NetworkManager.MAX_SERVER_RETRY));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m301a(Fragment fragment, String str) {
        if (str.equals("LAYER_1")) {
            return (fragment instanceof OTBannerFragment) || (fragment instanceof ViewOnClickListenerC0159e) || (fragment instanceof C0093d);
        }
        if (str.equals("LAYER_2")) {
            return (fragment instanceof ViewOnClickListenerC0158d) || (fragment instanceof OTVendorListFragment);
        }
        if (str.equals("LAYER_3")) {
            return (fragment instanceof ViewOnClickListenerC0168n) || (fragment instanceof OTSDKListFragment) || (fragment instanceof ViewOnClickListenerC0160f) || (fragment instanceof ViewOnClickListenerC0164j);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m302a(FragmentActivity fragmentActivity, String str) {
        Fragment fragmentFindFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
        return m301a(fragmentFindFragmentByTag, "LAYER_1") || m301a(fragmentFindFragmentByTag, "LAYER_2") || m301a(fragmentFindFragmentByTag, "LAYER_3");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m303a(String str, boolean z) {
        return m305b(str) ? z : Boolean.parseBoolean(str);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m305b(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m306b(String str, String str2) {
        if (m305b(str2)) {
            return false;
        }
        Locale locale = Locale.ENGLISH;
        return new JSONObject(str2.toLowerCase(locale)).has(str.toLowerCase(locale));
    }

    /* JADX INFO: renamed from: d */
    public static SimpleDateFormat m309d(String str) {
        return new SimpleDateFormat(str, Locale.getDefault(Locale.Category.FORMAT));
    }

    /* JADX INFO: renamed from: e */
    public static boolean m310e(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo != null) {
                String[] strArr = packageInfo.requestedPermissions;
                if (strArr == null) {
                    OTLogger.m2743a(3, "OTUtils", "App requestedPermissionsList is empty.");
                } else {
                    for (String str : strArr) {
                        if ("com.google.android.gms.permission.AD_ID".equalsIgnoreCase(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                OTLogger.m2743a(3, "GoogleAdInfo", "Is appRequestedGoogleAdPermission = " + z);
                return z;
            }
        } catch (PackageManager.NameNotFoundException e) {
            OTLogger.m2743a(6, "GoogleAdInfo", "Issue on reading PackageInfo for google ad permission. Error = " + e.getMessage());
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m313a(Context context, String str) {
        context.getSharedPreferences("com.onetrust.otpublishers.headless.preference" + str, 0).edit().clear().apply();
    }

    /* JADX INFO: renamed from: b */
    public String m314b(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(OTGppKeys.IAB_GPP_TCFEU2_STRING, "");
        if (m305b(string)) {
            string = defaultSharedPreferences.getString(OTIABTCFKeys.IABTCF_TCSTRING, "");
        }
        return m305b(string) ? "" : string;
    }

    /* JADX INFO: renamed from: c */
    public String m315c(Context context) {
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
        String string = sharedPreferences.getString("OT_SCRIPT_TYPE", "");
        return m305b(string) ? "" : string;
    }

    /* JADX INFO: renamed from: d */
    public String m316d(Context context) {
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
        String string = sharedPreferences.getString("OT_SYNC_GROUP_ID", "");
        return m305b(string) ? "" : string;
    }

    /* JADX INFO: renamed from: f */
    public boolean m317f(Context context) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
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
        return sharedPreferences.getBoolean("IS_IAB2_TEMPLATE", false);
    }

    /* JADX INFO: renamed from: g */
    public boolean m318g(Context context) {
        boolean z;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        String string = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
        if (m305b(string)) {
            string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
        }
        boolean zEqualsIgnoreCase = OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR.equalsIgnoreCase(string);
        if (!zEqualsIgnoreCase) {
            String string2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (m305b(string2)) {
                string2 = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            zEqualsIgnoreCase = OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN.equalsIgnoreCase(string2);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            z = false;
            sharedPreferencesC0047f = null;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        String string3 = sharedPreferences.getString("OT_MOBILE_DATA_OVERRIDE_THEME", null);
        if (!m305b(string3)) {
            OTLogger.m2743a(3, "OTUtils", "Mobile data, overrideTheme = " + string3);
            if (OTThemeConstants.NO_SDK_THEME_OVERRIDE.equalsIgnoreCase(string3)) {
                return false;
            }
            if (OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR.equalsIgnoreCase(string3)) {
                return true;
            }
        }
        return zEqualsIgnoreCase;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5 A[PHI: r5
      0x00b5: PHI (r5v2 java.lang.String) = (r5v0 java.lang.String), (r5v1 java.lang.String) binds: [B:22:0x00b3, B:25:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m319h(android.content.Context r8) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.C0048h.m319h(android.content.Context):void");
    }

    /* JADX INFO: renamed from: b */
    public static void m304b(Context context, String str) {
        String str2;
        try {
            Uri uri = Uri.parse(str);
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            if (C0170b.m959a(context, "OT_BANNERloadExternalURL")) {
                customTabsIntentBuild.launchUrl(context, uri);
            }
        } catch (ActivityNotFoundException unused) {
            str2 = "Could not load the url : URL passed may be invalid " + str;
            OTLogger.m2743a(6, "OneTrust", str2);
        } catch (Exception unused2) {
            str2 = "Could not find class androidx.browser.customtabs.CustomTabsIntent$Builder, add implementation 'androidx.browser:browser:{version}' to gradle file";
            OTLogger.m2743a(6, "OneTrust", str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public int m311a(Context context) {
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
        return sharedPreferences.getInt("OneTrustBannerShownToUser", -1);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m308c(String str) {
        if (m305b(str) || str.length() == 3) {
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(Locale.getISOLanguages()));
        HashSet hashSet2 = new HashSet(Arrays.asList(Locale.getISOCountries()));
        Locale[] availableLocales = Locale.getAvailableLocales();
        String[] strArr = new String[availableLocales.length + 1];
        for (int i = 0; i < availableLocales.length; i++) {
            strArr[i] = availableLocales[i].toString().replace("_", "-").trim();
        }
        HashSet hashSet3 = new HashSet(Arrays.asList(strArr));
        if (str.contains("-")) {
            try {
                String str2 = str.split("-")[1];
                Locale locale = Locale.ENGLISH;
                String upperCase = str2.toUpperCase(locale);
                if (!hashSet.contains(str.split("-")[0].toLowerCase(locale))) {
                    return false;
                }
                if (!hashSet2.contains(upperCase)) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                OTLogger.m2743a(3, "OTUtils", "Exception while validating language code, err: " + e.getMessage());
                return false;
            }
        } else {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (!hashSet3.contains(lowerCase) && !hashSet.contains(lowerCase)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static Date m297a(String str) {
        try {
            return new Date(str);
        } catch (Exception e) {
            OTLogger.m2743a(6, "OTUtils", "Error on converting tc string date on update, message = " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Date m298a(String str, String str2) {
        String str3;
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e) {
            str3 = "Error on converting tc string date, message = " + e.getMessage();
            OTLogger.m2743a(6, "OTUtils", str3);
            return null;
        } catch (Exception e2) {
            str3 = "Error on converting date. Error msg = " + e2.getMessage();
            OTLogger.m2743a(6, "OTUtils", str3);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m307c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).edit();
        editorEdit.putString("OT_UX_SDK_THEME", str);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: a */
    public void m312a(Context context, int i) {
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
        sharedPreferences.edit().putInt("OneTrustBannerShownToUser", i).apply();
    }

    /* JADX INFO: renamed from: a */
    public static void m300a(Context context, JSONObject jSONObject) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).edit();
        editorEdit.putString("OTT_UX_PARAMS_JSON", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        editorEdit.apply();
    }
}
