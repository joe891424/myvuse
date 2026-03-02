package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.camera.SideEffect;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.k */
/* JADX INFO: loaded from: classes5.dex */
final class C4780k extends Lambda implements Function2<State.d, Event.d, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4781l f7081a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ StateMachine.GraphBuilder.StateDefinitionBuilder f7082b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4780k(C4781l c4781l, StateMachine.GraphBuilder.StateDefinitionBuilder stateDefinitionBuilder) {
        super(2);
        this.f7081a = c4781l;
        this.f7082b = stateDefinitionBuilder;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.d receiver, Event.d event) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(event, "event");
        this.f7081a.f7083a.f7096a.f7074j.m4806b(event.m4973a());
        return this.f7081a.f7083a.f7096a.f7070f.getPageConfigs().get(this.f7081a.f7083a.f7096a.f7067c).shouldCaptureHologramsFrame() ? StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(this.f7082b, receiver, State.b.f7098a, null, 2, null) : this.f7082b.transitionTo(receiver, State.e.f7101a, SideEffect.a.f7061a);
    }
}
