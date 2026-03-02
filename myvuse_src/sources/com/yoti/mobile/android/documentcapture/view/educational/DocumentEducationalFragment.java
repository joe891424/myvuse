package com.yoti.mobile.android.documentcapture.view.educational;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.navigation.NavArgsLazy;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost;
import com.yoti.mobile.android.commons.navigation.NavigationUtilsKt;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.MediaResource;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.HideButtonProgressWithDelayKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentDocumentEducationalBinding;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentDocumentEducationalSuccessStateBinding;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentEducational;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTag;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentSideEffect;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalViewState;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentNavigationCoordinatorHelper;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentViewData;
import com.yoti.mobile.android.documentcapture.view.selection.ObjectiveRequirementsAdapter;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@Metadata(m5597d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010B\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u000206H\u0002J\u0010\u0010G\u001a\u0002062\u0006\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u0002062\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u000206H\u0016J\u0010\u0010Q\u001a\u0002062\u0006\u0010N\u001a\u00020OH\u0016J+\u0010R\u001a\u0002062\u0006\u0010S\u001a\u00020T2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020O0V2\u0006\u0010W\u001a\u00020XH\u0016¢\u0006\u0002\u0010YJ\b\u0010Z\u001a\u000206H\u0016J\u001a\u0010[\u001a\u0002062\u0006\u0010\\\u001a\u00020]2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010^\u001a\u000206H\u0002J\b\u0010_\u001a\u000206H\u0002J\u0012\u0010`\u001a\u0002062\b\b\u0001\u0010a\u001a\u00020TH\u0002J\u0010\u0010b\u001a\u0002062\u0006\u0010c\u001a\u00020dH\u0002J\u0012\u0010e\u001a\u0002062\b\b\u0001\u0010f\u001a\u00020TH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006g"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "Lcom/yoti/mobile/android/commons/navigation/NavigationCoordinatorHost;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentEducationalBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentEducationalBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "coordinator", "Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentNavigationCoordinatorHelper;", "getCoordinator", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentNavigationCoordinatorHelper;", "setCoordinator", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentNavigationCoordinatorHelper;)V", "errorTagToViewEventMapper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "getErrorTagToViewEventMapper", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "setErrorTagToViewEventMapper", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;)V", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewModel;", "getFactory$annotations", "getFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "failureTypeToErrorTagMapper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "getFailureTypeToErrorTagMapper", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "setFailureTypeToErrorTagMapper", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;)V", "isCameraPermissionNeeded", "", "()Z", "navArgs", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalFragmentArgs;", "getNavArgs", "()Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalFragmentArgs;", "navArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "objRequirementsAdapter", "Lcom/yoti/mobile/android/documentcapture/view/selection/ObjectiveRequirementsAdapter;", "getObjRequirementsAdapter", "()Lcom/yoti/mobile/android/documentcapture/view/selection/ObjectiveRequirementsAdapter;", "setObjRequirementsAdapter", "(Lcom/yoti/mobile/android/documentcapture/view/selection/ObjectiveRequirementsAdapter;)V", "playEducationalVideo", "viewModel", "bindViewData", "", "viewData", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;", "handleError", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "handleLoading", "visibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;", "handleSideEffect", "sideEffect", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "handleSuccess", "handleViewState", "viewState", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState;", "hideEducationalMedia", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNegativeButtonClick", "dialogTag", "", "onPause", "onPositiveButtonClick", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "Landroid/view/View;", "setUpClickListeners", "setUpViewModel", "showEducationalImage", "imageResId", "showEducationalMedia", "educationalMedia", "Lcom/yoti/mobile/android/commonui/MediaResource;", "showEducationalVideo", "videoResId", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentEducationalFragment extends BaseFragment implements NavigationCoordinatorHost {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DocumentEducationalFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentEducationalBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    @Inject
    public DocumentNavigationCoordinatorHelper coordinator;

    @Inject
    public DocumentFeatureErrorTagToViewEventMapper errorTagToViewEventMapper;

    @Inject
    public SavedStateViewModelFactory<DocumentEducationalViewModel> factory;

    @Inject
    public DocumentFailureTypeToErrorTagMapper failureTypeToErrorTagMapper;

    /* JADX INFO: renamed from: navArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy navArgs;

    @Inject
    public ObjectiveRequirementsAdapter objRequirementsAdapter;
    private boolean playEducationalVideo;
    private DocumentEducationalViewModel viewModel;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaResource.MediaType.values().length];
            iArr[MediaResource.MediaType.VIDEO.ordinal()] = 1;
            iArr[MediaResource.MediaType.IMAGE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1", m5608f = "DocumentEducationalFragment.kt", m5609i = {}, m5610l = {167}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1$1, reason: invalid class name */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1$1", m5608f = "DocumentEducationalFragment.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DocumentEducationalFragment this$0;

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1$1$1", m5608f = "DocumentEducationalFragment.kt", m5609i = {}, m5610l = {169}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
            static final class C60021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DocumentEducationalFragment this$0;

                /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                /* synthetic */ class C60031 implements FlowCollector, FunctionAdapter {
                    final /* synthetic */ DocumentEducationalFragment $tmp0;

                    C60031(DocumentEducationalFragment documentEducationalFragment) {
                        this.$tmp0 = documentEducationalFragment;
                    }

                    public final Object emit(DocumentEducationalViewState documentEducationalViewState, Continuation<? super Unit> continuation) {
                        Object objInvokeSuspend$handleViewState = C60021.invokeSuspend$handleViewState(this.$tmp0, documentEducationalViewState, continuation);
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
                        return new AdaptedFunctionReference(2, this.$tmp0, DocumentEducationalFragment.class, "handleViewState", "handleViewState(Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState;)V", 4);
                    }

                    public final int hashCode() {
                        return getFunctionDelegate().hashCode();
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit((DocumentEducationalViewState) obj, (Continuation<? super Unit>) continuation);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C60021(DocumentEducationalFragment documentEducationalFragment, Continuation<? super C60021> continuation) {
                    super(2, continuation);
                    this.this$0 = documentEducationalFragment;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ Object invokeSuspend$handleViewState(DocumentEducationalFragment documentEducationalFragment, DocumentEducationalViewState documentEducationalViewState, Continuation continuation) {
                    documentEducationalFragment.handleViewState(documentEducationalViewState);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C60021(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C60021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        DocumentEducationalViewModel documentEducationalViewModel = this.this$0.viewModel;
                        if (documentEducationalViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            documentEducationalViewModel = null;
                        }
                        Flow<DocumentEducationalViewState> viewState = documentEducationalViewModel.getViewState();
                        C60031 c60031 = new C60031(this.this$0);
                        this.label = 1;
                        if (viewState.collect(c60031, this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1$1$2, reason: invalid class name */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1$1$2", m5608f = "DocumentEducationalFragment.kt", m5609i = {}, m5610l = {172}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DocumentEducationalFragment this$0;

                /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$setUpViewModel$1$1$2$1, reason: invalid class name and collision with other inner class name */
                @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                /* synthetic */ class C60041 implements FlowCollector, FunctionAdapter {
                    final /* synthetic */ DocumentEducationalFragment $tmp0;

                    C60041(DocumentEducationalFragment documentEducationalFragment) {
                        this.$tmp0 = documentEducationalFragment;
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
                        return new AdaptedFunctionReference(2, this.$tmp0, DocumentEducationalFragment.class, "handleSideEffect", "handleSideEffect(Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;)V", 4);
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
                AnonymousClass2(DocumentEducationalFragment documentEducationalFragment, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = documentEducationalFragment;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ Object invokeSuspend$handleSideEffect(DocumentEducationalFragment documentEducationalFragment, DocumentSideEffect documentSideEffect, Continuation continuation) {
                    documentEducationalFragment.handleSideEffect(documentSideEffect);
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
                        DocumentEducationalViewModel documentEducationalViewModel = this.this$0.viewModel;
                        if (documentEducationalViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            documentEducationalViewModel = null;
                        }
                        Flow<DocumentSideEffect> sideEffect = documentEducationalViewModel.getSideEffect();
                        C60041 c60041 = new C60041(this.this$0);
                        this.label = 1;
                        if (sideEffect.collect(c60041, this) == coroutine_suspended) {
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
            AnonymousClass1(DocumentEducationalFragment documentEducationalFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = documentEducationalFragment;
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
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C60021(this.this$0, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.this$0, null), 3, null);
                return Unit.INSTANCE;
            }
        }

        C46811(Continuation<? super C46811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentEducationalFragment.this.new C46811(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = DocumentEducationalFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DocumentEducationalFragment.this, null);
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

    public DocumentEducationalFragment() {
        super(C4597R.layout.yds_fragment_document_educational);
        this.navArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(DocumentEducationalFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = this.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + this + " has null arguments");
            }
        });
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentDocumentEducationalBinding>() { // from class: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentDocumentEducationalBinding invoke() {
                return YdsFragmentDocumentEducationalBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final void bindViewData(DocumentEducationalViewData viewData) {
        Unit unit;
        YdsFragmentDocumentEducationalBinding binding = getBinding();
        TextView textView = binding.successView.textViewEducationalTitle;
        CompoundTextResource title = viewData.getTitle();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(title.getValue(contextRequireContext));
        TextView textView2 = binding.successView.textViewEducationalMessage;
        CompoundTextResource message = viewData.getMessage();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        textView2.setText(message.getValue(contextRequireContext2));
        binding.buttonStartScan.setText(getString(viewData.getCtaText()));
        binding.buttonDoNotHave.setText(viewData.getDoNotHaveDocumentsViewData().getLabelId());
        List<Integer> requirements = viewData.getRequirements();
        if (requirements != null) {
            RecyclerView recyclerView = binding.successView.objectiveRequirementList;
            recyclerView.setVisibility(0);
            ObjectiveRequirementsAdapter objRequirementsAdapter = getObjRequirementsAdapter();
            objRequirementsAdapter.setRequirements(requirements);
            recyclerView.setAdapter(objRequirementsAdapter);
        }
        MediaResource mediaResource = viewData.getMediaResource();
        if (mediaResource != null) {
            showEducationalMedia(mediaResource);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            hideEducationalMedia();
        }
    }

    private final YdsFragmentDocumentEducationalBinding getBinding() {
        return (YdsFragmentDocumentEducationalBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @ForDocumentEducational
    public static /* synthetic */ void getFactory$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DocumentEducationalFragmentArgs getNavArgs() {
        return (DocumentEducationalFragmentArgs) this.navArgs.getValue();
    }

    private final void handleError(YdsFailure failure) {
        showFailure(failure, getFailureTypeToErrorTagMapper().map(failure.getFailureType()).name());
    }

    private final void handleLoading(DocumentEducationalViewState.VisibilityToggles visibilityToggles) {
        YdsFragmentDocumentEducationalBinding binding = getBinding();
        Group loadingViewGroup = binding.loadingViewGroup;
        Intrinsics.checkNotNullExpressionValue(loadingViewGroup, "loadingViewGroup");
        loadingViewGroup.setVisibility(0);
        Group successViewGroup = binding.successViewGroup;
        Intrinsics.checkNotNullExpressionValue(successViewGroup, "successViewGroup");
        successViewGroup.setVisibility(8);
        View view = binding.loadingView.moreAboutVerificationLoading;
        Intrinsics.checkNotNullExpressionValue(view, "loadingView.moreAboutVerificationLoading");
        view.setVisibility(visibilityToggles.getShowMoreAboutVerification() ? 0 : 8);
        View buttonDoNotHaveLoading = binding.buttonDoNotHaveLoading;
        Intrinsics.checkNotNullExpressionValue(buttonDoNotHaveLoading, "buttonDoNotHaveLoading");
        buttonDoNotHaveLoading.setVisibility(visibilityToggles.getShowDoNotHaveDocuments() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSideEffect(DocumentSideEffect sideEffect) {
        YotiButton yotiButton = getBinding().buttonStartScan;
        if (Intrinsics.areEqual(sideEffect, DocumentSideEffect.ShowCtaLoading.INSTANCE)) {
            yotiButton.setEnabled(false);
            yotiButton.showProgress();
        } else if (Intrinsics.areEqual(sideEffect, DocumentSideEffect.HideCtaLoading.INSTANCE)) {
            yotiButton.setEnabled(true);
            Intrinsics.checkNotNullExpressionValue(yotiButton, "");
            HideButtonProgressWithDelayKt.hideProgressWithDelay(yotiButton);
        }
    }

    private final void handleSuccess(DocumentEducationalViewData viewData, DocumentEducationalViewState.VisibilityToggles visibilityToggles) {
        YdsFragmentDocumentEducationalBinding binding = getBinding();
        Group loadingViewGroup = binding.loadingViewGroup;
        Intrinsics.checkNotNullExpressionValue(loadingViewGroup, "loadingViewGroup");
        loadingViewGroup.setVisibility(8);
        Group successViewGroup = binding.successViewGroup;
        Intrinsics.checkNotNullExpressionValue(successViewGroup, "successViewGroup");
        successViewGroup.setVisibility(0);
        LinearLayout root = binding.successView.identityCheckLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "successView.identityCheckLayout.root");
        root.setVisibility(visibilityToggles.getShowIdentityCheck() ? 0 : 8);
        YotiButton yotiButton = binding.successView.buttonMoreAboutVerification;
        Intrinsics.checkNotNullExpressionValue(yotiButton, "successView.buttonMoreAboutVerification");
        yotiButton.setVisibility(visibilityToggles.getShowMoreAboutVerification() ? 0 : 8);
        YotiButton buttonDoNotHave = binding.buttonDoNotHave;
        Intrinsics.checkNotNullExpressionValue(buttonDoNotHave, "buttonDoNotHave");
        buttonDoNotHave.setVisibility(visibilityToggles.getShowDoNotHaveDocuments() ? 0 : 8);
        bindViewData(viewData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViewState(DocumentEducationalViewState viewState) {
        if (viewState instanceof DocumentEducationalViewState.Loading) {
            handleLoading(((DocumentEducationalViewState.Loading) viewState).getVisibilityToggles());
            return;
        }
        if (viewState instanceof DocumentEducationalViewState.Success) {
            DocumentEducationalViewState.Success success = (DocumentEducationalViewState.Success) viewState;
            handleSuccess(success.getViewData(), success.getVisibilityToggles());
        } else {
            if (!(viewState instanceof DocumentEducationalViewState.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            handleError(((DocumentEducationalViewState.Error) viewState).getFailure());
        }
    }

    private final void hideEducationalMedia() {
        CardView cardView = getBinding().successView.cardVideoContainer;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.successView.cardVideoContainer");
        cardView.setVisibility(8);
        this.playEducationalVideo = false;
    }

    private final boolean isCameraPermissionNeeded() {
        return getCoordinator().isCameraPermissionRequired() && !FragmentKt.isCameraPermissionGranted(this);
    }

    private final void setUpClickListeners() {
        YdsFragmentDocumentEducationalBinding binding = getBinding();
        YdsFragmentDocumentEducationalSuccessStateBinding ydsFragmentDocumentEducationalSuccessStateBinding = binding.successView;
        Iterator it2 = CollectionsKt.listOf((Object[]) new YotiButton[]{ydsFragmentDocumentEducationalSuccessStateBinding.buttonMoreAboutVerification, ydsFragmentDocumentEducationalSuccessStateBinding.identityCheckLayout.buttonMoreAboutIdentityCheck}).iterator();
        while (it2.hasNext()) {
            ((YotiButton) it2.next()).setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentEducationalFragment.m6841setUpClickListeners$lambda5$lambda2$lambda1(this.f$0, view);
                }
            });
        }
        binding.buttonStartScan.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentEducationalFragment.m6842setUpClickListeners$lambda5$lambda3(this.f$0, view);
            }
        });
        binding.buttonDoNotHave.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentEducationalFragment.m6843setUpClickListeners$lambda5$lambda4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setUpClickListeners$lambda-5$lambda-2$lambda-1, reason: not valid java name */
    public static final void m6841setUpClickListeners$lambda5$lambda2$lambda1(DocumentEducationalFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentEducationalViewModel documentEducationalViewModel = this$0.viewModel;
        if (documentEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentEducationalViewModel = null;
        }
        documentEducationalViewModel.handleViewEvent(DocumentViewEvent.MoreAboutVerification.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setUpClickListeners$lambda-5$lambda-3, reason: not valid java name */
    public static final void m6842setUpClickListeners$lambda5$lambda3(DocumentEducationalFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentEducationalViewModel documentEducationalViewModel = this$0.viewModel;
        if (documentEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentEducationalViewModel = null;
        }
        documentEducationalViewModel.handleViewEvent(new DocumentViewEvent.StartScan(this$0.isCameraPermissionNeeded()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setUpClickListeners$lambda-5$lambda-4, reason: not valid java name */
    public static final void m6843setUpClickListeners$lambda5$lambda4(DocumentEducationalFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentEducationalViewModel documentEducationalViewModel = this$0.viewModel;
        if (documentEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentEducationalViewModel = null;
        }
        documentEducationalViewModel.handleViewEvent(DocumentViewEvent.DoNotHaveDocument.INSTANCE);
    }

    private final void setUpViewModel() {
        DocumentEducationalViewModel documentEducationalViewModel = this.viewModel;
        if (documentEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentEducationalViewModel = null;
        }
        NavigationUtilsKt.bindNavigationViewModel((Fragment) this, (NavigationViewModel) documentEducationalViewModel);
        DocumentEducationalFragmentArgs navArgs = getNavArgs();
        DocumentViewData documentViewData = navArgs.getDocumentViewData();
        String countryIso3Code = navArgs.getCountryIso3Code();
        CaptureObjectiveTypeViewData objective = navArgs.getObjective();
        DocumentEducationalViewModel documentEducationalViewModel2 = this.viewModel;
        if (documentEducationalViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentEducationalViewModel2 = null;
        }
        documentEducationalViewModel2.init((documentViewData == null || countryIso3Code == null || objective == null) ? null : new DocumentEducationalArguments(documentViewData, countryIso3Code, objective));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C46811(null), 3, null);
    }

    private final void showEducationalImage(int imageResId) {
    }

    private final void showEducationalMedia(MediaResource educationalMedia) {
        CardView cardView = getBinding().successView.cardVideoContainer;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.successView.cardVideoContainer");
        boolean z = false;
        cardView.setVisibility(0);
        int i = WhenMappings.$EnumSwitchMapping$0[educationalMedia.getMediaType().ordinal()];
        if (i == 1) {
            showEducationalVideo(educationalMedia.getMediaResId());
            z = true;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            showEducationalImage(educationalMedia.getMediaResId());
        }
        this.playEducationalVideo = z;
    }

    private final void showEducationalVideo(int videoResId) {
        VideoView videoView = getBinding().successView.documentEducationalVideo;
        videoView.setBackground(null);
        videoView.setVideoURI(Uri.parse("android.resource://" + requireActivity().getPackageName() + '/' + videoResId));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.yoti.mobile.android.documentcapture.view.educational.DocumentEducationalFragment$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                DocumentEducationalFragment.m6844showEducationalVideo$lambda14$lambda13(mediaPlayer);
            }
        });
        videoView.setAudioFocusRequest(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showEducationalVideo$lambda-14$lambda-13, reason: not valid java name */
    public static final void m6844showEducationalVideo$lambda14$lambda13(MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public final DocumentFeatureErrorTagToViewEventMapper getErrorTagToViewEventMapper() {
        DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper = this.errorTagToViewEventMapper;
        if (documentFeatureErrorTagToViewEventMapper != null) {
            return documentFeatureErrorTagToViewEventMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("errorTagToViewEventMapper");
        return null;
    }

    public final SavedStateViewModelFactory<DocumentEducationalViewModel> getFactory() {
        SavedStateViewModelFactory<DocumentEducationalViewModel> savedStateViewModelFactory = this.factory;
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

    public final ObjectiveRequirementsAdapter getObjRequirementsAdapter() {
        ObjectiveRequirementsAdapter objectiveRequirementsAdapter = this.objRequirementsAdapter;
        if (objectiveRequirementsAdapter != null) {
            return objectiveRequirementsAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("objRequirementsAdapter");
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
        this.viewModel = (DocumentEducationalViewModel) getFactory().create(this);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        DocumentEducationalViewModel documentEducationalViewModel = this.viewModel;
        if (documentEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentEducationalViewModel = null;
        }
        documentEducationalViewModel.handleViewEvent(getErrorTagToViewEventMapper().map(new DocumentFeatureErrorTagToViewEventMapper.MapperParams(DocumentFeatureErrorTag.valueOf(dialogTag), false, isCameraPermissionNeeded())));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBinding().successView.documentEducationalVideo.stopPlayback();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        DocumentEducationalViewModel documentEducationalViewModel = this.viewModel;
        if (documentEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentEducationalViewModel = null;
        }
        documentEducationalViewModel.handleViewEvent(getErrorTagToViewEventMapper().map(new DocumentFeatureErrorTagToViewEventMapper.MapperParams(DocumentFeatureErrorTag.valueOf(dialogTag), true, isCameraPermissionNeeded())));
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            DocumentViewEvent cameraPermissionsDenied = ((grantResults.length == 0) || grantResults[0] != 0) ? new DocumentViewEvent.CameraPermissionsDenied(shouldShowRequestPermissionRationale("android.permission.CAMERA")) : DocumentViewEvent.CameraPermissionGranted.INSTANCE;
            DocumentEducationalViewModel documentEducationalViewModel = this.viewModel;
            if (documentEducationalViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                documentEducationalViewModel = null;
            }
            documentEducationalViewModel.handleViewEvent(cameraPermissionsDenied);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.playEducationalVideo) {
            getBinding().successView.documentEducationalVideo.start();
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getCoordinator().bind(this, 0);
        for (YotiAppbar it2 : CollectionsKt.listOf((Object[]) new YotiAppbar[]{getBinding().appBarLoading, getBinding().appBar})) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            BaseFragment.configureAppBar$default(this, it2, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        }
        setUpViewModel();
        setUpClickListeners();
        ScrollView scrollView = getBinding().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "binding.scrollView");
        View view2 = getBinding().shadow;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.shadow");
        new ShadowedScrollViewMediator(scrollView, view2).attach();
    }

    public void setCoordinator(DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper) {
        Intrinsics.checkNotNullParameter(documentNavigationCoordinatorHelper, "<set-?>");
        this.coordinator = documentNavigationCoordinatorHelper;
    }

    public final void setErrorTagToViewEventMapper(DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper) {
        Intrinsics.checkNotNullParameter(documentFeatureErrorTagToViewEventMapper, "<set-?>");
        this.errorTagToViewEventMapper = documentFeatureErrorTagToViewEventMapper;
    }

    public final void setFactory(SavedStateViewModelFactory<DocumentEducationalViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.factory = savedStateViewModelFactory;
    }

    public final void setFailureTypeToErrorTagMapper(DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper) {
        Intrinsics.checkNotNullParameter(documentFailureTypeToErrorTagMapper, "<set-?>");
        this.failureTypeToErrorTagMapper = documentFailureTypeToErrorTagMapper;
    }

    public final void setObjRequirementsAdapter(ObjectiveRequirementsAdapter objectiveRequirementsAdapter) {
        Intrinsics.checkNotNullParameter(objectiveRequirementsAdapter, "<set-?>");
        this.objRequirementsAdapter = objectiveRequirementsAdapter;
    }

    @Override // com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost
    public DocumentNavigationCoordinatorHelper getCoordinator() {
        DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper = this.coordinator;
        if (documentNavigationCoordinatorHelper != null) {
            return documentNavigationCoordinatorHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coordinator");
        return null;
    }
}
