package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTCache;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.UUID;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.a.c.t */
/* JADX INFO: loaded from: classes.dex */
public class C0025t {
    /* JADX INFO: renamed from: a */
    public boolean m158a(Context context, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, OTCache oTCache) {
        if (C0026u.m181a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            String dataSubjectIdentifier = oTCache.getDataSubjectIdentifier();
            if (dataSubjectIdentifier == null) {
                OTLogger.m2743a(4, "OTCacheHandler", "setDataSubjectIdentifier: Pass a valid identifier.");
                return false;
            }
            OTLogger.m2743a(5, "OTCacheHandler", "This method is now deprecated and replaced with renameProfile().");
            return C0048h.m305b(dataSubjectIdentifier) ? oTPublishersHeadlessSDK.switchUserProfile(dataSubjectIdentifier) : oTPublishersHeadlessSDK.renameProfile("", dataSubjectIdentifier);
        }
        String dataSubjectIdentifier2 = oTCache.getDataSubjectIdentifier();
        if (dataSubjectIdentifier2 == null) {
            OTLogger.m2743a(4, "OTUtils", "setDataSubjectIdentifier: Pass a valid identifier.");
            return false;
        }
        C0014i c0014i = new C0014i(context);
        if (dataSubjectIdentifier2.isEmpty()) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            dataSubjectIdentifier2 = sharedPreferences.getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
            if (C0048h.m305b(dataSubjectIdentifier2)) {
                dataSubjectIdentifier2 = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", dataSubjectIdentifier2).apply();
            }
            OTLogger.m2743a(4, "OTUtils", "Generated identifier = " + dataSubjectIdentifier2);
            c0014i.m78a(1);
        } else {
            c0014i.m78a(2);
        }
        c0014i.m81a(dataSubjectIdentifier2);
        c0014i.m82b();
        return true;
    }
}
