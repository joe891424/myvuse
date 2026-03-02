package com.zoontek.rnlocalize;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RNLocalizePackage extends TurboReactPackage {
    @Override // com.facebook.react.TurboReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(RNLocalizeModuleImpl.NAME)) {
            return new RNLocalizeModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.TurboReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.zoontek.rnlocalize.RNLocalizePackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNLocalizePackage.lambda$getReactModuleInfoProvider$0();
            }
        };
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap map = new HashMap();
        map.put(RNLocalizeModuleImpl.NAME, new ReactModuleInfo(RNLocalizeModuleImpl.NAME, RNLocalizeModuleImpl.NAME, false, false, true, false, false));
        return map;
    }
}
