package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.camera.SideEffect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.v */
/* JADX INFO: loaded from: classes5.dex */
final class C4791v extends Lambda implements Function1<StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4792w f7095a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4791v(C4792w c4792w) {
        super(1);
        this.f7095a = c4792w;
    }

    /* JADX INFO: renamed from: a */
    public final void m5003a(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        if (transition instanceof StateMachine.Transition.Invalid) {
            boolean z = transition.getEvent() instanceof Event.d;
        }
        if (!(transition instanceof StateMachine.Transition.Valid)) {
            transition = null;
        }
        StateMachine.Transition.Valid valid = (StateMachine.Transition.Valid) transition;
        if (valid == null || !Intrinsics.areEqual((SideEffect) valid.getSideEffect(), SideEffect.a.f7061a)) {
            return;
        }
        this.f7095a.f7096a.m4978c();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> transition) {
        m5003a(transition);
        return Unit.INSTANCE;
    }
}
