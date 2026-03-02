package com.salesforce.marketingcloud.messages.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.firebase.FirebaseApp;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.push.b */
/* JADX INFO: loaded from: classes6.dex */
final class C4269b {

    /* JADX INFO: renamed from: a */
    private static final String f5385a = "com.google.android.c2dm.intent.RECEIVE";

    /* JADX INFO: renamed from: b */
    private static final String f5386b = "com.google.firebase.INSTANCE_ID_EVENT";

    /* JADX INFO: renamed from: c */
    private static final String f5387c = "com.google.firebase.MESSAGING_EVENT";

    private C4269b() {
    }

    /* JADX INFO: renamed from: a */
    static JSONObject m3843a(Context context, String str, String str2) throws JSONException {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        JSONObject jSONObject = new JSONObject();
        Object obj = str;
        if (str == null) {
            obj = JSONObject.NULL;
        }
        jSONObject.put("senderId", obj);
        Object obj2 = str2;
        if (str2 == null) {
            obj2 = JSONObject.NULL;
        }
        jSONObject.put("deviceToken", obj2);
        jSONObject.put("firebaseApps", m3841a(context));
        jSONObject.put("c2dmReceiver", m3842a(packageName, packageManager.queryBroadcastReceivers(new Intent(f5385a), 0)));
        jSONObject.put("instanceIdService", m3842a(packageName, packageManager.queryIntentServices(new Intent(f5386b), 0)));
        jSONObject.put("messagingService", m3842a(packageName, packageManager.queryIntentServices(new Intent(f5387c), 0)));
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    private static JSONArray m3842a(String str, List<ResolveInfo> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (ResolveInfo resolveInfo : list) {
                ComponentInfo componentInfoM3840a = m3840a(resolveInfo);
                if (componentInfoM3840a != null && str.equals(componentInfoM3840a.processName)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", componentInfoM3840a.name);
                    jSONObject.put("priority", resolveInfo.priority);
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: renamed from: a */
    private static JSONArray m3841a(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            List<FirebaseApp> apps = FirebaseApp.getApps(context);
            if (!apps.isEmpty()) {
                Iterator<FirebaseApp> it2 = apps.iterator();
                while (it2.hasNext()) {
                    jSONArray.put(it2.next().toString());
                }
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    /* JADX INFO: renamed from: a */
    private static ComponentInfo m3840a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        if (activityInfo != null) {
            return activityInfo;
        }
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        if (serviceInfo != null) {
            return serviceInfo;
        }
        return null;
    }
}
