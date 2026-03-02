package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.r */
/* JADX INFO: loaded from: classes5.dex */
final class C4787r extends Lambda implements Function2<State.e, Event.c, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ StateMachine.GraphBuilder.StateDefinitionBuilder f7091a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4787r(StateMachine.GraphBuilder.StateDefinitionBuilder stateDefinitionBuilder) {
        super(2);
        this.f7091a = stateDefinitionBuilder;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.e receiver, Event.c it2) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(it2, "it");
        return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(this.f7091a, receiver, State.c.f7099a, null, 2, null);
    }
}
