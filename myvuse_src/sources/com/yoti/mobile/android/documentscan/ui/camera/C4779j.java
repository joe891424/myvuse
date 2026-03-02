package com.yoti.mobile.android.documentscan.ui.camera;

import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.j */
/* JADX INFO: loaded from: classes5.dex */
final class C4779j extends Lambda implements Function2<State.d, Event, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4781l f7080a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4779j(C4781l c4781l) {
        super(2);
        this.f7080a = c4781l;
    }

    /* JADX INFO: renamed from: a */
    public final void m4991a(State.d receiver, Event it2) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(it2, "it");
        this.f7080a.f7083a.f7096a.f7071g.scheduleImmediate(new C4778i(this));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(State.d dVar, Event event) {
        m4991a(dVar, event);
        return Unit.INSTANCE;
    }
}
