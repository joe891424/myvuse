package com.reactnativenavigation.utils;

import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/* JADX INFO: loaded from: classes6.dex */
public class TextViewUtils {
    public static int getTextColor(TextView textView) {
        SpannedString spannedString = new SpannedString(textView.getText());
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannedString.getSpans(0, spannedString.length(), ForegroundColorSpan.class);
        return foregroundColorSpanArr.length == 0 ? textView.getCurrentTextColor() : foregroundColorSpanArr[0].getForegroundColor();
    }

    public static float getTextSize(TextView textView) {
        SpannedString spannedString = new SpannedString(textView.getText());
        if (((AbsoluteSizeSpan[]) spannedString.getSpans(0, spannedString.length(), AbsoluteSizeSpan.class)).length == 0) {
            return -1.0f;
        }
        return r3[0].getSize();
    }

    public static void setColor(SpannableString spannableString, int i) {
        spannableString.setSpan(new ForegroundColorSpan(i), 0, spannableString.length(), 33);
    }
}
