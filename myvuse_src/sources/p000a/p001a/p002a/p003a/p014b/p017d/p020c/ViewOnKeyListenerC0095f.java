package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerModule;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p009f.C0040d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0077b;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0088d;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0092c;
import p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0094e;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.f */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0095f extends Fragment implements C0077b.a, View.OnKeyListener, View.OnFocusChangeListener, ViewOnKeyListenerC0092c.a, ViewOnKeyListenerC0094e.a, TraceFieldInterface {
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public Context f555a;

    /* JADX INFO: renamed from: b */
    public OTPublishersHeadlessSDK f556b;

    /* JADX INFO: renamed from: c */
    public a f557c;

    /* JADX INFO: renamed from: d */
    public C0002a f558d;

    /* JADX INFO: renamed from: e */
    public Button f559e;

    /* JADX INFO: renamed from: f */
    public Button f560f;

    /* JADX INFO: renamed from: g */
    public Button f561g;

    /* JADX INFO: renamed from: h */
    public RecyclerView f562h;

    /* JADX INFO: renamed from: i */
    public C0087c f563i;

    /* JADX INFO: renamed from: j */
    public RelativeLayout f564j;

    /* JADX INFO: renamed from: k */
    public LinearLayout f565k;

    /* JADX INFO: renamed from: l */
    public ImageView f566l;

    /* JADX INFO: renamed from: m */
    public ViewOnKeyListenerC0092c f567m;

    /* JADX INFO: renamed from: n */
    public ViewOnKeyListenerC0094e f568n;

    /* JADX INFO: renamed from: o */
    public View f569o;

    /* JADX INFO: renamed from: p */
    public C0077b f570p;

    /* JADX INFO: renamed from: q */
    public boolean f571q;

    /* JADX INFO: renamed from: r */
    public OTConfiguration f572r;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.f$a */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m556a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f561g.clearFocus();
            this.f560f.clearFocus();
            this.f559e.clearFocus();
            this.f568n.m554c();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m558a() {
        if (!this.f571q) {
            this.f570p.notifyDataSetChanged();
            return;
        }
        ViewOnKeyListenerC0094e viewOnKeyListenerC0094e = this.f568n;
        if (viewOnKeyListenerC0094e != null) {
            viewOnKeyListenerC0094e.m554c();
        }
        this.f567m.m530c();
    }

    /* JADX INFO: renamed from: a */
    public void m559a(int i) {
        if (i == 24) {
            this.f570p.notifyDataSetChanged();
        }
        if (i == 26) {
            this.f560f.requestFocus();
        }
        if (18 == i) {
            ((C0093d) this.f557c).m538a(18);
        }
        if (17 == i) {
            ((C0093d) this.f557c).m538a(17);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m561a(JSONObject jSONObject, boolean z) {
        C0002a c0002a = this.f558d;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f556b;
        ViewOnKeyListenerC0094e viewOnKeyListenerC0094e = new ViewOnKeyListenerC0094e();
        Bundle bundle = new Bundle();
        bundle.putString("GroupDetails", OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
        viewOnKeyListenerC0094e.setArguments(bundle);
        boolean z2 = viewOnKeyListenerC0094e.f540l != null;
        viewOnKeyListenerC0094e.f540l = jSONObject;
        if (z2) {
            viewOnKeyListenerC0094e.m552b();
        }
        viewOnKeyListenerC0094e.f542n = c0002a;
        viewOnKeyListenerC0094e.f543o = this;
        viewOnKeyListenerC0094e.f544p = z;
        viewOnKeyListenerC0094e.f539k = oTPublishersHeadlessSDK;
        this.f568n = viewOnKeyListenerC0094e;
        getChildFragmentManager().beginTransaction().replace(C3896R.id.ot_pc_detail_container, this.f568n).addToBackStack(null).commit();
        this.f568n.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: a.a.a.a.b.d.c.f$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                this.f$0.m556a(lifecycleOwner, event);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public final void m563b(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            C0002a c0002a = this.f558d;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f556b;
            ViewOnKeyListenerC0092c viewOnKeyListenerC0092c = new ViewOnKeyListenerC0092c();
            Bundle bundle = new Bundle();
            bundle.putString("GroupDetails", "GroupDetails");
            viewOnKeyListenerC0092c.setArguments(bundle);
            boolean z2 = viewOnKeyListenerC0092c.f503u != null;
            viewOnKeyListenerC0092c.f503u = jSONObject;
            if (z2) {
                viewOnKeyListenerC0092c.m527b();
            }
            viewOnKeyListenerC0092c.f505w = c0002a;
            viewOnKeyListenerC0092c.f506x = this;
            viewOnKeyListenerC0092c.f507y = z;
            viewOnKeyListenerC0092c.f493k = oTPublishersHeadlessSDK;
            this.f567m = viewOnKeyListenerC0092c;
            getChildFragmentManager().beginTransaction().replace(C3896R.id.ot_pc_detail_container, this.f567m).addToBackStack(null).commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("f");
        try {
            TraceMachine.enterMethod(this._nr_trace, "f#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "f#onCreate", null);
        }
        super.onCreate(bundle);
        this.f555a = getActivity();
        this.f563i = C0087c.m482c();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        StringBuilder sb;
        String message;
        try {
            TraceMachine.enterMethod(this._nr_trace, "f#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "f#onCreateView", null);
        }
        Context context = this.f555a;
        int i = C3896R.layout.ot_pc_tvfragment;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C3896R.id.tv_grp_list);
        this.f562h = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f562h.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f559e = (Button) viewInflate.findViewById(C3896R.id.tv_btn_confirm);
        this.f560f = (Button) viewInflate.findViewById(C3896R.id.tv_btn_accept_pc);
        this.f561g = (Button) viewInflate.findViewById(C3896R.id.tv_btn_reject_pc);
        this.f564j = (RelativeLayout) viewInflate.findViewById(C3896R.id.tv_pc_lyt);
        this.f565k = (LinearLayout) viewInflate.findViewById(C3896R.id.tv_btn_layout);
        this.f566l = (ImageView) viewInflate.findViewById(C3896R.id.ot_tv_pc_logo);
        this.f569o = viewInflate.findViewById(C3896R.id.ot_pc_list_div_tv);
        this.f559e.setOnKeyListener(this);
        this.f560f.setOnKeyListener(this);
        this.f561g.setOnKeyListener(this);
        this.f559e.setOnFocusChangeListener(this);
        this.f560f.setOnFocusChangeListener(this);
        this.f561g.setOnFocusChangeListener(this);
        try {
            JSONObject jSONObjectM495b = this.f563i.m495b(this.f555a);
            this.f564j.setBackgroundColor(Color.parseColor(this.f563i.m494b()));
            this.f565k.setBackgroundColor(Color.parseColor(this.f563i.m494b()));
            this.f569o.setBackgroundColor(Color.parseColor(this.f563i.m498d()));
            this.f562h.setBackgroundColor(Color.parseColor(this.f563i.f378j.f819B.f763a));
            C0072d.m384a(this.f563i.f378j.f854y, this.f559e);
            C0072d.m384a(this.f563i.f378j.f852w, this.f560f);
            C0072d.m384a(this.f563i.f378j.f853x, this.f561g);
            m562b();
            if (jSONObjectM495b != null) {
                JSONArray jSONArrayM557a = m557a(jSONObjectM495b.getJSONArray("Groups"));
                int i2 = (getArguments() == null || !getArguments().containsKey("OT_FOCUSED_PC_LIST_ITEM")) ? 0 : getArguments().getInt("OT_FOCUSED_PC_LIST_ITEM");
                C0077b c0077b = new C0077b(this.f555a, jSONArrayM557a, this);
                this.f570p = c0077b;
                c0077b.f253d = i2;
                this.f562h.setAdapter(c0077b);
                m563b(jSONArrayM557a.getJSONObject(0), false);
            }
        } catch (IndexOutOfBoundsException e) {
            sb = new StringBuilder("error while populating PC list");
            message = e.getMessage();
            OTLogger.m2743a(6, "TVPreferenceCenter", sb.append(message).toString());
        } catch (JSONException e2) {
            sb = new StringBuilder("JSON error while populating PC fields");
            message = e2.getMessage();
            OTLogger.m2743a(6, "TVPreferenceCenter", sb.append(message).toString());
        }
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.tv_btn_confirm) {
            C0072d.m391b(z, this.f559e, this.f563i.f378j.f854y);
        }
        if (view.getId() == C3896R.id.tv_btn_reject_pc) {
            C0072d.m391b(z, this.f561g, this.f563i.f378j.f853x);
        }
        if (view.getId() == C3896R.id.tv_btn_accept_pc) {
            C0072d.m391b(z, this.f560f, this.f563i.f378j.f852w);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (view.getId() == C3896R.id.tv_btn_confirm && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f557c).m538a(14);
        }
        if (view.getId() == C3896R.id.tv_btn_confirm && C0072d.m382a(i, keyEvent) == 25) {
            m558a();
            return true;
        }
        if (view.getId() == C3896R.id.tv_btn_accept_pc && C0072d.m382a(i, keyEvent) == 25) {
            m558a();
            return true;
        }
        if (view.getId() == C3896R.id.tv_btn_reject_pc && C0072d.m382a(i, keyEvent) == 25) {
            m558a();
            return true;
        }
        if (view.getId() == C3896R.id.tv_btn_accept_pc && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f557c).m538a(21);
        }
        if (view.getId() == C3896R.id.tv_btn_reject_pc && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f557c).m538a(22);
        }
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        ((C0093d) this.f557c).m538a(23);
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
    public void m560a(List<String> list) {
        C0093d c0093d = (C0093d) this.f557c;
        c0093d.f517i = 6;
        c0093d.m542b(1);
        c0093d.f516h.m411a(new C0003b(25), c0093d.f514f);
        C0002a c0002a = c0093d.f514f;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = c0093d.f513e;
        OTConfiguration oTConfiguration = c0093d.f519k;
        ViewOnKeyListenerC0098i viewOnKeyListenerC0098i = new ViewOnKeyListenerC0098i();
        Bundle bundle = new Bundle();
        bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
        viewOnKeyListenerC0098i.setArguments(bundle);
        viewOnKeyListenerC0098i.f609b = c0093d;
        viewOnKeyListenerC0098i.f618k = list;
        viewOnKeyListenerC0098i.f633z = oTPublishersHeadlessSDK;
        viewOnKeyListenerC0098i.f605A = c0002a;
        viewOnKeyListenerC0098i.f607C = oTConfiguration;
        c0093d.getChildFragmentManager().beginTransaction().replace(C3896R.id.tv_main_lyt, viewOnKeyListenerC0098i).addToBackStack(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG).commit();
    }

    /* JADX INFO: renamed from: b */
    public final void m562b() {
        if (this.f563i.f378j.f818A.m651b()) {
            if (new C0045d(this.f555a, "OTT_DEFAULT_USER").m271a().getBoolean("OTT_LOAD_OFFLINE_DATA", false)) {
                OTConfiguration oTConfiguration = this.f572r;
                if (oTConfiguration == null || oTConfiguration.getPcLogo() == null) {
                    return;
                }
            } else {
                if (!new C0045d(this.f555a, "OTT_DEFAULT_USER").m271a().getBoolean("OTT_OFFLINE_DATA_SET_FLAG", false) || new C0040d().m261a(this.f555a)) {
                    Glide.with(this).load(this.f563i.f378j.f818A.m650a()).fitCenter().timeout(AndroidLocationEnablerModule.DEFAULT_INTERVAL_DURATION).fallback(C3896R.drawable.ic_ot).into(this.f566l);
                    return;
                }
                OTConfiguration oTConfiguration2 = this.f572r;
                if (oTConfiguration2 == null || oTConfiguration2.getPcLogo() == null) {
                    return;
                }
            }
            this.f566l.setImageDrawable(this.f572r.getPcLogo());
        }
    }

    /* JADX INFO: renamed from: a */
    public final JSONArray m557a(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray != null) {
            try {
                String str = this.f563i.f378j.f840k.f726e;
                if (str == null) {
                    str = "";
                }
                jSONObject.put("GroupName", str);
                String str2 = this.f563i.f378j.f841l.f726e;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("GroupDescription", str2);
                jSONObject.put("isAlertNotice", true);
                jSONArray2.put(jSONObject);
                if (this.f563i.f373e) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("GroupName", C0088d.m503b().m508d());
                    jSONObject2.put("GroupDescription", "");
                    jSONObject2.put("IS_PARTNERS_LINK", true);
                    jSONArray2.put(jSONObject2);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    jSONArray2.put(jSONArray.getJSONObject(i));
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "Exception while setting alert notice text, err : " + e.toString());
                return jSONArray;
            }
        }
        return jSONArray2;
    }
}
