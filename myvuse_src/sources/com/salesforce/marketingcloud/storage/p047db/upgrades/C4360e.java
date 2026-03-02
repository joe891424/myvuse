package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.e */
/* JADX INFO: loaded from: classes6.dex */
public class C4360e {

    /* JADX INFO: renamed from: a */
    private static final String f5684a = C4170g.m3197a("Version4ToVersion5");

    private C4360e() {
    }

    /* JADX INFO: renamed from: a */
    private static void m4195a(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN custom VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN custom VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN keys VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN keys VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN title VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN title VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN alert VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN alert VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN sound VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN sound VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN mediaUrl VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN mediaUrl VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN mediaAlt VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN mediaAlt VARCHAR;");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS cloud_page_messages");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT, custom VARCHAR, keys VARCHAR, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, message_hash VARCHAR, request_id VARCHAR);");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT, custom VARCHAR, keys VARCHAR, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, message_hash VARCHAR, request_id VARCHAR);");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    C4170g.m3207b(f5684a, e, "Unable to update cloud_page_messages table", new Object[0]);
                } catch (SQLException e2) {
                    C4170g.m3207b(f5684a, e2, "Unable to create cloud_page_messages table", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4196b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery;
        try {
            if (sQLiteDatabase instanceof SQLiteDatabase) {
                cursorQuery = SQLiteInstrumentation.query(sQLiteDatabase, "cloud_page_messages", null, null, null, null, null, null);
            } else {
                cursorQuery = sQLiteDatabase.query("cloud_page_messages", null, null, null, null, null, null);
            }
            if (cursorQuery != null) {
                if (cursorQuery.getColumnIndex("custom") == -1) {
                    m4195a(sQLiteDatabase);
                }
                cursorQuery.close();
            }
        } catch (Exception unused) {
            C4170g.m3206b(f5684a, "Failed to update cloud_page_messages table.", new Object[0]);
        }
    }
}
