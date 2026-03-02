package com.yoti.mobile.android.liveness.data;

import com.google.gson.Gson;
import com.yoti.mobile.android.liveness.data.remote.model.LivenessValidationException;
import com.yoti.mobile.android.liveness.domain.model.LivenessValidationError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/data/LivenessExceptionToEntityMapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "map", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "from", "", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessExceptionToEntityMapper extends DataExceptionToEntityMapper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LivenessExceptionToEntityMapper(Gson gson) {
        super(gson);
        Intrinsics.checkNotNullParameter(gson, "gson");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper, com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper, com.yoti.mobile.android.yotidocs.common.Mapper
    public YotiDocsError map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return from instanceof LivenessValidationException ? new LivenessValidationError(((LivenessValidationException) from).getAttemptsLeft(), from) : super.map(from);
    }
}
