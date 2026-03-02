package com.reactnativenavigation.viewcontrollers.stack.topbar.button;

import com.reactnativenavigation.views.stack.topbar.titlebar.TitleBarReactButtonView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ButtonController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
/* synthetic */ class ButtonController$addToMenu$1$1 extends FunctionReferenceImpl implements Function0<TitleBarReactButtonView> {
    ButtonController$addToMenu$1$1(Object obj) {
        super(0, obj, ButtonController.class, "getView", "getView()Landroid/view/ViewGroup;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TitleBarReactButtonView invoke() {
        return ((ButtonController) this.receiver).getView();
    }
}
