package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0081f;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0084i;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0088d;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.l */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0101l extends Fragment implements C0081f.a, View.OnKeyListener, View.OnFocusChangeListener, TraceFieldInterface {
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public TextView f665a;

    /* JADX INFO: renamed from: b */
    public Context f666b;

    /* JADX INFO: renamed from: c */
    public a f667c;

    /* JADX INFO: renamed from: d */
    public RecyclerView f668d;

    /* JADX INFO: renamed from: e */
    public C0087c f669e;

    /* JADX INFO: renamed from: f */
    public C0088d f670f;

    /* JADX INFO: renamed from: g */
    public Map<String, String> f671g = new HashMap();

    /* JADX INFO: renamed from: h */
    public Button f672h;

    /* JADX INFO: renamed from: i */
    public Button f673i;

    /* JADX INFO: renamed from: j */
    public C0081f f674j;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.l$a */
    public interface a {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("l");
        try {
            TraceMachine.enterMethod(this._nr_trace, "l#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "l#onCreate", null);
        }
        super.onCreate(bundle);
        this.f666b = getActivity();
        this.f669e = C0087c.m482c();
        this.f670f = C0088d.m503b();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "l#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "l#onCreateView", null);
        }
        Context context = this.f666b;
        int i = C3896R.layout.ot_tv_purpose_filter;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        this.f665a = (TextView) viewInflate.findViewById(C3896R.id.ot_tv_filter_title);
        this.f668d = (RecyclerView) viewInflate.findViewById(C3896R.id.ot_tv_filter_list);
        this.f673i = (Button) viewInflate.findViewById(C3896R.id.ot_tv_filter_clear);
        this.f672h = (Button) viewInflate.findViewById(C3896R.id.ot_tv_filter_apply);
        this.f665a.requestFocus();
        this.f672h.setOnKeyListener(this);
        this.f673i.setOnKeyListener(this);
        this.f672h.setOnFocusChangeListener(this);
        this.f673i.setOnFocusChangeListener(this);
        String strM498d = this.f669e.m498d();
        C0072d.m391b(false, this.f672h, this.f669e.f378j.f854y);
        C0072d.m391b(false, this.f673i, this.f669e.f378j.f854y);
        this.f665a.setTextColor(Color.parseColor(strM498d));
        try {
            this.f673i.setText(this.f670f.f387d);
            this.f672h.setText(this.f670f.f386c);
            JSONObject jSONObjectM495b = this.f669e.m495b(this.f666b);
            if (this.f671g == null) {
                this.f671g = new HashMap();
            }
            if (jSONObjectM495b != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectM495b.optJSONArray("Groups");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                        OTLogger.m2743a(3, "UIUtils", "Individual Purpose List: " + jSONObject2.getString("Type") + "  " + jSONObject2.getString("GroupName"));
                        C0074f.m403a(jSONArray, jSONObject, jSONObject2, jSONObject2.getString("Type").contains("IAB2_STACK"));
                        C0074f.m402a(jSONArray, jSONObject2);
                    } catch (JSONException e) {
                        OTLogger.m2743a(6, "UIUtils", "getPurposeList: " + e.getMessage());
                    }
                }
                this.f674j = new C0081f(jSONArray, this.f669e.m498d(), this.f671g, this);
                this.f668d.setLayoutManager(new LinearLayoutManager(this.f666b));
                this.f668d.setAdapter(this.f674j);
            }
        } catch (Exception e2) {
            OTLogger.m2743a(6, "TVVendorListFilter", "error while populating VL fields" + e2.getMessage());
        }
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.ot_tv_filter_clear) {
            C0072d.m391b(z, this.f673i, this.f669e.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_tv_filter_apply) {
            C0072d.m391b(z, this.f672h, this.f669e.f378j.f854y);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (view.getId() == C3896R.id.ot_tv_filter_clear && C0072d.m382a(i, keyEvent) == 21) {
            C0081f c0081f = this.f674j;
            HashMap map = new HashMap();
            c0081f.getClass();
            c0081f.f293d = new HashMap(map);
            this.f674j.notifyDataSetChanged();
            this.f671g = new HashMap();
        }
        if (view.getId() == C3896R.id.ot_tv_filter_apply && C0072d.m382a(i, keyEvent) == 21) {
            a aVar = this.f667c;
            Map<String, String> map2 = this.f671g;
            ViewOnKeyListenerC0102m viewOnKeyListenerC0102m = (ViewOnKeyListenerC0102m) aVar;
            viewOnKeyListenerC0102m.getClass();
            viewOnKeyListenerC0102m.f698n = !map2.isEmpty();
            viewOnKeyListenerC0102m.f697m = map2;
            C0107c c0107c = viewOnKeyListenerC0102m.f691g.f390g;
            if (map2.isEmpty()) {
                viewOnKeyListenerC0102m.f679E.getDrawable().setTint(Color.parseColor(c0107c.f729b));
            } else {
                viewOnKeyListenerC0102m.f679E.getDrawable().setTint(Color.parseColor(c0107c.mo378b()));
            }
            viewOnKeyListenerC0102m.f700p.f329e = !map2.isEmpty();
            C0084i c0084i = viewOnKeyListenerC0102m.f700p;
            c0084i.f330f = map2;
            c0084i.m466b();
            C0084i c0084i2 = viewOnKeyListenerC0102m.f700p;
            c0084i2.f331g = 0;
            c0084i2.notifyDataSetChanged();
            try {
                viewOnKeyListenerC0102m.m610d();
            } catch (JSONException e) {
                OTLogger.m2743a(6, "TVVendorList", "error while setting first vendor detail,err " + e.toString());
            }
        }
        if (i == 4 && keyEvent.getAction() == 1) {
            ((ViewOnKeyListenerC0102m) this.f667c).m597a(23);
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
}
