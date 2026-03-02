package com.yoti.mobile.android.commonui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavArgsLazy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.databinding.YdsFragmentGenericMessageBinding;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GenericMessageFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002+,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001e\u0010%\u001a\u00020\u0017*\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006-"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentGenericMessageBinding;", "getBinding", "()Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentGenericMessageBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "isSecondaryButtonVisible", "", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/commonui/GenericMessageFragment$GenericMessageFragmentInteractionListener;", "navArguments", "Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;", "getNavArguments", "()Lcom/yoti/mobile/android/commonui/GenericMessageFragmentArgs;", "navArguments$delegate", "Landroidx/navigation/NavArgsLazy;", "configurePrimaryButton", "Lcom/yoti/mobile/android/common/ui/widgets/YotiButton;", "configureSecondaryButton", "", "handleNavigationIconClicked", "initialiseWidgets", "onActionButtonClicked", "onAttach", "context", "Landroid/content/Context;", "onDetach", "onSecondaryActionButtonClicked", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setText", "Landroid/widget/TextView;", "textResId", "", "textRaw", "", "GenericMessageFragmentInteractionListener", "IGenericMessageCustomArgs", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class GenericMessageFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GenericMessageFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentGenericMessageBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private GenericMessageFragmentInteractionListener listener;

    /* JADX INFO: renamed from: navArguments$delegate, reason: from kotlin metadata */
    private final NavArgsLazy navArguments;

    /* JADX INFO: compiled from: GenericMessageFragment.kt */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GenericMessageFragment$GenericMessageFragmentInteractionListener;", "", "onActionButtonClicked", "", "onNavigationIconClicked", "onSecondaryActionButtonClicked", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public interface GenericMessageFragmentInteractionListener {

        /* JADX INFO: compiled from: GenericMessageFragment.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class DefaultImpls {
            public static void onSecondaryActionButtonClicked(GenericMessageFragmentInteractionListener genericMessageFragmentInteractionListener) {
            }
        }

        void onActionButtonClicked();

        void onNavigationIconClicked();

        void onSecondaryActionButtonClicked();
    }

    /* JADX INFO: compiled from: GenericMessageFragment.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GenericMessageFragment$IGenericMessageCustomArgs;", "Landroid/os/Parcelable;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public interface IGenericMessageCustomArgs extends Parcelable {
    }

    public GenericMessageFragment() {
        super(C4590R.layout.yds_fragment_generic_message);
        final GenericMessageFragment genericMessageFragment = this;
        this.navArguments = new NavArgsLazy(Reflection.getOrCreateKotlinClass(GenericMessageFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.commonui.GenericMessageFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = genericMessageFragment.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + genericMessageFragment + " has null arguments");
            }
        });
        this.binding = FragmentKt.viewBindingLazy(genericMessageFragment, new Function0<YdsFragmentGenericMessageBinding>() { // from class: com.yoti.mobile.android.commonui.GenericMessageFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentGenericMessageBinding invoke() {
                return YdsFragmentGenericMessageBinding.bind(this.this$0.requireView());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final GenericMessageFragmentArgs getNavArguments() {
        return (GenericMessageFragmentArgs) this.navArguments.getValue();
    }

    protected final YdsFragmentGenericMessageBinding getBinding() {
        return (YdsFragmentGenericMessageBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final boolean isSecondaryButtonVisible() {
        String secondaryActionButtonText;
        return (getNavArguments().getSecondaryActionButtonTextResId() == 0 && ((secondaryActionButtonText = getNavArguments().getSecondaryActionButtonText()) == null || secondaryActionButtonText.length() == 0)) ? false : true;
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        YdsFragmentGenericMessageBinding binding = getBinding();
        super.onViewCreated(view, savedInstanceState);
        YotiAppbar appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, null, false, 0, 0, 0, 62, null);
        initialiseWidgets();
        ScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(scrollView, shadow).attach();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.listener = context instanceof GenericMessageFragmentInteractionListener ? (GenericMessageFragmentInteractionListener) context : null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    public void onSecondaryActionButtonClicked() {
        GenericMessageFragmentInteractionListener genericMessageFragmentInteractionListener = this.listener;
        if (genericMessageFragmentInteractionListener != null) {
            genericMessageFragmentInteractionListener.onSecondaryActionButtonClicked();
        }
    }

    public void onActionButtonClicked() {
        GenericMessageFragmentInteractionListener genericMessageFragmentInteractionListener = this.listener;
        if (genericMessageFragmentInteractionListener != null) {
            genericMessageFragmentInteractionListener.onActionButtonClicked();
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment
    protected void handleNavigationIconClicked() {
        super.handleNavigationIconClicked();
        GenericMessageFragmentInteractionListener genericMessageFragmentInteractionListener = this.listener;
        if (genericMessageFragmentInteractionListener != null) {
            genericMessageFragmentInteractionListener.onNavigationIconClicked();
        }
    }

    private final void initialiseWidgets() {
        YdsFragmentGenericMessageBinding binding = getBinding();
        binding.imageViewHead.setImageResource(getNavArguments().getHeaderImgResId());
        TextView textViewTitle = binding.textViewTitle;
        Intrinsics.checkNotNullExpressionValue(textViewTitle, "textViewTitle");
        setText(textViewTitle, getNavArguments().getTitleResId(), getNavArguments().getTitle());
        TextView textViewContent = binding.textViewContent;
        Intrinsics.checkNotNullExpressionValue(textViewContent, "textViewContent");
        setText(textViewContent, getNavArguments().getContentResId(), getNavArguments().getContent());
        configurePrimaryButton();
        configureSecondaryButton();
    }

    private final YotiButton configurePrimaryButton() {
        YotiButton yotiButton = getBinding().buttonAction;
        Intrinsics.checkNotNullExpressionValue(yotiButton, "");
        setText(yotiButton, getNavArguments().getButtonTextResId(), getNavArguments().getActionButtonText());
        yotiButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.commonui.GenericMessageFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GenericMessageFragment.m6784configurePrimaryButton$lambda4$lambda3$lambda2(this.f$0, view);
            }
        });
        if (getNavArguments().getActionButtonIconResId() != 0) {
            yotiButton.setIcon(ContextCompat.getDrawable(requireContext(), getNavArguments().getActionButtonIconResId()));
        }
        Intrinsics.checkNotNullExpressionValue(yotiButton, "with(binding) {\n        …        }\n        }\n    }");
        return yotiButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configurePrimaryButton$lambda-4$lambda-3$lambda-2, reason: not valid java name */
    public static final void m6784configurePrimaryButton$lambda4$lambda3$lambda2(GenericMessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onActionButtonClicked();
    }

    private final void configureSecondaryButton() {
        if (isSecondaryButtonVisible()) {
            YotiButton yotiButton = getBinding().buttonActionSecondary;
            Intrinsics.checkNotNullExpressionValue(yotiButton, "");
            yotiButton.setVisibility(0);
            setText(yotiButton, getNavArguments().getSecondaryActionButtonTextResId(), getNavArguments().getSecondaryActionButtonText());
            yotiButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.commonui.GenericMessageFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GenericMessageFragment.m6785configureSecondaryButton$lambda6$lambda5(this.f$0, view);
                }
            });
            if (getNavArguments().getSecondaryActionButtonIconResId() != 0) {
                yotiButton.setIcon(ContextCompat.getDrawable(requireContext(), getNavArguments().getSecondaryActionButtonIconResId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configureSecondaryButton$lambda-6$lambda-5, reason: not valid java name */
    public static final void m6785configureSecondaryButton$lambda6$lambda5(GenericMessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onSecondaryActionButtonClicked();
    }

    private final void setText(TextView textView, int i, String str) {
        if (i == 0) {
            textView.setText(str);
        } else {
            textView.setText(i);
        }
    }
}
