package com.reactnativecommunity.asyncstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AsyncLocalStorageUtil {
    static String buildKeySelection(int i) {
        String[] strArr = new String[i];
        Arrays.fill(strArr, "?");
        return "key IN (" + TextUtils.join(", ", strArr) + ")";
    }

    static String[] buildKeySelectionArgs(ReadableArray readableArray, int i, int i2) {
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = readableArray.getString(i + i3);
        }
        return strArr;
    }

    @Nullable
    public static String getItemImpl(SQLiteDatabase sQLiteDatabase, String str) {
        String[] strArr = {"value"};
        String[] strArr2 = {str};
        Cursor cursorQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.query("catalystLocalStorage", strArr, "key=?", strArr2, null, null, null) : SQLiteInstrumentation.query(sQLiteDatabase, "catalystLocalStorage", strArr, "key=?", strArr2, null, null, null);
        try {
            if (cursorQuery.moveToFirst()) {
                return cursorQuery.getString(0);
            }
            cursorQuery.close();
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    static boolean setItemImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put("value", str2);
        return -1 != (!(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.insertWithOnConflict("catalystLocalStorage", null, contentValues, 5) : SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabase, "catalystLocalStorage", null, contentValues, 5));
    }

    static boolean mergeImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) throws JSONException {
        String itemImpl = getItemImpl(sQLiteDatabase, str);
        if (itemImpl != null) {
            JSONObject jSONObject = new JSONObject(itemImpl);
            deepMergeInto(jSONObject, new JSONObject(str2));
            str2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        }
        return setItemImpl(sQLiteDatabase, str, str2);
    }

    private static void deepMergeInto(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(next);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null) {
                deepMergeInto(jSONObjectOptJSONObject2, jSONObjectOptJSONObject);
                jSONObject.put(next, jSONObjectOptJSONObject2);
            } else {
                jSONObject.put(next, jSONObject2.get(next));
            }
        }
    }

    public static void verifyAndForceSqliteCheckpoint(Context context) {
        Cursor cursorRawQuery;
        if (Build.VERSION.SDK_INT < 28) {
            LogInstrumentation.m2730i("AsyncStorage_Next", "SQLite checkpoint not required on this API version.");
        }
        File databasePath = context.getDatabasePath("AsyncStorage");
        File databasePath2 = context.getDatabasePath(ReactDatabaseSupplier.DATABASE_NAME);
        if (databasePath.exists() || !databasePath2.exists()) {
            LogInstrumentation.m2730i("AsyncStorage_Next", "SQLite checkpoint not required.");
            return;
        }
        try {
            ReactDatabaseSupplier reactDatabaseSupplier = ReactDatabaseSupplier.getInstance(context);
            SQLiteDatabase sQLiteDatabase = reactDatabaseSupplier.get();
            if (sQLiteDatabase instanceof SQLiteDatabase) {
                cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "PRAGMA wal_checkpoint", null);
            } else {
                cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA wal_checkpoint", null);
            }
            cursorRawQuery.close();
            reactDatabaseSupplier.closeDatabase();
            LogInstrumentation.m2730i("AsyncStorage_Next", "Forcing SQLite checkpoint successful.");
        } catch (Exception e) {
            LogInstrumentation.m2734w("AsyncStorage_Next", "Could not force checkpoint on RKStorage, the Next storage might not migrate the data properly: " + e.getMessage());
        }
    }
}
