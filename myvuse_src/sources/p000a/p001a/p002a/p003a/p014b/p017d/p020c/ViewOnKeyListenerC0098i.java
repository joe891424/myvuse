package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.facebook.common.callercontext.ContextChain;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0080e;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0088d;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0096g;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0097h;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0119m;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.i */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0098i extends Fragment implements C0080e.b, View.OnKeyListener, ViewOnKeyListenerC0096g.a, ViewOnKeyListenerC0097h.a, View.OnFocusChangeListener, TraceFieldInterface {

    /* JADX INFO: renamed from: A */
    public C0002a f605A;

    /* JADX INFO: renamed from: B */
    public boolean f606B;

    /* JADX INFO: renamed from: C */
    public OTConfiguration f607C;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public Context f608a;

    /* JADX INFO: renamed from: b */
    public a f609b;

    /* JADX INFO: renamed from: c */
    public RecyclerView f610c;

    /* JADX INFO: renamed from: d */
    public C0087c f611d;

    /* JADX INFO: renamed from: e */
    public C0088d f612e;

    /* JADX INFO: renamed from: f */
    public RelativeLayout f613f;

    /* JADX INFO: renamed from: g */
    public LinearLayout f614g;

    /* JADX INFO: renamed from: h */
    public ImageView f615h;

    /* JADX INFO: renamed from: i */
    public ImageView f616i;

    /* JADX INFO: renamed from: j */
    public View f617j;

    /* JADX INFO: renamed from: k */
    public List<String> f618k = new ArrayList();

    /* JADX INFO: renamed from: l */
    public C0080e f619l;

    /* JADX INFO: renamed from: m */
    public View f620m;

    /* JADX INFO: renamed from: n */
    public TextView f621n;

    /* JADX INFO: renamed from: o */
    public ViewOnKeyListenerC0096g f622o;

    /* JADX INFO: renamed from: p */
    public Button f623p;

    /* JADX INFO: renamed from: q */
    public Button f624q;

    /* JADX INFO: renamed from: r */
    public Button f625r;

    /* JADX INFO: renamed from: s */
    public Button f626s;

    /* JADX INFO: renamed from: t */
    public Button f627t;

    /* JADX INFO: renamed from: u */
    public Button f628u;

    /* JADX INFO: renamed from: v */
    public Button f629v;

    /* JADX INFO: renamed from: w */
    public ImageView f630w;

    /* JADX INFO: renamed from: x */
    public ArrayList<String> f631x;

    /* JADX INFO: renamed from: y */
    public String f632y;

    /* JADX INFO: renamed from: z */
    public OTPublishersHeadlessSDK f633z;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.i$a */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m568a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f625r.clearFocus();
            this.f624q.clearFocus();
            this.f623p.clearFocus();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m569a(String str, String str2, Button button) {
        if (str == null || str2 == null) {
            return;
        }
        button.getBackground().setTint(Color.parseColor(str));
        button.setTextColor(Color.parseColor(str2));
    }

    /* JADX INFO: renamed from: a */
    public void m571a(int i) {
        if (i != 24) {
            getChildFragmentManager().popBackStackImmediate();
            return;
        }
        C0080e c0080e = this.f619l;
        if (c0080e != null) {
            c0080e.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m573a(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(C3896R.id.ot_sdk_detail_container, fragment).addToBackStack(null).commit();
        fragment.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: a.a.a.a.b.d.c.i$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                this.f$0.m568a(lifecycleOwner, event);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m574a(String str, Button button) {
        String str2;
        button.setSelected(!button.isSelected());
        if (button.isSelected()) {
            this.f632y = str;
            this.f631x.add(str);
            C0119m c0119m = this.f611d.f378j.f819B;
            m572a(button, true, c0119m.f767e, c0119m.f768f);
        } else {
            this.f631x.remove(str);
            C0119m c0119m2 = this.f611d.f378j.f819B;
            m572a(button, false, c0119m2.f767e, c0119m2.f768f);
            if (this.f631x.size() == 0) {
                str2 = "A_F";
            } else if (!this.f631x.contains(this.f632y)) {
                ArrayList<String> arrayList = this.f631x;
                str2 = arrayList.get(arrayList.size() - 1);
            }
            this.f632y = str2;
        }
        C0080e c0080e = this.f619l;
        c0080e.f286g = this.f631x;
        List<JSONObject> listM442a = c0080e.m442a();
        C0080e c0080e2 = this.f619l;
        c0080e2.f284e = 0;
        c0080e2.notifyDataSetChanged();
        m575a(listM442a);
    }

    /* JADX INFO: renamed from: a */
    public final void m575a(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m576a(list.get(0));
    }

    /* JADX INFO: renamed from: a */
    public final boolean m579a(Button button, String str, String str2) {
        return this.f631x.contains(str) && button.getText().toString().startsWith(str2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing(ContextChain.TAG_INFRA);
        try {
            TraceMachine.enterMethod(this._nr_trace, "i#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "i#onCreate", null);
        }
        super.onCreate(bundle);
        this.f608a = getActivity();
        this.f611d = C0087c.m482c();
        this.f612e = C0088d.m503b();
        this.f631x = new ArrayList<>();
        this.f632y = "A_F";
        TraceMachine.exitMethod();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x02a7  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateView(android.view.LayoutInflater r23, android.view.ViewGroup r24, android.os.Bundle r25) {
        /*
            Method dump skipped, instruction units count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0098i.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.tv_btn_sdk_confirm) {
            C0072d.m391b(z, this.f623p, this.f611d.f378j.f854y);
        }
        if (view.getId() == C3896R.id.tv_btn_sdk_reject) {
            C0072d.m391b(z, this.f625r, this.f611d.f378j.f853x);
        }
        if (view.getId() == C3896R.id.tv_btn_sdk_accept) {
            C0072d.m391b(z, this.f624q, this.f611d.f378j.f852w);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_a_f_sdk) {
            m577a(z, this.f626s, this.f611d.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_g_l_sdk) {
            m577a(z, this.f627t, this.f611d.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_m_r_sdk) {
            m577a(z, this.f628u, this.f611d.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_s_z_sdk) {
            m577a(z, this.f629v, this.f611d.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_sdk_tv_filter) {
            m578a(z, this.f630w);
        }
        if (view.getId() == C3896R.id.ot_sdk_back_tv) {
            C0072d.m387a(z, this.f611d.f378j.f854y, this.f616i);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (view.getId() == C3896R.id.ot_sdk_back_tv && C0072d.m382a(i, keyEvent) == 21) {
            m570a();
            ((C0093d) this.f609b).m538a(23);
        }
        if (view.getId() == C3896R.id.tv_btn_sdk_confirm && C0072d.m382a(i, keyEvent) == 21) {
            m570a();
            ((C0093d) this.f609b).m538a(43);
        }
        if ((view.getId() == C3896R.id.tv_btn_sdk_accept || view.getId() == C3896R.id.tv_btn_sdk_reject || view.getId() == C3896R.id.tv_btn_sdk_confirm) && C0072d.m382a(i, keyEvent) == 25) {
            if (this.f606B) {
                this.f622o.m564a();
                return true;
            }
            this.f619l.notifyDataSetChanged();
            return true;
        }
        if (view.getId() == C3896R.id.tv_btn_sdk_accept && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f609b).m538a(41);
        }
        if (view.getId() == C3896R.id.tv_btn_sdk_reject && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f609b).m538a(42);
        }
        if (view.getId() == C3896R.id.ot_sdk_tv_filter && C0072d.m382a(i, keyEvent) == 21) {
            List<String> list = this.f618k;
            ViewOnKeyListenerC0097h viewOnKeyListenerC0097h = new ViewOnKeyListenerC0097h();
            Bundle bundle = new Bundle();
            bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
            viewOnKeyListenerC0097h.setArguments(bundle);
            viewOnKeyListenerC0097h.f601g = list;
            viewOnKeyListenerC0097h.f597c = this;
            getChildFragmentManager().beginTransaction().replace(C3896R.id.ot_sdk_detail_container, viewOnKeyListenerC0097h).addToBackStack(null).commit();
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_a_f_sdk && C0072d.m382a(i, keyEvent) == 21) {
            m574a("A_F", this.f626s);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_g_l_sdk && C0072d.m382a(i, keyEvent) == 21) {
            m574a("G_L", this.f627t);
        }
        if (view.getId() == C3896R.id.ot_tv_alphabet_m_r_sdk && C0072d.m382a(i, keyEvent) == 21) {
            m574a("M_R", this.f628u);
        }
        if (view.getId() != C3896R.id.ot_tv_alphabet_s_z_sdk || C0072d.m382a(i, keyEvent) != 21) {
            return false;
        }
        m574a("S_Z", this.f629v);
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
    public final void m576a(JSONObject jSONObject) {
        C0002a c0002a = this.f605A;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f633z;
        ViewOnKeyListenerC0096g viewOnKeyListenerC0096g = new ViewOnKeyListenerC0096g();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_DETAIL_FRAGMENT);
        viewOnKeyListenerC0096g.setArguments(bundle);
        viewOnKeyListenerC0096g.f588p = this;
        viewOnKeyListenerC0096g.f584l = jSONObject;
        viewOnKeyListenerC0096g.f593u = c0002a;
        viewOnKeyListenerC0096g.f594v = oTPublishersHeadlessSDK;
        this.f622o = viewOnKeyListenerC0096g;
        m573a(viewOnKeyListenerC0096g);
    }

    /* JADX INFO: renamed from: a */
    public final void m572a(Button button, boolean z, String str, String str2) {
        if (C0048h.m305b(this.f611d.f378j.f854y.f731d)) {
            m569a(str, str2, button);
        } else {
            C0072d.m388a(false, button, this.f611d, "300", 0, z);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m577a(boolean z, Button button, C0107c c0107c) {
        if (z) {
            button.setElevation(6.0f);
            if (!C0048h.m305b(c0107c.f731d)) {
                C0072d.m388a(true, button, this.f611d, "300", 0, false);
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
        if (m579a(button, "A_F", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) || m579a(button, "G_L", "G") || m579a(button, "M_R", "M") || m579a(button, "S_Z", ExifInterface.LATITUDE_SOUTH)) {
            if (!C0048h.m305b(c0107c.f731d)) {
                C0072d.m388a(false, button, this.f611d, "300", 0, true);
                return;
            } else {
                button.getBackground().setTint(Color.parseColor(this.f611d.f378j.f819B.f767e));
                button.setTextColor(Color.parseColor(this.f611d.f378j.f819B.f768f));
                return;
            }
        }
        if (!C0048h.m305b(c0107c.f731d)) {
            C0072d.m388a(false, button, this.f611d, "300", 0, false);
        } else {
            button.getBackground().setTint(Color.parseColor(c0107c.f729b));
            button.setTextColor(Color.parseColor(c0107c.mo378b()));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m578a(boolean z, ImageView imageView) {
        Drawable drawable;
        String str;
        if (z) {
            drawable = imageView.getDrawable();
            str = this.f612e.f390g.f736i;
        } else {
            List<String> list = this.f618k;
            if (list != null && !list.isEmpty()) {
                imageView.getDrawable().setTint(Color.parseColor(this.f612e.f390g.mo378b()));
                return;
            } else {
                drawable = imageView.getDrawable();
                str = this.f612e.f390g.f729b;
            }
        }
        drawable.setTint(Color.parseColor(str));
    }

    /* JADX INFO: renamed from: a */
    public final void m570a() {
        List<String> list;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        List<String> list2 = this.f618k;
        if (list2 == null || list2.isEmpty()) {
            JSONArray jSONArrayM504a = C0088d.m503b().m504a();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayM504a.length(); i++) {
                try {
                    arrayList.add(jSONArrayM504a.getJSONObject(i).optString("CustomGroupId", ""));
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "TVDataUtils", "addCategoriesToMapForClearFilter: " + e);
                }
            }
            list = arrayList;
        } else {
            list = this.f618k;
        }
        Context contextRequireContext = requireContext();
        new JSONObject();
        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(contextRequireContext, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(contextRequireContext, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
            z = false;
        }
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        new C0046e(contextRequireContext);
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f633z;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
            JSONArray jSONArray = new JSONArray();
            if (!C0048h.m305b(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.has(str)) {
                        jSONArray = new JSONArray(jSONObject.get(str).toString());
                    }
                } catch (JSONException e2) {
                    OTLogger.m2743a(6, "SdkListHelper", "Error while fetching Sdks by group : " + e2.getMessage());
                }
            }
            int purposeConsentLocal = oTPublishersHeadlessSDK.getPurposeConsentLocal(str);
            int length = jSONArray.length();
            if (length == 1) {
                int consentStatusForSDKId = oTPublishersHeadlessSDK.getConsentStatusForSDKId(jSONArray.optString(0));
                if (purposeConsentLocal != consentStatusForSDKId) {
                    oTPublishersHeadlessSDK.updatePurposeConsent(str, consentStatusForSDKId == 1, true);
                }
            } else {
                for (int i2 = 1; i2 < length; i2++) {
                    int consentStatusForSDKId2 = oTPublishersHeadlessSDK.getConsentStatusForSDKId(jSONArray.optString(i2 - 1));
                    int consentStatusForSDKId3 = oTPublishersHeadlessSDK.getConsentStatusForSDKId(jSONArray.optString(i2));
                    if (consentStatusForSDKId2 != consentStatusForSDKId3) {
                        break;
                    }
                    if (i2 == length - 1) {
                        oTPublishersHeadlessSDK.updatePurposeConsent(str, consentStatusForSDKId3 == 1, true);
                    }
                }
            }
        }
    }
}
