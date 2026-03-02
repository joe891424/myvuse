package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
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
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.onetrust.otpublishers.headless.C3896R;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p006b.C0002a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0003b;
import p000a.p001a.p002a.p003a.p014b.p016b.C0072d;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0087c;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0089e;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.b */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnKeyListenerC0091b extends Fragment implements View.OnKeyListener, View.OnFocusChangeListener, TraceFieldInterface {
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    public TextView f440a;

    /* JADX INFO: renamed from: b */
    public TextView f441b;

    /* JADX INFO: renamed from: c */
    public TextView f442c;

    /* JADX INFO: renamed from: d */
    public RelativeLayout f443d;

    /* JADX INFO: renamed from: e */
    public CardView f444e;

    /* JADX INFO: renamed from: f */
    public LinearLayout f445f;

    /* JADX INFO: renamed from: g */
    public LinearLayout f446g;

    /* JADX INFO: renamed from: h */
    public Context f447h;

    /* JADX INFO: renamed from: i */
    public OTPublishersHeadlessSDK f448i;

    /* JADX INFO: renamed from: j */
    public JSONObject f449j;

    /* JADX INFO: renamed from: k */
    public a f450k;

    /* JADX INFO: renamed from: l */
    public C0087c f451l;

    /* JADX INFO: renamed from: m */
    public CheckBox f452m;

    /* JADX INFO: renamed from: n */
    public C0002a f453n;

    /* JADX INFO: renamed from: o */
    public boolean f454o = true;

    /* JADX INFO: renamed from: p */
    public ScrollView f455p;

    /* JADX INFO: renamed from: q */
    public String f456q;

    /* JADX INFO: renamed from: r */
    public C0089e f457r;

    /* JADX INFO: renamed from: a.a.a.a.b.d.c.b$a */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m515a(CompoundButton compoundButton, boolean z) {
        String strTrim = this.f449j.optString("id").trim();
        this.f448i.updateVendorConsent(OTVendorListMode.GOOGLE, strTrim, z);
        if (this.f454o) {
            C0003b c0003b = new C0003b(15);
            c0003b.f3b = strTrim;
            c0003b.f4c = z ? 1 : 0;
            C0002a c0002a = this.f453n;
            if (c0002a != null) {
                c0002a.m0a(c0003b);
            } else {
                OTLogger.m2743a(6, "OneTrust", "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
        }
        ((ViewOnKeyListenerC0102m) this.f450k).getClass();
    }

    /* JADX INFO: renamed from: a */
    public void m516a() {
        TextView textView = this.f441b;
        if (textView != null && !C0048h.m305b(textView.getText().toString())) {
            this.f441b.requestFocus();
            return;
        }
        CardView cardView = this.f444e;
        if (cardView != null) {
            cardView.requestFocus();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m517a(View view) {
        this.f440a = (TextView) view.findViewById(C3896R.id.vendor_name_tv);
        this.f441b = (TextView) view.findViewById(C3896R.id.vendors_privacy_notice_tv);
        this.f443d = (RelativeLayout) view.findViewById(C3896R.id.vd_linearLyt_tv);
        this.f444e = (CardView) view.findViewById(C3896R.id.tv_vd_card_consent);
        this.f445f = (LinearLayout) view.findViewById(C3896R.id.vd_consent_lyt);
        this.f446g = (LinearLayout) view.findViewById(C3896R.id.vd_li_lyt);
        this.f442c = (TextView) view.findViewById(C3896R.id.vd_consent_label_tv);
        this.f452m = (CheckBox) view.findViewById(C3896R.id.tv_vd_consent_cb);
        this.f455p = (ScrollView) view.findViewById(C3896R.id.bg_main);
        this.f452m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: a.a.a.a.b.d.c.b$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.m515a(compoundButton, z);
            }
        });
        this.f444e.setOnKeyListener(this);
        this.f444e.setOnFocusChangeListener(this);
        this.f441b.setOnKeyListener(this);
        this.f441b.setOnFocusChangeListener(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m518a(String str, String str2) {
        CompoundButtonCompat.setButtonTintList(this.f452m, new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
        this.f442c.setTextColor(Color.parseColor(str));
        this.f445f.setBackgroundColor(Color.parseColor(str2));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("b");
        try {
            TraceMachine.enterMethod(this._nr_trace, "b#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "b#onCreate", null);
        }
        super.onCreate(bundle);
        this.f447h = getContext();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "b#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "b#onCreateView", null);
        }
        Context context = this.f447h;
        int i = C3896R.layout.ot_vendor_details_tv_fragment;
        if (new C0048h().m318g(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, C3896R.style.Theme_AppCompat_Light_NoActionBar));
        }
        View viewInflate = layoutInflater.inflate(i, viewGroup, false);
        this.f457r = C0089e.m509a();
        m517a(viewInflate);
        this.f446g.setVisibility(8);
        this.f457r.m510a(this.f449j);
        this.f451l = C0087c.m482c();
        this.f455p.setSmoothScrollingEnabled(true);
        this.f440a.setText(this.f457r.f394c);
        this.f441b.setText(this.f457r.f396e);
        this.f442c.setText(this.f451l.m488a(false));
        this.f444e.setVisibility(0);
        this.f454o = false;
        this.f452m.setChecked(this.f449j.optInt(OTVendorUtils.CONSENT_TYPE) == 1);
        this.f456q = new C0072d().m392a(this.f451l.m494b());
        String strM498d = this.f451l.m498d();
        this.f440a.setTextColor(Color.parseColor(strM498d));
        this.f441b.setTextColor(Color.parseColor(strM498d));
        this.f443d.setBackgroundColor(Color.parseColor(this.f451l.m494b()));
        this.f444e.setCardElevation(1.0f);
        m518a(strM498d, this.f456q);
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        TextView textView;
        String strM498d;
        CardView cardView;
        float f;
        if (view.getId() == C3896R.id.tv_vd_card_consent) {
            if (z) {
                C0107c c0107c = this.f451l.f378j.f854y;
                m518a(c0107c.f737j, c0107c.f736i);
                cardView = this.f444e;
                f = 6.0f;
            } else {
                m518a(this.f451l.m498d(), this.f456q);
                cardView = this.f444e;
                f = 1.0f;
            }
            cardView.setCardElevation(f);
        }
        if (view.getId() == C3896R.id.vendors_privacy_notice_tv) {
            if (z) {
                this.f441b.setBackgroundColor(Color.parseColor(this.f451l.f378j.f854y.f736i));
                textView = this.f441b;
                strM498d = this.f451l.f378j.f854y.f737j;
            } else {
                this.f441b.setBackgroundColor(Color.parseColor(this.f456q));
                textView = this.f441b;
                strM498d = this.f451l.m498d();
            }
            textView.setTextColor(Color.parseColor(strM498d));
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (view.getId() == C3896R.id.tv_vd_card_consent && C0072d.m382a(i, keyEvent) == 21) {
            this.f454o = true;
            this.f452m.setChecked(!r0.isChecked());
        }
        if (view.getId() == C3896R.id.vendors_privacy_notice_tv && C0072d.m382a(i, keyEvent) == 21) {
            C0072d c0072d = new C0072d();
            FragmentActivity activity = getActivity();
            C0089e c0089e = this.f457r;
            c0072d.m393a(activity, c0089e.f395d, c0089e.f396e, this.f451l.f378j.f854y);
        }
        if (i == 4 && keyEvent.getAction() == 1) {
            ((ViewOnKeyListenerC0102m) this.f450k).m597a(23);
        }
        if (C0072d.m382a(i, keyEvent) != 24) {
            return false;
        }
        ((ViewOnKeyListenerC0102m) this.f450k).m597a(24);
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
}
