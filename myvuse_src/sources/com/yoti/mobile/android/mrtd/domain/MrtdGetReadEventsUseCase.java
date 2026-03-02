package com.yoti.mobile.android.mrtd.domain;

import com.yoti.mobile.android.mrtd.domain.model.MrtdReadState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/MrtdGetReadEventsUseCase;", "", "controller", "Lcom/yoti/mobile/android/mrtd/domain/INfcReadController;", "errorHandler", "Lcom/yoti/mobile/android/mrtd/domain/MrtdErrorHandler;", "(Lcom/yoti/mobile/android/mrtd/domain/INfcReadController;Lcom/yoti/mobile/android/mrtd/domain/MrtdErrorHandler;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdGetReadEventsUseCase {
    private final INfcReadController controller;
    private final MrtdErrorHandler errorHandler;

    @Inject
    public MrtdGetReadEventsUseCase(INfcReadController controller, MrtdErrorHandler errorHandler) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        this.controller = controller;
        this.errorHandler = errorHandler;
    }

    public final Flow<MrtdReadState> invoke() {
        return FlowKt.transformLatest(this.controller.getReaderListener(), new MrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1(null, this));
    }
}
