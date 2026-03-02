package com.yoti.mobile.android.liveness.view.upload;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import com.yoti.mobile.android.commonui.GenericMessageFragment;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalGuidelineFragmentArgs;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorNavigationEvent;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorViewEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0014J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorFragment;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "()V", "viewModel", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "handleNavigationEvent", "", "navigationEvent", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent;", "navigateBack", "onActionButtonClicked", "onAttach", "context", "Landroid/content/Context;", "onSecondaryActionButtonClicked", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessUploadErrorFragment extends GenericMessageFragment {
    private LivenessUploadErrorViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNavigationEvent(SingleEvent<? extends LivenessUploadErrorNavigationEvent> navigationEvent) {
        navigationEvent.getContentIfNotHandled(new Function1<LivenessUploadErrorNavigationEvent, Unit>() { // from class: com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorFragment.handleNavigationEvent.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LivenessUploadErrorNavigationEvent livenessUploadErrorNavigationEvent) {
                invoke2(livenessUploadErrorNavigationEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LivenessUploadErrorNavigationEvent it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (Intrinsics.areEqual(it2, LivenessUploadErrorNavigationEvent.NavigateBackToLivenessEducational.INSTANCE)) {
                    FragmentKt.findNavController(LivenessUploadErrorFragment.this).popBackStack(C4871R.id.livenessEducationalFragment, false);
                } else if (it2 instanceof LivenessUploadErrorNavigationEvent.NavigateToGuidelines) {
                    NavigationKt.navigateSafe$default(FragmentKt.findNavController(LivenessUploadErrorFragment.this), C4871R.id.action_to_livenessEducationalGuidelineFragment, new LivenessEducationalGuidelineFragmentArgs(((LivenessUploadErrorNavigationEvent.NavigateToGuidelines) it2).getGuidelinesViewData()).toBundle(), null, null, 12, null);
                } else if (Intrinsics.areEqual(it2, LivenessUploadErrorNavigationEvent.CancelFlow.INSTANCE)) {
                    LivenessUploadErrorFragment.this.cancelFlow();
                }
            }
        });
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment
    protected void navigateBack() {
        LivenessUploadErrorViewModel livenessUploadErrorViewModel = this.viewModel;
        if (livenessUploadErrorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            livenessUploadErrorViewModel = null;
        }
        livenessUploadErrorViewModel.handleViewEvent(LivenessUploadErrorViewEvent.NavigateBack.INSTANCE);
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onActionButtonClicked() {
        LivenessUploadErrorViewModel livenessUploadErrorViewModel = this.viewModel;
        if (livenessUploadErrorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            livenessUploadErrorViewModel = null;
        }
        livenessUploadErrorViewModel.handleViewEvent(LivenessUploadErrorViewEvent.ScanAgain.INSTANCE);
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LivenessCoreSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onSecondaryActionButtonClicked() {
        LivenessUploadErrorViewModel livenessUploadErrorViewModel = this.viewModel;
        if (livenessUploadErrorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            livenessUploadErrorViewModel = null;
        }
        GenericMessageFragment.IGenericMessageCustomArgs customArgs = getNavArguments().getCustomArgs();
        if (customArgs == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType");
        }
        livenessUploadErrorViewModel.handleViewEvent(new LivenessUploadErrorViewEvent.SeeGuidelines((LivenessUploadFailureType) customArgs));
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LivenessUploadErrorViewModel livenessUploadErrorViewModel = (LivenessUploadErrorViewModel) new ViewModelProvider(this, getViewModelFactory()).get(LivenessUploadErrorViewModel.class);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, livenessUploadErrorViewModel.getNavigationEvent(), new LivenessUploadErrorFragment$onViewCreated$1$1(this));
        this.viewModel = livenessUploadErrorViewModel;
    }

    public final void setViewModelFactory(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
