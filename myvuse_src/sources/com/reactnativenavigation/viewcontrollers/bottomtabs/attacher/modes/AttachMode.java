package com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes;

import android.view.ViewGroup;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.TabsAttachMode;
import com.reactnativenavigation.utils.CoordinatorLayoutUtils;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabFinder;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsPresenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.bottomtabs.BottomTabsBehaviour;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AttachMode {
    protected final BottomTabFinder bottomTabFinder;
    final ViewController<?> initialTab;
    protected final ViewGroup parent;
    protected final BottomTabsPresenter presenter;
    protected final List<ViewController<?>> tabs;

    public abstract void attach();

    public void destroy() {
    }

    public void onTabSelected(ViewController<?> viewController) {
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.modes.AttachMode$1 */
    static /* synthetic */ class C39831 {
        static final /* synthetic */ int[] $SwitchMap$com$reactnativenavigation$options$TabsAttachMode;

        static {
            int[] iArr = new int[TabsAttachMode.values().length];
            $SwitchMap$com$reactnativenavigation$options$TabsAttachMode = iArr;
            try {
                iArr[TabsAttachMode.AFTER_INITIAL_TAB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$TabsAttachMode[TabsAttachMode.ON_SWITCH_TO_TAB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$TabsAttachMode[TabsAttachMode.UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$reactnativenavigation$options$TabsAttachMode[TabsAttachMode.TOGETHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static AttachMode get(ViewGroup viewGroup, List<ViewController<?>> list, BottomTabsPresenter bottomTabsPresenter, Options options) {
        int i = C39831.$SwitchMap$com$reactnativenavigation$options$TabsAttachMode[options.bottomTabsOptions.tabsAttachMode.ordinal()];
        if (i == 1) {
            return new AfterInitialTab(viewGroup, list, bottomTabsPresenter, options);
        }
        if (i == 2) {
            return new OnSwitchToTab(viewGroup, list, bottomTabsPresenter, options);
        }
        return new Together(viewGroup, list, bottomTabsPresenter, options);
    }

    AttachMode(ViewGroup viewGroup, List<ViewController<?>> list, BottomTabsPresenter bottomTabsPresenter, Options options) {
        this.parent = viewGroup;
        this.tabs = list;
        this.presenter = bottomTabsPresenter;
        BottomTabFinder bottomTabFinder = new BottomTabFinder(list);
        this.bottomTabFinder = bottomTabFinder;
        int iFindByControllerId = options.bottomTabsOptions.currentTabId.hasValue() ? bottomTabFinder.findByControllerId(options.bottomTabsOptions.currentTabId.get()) : -1;
        this.initialTab = list.get(iFindByControllerId < 0 ? options.bottomTabsOptions.currentTabIndex.get(0).intValue() : iFindByControllerId);
    }

    public void attach(ViewController<?> viewController) {
        ViewGroup view = viewController.getView();
        view.setVisibility(viewController == this.initialTab ? 0 : 4);
        this.parent.addView(view, CoordinatorLayoutUtils.matchParentWithBehaviour(new BottomTabsBehaviour(viewController.getParentController())));
    }
}
