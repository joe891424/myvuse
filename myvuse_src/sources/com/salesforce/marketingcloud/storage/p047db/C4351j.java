package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.firebase.messaging.Constants;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.internal.C4187j;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.storage.InterfaceC4376l;
import com.salesforce.marketingcloud.storage.p047db.C4349h;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import com.surajit.rnrg.RadialGradientManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.j */
/* JADX INFO: loaded from: classes6.dex */
public final class C4351j extends AbstractC4343b implements InterfaceC4376l {

    /* JADX INFO: renamed from: e */
    public static final String f5641e = "regions";

    /* JADX INFO: renamed from: f */
    public static final String f5642f = "region_messages";

    /* JADX INFO: renamed from: g */
    static final String f5643g = C4170g.m3197a("RegionDbStorage");

    public C4351j(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: b */
    private static void m4130b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE regions(id TEXT PRIMARY KEY, latitude TEXT, longitude TEXT, radius INTEGER, beacon_guid TEXT, beacon_major INTEGER, beacon_minor INTEGER, description TEXT, name TEXT, location_type INTEGER, is_inside SMALLINT);");
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE regions(id TEXT PRIMARY KEY, latitude TEXT, longitude TEXT, radius INTEGER, beacon_guid TEXT, beacon_major INTEGER, beacon_minor INTEGER, description TEXT, name TEXT, location_type INTEGER, is_inside SMALLINT);");
        }
    }

    /* JADX INFO: renamed from: c */
    static void m4132c(SQLiteDatabase sQLiteDatabase) {
        boolean z = sQLiteDatabase instanceof SQLiteDatabase;
        if (z) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS regions");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regions");
        }
        if (z) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS region_messages");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_messages");
        }
    }

    /* JADX INFO: renamed from: e */
    private static boolean m4134e(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT region_id,message_id FROM region_messages");
            return true;
        } catch (Exception e) {
            C4170g.m3217e(f5643g, e, "%s is invalid", f5642f);
            return false;
        }
    }

    /* JADX INFO: renamed from: g */
    static boolean m4136g(SQLiteDatabase sQLiteDatabase) {
        boolean zM4135f = m4135f(sQLiteDatabase);
        if (!zM4135f) {
            try {
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS regions");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regions");
                }
                m4130b(sQLiteDatabase);
                zM4135f = m4135f(sQLiteDatabase);
            } catch (Exception e) {
                C4170g.m3207b(f5643g, e, "Unable to recover %s", f5641e);
            }
        }
        boolean zM4134e = m4134e(sQLiteDatabase);
        if (zM4135f && !zM4134e) {
            try {
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS region_messages");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_messages");
                }
                m4129a(sQLiteDatabase);
                zM4134e = m4134e(sQLiteDatabase);
            } catch (Exception e2) {
                C4170g.m3207b(f5643g, e2, "Unable to recover %s", f5642f);
            }
        }
        return zM4135f && zM4134e;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: a */
    public void mo4139a(Region region, InterfaceC4384c interfaceC4384c) throws Exception {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        ContentValues contentValuesM4131c = m4131c(region, interfaceC4384c);
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabase, f5641e, null, contentValuesM4131c, 5);
        } else {
            sQLiteDatabase.insertWithOnConflict(f5641e, null, contentValuesM4131c, 5);
        }
        if (region.messages().isEmpty()) {
            return;
        }
        for (Message message : region.messages()) {
            SQLiteDatabase sQLiteDatabase2 = this.f5588c;
            ContentValues contentValuesM4128a = m4128a(region, message);
            if (sQLiteDatabase2 instanceof SQLiteDatabase) {
                SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabase2, f5642f, null, contentValuesM4128a, 5);
            } else {
                sQLiteDatabase2.insertWithOnConflict(f5642f, null, contentValuesM4128a, 5);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: d */
    public List<String> mo4142d(int i) {
        List<String> listEmptyList = Collections.emptyList();
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {String.valueOf(i)};
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery("SELECT id FROM regions WHERE location_type=?", strArr) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT id FROM regions WHERE location_type=?", strArr);
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                int columnIndex = cursorRawQuery.getColumnIndex("id");
                do {
                    arrayList.add(cursorRawQuery.getString(columnIndex));
                } while (cursorRawQuery.moveToNext());
                listEmptyList = arrayList;
            }
            cursorRawQuery.close();
        }
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: f */
    public int mo4143f(int i) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {String.valueOf(i)};
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.delete(f5641e, "location_type=?", strArr) : SQLiteInstrumentation.delete(sQLiteDatabase, f5641e, "location_type=?", strArr);
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: l */
    public void mo4144l() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_inside", (Integer) 0);
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.update(sQLiteDatabase, f5641e, contentValues, null, null);
        } else {
            sQLiteDatabase.update(f5641e, contentValues, null, null);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: m */
    public Region mo4145m(InterfaceC4384c interfaceC4384c) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {Region.MAGIC_REGION_ID};
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery("SELECT * FROM regions WHERE id=?", strArr) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM regions WHERE id=?", strArr);
        Region regionM3384a = null;
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                try {
                    regionM3384a = C4187j.m3384a(new LatLon(Double.valueOf(interfaceC4384c.mo4260b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(C4349h.a.f5610b)))).doubleValue(), Double.valueOf(interfaceC4384c.mo4260b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(C4349h.a.f5611c)))).doubleValue()), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(RadialGradientManager.PROP_RADIUS)));
                } catch (Exception e) {
                    C4170g.m3207b(f5643g, e, "Unable to read magic region from DB.", new Object[0]);
                }
            }
            cursorRawQuery.close();
        }
        return regionM3384a;
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return f5641e;
    }

    /* JADX INFO: renamed from: a */
    private static void m4129a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE region_messages (region_id TEXT,  message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE region_messages (region_id TEXT,  message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
        }
    }

    /* JADX INFO: renamed from: d */
    static void m4133d(SQLiteDatabase sQLiteDatabase) {
        m4130b(sQLiteDatabase);
        m4129a(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: f */
    private static boolean m4135f(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,latitude,longitude,radius,beacon_guid,beacon_major,beacon_minor,description,name,location_type,is_inside FROM regions");
            return true;
        } catch (Exception e) {
            C4170g.m3217e(f5643g, e, "%s is invalid", f5641e);
            return false;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: c */
    public List<String> mo4141c(String str, int i) {
        ArrayList arrayList;
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {str, String.valueOf(i)};
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery("SELECT message_id FROM region_messages INNER JOIN messages on region_messages.message_id = messages.id WHERE region_id = ? AND messages.message_type = ?", strArr) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT message_id FROM region_messages INNER JOIN messages on region_messages.message_id = messages.id WHERE region_id = ? AND messages.message_type = ?", strArr);
        if (cursorRawQuery.moveToFirst()) {
            arrayList = new ArrayList(cursorRawQuery.getCount());
            int columnIndex = cursorRawQuery.getColumnIndex(Constants.MessagePayloadKeys.MSGID_SERVER);
            do {
                arrayList.add(cursorRawQuery.getString(columnIndex));
            } while (cursorRawQuery.moveToNext());
        } else {
            arrayList = null;
        }
        cursorRawQuery.close();
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    /* JADX INFO: renamed from: c */
    private static ContentValues m4131c(Region region, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", region.m3630id());
        contentValues.put(C4349h.a.f5610b, interfaceC4384c.mo4259a(String.valueOf(region.center().latitude())));
        contentValues.put(C4349h.a.f5611c, interfaceC4384c.mo4259a(String.valueOf(region.center().longitude())));
        contentValues.put(RadialGradientManager.PROP_RADIUS, Integer.valueOf(region.radius()));
        contentValues.put("beacon_guid", interfaceC4384c.mo4259a(region.proximityUuid()));
        contentValues.put("beacon_major", Integer.valueOf(region.major()));
        contentValues.put("beacon_minor", Integer.valueOf(region.minor()));
        contentValues.put("description", interfaceC4384c.mo4259a(region.description()));
        contentValues.put("name", interfaceC4384c.mo4259a(region.name()));
        contentValues.put("location_type", Integer.valueOf(region.regionType()));
        contentValues.put("is_inside", Integer.valueOf(C4187j.m3386a(region) ? 1 : 0));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: a */
    public Region mo4137a(String str, InterfaceC4384c interfaceC4384c) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {str};
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery("SELECT * FROM regions WHERE id=?", strArr) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM regions WHERE id=?", strArr);
        if (cursorRawQuery != null) {
            regionM4048c = cursorRawQuery.moveToFirst() ? C4345d.m4048c(cursorRawQuery, interfaceC4384c) : null;
            cursorRawQuery.close();
        }
        return regionM4048c;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: a */
    public List<Region> mo4138a(int i, InterfaceC4384c interfaceC4384c) {
        List<Region> listEmptyList = Collections.emptyList();
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {String.valueOf(i)};
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery("SELECT * FROM regions WHERE location_type=?", strArr) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM regions WHERE location_type=?", strArr);
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                ArrayList arrayList = new ArrayList(cursorRawQuery.getCount());
                do {
                    Region regionM4048c = C4345d.m4048c(cursorRawQuery, interfaceC4384c);
                    if (regionM4048c != null) {
                        arrayList.add(regionM4048c);
                    }
                } while (cursorRawQuery.moveToNext());
                listEmptyList = arrayList;
            }
            cursorRawQuery.close();
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: a */
    private static ContentValues m4128a(Region region, Message message) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("region_id", region.m3630id());
        contentValues.put(Constants.MessagePayloadKeys.MSGID_SERVER, message.m3624id());
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4376l
    /* JADX INFO: renamed from: a */
    public void mo4140a(String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_inside", Integer.valueOf(z ? 1 : 0));
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {str};
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.update(sQLiteDatabase, f5641e, contentValues, "id=?", strArr);
        } else {
            sQLiteDatabase.update(f5641e, contentValues, "id=?", strArr);
        }
    }
}
