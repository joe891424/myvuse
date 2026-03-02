package com.reactnativenavigation.views.stack.topbar;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.reactnativenavigation.C3967R;
import com.reactnativenavigation.options.Alignment;
import com.reactnativenavigation.options.FontOptions;
import com.reactnativenavigation.options.LayoutDirection;
import com.reactnativenavigation.options.SubtitleOptions;
import com.reactnativenavigation.options.TitleOptions;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import com.reactnativenavigation.utils.CompatUtils;
import com.reactnativenavigation.utils.UiUtils;
import com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarCollapseBehavior;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener;
import com.reactnativenavigation.views.stack.topbar.titlebar.ButtonBar;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleAndButtonsContainer;
import com.reactnativenavigation.views.toptabs.TopTabs;

/* JADX INFO: loaded from: classes6.dex */
public class TopBar extends AppBarLayout implements ScrollEventListener.ScrollAwareView {
    public static final int DEFAULT_SUBTITLE_COLOR = -7829368;
    public static final int DEFAULT_TITLE_COLOR = -16777216;
    private View border;
    private final TopBarCollapseBehavior collapsingBehavior;
    private View component;
    private float elevation;
    private FrameLayout root;
    private final TitleAndButtonsContainer titleAndButtonsContainer;
    private TopTabs topTabs;

    public Drawable getNavigationIcon() {
        return this.titleAndButtonsContainer.getLeftButtonBar().getNavigationIcon();
    }

    public TopBar(Context context) {
        super(context);
        this.elevation = -1.0f;
        context.setTheme(C3967R.style.TopBar);
        setId(CompatUtils.generateViewId());
        this.titleAndButtonsContainer = new TitleAndButtonsContainer(getContext());
        this.collapsingBehavior = new TopBarCollapseBehavior(this);
        this.topTabs = new TopTabs(getContext());
        createLayout();
    }

    private void createLayout() {
        setId(CompatUtils.generateViewId());
        this.topTabs = createTopTabs();
        this.border = createBorder();
        LinearLayout linearLayoutCreateContentLayout = createContentLayout();
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.root = frameLayout;
        frameLayout.setId(CompatUtils.generateViewId());
        linearLayoutCreateContentLayout.addView(this.titleAndButtonsContainer, new ViewGroup.MarginLayoutParams(-1, UiUtils.getTopBarHeight(getContext())));
        linearLayoutCreateContentLayout.addView(this.topTabs);
        this.root.addView(linearLayoutCreateContentLayout);
        this.root.addView(this.border);
        addView(this.root, -1, -2);
    }

    private LinearLayout createContentLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    private TopTabs createTopTabs() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.titleAndButtonsContainer.getId());
        TopTabs topTabs = new TopTabs(getContext());
        topTabs.setLayoutParams(layoutParams);
        topTabs.setVisibility(8);
        return topTabs;
    }

    private View createBorder() {
        View view = new View(getContext());
        view.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        return view;
    }

    public void setHeight(int i) {
        int iDpToPx = UiUtils.dpToPx(getContext(), i);
        if (iDpToPx == getLayoutParams().height) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = iDpToPx;
        setLayoutParams(layoutParams);
    }

    public void setTopPadding(int i) {
        setPadding(0, i, 0, 0);
    }

    public void setTitleHeight(int i) {
        int iDpToPx = UiUtils.dpToPx(getContext(), i);
        ViewGroup.LayoutParams layoutParams = this.titleAndButtonsContainer.getLayoutParams();
        if (iDpToPx == layoutParams.height) {
            return;
        }
        layoutParams.height = iDpToPx;
        this.titleAndButtonsContainer.setLayoutParams(layoutParams);
    }

    public void setTitleTopMargin(int i) {
        int iDpToPx = UiUtils.dpToPx(getContext(), i);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.titleAndButtonsContainer.getLayoutParams();
        if (marginLayoutParams.topMargin != i) {
            marginLayoutParams.topMargin = iDpToPx;
            this.titleAndButtonsContainer.setLayoutParams(marginLayoutParams);
        }
    }

    public void setTitle(String str) {
        this.titleAndButtonsContainer.setTitle(str);
    }

    public String getTitle() {
        return this.titleAndButtonsContainer.getTitle();
    }

    public void setSubtitle(String str) {
        this.titleAndButtonsContainer.setSubtitle(str);
    }

    public void setSubtitleColor(int i) {
        this.titleAndButtonsContainer.setSubtitleColor(i);
    }

    public void setSubtitleTypeface(TypefaceLoader typefaceLoader, FontOptions fontOptions) {
        if (typefaceLoader != null) {
            this.titleAndButtonsContainer.setSubtitleTypeface(typefaceLoader, fontOptions);
        }
    }

    public void setSubtitleFontSize(double d) {
        this.titleAndButtonsContainer.setSubtitleFontSize((float) d);
    }

    public void animateRightButtons(boolean z) {
        this.titleAndButtonsContainer.animateRightButtons(z);
    }

    public void animateLeftButtons(boolean z) {
        this.titleAndButtonsContainer.animateLeftButtons(z);
    }

    public void setSubtitleAlignment(Alignment alignment) {
        this.titleAndButtonsContainer.setSubTitleTextAlignment(alignment);
    }

    public void setTestId(String str) {
        setTag(str);
    }

    public void setTitleTextColor(int i) {
        this.titleAndButtonsContainer.setTitleColor(i);
    }

    public void setTitleFontSize(double d) {
        this.titleAndButtonsContainer.setTitleFontSize((float) d);
    }

    public void setTitleTypeface(TypefaceLoader typefaceLoader, FontOptions fontOptions) {
        if (typefaceLoader != null) {
            this.titleAndButtonsContainer.setTitleTypeface(typefaceLoader, fontOptions);
        }
    }

    public void setTitleAlignment(Alignment alignment) {
        this.titleAndButtonsContainer.setTitleBarAlignment(alignment);
    }

    public void setTitleComponent(View view, Alignment alignment) {
        this.titleAndButtonsContainer.setComponent(view, alignment);
    }

    public void setTitleComponent(View view) {
        setTitleComponent(view, Alignment.Default);
    }

    public void setBackgroundComponent(View view) {
        if (this.component == view || view.getParent() != null) {
            return;
        }
        this.component = view;
        this.root.addView(view, 0);
    }

    public void setTopTabFontFamily(int i, Typeface typeface) {
        this.topTabs.setFontFamily(i, typeface);
    }

    public void applyTopTabsColors(ThemeColour themeColour, ThemeColour themeColour2) {
        this.topTabs.applyTopTabsColors(themeColour, themeColour2);
    }

    public void applyTopTabsFontSize(Number number) {
        this.topTabs.applyTopTabsFontSize(number);
    }

    public void setTopTabsVisible(boolean z) {
        this.topTabs.setVisibility(this, z);
    }

    public void setTopTabsHeight(int i) {
        if (this.topTabs.getLayoutParams().height == i) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.topTabs.getLayoutParams();
        if (i > 0) {
            i = UiUtils.dpToPx(getContext(), i);
        }
        layoutParams.height = i;
        TopTabs topTabs = this.topTabs;
        topTabs.setLayoutParams(topTabs.getLayoutParams());
    }

    public void setBackButton(ButtonController buttonController) {
        this.titleAndButtonsContainer.getLeftButtonBar().setBackButton(buttonController);
    }

    public void clearLeftButtons() {
        this.titleAndButtonsContainer.getLeftButtonBar().clearButtons();
    }

    public void clearBackButton() {
        this.titleAndButtonsContainer.getLeftButtonBar().clearBackButton();
    }

    public void clearRightButtons() {
        this.titleAndButtonsContainer.getRightButtonBar().clearButtons();
    }

    public void setElevation(Double d) {
        if (getElevation() != d.floatValue()) {
            float fDpToPx = UiUtils.dpToPx(getContext(), d.floatValue());
            this.elevation = fDpToPx;
            setElevation(fDpToPx);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.View
    public void setElevation(float f) {
        if (f == this.elevation) {
            super.setElevation(f);
        }
    }

    public ButtonBar getRightButtonBar() {
        return this.titleAndButtonsContainer.getRightButtonBar();
    }

    public ButtonBar getLeftButtonBar() {
        return this.titleAndButtonsContainer.getLeftButtonBar();
    }

    public void initTopTabs(ViewPager viewPager) {
        this.topTabs.setVisibility(0);
        this.topTabs.init(viewPager);
    }

    public void enableCollapse(ScrollEventListener scrollEventListener) {
        this.collapsingBehavior.enableCollapse(scrollEventListener);
        ((AppBarLayout.LayoutParams) this.root.getLayoutParams()).setScrollFlags(1);
    }

    public void disableCollapse() {
        this.collapsingBehavior.disableCollapse();
        ((AppBarLayout.LayoutParams) this.root.getLayoutParams()).setScrollFlags(0);
    }

    public void clearBackgroundComponent() {
        View view = this.component;
        if (view != null) {
            this.root.removeView(view);
            this.component = null;
        }
    }

    public void clearTopTabs() {
        this.topTabs.clear();
    }

    public TopTabs getTopTabs() {
        return this.topTabs;
    }

    public void setBorderHeight(double d) {
        this.border.getLayoutParams().height = (int) UiUtils.dpToPx(getContext(), (float) d);
    }

    public void setBorderColor(int i) {
        this.border.setBackgroundColor(i);
    }

    public void setOverflowButtonColor(int i) {
        this.titleAndButtonsContainer.getRightButtonBar().setOverflowButtonColor(i);
        this.titleAndButtonsContainer.getLeftButtonBar().setOverflowButtonColor(i);
    }

    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.titleAndButtonsContainer.setLayoutDirection(layoutDirection.get());
    }

    public void removeRightButton(ButtonController buttonController) {
        removeRightButton(buttonController.getButtonIntId());
    }

    public void removeLeftButton(ButtonController buttonController) {
        removeLeftButton(buttonController.getButtonIntId());
    }

    public void removeRightButton(int i) {
        this.titleAndButtonsContainer.getRightButtonBar().removeButton(i);
    }

    public void removeLeftButton(int i) {
        this.titleAndButtonsContainer.getLeftButtonBar().removeButton(i);
    }

    public void alignTitleComponent(Alignment alignment) {
        this.titleAndButtonsContainer.setTitleBarAlignment(alignment);
    }

    public TitleAndButtonsContainer getTitleAndButtonsContainer() {
        return this.titleAndButtonsContainer;
    }

    public void applyTitleOptions(TitleOptions titleOptions, TypefaceLoader typefaceLoader) {
        setTitle(titleOptions.text.get(""));
        setTitleFontSize(titleOptions.fontSize.get(Double.valueOf(18.0d)).doubleValue());
        setTitleTextColor(titleOptions.color.get(-16777216).intValue());
        setTitleTypeface(typefaceLoader, titleOptions.font);
        setTitleAlignment(titleOptions.alignment);
    }

    public void applySubtitleOptions(SubtitleOptions subtitleOptions, TypefaceLoader typefaceLoader) {
        setSubtitle(subtitleOptions.text.get(""));
        setSubtitleFontSize(subtitleOptions.fontSize.get(Double.valueOf(14.0d)).doubleValue());
        setSubtitleColor(subtitleOptions.color.get(Integer.valueOf(DEFAULT_SUBTITLE_COLOR)).intValue());
        setSubtitleTypeface(typefaceLoader, subtitleOptions.font);
        setSubtitleAlignment(subtitleOptions.alignment);
    }
}
