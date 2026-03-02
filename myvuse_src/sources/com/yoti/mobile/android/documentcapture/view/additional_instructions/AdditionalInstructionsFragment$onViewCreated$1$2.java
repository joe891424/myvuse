package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.yoti.mobile.android.documentcapture.view.DocumentSideEffect;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2", m5608f = "AdditionalInstructionsFragment.kt", m5609i = {}, m5610l = {79}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class AdditionalInstructionsFragment$onViewCreated$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdditionalInstructionsViewModel $this_viewModel;
    int label;
    final /* synthetic */ AdditionalInstructionsFragment this$0;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2$1", m5608f = "AdditionalInstructionsFragment.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AdditionalInstructionsViewModel $this_viewModel;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AdditionalInstructionsFragment this$0;

        /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2$1$1, reason: invalid class name */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2$1$1", m5608f = "AdditionalInstructionsFragment.kt", m5609i = {}, m5610l = {81}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AdditionalInstructionsViewModel $this_viewModel;
            int label;
            final /* synthetic */ AdditionalInstructionsFragment this$0;

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            /* synthetic */ class C60001 implements FlowCollector, FunctionAdapter {
                final /* synthetic */ AdditionalInstructionsFragment $tmp0;

                C60001(AdditionalInstructionsFragment additionalInstructionsFragment) {
                    this.$tmp0 = additionalInstructionsFragment;
                }

                public final Object emit(AdditionalInstructionsViewState additionalInstructionsViewState, Continuation<? super Unit> continuation) {
                    Object objInvokeSuspend$handleViewState = AnonymousClass1.invokeSuspend$handleViewState(this.$tmp0, additionalInstructionsViewState, continuation);
                    return objInvokeSuspend$handleViewState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$handleViewState : Unit.INSTANCE;
                }

                public final boolean equals(Object obj) {
                    if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                    }
                    return false;
                }

                @Override // kotlin.jvm.internal.FunctionAdapter
                public final Function<?> getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, this.$tmp0, AdditionalInstructionsFragment.class, "handleViewState", "handleViewState(Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewState;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit((AdditionalInstructionsViewState) obj, (Continuation<? super Unit>) continuation);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AdditionalInstructionsViewModel additionalInstructionsViewModel, AdditionalInstructionsFragment additionalInstructionsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$this_viewModel = additionalInstructionsViewModel;
                this.this$0 = additionalInstructionsFragment;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ Object invokeSuspend$handleViewState(AdditionalInstructionsFragment additionalInstructionsFragment, AdditionalInstructionsViewState additionalInstructionsViewState, Continuation continuation) {
                additionalInstructionsFragment.handleViewState(additionalInstructionsViewState);
                return Unit.INSTANCE;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$this_viewModel, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<AdditionalInstructionsViewState> viewState = this.$this_viewModel.getViewState();
                    C60001 c60001 = new C60001(this.this$0);
                    this.label = 1;
                    if (viewState.collect(c60001, this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2$1$2, reason: invalid class name */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2$1$2", m5608f = "AdditionalInstructionsFragment.kt", m5609i = {}, m5610l = {84}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AdditionalInstructionsViewModel $this_viewModel;
            int label;
            final /* synthetic */ AdditionalInstructionsFragment this$0;

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment$onViewCreated$1$2$1$2$1, reason: invalid class name */
            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            /* synthetic */ class AnonymousClass1 implements FlowCollector, FunctionAdapter {
                final /* synthetic */ AdditionalInstructionsFragment $tmp0;

                AnonymousClass1(AdditionalInstructionsFragment additionalInstructionsFragment) {
                    this.$tmp0 = additionalInstructionsFragment;
                }

                public final Object emit(DocumentSideEffect documentSideEffect, Continuation<? super Unit> continuation) {
                    Object objInvokeSuspend$handleSideEffect = AnonymousClass2.invokeSuspend$handleSideEffect(this.$tmp0, documentSideEffect, continuation);
                    return objInvokeSuspend$handleSideEffect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$handleSideEffect : Unit.INSTANCE;
                }

                public final boolean equals(Object obj) {
                    if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                    }
                    return false;
                }

                @Override // kotlin.jvm.internal.FunctionAdapter
                public final Function<?> getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, this.$tmp0, AdditionalInstructionsFragment.class, "handleSideEffect", "handleSideEffect(Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit((DocumentSideEffect) obj, (Continuation<? super Unit>) continuation);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AdditionalInstructionsViewModel additionalInstructionsViewModel, AdditionalInstructionsFragment additionalInstructionsFragment, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$this_viewModel = additionalInstructionsViewModel;
                this.this$0 = additionalInstructionsFragment;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ Object invokeSuspend$handleSideEffect(AdditionalInstructionsFragment additionalInstructionsFragment, DocumentSideEffect documentSideEffect, Continuation continuation) {
                additionalInstructionsFragment.handleSideEffect(documentSideEffect);
                return Unit.INSTANCE;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$this_viewModel, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<DocumentSideEffect> sideEffect = this.$this_viewModel.getSideEffect();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
                    this.label = 1;
                    if (sideEffect.collect(anonymousClass1, this) == coroutine_suspended) {
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
        C46791(AdditionalInstructionsViewModel additionalInstructionsViewModel, AdditionalInstructionsFragment additionalInstructionsFragment, Continuation<? super C46791> continuation) {
            super(2, continuation);
            this.$this_viewModel = additionalInstructionsViewModel;
            this.this$0 = additionalInstructionsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46791 c46791 = new C46791(this.$this_viewModel, this.this$0, continuation);
            c46791.L$0 = obj;
            return c46791;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$this_viewModel, this.this$0, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.$this_viewModel, this.this$0, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdditionalInstructionsFragment$onViewCreated$1$2(AdditionalInstructionsFragment additionalInstructionsFragment, AdditionalInstructionsViewModel additionalInstructionsViewModel, Continuation<? super AdditionalInstructionsFragment$onViewCreated$1$2> continuation) {
        super(2, continuation);
        this.this$0 = additionalInstructionsFragment;
        this.$this_viewModel = additionalInstructionsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdditionalInstructionsFragment$onViewCreated$1$2(this.this$0, this.$this_viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdditionalInstructionsFragment$onViewCreated$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            Lifecycle.State state = Lifecycle.State.STARTED;
            C46791 c46791 = new C46791(this.$this_viewModel, this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, c46791, this) == coroutine_suspended) {
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
