package com.yoti.mobile.android.commons.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraLifecycle.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/lifecycle/CameraLifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "", "startCamera", "()V", "stopCamera", "", "disableAutoStart", "Z", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "host", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "commons-camerax_release"}, m5599k = 1, m5600mv = {1, 1, 15}, m5601pn = "", m5602xi = 0, m5603xs = "")
public final class CameraLifecycle implements LifecycleOwner {

    /* JADX INFO: renamed from: a */
    private final LifecycleRegistry f6520a;

    /* JADX INFO: renamed from: b */
    private final boolean f6521b;

    public CameraLifecycle(LifecycleOwner host, boolean z) {
        Intrinsics.checkParameterIsNotNull(host, "host");
        this.f6521b = z;
        this.f6520a = new LifecycleRegistry(this);
        host.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.yoti.mobile.android.commons.lifecycle.CameraLifecycle.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Intrinsics.checkParameterIsNotNull(lifecycleOwner, "<anonymous parameter 0>");
                Intrinsics.checkParameterIsNotNull(event, "event");
                if (CameraLifecycle.this.f6520a.getState() == Lifecycle.State.CREATED && event == Lifecycle.Event.ON_PAUSE) {
                    return;
                }
                if (CameraLifecycle.this.f6521b && (event == Lifecycle.Event.ON_START || event == Lifecycle.Event.ON_RESUME)) {
                    return;
                }
                CameraLifecycle.this.f6520a.handleLifecycleEvent(event);
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f6520a;
    }

    public final void startCamera() {
        if (this.f6520a.getState().isAtLeast(Lifecycle.State.CREATED)) {
            this.f6520a.setCurrentState(Lifecycle.State.RESUMED);
        }
    }

    public final void stopCamera() {
        this.f6520a.setCurrentState(Lifecycle.State.CREATED);
    }

    public /* synthetic */ CameraLifecycle(LifecycleOwner lifecycleOwner, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner, (i & 2) != 0 ? false : z);
    }
}
