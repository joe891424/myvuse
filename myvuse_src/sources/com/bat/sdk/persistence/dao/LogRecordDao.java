package com.bat.sdk.persistence.dao;

import com.bat.sdk.persistence.dto.LogRecordDto;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: LogRecordDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\bH§@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u000f2\u0006\u0010\t\u001a\u00020\nH'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u000fH'J\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\bH§@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\bH§@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0016\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0019\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\r¨\u0006\u001a"}, m5598d2 = {"Lcom/bat/sdk/persistence/dao/LogRecordDao;", "", "getById", "Lcom/bat/sdk/persistence/dto/LogRecordDto;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByDeviceAddress", "", "deviceAddress", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeByDeviceAddress", "Lkotlinx/coroutines/flow/Flow;", "observeAll", "insert", "", FirebaseAnalytics.Param.ITEMS, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "deleteByIds", "ids", "deleteByDeviceAddress", "deleteAll", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface LogRecordDao {
    Object delete(List<LogRecordDto> list, Continuation<? super Unit> continuation);

    Object deleteAll(Continuation<? super Unit> continuation);

    Object deleteByDeviceAddress(String str, Continuation<? super Unit> continuation);

    Object deleteByIds(List<Long> list, Continuation<? super Unit> continuation);

    Object getAll(Continuation<? super List<LogRecordDto>> continuation);

    Object getByDeviceAddress(String str, Continuation<? super List<LogRecordDto>> continuation);

    Object getById(long j, Continuation<? super LogRecordDto> continuation);

    Object insert(List<LogRecordDto> list, Continuation<? super Unit> continuation);

    Flow<List<LogRecordDto>> observeAll();

    Flow<List<LogRecordDto>> observeByDeviceAddress(String deviceAddress);
}
