package com.yoti.mobile.android.commonui.moreabout;

import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavArgsLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.C4590R;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.databinding.YdsFragmentMoreAboutBinding;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.moreabout.MoreAboutItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: MoreAboutFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentMoreAboutBinding;", "getBinding", "()Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentMoreAboutBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "navArguments", "Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "getNavArguments", "()Lcom/yoti/mobile/android/commonui/moreabout/MoreAboutFragmentArgs;", "navArguments$delegate", "Landroidx/navigation/NavArgsLazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MoreAboutFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MoreAboutFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/commonui/databinding/YdsFragmentMoreAboutBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    /* JADX INFO: renamed from: navArguments$delegate, reason: from kotlin metadata */
    private final NavArgsLazy navArguments;

    public MoreAboutFragment() {
        super(C4590R.layout.yds_fragment_more_about);
        final MoreAboutFragment moreAboutFragment = this;
        this.navArguments = new NavArgsLazy(Reflection.getOrCreateKotlinClass(MoreAboutFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.commonui.moreabout.MoreAboutFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = moreAboutFragment.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + moreAboutFragment + " has null arguments");
            }
        });
        this.binding = FragmentKt.viewBindingLazy(moreAboutFragment, new Function0<YdsFragmentMoreAboutBinding>() { // from class: com.yoti.mobile.android.commonui.moreabout.MoreAboutFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentMoreAboutBinding invoke() {
                return YdsFragmentMoreAboutBinding.bind(this.this$0.requireView());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MoreAboutFragmentArgs getNavArguments() {
        return (MoreAboutFragmentArgs) this.navArguments.getValue();
    }

    private final YdsFragmentMoreAboutBinding getBinding() {
        return (YdsFragmentMoreAboutBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        YdsFragmentMoreAboutBinding binding = getBinding();
        super.onViewCreated(view, savedInstanceState);
        MoreAboutFragmentContent moreAboutFragmentContent = getNavArguments().getMoreAboutFragmentContent();
        binding.moreAboutVerificationRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(MoreAboutItem.AppbarItem.INSTANCE);
        arrayList.add(moreAboutFragmentContent.getTitleItem());
        Iterator<T> it2 = moreAboutFragmentContent.getDescriptionItems().iterator();
        while (it2.hasNext()) {
            arrayList.add((MoreAboutItem.MoreAboutDescItem) it2.next());
        }
        arrayList.add(MoreAboutItem.MoreAboutSeparatorItem.INSTANCE);
        Iterator<T> it3 = moreAboutFragmentContent.getAccordionItems().iterator();
        while (it3.hasNext()) {
            arrayList.add((MoreAboutItem.MoreAboutAccordionItem) it3.next());
        }
        MoreAboutItem.MoreAboutLogoItem logoItem = moreAboutFragmentContent.getLogoItem();
        if (logoItem != null) {
            arrayList.add(logoItem);
        }
        binding.moreAboutVerificationRecyclerView.setAdapter(new MoreAboutAdapter(arrayList, this));
        binding.buttonAction.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.commonui.moreabout.MoreAboutFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoreAboutFragment.m6801onViewCreated$lambda6$lambda5(this.f$0, view2);
            }
        });
        RecyclerView moreAboutVerificationRecyclerView = binding.moreAboutVerificationRecyclerView;
        Intrinsics.checkNotNullExpressionValue(moreAboutVerificationRecyclerView, "moreAboutVerificationRecyclerView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(moreAboutVerificationRecyclerView, shadow).attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-6$lambda-5, reason: not valid java name */
    public static final void m6801onViewCreated$lambda6$lambda5(MoreAboutFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.navigateBack();
    }
}
