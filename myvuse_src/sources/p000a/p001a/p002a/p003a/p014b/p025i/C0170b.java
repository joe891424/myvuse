package p000a.p001a.p002a.p003a.p014b.p025i;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.b.i.b */
/* JADX INFO: loaded from: classes.dex */
public class C0170b {

    /* JADX INFO: renamed from: a.a.a.a.b.i.b$a */
    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f1473a;

        public a(String str) {
            this.f1473a = str;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, this.f1473a));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m952a(Context context, String str, ViewGroup viewGroup, int i) {
        if (viewGroup != null) {
            TextView textView = new TextView(context);
            textView.setVisibility(0);
            textView.setHeight(0);
            textView.setWidth(0);
            textView.setText(str);
            viewGroup.addView(textView);
            ViewCompat.setLabelFor(textView, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m953a(View view, String str) {
        if (C0048h.m305b(str)) {
            return;
        }
        view.setBackgroundColor(Color.parseColor(str));
    }

    /* JADX INFO: renamed from: a */
    public static void m954a(CompoundButton compoundButton, int i, int i2) {
        compoundButton.setButtonTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{i, i2}));
    }

    /* JADX INFO: renamed from: a */
    public static void m955a(TextView textView, String str) {
        ViewCompat.setAccessibilityDelegate(textView, new a(str));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m957a(int i, KeyEvent keyEvent) {
        return i == 4 && keyEvent.getAction() == 1;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m958a(Context context) {
        if (!((AccessibilityManager) context.getSystemService("accessibility")).isEnabled()) {
            return false;
        }
        OTLogger.m2743a(3, "OneTrust", "isAccessibilityEnabled - true");
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m959a(Context context, String str) {
        if (context != null) {
            return true;
        }
        OTLogger.m2743a(6, "OneTrust", "Context is null - " + str);
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static void m956a(final FragmentActivity fragmentActivity, final AppCompatDialogFragment appCompatDialogFragment, final String str) {
        try {
            appCompatDialogFragment.show(fragmentActivity.getSupportFragmentManager(), str);
        } catch (IllegalStateException e) {
            OTLogger.m2743a(3, "OneTrust", "Activity in illegal state to add a Banner fragment " + e);
            if (fragmentActivity == null) {
                OTLogger.m2743a(6, "OneTrust", "showUIOnForeground : Activity is null - " + str);
            } else if (fragmentActivity.isDestroyed()) {
                OTLogger.m2743a(6, "OneTrust", "showUIOnForeground : Activity is destroyed - " + str);
            } else {
                fragmentActivity.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.onetrust.otpublishers.headless.UI.mobiledatautils.OTFragmentUtils$1
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
                            appCompatDialogFragment.show(fragmentActivity.getSupportFragmentManager(), str);
                            fragmentActivity.getLifecycle().removeObserver(this);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m960a(Context context, BottomSheetDialog bottomSheetDialog) {
        int i;
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(C3896R.id.design_bottom_sheet);
        if (frameLayout != null) {
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (context == null) {
                i = 0;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                i = displayMetrics.heightPixels;
            }
            if (layoutParams != null) {
                layoutParams.height = (i * 2) / 3;
            }
            frameLayout.setLayoutParams(layoutParams);
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setPeekHeight(frameLayout.getMeasuredHeight());
        }
    }
}
