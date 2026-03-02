package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.internal.C4188k;
import com.salesforce.marketingcloud.registration.Registration;
import com.salesforce.marketingcloud.storage.InterfaceC4377m;
import com.salesforce.marketingcloud.util.C4393l;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.k */
/* JADX INFO: loaded from: classes6.dex */
public final class C4352k extends AbstractC4343b implements InterfaceC4377m {

    /* JADX INFO: renamed from: e */
    public static final String f5644e = "registration";

    /* JADX INFO: renamed from: f */
    private static final String[] f5645f = {"id", "platform", a.f5649c, a.f5650d, a.f5651e, a.f5652f, a.f5653g, a.f5654h, a.f5655i, a.f5656j, a.f5657k, a.f5658l, a.f5659m, a.f5661o, a.f5662p, a.f5663q, a.f5664r, a.f5665s, "locale"};

    /* JADX INFO: renamed from: g */
    private static final String f5646g = "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, proximity_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, signed_string VARCHAR, locale VARCHAR );";

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.k$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final String f5647a = "id";

        /* JADX INFO: renamed from: b */
        public static final String f5648b = "platform";

        /* JADX INFO: renamed from: c */
        public static final String f5649c = "subscriber_key";

        /* JADX INFO: renamed from: d */
        public static final String f5650d = "et_app_id";

        /* JADX INFO: renamed from: e */
        public static final String f5651e = "timezone";

        /* JADX INFO: renamed from: f */
        public static final String f5652f = "dst";

        /* JADX INFO: renamed from: g */
        public static final String f5653g = "tags";

        /* JADX INFO: renamed from: h */
        public static final String f5654h = "attributes";

        /* JADX INFO: renamed from: i */
        public static final String f5655i = "platform_version";

        /* JADX INFO: renamed from: j */
        public static final String f5656j = "push_enabled";

        /* JADX INFO: renamed from: k */
        public static final String f5657k = "location_enabled";

        /* JADX INFO: renamed from: l */
        public static final String f5658l = "proximity_enabled";

        /* JADX INFO: renamed from: m */
        public static final String f5659m = "hwid";

        /* JADX INFO: renamed from: n */
        public static final String f5660n = "locale";

        /* JADX INFO: renamed from: o */
        public static final String f5661o = "system_token";

        /* JADX INFO: renamed from: p */
        public static final String f5662p = "device_id";

        /* JADX INFO: renamed from: q */
        public static final String f5663q = "app_version";

        /* JADX INFO: renamed from: r */
        public static final String f5664r = "sdk_version";

        /* JADX INFO: renamed from: s */
        public static final String f5665s = "signed_string";
    }

    public C4352k(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: b */
    static void m4148b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, f5646g);
        } else {
            sQLiteDatabase.execSQL(f5646g);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4377m
    /* JADX INFO: renamed from: a */
    public void mo4151a(Registration registration, InterfaceC4384c interfaceC4384c) throws Exception {
        C4188k.m3392a(registration, (int) m4031a(m4149c(registration, interfaceC4384c)));
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4377m
    /* JADX INFO: renamed from: c */
    public int mo4153c() {
        return m4041i(m4146a("%1$s NOT IN ( SELECT %1$s FROM ( SELECT %1$s FROM %2$s ORDER BY %1$s DESC LIMIT 1))", "id", mo4026o()));
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4377m
    /* JADX INFO: renamed from: l */
    public Registration mo4154l(InterfaceC4384c interfaceC4384c) throws Exception {
        Cursor cursorM4036a = m4036a(f5645f, null, null, null, null, m4146a("%s DESC", "id"), "1");
        if (cursorM4036a != null) {
            registrationM4049d = cursorM4036a.moveToFirst() ? C4345d.m4049d(cursorM4036a, interfaceC4384c) : null;
            cursorM4036a.close();
        }
        return registrationM4049d;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4377m
    /* JADX INFO: renamed from: n */
    public int mo4155n() {
        return m4041i(null);
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return f5644e;
    }

    /* JADX INFO: renamed from: a */
    static void m4147a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS registration");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
        }
    }

    /* JADX INFO: renamed from: c */
    static boolean m4150c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement(m4146a("SELECT %s FROM %s", TextUtils.join(",", f5645f), f5644e));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4377m
    /* JADX INFO: renamed from: b */
    public int mo4152b(Registration registration, InterfaceC4384c interfaceC4384c) throws Exception {
        return m4028a(m4149c(registration, interfaceC4384c), m4146a("%s = ?", "id"), new String[]{String.valueOf(C4188k.m3390a(registration))});
    }

    /* JADX INFO: renamed from: a */
    private static String m4146a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* JADX INFO: renamed from: c */
    private static ContentValues m4149c(Registration registration, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.f5649c, interfaceC4384c.mo4259a(registration.contactKey()));
        contentValues.put(a.f5665s, interfaceC4384c.mo4259a(registration.signedString()));
        contentValues.put(a.f5650d, interfaceC4384c.mo4259a(registration.appId()));
        contentValues.put(a.f5661o, interfaceC4384c.mo4259a(registration.systemToken()));
        contentValues.put(a.f5653g, interfaceC4384c.mo4259a(C4393l.m4338a(registration.tags())));
        contentValues.put(a.f5654h, interfaceC4384c.mo4259a(C4393l.m4337a(registration.attributes())));
        contentValues.put(a.f5662p, registration.deviceId());
        contentValues.put("platform", registration.platform());
        contentValues.put(a.f5651e, Integer.valueOf(registration.timeZone()));
        contentValues.put(a.f5652f, Integer.valueOf(registration.dst() ? 1 : 0));
        contentValues.put(a.f5655i, registration.platformVersion());
        contentValues.put(a.f5656j, Integer.valueOf(registration.pushEnabled() ? 1 : 0));
        contentValues.put(a.f5657k, Integer.valueOf(registration.locationEnabled() ? 1 : 0));
        contentValues.put(a.f5658l, Integer.valueOf(registration.proximityEnabled() ? 1 : 0));
        contentValues.put(a.f5659m, registration.hwid());
        contentValues.put("locale", registration.locale());
        contentValues.put(a.f5663q, registration.appVersion());
        contentValues.put(a.f5664r, registration.sdkVersion());
        return contentValues;
    }
}
