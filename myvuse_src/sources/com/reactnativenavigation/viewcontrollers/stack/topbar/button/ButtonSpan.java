package com.reactnativenavigation.viewcontrollers.stack.topbar.button;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.reactnativenavigation.options.ButtonOptions;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import com.reactnativenavigation.utils.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/stack/topbar/button/ButtonSpan;", "Landroid/text/style/MetricAffectingSpan;", "context", "Landroid/content/Context;", "button", "Lcom/reactnativenavigation/options/ButtonOptions;", "typefaceLoader", "Lcom/reactnativenavigation/options/parsers/TypefaceLoader;", "(Landroid/content/Context;Lcom/reactnativenavigation/options/ButtonOptions;Lcom/reactnativenavigation/options/parsers/TypefaceLoader;)V", "fontSize", "", "getFontSize", "()Ljava/lang/Float;", "apply", "", "paint", "Landroid/graphics/Paint;", "updateDrawState", "drawState", "Landroid/text/TextPaint;", "updateMeasureState", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ButtonSpan extends MetricAffectingSpan {
    private final ButtonOptions button;
    private final Context context;
    private final TypefaceLoader typefaceLoader;

    public /* synthetic */ ButtonSpan(Context context, ButtonOptions buttonOptions, TypefaceLoader typefaceLoader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, buttonOptions, (i & 4) != 0 ? new TypefaceLoader(context) : typefaceLoader);
    }

    public ButtonSpan(Context context, ButtonOptions button, TypefaceLoader typefaceLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(typefaceLoader, "typefaceLoader");
        this.context = context;
        this.button = button;
        this.typefaceLoader = typefaceLoader;
    }

    public final Float getFontSize() {
        if (this.button.fontSize.hasValue()) {
            return Float.valueOf(UiUtils.dpToPx(this.context, (float) this.button.fontSize.get().doubleValue()));
        }
        return null;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint drawState) {
        Intrinsics.checkNotNullParameter(drawState, "drawState");
        apply(drawState);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        apply(paint);
    }

    public final void apply(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Typeface typeface = this.button.font.getTypeface(this.typefaceLoader, paint.getTypeface());
        Typeface typeface2 = paint.getTypeface();
        int style = (typeface2 != null ? typeface2.getStyle() : 0) & (typeface != null ? ~typeface.getStyle() : 1);
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        Float fontSize = getFontSize();
        if (fontSize != null) {
            paint.setTextSize(fontSize.floatValue());
        }
        paint.setTypeface(typeface);
    }
}
