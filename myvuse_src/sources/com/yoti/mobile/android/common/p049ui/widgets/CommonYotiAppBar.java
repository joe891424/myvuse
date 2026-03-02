package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0006J\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001d¨\u0006*"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/CommonYotiAppBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/yoti/mobile/android/common/ui/widgets/AppBarDescription;", "appBarDescription", "", "setUpToolbarAccessibility", "(Lcom/yoti/mobile/android/common/ui/widgets/AppBarDescription;)V", "a", "b", "", "navigationIconContentDescriptionId", "Landroid/view/View;", "(I)Landroid/view/View;", "updateAppBar", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "Lcom/google/android/material/appbar/MaterialToolbar;", "kotlin.jvm.PlatformType", "getToolbar", "()Lcom/google/android/material/appbar/MaterialToolbar;", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setupTabLayout", "(Landroidx/viewpager/widget/ViewPager;)V", "showTitle", "()V", "hideTitle", "getLayoutRes", "()I", "layoutRes", "getDefaultStyleRes", "defaultStyleRes", "getDefaultSeparatorVisibility", "defaultSeparatorVisibility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public abstract class CommonYotiAppBar extends ConstraintLayout {

    /* JADX INFO: renamed from: a */
    private HashMap f5921a;

    public CommonYotiAppBar(Context context) {
        this(context, null, 0, 6, null);
    }

    public CommonYotiAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonYotiAppBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(getLayoutRes(), (ViewGroup) this, true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4584R.styleable.YotiAppBar, 0, getDefaultStyleRes());
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…defaultStyleRes\n        )");
        ((AppBarLayout) _$_findCachedViewById(C4584R.id.appBarLayout)).setBackgroundColor(typedArrayObtainStyledAttributes.getColor(C4584R.styleable.YotiAppBar_appBarBackgroundColour, 0));
        ((TextView) _$_findCachedViewById(C4584R.id.toolbarTitle)).setTextColor(typedArrayObtainStyledAttributes.getColor(C4584R.styleable.YotiAppBar_appBarTitleColour, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ CommonYotiAppBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: renamed from: a */
    private final View m4387a(int navigationIconContentDescriptionId) {
        MaterialToolbar materialToolbar = (MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar);
        int i = 0;
        int childCount = materialToolbar != null ? materialToolbar.getChildCount() : 0;
        while (true) {
            if (i >= childCount) {
                return null;
            }
            View childAt = ((MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar)).getChildAt(i);
            if (Intrinsics.areEqual(childAt != null ? childAt.getContentDescription() : null, getContext().getString(navigationIconContentDescriptionId))) {
                return ((MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar)).getChildAt(i);
            }
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, android.view.View] */
    /* JADX INFO: renamed from: a */
    private final void m4388a(final AppBarDescription appBarDescription) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        if (appBarDescription.getNavigationIcon() != NavigationIcon.NONE && appBarDescription.getNavigationIcon() != NavigationIcon.INVISBLE) {
            objectRef.element = m4387a(appBarDescription.getNavigationIcon().getNavDescription());
        }
        final View view = (View) objectRef.element;
        if (view != null) {
            ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: com.yoti.mobile.android.common.ui.widgets.CommonYotiAppBar$installAccessibilityDelegateForNavigationIcon$$inlined$apply$lambda$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    if (appBarDescription.getNavigationIcon() == NavigationIcon.NONE || appBarDescription.getNavigationIcon() == NavigationIcon.INVISBLE) {
                        return;
                    }
                    ((View) objectRef.element).setContentDescription(view.getContext().getString(appBarDescription.getNavigationIcon().getNavDescription()));
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m4389b(final AppBarDescription appBarDescription) {
        ViewCompat.setAccessibilityDelegate((MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar), new AccessibilityDelegateCompat() { // from class: com.yoti.mobile.android.common.ui.widgets.CommonYotiAppBar$installAccessibilityDelegateForToolBar$1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                super.onInitializeAccessibilityEvent(host, event);
                if (event == null || event.getEventType() != 32768) {
                    return;
                }
                MaterialToolbar materialToolbar = (MaterialToolbar) this.f5925a._$_findCachedViewById(C4584R.id.toolbar);
                materialToolbar.setFocusable(false);
                materialToolbar.setFocusableInTouchMode(false);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                MaterialToolbar toolbar;
                String titleText;
                super.onInitializeAccessibilityNodeInfo(host, info);
                if (appBarDescription.getTitle() > 0) {
                    toolbar = (MaterialToolbar) this.f5925a._$_findCachedViewById(C4584R.id.toolbar);
                    Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
                    titleText = this.f5925a.getContext().getString(appBarDescription.getTitle());
                } else {
                    toolbar = (MaterialToolbar) this.f5925a._$_findCachedViewById(C4584R.id.toolbar);
                    Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
                    titleText = appBarDescription.getTitleText();
                }
                toolbar.setContentDescription(titleText);
            }
        });
    }

    private final void setUpToolbarAccessibility(AppBarDescription appBarDescription) {
        Object systemService = getContext().getSystemService("accessibility");
        if (!(systemService instanceof AccessibilityManager)) {
            systemService = null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            if (Build.VERSION.SDK_INT >= 28) {
                TextView toolbarTitle = (TextView) _$_findCachedViewById(C4584R.id.toolbarTitle);
                Intrinsics.checkNotNullExpressionValue(toolbarTitle, "toolbarTitle");
                toolbarTitle.setAccessibilityHeading(true);
            }
            MaterialToolbar materialToolbar = (MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar);
            materialToolbar.setFocusable(true);
            materialToolbar.setFocusableInTouchMode(true);
            materialToolbar.sendAccessibilityEvent(32768);
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(32768);
            accessibilityEventObtain.setSource((MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar));
            accessibilityEventObtain.setEventType(32768);
            accessibilityEventObtain.setClassName(accessibilityEventObtain.getClass().getName());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            accessibilityEventObtain.setPackageName(context.getPackageName());
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
            m4389b(appBarDescription);
            m4388a(appBarDescription);
        }
    }

    public static /* synthetic */ void updateAppBar$default(CommonYotiAppBar commonYotiAppBar, AppBarDescription appBarDescription, int i, Object obj) {
        AppBarDescription appBarDescription2;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAppBar");
        }
        if ((i & 1) != 0) {
            appBarDescription2 = new AppBarDescription(null, 0, null, 0, false, null, null, null, false, 0, 0, 2047, null);
        } else {
            appBarDescription2 = appBarDescription;
        }
        commonYotiAppBar.updateAppBar(appBarDescription2);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f5921a;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5921a == null) {
            this.f5921a = new HashMap();
        }
        View view = (View) this.f5921a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5921a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public abstract int getDefaultSeparatorVisibility();

    public abstract int getDefaultStyleRes();

    public abstract int getLayoutRes();

    public final TabLayout getTabLayout() {
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(C4584R.id.tabLayout);
        Intrinsics.checkNotNullExpressionValue(tabLayout, "tabLayout");
        return tabLayout;
    }

    public final MaterialToolbar getToolbar() {
        return (MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar);
    }

    public final void hideTitle() {
        TextView toolbarTitle = (TextView) _$_findCachedViewById(C4584R.id.toolbarTitle);
        Intrinsics.checkNotNullExpressionValue(toolbarTitle, "toolbarTitle");
        toolbarTitle.setVisibility(8);
    }

    public final void setupTabLayout(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        ((TabLayout) _$_findCachedViewById(C4584R.id.tabLayout)).setupWithViewPager(viewPager);
    }

    public final void showTitle() {
        TextView toolbarTitle = (TextView) _$_findCachedViewById(C4584R.id.toolbarTitle);
        Intrinsics.checkNotNullExpressionValue(toolbarTitle, "toolbarTitle");
        toolbarTitle.setVisibility(0);
    }

    public final void updateAppBar(AppBarDescription appBarDescription) {
        Intrinsics.checkNotNullParameter(appBarDescription, "appBarDescription");
        if (appBarDescription.getHideAppBar()) {
            setVisibility(8);
            return;
        }
        int defaultSeparatorVisibility = 0;
        setVisibility(0);
        if (appBarDescription.getTitle() > 0) {
            ((TextView) _$_findCachedViewById(C4584R.id.toolbarTitle)).setText(appBarDescription.getTitle());
        } else {
            TextView toolbarTitle = (TextView) _$_findCachedViewById(C4584R.id.toolbarTitle);
            Intrinsics.checkNotNullExpressionValue(toolbarTitle, "toolbarTitle");
            toolbarTitle.setText(appBarDescription.getTitleText());
        }
        if (appBarDescription.getTitleGravity() != 1) {
            Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -1);
            layoutParams.gravity = appBarDescription.getTitleGravity();
            TextView toolbarTitle2 = (TextView) _$_findCachedViewById(C4584R.id.toolbarTitle);
            Intrinsics.checkNotNullExpressionValue(toolbarTitle2, "toolbarTitle");
            toolbarTitle2.setLayoutParams(layoutParams);
        }
        if (appBarDescription.getNavigationIcon() != NavigationIcon.NONE) {
            ((MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar)).setNavigationIcon(appBarDescription.getNavigationIcon().getIcon());
            ((MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar)).setNavigationContentDescription(appBarDescription.getNavigationIcon().getNavDescription());
        } else {
            MaterialToolbar toolbar = (MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar);
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            toolbar.setNavigationIcon((Drawable) null);
            MaterialToolbar toolbar2 = (MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar);
            Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
            toolbar2.setNavigationContentDescription((CharSequence) null);
        }
        if (appBarDescription.getShowTabLayout()) {
            TabLayout tabLayout = (TabLayout) _$_findCachedViewById(C4584R.id.tabLayout);
            Intrinsics.checkNotNullExpressionValue(tabLayout, "tabLayout");
            tabLayout.setVisibility(0);
        } else {
            TabLayout tabLayout2 = (TabLayout) _$_findCachedViewById(C4584R.id.tabLayout);
            Intrinsics.checkNotNullExpressionValue(tabLayout2, "tabLayout");
            tabLayout2.setVisibility(8);
            ((TabLayout) _$_findCachedViewById(C4584R.id.tabLayout)).setupWithViewPager(null);
        }
        View appbarSeparator = _$_findCachedViewById(C4584R.id.appbarSeparator);
        Intrinsics.checkNotNullExpressionValue(appbarSeparator, "appbarSeparator");
        Boolean hideSeparator = appBarDescription.getHideSeparator();
        if (Intrinsics.areEqual(hideSeparator, Boolean.TRUE)) {
            defaultSeparatorVisibility = 4;
        } else if (!Intrinsics.areEqual(hideSeparator, Boolean.FALSE)) {
            if (hideSeparator != null) {
                throw new NoWhenBranchMatchedException();
            }
            defaultSeparatorVisibility = getDefaultSeparatorVisibility();
        }
        appbarSeparator.setVisibility(defaultSeparatorVisibility);
        if (appBarDescription.getLogoRes() != 0) {
            ((MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar)).setLogo(appBarDescription.getLogoRes());
            if (appBarDescription.getLogoDescription() != 0) {
                ((MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar)).setLogoDescription(appBarDescription.getLogoDescription());
            }
        } else {
            MaterialToolbar toolbar3 = (MaterialToolbar) _$_findCachedViewById(C4584R.id.toolbar);
            Intrinsics.checkNotNullExpressionValue(toolbar3, "toolbar");
            toolbar3.setLogo((Drawable) null);
        }
        setUpToolbarAccessibility(appBarDescription);
    }
}
