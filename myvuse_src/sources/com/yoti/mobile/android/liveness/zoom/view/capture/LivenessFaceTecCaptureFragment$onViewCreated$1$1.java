package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class LivenessFaceTecCaptureFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function1<LivenessFaceTecCaptureViewModel.LivenessCaptureNavigationEvent, Unit> {
    LivenessFaceTecCaptureFragment$onViewCreated$1$1(Object obj) {
        super(1, obj, LivenessFaceTecCaptureFragment.class, "onNavigationEvent", "onNavigationEvent(Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LivenessFaceTecCaptureViewModel.LivenessCaptureNavigationEvent livenessCaptureNavigationEvent) {
        invoke2(livenessCaptureNavigationEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LivenessFaceTecCaptureViewModel.LivenessCaptureNavigationEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((LivenessFaceTecCaptureFragment) this.receiver).onNavigationEvent(p0);
    }
}
