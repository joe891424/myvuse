package com.reactnativenavigation.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.reactnativenavigation.utils.Functions;

/* JADX INFO: loaded from: classes6.dex */
public class UiUtils {
    private static final int DEFAULT_BOTTOM_TABS_HEIGHT = 56;
    private static final int DEFAULT_TOOLBAR_HEIGHT = 56;
    private static int bottomTabsHeight = -1;
    private static int topBarHeight = -1;

    public static <T extends View> void runOnPreDrawOnce(final T t, final Functions.Func1<T> func1) {
        if (t == null) {
            return;
        }
        runOnPreDrawOnce(t, new Runnable() { // from class: com.reactnativenavigation.utils.UiUtils$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                func1.run(t);
            }
        });
    }

    public static void runOnPreDrawOnce(final View view, final Runnable runnable) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.reactnativenavigation.utils.UiUtils.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                runnable.run();
                return true;
            }
        });
    }

    public static void doOnLayout(final View view, final Runnable runnable) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.reactnativenavigation.utils.UiUtils.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                runnable.run();
            }
        });
    }

    public static void runOnMeasured(final View view, final Runnable runnable) {
        if (view.getHeight() > 0 && view.getWidth() > 0) {
            runnable.run();
            return;
        }
        final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.reactnativenavigation.utils.UiUtils.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (view.getHeight() <= 0 || view.getWidth() <= 0) {
                    return;
                }
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                runnable.run();
            }
        };
        runOnDetach(view, new Runnable() { // from class: com.reactnativenavigation.utils.UiUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void runOnDetach(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: com.reactnativenavigation.utils.UiUtils.4
            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowAttached() {
            }

            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowDetached() {
                view.getViewTreeObserver().removeOnWindowAttachListener(this);
                runnable.run();
            }
        });
    }

    public static void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(runnable);
        }
    }

    public static float getWindowHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    public static float getWindowWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static int getTopBarHeightDp(Context context) {
        return (int) pxToDp(context, getTopBarHeight(context));
    }

    public static int getTopBarHeight(Context context) {
        int iDpToPx;
        int i = topBarHeight;
        if (i > 0) {
            return i;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("action_bar_size", "dimen", "android");
        if (identifier > 0) {
            iDpToPx = resources.getDimensionPixelSize(identifier);
        } else {
            iDpToPx = dpToPx(context, 56);
        }
        topBarHeight = iDpToPx;
        return iDpToPx;
    }

    public static int getBottomTabsHeight(Context context) {
        int iDpToPx;
        int i = bottomTabsHeight;
        if (i > 0) {
            return i;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("bottom_navigation_height", "dimen", context.getPackageName());
        if (identifier > 0) {
            iDpToPx = resources.getDimensionPixelSize(identifier);
        } else {
            iDpToPx = dpToPx(context, 56);
        }
        bottomTabsHeight = iDpToPx;
        return iDpToPx;
    }

    public static float dpToPx(Context context, float f) {
        return dpToPx(context.getResources().getDisplayMetrics(), f);
    }

    public static float dpToPx(DisplayMetrics displayMetrics, float f) {
        return f * (displayMetrics.densityDpi / 160.0f);
    }

    public static int dpToPx(Context context, int i) {
        return i <= 0 ? i : (int) (i * (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    public static float pxToDp(Context context, float f) {
        return f / (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static float dpToSp(Context context, float f) {
        return dpToPx(context, f) / context.getResources().getDisplayMetrics().density;
    }
}
