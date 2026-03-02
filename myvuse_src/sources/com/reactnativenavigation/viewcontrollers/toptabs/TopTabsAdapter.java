package com.reactnativenavigation.viewcontrollers.toptabs;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TopTabsAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private int currentPage = 0;
    private List<ViewController<?>> tabs;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    public TopTabsAdapter(List<ViewController<?>> list) {
        this.tabs = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return getTabOptions(i).topTabOptions.title.get("");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.tabs.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return this.tabs.get(i).getView();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.tabs.get(this.currentPage).onViewDisappear();
        this.tabs.get(i).onViewWillAppear();
        this.currentPage = i;
    }

    private Options getTabOptions(int i) {
        return this.tabs.get(i).options;
    }
}
