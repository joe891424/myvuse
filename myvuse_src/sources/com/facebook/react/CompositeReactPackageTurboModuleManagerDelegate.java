package com.facebook.react;

import com.facebook.jni.HybridData;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.turbomodule.core.TurboModuleManagerDelegate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CompositeReactPackageTurboModuleManagerDelegate extends ReactPackageTurboModuleManagerDelegate {
    private native void addTurboModuleManagerDelegate(TurboModuleManagerDelegate turboModuleManagerDelegate);

    @Override // com.facebook.react.turbomodule.core.TurboModuleManagerDelegate
    protected native HybridData initHybrid();

    private CompositeReactPackageTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<ReactPackage> list, List<TurboModuleManagerDelegate> list2) {
        super(reactApplicationContext, list);
        Iterator<TurboModuleManagerDelegate> it2 = list2.iterator();
        while (it2.hasNext()) {
            addTurboModuleManagerDelegate(it2.next());
        }
    }

    public static class Builder extends ReactPackageTurboModuleManagerDelegate.Builder {
        private final List<ReactPackageTurboModuleManagerDelegate.Builder> mDelegatesBuilder;

        public Builder(List<ReactPackageTurboModuleManagerDelegate.Builder> list) {
            this.mDelegatesBuilder = list;
        }

        @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.Builder
        protected ReactPackageTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<ReactPackageTurboModuleManagerDelegate.Builder> it2 = this.mDelegatesBuilder.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().build(reactApplicationContext, Collections.emptyList()));
            }
            return new CompositeReactPackageTurboModuleManagerDelegate(reactApplicationContext, list, arrayList);
        }
    }
}
