package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerModule;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentUICallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import org.json.JSONException;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0004a;
import p000a.p001a.p002a.p003a.p014b.InterfaceC0075c;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0115i;
import p000a.p001a.p002a.p003a.p014b.p021e.C0121o;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0171c;

/* JADX INFO: renamed from: a.a.a.a.b.h.a */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0155a extends BottomSheetDialogFragment implements View.OnClickListener, InterfaceC0075c {

    /* JADX INFO: renamed from: a */
    public Context f1121a;

    /* JADX INFO: renamed from: b */
    public TextView f1122b;

    /* JADX INFO: renamed from: c */
    public TextView f1123c;

    /* JADX INFO: renamed from: d */
    public Button f1124d;

    /* JADX INFO: renamed from: e */
    public Button f1125e;

    /* JADX INFO: renamed from: f */
    public ImageView f1126f;

    /* JADX INFO: renamed from: g */
    public BottomSheetDialog f1127g;

    /* JADX INFO: renamed from: h */
    public RelativeLayout f1128h;

    /* JADX INFO: renamed from: i */
    public TextView f1129i;

    /* JADX INFO: renamed from: j */
    public C0074f f1130j;

    /* JADX INFO: renamed from: k */
    public OTConfiguration f1131k;

    /* JADX INFO: renamed from: l */
    public OTPublishersHeadlessSDK f1132l;

    /* JADX INFO: renamed from: m */
    public C0121o f1133m;

    /* JADX INFO: renamed from: n */
    public OTConsentUICallback f1134n;

    /* JADX INFO: renamed from: a.a.a.a.b.h.a$a */
    public class a implements RequestListener<Drawable> {
        public a() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            OTLogger.m2743a(3, "OTAgeGateFragment", "Logo shown for Age Gate Prompt failed for url " + ViewOnClickListenerC0155a.this.f1133m.f774c);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            OTLogger.m2743a(3, "OTAgeGateFragment", "Logo shown for Age Gate Prompt for url " + ViewOnClickListenerC0155a.this.f1133m.f774c);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m761a(DialogInterface dialogInterface) {
        this.f1127g = (BottomSheetDialog) dialogInterface;
        this.f1130j.m414a(getActivity(), this.f1127g);
        this.f1127g.setCancelable(false);
        this.f1127g.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.a$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return ViewOnClickListenerC0155a.m762a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ boolean m762a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final void m763a() {
        RelativeLayout relativeLayout;
        int color;
        C0121o c0121o = this.f1133m;
        if (c0121o != null) {
            if (C0048h.m305b(c0121o.f775d)) {
                relativeLayout = this.f1128h;
                color = ContextCompat.getColor(this.f1121a, C3896R.color.whiteOT);
            } else {
                relativeLayout = this.f1128h;
                color = Color.parseColor(this.f1133m.f775d);
            }
            relativeLayout.setBackgroundColor(color);
            int color2 = ContextCompat.getColor(this.f1121a, C3896R.color.groupItemSelectedBGOT);
            int color3 = ContextCompat.getColor(this.f1121a, C3896R.color.whiteOT);
            C0106b0 c0106b0 = this.f1133m.f776e;
            m766a(this.f1122b, c0106b0, !C0048h.m305b(c0106b0.f724c) ? c0106b0.f724c : "");
            C0106b0 c0106b02 = this.f1133m.f777f;
            m766a(this.f1123c, c0106b02, C0048h.m305b(c0106b02.f724c) ? "" : c0106b02.f724c);
            m765a(this.f1124d, this.f1133m.f778g, color2, color3);
            m765a(this.f1125e, this.f1133m.f779h, color2, color3);
            a aVar = new a();
            C0121o c0121o2 = this.f1133m;
            if (!c0121o2.f773b) {
                this.f1126f.getLayoutParams().height = 20;
            } else if (C0048h.m305b(c0121o2.f774c)) {
                this.f1126f.setImageResource(C3896R.drawable.ic_ag);
            } else {
                Glide.with(this).load(this.f1133m.f774c).fitCenter().listener(aVar).fallback(C3896R.drawable.ic_ag).timeout(AndroidLocationEnablerModule.DEFAULT_INTERVAL_DURATION).into(this.f1126f);
            }
        }
    }

    @Override // p000a.p001a.p002a.p003a.p014b.InterfaceC0075c
    /* JADX INFO: renamed from: a */
    public void mo419a(int i) {
        dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        int id = view.getId();
        C0004a c0004a = new C0004a(this.f1121a);
        if (id == C3896R.id.btn_accept) {
            str = "OPT_IN";
        } else if (id != C3896R.id.btn_not_now) {
            return;
        } else {
            str = "OPT_OUT";
        }
        m764a(c0004a, str);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1130j.m414a(getActivity(), this.f1127g);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f1132l = new OTPublishersHeadlessSDK(getContext().getApplicationContext());
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_AGE_GATE_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (C0048h.m305b(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
                if (!C0048h.m305b(string2)) {
                    str = string2;
                }
                if (!str.equals(OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN)) {
                    return;
                }
            }
            OTLogger.m2743a(3, "OneTrust", "set theme to OT defined theme ");
            setStyle(0, C3896R.style.OTSDKTheme);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.a$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m761a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1121a = getContext();
        C0171c c0171c = new C0171c();
        if (!c0171c.m973a(this.f1132l, this.f1121a, C0074f.m394a(this.f1121a, this.f1131k))) {
            dismiss();
            return null;
        }
        C0074f c0074f = new C0074f();
        this.f1130j = c0074f;
        View viewM406a = c0074f.m406a(this.f1121a, layoutInflater, viewGroup, C3896R.layout.fragment_ot_age_gate);
        this.f1124d = (Button) viewM406a.findViewById(C3896R.id.btn_accept);
        this.f1125e = (Button) viewM406a.findViewById(C3896R.id.btn_not_now);
        this.f1128h = (RelativeLayout) viewM406a.findViewById(C3896R.id.age_gate_parent_layout);
        this.f1122b = (TextView) viewM406a.findViewById(C3896R.id.age_gate_title);
        this.f1123c = (TextView) viewM406a.findViewById(C3896R.id.age_gate_description);
        this.f1126f = (ImageView) viewM406a.findViewById(C3896R.id.age_gate_logo);
        this.f1129i = (TextView) viewM406a.findViewById(C3896R.id.view_powered_by_logo);
        this.f1124d.setOnClickListener(this);
        this.f1125e.setOnClickListener(this);
        try {
            this.f1133m = new C0130x(this.f1121a).m670a();
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTAgeGateFragment", "Error in ui property object, error message = " + e.getMessage());
        }
        try {
            m763a();
            c0171c.m970a(this.f1129i, this.f1131k);
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "OTAgeGateFragment", "error while populating Age-Gate UI " + e2.getMessage());
        }
        return viewM406a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m764a(p000a.p001a.p002a.p003a.p004a.p007c.C0004a r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "OPT_IN"
            boolean r0 = r5.equals(r0)
            r1 = -1
            java.lang.String r2 = "OT_AGE_GATE_USER_CONSENT_STATUS"
            if (r0 == 0) goto L1e
            a.a.a.a.a.g.d r5 = r4.f8a
            android.content.SharedPreferences r5 = r5.m271a()
            android.content.SharedPreferences$Editor r5 = r5.edit()
            r0 = 1
        L16:
            android.content.SharedPreferences$Editor r5 = r5.putInt(r2, r0)
            r5.apply()
            goto L43
        L1e:
            java.lang.String r0 = "OPT_OUT"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L32
            a.a.a.a.a.g.d r5 = r4.f8a
            android.content.SharedPreferences r5 = r5.m271a()
            android.content.SharedPreferences$Editor r5 = r5.edit()
            r0 = 0
            goto L16
        L32:
            a.a.a.a.a.g.d r5 = r4.f8a
            android.content.SharedPreferences r5 = r5.m271a()
            android.content.SharedPreferences$Editor r5 = r5.edit()
            android.content.SharedPreferences$Editor r5 = r5.putInt(r2, r1)
            r5.apply()
        L43:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Saving Age Gate Consent :"
            r5.<init>(r0)
            a.a.a.a.a.g.d r4 = r4.f8a
            android.content.SharedPreferences r4 = r4.m271a()
            int r4 = r4.getInt(r2, r1)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "AgeGateConsentHandler"
            r0 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r0, r5, r4)
            r3.dismiss()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Age-Gate Consent Status: "
            r4.<init>(r5)
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r5 = r3.f1132l
            int r5 = r5.getAgeGatePromptValue()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "OTAgeGateFragment"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r0, r5, r4)
            com.onetrust.otpublishers.headless.Public.OTConsentUICallback r4 = r3.f1134n
            if (r4 == 0) goto L86
            r4.onCompletion()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0155a.m764a(a.a.a.a.a.c.a, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    public final void m765a(Button button, C0107c c0107c, int i, int i2) {
        C0115i c0115i = c0107c.f728a;
        this.f1130j.m416a(button, c0115i, this.f1131k);
        if (!C0048h.m305b(c0115i.f751b)) {
            button.setTextSize(Float.parseFloat(c0115i.f751b));
        }
        button.setText(c0107c.mo376a());
        if (!C0048h.m305b(c0107c.mo378b())) {
            i2 = Color.parseColor(c0107c.mo378b());
        } else if (button.equals(this.f1125e)) {
            i2 = ContextCompat.getColor(this.f1121a, C3896R.color.blackOT);
        }
        button.setTextColor(i2);
        if (!C0048h.m305b(c0107c.f729b)) {
            C0074f.m397a(this.f1121a, button, c0107c, c0107c.f729b, c0107c.f731d);
            return;
        }
        if (!button.equals(this.f1125e)) {
            button.setBackgroundColor(i);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_3D), ContextCompat.getColor(this.f1121a, C3896R.color.blackOT));
        gradientDrawable.setColor(ContextCompat.getColor(this.f1121a, C3896R.color.whiteOT));
        button.setBackground(gradientDrawable);
    }

    /* JADX INFO: renamed from: a */
    public final void m766a(TextView textView, C0106b0 c0106b0, String str) {
        C0115i c0115i = c0106b0.f722a;
        textView.setText(c0106b0.f726e);
        this.f1130j.m417a(textView, c0106b0.f722a, this.f1131k);
        if (!C0048h.m305b(c0115i.f751b)) {
            textView.setTextSize(Float.parseFloat(c0115i.f751b));
        }
        if (!C0048h.m305b(c0106b0.f723b)) {
            C0074f.m401a(textView, Integer.parseInt(c0106b0.f723b));
        }
        textView.setTextColor(!C0048h.m305b(str) ? Color.parseColor(str) : ContextCompat.getColor(this.f1121a, C3896R.color.blackOT));
    }
}
