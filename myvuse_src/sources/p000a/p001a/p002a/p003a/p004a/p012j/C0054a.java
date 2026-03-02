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

/* JADX INFO: renamed from: a.a.a.a.a.j.a */
/* JADX INFO: loaded from: classes.dex */
public class C0054a {

    /* JADX INFO: renamed from: a */
    public boolean f113a;

    /* JADX INFO: renamed from: a */
    public static void m353a(View view, Drawable drawable, String str, boolean z) {
        if (drawable != null && !C0048h.m305b(str)) {
            drawable.setTint(Color.parseColor(str));
        }
        view.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m355a(Snackbar snackbar, View view) {
        snackbar.dismiss();
        if (this.f113a) {
            return;
        }
        this.f113a = true;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m356a(OTPublishersHeadlessSDK oTPublishersHeadlessSDK, FragmentActivity fragmentActivity, OTConfiguration oTConfiguration, Snackbar snackbar, View view) {
        oTPublishersHeadlessSDK.showPreferenceCenterUI(fragmentActivity, oTConfiguration);
        snackbar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m352a(C0056c c0056c, Snackbar snackbar, CardView cardView, CardView cardView2, TextView textView, TextView textView2, Button button, ImageView imageView, ImageView imageView2, OTConfiguration oTConfiguration) {
        if (c0056c.f119e < 12) {
            snackbar.dismiss();
            return;
        }
        if (this.f113a) {
            snackbar.show();
        }
        m354a(cardView, cardView2, textView, textView2, button, imageView, imageView2, c0056c.f116b, oTConfiguration);
        imageView2.setImageResource(C3896R.drawable.ot_notif_tick);
    }

    /* JADX INFO: renamed from: a */
    public Snackbar m357a(final FragmentActivity fragmentActivity, final OTConfiguration oTConfiguration, final OTPublishersHeadlessSDK oTPublishersHeadlessSDK, final C0056c c0056c) {
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
        View viewInflate = fragmentActivity.getLayoutInflater().inflate(C3896R.layout.ot_sync_notification, (ViewGroup) null);
        final ImageView imageView = (ImageView) viewInflate.findViewById(C3896R.id.ot_notif_progress_image);
        final TextView textView = (TextView) viewInflate.findViewById(C3896R.id.ot_notif_title);
        final TextView textView2 = (TextView) viewInflate.findViewById(C3896R.id.ot_notif_desc);
        final Button button = (Button) viewInflate.findViewById(C3896R.id.ot_notif_button);
        final ImageView imageView2 = (ImageView) viewInflate.findViewById(C3896R.id.ot_notif_close);
        final CardView cardView = (CardView) viewInflate.findViewById(C3896R.id.ot_notif_secondary_layout);
        final CardView cardView2 = (CardView) viewInflate.findViewById(C3896R.id.ot_notif_main_layout);
        m354a(cardView2, cardView, textView, textView2, button, imageView2, imageView, c0056c.f115a, oTConfiguration);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.a.j.a$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m355a(snackbarMake, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.a.j.a$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C0054a.m356a(oTPublishersHeadlessSDK, fragmentActivity, oTConfiguration, snackbarMake, view);
            }
        });
        snackbarLayout.setPadding(6, 6, 6, 6);
        snackbarLayout.addView(viewInflate, 0);
        snackbarMake.setDuration(c0056c.f118d);
        viewInflate.postDelayed(new Runnable() { // from class: a.a.a.a.a.j.a$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m352a(c0056c, snackbarMake, cardView2, cardView, textView, textView2, button, imageView2, imageView, oTConfiguration);
            }
        }, 1500L);
        return snackbarMake;
    }

    /* JADX INFO: renamed from: a */
    public static void m354a(CardView cardView, CardView cardView2, TextView textView, TextView textView2, Button button, ImageView imageView, ImageView imageView2, JSONObject jSONObject, OTConfiguration oTConfiguration) {
        int iM394a = C0074f.m394a(textView.getContext(), oTConfiguration);
        String str = iM394a == 22 ? OTUXParamsKeys.OT_UX_TEXT_COLOR : "textColorDark";
        JSONObject jSONObjectM238a = C0032d.m238a(jSONObject, "title");
        if (jSONObjectM238a != null) {
            textView.setText(jSONObjectM238a.optString("text"));
            String strOptString = jSONObjectM238a.optString(str);
            if (!C0048h.m305b(strOptString)) {
                textView.setTextColor(Color.parseColor(strOptString));
            }
        }
        JSONObject jSONObjectM238a2 = C0032d.m238a(jSONObject, "description");
        if (jSONObjectM238a2 != null) {
            textView2.setText(jSONObjectM238a2.optString("text"));
            String strOptString2 = jSONObjectM238a2.optString(str);
            if (!C0048h.m305b(strOptString2)) {
                textView2.setTextColor(Color.parseColor(strOptString2));
            }
        }
        JSONObject jSONObjectM238a3 = C0032d.m238a(jSONObject, OTVendorListMode.GENERAL);
        String str2 = iM394a == 22 ? "borderColor" : "borderColorDark";
        if (!C0032d.m240a(jSONObjectM238a3)) {
            m353a(imageView, imageView.getDrawable(), jSONObjectM238a != null ? jSONObjectM238a.optString(str) : null, jSONObjectM238a3.optBoolean("showClose"));
            m353a(imageView2, imageView2.getBackground(), jSONObjectM238a3.optString(iM394a == 22 ? "iconBackgroundColor" : "iconBackgroundColorDark"), jSONObjectM238a3.optBoolean("showIcon"));
            String strOptString3 = jSONObjectM238a3.optString(iM394a == 22 ? "backgroundColor" : "backgroundColorDark");
            String strOptString4 = jSONObjectM238a3.optString(str2);
            if (!C0048h.m305b(strOptString3)) {
                cardView2.setBackgroundColor(Color.parseColor(strOptString3));
            }
            if (!C0048h.m305b(strOptString4)) {
                cardView.setBackgroundColor(Color.parseColor(strOptString4));
            }
        }
        JSONObject jSONObjectM238a4 = C0032d.m238a(jSONObject, "button");
        if (C0032d.m240a(jSONObjectM238a4) || !jSONObjectM238a4.optBoolean("show")) {
            return;
        }
        button.setVisibility(0);
        button.setText(jSONObjectM238a4.optString("text"));
        button.setTextColor(Color.parseColor(jSONObjectM238a4.optString(str)));
        if (jSONObjectM238a4.optBoolean("showAsLink")) {
            button.setBackgroundColor(Color.parseColor("#00000000"));
            button.setPaintFlags(button.getPaintFlags() | 8);
            return;
        }
        String strOptString5 = jSONObjectM238a4.optString(str2);
        String strOptString6 = jSONObjectM238a4.optString(iM394a == 22 ? "color" : "colorDark");
        String strOptString7 = jSONObjectM238a4.optString("borderRadius");
        Context context = button.getContext();
        if (C0048h.m305b(strOptString6)) {
            OTLogger.m2743a(3, "UIUtils", "Button set background color called with empty buttonBackGroundColor.");
            return;
        }
        if (new C0048h().m318g(context)) {
            button.setBackgroundColor(Color.parseColor(strOptString6));
            return;
        }
        String str3 = ExifInterface.GPS_MEASUREMENT_2D;
        if (!C0048h.m305b(ExifInterface.GPS_MEASUREMENT_2D) || !C0048h.m305b(strOptString7)) {
            if (C0048h.m305b(ExifInterface.GPS_MEASUREMENT_2D)) {
                str3 = "4";
            }
            if (C0048h.m305b(strOptString5)) {
                strOptString5 = strOptString6;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setStroke(Integer.parseInt(str3), Color.parseColor(strOptString5));
            gradientDrawable.setColor(Color.parseColor(strOptString6));
            if (!C0048h.m305b(strOptString7)) {
                gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, Integer.parseInt(strOptString7), context.getResources().getDisplayMetrics()));
            }
            button.setBackground(gradientDrawable);
            return;
        }
        C0074f.m399a(button, strOptString6, strOptString5, C3896R.id.cookies_setting_button);
    }
}
