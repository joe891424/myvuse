package com.yoti.mobile.android.commons.navigation;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentNavigationCoordinator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/FragmentNavigationCoordinator;", "Lcom/yoti/mobile/android/commons/navigation/INavigationCoordinator;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/fragment/app/Fragment;", "fragment", "", "fragmentContainerId", "", "bind", "(Landroidx/fragment/app/Fragment;I)V", "Landroid/content/Intent;", "intent", "requestCode", "navigateForResult", "(Landroid/content/Intent;I)V", "clear", "()V", "getFragment", "()Landroidx/fragment/app/Fragment;", "a", "Landroidx/fragment/app/Fragment;", "_fragment", "<init>", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class FragmentNavigationCoordinator implements INavigationCoordinator, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Fragment _fragment;

    public void bind(Fragment fragment, int fragmentContainerId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this._fragment = fragment;
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        viewLifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void clear() {
        this._fragment = null;
    }

    protected final Fragment getFragment() {
        Fragment fragment = this._fragment;
        if (fragment != null) {
            return fragment;
        }
        throw new IllegalArgumentException("No fragment - coordinator may not be bound".toString());
    }

    protected final void navigateForResult(Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        getFragment().startActivityForResult(intent, requestCode);
    }
}
