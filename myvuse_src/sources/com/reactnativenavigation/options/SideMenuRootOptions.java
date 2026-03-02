package com.reactnativenavigation.options;

import com.facebook.react.uimanager.ViewProps;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SideMenuRootOptions {
    public SideMenuOptions left = new SideMenuOptions();
    public SideMenuOptions right = new SideMenuOptions();

    public static SideMenuRootOptions parse(JSONObject jSONObject) {
        SideMenuRootOptions sideMenuRootOptions = new SideMenuRootOptions();
        if (jSONObject == null) {
            return sideMenuRootOptions;
        }
        sideMenuRootOptions.left = SideMenuOptions.parse(jSONObject.optJSONObject(ViewProps.LEFT));
        sideMenuRootOptions.right = SideMenuOptions.parse(jSONObject.optJSONObject(ViewProps.RIGHT));
        return sideMenuRootOptions;
    }

    public void mergeWith(SideMenuRootOptions sideMenuRootOptions) {
        this.left.mergeWith(sideMenuRootOptions.left);
        this.right.mergeWith(sideMenuRootOptions.right);
    }

    public void mergeWithDefault(SideMenuRootOptions sideMenuRootOptions) {
        this.left.mergeWithDefault(sideMenuRootOptions.left);
        this.right.mergeWithDefault(sideMenuRootOptions.right);
    }
}
