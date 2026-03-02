package com.yoti.mobile.android.liveness.view.educational;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.navigation.NavArgsLazy;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.liveness.databinding.YdsFragmentLivenessEducationalGuidelineBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalGuidelineFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentLivenessEducationalGuidelineBinding;", "getBinding", "()Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentLivenessEducationalGuidelineBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "fragmentArgs", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalGuidelineFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalGuidelineFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "bindViewData", "", "viewData", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessEducationalGuidelineFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LivenessEducationalGuidelineFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentLivenessEducationalGuidelineBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;

    public LivenessEducationalGuidelineFragment() {
        super(C4871R.layout.yds_fragment_liveness_educational_guideline);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentLivenessEducationalGuidelineBinding>() { // from class: com.yoti.mobile.android.liveness.view.educational.LivenessEducationalGuidelineFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentLivenessEducationalGuidelineBinding invoke() {
                return YdsFragmentLivenessEducationalGuidelineBinding.bind(this.this$0.requireView());
            }
        });
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(LivenessEducationalGuidelineFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.liveness.view.educational.LivenessEducationalGuidelineFragment$special$$inlined$navArgs$1
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

    private final void bindViewData(LivenessGuidelinesViewData viewData) {
        YdsFragmentLivenessEducationalGuidelineBinding binding = getBinding();
        YotiAppbar appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, viewData.getNavigationIcon(), false, 0, 0, 0, 60, null);
        binding.livenessGuidelinesDescriptionFirst.setText(viewData.getDescriptionFirst());
        binding.livenessGuidelinesImageRowFirstStart.setImageResource(viewData.getImageRowFirst().getFirst().intValue());
        binding.livenessGuidelinesImageRowFirstEnd.setImageResource(viewData.getImageRowFirst().getSecond().intValue());
        binding.livenessGuidelinesDescriptionSecond.setText(viewData.getDescriptionSecond());
        binding.livenessGuidelinesImageRowSecondStart.setImageResource(viewData.getImageRowSecond().getFirst().intValue());
        binding.livenessGuidelinesImageRowSecondEnd.setImageResource(viewData.getImageRowSecond().getSecond().intValue());
    }

    private final YdsFragmentLivenessEducationalGuidelineBinding getBinding() {
        return (YdsFragmentLivenessEducationalGuidelineBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LivenessEducationalGuidelineFragmentArgs getFragmentArgs() {
        return (LivenessEducationalGuidelineFragmentArgs) this.fragmentArgs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-1$lambda-0, reason: not valid java name */
    public static final void m6874onViewCreated$lambda1$lambda0(LivenessEducationalGuidelineFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.navigateBack();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        YdsFragmentLivenessEducationalGuidelineBinding binding = getBinding();
        super.onViewCreated(view, savedInstanceState);
        binding.buttonLivenessGuidelinesGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.liveness.view.educational.LivenessEducationalGuidelineFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LivenessEducationalGuidelineFragment.m6874onViewCreated$lambda1$lambda0(this.f$0, view2);
            }
        });
        bindViewData(getFragmentArgs().getGuidelinesViewData());
        ScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(scrollView, shadow).attach();
    }
}
