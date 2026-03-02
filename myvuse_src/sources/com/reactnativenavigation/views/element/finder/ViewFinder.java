package com.reactnativenavigation.views.element.finder;

import android.view.View;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ViewFinder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/finder/ViewFinder;", "", "find", "Landroid/view/View;", "root", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "nativeId", "", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public interface ViewFinder {
    Object find(ViewController<?> viewController, String str, Continuation<? super View> continuation);
}
