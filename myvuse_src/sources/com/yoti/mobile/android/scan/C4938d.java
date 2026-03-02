package com.yoti.mobile.android.scan;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.d */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class C4938d extends FunctionReference implements Function1<String, Unit> {
    C4938d(ScannerViewBaseFragment scannerViewBaseFragment) {
        super(1, scannerViewBaseFragment);
    }

    /* JADX INFO: renamed from: a */
    public final void m5066a(String p1) {
        Intrinsics.checkParameterIsNotNull(p1, "p1");
        ((ScannerViewBaseFragment) this.receiver).m5040a(p1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "onCodeFound";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ScannerViewBaseFragment.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "onCodeFound(Ljava/lang/String;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        m5066a(str);
        return Unit.INSTANCE;
    }
}
