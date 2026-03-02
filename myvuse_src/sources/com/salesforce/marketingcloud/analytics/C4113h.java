package com.salesforce.marketingcloud.analytics;

import android.os.Bundle;
import android.text.TextUtils;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.InterfaceC4147e;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.InterfaceC4117l;
import com.salesforce.marketingcloud.analytics.etanalytics.C4107a;
import com.salesforce.marketingcloud.analytics.etanalytics.C4108b;
import com.salesforce.marketingcloud.analytics.etanalytics.C4109c;
import com.salesforce.marketingcloud.analytics.piwama.C4128i;
import com.salesforce.marketingcloud.analytics.stats.C4134c;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.behaviors.InterfaceC4139b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.iam.C4259j;
import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.toggles.EnumC4380a;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.EnumSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.h */
/* JADX INFO: loaded from: classes6.dex */
public final class C4113h implements InterfaceC4147e, InterfaceC4139b, InterfaceC4115j, RegionMessageManager.RegionTransitionEventListener, AnalyticsManager, InterfaceC4112g, InterfaceC4111f, InterfaceC4118m, InterfaceC4119n, InterfaceC4117l {

    /* JADX INFO: renamed from: s */
    private static final String f4419s = "ETAnalyticsEnabled";

    /* JADX INFO: renamed from: t */
    private static final String f4420t = "PIAnalyticsEnabled";

    /* JADX INFO: renamed from: u */
    private static final Object f4421u = new Object();

    /* JADX INFO: renamed from: d */
    private final C4140c f4422d;

    /* JADX INFO: renamed from: e */
    private final EnumSet<EnumC4138a> f4423e;

    /* JADX INFO: renamed from: f */
    final C4374j f4424f;

    /* JADX INFO: renamed from: g */
    private final C4174c f4425g;

    /* JADX INFO: renamed from: h */
    private final String f4426h;

    /* JADX INFO: renamed from: i */
    private final MarketingCloudConfig f4427i;

    /* JADX INFO: renamed from: j */
    private final C4093b f4428j;

    /* JADX INFO: renamed from: k */
    private C4109c f4429k;

    /* JADX INFO: renamed from: l */
    C4108b f4430l;

    /* JADX INFO: renamed from: m */
    C4107a f4431m;

    /* JADX INFO: renamed from: n */
    C4128i f4432n;

    /* JADX INFO: renamed from: o */
    C4134c f4433o;

    /* JADX INFO: renamed from: p */
    private C4189l f4434p;

    /* JADX INFO: renamed from: q */
    private EnumC4380a f4435q;

    /* JADX INFO: renamed from: r */
    private EnumC4380a f4436r;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.h$a */
    class a extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ InboxMessage f4437b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, InboxMessage inboxMessage) {
            super(str, objArr);
            this.f4437b = inboxMessage;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            if (this.f4437b == null || !C4113h.this.f4424f.m4240q().mo4101e(this.f4437b.m3794id())) {
                C4170g.m3216e(AnalyticsManager.TAG, "InboxMessage is a Legacy message, null or unknown.  Call to trackInboxOpenEvent() ignored.", new Object[0]);
                return;
            }
            C4107a c4107a = C4113h.this.f4431m;
            if (c4107a != null) {
                c4107a.trackInboxOpenEvent(this.f4437b);
            }
            C4108b c4108b = C4113h.this.f4430l;
            if (c4108b != null) {
                c4108b.trackInboxOpenEvent(this.f4437b);
            }
            C4128i c4128i = C4113h.this.f4432n;
            if (c4128i != null) {
                c4128i.trackInboxOpenEvent(this.f4437b);
            }
            C4134c c4134c = C4113h.this.f4433o;
            if (c4134c != null) {
                c4134c.trackInboxOpenEvent(this.f4437b);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.h$b */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4439a;

        static {
            int[] iArr = new int[EnumC4138a.values().length];
            f4439a = iArr;
            try {
                iArr[EnumC4138a.BEHAVIOR_APP_BACKGROUNDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4439a[EnumC4138a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4439a[EnumC4138a.BEHAVIOR_DEVICE_SHUTDOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4439a[EnumC4138a.BEHAVIOR_DEVICE_BOOT_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    C4113h(MarketingCloudConfig marketingCloudConfig, C4374j c4374j, String str, C4093b c4093b, C4140c c4140c, C4174c c4174c, C4107a c4107a, C4108b c4108b, C4128i c4128i, C4189l c4189l, C4134c c4134c, C4109c c4109c) {
        this(marketingCloudConfig, c4374j, str, c4093b, c4140c, c4174c, c4189l);
        this.f4431m = c4107a;
        this.f4430l = c4108b;
        this.f4432n = c4128i;
        this.f4433o = c4134c;
        this.f4429k = c4109c;
    }

    /* JADX INFO: renamed from: a */
    private void m2940a(Bundle bundle) {
        long j = bundle.getLong("timestamp", 0L);
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2924a(j);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2924a(j);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2924a(j);
            this.f4432n.m2975c();
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2924a(j);
            this.f4433o.m2994a();
        }
        C4109c c4109c = this.f4429k;
        if (c4109c != null) {
            c4109c.m2931a();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2942b(Bundle bundle) {
        long j = bundle.getLong("timestamp", System.currentTimeMillis());
        C4109c c4109c = this.f4429k;
        if (c4109c != null) {
            c4109c.m2931a();
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2927b(j);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2927b(j);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.m2975c();
            this.f4432n.mo2927b(j);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.m2994a();
            this.f4433o.mo2927b(j);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2943c(Bundle bundle) {
        long j = bundle.getLong("timestamp", 0L);
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2929c(j);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2929c(j);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2929c(j);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2929c(j);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public boolean areAnalyticsEnabled() {
        if (C4137b.m3024a(C4137b.m3022a(this.f4424f.m4238o()), 256)) {
            return false;
        }
        if (this.f4435q == null) {
            this.f4435q = m2939a(f4419s, (EnumC4380a) null);
        }
        EnumC4380a enumC4380a = this.f4435q;
        return enumC4380a == EnumC4380a.f5739b || (enumC4380a == EnumC4380a.f5738a && this.f4427i.analyticsEnabled());
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public boolean arePiAnalyticsEnabled() {
        if (C4137b.m3024a(C4137b.m3022a(this.f4424f.m4238o()), 512)) {
            return false;
        }
        if (this.f4436r == null) {
            this.f4436r = m2939a(f4420t, (EnumC4380a) null);
        }
        EnumC4380a enumC4380a = this.f4436r;
        return enumC4380a == EnumC4380a.f5739b || (enumC4380a == EnumC4380a.f5738a && this.f4427i.piAnalyticsEnabled());
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public String componentName() {
        return "AnalyticsManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean z = true;
            jSONObject.put("bet_analytics", this.f4431m != null);
            jSONObject.put("et_analytics", this.f4430l != null);
            jSONObject.put("pi_analytics", this.f4432n != null);
            if (this.f4433o == null) {
                z = false;
            }
            jSONObject.put("device_stats", z);
            C4128i c4128i = this.f4432n;
            if (c4128i != null) {
                jSONObject.put("predictive_intelligence_identifier", c4128i.getPiIdentifier());
            }
            jSONObject.put("analyticsEnabled", areAnalyticsEnabled());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void controlChannelInit(int i) {
        boolean zM3024a = C4137b.m3024a(i, 256);
        if (C4137b.m3024a(i, 2048)) {
            C4107a c4107a = this.f4431m;
            if (c4107a != null) {
                c4107a.mo2918a(false);
                this.f4431m = null;
            }
            C4107a.m2915a(this.f4424f, this.f4434p, C4137b.m3027c(i, 2048));
            C4134c c4134c = this.f4433o;
            if (c4134c != null) {
                c4134c.mo2918a(false);
                this.f4433o = null;
            }
            C4134c.m2992a(this.f4424f, C4137b.m3027c(i, 2048));
        } else {
            this.f4431m = new C4107a(this.f4424f, this.f4434p);
            MarketingCloudConfig marketingCloudConfig = this.f4427i;
            this.f4433o = new C4134c(marketingCloudConfig, this.f4426h, marketingCloudConfig.analyticsEnabled() && !zM3024a, this.f4424f, this.f4425g, this.f4428j, this.f4434p);
        }
        if (zM3024a) {
            C4108b c4108b = this.f4430l;
            if (c4108b != null) {
                c4108b.mo2918a(false);
                this.f4430l = null;
            }
            C4108b.m2922a(this.f4424f, this.f4434p, C4137b.m3027c(i, 256));
        } else if (this.f4430l == null && this.f4427i.analyticsEnabled()) {
            this.f4430l = new C4108b(this.f4424f, this.f4434p);
        }
        if (C4137b.m3024a(i, 512)) {
            C4128i c4128i = this.f4432n;
            if (c4128i != null) {
                c4128i.mo2918a(false);
                this.f4432n = null;
            }
            C4128i.m2968a(this.f4424f, this.f4425g, this.f4434p, C4137b.m3027c(i, 512));
        } else if (this.f4432n == null && this.f4427i.piAnalyticsEnabled()) {
            this.f4432n = new C4128i(this.f4427i, this.f4424f, this.f4425g, this.f4434p);
        }
        if (this.f4431m != null || this.f4430l != null) {
            if (this.f4429k == null) {
                this.f4429k = new C4109c(this.f4427i, this.f4426h, this.f4424f, this.f4425g, this.f4428j, this.f4434p);
            }
        } else {
            this.f4428j.m2868d(AbstractC4092a.a.f4318c);
            C4109c c4109c = this.f4429k;
            if (c4109c != null) {
                c4109c.m2933b();
                this.f4429k = null;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void disableAnalytics() {
        synchronized (f4421u) {
            this.f4435q = EnumC4380a.f5740c;
            this.f4424f.mo4222f().edit().putString(f4419s, this.f4435q.name()).apply();
            C4108b c4108b = this.f4430l;
            if (c4108b != null) {
                c4108b.mo2918a(true);
                this.f4430l = null;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void disablePiAnalytics() {
        synchronized (f4421u) {
            this.f4436r = EnumC4380a.f5740c;
            this.f4424f.mo4222f().edit().putString(f4420t, this.f4436r.name()).apply();
            C4170g.m3202a(AnalyticsManager.TAG, "Pi Analytics runtime toggle set to " + this.f4436r.name(), new Object[0]);
            C4128i c4128i = this.f4432n;
            if (c4128i != null) {
                c4128i.mo2918a(true);
                this.f4432n = null;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void enableAnalytics() {
        synchronized (f4421u) {
            if (C4137b.m3024a(C4137b.m3022a(this.f4424f.m4238o()), 256)) {
                return;
            }
            this.f4435q = EnumC4380a.f5739b;
            this.f4424f.mo4222f().edit().putString(f4419s, this.f4435q.name()).apply();
            this.f4430l = new C4108b(this.f4424f, this.f4434p);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void enablePiAnalytics() {
        synchronized (f4421u) {
            if (C4137b.m3024a(C4137b.m3022a(this.f4424f.m4238o()), 512)) {
                return;
            }
            this.f4436r = EnumC4380a.f5739b;
            this.f4424f.mo4222f().edit().putString(f4420t, this.f4436r.name()).apply();
            C4170g.m3202a(AnalyticsManager.TAG, "Pi Analytics runtime toggle set to " + this.f4436r.name(), new Object[0]);
            this.f4432n = new C4128i(this.f4427i, this.f4424f, this.f4425g, this.f4434p);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public String getPiIdentifier() {
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            return c4128i.getPiIdentifier();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void init(InitializationStatus.C4081a c4081a, int i) {
        boolean zM2948a = m2948a(i, m2939a(f4419s, this.f4435q));
        if (C4137b.m3026b(i, 2048)) {
            this.f4431m = new C4107a(this.f4424f, this.f4434p);
            this.f4433o = new C4134c(this.f4427i, this.f4426h, zM2948a, this.f4424f, this.f4425g, this.f4428j, this.f4434p);
        }
        m2941b(i, m2939a(f4420t, this.f4436r));
        if (this.f4431m != null || this.f4430l != null) {
            this.f4429k = new C4109c(this.f4427i, this.f4426h, this.f4424f, this.f4425g, this.f4428j, this.f4434p);
        }
        this.f4422d.m3037a(this, this.f4423e);
    }

    @Override // com.salesforce.marketingcloud.behaviors.InterfaceC4139b
    public void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        int i = b.f4439a[enumC4138a.ordinal()];
        if (i == 1) {
            m2940a(bundle);
            return;
        }
        if (i == 2) {
            m2942b(bundle);
        } else if (i == 3 || i == 4) {
            m2943c(bundle);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager.RegionTransitionEventListener
    public void onTransitionEvent(int i, Region region) {
        if (i == 1) {
            C4107a c4107a = this.f4431m;
            if (c4107a != null) {
                c4107a.mo2925a(region);
            }
            C4108b c4108b = this.f4430l;
            if (c4108b != null) {
                c4108b.mo2925a(region);
            }
            C4128i c4128i = this.f4432n;
            if (c4128i != null) {
                c4128i.mo2925a(region);
            }
            C4134c c4134c = this.f4433o;
            if (c4134c != null) {
                c4134c.mo2925a(region);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        C4107a c4107a2 = this.f4431m;
        if (c4107a2 != null) {
            c4107a2.mo2928b(region);
        }
        C4108b c4108b2 = this.f4430l;
        if (c4108b2 != null) {
            c4108b2.mo2928b(region);
        }
        C4128i c4128i2 = this.f4432n;
        if (c4128i2 != null) {
            c4128i2.mo2928b(region);
        }
        C4134c c4134c2 = this.f4433o;
        if (c4134c2 != null) {
            c4134c2.mo2928b(region);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void setPiIdentifier(String str) {
        if (str != null && TextUtils.getTrimmedLength(str) == 0) {
            C4170g.m3216e(AnalyticsManager.TAG, "Call to setPiIdentifier() ignored. Predictive Intelligence Identifier contained only whitespace.", new Object[0]);
            return;
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.setPiIdentifier(str);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        this.f4422d.m3036a(this);
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2918a(z);
            this.f4431m = null;
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2918a(z);
            this.f4430l = null;
        }
        C4109c c4109c = this.f4429k;
        if (c4109c != null) {
            c4109c.m2933b();
            this.f4429k = null;
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2918a(z);
            this.f4433o = null;
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2918a(z);
            this.f4432n = null;
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartContents(PiCart piCart) {
        if (piCart == null) {
            C4170g.m3216e(AnalyticsManager.TAG, "PiCart may not be null.  We could not complete your trackCartContents() request.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.trackCartContents(piCart);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.trackCartContents(piCart);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.trackCartContents(piCart);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.trackCartContents(piCart);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackCartConversion(PiOrder piOrder) {
        if (piOrder == null) {
            C4170g.m3216e(AnalyticsManager.TAG, "PiOrder may not be null.  We could not complete your trackCartConversion() request.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.trackCartConversion(piOrder);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.trackCartConversion(piOrder);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.trackCartConversion(piOrder);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.trackCartConversion(piOrder);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackInboxOpenEvent(InboxMessage inboxMessage) {
        this.f4434p.m3399b().execute(new a("track_inbox_open", new Object[0], inboxMessage));
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(String str) {
        trackPageView(str, null, null, null);
    }

    public C4113h(MarketingCloudConfig marketingCloudConfig, C4374j c4374j, String str, C4093b c4093b, C4140c c4140c, C4174c c4174c, C4189l c4189l) {
        this.f4423e = EnumSet.of(EnumC4138a.BEHAVIOR_APP_BACKGROUNDED, EnumC4138a.BEHAVIOR_APP_FOREGROUNDED, EnumC4138a.BEHAVIOR_DEVICE_SHUTDOWN, EnumC4138a.BEHAVIOR_DEVICE_BOOT_COMPLETE);
        this.f4424f = (C4374j) C4391j.m4326a(c4374j, "MCStorage may not be null.");
        this.f4422d = (C4140c) C4391j.m4326a(c4140c, "BehaviorManager may not be null.");
        this.f4425g = c4174c;
        this.f4426h = str;
        this.f4427i = marketingCloudConfig;
        this.f4428j = c4093b;
        this.f4434p = c4189l;
    }

    /* JADX INFO: renamed from: b */
    private void m2941b(int i, EnumC4380a enumC4380a) {
        if (C4137b.m3024a(i, 512)) {
            return;
        }
        this.f4436r = enumC4380a;
        if (enumC4380a == EnumC4380a.f5739b || (this.f4427i.piAnalyticsEnabled() && enumC4380a == EnumC4380a.f5738a)) {
            this.f4432n = new C4128i(this.f4427i, this.f4424f, this.f4425g, this.f4434p);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m2948a(int i, EnumC4380a enumC4380a) {
        boolean z = false;
        if (C4137b.m3024a(i, 256)) {
            return false;
        }
        this.f4435q = enumC4380a;
        if (enumC4380a == EnumC4380a.f5739b || (this.f4427i.analyticsEnabled() && enumC4380a == EnumC4380a.f5738a)) {
            z = true;
        }
        if (z) {
            this.f4430l = new C4108b(this.f4424f, this.f4434p);
        }
        return z;
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(String str, String str2) {
        trackPageView(str, str2, null, null);
    }

    /* JADX INFO: renamed from: a */
    private EnumC4380a m2939a(String str, EnumC4380a enumC4380a) {
        if (enumC4380a != null) {
            return enumC4380a;
        }
        String string = this.f4424f.mo4222f().getString(str, null);
        return string == null ? EnumC4380a.f5738a : EnumC4380a.valueOf(string);
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: b */
    public void mo2938b(InAppMessage inAppMessage) {
        if (inAppMessage == null) {
            C4170g.m3216e(AnalyticsManager.TAG, "InAppMessage is null.  Call to onInAppMessageDownloaded() ignored.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2938b(inAppMessage);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2938b(inAppMessage);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2938b(inAppMessage);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2938b(inAppMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(String str, String str2, String str3) {
        trackPageView(str, str2, str3, null);
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4119n
    /* JADX INFO: renamed from: a */
    public void mo2944a(C4106e c4106e, Event... eventArr) {
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2944a(c4106e, eventArr);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2944a(c4106e, eventArr);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2944a(c4106e, eventArr);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2944a(c4106e, eventArr);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: b */
    public void mo2949b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            C4170g.m3216e(AnalyticsManager.TAG, "Information not valid. Call to onSyncGateTimeOutEvent() ignored", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2949b(jSONObject);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2949b(jSONObject);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2949b(jSONObject);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2949b(jSONObject);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AnalyticsManager
    public void trackPageView(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            C4170g.m3216e(AnalyticsManager.TAG, "url may not be null or empty.  We could not complete your trackPageView() request.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.trackPageView(str, str2, str3, str4);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.trackPageView(str, str2, str3, str4);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.trackPageView(str, str2, str3, str4);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.trackPageView(str, str2, str3, str4);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2934a(InAppMessage inAppMessage) {
        if (inAppMessage == null) {
            C4170g.m3216e(AnalyticsManager.TAG, "InAppMessage is null.  Call to onIamDisplayed() ignored.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2934a(inAppMessage);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2934a(inAppMessage);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2934a(inAppMessage);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2934a(inAppMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: b */
    public void mo2919b(NotificationMessage notificationMessage) {
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2919b(notificationMessage);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2919b(notificationMessage);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2919b(notificationMessage);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2919b(notificationMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2935a(InAppMessage inAppMessage, C4259j c4259j) {
        if (inAppMessage == null || c4259j == null) {
            C4170g.m3216e(AnalyticsManager.TAG, "InAppMessage or MessageCompletedEvent is null.  Call to onInAppMessageCompleted() ignored.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2935a(inAppMessage, c4259j);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2935a(inAppMessage, c4259j);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2935a(inAppMessage, c4259j);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2935a(inAppMessage, c4259j);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2936a(InAppMessage inAppMessage, JSONObject jSONObject) {
        if (inAppMessage == null || jSONObject == null || jSONObject.length() <= 0) {
            C4170g.m3216e(AnalyticsManager.TAG, "Message and/or Information not valid. Call to onInAppMessageThrottled() ignored", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2936a(inAppMessage, jSONObject);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2936a(inAppMessage, jSONObject);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2936a(inAppMessage, jSONObject);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2936a(inAppMessage, jSONObject);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4111f
    /* JADX INFO: renamed from: a */
    public void mo2937a(String str, String str2, List<String> list) {
        if (str == null || str2 == null || list == null || list.isEmpty()) {
            C4170g.m3216e(AnalyticsManager.TAG, "messageId, activityInstanceId or reasons is null.  Call to onInAppMessageValidationError() ignored.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2937a(str, str2, list);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2937a(str, str2, list);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2937a(str, str2, list);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2937a(str, str2, list);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: a */
    public void mo2947a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            C4170g.m3216e(AnalyticsManager.TAG, "Information not valid. Call to onInvalidConfigEvent() ignored", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2947a(jSONObject);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2947a(jSONObject);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2947a(jSONObject);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2947a(jSONObject);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4112g
    /* JADX INFO: renamed from: a */
    public void mo2916a(InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            C4170g.m3216e(AnalyticsManager.TAG, "InboxMessage is null.  Call to onMessageDownloaded() ignored.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2916a(inboxMessage);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2916a(inboxMessage);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2916a(inboxMessage);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2916a(inboxMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4117l
    /* JADX INFO: renamed from: a */
    public void mo2945a(InterfaceC4117l.a aVar, JSONObject jSONObject) {
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2945a(aVar, jSONObject);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2945a(aVar, jSONObject);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2945a(aVar, jSONObject);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2945a(aVar, jSONObject);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4118m
    /* JADX INFO: renamed from: a */
    public void mo2946a(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null || str3 == null) {
            C4170g.m3216e(AnalyticsManager.TAG, "triggerId, outcomeId or outcomeType is null.  Call to onTriggerSuccessEvent() ignored.", new Object[0]);
            return;
        }
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2946a(str, str2, str3, str4);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2946a(str, str2, str3, str4);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2946a(str, str2, str3, str4);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2946a(str, str2, str3, str4);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: a */
    public void mo2926a(NotificationMessage notificationMessage) {
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2926a(notificationMessage);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2926a(notificationMessage);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2926a(notificationMessage);
        }
        C4134c c4134c = this.f4433o;
        if (c4134c != null) {
            c4134c.mo2926a(notificationMessage);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: a */
    public void mo2917a(NotificationMessage notificationMessage, boolean z) {
        C4107a c4107a = this.f4431m;
        if (c4107a != null) {
            c4107a.mo2917a(notificationMessage, z);
        }
        C4108b c4108b = this.f4430l;
        if (c4108b != null) {
            c4108b.mo2917a(notificationMessage, z);
        }
        C4128i c4128i = this.f4432n;
        if (c4128i != null) {
            c4128i.mo2917a(notificationMessage, z);
        }
    }
}
