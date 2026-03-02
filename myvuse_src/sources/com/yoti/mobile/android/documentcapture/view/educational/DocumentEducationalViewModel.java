package com.yoti.mobile.android.documentcapture.view.educational;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.documentcapture.view.DocumentSideEffect;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewState;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.internal.p103ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\u0012\u0010&\u001a\u00020\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(J\b\u0010)\u001a\u00020\u001fH\u0014J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0015H\u0016J\u0018\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00178F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewModel;", "Lcom/yoti/mobile/android/commons/navigation/NavigationViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "documentViewModelHelper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;", "documentResourceConfigEntityToEducationalViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentResourceConfigEntityToEducationalViewDataMapper;", "documentEducationalArgumentsToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;", "documentTypeViewDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentResourceConfigEntityToEducationalViewDataMapper;Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArgumentsToViewDataMapper;Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "_sideEffect", "Lkotlinx/coroutines/channels/Channel;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "_viewState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "sideEffect", "Lkotlinx/coroutines/flow/Flow;", "getSideEffect", "()Lkotlinx/coroutines/flow/Flow;", "viewState", "getViewState", "visibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;", "collectDocumentViewEventHandlerState", "", "handleFetchSuccess", "documentCaptureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "handleViewEvent", "viewEvent", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "init", "arguments", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalArguments;", "onCleared", "setSavedStateHandle", "handle", "setupDocumentViewEventHandler", "documentEducationalViewData", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;", "countryIso3Code", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentEducationalViewModel extends NavigationViewModel implements SavedStateHandleHolder {
    private final Channel<DocumentSideEffect> _sideEffect;
    private final MutableSharedFlow<DocumentEducationalViewState> _viewState;
    private final DocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper;
    private final DocumentResourceConfigEntityToEducationalViewDataMapper documentResourceConfigEntityToEducationalViewDataMapper;
    private final DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper;
    private final DocumentViewModelHelper documentViewModelHelper;
    private SavedStateHandle savedStateHandle;
    private final DocumentEducationalViewState.VisibilityToggles visibilityToggles;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1", m5608f = "DocumentEducationalViewModel.kt", m5609i = {}, m5610l = {113}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C46821(Continuation<? super C46821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46821 c46821 = DocumentEducationalViewModel.this.new C46821(continuation);
            c46821.L$0 = obj;
            return c46821;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Flow<DocumentViewModelHelper.State> state = DocumentEducationalViewModel.this.documentViewModelHelper.getState();
                final DocumentEducationalViewModel documentEducationalViewModel = DocumentEducationalViewModel.this;
                FlowCollector<? super DocumentViewModelHelper.State> flowCollector = new FlowCollector() { // from class: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel.collectDocumentViewEventHandlerState.1.1

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1$1$1, reason: invalid class name and collision with other inner class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1$1$1", m5608f = "DocumentEducationalViewModel.kt", m5609i = {}, m5610l = {119}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class C60051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ DocumentEducationalViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C60051(DocumentEducationalViewModel documentEducationalViewModel, Continuation<? super C60051> continuation) {
                            super(2, continuation);
                            this.this$0 = documentEducationalViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C60051(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C60051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Channel channel = this.this$0._sideEffect;
                                DocumentSideEffect.ShowCtaLoading showCtaLoading = DocumentSideEffect.ShowCtaLoading.INSTANCE;
                                this.label = 1;
                                if (channel.send(showCtaLoading, this) == coroutine_suspended) {
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

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1$1$2, reason: invalid class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1$1$2", m5608f = "DocumentEducationalViewModel.kt", m5609i = {}, m5610l = {122}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ DocumentEducationalViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(DocumentEducationalViewModel documentEducationalViewModel, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.this$0 = documentEducationalViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.this$0, continuation);
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
                                Channel channel = this.this$0._sideEffect;
                                DocumentSideEffect.HideCtaLoading hideCtaLoading = DocumentSideEffect.HideCtaLoading.INSTANCE;
                                this.label = 1;
                                if (channel.send(hideCtaLoading, this) == coroutine_suspended) {
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

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1$1$3, reason: invalid class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1$1$3", m5608f = "DocumentEducationalViewModel.kt", m5609i = {}, m5610l = {WebSocketProtocol.PAYLOAD_SHORT}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ DocumentEducationalViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(DocumentEducationalViewModel documentEducationalViewModel, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.this$0 = documentEducationalViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass3(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Channel channel = this.this$0._sideEffect;
                                DocumentSideEffect.HideCtaLoading hideCtaLoading = DocumentSideEffect.HideCtaLoading.INSTANCE;
                                this.label = 1;
                                if (channel.send(hideCtaLoading, this) == coroutine_suspended) {
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

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewModel$collectDocumentViewEventHandlerState$1$1$WhenMappings */
                    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[DocumentViewModelHelper.State.LoadingData.DataType.values().length];
                            iArr[DocumentViewModelHelper.State.LoadingData.DataType.DOCUMENT_RESOURCE_CONFIGURATION.ordinal()] = 1;
                            iArr[DocumentViewModelHelper.State.LoadingData.DataType.DOCUMENT_SCAN_CONFIGURATION.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((DocumentViewModelHelper.State) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(DocumentViewModelHelper.State state2, Continuation<? super Unit> continuation) {
                        Job jobLaunch$default;
                        if (state2 instanceof DocumentViewModelHelper.State.LoadingData) {
                            int i2 = WhenMappings.$EnumSwitchMapping$0[((DocumentViewModelHelper.State.LoadingData) state2).getDataType().ordinal()];
                            if (i2 == 1) {
                                documentEducationalViewModel._viewState.tryEmit(new DocumentEducationalViewState.Loading(documentEducationalViewModel.visibilityToggles));
                            } else if (i2 == 2 && (jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C60051(documentEducationalViewModel, null), 3, null)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return jobLaunch$default;
                            }
                        } else if (state2 instanceof DocumentViewModelHelper.State.Failure) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(documentEducationalViewModel, null), 3, null);
                            documentEducationalViewModel._viewState.tryEmit(new DocumentEducationalViewState.Error(((DocumentViewModelHelper.State.Failure) state2).getFailure()));
                        } else if (state2 instanceof DocumentViewModelHelper.State.NavigationPending) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(documentEducationalViewModel, null), 3, null);
                            documentEducationalViewModel.sendCoordinatorEvent(((DocumentViewModelHelper.State.NavigationPending) state2).getNavigationEvent());
                        } else if (state2 instanceof DocumentViewModelHelper.State.Successful) {
                            documentEducationalViewModel.handleFetchSuccess(((DocumentViewModelHelper.State.Successful) state2).getResourceConfigEntity());
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (state.collect(flowCollector, this) == coroutine_suspended) {
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

    @Inject
    public DocumentEducationalViewModel(DocumentViewModelHelper documentViewModelHelper, DocumentResourceConfigEntityToEducationalViewDataMapper documentResourceConfigEntityToEducationalViewDataMapper, DocumentEducationalArgumentsToViewDataMapper documentEducationalArgumentsToViewDataMapper, DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper, DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(documentViewModelHelper, "documentViewModelHelper");
        Intrinsics.checkNotNullParameter(documentResourceConfigEntityToEducationalViewDataMapper, "documentResourceConfigEntityToEducationalViewDataMapper");
        Intrinsics.checkNotNullParameter(documentEducationalArgumentsToViewDataMapper, "documentEducationalArgumentsToViewDataMapper");
        Intrinsics.checkNotNullParameter(documentTypeViewDataToEntityMapper, "documentTypeViewDataToEntityMapper");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.documentViewModelHelper = documentViewModelHelper;
        this.documentResourceConfigEntityToEducationalViewDataMapper = documentResourceConfigEntityToEducationalViewDataMapper;
        this.documentEducationalArgumentsToViewDataMapper = documentEducationalArgumentsToViewDataMapper;
        this.documentTypeViewDataToEntityMapper = documentTypeViewDataToEntityMapper;
        boolean showIdentityCheck = featureConfiguration.getUiSessionConfiguration().getShowIdentityCheck();
        this.visibilityToggles = new DocumentEducationalViewState.VisibilityToggles(showIdentityCheck, (showIdentityCheck || featureConfiguration.getIsSelectableDocumentFlow() || !featureConfiguration.getIsMoreAboutVerificationEnabled()) ? false : true, !featureConfiguration.getIsSelectableDocumentFlow() && featureConfiguration.getIsDoNotHaveDocumentOptionEnabled());
        collectDocumentViewEventHandlerState();
        this._viewState = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._sideEffect = ChannelKt.Channel$default(-2, null, null, 6, null);
    }

    private final void collectDocumentViewEventHandlerState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46821(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFetchSuccess(DocumentResourceConfigEntity documentCaptureConfiguration) {
        DocumentResourceConfigEntity.CountryEntity country = documentCaptureConfiguration.getCountry();
        SavedStateHandle savedStateHandle = null;
        String iso3Code = country != null ? country.getIso3Code() : null;
        if (iso3Code == null) {
            throw new IllegalArgumentException("Country iso code should not be null".toString());
        }
        SavedStateHandle savedStateHandle2 = this.savedStateHandle;
        if (savedStateHandle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle2 = null;
        }
        savedStateHandle2.set("KEY_ISO_3_CODE", iso3Code);
        DocumentEducationalViewData map = this.documentResourceConfigEntityToEducationalViewDataMapper.map(documentCaptureConfiguration);
        setupDocumentViewEventHandler(map, iso3Code);
        SavedStateHandle savedStateHandle3 = this.savedStateHandle;
        if (savedStateHandle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
        } else {
            savedStateHandle = savedStateHandle3;
        }
        savedStateHandle.set(DocumentEducationalViewModelKt.KEY_DOCUMENT_EDUCATIONAL_VIEW_DATA, map);
        this._viewState.tryEmit(new DocumentEducationalViewState.Success(map, this.visibilityToggles));
    }

    public static /* synthetic */ void init$default(DocumentEducationalViewModel documentEducationalViewModel, DocumentEducationalArguments documentEducationalArguments, int i, Object obj) {
        if ((i & 1) != 0) {
            documentEducationalArguments = null;
        }
        documentEducationalViewModel.init(documentEducationalArguments);
    }

    private final void setupDocumentViewEventHandler(DocumentEducationalViewData documentEducationalViewData, String countryIso3Code) {
        DocumentViewModelHelper documentViewModelHelper = this.documentViewModelHelper;
        documentViewModelHelper.setDocumentData(this.documentTypeViewDataToEntityMapper.map(documentEducationalViewData.getDocumentViewData().getDocumentType()), countryIso3Code, documentEducationalViewData.getDocumentViewData().getDateFromRequirement());
        documentViewModelHelper.setObjective(documentEducationalViewData.getObjective());
    }

    public final Flow<DocumentSideEffect> getSideEffect() {
        return FlowKt.receiveAsFlow(this._sideEffect);
    }

    public final Flow<DocumentEducationalViewState> getViewState() {
        return this._viewState;
    }

    public final void handleViewEvent(DocumentViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        this.documentViewModelHelper.handleViewEvent(viewEvent);
    }

    public final void init(DocumentEducationalArguments arguments) {
        SavedStateHandle savedStateHandle = null;
        if (arguments != null) {
            SavedStateHandle savedStateHandle2 = this.savedStateHandle;
            if (savedStateHandle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
                savedStateHandle2 = null;
            }
            savedStateHandle2.set("KEY_ISO_3_CODE", arguments.getCountryIso3Code());
            SavedStateHandle savedStateHandle3 = this.savedStateHandle;
            if (savedStateHandle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
                savedStateHandle3 = null;
            }
            savedStateHandle3.set(DocumentEducationalViewModelKt.KEY_DOCUMENT_EDUCATIONAL_VIEW_DATA, this.documentEducationalArgumentsToViewDataMapper.map(arguments));
        }
        SavedStateHandle savedStateHandle4 = this.savedStateHandle;
        if (savedStateHandle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle4 = null;
        }
        DocumentEducationalViewData documentEducationalViewData = (DocumentEducationalViewData) savedStateHandle4.get(DocumentEducationalViewModelKt.KEY_DOCUMENT_EDUCATIONAL_VIEW_DATA);
        if (documentEducationalViewData == null) {
            this.documentViewModelHelper.handleViewEvent(DocumentViewEvent.ViewCreated.INSTANCE);
            return;
        }
        SavedStateHandle savedStateHandle5 = this.savedStateHandle;
        if (savedStateHandle5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
        } else {
            savedStateHandle = savedStateHandle5;
        }
        String countryIso3Code = (String) savedStateHandle.get("KEY_ISO_3_CODE");
        if (countryIso3Code != null) {
            Intrinsics.checkNotNullExpressionValue(countryIso3Code, "countryIso3Code");
            setupDocumentViewEventHandler(documentEducationalViewData, countryIso3Code);
        }
        this._viewState.tryEmit(new DocumentEducationalViewState.Success(documentEducationalViewData, this.visibilityToggles));
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.documentViewModelHelper.cleanup();
    }

    @Override // com.yoti.mobile.android.commonui.SavedStateHandleHolder
    public void setSavedStateHandle(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.savedStateHandle = handle;
    }
}
