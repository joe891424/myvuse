package com.yoti.mobile.android.commons.navigation;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityNavigationCoordinator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00118D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/ActivityNavigationCoordinator;", "Lcom/yoti/mobile/android/commons/navigation/INavigationCoordinator;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/activity/ComponentActivity;", "activity", "", "bind", "(Landroidx/activity/ComponentActivity;)V", "Landroid/content/Intent;", "intent", "navigateTo", "(Landroid/content/Intent;)V", "", "requestCode", "navigateForResult", "(Landroid/content/Intent;I)V", "resultIntent", "Landroid/app/Activity;", "finishWithResult", "(Landroid/content/Intent;)Landroid/app/Activity;", "clear", "()V", "getActivity", "()Landroid/app/Activity;", "a", "Landroid/app/Activity;", "_activity", "<init>", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class ActivityNavigationCoordinator implements INavigationCoordinator, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Activity _activity;

    public void bind(ComponentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this._activity = activity;
        activity.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void clear() {
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

    protected final void navigateForResult(Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        getActivity().startActivityForResult(intent, requestCode);
    }

    protected final void navigateTo(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        getActivity().startActivity(intent);
    }
}
