package com.facebook.react.flipper;

import android.content.Context;
import com.facebook.react.ReactInstanceManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeFlipper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, m5598d2 = {"Lcom/facebook/react/flipper/ReactNativeFlipper;", "", "()V", "initializeFlipper", "", "context", "Landroid/content/Context;", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "flipper-integration_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class ReactNativeFlipper {
    public static final ReactNativeFlipper INSTANCE = new ReactNativeFlipper();

    @JvmStatic
    public static final void initializeFlipper(Context context, ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
    }

    private ReactNativeFlipper() {
    }
}
