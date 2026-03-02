package com.reactnativenavigation.options;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.util.Property;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.ValueAnimationOptions;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.TextParser;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.Functions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.EllipticCurveJsonWebKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnimationOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0016\u0018\u0000 42\u00020\u0001:\u00014B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0000J\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0000J\u0012\u0010,\u001a\u00020(2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J0\u0010-\u001a\u00020(2\u0018\u0010.\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000200J\u0006\u00103\u001a\u00020\u0010R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00065"}, m5598d2 = {"Lcom/reactnativenavigation/options/AnimationOptions;", "Lcom/reactnativenavigation/options/LayoutAnimation;", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "duration", "", "getDuration", "()I", "elementTransitions", "Lcom/reactnativenavigation/options/ElementTransitions;", "getElementTransitions", "()Lcom/reactnativenavigation/options/ElementTransitions;", "setElementTransitions", "(Lcom/reactnativenavigation/options/ElementTransitions;)V", ViewProps.ENABLED, "Lcom/reactnativenavigation/options/params/Bool;", "id", "Lcom/reactnativenavigation/options/params/Text;", "sharedElements", "Lcom/reactnativenavigation/options/SharedElements;", "getSharedElements", "()Lcom/reactnativenavigation/options/SharedElements;", "setSharedElements", "(Lcom/reactnativenavigation/options/SharedElements;)V", "valueOptions", "Ljava/util/HashSet;", "Lcom/reactnativenavigation/options/ValueAnimationOptions;", "waitForRender", "getAnimation", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "defaultAnimation", "hasAnimation", "", "hasElementTransitions", "hasValue", "isFadeAnimation", "mergeWith", "", "other", "mergeWithDefault", "defaultOptions", "parse", "setValueDy", "animation", "Landroid/util/Property;", "", "fromDelta", "toDelta", "shouldWaitForRender", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class AnimationOptions implements LayoutAnimation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ElementTransitions elementTransitions;
    public Bool enabled;
    public Text id;
    private SharedElements sharedElements;
    private HashSet<ValueAnimationOptions> valueOptions;
    public Bool waitForRender;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AnimationOptions(JSONObject jSONObject) {
        this.id = new NullText();
        this.enabled = new NullBool();
        this.waitForRender = new NullBool();
        this.sharedElements = new SharedElements();
        this.elementTransitions = new ElementTransitions();
        this.valueOptions = new HashSet<>();
        parse(jSONObject);
    }

    public /* synthetic */ AnimationOptions(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject);
    }

    @Override // com.reactnativenavigation.options.LayoutAnimation
    public SharedElements getSharedElements() {
        return this.sharedElements;
    }

    public void setSharedElements(SharedElements sharedElements) {
        Intrinsics.checkNotNullParameter(sharedElements, "<set-?>");
        this.sharedElements = sharedElements;
    }

    @Override // com.reactnativenavigation.options.LayoutAnimation
    public ElementTransitions getElementTransitions() {
        return this.elementTransitions;
    }

    public void setElementTransitions(ElementTransitions elementTransitions) {
        Intrinsics.checkNotNullParameter(elementTransitions, "<set-?>");
        this.elementTransitions = elementTransitions;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void parse(JSONObject json) {
        if (json == null) {
            return;
        }
        Iterator<String> itKeys = json.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next != null) {
                switch (next.hashCode()) {
                    case -1609594047:
                        if (next.equals(ViewProps.ENABLED)) {
                            Bool bool = BoolParser.parse(json, next);
                            Intrinsics.checkNotNullExpressionValue(bool, "parse(...)");
                            this.enabled = bool;
                        }
                        break;
                    case -1298848381:
                        if (next.equals("enable")) {
                            Bool bool2 = BoolParser.parse(json, next);
                            Intrinsics.checkNotNullExpressionValue(bool2, "parse(...)");
                            this.enabled = bool2;
                        }
                        break;
                    case -585576158:
                        if (next.equals("elementTransitions")) {
                            setElementTransitions(ElementTransitions.INSTANCE.parse(json));
                        }
                        break;
                    case -236533145:
                        if (next.equals("sharedElementTransitions")) {
                            setSharedElements(SharedElements.INSTANCE.parse(json));
                        }
                        break;
                    case 3355:
                        if (next.equals("id")) {
                            Text text = TextParser.parse(json, next);
                            Intrinsics.checkNotNullExpressionValue(text, "parse(...)");
                            this.id = text;
                        }
                        break;
                    case 1104912842:
                        if (next.equals("waitForRender")) {
                            Bool bool3 = BoolParser.parse(json, next);
                            Intrinsics.checkNotNullExpressionValue(bool3, "parse(...)");
                            this.waitForRender = bool3;
                        }
                        break;
                }
            }
            HashSet<ValueAnimationOptions> hashSet = this.valueOptions;
            ValueAnimationOptions.Companion companion = ValueAnimationOptions.INSTANCE;
            JSONObject jSONObjectOptJSONObject = json.optJSONObject(next);
            Companion companion2 = INSTANCE;
            Intrinsics.checkNotNull(next);
            hashSet.add(companion.parse(jSONObjectOptJSONObject, companion2.getAnimProp(next)));
        }
    }

    public final void mergeWith(AnimationOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.id.hasValue()) {
            this.id = other.id;
        }
        if (other.enabled.hasValue()) {
            this.enabled = other.enabled;
        }
        if (other.waitForRender.hasValue()) {
            this.waitForRender = other.waitForRender;
        }
        if (!other.valueOptions.isEmpty()) {
            this.valueOptions = other.valueOptions;
        }
        if (other.getSharedElements().hasValue()) {
            setSharedElements(other.getSharedElements());
        }
        if (other.getElementTransitions().hasValue()) {
            setElementTransitions(other.getElementTransitions());
        }
    }

    public final void mergeWithDefault(AnimationOptions defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        if (!this.id.hasValue()) {
            this.id = defaultOptions.id;
        }
        if (!this.enabled.hasValue()) {
            this.enabled = defaultOptions.enabled;
        }
        if (!this.waitForRender.hasValue()) {
            this.waitForRender = defaultOptions.waitForRender;
        }
        if (this.valueOptions.isEmpty()) {
            this.valueOptions = defaultOptions.valueOptions;
        }
        if (!getSharedElements().hasValue()) {
            setSharedElements(defaultOptions.getSharedElements());
        }
        if (getElementTransitions().hasValue()) {
            return;
        }
        setElementTransitions(defaultOptions.getElementTransitions());
    }

    public final boolean hasValue() {
        return this.id.hasValue() || this.enabled.hasValue() || this.waitForRender.hasValue() || getSharedElements().hasValue() || getElementTransitions().hasValue() || !this.valueOptions.isEmpty();
    }

    public final Animator getAnimation(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return getAnimation(view, new AnimatorSet());
    }

    public final Animator getAnimation(View view, Animator defaultAnimation) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(defaultAnimation, "defaultAnimation");
        if (!hasAnimation()) {
            return defaultAnimation;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        HashSet<ValueAnimationOptions> hashSet = this.valueOptions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(hashSet, 10));
        Iterator<T> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(((ValueAnimationOptions) it2.next()).getAnimation(view));
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    public final Bool shouldWaitForRender() {
        return new Bool(Boolean.valueOf(this.waitForRender.isTrue() | hasElementTransitions()));
    }

    public final boolean hasElementTransitions() {
        return getSharedElements().hasValue() | getElementTransitions().hasValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer _get_duration_$lambda$2(ValueAnimationOptions item, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        Integer num = item.getDuration().get(Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        return Integer.valueOf(Math.max(num.intValue(), i));
    }

    public final int getDuration() {
        Object objReduce = CollectionUtils.reduce(this.valueOptions, 0, (CollectionUtils.Reducer<int, T>) new CollectionUtils.Reducer() { // from class: com.reactnativenavigation.options.AnimationOptions$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Reducer
            public final Object reduce(Object obj, Object obj2) {
                return AnimationOptions._get_duration_$lambda$2((ValueAnimationOptions) obj, ((Integer) obj2).intValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(objReduce, "reduce(...)");
        return ((Number) objReduce).intValue();
    }

    public boolean hasAnimation() {
        return !this.valueOptions.isEmpty();
    }

    public final boolean isFadeAnimation() {
        Object next;
        if (this.valueOptions.size() == 1) {
            Iterator<T> it2 = this.valueOptions.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (((ValueAnimationOptions) next).isAlpha()) {
                    break;
                }
            }
            if (next != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setValueDy$lambda$3(Property property, ValueAnimationOptions o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return o.equals((Object) property);
    }

    public final void setValueDy(final Property<View, Float> animation, final float fromDelta, final float toDelta) {
        CollectionUtils.first(this.valueOptions, new CollectionUtils.Filter() { // from class: com.reactnativenavigation.options.AnimationOptions$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.CollectionUtils.Filter
            public final boolean filter(Object obj) {
                return AnimationOptions.setValueDy$lambda$3(animation, (ValueAnimationOptions) obj);
            }
        }, new Functions.Func1() { // from class: com.reactnativenavigation.options.AnimationOptions$$ExternalSyntheticLambda2
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                AnimationOptions.setValueDy$lambda$4(fromDelta, toDelta, (ValueAnimationOptions) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setValueDy$lambda$4(float f, float f2, ValueAnimationOptions param) {
        Intrinsics.checkNotNullParameter(param, "param");
        param.setFromDelta(f);
        param.setToDelta(f2);
    }

    /* JADX INFO: compiled from: AnimationOptions.kt */
    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\t0\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, m5598d2 = {"Lcom/reactnativenavigation/options/AnimationOptions$Companion;", "", "()V", "getAnimProp", "Lkotlin/Triple;", "Landroid/util/Property;", "Landroid/view/View;", "", "", "Lkotlin/Function1;", "key", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final Triple<Property<View, Float>, Integer, Function1<View, Float>> getAnimProp(String key) {
            switch (key.hashCode()) {
                case -1249320806:
                    if (key.equals("rotationX")) {
                        return new Triple<>(View.ROTATION_X, 0, AnimationOptions$Companion$getAnimProp$8.INSTANCE);
                    }
                    break;
                case -1249320805:
                    if (key.equals("rotationY")) {
                        return new Triple<>(View.ROTATION_Y, 0, AnimationOptions$Companion$getAnimProp$9.INSTANCE);
                    }
                    break;
                case -1225497657:
                    if (key.equals("translationX")) {
                        return new Triple<>(View.TRANSLATION_X, 1, AnimationOptions$Companion$getAnimProp$3.INSTANCE);
                    }
                    break;
                case -1225497656:
                    if (key.equals("translationY")) {
                        return new Triple<>(View.TRANSLATION_Y, 1, AnimationOptions$Companion$getAnimProp$4.INSTANCE);
                    }
                    break;
                case -908189618:
                    if (key.equals("scaleX")) {
                        return new Triple<>(View.SCALE_X, 0, AnimationOptions$Companion$getAnimProp$6.INSTANCE);
                    }
                    break;
                case -908189617:
                    if (key.equals("scaleY")) {
                        return new Triple<>(View.SCALE_Y, 0, AnimationOptions$Companion$getAnimProp$7.INSTANCE);
                    }
                    break;
                case -40300674:
                    if (key.equals("rotation")) {
                        return new Triple<>(View.ROTATION, 0, AnimationOptions$Companion$getAnimProp$10.INSTANCE);
                    }
                    break;
                case 120:
                    if (key.equals(EllipticCurveJsonWebKey.X_MEMBER_NAME)) {
                        return new Triple<>(View.X, 1, AnimationOptions$Companion$getAnimProp$1.INSTANCE);
                    }
                    break;
                case 121:
                    if (key.equals(EllipticCurveJsonWebKey.Y_MEMBER_NAME)) {
                        return new Triple<>(View.Y, 1, AnimationOptions$Companion$getAnimProp$2.INSTANCE);
                    }
                    break;
                case 92909918:
                    if (key.equals("alpha")) {
                        return new Triple<>(View.ALPHA, 0, AnimationOptions$Companion$getAnimProp$5.INSTANCE);
                    }
                    break;
            }
            throw new IllegalArgumentException("This animation is not supported: " + key);
        }
    }
}
