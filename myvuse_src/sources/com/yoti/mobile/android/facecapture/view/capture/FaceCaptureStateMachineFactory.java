package com.yoti.mobile.android.facecapture.view.capture;

import androidx.exifinterface.media.ExifInterface;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.tinder.StateMachine;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory;
import com.yoti.mobile.android.facecapture.view.capture.model.Event;
import com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedbackType;
import com.yoti.mobile.android.facecapture.view.capture.model.SideEffect;
import com.yoti.mobile.android.facecapture.view.capture.model.State;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042&\u0010\b\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016JB\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042&\u0010\b\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016JB\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00042&\u0010\b\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002J?\u0010\u0011\u001a\u00020\u000b\"\n\b\u0000\u0010\u0012\u0018\u0001*\u00020\u0005*\u001e\u0012\u0004\u0012\u0002H\u00120\u0013R\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0082\b¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureStateMachineFactory;", "Lcom/yoti/mobile/android/facecapture/view/capture/IFaceCaptureStateMachineFactory;", "()V", "getAutoCaptureStateMachine", "Lcom/tinder/StateMachine;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "transitionListener", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$Transition;", "", "getFallbackStateMachine", "getManualCaptureStateMachine", "isBelowLightThreshold", "", "", "onInvalidFrameDuringScan", ExifInterface.LATITUDE_SOUTH, "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lcom/tinder/StateMachine$GraphBuilder;", "readyToCapture", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureStateMachineFactory implements IFaceCaptureStateMachineFactory {

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory$onInvalidFrameDuringScan$1 */
    @Metadata(m5597d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0002*\u0002H\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, m5598d2 = {"<anonymous>", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", ExifInterface.LATITUDE_SOUTH, HexAttribute.HEX_ATTR_CAUSE, "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnInvalidFrame;", "invoke", "(Lcom/yoti/mobile/android/facecapture/view/capture/model/State;Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnInvalidFrame;)Lcom/tinder/StateMachine$Graph$State$TransitionTo;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class C48531<S> extends Lambda implements Function2<S, Event.OnInvalidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>> {
        final /* synthetic */ boolean $readyToCapture;
        final /* synthetic */ StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S> $this_onInvalidFrameDuringScan;

        /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory$onInvalidFrameDuringScan$1$WhenMappings */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ScanFeedbackType.values().length];
                iArr[ScanFeedbackType.ANALYSIS_ERROR.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C48531(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S> stateDefinitionBuilder, boolean z) {
            super(2);
            this.$this_onInvalidFrameDuringScan = stateDefinitionBuilder;
            this.$readyToCapture = z;
        }

        /* JADX WARN: Incorrect types in method signature: (TS;Lcom/yoti/mobile/android/facecapture/view/capture/model/Event$OnInvalidFrame;)Lcom/tinder/StateMachine$Graph$State$TransitionTo<Lcom/yoti/mobile/android/facecapture/view/capture/model/State;Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;>; */
        @Override // kotlin.jvm.functions.Function2
        public final StateMachine.Graph.State.TransitionTo invoke(State on, Event.OnInvalidFrame cause) {
            Intrinsics.checkNotNullParameter(on, "$this$on");
            Intrinsics.checkNotNullParameter(cause, "cause");
            return WhenMappings.$EnumSwitchMapping$0[cause.getError().ordinal()] == 1 ? this.$this_onInvalidFrameDuringScan.transitionTo(on, State.Complete.INSTANCE, SideEffect.FallbackMode.INSTANCE) : StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(this.$this_onInvalidFrameDuringScan, on, new State.Scanning(this.$readyToCapture, cause.getError()), null, 2, null);
        }
    }

    @Inject
    public FaceCaptureStateMachineFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBelowLightThreshold(float f) {
        return f < 5.0f;
    }

    private final /* synthetic */ <S extends State> void onInvalidFrameDuringScan(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S> stateDefinitionBuilder, boolean z) {
        Intrinsics.needClassReification();
        stateDefinitionBuilder.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnInvalidFrame.class), (Function2) new C48531(stateDefinitionBuilder, z));
    }

    static /* synthetic */ void onInvalidFrameDuringScan$default(FaceCaptureStateMachineFactory faceCaptureStateMachineFactory, StateMachine.GraphBuilder.StateDefinitionBuilder stateDefinitionBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.needClassReification();
        stateDefinitionBuilder.m4366on(StateMachine.Matcher.INSTANCE.any(Event.OnInvalidFrame.class), (Function2) new C48531(stateDefinitionBuilder, z));
    }

    @Override // com.yoti.mobile.android.facecapture.view.capture.IFaceCaptureStateMachineFactory
    public StateMachine<State, Event, SideEffect> getAutoCaptureStateMachine(final Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener) {
        return StateMachine.INSTANCE.create(new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1
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
                create.state(StateMachine.Matcher.INSTANCE.any(State.Created.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStart.class), (Function2) new Function2<State.Created, Event.OnLifecycleStart, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Created on, Event.OnLifecycleStart it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, new State.Initial(false), SideEffect.StartTimeout.INSTANCE);
                            }
                        });
                    }
                });
                final FaceCaptureStateMachineFactory faceCaptureStateMachineFactory = this;
                create.state(StateMachine.Matcher.INSTANCE.any(State.Initial.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Initial>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Initial> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Initial> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        final boolean z = false;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnInvalidFrame.class), (Function2) new Function2<State.Initial, Event.OnInvalidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory$getAutoCaptureStateMachine$1$2$invoke$$inlined$onInvalidFrameDuringScan$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Initial on, Event.OnInvalidFrame cause) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(cause, "cause");
                                return FaceCaptureStateMachineFactory.C48531.WhenMappings.$EnumSwitchMapping$0[cause.getError().ordinal()] == 1 ? state.transitionTo(on, State.Complete.INSTANCE, SideEffect.FallbackMode.INSTANCE) : StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(z, cause.getError()), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnValidFrame.class), (Function2) new Function2<State.Initial, Event.OnValidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Initial on, Event.OnValidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(false, ScanFeedbackType.NO_FACE), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.Initial, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Initial on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Created.INSTANCE, SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                    }
                });
                final FaceCaptureStateMachineFactory faceCaptureStateMachineFactory2 = this;
                create.state(StateMachine.Matcher.INSTANCE.any(State.Scanning.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        final boolean z = false;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnInvalidFrame.class), (Function2) new Function2<State.Scanning, Event.OnInvalidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory$getAutoCaptureStateMachine$1$3$invoke$$inlined$onInvalidFrameDuringScan$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnInvalidFrame cause) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(cause, "cause");
                                return FaceCaptureStateMachineFactory.C48531.WhenMappings.$EnumSwitchMapping$0[cause.getError().ordinal()] == 1 ? state.transitionTo(on, State.Complete.INSTANCE, SideEffect.FallbackMode.INSTANCE) : StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(z, cause.getError()), null, 2, null);
                            }
                        });
                        final FaceCaptureStateMachineFactory faceCaptureStateMachineFactory3 = faceCaptureStateMachineFactory2;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnValidFrame.class), (Function2) new Function2<State.Scanning, Event.OnValidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnValidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return faceCaptureStateMachineFactory3.isBelowLightThreshold(it2.getLightLevel()) ? state.transitionTo(on, new State.WaitingForFlash(false), SideEffect.StartFlashTimeout.INSTANCE) : state.transitionTo(on, State.Complete.INSTANCE, new SideEffect.CompleteCapture(it2.getJpegData()));
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.Scanning, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Created.INSTANCE, SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnTimeout.class), (Function2) new Function2<State.Scanning, Event.OnTimeout, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnTimeout it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Complete.INSTANCE, SideEffect.FallbackMode.INSTANCE);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.WaitingForFlash.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnFlashTimeout.class), (Function2) new Function2<State.WaitingForFlash, Event.OnFlashTimeout, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForFlash on, Event.OnFlashTimeout it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.WaitingForNextValidFrame(false), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.WaitingForFlash, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForFlash on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Created.INSTANCE, SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.WaitingForNextValidFrame.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextValidFrame>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextValidFrame> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextValidFrame> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnValidFrame.class), (Function2) new Function2<State.WaitingForNextValidFrame, Event.OnValidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForNextValidFrame on, Event.OnValidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Complete.INSTANCE, new SideEffect.CompleteCapture(it2.getJpegData()));
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.WaitingForNextValidFrame, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForNextValidFrame on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, State.Created.INSTANCE, null, 2, null);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.Complete.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Complete>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getAutoCaptureStateMachine.1.6
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
    public StateMachine<State, Event, SideEffect> getFallbackStateMachine(final Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener) {
        return StateMachine.INSTANCE.create(new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1
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
                create.state(StateMachine.Matcher.INSTANCE.any(State.Created.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStart.class), (Function2) new Function2<State.Created, Event.OnLifecycleStart, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Created on, Event.OnLifecycleStart it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(true, ScanFeedbackType.NO_FACE), null, 2, null);
                            }
                        });
                    }
                });
                final FaceCaptureStateMachineFactory faceCaptureStateMachineFactory = this;
                create.state(StateMachine.Matcher.INSTANCE.any(State.Scanning.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        final boolean z = true;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnInvalidFrame.class), (Function2) new Function2<State.Scanning, Event.OnInvalidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory$getFallbackStateMachine$1$2$invoke$$inlined$onInvalidFrameDuringScan$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnInvalidFrame cause) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(cause, "cause");
                                return FaceCaptureStateMachineFactory.C48531.WhenMappings.$EnumSwitchMapping$0[cause.getError().ordinal()] == 1 ? state.transitionTo(on, State.Complete.INSTANCE, SideEffect.FallbackMode.INSTANCE) : StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(z, cause.getError()), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnValidFrame.class), (Function2) new Function2<State.Scanning, Event.OnValidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnValidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(true, ScanFeedbackType.VALID_FACE), null, 2, null);
                            }
                        });
                        final FaceCaptureStateMachineFactory faceCaptureStateMachineFactory2 = faceCaptureStateMachineFactory;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnCapturePressed.class), (Function2) new Function2<State.Scanning, Event.OnCapturePressed, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnCapturePressed it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return faceCaptureStateMachineFactory2.isBelowLightThreshold(it2.getLightLevel()) ? state.transitionTo(on, new State.WaitingForFlash(false), SideEffect.StartFlashTimeout.INSTANCE) : StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.WaitingForNextFrame(false), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.Scanning, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, State.Created.INSTANCE, null, 2, null);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.WaitingForNextFrame.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextFrame>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextFrame> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextFrame> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnInvalidFrame.class), (Function2) new Function2<State.WaitingForNextFrame, Event.OnInvalidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForNextFrame on, Event.OnInvalidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Complete.INSTANCE, new SideEffect.CompleteCaptureRaw(it2.getFrame()));
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnValidFrame.class), (Function2) new Function2<State.WaitingForNextFrame, Event.OnValidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForNextFrame on, Event.OnValidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Complete.INSTANCE, new SideEffect.CompleteCapture(it2.getJpegData()));
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.WaitingForNextFrame, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForNextFrame on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, State.Created.INSTANCE, null, 2, null);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.WaitingForFlash.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnFlashTimeout.class), (Function2) new Function2<State.WaitingForFlash, Event.OnFlashTimeout, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForFlash on, Event.OnFlashTimeout it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.WaitingForNextFrame(false), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.WaitingForFlash, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForFlash on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Created.INSTANCE, SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.Complete.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Complete>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getFallbackStateMachine.1.5
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
    public StateMachine<State, Event, SideEffect> getManualCaptureStateMachine(final Function1<? super StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> transitionListener) {
        return StateMachine.INSTANCE.create(new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1
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
                create.state(StateMachine.Matcher.INSTANCE.any(State.Created.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Created> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStart.class), (Function2) new Function2<State.Created, Event.OnLifecycleStart, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Created on, Event.OnLifecycleStart it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, new State.Initial(true), SideEffect.StartTimeout.INSTANCE);
                            }
                        });
                    }
                });
                final FaceCaptureStateMachineFactory faceCaptureStateMachineFactory = this;
                create.state(StateMachine.Matcher.INSTANCE.any(State.Initial.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Initial>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Initial> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Initial> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        final boolean z = true;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnInvalidFrame.class), (Function2) new Function2<State.Initial, Event.OnInvalidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory$getManualCaptureStateMachine$1$2$invoke$$inlined$onInvalidFrameDuringScan$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Initial on, Event.OnInvalidFrame cause) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(cause, "cause");
                                return FaceCaptureStateMachineFactory.C48531.WhenMappings.$EnumSwitchMapping$0[cause.getError().ordinal()] == 1 ? state.transitionTo(on, State.Complete.INSTANCE, SideEffect.FallbackMode.INSTANCE) : StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(z, cause.getError()), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnValidFrame.class), (Function2) new Function2<State.Initial, Event.OnValidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Initial on, Event.OnValidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(true, ScanFeedbackType.NO_FACE), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.Initial, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Initial on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Created.INSTANCE, SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                    }
                });
                final FaceCaptureStateMachineFactory faceCaptureStateMachineFactory2 = this;
                create.state(StateMachine.Matcher.INSTANCE.any(State.Scanning.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Scanning> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        final boolean z = true;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnInvalidFrame.class), (Function2) new Function2<State.Scanning, Event.OnInvalidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory$getManualCaptureStateMachine$1$3$invoke$$inlined$onInvalidFrameDuringScan$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnInvalidFrame cause) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(cause, "cause");
                                return FaceCaptureStateMachineFactory.C48531.WhenMappings.$EnumSwitchMapping$0[cause.getError().ordinal()] == 1 ? state.transitionTo(on, State.Complete.INSTANCE, SideEffect.FallbackMode.INSTANCE) : StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(z, cause.getError()), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnValidFrame.class), (Function2) new Function2<State.Scanning, Event.OnValidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnValidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.Scanning(true, ScanFeedbackType.VALID_FACE), null, 2, null);
                            }
                        });
                        final FaceCaptureStateMachineFactory faceCaptureStateMachineFactory3 = faceCaptureStateMachineFactory2;
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnCapturePressed.class), (Function2) new Function2<State.Scanning, Event.OnCapturePressed, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnCapturePressed it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return faceCaptureStateMachineFactory3.isBelowLightThreshold(it2.getLightLevel()) ? state.transitionTo(on, new State.WaitingForFlash(false), SideEffect.StartFlashTimeout.INSTANCE) : state.transitionTo(on, new State.WaitingForNextValidFrame(false), SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.Scanning, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Created.INSTANCE, SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnTimeout.class), (Function2) new Function2<State.Scanning, Event.OnTimeout, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.3.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.Scanning on, Event.OnTimeout it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Complete.INSTANCE, SideEffect.FallbackMode.INSTANCE);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.WaitingForNextValidFrame.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextValidFrame>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextValidFrame> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForNextValidFrame> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnValidFrame.class), (Function2) new Function2<State.WaitingForNextValidFrame, Event.OnValidFrame, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForNextValidFrame on, Event.OnValidFrame it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Complete.INSTANCE, new SideEffect.CompleteCapture(it2.getJpegData()));
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.WaitingForNextValidFrame, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForNextValidFrame on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Created.INSTANCE, SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.WaitingForFlash.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash> stateDefinitionBuilder) {
                        invoke2(stateDefinitionBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.WaitingForFlash> state) {
                        Intrinsics.checkNotNullParameter(state, "$this$state");
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnFlashTimeout.class), (Function2) new Function2<State.WaitingForFlash, Event.OnFlashTimeout, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForFlash on, Event.OnFlashTimeout it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return StateMachine.GraphBuilder.StateDefinitionBuilder.transitionTo$default(state, on, new State.WaitingForNextValidFrame(false), null, 2, null);
                            }
                        });
                        state.m4366on((StateMachine.Matcher) StateMachine.Matcher.INSTANCE.any(Event.OnLifecycleStop.class), (Function2) new Function2<State.WaitingForFlash, Event.OnLifecycleStop, StateMachine.Graph.State.TransitionTo<? extends State, ? extends SideEffect>>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final StateMachine.Graph.State.TransitionTo<State, SideEffect> invoke(State.WaitingForFlash on, Event.OnLifecycleStop it2) {
                                Intrinsics.checkNotNullParameter(on, "$this$on");
                                Intrinsics.checkNotNullParameter(it2, "it");
                                return state.transitionTo(on, State.Created.INSTANCE, SideEffect.StopTimeout.INSTANCE);
                            }
                        });
                    }
                });
                create.state(StateMachine.Matcher.INSTANCE.any(State.Complete.class), (Function1<? super StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<S>, Unit>) new Function1<StateMachine.GraphBuilder<State, Event, SideEffect>.StateDefinitionBuilder<State.Complete>, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureStateMachineFactory.getManualCaptureStateMachine.1.6
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
}
