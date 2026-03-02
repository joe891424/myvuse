package com.reactnativenavigation.options;

import android.animation.TimeInterpolator;
import android.view.animation.LinearInterpolator;
import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.parsers.InterpolationParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import com.reactnativenavigation.options.parsers.TextParser;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SharedElementTransitionOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u001bJ\u0006\u0010\u0016\u001a\u00020\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001d"}, m5598d2 = {"Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "", "()V", "duration", "Lcom/reactnativenavigation/options/params/Number;", "getDuration", "()Lcom/reactnativenavigation/options/params/Number;", "setDuration", "(Lcom/reactnativenavigation/options/params/Number;)V", "fromId", "Lcom/reactnativenavigation/options/params/Text;", "getFromId", "()Lcom/reactnativenavigation/options/params/Text;", "setFromId", "(Lcom/reactnativenavigation/options/params/Text;)V", "interpolator", "Landroid/animation/TimeInterpolator;", "getInterpolator", "()Landroid/animation/TimeInterpolator;", "setInterpolator", "(Landroid/animation/TimeInterpolator;)V", "startDelay", "getStartDelay", "setStartDelay", "toId", "getToId", "setToId", "", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class SharedElementTransitionOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Text fromId = new NullText();
    private Text toId = new NullText();
    private Number duration = new NullNumber();
    private Number startDelay = new NullNumber();
    private TimeInterpolator interpolator = new LinearInterpolator();

    @JvmStatic
    public static final SharedElementTransitionOptions parse(JSONObject jSONObject) {
        return INSTANCE.parse(jSONObject);
    }

    public final Text getFromId() {
        return this.fromId;
    }

    public final void setFromId(Text text) {
        Intrinsics.checkNotNullParameter(text, "<set-?>");
        this.fromId = text;
    }

    public final Text getToId() {
        return this.toId;
    }

    public final void setToId(Text text) {
        Intrinsics.checkNotNullParameter(text, "<set-?>");
        this.toId = text;
    }

    public final Number getDuration() {
        return this.duration;
    }

    public final void setDuration(Number number) {
        Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.duration = number;
    }

    public final Number getStartDelay() {
        return this.startDelay;
    }

    public final void setStartDelay(Number number) {
        Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.startDelay = number;
    }

    public final TimeInterpolator getInterpolator() {
        return this.interpolator;
    }

    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        Intrinsics.checkNotNullParameter(timeInterpolator, "<set-?>");
        this.interpolator = timeInterpolator;
    }

    public final long getDuration() {
        return this.duration.get(0).intValue();
    }

    public final long getStartDelay() {
        return this.startDelay.get(0).intValue();
    }

    /* JADX INFO: compiled from: SharedElementTransitionOptions.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/reactnativenavigation/options/SharedElementTransitionOptions$Companion;", "", "()V", "parse", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "json", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SharedElementTransitionOptions parse(JSONObject json) {
            SharedElementTransitionOptions sharedElementTransitionOptions = new SharedElementTransitionOptions();
            if (json == null) {
                return sharedElementTransitionOptions;
            }
            Text text = TextParser.parse(json, "fromId");
            Intrinsics.checkNotNullExpressionValue(text, "parse(...)");
            sharedElementTransitionOptions.setFromId(text);
            Text text2 = TextParser.parse(json, "toId");
            Intrinsics.checkNotNullExpressionValue(text2, "parse(...)");
            sharedElementTransitionOptions.setToId(text2);
            Number number = NumberParser.parse(json, "duration");
            Intrinsics.checkNotNullExpressionValue(number, "parse(...)");
            sharedElementTransitionOptions.setDuration(number);
            Number number2 = NumberParser.parse(json, "startDelay");
            Intrinsics.checkNotNullExpressionValue(number2, "parse(...)");
            sharedElementTransitionOptions.setStartDelay(number2);
            TimeInterpolator timeInterpolator = InterpolationParser.parse(json);
            Intrinsics.checkNotNullExpressionValue(timeInterpolator, "parse(...)");
            sharedElementTransitionOptions.setInterpolator(timeInterpolator);
            return sharedElementTransitionOptions;
        }
    }
}
