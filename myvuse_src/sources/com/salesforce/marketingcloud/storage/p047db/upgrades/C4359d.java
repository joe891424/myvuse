package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.d */
/* JADX INFO: loaded from: classes6.dex */
public class C4359d {

    /* JADX INFO: renamed from: a */
    private static final String f5683a = C4170g.m3197a("Version3ToVersion4");

    private C4359d() {
    }

    /* JADX INFO: renamed from: a */
    private static void m4192a(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE regions ADD COLUMN is_inside SMALLINT");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN is_inside SMALLINT");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER, is_inside SMALLINT );");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER, is_inside SMALLINT );");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    C4170g.m3207b(f5683a, e, "Unable to update regions table", new Object[0]);
                } catch (SQLException e2) {
                    C4170g.m3207b(f5683a, e2, "Unable to create regions table", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m4193b(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE messages_temp (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE messages_temp (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO messages_temp SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, notify_id FROM messages");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO messages_temp SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, notify_id FROM messages");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE messages");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE messages");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
                } else {
                    sQLiteDatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "INSERT INTO messages SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, notify_id FROM messages_temp");
                } else {
                    sQLiteDatabase.execSQL("INSERT INTO messages SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, notify_id FROM messages_temp");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE messages_temp");
                } else {
                    sQLiteDatabase.execSQL("DROP TABLE messages_temp");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE messages ADD COLUMN title VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN title VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE messages ADD COLUMN mediaUrl VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN mediaUrl VARCHAR;");
                }
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE messages ADD COLUMN mediaAlt VARCHAR;");
                } else {
                    sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN mediaAlt VARCHAR;");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                try {
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS messages");
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
                    }
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE messages (id VARCHAR PRIMARY KEY, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
                    } else {
                        sQLiteDatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    C4170g.m3207b(f5683a, e, "Unable to update messages table", new Object[0]);
                } catch (SQLException e2) {
                    C4170g.m3207b(f5683a, e2, "Unable to create messages table", new Object[0]);
                }
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4194c(SQLiteDatabase sQLiteDatabase) {
        m4193b(sQLiteDatabase);
        m4192a(sQLiteDatabase);
    }
}
