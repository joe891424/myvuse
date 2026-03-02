package com.reactnativenavigation.utils;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.reactnativenavigation.C3967R;

/* JADX INFO: loaded from: classes6.dex */
public class CoordinatorLayoutUtils {
    public static CoordinatorLayout.LayoutParams matchParentLP() {
        return new CoordinatorLayout.LayoutParams(-1, -1);
    }

    public static CoordinatorLayout.LayoutParams matchParentWithBehaviour(CoordinatorLayout.Behavior<?> behavior) {
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(behavior);
        return layoutParams;
    }

    public static void updateBottomMargin(View view, int i) {
        ((CoordinatorLayout.LayoutParams) view.getLayoutParams()).bottomMargin = i + ((Integer) ViewTags.get(view, C3967R.id.fab_bottom_margin, 0)).intValue();
    }
}
