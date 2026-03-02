package com.yoti.mobile.android.documentscan.ui.camera;

import com.tinder.StateMachine;
import com.yoti.mobile.android.documentscan.ui.camera.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.u */
/* JADX INFO: loaded from: classes5.dex */
final class C4790u extends Lambda implements Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.a>, Unit> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4792w f7094a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4790u(C4792w c4792w) {
        super(1);
        this.f7094a = c4792w;
    }

    /* JADX INFO: renamed from: a */
    public final void m5002a(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.a> receiver) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        receiver.onEnter(new C4789t(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.a> stateDefinitionBuilder) {
        m5002a(stateDefinitionBuilder);
        return Unit.INSTANCE;
    }
}
