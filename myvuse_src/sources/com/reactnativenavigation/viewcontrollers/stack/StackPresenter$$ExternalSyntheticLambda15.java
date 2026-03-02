package com.reactnativenavigation.viewcontrollers.stack;

import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class StackPresenter$$ExternalSyntheticLambda15 implements CollectionUtils.Comparator {
    @Override // com.reactnativenavigation.utils.CollectionUtils.Comparator
    public final boolean compare(Object obj, Object obj2) {
        return ((ButtonController) obj).areButtonsEqual((ButtonController) obj2);
    }
}
