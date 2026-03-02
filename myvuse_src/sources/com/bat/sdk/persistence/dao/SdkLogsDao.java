package com.bat.sdk.persistence.dao;

import com.bat.sdk.persistence.dto.SdkLogDto;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SdkLogsDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0005¨\u0006\u000b"}, m5598d2 = {"Lcom/bat/sdk/persistence/dao/SdkLogsDao;", "", "getAll", "", "Lcom/bat/sdk/persistence/dto/SdkLogDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "log", "(Lcom/bat/sdk/persistence/dto/SdkLogDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface SdkLogsDao {
    Object deleteAll(Continuation<? super Unit> continuation);

    Object getAll(Continuation<? super List<SdkLogDto>> continuation);

    Object insert(SdkLogDto sdkLogDto, Continuation<? super Unit> continuation);
}
