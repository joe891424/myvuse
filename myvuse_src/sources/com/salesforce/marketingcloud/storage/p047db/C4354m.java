package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.events.C4157h;
import com.salesforce.marketingcloud.storage.InterfaceC4378n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.m */
/* JADX INFO: loaded from: classes6.dex */
public class C4354m extends AbstractC4343b implements InterfaceC4378n {

    /* JADX INFO: renamed from: g */
    public static final String f5672g = "triggers";

    /* JADX INFO: renamed from: h */
    private static final String f5673h = C4170g.m3197a("TriggerDbStorage");

    /* JADX INFO: renamed from: e */
    private final SQLiteStatement f5674e;

    /* JADX INFO: renamed from: f */
    private final SQLiteStatement f5675f;

    public C4354m(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        this.f5674e = sQLiteDatabase.compileStatement("UPDATE triggers SET app_open_count = app_open_count + 1 WHERE (start_date IS NULL OR start_date < ?)");
        this.f5675f = sQLiteDatabase.compileStatement("SELECT app_open_count FROM triggers WHERE id = ?");
    }

    /* JADX INFO: renamed from: c */
    private static boolean m4165c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,_key,start_date,_trigger,app_open_count FROM triggers");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    static boolean m4166d(SQLiteDatabase sQLiteDatabase) {
        boolean zM4165c = m4165c(sQLiteDatabase);
        if (zM4165c) {
            return zM4165c;
        }
        try {
            m4162a(sQLiteDatabase);
            m4163b(sQLiteDatabase);
            return m4165c(sQLiteDatabase);
        } catch (Exception e) {
            C4170g.m3207b(f5673h, e, "Unable to recover %s", f5672g);
            return zM4165c;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4378n
    /* JADX INFO: renamed from: a */
    public void mo4167a(C4157h c4157h) throws Exception {
        ContentValues contentValuesM4164c = m4164c(c4157h);
        if (m4028a(contentValuesM4164c, "id = ?", new String[]{c4157h.m3180h()}) == 0) {
            m4031a(contentValuesM4164c);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4378n
    /* JADX INFO: renamed from: b */
    public int mo4168b(C4157h c4157h) {
        if (c4157h != null) {
            try {
                this.f5675f.bindString(1, c4157h.m3180h());
                return (int) this.f5675f.simpleQueryForLong();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4378n
    /* JADX INFO: renamed from: g */
    public List<C4157h> mo4171g(String str) {
        ArrayList arrayList;
        Cursor cursorM4034a = m4034a(new String[]{"_trigger"}, "lower(_key) = lower(?) AND (start_date IS NULL OR start_date < ?)", new String[]{str, String.valueOf(System.currentTimeMillis())});
        try {
            if (cursorM4034a.moveToFirst()) {
                arrayList = new ArrayList(cursorM4034a.getCount());
                do {
                    arrayList.add(m4161a(cursorM4034a));
                } while (cursorM4034a.moveToNext());
            } else {
                arrayList = null;
            }
            return arrayList != null ? arrayList : Collections.emptyList();
        } finally {
            cursorM4034a.close();
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4378n
    /* JADX INFO: renamed from: k */
    public void mo4172k() {
        this.f5674e.bindString(1, String.valueOf(System.currentTimeMillis()));
        this.f5674e.execute();
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4378n
    /* JADX INFO: renamed from: m */
    public JSONArray mo4173m() {
        JSONArray jSONArray = new JSONArray();
        Cursor cursorM4033a = m4033a(new String[]{"_trigger", "app_open_count"}, (String) null);
        if (cursorM4033a != null) {
            try {
                if (cursorM4033a.moveToFirst()) {
                    int columnIndex = cursorM4033a.getColumnIndex("_trigger");
                    int columnIndex2 = cursorM4033a.getColumnIndex("app_open_count");
                    do {
                        try {
                            JSONObject jSONObject = new JSONObject(cursorM4033a.getString(columnIndex));
                            jSONObject.put("appOpenCount", cursorM4033a.getInt(columnIndex2));
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            C4170g.m3207b(f5673h, e, "Unable to read trigger information from cursor.", new Object[0]);
                        }
                    } while (cursorM4033a.moveToNext());
                }
            } finally {
                cursorM4033a.close();
            }
        }
        return jSONArray;
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return f5672g;
    }

    /* JADX INFO: renamed from: a */
    private static C4157h m4161a(Cursor cursor) {
        try {
            return new C4157h(new JSONObject(cursor.getString(cursor.getColumnIndex("_trigger"))));
        } catch (Exception e) {
            C4170g.m3207b(f5673h, e, "Unable to read trigger from DB", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    private static ContentValues m4164c(C4157h c4157h) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", c4157h.m3180h());
        contentValues.put("_key", c4157h.m3181i());
        contentValues.put("start_date", c4157h.m3184l() != null ? Long.valueOf(c4157h.m3184l().getTime()) : null);
        JSONObject jSONObjectM3185m = c4157h.m3185m();
        contentValues.put("_trigger", !(jSONObjectM3185m instanceof JSONObject) ? jSONObjectM3185m.toString() : JSONObjectInstrumentation.toString(jSONObjectM3185m));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4378n
    /* JADX INFO: renamed from: b */
    public C4157h mo4170b(String str) {
        Cursor cursorM4034a = m4034a(new String[]{"_trigger"}, "id = ?", new String[]{str});
        if (cursorM4034a != null) {
            c4157hM4161a = cursorM4034a.moveToFirst() ? m4161a(cursorM4034a) : null;
            cursorM4034a.close();
        }
        return c4157hM4161a;
    }

    /* JADX INFO: renamed from: a */
    static void m4162a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS triggers");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS triggers");
        }
    }

    /* JADX INFO: renamed from: b */
    static void m4163b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE triggers(id TEXT PRIMARY KEY, _key TEXT, start_date INTEGER DEFAULT NULL, _trigger TEXT, app_open_count INTEGER DEFAULT 0);");
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE triggers(id TEXT PRIMARY KEY, _key TEXT, start_date INTEGER DEFAULT NULL, _trigger TEXT, app_open_count INTEGER DEFAULT 0);");
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4378n
    /* JADX INFO: renamed from: b */
    public int mo4169b(Collection<String> collection) {
        if (collection.size() == 0) {
            return m4041i(null);
        }
        try {
            return m4029a(mo4026o(), collection);
        } catch (Exception unused) {
            C4170g.m3216e(f5673h, "Unable to clean up %s table.", mo4026o());
            return 0;
        }
    }
}
