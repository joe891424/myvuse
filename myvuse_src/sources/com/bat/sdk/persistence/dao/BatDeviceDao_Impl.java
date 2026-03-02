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
import com.bat.sdk.persistence.dto.BatDeviceDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class BatDeviceDao_Impl implements BatDeviceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<BatDeviceDto> __insertionAdapterOfBatDeviceDto;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByName;

    public BatDeviceDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfBatDeviceDto = new EntityInsertionAdapter<BatDeviceDto>(__db) { // from class: com.bat.sdk.persistence.dao.BatDeviceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `BatDevice` (`id`,`name`,`address`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final BatDeviceDto entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getName());
                }
                if (entity.getAddress() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getAddress());
                }
            }
        };
        this.__preparedStmtOfDeleteByName = new SharedSQLiteStatement(__db) { // from class: com.bat.sdk.persistence.dao.BatDeviceDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM BatDevice WHERE BatDevice.name LIKE ?";
            }
        };
    }

    @Override // com.bat.sdk.persistence.dao.BatDeviceDao
    public Object insert(final BatDeviceDto device, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.BatDeviceDao_Impl.3
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                BatDeviceDao_Impl.this.__db.beginTransaction();
                try {
                    BatDeviceDao_Impl.this.__insertionAdapterOfBatDeviceDto.insert(device);
                    BatDeviceDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    BatDeviceDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.BatDeviceDao
    public Object deleteByName(final String name, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.BatDeviceDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = BatDeviceDao_Impl.this.__preparedStmtOfDeleteByName.acquire();
                String str = name;
                if (str == null) {
                    supportSQLiteStatementAcquire.bindNull(1);
                } else {
                    supportSQLiteStatementAcquire.bindString(1, str);
                }
                try {
                    BatDeviceDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        BatDeviceDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        BatDeviceDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    BatDeviceDao_Impl.this.__preparedStmtOfDeleteByName.release(supportSQLiteStatementAcquire);
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.BatDeviceDao
    public Object loadAll(final Continuation<? super List<BatDeviceDto>> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BatDevice", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<BatDeviceDto>>() { // from class: com.bat.sdk.persistence.dao.BatDeviceDao_Impl.5
            @Override // java.util.concurrent.Callable
            public List<BatDeviceDto> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(BatDeviceDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "address");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new BatDeviceDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3)));
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
