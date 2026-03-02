package com.yoti.mobile.android.mrtd.view;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class MrtdCaptureActivity$onCreate$1$2 extends FunctionReferenceImpl implements Function1<Map<Integer, ? extends byte[]>, Unit> {
    MrtdCaptureActivity$onCreate$1$2(Object obj) {
        super(1, obj, MrtdCaptureActivity.class, "handleChipRead", "handleChipRead(Ljava/util/Map;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends byte[]> map) {
        invoke2((Map<Integer, byte[]>) map);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<Integer, byte[]> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((MrtdCaptureActivity) this.receiver).handleChipRead(p0);
    }
}
