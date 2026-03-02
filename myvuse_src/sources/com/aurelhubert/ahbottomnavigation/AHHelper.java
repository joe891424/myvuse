package com.aurelhubert.ahbottomnavigation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AHHelper {

    public interface Mapper<T> {
        T map(T t);
    }

    public static Drawable getTintDrawable(Drawable drawable, Integer num, boolean z) {
        if (num == null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            drawableMutate.setTintList(null);
            return drawableMutate;
        }
        if (z) {
            drawable.clearColorFilter();
            drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            drawable.invalidateSelf();
            return drawable;
        }
        Drawable drawableMutate2 = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTint(drawableMutate2, num.intValue());
        return drawableMutate2;
    }

    public static void updateTopMargin(final View view, int i, int i2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i, i2);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AHHelper.lambda$updateTopMargin$0(view, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    static /* synthetic */ void lambda$updateTopMargin$0(View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (int) fFloatValue, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.requestLayout();
        }
    }

    public static void updateBottomMargin(final View view, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i, i2);
        valueAnimatorOfFloat.setDuration(i3);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AHHelper.lambda$updateBottomMargin$1(view, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    static /* synthetic */ void lambda$updateBottomMargin$1(View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (int) fFloatValue);
            view.requestLayout();
        }
    }

    public static void updateMargin(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.topMargin = i2;
            marginLayoutParams.rightMargin = i3;
            marginLayoutParams.bottomMargin = i4;
        }
    }

    public static void updateLeftMargin(final View view, int i, int i2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i, i2);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AHHelper.lambda$updateLeftMargin$2(view, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    static /* synthetic */ void lambda$updateLeftMargin$2(View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins((int) fFloatValue, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.requestLayout();
        }
    }

    public static void updateTextSize(final TextView textView, float f, float f2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                textView.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
    }

    public static void updateAlpha(final View view, float f, float f2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
    }

    public static void updateTextColor(final AHTextView aHTextView, Integer num, Integer num2) {
        if (num != null && num2 != null) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), num, num2);
            valueAnimatorOfObject.setDuration(150L);
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    aHTextView.setTextColor((Integer) valueAnimator.getAnimatedValue());
                }
            });
            valueAnimatorOfObject.start();
            return;
        }
        aHTextView.setTextColor(num2);
    }

    public static void updateViewBackgroundColor(final View view, int i, int i2) {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
        valueAnimatorOfObject.setDuration(150L);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfObject.start();
    }

    public static void updateDrawableColor(final Drawable drawable, final ImageView imageView, Integer num, Integer num2, final boolean z) {
        if (num != null && num2 != null) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), num, num2);
            valueAnimatorOfObject.setDuration(150L);
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AHHelper.lambda$updateDrawableColor$7(imageView, drawable, z, valueAnimator);
                }
            });
            valueAnimatorOfObject.start();
            return;
        }
        imageView.setImageDrawable(getTintDrawable(drawable, num2, z));
        imageView.requestLayout();
    }

    static /* synthetic */ void lambda$updateDrawableColor$7(ImageView imageView, Drawable drawable, boolean z, ValueAnimator valueAnimator) {
        imageView.setImageDrawable(getTintDrawable(drawable, (Integer) valueAnimator.getAnimatedValue(), z));
        imageView.requestLayout();
    }

    public static void updateWidth(final View view, float f, float f2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.aurelhubert.ahbottomnavigation.AHHelper$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AHHelper.lambda$updateWidth$8(view, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    static /* synthetic */ void lambda$updateWidth$8(View view, ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = Math.round(((Float) valueAnimator.getAnimatedValue()).floatValue());
        view.setLayoutParams(layoutParams);
    }

    public static boolean isTranslucentStatusBar(Context context) {
        return (unwrap(context).getWindow().getAttributes().flags & 134217728) == 134217728;
    }

    public static int getSoftButtonsBarSizePort(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Window window = unwrap(context).getWindow();
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        window.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            return i2 - i;
        }
        return 0;
    }

    public static Activity unwrap(Context context) {
        while (!(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    public static <T> void map(ArrayList<T> arrayList, Mapper<T> mapper) {
        if (arrayList == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, mapper.map(arrayList.get(i)));
        }
    }

    public static <T> void fill(ArrayList<T> arrayList, int i, T t) {
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(t);
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NullPointerException | NumberFormatException unused) {
            return false;
        }
    }
}
