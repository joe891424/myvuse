package com.reactnativenavigation.options;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.reactnativenavigation.options.params.FloatParam;
import com.reactnativenavigation.options.params.NullFloatParam;
import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.parsers.FloatParser;
import com.reactnativenavigation.options.parsers.InterpolationParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import com.reactnativenavigation.utils.UiUtils;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ValueAnimationOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001e\u001a\u00020\u001f2\u0016\u0010 \u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\b\u0010%\u001a\u00020\bH\u0016J\u0006\u0010&\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m5598d2 = {"Lcom/reactnativenavigation/options/ValueAnimationOptions;", "", "()V", "animProp", "Landroid/util/Property;", "Landroid/view/View;", "", "animPropType", "", "Ljava/lang/Integer;", "animationValueAccessor", "Lkotlin/Function1;", "duration", "Lcom/reactnativenavigation/options/params/Number;", "getDuration", "()Lcom/reactnativenavigation/options/params/Number;", "setDuration", "(Lcom/reactnativenavigation/options/params/Number;)V", "<set-?>", "Lcom/reactnativenavigation/options/params/FloatParam;", "from", "getFrom", "()Lcom/reactnativenavigation/options/params/FloatParam;", "fromDelta", "interpolator", "Landroid/animation/TimeInterpolator;", "startDelay", TypedValues.TransitionType.S_TO, "getTo", "toDelta", "equals", "", "animationProperty", "other", "getAnimation", "Landroid/animation/Animator;", "view", "hashCode", "isAlpha", "setFromDelta", "", "setToDelta", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ValueAnimationOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Property<View, Float> animProp;
    private Integer animPropType;
    private Function1<? super View, Float> animationValueAccessor;
    private Number duration;
    private FloatParam from = new NullFloatParam();
    private FloatParam fromDelta;
    private TimeInterpolator interpolator;
    private Number startDelay;
    private FloatParam to;
    private FloatParam toDelta;

    public ValueAnimationOptions() {
        Float fValueOf = Float.valueOf(0.0f);
        this.fromDelta = new FloatParam(fValueOf);
        this.to = new NullFloatParam();
        this.toDelta = new FloatParam(fValueOf);
        this.duration = new NullNumber();
        this.startDelay = new NullNumber();
        this.interpolator = new LinearInterpolator();
    }

    public final FloatParam getFrom() {
        return this.from;
    }

    public final FloatParam getTo() {
        return this.to;
    }

    public final Number getDuration() {
        return this.duration;
    }

    public final void setDuration(Number number) {
        Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.duration = number;
    }

    public final void setFromDelta(float fromDelta) {
        this.fromDelta = new FloatParam(Float.valueOf(fromDelta));
    }

    public final void setToDelta(float toDelta) {
        this.toDelta = new FloatParam(Float.valueOf(toDelta));
    }

    public final Animator getAnimation(View view) {
        Float fValueOf;
        Float fValueOf2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!this.from.hasValue() && !this.to.hasValue()) {
            throw new IllegalArgumentException("Params 'from' and 'to' are mandatory".toString());
        }
        Float f = this.fromDelta.get();
        Float f2 = this.toDelta.get();
        Integer num = this.animPropType;
        if (num != null && num.intValue() == 1) {
            float fFloatValue = f.floatValue();
            Context context = view.getContext();
            FloatParam floatParam = this.from;
            Function1<? super View, Float> function1 = this.animationValueAccessor;
            Intrinsics.checkNotNull(function1);
            Float f3 = floatParam.get(function1.invoke(view));
            Intrinsics.checkNotNullExpressionValue(f3, "get(...)");
            fValueOf = Float.valueOf(fFloatValue + UiUtils.dpToPx(context, f3.floatValue()));
            float fFloatValue2 = f2.floatValue();
            Context context2 = view.getContext();
            FloatParam floatParam2 = this.to;
            Function1<? super View, Float> function12 = this.animationValueAccessor;
            Intrinsics.checkNotNull(function12);
            Float f4 = floatParam2.get(function12.invoke(view));
            Intrinsics.checkNotNullExpressionValue(f4, "get(...)");
            fValueOf2 = Float.valueOf(fFloatValue2 + UiUtils.dpToPx(context2, f4.floatValue()));
        } else {
            float fFloatValue3 = f.floatValue();
            FloatParam floatParam3 = this.from;
            Function1<? super View, Float> function13 = this.animationValueAccessor;
            Intrinsics.checkNotNull(function13);
            Float f5 = floatParam3.get(function13.invoke(view));
            Intrinsics.checkNotNullExpressionValue(f5, "get(...)");
            fValueOf = Float.valueOf(fFloatValue3 + f5.floatValue());
            float fFloatValue4 = f2.floatValue();
            FloatParam floatParam4 = this.to;
            Function1<? super View, Float> function14 = this.animationValueAccessor;
            Intrinsics.checkNotNull(function14);
            Float f6 = floatParam4.get(function14.invoke(view));
            Intrinsics.checkNotNullExpressionValue(f6, "get(...)");
            fValueOf2 = Float.valueOf(fFloatValue4 + f6.floatValue());
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, this.animProp, fValueOf.floatValue(), fValueOf2.floatValue());
        objectAnimatorOfFloat.setInterpolator(this.interpolator);
        if (this.duration.hasValue()) {
            objectAnimatorOfFloat.setDuration(this.duration.get().intValue());
        }
        if (this.startDelay.hasValue()) {
            objectAnimatorOfFloat.setStartDelay(this.startDelay.get().intValue());
        }
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        return objectAnimatorOfFloat;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.animProp, ((ValueAnimationOptions) other).animProp);
    }

    public final boolean equals(Property<View, Float> animationProperty) {
        Intrinsics.checkNotNullParameter(animationProperty, "animationProperty");
        Property<View, Float> property = this.animProp;
        Intrinsics.checkNotNull(property);
        return Intrinsics.areEqual(property.getName(), animationProperty.getName());
    }

    public int hashCode() {
        Property<View, Float> property = this.animProp;
        if (property != null) {
            return property.hashCode();
        }
        return 0;
    }

    public final boolean isAlpha() {
        return Intrinsics.areEqual(this.animProp, View.ALPHA);
    }

    /* JADX INFO: compiled from: ValueAnimationOptions.kt */
    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u000624\u0010\u0007\u001a0\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\r0\b¨\u0006\u000e"}, m5598d2 = {"Lcom/reactnativenavigation/options/ValueAnimationOptions$Companion;", "", "()V", "parse", "Lcom/reactnativenavigation/options/ValueAnimationOptions;", "json", "Lorg/json/JSONObject;", "property", "Lkotlin/Triple;", "Landroid/util/Property;", "Landroid/view/View;", "", "", "Lkotlin/Function1;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ValueAnimationOptions parse(JSONObject json, Triple<? extends Property<View, Float>, Integer, ? extends Function1<? super View, Float>> property) {
            Intrinsics.checkNotNullParameter(property, "property");
            ValueAnimationOptions valueAnimationOptions = new ValueAnimationOptions();
            valueAnimationOptions.animProp = property.getFirst();
            valueAnimationOptions.animPropType = property.getSecond();
            valueAnimationOptions.animationValueAccessor = property.getThird();
            FloatParam floatParam = FloatParser.parse(json, "from");
            Intrinsics.checkNotNullExpressionValue(floatParam, "parse(...)");
            valueAnimationOptions.from = floatParam;
            FloatParam floatParam2 = FloatParser.parse(json, TypedValues.TransitionType.S_TO);
            Intrinsics.checkNotNullExpressionValue(floatParam2, "parse(...)");
            valueAnimationOptions.to = floatParam2;
            Number number = NumberParser.parse(json, "duration");
            Intrinsics.checkNotNullExpressionValue(number, "parse(...)");
            valueAnimationOptions.setDuration(number);
            Number number2 = NumberParser.parse(json, "startDelay");
            Intrinsics.checkNotNullExpressionValue(number2, "parse(...)");
            valueAnimationOptions.startDelay = number2;
            TimeInterpolator timeInterpolator = InterpolationParser.parse(json);
            Intrinsics.checkNotNullExpressionValue(timeInterpolator, "parse(...)");
            valueAnimationOptions.interpolator = timeInterpolator;
            return valueAnimationOptions;
        }
    }
}
