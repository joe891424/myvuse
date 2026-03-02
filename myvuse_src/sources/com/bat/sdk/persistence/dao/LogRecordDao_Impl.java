package com.bat.sdk.persistence.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p034db.SupportSQLiteStatement;
import com.bat.sdk.persistence.Converters;
import com.bat.sdk.persistence.dto.LogRecordDto;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes3.dex */
public final class LogRecordDao_Impl implements LogRecordDao {
    private final Converters __converters = new Converters();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<LogRecordDto> __deletionAdapterOfLogRecordDto;
    private final EntityInsertionAdapter<LogRecordDto> __insertionAdapterOfLogRecordDto;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByDeviceAddress;

    public LogRecordDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfLogRecordDto = new EntityInsertionAdapter<LogRecordDto>(__db) { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `LogRecord` (`id`,`index`,`timestamp`,`type`,`code`,`data`,`originalData`,`deviceAddress`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final LogRecordDto entity) {
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getIndex());
                statement.bindLong(3, LogRecordDao_Impl.this.__converters.fromDate(entity.getTimestamp()));
                statement.bindLong(4, entity.getType());
                statement.bindLong(5, entity.getCode());
                if (entity.getData() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindBlob(6, entity.getData());
                }
                if (entity.getOriginalData() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindBlob(7, entity.getOriginalData());
                }
                if (entity.getDeviceAddress() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getDeviceAddress());
                }
            }
        };
        this.__deletionAdapterOfLogRecordDto = new EntityDeletionOrUpdateAdapter<LogRecordDto>(__db) { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `LogRecord` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final LogRecordDto entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteByDeviceAddress = new SharedSQLiteStatement(__db) { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LogRecord WHERE LogRecord.deviceAddress = ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LogRecord";
            }
        };
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Object insert(final List<LogRecordDto> items, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                LogRecordDao_Impl.this.__db.beginTransaction();
                try {
                    LogRecordDao_Impl.this.__insertionAdapterOfLogRecordDto.insert((Iterable) items);
                    LogRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LogRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Object delete(final List<LogRecordDto> items, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                LogRecordDao_Impl.this.__db.beginTransaction();
                try {
                    LogRecordDao_Impl.this.__deletionAdapterOfLogRecordDto.handleMultiple(items);
                    LogRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LogRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Object deleteByDeviceAddress(final String deviceAddress, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = LogRecordDao_Impl.this.__preparedStmtOfDeleteByDeviceAddress.acquire();
                String str = deviceAddress;
                if (str == null) {
                    supportSQLiteStatementAcquire.bindNull(1);
                } else {
                    supportSQLiteStatementAcquire.bindString(1, str);
                }
                try {
                    LogRecordDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        LogRecordDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        LogRecordDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    LogRecordDao_Impl.this.__preparedStmtOfDeleteByDeviceAddress.release(supportSQLiteStatementAcquire);
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Object deleteAll(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.8
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = LogRecordDao_Impl.this.__preparedStmtOfDeleteAll.acquire();
                try {
                    LogRecordDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        LogRecordDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        LogRecordDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    LogRecordDao_Impl.this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Object getById(final long id, final Continuation<? super LogRecordDto> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LogRecord WHERE LogRecord.id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<LogRecordDto>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LogRecordDto call() throws Exception {
                LogRecordDto logRecordDto = null;
                Cursor cursorQuery = DBUtil.query(LogRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.INDEX);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalData");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    if (cursorQuery.moveToFirst()) {
                        logRecordDto = new LogRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), LogRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3)), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getBlob(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    }
                    return logRecordDto;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Object getByDeviceAddress(final String deviceAddress, final Continuation<? super List<LogRecordDto>> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LogRecord WHERE LogRecord.deviceAddress = ?", 1);
        if (deviceAddress == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, deviceAddress);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<LogRecordDto>>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List<LogRecordDto> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(LogRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.INDEX);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalData");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new LogRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), LogRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3)), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getBlob(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Object getAll(final Continuation<? super List<LogRecordDto>> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LogRecord", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<LogRecordDto>>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.11
            @Override // java.util.concurrent.Callable
            public List<LogRecordDto> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(LogRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.INDEX);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalData");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new LogRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), LogRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3)), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getBlob(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Flow<List<LogRecordDto>> observeByDeviceAddress(final String deviceAddress) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LogRecord WHERE LogRecord.deviceAddress = ?", 1);
        if (deviceAddress == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, deviceAddress);
        }
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"LogRecord"}, new Callable<List<LogRecordDto>>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.12
            @Override // java.util.concurrent.Callable
            public List<LogRecordDto> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(LogRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.INDEX);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalData");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new LogRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), LogRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3)), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getBlob(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Flow<List<LogRecordDto>> observeAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LogRecord", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"LogRecord"}, new Callable<List<LogRecordDto>>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.13
            @Override // java.util.concurrent.Callable
            public List<LogRecordDto> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(LogRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.INDEX);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalData");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new LogRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), LogRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3)), cursorQuery.getInt(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getBlob(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.bat.sdk.persistence.dao.LogRecordDao
    public Object deleteByIds(final List<Long> ids, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.LogRecordDao_Impl.14
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("DELETE FROM LogRecord WHERE LogRecord.id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, ids.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = LogRecordDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                int i = 1;
                for (Long l : ids) {
                    if (l == null) {
                        supportSQLiteStatementCompileStatement.bindNull(i);
                    } else {
                        supportSQLiteStatementCompileStatement.bindLong(i, l.longValue());
                    }
                    i++;
                }
                LogRecordDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    LogRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LogRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
