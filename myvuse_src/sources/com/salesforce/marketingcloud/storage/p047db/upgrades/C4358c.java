package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.storage.p047db.C4342a;
import org.json.JSONException;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.c */
/* JADX INFO: loaded from: classes6.dex */
public final class C4358c {

    /* JADX INFO: renamed from: a */
    private static final String f5682a = C4170g.m3197a("Version2ToVersion3");

    private C4358c() {
    }

    /* JADX INFO: renamed from: a */
    private static void m4186a(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN message_hash VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN message_hash VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE cloud_page_messages ADD COLUMN request_id VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN request_id VARCHAR;");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                C4170g.m3207b(f5682a, e, "Failed to update cloud_page_messages table.", new Object[0]);
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS cloud_page_messages;");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloud_page_messages;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT, message_hash VARCHAR, request_id VARCHAR)");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT, message_hash VARCHAR, request_id VARCHAR)");
                }
                sQLiteDatabase.setTransactionSuccessful();
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m4187b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery;
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TEMPORARY TABLE analytic_item_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_types VARCHAR, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR)");
                } else {
                    sQLiteDatabase.execSQL("CREATE TEMPORARY TABLE analytic_item_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_types VARCHAR, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR)");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO analytic_item_temp SELECT id,event_date,analytic_product_type,analytic_types,value,ready_to_send,object_ids,json_payload FROM analytic_item");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO analytic_item_temp SELECT id,event_date,analytic_product_type,analytic_types,value,ready_to_send,object_ids,json_payload FROM analytic_item");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE analytic_item");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE analytic_item");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR)");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR)");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM analytic_item_temp", null);
                } else {
                    cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM analytic_item_temp", null);
                }
                if (cursorRawQuery != null) {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            ContentValues contentValues = new ContentValues();
                            try {
                                contentValues.put("id", Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"))));
                                contentValues.put(C4342a.a.f5579c, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(C4342a.a.f5579c)));
                                contentValues.put(C4342a.a.f5585i, Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(C4342a.a.f5585i))));
                                contentValues.put(C4342a.a.f5580d, Integer.valueOf(m4185a(cursorRawQuery)));
                                contentValues.put("value", Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("value"))));
                                contentValues.put(C4342a.a.f5582f, Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(C4342a.a.f5582f))));
                                contentValues.put(C4342a.a.f5581e, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(C4342a.a.f5581e)));
                                contentValues.put("json_payload", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("json_payload")));
                                if (sQLiteDatabase instanceof SQLiteDatabase) {
                                    SQLiteInstrumentation.insert(sQLiteDatabase, C4342a.f5572e, null, contentValues);
                                } else {
                                    sQLiteDatabase.insert(C4342a.f5572e, null, contentValues);
                                }
                            } catch (Exception e) {
                                C4170g.m3207b(f5682a, e, "Failed to update item in Analytics local storage during upgrade.", new Object[0]);
                            }
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE analytic_item_temp");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE analytic_item_temp");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e2) {
                C4170g.m3207b(f5682a, e2, "Failed to upgrade Analytics local storage.  Starting fresh.  Some analytics items may have been lost.", new Object[0]);
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR)");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR)");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLException e3) {
                    C4170g.m3207b(f5682a, e3, "Failed to create local storage for Analytics.", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m4188c(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("message_type", (Integer) 8);
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.update(sQLiteDatabase, "cloud_page_messages", contentValues, null, null);
                } else {
                    sQLiteDatabase.update("cloud_page_messages", contentValues, null, null);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                C4170g.m3217e(f5682a, e, "Failed to convert CloudPageMessage to an InboxMessage.", new Object[0]);
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DELETE FROM cloud_page_messages WHERE content_type=2 AND message_type=1;");
                    } else {
                        sQLiteDatabase.execSQL("DELETE FROM cloud_page_messages WHERE content_type=2 AND message_type=1;");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    C4170g.m3207b(f5682a, e2, "Failed to remove legacy CloudPage data.", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m4189d(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery;
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE inbox_message_status (id VARCHAR PRIMARY KEY, status INTEGER);");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE inbox_message_status (id VARCHAR PRIMARY KEY, status INTEGER);");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM cloud_page_messages", null);
                } else {
                    cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM cloud_page_messages", null);
                }
                if (cursorRawQuery != null) {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            int i = 1;
                            boolean z = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("message_deleted")) == 1;
                            boolean z2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("read")) == 1;
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"));
                            if (z) {
                                i = 2;
                            } else if (!z2) {
                                i = 0;
                            }
                            ContentValues contentValues = new ContentValues();
                            if (i > 0) {
                                try {
                                    contentValues.put("id", string);
                                    contentValues.put("status", Integer.valueOf(i));
                                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                                        SQLiteInstrumentation.insert(sQLiteDatabase, "inbox_message_status", null, contentValues);
                                    } else {
                                        sQLiteDatabase.insert("inbox_message_status", null, contentValues);
                                    }
                                } catch (Exception e) {
                                    C4170g.m3217e(f5682a, e, "Failed to add message %s to inbox_message_status table.", string);
                                }
                            }
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e2) {
                C4170g.m3207b(f5682a, e2, "Failed to update inbox_message_status table.", new Object[0]);
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS inbox_message_status;");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS inbox_message_status;");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE inbox_message_status (id VARCHAR PRIMARY KEY, status INTEGER);");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE inbox_message_status (id VARCHAR PRIMARY KEY, status INTEGER);");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e3) {
                    C4170g.m3207b(f5682a, e3, "Failed to create inbox_message_status table.", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: e */
    private static void m4190e(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TEMPORARY TABLE reg_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
                } else {
                    sQLiteDatabase.execSQL("CREATE TEMPORARY TABLE reg_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO reg_temp SELECT id,platform,subscriber_key,et_app_id,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,system_token,device_id,app_version,sdk_version,locale FROM registration");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO reg_temp SELECT id,platform,subscriber_key,et_app_id,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,system_token,device_id,app_version,sdk_version,locale FROM registration");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE registration");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE registration");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO registration SELECT id,platform,subscriber_key,et_app_id,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,system_token,device_id,app_version,sdk_version,locale FROM reg_temp");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO registration SELECT id,platform,subscriber_key,et_app_id,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,system_token,device_id,app_version,sdk_version,locale FROM reg_temp");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE reg_temp");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE reg_temp");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                C4170g.m3207b(f5682a, e, "Failed to upgrade Registration local storage.  Starting fresh.  Attributes, Tags and ContactKey will be lost.", new Object[0]);
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLException e2) {
                    C4170g.m3207b(f5682a, e2, "Failed to create local storage for Registration.", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m4191f(SQLiteDatabase sQLiteDatabase) {
        m4187b(sQLiteDatabase);
        m4190e(sQLiteDatabase);
        m4189d(sQLiteDatabase);
        m4188c(sQLiteDatabase);
        m4186a(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: a */
    public static int m4185a(Cursor cursor) throws JSONException, NumberFormatException, NullPointerException {
        String string = cursor.getString(cursor.getColumnIndex("analytic_types"));
        return string.contains(",") ? string.contains("4") ? 5 : 2 : Integer.parseInt(string.replaceAll("\\[", "").replaceAll("\\]", "").trim());
    }
}
