package com.reactnativenavigation.viewcontrollers.stack.topbar.button;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.reactnativenavigation.options.ButtonOptions;
import com.reactnativenavigation.options.params.DensityPixel;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.utils.ArrayUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ViewUtils;
import com.reactnativenavigation.views.stack.topbar.titlebar.IconBackgroundDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonPresenter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cH\u0002J\u001e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J\"\u0010$\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0&J$\u0010'\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cJ,\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0&H\u0002J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000f\u0010.\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0002\u00100J\u0018\u00101\u001a\u0002022\u0006\u0010\u0012\u001a\u0002032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u0002022\u0006\u0010\u0012\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\"H\u0002J\u0010\u00107\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\"2\u0006\u00108\u001a\u00020/H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006;"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonPresenter;", "", "context", "Landroid/content/Context;", "button", "Lcom/reactnativenavigation/options/ButtonOptions;", "iconResolver", "Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/IconResolver;", "(Landroid/content/Context;Lcom/reactnativenavigation/options/ButtonOptions;Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/IconResolver;)V", "styledText", "Landroid/text/SpannableString;", "getStyledText", "()Landroid/text/SpannableString;", "applyAccessibilityLabel", "", "menuItem", "Landroid/view/MenuItem;", "applyAllCaps", "view", "Landroid/view/View;", "applyBackgroundColor", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "color", "Lcom/reactnativenavigation/options/params/ThemeColour;", "applyColor", "applyComponent", "viewCreator", "Lkotlin/Function0;", "applyDisabledColor", "disabledColor", "applyEnabled", "applyIcon", "applyIconBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "srcDrawable", "applyNavigationIcon", "onPress", "Lkotlin/Function1;", "applyOptions", "applyOptionsDirectlyOnView", "titleBar", "onViewFound", "applyShowAsAction", "applyTestId", "applyTextColor", "getIconColor", "", "()Ljava/lang/Integer;", "isIconButtonView", "", "Landroid/widget/TextView;", "isTextualButtonView", "setIconColor", "icon", "setLeftButtonTestId", "tint", "drawable", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ButtonPresenter {
    public static final int DISABLED_COLOR = -3355444;
    private final ButtonOptions button;
    private final Context context;
    private final IconResolver iconResolver;

    public ButtonPresenter(Context context, ButtonOptions button, IconResolver iconResolver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(iconResolver, "iconResolver");
        this.context = context;
        this.button = button;
        this.iconResolver = iconResolver;
    }

    public final SpannableString getStyledText() {
        SpannableString spannableString = new SpannableString(this.button.text.get(""));
        spannableString.setSpan(new ButtonSpan(this.context, this.button, null, 4, null), 0, this.button.text.length(), 34);
        return spannableString;
    }

    public void tint(Drawable drawable, int tint) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        drawable.setColorFilter(new PorterDuffColorFilter(tint, PorterDuff.Mode.SRC_IN));
    }

    public final void applyOptions(Toolbar toolbar, MenuItem menuItem, Function0<? extends View> viewCreator) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        applyShowAsAction(menuItem);
        applyEnabled(menuItem);
        applyComponent(menuItem, viewCreator);
        applyAccessibilityLabel(menuItem);
        applyIcon(menuItem);
        applyOptionsDirectlyOnView(toolbar, menuItem, new Function1<View, Unit>() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter.applyOptions.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ButtonPresenter.this.applyTestId(it2);
                ButtonPresenter.this.applyTextColor(it2);
                ButtonPresenter.this.applyAllCaps(it2);
            }
        });
    }

    public final void applyColor(Toolbar toolbar, MenuItem menuItem, ThemeColour color) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(color, "color");
        this.button.color = color;
        applyIcon(menuItem);
        applyOptionsDirectlyOnView(toolbar, menuItem, new Function1<View, Unit>() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter.applyColor.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ButtonPresenter.this.applyTextColor(it2);
            }
        });
    }

    public final void applyDisabledColor(Toolbar toolbar, MenuItem menuItem, ThemeColour disabledColor) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(disabledColor, "disabledColor");
        this.button.disabledColor = disabledColor;
        applyIcon(menuItem);
        applyOptionsDirectlyOnView(toolbar, menuItem, new Function1<View, Unit>() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter.applyDisabledColor.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ButtonPresenter.this.applyTextColor(it2);
            }
        });
    }

    public final void applyBackgroundColor(Toolbar toolbar, MenuItem menuItem, ThemeColour color) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(color, "color");
        this.button.iconBackground.color = color;
        applyIcon(menuItem);
    }

    private final void applyAccessibilityLabel(MenuItem menuItem) {
        if (this.button.accessibilityLabel.hasValue()) {
            if (this.button.component.hasValue()) {
                View actionView = menuItem.getActionView();
                if (actionView == null) {
                    return;
                }
                actionView.setContentDescription(this.button.accessibilityLabel.get());
                return;
            }
            MenuItemCompat.setContentDescription(menuItem, this.button.accessibilityLabel.get());
        }
    }

    private final void applyComponent(MenuItem menuItem, Function0<? extends View> viewCreator) {
        if (this.button.hasComponent()) {
            menuItem.setActionView(viewCreator.invoke());
        }
    }

    private final void applyEnabled(MenuItem menuItem) {
        menuItem.setEnabled(this.button.enabled.isTrueOrUndefined());
    }

    private final Drawable applyIconBackgroundDrawable(Drawable srcDrawable) {
        Integer num;
        if (!this.button.iconBackground.hasValue()) {
            return srcDrawable;
        }
        Integer num2 = this.button.iconBackground.width.get(Integer.valueOf(srcDrawable.getIntrinsicWidth()));
        Intrinsics.checkNotNull(num2);
        int iMax = Math.max(num2.intValue(), srcDrawable.getIntrinsicWidth());
        Integer num3 = this.button.iconBackground.height.get(Integer.valueOf(srcDrawable.getIntrinsicHeight()));
        Intrinsics.checkNotNull(num3);
        int iMax2 = Math.max(num3.intValue(), srcDrawable.getIntrinsicHeight());
        DensityPixel densityPixel = this.button.iconBackground.cornerRadius;
        if (this.button.enabled.isTrueOrUndefined()) {
            num = this.button.iconBackground.color.get(null);
        } else {
            num = this.button.iconBackground.disabledColor.get(null);
        }
        Intrinsics.checkNotNull(densityPixel);
        return new IconBackgroundDrawable(srcDrawable, densityPixel, iMax, iMax2, getIconColor(), num);
    }

    private final void applyIcon(final MenuItem menuItem) {
        if (this.button.hasIcon()) {
            this.iconResolver.resolve(this.button, new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter$$ExternalSyntheticLambda1
                @Override // com.reactnativenavigation.utils.Functions.Func1
                public final void run(Object obj) {
                    ButtonPresenter.applyIcon$lambda$4(this.f$0, menuItem, (Drawable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyIcon$lambda$4(ButtonPresenter this$0, MenuItem menuItem, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
        if (drawable != null) {
            this$0.setIconColor(drawable);
            menuItem.setIcon(this$0.applyIconBackgroundDrawable(drawable));
        }
    }

    private final void applyShowAsAction(MenuItem menuItem) {
        if (this.button.showAsAction.hasValue()) {
            Integer num = this.button.showAsAction.get();
            Intrinsics.checkNotNullExpressionValue(num, "get(...)");
            menuItem.setShowAsAction(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTestId(View view) {
        if (this.button.testId.hasValue()) {
            view.setTag(this.button.testId.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyTextColor(View view) {
        if (view instanceof TextView) {
            if (this.button.enabled.isTrueOrUndefined()) {
                if (this.button.color.hasValue()) {
                    ((TextView) view).setTextColor(this.button.color.get());
                }
            } else {
                Integer num = this.button.disabledColor.get(Integer.valueOf(DISABLED_COLOR));
                Intrinsics.checkNotNull(num);
                ((TextView) view).setTextColor(num.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyAllCaps(View view) {
        if (view instanceof TextView) {
            Boolean bool = this.button.allCaps.get(true);
            Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
            ((TextView) view).setAllCaps(bool.booleanValue());
        }
    }

    private final void applyOptionsDirectlyOnView(final Toolbar titleBar, final MenuItem menuItem, final Function1<? super View, Unit> onViewFound) {
        final Toolbar toolbar = titleBar;
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(toolbar, new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter$applyOptionsDirectlyOnView$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                if (this.button.hasComponent()) {
                    Function1 function1 = onViewFound;
                    View actionView = menuItem.getActionView();
                    Intrinsics.checkNotNull(actionView);
                    function1.invoke(actionView);
                }
                for (TextView textView : ViewUtils.findChildrenByClass((ActionMenuView) ViewUtils.findChildByClass(titleBar, ActionMenuView.class), TextView.class)) {
                    ButtonPresenter buttonPresenter = this;
                    Intrinsics.checkNotNull(textView);
                    if (buttonPresenter.isTextualButtonView(textView) || this.isIconButtonView(textView, menuItem)) {
                        onViewFound.invoke(textView);
                    }
                }
            }
        }), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isIconButtonView(TextView view, MenuItem menuItem) {
        return this.button.icon.hasValue() && ArrayUtils.contains(view.getCompoundDrawables(), menuItem.getIcon());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isTextualButtonView(TextView view) {
        return this.button.text.hasValue() && Intrinsics.areEqual(this.button.text.get(), view.getText().toString());
    }

    public final void applyNavigationIcon(final Toolbar toolbar, final Function1<? super ButtonOptions, Unit> onPress) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        this.iconResolver.resolve(this.button, new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ButtonPresenter.applyNavigationIcon$lambda$7(this.f$0, toolbar, onPress, (Drawable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyNavigationIcon$lambda$7(final ButtonPresenter this$0, Toolbar toolbar, final Function1 onPress, Drawable icon) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toolbar, "$toolbar");
        Intrinsics.checkNotNullParameter(onPress, "$onPress");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this$0.setIconColor(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ButtonPresenter.applyNavigationIcon$lambda$7$lambda$6(onPress, this$0, view);
            }
        });
        toolbar.setNavigationIcon((Drawable) null);
        toolbar.setNavigationIcon(icon);
        this$0.setLeftButtonTestId(toolbar);
        if (this$0.button.accessibilityLabel.hasValue()) {
            toolbar.setNavigationContentDescription(this$0.button.accessibilityLabel.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyNavigationIcon$lambda$7$lambda$6(Function1 onPress, ButtonPresenter this$0, View view) {
        Intrinsics.checkNotNullParameter(onPress, "$onPress");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onPress.invoke(this$0.button);
    }

    private final void setIconColor(Drawable icon) {
        Integer iconColor = getIconColor();
        if (iconColor != null) {
            tint(icon, iconColor.intValue());
        }
    }

    private final Integer getIconColor() {
        if (this.button.disableIconTint.isTrue()) {
            return null;
        }
        if (this.button.enabled.isTrueOrUndefined() && this.button.color.hasValue()) {
            return Integer.valueOf(this.button.color.get());
        }
        if (this.button.enabled.isFalse()) {
            return this.button.disabledColor.get(Integer.valueOf(DISABLED_COLOR));
        }
        return null;
    }

    private final void setLeftButtonTestId(final Toolbar toolbar) {
        if (this.button.testId.hasValue()) {
            toolbar.post(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ButtonPresenter.setLeftButtonTestId$lambda$10(toolbar, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLeftButtonTestId$lambda$10(Toolbar toolbar, ButtonPresenter this$0) {
        Intrinsics.checkNotNullParameter(toolbar, "$toolbar");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageButton imageButton = (ImageButton) ViewUtils.findChildByClass(toolbar, ImageButton.class);
        if (imageButton != null) {
            imageButton.setTag(this$0.button.testId.get());
            ViewCompat.setAccessibilityDelegate(imageButton, new AccessibilityDelegateCompat() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonPresenter$setLeftButtonTestId$1$1$WixAccessibilityDelegateCompat
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    String str = (String) host.getTag();
                    if (str != null) {
                        info.setViewIdResourceName(str);
                    }
                }
            });
        }
    }
}
