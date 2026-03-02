package com.yoti.mobile.android.documentscan.ui.camera;

import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.m */
/* JADX INFO: loaded from: classes5.dex */
final class C4782m extends Lambda implements Function2<State.b, Event, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4784o f7084a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4782m(C4784o c4784o) {
        super(2);
        this.f7084a = c4784o;
    }

    /* JADX INFO: renamed from: a */
    public final void m4994a(State.b receiver, Event it2) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(it2, "it");
        this.f7084a.f7087a.f7096a.f7069e.mo4971b();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(State.b bVar, Event event) {
        m4994a(bVar, event);
        return Unit.INSTANCE;
    }
}
