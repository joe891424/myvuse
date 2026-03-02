package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.R;
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
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jose4j.jwk.RsaJsonWebKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.e */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0094e extends Fragment implements C0078c.a, View.OnKeyListener, View.OnFocusChangeListener, TraceFieldInterface {

    /* JADX INFO: renamed from: A */
    public ImageView f520A;

    /* JADX INFO: renamed from: B */
    public int f521B;

    /* JADX INFO: renamed from: C */
    public CardView f522C;

    /* JADX INFO: renamed from: D */
    public LinearLayout f523D;

    /* JADX INFO: renamed from: E */
    public TextView f524E;

    /* JADX INFO: renamed from: F */
    public CardView f525F;

    /* JADX INFO: renamed from: G */
    public LinearLayout f526G;

    /* JADX INFO: renamed from: H */
    public TextView f527H;

    /* JADX INFO: renamed from: I */
    public String f528I;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public TextView f529a;

    /* JADX INFO: renamed from: b */
    public TextView f530b;

    /* JADX INFO: renamed from: c */
    public TextView f531c;

    /* JADX INFO: renamed from: d */
    public TextView f532d;

    /* JADX INFO: renamed from: e */
    public TextView f533e;

    /* JADX INFO: renamed from: f */
    public RecyclerView f534f;

    /* JADX INFO: renamed from: g */
    public Context f535g;

    /* JADX INFO: renamed from: h */
    public LinearLayout f536h;

    /* JADX INFO: renamed from: i */
    public LinearLayout f537i;

    /* JADX INFO: renamed from: j */
    public TextView f538j;

    /* JADX INFO: renamed from: k */
    public OTPublishersHeadlessSDK f539k;

    /* JADX INFO: renamed from: l */
    public JSONObject f540l;

    /* JADX INFO: renamed from: m */
    public LinearLayout f541m;

    /* JADX INFO: renamed from: n */
    public C0002a f542n;

    /* JADX INFO: renamed from: o */
    public a f543o;

    /* JADX INFO: renamed from: p */
    public boolean f544p;

    /* JADX INFO: renamed from: q */
    public C0078c f545q;

    /* JADX INFO: renamed from: r */
    public View f546r;

    /* JADX INFO: renamed from: s */
    public C0087c f547s;

    /* JADX INFO: renamed from: t */
    public CardView f548t;

    /* JADX INFO: renamed from: u */
    public CardView f549u;

    /* JADX INFO: renamed from: v */
    public TextView f550v;

    /* JADX INFO: renamed from: w */
    public CheckBox f551w;

    /* JADX INFO: renamed from: x */
    public CheckBox f552x;

    /* JADX INFO: renamed from: y */
    public CheckBox f553y;

    /* JADX INFO: renamed from: z */
    public CheckBox f554z;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.e$a */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m545a(CompoundButton compoundButton, boolean z) {
        this.f521B = this.f521B > 1 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m546b(CompoundButton compoundButton, boolean z) {
        String strOptString = this.f540l.optString("CustomGroupId");
        this.f539k.updatePurposeLegitInterest(strOptString, z);
        m551a(z, strOptString, 11);
        if (this.f540l.has("SubGroups") && C0048h.m305b(this.f540l.optString("Parent"))) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f539k;
            JSONObject jSONObject = this.f540l;
            for (int i = 0; i < jSONObject.getJSONArray("SubGroups").length(); i++) {
                try {
                    oTPublishersHeadlessSDK.updatePurposeLegitInterest(jSONObject.getJSONArray("SubGroups").getJSONObject(i).optString("CustomGroupId"), z);
                } catch (Exception e) {
                    OTLogger.m2743a(6, "OneTrust", "error while updating subgroup LI status on TV, err : " + e.getMessage());
                }
            }
        } else if (!this.f540l.has("SubGroups") && !C0048h.m305b(this.f540l.optString("Parent"))) {
            String strOptString2 = this.f540l.optString("Parent");
            if (z) {
                try {
                    if (C0087c.m482c().m493a(strOptString2, this.f539k)) {
                        this.f539k.updatePurposeLegitInterest(strOptString2, true);
                    }
                } catch (JSONException e2) {
                    OTLogger.m2743a(6, "OneTrust", "error while updating parent LI status on TV, err: " + e2.getMessage());
                }
            } else {
                this.f539k.updatePurposeLegitInterest(strOptString2, false);
            }
        }
        C0078c c0078c = this.f545q;
        if (c0078c != null) {
            c0078c.notifyDataSetChanged();
        }
        int i2 = this.f521B;
        int i3 = 2;
        if (i2 != 0 && i2 != 2) {
            i3 = 3;
        }
        this.f521B = i3;
    }

    @Override // p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0078c.a
    /* JADX INFO: renamed from: a */
    public void mo433a() {
    }

    /* JADX INFO: renamed from: a */
    public final void m547a(View view) {
        this.f529a = (TextView) view.findViewById(C3896R.id.tv_category_title);
        this.f530b = (TextView) view.findViewById(C3896R.id.tv_category_desc);
        this.f536h = (LinearLayout) view.findViewById(C3896R.id.group_status_on);
        this.f537i = (LinearLayout) view.findViewById(C3896R.id.group_status_off);
        this.f534f = (RecyclerView) view.findViewById(C3896R.id.tv_subgroup_list);
        this.f531c = (TextView) view.findViewById(C3896R.id.subgroup_list_title);
        this.f546r = view.findViewById(C3896R.id.ot_grp_dtl_sg_div);
        this.f541m = (LinearLayout) view.findViewById(C3896R.id.tv_grp_detail_lyt);
        this.f548t = (CardView) view.findViewById(C3896R.id.tv_sg_card_on);
        this.f549u = (CardView) view.findViewById(C3896R.id.tv_sg_card_off);
        this.f553y = (CheckBox) view.findViewById(C3896R.id.tv_consent_on_sg_cb);
        this.f554z = (CheckBox) view.findViewById(C3896R.id.tv_consent_off_sg_cb);
        this.f532d = (TextView) view.findViewById(C3896R.id.group_status_on_tv);
        this.f533e = (TextView) view.findViewById(C3896R.id.group_status_off_tv);
        this.f538j = (TextView) view.findViewById(C3896R.id.ot_iab_legal_desc_tv);
        this.f550v = (TextView) view.findViewById(C3896R.id.always_active_status_iab);
        this.f551w = (CheckBox) view.findViewById(C3896R.id.tv_consent_cb);
        this.f552x = (CheckBox) view.findViewById(C3896R.id.tv_li_cb);
        this.f520A = (ImageView) view.findViewById(C3896R.id.tv_sub_grp_back);
        this.f534f.setHasFixedSize(true);
        this.f534f.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f548t.setOnKeyListener(this);
        this.f549u.setOnKeyListener(this);
        this.f548t.setOnFocusChangeListener(this);
        this.f549u.setOnFocusChangeListener(this);
        this.f520A.setOnKeyListener(this);
        this.f538j.setOnKeyListener(this);
        this.f520A.setOnFocusChangeListener(this);
        this.f525F = (CardView) view.findViewById(C3896R.id.card_list_of_sdks_sg);
        this.f526G = (LinearLayout) view.findViewById(C3896R.id.list_of_sdks_lyt_sg);
        this.f527H = (TextView) view.findViewById(C3896R.id.list_of_sdks_sg_tv);
        this.f551w.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.d.c.e$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m545a(compoundButton, z);
            }
        });
        this.f552x.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.d.c.e$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m546b(compoundButton, z);
            }
        });
        this.f522C = (CardView) view.findViewById(C3896R.id.card_list_of_partners);
        this.f523D = (LinearLayout) view.findViewById(C3896R.id.list_of_partners_lyt);
        this.f524E = (TextView) view.findViewById(C3896R.id.list_of_partners_tv);
        this.f522C.setOnKeyListener(this);
        this.f522C.setOnFocusChangeListener(this);
        this.f525F.setOnKeyListener(this);
        this.f525F.setOnFocusChangeListener(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m548a(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.f551w, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.f553y, new ColorStateList(iArr, iArr2));
        this.f550v.setTextColor(Color.parseColor(str));
        this.f532d.setTextColor(Color.parseColor(str));
        this.f536h.setBackgroundColor(Color.parseColor(str2));
        C0072d.m385a(this.f532d, str);
    }

    @Override // p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0078c.a
    /* JADX INFO: renamed from: a */
    public void mo434a(JSONObject jSONObject, boolean z) {
        ((ViewOnKeyListenerC0095f) this.f543o).m561a(jSONObject, z);
    }

    /* JADX INFO: renamed from: a */
    public final void m549a(boolean z) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z2;
        String strOptString = this.f540l.optString("CustomGroupId");
        m551a(z, strOptString, 7);
        this.f539k.updatePurposeConsent(strOptString, z);
        if (this.f540l.optBoolean("IsIabPurpose")) {
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
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f539k;
        String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (!C0048h.m305b(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has(strOptString)) {
                    jSONArray = new JSONArray(jSONObject.get(strOptString).toString());
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
    public final void m553b(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.f552x, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.f554z, new ColorStateList(iArr, iArr2));
        this.f533e.setTextColor(Color.parseColor(str));
        this.f537i.setBackgroundColor(Color.parseColor(str2));
        C0072d.m385a(this.f533e, str);
    }

    /* JADX INFO: renamed from: c */
    public void m554c() {
        CardView cardView;
        CardView cardView2 = this.f548t;
        if (cardView2 == null || cardView2.getVisibility() != 0) {
            CardView cardView3 = this.f549u;
            if (cardView3 == null || cardView3.getVisibility() != 0) {
                TextView textView = this.f530b;
                if (textView != null) {
                    textView.requestFocus();
                    return;
                }
                return;
            }
            cardView = this.f549u;
        } else {
            cardView = this.f548t;
        }
        cardView.requestFocus();
    }

    /* JADX INFO: renamed from: d */
    public final void m555d() {
        (this.f539k.getPurposeConsentLocal(this.f540l.optString("CustomGroupId")) == 1 ? this.f553y : this.f554z).setChecked(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing(RsaJsonWebKey.EXPONENT_MEMBER_NAME);
        try {
            TraceMachine.enterMethod(this._nr_trace, "e#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "e#onCreate", null);
        }
        super.onCreate(bundle);
        this.f535g = getContext();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "e#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "e#onCreateView", null);
        }
        Context context = this.f535g;
        int i = C3896R.layout.ot_pc_subgroupdetail_tv;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        m547a(viewInflate);
        m552b();
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.tv_sg_card_on) {
            if (z) {
                C0107c c0107c = this.f547s.f378j.f854y;
                m548a(c0107c.f737j, c0107c.f736i);
                this.f548t.setCardElevation(6.0f);
            } else {
                m548a(this.f547s.m498d(), this.f528I);
                this.f548t.setCardElevation(1.0f);
            }
        }
        if (view.getId() == C3896R.id.tv_sg_card_off) {
            if (z) {
                C0107c c0107c2 = this.f547s.f378j.f854y;
                m553b(c0107c2.f737j, c0107c2.f736i);
                this.f549u.setCardElevation(6.0f);
            } else {
                m553b(this.f547s.m498d(), this.f528I);
                this.f549u.setCardElevation(1.0f);
            }
        }
        if (view.getId() == C3896R.id.card_list_of_partners) {
            m550a(z, this.f547s.f378j.f854y, this.f522C, this.f523D, this.f524E);
        }
        if (view.getId() == C3896R.id.card_list_of_sdks_sg) {
            m550a(z, this.f547s.f378j.f854y, this.f525F, this.f526G, this.f527H);
        }
        if (view.getId() == C3896R.id.tv_sub_grp_back) {
            C0072d.m387a(z, this.f547s.f378j.f854y, this.f520A);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Button button;
        if (this.f547s.m500e()) {
            if (view.getId() == C3896R.id.tv_sg_card_on && C0072d.m382a(i, keyEvent) == 21) {
                boolean z = !this.f551w.isChecked();
                this.f551w.setChecked(z);
                m549a(z);
            } else if (view.getId() == C3896R.id.tv_sg_card_off && C0072d.m382a(i, keyEvent) == 21) {
                this.f552x.setChecked(!r0.isChecked());
            }
        } else if (view.getId() == C3896R.id.tv_sg_card_on && C0072d.m382a(i, keyEvent) == 21) {
            if (!this.f553y.isChecked()) {
                m549a(true);
                this.f553y.setChecked(true);
                this.f554z.setChecked(false);
                this.f521B = 1;
            }
        } else if (view.getId() == C3896R.id.tv_sg_card_off && C0072d.m382a(i, keyEvent) == 21 && !this.f554z.isChecked()) {
            m549a(false);
            this.f553y.setChecked(false);
            this.f554z.setChecked(true);
            this.f521B = 1;
        }
        if (view.getId() == C3896R.id.card_list_of_partners && C0072d.m382a(i, keyEvent) == 21) {
            HashMap map = new HashMap();
            map.put(this.f540l.optString("CustomGroupId"), this.f540l.optString("Type"));
            C0093d c0093d = (C0093d) ((ViewOnKeyListenerC0095f) this.f543o).f557c;
            c0093d.f517i = 4;
            c0093d.m542b(1);
            c0093d.m540a((Map<String, String>) map, true, false);
        }
        if (view.getId() == C3896R.id.tv_sub_grp_back && C0072d.m382a(i, keyEvent) == 21) {
            boolean z2 = this.f539k.getPurposeConsentLocal(this.f540l.optString("CustomGroupId")) == 1;
            boolean z3 = this.f539k.getPurposeLegitInterestLocal(this.f540l.optString("CustomGroupId")) == 1;
            a aVar = this.f543o;
            int i2 = this.f521B;
            ViewOnKeyListenerC0095f viewOnKeyListenerC0095f = (ViewOnKeyListenerC0095f) aVar;
            viewOnKeyListenerC0095f.getChildFragmentManager().popBackStackImmediate();
            ViewOnKeyListenerC0092c viewOnKeyListenerC0092c = viewOnKeyListenerC0095f.f567m;
            if (viewOnKeyListenerC0092c != null) {
                viewOnKeyListenerC0092c.f470M.requestFocus();
                if (i2 == 1) {
                    viewOnKeyListenerC0095f.f567m.m523a(z2);
                } else if (i2 == 2) {
                    viewOnKeyListenerC0095f.f567m.m529b(z3);
                } else if (i2 == 3) {
                    viewOnKeyListenerC0095f.f567m.m523a(z2);
                    viewOnKeyListenerC0095f.f567m.m529b(z3);
                }
            }
        }
        if (view.getId() != C3896R.id.ot_iab_legal_desc_tv || keyEvent.getKeyCode() != 20) {
            if (view.getId() == C3896R.id.card_list_of_sdks_sg && C0072d.m382a(i, keyEvent) == 21) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f540l.optString("CustomGroupId"));
                ((ViewOnKeyListenerC0095f) this.f543o).m560a(arrayList);
            }
            return false;
        }
        ViewOnKeyListenerC0095f viewOnKeyListenerC0095f2 = (ViewOnKeyListenerC0095f) this.f543o;
        if (viewOnKeyListenerC0095f2.f560f.getVisibility() == 0) {
            button = viewOnKeyListenerC0095f2.f560f;
        } else {
            if (viewOnKeyListenerC0095f2.f561g.getVisibility() != 0) {
                if (viewOnKeyListenerC0095f2.f559e.getVisibility() == 0) {
                    button = viewOnKeyListenerC0095f2.f559e;
                }
                return true;
            }
            button = viewOnKeyListenerC0095f2.f561g;
        }
        button.requestFocus();
        return true;
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

    /* JADX INFO: renamed from: b */
    public final void m552b() {
        ImageView imageView;
        int i;
        C0074f c0074f = new C0074f();
        this.f547s = C0087c.m482c();
        C0086b c0086bM475a = C0086b.m475a();
        Context context = this.f535g;
        TextView textView = this.f529a;
        JSONObject jSONObject = this.f540l;
        c0074f.m412a(context, textView, jSONObject.optString(C0048h.m305b(jSONObject.optString("GroupNameOTT")) ? "GroupName" : "GroupNameOTT"));
        this.f532d.setText(c0086bM475a.f347b);
        this.f533e.setText(c0086bM475a.f348c);
        this.f538j.setVisibility(this.f547s.m497d(this.f540l));
        c0074f.m412a(this.f535g, this.f538j, C0087c.m483c(this.f540l));
        this.f524E.setText(this.f547s.f378j.f822E.f755a.f726e);
        this.f520A.setVisibility(0);
        if (C0048h.m305b(C0087c.m481b(this.f540l))) {
            this.f530b.setVisibility(8);
        } else {
            c0074f.m412a(this.f535g, this.f530b, C0087c.m481b(this.f540l));
        }
        C0087c c0087c = this.f547s;
        this.f528I = new C0072d().m392a(c0087c.m494b());
        String strM498d = c0087c.m498d();
        this.f530b.setTextColor(Color.parseColor(strM498d));
        this.f529a.setTextColor(Color.parseColor(strM498d));
        this.f541m.setBackgroundColor(Color.parseColor(c0087c.m494b()));
        this.f546r.setBackgroundColor(Color.parseColor(strM498d));
        this.f531c.setTextColor(Color.parseColor(strM498d));
        this.f538j.setTextColor(Color.parseColor(strM498d));
        m550a(false, c0087c.f378j.f854y, this.f522C, this.f523D, this.f524E);
        m548a(strM498d, this.f528I);
        m553b(strM498d, this.f528I);
        this.f548t.setCardElevation(1.0f);
        this.f549u.setCardElevation(1.0f);
        C0072d.m387a(false, c0087c.f378j.f854y, this.f520A);
        m555d();
        this.f548t.setVisibility(this.f547s.m501f(this.f540l));
        this.f549u.setVisibility(this.f547s.m501f(this.f540l));
        if (this.f540l.optBoolean("IsIabPurpose")) {
            this.f548t.setVisibility(this.f540l.optBoolean("HasConsentOptOut") ? 0 : 8);
            this.f549u.setVisibility(this.f540l.optBoolean("HasLegIntOptOut") ? 0 : 8);
        }
        if (this.f548t.getVisibility() == 0) {
            imageView = this.f520A;
            i = C3896R.id.tv_sg_card_on;
        } else {
            imageView = this.f520A;
            i = C3896R.id.tv_category_desc;
        }
        imageView.setNextFocusDownId(i);
        this.f522C.setVisibility(this.f540l.optBoolean("IsIabPurpose") ? 0 : 8);
        this.f525F.setVisibility(this.f547s.m499e(this.f540l));
        this.f527H.setText(this.f547s.f378j.f823F.f755a.f726e);
        m550a(false, this.f547s.f378j.f854y, this.f525F, this.f526G, this.f527H);
        if (this.f540l.optString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
            if (!this.f540l.optBoolean("isAlertNotice")) {
                this.f548t.setVisibility(0);
            }
            String strM487a = this.f547s.m487a();
            if (this.f547s.m500e()) {
                this.f532d.setText(this.f547s.m488a(!this.f540l.optBoolean("IsIabPurpose")));
                this.f550v.setVisibility(0);
                this.f550v.setText(strM487a);
            } else {
                this.f532d.setText(strM487a);
                m555d();
            }
            this.f553y.setVisibility(8);
            if (C0048h.m305b(strM487a)) {
                this.f548t.setVisibility(8);
            }
        } else if (this.f547s.m500e()) {
            OTLogger.m2743a(3, "TVPCDetail", "Showing Consent Toggle UI");
            this.f553y.setVisibility(8);
            this.f554z.setVisibility(8);
            this.f532d.setText(this.f547s.m488a(!this.f540l.optBoolean("IsIabPurpose")));
            this.f533e.setText(this.f547s.f376h);
            int purposeLegitInterestLocal = this.f539k.getPurposeLegitInterestLocal(this.f540l.optString("CustomGroupId"));
            int iM486a = this.f547s.m486a(purposeLegitInterestLocal);
            this.f549u.setVisibility(iM486a);
            this.f552x.setVisibility(iM486a);
            this.f551w.setVisibility(0);
            if (iM486a == 0) {
                this.f552x.setChecked(purposeLegitInterestLocal == 1);
            }
            this.f551w.setChecked(this.f539k.getPurposeConsentLocal(this.f540l.optString("CustomGroupId")) == 1);
        }
        this.f531c.setVisibility(8);
        this.f546r.setVisibility(this.f522C.getVisibility());
        if (this.f544p || C0087c.m485h(this.f540l)) {
            return;
        }
        C0078c c0078c = new C0078c((JSONArray) Objects.requireNonNull(this.f540l.optJSONArray("SubGroups")), this.f535g, this.f539k, this);
        this.f545q = c0078c;
        this.f534f.setAdapter(c0078c);
        this.f531c.setText(c0086bM475a.f349d);
        this.f531c.setVisibility(0);
        this.f546r.setVisibility(this.f549u.getVisibility());
    }

    /* JADX INFO: renamed from: a */
    public final void m550a(boolean z, C0107c c0107c, CardView cardView, LinearLayout linearLayout, TextView textView) {
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
            linearLayout.setBackgroundColor(Color.parseColor(this.f528I));
            strM498d = this.f547s.m498d();
        }
        textView.setTextColor(Color.parseColor(strM498d));
    }

    /* JADX INFO: renamed from: a */
    public final void m551a(boolean z, String str, int i) {
        C0003b c0003b = new C0003b(i);
        c0003b.f3b = str;
        c0003b.f4c = z ? 1 : 0;
        C0002a c0002a = this.f542n;
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }
}
