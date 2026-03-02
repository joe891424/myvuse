package com.salesforce.marketingcloud.registration;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationManagerCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4188k;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.salesforce.marketingcloud.util.C4389h;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e */
/* JADX INFO: loaded from: classes6.dex */
class C4310e implements RegistrationManager {

    /* JADX INFO: renamed from: w */
    public static final String f5477w = "Android";

    /* JADX INFO: renamed from: x */
    static final String f5478x = "previousRegistrationHash";

    /* JADX INFO: renamed from: y */
    static final String f5479y = "lastRegistrationSendTimestamp";

    /* JADX INFO: renamed from: d */
    final Set<String> f5480d;

    /* JADX INFO: renamed from: e */
    private final Context f5481e;

    /* JADX INFO: renamed from: f */
    final MarketingCloudConfig f5482f;

    /* JADX INFO: renamed from: g */
    final C4374j f5483g;

    /* JADX INFO: renamed from: h */
    final C4093b f5484h;

    /* JADX INFO: renamed from: i */
    final C4174c f5485i;

    /* JADX INFO: renamed from: j */
    final C4189l f5486j;

    /* JADX INFO: renamed from: k */
    final SFMCSdkComponents f5487k;

    /* JADX INFO: renamed from: l */
    private final Set<RegistrationManager.RegistrationEventListener> f5488l;

    /* JADX INFO: renamed from: m */
    private final C4311f f5489m;

    /* JADX INFO: renamed from: n */
    private ConcurrentHashMap<String, String> f5490n;

    /* JADX INFO: renamed from: o */
    private ConcurrentSkipListSet<String> f5491o;

    /* JADX INFO: renamed from: p */
    private boolean f5492p;

    /* JADX INFO: renamed from: q */
    private boolean f5493q;

    /* JADX INFO: renamed from: r */
    private boolean f5494r;

    /* JADX INFO: renamed from: s */
    private boolean f5495s;

    /* JADX INFO: renamed from: t */
    private String f5496t;

    /* JADX INFO: renamed from: u */
    private String f5497u;

    /* JADX INFO: renamed from: v */
    private String f5498v;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$a */
    class a implements MarketingCloudSdk.WhenReadyListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ boolean f5499a;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$a$a, reason: collision with other inner class name */
        class CountDownTimerC5998a extends e {

            /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$a$a$a, reason: collision with other inner class name */
            class C5999a extends AbstractRunnableC4184g {
                C5999a(String str, Object... objArr) {
                    super(str, objArr);
                }

                @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
                /* JADX INFO: renamed from: a */
                protected void mo2882a() {
                    try {
                        SFMCSdkComponents sFMCSdkComponents = C4310e.this.f5487k;
                        String registrationId = sFMCSdkComponents != null ? sFMCSdkComponents.getRegistrationId() : null;
                        Registration registrationMo4154l = C4310e.this.f5483g.m4244u().mo4154l(C4310e.this.f5483g.mo4218b());
                        C4310e c4310e = C4310e.this;
                        if (C4310e.m3936a(registrationMo4154l, c4310e.f5483g, c4310e.f5482f.delayRegistrationUntilContactKeyIsSet())) {
                            C4310e.this.f5484h.m2868d(AbstractC4092a.a.f4317b);
                            C4310e c4310e2 = C4310e.this;
                            c4310e2.f5485i.m3298a(EnumC4172a.f4823o.m3250a(c4310e2.f5482f, c4310e2.f5483g.mo4220c(), C4309d.m3923a(registrationMo4154l, registrationId)));
                        }
                    } catch (Exception e) {
                        C4170g.m3207b(RegistrationManager.f5454a, e, "Failed to get our Registration from local storage.", new Object[0]);
                    }
                }
            }

            CountDownTimerC5998a(int i) {
                super(i);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                C4310e.this.f5486j.m3399b().execute(new C5999a("registration_request", new Object[0]));
            }
        }

        a(boolean z) {
            this.f5499a = z;
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(MarketingCloudSdk marketingCloudSdk) {
            new CountDownTimerC5998a(this.f5499a ? 1000 : 0).start();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$b */
    class b extends AbstractRunnableC4184g {
        b(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4310e.this.f5483g.m4244u().mo4153c();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$c */
    class c extends AbstractRunnableC4184g {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4310e c4310e = C4310e.this;
            if (C4310e.m3937a(c4310e.f5483g, c4310e.f5482f.delayRegistrationUntilContactKeyIsSet())) {
                C4310e.this.f5484h.m2865b(AbstractC4092a.a.f4317b);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$d */
    static class d implements RegistrationManager.Editor, InterfaceC4308c {

        /* JADX INFO: renamed from: j */
        private static final List<String> f5505j;

        /* JADX INFO: renamed from: a */
        private final Object f5506a = new Object();

        /* JADX INFO: renamed from: b */
        private final Map<String, String> f5507b;

        /* JADX INFO: renamed from: c */
        private final Set<String> f5508c;

        /* JADX INFO: renamed from: d */
        private String f5509d;

        /* JADX INFO: renamed from: e */
        private final f f5510e;

        /* JADX INFO: renamed from: f */
        private String f5511f;

        /* JADX INFO: renamed from: g */
        private final Map<String, String> f5512g;

        /* JADX INFO: renamed from: h */
        private boolean f5513h;

        /* JADX INFO: renamed from: i */
        private boolean f5514i;

        static {
            String[] strArr = {"addressId", "alias", "apId", "backgroundRefreshEnabled", "badge", "channel", "contactId", "contactKey", "createdBy", "createdDate", "customObjectKey", "device", "deviceId", "deviceType", "gcmSenderId", "hardwareId", "isHonorDst", "lastAppOpen", "lastMessageOpen", "lastSend", "locationEnabled", "messageOpenCount", "modifiedBy", "modifiedDate", "optInDate", "optInMethodId", "optInStatusId", "optOutDate", "optOutMethodId", "optOutStatusId", "platform", "platformVersion", "providerToken", "proximityEnabled", "pushAddressExtensionId", "pushApplicationId", RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "sendCount", "source", "sourceObjectId", "status", "systemToken", C4352k.a.f5651e, "utcOffset", "signedString", "quietPushEnabled"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 46; i++) {
                arrayList.add(strArr[i].toLowerCase(Locale.ENGLISH));
            }
            f5505j = Collections.unmodifiableList(arrayList);
        }

        d(f fVar, String str, String str2, ConcurrentHashMap<String, String> concurrentHashMap, ConcurrentSkipListSet<String> concurrentSkipListSet, Set<String> set) {
            Comparator comparator = String.CASE_INSENSITIVE_ORDER;
            this.f5507b = new TreeMap(comparator);
            this.f5508c = new TreeSet(comparator);
            this.f5510e = fVar;
            this.f5509d = str;
            this.f5511f = str2;
            this.f5512g = new C4307b(concurrentHashMap);
            for (String str3 : concurrentSkipListSet) {
                this.f5507b.put(str3, str3);
            }
            this.f5508c.addAll(set);
        }

        /* JADX INFO: renamed from: a */
        private boolean m3956a(String str) {
            if (TextUtils.isEmpty(str)) {
                C4170g.m3216e(RegistrationManager.f5454a, "The attribute you provided was null or empty.", new Object[0]);
                return false;
            }
            String strTrim = str.trim();
            if (TextUtils.isEmpty(strTrim)) {
                C4170g.m3216e(RegistrationManager.f5454a, "The attribute you provided was blank.", new Object[0]);
                return false;
            }
            if (f5505j.contains(strTrim.toLowerCase(Locale.ENGLISH))) {
                C4170g.m3216e(RegistrationManager.f5454a, "Attribute key '%s' is invalid and can not be added.  Please see documentation regarding Attributes and Reserved Words.", strTrim);
                return false;
            }
            if (strTrim.length() <= 128) {
                return true;
            }
            C4170g.m3216e(RegistrationManager.f5454a, "Your attribute key was %s characters long.  Attribute keys are restricted to %s characters.  Your attribute key will be truncated.", Integer.valueOf(strTrim.length()), 128);
            return false;
        }

        /* JADX INFO: renamed from: b */
        private boolean m3957b(String str) {
            if (str != null) {
                return true;
            }
            C4170g.m3206b(RegistrationManager.f5454a, "Attribute value was null and will not be saved.", new Object[0]);
            return false;
        }

        /* JADX INFO: renamed from: c */
        private boolean m3958c(String str) {
            return str == null || TextUtils.getTrimmedLength(str) > 0;
        }

        /* JADX INFO: renamed from: d */
        private String m3959d(String str) {
            if (!TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) != 0) {
                return str.trim();
            }
            C4170g.m3216e(RegistrationManager.f5454a, "An empty or NULL ContactKey will not be transmitted to the Marketing Cloud and was NOT updated with the provided value.", new Object[0]);
            return null;
        }

        /* JADX INFO: renamed from: e */
        private String m3960e(String str) {
            return str != null ? str.trim() : str;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTag(String str) {
            String strM3960e = m3960e(str);
            synchronized (this.f5506a) {
                if (!TextUtils.isEmpty(strM3960e) && !strM3960e.equals(this.f5507b.put(strM3960e, strM3960e))) {
                    this.f5513h = true;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTags(Iterable<String> iterable) {
            if (iterable == null) {
                return this;
            }
            Iterator<String> it2 = iterable.iterator();
            while (it2.hasNext()) {
                addTag(it2.next());
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttribute(String str) {
            return !m3956a(str) ? this : setAttribute(str, "");
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttributes(Iterable<String> iterable) {
            Iterator<String> it2 = iterable.iterator();
            while (it2.hasNext()) {
                clearAttribute(it2.next());
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearTags() {
            synchronized (this.f5506a) {
                if (this.f5507b.keySet().retainAll(this.f5508c)) {
                    this.f5513h = true;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public boolean commit() {
            f fVar;
            synchronized (this.f5506a) {
                if (!this.f5513h || (fVar = this.f5510e) == null) {
                    return false;
                }
                fVar.mo3927a(this.f5509d, this.f5511f, this.f5512g, this.f5507b.values(), this.f5514i);
                return true;
            }
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTag(String str) {
            if (str == null) {
                return this;
            }
            synchronized (this.f5506a) {
                if (!this.f5508c.contains(str) && this.f5507b.remove(str) != null) {
                    this.f5513h = true;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTags(Iterable<String> iterable) {
            if (iterable == null) {
                return this;
            }
            Iterator<String> it2 = iterable.iterator();
            while (it2.hasNext()) {
                removeTag(it2.next());
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        @Deprecated
        public RegistrationManager.Editor setAttribute(String str, String str2) {
            return mo3918a(str, str2, true);
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        @Deprecated
        public RegistrationManager.Editor setContactKey(String str) {
            return mo3920a(str, true);
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor setSignedString(String str) {
            synchronized (this.f5506a) {
                if (m3958c(str)) {
                    this.f5509d = str;
                    this.f5513h = true;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.InterfaceC4308c
        /* JADX INFO: renamed from: a */
        public RegistrationManager.Editor mo3918a(String str, String str2, boolean z) {
            synchronized (this.f5506a) {
                if (m3956a(str) && m3957b(str2)) {
                    this.f5512g.put(str, str2);
                    this.f5513h = true;
                    this.f5514i = z;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor addTags(String... strArr) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    addTag(str);
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor clearAttributes(String... strArr) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    clearAttribute(str);
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.RegistrationManager.Editor
        public RegistrationManager.Editor removeTags(String... strArr) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    removeTag(str);
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.InterfaceC4308c
        /* JADX INFO: renamed from: a */
        public RegistrationManager.Editor mo3920a(String str, boolean z) {
            String strM3959d = m3959d(str);
            if (strM3959d != null) {
                synchronized (this.f5506a) {
                    this.f5513h = true;
                    this.f5514i = z;
                    this.f5511f = strM3959d;
                }
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.InterfaceC4308c
        /* JADX INFO: renamed from: a */
        public RegistrationManager.Editor mo3919a(String str, Map<String, String> map, boolean z) {
            mo3920a(str, z);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mo3918a(entry.getKey(), entry.getValue(), z);
            }
            return this;
        }

        @Override // com.salesforce.marketingcloud.registration.InterfaceC4308c
        /* JADX INFO: renamed from: a */
        public RegistrationManager.Editor mo3921a(Map<String, String> map, boolean z) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mo3918a(entry.getKey(), entry.getValue(), z);
            }
            return this;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$e */
    static abstract class e extends CountDownTimer {
        public e(int i) {
            this(i, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }

        private e(long j, long j2) {
            super(j, j2);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.e$f */
    interface f {
        /* JADX INFO: renamed from: a */
        default void m3961a(String str, String str2, Map<String, String> map, Collection<String> collection) {
            mo3927a(str, str2, map, collection, false);
        }

        /* JADX INFO: renamed from: a */
        void mo3927a(String str, String str2, Map<String, String> map, Collection<String> collection, boolean z);
    }

    C4310e(Context context, MarketingCloudConfig marketingCloudConfig, C4374j c4374j, C4311f c4311f, C4093b c4093b, C4174c c4174c, PushMessageManager pushMessageManager, C4189l c4189l) {
        this(context, marketingCloudConfig, c4374j, c4311f, c4093b, c4174c, pushMessageManager, c4189l, null);
    }

    /* JADX INFO: renamed from: a */
    void m3939a() {
        this.f5483g.mo4222f().edit().remove(EnumC4172a.f4823o.f4834c + "_device").apply();
        m3945a(false);
    }

    /* JADX INFO: renamed from: b */
    void m3947b() {
        boolean zM4322b = C4389h.m4322b(this.f5481e);
        boolean z = zM4322b && C4389h.m4324c(this.f5481e);
        boolean zAreNotificationsEnabled = NotificationManagerCompat.from(this.f5481e).areNotificationsEnabled();
        if (zM4322b == this.f5492p && z == this.f5493q && zAreNotificationsEnabled == this.f5494r) {
            return;
        }
        this.f5492p = zM4322b;
        this.f5493q = z;
        this.f5494r = zAreNotificationsEnabled;
        m3954g();
    }

    /* JADX INFO: renamed from: c */
    void m3949c() {
        this.f5484h.m2868d(AbstractC4092a.a.f4317b);
        m3954g();
    }

    /* JADX INFO: renamed from: d */
    JSONObject m3951d() {
        String strMo3931b;
        Registration registrationM3932a = m3932a(0);
        if (registrationM3932a == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("current_registration", C4188k.m3393b(registrationM3932a));
            if (m3936a(registrationM3932a, this.f5483g, this.f5482f.delayRegistrationUntilContactKeyIsSet()) && (strMo3931b = this.f5483g.mo4220c().mo3931b(InterfaceC4340c.f5566h, null)) != null) {
                jSONObject.put("last_registration_sent", new JSONObject(strMo3931b));
            }
            long j = this.f5483g.mo4222f().getLong(f5479y, 0L);
            if (j > 0) {
                jSONObject.put("last_sent_timestamp", C4393l.m4336a(new Date(j)));
            }
        } catch (JSONException e2) {
            C4170g.m3207b(RegistrationManager.f5454a, e2, "Failed to build our component state JSONObject.", new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: e */
    void m3952e() {
        m3945a(true);
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public RegistrationManager.Editor edit() {
        C4170g.m3202a(RegistrationManager.f5454a, "Changes with this editor will not be saved.", new Object[0]);
        return new d(null, this.f5498v, this.f5496t, this.f5490n, this.f5491o, this.f5480d);
    }

    /* JADX INFO: renamed from: f */
    boolean m3953f() {
        return this.f5495s && NotificationManagerCompat.from(this.f5481e).areNotificationsEnabled();
    }

    /* JADX INFO: renamed from: g */
    void m3954g() {
        m3950c(false);
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public Map<String, String> getAttributes() {
        return new HashMap(this.f5490n);
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getContactKey() {
        return this.f5496t;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getDeviceId() {
        return this.f5489m.m3969f();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getSignedString() {
        return this.f5498v;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public String getSystemToken() {
        return this.f5497u;
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public Set<String> getTags() {
        return new TreeSet((SortedSet) this.f5491o);
    }

    /* JADX INFO: renamed from: h */
    void m3955h() {
        m3954g();
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public void registerForRegistrationEvents(RegistrationManager.RegistrationEventListener registrationEventListener) {
        if (registrationEventListener == null) {
            return;
        }
        synchronized (this.f5488l) {
            this.f5488l.add(registrationEventListener);
        }
    }

    @Override // com.salesforce.marketingcloud.registration.RegistrationManager
    public void unregisterForRegistrationEvents(RegistrationManager.RegistrationEventListener registrationEventListener) {
        synchronized (this.f5488l) {
            this.f5488l.remove(registrationEventListener);
        }
    }

    C4310e(Context context, MarketingCloudConfig marketingCloudConfig, C4374j c4374j, C4311f c4311f, C4093b c4093b, C4174c c4174c, PushMessageManager pushMessageManager, C4189l c4189l, SFMCSdkComponents sFMCSdkComponents) {
        Registration registrationM3932a;
        this.f5488l = new ArraySet();
        this.f5481e = context;
        this.f5482f = marketingCloudConfig;
        this.f5483g = c4374j;
        this.f5489m = c4311f;
        this.f5484h = c4093b;
        this.f5485i = c4174c;
        this.f5486j = c4189l;
        this.f5487k = sFMCSdkComponents;
        TreeSet treeSet = new TreeSet();
        treeSet.add("ALL");
        treeSet.add("Android");
        if (C4393l.m4343a(context)) {
            treeSet.add("DEBUG");
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        this.f5480d = setUnmodifiableSet;
        this.f5495s = pushMessageManager.isPushEnabled();
        boolean zM4322b = C4389h.m4322b(context);
        this.f5492p = zM4322b;
        boolean z = true;
        boolean z2 = false;
        this.f5493q = zM4322b && C4389h.m4324c(context);
        this.f5494r = NotificationManagerCompat.from(context).areNotificationsEnabled();
        this.f5497u = pushMessageManager.getPushToken();
        InterfaceC4340c interfaceC4340cMo4220c = c4374j.mo4220c();
        try {
            Registration registrationMo4154l = c4374j.m4244u().mo4154l(c4374j.mo4218b());
            if (registrationMo4154l == null) {
                this.f5498v = null;
                this.f5496t = interfaceC4340cMo4220c.mo3931b(InterfaceC4340c.f5562d, null);
                this.f5490n = new ConcurrentHashMap<>(C4393l.m4348c(interfaceC4340cMo4220c.mo3931b(InterfaceC4340c.f5560b, "")));
                ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet(C4393l.m4351d(interfaceC4340cMo4220c.mo3931b(InterfaceC4340c.f5561c, "")));
                this.f5491o = concurrentSkipListSet.isEmpty() ? new ConcurrentSkipListSet<>(setUnmodifiableSet) : m3933a((ConcurrentSkipListSet<String>) concurrentSkipListSet, setUnmodifiableSet);
                registrationM3932a = m3932a(0);
                z = false;
            } else {
                this.f5498v = registrationMo4154l.signedString();
                this.f5496t = registrationMo4154l.contactKey();
                this.f5490n = new ConcurrentHashMap<>(registrationMo4154l.attributes());
                this.f5491o = m3933a((ConcurrentSkipListSet<String>) new ConcurrentSkipListSet(registrationMo4154l.tags()), setUnmodifiableSet);
                registrationM3932a = m3932a(C4188k.m3390a(registrationMo4154l));
            }
            m3935a(c4374j, this.f5496t);
            z2 = z;
        } catch (Exception e2) {
            C4170g.m3207b(RegistrationManager.f5454a, e2, "Error trying to get, update or add a registration to local storage.", new Object[0]);
            this.f5491o = new ConcurrentSkipListSet<>(this.f5480d);
            this.f5490n = new ConcurrentHashMap<>();
            this.f5496t = null;
            this.f5498v = null;
            registrationM3932a = m3932a(0);
        }
        c4189l.m3399b().execute(new C4306a(c4374j.m4244u(), c4374j.mo4218b(), registrationM3932a, z2));
        if (m3936a(registrationM3932a, c4374j, marketingCloudConfig.delayRegistrationUntilContactKeyIsSet())) {
            m3952e();
        }
    }

    /* JADX INFO: renamed from: a */
    private static ConcurrentSkipListSet<String> m3933a(ConcurrentSkipListSet<String> concurrentSkipListSet, Set<String> set) {
        if (!concurrentSkipListSet.containsAll(set)) {
            concurrentSkipListSet.addAll(set);
        }
        return concurrentSkipListSet;
    }

    /* JADX INFO: renamed from: b */
    InterfaceC4308c m3946b(f fVar) {
        return new d(fVar, this.f5498v, this.f5496t, this.f5490n, this.f5491o, this.f5480d);
    }

    /* JADX INFO: renamed from: c */
    void m3950c(boolean z) {
        try {
            Registration registrationM3932a = m3932a(0);
            this.f5486j.m3399b().execute(new C4306a(this.f5483g.m4244u(), this.f5483g.mo4218b(), registrationM3932a, false));
            m3935a(this.f5483g, registrationM3932a.contactKey());
            if (m3936a(registrationM3932a, this.f5483g, this.f5482f.delayRegistrationUntilContactKeyIsSet())) {
                SFMCSdkComponents sFMCSdkComponents = this.f5487k;
                if (sFMCSdkComponents != null && z) {
                    if (this.f5496t != null) {
                        sFMCSdkComponents.getIdentity().setProfile(this.f5496t, this.f5490n, ModuleIdentifier.PUSH, new ModuleIdentifier[0]);
                    } else {
                        sFMCSdkComponents.getIdentity().setProfileAttributes(this.f5490n, ModuleIdentifier.PUSH);
                    }
                }
                m3952e();
            }
        } catch (Exception e2) {
            C4170g.m3207b(RegistrationManager.f5454a, e2, "An error occurred trying to save our Registration.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    RegistrationManager.Editor m3938a(f fVar) {
        return new d(fVar, this.f5498v, this.f5496t, this.f5490n, this.f5491o, this.f5480d);
    }

    /* JADX INFO: renamed from: b */
    void m3948b(boolean z) {
        this.f5495s = z;
        m3954g();
    }

    /* JADX INFO: renamed from: a */
    private Registration m3932a(int i) {
        return new Registration(i, this.f5498v, this.f5489m.m3969f(), this.f5497u, this.f5489m.m3973j(), this.f5489m.m3968e(), TimeZone.getDefault().inDaylightTime(new Date()), this.f5492p, this.f5493q, this.f5489m.m3972i(), m3953f(), C4393l.m4344b(), this.f5496t, this.f5489m.m3971h(), this.f5489m.m3970g(), this.f5482f.applicationId(), Locale.getDefault().toString(), this.f5491o, this.f5490n);
    }

    /* JADX INFO: renamed from: a */
    void m3945a(boolean z) {
        MarketingCloudSdk.requestSdk(new a(z));
    }

    /* JADX INFO: renamed from: a */
    void m3941a(Registration registration, Map<String, List<String>> map) {
        EnumC4172a.m3241a(map, this.f5483g.mo4220c());
        this.f5484h.m2866c(AbstractC4092a.a.f4317b);
        synchronized (this.f5488l) {
            for (RegistrationManager.RegistrationEventListener registrationEventListener : this.f5488l) {
                if (registrationEventListener != null) {
                    try {
                        registrationEventListener.onRegistrationReceived(registration);
                    } catch (Exception e2) {
                        C4170g.m3207b(RegistrationManager.f5454a, e2, "%s threw an exception while processing the registration response", registrationEventListener.getClass().getName());
                    }
                }
            }
        }
        JSONObject jSONObjectM3393b = C4188k.m3393b(registration);
        String string = !(jSONObjectM3393b instanceof JSONObject) ? jSONObjectM3393b.toString() : JSONObjectInstrumentation.toString(jSONObjectM3393b);
        this.f5483g.mo4220c().mo3930a(InterfaceC4340c.f5566h, string);
        this.f5483g.mo4222f().edit().putLong(f5479y, System.currentTimeMillis()).putString(f5478x, C4393l.m4346b(string)).apply();
        this.f5486j.m3399b().execute(new b("delete_old_registrations", new Object[0]));
    }

    /* JADX INFO: renamed from: a */
    void m3943a(String str, String str2, Map<String, String> map, Collection<String> collection) throws Exception {
        m3944a(str, str2, map, collection, false);
    }

    /* JADX INFO: renamed from: a */
    void m3944a(String str, String str2, Map<String, String> map, Collection<String> collection, boolean z) throws Exception {
        this.f5498v = str;
        this.f5496t = str2;
        this.f5490n.clear();
        this.f5490n.putAll(map);
        this.f5491o.clear();
        this.f5491o.addAll(collection);
        this.f5484h.m2866c(AbstractC4092a.a.f4317b);
        m3950c(z);
    }

    /* JADX INFO: renamed from: a */
    void m3940a(int i, String str) {
        C4170g.m3202a(RegistrationManager.f5454a, "%s: %s", Integer.valueOf(i), str);
        this.f5486j.m3399b().execute(new c("schedule_registration_retry", new Object[0]));
    }

    /* JADX INFO: renamed from: a */
    private void m3935a(C4374j c4374j, String str) {
        c4374j.mo4220c().mo3930a(InterfaceC4340c.f5562d, str);
    }

    /* JADX INFO: renamed from: a */
    static boolean m3936a(Registration registration, C4374j c4374j, boolean z) {
        if (registration == null) {
            return false;
        }
        if (registration.contactKey() == null && z) {
            C4170g.m3216e(RegistrationManager.f5454a, "You have delayRegistrationUntilContactKeyIsSet set to `true.`  The SDK will not send a registration to the Marketing Cloud until a contact key has been set.", new Object[0]);
            return false;
        }
        String string = c4374j.mo4222f().getString(f5478x, null);
        if (string != null) {
            JSONObject jSONObjectM3393b = C4188k.m3393b(registration);
            if (C4393l.m4346b(!(jSONObjectM3393b instanceof JSONObject) ? jSONObjectM3393b.toString() : JSONObjectInstrumentation.toString(jSONObjectM3393b)).equals(string)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    static boolean m3937a(C4374j c4374j, boolean z) {
        try {
            return m3936a(c4374j.m4244u().mo4154l(c4374j.mo4218b()), c4374j, z);
        } catch (Exception e2) {
            C4170g.m3207b(RegistrationManager.f5454a, e2, "Failed to get Registration from local storage or we can not determine if this Registration contains any changes.", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    static void m3934a(C4374j c4374j, C4093b c4093b, boolean z) {
        if (z) {
            c4374j.m4244u().mo4155n();
            c4374j.mo4220c().mo3929a(InterfaceC4340c.f5562d);
        }
        c4093b.m2868d(AbstractC4092a.a.f4317b);
    }

    /* JADX INFO: renamed from: a */
    void m3942a(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f5497u)) {
            return;
        }
        this.f5497u = str;
        m3954g();
    }
}
