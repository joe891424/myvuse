package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0076a;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0084i;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0088d;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0091b;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0100k;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0101l;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0119m;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.m */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0102m extends Fragment implements C0084i.b, View.OnKeyListener, ViewOnKeyListenerC0100k.a, ViewOnKeyListenerC0101l.a, OTVendorUtils.ItemListener, View.OnFocusChangeListener, C0076a.b, ViewOnKeyListenerC0091b.a, TraceFieldInterface {

    /* JADX INFO: renamed from: A */
    public Button f675A;

    /* JADX INFO: renamed from: B */
    public Button f676B;

    /* JADX INFO: renamed from: C */
    public Button f677C;

    /* JADX INFO: renamed from: D */
    public Button f678D;

    /* JADX INFO: renamed from: E */
    public ImageView f679E;

    /* JADX INFO: renamed from: F */
    public ArrayList<String> f680F;

    /* JADX INFO: renamed from: G */
    public String f681G;

    /* JADX INFO: renamed from: I */
    public boolean f683I;

    /* JADX INFO: renamed from: J */
    public OTConfiguration f684J;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public Context f685a;

    /* JADX INFO: renamed from: b */
    public OTPublishersHeadlessSDK f686b;

    /* JADX INFO: renamed from: c */
    public a f687c;

    /* JADX INFO: renamed from: d */
    public C0002a f688d;

    /* JADX INFO: renamed from: e */
    public RecyclerView f689e;

    /* JADX INFO: renamed from: f */
    public C0087c f690f;

    /* JADX INFO: renamed from: g */
    public C0088d f691g;

    /* JADX INFO: renamed from: h */
    public RelativeLayout f692h;

    /* JADX INFO: renamed from: i */
    public LinearLayout f693i;

    /* JADX INFO: renamed from: j */
    public ImageView f694j;

    /* JADX INFO: renamed from: k */
    public ImageView f695k;

    /* JADX INFO: renamed from: l */
    public View f696l;

    /* JADX INFO: renamed from: n */
    public boolean f698n;

    /* JADX INFO: renamed from: o */
    public OTVendorUtils f699o;

    /* JADX INFO: renamed from: p */
    public C0084i f700p;

    /* JADX INFO: renamed from: q */
    public C0076a f701q;

    /* JADX INFO: renamed from: r */
    public View f702r;

    /* JADX INFO: renamed from: s */
    public TextView f703s;

    /* JADX INFO: renamed from: t */
    public ViewOnKeyListenerC0100k f704t;

    /* JADX INFO: renamed from: u */
    public ViewOnKeyListenerC0091b f705u;

    /* JADX INFO: renamed from: v */
    public Button f706v;

    /* JADX INFO: renamed from: w */
    public Button f707w;

    /* JADX INFO: renamed from: x */
    public Button f708x;

    /* JADX INFO: renamed from: y */
    public Button f709y;

    /* JADX INFO: renamed from: z */
    public Button f710z;

    /* JADX INFO: renamed from: m */
    public Map<String, String> f697m = new HashMap();

    /* JADX INFO: renamed from: H */
    public String f682H = OTVendorListMode.IAB;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.m$a */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m592a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f704t.m591c();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m593a(String str, String str2, Button button) {
        if (str == null || str2 == null) {
            return;
        }
        button.getBackground().setTint(Color.parseColor(str));
        button.setTextColor(Color.parseColor(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public /* synthetic */ void m594b(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f705u.m516a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void m595c(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f708x.clearFocus();
            this.f707w.clearFocus();
            this.f706v.clearFocus();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m596a() {
        this.f680F.clear();
        this.f676B.setSelected(false);
        this.f710z.setSelected(false);
        this.f675A.setSelected(false);
        this.f709y.setSelected(false);
        C0107c c0107c = this.f690f.f378j.f854y;
        m593a(c0107c.f729b, c0107c.mo378b(), this.f709y);
        m593a(c0107c.f729b, c0107c.mo378b(), this.f710z);
        m593a(c0107c.f729b, c0107c.mo378b(), this.f675A);
        m593a(c0107c.f729b, c0107c.mo378b(), this.f676B);
    }

    /* JADX INFO: renamed from: a */
    public void m597a(int i) {
        C0076a c0076a;
        C0084i c0084i;
        if (i != 24) {
            getChildFragmentManager().popBackStackImmediate();
            return;
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(this.f682H) && (c0084i = this.f700p) != null) {
            c0084i.notifyDataSetChanged();
        }
        if (!OTVendorListMode.GOOGLE.equalsIgnoreCase(this.f682H) || (c0076a = this.f701q) == null) {
            return;
        }
        c0076a.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: a */
    public final void m599a(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(C3896R.id.ot_vl_detail_container, fragment).addToBackStack(null).commit();
        fragment.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: a.a.a.a.b.d.c.m$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                this.f$0.m595c(lifecycleOwner, event);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final boolean m606a(Button button, String str, String str2) {
        return this.f680F.contains(str) && button.getText().toString().startsWith(str2);
    }

    /* JADX INFO: renamed from: b */
    public void m607b() {
        Button button;
        Button button2;
        if (this.f681G.equals("A_F")) {
            button2 = this.f709y;
        } else {
            if (!this.f681G.equals("G_L")) {
                if (this.f681G.equals("M_R")) {
                    button = this.f675A;
                } else if (!this.f681G.equals("S_Z")) {
                    return;
                } else {
                    button = this.f676B;
                }
                button.requestFocus();
                return;
            }
            button2 = this.f710z;
        }
        button2.requestFocus();
    }

    /* JADX INFO: renamed from: b */
    public final void m608b(boolean z, Button button, C0107c c0107c) {
        if (!z) {
            button.setElevation(0.0f);
            m603a(button.isSelected(), c0107c, button, ExifInterface.GPS_MEASUREMENT_3D);
            return;
        }
        button.setElevation(6.0f);
        if (!C0048h.m305b(c0107c.f731d)) {
            C0072d.m386a(true, c0107c, button);
        } else {
            if (C0048h.m305b(c0107c.f736i) || C0048h.m305b(c0107c.f737j)) {
                return;
            }
            button.getBackground().setTint(Color.parseColor(c0107c.f736i));
            button.setTextColor(Color.parseColor(c0107c.f737j));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m609c() {
        Lifecycle lifecycle;
        LifecycleEventObserver lifecycleEventObserver;
        this.f683I = true;
        if (!OTVendorListMode.IAB.equalsIgnoreCase(this.f682H)) {
            if (OTVendorListMode.GOOGLE.equalsIgnoreCase(this.f682H)) {
                lifecycle = this.f705u.getLifecycle();
                lifecycleEventObserver = new LifecycleEventObserver() { // from class: a.a.a.a.b.d.c.m$$ExternalSyntheticLambda2
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        this.f$0.m594b(lifecycleOwner, event);
                    }
                };
            }
            this.f708x.clearFocus();
            this.f707w.clearFocus();
            this.f706v.clearFocus();
        }
        lifecycle = this.f704t.getLifecycle();
        lifecycleEventObserver = new LifecycleEventObserver() { // from class: a.a.a.a.b.d.c.m$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                this.f$0.m592a(lifecycleOwner, event);
            }
        };
        lifecycle.addObserver(lifecycleEventObserver);
        this.f708x.clearFocus();
        this.f707w.clearFocus();
        this.f706v.clearFocus();
    }

    /* JADX INFO: renamed from: d */
    public final void m610d() {
        JSONObject vendorsByPurpose = this.f698n ? this.f699o.getVendorsByPurpose(this.f697m, this.f686b.getVendorListUI(OTVendorListMode.IAB)) : this.f686b.getVendorListUI(OTVendorListMode.IAB);
        if (vendorsByPurpose == null || vendorsByPurpose.length() <= 0) {
            return;
        }
        m600a(((JSONArray) Objects.requireNonNull(vendorsByPurpose.names())).getString(0));
    }

    /* JADX INFO: renamed from: e */
    public final void m611e() {
        C0076a c0076a = new C0076a(this.f699o, this, this.f686b);
        this.f701q = c0076a;
        c0076a.m425b();
        this.f689e.setAdapter(this.f701q);
        this.f679E.setVisibility(4);
        this.f703s.setText(this.f690f.f380l);
        this.f677C.setSelected(false);
        this.f678D.setSelected(true);
        m608b(false, this.f678D, this.f690f.f378j.f854y);
        JSONObject vendorListUI = this.f686b.getVendorListUI(OTVendorListMode.GOOGLE);
        if (vendorListUI == null || vendorListUI.length() <= 0) {
            return;
        }
        m600a(((JSONArray) Objects.requireNonNull(vendorListUI.names())).getString(0));
    }

    /* JADX INFO: renamed from: f */
    public final void m612f() {
        C0084i c0084i = new C0084i(this.f699o, this, this.f686b, this.f698n, this.f697m);
        this.f700p = c0084i;
        c0084i.m466b();
        this.f689e.setAdapter(this.f700p);
        if (8 == this.f691g.f390g.mo379c()) {
            this.f679E.setVisibility(4);
        } else {
            this.f679E.setVisibility(0);
        }
        this.f703s.setText(this.f690f.f379k);
        this.f677C.setSelected(true);
        this.f678D.setSelected(false);
        m608b(false, this.f677C, this.f690f.f378j.f854y);
        m610d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("m");
        try {
            TraceMachine.enterMethod(this._nr_trace, "m#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "m#onCreate", null);
        }
        super.onCreate(bundle);
        this.f685a = getActivity();
        this.f690f = C0087c.m482c();
        this.f691g = C0088d.m503b();
        this.f680F = new ArrayList<>();
        this.f681G = "A_F";
        TraceMachine.exitMethod();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0272  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateView(android.view.LayoutInflater r13, android.view.ViewGroup r14, android.os.Bundle r15) {
        /*
            Method dump skipped, instruction units count: 908
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0102m.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.tv_btn_vl_confirm) {
            C0072d.m391b(z, this.f706v, this.f690f.f378j.f854y);
        }
        if (view.getId() == C3896R.id.tv_btn_vl_reject) {
            C0072d.m391b(z, this.f708x, this.f690f.f378j.f853x);
        }
        if (view.getId() == C3896R.id.tv_btn_vl_accept) {
            C0072d.m391b(z, this.f707w, this.f690f.f378j.f852w);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_a_f) {
            m604a(z, this.f709y, this.f690f.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_g_l) {
            m604a(z, this.f710z, this.f690f.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_m_r) {
            m604a(z, this.f675A, this.f690f.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_s_z) {
            m604a(z, this.f676B, this.f690f.f378j.f854y);
        }
        if (view.getId() == C3896R.id.tv_google_tab) {
            m608b(z, this.f678D, this.f690f.f378j.f854y);
        }
        if (view.getId() == C3896R.id.tv_iab_tab) {
            m608b(z, this.f677C, this.f690f.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_vl_tv_filter) {
            m605a(z, this.f679E);
        }
        if (view.getId() == C3896R.id.ot_vl_back) {
            C0072d.m387a(z, this.f690f.f378j.f854y, this.f695k);
        }
    }

    @Override // com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils.ItemListener
    public void onItemClick(String str, boolean z) {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        C0076a c0076a;
        ViewOnKeyListenerC0091b viewOnKeyListenerC0091b;
        ViewOnKeyListenerC0100k viewOnKeyListenerC0100k;
        if (view.getId() == C3896R.id.ot_vl_back && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f687c).m538a(23);
        }
        if (view.getId() == C3896R.id.tv_btn_vl_confirm && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f687c).m538a(33);
        }
        if ((view.getId() == C3896R.id.tv_btn_vl_accept || view.getId() == C3896R.id.tv_btn_vl_reject || view.getId() == C3896R.id.tv_btn_vl_confirm) && C0072d.m382a(i, keyEvent) == 25) {
            if (!this.f683I) {
                if (OTVendorListMode.IAB.equalsIgnoreCase(this.f682H)) {
                    this.f700p.notifyDataSetChanged();
                }
                if (!OTVendorListMode.GOOGLE.equalsIgnoreCase(this.f682H) || (c0076a = this.f701q) == null) {
                    return true;
                }
                c0076a.notifyDataSetChanged();
                return true;
            }
            if (OTVendorListMode.IAB.equalsIgnoreCase(this.f682H) && (viewOnKeyListenerC0100k = this.f704t) != null) {
                viewOnKeyListenerC0100k.m591c();
            }
            if (!OTVendorListMode.GOOGLE.equalsIgnoreCase(this.f682H) || (viewOnKeyListenerC0091b = this.f705u) == null) {
                return true;
            }
            viewOnKeyListenerC0091b.m516a();
            return true;
        }
        if (view.getId() == C3896R.id.tv_btn_vl_accept && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f687c).m538a(31);
        }
        if (view.getId() == C3896R.id.tv_btn_vl_reject && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f687c).m538a(32);
        }
        if (view.getId() == C3896R.id.ot_vl_tv_filter && C0072d.m382a(i, keyEvent) == 21) {
            Map<String, String> map = this.f697m;
            ViewOnKeyListenerC0101l viewOnKeyListenerC0101l = new ViewOnKeyListenerC0101l();
            Bundle bundle = new Bundle();
            bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
            viewOnKeyListenerC0101l.setArguments(bundle);
            viewOnKeyListenerC0101l.f667c = this;
            viewOnKeyListenerC0101l.f671g = map;
            getChildFragmentManager().beginTransaction().replace(C3896R.id.ot_vl_detail_container, viewOnKeyListenerC0101l).addToBackStack(null).commit();
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_a_f && C0072d.m382a(i, keyEvent) == 21) {
            m601a("A_F", this.f709y);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_g_l && C0072d.m382a(i, keyEvent) == 21) {
            m601a("G_L", this.f710z);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_m_r && C0072d.m382a(i, keyEvent) == 21) {
            m601a("M_R", this.f675A);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_s_z && C0072d.m382a(i, keyEvent) == 21) {
            m601a("S_Z", this.f676B);
        }
        if (view.getId() == C3896R.id.tv_iab_tab && C0072d.m382a(i, keyEvent) == 21) {
            try {
                this.f682H = OTVendorListMode.IAB;
                m596a();
                m612f();
                m608b(false, this.f678D, this.f690f.f378j.f854y);
                C0107c c0107c = this.f690f.f378j.f854y;
                m602a(c0107c.f729b, c0107c.mo378b());
            } catch (JSONException e) {
                OTLogger.m2743a(6, "TVVendorList", "onKey: error on setIABVendorData , " + e);
            }
        }
        if (view.getId() == C3896R.id.tv_google_tab && C0072d.m382a(i, keyEvent) == 21) {
            try {
                this.f682H = OTVendorListMode.GOOGLE;
                m596a();
                m611e();
                m608b(false, this.f677C, this.f690f.f378j.f854y);
                C0107c c0107c2 = this.f690f.f378j.f854y;
                m602a(c0107c2.f729b, c0107c2.mo378b());
            } catch (JSONException e2) {
                OTLogger.m2743a(6, "TVVendorList", "onKey: error on setGoogleVendorData , " + e2);
            }
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

    /* JADX INFO: renamed from: a */
    public final void m601a(String str, Button button) {
        String str2;
        button.setSelected(!button.isSelected());
        if (!button.isSelected()) {
            this.f680F.remove(str);
            C0107c c0107c = this.f690f.f378j.f854y;
            m598a(button, false, c0107c.f729b, c0107c.mo378b());
            if (this.f680F.isEmpty()) {
                str2 = "A_F";
            } else if (!this.f680F.contains(this.f681G)) {
                ArrayList<String> arrayList = this.f680F;
                str2 = arrayList.get(arrayList.size() - 1);
            }
            this.f681G = str2;
        } else {
            this.f681G = str;
            this.f680F.add(str);
            C0119m c0119m = this.f690f.f378j.f819B;
            m598a(button, true, c0119m.f767e, c0119m.f768f);
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(this.f682H)) {
            C0084i c0084i = this.f700p;
            c0084i.f334j = this.f680F;
            c0084i.m466b();
            C0084i c0084i2 = this.f700p;
            c0084i2.f331g = 0;
            c0084i2.notifyDataSetChanged();
            return;
        }
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(this.f682H)) {
            C0076a c0076a = this.f701q;
            c0076a.f247h = this.f680F;
            c0076a.m425b();
            C0076a c0076a2 = this.f701q;
            c0076a2.f244e = 0;
            c0076a2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m600a(String str) {
        if (C0048h.m305b(str)) {
            return;
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(this.f682H)) {
            if (this.f686b.getVendorDetails(OTVendorListMode.IAB, str) == null) {
                this.f686b.reInitVendorArray();
            }
            C0002a c0002a = this.f688d;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f686b;
            ViewOnKeyListenerC0100k viewOnKeyListenerC0100k = new ViewOnKeyListenerC0100k();
            Bundle bundle = new Bundle();
            bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
            viewOnKeyListenerC0100k.setArguments(bundle);
            viewOnKeyListenerC0100k.f656r = this;
            viewOnKeyListenerC0100k.f654p = oTPublishersHeadlessSDK;
            viewOnKeyListenerC0100k.f655q = oTPublishersHeadlessSDK.getVendorDetails(Integer.parseInt(str));
            viewOnKeyListenerC0100k.f662x = c0002a;
            this.f704t = viewOnKeyListenerC0100k;
            m599a(viewOnKeyListenerC0100k);
            return;
        }
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(this.f682H)) {
            if (this.f686b.getVendorDetails(OTVendorListMode.GOOGLE, str) == null) {
                this.f686b.reInitVendorArray();
            }
            C0002a c0002a2 = this.f688d;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = this.f686b;
            ViewOnKeyListenerC0091b viewOnKeyListenerC0091b = new ViewOnKeyListenerC0091b();
            Bundle bundle2 = new Bundle();
            bundle2.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
            viewOnKeyListenerC0091b.setArguments(bundle2);
            viewOnKeyListenerC0091b.f450k = this;
            viewOnKeyListenerC0091b.f448i = oTPublishersHeadlessSDK2;
            viewOnKeyListenerC0091b.f449j = oTPublishersHeadlessSDK2.getVendorDetails(OTVendorListMode.GOOGLE, str);
            viewOnKeyListenerC0091b.f453n = c0002a2;
            this.f705u = viewOnKeyListenerC0091b;
            m599a(viewOnKeyListenerC0091b);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m602a(String str, String str2) {
        if (C0048h.m305b(this.f690f.f378j.f854y.f731d)) {
            m593a(str, str2, this.f709y);
            m593a(str, str2, this.f710z);
            m593a(str, str2, this.f675A);
            m593a(str, str2, this.f676B);
            m593a(str, str2, this.f677C);
            m593a(str, str2, this.f678D);
            this.f677C.setMinHeight(70);
            this.f677C.setMinimumHeight(70);
            this.f678D.setMinHeight(70);
            this.f678D.setMinimumHeight(70);
            return;
        }
        C0072d.m388a(false, this.f709y, this.f690f, "300", 0, false);
        C0072d.m388a(false, this.f710z, this.f690f, "300", 0, false);
        C0072d.m388a(false, this.f675A, this.f690f, "300", 0, false);
        C0072d.m388a(false, this.f676B, this.f690f, "300", 0, false);
        C0072d.m388a(false, this.f677C, this.f690f, ExifInterface.GPS_MEASUREMENT_3D, 0, false);
        C0072d.m388a(false, this.f678D, this.f690f, ExifInterface.GPS_MEASUREMENT_3D, 0, false);
        this.f677C.setMinHeight(0);
        this.f677C.setMinimumHeight(0);
        this.f678D.setMinHeight(0);
        this.f678D.setMinimumHeight(0);
        this.f677C.setPadding(0, 5, 0, 5);
        this.f678D.setPadding(0, 5, 0, 5);
    }

    /* JADX INFO: renamed from: a */
    public final void m598a(Button button, boolean z, String str, String str2) {
        if (C0048h.m305b(this.f690f.f378j.f854y.f731d)) {
            m593a(str, str2, button);
        } else {
            C0072d.m388a(false, button, this.f690f, "300", 0, z);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m604a(boolean z, Button button, C0107c c0107c) {
        if (z) {
            button.setElevation(6.0f);
            if (!C0048h.m305b(c0107c.f731d)) {
                C0072d.m388a(true, button, this.f690f, "300", 0, false);
                return;
            } else {
                if (C0048h.m305b(c0107c.f736i) || C0048h.m305b(c0107c.f737j)) {
                    return;
                }
                button.getBackground().setTint(Color.parseColor(c0107c.f736i));
                button.setTextColor(Color.parseColor(c0107c.f737j));
                return;
            }
        }
        button.setElevation(0.0f);
        m603a(m606a(button, "A_F", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) || m606a(button, "G_L", "G") || m606a(button, "M_R", "M") || m606a(button, "S_Z", ExifInterface.LATITUDE_SOUTH), c0107c, button, "300");
    }

    /* JADX INFO: renamed from: a */
    public final void m605a(boolean z, ImageView imageView) {
        Drawable drawable;
        String str;
        if (z) {
            drawable = imageView.getDrawable();
            str = this.f691g.f390g.f736i;
        } else {
            Map<String, String> map = this.f697m;
            if (map != null && !map.isEmpty()) {
                imageView.getDrawable().setTint(Color.parseColor(this.f691g.f390g.mo378b()));
                return;
            } else {
                drawable = imageView.getDrawable();
                str = this.f691g.f390g.f729b;
            }
        }
        drawable.setTint(Color.parseColor(str));
    }

    /* JADX INFO: renamed from: a */
    public final void m603a(boolean z, C0107c c0107c, Button button, String str) {
        if (z) {
            if (!C0048h.m305b(c0107c.f731d)) {
                C0072d.m388a(false, button, this.f690f, str, 0, true);
                return;
            } else {
                button.getBackground().setTint(Color.parseColor(this.f690f.f378j.f819B.f767e));
                button.setTextColor(Color.parseColor(this.f690f.f378j.f819B.f768f));
                return;
            }
        }
        if (!C0048h.m305b(c0107c.f731d)) {
            C0072d.m388a(false, button, this.f690f, str, 0, false);
        } else {
            button.getBackground().setTint(Color.parseColor(c0107c.f729b));
            button.setTextColor(Color.parseColor(c0107c.mo378b()));
        }
    }
}
