package com.yoti.mobile.android.documentscan.ui.camera;

import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.f */
/* JADX INFO: loaded from: classes5.dex */
final class C4775f extends Lambda implements Function2<State.c, Event, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4777h f7076a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4775f(C4777h c4777h) {
        super(2);
        this.f7076a = c4777h;
    }

    /* JADX INFO: renamed from: a */
    public final void m4988a(State.c receiver, Event it2) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(it2, "it");
        this.f7076a.f7078a.f7096a.f7074j.m4799a(this.f7076a.f7078a.f7096a.f7070f.getPageConfigs().get(this.f7076a.f7078a.f7096a.f7067c).getWantedNbOfHolograms());
        this.f7076a.f7078a.f7096a.f7069e.mo4968a(this.f7076a.f7078a.f7096a.f7067c);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(State.c cVar, Event event) {
        m4988a(cVar, event);
        return Unit.INSTANCE;
    }
}
