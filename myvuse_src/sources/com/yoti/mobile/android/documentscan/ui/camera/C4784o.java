package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.o */
/* JADX INFO: loaded from: classes5.dex */
final class C4784o extends Lambda implements Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.b>, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4792w f7087a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4784o(C4792w c4792w) {
        super(1);
        this.f7087a = c4792w;
    }

    /* JADX INFO: renamed from: a */
    public final void m4996a(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.b> receiver) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        receiver.onEnter(new C4782m(this));
        receiver.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.d.class), (Function2) new C4783n(this, receiver));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.b> stateDefinitionBuilder) {
        m4996a(stateDefinitionBuilder);
        return Unit.INSTANCE;
    }
}
