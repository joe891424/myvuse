package com.yoti.mobile.android.documentscan.ui.camera;

import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.p */
/* JADX INFO: loaded from: classes5.dex */
final class C4785p extends Lambda implements Function2<State.e, Event, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4788s f7088a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4785p(C4788s c4788s) {
        super(2);
        this.f7088a = c4788s;
    }

    /* JADX INFO: renamed from: a */
    public final void m4997a(State.e receiver, Event it2) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(it2, "it");
        this.f7088a.f7092a.f7096a.f7069e.mo4967a();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(State.e eVar, Event event) {
        m4997a(eVar, event);
        return Unit.INSTANCE;
    }
}
