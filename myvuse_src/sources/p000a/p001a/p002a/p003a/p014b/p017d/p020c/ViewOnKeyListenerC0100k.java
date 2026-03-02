package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.cardview.widget.CardView;
import androidx.core.widget.CompoundButtonCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import okhttp3.OkHttpClient;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p009f.InterfaceC0037a;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0083h;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0089e;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.k */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0100k extends Fragment implements C0083h.c, View.OnKeyListener, View.OnFocusChangeListener, TraceFieldInterface {

    /* JADX INFO: renamed from: A */
    public ScrollView f635A;

    /* JADX INFO: renamed from: B */
    public String f636B;

    /* JADX INFO: renamed from: C */
    public C0089e f637C;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public TextView f639a;

    /* JADX INFO: renamed from: b */
    public TextView f640b;

    /* JADX INFO: renamed from: c */
    public TextView f641c;

    /* JADX INFO: renamed from: d */
    public TextView f642d;

    /* JADX INFO: renamed from: e */
    public TextView f643e;

    /* JADX INFO: renamed from: f */
    public TextView f644f;

    /* JADX INFO: renamed from: g */
    public TextView f645g;

    /* JADX INFO: renamed from: h */
    public RelativeLayout f646h;

    /* JADX INFO: renamed from: i */
    public CardView f647i;

    /* JADX INFO: renamed from: j */
    public CardView f648j;

    /* JADX INFO: renamed from: k */
    public LinearLayout f649k;

    /* JADX INFO: renamed from: l */
    public LinearLayout f650l;

    /* JADX INFO: renamed from: m */
    public View f651m;

    /* JADX INFO: renamed from: n */
    public RecyclerView f652n;

    /* JADX INFO: renamed from: o */
    public Context f653o;

    /* JADX INFO: renamed from: p */
    public OTPublishersHeadlessSDK f654p;

    /* JADX INFO: renamed from: q */
    public JSONObject f655q;

    /* JADX INFO: renamed from: r */
    public a f656r;

    /* JADX INFO: renamed from: s */
    public C0087c f657s;

    /* JADX INFO: renamed from: t */
    public CheckBox f658t;

    /* JADX INFO: renamed from: u */
    public CheckBox f659u;

    /* JADX INFO: renamed from: v */
    public JSONObject f660v;

    /* JADX INFO: renamed from: w */
    public C0083h f661w;

    /* JADX INFO: renamed from: x */
    public C0002a f662x;

    /* JADX INFO: renamed from: y */
    public boolean f663y = true;

    /* JADX INFO: renamed from: z */
    public boolean f664z = true;

    /* JADX INFO: renamed from: D */
    public int f638D = -1;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.k$a */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m581a() {
        C0083h c0083h = this.f661w;
        if (c0083h != null) {
            c0083h.notifyDataSetChanged();
            this.f638D = 2;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m583a(JSONArray jSONArray, String str, JSONObject jSONObject, boolean z, boolean z2) {
        String strOptString;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    jSONObject.put(str, 1);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (!C0032d.m240a(jSONObjectOptJSONObject)) {
                            if (!z2) {
                                strOptString = jSONObjectOptJSONObject.optString("name");
                            } else if (jSONObjectOptJSONObject instanceof JSONObject) {
                                JSONObject jSONObject2 = jSONObjectOptJSONObject;
                                strOptString = JSONObjectInstrumentation.toString(jSONObjectOptJSONObject);
                            } else {
                                strOptString = jSONObjectOptJSONObject.toString();
                            }
                            jSONObject.put(strOptString, z2 ? z ? 4 : 3 : 2);
                        }
                    }
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "exception thrown while constructing vendor purpose data, err: " + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m584b(CompoundButton compoundButton, boolean z) {
        String strTrim = this.f655q.optString("id").trim();
        this.f654p.updateVendorLegitInterest(strTrim, z);
        if (this.f664z) {
            m588a(z, strTrim, 16);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m586a(View view) {
        CardView cardView;
        this.f639a = (TextView) view.findViewById(C3896R.id.vendor_name_tv);
        this.f640b = (TextView) view.findViewById(C3896R.id.vendors_privacy_notice_tv);
        this.f641c = (TextView) view.findViewById(C3896R.id.lifespan_label_tv);
        this.f642d = (TextView) view.findViewById(C3896R.id.VD_lifespan_value);
        this.f646h = (RelativeLayout) view.findViewById(C3896R.id.vd_linearLyt_tv);
        this.f647i = (CardView) view.findViewById(C3896R.id.tv_vd_card_consent);
        this.f648j = (CardView) view.findViewById(C3896R.id.tv_vd_card_li);
        this.f649k = (LinearLayout) view.findViewById(C3896R.id.vd_consent_lyt);
        this.f650l = (LinearLayout) view.findViewById(C3896R.id.vd_li_lyt);
        this.f643e = (TextView) view.findViewById(C3896R.id.vd_consent_label_tv);
        this.f644f = (TextView) view.findViewById(C3896R.id.vd_li_label_tv);
        this.f645g = (TextView) view.findViewById(C3896R.id.lifespan_desc_tv);
        this.f651m = view.findViewById(C3896R.id.tv_vd_cb_div);
        this.f652n = (RecyclerView) view.findViewById(C3896R.id.vd_purpose_rv);
        this.f658t = (CheckBox) view.findViewById(C3896R.id.tv_vd_consent_cb);
        this.f659u = (CheckBox) view.findViewById(C3896R.id.tv_vd_li_cb);
        this.f635A = (ScrollView) view.findViewById(C3896R.id.bg_main);
        this.f658t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.d.c.k$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m582a(compoundButton, z);
            }
        });
        this.f659u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.d.c.k$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m584b(compoundButton, z);
            }
        });
        this.f647i.setOnKeyListener(this);
        this.f648j.setOnKeyListener(this);
        this.f647i.setOnFocusChangeListener(this);
        this.f648j.setOnFocusChangeListener(this);
        this.f640b.setOnKeyListener(this);
        this.f640b.setOnFocusChangeListener(this);
        this.f645g.setOnFocusChangeListener(this);
        if (this.f648j.getVisibility() == 8 && this.f647i.getVisibility() == 0) {
            cardView = this.f647i;
        } else if (this.f648j.getVisibility() != 0) {
            return;
        } else {
            cardView = this.f648j;
        }
        cardView.setNextFocusDownId(C3896R.id.lifespan_desc_tv);
    }

    /* JADX INFO: renamed from: a */
    public final void m587a(String str, String str2) {
        CompoundButtonCompat.setButtonTintList(this.f658t, new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
        this.f643e.setTextColor(Color.parseColor(str));
        this.f649k.setBackgroundColor(Color.parseColor(str2));
    }

    /* JADX INFO: renamed from: b */
    public void m589b() {
        ((ViewOnKeyListenerC0102m) this.f656r).m597a(24);
    }

    /* JADX INFO: renamed from: b */
    public final void m590b(String str, String str2) {
        CompoundButtonCompat.setButtonTintList(this.f659u, new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
        this.f644f.setTextColor(Color.parseColor(str));
        this.f650l.setBackgroundColor(Color.parseColor(str2));
    }

    /* JADX INFO: renamed from: c */
    public void m591c() {
        CardView cardView;
        C0089e c0089e = this.f637C;
        if (c0089e != null && !C0048h.m305b(c0089e.f406o)) {
            String str = this.f637C.f406o;
            OTLogger.m2743a(3, "TV Vendor", "IAB Vendor Disclosure API called ");
            ((InterfaceC0037a) new Retrofit.Builder().baseUrl("https://geolocation.1trust.app/").addConverterFactory(ScalarsConverterFactory.create()).client(new OkHttpClient.Builder().build()).build().create(InterfaceC0037a.class)).m248a(str).enqueue(new C0099j(this));
        }
        TextView textView = this.f640b;
        if (textView != null && !C0048h.m305b(textView.getText().toString())) {
            this.f640b.requestFocus();
            return;
        }
        CardView cardView2 = this.f647i;
        if (cardView2 == null || cardView2.getVisibility() != 0) {
            CardView cardView3 = this.f648j;
            if (cardView3 == null || cardView3.getVisibility() != 0) {
                return;
            } else {
                cardView = this.f648j;
            }
        } else {
            cardView = this.f647i;
        }
        cardView.requestFocus();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing(OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME);
        try {
            TraceMachine.enterMethod(this._nr_trace, "k#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "k#onCreate", null);
        }
        super.onCreate(bundle);
        this.f653o = getContext();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "k#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "k#onCreateView", null);
        }
        Context context = this.f653o;
        int i = C3896R.layout.ot_vendor_details_tv_fragment;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        this.f660v = new JSONObject();
        this.f637C = C0089e.m509a();
        m586a(viewInflate);
        this.f637C.m510a(this.f655q);
        this.f657s = C0087c.m482c();
        this.f661w = new C0083h(m585a(this.f637C, this.f660v), this);
        this.f652n.setLayoutManager(new LinearLayoutManager(this.f653o));
        this.f652n.setAdapter(this.f661w);
        this.f635A.setSmoothScrollingEnabled(true);
        this.f639a.setText(this.f637C.f394c);
        this.f640b.setText(this.f637C.f396e);
        this.f641c.setText(this.f637C.f397f);
        this.f642d.setText(this.f637C.f398g);
        this.f643e.setText(this.f657s.m488a(false));
        this.f644f.setText(this.f657s.f376h);
        this.f645g.setText(this.f637C.f405n);
        JSONObject jSONObject = this.f655q;
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt(OTVendorUtils.LEGITIMATE_CONSENT_TYPE);
            this.f663y = false;
            this.f664z = false;
            this.f659u.setChecked(iOptInt == 1);
            this.f658t.setChecked(this.f655q.optInt(OTVendorUtils.CONSENT_TYPE) == 1);
            this.f648j.setVisibility(this.f657s.m486a(this.f655q.optInt(OTVendorUtils.LEGITIMATE_CONSENT_TYPE)));
            this.f647i.setVisibility(this.f655q.optInt(OTVendorUtils.CONSENT_TYPE) > -1 ? 0 : 8);
        }
        this.f636B = new C0072d().m392a(this.f657s.m494b());
        String strM498d = this.f657s.m498d();
        this.f639a.setTextColor(Color.parseColor(strM498d));
        this.f640b.setTextColor(Color.parseColor(strM498d));
        this.f645g.setTextColor(Color.parseColor(strM498d));
        this.f641c.setTextColor(Color.parseColor(strM498d));
        this.f642d.setTextColor(Color.parseColor(strM498d));
        this.f646h.setBackgroundColor(Color.parseColor(this.f657s.m494b()));
        this.f651m.setBackgroundColor(Color.parseColor(strM498d));
        this.f647i.setCardElevation(1.0f);
        this.f648j.setCardElevation(1.0f);
        m587a(strM498d, this.f636B);
        m590b(strM498d, this.f636B);
        this.f638D = 0;
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        TextView textView;
        String strM498d;
        if (view.getId() == C3896R.id.tv_vd_card_consent) {
            if (z) {
                C0107c c0107c = this.f657s.f378j.f854y;
                m587a(c0107c.f737j, c0107c.f736i);
                this.f647i.setCardElevation(6.0f);
            } else {
                m587a(this.f657s.m498d(), this.f636B);
                this.f647i.setCardElevation(1.0f);
            }
        }
        if (view.getId() == C3896R.id.tv_vd_card_li) {
            if (z) {
                C0107c c0107c2 = this.f657s.f378j.f854y;
                m590b(c0107c2.f737j, c0107c2.f736i);
                this.f648j.setCardElevation(6.0f);
            } else {
                m590b(this.f657s.m498d(), this.f636B);
                this.f648j.setCardElevation(1.0f);
            }
        }
        if (view.getId() == C3896R.id.vendors_privacy_notice_tv) {
            if (z) {
                this.f640b.setBackgroundColor(Color.parseColor(this.f657s.f378j.f854y.f736i));
                textView = this.f640b;
                strM498d = this.f657s.f378j.f854y.f737j;
            } else {
                this.f640b.setBackgroundColor(Color.parseColor(this.f636B));
                textView = this.f640b;
                strM498d = this.f657s.m498d();
            }
            textView.setTextColor(Color.parseColor(strM498d));
        }
        if (view.getId() == C3896R.id.lifespan_desc_tv && z && this.f638D <= 1) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: a.a.a.a.b.d.c.k$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m581a();
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079 A[RETURN] */
    @Override // android.view.View.OnKeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKey(android.view.View r6, int r7, android.view.KeyEvent r8) {
        /*
            r5 = this;
            int r0 = r6.getId()
            int r1 = com.onetrust.otpublishers.headless.C3896R.id.tv_vd_card_consent
            r2 = 21
            r3 = 1
            if (r0 != r1) goto L1a
            int r0 = p000a.p001a.p002a.p003a.p014b.p016b.C0072d.m382a(r7, r8)
            if (r0 != r2) goto L1a
            r5.f663y = r3
            android.widget.CheckBox r0 = r5.f658t
        L15:
            boolean r1 = r0.isChecked()
            goto L2d
        L1a:
            int r0 = r6.getId()
            int r1 = com.onetrust.otpublishers.headless.C3896R.id.tv_vd_card_li
            if (r0 != r1) goto L31
            int r0 = p000a.p001a.p002a.p003a.p014b.p016b.C0072d.m382a(r7, r8)
            if (r0 != r2) goto L31
            r5.f664z = r3
            android.widget.CheckBox r0 = r5.f659u
            goto L15
        L2d:
            r1 = r1 ^ r3
            r0.setChecked(r1)
        L31:
            int r6 = r6.getId()
            int r0 = com.onetrust.otpublishers.headless.C3896R.id.vendors_privacy_notice_tv
            if (r6 != r0) goto L57
            int r6 = p000a.p001a.p002a.p003a.p014b.p016b.C0072d.m382a(r7, r8)
            if (r6 != r2) goto L57
            a.a.a.a.b.b.d r6 = new a.a.a.a.b.b.d
            r6.<init>()
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            a.a.a.a.b.d.b.e r1 = r5.f637C
            java.lang.String r2 = r1.f395d
            java.lang.String r1 = r1.f396e
            a.a.a.a.b.d.b.c r4 = r5.f657s
            a.a.a.a.b.e.t r4 = r4.f378j
            a.a.a.a.b.e.c r4 = r4.f854y
            r6.m393a(r0, r2, r1, r4)
        L57:
            r6 = 4
            if (r7 != r6) goto L69
            int r6 = r8.getAction()
            if (r6 != r3) goto L69
            a.a.a.a.b.d.c.k$a r6 = r5.f656r
            a.a.a.a.b.d.c.m r6 = (p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0102m) r6
            r0 = 23
            r6.m597a(r0)
        L69:
            int r6 = p000a.p001a.p002a.p003a.p014b.p016b.C0072d.m382a(r7, r8)
            r7 = 24
            if (r6 != r7) goto L79
            a.a.a.a.b.d.c.k$a r6 = r5.f656r
            a.a.a.a.b.d.c.m r6 = (p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0102m) r6
            r6.m597a(r7)
            return r3
        L79:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0100k.onKey(android.view.View, int, android.view.KeyEvent):boolean");
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m582a(CompoundButton compoundButton, boolean z) {
        String strTrim = this.f655q.optString("id").trim();
        this.f654p.updateVendorConsent(strTrim, z);
        if (this.f663y) {
            m588a(z, strTrim, 15);
        }
        ((ViewOnKeyListenerC0102m) this.f656r).getClass();
    }

    /* JADX INFO: renamed from: a */
    public final JSONObject m585a(C0089e c0089e, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = this.f655q;
        if (jSONObject3 != null) {
            m583a(jSONObject3.optJSONArray("purposes"), c0089e.f400i, jSONObject2, false, false);
            m583a(this.f655q.optJSONArray("legIntPurposes"), c0089e.f401j, jSONObject2, false, false);
            m583a(jSONObject.optJSONArray("disclosures"), c0089e.f399h, jSONObject2, false, true);
            m583a(jSONObject.optJSONArray("domains"), c0089e.f412u, jSONObject2, true, true);
            m583a(this.f655q.optJSONArray("specialFeatures"), c0089e.f404m, jSONObject2, false, false);
            m583a(this.f655q.optJSONArray("specialPurposes"), c0089e.f403l, jSONObject2, false, false);
            m583a(this.f655q.optJSONArray("features"), c0089e.f402k, jSONObject2, false, false);
            OTLogger.m2743a(2, "OneTrust", "vendor purposes:" + jSONObject2);
        }
        return jSONObject2;
    }

    /* JADX INFO: renamed from: a */
    public final void m588a(boolean z, String str, int i) {
        C0003b c0003b = new C0003b(i);
        c0003b.f3b = str;
        c0003b.f4c = z ? 1 : 0;
        C0002a c0002a = this.f662x;
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }
}
