package com.yoti.mobile.android.commonui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.CompoundTextResource;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.databinding.YdsFragmentGuidelinesBinding;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.HideButtonProgressWithDelayKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GuidelinesFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH$J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001d\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/GuidelinesFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentGuidelinesBinding;", "getBinding", "()Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentGuidelinesBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "hidePrimaryButtonProgressWithDelay", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrimaryButtonClick", "onViewCreated", "view", "setUpAppBar", "appBarConfig", "Lcom/yoti/mobile/android/commonui/AppBarConfig;", "setUpPrimaryButton", "viewData", "Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "setUpRecyclerView", "showPrimaryButtonProgress", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class GuidelinesFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GuidelinesFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentGuidelinesBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    protected abstract void onPrimaryButtonClick();

    public GuidelinesFragment() {
        super(0, 1, null);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentGuidelinesBinding>() { // from class: com.yoti.mobile.android.commonui.GuidelinesFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentGuidelinesBinding invoke() {
                return YdsFragmentGuidelinesBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentGuidelinesBinding getBinding() {
        return (YdsFragmentGuidelinesBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C4590R.layout.yds_fragment_guidelines, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflater.inflate(R.layou…elines, container, false)");
        return viewInflate;
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Parcelable parcelable = requireArguments().getParcelable("ARG_GUIDELINES_VIEW_DATA");
        if (parcelable == null) {
            throw new IllegalArgumentException(("Fragment " + this + " does not have the required arguments.").toString());
        }
        GuidelinesViewData guidelinesViewData = (GuidelinesViewData) parcelable;
        YdsFragmentGuidelinesBinding binding = getBinding();
        setUpAppBar(guidelinesViewData.getAppBarConfig());
        TextView textView = binding.guidelinesTitle;
        CompoundTextResource title = guidelinesViewData.getTitle();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(title.getValue(contextRequireContext));
        Integer subtitle = guidelinesViewData.getSubtitle();
        if (subtitle != null) {
            binding.guidelinesSubtitle.setText(subtitle.intValue());
            TextView guidelinesSubtitle = binding.guidelinesSubtitle;
            Intrinsics.checkNotNullExpressionValue(guidelinesSubtitle, "guidelinesSubtitle");
            guidelinesSubtitle.setVisibility(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            TextView guidelinesSubtitle2 = binding.guidelinesSubtitle;
            Intrinsics.checkNotNullExpressionValue(guidelinesSubtitle2, "guidelinesSubtitle");
            guidelinesSubtitle2.setVisibility(8);
        }
        Intrinsics.checkNotNullExpressionValue(guidelinesViewData, "this@apply");
        setUpRecyclerView(guidelinesViewData);
        View dragIndicator = binding.dragIndicator;
        Intrinsics.checkNotNullExpressionValue(dragIndicator, "dragIndicator");
        dragIndicator.setVisibility(guidelinesViewData.getShowDragIndicator() ? 0 : 8);
        setUpPrimaryButton(guidelinesViewData);
        NestedScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(scrollView, shadow).attach();
    }

    public final void showPrimaryButtonProgress() {
        getBinding().guidelinesButtonPrimary.showProgress();
    }

    public final void hidePrimaryButtonProgressWithDelay() {
        YotiButton yotiButton = getBinding().guidelinesButtonPrimary;
        Intrinsics.checkNotNullExpressionValue(yotiButton, "binding.guidelinesButtonPrimary");
        HideButtonProgressWithDelayKt.hideProgressWithDelay(yotiButton);
    }

    private final void setUpAppBar(AppBarConfig appBarConfig) {
        Unit unit;
        YdsFragmentGuidelinesBinding binding = getBinding();
        if (appBarConfig != null) {
            YotiAppbar appBar = binding.appBar;
            Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
            BaseFragment.configureAppBar$default(this, appBar, appBarConfig.getNavigationIcon(), false, 0, 0, appBarConfig.getLogoRes(), 28, null);
            YotiAppbar appBar2 = binding.appBar;
            Intrinsics.checkNotNullExpressionValue(appBar2, "appBar");
            appBar2.setVisibility(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            YotiAppbar appBar3 = binding.appBar;
            Intrinsics.checkNotNullExpressionValue(appBar3, "appBar");
            appBar3.setVisibility(8);
        }
    }

    private final void setUpRecyclerView(GuidelinesViewData viewData) {
        RecyclerView recyclerView = getBinding().guidelinesRecyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new GuidelinesListAdapter(viewData.getItems(), viewData.isListView()));
        if (viewData.isListView()) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, recyclerView.getResources().getDimensionPixelSize(C4590R.dimen.yds_guidelines_grid_cell_spacing)));
        }
    }

    private final void setUpPrimaryButton(GuidelinesViewData viewData) {
        YdsFragmentGuidelinesBinding binding = getBinding();
        binding.guidelinesButtonPrimary.setText(viewData.getPrimaryButtonText());
        binding.guidelinesButtonPrimary.setIconResource(viewData.getPrimaryButtonIcon());
        binding.guidelinesButtonPrimary.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.commonui.GuidelinesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuidelinesFragment.m6786setUpPrimaryButton$lambda10$lambda9(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setUpPrimaryButton$lambda-10$lambda-9, reason: not valid java name */
    public static final void m6786setUpPrimaryButton$lambda10$lambda9(GuidelinesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onPrimaryButtonClick();
    }
}
