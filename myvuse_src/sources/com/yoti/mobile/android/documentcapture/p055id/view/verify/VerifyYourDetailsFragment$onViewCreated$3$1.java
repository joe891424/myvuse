package com.yoti.mobile.android.documentcapture.p055id.view.verify;

import com.yoti.mobile.android.commonui.SingleEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class VerifyYourDetailsFragment$onViewCreated$3$1 extends FunctionReferenceImpl implements Function1<SingleEvent<? extends ScreenState>, Unit> {
    VerifyYourDetailsFragment$onViewCreated$3$1(Object obj) {
        super(1, obj, VerifyYourDetailsFragment.class, "onScreenStateChanged", "onScreenStateChanged(Lcom/yoti/mobile/android/commonui/SingleEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SingleEvent<? extends ScreenState> singleEvent) {
        invoke2(singleEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SingleEvent<? extends ScreenState> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((VerifyYourDetailsFragment) this.receiver).onScreenStateChanged(p0);
    }
}
