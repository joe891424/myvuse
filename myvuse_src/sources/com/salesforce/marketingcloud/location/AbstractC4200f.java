package com.salesforce.marketingcloud.location;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.salesforce.marketingcloud.AbstractC4169f;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.util.C4385d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.location.f */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4200f extends AbstractC4169f {

    /* JADX INFO: renamed from: d */
    public static final String f4986d = "NO_GPS_HARDWARE";

    /* JADX INFO: renamed from: e */
    public static final String f4987e = "RECEIVER_NOT_DECLARED_IN_MANIFEST";

    /* JADX INFO: renamed from: f */
    public static final int f4988f = -1;

    /* JADX INFO: renamed from: g */
    private static final String f4989g = "LocationManager";

    /* JADX INFO: renamed from: h */
    static final String f4990h = C4170g.m3197a(f4989g);

    /* JADX INFO: renamed from: i */
    protected static final String f4991i = "com.salesforce.marketingcloud.location.LOCATION_UPDATE";

    /* JADX INFO: renamed from: j */
    protected static final String f4992j = "com.salesforce.marketingcloud.location.GEOFENCE_ERROR";

    /* JADX INFO: renamed from: k */
    protected static final String f4993k = "com.salesforce.marketingcloud.location.GEOFENCE_EVENT";

    /* JADX INFO: renamed from: l */
    protected static final String f4994l = "extra_location";

    /* JADX INFO: renamed from: m */
    protected static final String f4995m = "extra_transition";

    /* JADX INFO: renamed from: n */
    protected static final String f4996n = "extra_fence_ids";

    /* JADX INFO: renamed from: o */
    protected static final String f4997o = "extra_error_code";

    /* JADX INFO: renamed from: p */
    protected static final String f4998p = "extra_error_message";

    /* JADX INFO: renamed from: a */
    public static AbstractC4200f m3489a(Context context, MarketingCloudConfig marketingCloudConfig) {
        Exception exc;
        boolean zM4263b = C4385d.m4263b();
        Boolean bool = null;
        Exception exc2 = null;
        if (zM4263b) {
            Boolean boolValueOf = Boolean.valueOf(LocationReceiver.m3453a(context));
            if (boolValueOf.booleanValue()) {
                try {
                    return new C4202h(context, marketingCloudConfig);
                } catch (Exception e) {
                    exc2 = e;
                    C4170g.m3207b(f4990h, exc2, "Unable to create real instance of %s", f4989g);
                }
            }
            exc = exc2;
            bool = boolValueOf;
        } else {
            C4170g.m3216e(f4990h, "GooglePlayServices Location dependency missing from build.", new Object[0]);
            exc = null;
        }
        return new C4195a(marketingCloudConfig, bool, zM4263b, exc);
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo3456a(InterfaceC4197c interfaceC4197c);

    /* JADX INFO: renamed from: a */
    public abstract void mo3457a(InterfaceC4199e interfaceC4199e);

    /* JADX INFO: renamed from: a */
    public abstract void mo3458a(List<String> list);

    /* JADX INFO: renamed from: a */
    public abstract void mo3459a(C4196b... c4196bArr);

    /* JADX INFO: renamed from: a */
    public boolean mo3493a() {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo3460b();

    /* JADX INFO: renamed from: b */
    public abstract void mo3461b(InterfaceC4197c interfaceC4197c);

    /* JADX INFO: renamed from: b */
    public abstract void mo3462b(InterfaceC4199e interfaceC4199e);

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return f4989g;
    }

    /* JADX INFO: renamed from: a */
    public static Intent m3486a(int i, String str) {
        return new Intent(f4992j).putExtra(f4997o, i).putExtra(f4998p, str);
    }

    /* JADX INFO: renamed from: a */
    public static Intent m3487a(int i, List<String> list, Location location) {
        Intent intent = new Intent(f4993k);
        intent.putExtra(f4995m, i);
        if (list instanceof ArrayList) {
            intent.putStringArrayListExtra(f4996n, (ArrayList) list);
        } else {
            intent.putStringArrayListExtra(f4996n, new ArrayList<>(list));
        }
        if (location != null) {
            intent.putExtra(f4994l, location);
        }
        return intent;
    }

    /* JADX INFO: renamed from: a */
    private static JSONObject m3490a(MarketingCloudConfig marketingCloudConfig) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("geofencingEnabled", marketingCloudConfig.geofencingEnabled());
            jSONObject.put("proximityEnabled", marketingCloudConfig.proximityEnabled());
        } catch (Exception e) {
            C4170g.m3207b(f4990h, e, "Error creating LocationManager state.", new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    static JSONObject m3491a(MarketingCloudConfig marketingCloudConfig, int i, String str) {
        JSONObject jSONObjectM3490a = m3490a(marketingCloudConfig);
        try {
            jSONObjectM3490a.put("apiCode", i);
            jSONObjectM3490a.put("apiMessage", str);
        } catch (Exception e) {
            C4170g.m3207b(f4990h, e, "Error creating LocationManager state.", new Object[0]);
        }
        return jSONObjectM3490a;
    }

    /* JADX INFO: renamed from: a */
    static JSONObject m3492a(MarketingCloudConfig marketingCloudConfig, Boolean bool, boolean z, Exception exc) {
        JSONObject jSONObjectM3490a = m3490a(marketingCloudConfig);
        try {
            jSONObjectM3490a.put("serviceAvailable", bool);
            jSONObjectM3490a.put("gmsLocationDependencyAvailable", z);
            if (exc != null) {
                jSONObjectM3490a.put(AnalyticsAttribute.NATIVE_EXCEPTION_MESSAGE_ATTRIBUTE, exc.getMessage());
            }
        } catch (JSONException e) {
            C4170g.m3207b(f4990h, e, "Error creating LocationManager state.", new Object[0]);
        }
        return jSONObjectM3490a;
    }

    /* JADX INFO: renamed from: a */
    public static Intent m3488a(Location location) {
        return new Intent(f4991i).putExtra(f4994l, location);
    }
}
