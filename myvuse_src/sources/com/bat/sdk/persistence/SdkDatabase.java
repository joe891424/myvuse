package com.bat.sdk.persistence;

import androidx.room.RoomDatabase;
import com.bat.sdk.persistence.dao.BatDeviceDao;
import com.bat.sdk.persistence.dao.ErrorRecordDao;
import com.bat.sdk.persistence.dao.LogRecordDao;
import com.bat.sdk.persistence.dao.PuffRecordDao;
import com.bat.sdk.persistence.dao.SdkLogsDao;
import kotlin.Metadata;

/* JADX INFO: compiled from: SdkDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/persistence/SdkDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "errorRecordDao", "Lcom/bat/sdk/persistence/dao/ErrorRecordDao;", "logRecordDao", "Lcom/bat/sdk/persistence/dao/LogRecordDao;", "puffRecordDao", "Lcom/bat/sdk/persistence/dao/PuffRecordDao;", "generalLogDao", "Lcom/bat/sdk/persistence/dao/SdkLogsDao;", "batDeviceDao", "Lcom/bat/sdk/persistence/dao/BatDeviceDao;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public abstract class SdkDatabase extends RoomDatabase {
    public abstract BatDeviceDao batDeviceDao();

    public abstract ErrorRecordDao errorRecordDao();

    public abstract SdkLogsDao generalLogDao();

    public abstract LogRecordDao logRecordDao();

    public abstract PuffRecordDao puffRecordDao();
}
