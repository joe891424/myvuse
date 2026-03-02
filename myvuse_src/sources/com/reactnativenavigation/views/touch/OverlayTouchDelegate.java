package com.reactnativenavigation.views.touch;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.react.ReactView;
import com.reactnativenavigation.utils.MotionEventKt;
import com.reactnativenavigation.views.component.ComponentLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverlayTouchDelegate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/reactnativenavigation/views/touch/OverlayTouchDelegate;", "", "component", "Lcom/reactnativenavigation/views/component/ComponentLayout;", "reactView", "Lcom/reactnativenavigation/react/ReactView;", "(Lcom/reactnativenavigation/views/component/ComponentLayout;Lcom/reactnativenavigation/react/ReactView;)V", "interceptTouchOutside", "Lcom/reactnativenavigation/options/params/Bool;", "getInterceptTouchOutside", "()Lcom/reactnativenavigation/options/params/Bool;", "setInterceptTouchOutside", "(Lcom/reactnativenavigation/options/params/Bool;)V", "handleDown", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class OverlayTouchDelegate {
    private final ComponentLayout component;
    private Bool interceptTouchOutside;
    private final ReactView reactView;

    public OverlayTouchDelegate(ComponentLayout component, ReactView reactView) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(reactView, "reactView");
        this.component = component;
        this.reactView = reactView;
        this.interceptTouchOutside = new NullBool();
    }

    public final Bool getInterceptTouchOutside() {
        return this.interceptTouchOutside;
    }

    public final void setInterceptTouchOutside(Bool bool) {
        Intrinsics.checkNotNullParameter(bool, "<set-?>");
        this.interceptTouchOutside = bool;
    }

    public final boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z = this.interceptTouchOutside.hasValue() && event.getActionMasked() == 0;
        if (z) {
            return handleDown(event);
        }
        if (z) {
            throw new NoWhenBranchMatchedException();
        }
        return this.component.superOnInterceptTouchEvent(event);
    }

    public boolean handleDown(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean zCoordinatesInsideView = MotionEventKt.coordinatesInsideView(event, this.reactView.getChildAt(0));
        if (zCoordinatesInsideView) {
            return this.component.superOnInterceptTouchEvent(event);
        }
        if (zCoordinatesInsideView) {
            throw new NoWhenBranchMatchedException();
        }
        return this.interceptTouchOutside.isFalse();
    }
}
