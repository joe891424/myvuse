package com.salesforce.marketingcloud.proximity;

import android.content.Context;
import com.salesforce.marketingcloud.AbstractC4169f;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.util.C4385d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.e */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4280e extends AbstractC4169f {

    /* JADX INFO: renamed from: d */
    public static final String f5448d = "com.salesforce.marketingcloud.proximity.BEACON_REGION_ENTERED";

    /* JADX INFO: renamed from: e */
    public static final String f5449e = "com.salesforce.marketingcloud.proximity.BEACON_REGION_EXITED";

    /* JADX INFO: renamed from: f */
    public static final String f5450f = "beaconRegion";

    /* JADX INFO: renamed from: g */
    private static final String f5451g = "ProximityManager";

    /* JADX INFO: renamed from: h */
    protected static final String f5452h = C4170g.m3197a(f5451g);

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.proximity.e$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo3820a(C4278c c4278c);

        /* JADX INFO: renamed from: b */
        void mo3821b(C4278c c4278c);
    }

    /* JADX INFO: renamed from: a */
    private static JSONObject m3912a(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("proximityEnabled", z);
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo3891a(a aVar);

    /* JADX INFO: renamed from: a */
    public abstract void mo3892a(List<C4278c> list);

    /* JADX INFO: renamed from: b */
    public abstract void mo3894b(a aVar);

    /* JADX INFO: renamed from: b */
    public abstract void mo3895b(List<C4278c> list);

    /* JADX INFO: renamed from: b */
    public boolean mo3896b() {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo3897c();

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return f5451g;
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC4280e m3910a(Context context, MarketingCloudConfig marketingCloudConfig) {
        String message;
        Boolean boolValueOf = Boolean.valueOf(m3914a(context));
        Boolean bool = null;
        if (!boolValueOf.booleanValue()) {
            message = null;
        } else if (C4385d.m4262a()) {
            try {
                return new C4277b(context, marketingCloudConfig.proximityNotificationCustomizationOptions());
            } catch (IllegalStateException e) {
                message = e.getMessage();
                C4170g.m3207b(f5452h, e, "Unable to create real instance of %s", f5451g);
            }
        } else {
            Boolean bool2 = Boolean.FALSE;
            C4170g.m3216e(f5452h, "If you wish to use proximity messenger then you need to add the AltBeacon dependency.", new Object[0]);
            message = null;
            bool = bool2;
        }
        return new C4279d(marketingCloudConfig.proximityEnabled(), m3913a(marketingCloudConfig.proximityEnabled(), boolValueOf, bool, message));
    }

    /* JADX INFO: renamed from: a */
    protected static JSONObject m3911a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        m3912a(jSONObject, true);
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    protected static JSONObject m3913a(boolean z, Boolean bool, Boolean bool2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = m3912a(jSONObject, z);
            jSONObject.put("hardwareAvailable", bool);
            jSONObject.put("libraryDeclared", bool2);
            if (str != null) {
                jSONObject.put("serviceMissing", str);
            }
        } catch (JSONException e) {
            C4170g.m3207b(f5452h, e, "Error creating fake ProximityManager state.", new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    protected static boolean m3914a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
}
