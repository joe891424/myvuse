package p000a.p001a.p002a.p003a.p004a.p011i;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p028d.C0187b;

/* JADX INFO: renamed from: a.a.a.a.a.i.a */
/* JADX INFO: loaded from: classes.dex */
public class C0049a {

    /* JADX INFO: renamed from: a */
    public final Context f102a;

    public C0049a(Context context) {
        this.f102a = context;
    }

    /* JADX INFO: renamed from: a */
    public void m322a(String str, boolean z, boolean z2) {
        if (str == null || C0048h.m305b(str)) {
            OTLogger.m2743a(3, "DefaultSPHelper", "backupData called with empty currentActiveProfileId, back up failed.");
            return;
        }
        if (z) {
            OTLogger.m2743a(3, "DefaultSPHelper", "Taking backup of default shared preference data, profile id = " + str);
            OTLogger.m2743a(3, "DefaultSPHelper", "Clearing default shared preference keys after the back up completes. Flag = " + z2);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f102a);
            SharedPreferences.Editor editorEdit = this.f102a.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new C0052d(this.f102a).m343c(str.toLowerCase(Locale.US)), 0).edit();
            SharedPreferences.Editor editorEdit2 = z2 ? defaultSharedPreferences.edit() : null;
            m320a(defaultSharedPreferences, editorEdit, editorEdit2);
            editorEdit.apply();
            if (editorEdit2 != null) {
                editorEdit2.apply();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m324b(String str, boolean z, boolean z2) {
        try {
            m322a(str, z, z2);
        } catch (Exception e) {
            OTLogger.m2743a(6, "OTSDKExceptions", "Error on backupDataWithExceptionHandling,Error = " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m323b(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, SharedPreferences.Editor editor2) {
        Map<String, Integer> map = new C0187b(this.f102a).f1667b;
        if (map.keySet().isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            if (!C0048h.m305b(str)) {
                Integer num = map.get(str);
                if (Objects.equals(num, C0187b.f1664d)) {
                    if (sharedPreferences.contains(str)) {
                        editor.putInt(str, sharedPreferences.getInt(str, -1));
                        if (editor2 != null) {
                            editor2.remove(str);
                        }
                    }
                } else if (Objects.equals(num, C0187b.f1665e) && sharedPreferences.contains(str)) {
                    editor.putString(str, sharedPreferences.getString(str, ""));
                    if (editor2 != null) {
                        editor2.remove(str);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m320a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, SharedPreferences.Editor editor2) {
        if (sharedPreferences.contains(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING)) {
            editor.putString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, sharedPreferences.getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, ""));
            if (editor2 != null) {
                editor2.remove(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_CMPSDKID)) {
            editor.putInt(OTIABTCFKeys.IABTCF_CMPSDKID, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_CMPSDKID, -1));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_CMPSDKID);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_CMPSDKVERSION)) {
            editor.putInt(OTIABTCFKeys.IABTCF_CMPSDKVERSION, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_CMPSDKVERSION, -1));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_CMPSDKVERSION);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_POLICYVERSION)) {
            editor.putInt(OTIABTCFKeys.IABTCF_POLICYVERSION, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_POLICYVERSION, -1));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_POLICYVERSION);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_GDPRAPPLIES)) {
            editor.putInt(OTIABTCFKeys.IABTCF_GDPRAPPLIES, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_GDPRAPPLIES, -1));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_GDPRAPPLIES);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT)) {
            editor.putInt(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT, -1));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS)) {
            editor.putInt(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS, -1));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCC)) {
            editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCC, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCC, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCC);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCC)) {
            editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCC, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCC, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCC);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_TCSTRING)) {
            editor.putString(OTIABTCFKeys.IABTCF_TCSTRING, sharedPreferences.getString(OTIABTCFKeys.IABTCF_TCSTRING, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_TCSTRING);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_VENDORCONSENTS)) {
            editor.putString(OTIABTCFKeys.IABTCF_VENDORCONSENTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_VENDORCONSENTS, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_VENDORCONSENTS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS)) {
            editor.putString(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PURPOSECONSENTS)) {
            editor.putString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PURPOSECONSENTS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS)) {
            editor.putString(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS)) {
            editor.putString(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT)) {
            editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS)) {
            editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS)) {
            editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS)) {
            editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS);
            }
        }
        if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT)) {
            editor.putString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, sharedPreferences.getString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, ""));
            if (editor2 != null) {
                editor2.remove(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT);
            }
        }
        for (int i = 1; i <= 10; i++) {
            String str = OTIABTCFKeys.IABTCF_PUBLISHERRESTRICTIONS + String.valueOf(i);
            if (sharedPreferences.contains(str)) {
                editor.putString(str, sharedPreferences.getString(str, ""));
                if (editor2 != null) {
                    editor2.remove(str);
                }
            }
        }
        m323b(sharedPreferences, editor, editor2);
    }

    /* JADX INFO: renamed from: a */
    public void m321a(String str, boolean z) {
        if (z) {
            OTLogger.m2743a(3, "DefaultSPHelper", "Restore of default shared preference data, profile id = " + str);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f102a);
            SharedPreferences sharedPreferences = this.f102a.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new C0052d(this.f102a).m343c(str.toLowerCase(Locale.US)), 0);
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            m320a(sharedPreferences, editorEdit, (SharedPreferences.Editor) null);
            m323b(sharedPreferences, editorEdit, (SharedPreferences.Editor) null);
            editorEdit.apply();
        }
    }
}
