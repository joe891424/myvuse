package com.salesforce.marketingcloud.storage.p047db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.db.b */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4343b {

    /* JADX INFO: renamed from: d */
    protected static final String f5587d = "%s = ?";

    /* JADX INFO: renamed from: c */
    protected final SQLiteDatabase f5588c;

    public AbstractC4343b(SQLiteDatabase sQLiteDatabase) {
        this.f5588c = sQLiteDatabase;
    }

    /* JADX INFO: renamed from: a */
    protected final int m4030a(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String strMo4026o = mo4026o();
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.delete(strMo4026o, str, strArr) : SQLiteInstrumentation.delete(sQLiteDatabase, strMo4026o, str, strArr);
    }

    /* JADX INFO: renamed from: b */
    void m4038b(String str, Collection<String> collection) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String strM4042a = C4344c.m4042a("DROP TABLE IF EXISTS tmp_%s;", str);
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, strM4042a);
        } else {
            sQLiteDatabase.execSQL(strM4042a);
        }
        SQLiteDatabase sQLiteDatabase2 = this.f5588c;
        String strM4042a2 = C4344c.m4042a("CREATE TEMPORARY TABLE tmp_%s(id VARCHAR);", str);
        if (sQLiteDatabase2 instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase2, strM4042a2);
        } else {
            sQLiteDatabase2.execSQL(strM4042a2);
        }
        ContentValues contentValues = new ContentValues();
        Iterator<String> it2 = collection.iterator();
        while (it2.hasNext()) {
            contentValues.put("id", it2.next());
            SQLiteDatabase sQLiteDatabase3 = this.f5588c;
            String strM4042a3 = C4344c.m4042a("tmp_%s", str);
            if (sQLiteDatabase3 instanceof SQLiteDatabase) {
                SQLiteInstrumentation.insert(sQLiteDatabase3, strM4042a3, null, contentValues);
            } else {
                sQLiteDatabase3.insert(strM4042a3, null, contentValues);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    final int m4039c(Collection<String> collection) throws SQLException {
        return m4027a(mo4026o(), collection, false);
    }

    /* JADX INFO: renamed from: h */
    void m4040h(String str) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String strM4042a = C4344c.m4042a("DROP TABLE IF EXISTS tmp_%s;", str);
        if (sQLiteDatabase instanceof SQLiteDatabase) {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, strM4042a);
        } else {
            sQLiteDatabase.execSQL(strM4042a);
        }
    }

    /* JADX INFO: renamed from: i */
    protected final int m4041i(String str) {
        return m4030a(str, (String[]) null);
    }

    /* JADX INFO: renamed from: o */
    abstract String mo4026o();

    /* JADX INFO: renamed from: a */
    private int m4027a(String str, Collection<String> collection, boolean z) {
        int iDelete;
        try {
            this.f5588c.beginTransaction();
            m4038b(str, collection);
            SQLiteDatabase sQLiteDatabase = this.f5588c;
            String strM4042a = C4344c.m4042a("id IN(SELECT %1$s.id FROM %1$s LEFT JOIN tmp_%1$s ON %1$s.id = tmp_%1$s.id WHERE tmp_%1$s.id %2$s)", str, z ? "IS NULL" : "IS NOT NULL");
            if (sQLiteDatabase instanceof SQLiteDatabase) {
                iDelete = SQLiteInstrumentation.delete(sQLiteDatabase, str, strM4042a, null);
            } else {
                iDelete = sQLiteDatabase.delete(str, strM4042a, null);
            }
            m4040h(str);
            this.f5588c.setTransactionSuccessful();
            this.f5588c.endTransaction();
            return iDelete;
        } catch (SQLException e) {
            this.f5588c.endTransaction();
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    final int m4029a(String str, Collection<String> collection) throws SQLException {
        return m4027a(str, collection, true);
    }

    /* JADX INFO: renamed from: a */
    protected final long m4031a(ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String strMo4026o = mo4026o();
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.insert(strMo4026o, null, contentValues) : SQLiteInstrumentation.insert(sQLiteDatabase, strMo4026o, null, contentValues);
    }

    /* JADX INFO: renamed from: a */
    protected final Cursor m4032a(String str, String[] strArr, String str2, String[] strArr2) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.query(str, strArr, str2, strArr2, null, null, null) : SQLiteInstrumentation.query(sQLiteDatabase, str, strArr, str2, strArr2, null, null, null);
    }

    /* JADX INFO: renamed from: a */
    protected final Cursor m4033a(String[] strArr, String str) {
        return m4036a(strArr, str, null, null, null, null, null);
    }

    /* JADX INFO: renamed from: a */
    protected final Cursor m4034a(String[] strArr, String str, String[] strArr2) {
        return m4036a(strArr, str, strArr2, null, null, null, null);
    }

    /* JADX INFO: renamed from: a */
    protected final Cursor m4035a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String strMo4026o = mo4026o();
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.query(false, strMo4026o, strArr, str, strArr2, str2, str3, str4, null) : SQLiteInstrumentation.query(sQLiteDatabase, false, strMo4026o, strArr, str, strArr2, str2, str3, str4, null);
    }

    /* JADX INFO: renamed from: a */
    protected final Cursor m4036a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String strMo4026o = mo4026o();
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.query(false, strMo4026o, strArr, str, strArr2, str2, str3, str4, str5) : SQLiteInstrumentation.query(sQLiteDatabase, false, strMo4026o, strArr, str, strArr2, str2, str3, str4, str5);
    }

    /* JADX INFO: renamed from: a */
    protected final int m4028a(ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase = this.f5588c;
        String strMo4026o = mo4026o();
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.update(strMo4026o, contentValues, str, strArr) : SQLiteInstrumentation.update(sQLiteDatabase, strMo4026o, contentValues, str, strArr);
    }

    /* JADX INFO: renamed from: a */
    final void m4037a(ContentValues contentValues, Collection<String> collection) {
        try {
            this.f5588c.beginTransactionNonExclusive();
            m4038b(mo4026o(), collection);
            m4028a(contentValues, C4344c.m4042a("id IN(SELECT %1$s.id FROM %1$s LEFT JOIN tmp_%1$s ON %1$s.id = tmp_%1$s.id WHERE tmp_%1$s.id IS NOT NULL)", mo4026o()), (String[]) null);
            m4040h(mo4026o());
            this.f5588c.setTransactionSuccessful();
            this.f5588c.endTransaction();
        } catch (SQLException e) {
            this.f5588c.endTransaction();
            throw e;
        }
    }
}
