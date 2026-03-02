package com.reactnativenavigation.views.sidemenu;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.SideMenuOptions;
import com.reactnativenavigation.utils.CoordinatorLayoutUtils;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.BehaviourAdapter;
import com.reactnativenavigation.views.BehaviourDelegate;

/* JADX INFO: loaded from: classes6.dex */
public class SideMenuRoot extends CoordinatorLayout {
    private SideMenu sideMenu;

    static /* synthetic */ WindowInsetsCompat lambda$enableDrawingBehindStatusBar$0(View view, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }

    public SideMenuRoot(Context context) {
        super(context);
    }

    public void addSideMenu(SideMenu sideMenu, BehaviourAdapter behaviourAdapter) {
        this.sideMenu = sideMenu;
        enableDrawingBehindStatusBar();
        addView(sideMenu, CoordinatorLayoutUtils.matchParentWithBehaviour(new BehaviourDelegate(behaviourAdapter)));
    }

    public boolean isDrawerOpen(int i) {
        return this.sideMenu.isDrawerOpen(i);
    }

    public void setCenter(ViewController viewController) {
        this.sideMenu.addView(viewController.getView());
    }

    public void setLeft(ViewController viewController, Options options) {
        this.sideMenu.addView(viewController.getView(), createLayoutParams(options.sideMenuRootOptions.left, 3));
    }

    public void setRight(ViewController viewController, Options options) {
        this.sideMenu.addView(viewController.getView(), createLayoutParams(options.sideMenuRootOptions.right, 5));
    }

    public boolean isSideMenu(View view) {
        return this.sideMenu == view;
    }

    private DrawerLayout.LayoutParams createLayoutParams(SideMenuOptions sideMenuOptions, int i) {
        return new DrawerLayout.LayoutParams(getWidth(sideMenuOptions), getHeight(sideMenuOptions), i);
    }

    private int getWidth(SideMenuOptions sideMenuOptions) {
        if (sideMenuOptions.width.hasValue()) {
            return (int) TypedValue.applyDimension(1, sideMenuOptions.width.get().intValue(), Resources.getSystem().getDisplayMetrics());
        }
        return -1;
    }

    private int getHeight(SideMenuOptions sideMenuOptions) {
        if (sideMenuOptions.height.hasValue()) {
            return (int) TypedValue.applyDimension(1, sideMenuOptions.height.get().intValue(), Resources.getSystem().getDisplayMetrics());
        }
        return -1;
    }

    private void enableDrawingBehindStatusBar() {
        this.sideMenu.setFitsSystemWindows(true);
        ViewCompat.setOnApplyWindowInsetsListener(this.sideMenu, new OnApplyWindowInsetsListener() { // from class: com.reactnativenavigation.views.sidemenu.SideMenuRoot$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return SideMenuRoot.lambda$enableDrawingBehindStatusBar$0(view, windowInsetsCompat);
            }
        });
    }

    public SideMenu getSideMenu() {
        return this.sideMenu;
    }
}
