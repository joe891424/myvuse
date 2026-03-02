package com.reactnativenavigation.react.modal;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.infer.annotation.Assertions;
import com.reactnativenavigation.utils.SystemUiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m5598d2 = {"MODAL_MANAGER_NAME", "", "getModalHostSize", "Landroid/graphics/Point;", "activity", "Landroid/app/Activity;", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ModalViewManagerKt {
    private static final String MODAL_MANAGER_NAME = "RNNModalViewManager";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Point getModalHostSize(Activity activity) {
        Point point = new Point();
        Point point2 = new Point();
        Point point3 = new Point();
        Object systemService = activity.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) Assertions.assertNotNull((WindowManager) systemService)).getDefaultDisplay();
        defaultDisplay.getCurrentSizeRange(point, point2);
        defaultDisplay.getSize(point3);
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowFullscreen});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int statusBarHeight = typedArrayObtainStyledAttributes.getBoolean(0, false) ? SystemUiUtils.getStatusBarHeight(activity) : 0;
        if (point3.x < point3.y) {
            return new Point(point.x, point2.y + statusBarHeight);
        }
        return new Point(point2.x, point.y + statusBarHeight);
    }
}
