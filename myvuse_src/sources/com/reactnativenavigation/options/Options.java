package com.reactnativenavigation.options;

import android.content.Context;
import com.reactnativenavigation.options.layout.LayoutOptions;
import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Options {
    public static final Options EMPTY = new Options();
    public TopBarOptions topBar = new TopBarOptions();
    public TopTabsOptions topTabs = new TopTabsOptions();
    public TopTabOptions topTabOptions = new TopTabOptions();
    public BottomTabOptions bottomTabOptions = new BottomTabOptions();
    public BottomTabsOptions bottomTabsOptions = new BottomTabsOptions();
    public OverlayOptions overlayOptions = new OverlayOptions();
    public FabOptions fabOptions = new FabOptions();
    public AnimationsOptions animations = new AnimationsOptions();
    public SideMenuRootOptions sideMenuRootOptions = new SideMenuRootOptions();
    public ModalOptions modal = new ModalOptions();
    public NavigationBarOptions navigationBar = new NavigationBarOptions();
    public StatusBarOptions statusBar = new StatusBarOptions();
    public LayoutOptions layout = new LayoutOptions();
    public HardwareBackButtonOptions hardwareBack = new HardwareBackButtonOptions();

    public static Options parse(Context context, TypefaceLoader typefaceLoader, JSONObject jSONObject) {
        Options options = new Options();
        if (jSONObject == null) {
            return options;
        }
        options.topBar = TopBarOptions.parse(context, typefaceLoader, jSONObject.optJSONObject("topBar"));
        options.topTabs = TopTabsOptions.parse(context, jSONObject.optJSONObject("topTabs"));
        options.topTabOptions = TopTabOptions.parse(typefaceLoader, jSONObject.optJSONObject("topTab"));
        options.bottomTabOptions = BottomTabOptions.parse(context, typefaceLoader, jSONObject.optJSONObject("bottomTab"));
        options.bottomTabsOptions = BottomTabsOptions.parse(context, jSONObject.optJSONObject("bottomTabs"));
        options.overlayOptions = OverlayOptions.parse(jSONObject.optJSONObject("overlay"));
        options.fabOptions = FabOptions.parse(context, jSONObject.optJSONObject("fab"));
        options.sideMenuRootOptions = SideMenuRootOptions.parse(jSONObject.optJSONObject("sideMenu"));
        options.animations = AnimationsOptions.parse(jSONObject.optJSONObject("animations"));
        options.modal = ModalOptions.parse(jSONObject);
        options.navigationBar = NavigationBarOptions.parse(context, jSONObject.optJSONObject("navigationBar"));
        options.statusBar = StatusBarOptions.parse(context, jSONObject.optJSONObject("statusBar"));
        options.layout = LayoutOptions.parse(context, jSONObject.optJSONObject("layout"));
        options.hardwareBack = new HardwareBackButtonOptions(jSONObject.optJSONObject("hardwareBackButton"));
        return options;
    }

    void setTopTabIndex(int i) {
        this.topTabOptions.tabIndex = i;
    }

    public Options copy() {
        Options options = new Options();
        options.topBar.mergeWith(this.topBar);
        options.topTabs.mergeWith(this.topTabs);
        options.topTabOptions.mergeWith(this.topTabOptions);
        options.bottomTabOptions.mergeWith(this.bottomTabOptions);
        options.bottomTabsOptions.mergeWith(this.bottomTabsOptions);
        options.overlayOptions = this.overlayOptions;
        options.fabOptions.mergeWith(this.fabOptions);
        options.sideMenuRootOptions.mergeWith(this.sideMenuRootOptions);
        options.animations.mergeWith(this.animations);
        options.modal.mergeWith(this.modal);
        options.navigationBar.mergeWith(this.navigationBar);
        options.statusBar.mergeWith(this.statusBar);
        options.layout.mergeWith(this.layout);
        options.hardwareBack.mergeWith(this.hardwareBack);
        return options;
    }

    public Options mergeWith(Options options) {
        Options optionsCopy = copy();
        optionsCopy.topBar.mergeWith(options.topBar);
        optionsCopy.topTabs.mergeWith(options.topTabs);
        optionsCopy.topTabOptions.mergeWith(options.topTabOptions);
        optionsCopy.bottomTabOptions.mergeWith(options.bottomTabOptions);
        optionsCopy.bottomTabsOptions.mergeWith(options.bottomTabsOptions);
        optionsCopy.fabOptions.mergeWith(options.fabOptions);
        optionsCopy.animations.mergeWith(options.animations);
        optionsCopy.sideMenuRootOptions.mergeWith(options.sideMenuRootOptions);
        optionsCopy.modal.mergeWith(options.modal);
        optionsCopy.navigationBar.mergeWith(options.navigationBar);
        optionsCopy.statusBar.mergeWith(options.statusBar);
        optionsCopy.layout.mergeWith(options.layout);
        optionsCopy.hardwareBack.mergeWith(options.hardwareBack);
        return optionsCopy;
    }

    public Options withDefaultOptions(Options options) {
        this.topBar.mergeWithDefault(options.topBar);
        this.topTabOptions.mergeWithDefault(options.topTabOptions);
        this.topTabs.mergeWithDefault(options.topTabs);
        this.bottomTabOptions.mergeWithDefault(options.bottomTabOptions);
        this.bottomTabsOptions.mergeWithDefault(options.bottomTabsOptions);
        this.fabOptions.mergeWithDefault(options.fabOptions);
        this.animations.mergeWithDefault(options.animations);
        this.sideMenuRootOptions.mergeWithDefault(options.sideMenuRootOptions);
        this.modal.mergeWithDefault(options.modal);
        this.navigationBar.mergeWithDefault(options.navigationBar);
        this.statusBar.mergeWithDefault(options.statusBar);
        this.layout.mergeWithDefault(options.layout);
        this.hardwareBack.mergeWithDefault(options.hardwareBack);
        return this;
    }

    public Options clearTopBarOptions() {
        this.topBar = new TopBarOptions();
        return this;
    }

    public Options clearBottomTabsOptions() {
        this.bottomTabsOptions = new BottomTabsOptions();
        return this;
    }

    public Options clearTopTabOptions() {
        this.topTabOptions = new TopTabOptions();
        return this;
    }

    public Options clearTopTabsOptions() {
        this.topTabs = new TopTabsOptions();
        return this;
    }

    public Options clearBottomTabOptions() {
        this.bottomTabOptions = new BottomTabOptions();
        return this;
    }

    public Options clearAnimationOptions() {
        this.animations = new AnimationsOptions();
        return this;
    }

    public Options clearFabOptions() {
        this.fabOptions = new FabOptions();
        return this;
    }

    public Options clearOneTimeOptions() {
        this.bottomTabsOptions.currentTabId = new NullText();
        this.bottomTabsOptions.currentTabIndex = new NullNumber();
        return this;
    }
}
