package com.bat.myvuse.mobile;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bat.sdk.BatSdk;
import com.bat.sdk.domain.Configuration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkLifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/bat/myvuse/mobile/SdkLifecycle;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V", "startSdk", "", "stopSdk", "app_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class SdkLifecycle implements LifecycleObserver {
    private final Context context;
    private final Lifecycle lifecycle;

    @Inject
    public SdkLifecycle(Context context, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.context = context;
        this.lifecycle = lifecycle;
        if (lifecycle.getState().isAtLeast(Lifecycle.State.CREATED)) {
            startSdk();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void stopSdk() {
        BatSdk.INSTANCE.dispose();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void startSdk() {
        BatSdk.INSTANCE.initialize(this.context, new Configuration(true, false));
    }
}
