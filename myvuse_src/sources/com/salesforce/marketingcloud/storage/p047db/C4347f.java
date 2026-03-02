package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.internal.C4178a;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.storage.InterfaceC4371g;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.f */
/* JADX INFO: loaded from: classes6.dex */
public class C4347f extends AbstractC4343b implements InterfaceC4371g {

    /* JADX INFO: renamed from: e */
    public static final String f5594e = "in_app_messages";

    /* JADX INFO: renamed from: f */
    public static final String f5595f = "iam_state";

    /* JADX INFO: renamed from: g */
    public static final String f5596g = "iam_view";

    /* JADX INFO: renamed from: h */
    public static final String f5597h = "iam_state_init";

    /* JADX INFO: renamed from: i */
    private static final String f5598i = C4170g.m3197a("InAppMessageDbStorage");

    /* JADX INFO: renamed from: j */
    private static final String f5599j = "id IN (%s) AND (display_count < display_limit) AND (start_date IS NULL OR start_date < ?) AND (end_date IS NULL OR end_date > ?) ORDER BY   priority ASC,  modified_date DESC LIMIT 1";

    public C4347f(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: b */
    private static void m4064b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TRIGGER iam_state_init AFTER INSERT ON in_app_messages BEGIN INSERT INTO iam_state (id) VALUES (NEW.id); END;");
        } else {
            sQLiteDatabase.execSQL("CREATE TRIGGER iam_state_init AFTER INSERT ON in_app_messages BEGIN INSERT INTO iam_state (id) VALUES (NEW.id); END;");
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m4065c(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE VIEW iam_view AS SELECT in_app_messages.id,in_app_messages.priority,in_app_messages.start_date,in_app_messages.end_date,in_app_messages.modified_date,in_app_messages.display_limit,in_app_messages.message_json,iam_state.display_count FROM in_app_messages INNER JOIN iam_state ON iam_state.id = in_app_messages.id;");
        } else {
            sQLiteDatabase.execSQL("CREATE VIEW iam_view AS SELECT in_app_messages.id,in_app_messages.priority,in_app_messages.start_date,in_app_messages.end_date,in_app_messages.modified_date,in_app_messages.display_limit,in_app_messages.message_json,iam_state.display_count FROM in_app_messages INNER JOIN iam_state ON iam_state.id = in_app_messages.id;");
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m4066d(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE in_app_messages(id TEXT PRIMARY KEY, priority INTEGER DEFAULT 999, start_date INTEGER DEFAULT NULL, end_date INTEGER DEFAULT NULL, modified_date INTEGER DEFAULT NULL, display_limit INTEGER DEFAULT 1, media_url TEXT DEFAULT NULL, message_json TEXT);");
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE in_app_messages(id TEXT PRIMARY KEY, priority INTEGER DEFAULT 999, start_date INTEGER DEFAULT NULL, end_date INTEGER DEFAULT NULL, modified_date INTEGER DEFAULT NULL, display_limit INTEGER DEFAULT 1, media_url TEXT DEFAULT NULL, message_json TEXT);");
        }
    }

    /* JADX INFO: renamed from: e */
    static void m4067e(SQLiteDatabase sQLiteDatabase) {
        m4070h(sQLiteDatabase);
        m4068f(sQLiteDatabase);
        m4069g(sQLiteDatabase);
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TRIGGER IF EXISTS iam_state_init");
        } else {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS iam_state_init");
        }
    }

    /* JADX INFO: renamed from: f */
    private static void m4068f(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS iam_state");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS iam_state");
        }
    }

    /* JADX INFO: renamed from: g */
    private static void m4069g(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP VIEW IF EXISTS iam_view");
        } else {
            sQLiteDatabase.execSQL("DROP VIEW IF EXISTS iam_view");
        }
    }

    /* JADX INFO: renamed from: h */
    private static void m4070h(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS in_app_messages");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS in_app_messages");
        }
    }

    /* JADX INFO: renamed from: i */
    static void m4071i(SQLiteDatabase sQLiteDatabase) {
        m4066d(sQLiteDatabase);
        m4061a(sQLiteDatabase);
        m4064b(sQLiteDatabase);
        m4065c(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: j */
    private static boolean m4072j(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,display_count FROM iam_state");
            return false;
        } catch (Exception e) {
            C4170g.m3217e(f5598i, e, "%s is invalid", f5595f);
            return true;
        }
    }

    /* JADX INFO: renamed from: k */
    private static boolean m4073k(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,priority,start_date,end_date,modified_date,display_limit,media_url,message_json FROM in_app_messages");
            return false;
        } catch (Exception e) {
            C4170g.m3217e(f5598i, e, "%s is invalid", f5594e);
            return true;
        }
    }

    /* JADX INFO: renamed from: l */
    private static boolean m4074l(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.compileStatement("SELECT id,priority,start_date,end_date,modified_date,display_limit,message_json,display_count FROM iam_view");
            return false;
        } catch (Exception e) {
            C4170g.m3217e(f5598i, e, "%s is invalid", f5596g);
            return true;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(5:4|61|5|11|(1:13))|16|(5:18|59|19|25|(1:27)(1:28))(1:31)|32|(4:70|34|38|(1:40))|41|(4:68|43|47|(1:49))(2:(0)|58)|64|51|(1:53)(1:54)|63|58|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b8, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b9, code lost:
    
        com.salesforce.marketingcloud.C4170g.m3207b(com.salesforce.marketingcloud.storage.p047db.C4347f.f5598i, r8, "Unable to correct relationship between iam data and iam state.", new java.lang.Object[r2]);
        r2 = "Unable to correct relationship between iam data and iam state.";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00b9 -> B:63:0x00c2). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean m4075m(android.database.sqlite.SQLiteDatabase r8) {
        /*
            boolean r0 = m4073k(r8)
            java.lang.String r1 = "Unable to recover %s"
            r2 = 0
            if (r0 == 0) goto L32
            r8.beginTransaction()
            m4070h(r8)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L18
            m4066d(r8)     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L18
            r8.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L16 java.lang.Exception -> L18
            goto L24
        L16:
            r0 = move-exception
            goto L2e
        L18:
            r0 = move-exception
            java.lang.String r3 = com.salesforce.marketingcloud.storage.p047db.C4347f.f5598i     // Catch: java.lang.Throwable -> L16
            java.lang.String r4 = "in_app_messages"
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.Throwable -> L16
            com.salesforce.marketingcloud.C4170g.m3207b(r3, r0, r1, r4)     // Catch: java.lang.Throwable -> L16
        L24:
            r8.endTransaction()
            boolean r0 = m4073k(r8)
            if (r0 == 0) goto L32
            return r2
        L2e:
            r8.endTransaction()
            throw r0
        L32:
            boolean r0 = m4072j(r8)
            r3 = 1
            if (r0 == 0) goto L64
            r8.beginTransaction()
            m4068f(r8)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            m4061a(r8)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r8.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            goto L54
        L46:
            r0 = move-exception
            goto L60
        L48:
            r0 = move-exception
            java.lang.String r4 = com.salesforce.marketingcloud.storage.p047db.C4347f.f5598i     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "iam_state"
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Throwable -> L46
            com.salesforce.marketingcloud.C4170g.m3207b(r4, r0, r1, r5)     // Catch: java.lang.Throwable -> L46
        L54:
            r8.endTransaction()
            boolean r0 = m4072j(r8)
            if (r0 == 0) goto L5e
            return r2
        L5e:
            r0 = r3
            goto L65
        L60:
            r8.endTransaction()
            throw r0
        L64:
            r0 = r2
        L65:
            boolean r4 = m4074l(r8)
            if (r4 == 0) goto L85
            m4069g(r8)     // Catch: java.lang.Exception -> L72
            m4065c(r8)     // Catch: java.lang.Exception -> L72
            goto L7e
        L72:
            r4 = move-exception
            java.lang.String r5 = com.salesforce.marketingcloud.storage.p047db.C4347f.f5598i
            java.lang.String r6 = "iam_view"
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            com.salesforce.marketingcloud.C4170g.m3207b(r5, r4, r1, r6)
        L7e:
            boolean r4 = m4074l(r8)
            if (r4 == 0) goto L85
            return r2
        L85:
            java.lang.String r4 = "trigger"
            java.lang.String r5 = "iam_state_init"
            boolean r6 = com.salesforce.marketingcloud.storage.p047db.C4344c.m4043a(r8, r4, r5)
            if (r6 == 0) goto La5
            m4064b(r8)     // Catch: java.lang.Exception -> L94
            goto L9e
        L94:
            r0 = move-exception
            java.lang.String r6 = com.salesforce.marketingcloud.storage.p047db.C4347f.f5598i
            java.lang.Object[] r7 = new java.lang.Object[]{r5}
            com.salesforce.marketingcloud.C4170g.m3207b(r6, r0, r1, r7)
        L9e:
            boolean r0 = com.salesforce.marketingcloud.storage.p047db.C4344c.m4043a(r8, r4, r5)
            if (r0 == 0) goto La7
            return r2
        La5:
            if (r0 == 0) goto Lc2
        La7:
            java.lang.String r0 = "INSERT OR IGNORE INTO iam_state(id) SELECT id FROM in_app_messages;"
            boolean r1 = r8 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Exception -> Lb8
            if (r1 != 0) goto Lb1
            r8.execSQL(r0)     // Catch: java.lang.Exception -> Lb8
            goto Lc2
        Lb1:
            r1 = r8
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch: java.lang.Exception -> Lb8
            com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.execSQL(r8, r0)     // Catch: java.lang.Exception -> Lb8
            goto Lc2
        Lb8:
            r8 = move-exception
            java.lang.String r0 = com.salesforce.marketingcloud.storage.p047db.C4347f.f5598i
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = "Unable to correct relationship between iam data and iam state."
            com.salesforce.marketingcloud.C4170g.m3207b(r0, r8, r2, r1)
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.storage.p047db.C4347f.m4075m(android.database.sqlite.SQLiteDatabase):boolean");
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4371g
    /* JADX INFO: renamed from: a */
    public int mo4076a(InAppMessage inAppMessage, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValuesM4062b = m4062b(inAppMessage, interfaceC4384c);
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String[] strArr = {inAppMessage.m3690id()};
        if ((!(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.update(f5594e, contentValuesM4062b, "id = ?", strArr) : SQLiteInstrumentation.update(sQLiteDatabase, f5594e, contentValuesM4062b, "id = ?", strArr)) != 0) {
            return 2;
        }
        SQLiteDatabase sQLiteDatabase2 = this.f5588c;
        if (sQLiteDatabase2 instanceof SQLiteDatabase) {
            SQLiteInstrumentation.insert(sQLiteDatabase2, f5594e, null, contentValuesM4062b);
            return 1;
        }
        sQLiteDatabase2.insert(f5594e, null, contentValuesM4062b);
        return 1;
    }

    @Override // com.salesforce.marketingcloud.storage.p047db.AbstractC4343b
    /* JADX INFO: renamed from: o */
    String mo4026o() {
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static void m4061a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE iam_state(id TEXT PRIMARY KEY, display_count integer default 0, FOREIGN KEY (id) REFERENCES in_app_messages(id) ON DELETE CASCADE);");
        } else {
            sQLiteDatabase.execSQL("CREATE TABLE iam_state(id TEXT PRIMARY KEY, display_count integer default 0, FOREIGN KEY (id) REFERENCES in_app_messages(id) ON DELETE CASCADE);");
        }
    }

    /* JADX INFO: renamed from: b */
    private static InAppMessage m4063b(Cursor cursor, InterfaceC4384c interfaceC4384c) {
        try {
            return new InAppMessage(new JSONObject(interfaceC4384c.mo4260b(cursor.getString(cursor.getColumnIndex("message_json")))));
        } catch (Exception e) {
            C4170g.m3207b(f5598i, e, "Unable to retrieve InAppMessage from db cursor", new Object[0]);
            return null;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4371g
    /* JADX INFO: renamed from: d */
    public JSONArray mo4082d(InterfaceC4384c interfaceC4384c) {
        JSONArray jSONArray = new JSONArray();
        Cursor cursorM4032a = m4032a(f5596g, new String[]{"message_json", "display_count"}, null, null);
        if (cursorM4032a != null) {
            try {
                if (cursorM4032a.moveToFirst()) {
                    int columnIndex = cursorM4032a.getColumnIndex("message_json");
                    int columnIndex2 = cursorM4032a.getColumnIndex("display_count");
                    do {
                        try {
                            JSONObject jSONObject = new JSONObject(interfaceC4384c.mo4260b(cursorM4032a.getString(columnIndex)));
                            jSONObject.put("displayCount", cursorM4032a.getInt(columnIndex2));
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            C4170g.m3207b(f5598i, e, "Unable to read message information from cursor.", new Object[0]);
                        }
                    } while (cursorM4032a.moveToNext());
                }
            } finally {
                cursorM4032a.close();
            }
        }
        return jSONArray;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4371g
    /* JADX INFO: renamed from: e */
    public List<String> mo4083e(InterfaceC4384c interfaceC4384c) {
        ArrayList arrayList = null;
        Cursor cursorM4032a = m4032a(f5594e, new String[]{"media_url"}, "media_url IS NOT NULL", null);
        try {
            if (cursorM4032a.moveToFirst()) {
                arrayList = new ArrayList(cursorM4032a.getCount());
                do {
                    String strM4060a = m4060a(cursorM4032a, interfaceC4384c);
                    if (strM4060a != null) {
                        arrayList.add(strM4060a);
                    }
                } while (cursorM4032a.moveToNext());
            }
            return arrayList != null ? arrayList : Collections.emptyList();
        } finally {
            cursorM4032a.close();
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m4060a(Cursor cursor, InterfaceC4384c interfaceC4384c) {
        try {
            return interfaceC4384c.mo4260b(cursor.getString(cursor.getColumnIndex("media_url")));
        } catch (Exception e) {
            C4170g.m3207b(f5598i, e, "Unable to retrieve media_url from db cursor", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static ContentValues m4062b(InAppMessage inAppMessage, InterfaceC4384c interfaceC4384c) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", inAppMessage.m3690id());
        contentValues.put("priority", Integer.valueOf(inAppMessage.priority()));
        contentValues.put("start_date", inAppMessage.startDateUtc() != null ? Long.valueOf(inAppMessage.startDateUtc().getTime()) : null);
        contentValues.put("end_date", inAppMessage.endDateUtc() != null ? Long.valueOf(inAppMessage.endDateUtc().getTime()) : null);
        contentValues.put("modified_date", Long.valueOf(inAppMessage.modifiedDateUtc().getTime()));
        contentValues.put("display_limit", Integer.valueOf(inAppMessage.displayLimit()));
        InAppMessage.Media media = inAppMessage.media();
        if (media != null && !TextUtils.isEmpty(media.url())) {
            contentValues.put("media_url", interfaceC4384c.mo4259a(media.url()));
        }
        JSONObject jSONObjectM3326b = C4178a.m3326b(inAppMessage);
        contentValues.put("message_json", interfaceC4384c.mo4259a(!(jSONObjectM3326b instanceof JSONObject) ? jSONObjectM3326b.toString() : JSONObjectInstrumentation.toString(jSONObjectM3326b)));
        return contentValues;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4371g
    /* JADX INFO: renamed from: a */
    public InAppMessage mo4078a(String str, InterfaceC4384c interfaceC4384c) {
        Cursor cursorM4032a = m4032a(f5594e, new String[]{"message_json"}, "id = ?", new String[]{str});
        if (cursorM4032a != null) {
            inAppMessageM4063b = cursorM4032a.moveToFirst() ? m4063b(cursorM4032a, interfaceC4384c) : null;
            cursorM4032a.close();
        }
        return inAppMessageM4063b;
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4371g
    /* JADX INFO: renamed from: b */
    public void mo4081b(String str, int i) {
        if (str == null || i < 0) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        Object[] objArr = {Integer.valueOf(i), str};
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "UPDATE iam_state SET display_count = MAX(display_count, ?) WHERE id = ?", objArr);
        } else {
            sQLiteDatabase.execSQL("UPDATE iam_state SET display_count = MAX(display_count, ?) WHERE id = ?", objArr);
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4371g
    /* JADX INFO: renamed from: a */
    public void mo4080a(InAppMessage inAppMessage) {
        if (inAppMessage != null) {
            SQLiteDatabase sQLiteDatabase = this.f5588c;
            String[] strArr = {inAppMessage.m3690id()};
            if (sQLiteDatabase instanceof SQLiteDatabase) {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "UPDATE iam_state SET display_count = display_count + 1 WHERE id = ?", strArr);
            } else {
                sQLiteDatabase.execSQL("UPDATE iam_state SET display_count = display_count + 1 WHERE id = ?", strArr);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4371g
    /* JADX INFO: renamed from: a */
    public int mo4077a(Collection<String> collection) {
        if (collection.size() == 0) {
            SQLiteDatabase sQLiteDatabase = this.f5588c;
            return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.delete(f5594e, null, null) : SQLiteInstrumentation.delete(sQLiteDatabase, f5594e, null, null);
        }
        try {
            return m4029a(f5594e, collection);
        } catch (SQLException unused) {
            C4170g.m3216e(f5598i, "Unable to clean up %s table.", f5594e);
            return 0;
        }
    }

    @Override // com.salesforce.marketingcloud.storage.InterfaceC4371g
    /* JADX INFO: renamed from: a */
    public InAppMessage mo4079a(Collection<String> collection, InterfaceC4384c interfaceC4384c) {
        if (collection.size() > 0) {
            this.f5588c.beginTransaction();
            m4038b(f5596g, collection);
            String strM4042a = C4344c.m4042a(f5599j, C4344c.m4042a("SELECT %1$s.id FROM %1$s LEFT JOIN tmp_%1$s ON %1$s.id = tmp_%1$s.id WHERE tmp_%1$s.id IS NOT NULL", f5596g));
            String strValueOf = String.valueOf(System.currentTimeMillis());
            Cursor cursorM4032a = m4032a(f5596g, new String[]{"message_json"}, strM4042a, new String[]{strValueOf, strValueOf});
            if (cursorM4032a != null) {
                inAppMessageM4063b = cursorM4032a.moveToFirst() ? m4063b(cursorM4032a, interfaceC4384c) : null;
                cursorM4032a.close();
            }
            m4040h(f5596g);
            this.f5588c.setTransactionSuccessful();
            this.f5588c.endTransaction();
        }
        return inAppMessageM4063b;
    }
}
