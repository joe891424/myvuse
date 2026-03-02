package com.yoti.mobile.android.documentscan.ui.camera;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.d */
/* JADX INFO: loaded from: classes5.dex */
final class C4773d extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SimpleCameraFragment f7064a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4773d(SimpleCameraFragment simpleCameraFragment) {
        super(0);
        this.f7064a = simpleCameraFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SimpleCameraFragment.m4962a(this.f7064a).m4982a();
    }
}
