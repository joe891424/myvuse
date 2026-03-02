package com.salesforce.marketingcloud.behaviors;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.AbstractC4169f;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.behaviors.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4140c extends AbstractC4169f {

    /* JADX INFO: renamed from: i */
    public static final String f4593i = "timestamp";

    /* JADX INFO: renamed from: j */
    static final int f4594j = 1;

    /* JADX INFO: renamed from: k */
    static final String f4595k = C4170g.m3197a("BehaviorManager");

    /* JADX INFO: renamed from: d */
    private final ExecutorService f4596d;

    /* JADX INFO: renamed from: e */
    private final ArrayMap<EnumC4138a, Set<InterfaceC4139b>> f4597e = new ArrayMap<>();

    /* JADX INFO: renamed from: f */
    private final Map<EnumC4138a, Bundle> f4598f = new ArrayMap(1);

    /* JADX INFO: renamed from: g */
    private final Context f4599g;

    /* JADX INFO: renamed from: h */
    private BroadcastReceiver f4600h;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.behaviors.c$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4170g.m3213d(C4140c.f4595k, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4170g.m3213d(C4140c.f4595k, "Received null action", new Object[0]);
                return;
            }
            EnumC4138a enumC4138aM3033a = EnumC4138a.m3033a(action);
            if (enumC4138aM3033a != null) {
                C4140c.this.onBehavior(enumC4138aM3033a, intent.getExtras());
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.behaviors.c$b */
    static class b implements Runnable {

        /* JADX INFO: renamed from: a */
        final Set<InterfaceC4139b> f4602a;

        /* JADX INFO: renamed from: b */
        final EnumC4138a f4603b;

        /* JADX INFO: renamed from: c */
        final Bundle f4604c;

        b(Set<InterfaceC4139b> set, EnumC4138a enumC4138a, Bundle bundle) {
            this.f4602a = set;
            this.f4603b = enumC4138a;
            this.f4604c = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (InterfaceC4139b interfaceC4139b : this.f4602a) {
                if (interfaceC4139b != null) {
                    try {
                        interfaceC4139b.onBehavior(this.f4603b, this.f4604c);
                    } catch (Exception e) {
                        C4170g.m3207b(C4140c.f4595k, e, "Failure delivering behavior %s to %s", this.f4603b.f4590a, interfaceC4139b.getClass().getName());
                    }
                }
            }
        }
    }

    public C4140c(Context context, ExecutorService executorService) {
        this.f4599g = context;
        this.f4596d = executorService;
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f
    /* JADX INFO: renamed from: a */
    protected void mo2859a(InitializationStatus.C4081a c4081a) {
        this.f4600h = new a();
        IntentFilter intentFilter = new IntentFilter();
        for (EnumC4138a enumC4138a : EnumC4138a.values()) {
            intentFilter.addAction(enumC4138a.f4590a);
        }
        LocalBroadcastManager.getInstance(this.f4599g).registerReceiver(this.f4600h, intentFilter);
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return "BehaviorManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final JSONObject componentState() {
        return null;
    }

    void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putLong("timestamp", System.currentTimeMillis());
        C4170g.m3202a(f4595k, "Behavior found: %s", enumC4138a.name());
        synchronized (this.f4597e) {
            Set<InterfaceC4139b> set = this.f4597e.get(enumC4138a);
            if (set != null && !set.isEmpty()) {
                try {
                    this.f4596d.submit(new b(Collections.unmodifiableSet(set), enumC4138a, bundle));
                } catch (RejectedExecutionException e) {
                    C4170g.m3207b(f4595k, e, "Unable to deliver behavior %s.", enumC4138a.f4590a);
                }
            }
        }
        synchronized (this.f4598f) {
            if (enumC4138a.f4591b) {
                this.f4598f.put(enumC4138a, bundle);
            }
            EnumC4138a enumC4138a2 = enumC4138a.f4592c;
            if (enumC4138a2 != null) {
                this.f4598f.put(enumC4138a2, null);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.AbstractC4169f, com.salesforce.marketingcloud.InterfaceC4146d
    public final void tearDown(boolean z) {
        Context context = this.f4599g;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f4600h);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3035a(Context context, EnumC4138a enumC4138a, Bundle bundle) {
        C4391j.m4326a(context, "Context is null");
        C4391j.m4326a(enumC4138a, "Behavior is null");
        Intent intent = new Intent(enumC4138a.f4590a);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: a */
    public void m3037a(InterfaceC4139b interfaceC4139b, EnumSet<EnumC4138a> enumSet) {
        C4391j.m4326a(interfaceC4139b, "BehaviorListener is null");
        C4391j.m4326a(enumSet, "Behavior set is null");
        synchronized (this.f4597e) {
            C4170g.m3202a(f4595k, "Registering %s for behaviors: %s", interfaceC4139b.getClass().getName(), enumSet.toString());
            for (EnumC4138a enumC4138a : enumSet) {
                Set<InterfaceC4139b> hashSet = this.f4597e.get(enumC4138a);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.f4597e.put(enumC4138a, hashSet);
                }
                hashSet.add(interfaceC4139b);
            }
        }
        synchronized (this.f4598f) {
            for (EnumC4138a enumC4138a2 : enumSet) {
                if (enumC4138a2.f4591b && this.f4598f.containsKey(enumC4138a2)) {
                    this.f4596d.submit(new b(Collections.singleton(interfaceC4139b), enumC4138a2, this.f4598f.get(enumC4138a2)));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3036a(InterfaceC4139b interfaceC4139b) {
        synchronized (this.f4597e) {
            Iterator<Map.Entry<EnumC4138a, Set<InterfaceC4139b>>> it2 = this.f4597e.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().remove(interfaceC4139b);
            }
        }
    }
}
