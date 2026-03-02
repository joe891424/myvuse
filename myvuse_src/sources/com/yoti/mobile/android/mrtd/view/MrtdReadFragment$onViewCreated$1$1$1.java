package com.yoti.mobile.android.mrtd.view;

import com.yoti.mobile.android.commonui.SingleEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class MrtdReadFragment$onViewCreated$1$1$1 extends FunctionReferenceImpl implements Function1<SingleEvent<? extends MrtdScreen>, Unit> {
    MrtdReadFragment$onViewCreated$1$1$1(Object obj) {
        super(1, obj, MrtdReadFragment.class, "updateReadStatus", "updateReadStatus(Lcom/yoti/mobile/android/commonui/SingleEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SingleEvent<? extends MrtdScreen> singleEvent) {
        invoke2(singleEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SingleEvent<? extends MrtdScreen> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((MrtdReadFragment) this.receiver).updateReadStatus(p0);
    }
}
