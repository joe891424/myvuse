package com.yoti.mobile.android.documentscan.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.p */
/* JADX INFO: loaded from: classes5.dex */
final class C4812p extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideFragment f7134a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4812p(ScanDocumentMultiSideFragment scanDocumentMultiSideFragment) {
        super(0);
        this.f7134a = scanDocumentMultiSideFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ScanDocumentMultiSideFragment.m4906a(this.f7134a).m4935c();
    }
}
