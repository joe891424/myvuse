package com.bat.sdk.persistence;

import android.database.sqlite.SQLiteDatabase;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p034db.SupportSQLiteDatabase;
import androidx.sqlite.p034db.SupportSQLiteOpenHelper;
import com.bat.sdk.persistence.dao.BatDeviceDao;
import com.bat.sdk.persistence.dao.BatDeviceDao_Impl;
import com.bat.sdk.persistence.dao.ErrorRecordDao;
import com.bat.sdk.persistence.dao.ErrorRecordDao_Impl;
import com.bat.sdk.persistence.dao.LogRecordDao;
import com.bat.sdk.persistence.dao.LogRecordDao_Impl;
import com.bat.sdk.persistence.dao.PuffRecordDao;
import com.bat.sdk.persistence.dao.PuffRecordDao_Impl;
import com.bat.sdk.persistence.dao.SdkLogsDao;
import com.bat.sdk.persistence.dao.SdkLogsDao_Impl;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkDatabase_Impl extends SdkDatabase {
    private volatile BatDeviceDao _batDeviceDao;
    private volatile ErrorRecordDao _errorRecordDao;
    private volatile LogRecordDao _logRecordDao;
    private volatile PuffRecordDao _puffRecordDao;
    private volatile SdkLogsDao _sdkLogsDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) { // from class: com.bat.sdk.persistence.SdkDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                boolean z = db instanceof SQLiteDatabase;
                if (z) {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "CREATE TABLE IF NOT EXISTS `ErrorRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `code` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
                } else {
                    db.execSQL("CREATE TABLE IF NOT EXISTS `ErrorRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `code` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
                }
                if (!z) {
                    db.execSQL("CREATE TABLE IF NOT EXISTS `LogRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `index` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `type` INTEGER NOT NULL, `code` INTEGER NOT NULL, `data` BLOB NOT NULL, `originalData` BLOB NOT NULL, `deviceAddress` TEXT NOT NULL)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "CREATE TABLE IF NOT EXISTS `LogRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `index` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `type` INTEGER NOT NULL, `code` INTEGER NOT NULL, `data` BLOB NOT NULL, `originalData` BLOB NOT NULL, `deviceAddress` TEXT NOT NULL)");
                }
                if (!z) {
                    db.execSQL("CREATE TABLE IF NOT EXISTS `PuffRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `count` INTEGER NOT NULL, `time` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `level` INTEGER NOT NULL, `data` BLOB NOT NULL, `deviceAddress` TEXT NOT NULL, `podUid` BLOB, `liquidInformation` BLOB, `remainedVolume` INTEGER, `podPuffCount` INTEGER, `syncIndication` INTEGER, `apiVersion` INTEGER, `skuInformation` TEXT)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "CREATE TABLE IF NOT EXISTS `PuffRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `count` INTEGER NOT NULL, `time` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `level` INTEGER NOT NULL, `data` BLOB NOT NULL, `deviceAddress` TEXT NOT NULL, `podUid` BLOB, `liquidInformation` BLOB, `remainedVolume` INTEGER, `podPuffCount` INTEGER, `syncIndication` INTEGER, `apiVersion` INTEGER, `skuInformation` TEXT)");
                }
                if (!z) {
                    db.execSQL("CREATE TABLE IF NOT EXISTS `GeneralLog` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` INTEGER NOT NULL, `message` TEXT NOT NULL)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "CREATE TABLE IF NOT EXISTS `GeneralLog` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` INTEGER NOT NULL, `message` TEXT NOT NULL)");
                }
                if (!z) {
                    db.execSQL("CREATE TABLE IF NOT EXISTS `BatDevice` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "CREATE TABLE IF NOT EXISTS `BatDevice` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL)");
                }
                if (!z) {
                    db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_BatDevice_name` ON `BatDevice` (`name`)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "CREATE UNIQUE INDEX IF NOT EXISTS `index_BatDevice_name` ON `BatDevice` (`name`)");
                }
                if (!z) {
                    db.execSQL(RoomMasterTable.CREATE_QUERY);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, RoomMasterTable.CREATE_QUERY);
                }
                if (!z) {
                    db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ec5698b149e4f4dda757f3d6b7c0234c')");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ec5698b149e4f4dda757f3d6b7c0234c')");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                boolean z = db instanceof SQLiteDatabase;
                if (z) {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "DROP TABLE IF EXISTS `ErrorRecord`");
                } else {
                    db.execSQL("DROP TABLE IF EXISTS `ErrorRecord`");
                }
                if (!z) {
                    db.execSQL("DROP TABLE IF EXISTS `LogRecord`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "DROP TABLE IF EXISTS `LogRecord`");
                }
                if (!z) {
                    db.execSQL("DROP TABLE IF EXISTS `PuffRecord`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "DROP TABLE IF EXISTS `PuffRecord`");
                }
                if (!z) {
                    db.execSQL("DROP TABLE IF EXISTS `GeneralLog`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "DROP TABLE IF EXISTS `GeneralLog`");
                }
                if (!z) {
                    db.execSQL("DROP TABLE IF EXISTS `BatDevice`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) db, "DROP TABLE IF EXISTS `BatDevice`");
                }
                List list = SdkDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        ((RoomDatabase.Callback) it2.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = SdkDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        ((RoomDatabase.Callback) it2.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                SdkDatabase_Impl.this.mDatabase = db;
                SdkDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = SdkDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        ((RoomDatabase.Callback) it2.next()).onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap map = new HashMap(3);
                map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map.put("code", new TableInfo.Column("code", "INTEGER", true, 0, null, 1));
                map.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("ErrorRecord", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(db, "ErrorRecord");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "ErrorRecord(com.bat.sdk.persistence.dto.ErrorRecordDto).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(8);
                map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map2.put(FirebaseAnalytics.Param.INDEX, new TableInfo.Column(FirebaseAnalytics.Param.INDEX, "INTEGER", true, 0, null, 1));
                map2.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                map2.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                map2.put("code", new TableInfo.Column("code", "INTEGER", true, 0, null, 1));
                map2.put("data", new TableInfo.Column("data", "BLOB", true, 0, null, 1));
                map2.put("originalData", new TableInfo.Column("originalData", "BLOB", true, 0, null, 1));
                map2.put("deviceAddress", new TableInfo.Column("deviceAddress", "TEXT", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("LogRecord", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(db, "LogRecord");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "LogRecord(com.bat.sdk.persistence.dto.LogRecordDto).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(14);
                map3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map3.put(NewHtcHomeBadger.COUNT, new TableInfo.Column(NewHtcHomeBadger.COUNT, "INTEGER", true, 0, null, 1));
                map3.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                map3.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, 1));
                map3.put(FirebaseAnalytics.Param.LEVEL, new TableInfo.Column(FirebaseAnalytics.Param.LEVEL, "INTEGER", true, 0, null, 1));
                map3.put("data", new TableInfo.Column("data", "BLOB", true, 0, null, 1));
                map3.put("deviceAddress", new TableInfo.Column("deviceAddress", "TEXT", true, 0, null, 1));
                map3.put("podUid", new TableInfo.Column("podUid", "BLOB", false, 0, null, 1));
                map3.put("liquidInformation", new TableInfo.Column("liquidInformation", "BLOB", false, 0, null, 1));
                map3.put("remainedVolume", new TableInfo.Column("remainedVolume", "INTEGER", false, 0, null, 1));
                map3.put("podPuffCount", new TableInfo.Column("podPuffCount", "INTEGER", false, 0, null, 1));
                map3.put("syncIndication", new TableInfo.Column("syncIndication", "INTEGER", false, 0, null, 1));
                map3.put("apiVersion", new TableInfo.Column("apiVersion", "INTEGER", false, 0, null, 1));
                map3.put("skuInformation", new TableInfo.Column("skuInformation", "TEXT", false, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("PuffRecord", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(db, "PuffRecord");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "PuffRecord(com.bat.sdk.persistence.dto.PuffRecordDto).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(3);
                map4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map4.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, 1));
                map4.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("GeneralLog", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(db, "GeneralLog");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "GeneralLog(com.bat.sdk.persistence.dto.SdkLogDto).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(3);
                map5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map5.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map5.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_BatDevice_name", true, Arrays.asList("name"), Arrays.asList("ASC")));
                TableInfo tableInfo9 = new TableInfo("BatDevice", map5, hashSet, hashSet2);
                TableInfo tableInfo10 = TableInfo.read(db, "BatDevice");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "BatDevice(com.bat.sdk.persistence.dto.BatDeviceDto).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "ec5698b149e4f4dda757f3d6b7c0234c", "fda6bee1de6cacc78114c2b8bef3f800")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ErrorRecord", "LogRecord", "PuffRecord", "GeneralLog", "BatDevice");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `ErrorRecord`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `ErrorRecord`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `LogRecord`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `LogRecord`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `PuffRecord`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `PuffRecord`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `GeneralLog`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `GeneralLog`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `BatDevice`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `BatDevice`");
            }
            super.setTransactionSuccessful();
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (writableDatabase.inTransaction()) {
                return;
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("VACUUM");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "VACUUM");
            }
        } catch (Throwable th) {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                if (!(writableDatabase instanceof SQLiteDatabase)) {
                    writableDatabase.execSQL("VACUUM");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "VACUUM");
                }
            }
            throw th;
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(ErrorRecordDao.class, ErrorRecordDao_Impl.getRequiredConverters());
        map.put(LogRecordDao.class, LogRecordDao_Impl.getRequiredConverters());
        map.put(PuffRecordDao.class, PuffRecordDao_Impl.getRequiredConverters());
        map.put(SdkLogsDao.class, SdkLogsDao_Impl.getRequiredConverters());
        map.put(BatDeviceDao.class, BatDeviceDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // com.bat.sdk.persistence.SdkDatabase
    public ErrorRecordDao errorRecordDao() {
        ErrorRecordDao errorRecordDao;
        if (this._errorRecordDao != null) {
            return this._errorRecordDao;
        }
        synchronized (this) {
            if (this._errorRecordDao == null) {
                this._errorRecordDao = new ErrorRecordDao_Impl(this);
            }
            errorRecordDao = this._errorRecordDao;
        }
        return errorRecordDao;
    }

    @Override // com.bat.sdk.persistence.SdkDatabase
    public LogRecordDao logRecordDao() {
        LogRecordDao logRecordDao;
        if (this._logRecordDao != null) {
            return this._logRecordDao;
        }
        synchronized (this) {
            if (this._logRecordDao == null) {
                this._logRecordDao = new LogRecordDao_Impl(this);
            }
            logRecordDao = this._logRecordDao;
        }
        return logRecordDao;
    }

    @Override // com.bat.sdk.persistence.SdkDatabase
    public PuffRecordDao puffRecordDao() {
        PuffRecordDao puffRecordDao;
        if (this._puffRecordDao != null) {
            return this._puffRecordDao;
        }
        synchronized (this) {
            if (this._puffRecordDao == null) {
                this._puffRecordDao = new PuffRecordDao_Impl(this);
            }
            puffRecordDao = this._puffRecordDao;
        }
        return puffRecordDao;
    }

    @Override // com.bat.sdk.persistence.SdkDatabase
    public SdkLogsDao generalLogDao() {
        SdkLogsDao sdkLogsDao;
        if (this._sdkLogsDao != null) {
            return this._sdkLogsDao;
        }
        synchronized (this) {
            if (this._sdkLogsDao == null) {
                this._sdkLogsDao = new SdkLogsDao_Impl(this);
            }
            sdkLogsDao = this._sdkLogsDao;
        }
        return sdkLogsDao;
    }

    @Override // com.bat.sdk.persistence.SdkDatabase
    public BatDeviceDao batDeviceDao() {
        BatDeviceDao batDeviceDao;
        if (this._batDeviceDao != null) {
            return this._batDeviceDao;
        }
        synchronized (this) {
            if (this._batDeviceDao == null) {
                this._batDeviceDao = new BatDeviceDao_Impl(this);
            }
            batDeviceDao = this._batDeviceDao;
        }
        return batDeviceDao;
    }
}
