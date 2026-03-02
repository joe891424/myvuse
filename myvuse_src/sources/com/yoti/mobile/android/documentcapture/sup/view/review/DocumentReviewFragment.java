package com.yoti.mobile.android.documentcapture.sup.view.review;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.sup.databinding.YdsFragmentSupDocumentReviewBinding;
import com.yoti.mobile.android.documentcapture.sup.databinding.YdsFragmentSupDocumentReviewLoadingStateBinding;
import com.yoti.mobile.android.documentcapture.sup.databinding.YdsFragmentSupDocumentReviewSuccessStateBinding;
import com.yoti.mobile.android.documentcapture.sup.p057di.ForDocumentReview;
import com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureSession;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadFragmentArgs;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0002J\u001a\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020\u001dH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00168\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00068"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsFragmentSupDocumentReviewBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsFragmentSupDocumentReviewBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "fragmentArgs", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "loadingView", "Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsFragmentSupDocumentReviewLoadingStateBinding;", "successView", "Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsFragmentSupDocumentReviewSuccessStateBinding;", "viewModel", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "navigateToFileOpenErrorScreen", "", "Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;", "navigateToScan", "navigateToUpload", "data", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "onAttach", "context", "Landroid/content/Context;", "onNavigationEventReceived", "navEvent", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent;", "onReviewStateChanged", "state", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "prepareView", "viewConfiguration", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState$ViewConfiguration;", "showBitmap", "bitmapLoaded", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState$BitmapLoaded;", "showLoadingState", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentReviewFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DocumentReviewFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsFragmentSupDocumentReviewBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;
    private YdsFragmentSupDocumentReviewLoadingStateBinding loadingView;
    private YdsFragmentSupDocumentReviewSuccessStateBinding successView;
    private DocumentReviewViewModel viewModel;

    @Inject
    public SavedStateViewModelFactory<DocumentReviewViewModel> viewModelFactory;

    public DocumentReviewFragment() {
        super(C4653R.layout.yds_fragment_sup_document_review);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentSupDocumentReviewBinding>() { // from class: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentSupDocumentReviewBinding invoke() {
                return YdsFragmentSupDocumentReviewBinding.bind(this.this$0.requireView());
            }
        });
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(DocumentReviewFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewFragment$special$$inlined$navArgs$1
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
    }

    private final YdsFragmentSupDocumentReviewBinding getBinding() {
        return (YdsFragmentSupDocumentReviewBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DocumentReviewFragmentArgs getFragmentArgs() {
        return (DocumentReviewFragmentArgs) this.fragmentArgs.getValue();
    }

    @ForDocumentReview
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    private final void navigateToFileOpenErrorScreen(GenericMessageFragmentArgs fragmentArgs) {
        NavigationKt.navigateSafe$default(androidx.navigation.fragment.FragmentKt.findNavController(this), C4653R.id.action_review_to_file_open_error, fragmentArgs.toBundle(), null, null, 12, null);
    }

    private final void navigateToScan() {
        NavController navControllerFindNavController = androidx.navigation.fragment.FragmentKt.findNavController(this);
        if (navControllerFindNavController instanceof NavHostController) {
            NavigationController.popBackStack((NavHostController) navControllerFindNavController);
        } else {
            navControllerFindNavController.popBackStack();
        }
    }

    private final void navigateToUpload(IDocumentViewData data) {
        NavigationKt.navigateSafeToNavGraph(androidx.navigation.fragment.FragmentKt.findNavController(this), C4653R.navigation.yds_document_upload_nav_graph, new DocumentUploadFragmentArgs(data).toBundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNavigationEventReceived(DocumentReviewViewModel.NavigationEvent navEvent) {
        if (navEvent instanceof DocumentReviewViewModel.NavigationEvent.NavigateToFileOpenError) {
            navigateToFileOpenErrorScreen(((DocumentReviewViewModel.NavigationEvent.NavigateToFileOpenError) navEvent).getArgs());
        } else if (navEvent instanceof DocumentReviewViewModel.NavigationEvent.NavigateToUpload) {
            navigateToUpload(((DocumentReviewViewModel.NavigationEvent.NavigateToUpload) navEvent).getDocumentData());
        } else if (navEvent instanceof DocumentReviewViewModel.NavigationEvent.NavigateToScan) {
            navigateToScan();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onReviewStateChanged(DocumentReviewViewModel.DocumentReviewState state) {
        if (state instanceof DocumentReviewViewModel.DocumentReviewState.ViewConfiguration) {
            prepareView((DocumentReviewViewModel.DocumentReviewState.ViewConfiguration) state);
        } else if (state instanceof DocumentReviewViewModel.DocumentReviewState.BitmapLoaded) {
            showBitmap((DocumentReviewViewModel.DocumentReviewState.BitmapLoaded) state);
        } else if (state instanceof DocumentReviewViewModel.DocumentReviewState.Error) {
            showFailure(((DocumentReviewViewModel.DocumentReviewState.Error) state).getFailure(), "DOCUMENT_REVIEW_ERROR_DIALOG_TAG");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-3$lambda-1, reason: not valid java name */
    public static final void m6831onViewCreated$lambda3$lambda1(DocumentReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentReviewViewModel documentReviewViewModel = this$0.viewModel;
        if (documentReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentReviewViewModel = null;
        }
        documentReviewViewModel.approveCapture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-3$lambda-2, reason: not valid java name */
    public static final void m6832onViewCreated$lambda3$lambda2(DocumentReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentReviewViewModel documentReviewViewModel = this$0.viewModel;
        if (documentReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            documentReviewViewModel = null;
        }
        documentReviewViewModel.rejectCapture();
    }

    private final void prepareView(final DocumentReviewViewModel.DocumentReviewState.ViewConfiguration viewConfiguration) {
        final YdsFragmentSupDocumentReviewSuccessStateBinding ydsFragmentSupDocumentReviewSuccessStateBinding = this.successView;
        DocumentReviewViewModel documentReviewViewModel = null;
        if (ydsFragmentSupDocumentReviewSuccessStateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
            ydsFragmentSupDocumentReviewSuccessStateBinding = null;
        }
        YotiAppbar appBar = ydsFragmentSupDocumentReviewSuccessStateBinding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        ydsFragmentSupDocumentReviewSuccessStateBinding.getRoot().setVisibility(0);
        YdsFragmentSupDocumentReviewLoadingStateBinding ydsFragmentSupDocumentReviewLoadingStateBinding = this.loadingView;
        if (ydsFragmentSupDocumentReviewLoadingStateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            ydsFragmentSupDocumentReviewLoadingStateBinding = null;
        }
        ydsFragmentSupDocumentReviewLoadingStateBinding.getRoot().setVisibility(8);
        ViewPager2 previewImagePager = ydsFragmentSupDocumentReviewSuccessStateBinding.previewImagePager;
        Intrinsics.checkNotNullExpressionValue(previewImagePager, "previewImagePager");
        if (!ViewCompat.isLaidOut(previewImagePager) || previewImagePager.isLayoutRequested()) {
            previewImagePager.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewFragment$prepareView$lambda-5$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkParameterIsNotNull(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    ViewPager2 viewPager2 = ydsFragmentSupDocumentReviewSuccessStateBinding.previewImagePager;
                    int pages = viewConfiguration.getPages();
                    ICaptureToBitmapTransformer.TransformOptions.Size size = new ICaptureToBitmapTransformer.TransformOptions.Size(view.getWidth(), view.getHeight());
                    DocumentReviewViewModel documentReviewViewModel2 = this.viewModel;
                    if (documentReviewViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        documentReviewViewModel2 = null;
                    }
                    viewPager2.setAdapter(new DocumentImageAdapter(pages, size, documentReviewViewModel2));
                }
            });
        } else {
            ViewPager2 viewPager2 = ydsFragmentSupDocumentReviewSuccessStateBinding.previewImagePager;
            int pages = viewConfiguration.getPages();
            ICaptureToBitmapTransformer.TransformOptions.Size size = new ICaptureToBitmapTransformer.TransformOptions.Size(previewImagePager.getWidth(), previewImagePager.getHeight());
            DocumentReviewViewModel documentReviewViewModel2 = this.viewModel;
            if (documentReviewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                documentReviewViewModel = documentReviewViewModel2;
            }
            viewPager2.setAdapter(new DocumentImageAdapter(pages, size, documentReviewViewModel));
        }
        if (viewConfiguration.getPages() > 1) {
            IndefinitePagerIndicator indefinitePagerIndicator = ydsFragmentSupDocumentReviewSuccessStateBinding.indicatorLayout;
            ViewPager2 previewImagePager2 = ydsFragmentSupDocumentReviewSuccessStateBinding.previewImagePager;
            Intrinsics.checkNotNullExpressionValue(previewImagePager2, "previewImagePager");
            indefinitePagerIndicator.attachToViewPager2(previewImagePager2);
        }
    }

    private final void showBitmap(DocumentReviewViewModel.DocumentReviewState.BitmapLoaded bitmapLoaded) {
        YdsFragmentSupDocumentReviewSuccessStateBinding ydsFragmentSupDocumentReviewSuccessStateBinding = this.successView;
        if (ydsFragmentSupDocumentReviewSuccessStateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
            ydsFragmentSupDocumentReviewSuccessStateBinding = null;
        }
        RecyclerView.Adapter adapter = ydsFragmentSupDocumentReviewSuccessStateBinding.previewImagePager.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.documentcapture.sup.view.review.DocumentImageAdapter");
        }
        ((DocumentImageAdapter) adapter).showPage(bitmapLoaded.getPage(), bitmapLoaded.getBitmap(), bitmapLoaded.getPageNumberIndicator(), bitmapLoaded.getRotationEnabled());
    }

    private final void showLoadingState() {
        YdsFragmentSupDocumentReviewLoadingStateBinding ydsFragmentSupDocumentReviewLoadingStateBinding = this.loadingView;
        YdsFragmentSupDocumentReviewSuccessStateBinding ydsFragmentSupDocumentReviewSuccessStateBinding = null;
        if (ydsFragmentSupDocumentReviewLoadingStateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            ydsFragmentSupDocumentReviewLoadingStateBinding = null;
        }
        YotiAppbar yotiAppbar = ydsFragmentSupDocumentReviewLoadingStateBinding.loadingAppBar;
        Intrinsics.checkNotNullExpressionValue(yotiAppbar, "loadingView.loadingAppBar");
        BaseFragment.configureAppBar$default(this, yotiAppbar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        YdsFragmentSupDocumentReviewLoadingStateBinding ydsFragmentSupDocumentReviewLoadingStateBinding2 = this.loadingView;
        if (ydsFragmentSupDocumentReviewLoadingStateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            ydsFragmentSupDocumentReviewLoadingStateBinding2 = null;
        }
        ydsFragmentSupDocumentReviewLoadingStateBinding2.getRoot().setVisibility(0);
        YdsFragmentSupDocumentReviewSuccessStateBinding ydsFragmentSupDocumentReviewSuccessStateBinding2 = this.successView;
        if (ydsFragmentSupDocumentReviewSuccessStateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
        } else {
            ydsFragmentSupDocumentReviewSuccessStateBinding = ydsFragmentSupDocumentReviewSuccessStateBinding2;
        }
        ydsFragmentSupDocumentReviewSuccessStateBinding.getRoot().setVisibility(8);
    }

    public final SavedStateViewModelFactory<DocumentReviewViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<DocumentReviewViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SupDocumentCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        YdsFragmentSupDocumentReviewSuccessStateBinding ydsFragmentSupDocumentReviewSuccessStateBinding = getBinding().successDataView;
        Intrinsics.checkNotNullExpressionValue(ydsFragmentSupDocumentReviewSuccessStateBinding, "binding.successDataView");
        this.successView = ydsFragmentSupDocumentReviewSuccessStateBinding;
        YdsFragmentSupDocumentReviewLoadingStateBinding ydsFragmentSupDocumentReviewLoadingStateBinding = getBinding().loadingDataView;
        Intrinsics.checkNotNullExpressionValue(ydsFragmentSupDocumentReviewLoadingStateBinding, "binding.loadingDataView");
        this.loadingView = ydsFragmentSupDocumentReviewLoadingStateBinding;
        DocumentReviewViewModel documentReviewViewModel = (DocumentReviewViewModel) getViewModelFactory().create(this);
        documentReviewViewModel.setupCapture(getFragmentArgs().getCaptureViewData());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, documentReviewViewModel.getReviewState(), new DocumentReviewFragment$onViewCreated$1$1(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner2, documentReviewViewModel.getNavigationEvent(), new DocumentReviewFragment$onViewCreated$1$2(this));
        this.viewModel = documentReviewViewModel;
        showLoadingState();
        YdsFragmentSupDocumentReviewSuccessStateBinding ydsFragmentSupDocumentReviewSuccessStateBinding2 = this.successView;
        if (ydsFragmentSupDocumentReviewSuccessStateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
            ydsFragmentSupDocumentReviewSuccessStateBinding2 = null;
        }
        ydsFragmentSupDocumentReviewSuccessStateBinding2.buttonDocumentReviewApprove.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentReviewFragment.m6831onViewCreated$lambda3$lambda1(this.f$0, view2);
            }
        });
        ydsFragmentSupDocumentReviewSuccessStateBinding2.buttonDocumentReviewCancel.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentReviewFragment.m6832onViewCreated$lambda3$lambda2(this.f$0, view2);
            }
        });
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<DocumentReviewViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }
}
