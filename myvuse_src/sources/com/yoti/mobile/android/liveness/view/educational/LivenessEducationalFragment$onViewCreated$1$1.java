package com.yoti.mobile.android.liveness.view.educational;

import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class LivenessEducationalFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function1<LivenessEducationalViewModel.EducationalViewState, Unit> {
    LivenessEducationalFragment$onViewCreated$1$1(Object obj) {
        super(1, obj, LivenessEducationalFragment.class, "onViewStateChanged", "onViewStateChanged(Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LivenessEducationalViewModel.EducationalViewState educationalViewState) {
        invoke2(educationalViewState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LivenessEducationalViewModel.EducationalViewState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((LivenessEducationalFragment) this.receiver).onViewStateChanged(p0);
    }
}
