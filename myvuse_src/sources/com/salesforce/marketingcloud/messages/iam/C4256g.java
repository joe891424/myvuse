package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.g */
/* JADX INFO: loaded from: classes6.dex */
class C4256g {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.g$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5245a;

        static {
            int[] iArr = new int[InAppMessage.Alignment.values().length];
            f5245a = iArr;
            try {
                iArr[InAppMessage.Alignment.center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5245a[InAppMessage.Alignment.end.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5245a[InAppMessage.Alignment.beginning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private C4256g() {
    }

    /* JADX INFO: renamed from: a */
    static int m3748a(InAppMessage.Alignment alignment) {
        int i = a.f5245a[alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? GravityCompat.START : GravityCompat.END;
        }
        return 17;
    }

    /* JADX INFO: renamed from: a */
    static void m3750a(TextView textView, String str, int i, float f, int i2) {
        textView.setText(str);
        textView.setTextColor(i);
        textView.setTextSize(0, f);
        textView.setGravity(i2);
    }

    /* JADX INFO: renamed from: a */
    static Drawable m3749a(int i, float f, int i2, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(Math.round(f2), i2);
        return gradientDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX INFO: renamed from: a */
    static int m3747a(Context context, String str, int i) {
        try {
            context = str != null ? Color.parseColor(str.replace("0x", "#")) : context.getResources().getColor(i);
            return context;
        } catch (Exception unused) {
            return context.getResources().getColor(i);
        }
    }
}
