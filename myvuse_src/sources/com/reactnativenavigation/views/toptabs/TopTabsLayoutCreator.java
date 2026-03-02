package com.reactnativenavigation.views.toptabs;

import android.content.Context;
import com.reactnativenavigation.viewcontrollers.toptabs.TopTabsAdapter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TopTabsLayoutCreator {
    private Context context;
    private List<ViewController<?>> tabs;

    public TopTabsLayoutCreator(Context context, List<ViewController<?>> list) {
        this.context = context;
        this.tabs = list;
    }

    public TopTabsViewPager create() {
        return new TopTabsViewPager(this.context, this.tabs, new TopTabsAdapter(this.tabs));
    }
}
