package com.salesforce.marketingcloud.registration;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.InterfaceC4147e;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.behaviors.InterfaceC4139b;
import com.salesforce.marketingcloud.events.C4153d;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.C4188k;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.registration.C4310e;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventSubscriber;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.salesforce.marketingcloud.util.C4389h;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.d */
/* JADX INFO: loaded from: classes6.dex */
public class C4309d implements InterfaceC4147e, RegistrationManager, InterfaceC4139b, C4093b.b, C4174c.c, C4310e.f, EventSubscriber {

    /* JADX INFO: renamed from: o */
    private static final EnumSet<EnumC4138a> f5463o = EnumSet.of(EnumC4138a.BEHAVIOR_APP_PACKAGE_REPLACED, EnumC4138a.BEHAVIOR_DEVICE_TIME_ZONE_CHANGED, EnumC4138a.BEHAVIOR_APP_FOREGROUNDED, EnumC4138a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, EnumC4138a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, EnumC4138a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED, EnumC4138a.BEHAVIOR_SDK_TOKEN_REFRESHED, EnumC4138a.BEHAVIOR_APP_BACKGROUNDED);

    /* JADX INFO: renamed from: d */
    private final Context f5464d;

    /* JADX INFO: renamed from: e */
    private final MarketingCloudConfig f5465e;

    /* JADX INFO: renamed from: f */
    private final C4374j f5466f;

    /* JADX INFO: renamed from: g */
    private final C4140c f5467g;

    /* JADX INFO: renamed from: h */
    private final C4093b f5468h;

    /* JADX INFO: renamed from: i */
    private final C4174c f5469i;

    /* JADX INFO: renamed from: j */
    private final PushMessageManager f5470j;

    /* JADX INFO: renamed from: k */
    private final C4189l f5471k;

    /* JADX INFO: renamed from: l */
    private final SFMCSdkComponents f5472l;

    /* JADX INFO: renamed from: m */
    private final C4311f f5473m;

    /* JADX INFO: renamed from: n */
    private C4310e f5474n;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.d$a */
    class a implements InterfaceC4340c {
        a() {
        }

        @Override // com.salesforce.marketingcloud.storage.InterfaceC4340c
        /* JADX INFO: renamed from: a */
        public void mo3928a() {
        }

        @Override // com.salesforce.marketingcloud.storage.InterfaceC4340c
        /* JADX INFO: renamed from: a */
        public void mo3929a(String str) {
        }

        @Override // com.salesforce.marketingcloud.storage.InterfaceC4340c
        /* JADX INFO: renamed from: a */
        public void mo3930a(String str, String str2) {
        }

        @Override // com.salesforce.marketingcloud.storage.InterfaceC4340c
        /* JADX INFO: renamed from: b */
        public String mo3931b(String str, String str2) {
            return str2;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.d$b */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5475a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f5476b;

        static {
            int[] iArr = new int[AbstractC4092a.a.values().length];
            f5476b = iArr;
            try {
                iArr[AbstractC4092a.a.f4317b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[EnumC4138a.values().length];
            f5475a = iArr2;
            try {
                iArr2[EnumC4138a.BEHAVIOR_APP_PACKAGE_REPLACED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5475a[EnumC4138a.BEHAVIOR_DEVICE_TIME_ZONE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5475a[EnumC4138a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5475a[EnumC4138a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5475a[EnumC4138a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5475a[EnumC4138a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5475a[EnumC4138a.BEHAVIOR_APP_BACKGROUNDED.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5475a[EnumC4138a.BEHAVIOR_SDK_TOKEN_REFRESHED.ordinal()] = 8;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.d$c */
    static class c implements RegistrationManager.Editor {
        c() {
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTag(String str) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTags(Iterable<String> iterable) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTags(String... strArr) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttribute(String str) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttributes(Iterable<String> iterable) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttributes(String... strArr) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearTags() {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public boolean commit() {
            return false;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTag(String str) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTags(Iterable<String> iterable) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTags(String... strArr) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor setAttribute(String str, String str2) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor setContactKey(String str) {
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor setSignedString(String str) {
            return this;
        }
    }

    public C4309d(Context context, MarketingCloudConfig marketingCloudConfig, C4374j c4374j, C4311f c4311f, C4140c c4140c, C4093b c4093b, C4174c c4174c, PushMessageManager pushMessageManager, C4189l c4189l) {
        this(context, marketingCloudConfig, c4374j, c4311f, c4140c, c4093b, c4174c, pushMessageManager, c4189l, (SFMCSdkComponents) null);
    }

    /* JADX INFO: renamed from: a */
    public static String m3924a(C4374j c4374j) {
        return c4374j.mo4220c().mo3931b(InterfaceC4340c.f5562d, null);
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return "RegistrationManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final JSONObject componentState() {
        C4310e c4310e = this.f5474n;
        return c4310e != null ? c4310e.m3951d() : new JSONObject();
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void controlChannelInit(int i) {
        if (!C4137b.m3024a(i, 2)) {
            if (this.f5474n == null) {
                m3926a((InitializationStatus.C4081a) null);
                this.f5474n.m3954g();
                return;
            }
            return;
        }
        this.f5474n = null;
        C4310e.m3934a(this.f5466f, this.f5468h, C4137b.m3027c(i, 2));
        this.f5467g.m3036a(this);
        m3925a();
        this.f5468h.m2869e(AbstractC4092a.a.f4317b);
        this.f5469i.m3296a(EnumC4172a.f4823o);
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public RegistrationManager.Editor edit() {
        C4310e c4310e = this.f5474n;
        return c4310e != null ? c4310e.m3938a(this) : new c();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public Map<String, String> getAttributes() {
        C4310e c4310e = this.f5474n;
        return c4310e != null ? c4310e.getAttributes() : Collections.emptyMap();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getContactKey() {
        C4310e c4310e = this.f5474n;
        if (c4310e != null) {
            return c4310e.getContactKey();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getDeviceId() {
        C4310e c4310e = this.f5474n;
        return c4310e != null ? c4310e.getDeviceId() : "";
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getSignedString() {
        C4310e c4310e = this.f5474n;
        if (c4310e != null) {
            return c4310e.getSignedString();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getSystemToken() {
        C4310e c4310e = this.f5474n;
        if (c4310e != null) {
            return c4310e.getSystemToken();
        }
        return null;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public Set<String> getTags() {
        C4310e c4310e = this.f5474n;
        return c4310e != null ? c4310e.getTags() : Collections.emptySet();
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void init(InitializationStatus.C4081a c4081a, int i) {
        if (C4137b.m3026b(i, 2)) {
            m3926a(c4081a);
        }
    }

    @Override // com.salesforce.marketingcloud.behaviors.InterfaceC4139b
    public final void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        if (this.f5474n != null) {
            switch (b.f5475a[enumC4138a.ordinal()]) {
                case 1:
                    this.f5474n.m3949c();
                    break;
                case 2:
                    this.f5474n.m3955h();
                    break;
                case 3:
                    this.f5474n.m3948b(bundle.getBoolean(PushMessageManager.f5366h));
                    break;
                case 4:
                case 5:
                case 6:
                    this.f5474n.m3947b();
                    break;
                case 7:
                    this.f5474n.m3939a();
                    break;
                case 8:
                    this.f5474n.m3942a(bundle.getString(PushMessageManager.f5367i, ""));
                    break;
                default:
                    C4170g.m3202a(RegistrationManager.f5454a, "Unhandled behavior: %s", enumC4138a);
                    break;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.events.EventSubscriber
    public void onEventPublished(Event... eventArr) {
        for (com.salesforce.marketingcloud.events.Event event : C4153d.m3134a(eventArr, (EnumSet<Event.Producer>) EnumSet.of(Event.Producer.SFMC_SDK), (EnumSet<Event.Category>) EnumSet.of(Event.Category.IDENTITY))) {
            try {
                JSONObject jSONObject = (JSONObject) ((JSONObject) Objects.requireNonNull(event.attributes().get("moduleIdentities"))).get(ModuleIdentifier.PUSH.name().toLowerCase());
                JSONObject jSONObject2 = jSONObject.getJSONObject("customProperties").getJSONObject(C4352k.a.f5654h);
                Iterator<String> itKeys = jSONObject2.keys();
                HashMap map = new HashMap();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, (String) jSONObject2.get(next));
                }
                String strOptString = jSONObject.optString("profileId", null);
                (strOptString != null ? this.f5474n.m3946b(this).mo3919a(strOptString, (Map<String, String>) map, false) : this.f5474n.m3946b(this).mo3921a((Map<String, String>) map, false)).commit();
            } catch (Exception e) {
                C4170g.m3217e(RegistrationManager.f5454a, e, "Failed to parse event for identity update.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public void registerForRegistrationEvents(RegistrationManager.RegistrationEventListener registrationEventListener) {
        C4310e c4310e = this.f5474n;
        if (c4310e != null) {
            c4310e.registerForRegistrationEvents(registrationEventListener);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        C4093b c4093b = this.f5468h;
        AbstractC4092a.a aVar = AbstractC4092a.a.f4317b;
        c4093b.m2868d(aVar);
        this.f5468h.m2869e(aVar);
        this.f5467g.m3036a(this);
        m3925a();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public void unregisterForRegistrationEvents(RegistrationManager.RegistrationEventListener registrationEventListener) {
        C4310e c4310e = this.f5474n;
        if (c4310e != null) {
            c4310e.unregisterForRegistrationEvents(registrationEventListener);
        }
    }

    public C4309d(Context context, MarketingCloudConfig marketingCloudConfig, C4374j c4374j, C4311f c4311f, C4140c c4140c, C4093b c4093b, C4174c c4174c, PushMessageManager pushMessageManager, C4189l c4189l, SFMCSdkComponents sFMCSdkComponents) {
        this.f5464d = context;
        this.f5465e = marketingCloudConfig;
        this.f5466f = c4374j;
        this.f5473m = c4311f;
        this.f5467g = c4140c;
        this.f5468h = c4093b;
        this.f5469i = c4174c;
        this.f5470j = pushMessageManager;
        this.f5471k = c4189l;
        this.f5472l = sFMCSdkComponents;
    }

    /* JADX INFO: renamed from: a */
    private void m3926a(InitializationStatus.C4081a c4081a) {
        this.f5467g.m3037a(this, f5463o);
        this.f5468h.m2861a(this, AbstractC4092a.a.f4317b);
        this.f5469i.m3297a(EnumC4172a.f4823o, this);
        SFMCSdkComponents sFMCSdkComponents = this.f5472l;
        if (sFMCSdkComponents != null) {
            sFMCSdkComponents.getEventManager().subscribe(this);
        }
        try {
            this.f5474n = new C4310e(this.f5464d, this.f5465e, this.f5466f, this.f5473m, this.f5468h, this.f5469i, this.f5470j, this.f5471k, this.f5472l);
        } catch (Exception e) {
            if (c4081a != null) {
                c4081a.m2803a(e);
            }
        }
    }

    C4309d(C4310e c4310e, Context context, MarketingCloudConfig marketingCloudConfig, C4374j c4374j, C4311f c4311f, C4140c c4140c, C4093b c4093b, C4174c c4174c, PushMessageManager pushMessageManager, C4189l c4189l) {
        this.f5474n = c4310e;
        this.f5464d = context;
        this.f5465e = marketingCloudConfig;
        this.f5466f = c4374j;
        this.f5473m = c4311f;
        this.f5467g = c4140c;
        this.f5468h = c4093b;
        this.f5469i = c4174c;
        this.f5470j = pushMessageManager;
        this.f5471k = c4189l;
        this.f5472l = null;
    }

    @Override // com.salesforce.marketingcloud.alarms.C4093b.b
    /* JADX INFO: renamed from: a */
    public final void mo2870a(AbstractC4092a.a aVar) {
        C4310e c4310e;
        if (b.f5476b[aVar.ordinal()] == 1 && (c4310e = this.f5474n) != null) {
            c4310e.m3952e();
        }
    }

    @Override // com.salesforce.marketingcloud.registration.C4310e.f
    /* JADX INFO: renamed from: a */
    public void mo3927a(String str, String str2, Map<String, String> map, Collection<String> collection, boolean z) {
        C4310e c4310e = this.f5474n;
        if (c4310e != null) {
            try {
                c4310e.m3944a(str, str2, map, collection, z);
            } catch (Exception e) {
                C4170g.m3207b(RegistrationManager.f5454a, e, "Error encountered while saving registration", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.http.C4174c.c
    /* JADX INFO: renamed from: a */
    public void mo2932a(C4173b c4173b, C4175d c4175d) {
        if (this.f5474n != null) {
            if (!c4175d.m3307g()) {
                this.f5474n.m3940a(c4175d.m3302b(), c4175d.m3305e());
                return;
            }
            try {
                this.f5474n.m3941a(C4188k.m3391a(new JSONObject(c4173b.m3277o())), c4175d.m3304d());
            } catch (Exception unused) {
                this.f5474n.m3940a(-1, "Failed to convert our Response Body into a Registration.");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static C4175d m3922a(MarketingCloudConfig marketingCloudConfig, Context context, String str, String str2) {
        return EnumC4172a.f4823o.m3250a(marketingCloudConfig, new a(), m3923a(new Registration(0, null, str, null, MarketingCloudSdk.getSdkVersionName(), C4389h.m4319a(context), TimeZone.getDefault().inDaylightTime(new Date()), false, false, Build.VERSION.RELEASE, false, C4393l.m4344b(), null, "Android", String.format(Locale.ENGLISH, "%s %s", Build.MANUFACTURER, Build.MODEL), marketingCloudConfig.applicationId(), Locale.getDefault().toString(), Collections.emptySet(), Collections.emptyMap()), str2)).m3272j();
    }

    /* JADX INFO: renamed from: a */
    static String m3923a(Registration registration, String str) {
        String string;
        try {
            JSONObject jSONObjectPutOpt = C4188k.m3393b(registration).put("registrationDateUtc", C4393l.m4336a(new Date())).put("quietPushEnabled", false).putOpt("registrationId", str);
            if (jSONObjectPutOpt instanceof JSONObject) {
                JSONObject jSONObject = jSONObjectPutOpt;
                string = JSONObjectInstrumentation.toString(jSONObjectPutOpt);
            } else {
                string = jSONObjectPutOpt.toString();
            }
            return string;
        } catch (Exception e) {
            C4170g.m3207b(RegistrationManager.f5454a, e, "Unable to create registration request payload", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3925a() {
        SFMCSdkComponents sFMCSdkComponents = this.f5472l;
        if (sFMCSdkComponents != null) {
            sFMCSdkComponents.getEventManager().unsubscribe(this);
        }
    }
}
