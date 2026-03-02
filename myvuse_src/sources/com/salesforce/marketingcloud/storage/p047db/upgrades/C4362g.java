package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.g */
/* JADX INFO: loaded from: classes6.dex */
public class C4362g {

    /* JADX INFO: renamed from: a */
    private static final String f5686a = C4170g.m3197a("Version6ToVersion7");

    /* JADX INFO: renamed from: a */
    private static void m4199a(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE registration ADD COLUMN signed_string VARCHAR DEFAULT NULL");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE registration ADD COLUMN signed_string VARCHAR DEFAULT NULL");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                try {
                    C4170g.m3207b(f5686a, e, "Unable to update registration table", new Object[0]);
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS registration");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, proximity_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, signed_string VARCHAR, locale VARCHAR );");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, proximity_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, signed_string VARCHAR, locale VARCHAR );");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLException e2) {
                    C4170g.m3207b(f5686a, e2, "Unable to create registration table", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4200b(SQLiteDatabase sQLiteDatabase) {
        m4199a(sQLiteDatabase);
    }
}
