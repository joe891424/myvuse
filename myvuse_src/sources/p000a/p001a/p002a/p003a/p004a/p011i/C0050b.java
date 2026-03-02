package p000a.p001a.p002a.p003a.p004a.p011i;

import android.content.Context;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.Locale;
import org.json.JSONException;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.i.b */
/* JADX INFO: loaded from: classes.dex */
public class C0050b {

    /* JADX INFO: renamed from: a */
    public final C0045d f103a;

    /* JADX INFO: renamed from: b */
    public final Context f104b;

    public C0050b(Context context) {
        this.f104b = context;
        this.f103a = new C0045d(context, "OTT_DEFAULT_USER", false);
    }

    public C0050b(Context context, C0045d c0045d) {
        this.f104b = context;
        this.f103a = c0045d;
    }

    /* JADX INFO: renamed from: a */
    public boolean m325a(String str) {
        if (str == null || C0048h.m305b(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        this.f103a.m271a().edit().putString("OT_ACTIVE_PROFILE_ID", lowerCase).apply();
        OTLogger.m2743a(3, "MultiProfileFile", "Active profile set to = " + lowerCase);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m326a(String str, String str2, boolean z, boolean z2) {
        OTLogger.m2743a(3, "MultiProfileFile", "setProfile called, currentActiveProfileId = " + str + " , newProfileID = " + str2 + " , backupDefaultSharedPreferenceData = " + z + ", restoreDefaultSharedPreferenceData = " + z2);
        if (str2 != null && !C0048h.m305b(str2)) {
            String lowerCase = str2.toLowerCase(Locale.US);
            C0049a c0049a = new C0049a(this.f104b);
            if (lowerCase.equalsIgnoreCase(str)) {
                z = false;
                z2 = false;
            }
            c0049a.m324b(str, z, z);
            m325a(lowerCase);
            try {
                if (C0052d.m327a(str2, this.f103a)) {
                    return true;
                }
                try {
                    c0049a.m321a(lowerCase, z2);
                    return true;
                } catch (Exception e) {
                    OTLogger.m2743a(6, "OTSDKExceptions", "Error on restoreDataWithExceptionHandling,Error = " + e.getMessage());
                    return true;
                }
            } catch (JSONException e2) {
                OTLogger.m2743a(6, "MultiProfileFile", "Error on updating multi-profile id maps. Error = " + e2.getMessage());
            }
        }
        return false;
    }
}
