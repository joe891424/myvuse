package com.reactnativenavigation.views.stack.topbar.titlebar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.utils.ViewUtils;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonBar.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0006J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0006H\u0016J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006("}, m5598d2 = {"Lcom/reactnativenavigation/views/stack/topbar/titlebar/ButtonBar;", "Landroidx/appcompat/widget/Toolbar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buttonCount", "", "getButtonCount", "()I", "shouldAnimate", "", "getShouldAnimate", "()Z", "setShouldAnimate", "(Z)V", "addButton", "Landroid/view/MenuItem;", "menuItem", "intId", "order", "styledText", "Landroid/text/SpannableString;", "clearBackButton", "", "clearButtons", "containsButton", "getButton", FirebaseAnalytics.Param.INDEX, "onViewAdded", "child", "Landroid/view/View;", "removeButton", "buttonId", "setBackButton", "button", "Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonController;", "setLayoutDirection", ViewProps.LAYOUT_DIRECTION, "setOverflowButtonColor", "color", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ButtonBar extends Toolbar {
    private boolean shouldAnimate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonBar(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        super.setContentInsetsAbsolute(0, 0);
        setContentInsetStartWithNavigation(0);
    }

    public final boolean getShouldAnimate() {
        return this.shouldAnimate;
    }

    public final void setShouldAnimate(boolean z) {
        this.shouldAnimate = z;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onViewAdded(child);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLayoutDirection$lambda$0(int i, ActionMenuView buttonsContainer) {
        Intrinsics.checkNotNullParameter(buttonsContainer, "buttonsContainer");
        buttonsContainer.setLayoutDirection(i);
    }

    @Override // android.view.View
    public void setLayoutDirection(final int layoutDirection) {
        ObjectUtils.perform(ViewUtils.findChildByClass(this, ActionMenuView.class), new Functions.Func1() { // from class: com.reactnativenavigation.views.stack.topbar.titlebar.ButtonBar$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ButtonBar.setLayoutDirection$lambda$0(layoutDirection, (ActionMenuView) obj);
            }
        });
        super.setLayoutDirection(layoutDirection);
    }

    public final int getButtonCount() {
        return getMenu().size();
    }

    public final MenuItem addButton(int menuItem, int intId, int order, SpannableString styledText) {
        Intrinsics.checkNotNullParameter(styledText, "styledText");
        if (this.shouldAnimate) {
            TransitionManager.beginDelayedTransition(this, new AutoTransition());
        }
        Menu menu = getMenu();
        if (menu != null) {
            return menu.add(menuItem, intId, order, styledText);
        }
        return null;
    }

    public final void removeButton(int buttonId) {
        if (this.shouldAnimate) {
            TransitionManager.beginDelayedTransition(this, new AutoTransition());
        }
        getMenu().removeItem(buttonId);
    }

    public void clearButtons() {
        if (this.shouldAnimate) {
            TransitionManager.beginDelayedTransition(this, new AutoTransition());
        }
        clearBackButton();
        if (getMenu().size() > 0) {
            getMenu().clear();
        }
    }

    public final MenuItem getButton(int index) {
        MenuItem item = getMenu().getItem(index);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        return item;
    }

    public final boolean containsButton(MenuItem menuItem, int order) {
        return (menuItem == null || getMenu().findItem(menuItem.getItemId()) == null || menuItem.getOrder() != order) ? false : true;
    }

    public final void setBackButton(ButtonController button) {
        Intrinsics.checkNotNullParameter(button, "button");
        button.applyNavigationIcon(this);
    }

    public final void clearBackButton() {
        setNavigationIcon((Drawable) null);
    }

    public final void setOverflowButtonColor(int color) {
        Drawable overflowIcon;
        ActionMenuView actionMenuView = (ActionMenuView) ViewUtils.findChildByClass(this, ActionMenuView.class);
        if (actionMenuView == null || (overflowIcon = actionMenuView.getOverflowIcon()) == null) {
            return;
        }
        overflowIcon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
    }
}
