package com.salesforce.marketingcloud.storage.p047db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.c */
/* JADX INFO: loaded from: classes6.dex */
class C4344c {
    private C4344c() {
    }

    /* JADX INFO: renamed from: a */
    static String m4042a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    static boolean m4043a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String str3 = String.format(Locale.ENGLISH, "SELECT EXISTS(SELECT 1 FROM sqlite_master WHERE type='%s' and name='%s')", str, str2);
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery(str3, null) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, str3, null);
        boolean z = false;
        if (cursorRawQuery.moveToFirst() && cursorRawQuery.getInt(0) == 0) {
            z = true;
        }
        cursorRawQuery.close();
        return z;
    }
}
