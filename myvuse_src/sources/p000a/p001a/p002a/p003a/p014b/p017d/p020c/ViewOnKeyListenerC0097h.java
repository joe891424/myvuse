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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0079d;
import p000a.p001a.p002a.p003a.p014b.p017d.p018a.C0080e;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0088d;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.h */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0097h extends Fragment implements C0079d.a, View.OnKeyListener, View.OnFocusChangeListener, TraceFieldInterface {
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public TextView f595a;

    /* JADX INFO: renamed from: b */
    public Context f596b;

    /* JADX INFO: renamed from: c */
    public a f597c;

    /* JADX INFO: renamed from: d */
    public RecyclerView f598d;

    /* JADX INFO: renamed from: e */
    public C0087c f599e;

    /* JADX INFO: renamed from: f */
    public C0088d f600f;

    /* JADX INFO: renamed from: g */
    public List<String> f601g = new ArrayList();

    /* JADX INFO: renamed from: h */
    public Button f602h;

    /* JADX INFO: renamed from: i */
    public Button f603i;

    /* JADX INFO: renamed from: j */
    public C0079d f604j;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.h$a */
    public interface a {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("h");
        try {
            TraceMachine.enterMethod(this._nr_trace, "h#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "h#onCreate", null);
        }
        super.onCreate(bundle);
        this.f596b = getActivity();
        this.f599e = C0087c.m482c();
        this.f600f = C0088d.m503b();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "h#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "h#onCreateView", null);
        }
        Context context = this.f596b;
        int i = C3896R.layout.ot_tv_purpose_filter;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        this.f595a = (TextView) viewInflate.findViewById(C3896R.id.ot_tv_filter_title);
        this.f598d = (RecyclerView) viewInflate.findViewById(C3896R.id.ot_tv_filter_list);
        this.f603i = (Button) viewInflate.findViewById(C3896R.id.ot_tv_filter_clear);
        this.f602h = (Button) viewInflate.findViewById(C3896R.id.ot_tv_filter_apply);
        this.f595a.requestFocus();
        this.f602h.setOnKeyListener(this);
        this.f603i.setOnKeyListener(this);
        this.f602h.setOnFocusChangeListener(this);
        this.f603i.setOnFocusChangeListener(this);
        String strM498d = this.f599e.m498d();
        C0072d.m391b(false, this.f602h, this.f599e.f378j.f854y);
        C0072d.m391b(false, this.f603i, this.f599e.f378j.f854y);
        this.f595a.setText("Filter SDK List");
        this.f595a.setTextColor(Color.parseColor(strM498d));
        try {
            this.f603i.setText(this.f600f.f387d);
            this.f602h.setText(this.f600f.f386c);
            if (this.f601g == null) {
                this.f601g = new ArrayList();
            }
            this.f604j = new C0079d(this.f600f.m504a(), this.f599e.m498d(), this.f601g, this);
            this.f598d.setLayoutManager(new LinearLayoutManager(this.f596b));
            this.f598d.setAdapter(this.f604j);
        } catch (Exception e) {
            OTLogger.m2743a(6, "TVVendorListFilter", "error while populating SDK List fields" + e.getMessage());
        }
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.ot_tv_filter_clear) {
            C0072d.m391b(z, this.f603i, this.f599e.f378j.f854y);
        }
        if (view.getId() == C3896R.id.ot_tv_filter_apply) {
            C0072d.m391b(z, this.f602h, this.f599e.f378j.f854y);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (view.getId() == C3896R.id.ot_tv_filter_clear && C0072d.m382a(i, keyEvent) == 21) {
            this.f604j.f271d = new ArrayList();
            this.f604j.notifyDataSetChanged();
            this.f601g = new ArrayList();
        }
        if (view.getId() == C3896R.id.ot_tv_filter_apply && C0072d.m382a(i, keyEvent) == 21) {
            a aVar = this.f597c;
            List<String> list = this.f601g;
            ViewOnKeyListenerC0098i viewOnKeyListenerC0098i = (ViewOnKeyListenerC0098i) aVar;
            viewOnKeyListenerC0098i.f618k = list;
            C0107c c0107c = viewOnKeyListenerC0098i.f612e.f390g;
            if (list.isEmpty()) {
                viewOnKeyListenerC0098i.f630w.getDrawable().setTint(Color.parseColor(c0107c.f729b));
            } else {
                viewOnKeyListenerC0098i.f630w.getDrawable().setTint(Color.parseColor(c0107c.mo378b()));
            }
            C0080e c0080e = viewOnKeyListenerC0098i.f619l;
            c0080e.f283d = list;
            List<JSONObject> listM442a = c0080e.m442a();
            C0080e c0080e2 = viewOnKeyListenerC0098i.f619l;
            c0080e2.f284e = 0;
            c0080e2.notifyDataSetChanged();
            viewOnKeyListenerC0098i.m575a(listM442a);
        }
        if (i == 4 && keyEvent.getAction() == 1) {
            ((ViewOnKeyListenerC0098i) this.f597c).m571a(23);
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
