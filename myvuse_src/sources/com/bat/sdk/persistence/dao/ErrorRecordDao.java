package com.bat.sdk.persistence.dao;

import com.bat.sdk.persistence.dto.ErrorRecordDto;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ErrorRecordDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH§@¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u000bH'J\u001c\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\bH§@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\bH§@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0013\u001a\u00020\rH§@¢\u0006\u0002\u0010\t¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/persistence/dao/ErrorRecordDao;", "", "getById", "Lcom/bat/sdk/persistence/dto/ErrorRecordDto;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "insert", "", FirebaseAnalytics.Param.ITEMS, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "deleteByIds", "ids", "deleteAll", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface ErrorRecordDao {
    Object delete(List<ErrorRecordDto> list, Continuation<? super Unit> continuation);

    Object deleteAll(Continuation<? super Unit> continuation);

    Object deleteByIds(List<Long> list, Continuation<? super Unit> continuation);

    Object getAll(Continuation<? super List<ErrorRecordDto>> continuation);

    Object getById(long j, Continuation<? super ErrorRecordDto> continuation);

    Object insert(List<ErrorRecordDto> list, Continuation<? super Unit> continuation);

    Flow<List<ErrorRecordDto>> observeAll();
}
