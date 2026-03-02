package com.salesforce.marketingcloud.analytics;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.registration.C4311f;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.e */
/* JADX INFO: loaded from: classes6.dex */
public final class C4106e {

    /* JADX INFO: renamed from: a */
    private final C4311f f4391a;

    /* JADX INFO: renamed from: b */
    private final PushMessageManager f4392b;

    /* JADX INFO: renamed from: c */
    private final boolean f4393c;

    /* JADX INFO: renamed from: d */
    private final Identity f4394d;

    public C4106e(C4311f registrationMeta, PushMessageManager pushMessageManager, boolean z, Identity identity) {
        Intrinsics.checkNotNullParameter(registrationMeta, "registrationMeta");
        this.f4391a = registrationMeta;
        this.f4392b = pushMessageManager;
        this.f4393c = z;
        this.f4394d = identity;
    }

    /* JADX INFO: renamed from: a */
    private final C4311f m2908a() {
        return this.f4391a;
    }

    /* JADX INFO: renamed from: b */
    private final PushMessageManager m2909b() {
        return this.f4392b;
    }

    /* JADX INFO: renamed from: c */
    private final boolean m2910c() {
        return this.f4393c;
    }

    /* JADX INFO: renamed from: d */
    private final Identity m2911d() {
        return this.f4394d;
    }

    /* JADX INFO: renamed from: e */
    public final JSONObject m2913e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceID", this.f4391a.m3969f());
        jSONObject.put("etAppId", this.f4391a.m3967d());
        jSONObject.put(C4352k.a.f5659m, this.f4391a.m3970g());
        jSONObject.put("platform", this.f4391a.m3971h());
        jSONObject.put("platform_Version", this.f4391a.m3972i());
        jSONObject.put("sdk_Version", this.f4391a.m3973j());
        jSONObject.put("app_Version", this.f4391a.m3968e());
        jSONObject.put("locale", Locale.getDefault().toString());
        jSONObject.put(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, C4393l.m4344b());
        jSONObject.put("location_Enabled", this.f4393c);
        PushMessageManager pushMessageManager = this.f4392b;
        if (pushMessageManager != null) {
            jSONObject.put("backgroundRefreshEnabled", pushMessageManager.isPushEnabled());
            jSONObject.put("push_Enabled", pushMessageManager.isPushEnabled());
        }
        Identity identity = this.f4394d;
        if (identity != null) {
            jSONObject.put("identity", identity.toJson());
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4106e)) {
            return false;
        }
        C4106e c4106e = (C4106e) obj;
        return Intrinsics.areEqual(this.f4391a, c4106e.f4391a) && Intrinsics.areEqual(this.f4392b, c4106e.f4392b) && this.f4393c == c4106e.f4393c && Intrinsics.areEqual(this.f4394d, c4106e.f4394d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int iHashCode = this.f4391a.hashCode() * 31;
        PushMessageManager pushMessageManager = this.f4392b;
        int iHashCode2 = (iHashCode + (pushMessageManager == null ? 0 : pushMessageManager.hashCode())) * 31;
        boolean z = this.f4393c;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        Identity identity = this.f4394d;
        return i + (identity != null ? identity.hashCode() : 0);
    }

    public String toString() {
        return "EventMetaData(registrationMeta=" + this.f4391a + ", pushMessageManager=" + this.f4392b + ", locationEnabled=" + this.f4393c + ", identity=" + this.f4394d + ")";
    }

    /* JADX INFO: renamed from: a */
    public final C4106e m2912a(C4311f registrationMeta, PushMessageManager pushMessageManager, boolean z, Identity identity) {
        Intrinsics.checkNotNullParameter(registrationMeta, "registrationMeta");
        return new C4106e(registrationMeta, pushMessageManager, z, identity);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4106e m2907a(C4106e c4106e, C4311f c4311f, PushMessageManager pushMessageManager, boolean z, Identity identity, int i, Object obj) {
        if ((i & 1) != 0) {
            c4311f = c4106e.f4391a;
        }
        if ((i & 2) != 0) {
            pushMessageManager = c4106e.f4392b;
        }
        if ((i & 4) != 0) {
            z = c4106e.f4393c;
        }
        if ((i & 8) != 0) {
            identity = c4106e.f4394d;
        }
        return c4106e.m2912a(c4311f, pushMessageManager, z, identity);
    }
}
