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
import com.bat.sdk.persistence.dto.ErrorRecordDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorRecordDao_Impl implements ErrorRecordDao {
    private final Converters __converters = new Converters();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ErrorRecordDto> __deletionAdapterOfErrorRecordDto;
    private final EntityInsertionAdapter<ErrorRecordDto> __insertionAdapterOfErrorRecordDto;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public ErrorRecordDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfErrorRecordDto = new EntityInsertionAdapter<ErrorRecordDto>(__db) { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `ErrorRecord` (`id`,`code`,`timestamp`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final ErrorRecordDto entity) {
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getCode());
                statement.bindLong(3, ErrorRecordDao_Impl.this.__converters.fromDate(entity.getTimestamp()));
            }
        };
        this.__deletionAdapterOfErrorRecordDto = new EntityDeletionOrUpdateAdapter<ErrorRecordDto>(__db) { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `ErrorRecord` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final ErrorRecordDto entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ErrorRecord";
            }
        };
    }

    @Override // com.bat.sdk.persistence.dao.ErrorRecordDao
    public Object insert(final List<ErrorRecordDto> items, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                ErrorRecordDao_Impl.this.__db.beginTransaction();
                try {
                    ErrorRecordDao_Impl.this.__insertionAdapterOfErrorRecordDto.insert((Iterable) items);
                    ErrorRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ErrorRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.ErrorRecordDao
    public Object delete(final List<ErrorRecordDto> items, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                ErrorRecordDao_Impl.this.__db.beginTransaction();
                try {
                    ErrorRecordDao_Impl.this.__deletionAdapterOfErrorRecordDto.handleMultiple(items);
                    ErrorRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ErrorRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.ErrorRecordDao
    public Object deleteAll(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = ErrorRecordDao_Impl.this.__preparedStmtOfDeleteAll.acquire();
                try {
                    ErrorRecordDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        ErrorRecordDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        ErrorRecordDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    ErrorRecordDao_Impl.this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.ErrorRecordDao
    public Object getById(final long id, final Continuation<? super ErrorRecordDto> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ErrorRecord WHERE ErrorRecord.id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<ErrorRecordDto>() { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ErrorRecordDto call() throws Exception {
                ErrorRecordDto errorRecordDto = null;
                Cursor cursorQuery = DBUtil.query(ErrorRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    if (cursorQuery.moveToFirst()) {
                        errorRecordDto = new ErrorRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), ErrorRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3)));
                    }
                    return errorRecordDto;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.ErrorRecordDao
    public Object getAll(final Continuation<? super List<ErrorRecordDto>> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ErrorRecord", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<ErrorRecordDto>>() { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.8
            @Override // java.util.concurrent.Callable
            public List<ErrorRecordDto> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ErrorRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ErrorRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), ErrorRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3))));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.ErrorRecordDao
    public Flow<List<ErrorRecordDto>> observeAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ErrorRecord", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ErrorRecord"}, new Callable<List<ErrorRecordDto>>() { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.9
            @Override // java.util.concurrent.Callable
            public List<ErrorRecordDto> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ErrorRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new ErrorRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), ErrorRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3))));
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

    @Override // com.bat.sdk.persistence.dao.ErrorRecordDao
    public Object deleteByIds(final List<Long> ids, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.ErrorRecordDao_Impl.10
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("DELETE FROM ErrorRecord WHERE ErrorRecord.id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, ids.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = ErrorRecordDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                int i = 1;
                for (Long l : ids) {
                    if (l == null) {
                        supportSQLiteStatementCompileStatement.bindNull(i);
                    } else {
                        supportSQLiteStatementCompileStatement.bindLong(i, l.longValue());
                    }
                    i++;
                }
                ErrorRecordDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    ErrorRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ErrorRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
