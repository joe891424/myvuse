package p000a.p001a.p002a.p003a.p014b.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0016k;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.adapter.C0145m;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0124r;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;
import p000a.p001a.p002a.p003a.p014b.p021e.C0131y;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;
import p000a.p001a.p002a.p003a.p014b.p025i.C0171c;

/* JADX INFO: renamed from: a.a.a.a.b.h.c */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC0157c extends BottomSheetDialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: A */
    public C0124r f1154A;

    /* JADX INFO: renamed from: B */
    public C0074f f1155B;

    /* JADX INFO: renamed from: C */
    public String f1156C;

    /* JADX INFO: renamed from: D */
    public String f1157D;

    /* JADX INFO: renamed from: E */
    public C0002a f1158E;

    /* JADX INFO: renamed from: F */
    public C0171c f1159F;

    /* JADX INFO: renamed from: a */
    public String f1160a;

    /* JADX INFO: renamed from: b */
    public TextView f1161b;

    /* JADX INFO: renamed from: c */
    public TextView f1162c;

    /* JADX INFO: renamed from: d */
    public TextView f1163d;

    /* JADX INFO: renamed from: e */
    public TextView f1164e;

    /* JADX INFO: renamed from: f */
    public TextView f1165f;

    /* JADX INFO: renamed from: g */
    public RecyclerView f1166g;

    /* JADX INFO: renamed from: h */
    public BottomSheetDialog f1167h;

    /* JADX INFO: renamed from: i */
    public ImageView f1168i;

    /* JADX INFO: renamed from: j */
    public TextView f1169j;

    /* JADX INFO: renamed from: k */
    public Context f1170k;

    /* JADX INFO: renamed from: l */
    public OTPublishersHeadlessSDK f1171l;

    /* JADX INFO: renamed from: m */
    public JSONObject f1172m;

    /* JADX INFO: renamed from: n */
    public SwitchCompat f1173n;

    /* JADX INFO: renamed from: o */
    public RelativeLayout f1174o;

    /* JADX INFO: renamed from: p */
    public RelativeLayout f1175p;

    /* JADX INFO: renamed from: q */
    public LinearLayout f1176q;

    /* JADX INFO: renamed from: r */
    public String f1177r;

    /* JADX INFO: renamed from: s */
    public a f1178s;

    /* JADX INFO: renamed from: t */
    public View f1179t;

    /* JADX INFO: renamed from: u */
    public String f1180u;

    /* JADX INFO: renamed from: v */
    public String f1181v;

    /* JADX INFO: renamed from: w */
    public String f1182w;

    /* JADX INFO: renamed from: x */
    public String f1183x;

    /* JADX INFO: renamed from: y */
    public C0131y f1184y;

    /* JADX INFO: renamed from: z */
    public OTConfiguration f1185z;

    /* JADX INFO: renamed from: a.a.a.a.b.h.c$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo801a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m790a(DialogInterface dialogInterface) {
        JSONObject jSONObject;
        this.f1167h = (BottomSheetDialog) dialogInterface;
        this.f1155B.m414a(getActivity(), this.f1167h);
        this.f1167h.setCancelable(false);
        BottomSheetDialog bottomSheetDialog = this.f1167h;
        if (bottomSheetDialog != null && (jSONObject = this.f1172m) != null) {
            bottomSheetDialog.setTitle(jSONObject.optString("Name"));
        }
        this.f1167h.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: a.a.a.a.b.h.c$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i, KeyEvent keyEvent) {
                return this.f$0.m792a(dialogInterface2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m793a() {
        if (!C0048h.m305b(this.f1184y.f890e.f722a.f751b)) {
            this.f1161b.setTextSize(Float.parseFloat(this.f1184y.f890e.f722a.f751b));
        }
        if (!C0048h.m305b(this.f1184y.f892g.f722a.f751b)) {
            this.f1164e.setTextSize(Float.parseFloat(this.f1184y.f892g.f722a.f751b));
        }
        if (!C0048h.m305b(this.f1184y.f891f.f722a.f751b)) {
            this.f1165f.setTextSize(Float.parseFloat(this.f1184y.f891f.f722a.f751b));
        }
        if (!C0048h.m305b(this.f1184y.f893h.f722a.f751b)) {
            this.f1163d.setTextSize(Float.parseFloat(this.f1184y.f893h.f722a.f751b));
        }
        String str = this.f1184y.f895j.f755a.f722a.f751b;
        if (C0048h.m305b(str)) {
            return;
        }
        this.f1162c.setTextSize(Float.parseFloat(str));
    }

    /* JADX INFO: renamed from: a */
    public final void m794a(SwitchCompat switchCompat) {
        Drawable trackDrawable;
        int color;
        if (this.f1183x != null) {
            trackDrawable = switchCompat.getTrackDrawable();
            color = Color.parseColor(this.f1183x);
        } else {
            trackDrawable = switchCompat.getTrackDrawable();
            color = ContextCompat.getColor(this.f1170k, C3896R.color.light_greyOT);
        }
        trackDrawable.setTint(color);
        switchCompat.getThumbDrawable().setTint(this.f1182w != null ? Color.parseColor(this.f1182w) : ContextCompat.getColor(this.f1170k, C3896R.color.contentTextColorOT));
    }

    /* JADX INFO: renamed from: a */
    public final void m795a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = this.f1172m;
        if (jSONObject2 != null) {
            this.f1161b.setText(jSONObject2.getString("Name"));
            ViewCompat.setAccessibilityHeading(this.f1161b, true);
            this.f1161b.setLabelFor(C3896R.id.general_consent_switch);
            this.f1160a = this.f1172m.getString("PrivacyPolicyUrl");
            String string = this.f1172m.getString("Description");
            if (C0048h.m305b(string)) {
                this.f1164e.setVisibility(8);
            } else {
                this.f1155B.m412a(this.f1170k, this.f1164e, string);
            }
            JSONArray jSONArray = this.f1172m.getJSONArray("Sdks");
            if (C0032d.m239a(jSONArray)) {
                this.f1165f.setVisibility(8);
                return;
            }
            this.f1165f.setText(jSONObject.optString("PCenterCookiesListText"));
            ViewCompat.setAccessibilityHeading(this.f1165f, true);
            this.f1165f.setTextColor(Color.parseColor(this.f1157D));
            this.f1166g.setLayoutManager(new LinearLayoutManager(this.f1170k));
            this.f1166g.setAdapter(new C0145m(jSONArray, this.f1156C, this.f1184y, this.f1185z, OTVendorListMode.GENERAL));
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m796b() {
        if (!C0048h.m305b(this.f1184y.f890e.f723b)) {
            this.f1161b.setTextAlignment(Integer.parseInt(this.f1184y.f890e.f723b));
        }
        if (!C0048h.m305b(this.f1184y.f893h.f723b)) {
            this.f1163d.setTextAlignment(Integer.parseInt(this.f1184y.f893h.f723b));
        }
        if (!C0048h.m305b(this.f1184y.f892g.f723b)) {
            this.f1164e.setTextAlignment(Integer.parseInt(this.f1184y.f892g.f723b));
        }
        if (C0048h.m305b(this.f1184y.f891f.f723b)) {
            return;
        }
        this.f1165f.setTextAlignment(Integer.parseInt(this.f1184y.f891f.f723b));
    }

    /* JADX INFO: renamed from: b */
    public final void m797b(SwitchCompat switchCompat) {
        Drawable trackDrawable;
        int color;
        if (this.f1183x != null) {
            trackDrawable = switchCompat.getTrackDrawable();
            color = Color.parseColor(this.f1183x);
        } else {
            trackDrawable = switchCompat.getTrackDrawable();
            color = ContextCompat.getColor(this.f1170k, C3896R.color.light_greyOT);
        }
        trackDrawable.setTint(color);
        switchCompat.getThumbDrawable().setTint(this.f1181v != null ? Color.parseColor(this.f1181v) : ContextCompat.getColor(this.f1170k, C3896R.color.colorPrimaryOT));
    }

    /* JADX INFO: renamed from: c */
    public final void m799c() {
        this.f1162c.setOnClickListener(this);
        this.f1168i.setOnClickListener(this);
        this.f1173n.setOnClickListener(new View.OnClickListener() { // from class: a.a.a.a.b.h.c$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m791a(view);
            }
        });
    }

    /* JADX INFO: renamed from: d */
    public final void m800d() {
        String str = this.f1184y.f888c;
        if (str != null && !C0048h.m305b(str)) {
            this.f1182w = this.f1184y.f888c;
        }
        String str2 = this.f1184y.f887b;
        if (str2 != null && !C0048h.m305b(str2)) {
            this.f1181v = this.f1184y.f887b;
        }
        String str3 = this.f1184y.f889d;
        if (str3 == null || C0048h.m305b(str3)) {
            return;
        }
        this.f1183x = this.f1184y.f889d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C3896R.id.general_vendor_detail_back) {
            dismiss();
            this.f1178s.mo801a();
        } else if (id == C3896R.id.general_vendors_privacy_notice) {
            C0048h.m304b(this.f1170k, this.f1160a);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1155B.m414a(getActivity(), this.f1167h);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f1171l == null) {
            dismiss();
        }
        FragmentActivity activity = getActivity();
        if (C0170b.m959a(activity, OTFragmentTags.OT_GENERAL_VENDOR_DETAILS_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: a.a.a.a.b.h.c$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.m790a(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1170k = getContext();
        this.f1159F = new C0171c();
        if (!this.f1159F.m973a(this.f1171l, this.f1170k, C0074f.m394a(this.f1170k, this.f1185z))) {
            dismiss();
            return null;
        }
        Context context = this.f1170k;
        int i = C3896R.layout.ot_general_vendors_details_fragment;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        this.f1161b = (TextView) viewInflate.findViewById(C3896R.id.general_vendor_name);
        this.f1162c = (TextView) viewInflate.findViewById(C3896R.id.general_vendors_privacy_notice);
        this.f1174o = (RelativeLayout) viewInflate.findViewById(C3896R.id.general_vendor_detail_header);
        this.f1175p = (RelativeLayout) viewInflate.findViewById(C3896R.id.general_vendor_detail_RL);
        this.f1168i = (ImageView) viewInflate.findViewById(C3896R.id.general_vendor_detail_back);
        this.f1173n = (SwitchCompat) viewInflate.findViewById(C3896R.id.general_consent_switch);
        this.f1176q = (LinearLayout) viewInflate.findViewById(C3896R.id.gvd_linearLyt);
        this.f1163d = (TextView) viewInflate.findViewById(C3896R.id.general_consent_title);
        this.f1179t = viewInflate.findViewById(C3896R.id.general_vendor_name_view);
        this.f1164e = (TextView) viewInflate.findViewById(C3896R.id.general_vendor_description);
        this.f1165f = (TextView) viewInflate.findViewById(C3896R.id.general_vendor_sdk_list_title);
        this.f1166g = (RecyclerView) viewInflate.findViewById(C3896R.id.general_vendor_sdk_list);
        this.f1169j = (TextView) viewInflate.findViewById(C3896R.id.view_powered_by_logo);
        this.f1155B = new C0074f();
        try {
            JSONObject preferenceCenterData = this.f1171l.getPreferenceCenterData();
            if (preferenceCenterData != null) {
                m798b(preferenceCenterData);
                String strOptString = preferenceCenterData.optString("BConsentText");
                this.f1163d.setText(strOptString);
                this.f1173n.setContentDescription(strOptString);
                C0016k c0016kM103a = new C0016k(this.f1170k).m103a();
                if (getArguments() != null) {
                    String string = getArguments().getString("vendorId");
                    this.f1177r = string;
                    this.f1172m = this.f1171l.getVendorDetails(OTVendorListMode.GENERAL, string);
                    m795a(preferenceCenterData);
                    if (C0048h.m305b(c0016kM103a.f37c) || C0048h.m305b(this.f1160a)) {
                        this.f1162c.setVisibility(8);
                    } else {
                        this.f1162c.setText(c0016kM103a.f37c);
                    }
                    if (preferenceCenterData.has("PCPrivacyLinkActionAriaLabel")) {
                        C0170b.m955a(this.f1162c, preferenceCenterData.optString("PCPrivacyLinkActionAriaLabel"));
                    }
                    if (preferenceCenterData.has("PCenterBackText")) {
                        this.f1168i.setContentDescription(preferenceCenterData.optString("PCenterBackText"));
                    }
                }
                this.f1159F.m970a(this.f1169j, this.f1185z);
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "VendorDetail", "error while populating Vendor Detail fields" + e.getMessage());
        }
        m799c();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        View view;
        super.onResume();
        try {
            Context context = this.f1170k;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z = true;
            } else {
                sharedPreferencesC0047f = null;
                z = false;
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            if (sharedPreferences.getBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", false)) {
                int i = this.f1172m.getInt(OTVendorUtils.CONSENT_TYPE);
                if (i == 0) {
                    this.f1173n.setChecked(false);
                    m794a(this.f1173n);
                    return;
                } else if (i == 1) {
                    this.f1173n.setChecked(true);
                    m797b(this.f1173n);
                    return;
                } else {
                    this.f1173n.setVisibility(8);
                    this.f1163d.setVisibility(8);
                    view = this.f1179t;
                }
            } else {
                this.f1173n.setVisibility(8);
                this.f1163d.setVisibility(8);
                view = this.f1179t;
            }
            view.setVisibility(8);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "VendorDetail", "error while setting toggle values" + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m798b(JSONObject jSONObject) {
        String strOptString;
        try {
            int iM394a = C0074f.m394a(this.f1170k, this.f1185z);
            C0130x c0130x = new C0130x(this.f1170k, iM394a);
            this.f1184y = c0130x.m675c();
            this.f1154A = c0130x.f880a.m622b();
            C0106b0 c0106b0 = this.f1184y.f890e;
            if (!C0048h.m305b(c0106b0.f724c)) {
                strOptString = c0106b0.f724c;
            } else {
                strOptString = jSONObject.optString("PcTextColor");
            }
            this.f1180u = strOptString;
            String str = this.f1184y.f892g.f724c;
            String strOptString2 = jSONObject.optString("PcTextColor");
            String str2 = "#696969";
            if (C0048h.m305b(str)) {
                str = !C0048h.m305b(strOptString2) ? strOptString2 : iM394a == 11 ? "#FFFFFF" : "#696969";
            }
            this.f1156C = str;
            String str3 = this.f1184y.f891f.f724c;
            String strOptString3 = jSONObject.optString("PcTextColor");
            if (C0048h.m305b(str3)) {
                str3 = !C0048h.m305b(strOptString3) ? strOptString3 : iM394a == 11 ? "#FFFFFF" : "#696969";
            }
            this.f1157D = str3;
            String str4 = this.f1184y.f893h.f724c;
            String strOptString4 = jSONObject.optString("PcTextColor");
            if (C0048h.m305b(str4)) {
                str4 = !C0048h.m305b(strOptString4) ? strOptString4 : iM394a == 11 ? "#FFFFFF" : "#696969";
            }
            String str5 = this.f1184y.f886a;
            String strOptString5 = jSONObject.optString("PcBackgroundColor");
            if (C0048h.m305b(str5)) {
                str5 = !C0048h.m305b(strOptString5) ? strOptString5 : iM394a == 11 ? "#2F2F2F" : "#FFFFFF";
            }
            String str6 = this.f1184y.f896k;
            String strOptString6 = jSONObject.optString("PcTextColor");
            if (!C0048h.m305b(str6)) {
                str2 = str6;
            } else if (!C0048h.m305b(strOptString6)) {
                str2 = strOptString6;
            } else if (iM394a == 11) {
                str2 = "#FFFFFF";
            }
            m800d();
            String strM408a = this.f1155B.m408a(this.f1184y.f895j.f755a, jSONObject.optString("PcLinksTextColor"));
            C0124r c0124r = this.f1154A;
            if (c0124r == null || c0124r.f800a) {
                TextView textView = this.f1162c;
                textView.setPaintFlags(textView.getPaintFlags() | 8);
            }
            m793a();
            m796b();
            this.f1155B.m417a(this.f1161b, this.f1184y.f890e.f722a, this.f1185z);
            this.f1155B.m417a(this.f1162c, this.f1184y.f895j.f755a.f722a, this.f1185z);
            this.f1155B.m417a(this.f1163d, this.f1184y.f893h.f722a, this.f1185z);
            this.f1155B.m417a(this.f1164e, this.f1184y.f892g.f722a, this.f1185z);
            this.f1155B.m417a(this.f1165f, this.f1184y.f891f.f722a, this.f1185z);
            this.f1161b.setTextColor(Color.parseColor(this.f1180u));
            this.f1163d.setTextColor(Color.parseColor(str4));
            this.f1175p.setBackgroundColor(Color.parseColor(str5));
            this.f1174o.setBackgroundColor(Color.parseColor(str5));
            this.f1176q.setBackgroundColor(Color.parseColor(str5));
            this.f1168i.setColorFilter(Color.parseColor(str2));
            this.f1162c.setTextColor(Color.parseColor(strM408a));
            this.f1164e.setTextColor(Color.parseColor(str));
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error while applying styles to Vendor details, err : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m791a(View view) {
        this.f1171l.updateVendorConsent(OTVendorListMode.GENERAL, this.f1177r, this.f1173n.isChecked());
        if (this.f1173n.isChecked()) {
            m797b(this.f1173n);
        } else {
            m794a(this.f1173n);
        }
        String strOptString = this.f1172m.optString("VendorCustomId");
        C0003b c0003b = new C0003b(15);
        c0003b.f3b = strOptString;
        c0003b.f4c = this.f1173n.isChecked() ? 1 : 0;
        c0003b.f6e = OTVendorListMode.GENERAL;
        C0002a c0002a = this.f1158E;
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m792a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (!C0170b.m957a(i, keyEvent)) {
            return false;
        }
        dismiss();
        this.f1178s.mo801a();
        return false;
    }
}
