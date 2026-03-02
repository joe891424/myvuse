package com.yoti.mobile.android.facecapture.view.capture.automation;

import com.tinder.StateMachine;
import com.yoti.mobile.android.facecapture.view.capture.IFaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.capture.model.Event;
import com.yoti.mobile.android.facecapture.view.capture.model.SideEffect;
import com.yoti.mobile.android.facecapture.view.capture.model.State;
import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.FilesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JB\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062&\u0010\n\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0002JB\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062&\u0010\n\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016JB\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062&\u0010\n\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016JB\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062&\u0010\n\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/automation/AutomationFaceCaptureStateMachineFactory;", "Lcom/yoti/mobile/android/facecapture/view/capture/IFaceCaptureStateMachineFactory;", "assetToFileConverter", "Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;", "(Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;)V", "completeFaceCapture", "Lcom/tinder/StateMachine;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "transitionListener", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$Transition;", "", "getAutoCaptureStateMachine", "getFallbackStateMachine", "getManualCaptureStateMachine", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationFaceCaptureStateMachineFactory implements IFaceCaptureStateMachineFactory {
    private final AssetToFileConverter assetToFileConverter;

    @Inject
    public AutomationFaceCaptureStateMachineFactory(AssetToFileConverter assetToFileConverter) {
        Intrinsics.checkNotNullParameter(assetToFileConverter, "assetToFileConverter");
        this.assetToFileConverter = assetToFileConverter;
    }

    private final StateMachine<State, Event, SideEffect> completeFaceCapture(final Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener) {
        return StateMachine.INSTANCE.create(new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory.completeFaceCapture.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect> graphBuilder) {
                invoke2(graphBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StateMachine.GraphBuilder<State, Event, SideEffect> create) {
                Intrinsics.checkNotNullParameter(create, "$this$create");
                create.initialState(State.Created.INSTANCE);
                final AutomationFaceCaptureStateMachineFactory automationFaceCaptureStateMachineFactory = this;
                create.state(StateMachine.Matcher.INSTANCE.any(State.Created.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory.completeFaceCapture.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        final AutomationFaceCaptureStateMachineFactory automationFaceCaptureStateMachineFactory2 = automationFaceCaptureStateMachineFactory;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStart.class), (Function2) new Function2<State.Created, Event.OnLifecycleStart, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory.completeFaceCapture.1.1.1

                            /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory$completeFaceCapture$1$1$1$1, reason: invalid class name and collision with other inner class name */
                            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                            @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory$completeFaceCapture$1$1$1$1", m5608f = "AutomationFaceCaptureStateMachineFactory.kt", m5609i = {}, m5610l = {38}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                            static final class C60241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                int label;

                                C60241(Continuation<? super C60241> continuation) {
                                    super(2, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C60241(continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C60241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Created on, Event.OnLifecycleStart it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C60241(null), 3, null);
                                return state.transitionTo(on, State.Complete.INSTANCE, new SideEffect.CompleteCapture(FilesKt.readBytes(AssetToFileConverter.getFile$default(automationFaceCaptureStateMachineFactory2.assetToFileConverter, "facecapture.jpg", false, 2, null))));
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.Complete.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Complete>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.automation.AutomationFaceCaptureStateMachineFactory.completeFaceCapture.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Complete> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Complete> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                    }
                });
                Function1<StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> function1 = transitionListener;
                if (function1 != null) {
                    create.onTransition(function1);
                }
            }
        });
    }

    @Override // com.yoti.mobile.android.facecapture.view.capture.IFaceCaptureStateMachineFactory
    public StateMachine<State, Event, SideEffect> getAutoCaptureStateMachine(Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener) {
        return completeFaceCapture(transitionListener);
    }

    @Override // com.yoti.mobile.android.facecapture.view.capture.IFaceCaptureStateMachineFactory
    public StateMachine<State, Event, SideEffect> getFallbackStateMachine(Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener) {
        return completeFaceCapture(transitionListener);
    }

    @Override // com.yoti.mobile.android.facecapture.view.capture.IFaceCaptureStateMachineFactory
    public StateMachine<State, Event, SideEffect> getManualCaptureStateMachine(Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener) {
        return completeFaceCapture(transitionListener);
    }
}
