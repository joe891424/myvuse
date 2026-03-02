package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.storage.InterfaceC4373i;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.h */
/* JADX INFO: loaded from: classes6.dex */
public final class C4349h extends AbstractC4343b implements InterfaceC4373i {

    /* JADX INFO: renamed from: e */
    public static final String f5605e = "location_table";

    /* JADX INFO: renamed from: f */
    private static final String f5606f = "CREATE TABLE location_table (id INTEGER PRIMARY KEY CHECK (id = 0), latitude VARCHAR, longitude VARCHAR );";

    /* JADX INFO: renamed from: g */
    private static final String[] f5607g = {"id", a.f5610b, a.f5611c};

    /* JADX INFO: renamed from: h */
    private static final String f5608h = C4170g.m3197a("LocationDbStorage");

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.h$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final String f5609a = "id";

        /* JADX INFO: renamed from: b */
        public static final String f5610b = "latitude";

        /* JADX INFO: renamed from: c */
        public static final String f5611c = "longitude";
    }

    public C4349h(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: a */
    static void m4107a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS location_table");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS location_table");
        }
    }

    /* JADX INFO: renamed from: b */
    static void m4108b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, f5606f);
        } else {
            sQLiteDatabase.execSQL(f5606f);
        }
    }

    /* JADX INFO: renamed from: c */
    private static boolean m4109c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement(C4344c.m4042a("SELECT %s FROM %s", TextUtils.join(",", f5607g), f5605e));
            return true;
        } catch (Exception e) {
            C4170g.m3217e(f5608h, e, "%s is invalid", f5605e);
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    static boolean m4110d(SQLiteDatabase sQLiteDatabase) {
        boolean zM4109c = m4109c(sQLiteDatabase);
        if (zM4109c) {
            return zM4109c;
        }
        try {
            m4107a(sQLiteDatabase);
            m4108b(sQLiteDatabase);
            return m4109c(sQLiteDatabase);
        } catch (Exception e) {
            C4170g.m3207b(f5608h, e, "Unable to recover %s", f5605e);
            return zM4109c;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4373i
    /* JADX INFO: renamed from: f */
    public LatLon mo4112f(InterfaceC4384c interfaceC4384c) {
        Cursor cursorM4034a = m4034a(f5607g, String.format(Locale.ENGLISH, "%s = ?", "id"), new String[]{"0"});
        LatLon latLon = null;
        if (cursorM4034a != null) {
            if (cursorM4034a.moveToFirst()) {
                try {
                    latLon = new LatLon(Double.valueOf(interfaceC4384c.mo4260b(cursorM4034a.getString(cursorM4034a.getColumnIndex(a.f5610b)))).doubleValue(), Double.valueOf(interfaceC4384c.mo4260b(cursorM4034a.getString(cursorM4034a.getColumnIndex(a.f5611c)))).doubleValue());
                } catch (Exception e) {
                    C4170g.m3207b(f5608h, e, "Unable to read location from database.", new Object[0]);
                }
            }
            cursorM4034a.close();
        }
        return latLon;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4373i
    /* JADX INFO: renamed from: g */
    public int mo4113g() {
        return m4041i(null);
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return f5605e;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4373i
    /* JADX INFO: renamed from: a */
    public void mo4111a(LatLon latLon, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", (Integer) 0);
        contentValues.put(a.f5610b, interfaceC4384c.mo4259a(Double.toString(latLon.latitude())));
        contentValues.put(a.f5611c, interfaceC4384c.mo4259a(Double.toString(latLon.longitude())));
        if (m4028a(contentValues, String.format(Locale.ENGLISH, "%s = ?", "id"), new String[]{"0"}) == 0) {
            m4031a(contentValues);
        }
    }
}
