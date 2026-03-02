package com.reactnativenavigation.options;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class LayoutNode {
    final List<LayoutNode> children;
    public final JSONObject data;

    /* JADX INFO: renamed from: id */
    public final String f4202id;
    public final Type type;

    public enum Type {
        Component,
        ExternalComponent,
        Stack,
        BottomTabs,
        SideMenuRoot,
        SideMenuCenter,
        SideMenuLeft,
        SideMenuRight,
        TopTabs
    }

    LayoutNode(String str, Type type) {
        this(str, type, new JSONObject(), new ArrayList());
    }

    public LayoutNode(String str, Type type, JSONObject jSONObject, List<LayoutNode> list) {
        this.f4202id = str;
        this.type = type;
        this.data = jSONObject;
        this.children = list;
    }

    JSONObject getOptions() {
        return this.data.optJSONObject("options");
    }
}
