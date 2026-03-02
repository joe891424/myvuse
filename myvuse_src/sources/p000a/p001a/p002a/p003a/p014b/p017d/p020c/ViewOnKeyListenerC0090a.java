package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p016b.C0074f;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0085a;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.a */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0090a extends Fragment implements View.OnKeyListener, View.OnFocusChangeListener, TraceFieldInterface {
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public TextView f414a;

    /* JADX INFO: renamed from: b */
    public TextView f415b;

    /* JADX INFO: renamed from: c */
    public Button f416c;

    /* JADX INFO: renamed from: d */
    public Button f417d;

    /* JADX INFO: renamed from: e */
    public Button f418e;

    /* JADX INFO: renamed from: f */
    public Context f419f;

    /* JADX INFO: renamed from: g */
    public C0085a f420g;

    /* JADX INFO: renamed from: h */
    public a f421h;

    /* JADX INFO: renamed from: i */
    public LinearLayout f422i;

    /* JADX INFO: renamed from: j */
    public LinearLayout f423j;

    /* JADX INFO: renamed from: k */
    public LinearLayout f424k;

    /* JADX INFO: renamed from: l */
    public TextView f425l;

    /* JADX INFO: renamed from: m */
    public TextView f426m;

    /* JADX INFO: renamed from: n */
    public View f427n;

    /* JADX INFO: renamed from: o */
    public ImageView f428o;

    /* JADX INFO: renamed from: p */
    public ImageView f429p;

    /* JADX INFO: renamed from: q */
    public TextView f430q;

    /* JADX INFO: renamed from: r */
    public TextView f431r;

    /* JADX INFO: renamed from: s */
    public TextView f432s;

    /* JADX INFO: renamed from: t */
    public Button f433t;

    /* JADX INFO: renamed from: u */
    public Button f434u;

    /* JADX INFO: renamed from: v */
    public int f435v;

    /* JADX INFO: renamed from: w */
    public ImageView f436w;

    /* JADX INFO: renamed from: x */
    public LinearLayout f437x;

    /* JADX INFO: renamed from: y */
    public TextView f438y;

    /* JADX INFO: renamed from: z */
    public OTConfiguration f439z;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.a$a */
    public interface a {
    }

    /* JADX INFO: renamed from: a */
    public final void m511a(C0106b0 c0106b0, TextView textView) {
        textView.setVisibility(c0106b0.f727f);
        textView.setTextColor(Color.parseColor(c0106b0.f724c));
        new C0074f().m412a(this.f419f, textView, c0106b0.f726e);
    }

    /* JADX INFO: renamed from: a */
    public final void m513a(String str, Button button) {
        if (str != null && !C0048h.m305b(str)) {
            button.setTextColor(Color.parseColor(str));
        }
        button.setPaintFlags(button.getPaintFlags() | 8);
        button.getBackground().setTint(Color.parseColor(this.f420g.m470a()));
        button.setElevation(0.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("a");
        try {
            TraceMachine.enterMethod(this._nr_trace, "a#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "a#onCreate", null);
        }
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f419f = getActivity();
        TraceMachine.exitMethod();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x02bd  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateView(android.view.LayoutInflater r12, android.view.ViewGroup r13, android.os.Bundle r14) {
        /*
            Method dump skipped, instruction units count: 1147
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0090a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.btn_accept_TV) {
            C0072d.m391b(z, this.f416c, this.f420g.f343f.f793i);
        }
        if (view.getId() == C3896R.id.btn_reject_TV) {
            C0072d.m391b(z, this.f417d, this.f420g.f343f.f794j);
        }
        if (view.getId() == C3896R.id.btn_mp_TV) {
            C0072d.m391b(z, this.f418e, this.f420g.f343f.f795k);
        }
        if (view.getId() == C3896R.id.btn_VL_link_TV) {
            C0072d.m391b(z, this.f433t, this.f420g.f344g);
        }
        if (view.getId() == C3896R.id.tv_close_banner_text) {
            C0107c c0107c = this.f420g.f342e.f232p;
            if (C0026u.m181a(c0107c.f735h, false)) {
                C0072d.m391b(z, this.f434u, c0107c);
            } else {
                Button button = this.f434u;
                String strMo378b = this.f420g.f342e.mo378b();
                if (z) {
                    C0072d.m391b(true, button, c0107c);
                    button.setPaintFlags(button.getPaintFlags() & (-9));
                } else {
                    m513a(strMo378b, button);
                }
            }
        }
        if (view.getId() == C3896R.id.tv_close_banner) {
            m514a(z, this.f420g.f343f.f793i);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (view.getId() == C3896R.id.btn_accept_TV && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f421h).m538a(11);
        }
        if (view.getId() == C3896R.id.btn_reject_TV && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f421h).m538a(12);
        }
        if (view.getId() == C3896R.id.btn_mp_TV && C0072d.m382a(i, keyEvent) == 21) {
            C0093d c0093d = (C0093d) this.f421h;
            c0093d.getClass();
            OTUIDisplayReason oTUIDisplayReason = new OTUIDisplayReason(OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SHOW_PC_CALLED, OTUIDisplayReason.getResponseMessage(OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SHOW_PC_CALLED));
            C0003b c0003b = new C0003b(5);
            c0003b.f7f = oTUIDisplayReason;
            c0093d.f516h.m411a(c0003b, c0093d.f514f);
            c0093d.m544c();
            c0093d.m542b(1);
        }
        if (view.getId() == C3896R.id.tv_close_banner && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f421h).m538a(13);
        }
        if (view.getId() == C3896R.id.tv_close_banner_text && C0072d.m382a(i, keyEvent) == 21) {
            ((C0093d) this.f421h).m538a(16);
        }
        if (view.getId() != C3896R.id.btn_VL_link_TV || C0072d.m382a(i, keyEvent) != 21) {
            return false;
        }
        ((C0093d) this.f421h).m538a(15);
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
    public final void m512a(TextView textView, C0106b0 c0106b0) {
        C0074f c0074f = new C0074f();
        textView.setVisibility(0);
        textView.setTextColor(Color.parseColor(c0106b0.f724c));
        String str = c0106b0.f726e;
        if (str != null) {
            c0074f.m412a(this.f419f, textView, str);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m514a(boolean z, C0107c c0107c) {
        GradientDrawable gradientDrawableM383a = C0072d.m383a(z, c0107c.f738k, c0107c.f736i, this.f420g.m470a(), this.f420g.f343f.f789e.f724c, this.f428o);
        if (z) {
            if (!C0048h.m305b(c0107c.f736i) && !C0048h.m305b(c0107c.f737j)) {
                this.f428o.getBackground().setTint(Color.parseColor(c0107c.f736i));
                this.f428o.getDrawable().setTint(Color.parseColor(c0107c.f737j));
            }
        } else {
            this.f428o.getBackground().setTint(Color.parseColor(this.f420g.f343f.f789e.f724c));
            this.f428o.getDrawable().setTint(Color.parseColor(this.f420g.m470a()));
        }
        if (C0048h.m305b(c0107c.f731d)) {
            return;
        }
        this.f428o.setBackground(gradientDrawableM383a);
    }
}
