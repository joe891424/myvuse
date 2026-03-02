package com.yoti.mobile.android.yotisdkcore.core.view.upload;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.TextViewLoadingEllipsisAnimationKt;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;
import com.yoti.mobile.android.yotidocs.common.Status;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel;
import com.yoti.mobile.android.yotisdkcore.p081b.C4968d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0017J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH&J\b\u0010$\u001a\u00020\u001fH\u0014J\b\u0010%\u001a\u00020\u001fH&J\b\u0010&\u001a\u00020\u001fH\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\u0016\u0010-\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0/H\u0002J\u001a\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00065"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadFragment;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "DELAY_SUCCESS_UPLOAD_STATUS", "", "binding", "Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentUploadBinding;", "getBinding", "()Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentUploadBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "handler", "Landroid/os/Handler;", "uploadInProgressTitle", "", "getUploadInProgressTitle", "()Ljava/lang/String;", "uploadSuccessTitle", "getUploadSuccessTitle", "uploadViewModel", "getUploadViewModel", "()Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;", "setUploadViewModel", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;)V", "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;", "createViewModel", "displaySuccessfulUploadState", "", "displayUploadFailureState", "", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "initialiseAppBar", "initialiseUploadProcess", "navigateBack", "navigateToPreviousScreen", "onDestroyView", "onNegativeButtonClick", "dialogTag", "onPositiveButtonClick", "onUploadProgressChanged", "progress", "", "onUploadStatusChanged", "status", "Lcom/yoti/mobile/android/yotidocs/common/Status;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class UploadFragment<T extends UploadViewModel<?>> extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(UploadFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentUploadBinding;", 0))};
    private final long DELAY_SUCCESS_UPLOAD_STATUS;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private final Handler handler;
    protected T uploadViewModel;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment$a */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, m5598d2 = {"<anonymous>", "Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentUploadBinding;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class C4986a extends Lambda implements Function0<C4968d> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ UploadFragment<T> f7612a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4986a(UploadFragment<T> uploadFragment) {
            super(0);
            this.f7612a = uploadFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C4968d invoke() {
            return C4968d.m5104a(this.f7612a.requireView());
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment$b */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C4987b extends FunctionReferenceImpl implements Function1<Double, Unit> {
        C4987b(Object obj) {
            super(1, obj, UploadFragment.class, "onUploadProgressChanged", "onUploadProgressChanged(D)V", 0);
        }

        /* JADX INFO: renamed from: a */
        public final void m5123a(double d) {
            ((UploadFragment) this.receiver).onUploadProgressChanged(d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Double d) {
            m5123a(d.doubleValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C4988c extends FunctionReferenceImpl implements Function1<Status<? extends Unit>, Unit> {
        C4988c(Object obj) {
            super(1, obj, UploadFragment.class, "onUploadStatusChanged", "onUploadStatusChanged(Lcom/yoti/mobile/android/yotidocs/common/Status;)V", 0);
        }

        /* JADX INFO: renamed from: a */
        public final void m5124a(Status<Unit> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((UploadFragment) this.receiver).onUploadStatusChanged(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Status<? extends Unit> status) {
            m5124a(status);
            return Unit.INSTANCE;
        }
    }

    public UploadFragment() {
        super(C4957R.layout.yds_fragment_upload);
        this.DELAY_SUCCESS_UPLOAD_STATUS = FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS;
        this.handler = new Handler();
        this.binding = FragmentKt.viewBindingLazy(this, new C4986a(this));
    }

    private final boolean displaySuccessfulUploadState() {
        C4968d binding = getBinding();
        YotiAppbar appBar = binding.f7585b;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, NavigationIcon.CLOSE_BLUE, false, 0, 0, 0, 60, null);
        binding.f7586c.setImageResource(C4957R.drawable.yds_ic_tick_grey);
        TextView textView = getBinding().f7588e;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        TextViewLoadingEllipsisAnimationKt.hideLoadingEllipsis(textView);
        textView.setText(getUploadSuccessTitle());
        binding.f7587d.setVisibility(8);
        return this.handler.postDelayed(new Runnable() { // from class: com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UploadFragment.m6907displaySuccessfulUploadState$lambda4$lambda3(this.f$0);
            }
        }, this.DELAY_SUCCESS_UPLOAD_STATUS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: displaySuccessfulUploadState$lambda-4$lambda-3, reason: not valid java name */
    public static final void m6907displaySuccessfulUploadState$lambda4$lambda3(UploadFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finishFlow();
    }

    private final C4968d getBinding() {
        return (C4968d) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final void initialiseAppBar() {
        YotiAppbar yotiAppbar = getBinding().f7585b;
        Intrinsics.checkNotNullExpressionValue(yotiAppbar, "binding.appBar");
        BaseFragment.configureAppBar$default(this, yotiAppbar, NavigationIcon.NONE, false, 0, 0, 0, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUploadProgressChanged(double progress) {
        getBinding().f7587d.setProgress((int) (progress * ((double) 100)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUploadStatusChanged(Status<Unit> status) {
        if (status instanceof Status.Success) {
            displaySuccessfulUploadState();
        } else if (status instanceof Status.Error) {
            displayUploadFailureState(((Status.Error) status).getError());
        }
    }

    public abstract T createViewModel();

    public void displayUploadFailureState(YdsFailure failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failure.getFailureType() instanceof YdsFailureType.InconsistencyError) {
            navigateToPreviousScreen();
        } else {
            showFailure(failure, "UPLOAD_ERROR_DIALOG_TAG");
        }
    }

    public abstract String getUploadInProgressTitle();

    public abstract String getUploadSuccessTitle();

    protected final T getUploadViewModel() {
        T t = this.uploadViewModel;
        if (t != null) {
            return t;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uploadViewModel");
        return null;
    }

    public abstract void initialiseUploadProcess();

    @Override // com.yoti.mobile.android.commonui.BaseFragment
    protected void navigateBack() {
        if (getUploadViewModel().getUploadStatus().getValue() instanceof Status.Success) {
            finishFlow();
        } else {
            navigateToPreviousScreen();
        }
    }

    public abstract void navigateToPreviousScreen();

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.handler.removeCallbacksAndMessages(null);
        super.onDestroyView();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        if (Intrinsics.areEqual(dialogTag, "UPLOAD_ERROR_DIALOG_TAG")) {
            cancelFlow();
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        if (Intrinsics.areEqual(dialogTag, "UPLOAD_ERROR_DIALOG_TAG")) {
            initialiseUploadProcess();
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getBinding().f7588e;
        textView.setText(getUploadInProgressTitle());
        Intrinsics.checkNotNullExpressionValue(textView, "");
        TextViewLoadingEllipsisAnimationKt.showLoadingEllipsis(textView);
        UploadViewModel uploadViewModelCreateViewModel = createViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, uploadViewModelCreateViewModel.getUploadProgress(), new C4987b(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner2, uploadViewModelCreateViewModel.getUploadStatus(), new C4988c(this));
        setUploadViewModel(uploadViewModelCreateViewModel);
        initialiseAppBar();
        initialiseUploadProcess();
    }

    protected final void setUploadViewModel(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.uploadViewModel = t;
    }
}
