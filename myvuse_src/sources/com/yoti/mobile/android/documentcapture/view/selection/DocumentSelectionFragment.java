package com.yoti.mobile.android.documentcapture.view.selection;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost;
import com.yoti.mobile.android.commons.navigation.NavigationUtilsKt;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentDocumentSelectionBinding;
import com.yoti.mobile.android.documentcapture.databinding.YdsFragmentDocumentSelectionSuccessStateBinding;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentSelection;
import com.yoti.mobile.android.documentcapture.view.DocumentFailureTypeToErrorTagMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTag;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTagToViewEventMapper;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionListItem;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewEvent;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewState;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
@Metadata(m5597d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u00020/2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020<H\u0002J \u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010;\u001a\u00020<H\u0002J\u0018\u0010B\u001a\u00020/2\u0006\u0010>\u001a\u00020?2\u0006\u0010C\u001a\u00020+H\u0002J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020/2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020/2\u0006\u0010N\u001a\u00020OH\u0016J+\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u0002062\f\u0010S\u001a\b\u0012\u0004\u0012\u00020O0T2\u0006\u0010U\u001a\u00020VH\u0016¢\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020/H\u0016J\u001a\u0010Y\u001a\u00020/2\u0006\u0010Z\u001a\u00020[2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010\\\u001a\u00020/H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010,R\u000e\u0010-\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u0006]"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "Lcom/yoti/mobile/android/commons/navigation/NavigationCoordinatorHost;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentSelectionBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentSelectionBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "coordinator", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionCoordinator;", "getCoordinator", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionCoordinator;", "setCoordinator", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionCoordinator;)V", "documentsAdapter", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentsAdapter;", "getDocumentsAdapter", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentsAdapter;", "setDocumentsAdapter", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentsAdapter;)V", "errorTagToViewEventMapper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "getErrorTagToViewEventMapper", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;", "setErrorTagToViewEventMapper", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureErrorTagToViewEventMapper;)V", "factory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewModel;", "getFactory$annotations", "getFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "failureTypeToErrorTagMapper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "getFailureTypeToErrorTagMapper", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;", "setFailureTypeToErrorTagMapper", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentFailureTypeToErrorTagMapper;)V", "isCameraPermissionNeeded", "", "()Z", "viewModel", "displayEmptyCountryState", "", "displaySelectedCountryOptionState", "selectionOption", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "doNotHaveDocumentsViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;", "getDisabledTextColor", "", "handleError", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "handleLoading", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "handleSuccess", "viewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "visibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$VisibilityToggles;", "handleViewData", "showDoNotHaveDocuments", "handleViewState", "viewState", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNegativeButtonClick", "dialogTag", "", "onPositiveButtonClick", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "Landroid/view/View;", "setUpClickListeners", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentSelectionFragment extends BaseFragment implements NavigationCoordinatorHost {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DocumentSelectionFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/databinding/YdsFragmentDocumentSelectionBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    @Inject
    public DocumentSelectionCoordinator coordinator;

    @Inject
    public DocumentsAdapter documentsAdapter;

    @Inject
    public DocumentFeatureErrorTagToViewEventMapper errorTagToViewEventMapper;

    @Inject
    public SavedStateViewModelFactory<DocumentSelectionViewModel> factory;

    @Inject
    public DocumentFailureTypeToErrorTagMapper failureTypeToErrorTagMapper;
    private DocumentSelectionViewModel viewModel;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$onViewCreated$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$onViewCreated$1", m5608f = "DocumentSelectionFragment.kt", m5609i = {}, m5610l = {87}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$onViewCreated$1$1, reason: invalid class name */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$onViewCreated$1$1", m5608f = "DocumentSelectionFragment.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DocumentSelectionFragment this$0;

            /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$onViewCreated$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$onViewCreated$1$1$1", m5608f = "DocumentSelectionFragment.kt", m5609i = {}, m5610l = {89}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
            static final class C60121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DocumentSelectionFragment this$0;

                /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$onViewCreated$1$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                /* synthetic */ class C60131 implements FlowCollector, FunctionAdapter {
                    final /* synthetic */ DocumentSelectionFragment $tmp0;

                    C60131(DocumentSelectionFragment documentSelectionFragment) {
                        this.$tmp0 = documentSelectionFragment;
                    }

                    public final Object emit(DocumentSelectionViewState documentSelectionViewState, Continuation<? super Unit> continuation) {
                        Object objInvokeSuspend$handleViewState = C60121.invokeSuspend$handleViewState(this.$tmp0, documentSelectionViewState, continuation);
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
                        return new AdaptedFunctionReference(2, this.$tmp0, DocumentSelectionFragment.class, "handleViewState", "handleViewState(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;)V", 4);
                    }

                    public final int hashCode() {
                        return getFunctionDelegate().hashCode();
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit((DocumentSelectionViewState) obj, (Continuation<? super Unit>) continuation);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C60121(DocumentSelectionFragment documentSelectionFragment, Continuation<? super C60121> continuation) {
                    super(2, continuation);
                    this.this$0 = documentSelectionFragment;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ Object invokeSuspend$handleViewState(DocumentSelectionFragment documentSelectionFragment, DocumentSelectionViewState documentSelectionViewState, Continuation continuation) {
                    documentSelectionFragment.handleViewState(documentSelectionViewState);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C60121(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C60121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        DocumentSelectionViewModel documentSelectionViewModel = this.this$0.viewModel;
                        if (documentSelectionViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            documentSelectionViewModel = null;
                        }
                        Flow<DocumentSelectionViewState> viewState = documentSelectionViewModel.getViewState();
                        C60131 c60131 = new C60131(this.this$0);
                        this.label = 1;
                        if (viewState.collect(c60131, this) == coroutine_suspended) {
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
            AnonymousClass1(DocumentSelectionFragment documentSelectionFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = documentSelectionFragment;
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
                BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new C60121(this.this$0, null), 3, null);
                return Unit.INSTANCE;
            }
        }

        C46881(Continuation<? super C46881> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentSelectionFragment.this.new C46881(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = DocumentSelectionFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DocumentSelectionFragment.this, null);
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

    public DocumentSelectionFragment() {
        super(C4597R.layout.yds_fragment_document_selection);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentDocumentSelectionBinding>() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentDocumentSelectionBinding invoke() {
                return YdsFragmentDocumentSelectionBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final void displayEmptyCountryState() {
        YdsFragmentDocumentSelectionSuccessStateBinding ydsFragmentDocumentSelectionSuccessStateBinding = getBinding().successView;
        ydsFragmentDocumentSelectionSuccessStateBinding.textViewIssuingCountry.setText(getString(C4597R.string.ios_android_yds_document_selection_no_selected_country));
        ydsFragmentDocumentSelectionSuccessStateBinding.textViewIssuingCountry.setTextColor(getDisabledTextColor());
        ydsFragmentDocumentSelectionSuccessStateBinding.buttonMoreAboutVerification.setVisibility(8);
    }

    private final void displaySelectedCountryOptionState(CountrySelectionOptionViewData selectionOption, DoNotHaveDocumentsViewData doNotHaveDocumentsViewData) {
        YdsFragmentDocumentSelectionSuccessStateBinding ydsFragmentDocumentSelectionSuccessStateBinding = getBinding().successView;
        TextView textView = ydsFragmentDocumentSelectionSuccessStateBinding.textViewIssuingCountry;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(selectionOption.getLabel(contextRequireContext));
        if (!(selectionOption instanceof CountryViewData)) {
            RecyclerView recyclerViewDocuments = ydsFragmentDocumentSelectionSuccessStateBinding.recyclerViewDocuments;
            Intrinsics.checkNotNullExpressionValue(recyclerViewDocuments, "recyclerViewDocuments");
            recyclerViewDocuments.setVisibility(8);
            YotiButton buttonContinueCountryNotListed = ydsFragmentDocumentSelectionSuccessStateBinding.buttonContinueCountryNotListed;
            Intrinsics.checkNotNullExpressionValue(buttonContinueCountryNotListed, "buttonContinueCountryNotListed");
            buttonContinueCountryNotListed.setVisibility(0);
            ydsFragmentDocumentSelectionSuccessStateBinding.textViewIssuingCountry.setTextColor(getDisabledTextColor());
            return;
        }
        RecyclerView recyclerView = ydsFragmentDocumentSelectionSuccessStateBinding.recyclerViewDocuments;
        DocumentsAdapter documentsAdapter = getDocumentsAdapter();
        documentsAdapter.setup$documentcapture_core_productionRelease(selectionOption, doNotHaveDocumentsViewData, new Function1<DocumentSelectionListItem, Unit>() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$displaySelectedCountryOptionState$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DocumentSelectionListItem documentSelectionListItem) {
                invoke2(documentSelectionListItem);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DocumentSelectionListItem listItem) {
                Intrinsics.checkNotNullParameter(listItem, "listItem");
                DocumentSelectionViewModel documentSelectionViewModel = null;
                if (listItem instanceof DocumentSelectionListItem.DocumentListItem) {
                    DocumentSelectionViewModel documentSelectionViewModel2 = this.this$0.viewModel;
                    if (documentSelectionViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        documentSelectionViewModel = documentSelectionViewModel2;
                    }
                    documentSelectionViewModel.handleViewEvent(new DocumentSelectionViewEvent.DocumentSelected(((DocumentSelectionListItem.DocumentListItem) listItem).getDocument(), this.this$0.isCameraPermissionNeeded()));
                    return;
                }
                if (listItem instanceof DocumentSelectionListItem.DoNotHaveDocumentsListItem) {
                    DocumentSelectionViewModel documentSelectionViewModel3 = this.this$0.viewModel;
                    if (documentSelectionViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        documentSelectionViewModel = documentSelectionViewModel3;
                    }
                    documentSelectionViewModel.handleViewEvent(DocumentViewEvent.DoNotHaveDocument.INSTANCE);
                }
            }
        });
        recyclerView.setAdapter(documentsAdapter);
        RecyclerView recyclerViewDocuments2 = ydsFragmentDocumentSelectionSuccessStateBinding.recyclerViewDocuments;
        Intrinsics.checkNotNullExpressionValue(recyclerViewDocuments2, "recyclerViewDocuments");
        recyclerViewDocuments2.setVisibility(0);
        YotiButton buttonContinueCountryNotListed2 = ydsFragmentDocumentSelectionSuccessStateBinding.buttonContinueCountryNotListed;
        Intrinsics.checkNotNullExpressionValue(buttonContinueCountryNotListed2, "buttonContinueCountryNotListed");
        buttonContinueCountryNotListed2.setVisibility(8);
    }

    private final YdsFragmentDocumentSelectionBinding getBinding() {
        return (YdsFragmentDocumentSelectionBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final int getDisabledTextColor() {
        return ContextCompat.getColor(requireContext(), C4597R.color.yds_theme_typography_neutral_contrast_disabled);
    }

    @ForDocumentSelection
    public static /* synthetic */ void getFactory$annotations() {
    }

    private final void handleError(YdsFailure failure) {
        getDocumentsAdapter().resetViews();
        showFailure(failure, getFailureTypeToErrorTagMapper().map(failure.getFailureType()).name());
    }

    private final void handleLoading(NavigationIcon navigationIcon) {
        YdsFragmentDocumentSelectionBinding binding = getBinding();
        YotiAppbar appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, navigationIcon, false, 0, 0, 0, 60, null);
        ConstraintLayout root = binding.loadingView.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "loadingView.root");
        root.setVisibility(0);
        ConstraintLayout root2 = binding.successView.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "successView.root");
        root2.setVisibility(8);
    }

    private final void handleSuccess(DocumentSelectionViewData viewData, DocumentSelectionViewState.VisibilityToggles visibilityToggles, NavigationIcon navigationIcon) {
        YdsFragmentDocumentSelectionBinding binding = getBinding();
        YotiAppbar appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, navigationIcon, false, 0, 0, 0, 60, null);
        ConstraintLayout root = binding.loadingView.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "loadingView.root");
        root.setVisibility(8);
        ConstraintLayout root2 = binding.successView.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "successView.root");
        root2.setVisibility(0);
        LinearLayout root3 = binding.successView.identityCheckLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "successView.identityCheckLayout.root");
        root3.setVisibility(visibilityToggles.getShowIdentityCheck() ? 0 : 8);
        YotiButton yotiButton = binding.successView.buttonMoreAboutVerification;
        Intrinsics.checkNotNullExpressionValue(yotiButton, "successView.buttonMoreAboutVerification");
        yotiButton.setVisibility(visibilityToggles.getShowMoreAboutVerification() ? 0 : 8);
        handleViewData(viewData, visibilityToggles.getShowDoNotHaveDocuments());
    }

    private final void handleViewData(DocumentSelectionViewData viewData, boolean showDoNotHaveDocuments) {
        YdsFragmentDocumentSelectionSuccessStateBinding ydsFragmentDocumentSelectionSuccessStateBinding = getBinding().successView;
        TextView textView = ydsFragmentDocumentSelectionSuccessStateBinding.textViewHeader;
        CompoundTextResource title = viewData.getTitle();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(title.getValue(contextRequireContext));
        ydsFragmentDocumentSelectionSuccessStateBinding.buttonChangeCountryLink.setVisibility(viewData.getButtonChangeCountryLinkVisibility());
        CountrySelectionOptionViewData selectedCountryOption = viewData.getSelectedCountryOption();
        Unit unit = null;
        if (selectedCountryOption != null) {
            displaySelectedCountryOptionState(selectedCountryOption, showDoNotHaveDocuments ? viewData.getDoNotHaveDocumentsViewData() : null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            displayEmptyCountryState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViewState(DocumentSelectionViewState viewState) {
        if (viewState instanceof DocumentSelectionViewState.Loading) {
            handleLoading(((DocumentSelectionViewState.Loading) viewState).getNavigationIcon());
            return;
        }
        if (viewState instanceof DocumentSelectionViewState.Success) {
            DocumentSelectionViewState.Success success = (DocumentSelectionViewState.Success) viewState;
            handleSuccess(success.getViewData(), success.getVisibilityToggles(), success.getNavigationIcon());
        } else if (viewState instanceof DocumentSelectionViewState.Error) {
            handleError(((DocumentSelectionViewState.Error) viewState).getFailure());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCameraPermissionNeeded() {
        return getCoordinator().isCameraPermissionRequired() && !FragmentKt.isCameraPermissionGranted(this);
    }

    private final void setUpClickListeners() {
        YdsFragmentDocumentSelectionSuccessStateBinding ydsFragmentDocumentSelectionSuccessStateBinding = getBinding().successView;
        Iterator it2 = CollectionsKt.listOf((Object[]) new YotiButton[]{ydsFragmentDocumentSelectionSuccessStateBinding.buttonMoreAboutVerification, ydsFragmentDocumentSelectionSuccessStateBinding.identityCheckLayout.buttonMoreAboutIdentityCheck}).iterator();
        while (it2.hasNext()) {
            ((YotiButton) it2.next()).setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocumentSelectionFragment.m6851setUpClickListeners$lambda4$lambda1$lambda0(this.f$0, view);
                }
            });
        }
        ydsFragmentDocumentSelectionSuccessStateBinding.buttonChangeCountryLink.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentSelectionFragment.m6852setUpClickListeners$lambda4$lambda2(this.f$0, view);
            }
        });
        ydsFragmentDocumentSelectionSuccessStateBinding.buttonContinueCountryNotListed.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentSelectionFragment.m6853setUpClickListeners$lambda4$lambda3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setUpClickListeners$lambda-4$lambda-1$lambda-0, reason: not valid java name */
    public static final void m6851setUpClickListeners$lambda4$lambda1$lambda0(DocumentSelectionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentSelectionViewModel documentSelectionViewModel = this$0.viewModel;
        if (documentSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentSelectionViewModel = null;
        }
        documentSelectionViewModel.handleViewEvent(DocumentViewEvent.MoreAboutVerification.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setUpClickListeners$lambda-4$lambda-2, reason: not valid java name */
    public static final void m6852setUpClickListeners$lambda4$lambda2(DocumentSelectionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentSelectionViewModel documentSelectionViewModel = this$0.viewModel;
        if (documentSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentSelectionViewModel = null;
        }
        documentSelectionViewModel.handleViewEvent(DocumentSelectionViewEvent.ChangeCountry.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setUpClickListeners$lambda-4$lambda-3, reason: not valid java name */
    public static final void m6853setUpClickListeners$lambda4$lambda3(DocumentSelectionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentSelectionViewModel documentSelectionViewModel = this$0.viewModel;
        if (documentSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentSelectionViewModel = null;
        }
        documentSelectionViewModel.handleViewEvent(DocumentSelectionViewEvent.CountryNotListed.INSTANCE);
    }

    public final DocumentsAdapter getDocumentsAdapter() {
        DocumentsAdapter documentsAdapter = this.documentsAdapter;
        if (documentsAdapter != null) {
            return documentsAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("documentsAdapter");
        return null;
    }

    public final DocumentFeatureErrorTagToViewEventMapper getErrorTagToViewEventMapper() {
        DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper = this.errorTagToViewEventMapper;
        if (documentFeatureErrorTagToViewEventMapper != null) {
            return documentFeatureErrorTagToViewEventMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("errorTagToViewEventMapper");
        return null;
    }

    public final SavedStateViewModelFactory<DocumentSelectionViewModel> getFactory() {
        SavedStateViewModelFactory<DocumentSelectionViewModel> savedStateViewModelFactory = this.factory;
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
        SavedStateViewModelFactory<DocumentSelectionViewModel> factory = getFactory();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.viewModel = (DocumentSelectionViewModel) factory.create(fragmentActivityRequireActivity);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        DocumentSelectionViewModel documentSelectionViewModel = this.viewModel;
        if (documentSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentSelectionViewModel = null;
        }
        documentSelectionViewModel.handleViewEvent(getErrorTagToViewEventMapper().map(new DocumentFeatureErrorTagToViewEventMapper.MapperParams(DocumentFeatureErrorTag.valueOf(dialogTag), false, isCameraPermissionNeeded())));
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        DocumentSelectionViewModel documentSelectionViewModel = this.viewModel;
        if (documentSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentSelectionViewModel = null;
        }
        documentSelectionViewModel.handleViewEvent(getErrorTagToViewEventMapper().map(new DocumentFeatureErrorTagToViewEventMapper.MapperParams(DocumentFeatureErrorTag.valueOf(dialogTag), true, isCameraPermissionNeeded())));
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            DocumentViewEvent cameraPermissionsDenied = ((grantResults.length == 0) || grantResults[0] != 0) ? new DocumentViewEvent.CameraPermissionsDenied(shouldShowRequestPermissionRationale("android.permission.CAMERA")) : DocumentViewEvent.CameraPermissionGranted.INSTANCE;
            DocumentSelectionViewModel documentSelectionViewModel = this.viewModel;
            if (documentSelectionViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                documentSelectionViewModel = null;
            }
            documentSelectionViewModel.handleViewEvent(cameraPermissionsDenied);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getDocumentsAdapter().resetViews();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getCoordinator().bind(this, 0);
        DocumentSelectionViewModel documentSelectionViewModel = this.viewModel;
        if (documentSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentSelectionViewModel = null;
        }
        NavigationUtilsKt.bindNavigationViewModel((Fragment) this, (NavigationViewModel) documentSelectionViewModel);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C46881(null), 3, null);
        setUpClickListeners();
    }

    public void setCoordinator(DocumentSelectionCoordinator documentSelectionCoordinator) {
        Intrinsics.checkNotNullParameter(documentSelectionCoordinator, "<set-?>");
        this.coordinator = documentSelectionCoordinator;
    }

    public final void setDocumentsAdapter(DocumentsAdapter documentsAdapter) {
        Intrinsics.checkNotNullParameter(documentsAdapter, "<set-?>");
        this.documentsAdapter = documentsAdapter;
    }

    public final void setErrorTagToViewEventMapper(DocumentFeatureErrorTagToViewEventMapper documentFeatureErrorTagToViewEventMapper) {
        Intrinsics.checkNotNullParameter(documentFeatureErrorTagToViewEventMapper, "<set-?>");
        this.errorTagToViewEventMapper = documentFeatureErrorTagToViewEventMapper;
    }

    public final void setFactory(SavedStateViewModelFactory<DocumentSelectionViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.factory = savedStateViewModelFactory;
    }

    public final void setFailureTypeToErrorTagMapper(DocumentFailureTypeToErrorTagMapper documentFailureTypeToErrorTagMapper) {
        Intrinsics.checkNotNullParameter(documentFailureTypeToErrorTagMapper, "<set-?>");
        this.failureTypeToErrorTagMapper = documentFailureTypeToErrorTagMapper;
    }

    @Override // com.yoti.mobile.android.commons.navigation.NavigationCoordinatorHost
    public DocumentSelectionCoordinator getCoordinator() {
        DocumentSelectionCoordinator documentSelectionCoordinator = this.coordinator;
        if (documentSelectionCoordinator != null) {
            return documentSelectionCoordinator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coordinator");
        return null;
    }
}
