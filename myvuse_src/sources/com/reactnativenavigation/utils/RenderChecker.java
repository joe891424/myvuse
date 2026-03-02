package com.reactnativenavigation.utils;

import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public class RenderChecker {
    public boolean areRendered(Collection<ViewController<?>> collection) {
        return CollectionUtils.reduce((Collection) collection, true, new Functions.FuncR1() { // from class: com.reactnativenavigation.utils.RenderChecker$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return Boolean.valueOf(((ViewController) obj).isRendered());
            }
        }).booleanValue();
    }
}
