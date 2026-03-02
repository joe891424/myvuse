package com.yoti.mobile.android.commons.navigation;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: NestedFragmentNavigationCoordinator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010\u0018J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0004¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0004\u001a\u00020\u00038D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000fR\u0016\u0010#\u001a\u00020\u001c8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R$\u0010)\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00058\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/NestedFragmentNavigationCoordinator;", "Lcom/yoti/mobile/android/commons/navigation/INavigationCoordinator;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/fragment/app/Fragment;", "fragment", "", "fragmentContainerId", "", "bind", "(Landroidx/fragment/app/Fragment;I)V", "", HeaderParameterNames.AUTHENTICATION_TAG, "show", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)I", "getCurrent", "()Landroidx/fragment/app/Fragment;", "find", "(Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "Landroid/content/Intent;", "intent", "requestCode", "navigateForResult", "(Landroid/content/Intent;I)V", "clear", "()V", "c", "Landroidx/fragment/app/Fragment;", "_fragment", "Landroidx/fragment/app/FragmentManager;", "b", "Landroidx/fragment/app/FragmentManager;", "_fragmentManager", "getFragment", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<set-?>", "a", "I", "getContainerViewId", "()I", "containerViewId", "<init>", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class NestedFragmentNavigationCoordinator implements INavigationCoordinator, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private int containerViewId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private FragmentManager _fragmentManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private Fragment _fragment;

    public static /* synthetic */ int show$default(NestedFragmentNavigationCoordinator nestedFragmentNavigationCoordinator, Fragment fragment, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return nestedFragmentNavigationCoordinator.show(fragment, str);
    }

    public void bind(Fragment fragment, int fragmentContainerId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this._fragment = fragment;
        this.containerViewId = fragmentContainerId;
        this._fragmentManager = fragment.getChildFragmentManager();
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        viewLifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void clear() {
        this._fragment = null;
        this._fragmentManager = null;
    }

    protected final Fragment find(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return getFragmentManager().findFragmentByTag(tag);
    }

    protected final int getContainerViewId() {
        return this.containerViewId;
    }

    protected final Fragment getCurrent() {
        return getFragmentManager().findFragmentById(this.containerViewId);
    }

    protected final Fragment getFragment() {
        Fragment fragment = this._fragment;
        if (fragment != null) {
            return fragment;
        }
        throw new IllegalArgumentException("No fragment - coordinator may not be bound".toString());
    }

    protected final FragmentManager getFragmentManager() {
        FragmentManager fragmentManager = this._fragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalArgumentException("No child fragment manager - coordinator may not be bound".toString());
    }

    protected final void navigateForResult(Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        getFragment().startActivityForResult(intent, requestCode);
    }

    protected final int show(Fragment fragment, String tag) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return getFragmentManager().beginTransaction().replace(this.containerViewId, fragment, tag).commit();
    }
}
