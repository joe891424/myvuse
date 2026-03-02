package com.yoti.mobile.android.commons.navigation;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: FragmentHostActivityNavigationCoordinator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b-\u0010\u001aJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00168D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001b8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R$\u0010)\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00058\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/FragmentHostActivityNavigationCoordinator;", "Lcom/yoti/mobile/android/commons/navigation/INavigationCoordinator;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "fragmentContainerId", "", "bind", "(Landroidx/fragment/app/FragmentActivity;I)V", "Landroidx/fragment/app/Fragment;", "fragment", "", HeaderParameterNames.AUTHENTICATION_TAG, "show", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)I", "getCurrent", "()Landroidx/fragment/app/Fragment;", "find", "(Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "Landroid/content/Intent;", "resultIntent", "Landroid/app/Activity;", "finishWithResult", "(Landroid/content/Intent;)Landroid/app/Activity;", "clear", "()V", "Landroidx/fragment/app/FragmentManager;", "b", "Landroidx/fragment/app/FragmentManager;", "_fragmentManager", "getActivity", "()Landroid/app/Activity;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<set-?>", "a", "I", "getContainerViewId", "()I", "containerViewId", "c", "Landroid/app/Activity;", "_activity", "<init>", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class FragmentHostActivityNavigationCoordinator implements INavigationCoordinator, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private int containerViewId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private FragmentManager _fragmentManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private Activity _activity;

    public static /* synthetic */ int show$default(FragmentHostActivityNavigationCoordinator fragmentHostActivityNavigationCoordinator, Fragment fragment, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return fragmentHostActivityNavigationCoordinator.show(fragment, str);
    }

    public void bind(FragmentActivity activity, int fragmentContainerId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this._activity = activity;
        this.containerViewId = fragmentContainerId;
        this._fragmentManager = activity.getSupportFragmentManager();
        activity.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void clear() {
        this._activity = null;
        this._fragmentManager = null;
    }

    protected final Fragment find(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return getFragmentManager().findFragmentByTag(tag);
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

    protected final int getContainerViewId() {
        return this.containerViewId;
    }

    protected final Fragment getCurrent() {
        return getFragmentManager().findFragmentById(this.containerViewId);
    }

    protected final FragmentManager getFragmentManager() {
        FragmentManager fragmentManager = this._fragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalArgumentException("No fragment manager - coordinator may not be bound".toString());
    }

    protected final int show(Fragment fragment, String tag) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return getFragmentManager().beginTransaction().replace(this.containerViewId, fragment, tag).commit();
    }
}
