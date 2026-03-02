package com.yoti.mobile.android.liveness.zoom.data.remote;

import io.reactivex.FlowableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class LivenessFaceTecUploadService$buildRequest$1$1$1 extends FunctionReferenceImpl implements Function1<Double, Unit> {
    LivenessFaceTecUploadService$buildRequest$1$1$1(Object obj) {
        super(1, obj, FlowableEmitter.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Double d) {
        invoke2(d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Double p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((FlowableEmitter) this.receiver).onNext(p0);
    }
}
