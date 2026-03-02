package com.reactnativenavigation.views.toptabs;

import android.content.Context;
import android.graphics.Typeface;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.utils.ViewExtensionsKt;
import com.reactnativenavigation.views.stack.topbar.TopBar;

/* JADX INFO: loaded from: classes6.dex */
public class TopTabs extends TabLayout {
    private final TopTabsStyleHelper styleHelper;

    public TopTabs(Context context) {
        super(context);
        this.styleHelper = new TopTabsStyleHelper(this);
    }

    public void setFontFamily(int i, Typeface typeface) {
        this.styleHelper.setFontFamily(i, typeface);
    }

    public int[] getSelectedTabColors() {
        return SELECTED_STATE_SET;
    }

    public int[] getDefaultTabColors() {
        return EMPTY_STATE_SET;
    }

    public void applyTopTabsColors(ThemeColour themeColour, ThemeColour themeColour2) {
        this.styleHelper.applyTopTabsColors(themeColour, themeColour2);
    }

    public void applyTopTabsFontSize(Number number) {
        this.styleHelper.applyTopTabsFontSize(number);
    }

    public void setVisibility(TopBar topBar, boolean z) {
        if (z && getTabCount() > 0) {
            if (getParent() == null) {
                topBar.addView(this, 1);
            }
            setVisibility(0);
            return;
        }
        topBar.removeView(this);
    }

    public void clear() {
        setupWithViewPager(null);
        ViewExtensionsKt.removeFromParent(this);
    }

    public void init(ViewPager viewPager) {
        setupWithViewPager(viewPager);
    }
}
