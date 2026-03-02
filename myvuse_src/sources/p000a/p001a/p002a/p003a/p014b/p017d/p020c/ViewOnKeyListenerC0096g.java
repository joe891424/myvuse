package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.CompoundButtonCompat;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.g */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0096g extends Fragment implements View.OnKeyListener, View.OnFocusChangeListener, TraceFieldInterface {
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public TextView f573a;

    /* JADX INFO: renamed from: b */
    public TextView f574b;

    /* JADX INFO: renamed from: c */
    public TextView f575c;

    /* JADX INFO: renamed from: d */
    public TextView f576d;

    /* JADX INFO: renamed from: e */
    public TextView f577e;

    /* JADX INFO: renamed from: f */
    public RelativeLayout f578f;

    /* JADX INFO: renamed from: g */
    public CardView f579g;

    /* JADX INFO: renamed from: h */
    public CardView f580h;

    /* JADX INFO: renamed from: i */
    public LinearLayout f581i;

    /* JADX INFO: renamed from: j */
    public LinearLayout f582j;

    /* JADX INFO: renamed from: k */
    public Context f583k;

    /* JADX INFO: renamed from: l */
    public JSONObject f584l;

    /* JADX INFO: renamed from: m */
    public CheckBox f585m;

    /* JADX INFO: renamed from: n */
    public CheckBox f586n;

    /* JADX INFO: renamed from: o */
    public CheckBox f587o;

    /* JADX INFO: renamed from: p */
    public a f588p;

    /* JADX INFO: renamed from: q */
    public C0087c f589q;

    /* JADX INFO: renamed from: r */
    public ScrollView f590r;

    /* JADX INFO: renamed from: s */
    public String f591s;

    /* JADX INFO: renamed from: t */
    public String f592t;

    /* JADX INFO: renamed from: u */
    public C0002a f593u;

    /* JADX INFO: renamed from: v */
    public OTPublishersHeadlessSDK f594v;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.g$a */
    public interface a {
    }

    /* JADX INFO: renamed from: a */
    public void m564a() {
        if (this.f579g.getVisibility() == 0) {
            this.f579g.requestFocus();
            return;
        }
        this.f576d.setFocusableInTouchMode(true);
        if (C0048h.m305b(this.f576d.getText().toString())) {
            return;
        }
        this.f576d.requestFocus();
    }

    /* JADX INFO: renamed from: a */
    public final void m565a(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.f585m, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.f586n, new ColorStateList(iArr, iArr2));
        this.f574b.setTextColor(Color.parseColor(str));
        this.f577e.setTextColor(Color.parseColor(str));
        this.f581i.setBackgroundColor(Color.parseColor(str2));
    }

    /* JADX INFO: renamed from: a */
    public final void m566a(boolean z) {
        this.f594v.updateSDKConsentStatus(this.f592t, z);
        String str = this.f592t;
        C0003b c0003b = new C0003b(24);
        c0003b.f3b = str;
        c0003b.f4c = z ? 1 : 0;
        C0002a c0002a = this.f593u;
        if (c0002a != null) {
            c0002a.m0a(c0003b);
        } else {
            OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m567b(String str, String str2) {
        CompoundButtonCompat.setButtonTintList(this.f587o, new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
        this.f575c.setTextColor(Color.parseColor(str));
        this.f577e.setTextColor(Color.parseColor(str));
        this.f582j.setBackgroundColor(Color.parseColor(str2));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("g");
        try {
            TraceMachine.enterMethod(this._nr_trace, "g#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "g#onCreate", null);
        }
        super.onCreate(bundle);
        this.f583k = getContext();
        TraceMachine.exitMethod();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x01b9  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onCreateView(android.view.LayoutInflater r17, android.view.ViewGroup r18, android.os.Bundle r19) {
        /*
            Method dump skipped, instruction units count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p017d.p020c.ViewOnKeyListenerC0096g.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view.getId() == C3896R.id.tv_sdk_card_consent) {
            if (z) {
                C0107c c0107c = this.f589q.f378j.f854y;
                m565a(c0107c.f737j, c0107c.f736i);
                this.f579g.setCardElevation(6.0f);
            } else {
                m565a(this.f589q.m498d(), this.f591s);
                this.f579g.setCardElevation(1.0f);
            }
        }
        if (view.getId() == C3896R.id.tv_sdk_card_off) {
            if (!z) {
                m567b(this.f589q.m498d(), this.f591s);
                this.f580h.setCardElevation(1.0f);
            } else {
                C0107c c0107c2 = this.f589q.f378j.f854y;
                m567b(c0107c2.f737j, c0107c2.f736i);
                this.f580h.setCardElevation(6.0f);
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            ((ViewOnKeyListenerC0098i) this.f588p).m571a(23);
        }
        if (C0072d.m382a(i, keyEvent) == 24) {
            ((ViewOnKeyListenerC0098i) this.f588p).m571a(24);
        }
        if (this.f589q.m500e()) {
            if (view.getId() == C3896R.id.tv_sdk_card_consent && C0072d.m382a(i, keyEvent) == 21) {
                boolean z = !this.f585m.isChecked();
                this.f585m.setChecked(z);
                m566a(z);
            }
        } else if (view.getId() == C3896R.id.tv_sdk_card_consent && C0072d.m382a(i, keyEvent) == 21) {
            if (!this.f586n.isChecked()) {
                m566a(true);
                this.f586n.setChecked(true);
                this.f587o.setChecked(false);
            }
        } else if (view.getId() == C3896R.id.tv_sdk_card_off && C0072d.m382a(i, keyEvent) == 21 && !this.f587o.isChecked()) {
            m566a(false);
            this.f586n.setChecked(false);
            this.f587o.setChecked(true);
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
