package com.reactnativenavigation.views.toptabs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.reactnativenavigation.options.ButtonOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController;
import com.reactnativenavigation.viewcontrollers.toptabs.TopTabsAdapter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.component.Component;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TopTabsViewPager extends ViewPager implements Component, ButtonController.OnClickListener {
    private static final int OFFSCREEN_PAGE_LIMIT = 99;
    private List<ViewController<?>> tabs;

    public void applyOptions(Options options) {
    }

    public TopTabsViewPager(Context context, List<ViewController<?>> list, TopTabsAdapter topTabsAdapter) {
        super(context);
        this.tabs = list;
        initTabs(topTabsAdapter);
    }

    private void initTabs(TopTabsAdapter topTabsAdapter) {
        setOffscreenPageLimit(99);
        Iterator<ViewController<?>> it2 = this.tabs.iterator();
        while (it2.hasNext()) {
            addView(it2.next().getView(), new ViewGroup.LayoutParams(-1, -1));
        }
        setAdapter(topTabsAdapter);
        addOnPageChangeListener(topTabsAdapter);
    }

    @Override // com.reactnativenavigation.views.component.Renderable
    public boolean isRendered() {
        return this.tabs.size() != 0 && areAllTabsRendered();
    }

    private boolean areAllTabsRendered() {
        Iterator<ViewController<?>> it2 = this.tabs.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isRendered()) {
                return false;
            }
        }
        return true;
    }

    public void switchToTab(int i) {
        setCurrentItem(i);
    }

    @Override // com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController.OnClickListener
    public void onPress(ButtonOptions buttonOptions) {
        ((IReactView) this.tabs.get(getCurrentItem()).getView()).sendOnNavigationButtonPressed(buttonOptions.f4200id);
    }

    public void destroy() {
        Iterator<ViewController<?>> it2 = this.tabs.iterator();
        while (it2.hasNext()) {
            it2.next().destroy();
        }
    }

    public boolean isCurrentView(View view) {
        Iterator<ViewController<?>> it2 = this.tabs.iterator();
        while (it2.hasNext()) {
            if (it2.next().getView() == view) {
                return true;
            }
        }
        return false;
    }
}
