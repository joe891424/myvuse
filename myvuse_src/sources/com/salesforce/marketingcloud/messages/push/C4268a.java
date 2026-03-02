package com.salesforce.marketingcloud.messages.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.C4193k;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.InterfaceC4147e;
import com.salesforce.marketingcloud.MCService;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.internal.C4185h;
import com.salesforce.marketingcloud.messages.inbox.C4263a;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.notifications.C4273a;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.push.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4268a extends PushMessageManager implements InterfaceC4147e, C4093b.b {

    /* JADX INFO: renamed from: t */
    static final String f5368t = "et_push_enabled";

    /* JADX INFO: renamed from: u */
    private static final String f5369u = "last_push_token_refresh";

    /* JADX INFO: renamed from: v */
    private static final String f5370v = "content-available";

    /* JADX INFO: renamed from: w */
    private static final String f5371w = "_c";

    /* JADX INFO: renamed from: x */
    private static final String f5372x = "_p";

    /* JADX INFO: renamed from: y */
    private static final long f5373y = TimeUnit.HOURS.toMillis(48);

    /* JADX INFO: renamed from: j */
    private final Context f5374j;

    /* JADX INFO: renamed from: k */
    private final C4273a f5375k;

    /* JADX INFO: renamed from: l */
    private final C4093b f5376l;

    /* JADX INFO: renamed from: n */
    private final C4374j f5378n;

    /* JADX INFO: renamed from: o */
    private final String f5379o;

    /* JADX INFO: renamed from: q */
    private int f5381q;

    /* JADX INFO: renamed from: r */
    private BroadcastReceiver f5382r;

    /* JADX INFO: renamed from: s */
    private boolean f5383s;

    /* JADX INFO: renamed from: m */
    private final Set<PushMessageManager.SilentPushListener> f5377m = new ArraySet();

    /* JADX INFO: renamed from: p */
    private final Set<PushMessageManager.PushTokenRefreshListener> f5380p = new ArraySet();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.push.a$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4170g.m3213d(PushMessageManager.f5362d, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4170g.m3213d(PushMessageManager.f5362d, "Received null action", new Object[0]);
            } else if (action.equals(PushMessageManager.f5363e)) {
                C4268a.this.m3839a(intent.getExtras());
            } else {
                C4170g.m3202a(PushMessageManager.f5362d, "Received unknown action: %s", action);
            }
        }
    }

    public C4268a(Context context, C4374j c4374j, C4273a c4273a, C4093b c4093b, String str) {
        this.f5374j = (Context) C4391j.m4326a(context, "Content is null");
        this.f5378n = (C4374j) C4391j.m4326a(c4374j, "Storage is null");
        this.f5375k = (C4273a) C4391j.m4326a(c4273a, "NotificationManager is null");
        this.f5376l = (C4093b) C4391j.m4326a(c4093b, "AlarmScheduler is null");
        this.f5379o = str;
    }

    /* JADX INFO: renamed from: a */
    private void m3827a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(PushMessageManager.f5366h, this.f5383s);
        C4140c.m3035a(this.f5374j, EnumC4138a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED, bundle);
    }

    /* JADX INFO: renamed from: b */
    private void m3830b() {
        JSONArray jSONArrayOptJSONArray = getPushDebugInfo().optJSONArray("messagingService");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 2) {
            return;
        }
        C4170g.m3216e(PushMessageManager.f5362d, "Possible Multiple Push Provider implementation issue detected in your application. This may lead to the malfunctioning of the Push SDK.", new Object[0]);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            int iOptInt = jSONObjectOptJSONObject.optInt("priority");
            String strOptString = jSONObjectOptJSONObject.optString("name");
            if (iOptInt > -1) {
                C4170g.m3213d(PushMessageManager.f5362d, strOptString + " is having higher priority than the Push SDK", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3834c(Map<String, String> map) {
        map.remove(f5371w);
        map.remove(f5372x);
        m3836d(map);
    }

    /* JADX INFO: renamed from: d */
    private void m3836d(Map<String, String> map) {
        synchronized (this.f5377m) {
            for (PushMessageManager.SilentPushListener silentPushListener : this.f5377m) {
                if (silentPushListener != null) {
                    try {
                        silentPushListener.silentPushReceived(map);
                    } catch (Exception e) {
                        C4170g.m3207b(PushMessageManager.f5362d, e, "%s threw an exception while processing the silent push message", silentPushListener.getClass().getName());
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m3837e(Map<String, String> map) {
        if (map == null || m3838f(map)) {
            return;
        }
        C4140c.m3035a(this.f5374j, EnumC4138a.BEHAVIOR_SDK_PUSH_RECEIVED, m3826a(map));
        if (C4193k.m3442a(map)) {
            C4170g.m3213d(PushMessageManager.f5362d, "Sync handler push received.", new Object[0]);
            return;
        }
        if (!isPushEnabled()) {
            C4170g.m3202a(PushMessageManager.f5362d, "Push Messaging is disabled.  Ignoring message.", new Object[0]);
            return;
        }
        if (map.containsKey(f5370v)) {
            m3832b(map);
            return;
        }
        if (map.containsKey(f5371w)) {
            m3834c(map);
            return;
        }
        try {
            NotificationMessage notificationMessageM3377a = C4185h.m3377a(map);
            if (TextUtils.isEmpty(notificationMessageM3377a.alert().trim())) {
                C4170g.m3202a(PushMessageManager.f5362d, "Message (%s) was received but does not have an alert message.", notificationMessageM3377a.m3845id());
            } else {
                this.f5375k.m3860a(notificationMessageM3377a, (C4273a.b) null);
            }
        } catch (Exception e) {
            C4170g.m3207b(PushMessageManager.f5362d, e, "Unable to show push notification", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: f */
    private boolean m3838f(Map<String, String> map) {
        if (C4137b.m3024a(this.f5381q, 4)) {
            C4170g.m3202a(PushMessageManager.f5362d, "Blocking push message.  Received a push message when the push feature is blocked.", new Object[0]);
            return true;
        }
        if (!C4137b.m3024a(this.f5381q, 128) || !C4263a.m3799a(map)) {
            return false;
        }
        C4170g.m3202a(PushMessageManager.f5362d, "Blocking push message.  Received an inbox message when the inbox feature is blocked.", new Object[0]);
        return true;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public String componentName() {
        return "PushMessageManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pushEnabled", this.f5383s);
            jSONObject.put("pushPermissionsAllowed", NotificationManagerCompat.from(this.f5374j).areNotificationsEnabled());
            synchronized (this.f5380p) {
                if (!this.f5380p.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener : this.f5380p) {
                        if (pushTokenRefreshListener != null) {
                            jSONArray.put(pushTokenRefreshListener.getClass().getName());
                        }
                    }
                    jSONObject.put("tokenRefreshListeners", jSONArray);
                }
            }
            jSONObject.put("debugInfo", getPushDebugInfo());
        } catch (JSONException e) {
            C4170g.m3207b(PushMessageManager.f5362d, e, "Unable to create component state for $s", componentName());
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void controlChannelInit(int i) {
        if (!C4137b.m3024a(i, 4)) {
            if (C4137b.m3024a(this.f5381q, 4)) {
                this.f5381q = i;
                m3833c();
                this.f5376l.m2861a(this, AbstractC4092a.a.f4320e);
                enablePush();
                String str = this.f5379o;
                if (str != null) {
                    MCService.m2821b(this.f5374j, str);
                    return;
                }
                return;
            }
            return;
        }
        disablePush();
        if (this.f5382r != null) {
            LocalBroadcastManager.getInstance(this.f5374j).unregisterReceiver(this.f5382r);
        }
        C4093b c4093b = this.f5376l;
        AbstractC4092a.a aVar = AbstractC4092a.a.f4320e;
        c4093b.m2869e(aVar);
        this.f5376l.m2868d(aVar);
        if (C4137b.m3027c(i, 4)) {
            InterfaceC4340c interfaceC4340cMo4220c = this.f5378n.mo4220c();
            interfaceC4340cMo4220c.mo3929a(InterfaceC4340c.f5567i);
            interfaceC4340cMo4220c.mo3929a(InterfaceC4340c.f5563e);
        }
        this.f5381q = i;
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public synchronized void disablePush() {
        if (this.f5383s && !C4137b.m3024a(this.f5381q, 4)) {
            this.f5383s = false;
            m3827a();
            m3835d();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public synchronized void enablePush() {
        if (C4137b.m3024a(this.f5381q, 4)) {
            return;
        }
        this.f5383s = true;
        m3827a();
        m3835d();
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public JSONObject getPushDebugInfo() {
        try {
            return C4269b.m3843a(this.f5374j, this.f5379o, this.f5378n.mo4220c().mo3931b(InterfaceC4340c.f5563e, null));
        } catch (Exception e) {
            C4170g.m3207b(PushMessageManager.f5362d, e, "Unable to acquire push debug info.", new Object[0]);
            return new JSONObject();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public String getPushToken() {
        return this.f5378n.mo4220c().mo3931b(InterfaceC4340c.f5563e, null);
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public boolean handleMessage(RemoteMessage remoteMessage) {
        if (PushMessageManager.isMarketingCloudPush(remoteMessage)) {
            m3837e(remoteMessage.getData());
            return true;
        }
        C4170g.m3202a(PushMessageManager.f5362d, "Message was not sent from the Marketing Cloud.  Message ignored.", new Object[0]);
        return false;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void init(InitializationStatus.C4081a c4081a, int i) {
        this.f5381q = i;
        if (C4137b.m3026b(i, 4)) {
            this.f5383s = this.f5378n.mo4222f().getBoolean(f5368t, true);
            m3833c();
            C4093b c4093b = this.f5376l;
            AbstractC4092a.a aVar = AbstractC4092a.a.f4320e;
            c4093b.m2861a(this, aVar);
            if (this.f5379o == null) {
                C4170g.m3216e(PushMessageManager.f5362d, "No sender id was provided during initialization.  You will not receive push messages until a token is manually set.", new Object[0]);
                this.f5376l.m2868d(aVar);
                this.f5378n.mo4220c().mo3929a(InterfaceC4340c.f5567i);
                return;
            }
            m3830b();
            if (!this.f5379o.equals(this.f5378n.mo4220c().mo3931b(InterfaceC4340c.f5567i, null))) {
                C4170g.m3213d(PushMessageManager.f5362d, "Sender Id has changed.  Refresh system token.", new Object[0]);
            } else if (this.f5378n.mo4222f().getLong(f5369u, 0L) + f5373y >= System.currentTimeMillis()) {
                return;
            } else {
                C4170g.m3213d(PushMessageManager.f5362d, "Push token refresh cool down expired.  Refresh system token.", new Object[0]);
            }
            MCService.m2821b(this.f5374j, this.f5379o);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public synchronized boolean isPushEnabled() {
        return this.f5383s;
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void registerSilentPushListener(PushMessageManager.SilentPushListener silentPushListener) {
        if (silentPushListener == null) {
            return;
        }
        synchronized (this.f5377m) {
            this.f5377m.add(silentPushListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void registerTokenRefreshListener(PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener) {
        if (pushTokenRefreshListener == null) {
            return;
        }
        synchronized (this.f5380p) {
            this.f5380p.add(pushTokenRefreshListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void setPushToken(String str) {
        if (C4137b.m3026b(this.f5381q, 4)) {
            if (str == null) {
                C4170g.m3206b(PushMessageManager.f5362d, "Provided pushToken was null", new Object[0]);
                return;
            }
            if (this.f5379o != null) {
                C4170g.m3202a(PushMessageManager.f5362d, "Setting the SenderId during SDK initialization and setting the push token will cause conflicts in the system and could prevent the device from receiving push messages.", new Object[0]);
            }
            InterfaceC4340c interfaceC4340cMo4220c = this.f5378n.mo4220c();
            interfaceC4340cMo4220c.mo3929a(InterfaceC4340c.f5567i);
            interfaceC4340cMo4220c.mo3930a(InterfaceC4340c.f5563e, str);
            this.f5376l.m2868d(AbstractC4092a.a.f4320e);
            m3831b(str);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        if (this.f5382r != null) {
            LocalBroadcastManager.getInstance(this.f5374j).unregisterReceiver(this.f5382r);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void unregisterSilentPushListener(PushMessageManager.SilentPushListener silentPushListener) {
        synchronized (this.f5377m) {
            this.f5377m.remove(silentPushListener);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public void unregisterTokenRefreshListener(PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener) {
        synchronized (this.f5380p) {
            this.f5380p.remove(pushTokenRefreshListener);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3828a(Context context, boolean z, String str, String str2) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(PushMessageManager.f5363e).putExtra(PushMessageManager.f5364f, z).putExtra(PushMessageManager.f5365g, str).putExtra(PushMessageManager.f5367i, str2));
    }

    /* JADX INFO: renamed from: b */
    private void m3832b(Map<String, String> map) {
        String str = map.get(f5370v);
        if (str != null) {
            try {
                if (Integer.parseInt(str) == 1) {
                    m3836d(map);
                }
            } catch (Exception e) {
                C4170g.m3207b(PushMessageManager.f5362d, e, "Unable to parse content available flag: %s", str);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3833c() {
        this.f5382r = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushMessageManager.f5363e);
        LocalBroadcastManager.getInstance(this.f5374j).registerReceiver(this.f5382r, intentFilter);
    }

    /* JADX INFO: renamed from: d */
    private void m3835d() {
        C4374j c4374j = this.f5378n;
        if (c4374j != null) {
            c4374j.mo4222f().edit().putBoolean(f5368t, this.f5383s).apply();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.push.PushMessageManager
    public boolean handleMessage(Map<String, String> map) {
        if (PushMessageManager.isMarketingCloudPush(map)) {
            m3837e(map);
            return true;
        }
        C4170g.m3202a(PushMessageManager.f5362d, "Message was not sent from the Marketing Cloud.  Message ignored.", new Object[0]);
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static Bundle m3826a(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (!map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    /* JADX INFO: renamed from: b */
    private void m3831b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(PushMessageManager.f5367i, str);
        C4140c.m3035a(this.f5374j, EnumC4138a.BEHAVIOR_SDK_TOKEN_REFRESHED, bundle);
    }

    /* JADX INFO: renamed from: a */
    private void m3829a(String str) {
        synchronized (this.f5380p) {
            for (PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener : this.f5380p) {
                if (pushTokenRefreshListener != null) {
                    try {
                        pushTokenRefreshListener.onTokenRefreshed(str);
                    } catch (Exception e) {
                        C4170g.m3207b(PushMessageManager.f5362d, e, "%s threw an exception while processing the token refresh", pushTokenRefreshListener.getClass().getName());
                    }
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.alarms.C4093b.b
    /* JADX INFO: renamed from: a */
    public void mo2870a(AbstractC4092a.a aVar) {
        String str;
        if (aVar != AbstractC4092a.a.f4320e || (str = this.f5379o) == null) {
            return;
        }
        MCService.m2821b(this.f5374j, str);
    }

    /* JADX INFO: renamed from: a */
    void m3839a(Bundle bundle) {
        InterfaceC4340c interfaceC4340cMo4220c = this.f5378n.mo4220c();
        if (!bundle.getBoolean(PushMessageManager.f5364f, false)) {
            interfaceC4340cMo4220c.mo3929a(InterfaceC4340c.f5567i);
            this.f5376l.m2865b(AbstractC4092a.a.f4320e);
            return;
        }
        String string = bundle.getString(PushMessageManager.f5367i, "");
        interfaceC4340cMo4220c.mo3930a(InterfaceC4340c.f5563e, string);
        interfaceC4340cMo4220c.mo3930a(InterfaceC4340c.f5567i, bundle.getString(PushMessageManager.f5365g, ""));
        m3831b(string);
        this.f5376l.m2868d(AbstractC4092a.a.f4320e);
        this.f5378n.mo4222f().edit().putLong(f5369u, System.currentTimeMillis()).apply();
        m3829a(string);
    }
}
