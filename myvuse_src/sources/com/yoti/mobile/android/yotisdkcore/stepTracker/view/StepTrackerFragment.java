package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.FragmentActivityKt;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import com.yoti.mobile.android.yotisdkcore.p081b.C4965a;
import com.yoti.mobile.android.yotisdkcore.p081b.C4966b;
import com.yoti.mobile.android.yotisdkcore.p081b.C4967c;
import com.yoti.mobile.android.yotisdkcore.stepTracker.di.StepTrackerCoreSession;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerNavigationEvent;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewEvent;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerViewState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\"\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0016J\u0016\u0010(\u001a\u00020\u001d2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0016J\u001a\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u001dH\u0002J\u0018\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020.H\u0002J\b\u0010=\u001a\u00020\u001dH\u0002J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020@H\u0002J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020@H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00168\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006D"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentSteptrackerBinding;", "getBinding", "()Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentSteptrackerBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "loadingView", "Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentSteptrackerLoadingStatusBinding;", "stepListAdapter", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerListAdapter;", "getStepListAdapter", "()Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerListAdapter;", "setStepListAdapter", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerListAdapter;)V", "successView", "Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentSteptrackerSuccessStatusBinding;", "viewModel", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "hideCtaLoading", "", "hideFullscreenLoading", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onNavigationEvent", "navigationEvent", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerNavigationEvent;", "onNegativeButtonClick", "dialogTag", "", "onPositiveButtonClick", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewStateChanged", "viewState", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState;", "showCtaLoading", "showError", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", HeaderParameterNames.AUTHENTICATION_TAG, "showFullscreenLoading", "showStepTracker", "viewData", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewData;", "updateData", "stepTrackerViewData", "updateStepTracker", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class StepTrackerFragment extends BaseFragment {

    /* JADX INFO: renamed from: g */
    static final /* synthetic */ KProperty<Object>[] f7770g = {Reflection.property1(new PropertyReference1Impl(StepTrackerFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentSteptrackerBinding;", 0))};

    /* JADX INFO: renamed from: a */
    @Inject
    public StepTrackerListAdapter f7771a;

    /* JADX INFO: renamed from: b */
    @Inject
    public SavedStateViewModelFactory<StepTrackerViewModel> f7772b;

    /* JADX INFO: renamed from: c */
    private StepTrackerViewModel f7773c;

    /* JADX INFO: renamed from: d */
    private final ReadOnlyProperty f7774d;

    /* JADX INFO: renamed from: e */
    private C4967c f7775e;

    /* JADX INFO: renamed from: f */
    private C4966b f7776f;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerFragment$a */
    @Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m5598d2 = {"<anonymous>", "Lcom/yoti/mobile/android/yotisdkcore/databinding/YdsFragmentSteptrackerBinding;", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class C5019a extends Lambda implements Function0<C4965a> {
        C5019a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C4965a invoke() {
            return C4965a.m5098a(StepTrackerFragment.this.requireView());
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerFragment$b */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m5598d2 = {"<anonymous>", "", "it", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerNavigationEvent;", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class C5020b extends Lambda implements Function1<StepTrackerNavigationEvent, Unit> {
        C5020b() {
            super(1);
        }

        /* JADX INFO: renamed from: a */
        public final void m5218a(StepTrackerNavigationEvent it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            if (Intrinsics.areEqual(it2, StepTrackerNavigationEvent.a.f7837a)) {
                StepTrackerFragment.this.finishFlow();
            } else if (Intrinsics.areEqual(it2, StepTrackerNavigationEvent.b.f7838a)) {
                StepTrackerFragment.this.finishSdk();
            } else if (Intrinsics.areEqual(it2, StepTrackerNavigationEvent.c.f7839a)) {
                StepTrackerFragment.this.navigateBack();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StepTrackerNavigationEvent stepTrackerNavigationEvent) {
            m5218a(stepTrackerNavigationEvent);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerFragment$c */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C5021c extends FunctionReferenceImpl implements Function1<StepTrackerViewState, Unit> {
        C5021c(Object obj) {
            super(1, obj, StepTrackerFragment.class, "onViewStateChanged", "onViewStateChanged(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewState;)V", 0);
        }

        /* JADX INFO: renamed from: a */
        public final void m5219a(StepTrackerViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((StepTrackerFragment) this.receiver).m5207a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StepTrackerViewState stepTrackerViewState) {
            m5219a(stepTrackerViewState);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerFragment$d */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C5022d extends FunctionReferenceImpl implements Function1<SingleEvent<? extends StepTrackerNavigationEvent>, Unit> {
        C5022d(Object obj) {
            super(1, obj, StepTrackerFragment.class, "onNavigationEvent", "onNavigationEvent(Lcom/yoti/mobile/android/commonui/SingleEvent;)V", 0);
        }

        /* JADX INFO: renamed from: a */
        public final void m5220a(SingleEvent<? extends StepTrackerNavigationEvent> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((StepTrackerFragment) this.receiver).m5200a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SingleEvent<? extends StepTrackerNavigationEvent> singleEvent) {
            m5220a(singleEvent);
            return Unit.INSTANCE;
        }
    }

    public StepTrackerFragment() {
        super(C4957R.layout.yds_fragment_steptracker);
        this.f7774d = FragmentKt.viewBindingLazy(this, new C5019a());
    }

    /* JADX INFO: renamed from: a */
    private final C4965a m5199a() {
        return (C4965a) this.f7774d.getValue(this, f7770g[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5200a(SingleEvent<? extends StepTrackerNavigationEvent> singleEvent) {
        singleEvent.getContentIfNotHandled(new C5020b());
    }

    /* JADX INFO: renamed from: a */
    private final void m5201a(YdsFailure ydsFailure, String str) {
        m5212e();
        m5211d();
        showFailure(ydsFailure, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static final void m5203a(StepTrackerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StepTrackerViewModel stepTrackerViewModel = this$0.f7773c;
        if (stepTrackerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            stepTrackerViewModel = null;
        }
        stepTrackerViewModel.m5331a(StepTrackerViewEvent.e.f7848a);
    }

    /* JADX INFO: renamed from: a */
    private final void m5206a(StepTrackerViewData stepTrackerViewData) {
        m5212e();
        m5211d();
        C4967c c4967c = this.f7775e;
        C4967c c4967c2 = null;
        if (c4967c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
            c4967c = null;
        }
        c4967c.f7579d.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepTrackerFragment.m5203a(this.f$0, view);
            }
        });
        m5209b(stepTrackerViewData);
        m5210c(stepTrackerViewData);
        C4967c c4967c3 = this.f7775e;
        if (c4967c3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
        } else {
            c4967c2 = c4967c3;
        }
        YotiAppbar yotiAppbar = c4967c2.f7577b;
        Intrinsics.checkNotNullExpressionValue(yotiAppbar, "successView.appBar");
        BaseFragment.configureAppBar$default(this, yotiAppbar, null, false, 0, 0, 0, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5207a(StepTrackerViewState stepTrackerViewState) {
        if (Intrinsics.areEqual(stepTrackerViewState, StepTrackerViewState.a.C6028a.f7865a)) {
            m5213f();
            return;
        }
        if (Intrinsics.areEqual(stepTrackerViewState, StepTrackerViewState.a.b.f7866a)) {
            m5214g();
            return;
        }
        if (stepTrackerViewState instanceof StepTrackerViewState.b) {
            StepTrackerViewState.b bVar = (StepTrackerViewState.b) stepTrackerViewState;
            m5201a(bVar.getF7867a(), bVar.getF7868b());
        } else if (stepTrackerViewState instanceof StepTrackerViewState.c) {
            m5206a(((StepTrackerViewState.c) stepTrackerViewState).getF7869a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static final void m5208b(StepTrackerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StepTrackerViewModel stepTrackerViewModel = this$0.f7773c;
        if (stepTrackerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            stepTrackerViewModel = null;
        }
        stepTrackerViewModel.m5331a(new StepTrackerViewEvent.f(this$0));
    }

    /* JADX INFO: renamed from: b */
    private final void m5209b(StepTrackerViewData stepTrackerViewData) {
        if (stepTrackerViewData.m5299g().isEmpty()) {
            return;
        }
        C4967c c4967c = this.f7775e;
        if (c4967c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
            c4967c = null;
        }
        RecyclerView recyclerView = c4967c.f7583h.f7591b;
        StepTrackerListAdapter stepTrackerListAdapterM5215b = m5215b();
        List<Step> listM5299g = stepTrackerViewData.m5299g();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listM5299g, 10));
        Iterator<T> it2 = listM5299g.iterator();
        while (it2.hasNext()) {
            arrayList.add(((Step) it2.next()).getF7828a());
        }
        stepTrackerListAdapterM5215b.m5287a(arrayList);
        recyclerView.setAdapter(stepTrackerListAdapterM5215b);
    }

    /* JADX INFO: renamed from: c */
    private final void m5210c(StepTrackerViewData stepTrackerViewData) {
        C4967c c4967c = this.f7775e;
        C4967c c4967c2 = null;
        if (c4967c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
            c4967c = null;
        }
        if (stepTrackerViewData.m5294a()) {
            C4967c c4967c3 = this.f7775e;
            if (c4967c3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("successView");
            } else {
                c4967c2 = c4967c3;
            }
            c4967c2.f7578c.setVisibility(8);
            c4967c.f7579d.setVisibility(0);
            if (stepTrackerViewData.m5302j()) {
                c4967c.f7583h.getRoot().setVisibility(8);
                c4967c.f7580e.getRoot().setVisibility(0);
            }
        } else {
            c4967c.f7578c.setText(stepTrackerViewData.getF7843d());
            c4967c.f7578c.setVisibility(0);
            c4967c.f7579d.setVisibility(8);
        }
        c4967c.f7583h.f7593d.setText(stepTrackerViewData.getF7841b());
        c4967c.f7583h.f7592c.setText(stepTrackerViewData.getF7842c());
        c4967c.f7578c.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.yotisdkcore.stepTracker.view.StepTrackerFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepTrackerFragment.m5208b(this.f$0, view);
            }
        });
        NestedScrollView nestedScrollView = c4967c.f7581f;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "nestedScrollView");
        View shadow = c4967c.f7582g;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(nestedScrollView, shadow).attach();
    }

    /* JADX INFO: renamed from: d */
    private final void m5211d() {
        C4967c c4967c = this.f7775e;
        if (c4967c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
            c4967c = null;
        }
        c4967c.f7579d.hideProgress();
    }

    /* JADX INFO: renamed from: e */
    private final void m5212e() {
        C4966b c4966b = this.f7776f;
        C4967c c4967c = null;
        if (c4966b == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            c4966b = null;
        }
        c4966b.getRoot().setVisibility(8);
        C4967c c4967c2 = this.f7775e;
        if (c4967c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
        } else {
            c4967c = c4967c2;
        }
        c4967c.getRoot().setVisibility(0);
    }

    /* JADX INFO: renamed from: f */
    private final void m5213f() {
        C4967c c4967c = this.f7775e;
        if (c4967c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
            c4967c = null;
        }
        c4967c.f7579d.showProgress();
    }

    /* JADX INFO: renamed from: g */
    private final void m5214g() {
        C4966b c4966b = this.f7776f;
        C4967c c4967c = null;
        if (c4966b == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            c4966b = null;
        }
        c4966b.getRoot().setVisibility(0);
        C4967c c4967c2 = this.f7775e;
        if (c4967c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successView");
        } else {
            c4967c = c4967c2;
        }
        c4967c.getRoot().setVisibility(8);
    }

    /* JADX INFO: renamed from: b */
    public final StepTrackerListAdapter m5215b() {
        StepTrackerListAdapter stepTrackerListAdapter = this.f7771a;
        if (stepTrackerListAdapter != null) {
            return stepTrackerListAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stepListAdapter");
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final SavedStateViewModelFactory<StepTrackerViewModel> m5216c() {
        SavedStateViewModelFactory<StepTrackerViewModel> savedStateViewModelFactory = this.f7772b;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        StepTrackerViewEvent stepTrackerViewEvent;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1003) {
            StepTrackerViewModel stepTrackerViewModel = null;
            if (resultCode == FragmentActivityKt.getRESULT_CLOSE_YOTIDOCSDK()) {
                StepTrackerViewModel stepTrackerViewModel2 = this.f7773c;
                if (stepTrackerViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    stepTrackerViewModel = stepTrackerViewModel2;
                }
                stepTrackerViewEvent = StepTrackerViewEvent.d.f7847a;
            } else if (resultCode == -1) {
                StepTrackerViewModel stepTrackerViewModel3 = this.f7773c;
                if (stepTrackerViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    stepTrackerViewModel = stepTrackerViewModel3;
                }
                stepTrackerViewEvent = StepTrackerViewEvent.g.f7850a;
            } else {
                if (resultCode != FragmentActivityKt.getRESULT_FLOW_CANCELED()) {
                    return;
                }
                StepTrackerViewModel stepTrackerViewModel4 = this.f7773c;
                if (stepTrackerViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    stepTrackerViewModel = stepTrackerViewModel4;
                }
                stepTrackerViewEvent = StepTrackerViewEvent.c.f7846a;
            }
            stepTrackerViewModel.m5331a(stepTrackerViewEvent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StepTrackerCoreSession.f7673d.m5163a().m5160c().mo5137a(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        StepTrackerViewModel stepTrackerViewModel = this.f7773c;
        if (stepTrackerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            stepTrackerViewModel = null;
        }
        stepTrackerViewModel.m5331a(new StepTrackerViewEvent.a(dialogTag));
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        StepTrackerViewModel stepTrackerViewModel = this.f7773c;
        if (stepTrackerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            stepTrackerViewModel = null;
        }
        stepTrackerViewModel.m5331a(new StepTrackerViewEvent.b(dialogTag));
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        C4967c c4967c = m5199a().f7574c;
        Intrinsics.checkNotNullExpressionValue(c4967c, "binding.successView");
        this.f7775e = c4967c;
        C4966b c4966b = m5199a().f7573b;
        Intrinsics.checkNotNullExpressionValue(c4966b, "binding.loadingView");
        this.f7776f = c4966b;
        SavedStateViewModelFactory<StepTrackerViewModel> savedStateViewModelFactoryM5216c = m5216c();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        StepTrackerViewModel stepTrackerViewModel = (StepTrackerViewModel) savedStateViewModelFactoryM5216c.create(fragmentActivityRequireActivity);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, stepTrackerViewModel.m5333d(), new C5021c(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner2, stepTrackerViewModel.m5332b(), new C5022d(this));
        this.f7773c = stepTrackerViewModel;
    }
}
