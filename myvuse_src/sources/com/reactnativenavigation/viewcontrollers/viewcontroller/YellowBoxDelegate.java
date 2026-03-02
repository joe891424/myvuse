package com.reactnativenavigation.viewcontrollers.viewcontroller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.reactnativenavigation.utils.ContextKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YellowBoxDelegate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001b\u001a\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00148G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/viewcontroller/YellowBoxDelegate;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "yellowBoxHelper", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/YellowBoxHelper;", "(Landroid/content/Context;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/YellowBoxHelper;)V", "isDestroyed", "", "<set-?>", "Landroid/view/ViewGroup;", "parent", "getParent", "()Landroid/view/ViewGroup;", "tempViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "yellowBoxViews", "yellowBoxes", "", "getYellowBoxes", "()Ljava/util/List;", "destroy", "", "onChildViewAdded", "child", "onYellowBoxAdded", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class YellowBoxDelegate {
    private final Context context;
    private boolean isDestroyed;
    private ViewGroup parent;
    private final ArrayList<View> tempViews;
    private final YellowBoxHelper yellowBoxHelper;
    private final ArrayList<View> yellowBoxViews;

    public YellowBoxDelegate(Context context, YellowBoxHelper yellowBoxHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(yellowBoxHelper, "yellowBoxHelper");
        this.context = context;
        this.yellowBoxHelper = yellowBoxHelper;
        this.yellowBoxViews = new ArrayList<>();
        this.tempViews = new ArrayList<>();
    }

    public /* synthetic */ YellowBoxDelegate(Context context, YellowBoxHelper yellowBoxHelper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new YellowBoxHelper() : yellowBoxHelper);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YellowBoxDelegate(Context context) {
        this(context, new YellowBoxHelper());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final ViewGroup getParent() {
        return this.parent;
    }

    public final List<View> getYellowBoxes() {
        return this.yellowBoxViews;
    }

    public void onChildViewAdded(View parent, View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (ContextKt.isDebug(this.context)) {
            onYellowBoxAdded(parent, child);
        }
    }

    public final void onYellowBoxAdded(View parent, View child) {
        if (this.isDestroyed) {
            return;
        }
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        this.parent = viewGroup;
        if (this.yellowBoxHelper.isYellowBox(parent, child) || !(this.isDestroyed || CollectionsKt.contains(this.tempViews, child))) {
            int childCount = viewGroup.getChildCount();
            for (int i = 1; i < childCount; i++) {
                this.yellowBoxViews.add(ViewGroupKt.get(viewGroup, i));
                viewGroup.removeView(ViewGroupKt.get(viewGroup, i));
                View view = new View(this.context);
                this.tempViews.add(view);
                viewGroup.addView(view, i);
            }
        }
    }

    public final void destroy() {
        this.isDestroyed = true;
        if (this.yellowBoxViews.isEmpty()) {
            return;
        }
        for (View view : this.yellowBoxViews) {
            ViewGroup viewGroup = this.parent;
            if (viewGroup != null) {
                viewGroup.addView(view);
            }
        }
    }
}
