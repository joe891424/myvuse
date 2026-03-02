package com.yoti.mobile.android.commons.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavHostActivityNavigationCoordinator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\u0014J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00158D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00108D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/NavHostActivityNavigationCoordinator;", "Lcom/yoti/mobile/android/commons/navigation/INavigationCoordinator;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/activity/ComponentActivity;", "activity", "", "navHostId", "", "bind", "(Landroidx/activity/ComponentActivity;I)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerNavigationListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Intent;", "resultIntent", "Landroid/app/Activity;", "finishWithResult", "(Landroid/content/Intent;)Landroid/app/Activity;", "clear", "()V", "Landroidx/navigation/NavController;", "a", "Landroidx/navigation/NavController;", "_navController", "b", "Landroid/app/Activity;", "_activity", "getNavController", "()Landroidx/navigation/NavController;", "navController", "getActivity", "()Landroid/app/Activity;", "<init>", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class NavHostActivityNavigationCoordinator implements INavigationCoordinator, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private NavController _navController;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private Activity _activity;

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.NavHostActivityNavigationCoordinator$a */
    /* JADX INFO: compiled from: NavHostActivityNavigationCoordinator.kt */
    static final class C4576a implements NavController.OnDestinationChangedListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Function1 f6538a;

        C4576a(Function1 function1) {
            this.f6538a = function1;
        }

        @Override // androidx.navigation.NavController.OnDestinationChangedListener
        public final void onDestinationChanged(NavController navController, NavDestination destination, Bundle bundle) {
            Intrinsics.checkNotNullParameter(navController, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(destination, "destination");
            this.f6538a.invoke(Integer.valueOf(destination.getId()));
        }
    }

    public void bind(ComponentActivity activity, int navHostId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this._activity = activity;
        this._navController = ActivityKt.findNavController(activity, navHostId);
        activity.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void clear() {
        this._navController = null;
        this._activity = null;
    }

    protected final Activity finishWithResult(Intent resultIntent) {
        Activity activity = getActivity();
        activity.setResult(-1, resultIntent);
        activity.finish();
        return activity;
    }

    protected final Activity getActivity() {
        Activity activity = this._activity;
        if (activity != null) {
            return activity;
        }
        throw new IllegalArgumentException("No activity - coordinator may not be bound".toString());
    }

    protected final NavController getNavController() {
        NavController navController = this._navController;
        if (navController != null) {
            return navController;
        }
        throw new IllegalArgumentException("No nav controller - coordinator may not be bound".toString());
    }

    public final void registerNavigationListener(Function1<? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getNavController().addOnDestinationChangedListener(new C4576a(listener));
    }
}
