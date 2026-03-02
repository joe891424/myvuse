package com.bat.sdk.persistence.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p034db.SupportSQLiteStatement;
import com.bat.sdk.persistence.Converters;
import com.bat.sdk.persistence.dto.SdkLogDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkLogsDao_Impl implements SdkLogsDao {
    private final Converters __converters = new Converters();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SdkLogDto> __insertionAdapterOfSdkLogDto;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public SdkLogsDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSdkLogDto = new EntityInsertionAdapter<SdkLogDto>(__db) { // from class: com.bat.sdk.persistence.dao.SdkLogsDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `GeneralLog` (`id`,`date`,`message`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final SdkLogDto entity) {
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, SdkLogsDao_Impl.this.__converters.fromDate(entity.getDate()));
                if (entity.getMessage() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMessage());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) { // from class: com.bat.sdk.persistence.dao.SdkLogsDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM GeneralLog";
            }
        };
    }

    @Override // com.bat.sdk.persistence.dao.SdkLogsDao
    public Object insert(final SdkLogDto log, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.SdkLogsDao_Impl.3
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SdkLogsDao_Impl.this.__db.beginTransaction();
                try {
                    SdkLogsDao_Impl.this.__insertionAdapterOfSdkLogDto.insert(log);
                    SdkLogsDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    SdkLogsDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.SdkLogsDao
    public Object deleteAll(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.SdkLogsDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = SdkLogsDao_Impl.this.__preparedStmtOfDeleteAll.acquire();
                try {
                    SdkLogsDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        SdkLogsDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        SdkLogsDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    SdkLogsDao_Impl.this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.SdkLogsDao
    public Object getAll(final Continuation<? super List<SdkLogDto>> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM GeneralLog", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<SdkLogDto>>() { // from class: com.bat.sdk.persistence.dao.SdkLogsDao_Impl.5
            @Override // java.util.concurrent.Callable
            public List<SdkLogDto> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(SdkLogsDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new SdkLogDto(cursorQuery.getLong(columnIndexOrThrow), SdkLogsDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow2)), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
