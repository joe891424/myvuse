package com.reactnativenavigation.react.events;

/* JADX INFO: loaded from: classes6.dex */
public enum ComponentType {
    Component("Component"),
    Button("TopBarButton"),
    Title("TopBarTitle"),
    Background("TopBarBackground");

    private String name;

    public String getName() {
        return this.name;
    }

    ComponentType(String str) {
        this.name = str;
    }
}
