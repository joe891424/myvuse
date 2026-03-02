package com.yoti.mobile.android.commons.navigation;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;
import com.yoti.mobile.android.commons.navigation.FlowObserverKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NavigationUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a?\u0010\u000f\u001a\u00020\u000e*\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u000f\u001a\u00020\u000e*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0014\u001a\u0019\u0010\u0017\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0017\u001a\u00020\u000e\"\f\b\u0000\u0010\u001b*\u00020\u0019*\u00020\u001a*\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u001c\u001a\u0019\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d*\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, m5598d2 = {"Landroidx/fragment/app/FragmentManager;", "", "navigationId", "Landroidx/fragment/app/Fragment;", "getNavigationCurrentVisibleFragment", "(Landroidx/fragment/app/FragmentManager;I)Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavController;", "resId", "Landroid/os/Bundle;", "args", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navExtras", "", "navigateSafe", "(Landroidx/navigation/NavController;ILandroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavDirections;", "navDirection", "navigatorExtras", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDirections;Landroidx/navigation/Navigator$Extras;)V", "Lcom/yoti/mobile/android/commons/navigation/NavigationViewModel;", "viewModel", "bindNavigationViewModel", "(Landroidx/fragment/app/Fragment;Lcom/yoti/mobile/android/commons/navigation/NavigationViewModel;)V", "Lcom/yoti/mobile/android/commons/navigation/NavigationCoordinatorHost;", "Landroidx/lifecycle/LifecycleOwner;", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/yoti/mobile/android/commons/navigation/NavigationCoordinatorHost;Lcom/yoti/mobile/android/commons/navigation/NavigationViewModel;)V", "Lkotlin/sequences/Sequence;", "Lcom/yoti/mobile/android/commons/navigation/INavigationCoordinator;", "a", "(Landroidx/fragment/app/Fragment;)Lkotlin/sequences/Sequence;", "commons-navigation_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class NavigationUtilsKt {

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.NavigationUtilsKt$a */
    /* JADX INFO: compiled from: NavigationUtils.kt */
    @DebugMetadata(m5607c = "com.yoti.mobile.android.commons.navigation.NavigationUtilsKt$bindNavigationViewModel$1", m5608f = "NavigationUtils.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C4577a extends SuspendLambda implements Function2<NavigationEvent, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        private /* synthetic */ Object f6539a;

        /* JADX INFO: renamed from: b */
        int f6540b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ Fragment f6541c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4577a(Fragment fragment, Continuation continuation) {
            super(2, continuation);
            this.f6541c = fragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            C4577a c4577a = new C4577a(this.f6541c, completion);
            c4577a.f6539a = obj;
            return c4577a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NavigationEvent navigationEvent, Continuation<? super Unit> continuation) {
            return ((C4577a) create(navigationEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6540b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NavigationEvent navigationEvent = (NavigationEvent) this.f6539a;
            Iterator it2 = NavigationUtilsKt.m4683a(this.f6541c).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (Boxing.boxBoolean(((INavigationCoordinator) next).onNavigationEvent(navigationEvent)).booleanValue()) {
                    break;
                }
            }
            if (((INavigationCoordinator) next) != null) {
                return Unit.INSTANCE;
            }
            throw new IllegalStateException(("No coordinator host found to handle event " + navigationEvent + " from " + this.f6541c.getClass()).toString());
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.NavigationUtilsKt$b */
    /* JADX INFO: compiled from: NavigationUtils.kt */
    @DebugMetadata(m5607c = "com.yoti.mobile.android.commons.navigation.NavigationUtilsKt$bindNavigationViewModel$2", m5608f = "NavigationUtils.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C4578b extends SuspendLambda implements Function2<NavigationEvent, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        private /* synthetic */ Object f6542a;

        /* JADX INFO: renamed from: b */
        int f6543b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ NavigationCoordinatorHost f6544c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4578b(NavigationCoordinatorHost navigationCoordinatorHost, Continuation continuation) {
            super(2, continuation);
            this.f6544c = navigationCoordinatorHost;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            C4578b c4578b = new C4578b(this.f6544c, completion);
            c4578b.f6542a = obj;
            return c4578b;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NavigationEvent navigationEvent, Continuation<? super Unit> continuation) {
            return ((C4578b) create(navigationEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6543b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.f6544c.getCoordinator().onNavigationEvent((NavigationEvent) this.f6542a);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.NavigationUtilsKt$c */
    /* JADX INFO: compiled from: NavigationUtils.kt */
    static final class C4579c extends Lambda implements Function1<Fragment, Fragment> {

        /* JADX INFO: renamed from: a */
        public static final C4579c f6545a = new C4579c();

        C4579c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke(Fragment it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            return it2.getParentFragment();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.NavigationUtilsKt$d */
    /* JADX INFO: compiled from: NavigationUtils.kt */
    static final class C4580d extends Lambda implements Function1<Object, INavigationCoordinator> {

        /* JADX INFO: renamed from: a */
        public static final C4580d f6546a = new C4580d();

        C4580d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final INavigationCoordinator invoke(Object obj) {
            if (!(obj instanceof NavigationCoordinatorHost)) {
                obj = null;
            }
            NavigationCoordinatorHost navigationCoordinatorHost = (NavigationCoordinatorHost) obj;
            if (navigationCoordinatorHost != null) {
                return navigationCoordinatorHost.getCoordinator();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static final Sequence<INavigationCoordinator> m4683a(Fragment fragment) {
        return SequencesKt.mapNotNull(SequencesKt.plus((Sequence<? extends FragmentActivity>) SequencesKt.generateSequence(fragment, C4579c.f6545a), fragment.getActivity()), C4580d.f6546a);
    }

    public static final void bindNavigationViewModel(Fragment bindNavigationViewModel, NavigationViewModel viewModel) {
        Intrinsics.checkNotNullParameter(bindNavigationViewModel, "$this$bindNavigationViewModel");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Flow flowOnEach = FlowKt.onEach(viewModel.getNavigationEvents(), new C4577a(bindNavigationViewModel, null));
        LifecycleOwner viewLifecycleOwner = bindNavigationViewModel.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        new FlowObserver(viewLifecycleOwner, flowOnEach, new FlowObserverKt.C45751(null));
    }

    public static final Fragment getNavigationCurrentVisibleFragment(FragmentManager getNavigationCurrentVisibleFragment, int i) {
        FragmentManager childFragmentManager;
        List<Fragment> fragments;
        Intrinsics.checkNotNullParameter(getNavigationCurrentVisibleFragment, "$this$getNavigationCurrentVisibleFragment");
        Fragment fragmentFindFragmentById = getNavigationCurrentVisibleFragment.findFragmentById(i);
        if (fragmentFindFragmentById == null || (childFragmentManager = fragmentFindFragmentById.getChildFragmentManager()) == null || (fragments = childFragmentManager.getFragments()) == null) {
            return null;
        }
        if (fragments.size() <= 0) {
            fragments = null;
        }
        if (fragments != null) {
            return fragments.get(0);
        }
        return null;
    }

    public static final void navigateSafe(NavController navigateSafe, int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navigateSafe, "$this$navigateSafe");
        NavDestination currentDestination = navigateSafe.getCurrentDestination();
        if (currentDestination == null || currentDestination.getAction(i) == null) {
            return;
        }
        if (navigateSafe instanceof NavController) {
            NavigationController.navigate(navigateSafe, i, bundle, navOptions, extras);
        } else {
            navigateSafe.navigate(i, bundle, navOptions, extras);
        }
    }

    public static /* synthetic */ void navigateSafe$default(NavController navController, int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        if ((i2 & 4) != 0) {
            navOptions = null;
        }
        if ((i2 & 8) != 0) {
            extras = null;
        }
        navigateSafe(navController, i, bundle, navOptions, extras);
    }

    public static /* synthetic */ void navigateSafe$default(NavController navController, NavDirections navDirections, Navigator.Extras extras, int i, Object obj) {
        if ((i & 2) != 0) {
            extras = null;
        }
        navigateSafe(navController, navDirections, extras);
    }

    public static final void navigateSafe(NavController navigateSafe, NavDirections navDirection, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navigateSafe, "$this$navigateSafe");
        Intrinsics.checkNotNullParameter(navDirection, "navDirection");
        NavDestination currentDestination = navigateSafe.getCurrentDestination();
        if (currentDestination == null || currentDestination.getAction(navDirection.getActionId()) == null) {
            return;
        }
        if (extras != null) {
            navigateSafe.navigate(navDirection, extras);
        } else {
            navigateSafe.navigate(navDirection);
        }
    }

    public static final <T extends NavigationCoordinatorHost & LifecycleOwner> void bindNavigationViewModel(T bindNavigationViewModel, NavigationViewModel viewModel) {
        Intrinsics.checkNotNullParameter(bindNavigationViewModel, "$this$bindNavigationViewModel");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        new FlowObserver(bindNavigationViewModel, FlowKt.onEach(viewModel.getNavigationEvents(), new C4578b(bindNavigationViewModel, null)), new FlowObserverKt.C45751(null));
    }
}
