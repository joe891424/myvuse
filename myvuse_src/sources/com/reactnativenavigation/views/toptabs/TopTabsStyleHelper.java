package com.reactnativenavigation.views.toptabs;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.TextView;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ViewUtils;

/* JADX INFO: loaded from: classes6.dex */
class TopTabsStyleHelper {
    private TopTabs topTabs;

    TopTabsStyleHelper(TopTabs topTabs) {
        this.topTabs = topTabs;
    }

    void applyTopTabsFontSize(final Number number) {
        if (number.hasValue()) {
            for (int i = 0; i < this.topTabs.getTabCount(); i++) {
                applyOnTabTitle(i, new Functions.Func1() { // from class: com.reactnativenavigation.views.toptabs.TopTabsStyleHelper$$ExternalSyntheticLambda0
                    @Override // com.reactnativenavigation.utils.Functions.Func1
                    public final void run(Object obj) {
                        Number number2 = number;
                        ((TextView) obj).setTextSize(number2.get().intValue());
                    }
                });
            }
        }
    }

    void applyTopTabsColors(ThemeColour themeColour, ThemeColour themeColour2) {
        ColorStateList tabTextColors = this.topTabs.getTabTextColors();
        int colorForState = tabTextColors != null ? tabTextColors.getColorForState(this.topTabs.getSelectedTabColors(), -1) : -1;
        int colorForState2 = tabTextColors != null ? tabTextColors.getColorForState(this.topTabs.getDefaultTabColors(), -1) : -1;
        if (themeColour.hasValue()) {
            colorForState = themeColour.get();
        }
        if (themeColour2.hasValue()) {
            colorForState2 = themeColour2.get();
        }
        this.topTabs.setTabTextColors(colorForState2, colorForState);
    }

    void setFontFamily(int i, final Typeface typeface) {
        applyOnTabTitle(i, new Functions.Func1() { // from class: com.reactnativenavigation.views.toptabs.TopTabsStyleHelper$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((TextView) obj).setTypeface(typeface);
            }
        });
    }

    private void applyOnTabTitle(int i, Functions.Func1<TextView> func1) {
        TextView textView = (TextView) ViewUtils.findChildByClass(getTabView(i), TextView.class);
        if (textView != null) {
            func1.run(textView);
        }
    }

    private ViewGroup getTabView(int i) {
        return (ViewGroup) ((ViewGroup) this.topTabs.getChildAt(0)).getChildAt(i);
    }
}
