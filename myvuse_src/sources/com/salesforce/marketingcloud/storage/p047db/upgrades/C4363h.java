package com.salesforce.marketingcloud.storage.p047db.upgrades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.C4170g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.upgrades.h */
/* JADX INFO: loaded from: classes6.dex */
public class C4363h {

    /* JADX INFO: renamed from: a */
    private static final String f5687a = C4170g.m3197a("Version7ToVersion8");

    private C4363h() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00c1 -> B:60:0x00ca). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: a */
    public static void m4201a(SQLiteDatabase sQLiteDatabase) {
        boolean z;
        Cursor cursorRawQuery;
        try {
            if (sQLiteDatabase instanceof SQLiteDatabase) {
                cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT id,read,message_deleted FROM cloud_page_messages WHERE message_type=1", null);
            } else {
                cursorRawQuery = sQLiteDatabase.rawQuery("SELECT id,read,message_deleted FROM cloud_page_messages WHERE message_type=1", null);
            }
        } catch (Exception e) {
            e = e;
            z = false;
        }
        if (cursorRawQuery != null) {
            if (cursorRawQuery.moveToFirst()) {
                do {
                    z = true;
                    try {
                        int i = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("message_deleted")) == 1 ? 2 : cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("read")) == 1 ? 1 : -1;
                        if (i != -1) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("id", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id")));
                            contentValues.put("status", Integer.valueOf(i));
                            if (sQLiteDatabase instanceof SQLiteDatabase) {
                                SQLiteInstrumentation.insert(sQLiteDatabase, "inbox_message_status", null, contentValues);
                            } else {
                                sQLiteDatabase.insert("inbox_message_status", null, contentValues);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        C4170g.m3207b(f5687a, e, "Unable to set inbox message statuses for legacy messages", new Object[0]);
                    }
                } while (cursorRawQuery.moveToNext());
            } else {
                z = false;
            }
            cursorRawQuery.close();
            if (z) {
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("message_type", (Integer) 8);
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        SQLiteInstrumentation.update(sQLiteDatabase, "cloud_page_messages", contentValues2, null, null);
                    } else {
                        sQLiteDatabase.update("cloud_page_messages", contentValues2, null, null);
                    }
                } catch (Exception e3) {
                    C4170g.m3207b(f5687a, e3, "Unable to update message_type for legacy Inbox messages.  Attempting to delete them.", new Object[0]);
                    try {
                        if (sQLiteDatabase instanceof SQLiteDatabase) {
                            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DELETE FROM cloud_page_messages WHERE message_type=1", null);
                        } else {
                            sQLiteDatabase.execSQL("DELETE FROM cloud_page_messages WHERE message_type=1", null);
                        }
                    } catch (Exception e4) {
                        C4170g.m3207b(f5687a, e4, "Unable to delete legacy Inbox messages.", new Object[0]);
                    }
                }
            }
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("DELETE FROM cloud_page_messages WHERE message_type=1", null);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "DELETE FROM cloud_page_messages WHERE message_type=1", null);
            }
        } catch (Exception e5) {
            C4170g.m3207b(f5687a, e5, "Final attempt to delete legacy Inbox messages failed.", new Object[0]);
        }
    }
}
