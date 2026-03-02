package com.yoti.mobile.android.documentcapture.view.requirements;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost;
import com.yoti.mobile.android.commons.navigation.NavigationUtilsKt;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.HideButtonProgressWithDelayKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentDocumentRequirementsBinding;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentDocumentRequirementsSuccessStateBinding;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentRequirements;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTag;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentSideEffect;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewEvent;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewState;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentRequirementsViewData;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00102\u001a\u00020)2\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u00105\u001a\u00020)2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020:H\u0016J\u0012\u0010;\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020)2\u0006\u0010?\u001a\u00020@H\u0016J+\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020@0F2\u0006\u0010G\u001a\u00020HH\u0016¢\u0006\u0002\u0010IJ\u001a\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020L2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u000e\u0010'\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006M"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "Lcom/yoti/mobile/android/commons/navigation/NavigationCoordinatorHost;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentRequirementsBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentRequirementsBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "coordinator", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsCoordinator;", "getCoordinator", "()Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsCoordinator;", "setCoordinator", "(Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsCoordinator;)V", "errorTagToViewEventMapper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "getErrorTagToViewEventMapper", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "setErrorTagToViewEventMapper", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;)V", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewModel;", "getFactory$annotations", "getFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "failureTypeToErrorTagMapper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "getFailureTypeToErrorTagMapper", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "setFailureTypeToErrorTagMapper", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;)V", "isCameraPermissionNeeded", "", "()Z", "viewModel", "handleError", "", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "handleLoading", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "handleSideEffect", "sideEffect", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "handleSuccess", "viewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementsViewData;", "handleViewState", "viewState", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNegativeButtonClick", "dialogTag", "", "onPositiveButtonClick", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "Landroid/view/View;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentRequirementsFragment extends BaseFragment implements NavigationCoordinatorHost {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DocumentRequirementsFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentRequirementsBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    @Inject
    public DocumentRequirementsCoordinator coordinator;

    @Inject
    public DocumentFeatureErrorTagToViewEventMapper errorTagToViewEventMapper;

    @Inject
    public SavedStateViewModelFactory<DocumentRequirementsViewModel> factory;

    @Inject
    public DocumentFailureTypeToErrorTagMapper failureTypeToErrorTagMapper;
    private DocumentRequirementsViewModel viewModel;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1", m5608f = "DocumentRequirementsFragment.kt", m5609i = {}, m5610l = {92}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1$1, reason: invalid class name */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1$1", m5608f = "DocumentRequirementsFragment.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DocumentRequirementsFragment this$0;

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1$1$1", m5608f = "DocumentRequirementsFragment.kt", m5609i = {}, m5610l = {94}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
            static final class C60061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DocumentRequirementsFragment this$0;

                /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                /* synthetic */ class C60071 implements FlowCollector, FunctionAdapter {
                    final /* synthetic */ DocumentRequirementsFragment $tmp0;

                    C60071(DocumentRequirementsFragment documentRequirementsFragment) {
                        this.$tmp0 = documentRequirementsFragment;
                    }

                    public final Object emit(DocumentRequirementsViewState documentRequirementsViewState, Continuation<? super Unit> continuation) {
                        Object objInvokeSuspend$handleViewState = C60061.invokeSuspend$handleViewState(this.$tmp0, documentRequirementsViewState, continuation);
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
                        return new AdaptedFunctionReference(2, this.$tmp0, DocumentRequirementsFragment.class, "handleViewState", "handleViewState(Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState;)V", 4);
                    }

                    public final int hashCode() {
                        return getFunctionDelegate().hashCode();
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit((DocumentRequirementsViewState) obj, (Continuation<? super Unit>) continuation);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C60061(DocumentRequirementsFragment documentRequirementsFragment, Continuation<? super C60061> continuation) {
                    super(2, continuation);
                    this.this$0 = documentRequirementsFragment;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ Object invokeSuspend$handleViewState(DocumentRequirementsFragment documentRequirementsFragment, DocumentRequirementsViewState documentRequirementsViewState, Continuation continuation) {
                    documentRequirementsFragment.handleViewState(documentRequirementsViewState);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C60061(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C60061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        DocumentRequirementsViewModel documentRequirementsViewModel = this.this$0.viewModel;
                        if (documentRequirementsViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            documentRequirementsViewModel = null;
                        }
                        Flow<DocumentRequirementsViewState> viewState = documentRequirementsViewModel.getViewState();
                        C60071 c60071 = new C60071(this.this$0);
                        this.label = 1;
                        if (viewState.collect(c60071, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1$1$2, reason: invalid class name */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1$1$2", m5608f = "DocumentRequirementsFragment.kt", m5609i = {}, m5610l = {97}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DocumentRequirementsFragment this$0;

                /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$onViewCreated$1$1$2$1, reason: invalid class name and collision with other inner class name */
                @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                /* synthetic */ class C60081 implements FlowCollector, FunctionAdapter {
                    final /* synthetic */ DocumentRequirementsFragment $tmp0;

                    C60081(DocumentRequirementsFragment documentRequirementsFragment) {
                        this.$tmp0 = documentRequirementsFragment;
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
                        return new AdaptedFunctionReference(2, this.$tmp0, DocumentRequirementsFragment.class, "handleSideEffect", "handleSideEffect(Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;)V", 4);
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
                AnonymousClass2(DocumentRequirementsFragment documentRequirementsFragment, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = documentRequirementsFragment;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ Object invokeSuspend$handleSideEffect(DocumentRequirementsFragment documentRequirementsFragment, DocumentSideEffect documentSideEffect, Continuation continuation) {
                    documentRequirementsFragment.handleSideEffect(documentSideEffect);
                    return Unit.INSTANCE;
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
                        DocumentRequirementsViewModel documentRequirementsViewModel = this.this$0.viewModel;
                        if (documentRequirementsViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            documentRequirementsViewModel = null;
                        }
                        Flow<DocumentSideEffect> sideEffect = documentRequirementsViewModel.getSideEffect();
                        C60081 c60081 = new C60081(this.this$0);
                        this.label = 1;
                        if (sideEffect.collect(c60081, this) == coroutine_suspended) {
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
            AnonymousClass1(DocumentRequirementsFragment documentRequirementsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = documentRequirementsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C60061(this.this$0, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.this$0, null), 3, null);
                return Unit.INSTANCE;
            }
        }

        C46831(Continuation<? super C46831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentRequirementsFragment.this.new C46831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = DocumentRequirementsFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DocumentRequirementsFragment.this, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, anonymousClass1, this) == coroutine_suspended) {
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

    public DocumentRequirementsFragment() {
        super(C4597R.layout.yds_fragment_document_requirements);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentDocumentRequirementsBinding>() { // from class: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentDocumentRequirementsBinding invoke() {
                return YdsFragmentDocumentRequirementsBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentDocumentRequirementsBinding getBinding() {
        return (YdsFragmentDocumentRequirementsBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @ForDocumentRequirements
    public static /* synthetic */ void getFactory$annotations() {
    }

    private final void handleError(YdsFailure failure) {
        showFailure(failure, getFailureTypeToErrorTagMapper().map(failure.getFailureType()).name());
    }

    private final void handleLoading(NavigationIcon navigationIcon) {
        YdsFragmentDocumentRequirementsBinding binding = getBinding();
        YotiAppbarTransparent yotiAppbarTransparent = binding.loadingView.appBarLoading;
        Intrinsics.checkNotNullExpressionValue(yotiAppbarTransparent, "loadingView.appBarLoading");
        BaseFragment.configureAppBar$default(this, yotiAppbarTransparent, navigationIcon, false, 0, 0, 0, 60, null);
        ConstraintLayout root = binding.loadingView.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "loadingView.root");
        root.setVisibility(0);
        ConstraintLayout root2 = binding.successView.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "successView.root");
        root2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSideEffect(DocumentSideEffect sideEffect) {
        YotiButton yotiButton = getBinding().successView.buttonRequirementsActionPrimary;
        if (Intrinsics.areEqual(sideEffect, DocumentSideEffect.ShowCtaLoading.INSTANCE)) {
            yotiButton.setEnabled(false);
            yotiButton.showProgress();
        } else if (Intrinsics.areEqual(sideEffect, DocumentSideEffect.HideCtaLoading.INSTANCE)) {
            yotiButton.setEnabled(true);
            Intrinsics.checkNotNullExpressionValue(yotiButton, "");
            HideButtonProgressWithDelayKt.hideProgressWithDelay(yotiButton);
        }
    }

    private final void handleSuccess(DocumentRequirementsViewData viewData, NavigationIcon navigationIcon) {
        ConstraintLayout root = getBinding().loadingView.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.loadingView.root");
        root.setVisibility(8);
        YdsFragmentDocumentRequirementsSuccessStateBinding ydsFragmentDocumentRequirementsSuccessStateBinding = getBinding().successView;
        ConstraintLayout root2 = ydsFragmentDocumentRequirementsSuccessStateBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "root");
        root2.setVisibility(0);
        YotiAppbarTransparent appBar = ydsFragmentDocumentRequirementsSuccessStateBinding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, navigationIcon, false, 0, 0, 0, 60, null);
        TextView textView = ydsFragmentDocumentRequirementsSuccessStateBinding.textViewRequirementsTitle;
        CompoundTextResource title = viewData.getTitle();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(title.getValue(contextRequireContext));
        RecyclerView.Adapter adapter = ydsFragmentDocumentRequirementsSuccessStateBinding.recyclerViewRequirements.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsAdapter");
        }
        ((DocumentRequirementsAdapter) adapter).setItems(viewData.getListItems());
        ydsFragmentDocumentRequirementsSuccessStateBinding.buttonRequirementsActionPrimary.setText(getString(viewData.getPrimaryCtaText()));
        ydsFragmentDocumentRequirementsSuccessStateBinding.buttonRequirementsActionSecondary.setText(getString(viewData.getSecondaryCtaText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViewState(DocumentRequirementsViewState viewState) {
        if (viewState instanceof DocumentRequirementsViewState.Loading) {
            handleLoading(((DocumentRequirementsViewState.Loading) viewState).getNavigationIcon());
            return;
        }
        if (viewState instanceof DocumentRequirementsViewState.Success) {
            DocumentRequirementsViewState.Success success = (DocumentRequirementsViewState.Success) viewState;
            handleSuccess(success.getViewData(), success.getNavigationIcon());
        } else if (viewState instanceof DocumentRequirementsViewState.Error) {
            handleError(((DocumentRequirementsViewState.Error) viewState).getFailure());
        }
    }

    private final boolean isCameraPermissionNeeded() {
        return getCoordinator().isCameraPermissionRequired() && !FragmentKt.isCameraPermissionGranted(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-4$lambda-0, reason: not valid java name */
    public static final void m6846onViewCreated$lambda4$lambda0(DocumentRequirementsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentRequirementsViewModel documentRequirementsViewModel = this$0.viewModel;
        if (documentRequirementsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentRequirementsViewModel = null;
        }
        documentRequirementsViewModel.handleViewEvent(new DocumentViewEvent.StartScan(this$0.isCameraPermissionNeeded()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-4$lambda-1, reason: not valid java name */
    public static final void m6847onViewCreated$lambda4$lambda1(DocumentRequirementsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentRequirementsViewModel documentRequirementsViewModel = this$0.viewModel;
        if (documentRequirementsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentRequirementsViewModel = null;
        }
        documentRequirementsViewModel.handleViewEvent(DocumentRequirementsViewEvent.IncorrectDocument.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-4$lambda-2, reason: not valid java name */
    public static final void m6848onViewCreated$lambda4$lambda2(DocumentRequirementsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentRequirementsViewModel documentRequirementsViewModel = this$0.viewModel;
        if (documentRequirementsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentRequirementsViewModel = null;
        }
        documentRequirementsViewModel.handleViewEvent(DocumentRequirementsViewEvent.SeeScanningGuidelines.INSTANCE);
    }

    public final DocumentFeatureErrorTagToViewEventMapper getErrorTagToViewEventMapper() {
        DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper = this.errorTagToViewEventMapper;
        if (documentFeatureErrorTagToViewEventMapper != null) {
            return documentFeatureErrorTagToViewEventMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("errorTagToViewEventMapper");
        return null;
    }

    public final SavedStateViewModelFactory<DocumentRequirementsViewModel> getFactory() {
        SavedStateViewModelFactory<DocumentRequirementsViewModel> savedStateViewModelFactory = this.factory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final DocumentFailureTypeToErrorTagMapper getFailureTypeToErrorTagMapper() {
        DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper = this.failureTypeToErrorTagMapper;
        if (documentFailureTypeToErrorTagMapper != null) {
            return documentFailureTypeToErrorTagMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("failureTypeToErrorTagMapper");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DocumentCaptureCoreSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = (DocumentRequirementsViewModel) getFactory().create(this);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        DocumentRequirementsViewModel documentRequirementsViewModel = this.viewModel;
        if (documentRequirementsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentRequirementsViewModel = null;
        }
        documentRequirementsViewModel.handleViewEvent(getErrorTagToViewEventMapper().map(new DocumentFeatureErrorTagToViewEventMapper.MapperParams(DocumentFeatureErrorTag.valueOf(dialogTag), false, isCameraPermissionNeeded())));
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        DocumentRequirementsViewModel documentRequirementsViewModel = this.viewModel;
        if (documentRequirementsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentRequirementsViewModel = null;
        }
        documentRequirementsViewModel.handleViewEvent(getErrorTagToViewEventMapper().map(new DocumentFeatureErrorTagToViewEventMapper.MapperParams(DocumentFeatureErrorTag.valueOf(dialogTag), true, isCameraPermissionNeeded())));
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            DocumentViewEvent cameraPermissionsDenied = ((grantResults.length == 0) || grantResults[0] != 0) ? new DocumentViewEvent.CameraPermissionsDenied(shouldShowRequestPermissionRationale("android.permission.CAMERA")) : DocumentViewEvent.CameraPermissionGranted.INSTANCE;
            DocumentRequirementsViewModel documentRequirementsViewModel = this.viewModel;
            if (documentRequirementsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                documentRequirementsViewModel = null;
            }
            documentRequirementsViewModel.handleViewEvent(cameraPermissionsDenied);
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getCoordinator().bind(this, 0);
        DocumentRequirementsViewModel documentRequirementsViewModel = this.viewModel;
        if (documentRequirementsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentRequirementsViewModel = null;
        }
        NavigationUtilsKt.bindNavigationViewModel((Fragment) this, (NavigationViewModel) documentRequirementsViewModel);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C46831(null), 3, null);
        YdsFragmentDocumentRequirementsSuccessStateBinding ydsFragmentDocumentRequirementsSuccessStateBinding = getBinding().successView;
        NestedScrollView scrollView = ydsFragmentDocumentRequirementsSuccessStateBinding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadowViewRequirements = ydsFragmentDocumentRequirementsSuccessStateBinding.shadowViewRequirements;
        Intrinsics.checkNotNullExpressionValue(shadowViewRequirements, "shadowViewRequirements");
        new ShadowedScrollViewMediator(scrollView, shadowViewRequirements).attach();
        ydsFragmentDocumentRequirementsSuccessStateBinding.buttonRequirementsActionPrimary.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentRequirementsFragment.m6846onViewCreated$lambda4$lambda0(this.f$0, view2);
            }
        });
        ydsFragmentDocumentRequirementsSuccessStateBinding.buttonRequirementsActionSecondary.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentRequirementsFragment.m6847onViewCreated$lambda4$lambda1(this.f$0, view2);
            }
        });
        ydsFragmentDocumentRequirementsSuccessStateBinding.buttonSeeScanningGuidelines.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentRequirementsFragment.m6848onViewCreated$lambda4$lambda2(this.f$0, view2);
            }
        });
        RecyclerView recyclerView = ydsFragmentDocumentRequirementsSuccessStateBinding.recyclerViewRequirements;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new DocumentRequirementsAdapter());
    }

    public void setCoordinator(DocumentRequirementsCoordinator documentRequirementsCoordinator) {
        Intrinsics.checkNotNullParameter(documentRequirementsCoordinator, "<set-?>");
        this.coordinator = documentRequirementsCoordinator;
    }

    public final void setErrorTagToViewEventMapper(DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper) {
        Intrinsics.checkNotNullParameter(documentFeatureErrorTagToViewEventMapper, "<set-?>");
        this.errorTagToViewEventMapper = documentFeatureErrorTagToViewEventMapper;
    }

    public final void setFactory(SavedStateViewModelFactory<DocumentRequirementsViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.factory = savedStateViewModelFactory;
    }

    public final void setFailureTypeToErrorTagMapper(DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper) {
        Intrinsics.checkNotNullParameter(documentFailureTypeToErrorTagMapper, "<set-?>");
        this.failureTypeToErrorTagMapper = documentFailureTypeToErrorTagMapper;
    }

    @Override // com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost
    public DocumentRequirementsCoordinator getCoordinator() {
        DocumentRequirementsCoordinator documentRequirementsCoordinator = this.coordinator;
        if (documentRequirementsCoordinator != null) {
            return documentRequirementsCoordinator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coordinator");
        return null;
    }
}
