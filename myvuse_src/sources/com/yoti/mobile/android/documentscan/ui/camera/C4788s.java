package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.s */
/* JADX INFO: loaded from: classes5.dex */
final class C4788s extends Lambda implements Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.e>, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4792w f7092a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4788s(C4792w c4792w) {
        super(1);
        this.f7092a = c4792w;
    }

    /* JADX INFO: renamed from: a */
    public final void m5000a(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.e> receiver) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        receiver.onEnter(new C4785p(this));
        receiver.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.b.class), (Function2) new C4786q(this, receiver));
        receiver.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.c.class), (Function2) new C4787r(receiver));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.e> stateDefinitionBuilder) {
        m5000a(stateDefinitionBuilder);
        return Unit.INSTANCE;
    }
}
