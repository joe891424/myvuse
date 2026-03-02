package p000a.p001a.p002a.p003a.p004a.p012j;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.Snackbar;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0085a;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0086b;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;

/* JADX INFO: renamed from: a.a.a.a.a.j.b */
/* JADX INFO: loaded from: classes.dex */
public class C0055b {

    /* JADX INFO: renamed from: a */
    public boolean f114a;

    /* JADX INFO: renamed from: a */
    public static void m360a(View view, Drawable drawable, String str, boolean z) {
        if (drawable != null && !C0048h.m305b(str)) {
            drawable.setTint(Color.parseColor(str));
        }
        view.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m365a(Snackbar snackbar, View view) {
        snackbar.dismiss();
        if (this.f114a) {
            return;
        }
        this.f114a = true;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m366a(OTPublishersHeadlessSDK oTPublishersHeadlessSDK, FragmentActivity fragmentActivity, OTConfiguration oTConfiguration, Snackbar snackbar, View view) {
        oTPublishersHeadlessSDK.showPreferenceCenterUI(fragmentActivity, oTConfiguration);
        snackbar.dismiss();
    }

    /* JADX INFO: renamed from: a */
    public static void m361a(Button button, C0107c c0107c, C0056c c0056c, View view, boolean z) {
        if (z) {
            OTLogger.m2743a(3, "SyncNotification", "focus: " + z);
            button.getBackground().setTint(Color.parseColor(c0107c.f736i));
            button.setTextColor(Color.parseColor(c0107c.f737j));
        } else {
            OTLogger.m2743a(3, "SyncNotification", "focus: " + z);
            m362a(button, c0056c.f116b, 22, OTUXParamsKeys.OT_UX_TEXT_COLOR, "borderColor");
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m363a(ImageView imageView, C0107c c0107c, C0056c c0056c, View view, boolean z) {
        if (!z) {
            m358a(c0056c, imageView);
        } else {
            imageView.getBackground().setTint(Color.parseColor(c0107c.f736i));
            imageView.getDrawable().setTint(Color.parseColor(c0107c.f737j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m359a(C0056c c0056c, Snackbar snackbar, CardView cardView, CardView cardView2, TextView textView, TextView textView2, Button button, ImageView imageView, ImageView imageView2) {
        if (c0056c.f119e < 12) {
            snackbar.dismiss();
            return;
        }
        if (this.f114a) {
            snackbar.show();
        }
        m364a(cardView, cardView2, textView, textView2, button, imageView, imageView2, c0056c.f116b);
        imageView2.setImageResource(C3896R.drawable.ot_notif_tick);
        m358a(c0056c, imageView);
    }

    /* JADX INFO: renamed from: a */
    public Snackbar m367a(final FragmentActivity fragmentActivity, final OTConfiguration oTConfiguration, final OTPublishersHeadlessSDK oTPublishersHeadlessSDK, final C0056c c0056c) {
        String str;
        try {
            C0086b.m475a().m477a(fragmentActivity);
            C0085a c0085aM469b = C0085a.m469b();
            c0085aM469b.m473a(fragmentActivity);
            View viewFindViewById = fragmentActivity.findViewById(R.id.content);
            if (viewFindViewById == null) {
                OTLogger.m2743a(5, "SyncNotification", "could not find view from activity");
                if (oTConfiguration != null && oTConfiguration.getView() != null) {
                    OTLogger.m2743a(4, "SyncNotification", "checking for view passed by app");
                    viewFindViewById = oTConfiguration.getView();
                }
            }
            if (viewFindViewById == null) {
                OTLogger.m2743a(6, "SyncNotification", "expected valid view but found null, not showing sync notification");
                return null;
            }
            final Snackbar snackbarMake = Snackbar.make(viewFindViewById, "", 0);
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarMake.getView();
            snackbarLayout.setBackgroundColor(Color.parseColor("#00000000"));
            ((TextView) snackbarLayout.findViewById(C3896R.id.snackbar_text)).setVisibility(4);
            View viewInflate = fragmentActivity.getLayoutInflater().inflate(C3896R.layout.ot_tv_sync_notification, (ViewGroup) null);
            final ImageView imageView = (ImageView) viewInflate.findViewById(C3896R.id.ot_notif_progress_image);
            final TextView textView = (TextView) viewInflate.findViewById(C3896R.id.ot_notif_title);
            final TextView textView2 = (TextView) viewInflate.findViewById(C3896R.id.ot_notif_desc);
            final Button button = (Button) viewInflate.findViewById(C3896R.id.ot_notif_button);
            final ImageView imageView2 = (ImageView) viewInflate.findViewById(C3896R.id.ot_tv_notif_close);
            final CardView cardView = (CardView) viewInflate.findViewById(C3896R.id.ot_notif_secondary_layout);
            final CardView cardView2 = (CardView) viewInflate.findViewById(C3896R.id.ot_notif_main_layout);
            m364a(cardView2, cardView, textView, textView2, button, imageView2, imageView, c0056c.f115a);
            m358a(c0056c, imageView2);
            str = "SyncNotification";
            try {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.a.j.b$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.m365a(snackbarMake, view);
                    }
                });
                button.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.a.j.b$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C0055b.m366a(oTPublishersHeadlessSDK, fragmentActivity, oTConfiguration, snackbarMake, view);
                    }
                });
                final C0107c c0107c = c0085aM469b.f343f.f793i;
                button.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.a.j.b$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        C0055b.m361a(button, c0107c, c0056c, view, z);
                    }
                });
                imageView2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a.a.a.a.a.j.b$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        C0055b.m363a(imageView2, c0107c, c0056c, view, z);
                    }
                });
                snackbarLayout.setPadding(6, 6, 6, 6);
                snackbarLayout.addView(viewInflate, 0);
                snackbarMake.setDuration(c0056c.f118d);
                viewInflate.postDelayed(new Runnable() { // from class: a.a.a.a.a.j.b$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m359a(c0056c, snackbarMake, cardView2, cardView, textView, textView2, button, imageView2, imageView);
                    }
                }, 1500L);
                return snackbarMake;
            } catch (Exception e) {
                e = e;
                OTLogger.m2743a(6, str, e.toString());
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            str = "SyncNotification";
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m362a(Button button, JSONObject jSONObject, int i, String str, String str2) {
        JSONObject jSONObjectM238a = C0032d.m238a(jSONObject, "button");
        if (C0032d.m240a(jSONObjectM238a) || !jSONObjectM238a.optBoolean("show")) {
            return;
        }
        button.setVisibility(0);
        button.setText(jSONObjectM238a.optString("text"));
        button.setTextColor(Color.parseColor(jSONObjectM238a.optString(str)));
        if (jSONObjectM238a.optBoolean("showAsLink")) {
            button.setBackgroundColor(Color.parseColor("#00000000"));
            button.setPaintFlags(button.getPaintFlags() | 8);
            return;
        }
        String strOptString = jSONObjectM238a.optString(str2);
        String strOptString2 = jSONObjectM238a.optString(i == 22 ? "color" : "colorDark");
        String strOptString3 = jSONObjectM238a.optString("borderRadius");
        Context context = button.getContext();
        if (C0048h.m305b(strOptString2)) {
            OTLogger.m2743a(3, "UIUtils", "Button set background color called with empty buttonBackGroundColor.");
            return;
        }
        if (new C0048h().m318g(context)) {
            button.setBackgroundColor(Color.parseColor(strOptString2));
            return;
        }
        String str3 = ExifInterface.GPS_MEASUREMENT_2D;
        if (!C0048h.m305b(ExifInterface.GPS_MEASUREMENT_2D) || !C0048h.m305b(strOptString3)) {
            if (C0048h.m305b(ExifInterface.GPS_MEASUREMENT_2D)) {
                str3 = "4";
            }
            if (C0048h.m305b(strOptString)) {
                strOptString = strOptString2;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setStroke(Integer.parseInt(str3), Color.parseColor(strOptString));
            gradientDrawable.setColor(Color.parseColor(strOptString2));
            if (!C0048h.m305b(strOptString3)) {
                gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, Integer.parseInt(strOptString3), context.getResources().getDisplayMetrics()));
            }
            button.setBackground(gradientDrawable);
            return;
        }
        C0074f.m399a(button, strOptString2, strOptString, C3896R.id.cookies_setting_button);
    }

    /* JADX INFO: renamed from: a */
    public static void m358a(C0056c c0056c, ImageView imageView) {
        JSONObject jSONObjectM238a = C0032d.m238a(c0056c.f116b, "button");
        if (jSONObjectM238a != null) {
            String strOptString = jSONObjectM238a.optString("color");
            String strOptString2 = jSONObjectM238a.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            imageView.getBackground().setTint(Color.parseColor(strOptString));
            imageView.getDrawable().setTint(Color.parseColor(strOptString2));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m364a(CardView cardView, CardView cardView2, TextView textView, TextView textView2, Button button, ImageView imageView, ImageView imageView2, JSONObject jSONObject) {
        JSONObject jSONObjectM238a = C0032d.m238a(jSONObject, "title");
        if (jSONObjectM238a != null) {
            textView.setText(jSONObjectM238a.optString("text"));
            String strOptString = jSONObjectM238a.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            if (!C0048h.m305b(strOptString)) {
                textView.setTextColor(Color.parseColor(strOptString));
            }
        }
        JSONObject jSONObjectM238a2 = C0032d.m238a(jSONObject, "description");
        if (jSONObjectM238a2 != null) {
            textView2.setText(jSONObjectM238a2.optString("text"));
            String strOptString2 = jSONObjectM238a2.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            if (!C0048h.m305b(strOptString2)) {
                textView2.setTextColor(Color.parseColor(strOptString2));
            }
        }
        JSONObject jSONObjectM238a3 = C0032d.m238a(jSONObject, OTVendorListMode.GENERAL);
        if (!C0032d.m240a(jSONObjectM238a3)) {
            m360a(imageView, imageView.getDrawable(), jSONObjectM238a != null ? jSONObjectM238a.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR) : null, jSONObjectM238a3.optBoolean("showClose"));
            m360a(imageView2, imageView2.getBackground(), jSONObjectM238a3.optString("iconBackgroundColor"), jSONObjectM238a3.optBoolean("showIcon"));
            String strOptString3 = jSONObjectM238a3.optString("backgroundColor");
            String strOptString4 = jSONObjectM238a3.optString("borderColor");
            if (!C0048h.m305b(strOptString3)) {
                cardView2.setBackgroundColor(Color.parseColor(strOptString3));
            }
            if (!C0048h.m305b(strOptString4)) {
                cardView.setBackgroundColor(Color.parseColor(strOptString4));
            }
        }
        m362a(button, jSONObject, 22, OTUXParamsKeys.OT_UX_TEXT_COLOR, "borderColor");
    }
}
