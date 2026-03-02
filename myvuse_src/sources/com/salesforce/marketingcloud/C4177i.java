package com.salesforce.marketingcloud;

import com.salesforce.marketingcloud.registration.RegistrationManager;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.ModuleIdentity;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.i */
/* JADX INFO: loaded from: classes6.dex */
public final class C4177i extends ModuleIdentity {

    /* JADX INFO: renamed from: b */
    public static final a f4895b = new a(null);

    /* JADX INFO: renamed from: c */
    private static ModuleIdentity f4896c;

    /* JADX INFO: renamed from: a */
    private final RegistrationManager f4897a;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.i$a */
    public static final class a {
        private a() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final ModuleIdentity m3323a(String applicationId, RegistrationManager registrationManager) {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(registrationManager, "registrationManager");
            if (C4177i.f4896c == null) {
                C4177i.f4896c = new C4177i(applicationId, registrationManager, null);
            }
            return C4177i.f4896c;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private C4177i(String str, RegistrationManager registrationManager) {
        super(ModuleIdentifier.PUSH, str);
        this.f4897a = registrationManager;
        if (registrationManager != null) {
            setProfileId(registrationManager.getContactKey());
            setInstallationId(registrationManager.getDeviceId());
            HashMap map = new HashMap();
            map.put("deviceId", registrationManager.getDeviceId());
            map.put(C4352k.a.f5654h, registrationManager.getAttributes());
            map.put(C4352k.a.f5653g, registrationManager.getTags());
            setCustomProperties(map);
        }
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.components.identity.ModuleIdentity
    public JSONObject customPropertiesToJson(Map<String, ? extends Object> customProperties) throws JSONException {
        Intrinsics.checkNotNullParameter(customProperties, "customProperties");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("deviceId", customProperties.get("deviceId"));
            Object obj = customProperties.get(C4352k.a.f5654h);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any?, kotlin.Any?>");
            jSONObject.put(C4352k.a.f5654h, new JSONObject(TypeIntrinsics.asMutableMap(obj)));
            jSONObject.put(C4352k.a.f5653g, new JSONArray((Collection) this.f4897a.getTags()));
            return jSONObject;
        } catch (Exception e) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error", e.getMessage());
            return jSONObject2;
        }
    }

    public /* synthetic */ C4177i(String str, RegistrationManager registrationManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, registrationManager);
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final ModuleIdentity m3321a(String str, RegistrationManager registrationManager) {
        return f4895b.m3323a(str, registrationManager);
    }
}
