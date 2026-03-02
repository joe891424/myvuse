package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.cardview.widget.CardView;
import androidx.core.widget.CompoundButtonCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0078c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0086b;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0117k;
import p000a.p001a.p002a.p003a.p014b.p021e.C0126t;
import p000a.p001a.p002a.p003a.p014b.p025i.C0170b;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.c */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0092c extends Fragment implements C0078c.a, View.OnKeyListener, View.OnFocusChangeListener, TraceFieldInterface {

    /* JADX INFO: renamed from: A */
    public View f458A;

    /* JADX INFO: renamed from: B */
    public C0087c f459B;

    /* JADX INFO: renamed from: C */
    public CardView f460C;

    /* JADX INFO: renamed from: D */
    public CardView f461D;

    /* JADX INFO: renamed from: E */
    public CardView f462E;

    /* JADX INFO: renamed from: F */
    public CardView f463F;

    /* JADX INFO: renamed from: G */
    public LinearLayout f464G;

    /* JADX INFO: renamed from: H */
    public LinearLayout f465H;

    /* JADX INFO: renamed from: I */
    public LinearLayout f466I;

    /* JADX INFO: renamed from: J */
    public LinearLayout f467J;

    /* JADX INFO: renamed from: K */
    public TextView f468K;

    /* JADX INFO: renamed from: L */
    public TextView f469L;

    /* JADX INFO: renamed from: M */
    public RelativeLayout f470M;

    /* JADX INFO: renamed from: N */
    public TextView f471N;

    /* JADX INFO: renamed from: O */
    public CheckBox f472O;

    /* JADX INFO: renamed from: P */
    public CheckBox f473P;

    /* JADX INFO: renamed from: Q */
    public CheckBox f474Q;

    /* JADX INFO: renamed from: R */
    public CheckBox f475R;

    /* JADX INFO: renamed from: S */
    public boolean f476S = true;

    /* JADX INFO: renamed from: T */
    public boolean f477T = true;

    /* JADX INFO: renamed from: U */
    public String f478U;

    /* JADX INFO: renamed from: V */
    public ImageView f479V;

    /* JADX INFO: renamed from: W */
    public LinearLayout f480W;

    /* JADX INFO: renamed from: X */
    public TextView f481X;

    /* JADX INFO: renamed from: Y */
    public View f482Y;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public TextView f483a;

    /* JADX INFO: renamed from: b */
    public TextView f484b;

    /* JADX INFO: renamed from: c */
    public TextView f485c;

    /* JADX INFO: renamed from: d */
    public TextView f486d;

    /* JADX INFO: renamed from: e */
    public TextView f487e;

    /* JADX INFO: renamed from: f */
    public RecyclerView f488f;

    /* JADX INFO: renamed from: g */
    public Context f489g;

    /* JADX INFO: renamed from: h */
    public LinearLayout f490h;

    /* JADX INFO: renamed from: i */
    public LinearLayout f491i;

    /* JADX INFO: renamed from: j */
    public TextView f492j;

    /* JADX INFO: renamed from: k */
    public OTPublishersHeadlessSDK f493k;

    /* JADX INFO: renamed from: l */
    public TextView f494l;

    /* JADX INFO: renamed from: m */
    public TextView f495m;

    /* JADX INFO: renamed from: n */
    public TextView f496n;

    /* JADX INFO: renamed from: o */
    public TextView f497o;

    /* JADX INFO: renamed from: p */
    public TextView f498p;

    /* JADX INFO: renamed from: q */
    public View f499q;

    /* JADX INFO: renamed from: r */
    public Button f500r;

    /* JADX INFO: renamed from: s */
    public Button f501s;

    /* JADX INFO: renamed from: t */
    public TextView f502t;

    /* JADX INFO: renamed from: u */
    public JSONObject f503u;

    /* JADX INFO: renamed from: v */
    public LinearLayout f504v;

    /* JADX INFO: renamed from: w */
    public C0002a f505w;

    /* JADX INFO: renamed from: x */
    public a f506x;

    /* JADX INFO: renamed from: y */
    public boolean f507y;

    /* JADX INFO: renamed from: z */
    public C0078c f508z;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.c$a */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m519a(CompoundButton compoundButton, boolean z) {
        String strOptString = this.f503u.optString("CustomGroupId");
        this.f493k.updatePurposeLegitInterest(strOptString, z);
        m526a(z, strOptString, 11);
        if (this.f503u.has("SubGroups") && C0048h.m305b(this.f503u.optString("Parent")) && this.f477T) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f493k;
            JSONObject jSONObject = this.f503u;
            for (int i = 0; i < jSONObject.getJSONArray("SubGroups").length(); i++) {
                try {
                    oTPublishersHeadlessSDK.updatePurposeLegitInterest(jSONObject.getJSONArray("SubGroups").getJSONObject(i).optString("CustomGroupId"), z);
                } catch (Exception e) {
                    OTLogger.m2743a(6, "OneTrust", "error while updating subgroup LI status on TV, err : " + e.getMessage());
                }
            }
        }
        C0078c c0078c = this.f508z;
        if (c0078c != null) {
            c0078c.notifyDataSetChanged();
        }
        this.f477T = true;
    }

    @Override // p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0078c.a
    /* JADX INFO: renamed from: a */
    public void mo433a() {
        ((ViewOnKeyListenerC0095f) this.f506x).m559a(24);
    }

    /* JADX INFO: renamed from: a */
    public final void m520a(View view) {
        this.f483a = (TextView) view.findViewById(C3896R.id.tv_category_title);
        this.f484b = (TextView) view.findViewById(C3896R.id.tv_category_desc);
        this.f490h = (LinearLayout) view.findViewById(C3896R.id.group_status_on);
        this.f491i = (LinearLayout) view.findViewById(C3896R.id.group_status_off);
        this.f502t = (TextView) view.findViewById(C3896R.id.tv_vl_desc);
        this.f488f = (RecyclerView) view.findViewById(C3896R.id.tv_subgroup_list);
        this.f485c = (TextView) view.findViewById(C3896R.id.subgroup_list_title);
        this.f458A = view.findViewById(C3896R.id.ot_grp_dtl_sg_div);
        this.f504v = (LinearLayout) view.findViewById(C3896R.id.tv_grp_detail_lyt);
        this.f460C = (CardView) view.findViewById(C3896R.id.tv_sg_card_on);
        this.f461D = (CardView) view.findViewById(C3896R.id.tv_sg_card_off);
        this.f474Q = (CheckBox) view.findViewById(C3896R.id.tv_consent_on_cb);
        this.f475R = (CheckBox) view.findViewById(C3896R.id.tv_consent_off_cb);
        this.f488f.setHasFixedSize(true);
        this.f488f.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f460C.setOnKeyListener(this);
        this.f461D.setOnKeyListener(this);
        this.f460C.setOnFocusChangeListener(this);
        this.f461D.setOnFocusChangeListener(this);
        this.f486d = (TextView) view.findViewById(C3896R.id.group_status_on_tv);
        this.f487e = (TextView) view.findViewById(C3896R.id.group_status_off_tv);
        this.f492j = (TextView) view.findViewById(C3896R.id.ot_iab_legal_desc_tv);
        this.f471N = (TextView) view.findViewById(C3896R.id.always_active_status_iab);
        this.f472O = (CheckBox) view.findViewById(C3896R.id.tv_consent_cb);
        this.f473P = (CheckBox) view.findViewById(C3896R.id.tv_li_cb);
        this.f466I = (LinearLayout) view.findViewById(C3896R.id.tv_dsid_layout);
        this.f494l = (TextView) view.findViewById(C3896R.id.tv_dsid_title);
        this.f495m = (TextView) view.findViewById(C3896R.id.tv_dsid);
        this.f496n = (TextView) view.findViewById(C3896R.id.tv_timestamp_title);
        this.f497o = (TextView) view.findViewById(C3896R.id.tv_timestamp);
        this.f498p = (TextView) view.findViewById(C3896R.id.tv_dsid_description);
        this.f499q = view.findViewById(C3896R.id.tv_dsid_divider);
        this.f467J = (LinearLayout) view.findViewById(C3896R.id.tv_partners_layout);
        this.f500r = (Button) view.findViewById(C3896R.id.tv_btn_iab_vendor);
        this.f501s = (Button) view.findViewById(C3896R.id.tv_btn_google_vendor);
        this.f473P.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.d.c.c$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m519a(compoundButton, z);
            }
        });
        this.f462E = (CardView) view.findViewById(C3896R.id.card_list_of_partners);
        this.f464G = (LinearLayout) view.findViewById(C3896R.id.list_of_partners_lyt);
        this.f468K = (TextView) view.findViewById(C3896R.id.list_of_partners_tv);
        this.f463F = (CardView) view.findViewById(C3896R.id.card_list_of_sdks);
        this.f465H = (LinearLayout) view.findViewById(C3896R.id.list_of_sdks_lyt);
        this.f469L = (TextView) view.findViewById(C3896R.id.list_of_sdks_tv);
        this.f470M = (RelativeLayout) view.findViewById(C3896R.id.ot_tv_pc_detail_parent_lyt);
        this.f462E.setOnKeyListener(this);
        this.f462E.setOnFocusChangeListener(this);
        this.f463F.setOnKeyListener(this);
        this.f463F.setOnFocusChangeListener(this);
        this.f492j.setOnKeyListener(this);
        this.f484b.setOnKeyListener(this);
        this.f483a.setOnKeyListener(this);
        this.f500r.setOnKeyListener(this);
        this.f500r.setOnFocusChangeListener(this);
        this.f501s.setOnFocusChangeListener(this);
        this.f501s.setOnKeyListener(this);
        this.f502t.setOnKeyListener(this);
        this.f480W = (LinearLayout) view.findViewById(C3896R.id.tv_qr_code);
        this.f479V = (ImageView) view.findViewById(C3896R.id.qrcode_img_tv);
        this.f481X = (TextView) view.findViewById(C3896R.id.tv_qr_code_text);
        this.f482Y = view.findViewById(C3896R.id.ot_qr_code_tv_div);
        this.f479V.setOnKeyListener(this);
        this.f481X.setOnKeyListener(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m522a(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.f472O, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.f474Q, new ColorStateList(iArr, iArr2));
        this.f471N.setTextColor(Color.parseColor(str));
        this.f486d.setTextColor(Color.parseColor(str));
        this.f490h.setBackgroundColor(Color.parseColor(str2));
        C0072d.m385a(this.f486d, str);
    }

    @Override // p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0078c.a
    /* JADX INFO: renamed from: a */
    public void mo434a(JSONObject jSONObject, boolean z) {
        ((ViewOnKeyListenerC0095f) this.f506x).m561a(jSONObject, z);
    }

    /* JADX INFO: renamed from: b */
    public final void m527b() {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        C0074f c0074f = new C0074f();
        this.f459B = C0087c.m482c();
        C0086b c0086bM475a = C0086b.m475a();
        Context context = this.f489g;
        TextView textView = this.f483a;
        JSONObject jSONObject = this.f503u;
        c0074f.m412a(context, textView, jSONObject.optString(C0048h.m305b(jSONObject.optString("GroupNameOTT")) ? "GroupName" : "GroupNameOTT"));
        this.f486d.setText(c0086bM475a.f347b);
        this.f487e.setText(c0086bM475a.f348c);
        this.f492j.setVisibility(this.f459B.m497d(this.f503u));
        c0074f.m412a(this.f489g, this.f492j, C0087c.m483c(this.f503u));
        this.f468K.setText(this.f459B.f378j.f822E.f755a.f726e);
        if (C0048h.m305b(C0087c.m481b(this.f503u))) {
            this.f484b.setVisibility(8);
        } else {
            c0074f.m412a(this.f489g, this.f484b, C0087c.m481b(this.f503u));
        }
        C0087c c0087c = this.f459B;
        this.f478U = new C0072d().m392a(c0087c.m494b());
        String strM498d = c0087c.m498d();
        this.f484b.setTextColor(Color.parseColor(strM498d));
        this.f483a.setTextColor(Color.parseColor(strM498d));
        this.f504v.setBackgroundColor(Color.parseColor(c0087c.m494b()));
        this.f458A.setBackgroundColor(Color.parseColor(strM498d));
        this.f485c.setTextColor(Color.parseColor(strM498d));
        this.f492j.setTextColor(Color.parseColor(strM498d));
        m524a(false, c0087c.f378j.f854y, this.f462E, this.f464G, this.f468K);
        m522a(strM498d, this.f478U);
        m528b(strM498d, this.f478U);
        this.f460C.setCardElevation(1.0f);
        this.f461D.setCardElevation(1.0f);
        m532d();
        if (this.f503u.optBoolean("IS_PARTNERS_LINK")) {
            this.f460C.setVisibility(8);
            this.f461D.setVisibility(8);
            this.f466I.setVisibility(8);
            this.f467J.setVisibility(0);
            this.f500r.setText(this.f459B.f379k);
            C0074f c0074f2 = new C0074f();
            Context context2 = getContext();
            TextView textView2 = this.f502t;
            String str = this.f459B.f381m;
            if (str == null) {
                str = "";
            }
            c0074f2.m412a(context2, textView2, str);
            this.f502t.setTextColor(Color.parseColor(this.f459B.m498d()));
            Context context3 = getContext();
            SharedPreferences sharedPreferences = context3.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(context3.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context3, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z = true;
            } else {
                sharedPreferencesC0047f = null;
                z = false;
            }
            if (z) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            if (sharedPreferences.getBoolean("OT_GOOGLE_VENDORS_ENABLED_STATE", false)) {
                this.f501s.setVisibility(0);
                this.f501s.setText(this.f459B.f380l);
            }
            C0072d.m386a(false, this.f459B.f378j.f854y, this.f500r);
            C0072d.m386a(false, this.f459B.f378j.f854y, this.f501s);
            if (C0048h.m305b(this.f459B.f378j.f854y.f731d)) {
                this.f500r.setMinHeight(70);
                this.f500r.setMinimumHeight(70);
                this.f501s.setMinHeight(70);
                this.f501s.setMinimumHeight(70);
            } else {
                this.f500r.setMinHeight(0);
                this.f500r.setMinimumHeight(0);
                this.f501s.setMinHeight(0);
                this.f501s.setMinimumHeight(0);
                this.f500r.setPadding(15, 5, 15, 5);
                this.f501s.setPadding(15, 5, 15, 5);
            }
        } else if (this.f503u.optBoolean("isAlertNotice")) {
            this.f460C.setVisibility(8);
            this.f461D.setVisibility(8);
            C0126t c0126t = this.f459B.f378j;
            if (Boolean.parseBoolean(c0126t.f826I)) {
                m521a(this.f494l, c0126t.f842m);
                m521a(this.f495m, c0126t.f843n);
                m521a(this.f496n, c0126t.f844o);
                m521a(this.f497o, c0126t.f845p);
                m521a(this.f498p, c0126t.f847r);
                this.f499q.setBackgroundColor(Color.parseColor(this.f459B.m498d()));
            } else {
                this.f466I.setVisibility(8);
            }
            C0117k c0117k = this.f459B.f378j.f821D;
            String str2 = c0117k.f756b;
            C0106b0 c0106b0 = c0117k.f755a;
            String str3 = c0106b0.f726e;
            boolean zM614a = c0106b0.m614a();
            if (!C0048h.m305b(str2) && zM614a && C0170b.m959a(getActivity(), OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG)) {
                this.f480W.setVisibility(0);
                try {
                    C0026u.m177a(str2, (Activity) getActivity(), this.f459B.m494b(), this.f459B.m498d(), this.f479V, false);
                    this.f481X.setText(str3);
                    this.f481X.setTextColor(Color.parseColor(this.f459B.m498d()));
                    this.f482Y.setBackgroundColor(Color.parseColor(this.f459B.m498d()));
                } catch (Exception e) {
                    OTLogger.m2743a(6, "OneTrust", "Exception while rendering QR code," + e);
                }
            } else {
                this.f480W.setVisibility(8);
            }
        } else {
            this.f466I.setVisibility(8);
            this.f460C.setVisibility(this.f459B.m501f(this.f503u));
            this.f461D.setVisibility(this.f459B.m501f(this.f503u));
            if (this.f503u.optBoolean("IsIabPurpose")) {
                this.f460C.setVisibility(this.f503u.optBoolean("HasConsentOptOut") ? 0 : 8);
                this.f461D.setVisibility(this.f503u.optBoolean("HasLegIntOptOut") ? 0 : 8);
            }
            this.f463F.setVisibility(this.f459B.m499e(this.f503u));
            this.f469L.setText(this.f459B.f378j.f823F.f755a.f726e);
            m524a(false, this.f459B.f378j.f854y, this.f463F, this.f465H, this.f469L);
        }
        this.f462E.setVisibility(this.f503u.optBoolean("IsIabPurpose") ? 0 : 8);
        if (this.f503u.optString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
            if (!this.f503u.optBoolean("isAlertNotice")) {
                this.f460C.setVisibility(0);
            }
            String strM487a = this.f459B.m487a();
            if (this.f459B.m500e()) {
                this.f486d.setText(this.f459B.m488a(!this.f503u.optBoolean("IsIabPurpose")));
                this.f471N.setVisibility(0);
                this.f471N.setText(strM487a);
            } else {
                this.f486d.setText(strM487a);
                m532d();
            }
            this.f474Q.setVisibility(8);
            if (C0048h.m305b(strM487a)) {
                this.f460C.setVisibility(8);
            }
        } else if (this.f459B.m500e() && !this.f503u.optBoolean("isAlertNotice")) {
            OTLogger.m2743a(3, "TVPCDetail", "Showing Consent Toggle UI");
            this.f474Q.setVisibility(8);
            this.f475R.setVisibility(8);
            this.f486d.setText(this.f459B.m488a(!this.f503u.optBoolean("IsIabPurpose")));
            this.f487e.setText(this.f459B.f376h);
            int purposeLegitInterestLocal = this.f493k.getPurposeLegitInterestLocal(this.f503u.optString("CustomGroupId"));
            int iM486a = this.f459B.m486a(purposeLegitInterestLocal);
            this.f461D.setVisibility(iM486a);
            this.f473P.setVisibility(iM486a);
            this.f472O.setVisibility(0);
            if (iM486a == 0) {
                this.f473P.setChecked(purposeLegitInterestLocal == 1);
            }
            this.f472O.setChecked(this.f493k.getPurposeConsentLocal(this.f503u.optString("CustomGroupId")) == 1);
        }
        this.f485c.setVisibility(8);
        this.f458A.setVisibility(this.f462E.getVisibility());
        if (this.f507y || C0087c.m485h(this.f503u)) {
            return;
        }
        C0078c c0078c = new C0078c((JSONArray) Objects.requireNonNull(this.f503u.optJSONArray("SubGroups")), this.f489g, this.f493k, this);
        this.f508z = c0078c;
        this.f488f.setAdapter(c0078c);
        this.f485c.setText(c0086bM475a.f349d);
        this.f485c.setVisibility(0);
        this.f458A.setVisibility(0);
    }

    /* JADX INFO: renamed from: b */
    public final void m528b(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.f473P, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.f475R, new ColorStateList(iArr, iArr2));
        this.f487e.setTextColor(Color.parseColor(str));
        this.f491i.setBackgroundColor(Color.parseColor(str2));
        C0072d.m385a(this.f487e, str);
    }

    /* JADX INFO: renamed from: c */
    public void m530c() {
        CardView cardView;
        if (this.f503u.optBoolean("IS_PARTNERS_LINK")) {
            this.f500r.requestFocus();
            return;
        }
        if (this.f460C.getVisibility() == 0) {
            cardView = this.f460C;
        } else {
            if (this.f461D.getVisibility() != 0) {
                if (this.f484b.getVisibility() == 0) {
                    this.f484b.requestFocus();
                    return;
                }
                return;
            }
            cardView = this.f461D;
        }
        cardView.requestFocus();
    }

    /* JADX INFO: renamed from: c */
    public final void m531c(boolean z) {
        String strOptString = this.f503u.optString("CustomGroupId");
        this.f493k.updatePurposeConsent(strOptString, z);
        m526a(z, strOptString, 7);
        m525a(z, strOptString);
        if (this.f503u.has("SubGroups") && C0048h.m305b(this.f503u.optString("Parent")) && this.f476S) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f493k;
            JSONObject jSONObject = this.f503u;
            for (int i = 0; i < jSONObject.getJSONArray("SubGroups").length(); i++) {
                try {
                    String strOptString2 = jSONObject.getJSONArray("SubGroups").getJSONObject(i).optString("CustomGroupId");
                    oTPublishersHeadlessSDK.updatePurposeConsent(strOptString2, z);
                    m525a(z, strOptString2);
                } catch (Exception e) {
                    OTLogger.m2743a(6, "OneTrust", "error while updating subgroup status on TV, err : " + e.getMessage());
                }
            }
        }
        C0078c c0078c = this.f508z;
        if (c0078c != null) {
            c0078c.notifyDataSetChanged();
        }
        this.f476S = true;
    }

    /* JADX INFO: renamed from: d */
    public final void m532d() {
        CheckBox checkBox;
        if (this.f493k.getPurposeConsentLocal(this.f503u.optString("CustomGroupId")) == 1) {
            this.f474Q.setChecked(true);
            checkBox = this.f475R;
        } else {
            this.f475R.setChecked(true);
            checkBox = this.f474Q;
        }
        checkBox.setChecked(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("c");
        try {
            TraceMachine.enterMethod(this._nr_trace, "c#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "c#onCreate", null);
        }
        super.onCreate(bundle);
        this.f489g = getContext();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "c#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "c#onCreateView", null);
        }
        Context context = this.f489g;
        int i = C3896R.layout.ot_pc_groupdetail_tv;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        m520a(viewInflate);
        m527b();
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.tv_sg_card_on) {
            if (z) {
                C0107c c0107c = this.f459B.f378j.f854y;
                m522a(c0107c.f737j, c0107c.f736i);
                this.f460C.setCardElevation(6.0f);
            } else {
                m522a(this.f459B.m498d(), this.f478U);
                this.f460C.setCardElevation(1.0f);
            }
        }
        if (view.getId() == C3896R.id.tv_sg_card_off) {
            if (z) {
                C0107c c0107c2 = this.f459B.f378j.f854y;
                m528b(c0107c2.f737j, c0107c2.f736i);
                this.f461D.setCardElevation(6.0f);
            } else {
                m528b(this.f459B.m498d(), this.f478U);
                this.f461D.setCardElevation(1.0f);
            }
        }
        if (view.getId() == C3896R.id.card_list_of_partners) {
            m524a(z, this.f459B.f378j.f854y, this.f462E, this.f464G, this.f468K);
        }
        if (view.getId() == C3896R.id.card_list_of_sdks) {
            m524a(z, this.f459B.f378j.f854y, this.f463F, this.f465H, this.f469L);
        }
        if (view.getId() == C3896R.id.tv_btn_google_vendor) {
            C0072d.m391b(z, this.f501s, this.f459B.f378j.f854y);
        }
        if (view.getId() == C3896R.id.tv_btn_iab_vendor) {
            C0072d.m391b(z, this.f500r, this.f459B.f378j.f854y);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f459B.m500e()) {
            if (view.getId() == C3896R.id.tv_sg_card_on && C0072d.m382a(i, keyEvent) == 21) {
                boolean z = !this.f472O.isChecked();
                this.f472O.setChecked(z);
                m531c(z);
            } else if (view.getId() == C3896R.id.tv_sg_card_off && C0072d.m382a(i, keyEvent) == 21) {
                this.f473P.setChecked(!r0.isChecked());
            }
        } else if (view.getId() == C3896R.id.tv_sg_card_on && C0072d.m382a(i, keyEvent) == 21) {
            if (!this.f474Q.isChecked()) {
                m531c(true);
                this.f474Q.setChecked(true);
                this.f475R.setChecked(false);
            }
        } else if (view.getId() == C3896R.id.tv_sg_card_off && C0072d.m382a(i, keyEvent) == 21 && !this.f475R.isChecked()) {
            m531c(false);
            this.f474Q.setChecked(false);
            this.f475R.setChecked(true);
        }
        if (view.getId() == C3896R.id.card_list_of_partners && C0072d.m382a(i, keyEvent) == 21) {
            HashMap map = new HashMap();
            if (!this.f503u.optString("Type").equals("IAB2_STACK")) {
                map.put(this.f503u.optString("CustomGroupId"), this.f503u.optString("Type"));
            }
            JSONArray jSONArrayM484g = C0087c.m484g(this.f503u);
            if (jSONArrayM484g != null) {
                for (int i2 = 0; i2 < jSONArrayM484g.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayM484g.optJSONObject(i2);
                    if (jSONObjectOptJSONObject.optBoolean("IsIabPurpose")) {
                        map.put(jSONObjectOptJSONObject.optString("CustomGroupId"), jSONObjectOptJSONObject.optString("Type"));
                    }
                }
            }
            C0093d c0093d = (C0093d) ((ViewOnKeyListenerC0095f) this.f506x).f557c;
            c0093d.f517i = 4;
            c0093d.m542b(1);
            c0093d.m540a((Map<String, String>) map, true, false);
        }
        if (i == 4 && keyEvent.getAction() == 1) {
            ((ViewOnKeyListenerC0095f) this.f506x).m559a(1);
        }
        if (C0072d.m382a(i, keyEvent) == 24 || (view.getId() == C3896R.id.qrcode_img_tv && C0072d.m382a(i, keyEvent) == 24)) {
            ((ViewOnKeyListenerC0095f) this.f506x).m559a(24);
            return true;
        }
        if (view.getId() == C3896R.id.ot_iab_legal_desc_tv && C0072d.m382a(i, keyEvent) == 24) {
            ((ViewOnKeyListenerC0095f) this.f506x).m559a(24);
        }
        if (view.getId() == C3896R.id.tv_category_desc && C0072d.m382a(i, keyEvent) == 24) {
            ((ViewOnKeyListenerC0095f) this.f506x).m559a(24);
        }
        if (view.getId() == C3896R.id.tv_category_title && C0072d.m382a(i, keyEvent) == 24) {
            ((ViewOnKeyListenerC0095f) this.f506x).m559a(24);
        }
        if (view.getId() == C3896R.id.tv_btn_google_vendor && C0072d.m382a(i, keyEvent) == 21) {
            ((ViewOnKeyListenerC0095f) this.f506x).m559a(18);
        }
        if (view.getId() == C3896R.id.tv_btn_iab_vendor && C0072d.m382a(i, keyEvent) == 21) {
            ((ViewOnKeyListenerC0095f) this.f506x).m559a(17);
        }
        if (view.getId() == C3896R.id.card_list_of_sdks && C0072d.m382a(i, keyEvent) == 21) {
            ArrayList arrayList = new ArrayList();
            if (!C0032d.m239a(this.f503u.optJSONArray("FirstPartyCookies"))) {
                arrayList.add(this.f503u.optString("CustomGroupId"));
            }
            JSONArray jSONArrayM484g2 = C0087c.m484g(this.f503u);
            if (jSONArrayM484g2 != null) {
                for (int i3 = 0; i3 < jSONArrayM484g2.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayM484g2.optJSONObject(i3);
                    if (!jSONObjectOptJSONObject2.optBoolean("IsIabPurpose") && jSONObjectOptJSONObject2.optBoolean("ShowSDKListLink")) {
                        arrayList.add(jSONObjectOptJSONObject2.optString("CustomGroupId"));
                    }
                }
            }
            ((ViewOnKeyListenerC0095f) this.f506x).m560a(arrayList);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        r6.f493k.updatePurposeConsent(r0, true);
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m523a(boolean r7) {
        /*
            r6 = this;
            org.json.JSONObject r0 = r6.f503u
            java.lang.String r1 = "CustomGroupId"
            java.lang.String r0 = r0.optString(r1)
            boolean r0 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r0 != 0) goto L95
            org.json.JSONObject r0 = r6.f503u
            java.lang.String r0 = r0.optString(r1)
            r1 = 0
            r6.f476S = r1
            r2 = 1
            if (r7 != 0) goto L20
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r7 = r6.f493k
            r7.updatePurposeConsent(r0, r1)
            goto L7b
        L20:
            a.a.a.a.b.d.b.c r7 = p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c.m482c()     // Catch: org.json.JSONException -> L61
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r3 = r6.f493k     // Catch: org.json.JSONException -> L61
            org.json.JSONObject r7 = r7.f371c     // Catch: org.json.JSONException -> L61
            org.json.JSONArray r4 = r7.names()     // Catch: org.json.JSONException -> L61
            boolean r5 = r4 instanceof org.json.JSONArray     // Catch: org.json.JSONException -> L61
            if (r5 != 0) goto L35
            java.lang.String r4 = r4.toString()     // Catch: org.json.JSONException -> L61
            goto L3c
        L35:
            r5 = r4
            org.json.JSONArray r5 = (org.json.JSONArray) r5     // Catch: org.json.JSONException -> L61
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation.toString(r4)     // Catch: org.json.JSONException -> L61
        L3c:
            boolean r4 = r4.contains(r0)     // Catch: org.json.JSONException -> L61
            if (r4 == 0) goto L7b
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: org.json.JSONException -> L61
            r4 = r1
        L47:
            int r5 = r7.length()     // Catch: org.json.JSONException -> L61
            if (r4 >= r5) goto L5b
            java.lang.String r5 = r7.getString(r4)     // Catch: org.json.JSONException -> L61
            int r5 = r3.getPurposeConsentLocal(r5)     // Catch: org.json.JSONException -> L61
            if (r5 != 0) goto L58
            goto L7b
        L58:
            int r4 = r4 + 1
            goto L47
        L5b:
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r7 = r6.f493k     // Catch: org.json.JSONException -> L61
            r7.updatePurposeConsent(r0, r2)     // Catch: org.json.JSONException -> L61
            goto L7b
        L61:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "error while updating parent category status on TV, err: "
            r3.<init>(r4)
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r7 = r3.append(r7)
            java.lang.String r7 = r7.toString()
            r3 = 6
            java.lang.String r4 = "OneTrust"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r3, r4, r7)
        L7b:
            a.a.a.a.b.d.b.c r7 = r6.f459B
            boolean r7 = r7.m500e()
            if (r7 == 0) goto L92
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r7 = r6.f493k
            int r7 = r7.getPurposeConsentLocal(r0)
            if (r7 != r2) goto L8c
            r1 = r2
        L8c:
            android.widget.CheckBox r7 = r6.f472O
            r7.setChecked(r1)
            goto L95
        L92:
            r6.m532d()
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0092c.m523a(boolean):void");
    }

    /* JADX INFO: renamed from: a */
    public final void m524a(boolean z, C0107c c0107c, CardView cardView, LinearLayout linearLayout, TextView textView) {
        String strM498d;
        if (z) {
            cardView.setElevation(6.0f);
            if (C0048h.m305b(c0107c.f736i) || C0048h.m305b(c0107c.f737j)) {
                return;
            }
            linearLayout.setBackgroundColor(Color.parseColor(c0107c.f736i));
            strM498d = c0107c.f737j;
        } else {
            cardView.setElevation(1.0f);
            linearLayout.setBackgroundColor(Color.parseColor(this.f478U));
            strM498d = this.f459B.m498d();
        }
        textView.setTextColor(Color.parseColor(strM498d));
    }

    /* JADX INFO: renamed from: a */
    public final void m521a(TextView textView, C0106b0 c0106b0) {
        textView.setText(c0106b0.f726e);
        textView.setTextColor(Color.parseColor(this.f459B.m498d()));
        textView.setVisibility(c0106b0.f727f);
    }

    /* JADX INFO: renamed from: a */
    public final void m526a(boolean z, String str, int i) {
        C0003b c0003b = new C0003b(i);
        c0003b.f3b = str;
        c0003b.f4c = z ? 1 : 0;
        C0002a c0002a = this.f505w;
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m525a(boolean z, String str) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z2;
        if (this.f503u.optBoolean("IsIabPurpose")) {
            return;
        }
        Context contextRequireContext = requireContext();
        new JSONObject();
        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(contextRequireContext, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(contextRequireContext, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z2 = true;
        } else {
            sharedPreferencesC0047f = null;
            z2 = false;
        }
        if (z2) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        new C0046e(contextRequireContext);
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f493k;
        String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (!C0048h.m305b(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray(jSONObject.get(str).toString());
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "SdkListHelper", "Error while fetching Sdks by group : " + e.getMessage());
            }
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                oTPublishersHeadlessSDK.updateSDKConsentStatus(jSONArray.get(i).toString(), z);
            } catch (JSONException e2) {
                OTLogger.m2743a(6, "SdkListHelper", "Error while Updating consent of SDK " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m529b(boolean z) {
        if (C0048h.m305b(this.f503u.optString("CustomGroupId"))) {
            return;
        }
        String strOptString = this.f503u.optString("CustomGroupId");
        this.f477T = false;
        if (z) {
            try {
                if (C0087c.m482c().m493a(strOptString, this.f493k)) {
                    this.f493k.updatePurposeLegitInterest(strOptString, true);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while updating parent LI status on TV, err: " + e.getMessage());
            }
        } else {
            this.f493k.updatePurposeLegitInterest(strOptString, false);
        }
        this.f473P.setChecked(this.f493k.getPurposeLegitInterestLocal(strOptString) == 1);
    }
}
