package com.bat.sdk.persistence.dao;

import com.bat.sdk.persistence.dto.BatDeviceDto;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: BatDeviceDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/persistence/dao/BatDeviceDao;", "", "insert", "", "device", "Lcom/bat/sdk/persistence/dto/BatDeviceDto;", "(Lcom/bat/sdk/persistence/dto/BatDeviceDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByName", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public interface BatDeviceDao {
    Object deleteByName(String str, Continuation<? super Unit> continuation);

    Object insert(BatDeviceDto batDeviceDto, Continuation<? super Unit> continuation);

    Object loadAll(Continuation<? super List<BatDeviceDto>> continuation);
}
