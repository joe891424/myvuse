package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.q */
/* JADX INFO: loaded from: classes5.dex */
final class C4786q extends Lambda implements Function2<State.e, Event.b, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4788s f7089a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ StateMachine.GraphBuilder.StateDefinitionBuilder f7090b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4786q(C4788s c4788s, StateMachine.GraphBuilder.StateDefinitionBuilder stateDefinitionBuilder) {
        super(2);
        this.f7089a = c4788s;
        this.f7090b = stateDefinitionBuilder;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.e receiver, Event.b it2) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(it2, "it");
        this.f7089a.f7092a.f7096a.f7067c++;
        return this.f7089a.f7092a.f7096a.f7067c == this.f7089a.f7092a.f7096a.f7070f.getPageConfigs().size() ? StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(this.f7090b, receiver, State.a.f7097a, null, 2, null) : StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(this.f7090b, receiver, State.c.f7099a, null, 2, null);
    }
}
