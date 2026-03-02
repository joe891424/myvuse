package com.reactnativenavigation.viewcontrollers.stack.topbar.button;

import android.app.Activity;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.reactnativenavigation.options.ButtonOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.react.events.ComponentType;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.YellowBoxDelegate;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay;
import com.reactnativenavigation.views.stack.topbar.titlebar.ButtonBar;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarButtonCreator;
import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarReactButtonView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00016B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016J\u001f\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J\u001f\u0010'\u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0000J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u001aH\u0016J\b\u00102\u001a\u00020\u001cH\u0017J\b\u00103\u001a\u00020\u001cH\u0017J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0012H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonController;", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleBarReactButtonView;", "Landroid/view/MenuItem$OnMenuItemClickListener;", "activity", "Landroid/app/Activity;", "presenter", "Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonPresenter;", "button", "Lcom/reactnativenavigation/options/ButtonOptions;", "viewCreator", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleBarButtonCreator;", "onPressListener", "Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonController$OnClickListener;", "(Landroid/app/Activity;Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonPresenter;Lcom/reactnativenavigation/options/ButtonOptions;Lcom/reactnativenavigation/views/stack/topbar/titlebar/TitleBarButtonCreator;Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonController$OnClickListener;)V", "getButton", "()Lcom/reactnativenavigation/options/ButtonOptions;", "buttonInstanceId", "", "getButtonInstanceId", "()Ljava/lang/String;", "buttonIntId", "", "getButtonIntId", "()I", "menuItem", "Landroid/view/MenuItem;", "addToMenu", "", "buttonBar", "Lcom/reactnativenavigation/views/stack/topbar/titlebar/ButtonBar;", "order", "applyBackgroundColor", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "color", "Lcom/reactnativenavigation/options/params/ThemeColour;", "(Landroidx/appcompat/widget/Toolbar;Lcom/reactnativenavigation/options/params/ThemeColour;)Lkotlin/Unit;", "applyColor", "applyDisabledColor", "disabledColour", "applyNavigationIcon", "areButtonsEqual", "", "other", "createView", "getCurrentComponentName", "isRendered", "onMenuItemClick", "item", "onViewDisappear", "onViewWillAppear", "sendOnNavigationButtonPressed", "buttonId", "OnClickListener", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ButtonController extends ViewController<TitleBarReactButtonView> implements MenuItem.OnMenuItemClickListener {
    private final ButtonOptions button;
    private MenuItem menuItem;
    private final OnClickListener onPressListener;
    private final ButtonPresenter presenter;
    private final TitleBarButtonCreator viewCreator;

    /* JADX INFO: compiled from: ButtonController.kt */
    @Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonController$OnClickListener;", "", "onPress", "", "button", "Lcom/reactnativenavigation/options/ButtonOptions;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public interface OnClickListener {
        void onPress(ButtonOptions button);
    }

    public final ButtonOptions getButton() {
        return this.button;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ButtonController(Activity activity, ButtonPresenter presenter, ButtonOptions button, TitleBarButtonCreator viewCreator, OnClickListener onPressListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(onPressListener, "onPressListener");
        Activity activity2 = activity;
        super(activity, button.f4200id, new YellowBoxDelegate(activity2), new Options(), new ViewControllerOverlay(activity2));
        this.presenter = presenter;
        this.button = button;
        this.viewCreator = viewCreator;
        this.onPressListener = onPressListener;
    }

    public final String getButtonInstanceId() {
        String instanceId = this.button.instanceId;
        Intrinsics.checkNotNullExpressionValue(instanceId, "instanceId");
        return instanceId;
    }

    public final int getButtonIntId() {
        return this.button.getIntId();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillAppear() {
        TitleBarReactButtonView view = getView();
        if (view != null) {
            view.sendComponentWillStart(ComponentType.Button);
        }
        TitleBarReactButtonView view2 = getView();
        if (view2 != null) {
            view2.sendComponentStart(ComponentType.Button);
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDisappear() {
        TitleBarReactButtonView view = getView();
        if (view != null) {
            view.sendComponentStop(ComponentType.Button);
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean isRendered() {
        return !this.button.component.componentId.hasValue() || super.isRendered();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String buttonId) {
        Intrinsics.checkNotNullParameter(buttonId, "buttonId");
        TitleBarReactButtonView view = getView();
        Intrinsics.checkNotNull(view);
        view.sendOnNavigationButtonPressed(buttonId);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public String getCurrentComponentName() {
        String str = this.button.component.name.get();
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return str;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public TitleBarReactButtonView createView() {
        TitleBarReactButtonView titleBarReactButtonViewCreate = this.viewCreator.create(getActivity(), this.button.component);
        this.view = titleBarReactButtonViewCreate;
        Intrinsics.checkNotNullExpressionValue(titleBarReactButtonViewCreate, "apply(...)");
        return titleBarReactButtonViewCreate;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.onPressListener.onPress(this.button);
        return true;
    }

    public final boolean areButtonsEqual(ButtonController other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other == this) {
            return true;
        }
        if (Intrinsics.areEqual(other.getId(), getId())) {
            return this.button.equals(other.button);
        }
        return false;
    }

    public final void applyNavigationIcon(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        this.presenter.applyNavigationIcon(toolbar, new Function1<ButtonOptions, Unit>() { // from class: com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController.applyNavigationIcon.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ButtonOptions buttonOptions) {
                invoke2(buttonOptions);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ButtonOptions it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                ButtonController.this.onPressListener.onPress(it2);
            }
        });
    }

    public Unit applyColor(Toolbar toolbar, ThemeColour color) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(color, "color");
        MenuItem menuItem = this.menuItem;
        if (menuItem == null) {
            return null;
        }
        this.presenter.applyColor(toolbar, menuItem, color);
        return Unit.INSTANCE;
    }

    public Unit applyDisabledColor(Toolbar toolbar, ThemeColour disabledColour) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(disabledColour, "disabledColour");
        MenuItem menuItem = this.menuItem;
        if (menuItem == null) {
            return null;
        }
        this.presenter.applyDisabledColor(toolbar, menuItem, disabledColour);
        return Unit.INSTANCE;
    }

    public Unit applyBackgroundColor(Toolbar toolbar, ThemeColour color) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(color, "color");
        MenuItem menuItem = this.menuItem;
        if (menuItem == null) {
            return null;
        }
        this.presenter.applyBackgroundColor(toolbar, menuItem, color);
        return Unit.INSTANCE;
    }

    public final void addToMenu(ButtonBar buttonBar, int order) {
        Intrinsics.checkNotNullParameter(buttonBar, "buttonBar");
        if (this.button.component.hasValue() && buttonBar.containsButton(this.menuItem, order)) {
            return;
        }
        buttonBar.getMenu().removeItem(this.button.getIntId());
        MenuItem menuItemAddButton = buttonBar.addButton(0, this.button.getIntId(), order, this.presenter.getStyledText());
        if (menuItemAddButton != null) {
            menuItemAddButton.setOnMenuItemClickListener(this);
            this.presenter.applyOptions(buttonBar, menuItemAddButton, new ButtonController$addToMenu$1$1(this));
        } else {
            menuItemAddButton = null;
        }
        this.menuItem = menuItemAddButton;
    }
}
