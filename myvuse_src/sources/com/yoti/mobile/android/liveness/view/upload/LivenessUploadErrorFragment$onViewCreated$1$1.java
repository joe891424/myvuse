package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.commonui.SingleEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class LivenessUploadErrorFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function1<SingleEvent<? extends LivenessUploadErrorNavigationEvent>, Unit> {
    LivenessUploadErrorFragment$onViewCreated$1$1(Object obj) {
        super(1, obj, LivenessUploadErrorFragment.class, "handleNavigationEvent", "handleNavigationEvent(Lcom/yoti/mobile/android/commonui/SingleEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SingleEvent<? extends LivenessUploadErrorNavigationEvent> singleEvent) {
        invoke2(singleEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SingleEvent<? extends LivenessUploadErrorNavigationEvent> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((LivenessUploadErrorFragment) this.receiver).handleNavigationEvent(p0);
    }
}
