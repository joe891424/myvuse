package com.yoti.mobile.android.commonui.extension;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextViewLoadingEllipsisAnimation.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\nH\u0002\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\n\u001a\n\u0010\u001e\u001a\u00020\u001d*\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\",\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\u0010*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0018\u0010\u0017\u001a\u00020\u0018*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, m5598d2 = {"ELLIPSIS_ANIMATION_FRAME_DURATION_MS", "", "ELLIPSIS_ANIMATION_TOTAL_DURATION_MS", "ELLIPSIS_DOT", "", "ELLIPSIS_DOT_COUNT", "", "value", "Landroid/animation/Animator;", "ellipsisAnimator", "Landroid/widget/TextView;", "getEllipsisAnimator", "(Landroid/widget/TextView;)Landroid/animation/Animator;", "setEllipsisAnimator", "(Landroid/widget/TextView;Landroid/animation/Animator;)V", "isEllipsisAnimationRunning", "", "(Landroid/widget/TextView;)Z", "spannableEllipsisTextList", "", "Landroid/text/SpannableString;", "getSpannableEllipsisTextList", "(Landroid/widget/TextView;)Ljava/util/List;", "textWithEllipsis", "", "getTextWithEllipsis", "(Landroid/widget/TextView;)Ljava/lang/CharSequence;", "createEllipsisAnimator", "hideLoadingEllipsis", "", "showLoadingEllipsis", "commonUI_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TextViewLoadingEllipsisAnimationKt {
    private static final long ELLIPSIS_ANIMATION_FRAME_DURATION_MS = 250;
    private static final long ELLIPSIS_ANIMATION_TOTAL_DURATION_MS = 1000;
    private static final String ELLIPSIS_DOT = ".";
    private static final int ELLIPSIS_DOT_COUNT = 3;

    public static final void showLoadingEllipsis(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (isEllipsisAnimationRunning(textView)) {
            return;
        }
        Animator animatorCreateEllipsisAnimator = createEllipsisAnimator(textView);
        animatorCreateEllipsisAnimator.start();
        setEllipsisAnimator(textView, animatorCreateEllipsisAnimator);
    }

    public static final void hideLoadingEllipsis(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (isEllipsisAnimationRunning(textView)) {
            Animator ellipsisAnimator = getEllipsisAnimator(textView);
            if (ellipsisAnimator != null) {
                ellipsisAnimator.cancel();
            }
            setEllipsisAnimator(textView, null);
            CharSequence text = textView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            textView.setText(text.subSequence(0, textView.getText().length() - 3).toString());
        }
    }

    private static final boolean isEllipsisAnimationRunning(TextView textView) {
        Animator ellipsisAnimator = getEllipsisAnimator(textView);
        return ellipsisAnimator != null && ellipsisAnimator.isRunning();
    }

    private static final Animator getEllipsisAnimator(TextView textView) {
        Object tag = textView.getTag();
        if (tag instanceof Animator) {
            return (Animator) tag;
        }
        return null;
    }

    private static final void setEllipsisAnimator(TextView textView, Animator animator) {
        textView.setTag(animator);
    }

    private static final CharSequence getTextWithEllipsis(TextView textView) {
        return ((Object) textView.getText()) + StringsKt.repeat(ELLIPSIS_DOT, 3);
    }

    private static final List<SpannableString> getSpannableEllipsisTextList(TextView textView) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            int length = getTextWithEllipsis(textView).length() - (3 - i);
            int length2 = getTextWithEllipsis(textView).length();
            SpannableString spannableString = new SpannableString(getTextWithEllipsis(textView));
            spannableString.setSpan(new ForegroundColorSpan(0), length, length2, 18);
            arrayList.add(spannableString);
        }
        return arrayList;
    }

    private static final Animator createEllipsisAnimator(final TextView textView) {
        final List<SpannableString> spannableEllipsisTextList = getSpannableEllipsisTextList(textView);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, spannableEllipsisTextList.size());
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.setDuration(1000L);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setRepeatMode(1);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yoti.mobile.android.commonui.extension.TextViewLoadingEllipsisAnimationKt$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TextViewLoadingEllipsisAnimationKt.m6800createEllipsisAnimator$lambda5$lambda4(spannableEllipsisTextList, textView, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfInt, "ofInt(0, ellipsisTextLis…[value] }\n        }\n    }");
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createEllipsisAnimator$lambda-5$lambda-4, reason: not valid java name */
    public static final void m6800createEllipsisAnimator$lambda5$lambda4(List ellipsisTextList, TextView this_createEllipsisAnimator, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(ellipsisTextList, "$ellipsisTextList");
        Intrinsics.checkNotNullParameter(this_createEllipsisAnimator, "$this_createEllipsisAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        Integer numValueOf = Integer.valueOf(((Integer) animatedValue).intValue());
        int iIntValue = numValueOf.intValue();
        if (iIntValue < 0 || iIntValue >= ellipsisTextList.size()) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            this_createEllipsisAnimator.setText((CharSequence) ellipsisTextList.get(numValueOf.intValue()));
        }
    }
}
