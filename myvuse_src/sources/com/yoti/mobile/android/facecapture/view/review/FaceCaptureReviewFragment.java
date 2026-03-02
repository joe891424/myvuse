package com.yoti.mobile.android.facecapture.view.review;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.utils.ViewBindingLazyKt;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.databinding.YdsFragmentFaceCaptureReviewBinding;
import com.yoti.mobile.android.facecapture.databinding.YdsFragmentFaceCaptureReviewLoadingBinding;
import com.yoti.mobile.android.facecapture.databinding.YdsFragmentFaceCaptureReviewSuccessBinding;
import com.yoti.mobile.android.facecapture.p070di.FaceCaptureSession;
import com.yoti.mobile.android.facecapture.view.navigation.CaptureNavigationEvent;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewEvent;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewState;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFragmentArgs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0016\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001cH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006/"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/facecapture/databinding/YdsFragmentFaceCaptureReviewBinding;", "getBinding", "()Lcom/yoti/mobile/android/facecapture/databinding/YdsFragmentFaceCaptureReviewBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "fragmentArgs", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "loadingBinding", "Lcom/yoti/mobile/android/facecapture/databinding/YdsFragmentFaceCaptureReviewLoadingBinding;", "successBinding", "Lcom/yoti/mobile/android/facecapture/databinding/YdsFragmentFaceCaptureReviewSuccessBinding;", "viewModel", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$facecapture_productionRelease", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$facecapture_productionRelease", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onAttach", "", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "processNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent;", "processViewState", "state", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewState;", "renderCaptureReview", "capture", "", "renderLoadingState", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureReviewFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FaceCaptureReviewFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/facecapture/databinding/YdsFragmentFaceCaptureReviewBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;
    private YdsFragmentFaceCaptureReviewLoadingBinding loadingBinding;
    private YdsFragmentFaceCaptureReviewSuccessBinding successBinding;
    private FaceCaptureReviewViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment$renderCaptureReview$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment$renderCaptureReview$1", m5608f = "FaceCaptureReviewFragment.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $capture;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48691(byte[] bArr, Continuation<? super C48691> continuation) {
            super(2, continuation);
            this.$capture = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FaceCaptureReviewFragment.this.new C48691(this.$capture, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding = FaceCaptureReviewFragment.this.successBinding;
            if (ydsFragmentFaceCaptureReviewSuccessBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("successBinding");
                ydsFragmentFaceCaptureReviewSuccessBinding = null;
            }
            ImageView imageView = ydsFragmentFaceCaptureReviewSuccessBinding.imageViewCaptureReview;
            byte[] bArr = this.$capture;
            imageView.setImageBitmap(BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length));
            return Unit.INSTANCE;
        }
    }

    public FaceCaptureReviewFragment() {
        super(C4832R.layout.yds_fragment_face_capture_review);
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(FaceCaptureReviewFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment$special$$inlined$navArgs$1
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
        this.binding = ViewBindingLazyKt.viewBindingLazy(this, new Function0<YdsFragmentFaceCaptureReviewBinding>() { // from class: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentFaceCaptureReviewBinding invoke() {
                return YdsFragmentFaceCaptureReviewBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentFaceCaptureReviewBinding getBinding() {
        return (YdsFragmentFaceCaptureReviewBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FaceCaptureReviewFragmentArgs getFragmentArgs() {
        return (FaceCaptureReviewFragmentArgs) this.fragmentArgs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-1, reason: not valid java name */
    public static final void m6862onViewCreated$lambda1(FaceCaptureReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FaceCaptureReviewViewModel faceCaptureReviewViewModel = this$0.viewModel;
        if (faceCaptureReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            faceCaptureReviewViewModel = null;
        }
        faceCaptureReviewViewModel.handleViewEvent(FaceCaptureReviewViewEvent.OnCaptureRejected.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-2, reason: not valid java name */
    public static final void m6863onViewCreated$lambda2(FaceCaptureReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FaceCaptureReviewViewModel faceCaptureReviewViewModel = this$0.viewModel;
        if (faceCaptureReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            faceCaptureReviewViewModel = null;
        }
        faceCaptureReviewViewModel.handleViewEvent(FaceCaptureReviewViewEvent.OnCaptureApproved.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processNavigationEvent(SingleEvent<? extends CaptureNavigationEvent> event) {
        event.getContentIfNotHandled(new Function1<CaptureNavigationEvent, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment.processNavigationEvent.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CaptureNavigationEvent captureNavigationEvent) {
                invoke2(captureNavigationEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CaptureNavigationEvent it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2 instanceof CaptureNavigationEvent.NavigateToUpload) {
                    NavigationKt.navigateSafeToNavGraph(FragmentKt.findNavController(FaceCaptureReviewFragment.this), C4832R.navigation.yds_liveness_upload_nav_graph, new LivenessUploadFragmentArgs(FaceCaptureReviewFragment.this.getFragmentArgs().getLivenessCapture()).toBundle());
                } else if (it2 instanceof CaptureNavigationEvent.NavigateToFaceCapture) {
                    FaceCaptureReviewFragment.this.navigateBack();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processViewState(FaceCaptureReviewViewState state) {
        if (state instanceof FaceCaptureReviewViewState.DisplayCaptureReview) {
            renderCaptureReview(((FaceCaptureReviewViewState.DisplayCaptureReview) state).getCapture());
        } else {
            if (Intrinsics.areEqual(state, FaceCaptureReviewViewState.CaptureReviewError.INSTANCE) || !Intrinsics.areEqual(state, FaceCaptureReviewViewState.LoadingCapture.INSTANCE)) {
                return;
            }
            renderLoadingState();
        }
    }

    private final void renderCaptureReview(byte[] capture) {
        YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding = this.successBinding;
        if (ydsFragmentFaceCaptureReviewSuccessBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successBinding");
            ydsFragmentFaceCaptureReviewSuccessBinding = null;
        }
        YotiAppbar yotiAppbar = ydsFragmentFaceCaptureReviewSuccessBinding.appBar;
        Intrinsics.checkNotNullExpressionValue(yotiAppbar, "successBinding.appBar");
        BaseFragment.configureAppBar$default(this, yotiAppbar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding2 = this.successBinding;
        if (ydsFragmentFaceCaptureReviewSuccessBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successBinding");
            ydsFragmentFaceCaptureReviewSuccessBinding2 = null;
        }
        ydsFragmentFaceCaptureReviewSuccessBinding2.getRoot().setVisibility(0);
        YdsFragmentFaceCaptureReviewLoadingBinding ydsFragmentFaceCaptureReviewLoadingBinding = this.loadingBinding;
        if (ydsFragmentFaceCaptureReviewLoadingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingBinding");
            ydsFragmentFaceCaptureReviewLoadingBinding = null;
        }
        ydsFragmentFaceCaptureReviewLoadingBinding.getRoot().setVisibility(8);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C48691(capture, null), 3, null);
    }

    private final void renderLoadingState() {
        YdsFragmentFaceCaptureReviewLoadingBinding ydsFragmentFaceCaptureReviewLoadingBinding = this.loadingBinding;
        YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding = null;
        if (ydsFragmentFaceCaptureReviewLoadingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingBinding");
            ydsFragmentFaceCaptureReviewLoadingBinding = null;
        }
        YotiAppbar yotiAppbar = ydsFragmentFaceCaptureReviewLoadingBinding.loadingAppBar;
        Intrinsics.checkNotNullExpressionValue(yotiAppbar, "loadingBinding.loadingAppBar");
        BaseFragment.configureAppBar$default(this, yotiAppbar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        YdsFragmentFaceCaptureReviewLoadingBinding ydsFragmentFaceCaptureReviewLoadingBinding2 = this.loadingBinding;
        if (ydsFragmentFaceCaptureReviewLoadingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingBinding");
            ydsFragmentFaceCaptureReviewLoadingBinding2 = null;
        }
        ydsFragmentFaceCaptureReviewLoadingBinding2.getRoot().setVisibility(0);
        YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding2 = this.successBinding;
        if (ydsFragmentFaceCaptureReviewSuccessBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successBinding");
        } else {
            ydsFragmentFaceCaptureReviewSuccessBinding = ydsFragmentFaceCaptureReviewSuccessBinding2;
        }
        ydsFragmentFaceCaptureReviewSuccessBinding.getRoot().setVisibility(8);
    }

    public final ViewModelProvider.Factory getViewModelFactory$facecapture_productionRelease() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FaceCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding = getBinding().layoutCaptureReviewSuccess;
        Intrinsics.checkNotNullExpressionValue(ydsFragmentFaceCaptureReviewSuccessBinding, "binding.layoutCaptureReviewSuccess");
        this.successBinding = ydsFragmentFaceCaptureReviewSuccessBinding;
        YdsFragmentFaceCaptureReviewLoadingBinding ydsFragmentFaceCaptureReviewLoadingBinding = getBinding().layoutCaptureReviewLoading;
        Intrinsics.checkNotNullExpressionValue(ydsFragmentFaceCaptureReviewLoadingBinding, "binding.layoutCaptureReviewLoading");
        this.loadingBinding = ydsFragmentFaceCaptureReviewLoadingBinding;
        FaceCaptureReviewViewModel faceCaptureReviewViewModel = (FaceCaptureReviewViewModel) new ViewModelProvider(this, getViewModelFactory$facecapture_productionRelease()).get(FaceCaptureReviewViewModel.class);
        faceCaptureReviewViewModel.getViewState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.processViewState((FaceCaptureReviewViewState) obj);
            }
        });
        faceCaptureReviewViewModel.getNavigationEvent().observe(getViewLifecycleOwner(), new Observer() { // from class: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.processNavigationEvent((SingleEvent) obj);
            }
        });
        this.viewModel = faceCaptureReviewViewModel;
        YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding2 = this.successBinding;
        YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding3 = null;
        if (ydsFragmentFaceCaptureReviewSuccessBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successBinding");
            ydsFragmentFaceCaptureReviewSuccessBinding2 = null;
        }
        ydsFragmentFaceCaptureReviewSuccessBinding2.buttonReviewCaptureNegative.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FaceCaptureReviewFragment.m6862onViewCreated$lambda1(this.f$0, view2);
            }
        });
        YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding4 = this.successBinding;
        if (ydsFragmentFaceCaptureReviewSuccessBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successBinding");
        } else {
            ydsFragmentFaceCaptureReviewSuccessBinding3 = ydsFragmentFaceCaptureReviewSuccessBinding4;
        }
        ydsFragmentFaceCaptureReviewSuccessBinding3.buttonReviewCapturePositive.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FaceCaptureReviewFragment.m6863onViewCreated$lambda2(this.f$0, view2);
            }
        });
    }

    public final void setViewModelFactory$facecapture_productionRelease(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
