package com.salesforce.marketingcloud.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.provider.Settings;
import androidx.collection.ArrayMap;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.util.C4390i;
import com.salesforce.marketingcloud.util.C4391j;
import com.salesforce.marketingcloud.util.C4393l;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.e */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractC4367e {

    /* JADX INFO: renamed from: d */
    protected static final int f5691d = -1;

    /* JADX INFO: renamed from: e */
    private static final String f5692e = "DEFAULT_SHARED_PREFERENCES";

    /* JADX INFO: renamed from: f */
    private static final String f5693f = "et_207_preference_migration_complete";

    /* JADX INFO: renamed from: a */
    private final String f5695a;

    /* JADX INFO: renamed from: b */
    private final String f5696b;

    /* JADX INFO: renamed from: c */
    protected static final String f5690c = C4170g.m3197a("Storage");

    /* JADX INFO: renamed from: g */
    private static AtomicBoolean f5694g = new AtomicBoolean(false);

    AbstractC4367e(String str, String str2) {
        this.f5695a = (String) C4391j.m4325a((String) C4391j.m4326a(str, "Application ID is null."), "Application ID is empty.");
        this.f5696b = (String) C4391j.m4325a((String) C4391j.m4326a(str2, "Access Token is null."), "Access Token is empty.");
    }

    /* JADX INFO: renamed from: a */
    private Object m4209a(InterfaceC4384c interfaceC4384c, String str, Type type) {
        SharedPreferences sharedPreferences = mo4215a().getSharedPreferences("ETPush", 0);
        String str2 = null;
        try {
            String string = sharedPreferences.getString(String.format("%s_enc", str), null);
            if (string == null) {
                string = sharedPreferences.getString(str, null);
            }
            if (string != null) {
                try {
                    string = interfaceC4384c.mo4260b(string);
                    C4170g.m3210c(f5690c, "Found encrypted value for %s", str);
                } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
                    C4170g.m3210c(f5690c, "Found unencrypted value for %s", str);
                }
            }
            str2 = string;
        } catch (Exception unused2) {
        }
        return str2 != null ? str2 : m4210a(str, type);
    }

    /* JADX INFO: renamed from: b */
    private void m4212b(InterfaceC4384c interfaceC4384c) {
        Object objM4209a;
        boolean zBooleanValue;
        SharedPreferences.Editor editorEdit = mo4222f().edit();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("et_geo_enabled_key", Boolean.class);
        arrayMap.put("et_proximity_enabled_key", Boolean.class);
        arrayMap.put("et_push_enabled", Boolean.class);
        Iterator it2 = arrayMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String str = (String) entry.getKey();
            Type type = (Type) entry.getValue();
            String str2 = f5690c;
            C4170g.m3210c(str2, "Migrating %s ...", str);
            try {
                objM4209a = m4209a(interfaceC4384c, str, type);
            } catch (Exception e) {
                C4170g.m3207b(f5690c, e, "Unable to migrate %s", str);
            }
            if (objM4209a != null) {
                if (type == Boolean.class) {
                    if (objM4209a instanceof Boolean) {
                        zBooleanValue = ((Boolean) objM4209a).booleanValue();
                    } else if (objM4209a instanceof String) {
                        zBooleanValue = Boolean.valueOf((String) objM4209a).booleanValue();
                    } else {
                        C4170g.m3210c(str2, "Unknown Type for %s. Preference will not be migrated.", str);
                    }
                    editorEdit.putBoolean(str, zBooleanValue);
                } else {
                    C4170g.m3210c(str2, "Key '%s' with value of '%s' was not written to preferences.", str, objM4209a);
                }
            }
            C4170g.m3210c(str2, "Done with %s.", str);
        }
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: c */
    private void m4213c(InterfaceC4384c interfaceC4384c) {
        Map<String, String> mapM4348c;
        String[] strArr = {InterfaceC4340c.f5561c, InterfaceC4340c.f5560b, InterfaceC4340c.f5562d};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            try {
                String str2 = f5690c;
                C4170g.m3210c(str2, "Migrating %s ...", str);
                Object objM4209a = m4209a(interfaceC4384c, str, String.class);
                if (InterfaceC4340c.f5560b.equals(str) && (mapM4348c = C4393l.m4348c((String) objM4209a)) != null) {
                    mapM4348c.remove("_ETSDKVersion");
                    objM4209a = C4393l.m4337a(mapM4348c);
                }
                if (objM4209a == null || "null".equals(objM4209a)) {
                    C4170g.m3210c(str2, "Value was \"null\" and will not be migrated.", new Object[0]);
                } else {
                    C4170g.m3210c(str2, "Writing %s to encrypted preferences ...", str);
                    mo4220c().mo3930a(str, String.valueOf(objM4209a));
                }
                C4170g.m3210c(str2, "Done with %s.", str);
            } catch (Exception e) {
                C4170g.m3207b(f5690c, e, "Unable to migrate %s", str);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private String m4214d() {
        return C4393l.m4352e(Settings.Secure.getString(mo4215a().getContentResolver(), "android_id") + "-" + mo4215a().getPackageName());
    }

    /* JADX INFO: renamed from: a */
    protected abstract Context mo4215a();

    /* JADX INFO: renamed from: a */
    protected abstract void mo4216a(Context context, int i, int i2);

    /* JADX INFO: renamed from: b */
    public abstract InterfaceC4384c mo4218b();

    /* JADX INFO: renamed from: c */
    public abstract InterfaceC4340c mo4220c();

    /* JADX INFO: renamed from: e */
    protected abstract SQLiteOpenHelper mo4221e();

    /* JADX INFO: renamed from: f */
    public abstract SharedPreferences mo4222f();

    /* JADX INFO: renamed from: a */
    private Object m4210a(String str, Type type) {
        String[] strArr = {"ETPush", "et_registration_cache", "~!Registration", "~!ETPush", "~!ETLocationManager", "etpushSDK@ETPush", "etpushsdk@ETLocationManager", f5692e};
        for (int i = 0; i < 8; i++) {
            String str2 = strArr[i];
            SharedPreferences defaultSharedPreferences = f5692e.equals(str2) ? PreferenceManager.getDefaultSharedPreferences(mo4215a()) : mo4215a().getSharedPreferences(str2, 0);
            if (defaultSharedPreferences.contains(str)) {
                try {
                    if (type == Boolean.class) {
                        return Boolean.valueOf(defaultSharedPreferences.getBoolean(str, false));
                    }
                    if (type == String.class) {
                        return defaultSharedPreferences.getString(str, null);
                    }
                } catch (ClassCastException unused) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    protected final void m4219b(Context context, int i, int i2) {
        String[] strArrDatabaseList;
        if (i != -1 || (strArrDatabaseList = context.databaseList()) == null) {
            return;
        }
        for (String str : strArrDatabaseList) {
            if ("etdb.db".equals(str)) {
                m4211a(context, this.f5695a, this.f5696b);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final void m4217a(InterfaceC4384c interfaceC4384c) throws GeneralSecurityException, UnsupportedEncodingException {
        String str = f5690c;
        C4170g.m3210c(str, "Migrating SharedPreferences ...", new Object[0]);
        m4213c(interfaceC4384c);
        m4212b(interfaceC4384c);
        C4170g.m3210c(str, "Finished migrating SharedPreferences.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    private void m4211a(Context context, String str, String str2) {
        boolean andSet;
        boolean z;
        try {
            try {
                andSet = f5694g.getAndSet(true);
                z = mo4222f().getBoolean(f5693f, false);
            } catch (Exception e) {
                C4170g.m3207b(f5690c, e, "Data migration failed", new Object[0]);
            }
            if (!andSet && !z) {
                C4390i c4390i = new C4390i(context, str, str2, m4214d());
                try {
                    c4390i.mo4260b(context.getSharedPreferences("ETPush", 0).getString("et_device_id_cache_enc", null));
                    m4217a(c4390i);
                    C4170g.m3210c(f5690c, "Old data migrations completed without exception.", new Object[0]);
                } catch (Exception unused) {
                    C4170g.m3202a(f5690c, "Unable to verify old encryption.  Moving on without migrating data.", new Object[0]);
                }
            }
        } finally {
            mo4222f().edit().putBoolean(f5693f, true).apply();
            f5694g.set(false);
        }
    }
}
