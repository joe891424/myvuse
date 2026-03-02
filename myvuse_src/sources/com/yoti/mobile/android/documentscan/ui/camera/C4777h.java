package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.h */
/* JADX INFO: loaded from: classes5.dex */
final class C4777h extends Lambda implements Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.c>, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4792w f7078a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4777h(C4792w c4792w) {
        super(1);
        this.f7078a = c4792w;
    }

    /* JADX INFO: renamed from: a */
    public final void m4990a(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.c> receiver) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        receiver.onEnter(new C4775f(this));
        receiver.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.a.class), (Function2) new C4776g(receiver));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.c> stateDefinitionBuilder) {
        m4990a(stateDefinitionBuilder);
        return Unit.INSTANCE;
    }
}
