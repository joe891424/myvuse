package com.reactnativenavigation.views.stack.topbar.titlebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.Alignment;
import com.reactnativenavigation.options.FontOptions;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import com.reactnativenavigation.utils.ViewExtensionsKt;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: TitleAndButtonsContainer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\r\u0010 \u001a\u00020\u0006H\u0000¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0014H\u0007J0\u0010#\u001a\u00020\u00162\n\u0010$\u001a\u00060%j\u0002`&2\n\u0010'\u001a\u00060%j\u0002`(2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0018H\u0002J \u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020%H\u0002J0\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020%H\u0014J\u0018\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020%H\u0014J\u000e\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:J\u0018\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH\u0007J\u0018\u0010>\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u000fJ\u0010\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020%H\u0016J\u000e\u0010B\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u000fJ\u0010\u0010C\u001a\u00020\u00162\b\u0010D\u001a\u0004\u0018\u00010EJ\u0010\u0010F\u001a\u00020\u00162\b\b\u0001\u00109\u001a\u00020%J\u000e\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020IJ\u0016\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NJ\u0010\u0010O\u001a\u00020\u00162\b\u0010P\u001a\u0004\u0018\u00010EJ\u000e\u0010Q\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u000fJ\u0010\u0010R\u001a\u00020\u00162\b\b\u0001\u00109\u001a\u00020%J\u000e\u0010S\u001a\u00020\u00162\u0006\u0010H\u001a\u00020IJ\u0010\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u0014H\u0007J\u000e\u0010V\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u000fJ\u0016\u0010W\u001a\u00020\u00162\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, m5598d2 = {"Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleAndButtonsContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "component", "Landroid/view/View;", "<set-?>", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/ButtonBar;", "leftButtonBar", "getLeftButtonBar", "()Lcom/reactnativenavigation/views/stack/topbar/titlebar/ButtonBar;", "rightButtonBar", "getRightButtonBar", "value", "Lcom/reactnativenavigation/options/Alignment;", "titleComponentAlignment", "setTitleComponentAlignment", "(Lcom/reactnativenavigation/options/Alignment;)V", "titleSubTitleBar", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleSubTitleLayout;", "animateLeftButtons", "", "animate", "", "animateRightButtons", "clearComponent", "()Lkotlin/Unit;", "clearTitle", "getComponent", "getTitle", "", "getTitleComponent", "getTitleComponent$react_native_navigation_reactNative71Release", "getTitleSubtitleBar", "measureTextTitleEnsureTruncatedEndIfNeeded", "titleRight", "", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleRight;", "titleLeft", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleLeft;", "titleComponent", "isCenter", "measureTitleComponentExact", "mode", "containerWidth", "containerHeight", ViewProps.ON_LAYOUT, "changed", "l", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME, "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBackgroundColor", "color", "Lcom/reactnativenavigation/options/params/ThemeColour;", "setButtonBars", ViewProps.LEFT, ViewProps.RIGHT, "setComponent", "alignment", "setLayoutDirection", ViewProps.LAYOUT_DIRECTION, "setSubTitleTextAlignment", "setSubtitle", NotificationMessage.NOTIF_KEY_SUB_TITLE, "", "setSubtitleColor", "setSubtitleFontSize", "size", "", "setSubtitleTypeface", "typefaceLoader", "Lcom/reactnativenavigation/options/parsers/TypefaceLoader;", "font", "Lcom/reactnativenavigation/options/FontOptions;", "setTitle", "title", "setTitleBarAlignment", "setTitleColor", "setTitleFontSize", "setTitleSubtitleLayout", "layout", "setTitleTextAlignment", "setTitleTypeface", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TitleAndButtonsContainer extends ViewGroup {
    private View component;
    private ButtonBar leftButtonBar;
    private ButtonBar rightButtonBar;
    private Alignment titleComponentAlignment;
    private TitleSubTitleLayout titleSubTitleBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleAndButtonsContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleComponentAlignment = Alignment.Default;
        this.titleSubTitleBar = new TitleSubTitleLayout(context);
        this.leftButtonBar = new ButtonBar(context);
        this.rightButtonBar = new ButtonBar(context);
        addView(this.leftButtonBar, new ViewGroup.LayoutParams(-2, -1));
        addView(this.titleSubTitleBar, new ViewGroup.LayoutParams(-2, -1));
        addView(this.rightButtonBar, new ViewGroup.LayoutParams(-2, -1));
    }

    private final void setTitleComponentAlignment(Alignment alignment) {
        if (this.titleComponentAlignment != alignment) {
            this.titleComponentAlignment = alignment;
            requestLayout();
        }
    }

    public final void animateLeftButtons(boolean animate) {
        this.leftButtonBar.setShouldAnimate(animate);
    }

    public final void animateRightButtons(boolean animate) {
        this.rightButtonBar.setShouldAnimate(animate);
    }

    public final ButtonBar getLeftButtonBar() {
        return this.leftButtonBar;
    }

    public final ButtonBar getRightButtonBar() {
        return this.rightButtonBar;
    }

    public static /* synthetic */ void setComponent$default(TitleAndButtonsContainer titleAndButtonsContainer, View view, Alignment alignment, int i, Object obj) {
        if ((i & 2) != 0) {
            alignment = Alignment.Default;
        }
        titleAndButtonsContainer.setComponent(view, alignment);
    }

    public final void setComponent(View component, Alignment alignment) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        if (Intrinsics.areEqual(this.component, component)) {
            return;
        }
        clearTitle();
        this.component = component;
        addView(component, new ViewGroup.LayoutParams(-2, -2));
        setTitleComponentAlignment(alignment);
    }

    public final void setTitle(CharSequence title) {
        clearComponent();
        this.titleSubTitleBar.setVisibility(0);
        this.titleSubTitleBar.setTitle(title);
    }

    public final void setSubtitle(CharSequence subtitle) {
        clearComponent();
        this.titleSubTitleBar.setVisibility(0);
        this.titleSubTitleBar.setSubtitle(subtitle);
    }

    public final void setTitleBarAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        setTitleComponentAlignment(alignment);
    }

    @Override // android.view.View
    public void setLayoutDirection(int layoutDirection) {
        super.setLayoutDirection(layoutDirection);
        View view = this.component;
        if (view != null) {
            view.setLayoutDirection(layoutDirection);
        }
        this.titleSubTitleBar.setLayoutDirection(layoutDirection);
        this.rightButtonBar.setLayoutDirection(layoutDirection);
        ButtonBar buttonBar = this.leftButtonBar;
        if (ViewExtensionsKt.isRTL(this)) {
            layoutDirection = 1;
        }
        buttonBar.setLayoutDirection(layoutDirection);
    }

    public final void setSubTitleTextAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.titleSubTitleBar.setSubTitleAlignment(alignment);
    }

    public final void setTitleTextAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.titleSubTitleBar.setTitleAlignment(alignment);
    }

    public final void setBackgroundColor(ThemeColour color) {
        Intrinsics.checkNotNullParameter(color, "color");
        if (color.hasValue()) {
            setBackgroundColor(color.get());
        }
    }

    public final void setTitleFontSize(float size) {
        this.titleSubTitleBar.setTitleFontSize(size);
    }

    public final void setTitleTypeface(TypefaceLoader typefaceLoader, FontOptions font) {
        Intrinsics.checkNotNullParameter(typefaceLoader, "typefaceLoader");
        Intrinsics.checkNotNullParameter(font, "font");
        this.titleSubTitleBar.setTitleTypeface(typefaceLoader, font);
    }

    public final void setSubtitleTypeface(TypefaceLoader typefaceLoader, FontOptions font) {
        Intrinsics.checkNotNullParameter(typefaceLoader, "typefaceLoader");
        Intrinsics.checkNotNullParameter(font, "font");
        this.titleSubTitleBar.setSubtitleTypeface(typefaceLoader, font);
    }

    public final void setSubtitleFontSize(float size) {
        this.titleSubTitleBar.setSubtitleFontSize(size);
    }

    public final void setSubtitleColor(int color) {
        this.titleSubTitleBar.setSubtitleTextColor(color);
    }

    public final void setTitleColor(int color) {
        this.titleSubTitleBar.setTitleTextColor(color);
    }

    public final String getTitle() {
        return this.titleSubTitleBar.getTitle();
    }

    public final void clearTitle() {
        this.titleSubTitleBar.clear();
        clearComponent();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View titleComponent$react_native_navigation_reactNative71Release = getTitleComponent$react_native_navigation_reactNative71Release();
        boolean z = this.titleComponentAlignment == Alignment.Center;
        int i = r - l;
        boolean zIsRTL = ViewExtensionsKt.isRTL(this);
        int measuredWidth = titleComponent$react_native_navigation_reactNative71Release.getMeasuredWidth();
        int measuredHeight = titleComponent$react_native_navigation_reactNative71Release.getMeasuredHeight();
        int measuredWidth2 = this.leftButtonBar.getMeasuredWidth();
        Pair<Integer, Integer> pairResolveHorizontalTitleBoundsLimit = TitleAndButtonsMeasurerKt.resolveHorizontalTitleBoundsLimit(i, measuredWidth, measuredWidth2, this.rightButtonBar.getMeasuredWidth(), z, zIsRTL);
        int iIntValue = pairResolveHorizontalTitleBoundsLimit.component1().intValue();
        int iIntValue2 = pairResolveHorizontalTitleBoundsLimit.component2().intValue();
        Pair<Integer, Integer> pairResolveVerticalTitleBoundsLimit = TitleAndButtonsMeasurerKt.resolveVerticalTitleBoundsLimit(b - t, measuredHeight);
        int iIntValue3 = pairResolveVerticalTitleBoundsLimit.component1().intValue();
        int iIntValue4 = pairResolveVerticalTitleBoundsLimit.component2().intValue();
        Pair<Integer, Integer> pairResolveLeftButtonsBounds = TitleAndButtonsMeasurerKt.resolveLeftButtonsBounds(i, measuredWidth2, zIsRTL);
        int iIntValue5 = pairResolveLeftButtonsBounds.component1().intValue();
        int iIntValue6 = pairResolveLeftButtonsBounds.component2().intValue();
        Pair<Integer, Integer> pairResolveRightButtonsBounds = TitleAndButtonsMeasurerKt.resolveRightButtonsBounds(i, this.rightButtonBar.getMeasuredWidth(), zIsRTL);
        int iIntValue7 = pairResolveRightButtonsBounds.component1().intValue();
        int iIntValue8 = pairResolveRightButtonsBounds.component2().intValue();
        this.leftButtonBar.layout(iIntValue5, t, iIntValue6, b);
        this.rightButtonBar.layout(iIntValue7, t, iIntValue8, b);
        titleComponent$react_native_navigation_reactNative71Release.layout(iIntValue, iIntValue3, iIntValue2, iIntValue4);
        measureTextTitleEnsureTruncatedEndIfNeeded(iIntValue2, iIntValue, titleComponent$react_native_navigation_reactNative71Release, z);
    }

    private final void measureTextTitleEnsureTruncatedEndIfNeeded(int titleRight, int titleLeft, View titleComponent, boolean isCenter) {
        int i;
        if (this.component != null || (i = titleRight - titleLeft) == titleComponent.getMeasuredWidth()) {
            return;
        }
        titleComponent.measure(View.MeasureSpec.makeMeasureSpec(i + (isCenter ? 0 : TitleAndButtonsMeasurerKt.getDEFAULT_LEFT_MARGIN_PX() * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(titleComponent.getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        measureTitleComponentExact(mode, size, size2);
        setMeasuredDimension(size, size2);
    }

    private final void measureTitleComponentExact(int mode, int containerWidth, int containerHeight) {
        if (mode != 1073741824) {
            return;
        }
        View titleComponent$react_native_navigation_reactNative71Release = getTitleComponent$react_native_navigation_reactNative71Release();
        this.rightButtonBar.measure(View.MeasureSpec.makeMeasureSpec(containerWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(containerHeight, 1073741824));
        this.leftButtonBar.measure(View.MeasureSpec.makeMeasureSpec(containerWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(containerHeight, 1073741824));
        int measuredWidth = this.rightButtonBar.getMeasuredWidth();
        int measuredWidth2 = this.leftButtonBar.getMeasuredWidth();
        boolean z = this.titleComponentAlignment == Alignment.Center;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(containerHeight, Integer.MIN_VALUE);
        int iMakeTitleAtMostWidthMeasureSpec = TitleAndButtonsMeasurerKt.makeTitleAtMostWidthMeasureSpec(containerWidth, measuredWidth, measuredWidth2, z);
        if (titleComponent$react_native_navigation_reactNative71Release instanceof TitleBarReactView) {
            ((TitleBarReactView) titleComponent$react_native_navigation_reactNative71Release).setCentered(z);
        }
        titleComponent$react_native_navigation_reactNative71Release.measure(iMakeTitleAtMostWidthMeasureSpec, iMakeMeasureSpec);
    }

    private final Unit clearComponent() {
        View view = this.component;
        if (view == null) {
            return null;
        }
        ViewExtensionsKt.removeFromParent(view);
        this.component = null;
        return Unit.INSTANCE;
    }

    public final View getTitleComponent$react_native_navigation_reactNative71Release() {
        View view = this.component;
        return view == null ? this.titleSubTitleBar : view;
    }

    public final View getComponent() {
        return this.component;
    }

    public final void setTitleSubtitleLayout(TitleSubTitleLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        removeView(this.titleSubTitleBar);
        this.titleSubTitleBar = layout;
        addView(layout, new ViewGroup.LayoutParams(-2, -1));
    }

    public final void setButtonBars(ButtonBar left, ButtonBar right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.leftButtonBar.getLayoutParams());
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(this.rightButtonBar.getLayoutParams());
        removeView(this.leftButtonBar);
        removeView(this.rightButtonBar);
        addView(left, layoutParams);
        addView(right, layoutParams2);
        this.leftButtonBar = left;
        this.rightButtonBar = right;
    }

    /* JADX INFO: renamed from: getTitleSubtitleBar, reason: from getter */
    public final TitleSubTitleLayout getTitleSubTitleBar() {
        return this.titleSubTitleBar;
    }
}
