package com.tinder;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.tinder.StateMachine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 !*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u00020\u0002:\u0005!\"#$%B!\b\u0002\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0002\u0010\u0010JC\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002)\u0010\u0012\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016J#\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0018*\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J+\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e*\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u0015*\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u0015*\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001eJ\u001e\u0010 \u001a\u00020\u0015*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000eH\u0002R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m5598d2 = {"Lcom/tinder/StateMachine;", "STATE", "", "EVENT", "SIDE_EFFECT", "graph", "Lcom/tinder/StateMachine$Graph;", "(Lcom/tinder/StateMachine$Graph;)V", "state", "getState", "()Ljava/lang/Object;", "stateRef", "Ljava/util/concurrent/atomic/AtomicReference;", "transition", "Lcom/tinder/StateMachine$Transition;", NotificationCompat.CATEGORY_EVENT, "(Ljava/lang/Object;)Lcom/tinder/StateMachine$Transition;", "with", "init", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$GraphBuilder;", "", "Lkotlin/ExtensionFunctionType;", "getDefinition", "Lcom/tinder/StateMachine$Graph$State;", "(Ljava/lang/Object;)Lcom/tinder/StateMachine$Graph$State;", "getTransition", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$Transition;", "notifyOnEnter", HexAttribute.HEX_ATTR_CAUSE, "(Ljava/lang/Object;Ljava/lang/Object;)V", "notifyOnExit", "notifyOnTransition", "Companion", "Graph", "GraphBuilder", "Matcher", "Transition", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Graph<STATE, EVENT, SIDE_EFFECT> graph;
    private final AtomicReference<STATE> stateRef;

    private StateMachine(Graph<STATE, EVENT, SIDE_EFFECT> graph) {
        this.graph = graph;
        this.stateRef = new AtomicReference<>(graph.getInitialState());
    }

    public /* synthetic */ StateMachine(Graph graph, DefaultConstructorMarker defaultConstructorMarker) {
        this(graph);
    }

    public final STATE getState() {
        STATE state = this.stateRef.get();
        Intrinsics.checkExpressionValueIsNotNull(state, "stateRef.get()");
        return state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Transition<STATE, EVENT, SIDE_EFFECT> transition(EVENT event) {
        Transition<STATE, EVENT, SIDE_EFFECT> transition;
        Intrinsics.checkParameterIsNotNull(event, "event");
        synchronized (this) {
            STATE fromState = this.stateRef.get();
            Intrinsics.checkExpressionValueIsNotNull(fromState, "fromState");
            transition = getTransition(fromState, event);
            if (transition instanceof Transition.Valid) {
                this.stateRef.set((STATE) ((Transition.Valid) transition).getToState());
            }
        }
        notifyOnTransition(transition);
        if (transition instanceof Transition.Valid) {
            Transition.Valid valid = (Transition.Valid) transition;
            notifyOnExit(valid.getFromState(), event);
            notifyOnEnter(valid.getToState(), event);
        }
        return transition;
    }

    public final StateMachine<STATE, EVENT, SIDE_EFFECT> with(Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>, Unit> init) {
        Intrinsics.checkParameterIsNotNull(init, "init");
        return INSTANCE.create(Graph.copy$default(this.graph, getState(), null, null, 6, null), init);
    }

    private final Transition<STATE, EVENT, SIDE_EFFECT> getTransition(STATE state, EVENT event) {
        for (Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, Graph.State.TransitionTo<STATE, SIDE_EFFECT>>> entry : getDefinition(state).getTransitions().entrySet()) {
            Matcher<EVENT, EVENT> key = entry.getKey();
            Function2<STATE, EVENT, Graph.State.TransitionTo<STATE, SIDE_EFFECT>> value = entry.getValue();
            if (key.matches(event)) {
                Graph.State.TransitionTo<STATE, SIDE_EFFECT> transitionToInvoke = value.invoke(state, event);
                return new Transition.Valid(state, event, transitionToInvoke.component1(), transitionToInvoke.component2());
            }
        }
        return new Transition.Invalid(state, event);
    }

    private final Graph.State<STATE, EVENT, SIDE_EFFECT> getDefinition(STATE state) {
        Map<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions = this.graph.getStateDefinitions();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> entry : stateDefinitions.entrySet()) {
            if (entry.getKey().matches(state)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add((Graph.State) ((Map.Entry) it2.next()).getValue());
        }
        Graph.State<STATE, EVENT, SIDE_EFFECT> state2 = (Graph.State) CollectionsKt.firstOrNull((List) arrayList);
        if (state2 != null) {
            return state2;
        }
        throw new IllegalStateException(("Missing definition for state " + state.getClass().getSimpleName() + '!').toString());
    }

    private final void notifyOnEnter(STATE state, EVENT event) {
        Iterator<T> it2 = getDefinition(state).getOnEnterListeners().iterator();
        while (it2.hasNext()) {
            ((Function2) it2.next()).invoke(state, event);
        }
    }

    private final void notifyOnExit(STATE state, EVENT event) {
        Iterator<T> it2 = getDefinition(state).getOnExitListeners().iterator();
        while (it2.hasNext()) {
            ((Function2) it2.next()).invoke(state, event);
        }
    }

    private final void notifyOnTransition(Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT> transition) {
        Iterator<T> it2 = this.graph.getOnTransitionListeners().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(transition);
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0003\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0004\u0010\u0003 \u0001*\u00020\u0002*\n\b\u0005\u0010\u0004 \u0001*\u00020\u00022\u00020\u0002:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00028\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/tinder/StateMachine$Transition;", "STATE", "", "EVENT", "SIDE_EFFECT", "()V", NotificationCompat.CATEGORY_EVENT, "getEvent", "()Ljava/lang/Object;", "fromState", "getFromState", "Invalid", "Valid", "Lcom/tinder/StateMachine$Transition$Valid;", "Lcom/tinder/StateMachine$Transition$Invalid;", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
    public static abstract class Transition<STATE, EVENT, SIDE_EFFECT> {
        public abstract EVENT getEvent();

        public abstract STATE getFromState();

        private Transition() {
        }

        public /* synthetic */ Transition(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0006\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0007\u0010\u0003 \u0001*\u00020\u0002*\n\b\b\u0010\u0004 \u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0005B)\b\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0007\u0012\u0006\u0010\b\u001a\u00028\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00018\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00018\bHÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u00072\b\b\u0002\u0010\b\u001a\u00028\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0007\u001a\u00028\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00028\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00018\b¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, m5598d2 = {"Lcom/tinder/StateMachine$Transition$Valid;", "STATE", "", "EVENT", "SIDE_EFFECT", "Lcom/tinder/StateMachine$Transition;", "fromState", NotificationCompat.CATEGORY_EVENT, "toState", "sideEffect", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getEvent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFromState", "getSideEffect", "getToState", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$Transition$Valid;", "equals", "", "other", "hashCode", "", "toString", "", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
        public static final /* data */ class Valid<STATE, EVENT, SIDE_EFFECT> extends Transition<STATE, EVENT, SIDE_EFFECT> {
            private final EVENT event;
            private final STATE fromState;
            private final SIDE_EFFECT sideEffect;
            private final STATE toState;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, Object obj, Object obj2, Object obj3, Object obj4, int i, Object obj5) {
                if ((i & 1) != 0) {
                    obj = valid.getFromState();
                }
                if ((i & 2) != 0) {
                    obj2 = valid.getEvent();
                }
                if ((i & 4) != 0) {
                    obj3 = valid.toState;
                }
                if ((i & 8) != 0) {
                    obj4 = valid.sideEffect;
                }
                return valid.copy(obj, obj2, obj3, obj4);
            }

            public final STATE component1() {
                return getFromState();
            }

            public final EVENT component2() {
                return getEvent();
            }

            public final STATE component3() {
                return this.toState;
            }

            public final SIDE_EFFECT component4() {
                return this.sideEffect;
            }

            public final Valid<STATE, EVENT, SIDE_EFFECT> copy(STATE fromState, EVENT event, STATE toState, SIDE_EFFECT sideEffect) {
                Intrinsics.checkParameterIsNotNull(fromState, "fromState");
                Intrinsics.checkParameterIsNotNull(event, "event");
                Intrinsics.checkParameterIsNotNull(toState, "toState");
                return new Valid<>(fromState, event, toState, sideEffect);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics.areEqual(getFromState(), valid.getFromState()) && Intrinsics.areEqual(getEvent(), valid.getEvent()) && Intrinsics.areEqual(this.toState, valid.toState) && Intrinsics.areEqual(this.sideEffect, valid.sideEffect);
            }

            public int hashCode() {
                STATE fromState = getFromState();
                int iHashCode = (fromState != null ? fromState.hashCode() : 0) * 31;
                EVENT event = getEvent();
                int iHashCode2 = (iHashCode + (event != null ? event.hashCode() : 0)) * 31;
                STATE state = this.toState;
                int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
                SIDE_EFFECT side_effect = this.sideEffect;
                return iHashCode3 + (side_effect != null ? side_effect.hashCode() : 0);
            }

            public String toString() {
                return "Valid(fromState=" + getFromState() + ", event=" + getEvent() + ", toState=" + this.toState + ", sideEffect=" + this.sideEffect + ")";
            }

            @Override // com.tinder.StateMachine.Transition
            public STATE getFromState() {
                return this.fromState;
            }

            @Override // com.tinder.StateMachine.Transition
            public EVENT getEvent() {
                return this.event;
            }

            public final STATE getToState() {
                return this.toState;
            }

            public final SIDE_EFFECT getSideEffect() {
                return this.sideEffect;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(STATE fromState, EVENT event, STATE toState, SIDE_EFFECT side_effect) {
                super(null);
                Intrinsics.checkParameterIsNotNull(fromState, "fromState");
                Intrinsics.checkParameterIsNotNull(event, "event");
                Intrinsics.checkParameterIsNotNull(toState, "toState");
                this.fromState = fromState;
                this.event = event;
                this.toState = toState;
                this.sideEffect = side_effect;
            }
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0006\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0007\u0010\u0003 \u0001*\u00020\u0002*\n\b\b\u0010\u0004 \u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ4\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u0007HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0007\u001a\u00028\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00028\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, m5598d2 = {"Lcom/tinder/StateMachine$Transition$Invalid;", "STATE", "", "EVENT", "SIDE_EFFECT", "Lcom/tinder/StateMachine$Transition;", "fromState", NotificationCompat.CATEGORY_EVENT, "(Ljava/lang/Object;Ljava/lang/Object;)V", "getEvent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFromState", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$Transition$Invalid;", "equals", "", "other", "hashCode", "", "toString", "", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
        public static final /* data */ class Invalid<STATE, EVENT, SIDE_EFFECT> extends Transition<STATE, EVENT, SIDE_EFFECT> {
            private final EVENT event;
            private final STATE fromState;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Invalid copy$default(Invalid invalid, Object obj, Object obj2, int i, Object obj3) {
                if ((i & 1) != 0) {
                    obj = invalid.getFromState();
                }
                if ((i & 2) != 0) {
                    obj2 = invalid.getEvent();
                }
                return invalid.copy(obj, obj2);
            }

            public final STATE component1() {
                return getFromState();
            }

            public final EVENT component2() {
                return getEvent();
            }

            public final Invalid<STATE, EVENT, SIDE_EFFECT> copy(STATE fromState, EVENT event) {
                Intrinsics.checkParameterIsNotNull(fromState, "fromState");
                Intrinsics.checkParameterIsNotNull(event, "event");
                return new Invalid<>(fromState, event);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invalid)) {
                    return false;
                }
                Invalid invalid = (Invalid) other;
                return Intrinsics.areEqual(getFromState(), invalid.getFromState()) && Intrinsics.areEqual(getEvent(), invalid.getEvent());
            }

            public int hashCode() {
                STATE fromState = getFromState();
                int iHashCode = (fromState != null ? fromState.hashCode() : 0) * 31;
                EVENT event = getEvent();
                return iHashCode + (event != null ? event.hashCode() : 0);
            }

            public String toString() {
                return "Invalid(fromState=" + getFromState() + ", event=" + getEvent() + ")";
            }

            @Override // com.tinder.StateMachine.Transition
            public STATE getFromState() {
                return this.fromState;
            }

            @Override // com.tinder.StateMachine.Transition
            public EVENT getEvent() {
                return this.event;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Invalid(STATE fromState, EVENT event) {
                super(null);
                Intrinsics.checkParameterIsNotNull(fromState, "fromState");
                Intrinsics.checkParameterIsNotNull(event, "event");
                this.fromState = fromState;
                this.event = event;
            }
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u0002*\b\b\u0004\u0010\u0003*\u00020\u0002*\b\b\u0005\u0010\u0004*\u00020\u00022\u00020\u0002:\u0001#Bk\u0012\u0006\u0010\u0005\u001a\u00028\u0003\u00120\u0010\u0006\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t0\u0007\u0012*\u0010\n\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0017\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J3\u0010\u0018\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t0\u0007HÆ\u0003J-\u0010\u0019\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bHÆ\u0003J\u008c\u0001\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u000322\b\u0002\u0010\u0006\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t0\u00072,\b\u0002\u0010\n\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R5\u0010\n\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R;\u0010\u0006\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, m5598d2 = {"Lcom/tinder/StateMachine$Graph;", "STATE", "", "EVENT", "SIDE_EFFECT", "initialState", "stateDefinitions", "", "Lcom/tinder/StateMachine$Matcher;", "Lcom/tinder/StateMachine$Graph$State;", "onTransitionListeners", "", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$Transition;", "", "(Ljava/lang/Object;Ljava/util/Map;Ljava/util/List;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getOnTransitionListeners", "()Ljava/util/List;", "getStateDefinitions", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/util/Map;Ljava/util/List;)Lcom/tinder/StateMachine$Graph;", "equals", "", "other", "hashCode", "", "toString", "", "State", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
    public static final /* data */ class Graph<STATE, EVENT, SIDE_EFFECT> {
        private final STATE initialState;
        private final List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners;
        private final Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Graph copy$default(Graph graph, Object obj, Map map, List list, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = graph.initialState;
            }
            if ((i & 2) != 0) {
                map = graph.stateDefinitions;
            }
            if ((i & 4) != 0) {
                list = graph.onTransitionListeners;
            }
            return graph.copy(obj, map, list);
        }

        public final STATE component1() {
            return this.initialState;
        }

        public final Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> component2() {
            return this.stateDefinitions;
        }

        public final List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> component3() {
            return this.onTransitionListeners;
        }

        public final Graph<STATE, EVENT, SIDE_EFFECT> copy(STATE initialState, Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions, List<? extends Function1<? super Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners) {
            Intrinsics.checkParameterIsNotNull(initialState, "initialState");
            Intrinsics.checkParameterIsNotNull(stateDefinitions, "stateDefinitions");
            Intrinsics.checkParameterIsNotNull(onTransitionListeners, "onTransitionListeners");
            return new Graph<>(initialState, stateDefinitions, onTransitionListeners);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Graph)) {
                return false;
            }
            Graph graph = (Graph) other;
            return Intrinsics.areEqual(this.initialState, graph.initialState) && Intrinsics.areEqual(this.stateDefinitions, graph.stateDefinitions) && Intrinsics.areEqual(this.onTransitionListeners, graph.onTransitionListeners);
        }

        public int hashCode() {
            STATE state = this.initialState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> map = this.stateDefinitions;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> list = this.onTransitionListeners;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Graph(initialState=" + this.initialState + ", stateDefinitions=" + this.stateDefinitions + ", onTransitionListeners=" + this.onTransitionListeners + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Graph(STATE initialState, Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions, List<? extends Function1<? super Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners) {
            Intrinsics.checkParameterIsNotNull(initialState, "initialState");
            Intrinsics.checkParameterIsNotNull(stateDefinitions, "stateDefinitions");
            Intrinsics.checkParameterIsNotNull(onTransitionListeners, "onTransitionListeners");
            this.initialState = initialState;
            this.stateDefinitions = stateDefinitions;
            this.onTransitionListeners = onTransitionListeners;
        }

        public final STATE getInitialState() {
            return this.initialState;
        }

        public final Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> getStateDefinitions() {
            return this.stateDefinitions;
        }

        public final List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> getOnTransitionListeners() {
            return this.onTransitionListeners;
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0006\u0010\u0001*\u00020\u0002*\b\b\u0007\u0010\u0003*\u00020\u0002*\b\b\b\u0010\u0004*\u00020\u00022\u00020\u0002:\u0001\u0015B\u0007\b\u0000¢\u0006\u0002\u0010\u0005R)\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0081\u0001\u0010\u000e\u001ar\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\u00070\u0010\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\b0\u00110\b0\u000fj8\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\u00070\u0010\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\b0\u00110\b`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m5598d2 = {"Lcom/tinder/StateMachine$Graph$State;", "STATE", "", "EVENT", "SIDE_EFFECT", "()V", "onEnterListeners", "", "Lkotlin/Function2;", "", "getOnEnterListeners", "()Ljava/util/List;", "onExitListeners", "getOnExitListeners", "transitions", "Ljava/util/LinkedHashMap;", "Lcom/tinder/StateMachine$Matcher;", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lkotlin/collections/LinkedHashMap;", "getTransitions", "()Ljava/util/LinkedHashMap;", "TransitionTo", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
        public static final class State<STATE, EVENT, SIDE_EFFECT> {
            private final List<Function2<STATE, EVENT, Unit>> onEnterListeners = new ArrayList();
            private final List<Function2<STATE, EVENT, Unit>> onExitListeners = new ArrayList();
            private final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, TransitionTo<STATE, SIDE_EFFECT>>> transitions = new LinkedHashMap<>();

            public final List<Function2<STATE, EVENT, Unit>> getOnEnterListeners() {
                return this.onEnterListeners;
            }

            public final List<Function2<STATE, EVENT, Unit>> getOnExitListeners() {
                return this.onExitListeners;
            }

            public final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, TransitionTo<STATE, SIDE_EFFECT>>> getTransitions() {
                return this.transitions;
            }

            /* JADX INFO: compiled from: StateMachine.kt */
            @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\t\u0010\u0001 \u0001*\u00020\u0002*\n\b\n\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00028\t\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\n¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00028\tHÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00018\nHÆ\u0003¢\u0006\u0002\u0010\bJ0\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n0\u00002\b\b\u0002\u0010\u0004\u001a\u00028\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\nHÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\n¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00028\t¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, m5598d2 = {"Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "STATE", "", "SIDE_EFFECT", "toState", "sideEffect", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getSideEffect", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getToState", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "equals", "", "other", "hashCode", "", "toString", "", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
            public static final /* data */ class TransitionTo<STATE, SIDE_EFFECT> {
                private final SIDE_EFFECT sideEffect;
                private final STATE toState;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ TransitionTo copy$default(TransitionTo transitionTo, Object obj, Object obj2, int i, Object obj3) {
                    if ((i & 1) != 0) {
                        obj = transitionTo.toState;
                    }
                    if ((i & 2) != 0) {
                        obj2 = transitionTo.sideEffect;
                    }
                    return transitionTo.copy(obj, obj2);
                }

                public final STATE component1() {
                    return this.toState;
                }

                public final SIDE_EFFECT component2() {
                    return this.sideEffect;
                }

                public final TransitionTo<STATE, SIDE_EFFECT> copy(STATE toState, SIDE_EFFECT sideEffect) {
                    Intrinsics.checkParameterIsNotNull(toState, "toState");
                    return new TransitionTo<>(toState, sideEffect);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof TransitionTo)) {
                        return false;
                    }
                    TransitionTo transitionTo = (TransitionTo) other;
                    return Intrinsics.areEqual(this.toState, transitionTo.toState) && Intrinsics.areEqual(this.sideEffect, transitionTo.sideEffect);
                }

                public int hashCode() {
                    STATE state = this.toState;
                    int iHashCode = (state != null ? state.hashCode() : 0) * 31;
                    SIDE_EFFECT side_effect = this.sideEffect;
                    return iHashCode + (side_effect != null ? side_effect.hashCode() : 0);
                }

                public String toString() {
                    return "TransitionTo(toState=" + this.toState + ", sideEffect=" + this.sideEffect + ")";
                }

                public TransitionTo(STATE toState, SIDE_EFFECT side_effect) {
                    Intrinsics.checkParameterIsNotNull(toState, "toState");
                    this.toState = toState;
                    this.sideEffect = side_effect;
                }

                public final STATE getToState() {
                    return this.toState;
                }

                public final SIDE_EFFECT getSideEffect() {
                    return this.sideEffect;
                }
            }
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0011*\b\b\u0003\u0010\u0001*\u00020\u0002*\n\b\u0004\u0010\u0003 \u0001*\u0002H\u00012\u00020\u0002:\u0001\u0011B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00040\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0003¢\u0006\u0002\u0010\rJ+\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00002\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00040\u0005X\u0088\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/tinder/StateMachine$Matcher;", ExifInterface.GPS_DIRECTION_TRUE, "", "R", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "predicates", "", "Lkotlin/Function1;", "", "matches", "value", "(Ljava/lang/Object;)Z", "where", "predicate", "Lkotlin/ExtensionFunctionType;", "Companion", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
    public static final class Matcher<T, R extends T> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Class<R> clazz;
        private final List<Function1<T, Boolean>> predicates;

        private Matcher(Class<R> cls) {
            this.clazz = cls;
            this.predicates = CollectionsKt.mutableListOf(new Function1<T, Boolean>() { // from class: com.tinder.StateMachine$Matcher$predicates$1
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return Boolean.valueOf(invoke2(obj));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(T it2) {
                    Intrinsics.checkParameterIsNotNull(it2, "it");
                    return this.this$0.clazz.isInstance(it2);
                }
            });
        }

        public /* synthetic */ Matcher(Class cls, DefaultConstructorMarker defaultConstructorMarker) {
            this(cls);
        }

        public final Matcher<T, R> where(final Function1<? super R, Boolean> predicate) {
            Intrinsics.checkParameterIsNotNull(predicate, "predicate");
            this.predicates.add(new Function1<T, Boolean>() { // from class: com.tinder.StateMachine$Matcher$where$$inlined$apply$lambda$1
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return Boolean.valueOf(invoke2(obj));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(T it2) {
                    Intrinsics.checkParameterIsNotNull(it2, "it");
                    return ((Boolean) predicate.invoke(it2)).booleanValue();
                }
            });
            return this;
        }

        public final boolean matches(T value) {
            Intrinsics.checkParameterIsNotNull(value, "value");
            List<Function1<T, Boolean>> list = this.predicates;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (!((Boolean) ((Function1) it2.next()).invoke(value)).booleanValue()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0005\u0010\u0005*\u00020\u0001\"\n\b\u0006\u0010\u0006\u0018\u0001*\u0002H\u0005H\u0086\bJ4\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0005\u0010\u0005*\u00020\u0001\"\b\b\u0006\u0010\u0006*\u0002H\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bJ8\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0005\u0010\u0005*\u00020\u0001\"\n\b\u0006\u0010\u0006\u0018\u0001*\u0002H\u00052\u0006\u0010\n\u001a\u0002H\u0006H\u0086\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m5598d2 = {"Lcom/tinder/StateMachine$Matcher$Companion;", "", "()V", "any", "Lcom/tinder/StateMachine$Matcher;", ExifInterface.GPS_DIRECTION_TRUE, "R", "clazz", "Ljava/lang/Class;", "eq", "value", "(Ljava/lang/Object;)Lcom/tinder/StateMachine$Matcher;", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final <T, R extends T> Matcher<T, R> any(Class<R> clazz) {
                Intrinsics.checkParameterIsNotNull(clazz, "clazz");
                return new Matcher<>(clazz, null);
            }

            private final <T, R extends T> Matcher<T, R> any() {
                Intrinsics.reifiedOperationMarker(4, "R");
                return any(Object.class);
            }

            /* JADX INFO: renamed from: eq */
            private final <T, R extends T> Matcher<T, R> m4367eq(R value) {
                Intrinsics.reifiedOperationMarker(4, "R");
                return any(Object.class).where(new StateMachine$Matcher$Companion$eq$1(value));
            }
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u0002*\b\b\u0004\u0010\u0003*\u00020\u0002*\b\b\u0005\u0010\u0004*\u00020\u00022\u00020\u0002:\u0001!B#\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0006J\u0013\u0010\b\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0003¢\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u00020\u000e2$\u0010\u0019\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\fJY\u0010\u001a\u001a\u00020\u000e\"\n\b\u0006\u0010\u001b\u0018\u0001*\u00028\u00032\u0006\u0010\u001a\u001a\u0002H\u001b25\b\b\u0010\u001c\u001a/\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u001b0\u001dR\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0000\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u001eH\u0086\b¢\u0006\u0002\u0010\u001fJL\u0010\u001a\u001a\u00020\u000e\"\n\b\u0006\u0010\u001b\u0018\u0001*\u00028\u000325\b\b\u0010\u001c\u001a/\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u001b0\u001dR\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0000\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u001eH\u0086\bJY\u0010\u001a\u001a\u00020\u000e\"\b\b\u0006\u0010\u001b*\u00028\u00032\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u0002H\u001b0\u001323\u0010\u001c\u001a/\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u001b0\u001dR\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0000\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u001eR\u0012\u0010\b\u001a\u0004\u0018\u00018\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR§\u0001\u0010\n\u001a\u009a\u0001\u0012H\u0012F\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e \u000f*\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\f0\u000bjL\u0012H\u0012F\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e \u000f*\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RÃ\u0001\u0010\u0011\u001a¶\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003 \u000f*\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00130\u0013\u00120\u0012.\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005 \u000f*\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u00140\u00140\u0012jZ\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003 \u000f*\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00130\u0013\u00120\u0012.\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005 \u000f*\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u00140\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m5598d2 = {"Lcom/tinder/StateMachine$GraphBuilder;", "STATE", "", "EVENT", "SIDE_EFFECT", "graph", "Lcom/tinder/StateMachine$Graph;", "(Lcom/tinder/StateMachine$Graph;)V", "initialState", "Ljava/lang/Object;", "onTransitionListeners", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$Transition;", "", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "stateDefinitions", "Ljava/util/LinkedHashMap;", "Lcom/tinder/StateMachine$Matcher;", "Lcom/tinder/StateMachine$Graph$State;", "Lkotlin/collections/LinkedHashMap;", "build", "(Ljava/lang/Object;)V", "onTransition", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "state", ExifInterface.LATITUDE_SOUTH, "init", "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "stateMatcher", "StateDefinitionBuilder", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {
        private STATE initialState;
        private final ArrayList<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners;
        private final LinkedHashMap<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions;

        /* JADX WARN: Multi-variable type inference failed */
        public GraphBuilder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public GraphBuilder(Graph<STATE, EVENT, SIDE_EFFECT> graph) {
            List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners;
            Map<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions;
            this.initialState = graph != null ? graph.getInitialState() : null;
            this.stateDefinitions = new LinkedHashMap<>((graph == null || (stateDefinitions = graph.getStateDefinitions()) == null) ? MapsKt.emptyMap() : stateDefinitions);
            this.onTransitionListeners = new ArrayList<>((graph == null || (onTransitionListeners = graph.getOnTransitionListeners()) == null) ? CollectionsKt.emptyList() : onTransitionListeners);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ GraphBuilder(Graph graph, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                graph = null;
            }
            this(graph);
        }

        public final void initialState(STATE initialState) {
            Intrinsics.checkParameterIsNotNull(initialState, "initialState");
            this.initialState = initialState;
        }

        public final <S extends STATE> void state(Matcher<STATE, ? extends S> stateMatcher, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> init) {
            Intrinsics.checkParameterIsNotNull(stateMatcher, "stateMatcher");
            Intrinsics.checkParameterIsNotNull(init, "init");
            LinkedHashMap<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> linkedHashMap = this.stateDefinitions;
            StateDefinitionBuilder stateDefinitionBuilder = new StateDefinitionBuilder();
            init.invoke(stateDefinitionBuilder);
            linkedHashMap.put(stateMatcher, stateDefinitionBuilder.build());
        }

        private final <S extends STATE> void state(Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> init) {
            Matcher.Companion companion = Matcher.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
            state((Matcher) companion.any(Object.class), (Function1) init);
        }

        private final <S extends STATE> void state(S state, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> init) {
            Matcher.Companion companion = Matcher.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
            state((Matcher) companion.any(Object.class).where(new StateMachine$Matcher$Companion$eq$1(state)), (Function1) init);
        }

        public final void onTransition(Function1<? super Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit> listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            this.onTransitionListeners.add(listener);
        }

        public final Graph<STATE, EVENT, SIDE_EFFECT> build() {
            STATE state = this.initialState;
            if (state != null) {
                return new Graph<>(state, MapsKt.toMap(this.stateDefinitions), CollectionsKt.toList(this.onTransitionListeners));
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0004\u0018\u0000*\b\b\u0006\u0010\u0001*\u00028\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u0002H\b0\u0007\"\n\b\u0007\u0010\b\u0018\u0001*\u00028\u0004H\u0086\bJ\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005J.\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u0002H\u000b0\u0007\"\n\b\u0007\u0010\u000b\u0018\u0001*\u00028\u00042\u0006\u0010\f\u001a\u0002H\u000bH\u0086\b¢\u0006\u0002\u0010\rJO\u0010\u000e\u001a\u00020\u000f\"\n\b\u0007\u0010\b\u0018\u0001*\u00028\u00042\u0006\u0010\u0010\u001a\u0002H\b2+\b\b\u0010\u0011\u001a%\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u0002H\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u00130\u0012¢\u0006\u0002\b\u0014H\u0086\b¢\u0006\u0002\u0010\u0015JB\u0010\u000e\u001a\u00020\u000f\"\n\b\u0007\u0010\b\u0018\u0001*\u00028\u00042+\b\b\u0010\u0011\u001a%\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u0002H\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u00130\u0012¢\u0006\u0002\b\u0014H\u0086\bJO\u0010\u000e\u001a\u00020\u000f\"\b\b\u0007\u0010\b*\u00028\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u0002H\b0\u00072)\u0010\u0011\u001a%\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u0002H\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u00130\u0012¢\u0006\u0002\b\u0014J%\u0010\u0017\u001a\u00020\u00182\u001d\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0002\b\u0014J%\u0010\u001a\u001a\u00020\u00182\u001d\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0002\b\u0014J'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u0013*\u00028\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00018\u0005¢\u0006\u0002\u0010\u001dJ/\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u0013*\u00028\u00062\u0006\u0010\u001f\u001a\u00028\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00018\u0005¢\u0006\u0002\u0010 R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m5598d2 = {"Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", ExifInterface.LATITUDE_SOUTH, "", "(Lcom/tinder/StateMachine$GraphBuilder;)V", "stateDefinition", "Lcom/tinder/StateMachine$Graph$State;", "any", "Lcom/tinder/StateMachine$Matcher;", ExifInterface.LONGITUDE_EAST, "build", "eq", "R", "value", "(Ljava/lang/Object;)Lcom/tinder/StateMachine$Matcher;", "on", "", NotificationCompat.CATEGORY_EVENT, "createTransitionTo", "Lkotlin/Function2;", "Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "eventMatcher", "onEnter", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onExit", "dontTransition", "sideEffect", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "transitionTo", "state", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$Graph$State$TransitionTo;", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
        public final class StateDefinitionBuilder<S extends STATE> {
            private final Graph.State<STATE, EVENT, SIDE_EFFECT> stateDefinition = new Graph.State<>();

            public StateDefinitionBuilder() {
            }

            private final <E extends EVENT> Matcher<EVENT, E> any() {
                Matcher.Companion companion = Matcher.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_EAST);
                return companion.any(Object.class);
            }

            /* JADX INFO: renamed from: eq */
            private final <R extends EVENT> Matcher<EVENT, R> m4363eq(R value) {
                Matcher.Companion companion = Matcher.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "R");
                return companion.any(Object.class).where(new StateMachine$Matcher$Companion$eq$1(value));
            }

            /* JADX INFO: renamed from: on */
            public final <E extends EVENT> void m4366on(Matcher<EVENT, ? extends E> eventMatcher, final Function2<? super S, ? super E, ? extends Graph.State.TransitionTo<? extends STATE, ? extends SIDE_EFFECT>> createTransitionTo) {
                Intrinsics.checkParameterIsNotNull(eventMatcher, "eventMatcher");
                Intrinsics.checkParameterIsNotNull(createTransitionTo, "createTransitionTo");
                this.stateDefinition.getTransitions().put(eventMatcher, new Function2<STATE, EVENT, Graph.State.TransitionTo<? extends STATE, ? extends SIDE_EFFECT>>() { // from class: com.tinder.StateMachine$GraphBuilder$StateDefinitionBuilder$on$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final StateMachine.Graph.State.TransitionTo<STATE, SIDE_EFFECT> invoke(STATE state, EVENT event) {
                        Intrinsics.checkParameterIsNotNull(state, "state");
                        Intrinsics.checkParameterIsNotNull(event, "event");
                        return (StateMachine.Graph.State.TransitionTo) createTransitionTo.invoke(state, event);
                    }
                });
            }

            public final boolean onEnter(final Function2<? super S, ? super EVENT, Unit> listener) {
                Intrinsics.checkParameterIsNotNull(listener, "listener");
                return this.stateDefinition.getOnEnterListeners().add(new Function2<STATE, EVENT, Unit>() { // from class: com.tinder.StateMachine$GraphBuilder$StateDefinitionBuilder$onEnter$$inlined$with$lambda$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                        invoke2(obj, obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(STATE state, EVENT cause) {
                        Intrinsics.checkParameterIsNotNull(state, "state");
                        Intrinsics.checkParameterIsNotNull(cause, "cause");
                        listener.invoke(state, cause);
                    }
                });
            }

            public final boolean onExit(final Function2<? super S, ? super EVENT, Unit> listener) {
                Intrinsics.checkParameterIsNotNull(listener, "listener");
                return this.stateDefinition.getOnExitListeners().add(new Function2<STATE, EVENT, Unit>() { // from class: com.tinder.StateMachine$GraphBuilder$StateDefinitionBuilder$onExit$$inlined$with$lambda$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                        invoke2(obj, obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(STATE state, EVENT cause) {
                        Intrinsics.checkParameterIsNotNull(state, "state");
                        Intrinsics.checkParameterIsNotNull(cause, "cause");
                        listener.invoke(state, cause);
                    }
                });
            }

            public final Graph.State<STATE, EVENT, SIDE_EFFECT> build() {
                return this.stateDefinition;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Graph.State.TransitionTo transitionTo$default(StateDefinitionBuilder stateDefinitionBuilder, Object obj, Object obj2, Object obj3, int i, Object obj4) {
                if ((i & 2) != 0) {
                    obj3 = null;
                }
                return stateDefinitionBuilder.transitionTo(obj, obj2, obj3);
            }

            public final Graph.State.TransitionTo<STATE, SIDE_EFFECT> transitionTo(S receiver$0, STATE state, SIDE_EFFECT side_effect) {
                Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
                Intrinsics.checkParameterIsNotNull(state, "state");
                return new Graph.State.TransitionTo<>(state, side_effect);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Graph.State.TransitionTo dontTransition$default(StateDefinitionBuilder stateDefinitionBuilder, Object obj, Object obj2, int i, Object obj3) {
                if ((i & 1) != 0) {
                    obj2 = null;
                }
                return stateDefinitionBuilder.dontTransition(obj, obj2);
            }

            public final Graph.State.TransitionTo<STATE, SIDE_EFFECT> dontTransition(S receiver$0, SIDE_EFFECT side_effect) {
                Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
                return transitionTo(receiver$0, receiver$0, side_effect);
            }

            /* JADX INFO: renamed from: on */
            private final <E extends EVENT> void m4365on(Function2<? super S, ? super E, ? extends Graph.State.TransitionTo<? extends STATE, ? extends SIDE_EFFECT>> createTransitionTo) {
                Matcher.Companion companion = Matcher.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_EAST);
                m4366on((Matcher) companion.any(Object.class), (Function2) createTransitionTo);
            }

            /* JADX INFO: renamed from: on */
            private final <E extends EVENT> void m4364on(E event, Function2<? super S, ? super E, ? extends Graph.State.TransitionTo<? extends STATE, ? extends SIDE_EFFECT>> createTransitionTo) {
                Matcher.Companion companion = Matcher.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_EAST);
                m4366on((Matcher) companion.any(Object.class).where(new StateMachine$Matcher$Companion$eq$1(event)), (Function2) createTransitionTo);
            }
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u007f\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0004\"\b\b\u0003\u0010\u0005*\u00020\u0001\"\b\b\u0004\u0010\u0006*\u00020\u0001\"\b\b\u0005\u0010\u0007*\u00020\u00012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\t2)\u0010\n\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0002Ja\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0004\"\b\b\u0003\u0010\u0005*\u00020\u0001\"\b\b\u0004\u0010\u0006*\u00020\u0001\"\b\b\u0005\u0010\u0007*\u00020\u00012)\u0010\n\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/tinder/StateMachine$Companion;", "", "()V", "create", "Lcom/tinder/StateMachine;", "STATE", "EVENT", "SIDE_EFFECT", "graph", "Lcom/tinder/StateMachine$Graph;", "init", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$GraphBuilder;", "", "Lkotlin/ExtensionFunctionType;", "state-machine"}, m5599k = 1, m5600mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <STATE, EVENT, SIDE_EFFECT> StateMachine<STATE, EVENT, SIDE_EFFECT> create(Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>, Unit> init) {
            Intrinsics.checkParameterIsNotNull(init, "init");
            return create(null, init);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <STATE, EVENT, SIDE_EFFECT> StateMachine<STATE, EVENT, SIDE_EFFECT> create(Graph<STATE, EVENT, SIDE_EFFECT> graph, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>, Unit> init) {
            GraphBuilder graphBuilder = new GraphBuilder(graph);
            init.invoke(graphBuilder);
            return new StateMachine<>(graphBuilder.build(), null);
        }
    }
}
