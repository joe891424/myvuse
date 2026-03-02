package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.util.InterfaceC4384c;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.j */
/* JADX INFO: loaded from: classes6.dex */
public class C4365j {

    /* JADX INFO: renamed from: a */
    private static final String f5689a = C4170g.m3197a("Version9ToVersion10");

    private C4365j() {
    }

    /* JADX INFO: renamed from: a */
    private static void m4204a(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE device_stats(id INTEGER PRIMARY KEY, type INTEGER, date INTEGER, event_data TEXT, in_transit INTEGER DEFAULT 0, ready_to_send INTEGER DEFAULT 0);");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE device_stats(id INTEGER PRIMARY KEY, type INTEGER, date INTEGER, event_data TEXT, in_transit INTEGER DEFAULT 0, ready_to_send INTEGER DEFAULT 0);");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                C4170g.m3207b(f5689a, e, "Unable to create device stats table.", new Object[0]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m4206b(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE triggers (id TEXT PRIMARY KEY, _key TEXT, start_date INTEGER DEFAULT NULL, _trigger TEXT, app_open_count INTEGER DEFAULT 0);");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE triggers (id TEXT PRIMARY KEY, _key TEXT, start_date INTEGER DEFAULT NULL, _trigger TEXT, app_open_count INTEGER DEFAULT 0);");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE in_app_messages(id TEXT PRIMARY KEY, priority INTEGER DEFAULT 999, start_date DATETIME, end_date DATETIME, modified_date DATETIME, display_limit INTEGER DEFAULT 1, media_url TEXT DEFAULT NULL, message_json TEXT);");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE in_app_messages(id TEXT PRIMARY KEY, priority INTEGER DEFAULT 999, start_date DATETIME, end_date DATETIME, modified_date DATETIME, display_limit INTEGER DEFAULT 1, media_url TEXT DEFAULT NULL, message_json TEXT);");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE iam_state(id TEXT PRIMARY KEY, display_count integer DEFAULT 0, FOREIGN KEY (id) REFERENCES in_app_messages(id) ON DELETE CASCADE);");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE iam_state(id TEXT PRIMARY KEY, display_count integer DEFAULT 0, FOREIGN KEY (id) REFERENCES in_app_messages(id) ON DELETE CASCADE);");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TRIGGER iam_state_init AFTER INSERT ON in_app_messages BEGIN INSERT INTO iam_state (id) VALUES (NEW.id); END;");
                } else {
                    sQLiteDatabase.execSQL("CREATE TRIGGER iam_state_init AFTER INSERT ON in_app_messages BEGIN INSERT INTO iam_state (id) VALUES (NEW.id); END;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE VIEW iam_view AS SELECT in_app_messages.id,in_app_messages.priority,in_app_messages.start_date,in_app_messages.end_date,in_app_messages.modified_date,in_app_messages.display_limit,in_app_messages.message_json,iam_state.display_count FROM in_app_messages INNER JOIN iam_state ON iam_state.id = in_app_messages.id;");
                } else {
                    sQLiteDatabase.execSQL("CREATE VIEW iam_view AS SELECT in_app_messages.id,in_app_messages.priority,in_app_messages.start_date,in_app_messages.end_date,in_app_messages.modified_date,in_app_messages.display_limit,in_app_messages.message_json,iam_state.display_count FROM in_app_messages INNER JOIN iam_state ON iam_state.id = in_app_messages.id;");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                C4170g.m3207b(f5689a, e, "Unable to create in app message table", new Object[0]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m4208c(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE region_messages ( region_id TEXT, message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE region_messages ( region_id TEXT, message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO region_messages SELECT region_id,message_id FROM region_message;");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO region_messages SELECT region_id,message_id FROM region_message;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS region_message");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_message");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                C4170g.m3207b(f5689a, e, "Unable to create region_messages table and migrate data from region_message.", new Object[0]);
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS region_messages");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_messages");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS region_message");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_message");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE region_messages ( region_id TEXT, message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE region_messages ( region_id TEXT, message_id TEXT, FOREIGN KEY (region_id) REFERENCES regions(id) ON DELETE CASCADE, PRIMARY KEY (region_id, message_id));");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLException e2) {
                    C4170g.m3207b(f5689a, e2, "Unable to create region_messages table", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(3:17|(2:(19:143|19|137|20|(5:139|22|23|147|24)(1:27)|28|(1:30)|31|(14:145|33|(4:35|(8:38|39|40|41|152|42|160|36)|159|45)(1:50)|51|(4:54|(1:56)|(1:58)|59)|60|(1:62)(1:63)|64|65|154|66|(1:68)(1:69)|84|(1:158)(1:87))(0)|100|(1:102)(1:103)|104|141|105|(1:107)(1:108)|(3:110|(2:(4:112|(1:114)(1:115)|116|(1:157)(1:119))|118)|120)|121|127|(2:129|161)(2:130|131))|86)(1:88)|89)(1:90)|141|105|(0)(0)|(0)|121|127|(0)(0)|(2:(0)|(1:151))) */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02f5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02f6, code lost:
    
        com.salesforce.marketingcloud.C4170g.m3207b(com.salesforce.marketingcloud.storage.p047db.upgrades.C4365j.f5689a, r0, "Unable to update inbox status values", new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ac A[Catch: all -> 0x02f3, Exception -> 0x02f5, TryCatch #4 {Exception -> 0x02f5, blocks: (B:105:0x02a6, B:107:0x02ac, B:110:0x02bc, B:112:0x02c2, B:114:0x02d8, B:116:0x02e2, B:115:0x02dc, B:120:0x02ec, B:121:0x02ef, B:108:0x02b2), top: B:141:0x02a6, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b2 A[Catch: all -> 0x02f3, Exception -> 0x02f5, TryCatch #4 {Exception -> 0x02f5, blocks: (B:105:0x02a6, B:107:0x02ac, B:110:0x02bc, B:112:0x02c2, B:114:0x02d8, B:116:0x02e2, B:115:0x02dc, B:120:0x02ec, B:121:0x02ef, B:108:0x02b2), top: B:141:0x02a6, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02bc A[Catch: all -> 0x02f3, Exception -> 0x02f5, TryCatch #4 {Exception -> 0x02f5, blocks: (B:105:0x02a6, B:107:0x02ac, B:110:0x02bc, B:112:0x02c2, B:114:0x02d8, B:116:0x02e2, B:115:0x02dc, B:120:0x02ec, B:121:0x02ef, B:108:0x02b2), top: B:141:0x02a6, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0268 A[EDGE_INSN: B:158:0x0268->B:86:0x0268 BREAK  A[LOOP:1: B:143:0x005e->B:87:0x0269], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0269 A[LOOP:1: B:143:0x005e->B:87:0x0269, LOOP_END] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m4205a(android.database.sqlite.SQLiteDatabase r21, com.salesforce.marketingcloud.util.InterfaceC4384c r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.storage.p047db.upgrades.C4365j.m4205a(android.database.sqlite.SQLiteDatabase, com.salesforce.marketingcloud.util.c):void");
    }

    /* JADX INFO: renamed from: b */
    public static void m4207b(SQLiteDatabase sQLiteDatabase, InterfaceC4384c interfaceC4384c) throws Throwable {
        m4205a(sQLiteDatabase, interfaceC4384c);
        m4206b(sQLiteDatabase);
        m4204a(sQLiteDatabase);
        m4208c(sQLiteDatabase);
    }
}
