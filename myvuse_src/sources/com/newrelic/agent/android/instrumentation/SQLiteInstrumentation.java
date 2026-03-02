package com.newrelic.agent.android.instrumentation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class SQLiteInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, MetricCategory.class.getName(), "DATABASE"));

    SQLiteInstrumentation() {
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
        Cursor cursorQuery = sQLiteDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        TraceMachine.exitMethod();
        return cursorQuery;
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
        Cursor cursorQuery = sQLiteDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6, cancellationSignal);
        TraceMachine.exitMethod();
        return cursorQuery;
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
        Cursor cursorQuery = sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5);
        TraceMachine.exitMethod();
        return cursorQuery;
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
        Cursor cursorQuery = sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        TraceMachine.exitMethod();
        return cursorQuery;
    }

    public static Cursor queryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        TraceMachine.enterMethod("SQLiteDatabase#queryWithFactory", categoryParams);
        Cursor cursorQueryWithFactory = sQLiteDatabase.queryWithFactory(cursorFactory, z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        TraceMachine.exitMethod();
        return cursorQueryWithFactory;
    }

    public static Cursor queryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        TraceMachine.enterMethod("SQLiteDatabase#queryWithFactory", categoryParams);
        Cursor cursorQueryWithFactory = sQLiteDatabase.queryWithFactory(cursorFactory, z, str, strArr, str2, strArr2, str3, str4, str5, str6, cancellationSignal);
        TraceMachine.exitMethod();
        return cursorQueryWithFactory;
    }

    public static Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        TraceMachine.enterMethod("SQLiteDatabase#rawQuery", categoryParams);
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
        TraceMachine.exitMethod();
        return cursorRawQuery;
    }

    public static Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, CancellationSignal cancellationSignal) {
        TraceMachine.enterMethod("SQLiteDatabase#rawQuery", categoryParams);
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr, cancellationSignal);
        TraceMachine.exitMethod();
        return cursorRawQuery;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        TraceMachine.enterMethod("SQLiteDatabase#rawQueryWithFactory", categoryParams);
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2);
        TraceMachine.exitMethod();
        return cursorRawQueryWithFactory;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, String str, String[] strArr, String str2, CancellationSignal cancellationSignal) {
        TraceMachine.enterMethod("SQLiteDatabase#rawQueryWithFactory", categoryParams);
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        TraceMachine.exitMethod();
        return cursorRawQueryWithFactory;
    }

    public static long insert(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) {
        TraceMachine.enterMethod("SQLiteDatabase#insert", categoryParams);
        long jInsert = sQLiteDatabase.insert(str, str2, contentValues);
        TraceMachine.exitMethod();
        return jInsert;
    }

    public static long insertOrThrow(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) throws SQLException {
        TraceMachine.enterMethod("SQLiteDatabase#insertOrThrow", categoryParams);
        long jInsertOrThrow = sQLiteDatabase.insertOrThrow(str, str2, contentValues);
        TraceMachine.exitMethod();
        return jInsertOrThrow;
    }

    public static long insertWithOnConflict(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues, int i) {
        TraceMachine.enterMethod("SQLiteDatabase#insertWithOnConflict", categoryParams);
        long jInsertWithOnConflict = sQLiteDatabase.insertWithOnConflict(str, str2, contentValues, i);
        TraceMachine.exitMethod();
        return jInsertWithOnConflict;
    }

    public static long replace(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) {
        TraceMachine.enterMethod("SQLiteDatabase#replace", categoryParams);
        long jReplace = sQLiteDatabase.replace(str, str2, contentValues);
        TraceMachine.exitMethod();
        return jReplace;
    }

    public static long replaceOrThrow(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) throws SQLException {
        TraceMachine.enterMethod("SQLiteDatabase#replaceOrThrow", categoryParams);
        long jReplaceOrThrow = sQLiteDatabase.replaceOrThrow(str, str2, contentValues);
        TraceMachine.exitMethod();
        return jReplaceOrThrow;
    }

    public static int delete(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        TraceMachine.enterMethod("SQLiteDatabase#delete", categoryParams);
        int iDelete = sQLiteDatabase.delete(str, str2, strArr);
        TraceMachine.exitMethod();
        return iDelete;
    }

    public static int update(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr) {
        TraceMachine.enterMethod("SQLiteDatabase#update", categoryParams);
        int iUpdate = sQLiteDatabase.update(str, contentValues, str2, strArr);
        TraceMachine.exitMethod();
        return iUpdate;
    }

    public static int updateWithOnConflict(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        TraceMachine.enterMethod("SQLiteDatabase#updateWithOnConflict", categoryParams);
        int iUpdateWithOnConflict = sQLiteDatabase.updateWithOnConflict(str, contentValues, str2, strArr, i);
        TraceMachine.exitMethod();
        return iUpdateWithOnConflict;
    }

    public static void execSQL(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        TraceMachine.enterMethod("SQLiteDatabase#execSQL", categoryParams);
        sQLiteDatabase.execSQL(str);
        TraceMachine.exitMethod();
    }

    public static void execSQL(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) throws SQLException {
        TraceMachine.enterMethod("SQLiteDatabase#execSQL", categoryParams);
        sQLiteDatabase.execSQL(str, objArr);
        TraceMachine.exitMethod();
    }
}
