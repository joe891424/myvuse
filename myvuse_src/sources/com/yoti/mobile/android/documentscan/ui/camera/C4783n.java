package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.camera.SideEffect;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.n */
/* JADX INFO: loaded from: classes5.dex */
final class C4783n extends Lambda implements Function2<State.b, Event.d, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4784o f7085a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ StateMachine.GraphBuilder.StateDefinitionBuilder f7086b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4783n(C4784o c4784o, StateMachine.GraphBuilder.StateDefinitionBuilder stateDefinitionBuilder) {
        super(2);
        this.f7085a = c4784o;
        this.f7086b = stateDefinitionBuilder;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.b receiver, Event.d event) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(event, "event");
        this.f7085a.f7087a.f7096a.f7074j.m4804a(event.m4973a());
        return this.f7085a.f7087a.f7096a.f7074j.m4813g() ? this.f7086b.transitionTo(receiver, State.e.f7101a, SideEffect.a.f7061a) : StateMachine.GraphBuilder.StateDefinitionBuilder.dontTransition$default(this.f7086b, receiver, null, 1, null);
    }
}
