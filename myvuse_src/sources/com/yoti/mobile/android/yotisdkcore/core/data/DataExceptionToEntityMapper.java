package com.yoti.mobile.android.yotisdkcore.core.data;

import com.google.gson.Gson;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "map", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "from", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class DataExceptionToEntityMapper extends RemoteExceptionToEntityMapper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DataExceptionToEntityMapper(Gson gson) {
        super(gson);
        Intrinsics.checkNotNullParameter(gson, "gson");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper, com.yoti.mobile.android.yotidocs.common.Mapper
    public YotiDocsError map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return from instanceof YotiDocsError ? (YotiDocsError) from : super.map(from);
    }
}
