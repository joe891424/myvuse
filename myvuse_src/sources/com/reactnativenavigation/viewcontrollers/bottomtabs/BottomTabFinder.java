package com.reactnativenavigation.viewcontrollers.bottomtabs;

import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class BottomTabFinder {
    private final List<ViewController<?>> tabs;

    public BottomTabFinder(List<ViewController<?>> list) {
        this.tabs = list;
    }

    public int findByControllerId(String str) {
        for (int i = 0; i < this.tabs.size(); i++) {
            if (this.tabs.get(i).findController(str) != null) {
                return i;
            }
        }
        return -1;
    }
}
