package com.reactnativecommunity.asyncstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = AsyncStorageModule.NAME)
public final class AsyncStorageModule extends NativeAsyncStorageModuleSpec implements ModuleDataCleaner.Cleanable, LifecycleEventListener {
    private static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "RNCAsyncStorage";
    private final SerialExecutor executor;
    private ReactDatabaseSupplier mReactDatabaseSupplier;
    private boolean mShuttingDown;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @VisibleForTesting
    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor) throws Throwable {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        AsyncStorageExpoMigration.migrate(reactApplicationContext);
        this.executor = new SerialExecutor(executor);
        reactApplicationContext.addLifecycleEventListener(this);
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    @Override // com.facebook.react.modules.common.ModuleDataCleaner.Cleanable
    public void clearSensitiveData() {
        this.mReactDatabaseSupplier.clearAndCloseDatabase();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        this.mReactDatabaseSupplier.closeDatabase();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$1] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError(null), null);
            return;
        }
        ?? r0 = new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                int i;
                Cursor cursorQuery;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null), null);
                    return;
                }
                String[] strArr = {"key", "value"};
                HashSet<String> hashSet = new HashSet();
                WritableArray writableArrayCreateArray = Arguments.createArray();
                for (int i2 = 0; i2 < readableArray.size(); i2 += 999) {
                    int iMin = Math.min(readableArray.size() - i2, 999);
                    SQLiteDatabase sQLiteDatabase = AsyncStorageModule.this.mReactDatabaseSupplier.get();
                    String strBuildKeySelection = AsyncLocalStorageUtil.buildKeySelection(iMin);
                    String[] strArrBuildKeySelectionArgs = AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i2, iMin);
                    if (sQLiteDatabase instanceof SQLiteDatabase) {
                        i = iMin;
                        cursorQuery = SQLiteInstrumentation.query(sQLiteDatabase, "catalystLocalStorage", strArr, strBuildKeySelection, strArrBuildKeySelectionArgs, null, null, null);
                    } else {
                        i = iMin;
                        cursorQuery = sQLiteDatabase.query("catalystLocalStorage", strArr, strBuildKeySelection, strArrBuildKeySelectionArgs, null, null, null);
                    }
                    hashSet.clear();
                    try {
                        try {
                            if (cursorQuery.getCount() != readableArray.size()) {
                                for (int i3 = i2; i3 < i2 + i; i3++) {
                                    hashSet.add(readableArray.getString(i3));
                                }
                            }
                            if (cursorQuery.moveToFirst()) {
                                do {
                                    WritableArray writableArrayCreateArray2 = Arguments.createArray();
                                    writableArrayCreateArray2.pushString(cursorQuery.getString(0));
                                    writableArrayCreateArray2.pushString(cursorQuery.getString(1));
                                    writableArrayCreateArray.pushArray(writableArrayCreateArray2);
                                    hashSet.remove(cursorQuery.getString(0));
                                } while (cursorQuery.moveToNext());
                            }
                            cursorQuery.close();
                            for (String str : hashSet) {
                                WritableArray writableArrayCreateArray3 = Arguments.createArray();
                                writableArrayCreateArray3.pushString(str);
                                writableArrayCreateArray3.pushNull();
                                writableArrayCreateArray.pushArray(writableArrayCreateArray3);
                            }
                            hashSet.clear();
                        } catch (Exception e) {
                            FLog.m1318w(ReactConstants.TAG, e.getMessage(), e);
                            callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()), null);
                            cursorQuery.close();
                            return;
                        }
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                callback.invoke(null, writableArrayCreateArray);
            }
        };
        SerialExecutor serialExecutor = this.executor;
        Void[] voidArr = new Void[0];
        if (r0 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask) r0, serialExecutor, voidArr);
        } else {
            r0.executeOnExecutor(serialExecutor, voidArr);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$2] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
            return;
        }
        ?? r0 = new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0158  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0162  */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void doInBackgroundGuarded(java.lang.Void... r8) {
                /*
                    Method dump skipped, instruction units count: 392
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.AsyncStorageModule.AsyncTaskC39422.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        };
        SerialExecutor serialExecutor = this.executor;
        Void[] voidArr = new Void[0];
        if (r0 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask) r0, serialExecutor, voidArr);
        } else {
            r0.executeOnExecutor(serialExecutor, voidArr);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$3] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
            return;
        }
        ?? r0 = new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void doInBackgroundGuarded(java.lang.Void... r9) {
                /*
                    Method dump skipped, instruction units count: 246
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.AsyncStorageModule.AsyncTaskC39433.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        };
        SerialExecutor serialExecutor = this.executor;
        Void[] voidArr = new Void[0];
        if (r0 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask) r0, serialExecutor, voidArr);
        } else {
            r0.executeOnExecutor(serialExecutor, voidArr);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$4] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void multiMerge(final ReadableArray readableArray, final Callback callback) {
        ?? r0 = new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0170  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x017a  */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void doInBackgroundGuarded(java.lang.Void... r8) {
                /*
                    Method dump skipped, instruction units count: 416
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.AsyncStorageModule.AsyncTaskC39444.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        };
        SerialExecutor serialExecutor = this.executor;
        Void[] voidArr = new Void[0];
        if (r0 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask) r0, serialExecutor, voidArr);
        } else {
            r0.executeOnExecutor(serialExecutor, voidArr);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$5] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void clear(final Callback callback) {
        ?? r0 = new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                    callback.invoke(new Object[0]);
                } catch (Exception e) {
                    FLog.m1318w(ReactConstants.TAG, e.getMessage(), e);
                    callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()));
                }
            }
        };
        SerialExecutor serialExecutor = this.executor;
        Void[] voidArr = new Void[0];
        if (r0 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask) r0, serialExecutor, voidArr);
        } else {
            r0.executeOnExecutor(serialExecutor, voidArr);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativecommunity.asyncstorage.AsyncStorageModule$6] */
    @Override // com.reactnativecommunity.asyncstorage.NativeAsyncStorageModuleSpec
    @ReactMethod
    public void getAllKeys(final Callback callback) {
        ?? r0 = new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) { // from class: com.reactnativecommunity.asyncstorage.AsyncStorageModule.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null), null);
                    return;
                }
                WritableArray writableArrayCreateArray = Arguments.createArray();
                String[] strArr = {"key"};
                SQLiteDatabase sQLiteDatabase = AsyncStorageModule.this.mReactDatabaseSupplier.get();
                Cursor cursorQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.query("catalystLocalStorage", strArr, null, null, null, null, null) : SQLiteInstrumentation.query(sQLiteDatabase, "catalystLocalStorage", strArr, null, null, null, null, null);
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                writableArrayCreateArray.pushString(cursorQuery.getString(0));
                            } while (cursorQuery.moveToNext());
                        }
                        cursorQuery.close();
                        callback.invoke(null, writableArrayCreateArray);
                    } catch (Exception e) {
                        FLog.m1318w(ReactConstants.TAG, e.getMessage(), e);
                        callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()), null);
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
        };
        SerialExecutor serialExecutor = this.executor;
        Void[] voidArr = new Void[0];
        if (r0 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask) r0, serialExecutor, voidArr);
        } else {
            r0.executeOnExecutor(serialExecutor, voidArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureDatabase() {
        return !this.mShuttingDown && this.mReactDatabaseSupplier.ensureDatabase();
    }
}
