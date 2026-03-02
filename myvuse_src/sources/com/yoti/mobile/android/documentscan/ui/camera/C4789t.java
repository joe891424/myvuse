package com.yoti.mobile.android.documentscan.ui.camera;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.t */
/* JADX INFO: loaded from: classes5.dex */
final class C4789t extends Lambda implements Function2<State.a, Event, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4790u f7093a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4789t(C4790u c4790u) {
        super(2);
        this.f7093a = c4790u;
    }

    /* JADX INFO: renamed from: a */
    public final void m5001a(State.a receiver, Event it2) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(it2, "it");
        this.f7093a.f7094a.f7096a.f7069e.mo4967a();
        DocumentCaptureResult documentCaptureResultM4808c = this.f7093a.f7094a.f7096a.f7074j.m4808c();
        if (documentCaptureResultM4808c != null) {
            this.f7093a.f7094a.f7096a.f7069e.onScanCompleted(documentCaptureResultM4808c, this.f7093a.f7094a.f7096a.f7074j.m4805b());
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(State.a aVar, Event event) {
        m5001a(aVar, event);
        return Unit.INSTANCE;
    }
}
