package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.analytics.stats.C4133b;
import com.salesforce.marketingcloud.analytics.stats.C4135d;
import com.salesforce.marketingcloud.storage.InterfaceC4341d;
import com.salesforce.marketingcloud.storage.p047db.C4342a;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.e */
/* JADX INFO: loaded from: classes6.dex */
public class C4346e extends AbstractC4343b implements InterfaceC4341d {

    /* JADX INFO: renamed from: e */
    static final String f5592e = "device_stats";

    /* JADX INFO: renamed from: f */
    private static final String f5593f = C4170g.m3197a("DeviceStatsDbStorage");

    public C4346e(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: b */
    static void m4057b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE device_stats(id INTEGER PRIMARY KEY, type INTEGER, date INTEGER, event_data TEXT, in_transit INTEGER DEFAULT 0, ready_to_send INTEGER DEFAULT 0);");
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE device_stats(id INTEGER PRIMARY KEY, type INTEGER, date INTEGER, event_data TEXT, in_transit INTEGER DEFAULT 0, ready_to_send INTEGER DEFAULT 0);");
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4341d
    /* JADX INFO: renamed from: a */
    public void mo4008a(C4133b c4133b, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValuesM4056b = m4056b(c4133b, interfaceC4384c);
        if (c4133b.m2988b() == null || m4028a(contentValuesM4056b, "id = ?", new String[]{c4133b.m2988b().toString()}) == 0) {
            m4031a(contentValuesM4056b);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4341d
    /* JADX INFO: renamed from: c */
    public void mo4009c(String[] strArr) {
        if (strArr.length > 0) {
            try {
                C4170g.m3210c(f5593f, "Deleted %d items of %d items", Integer.valueOf(strArr.length), Integer.valueOf(m4039c(Arrays.asList(strArr))));
            } catch (Exception unused) {
                C4170g.m3216e(f5593f, "Unable to clean up %s table.", mo4026o());
            }
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4341d
    /* JADX INFO: renamed from: d */
    public void mo4010d(String[] strArr) {
        if (strArr.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("in_transit", (Integer) 0);
            try {
                m4037a(contentValues, Arrays.asList(strArr));
            } catch (Exception unused) {
                C4170g.m3216e(f5593f, "Unable to update %s table.", mo4026o());
            }
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4341d
    /* JADX INFO: renamed from: f */
    public int mo4011f() {
        return m4041i(null);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4341d
    /* JADX INFO: renamed from: j */
    public List<C4133b> mo4012j(InterfaceC4384c interfaceC4384c) {
        List<C4133b> listEmptyList = Collections.emptyList();
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery("SELECT * FROM device_stats WHERE ready_to_send=0", null) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM device_stats WHERE ready_to_send=0", null);
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                ArrayList arrayList = new ArrayList(cursorRawQuery.getCount());
                do {
                    arrayList.add(m4053a(cursorRawQuery, interfaceC4384c));
                } while (cursorRawQuery.moveToNext());
                listEmptyList = arrayList;
            }
            cursorRawQuery.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4341d
    /* JADX INFO: renamed from: k */
    public List<C4133b> mo4013k(InterfaceC4384c interfaceC4384c) {
        return m4054a(interfaceC4384c, "SELECT * FROM device_stats WHERE ready_to_send=1 AND in_transit=0 AND type IN(100, 101, 102, 103, 104, 106, 107)");
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return f5592e;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4341d
    /* JADX INFO: renamed from: p */
    public List<C4133b> mo4014p(InterfaceC4384c interfaceC4384c) {
        return m4054a(interfaceC4384c, "SELECT * FROM device_stats WHERE ready_to_send=1 AND in_transit=0 AND type IN(105)");
    }

    /* JADX INFO: renamed from: a */
    private static C4133b m4053a(Cursor cursor, InterfaceC4384c interfaceC4384c) {
        try {
            int i = cursor.getInt(cursor.getColumnIndex("id"));
            int i2 = cursor.getInt(cursor.getColumnIndex("type"));
            Date date = new Date(cursor.getLong(cursor.getColumnIndex("date")));
            C4135d c4135dM2996a = C4135d.m2996a(interfaceC4384c.mo4260b(cursor.getString(cursor.getColumnIndex("event_data"))));
            boolean z = true;
            if (cursor.getInt(cursor.getColumnIndex(C4342a.a.f5582f)) != 1) {
                z = false;
            }
            return C4133b.m2983a(i, i2, date, c4135dM2996a, z);
        } catch (Exception e) {
            C4170g.m3207b(f5593f, e, "Unable to read analytic item from cursor.", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static ContentValues m4056b(C4133b c4133b, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValues = new ContentValues();
        if (c4133b.m2988b() != null) {
            contentValues.put("id", c4133b.m2988b());
        }
        contentValues.put("type", Integer.valueOf(c4133b.m2990d()));
        contentValues.put("date", Long.valueOf(c4133b.m2985a().getTime()));
        contentValues.put("event_data", interfaceC4384c.mo4259a(c4133b.m2989c().m3019a()));
        contentValues.put(C4342a.a.f5582f, Integer.valueOf(c4133b.m2991e() ? 1 : 0));
        return contentValues;
    }

    /* JADX INFO: renamed from: c */
    private static boolean m4058c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,type,date,event_data,in_transit,ready_to_send FROM device_stats");
            return true;
        } catch (Exception e) {
            C4170g.m3217e(f5593f, e, "%s is invalid", f5592e);
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    static boolean m4059d(SQLiteDatabase sQLiteDatabase) {
        boolean zM4058c = m4058c(sQLiteDatabase);
        if (zM4058c) {
            return zM4058c;
        }
        try {
            m4055a(sQLiteDatabase);
            m4057b(sQLiteDatabase);
            return m4058c(sQLiteDatabase);
        } catch (Exception e) {
            C4170g.m3207b(f5593f, e, "Unable to recover %s", f5592e);
            return zM4058c;
        }
    }

    /* JADX INFO: renamed from: a */
    static void m4055a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS device_stats");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_stats");
        }
    }

    /* JADX INFO: renamed from: a */
    private List<C4133b> m4054a(InterfaceC4384c interfaceC4384c, String str) {
        List<C4133b> listEmptyList = Collections.emptyList();
        this.f5588c.beginTransaction();
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery(str, null) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, str, null);
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                int count = cursorRawQuery.getCount();
                int columnIndex = cursorRawQuery.getColumnIndex("id");
                String[] strArr = new String[count];
                ArrayList arrayList = new ArrayList(count);
                int i = 0;
                while (true) {
                    arrayList.add(m4053a(cursorRawQuery, interfaceC4384c));
                    strArr[i] = cursorRawQuery.getString(columnIndex);
                    if (!cursorRawQuery.moveToNext()) {
                        break;
                    }
                    int i2 = i + 1;
                    if (i >= count) {
                        break;
                    }
                    i = i2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("in_transit", (Integer) 1);
                try {
                    m4037a(contentValues, Arrays.asList(strArr));
                    this.f5588c.setTransactionSuccessful();
                } catch (Exception unused) {
                    C4170g.m3216e(f5593f, "Unable to update %s table.", mo4026o());
                }
                listEmptyList = arrayList;
            }
            cursorRawQuery.close();
            this.f5588c.endTransaction();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4341d
    /* JADX INFO: renamed from: a */
    public int mo4007a() {
        try {
            return m4030a("(type = ? OR type = ?) AND in_transit = 0 AND date <= ?", new String[]{String.valueOf(106), String.valueOf(107), String.valueOf(System.currentTimeMillis() - 1209600000)});
        } catch (Exception e) {
            C4170g.m3207b(f5593f, e, "Unable to purge old debug/telemetry data.", new Object[0]);
            return 0;
        }
    }
}
