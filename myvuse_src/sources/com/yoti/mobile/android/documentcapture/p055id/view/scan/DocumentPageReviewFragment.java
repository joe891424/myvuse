package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yoti.mobile.android.common.p049ui.widgets.AppBarDescription;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.YotiBottomSheetDialog;
import com.yoti.mobile.android.commonui.YotiDocsDialogFragment;
import com.yoti.mobile.android.commonui.extension.FragmentActivityKt;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.ImageViewLoadAnimationKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsFragmentDocumentReviewBinding;
import com.yoti.mobile.android.documentcapture.p055id.p056di.ForDocumentReview;
import com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureSession;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.PageScanReviewViewModel;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0002NOB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J,\u00101\u001a\n 3*\u0004\u0018\u000102022\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020@H\u0016J\u001a\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010D\u001a\u00020\u001cH\u0002J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020\u001cH\u0002J\b\u0010I\u001a\u00020\u001cH\u0002J\u0012\u0010J\u001a\u00020\u001c2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\b\u0010M\u001a\u00020\u001cH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00158\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006P"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentPageReviewFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/yoti/mobile/android/commonui/YotiDocsDialogFragment$DialogListener;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentDocumentReviewBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentDocumentReviewBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "documentImageLoader", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentImageLoader;", "getDocumentImageLoader", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentImageLoader;", "setDocumentImageLoader", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentImageLoader;)V", "documentPageReviewListener", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentPageReviewFragment$DocumentPageReviewListener;", "pageScanReviewViewModel", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "approvePage", "", "displayDocumentImage", "image", "Landroid/graphics/Bitmap;", "displayFailureState", "initialiseViewModel", "loadScreen", "pageScanReviewViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "showConsentText", "", "loadUploadOptionScreen", "navigateToGuidelines", "navigateToReview", "onAttach", "context", "Landroid/content/Context;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCurrentStateChanged", "currentState", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onNegativeButtonClick", "dialogTag", "", "onPositiveButtonClick", "onViewCreated", "view", "rejectPage", "setImageRatio", "cropRegion", "Landroid/graphics/RectF;", "setupBar", "setupButtons", "setupConsent", "consentViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ConsentViewData;", "showProgress", "Companion", "DocumentPageReviewListener", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentPageReviewFragment extends BottomSheetDialogFragment implements YotiDocsDialogFragment.DialogListener {
    private static final String ARG_PAGE_REVIEW_DATA = "ARG_PAGE_REVIEW_DATA";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentDocumentReviewBinding>() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$binding$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final YdsFragmentDocumentReviewBinding invoke() {
            return YdsFragmentDocumentReviewBinding.bind(this.this$0.requireView());
        }
    });

    @Inject
    public DocumentImageLoader documentImageLoader;
    private DocumentPageReviewListener documentPageReviewListener;
    private PageScanReviewViewModel pageScanReviewViewModel;

    @Inject
    public SavedStateViewModelFactory<PageScanReviewViewModel> viewModelFactory;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DocumentPageReviewFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentDocumentReviewBinding;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentPageReviewFragment$Companion;", "", "()V", DocumentPageReviewFragment.ARG_PAGE_REVIEW_DATA, "", "newInstance", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentPageReviewFragment;", "reviewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DocumentPageReviewFragment newInstance(PageScanReviewViewData reviewData) {
            Intrinsics.checkNotNullParameter(reviewData, "reviewData");
            DocumentPageReviewFragment documentPageReviewFragment = new DocumentPageReviewFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DocumentPageReviewFragment.ARG_PAGE_REVIEW_DATA, reviewData);
            documentPageReviewFragment.setArguments(bundle);
            return documentPageReviewFragment;
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentPageReviewFragment$DocumentPageReviewListener;", "", "onPageReviewApproved", "", "onPageReviewCancelled", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public interface DocumentPageReviewListener {
        void onPageReviewApproved();

        void onPageReviewCancelled();
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$loadScreen$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$loadScreen$1", m5608f = "DocumentPageReviewFragment.kt", m5609i = {}, m5610l = {163}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageScanReviewViewData $pageScanReviewViewData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46321(PageScanReviewViewData pageScanReviewViewData, Continuation<? super C46321> continuation) {
            super(2, continuation);
            this.$pageScanReviewViewData = pageScanReviewViewData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentPageReviewFragment.this.new C46321(this.$pageScanReviewViewData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DocumentImageLoader documentImageLoader = DocumentPageReviewFragment.this.getDocumentImageLoader();
                RectF cropRegion = this.$pageScanReviewViewData.getCropRegion();
                String imagePath = this.$pageScanReviewViewData.getImagePath();
                this.label = 1;
                obj = documentImageLoader.loadImage(cropRegion, imagePath, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            DocumentPageReviewFragment documentPageReviewFragment = DocumentPageReviewFragment.this;
            PageScanReviewViewData pageScanReviewViewData = this.$pageScanReviewViewData;
            documentPageReviewFragment.displayDocumentImage((Bitmap) obj);
            String string = documentPageReviewFragment.getString(pageScanReviewViewData.getDocumentName());
            Intrinsics.checkNotNullExpressionValue(string, "getString(pageScanReviewViewData.documentName)");
            ((TextView) documentPageReviewFragment.requireView().findViewById(C4608R.id.textViewDocumentReviewGuidelinesMessage)).setText(documentPageReviewFragment.getString(C4608R.string.yds_document_guidelines_description, string));
            return Unit.INSTANCE;
        }
    }

    private final void approvePage() {
        DocumentPageReviewListener documentPageReviewListener = this.documentPageReviewListener;
        if (documentPageReviewListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentPageReviewListener");
            documentPageReviewListener = null;
        }
        documentPageReviewListener.onPageReviewApproved();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayDocumentImage(Bitmap image) {
        ImageView imageView = getBinding().review.imageViewDocumentReview;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.review.imageViewDocumentReview");
        ImageViewLoadAnimationKt.showBitmapSoftly(imageView, image);
    }

    private final void displayFailureState() {
        YotiDocsDialogFragment.Companion.newInstance$default(YotiDocsDialogFragment.INSTANCE, YdsFailureType.TechnicalProblem.INSTANCE.getF7489b(), YdsFailureType.TechnicalProblem.INSTANCE.getF7490c(), C4608R.string.yds_common_try_again, Integer.valueOf(C4608R.string.ios_android_yds_common_cancel), null, 16, null).show(getChildFragmentManager(), "DOCUMENT_PAGE_REVIEW_ERROR_DIALOG_TAG");
    }

    private final YdsFragmentDocumentReviewBinding getBinding() {
        return (YdsFragmentDocumentReviewBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @ForDocumentReview
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    private final void initialiseViewModel() {
        PageScanReviewViewModel pageScanReviewViewModel = (PageScanReviewViewModel) getViewModelFactory().create(this);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, pageScanReviewViewModel.getCurrentState(), new DocumentPageReviewFragment$initialiseViewModel$1$1(this));
        this.pageScanReviewViewModel = pageScanReviewViewModel;
        Bundle arguments = getArguments();
        if (arguments != null) {
            PageScanReviewViewModel pageScanReviewViewModel2 = this.pageScanReviewViewModel;
            if (pageScanReviewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
                pageScanReviewViewModel2 = null;
            }
            Parcelable parcelable = arguments.getParcelable(ARG_PAGE_REVIEW_DATA);
            Intrinsics.checkNotNull(parcelable);
            pageScanReviewViewModel2.setupPageReviewData((PageScanReviewViewData) parcelable);
        }
    }

    private final void loadScreen(PageScanReviewViewData pageScanReviewViewData, boolean showConsentText) {
        setImageRatio(pageScanReviewViewData.getCropRegion());
        setupConsent(showConsentText ? pageScanReviewViewData.getConsentViewData() : null);
        getBinding().review.buttonDocumentReviewGuidelines.setVisibility(pageScanReviewViewData.isGuidelinesLinkVisible() ? 0 : 8);
        C4631x66441263 c4631x66441263 = new C4631x66441263(CoroutineExceptionHandler.INSTANCE, this);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), c4631x66441263, null, new C46321(pageScanReviewViewData, null), 2, null);
    }

    private final void loadUploadOptionScreen(PageScanReviewViewData pageScanReviewViewData, boolean showConsentText) {
        getBinding().review.buttonDocumentReviewApprove.setText(getString(C4608R.string.yds_document_review_confirm_upload_primary_cta));
        loadScreen(pageScanReviewViewData, showConsentText);
    }

    private final void navigateToGuidelines() {
        getBinding().reviewGuidelineFlipper.showNext();
    }

    private final void navigateToReview() {
        getBinding().reviewGuidelineFlipper.showPrevious();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCurrentStateChanged(PageScanReviewViewModel.ReviewState currentState) {
        if (currentState instanceof PageScanReviewViewModel.ReviewState.ScreenLoading) {
            PageScanReviewViewModel.ReviewState.ScreenLoading screenLoading = (PageScanReviewViewModel.ReviewState.ScreenLoading) currentState;
            loadScreen(screenLoading.getScreenData(), screenLoading.getShowConsentText());
            return;
        }
        if (currentState instanceof PageScanReviewViewModel.ReviewState.ScreenLoadingWithUploadOption) {
            PageScanReviewViewModel.ReviewState.ScreenLoadingWithUploadOption screenLoadingWithUploadOption = (PageScanReviewViewModel.ReviewState.ScreenLoadingWithUploadOption) currentState;
            loadUploadOptionScreen(screenLoadingWithUploadOption.getScreenData(), screenLoadingWithUploadOption.getShowConsentText());
            return;
        }
        if (currentState instanceof PageScanReviewViewModel.ReviewState.ShowGuidelines) {
            navigateToGuidelines();
            return;
        }
        if (currentState instanceof PageScanReviewViewModel.ReviewState.ShowReview) {
            navigateToReview();
            return;
        }
        if (currentState instanceof PageScanReviewViewModel.ReviewState.PageApproved) {
            approvePage();
            return;
        }
        if (currentState instanceof PageScanReviewViewModel.ReviewState.PageRejected) {
            rejectPage();
            return;
        }
        if (!(currentState instanceof PageScanReviewViewModel.ReviewState.Progress)) {
            if (currentState instanceof PageScanReviewViewModel.ReviewState.Error) {
                displayFailureState();
            }
        } else {
            DocumentPageReviewListener documentPageReviewListener = this.documentPageReviewListener;
            if (documentPageReviewListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("documentPageReviewListener");
                documentPageReviewListener = null;
            }
            documentPageReviewListener.onPageReviewApproved();
            showProgress();
        }
    }

    private final void rejectPage() {
        DocumentPageReviewListener documentPageReviewListener = this.documentPageReviewListener;
        if (documentPageReviewListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentPageReviewListener");
            documentPageReviewListener = null;
        }
        documentPageReviewListener.onPageReviewCancelled();
        dismiss();
    }

    private final void setImageRatio(RectF cropRegion) {
        float f = (cropRegion.bottom - cropRegion.top) / (cropRegion.right - cropRegion.left);
        DocumentImageLoader documentImageLoader = getDocumentImageLoader();
        Intrinsics.checkNotNullExpressionValue(requireActivity(), "requireActivity()");
        float fCalculateMaximumImageFrameWidth = documentImageLoader.calculateMaximumImageFrameWidth(FragmentActivityKt.getDisplayMetrics(r0).widthPixels) * f;
        ImageView imageView = getBinding().review.imageViewDocumentReview;
        ViewGroup.LayoutParams layoutParams = getBinding().review.imageViewDocumentReview.getLayoutParams();
        layoutParams.height = (int) fCalculateMaximumImageFrameWidth;
        imageView.setLayoutParams(layoutParams);
    }

    private final void setupBar() {
        YotiAppbar yotiAppbar = (YotiAppbar) requireView().findViewById(C4608R.id.appBar);
        yotiAppbar.updateAppBar(new AppBarDescription(NavigationIcon.BACK_BLUE, 0, null, 0, false, null, null, Boolean.TRUE, false, 0, 0, 1918, null));
        yotiAppbar.getToolbar().setNavigationOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentPageReviewFragment.m6814setupBar$lambda13$lambda12(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupBar$lambda-13$lambda-12, reason: not valid java name */
    public static final void m6814setupBar$lambda13$lambda12(DocumentPageReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PageScanReviewViewModel pageScanReviewViewModel = this$0.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.guidelinesBackNavClicked();
    }

    private final void setupButtons() {
        getBinding().review.buttonDocumentReviewGuidelines.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentPageReviewFragment.m6817setupButtons$lambda8(this.f$0, view);
            }
        });
        getBinding().review.buttonDocumentReviewApprove.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentPageReviewFragment.m6818setupButtons$lambda9(this.f$0, view);
            }
        });
        getBinding().review.buttonDocumentReviewCancel.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentPageReviewFragment.m6815setupButtons$lambda10(this.f$0, view);
            }
        });
        ((YotiButton) requireView().findViewById(C4608R.id.buttonDocumentReviewGuidelinesGotIt)).setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentPageReviewFragment.m6816setupButtons$lambda11(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupButtons$lambda-10, reason: not valid java name */
    public static final void m6815setupButtons$lambda10(DocumentPageReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PageScanReviewViewModel pageScanReviewViewModel = this$0.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.secondaryButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupButtons$lambda-11, reason: not valid java name */
    public static final void m6816setupButtons$lambda11(DocumentPageReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PageScanReviewViewModel pageScanReviewViewModel = this$0.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.guidelinesGotItButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupButtons$lambda-8, reason: not valid java name */
    public static final void m6817setupButtons$lambda8(DocumentPageReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PageScanReviewViewModel pageScanReviewViewModel = this$0.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.guidelinesButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupButtons$lambda-9, reason: not valid java name */
    public static final void m6818setupButtons$lambda9(DocumentPageReviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PageScanReviewViewModel pageScanReviewViewModel = this$0.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.primaryButtonClicked();
    }

    private final void setupConsent(ConsentViewData consentViewData) {
        Unit unit;
        TextView textView = getBinding().review.textViewDocumentReviewConsent;
        if (consentViewData != null) {
            CompoundTextResource text = consentViewData.getText();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(text.getValue(contextRequireContext));
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(8);
        }
    }

    private final void showProgress() {
        getBinding().review.buttonDocumentReviewApprove.showProgress();
    }

    public final DocumentImageLoader getDocumentImageLoader() {
        DocumentImageLoader documentImageLoader = this.documentImageLoader;
        if (documentImageLoader != null) {
            return documentImageLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("documentImageLoader");
        return null;
    }

    public final SavedStateViewModelFactory<PageScanReviewViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<PageScanReviewViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IdDocumentCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
        Object objFirstOrNull = SequencesKt.firstOrNull(SequencesKt.filterIsInstance(SequencesKt.plus((Sequence<? extends FragmentActivity>) SequencesKt.generateSequence(this, new Function1<Fragment, Fragment>() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$onAttach$$inlined$findCallback$1
            @Override // kotlin.jvm.functions.Function1
            public final Fragment invoke(Fragment it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return it2.getParentFragment();
            }
        }), getActivity()), DocumentPageReviewListener.class));
        if (objFirstOrNull == null) {
            throw new IllegalArgumentException("A parent Fragment or Activity must implement DocumentPageReviewListener!".toString());
        }
        this.documentPageReviewListener = (DocumentPageReviewListener) objFirstOrNull;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return new YotiBottomSheetDialog(contextRequireContext, C4608R.style.Yds_BottomSheetDialogTheme, null, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C4608R.layout.yds_fragment_document_review, container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        PageScanReviewViewModel pageScanReviewViewModel = this.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.reviewScreenDismissed();
    }

    @Override // com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        PageScanReviewViewModel pageScanReviewViewModel = this.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.errorDialogNegativeButtonClicked();
    }

    @Override // com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        PageScanReviewViewModel pageScanReviewViewModel = this.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.errorDialogPositiveButtonClicked();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupButtons();
        setupBar();
        initialiseViewModel();
        ScrollView scrollView = getBinding().guidelines.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "binding.guidelines.scrollView");
        View view2 = getBinding().guidelines.shadow;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.guidelines.shadow");
        new ShadowedScrollViewMediator(scrollView, view2).attach();
    }

    public final void setDocumentImageLoader(DocumentImageLoader documentImageLoader) {
        Intrinsics.checkNotNullParameter(documentImageLoader, "<set-?>");
        this.documentImageLoader = documentImageLoader;
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<PageScanReviewViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }
}
