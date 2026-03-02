package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.storage.p047db.C4342a;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4356a {

    /* JADX INFO: renamed from: a */
    private static final String f5676a = C4170g.m3197a("Version10ToVersion11");

    private C4356a() {
    }

    /* JADX INFO: renamed from: a */
    private static void m4174a(SQLiteDatabase sQLiteDatabase, InterfaceC4384c interfaceC4384c) {
        Cursor cursorRawQuery;
        String string;
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TEMPORARY TABLE analytic_item_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
                } else {
                    sQLiteDatabase.execSQL("CREATE TEMPORARY TABLE analytic_item_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO analytic_item_temp SELECT id,event_date,analytic_product_type,analytic_type,value,ready_to_send,object_ids,json_payload,request_id,predictive_intelligence_identifier FROM analytic_item");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO analytic_item_temp SELECT id,event_date,analytic_product_type,analytic_type,value,ready_to_send,object_ids,json_payload,request_id,predictive_intelligence_identifier FROM analytic_item");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE analytic_item");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE analytic_item");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, enc_json_pi_payload VARCHAR, enc_json_et_payload VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, enc_json_pi_payload VARCHAR, enc_json_et_payload VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
                }
                String str = null;
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM analytic_item_temp", null);
                } else {
                    cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM analytic_item_temp", null);
                }
                Cursor cursor = cursorRawQuery;
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        while (true) {
                            ContentValues contentValues = new ContentValues();
                            try {
                                contentValues.put("id", Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
                                contentValues.put(C4342a.a.f5579c, cursor.getString(cursor.getColumnIndex(C4342a.a.f5579c)));
                                contentValues.put(C4342a.a.f5585i, Integer.valueOf(cursor.getInt(cursor.getColumnIndex(C4342a.a.f5585i))));
                                contentValues.put(C4342a.a.f5580d, Integer.valueOf(cursor.getInt(cursor.getColumnIndex(C4342a.a.f5580d))));
                                contentValues.put("value", Integer.valueOf(cursor.getInt(cursor.getColumnIndex("value"))));
                                contentValues.put(C4342a.a.f5582f, Integer.valueOf(cursor.getInt(cursor.getColumnIndex(C4342a.a.f5582f))));
                                contentValues.put(C4342a.a.f5581e, cursor.getString(cursor.getColumnIndex(C4342a.a.f5581e)));
                                contentValues.put(C4342a.a.f5584h, cursor.getString(cursor.getColumnIndex("json_payload")));
                                String string2 = cursor.getString(cursor.getColumnIndex("request_id"));
                                if (!TextUtils.isEmpty(string2)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("requestId", string2);
                                    if (jSONObject instanceof JSONObject) {
                                        string = JSONObjectInstrumentation.toString(jSONObject);
                                    } else {
                                        string = jSONObject.toString();
                                    }
                                    try {
                                        contentValues.put(C4342a.a.f5583g, interfaceC4384c.mo4259a(string));
                                    } catch (Exception e) {
                                        e = e;
                                        C4170g.m3207b(f5676a, e, "Failed to update item in Analytics local storage during upgrade.", new Object[0]);
                                    }
                                }
                                if (sQLiteDatabase instanceof SQLiteDatabase) {
                                    SQLiteInstrumentation.insert(sQLiteDatabase, C4342a.f5572e, str, contentValues);
                                } else {
                                    sQLiteDatabase.insert(C4342a.f5572e, str, contentValues);
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            if (!cursor.moveToNext()) {
                                break;
                            } else {
                                str = null;
                            }
                        }
                    }
                    cursor.close();
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE analytic_item_temp");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE analytic_item_temp");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e3) {
                C4170g.m3207b(f5676a, e3, "Failed to upgrade Analytics local storage.  Starting fresh.  Some analytics items may have been lost.", new Object[0]);
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, enc_json_pi_payload VARCHAR, enc_json_et_payload VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, enc_json_pi_payload VARCHAR, enc_json_et_payload VARCHAR, predictive_intelligence_identifier VARCHAR DEFAULT NULL)");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLException e4) {
                    C4170g.m3207b(f5676a, e4, "Failed to create local storage for Analytics.", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4175b(SQLiteDatabase sQLiteDatabase, InterfaceC4384c interfaceC4384c) {
        m4174a(sQLiteDatabase, interfaceC4384c);
    }
}
