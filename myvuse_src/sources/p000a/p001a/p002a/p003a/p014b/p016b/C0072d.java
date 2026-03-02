package p000a.p001a.p002a.p003a.p014b.p016b;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0119m;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.b.b.d */
/* JADX INFO: loaded from: classes.dex */
public class C0072d {
    /* JADX INFO: renamed from: a */
    public static int m382a(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return 20;
        }
        if (i == 4) {
            return 23;
        }
        if (i == 61) {
            return 22;
        }
        if (i == 66) {
            return 21;
        }
        switch (i) {
        }
        return 20;
    }

    /* JADX INFO: renamed from: a */
    public static GradientDrawable m383a(boolean z, String str, String str2, String str3, String str4, ImageView imageView) {
        float f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setCornerRadius(Float.parseFloat(ExifInterface.GPS_MEASUREMENT_3D));
        if (z) {
            gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_2D), m390b(str));
            gradientDrawable.setColor(m390b(str2));
            f = 6.0f;
        } else {
            gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_2D), m390b(str3));
            gradientDrawable.setColor(m390b(str4));
            f = 0.0f;
        }
        imageView.setElevation(f);
        return gradientDrawable;
    }

    /* JADX INFO: renamed from: a */
    public static void m384a(C0107c c0107c, Button button) {
        button.setVisibility(c0107c.mo379c());
        button.setText(c0107c.mo376a());
        m386a(false, c0107c, button);
    }

    /* JADX INFO: renamed from: a */
    public static void m385a(TextView textView, String str) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(m390b(str), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m390b(String str) {
        if (C0048h.m305b(str)) {
            return 0;
        }
        return Color.parseColor(str);
    }

    /* JADX INFO: renamed from: b */
    public static void m391b(boolean z, Button button, C0107c c0107c) {
        if (z) {
            button.setElevation(6.0f);
            if (!C0048h.m305b(c0107c.f736i) && !C0048h.m305b(c0107c.f737j)) {
                button.getBackground().setTint(m390b(c0107c.f736i));
                button.setTextColor(m390b(c0107c.f737j));
            }
        } else {
            button.setElevation(0.0f);
            button.getBackground().setTint(m390b(c0107c.f729b));
            button.setTextColor(m390b(c0107c.mo378b()));
        }
        if (C0048h.m305b(c0107c.f731d)) {
            return;
        }
        m389a(z, button, c0107c);
    }

    /* JADX INFO: renamed from: a */
    public void m393a(Activity activity, String str, String str2, C0107c c0107c) {
        if (activity == null || !C0170b.m959a(activity, "TV Utils")) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View viewInflate = activity.getLayoutInflater().inflate(C3896R.layout.ot_tv_vendor_qrcode, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C3896R.id.vendor_qrcode_tv_layout);
        TextView textView = (TextView) viewInflate.findViewById(C3896R.id.ot_tv_qr_code_vendor_title);
        ImageView imageView = (ImageView) viewInflate.findViewById(C3896R.id.ot_tv_qr_code_vendor);
        textView.setText(str2);
        String str3 = c0107c.f736i;
        String str4 = c0107c.f737j;
        if (!C0048h.m305b(str3)) {
            linearLayout.setBackgroundColor(m390b(str3));
        }
        if (!C0048h.m305b(str4)) {
            textView.setTextColor(m390b(str4));
        }
        C0026u.m177a(str, activity, "#00000000", str4, imageView, true);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.show();
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(C3896R.dimen.ot_tv_margin_medium);
        int dimensionPixelSize2 = activity.getResources().getDimensionPixelSize(C3896R.dimen.ot_tv_qr_vendor_vertical_margin);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(alertDialogCreate.getWindow().getAttributes());
        layoutParams.gravity = 49;
        layoutParams.x = dimensionPixelSize;
        layoutParams.y = dimensionPixelSize2;
        alertDialogCreate.getWindow().setAttributes(layoutParams);
        alertDialogCreate.getWindow().setLayout(activity.getResources().getDimensionPixelSize(C3896R.dimen.ot_tv_qr_code_view_width), activity.getResources().getDimensionPixelSize(C3896R.dimen.ot_tv_qr_code_view_height));
        Drawable background = alertDialogCreate.getWindow().getDecorView().getBackground();
        if (background != null) {
            background.setTint(m390b(str3));
        }
    }

    /* JADX INFO: renamed from: a */
    public String m392a(String str) {
        try {
        } catch (Exception e) {
            OTLogger.m2743a(6, "TV Utils", "error on computing dark colors " + e.getMessage());
        }
        String str2 = ((((double) Integer.valueOf(str.substring(1, 3), 16).intValue()) * 0.299d) + (((double) Integer.valueOf(str.substring(3, 5), 16).intValue()) * 0.587d)) + (((double) Integer.valueOf(str.substring(5, 7), 16).intValue()) * 0.114d) <= 90.0d ? "bb" : "F1";
        return str.substring(0, 1) + str2 + str.substring(1, str.length());
    }

    /* JADX INFO: renamed from: a */
    public static void m389a(boolean z, Button button, C0107c c0107c) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(Float.parseFloat(ExifInterface.GPS_MEASUREMENT_3D));
        if (z) {
            gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_2D), m390b(c0107c.f738k));
            gradientDrawable.setColor(m390b(c0107c.f736i));
            button.setTextColor(m390b(c0107c.f737j));
            button.setElevation(6.0f);
        } else {
            gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_2D), m390b(c0107c.f731d));
            gradientDrawable.setColor(m390b(c0107c.f729b));
            button.setTextColor(m390b(c0107c.mo378b()));
            button.setElevation(0.0f);
        }
        button.setBackground(gradientDrawable);
        button.setMinHeight(5);
        button.setMinimumHeight(5);
    }

    /* JADX INFO: renamed from: a */
    public static void m387a(boolean z, C0107c c0107c, ImageView imageView) {
        Drawable background;
        String str;
        if (z) {
            imageView.getDrawable().setTint(m390b(c0107c.f737j));
            if (!C0048h.m305b(c0107c.f731d)) {
                imageView.setBackground(m383a(true, c0107c.f738k, c0107c.f736i, c0107c.f731d, c0107c.f729b, imageView));
                return;
            } else {
                background = imageView.getBackground();
                str = c0107c.f736i;
            }
        } else {
            imageView.getDrawable().setTint(m390b(c0107c.mo378b()));
            if (!C0048h.m305b(c0107c.f731d)) {
                imageView.setBackground(m383a(false, c0107c.f738k, c0107c.f736i, c0107c.f731d, c0107c.f729b, imageView));
                return;
            } else {
                background = imageView.getBackground();
                str = c0107c.f729b;
            }
        }
        background.setTint(m390b(str));
    }

    /* JADX INFO: renamed from: a */
    public static void m386a(boolean z, C0107c c0107c, Button button) {
        button.setElevation(0.0f);
        if (c0107c.mo378b() != null) {
            button.setTextColor(m390b(c0107c.mo378b()));
        }
        button.getBackground().setTint(m390b(c0107c.f729b));
        if (C0048h.m305b(c0107c.f731d)) {
            return;
        }
        m389a(z, button, c0107c);
    }

    /* JADX INFO: renamed from: a */
    public static void m388a(boolean z, Button button, C0087c c0087c, String str, int i, boolean z2) {
        String str2;
        String str3;
        String str4;
        C0126t c0126t = c0087c.f378j;
        C0107c c0107c = c0126t.f854y;
        C0119m c0119m = c0126t.f819B;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i);
        gradientDrawable.setCornerRadius(Float.parseFloat(str));
        if (z) {
            str2 = c0107c.f738k;
            str3 = c0107c.f736i;
            str4 = c0107c.f737j;
            button.setElevation(6.0f);
        } else if (z2) {
            str4 = c0119m.f768f;
            str3 = c0119m.f767e;
            button.setElevation(0.0f);
            str2 = str4;
        } else {
            String str5 = c0107c.f731d;
            String str6 = c0107c.f729b;
            String strMo378b = c0107c.mo378b();
            button.setElevation(0.0f);
            str2 = str5;
            str3 = str6;
            str4 = strMo378b;
        }
        gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_2D), m390b(str2));
        gradientDrawable.setColor(m390b(str3));
        button.setTextColor(m390b(str4));
        button.setElevation(6.0f);
        button.setBackground(gradientDrawable);
        button.setMinHeight(0);
        button.setMinimumHeight(0);
    }
}
