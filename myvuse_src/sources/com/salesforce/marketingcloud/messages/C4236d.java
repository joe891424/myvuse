package com.salesforce.marketingcloud.messages;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.collection.ArraySet;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.InterfaceC4147e;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.behaviors.InterfaceC4139b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4183f;
import com.salesforce.marketingcloud.internal.C4185h;
import com.salesforce.marketingcloud.internal.C4187j;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.location.AbstractC4200f;
import com.salesforce.marketingcloud.location.C4196b;
import com.salesforce.marketingcloud.location.InterfaceC4197c;
import com.salesforce.marketingcloud.location.InterfaceC4199e;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.InterfaceC4235c;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.geofence.C4238a;
import com.salesforce.marketingcloud.messages.geofence.GeofenceMessageResponse;
import com.salesforce.marketingcloud.messages.proximity.C4267a;
import com.salesforce.marketingcloud.messages.proximity.ProximityMessageResponse;
import com.salesforce.marketingcloud.notifications.C4273a;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.proximity.AbstractC4280e;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4376l;
import com.salesforce.marketingcloud.toggles.EnumC4380a;
import com.salesforce.marketingcloud.util.C4385d;
import com.salesforce.marketingcloud.util.C4389h;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d */
/* JADX INFO: loaded from: classes6.dex */
public class C4236d implements InterfaceC4147e, RegionMessageManager, C4093b.b, InterfaceC4199e, InterfaceC4139b, InterfaceC4235c.b, InterfaceC4235c.a, InterfaceC4197c {

    /* JADX INFO: renamed from: B */
    private static final float f5147B = 0.8f;

    /* JADX INFO: renamed from: w */
    static final String f5149w = "et_geo_enabled_key";

    /* JADX INFO: renamed from: x */
    static final String f5150x = "et_region_message_toggled_key";

    /* JADX INFO: renamed from: y */
    static final String f5151y = "et_proximity_enabled_key";

    /* JADX INFO: renamed from: z */
    static final int f5152z = 5000;

    /* JADX INFO: renamed from: d */
    final C4374j f5153d;

    /* JADX INFO: renamed from: e */
    private final C4093b f5154e;

    /* JADX INFO: renamed from: f */
    private final AbstractC4200f f5155f;

    /* JADX INFO: renamed from: g */
    private final AbstractC4280e f5156g;

    /* JADX INFO: renamed from: h */
    private final MarketingCloudConfig f5157h;

    /* JADX INFO: renamed from: i */
    private final String f5158i;

    /* JADX INFO: renamed from: j */
    private final Context f5159j;

    /* JADX INFO: renamed from: k */
    private final C4273a f5160k;

    /* JADX INFO: renamed from: l */
    private final C4140c f5161l;

    /* JADX INFO: renamed from: m */
    private final C4174c f5162m;

    /* JADX INFO: renamed from: n */
    private final Set<RegionMessageManager.GeofenceMessageResponseListener> f5163n = new ArraySet();

    /* JADX INFO: renamed from: o */
    private final Set<RegionMessageManager.ProximityMessageResponseListener> f5164o = new ArraySet();

    /* JADX INFO: renamed from: p */
    private final Set<RegionMessageManager.RegionTransitionEventListener> f5165p;

    /* JADX INFO: renamed from: q */
    private final AtomicBoolean f5166q;

    /* JADX INFO: renamed from: r */
    private final C4189l f5167r;

    /* JADX INFO: renamed from: s */
    private C4238a f5168s;

    /* JADX INFO: renamed from: t */
    private C4267a f5169t;

    /* JADX INFO: renamed from: u */
    private EnumC4380a f5170u;

    /* JADX INFO: renamed from: v */
    private EnumC4380a f5171v;

    /* JADX INFO: renamed from: A */
    private static final String f5146A = "RegionMessageManager";

    /* JADX INFO: renamed from: C */
    static final String f5148C = C4170g.m3197a(f5146A);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d$a */
    class a extends AbstractRunnableC4184g {
        a(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            LatLon latLonMo4112f;
            C4374j c4374j = C4236d.this.f5153d;
            if (c4374j == null || (latLonMo4112f = c4374j.m4241r().mo4112f(C4236d.this.f5153d.mo4218b())) == null) {
                return;
            }
            C4236d.this.m3670a(latLonMo4112f);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d$b */
    class b extends AbstractRunnableC4184g {
        b(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            LatLon latLonMo4112f;
            C4374j c4374j = C4236d.this.f5153d;
            if (c4374j == null || (latLonMo4112f = c4374j.m4241r().mo4112f(C4236d.this.f5153d.mo4218b())) == null) {
                return;
            }
            C4236d.this.m3673b(latLonMo4112f);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d$c */
    class c extends AbstractRunnableC4184g {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4236d.this.f5153d.m4243t().mo4144l();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d$d */
    class d extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ LatLon f5175b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, LatLon latLon) {
            super(str, objArr);
            this.f5175b = latLon;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            try {
                C4236d c4236d = C4236d.this;
                boolean zM3672a = c4236d.m3672a(this.f5175b, c4236d.f5153d.m4243t().mo4145m(C4236d.this.f5153d.mo4218b()));
                C4236d.this.f5153d.m4241r().mo4111a(this.f5175b, C4236d.this.f5153d.mo4218b());
                if (zM3672a) {
                    C4236d.this.m3671a(this.f5175b, 5000);
                    C4236d.this.m3670a(this.f5175b);
                    C4236d.this.m3673b(this.f5175b);
                }
            } catch (Exception e) {
                C4170g.m3207b(C4236d.f5148C, e, "Unable to store last location", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d$e */
    class e extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Region f5177b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, Region region) {
            super(str, objArr);
            this.f5177b = region;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            try {
                C4236d.this.f5153d.m4243t().mo4139a(this.f5177b, C4236d.this.f5153d.mo4218b());
            } catch (Exception e) {
                C4170g.m3207b(C4236d.f5148C, e, "Unable to set magic region", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d$f */
    class f implements C4273a.b {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Message f5179a;

        f(Message message) {
            this.f5179a = message;
        }

        @Override // com.salesforce.marketingcloud.notifications.C4273a.b
        /* JADX INFO: renamed from: a */
        public void mo3675a(int i) {
            if (i != -1) {
                try {
                    C4183f.m3357a(this.f5179a, i);
                    C4236d.this.f5153d.m4242s().mo4125a(this.f5179a, C4236d.this.f5153d.mo4218b());
                } catch (Exception e) {
                    C4170g.m3207b(C4236d.f5148C, e, "Unable to update message id with notification id.", new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.d$g */
    static /* synthetic */ class g {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5181a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f5182b;

        static {
            int[] iArr = new int[EnumC4138a.values().length];
            f5182b = iArr;
            try {
                iArr[EnumC4138a.BEHAVIOR_DEVICE_BOOT_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5182b[EnumC4138a.BEHAVIOR_APP_PACKAGE_REPLACED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5182b[EnumC4138a.BEHAVIOR_DEVICE_SHUTDOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5182b[EnumC4138a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[AbstractC4092a.a.values().length];
            f5181a = iArr2;
            try {
                iArr2[AbstractC4092a.a.f4319d.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C4236d(Context context, MarketingCloudConfig marketingCloudConfig, C4374j c4374j, String str, AbstractC4200f abstractC4200f, AbstractC4280e abstractC4280e, C4140c c4140c, C4093b c4093b, C4174c c4174c, C4273a c4273a, C4189l c4189l, RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        ArraySet arraySet = new ArraySet();
        this.f5165p = arraySet;
        this.f5166q = new AtomicBoolean(false);
        this.f5159j = context;
        this.f5153d = c4374j;
        this.f5155f = abstractC4200f;
        this.f5156g = abstractC4280e;
        this.f5160k = c4273a;
        this.f5154e = c4093b;
        this.f5161l = c4140c;
        this.f5162m = c4174c;
        this.f5158i = str;
        this.f5157h = marketingCloudConfig;
        arraySet.add(regionTransitionEventListener);
        this.f5167r = c4189l;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3654a(boolean z) {
        if (C4137b.m3024a(C4137b.m3022a(this.f5153d.m4238o()), 32)) {
            return false;
        }
        if (!z && isGeofenceMessagingEnabled()) {
            C4170g.m3202a(f5148C, "Geofence messaging is already enabled", new Object[0]);
            return false;
        }
        C4238a c4238a = this.f5168s;
        if (c4238a != null && !c4238a.m3681d()) {
            C4170g.m3202a(f5148C, "Geofence messaging was not enabled due to device limitation.", new Object[0]);
            return false;
        }
        if (C4389h.m4322b(this.f5159j)) {
            return true;
        }
        m3665f();
        return false;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3658b(boolean z) {
        if (C4137b.m3024a(C4137b.m3022a(this.f5153d.m4238o()), 64)) {
            return false;
        }
        if (!z && isProximityMessagingEnabled()) {
            C4170g.m3202a(f5148C, "Proximity messaging is already enabled.", new Object[0]);
            return false;
        }
        if (this.f5169t == null) {
            C4170g.m3202a(f5148C, "Proximity messaging was not enabled while configuring the SDK.  Messaging will not be enabled.", new Object[0]);
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31 && this.f5157h.proximityNotificationCustomizationOptions() == null) {
            C4170g.m3202a(f5148C, "Proximity messaging configuration is not passed while configuring the SDK.  Messaging will not be enabled.", new Object[0]);
            return false;
        }
        if (!this.f5169t.m3822d() || !this.f5155f.mo3493a()) {
            C4170g.m3202a(f5148C, "Proximity messaging was not enabled due to device limitation.", new Object[0]);
            return false;
        }
        if (!C4389h.m4322b(this.f5159j)) {
            m3665f();
            return false;
        }
        if (C4389h.m4324c(this.f5159j)) {
            return true;
        }
        m3664e();
        return false;
    }

    /* JADX INFO: renamed from: c */
    private synchronized boolean m3661c(boolean z) {
        if (!C4385d.m4263b()) {
            C4170g.m3216e(f5148C, "GooglePlayServices Location dependency missing from build.", new Object[0]);
            return false;
        }
        if (!m3654a(z)) {
            return false;
        }
        C4170g.m3213d(f5148C, "Enabling geofence messaging", new Object[0]);
        if (!z) {
            this.f5153d.mo4222f().edit().putBoolean(f5149w, true).apply();
            this.f5153d.mo4222f().edit().putBoolean(f5150x, true).apply();
            this.f5170u = EnumC4380a.f5739b;
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, true);
            C4140c.m3035a(this.f5159j, EnumC4138a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, bundle);
        }
        this.f5168s.mo3642a();
        return m3660c();
    }

    /* JADX INFO: renamed from: d */
    private boolean m3663d(boolean z) {
        if (!C4385d.m4262a()) {
            C4170g.m3216e(f5148C, "If you wish to use proximity messenger then you need to add the AltBeacon dependency.", new Object[0]);
            return false;
        }
        if (!m3658b(z)) {
            return false;
        }
        C4170g.m3213d(f5148C, "Enabling proximity messaging.", new Object[0]);
        if (z) {
            this.f5169t.mo3645c();
        } else {
            C4374j c4374j = this.f5153d;
            if (c4374j != null) {
                c4374j.mo4222f().edit().putBoolean(f5151y, true).apply();
                this.f5153d.mo4222f().edit().putBoolean(f5150x, true).apply();
            }
            this.f5171v = EnumC4380a.f5739b;
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, true);
            C4140c.m3035a(this.f5159j, EnumC4138a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, bundle);
        }
        this.f5169t.mo3642a();
        return m3660c();
    }

    /* JADX INFO: renamed from: e */
    private void m3664e() {
        if (Build.VERSION.SDK_INT >= 31) {
            C4170g.m3202a(f5148C, "Missing %s or %s", "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        }
    }

    /* JADX INFO: renamed from: f */
    private void m3665f() {
        if (Build.VERSION.SDK_INT < 29) {
            C4170g.m3202a(f5148C, "Missing %s", "android.permission.ACCESS_FINE_LOCATION");
        } else {
            C4170g.m3202a(f5148C, "Missing %s or %s", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION");
        }
    }

    /* JADX INFO: renamed from: g */
    private void m3666g() {
        if (isGeofenceMessagingEnabled() && m3654a(true)) {
            this.f5168s.mo3645c();
        }
        if (isProximityMessagingEnabled() && m3658b(true)) {
            this.f5169t.mo3645c();
        }
    }

    /* JADX INFO: renamed from: h */
    private void m3667h() {
        this.f5167r.m3399b().execute(new c("reset_flags", new Object[0]));
    }

    /* JADX INFO: renamed from: i */
    private void m3668i() {
        if (isGeofenceMessagingEnabled()) {
            this.f5167r.m3399b().execute(new a("update_geofence", new Object[0]));
        }
    }

    /* JADX INFO: renamed from: j */
    private void m3669j() {
        if (isProximityMessagingEnabled()) {
            this.f5167r.m3399b().execute(new b("update_proximity", new Object[0]));
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return f5146A;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("geofenceMessagingEnabled", isGeofenceMessagingEnabled());
            jSONObject.put("proximityMessagingEnabled", isProximityMessagingEnabled());
            InterfaceC4376l interfaceC4376lM4243t = this.f5153d.m4243t();
            InterfaceC4384c interfaceC4384cMo4218b = this.f5153d.mo4218b();
            if (interfaceC4376lM4243t != null) {
                Region regionMo4145m = interfaceC4376lM4243t.mo4145m(interfaceC4384cMo4218b);
                if (regionMo4145m != null) {
                    jSONObject.put("magic_fence", regionMo4145m);
                }
                jSONObject.put("geofence_regions", interfaceC4376lM4243t.mo4138a(1, interfaceC4384cMo4218b));
                jSONObject.put("geofence_region_messages", this.f5153d.m4242s().mo4124a(interfaceC4384cMo4218b));
                jSONObject.put("proximity_regions", interfaceC4376lM4243t.mo4138a(3, interfaceC4384cMo4218b));
                jSONObject.put("proximity_region_messages", this.f5153d.m4242s().mo4126b(interfaceC4384cMo4218b));
                jSONObject.put("boot_complete_permission", C4389h.m4320a(this.f5159j, "android.permission.RECEIVE_BOOT_COMPLETED"));
            }
        } catch (Exception e2) {
            C4170g.m3203a(f5148C, e2, "Error creating RegionMessageManager state.", new Object[0]);
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public final synchronized void controlChannelInit(int i) {
        if (C4137b.m3024a(i, 32)) {
            disableGeofenceMessaging();
            this.f5168s = null;
            C4238a.m3679a(this.f5153d, this.f5155f, this.f5162m, C4137b.m3027c(i, 32));
        } else if (this.f5168s == null && this.f5157h.geofencingEnabled()) {
            m3653a((InitializationStatus.C4081a) null, i);
        }
        if (C4137b.m3024a(i, 64)) {
            disableProximityMessaging();
            this.f5169t = null;
            C4267a.m3818a(this.f5153d, this.f5156g, this.f5162m, C4137b.m3027c(i, 64));
        } else if (this.f5169t == null && this.f5157h.proximityEnabled()) {
            m3656b(null, i);
        }
        if (C4137b.m3024a(i, 96)) {
            this.f5155f.mo3461b((InterfaceC4197c) this);
            this.f5155f.mo3462b((InterfaceC4199e) this);
            this.f5161l.m3036a(this);
            this.f5153d.m4241r().mo4113g();
            C4093b c4093b = this.f5154e;
            AbstractC4092a.a aVar = AbstractC4092a.a.f4319d;
            c4093b.m2869e(aVar);
            this.f5154e.m2868d(aVar);
        } else {
            this.f5161l.m3037a(this, EnumSet.of(EnumC4138a.BEHAVIOR_DEVICE_BOOT_COMPLETE, EnumC4138a.BEHAVIOR_APP_PACKAGE_REPLACED, EnumC4138a.BEHAVIOR_DEVICE_SHUTDOWN, EnumC4138a.BEHAVIOR_APP_FOREGROUNDED));
            this.f5155f.mo3456a((InterfaceC4197c) this);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final synchronized void disableGeofenceMessaging() {
        C4170g.m3202a(f5148C, "Disabling geofence messaging", new Object[0]);
        if (isGeofenceMessagingEnabled()) {
            C4374j c4374j = this.f5153d;
            if (c4374j != null) {
                c4374j.mo4222f().edit().putBoolean(f5149w, false).apply();
            }
            this.f5170u = EnumC4380a.f5740c;
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, false);
            C4140c.m3035a(this.f5159j, EnumC4138a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, bundle);
            C4238a c4238a = this.f5168s;
            if (c4238a != null) {
                c4238a.mo3644b();
            }
        }
        m3651a();
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final synchronized void disableProximityMessaging() {
        C4170g.m3202a(f5148C, "Disabling proximity messaging", new Object[0]);
        if (isProximityMessagingEnabled()) {
            C4374j c4374j = this.f5153d;
            if (c4374j != null) {
                c4374j.mo4222f().edit().putBoolean(f5151y, false).apply();
            }
            this.f5171v = EnumC4380a.f5740c;
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, false);
            C4140c.m3035a(this.f5159j, EnumC4138a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, bundle);
            C4267a c4267a = this.f5169t;
            if (c4267a != null) {
                c4267a.mo3644b();
            }
        }
        m3651a();
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final synchronized boolean enableGeofenceMessaging() {
        return m3661c(false);
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final synchronized boolean enableProximityMessaging() {
        return m3663d(false);
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public final synchronized void init(InitializationStatus.C4081a c4081a, int i) {
        m3653a(c4081a, i);
        m3656b(c4081a, i);
        if (this.f5168s != null || this.f5169t != null) {
            this.f5161l.m3037a(this, EnumSet.of(EnumC4138a.BEHAVIOR_DEVICE_BOOT_COMPLETE, EnumC4138a.BEHAVIOR_APP_PACKAGE_REPLACED, EnumC4138a.BEHAVIOR_DEVICE_SHUTDOWN, EnumC4138a.BEHAVIOR_APP_FOREGROUNDED));
            this.f5155f.mo3456a((InterfaceC4197c) this);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final boolean isGeofenceMessagingEnabled() {
        if (C4137b.m3024a(C4137b.m3022a(this.f5153d.m4238o()), 32)) {
            return false;
        }
        if (this.f5170u == null) {
            this.f5170u = m3650a(f5149w, (EnumC4380a) null);
        }
        EnumC4380a enumC4380a = this.f5170u;
        return enumC4380a == EnumC4380a.f5739b || (enumC4380a == EnumC4380a.f5738a && this.f5157h.geofencingEnabled());
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final boolean isProximityMessagingEnabled() {
        if (C4137b.m3024a(C4137b.m3022a(this.f5153d.m4238o()), 64)) {
            return false;
        }
        if (this.f5171v == null) {
            this.f5171v = m3650a(f5151y, (EnumC4380a) null);
        }
        EnumC4380a enumC4380a = this.f5171v;
        return enumC4380a == EnumC4380a.f5739b || (enumC4380a == EnumC4380a.f5738a && this.f5157h.proximityEnabled());
    }

    @Override // com.salesforce.marketingcloud.behaviors.InterfaceC4139b
    public final void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        if (enumC4138a == null) {
            return;
        }
        int i = g.f5182b[enumC4138a.ordinal()];
        if (i == 1) {
            m3667h();
        } else if (i != 2) {
            if (i == 3) {
                m3667h();
                return;
            }
            if (i != 4) {
                return;
            }
            m3668i();
            m3669j();
            if (isGeofenceMessagingEnabled() || isProximityMessagingEnabled()) {
                C4093b c4093b = this.f5154e;
                AbstractC4092a.a aVar = AbstractC4092a.a.f4319d;
                c4093b.m2868d(aVar);
                this.f5154e.m2865b(aVar);
                return;
            }
            return;
        }
        m3666g();
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void registerGeofenceMessageResponseListener(RegionMessageManager.GeofenceMessageResponseListener geofenceMessageResponseListener) {
        if (geofenceMessageResponseListener != null) {
            synchronized (this.f5163n) {
                this.f5163n.add(geofenceMessageResponseListener);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void registerProximityMessageResponseListener(RegionMessageManager.ProximityMessageResponseListener proximityMessageResponseListener) {
        if (proximityMessageResponseListener != null) {
            synchronized (this.f5164o) {
                this.f5164o.add(proximityMessageResponseListener);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void registerRegionTransitionEventListener(RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        if (regionTransitionEventListener != null) {
            synchronized (this.f5165p) {
                this.f5165p.add(regionTransitionEventListener);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void unregisterGeofenceMessageResponseListener(RegionMessageManager.GeofenceMessageResponseListener geofenceMessageResponseListener) {
        synchronized (this.f5163n) {
            this.f5163n.remove(geofenceMessageResponseListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void unregisterProximityMessageResponseListener(RegionMessageManager.ProximityMessageResponseListener proximityMessageResponseListener) {
        synchronized (this.f5164o) {
            this.f5164o.remove(proximityMessageResponseListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.RegionMessageManager
    public final void unregisterRegionTransitionEventListener(RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        synchronized (this.f5165p) {
            this.f5165p.remove(regionTransitionEventListener);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3651a() {
        if (isProximityMessagingEnabled() || isGeofenceMessagingEnabled()) {
            return;
        }
        this.f5154e.m2868d(AbstractC4092a.a.f4319d);
    }

    /* JADX INFO: renamed from: b */
    private void m3655b() {
        disableProximityMessaging();
        disableGeofenceMessaging();
    }

    /* JADX INFO: renamed from: c */
    private boolean m3660c() {
        if (this.f5168s == null && this.f5169t == null) {
            return false;
        }
        if (this.f5166q.compareAndSet(false, true)) {
            try {
                this.f5155f.mo3457a((InterfaceC4199e) this);
            } catch (Exception e2) {
                C4170g.m3207b(f5148C, e2, "Unable to request location update", new Object[0]);
                m3655b();
                return false;
            }
        }
        this.f5154e.m2865b(AbstractC4092a.a.f4319d);
        return true;
    }

    /* JADX INFO: renamed from: d */
    boolean m3674d() {
        C4374j c4374j;
        return (isProximityMessagingEnabled() || isGeofenceMessagingEnabled()) && (c4374j = this.f5153d) != null && c4374j.mo4222f().getBoolean(f5150x, false);
    }

    /* JADX INFO: renamed from: a */
    private EnumC4380a m3650a(String str, EnumC4380a enumC4380a) {
        return enumC4380a == null ? this.f5153d.mo4222f().getBoolean(str, false) ? EnumC4380a.f5739b : EnumC4380a.f5740c : enumC4380a;
    }

    /* JADX INFO: renamed from: b */
    private void m3656b(InitializationStatus.C4081a c4081a, int i) {
        if (C4137b.m3024a(i, 64)) {
            return;
        }
        this.f5169t = new C4267a(this.f5153d, this.f5156g, this.f5162m, this.f5167r, this);
        this.f5154e.m2861a(this, AbstractC4092a.a.f4319d);
        if (isProximityMessagingEnabled()) {
            if (!m3663d(true)) {
                disableProximityMessaging();
            }
            if (c4081a != null) {
                c4081a.m2807c(!C4389h.m4322b(this.f5159j));
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private static C4196b m3659c(Region region) {
        return new C4196b(region.m3630id(), f5147B * region.radius(), region.center().latitude(), region.center().longitude(), 2);
    }

    /* JADX INFO: renamed from: d */
    private void m3662d(Region region) {
        this.f5167r.m3399b().execute(new e("storing_fence", new Object[0], region));
    }

    /* JADX INFO: renamed from: a */
    private void m3653a(InitializationStatus.C4081a c4081a, int i) {
        if (C4137b.m3024a(i, 32)) {
            return;
        }
        this.f5168s = new C4238a(this.f5153d, this.f5155f, this.f5162m, this.f5167r, this);
        this.f5154e.m2861a(this, AbstractC4092a.a.f4319d);
        if (isGeofenceMessagingEnabled()) {
            if (!m3661c(true)) {
                disableGeofenceMessaging();
            }
            if (c4081a != null) {
                c4081a.m2807c(!C4389h.m4322b(this.f5159j));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3657b(MessageResponse messageResponse) {
        if (messageResponse instanceof GeofenceMessageResponse) {
            synchronized (this.f5163n) {
                if (!this.f5163n.isEmpty()) {
                    for (RegionMessageManager.GeofenceMessageResponseListener geofenceMessageResponseListener : this.f5163n) {
                        if (geofenceMessageResponseListener != null) {
                            try {
                                geofenceMessageResponseListener.onGeofenceMessageResponse((GeofenceMessageResponse) messageResponse);
                            } catch (Exception e2) {
                                C4170g.m3207b(f5148C, e2, "%s threw an exception while processing the geofence response", geofenceMessageResponseListener.getClass().getName());
                            }
                        }
                    }
                }
            }
            return;
        }
        if (messageResponse instanceof ProximityMessageResponse) {
            synchronized (this.f5164o) {
                if (!this.f5164o.isEmpty()) {
                    for (RegionMessageManager.ProximityMessageResponseListener proximityMessageResponseListener : this.f5164o) {
                        if (proximityMessageResponseListener != null) {
                            try {
                                proximityMessageResponseListener.onProximityMessageResponse((ProximityMessageResponse) messageResponse);
                            } catch (Exception e3) {
                                C4170g.m3207b(f5148C, e3, "%s threw an exception while processing the proximity response", proximityMessageResponseListener.getClass().getName());
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3652a(int i, Region region) {
        synchronized (this.f5165p) {
            if (!this.f5165p.isEmpty()) {
                for (RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener : this.f5165p) {
                    if (regionTransitionEventListener != null) {
                        try {
                            regionTransitionEventListener.onTransitionEvent(i, region);
                        } catch (Exception e2) {
                            C4170g.m3207b(f5148C, e2, "%s threw an exception while processing the region (%s) transition (%d)", regionTransitionEventListener.getClass().getName(), region.m3630id(), Integer.valueOf(i));
                        }
                    }
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c.a
    /* JADX INFO: renamed from: b */
    public void mo3648b(Region region) {
        m3652a(1, region);
    }

    @Override // com.salesforce.marketingcloud.alarms.C4093b.b
    /* JADX INFO: renamed from: a */
    public final void mo2870a(AbstractC4092a.a aVar) {
        if (g.f5181a[aVar.ordinal()] != 1) {
            return;
        }
        m3668i();
        m3669j();
        if (isGeofenceMessagingEnabled() || isProximityMessagingEnabled()) {
            this.f5154e.m2865b(AbstractC4092a.a.f4319d);
        }
    }

    /* JADX INFO: renamed from: b */
    void m3673b(LatLon latLon) {
        C4267a c4267a;
        if (!isProximityMessagingEnabled() || (c4267a = this.f5169t) == null || latLon == null) {
            C4170g.m3202a(f5148C, "Tried to update proximity messages, but was not enabled.", new Object[0]);
        } else {
            c4267a.mo3643a(latLon, this.f5158i, this.f5157h, this);
        }
    }

    @Override // com.salesforce.marketingcloud.location.InterfaceC4199e
    /* JADX INFO: renamed from: a */
    public void mo3485a(Location location) {
        this.f5166q.set(false);
        if (location == null) {
            return;
        }
        try {
            this.f5167r.m3399b().execute(new d("store_latlon", new Object[0], new LatLon(location.getLatitude(), location.getLongitude())));
        } catch (Exception e2) {
            C4170g.m3207b(f5148C, e2, "Unable to make geofence message request after location update", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c.b
    /* JADX INFO: renamed from: a */
    public final void mo3649a(MessageResponse messageResponse) {
        if (messageResponse == null) {
            return;
        }
        m3657b(messageResponse);
        try {
            Region regionM3384a = C4187j.m3384a(messageResponse.getRefreshCenter(), messageResponse.getRefreshRadius());
            m3662d(regionM3384a);
            this.f5155f.mo3459a(m3659c(regionM3384a));
        } catch (Exception e2) {
            C4170g.m3207b(f5148C, e2, "Failed to updated radius for magic region.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.location.InterfaceC4197c
    /* JADX INFO: renamed from: a */
    public final void mo3475a(int i, String str) {
        C4170g.m3202a(f5148C, "Region error %d - %s", Integer.valueOf(i), str);
    }

    @Override // com.salesforce.marketingcloud.location.InterfaceC4197c
    /* JADX INFO: renamed from: a */
    public final void mo3476a(String str, int i, Location location) {
        if (i == 2 && Region.MAGIC_REGION_ID.equals(str)) {
            String str2 = f5148C;
            C4170g.m3213d(str2, "MagicRegion exited", new Object[0]);
            if (!C4389h.m4322b(this.f5159j)) {
                C4170g.m3202a(str2, "MagicRegion exited, but was missing location permission.", new Object[0]);
                m3655b();
            } else if (location != null) {
                mo3485a(location);
            } else {
                this.f5155f.mo3457a((InterfaceC4199e) this);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c.a
    /* JADX INFO: renamed from: a */
    public void mo3646a(Region region) {
        m3652a(2, region);
    }

    /* JADX INFO: renamed from: a */
    void m3671a(LatLon latLon, int i) {
        if (C4389h.m4322b(this.f5159j)) {
            Region regionM3384a = C4187j.m3384a(latLon, i);
            m3662d(regionM3384a);
            this.f5155f.mo3459a(m3659c(regionM3384a));
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m3672a(LatLon latLon, Region region) {
        boolean z = true;
        if (region != null) {
            try {
                float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
                Location.distanceBetween(latLon.latitude(), latLon.longitude(), region.center().latitude(), region.center().longitude(), fArr);
                if (!m3674d()) {
                    if (fArr[0] <= region.radius() * f5147B) {
                        z = false;
                    }
                }
            } catch (Exception unused) {
                C4170g.m3206b(f5148C, "An error occurred while calculating distance between last known location and the current location.", new Object[0]);
            }
        }
        C4374j c4374j = this.f5153d;
        if (c4374j != null) {
            c4374j.mo4222f().edit().remove(f5150x).apply();
        }
        return z;
    }

    @Override // com.salesforce.marketingcloud.messages.InterfaceC4235c.a
    /* JADX INFO: renamed from: a */
    public final void mo3647a(Region region, Message message) {
        if (region == null || message == null) {
            return;
        }
        C4170g.m3213d(f5148C, "showMessage(%s, %s)", region.m3630id(), message.m3624id());
        NotificationMessage notificationMessageM3376a = C4185h.m3376a(message, region);
        if (notificationMessageM3376a == null || !C4234b.m3641c(message)) {
            return;
        }
        try {
            C4234b.m3637a(message, this.f5153d);
            this.f5160k.m3860a(notificationMessageM3376a, new f(message));
        } catch (Exception e2) {
            C4170g.m3207b(f5148C, e2, "Failed to show message", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3670a(LatLon latLon) {
        C4238a c4238a;
        if (!isGeofenceMessagingEnabled() || (c4238a = this.f5168s) == null || latLon == null) {
            C4170g.m3202a(f5148C, "Tried to update geofence messages, but was not enabled.", new Object[0]);
        } else {
            c4238a.mo3643a(latLon, this.f5158i, this.f5157h, this);
        }
    }
}
