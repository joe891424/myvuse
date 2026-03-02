package com.reactnativenavigation.views.element;

import com.salesforce.marketingcloud.UrlHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransitionSet.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\u0014\u0010\u0018\u001a\u00020\u00162\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\u0019\u001a\u00020\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0010¨\u0006\u001e"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/TransitionSet;", "", "()V", "isEmpty", "", "()Z", "transitions", "", "Lcom/reactnativenavigation/views/element/Transition;", "getTransitions", "()Ljava/util/List;", "validElementTransitions", "", "Lcom/reactnativenavigation/views/element/ElementTransition;", "getValidElementTransitions", "setValidElementTransitions", "(Ljava/util/List;)V", "validSharedElementTransitions", "Lcom/reactnativenavigation/views/element/SharedElementTransition;", "getValidSharedElementTransitions", "setValidSharedElementTransitions", "add", "", "transition", "addAll", "forEach", UrlHandler.ACTION, "Lkotlin/Function1;", "size", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TransitionSet {
    private List<SharedElementTransition> validSharedElementTransitions = new ArrayList();
    private List<ElementTransition> validElementTransitions = new ArrayList();

    public final List<SharedElementTransition> getValidSharedElementTransitions() {
        return this.validSharedElementTransitions;
    }

    public final void setValidSharedElementTransitions(List<SharedElementTransition> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.validSharedElementTransitions = list;
    }

    public final List<ElementTransition> getValidElementTransitions() {
        return this.validElementTransitions;
    }

    public final void setValidElementTransitions(List<ElementTransition> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.validElementTransitions = list;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final List<Transition> getTransitions() {
        return CollectionsKt.plus((Collection) this.validElementTransitions, (Iterable) this.validSharedElementTransitions);
    }

    public final void add(SharedElementTransition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.validSharedElementTransitions.add(transition);
    }

    public final void add(ElementTransition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.validElementTransitions.add(transition);
    }

    public final void addAll(List<? extends Transition> transitions) {
        Intrinsics.checkNotNullParameter(transitions, "transitions");
        for (Transition transition : transitions) {
            if (transition instanceof SharedElementTransition) {
                this.validSharedElementTransitions.add((SharedElementTransition) transition);
            } else if (transition instanceof ElementTransition) {
                this.validElementTransitions.add((ElementTransition) transition);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void forEach(Function1<? super Transition, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<T> it2 = this.validSharedElementTransitions.iterator();
        while (it2.hasNext()) {
            action.invoke(it2.next());
        }
        Iterator<T> it3 = this.validElementTransitions.iterator();
        while (it3.hasNext()) {
            action.invoke(it3.next());
        }
    }

    public final int size() {
        return this.validElementTransitions.size() + this.validSharedElementTransitions.size();
    }
}
