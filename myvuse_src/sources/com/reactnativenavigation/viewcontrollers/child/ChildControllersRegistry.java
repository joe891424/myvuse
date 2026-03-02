package com.reactnativenavigation.viewcontrollers.child;

import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes6.dex */
public class ChildControllersRegistry {
    private ArrayDeque<ChildController<?>> children = new ArrayDeque<>();

    public void onViewAppeared(ChildController<?> childController) {
        this.children.push(childController);
    }

    public void onViewDisappear(ChildController<?> childController) {
        if (isTopChild(childController)) {
            this.children.pop();
            if (this.children.isEmpty()) {
                return;
            }
            this.children.peek().onViewBroughtToFront();
            return;
        }
        this.children.remove(childController);
    }

    private boolean isTopChild(final ChildController<?> childController) {
        return ((Boolean) ObjectUtils.perform(this.children.peek(), false, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return Boolean.valueOf(((ChildController) obj).equals(childController));
            }
        })).booleanValue();
    }

    public int size() {
        return this.children.size();
    }

    public void onChildDestroyed(ChildController<?> childController) {
        this.children.remove(childController);
    }
}
