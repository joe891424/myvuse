package com.facetec.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.security.SecureRandom;

/* JADX INFO: renamed from: com.facetec.sdk.cb */
/* JADX INFO: loaded from: classes3.dex */
class C2188cb {

    /* JADX INFO: renamed from: B */
    private static /* synthetic */ boolean f3015B = true;

    C2188cb() {
    }

    /* JADX INFO: renamed from: I */
    static float m1989I(int i) {
        return i / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0f);
    }

    /* JADX INFO: renamed from: V */
    static float m1993V(int i) {
        return TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX INFO: renamed from: B */
    static float m1986B(int i) {
        return TypedValue.applyDimension(2, i, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX INFO: renamed from: B */
    static void m1988B(Activity activity) {
        View viewFindViewById = activity.findViewById(C2130R.id.backgroundColor);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(4);
        }
    }

    static String Code(int i) {
        return C2222k.m2259I(m1992I(16, i));
    }

    /* JADX INFO: renamed from: I */
    static byte[] m1992I(int i, int i2) {
        SecureRandom secureRandom = new SecureRandom();
        if (i2 != 0) {
            i += secureRandom.nextInt(i2 + 1);
        }
        return secureRandom.generateSeed(i);
    }

    /* JADX INFO: renamed from: V */
    static String m1995V(String str) {
        return str == null ? "Unknown Error" : str;
    }

    /* JADX INFO: renamed from: B */
    static WindowManager m1987B(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindowManager();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (f3015B || windowManager != null) {
            return windowManager;
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: V */
    static int m1994V(Context context) {
        int rotation = m1987B(context).getDefaultDisplay().getRotation();
        if (rotation != 1) {
            return rotation != 2 ? rotation != 3 ? 1 : 8 : (Build.MODEL.contains("Mi MIX 2") || Build.MODEL.contains("RCT6773W22BM")) ? 1 : 9;
        }
        return 0;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cb$V */
    static class V {
        private int Code;

        /* JADX INFO: renamed from: Z */
        private int f3016Z;

        public V(int i, int i2) {
            this.Code = i;
            this.f3016Z = i2;
        }

        final int Code() {
            return this.Code;
        }

        /* JADX INFO: renamed from: Z */
        final int m1996Z() {
            return this.f3016Z;
        }
    }

    /* JADX INFO: renamed from: I */
    static V m1991I(String str, int i, Typeface typeface) {
        Paint paint = new Paint();
        paint.setTextSize(i);
        paint.setTypeface(typeface);
        paint.setFlags(1);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setAntiAlias(true);
        int iRound = Math.round(paint.measureText(str));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return new V(iRound, Math.round(fontMetrics.descent - fontMetrics.ascent));
    }

    /* JADX INFO: renamed from: I */
    static int m1990I(TextView textView, V v, int i, int i2) {
        int iCeil;
        Typeface typeface = textView.getTypeface();
        String string = textView.getText().toString();
        if (string.contains(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            string = string.substring(0, string.indexOf(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
        }
        int i3 = i2 - i;
        do {
            i3--;
            iCeil = (int) Math.ceil(((double) (i2 + i)) / 2.0d);
            V vM1991I = m1991I(string, iCeil, typeface);
            if (vM1991I.Code() > v.Code() || vM1991I.m1996Z() > v.m1996Z()) {
                i2 = iCeil - 1;
            } else {
                i = iCeil;
            }
            if (i == i2) {
                break;
            }
        } while (i3 > 0);
        return iCeil - 1;
    }
}
