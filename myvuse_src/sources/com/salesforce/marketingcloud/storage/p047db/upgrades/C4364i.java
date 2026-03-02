package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.i */
/* JADX INFO: loaded from: classes6.dex */
public class C4364i {

    /* JADX INFO: renamed from: a */
    private static final String f5688a = C4170g.m3197a("Version8ToVersion9");

    private C4364i() {
    }

    /* JADX INFO: renamed from: a */
    private static void m4202a(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE analytic_item ADD COLUMN predictive_intelligence_identifier VARCHAR DEFAULT NULL");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE analytic_item ADD COLUMN predictive_intelligence_identifier VARCHAR DEFAULT NULL");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                try {
                    C4170g.m3207b(f5688a, e, "Unable to update analytic_item table", new Object[0]);
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS analytic_item");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS analytic_item");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL);");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL);");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLException e2) {
                    C4170g.m3207b(f5688a, e2, "Unable to create analytic_item table", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4203b(SQLiteDatabase sQLiteDatabase) {
        m4202a(sQLiteDatabase);
    }
}
