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
import com.bat.sdk.persistence.dto.PuffRecordDto;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: loaded from: classes3.dex */
public final class PuffRecordDao_Impl implements PuffRecordDao {
    private final Converters __converters = new Converters();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PuffRecordDto> __deletionAdapterOfPuffRecordDto;
    private final EntityInsertionAdapter<PuffRecordDto> __insertionAdapterOfPuffRecordDto;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByDeviceAddress;

    public PuffRecordDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPuffRecordDto = new EntityInsertionAdapter<PuffRecordDto>(__db) { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `PuffRecord` (`id`,`count`,`time`,`duration`,`level`,`data`,`deviceAddress`,`podUid`,`liquidInformation`,`remainedVolume`,`podPuffCount`,`syncIndication`,`apiVersion`,`skuInformation`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PuffRecordDto entity) {
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getCount());
                statement.bindLong(3, PuffRecordDao_Impl.this.__converters.fromDate(entity.getTime()));
                statement.bindLong(4, entity.getDuration());
                statement.bindLong(5, entity.getLevel());
                if (entity.getData() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindBlob(6, entity.getData());
                }
                if (entity.getDeviceAddress() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getDeviceAddress());
                }
                if (entity.getPodUid() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindBlob(8, entity.getPodUid());
                }
                if (entity.getLiquidInformation() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindBlob(9, entity.getLiquidInformation());
                }
                if (entity.getRemainedVolume() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindLong(10, entity.getRemainedVolume().intValue());
                }
                if (entity.getPodPuffCount() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindLong(11, entity.getPodPuffCount().intValue());
                }
                if (entity.getSyncIndication() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindLong(12, entity.getSyncIndication().intValue());
                }
                if (entity.getApiVersion() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindLong(13, entity.getApiVersion().intValue());
                }
                if (entity.getSkuInformation() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getSkuInformation());
                }
            }
        };
        this.__deletionAdapterOfPuffRecordDto = new EntityDeletionOrUpdateAdapter<PuffRecordDto>(__db) { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `PuffRecord` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PuffRecordDto entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteByDeviceAddress = new SharedSQLiteStatement(__db) { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PuffRecord WHERE PuffRecord.deviceAddress = ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PuffRecord";
            }
        };
    }

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Object insert(final List<PuffRecordDto> items, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PuffRecordDao_Impl.this.__db.beginTransaction();
                try {
                    PuffRecordDao_Impl.this.__insertionAdapterOfPuffRecordDto.insert((Iterable) items);
                    PuffRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PuffRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Object delete(final List<PuffRecordDto> items, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PuffRecordDao_Impl.this.__db.beginTransaction();
                try {
                    PuffRecordDao_Impl.this.__deletionAdapterOfPuffRecordDto.handleMultiple(items);
                    PuffRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PuffRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Object deleteByDeviceAddress(final String deviceAddress, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = PuffRecordDao_Impl.this.__preparedStmtOfDeleteByDeviceAddress.acquire();
                String str = deviceAddress;
                if (str == null) {
                    supportSQLiteStatementAcquire.bindNull(1);
                } else {
                    supportSQLiteStatementAcquire.bindString(1, str);
                }
                try {
                    PuffRecordDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        PuffRecordDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        PuffRecordDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    PuffRecordDao_Impl.this.__preparedStmtOfDeleteByDeviceAddress.release(supportSQLiteStatementAcquire);
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Object deleteAll(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.8
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = PuffRecordDao_Impl.this.__preparedStmtOfDeleteAll.acquire();
                try {
                    PuffRecordDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        PuffRecordDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        PuffRecordDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    PuffRecordDao_Impl.this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Object getById(final long id, final Continuation<? super PuffRecordDto> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PuffRecord WHERE PuffRecord.id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<PuffRecordDto>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PuffRecordDto call() throws Exception {
                PuffRecordDto puffRecordDto;
                Cursor cursorQuery = DBUtil.query(PuffRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NewHtcHomeBadger.COUNT);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.LEVEL);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podUid");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liquidInformation");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remainedVolume");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podPuffCount");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "syncIndication");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "apiVersion");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skuInformation");
                    if (cursorQuery.moveToFirst()) {
                        puffRecordDto = new PuffRecordDto(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), PuffRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3)), cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getBlob(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getBlob(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.isNull(columnIndexOrThrow12) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow12)), cursorQuery.isNull(columnIndexOrThrow13) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow13)), cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    } else {
                        puffRecordDto = null;
                    }
                    return puffRecordDto;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Object getByDeviceAddress(final String deviceAddress, final Continuation<? super List<PuffRecordDto>> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PuffRecord WHERE PuffRecord.deviceAddress = ?", 1);
        if (deviceAddress == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, deviceAddress);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<PuffRecordDto>>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List<PuffRecordDto> call() throws Exception {
                Integer numValueOf;
                int i;
                Integer numValueOf2;
                int i2;
                Cursor cursorQuery = DBUtil.query(PuffRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NewHtcHomeBadger.COUNT);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.LEVEL);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podUid");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liquidInformation");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remainedVolume");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podPuffCount");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "syncIndication");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "apiVersion");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skuInformation");
                    int i3 = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i4 = cursorQuery.getInt(columnIndexOrThrow2);
                        int i5 = columnIndexOrThrow2;
                        ArrayList arrayList2 = arrayList;
                        int i6 = columnIndexOrThrow;
                        Date dateFromTimeStamp = PuffRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3));
                        long j2 = cursorQuery.getLong(columnIndexOrThrow4);
                        int i7 = cursorQuery.getInt(columnIndexOrThrow5);
                        byte[] blob = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6);
                        String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        byte[] blob2 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getBlob(columnIndexOrThrow8);
                        byte[] blob3 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getBlob(columnIndexOrThrow9);
                        Integer numValueOf3 = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf4 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        if (cursorQuery.isNull(columnIndexOrThrow12)) {
                            i = i3;
                            numValueOf = null;
                        } else {
                            numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow12));
                            i = i3;
                        }
                        if (cursorQuery.isNull(i)) {
                            i2 = columnIndexOrThrow14;
                            numValueOf2 = null;
                        } else {
                            numValueOf2 = Integer.valueOf(cursorQuery.getInt(i));
                            i2 = columnIndexOrThrow14;
                        }
                        i3 = i;
                        arrayList2.add(new PuffRecordDto(j, i4, dateFromTimeStamp, j2, i7, blob, string, blob2, blob3, numValueOf3, numValueOf4, numValueOf, numValueOf2, cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2)));
                        arrayList = arrayList2;
                        columnIndexOrThrow14 = i2;
                        columnIndexOrThrow2 = i5;
                        columnIndexOrThrow = i6;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Object getAll(final Continuation<? super List<PuffRecordDto>> $completion) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PuffRecord", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<PuffRecordDto>>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.11
            @Override // java.util.concurrent.Callable
            public List<PuffRecordDto> call() throws Exception {
                Integer numValueOf;
                int i;
                Integer numValueOf2;
                int i2;
                Cursor cursorQuery = DBUtil.query(PuffRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NewHtcHomeBadger.COUNT);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.LEVEL);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podUid");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liquidInformation");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remainedVolume");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podPuffCount");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "syncIndication");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "apiVersion");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skuInformation");
                    int i3 = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i4 = cursorQuery.getInt(columnIndexOrThrow2);
                        int i5 = columnIndexOrThrow2;
                        ArrayList arrayList2 = arrayList;
                        int i6 = columnIndexOrThrow;
                        Date dateFromTimeStamp = PuffRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3));
                        long j2 = cursorQuery.getLong(columnIndexOrThrow4);
                        int i7 = cursorQuery.getInt(columnIndexOrThrow5);
                        byte[] blob = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6);
                        String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        byte[] blob2 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getBlob(columnIndexOrThrow8);
                        byte[] blob3 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getBlob(columnIndexOrThrow9);
                        Integer numValueOf3 = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf4 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        if (cursorQuery.isNull(columnIndexOrThrow12)) {
                            i = i3;
                            numValueOf = null;
                        } else {
                            numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow12));
                            i = i3;
                        }
                        if (cursorQuery.isNull(i)) {
                            i2 = columnIndexOrThrow14;
                            numValueOf2 = null;
                        } else {
                            numValueOf2 = Integer.valueOf(cursorQuery.getInt(i));
                            i2 = columnIndexOrThrow14;
                        }
                        i3 = i;
                        arrayList2.add(new PuffRecordDto(j, i4, dateFromTimeStamp, j2, i7, blob, string, blob2, blob3, numValueOf3, numValueOf4, numValueOf, numValueOf2, cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2)));
                        arrayList = arrayList2;
                        columnIndexOrThrow14 = i2;
                        columnIndexOrThrow2 = i5;
                        columnIndexOrThrow = i6;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, $completion);
    }

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Flow<List<PuffRecordDto>> observeAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PuffRecord", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"PuffRecord"}, new Callable<List<PuffRecordDto>>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.12
            @Override // java.util.concurrent.Callable
            public List<PuffRecordDto> call() throws Exception {
                Integer numValueOf;
                int i;
                Integer numValueOf2;
                int i2;
                Cursor cursorQuery = DBUtil.query(PuffRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NewHtcHomeBadger.COUNT);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.LEVEL);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podUid");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liquidInformation");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remainedVolume");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podPuffCount");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "syncIndication");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "apiVersion");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skuInformation");
                    int i3 = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i4 = cursorQuery.getInt(columnIndexOrThrow2);
                        int i5 = columnIndexOrThrow2;
                        ArrayList arrayList2 = arrayList;
                        int i6 = columnIndexOrThrow;
                        Date dateFromTimeStamp = PuffRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3));
                        long j2 = cursorQuery.getLong(columnIndexOrThrow4);
                        int i7 = cursorQuery.getInt(columnIndexOrThrow5);
                        byte[] blob = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6);
                        String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        byte[] blob2 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getBlob(columnIndexOrThrow8);
                        byte[] blob3 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getBlob(columnIndexOrThrow9);
                        Integer numValueOf3 = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf4 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        if (cursorQuery.isNull(columnIndexOrThrow12)) {
                            i = i3;
                            numValueOf = null;
                        } else {
                            numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow12));
                            i = i3;
                        }
                        if (cursorQuery.isNull(i)) {
                            i2 = columnIndexOrThrow14;
                            numValueOf2 = null;
                        } else {
                            numValueOf2 = Integer.valueOf(cursorQuery.getInt(i));
                            i2 = columnIndexOrThrow14;
                        }
                        i3 = i;
                        arrayList2.add(new PuffRecordDto(j, i4, dateFromTimeStamp, j2, i7, blob, string, blob2, blob3, numValueOf3, numValueOf4, numValueOf, numValueOf2, cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2)));
                        arrayList = arrayList2;
                        columnIndexOrThrow14 = i2;
                        columnIndexOrThrow2 = i5;
                        columnIndexOrThrow = i6;
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

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Flow<List<PuffRecordDto>> observeByDeviceAddress(final String deviceAddress) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PuffRecord WHERE PuffRecord.deviceAddress = ?", 1);
        if (deviceAddress == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, deviceAddress);
        }
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"PuffRecord"}, new Callable<List<PuffRecordDto>>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.13
            @Override // java.util.concurrent.Callable
            public List<PuffRecordDto> call() throws Exception {
                Integer numValueOf;
                int i;
                Integer numValueOf2;
                int i2;
                Cursor cursorQuery = DBUtil.query(PuffRecordDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, NewHtcHomeBadger.COUNT);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.LEVEL);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceAddress");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podUid");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liquidInformation");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remainedVolume");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "podPuffCount");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "syncIndication");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "apiVersion");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skuInformation");
                    int i3 = columnIndexOrThrow13;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        int i4 = cursorQuery.getInt(columnIndexOrThrow2);
                        int i5 = columnIndexOrThrow2;
                        ArrayList arrayList2 = arrayList;
                        int i6 = columnIndexOrThrow;
                        Date dateFromTimeStamp = PuffRecordDao_Impl.this.__converters.fromTimeStamp(cursorQuery.getLong(columnIndexOrThrow3));
                        long j2 = cursorQuery.getLong(columnIndexOrThrow4);
                        int i7 = cursorQuery.getInt(columnIndexOrThrow5);
                        byte[] blob = cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6);
                        String string = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        byte[] blob2 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getBlob(columnIndexOrThrow8);
                        byte[] blob3 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getBlob(columnIndexOrThrow9);
                        Integer numValueOf3 = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf4 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        if (cursorQuery.isNull(columnIndexOrThrow12)) {
                            i = i3;
                            numValueOf = null;
                        } else {
                            numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow12));
                            i = i3;
                        }
                        if (cursorQuery.isNull(i)) {
                            i2 = columnIndexOrThrow14;
                            numValueOf2 = null;
                        } else {
                            numValueOf2 = Integer.valueOf(cursorQuery.getInt(i));
                            i2 = columnIndexOrThrow14;
                        }
                        i3 = i;
                        arrayList2.add(new PuffRecordDto(j, i4, dateFromTimeStamp, j2, i7, blob, string, blob2, blob3, numValueOf3, numValueOf4, numValueOf, numValueOf2, cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2)));
                        arrayList = arrayList2;
                        columnIndexOrThrow14 = i2;
                        columnIndexOrThrow2 = i5;
                        columnIndexOrThrow = i6;
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

    @Override // com.bat.sdk.persistence.dao.PuffRecordDao
    public Object deleteByIds(final List<Long> ids, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.bat.sdk.persistence.dao.PuffRecordDao_Impl.14
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("DELETE FROM PuffRecord WHERE PuffRecord.id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, ids.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = PuffRecordDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                int i = 1;
                for (Long l : ids) {
                    if (l == null) {
                        supportSQLiteStatementCompileStatement.bindNull(i);
                    } else {
                        supportSQLiteStatementCompileStatement.bindLong(i, l.longValue());
                    }
                    i++;
                }
                PuffRecordDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    PuffRecordDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PuffRecordDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
