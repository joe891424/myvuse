package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.w */
/* JADX INFO: loaded from: classes5.dex */
final class C4792w extends Lambda implements Function1<StateMachine.GraphBuilder<State, Event, SideEffect>, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SimpleCameraPresenter f7096a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4792w(SimpleCameraPresenter simpleCameraPresenter) {
        super(1);
        this.f7096a = simpleCameraPresenter;
    }

    /* JADX INFO: renamed from: a */
    public final void m5004a(StateMachine.GraphBuilder<State, Event, SideEffect> receiver) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        receiver.initialState(State.c.f7099a);
        receiver.state(StateMachine.Matcher.INSTANCE.any(State.c.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new C4777h(this));
        receiver.state(StateMachine.Matcher.INSTANCE.any(State.d.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new C4781l(this));
        receiver.state(StateMachine.Matcher.INSTANCE.any(State.b.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new C4784o(this));
        receiver.state(StateMachine.Matcher.INSTANCE.any(State.e.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new C4788s(this));
        receiver.state(StateMachine.Matcher.INSTANCE.any(State.a.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new C4790u(this));
        receiver.onTransition(new C4791v(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect> graphBuilder) {
        m5004a(graphBuilder);
        return Unit.INSTANCE;
    }
}
