package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.storage.p047db.C4342a;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.salesforce.marketingcloud.util.C4386e;
import com.salesforce.marketingcloud.util.C4389h;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4357b {

    /* JADX INFO: renamed from: a */
    static final String f5677a = "geofence_request";

    /* JADX INFO: renamed from: b */
    static final String f5678b = "beacon_request";

    /* JADX INFO: renamed from: c */
    private static final String f5679c = C4170g.m3197a("Version1ToVersion2");

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.b$a */
    private static class a {

        /* JADX INFO: renamed from: a */
        final String f5680a;

        /* JADX INFO: renamed from: b */
        final String f5681b;

        a(String str, String str2) {
            this.f5680a = str;
            this.f5681b = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.f5680a;
            if (str == null && aVar.f5680a == null) {
                return true;
            }
            return str.equalsIgnoreCase(aVar.f5680a);
        }

        public int hashCode() {
            return this.f5680a.toLowerCase().hashCode();
        }
    }

    private C4357b() {
    }

    /* JADX INFO: renamed from: a */
    private static void m4178a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery;
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE analytic_item RENAME TO old_analytic_item");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE analytic_item RENAME TO old_analytic_item");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_types VARCHAR, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR)");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_types VARCHAR, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR)");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM old_analytic_item", null);
                } else {
                    cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM old_analytic_item", null);
                }
                if (cursorRawQuery != null) {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            ContentValues contentValues = new ContentValues();
                            try {
                                contentValues.put("id", Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"))));
                                contentValues.put(C4342a.a.f5579c, cursorRawQuery.getString(cursorRawQuery.getColumnIndex(C4342a.a.f5579c)));
                                contentValues.put(C4342a.a.f5585i, Integer.valueOf(!TextUtils.isEmpty(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("pi_app_key"))) ? 1 : 0));
                                contentValues.put("analytic_types", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("analytic_types")));
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
                                C4170g.m3207b(f5679c, e, "Failed to update item in Analytics local storage during upgrade.", new Object[0]);
                            }
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                }
                String str = "DROP TABLE old_analytic_item";
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, str);
                } else {
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            C4170g.m3207b(f5679c, e2, "Failed to upgrade Analytics local storage.  Starting fresh.  Some analytics items may have been lost.", new Object[0]);
            try {
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR);");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR);");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e3) {
                C4170g.m3207b(f5679c, e3, "Failed to create local storage for Analytics.", new Object[0]);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0015 -> B:51:0x001e). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: b */
    private static void m4180b(SQLiteDatabase sQLiteDatabase) {
        try {
            if (sQLiteDatabase instanceof SQLiteDatabase) {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "DELETE FROM messages WHERE message_type NOT IN ( 5, 3, 4 )");
            } else {
                sQLiteDatabase.execSQL("DELETE FROM messages WHERE message_type NOT IN ( 5, 3, 4 )");
            }
        } catch (Exception e) {
            C4170g.m3207b(f5679c, e, "Unable to clean unused messages from db.", new Object[0]);
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE messages RENAME TO old_messages");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE messages RENAME TO old_messages");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, has_entered SMALLINT, notify_id INTEGER );");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, has_entered SMALLINT, notify_id INTEGER );");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO messages SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, has_entered, notify_id FROM old_messages");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO messages SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, has_entered, notify_id FROM old_messages");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE old_messages");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE old_messages");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                sQLiteDatabase.endTransaction();
                try {
                    sQLiteDatabase.beginTransaction();
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS messages");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, has_entered SMALLINT, notify_id INTEGER );");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, has_entered SMALLINT, notify_id INTEGER );");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e3) {
                    C4170g.m3207b(f5679c, e3, "Unable a create message table.", new Object[0]);
                }
                C4170g.m3207b(f5679c, e2, "Unable to update message table", new Object[0]);
            }
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m4182c(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS regions");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regions");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER );");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER );");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DELETE FROM region_message");
                } else {
                    sQLiteDatabase.execSQL("DELETE FROM region_message");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException unused) {
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS regions");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regions");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS region_message");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_message");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER );");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER );");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );");
                }
                sQLiteDatabase.setTransactionSuccessful();
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m4183d(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE location_table (id INTEGER PRIMARY KEY CHECK (id = 0), latitude VARCHAR, longitude VARCHAR );");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE location_table (id INTEGER PRIMARY KEY CHECK (id = 0), latitude VARCHAR, longitude VARCHAR );");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                C4170g.m3207b(f5679c, e, "Unable to create location table", new Object[0]);
            }
            try {
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE beacon_request");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE beacon_request");
                }
                if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                    sQLiteDatabase.execSQL("DROP TABLE geofence_request");
                } else {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE geofence_request");
                }
            } catch (Exception e2) {
                C4170g.m3207b(f5679c, e2, "Unable to drop unused request tables", new Object[0]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: e */
    private static void m4184e(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT)");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT)");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO cloud_page_messages SELECT id,start_date,end_date,message_type,content_type,url,subject,read,message_deleted FROM messages WHERE message_type=1 AND content_type=2");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO cloud_page_messages SELECT id,start_date,end_date,message_type,content_type,url,subject,read,message_deleted FROM messages WHERE message_type=1 AND content_type=2");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DELETE FROM messages WHERE message_type=1 AND content_type=2");
                } else {
                    sQLiteDatabase.execSQL("DELETE FROM messages WHERE message_type=1 AND content_type=2");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                C4170g.m3207b(f5679c, e, "Failed to move Messages to CloudPage Messages table.", new Object[0]);
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS cloud_page_messages");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT)");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT)");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    C4170g.m3207b(f5679c, e2, "Could not create cloud_page_messages table.", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m4179a(SQLiteDatabase sQLiteDatabase, Context context, InterfaceC4384c interfaceC4384c) {
        Cursor cursorRawQuery;
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE registration RENAME TO old_registration");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE registration RENAME TO old_registration");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, gcm_sender_id VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR )");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, gcm_sender_id VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR )");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO registration (id,platform,subscriber_key,et_app_id,badge,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,gcm_sender_id,locale) SELECT id,platform,subscriber_key,et_app_id,badge,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,gcm_sender_id,locale FROM old_registration");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO registration (id,platform,subscriber_key,et_app_id,badge,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,gcm_sender_id,locale) SELECT id,platform,subscriber_key,et_app_id,badge,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,gcm_sender_id,locale FROM old_registration");
                }
                if (DatabaseUtils.queryNumEntries(sQLiteDatabase, C4352k.f5644e) > 0) {
                    ContentValues contentValues = new ContentValues(3);
                    contentValues.put(C4352k.a.f5662p, C4386e.m4266a(context, (String) null));
                    contentValues.put(C4352k.a.f5663q, C4389h.m4319a(context));
                    contentValues.put(C4352k.a.f5664r, MarketingCloudSdk.getSdkVersionName());
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.update(sQLiteDatabase, C4352k.f5644e, contentValues, null, null);
                    } else {
                        sQLiteDatabase.update(C4352k.f5644e, contentValues, null, null);
                    }
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE old_registration");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE old_registration");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                C4170g.m3207b(f5679c, e, "Unable to update registration table", new Object[0]);
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS registration");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, gcm_sender_id VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR )");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, gcm_sender_id VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR )");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    C4170g.m3207b(f5679c, e2, "Unable to create registration table", new Object[0]);
                }
            }
            sQLiteDatabase.endTransaction();
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT id, attributes FROM registration", null);
                } else {
                    cursorRawQuery = sQLiteDatabase.rawQuery("SELECT id, attributes FROM registration", null);
                }
                if (cursorRawQuery != null) {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            try {
                                ArrayList<a> arrayListM4177a = m4177a(interfaceC4384c.mo4260b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(C4352k.a.f5654h))));
                                ArraySet arraySet = new ArraySet();
                                if (!arrayListM4177a.isEmpty()) {
                                    for (int size = arrayListM4177a.size() - 1; size >= 0; size--) {
                                        arraySet.add(arrayListM4177a.get(size));
                                    }
                                    ContentValues contentValues2 = new ContentValues();
                                    contentValues2.put(C4352k.a.f5654h, interfaceC4384c.mo4259a(m4176a(arraySet)));
                                    String[] strArr = {cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))};
                                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                                        SQLiteInstrumentation.update(sQLiteDatabase, C4352k.f5644e, contentValues2, "id=?", strArr);
                                    } else {
                                        sQLiteDatabase.update(C4352k.f5644e, contentValues2, "id=?", strArr);
                                    }
                                }
                            } catch (Exception e3) {
                                C4170g.m3206b(f5679c, "Unable to remove duplicate attributes from row", e3);
                            }
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4181b(SQLiteDatabase sQLiteDatabase, Context context, InterfaceC4384c interfaceC4384c) {
        m4184e(sQLiteDatabase);
        m4180b(sQLiteDatabase);
        m4183d(sQLiteDatabase);
        m4182c(sQLiteDatabase);
        m4179a(sQLiteDatabase, context, interfaceC4384c);
        m4178a(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: a */
    private static ArrayList<a> m4177a(String str) {
        ArrayList<a> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("\\^\\|\\^");
            int i = 0;
            while (i < strArrSplit.length) {
                while (true) {
                    String str2 = strArrSplit[i];
                    if (str2 != null && !str2.isEmpty()) {
                        break;
                    }
                    i++;
                }
                int i2 = i + 1;
                if (i2 >= strArrSplit.length) {
                    arrayList.add(new a(strArrSplit[i], ""));
                } else {
                    arrayList.add(new a(strArrSplit[i], strArrSplit[i2]));
                }
                i += 2;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static synchronized String m4176a(Collection<a> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList(collection.size());
        Iterator<a> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        StringBuilder sb = new StringBuilder();
        for (a aVar : arrayList) {
            if (aVar != null) {
                sb.append(aVar.f5680a);
                sb.append("^|^");
                sb.append(aVar.f5681b);
                sb.append("^|^");
            } else {
                C4170g.m3216e(f5679c, "A null attribute was encountered.", new Object[0]);
            }
        }
        return sb.toString();
    }
}
