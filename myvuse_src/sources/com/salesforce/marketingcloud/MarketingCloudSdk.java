package com.salesforce.marketingcloud;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MCLogListener;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.analytics.C4113h;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.LifecycleManager;
import com.salesforce.marketingcloud.config.C4143a;
import com.salesforce.marketingcloud.events.C4152c;
import com.salesforce.marketingcloud.events.EventManager;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.internal.C4180c;
import com.salesforce.marketingcloud.internal.C4181d;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.location.AbstractC4200f;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.messages.C4236d;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.iam.InAppMessageComponent;
import com.salesforce.marketingcloud.messages.iam.InAppMessageManager;
import com.salesforce.marketingcloud.messages.inbox.C4263a;
import com.salesforce.marketingcloud.messages.inbox.InboxMessageManager;
import com.salesforce.marketingcloud.messages.push.C4268a;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.notifications.C4273a;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.proximity.AbstractC4280e;
import com.salesforce.marketingcloud.registration.C4309d;
import com.salesforce.marketingcloud.registration.C4311f;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.ModuleIdentity;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.util.C4382a;
import com.salesforce.marketingcloud.util.C4383b;
import com.salesforce.marketingcloud.util.C4386e;
import com.salesforce.marketingcloud.util.C4389h;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class MarketingCloudSdk extends PushModuleInterface implements C4137b.b {

    /* JADX INFO: renamed from: A */
    private static volatile boolean f4243A = false;

    /* JADX INFO: renamed from: s */
    static final String f4245s = "MarketingCloudPrefs";

    /* JADX INFO: renamed from: t */
    static final String f4246t = "InitConfig";

    /* JADX INFO: renamed from: x */
    static MarketingCloudSdk f4250x;

    /* JADX INFO: renamed from: y */
    private static Context f4251y;

    /* JADX INFO: renamed from: z */
    private static volatile boolean f4252z;

    /* JADX INFO: renamed from: a */
    private final MarketingCloudConfig f4253a;

    /* JADX INFO: renamed from: b */
    private final List<InterfaceC4146d> f4254b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private final SFMCSdkComponents f4255c;

    /* JADX INFO: renamed from: d */
    AbstractC4200f f4256d;

    /* JADX INFO: renamed from: e */
    C4140c f4257e;

    /* JADX INFO: renamed from: f */
    private C4137b f4258f;

    /* JADX INFO: renamed from: g */
    private C4374j f4259g;

    /* JADX INFO: renamed from: h */
    private C4174c f4260h;

    /* JADX INFO: renamed from: i */
    private C4263a f4261i;

    /* JADX INFO: renamed from: j */
    private C4309d f4262j;

    /* JADX INFO: renamed from: k */
    private C4273a f4263k;

    /* JADX INFO: renamed from: l */
    private C4268a f4264l;

    /* JADX INFO: renamed from: m */
    private C4236d f4265m;

    /* JADX INFO: renamed from: n */
    private C4152c f4266n;

    /* JADX INFO: renamed from: o */
    private AnalyticsManager f4267o;

    /* JADX INFO: renamed from: p */
    private InitializationStatus f4268p;

    /* JADX INFO: renamed from: q */
    private InAppMessageComponent f4269q;

    /* JADX INFO: renamed from: r */
    private C4189l f4270r;

    /* JADX INFO: renamed from: u */
    static final String f4247u = C4170g.m3197a("MarketingCloudSdk");

    /* JADX INFO: renamed from: v */
    private static final Object f4248v = new Object();

    /* JADX INFO: renamed from: w */
    private static final List<AbstractC4088c> f4249w = new ArrayList();

    /* JADX INFO: renamed from: B */
    private static volatile boolean f4244B = true;

    public interface InitializationListener {
        void complete(InitializationStatus initializationStatus);
    }

    public interface WhenReadyListener {
        void ready(MarketingCloudSdk marketingCloudSdk);
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.MarketingCloudSdk$a */
    class RunnableC4086a implements Runnable {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Context f4271a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ MarketingCloudConfig f4272b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ SFMCSdkComponents f4273c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ InitializationListener f4274d;

        RunnableC4086a(Context context, MarketingCloudConfig marketingCloudConfig, SFMCSdkComponents sFMCSdkComponents, InitializationListener initializationListener) {
            this.f4271a = context;
            this.f4272b = marketingCloudConfig;
            this.f4273c = sFMCSdkComponents;
            this.f4274d = initializationListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("SFMC_init");
            try {
                String str = MarketingCloudSdk.f4247u;
                C4170g.m3213d(str, "Starting init thread", new Object[0]);
                MarketingCloudSdk.m2830a(this.f4271a, this.f4272b, this.f4273c, this.f4274d);
                Thread.currentThread().setName(name);
                C4170g.m3213d(str, "~~ MarketingCloudSdk v%s init complete ~~", MarketingCloudSdk.getSdkVersionName());
            } catch (Throwable th) {
                Thread.currentThread().setName(name);
                C4170g.m3213d(MarketingCloudSdk.f4247u, "~~ MarketingCloudSdk v%s init complete ~~", MarketingCloudSdk.getSdkVersionName());
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.MarketingCloudSdk$b */
    class C4087b extends AbstractC4088c {
        C4087b(Looper looper, WhenReadyListener whenReadyListener) {
            super(looper, whenReadyListener);
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.AbstractC4088c
        /* JADX INFO: renamed from: a */
        protected void mo2839a(WhenReadyListener whenReadyListener) {
            if (whenReadyListener != null) {
                try {
                    whenReadyListener.ready(MarketingCloudSdk.f4250x);
                } catch (Exception e) {
                    C4170g.m3207b(MarketingCloudSdk.f4247u, e, "Error occurred in %s", whenReadyListener.getClass().getName());
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.MarketingCloudSdk$c */
    static abstract class AbstractC4088c {

        /* JADX INFO: renamed from: a */
        private final Handler f4275a;

        /* JADX INFO: renamed from: b */
        WhenReadyListener f4276b;

        /* JADX INFO: renamed from: c */
        volatile boolean f4277c;

        /* JADX INFO: renamed from: d */
        private final Runnable f4278d = new a();

        /* JADX INFO: renamed from: e */
        private volatile boolean f4279e;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.MarketingCloudSdk$c$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (AbstractC4088c.this) {
                    if (AbstractC4088c.this.f4277c) {
                        return;
                    }
                    AbstractC4088c abstractC4088c = AbstractC4088c.this;
                    abstractC4088c.mo2839a(abstractC4088c.f4276b);
                    AbstractC4088c.this.f4277c = true;
                }
            }
        }

        AbstractC4088c(Looper looper, WhenReadyListener whenReadyListener) {
            looper = looper == null ? Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper() : looper;
            this.f4276b = whenReadyListener;
            this.f4275a = new Handler(looper);
        }

        /* JADX INFO: renamed from: a */
        public void m2840a() {
            synchronized (this) {
                if (!this.f4277c && !this.f4279e) {
                    this.f4279e = true;
                    this.f4275a.post(this.f4278d);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        protected abstract void mo2839a(WhenReadyListener whenReadyListener);
    }

    private MarketingCloudSdk(MarketingCloudConfig marketingCloudConfig, SFMCSdkComponents sFMCSdkComponents) {
        this.f4253a = marketingCloudConfig;
        this.f4255c = sFMCSdkComponents;
    }

    /* JADX INFO: renamed from: c */
    static void m2835c() {
        MarketingCloudSdk marketingCloudSdk = f4250x;
        if (marketingCloudSdk != null) {
            marketingCloudSdk.m2832a(false);
        }
        f4250x = null;
    }

    public static MarketingCloudSdk getInstance() {
        if (!f4252z && !f4243A) {
            throw new IllegalStateException("MarketingCloudSdk#init must be called before calling MarketingCloudSdk#getInstance.");
        }
        synchronized (f4248v) {
            if (f4243A) {
                return f4250x;
            }
            boolean z = false;
            while (!f4243A && f4252z) {
                try {
                    try {
                        f4248v.wait(0L);
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                } finally {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            return f4250x;
        }
    }

    @MCLogListener.LogLevel
    public static int getLogLevel() {
        return C4181d.m3346a();
    }

    public static int getSdkVersionCode() {
        return C4091a.f4308d;
    }

    public static String getSdkVersionName() {
        return C4091a.f4309e;
    }

    @Deprecated(message = "Initialize the SDK with SFMCSdk.configure()")
    public static void init(Context context, MarketingCloudConfig marketingCloudConfig, InitializationListener initializationListener) {
        m2833b(context, marketingCloudConfig, null, initializationListener);
    }

    public static boolean isInitializing() {
        return f4252z;
    }

    public static boolean isReady() {
        return f4243A && f4250x != null;
    }

    public static void requestSdk(Looper looper, WhenReadyListener whenReadyListener) {
        C4087b c4087b = new C4087b(looper, whenReadyListener);
        List<AbstractC4088c> list = f4249w;
        synchronized (list) {
            if (f4244B) {
                list.add(c4087b);
            } else {
                c4087b.m2840a();
            }
        }
    }

    public static void setLogLevel(@MCLogListener.LogLevel int i) {
        C4181d.m3347a(i);
    }

    public static void setLogListener(MCLogListener mCLogListener) {
        C4181d.m3348a(mCLogListener);
    }

    public static void unregisterWhenReadyListener(WhenReadyListener whenReadyListener) {
        if (whenReadyListener == null) {
            return;
        }
        List<AbstractC4088c> list = f4249w;
        synchronized (list) {
            Iterator<AbstractC4088c> it2 = list.iterator();
            while (it2.hasNext()) {
                if (whenReadyListener == it2.next().f4276b) {
                    it2.remove();
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.C4137b.b
    /* JADX INFO: renamed from: a */
    public void mo2837a(int i) {
        for (int size = this.f4254b.size() - 1; size >= 0; size--) {
            try {
                InterfaceC4146d interfaceC4146d = this.f4254b.get(size);
                if (interfaceC4146d instanceof InterfaceC4147e) {
                    ((InterfaceC4147e) interfaceC4146d).controlChannelInit(i);
                }
            } catch (Exception e) {
                C4170g.m3207b(f4247u, e, "Error encountered during control channel init.", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public C4374j m2838b() {
        return this.f4259g;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public AnalyticsManager getAnalyticsManager() {
        return this.f4267o;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public EventManager getEventManager() {
        return this.f4266n;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public InAppMessageManager getInAppMessageManager() {
        return this.f4269q;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public InboxMessageManager getInboxMessageManager() {
        return this.f4261i;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public InitializationStatus getInitializationStatus() {
        return this.f4268p;
    }

    public MarketingCloudConfig getMarketingCloudConfig() {
        return this.f4253a;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface
    public ModuleIdentity getModuleIdentity() {
        return C4177i.m3321a(this.f4253a.applicationId(), getRegistrationManager());
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public NotificationManager getNotificationManager() {
        return this.f4263k;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public PushMessageManager getPushMessageManager() {
        return this.f4264l;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public RegionMessageManager getRegionMessageManager() {
        return this.f4265m;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface
    public RegistrationManager getRegistrationManager() {
        return this.f4262j;
    }

    public JSONObject getSdkState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("initConfig", this.f4253a.toString());
            jSONObject.put("initStatus", this.f4268p.toString());
            for (InterfaceC4146d interfaceC4146d : this.f4254b) {
                if (interfaceC4146d != null) {
                    try {
                        jSONObject.put(interfaceC4146d.componentName(), interfaceC4146d.componentState());
                    } catch (Exception e) {
                        C4170g.m3207b(f4247u, e, "Failed to create component state for %s", interfaceC4146d);
                    }
                }
            }
        } catch (Exception e2) {
            C4170g.m3207b(f4247u, e2, "Unable to create Sdk state json", new Object[0]);
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleInterface
    public JSONObject getState() {
        return getSdkState();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2 A[Catch: all -> 0x00aa, TryCatch #2 {, blocks: (B:4:0x000e, B:6:0x0012, B:7:0x001b, B:9:0x0025, B:11:0x002b, B:13:0x0047, B:14:0x0055, B:31:0x009b, B:33:0x00a2, B:34:0x00a5, B:26:0x008c, B:27:0x008d, B:28:0x0096, B:38:0x00a9, B:29:0x0097, B:30:0x009a, B:15:0x0056, B:17:0x006f, B:18:0x0073, B:20:0x0079, B:21:0x0083, B:22:0x0088), top: B:46:0x000e, inners: #0, #1 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m2830a(android.content.Context r3, com.salesforce.marketingcloud.MarketingCloudConfig r4, com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents r5, com.salesforce.marketingcloud.MarketingCloudSdk.InitializationListener r6) {
        /*
            java.lang.String r3 = com.salesforce.marketingcloud.MarketingCloudSdk.f4247u
            java.lang.Object[] r0 = new java.lang.Object[]{r4}
            java.lang.String r1 = "executeInit %s"
            com.salesforce.marketingcloud.C4170g.m3213d(r3, r1, r0)
            java.lang.Object r0 = com.salesforce.marketingcloud.MarketingCloudSdk.f4248v
            monitor-enter(r0)
            com.salesforce.marketingcloud.MarketingCloudSdk r1 = com.salesforce.marketingcloud.MarketingCloudSdk.f4250x     // Catch: java.lang.Throwable -> Laa
            if (r1 == 0) goto L1b
            com.salesforce.marketingcloud.MarketingCloudConfig r2 = r1.f4253a     // Catch: java.lang.Throwable -> Laa
            boolean r2 = com.salesforce.marketingcloud.internal.C4182e.m3354a(r4, r2)     // Catch: java.lang.Throwable -> Laa
            r1.m2834b(r2)     // Catch: java.lang.Throwable -> Laa
        L1b:
            com.salesforce.marketingcloud.MarketingCloudSdk r1 = new com.salesforce.marketingcloud.MarketingCloudSdk     // Catch: java.lang.Throwable -> Laa
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> Laa
            com.salesforce.marketingcloud.MarketingCloudSdk.f4250x = r1     // Catch: java.lang.Throwable -> Laa
            r4 = 0
            if (r5 == 0) goto L2a
            java.lang.String r5 = r5.getRegistrationId()     // Catch: java.lang.Throwable -> Laa
            goto L2b
        L2a:
            r5 = r4
        L2b:
            com.salesforce.marketingcloud.MarketingCloudSdk r1 = com.salesforce.marketingcloud.MarketingCloudSdk.f4250x     // Catch: java.lang.Throwable -> Laa
            com.salesforce.marketingcloud.InitializationStatus r5 = r1.m2829a(r5)     // Catch: java.lang.Throwable -> Laa
            java.lang.String r1 = "MarketingCloudSdk init finished with status: %s"
            java.lang.Object[] r2 = new java.lang.Object[]{r5}     // Catch: java.lang.Throwable -> Laa
            com.salesforce.marketingcloud.C4170g.m3202a(r3, r1, r2)     // Catch: java.lang.Throwable -> Laa
            boolean r1 = r5.getIsUsable()     // Catch: java.lang.Throwable -> Laa
            com.salesforce.marketingcloud.MarketingCloudSdk.f4243A = r1     // Catch: java.lang.Throwable -> Laa
            r1 = 0
            com.salesforce.marketingcloud.MarketingCloudSdk.f4252z = r1     // Catch: java.lang.Throwable -> Laa
            boolean r2 = com.salesforce.marketingcloud.MarketingCloudSdk.f4243A     // Catch: java.lang.Throwable -> Laa
            if (r2 == 0) goto L8d
            com.salesforce.marketingcloud.MarketingCloudSdk r4 = com.salesforce.marketingcloud.MarketingCloudSdk.f4250x     // Catch: java.lang.Throwable -> Laa
            r4.m2831a(r5)     // Catch: java.lang.Throwable -> Laa
            com.salesforce.marketingcloud.MarketingCloudSdk r4 = com.salesforce.marketingcloud.MarketingCloudSdk.f4250x     // Catch: java.lang.Throwable -> Laa
            com.salesforce.marketingcloud.b r2 = r4.f4258f     // Catch: java.lang.Throwable -> Laa
            r2.m3029a(r4)     // Catch: java.lang.Throwable -> Laa
            java.util.List<com.salesforce.marketingcloud.MarketingCloudSdk$c> r4 = com.salesforce.marketingcloud.MarketingCloudSdk.f4249w     // Catch: java.lang.Throwable -> Laa
            monitor-enter(r4)     // Catch: java.lang.Throwable -> Laa
            com.salesforce.marketingcloud.MarketingCloudSdk.f4244B = r1     // Catch: java.lang.Throwable -> L8a
            java.lang.String r1 = "Delivering queued SDK requests to %s listeners"
            int r2 = r4.size()     // Catch: java.lang.Throwable -> L8a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L8a
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.Throwable -> L8a
            com.salesforce.marketingcloud.C4170g.m3213d(r3, r1, r2)     // Catch: java.lang.Throwable -> L8a
            boolean r3 = r4.isEmpty()     // Catch: java.lang.Throwable -> L8a
            if (r3 != 0) goto L88
            java.util.Iterator r3 = r4.iterator()     // Catch: java.lang.Throwable -> L8a
        L73:
            boolean r1 = r3.hasNext()     // Catch: java.lang.Throwable -> L8a
            if (r1 == 0) goto L83
            java.lang.Object r1 = r3.next()     // Catch: java.lang.Throwable -> L8a
            com.salesforce.marketingcloud.MarketingCloudSdk$c r1 = (com.salesforce.marketingcloud.MarketingCloudSdk.AbstractC4088c) r1     // Catch: java.lang.Throwable -> L8a
            r1.m2840a()     // Catch: java.lang.Throwable -> L8a
            goto L73
        L83:
            java.util.List<com.salesforce.marketingcloud.MarketingCloudSdk$c> r3 = com.salesforce.marketingcloud.MarketingCloudSdk.f4249w     // Catch: java.lang.Throwable -> L8a
            r3.clear()     // Catch: java.lang.Throwable -> L8a
        L88:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L8a
            goto L9b
        L8a:
            r3 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L8a
            throw r3     // Catch: java.lang.Throwable -> Laa
        L8d:
            com.salesforce.marketingcloud.MarketingCloudSdk r3 = com.salesforce.marketingcloud.MarketingCloudSdk.f4250x     // Catch: java.lang.Throwable -> Laa
            r3.m2832a(r1)     // Catch: java.lang.Throwable -> Laa
            com.salesforce.marketingcloud.MarketingCloudSdk.f4250x = r4     // Catch: java.lang.Throwable -> Laa
            java.util.List<com.salesforce.marketingcloud.MarketingCloudSdk$c> r3 = com.salesforce.marketingcloud.MarketingCloudSdk.f4249w     // Catch: java.lang.Throwable -> Laa
            monitor-enter(r3)     // Catch: java.lang.Throwable -> Laa
            r3.clear()     // Catch: java.lang.Throwable -> La7
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La7
        L9b:
            java.lang.Object r3 = com.salesforce.marketingcloud.MarketingCloudSdk.f4248v     // Catch: java.lang.Throwable -> Laa
            r3.notifyAll()     // Catch: java.lang.Throwable -> Laa
            if (r6 == 0) goto La5
            r6.complete(r5)     // Catch: java.lang.Throwable -> Laa
        La5:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Laa
            return
        La7:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La7
            throw r4     // Catch: java.lang.Throwable -> Laa
        Laa:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Laa
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.MarketingCloudSdk.m2830a(android.content.Context, com.salesforce.marketingcloud.MarketingCloudConfig, com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents, com.salesforce.marketingcloud.MarketingCloudSdk$InitializationListener):void");
    }

    /* JADX INFO: renamed from: b */
    static void m2833b(Context context, MarketingCloudConfig marketingCloudConfig, SFMCSdkComponents sFMCSdkComponents, InitializationListener initializationListener) {
        MarketingCloudSdk marketingCloudSdk;
        String str = f4247u;
        C4170g.m3213d(str, "~~ MarketingCloudSdk v%s init() ~~", getSdkVersionName());
        C4391j.m4326a(context, "Context cannot be null.");
        C4391j.m4326a(marketingCloudConfig, "Config cannot be null.");
        C4181d.m3349a(marketingCloudConfig.applicationId(), marketingCloudConfig.accessToken(), marketingCloudConfig.senderId());
        synchronized (f4248v) {
            if ((f4243A || f4252z) && (marketingCloudSdk = f4250x) != null && marketingCloudConfig.equals(marketingCloudSdk.f4253a)) {
                C4170g.m3213d(str, "MarketingCloudSdk is already %s", f4243A ? "initialized" : "initializing");
                if (isReady() && initializationListener != null) {
                    initializationListener.complete(f4250x.f4268p);
                }
                return;
            }
            C4170g.m3213d(str, "Starting initialization", new Object[0]);
            f4243A = false;
            f4252z = true;
            f4244B = true;
            f4251y = context.getApplicationContext();
            new Thread(new RunnableC4086a(context, marketingCloudConfig, sFMCSdkComponents, initializationListener)).start();
        }
    }

    public static void requestSdk(WhenReadyListener whenReadyListener) {
        requestSdk(null, whenReadyListener);
    }

    /* JADX INFO: renamed from: b */
    private void m2834b(boolean z) {
        for (int size = this.f4254b.size() - 1; size >= 0; size--) {
            try {
                this.f4254b.get(size).tearDown(z);
            } catch (Exception e) {
                C4170g.m3207b(f4247u, e, "Error encountered tearing down component.", new Object[0]);
            }
        }
        this.f4254b.clear();
        C4189l c4189l = this.f4270r;
        if (c4189l != null) {
            c4189l.m3400c();
        }
        C4374j c4374j = this.f4259g;
        if (c4374j != null) {
            try {
                c4374j.m4246x();
            } catch (Exception e2) {
                C4170g.m3207b(f4247u, e2, "Error encountered tearing down storage.", new Object[0]);
            }
            this.f4259g = null;
        }
        List<AbstractC4088c> list = f4249w;
        synchronized (list) {
            list.clear();
        }
        f4243A = false;
        f4244B = true;
    }

    /* JADX INFO: renamed from: a */
    public C4174c m2836a() {
        return this.f4260h;
    }

    /* JADX INFO: renamed from: a */
    private InitializationStatus m2829a(String str) {
        InitializationStatus.C4081a c4081a;
        String strM4266a;
        if (C4383b.m4261a()) {
            return C4180c.m3342a();
        }
        InitializationStatus.C4081a c4081aM3343b = C4180c.m3343b();
        try {
            strM4266a = C4386e.m4266a(f4251y, str);
            try {
                this.f4270r = new C4189l();
                C4374j c4374j = new C4374j(f4251y, new C4382a(f4251y, this.f4253a.applicationId(), this.f4253a.accessToken(), strM4266a), this.f4253a.applicationId(), this.f4253a.accessToken(), this.f4270r);
                this.f4259g = c4374j;
                c4374j.m4234a(c4081aM3343b);
            } catch (Throwable th) {
                C4170g.m3203a(f4247u, th, "Unable to initialize SDK storage.", new Object[0]);
                c4081aM3343b.m2803a(th);
            }
        } catch (Exception e) {
            e = e;
            c4081a = c4081aM3343b;
            c4081a.m2803a(e);
            C4170g.m3207b(f4247u, e, "Something wrong with internal init", new Object[0]);
            return c4081a.m2799a();
        }
        if (!c4081aM3343b.m2806b()) {
            C4309d.m3922a(this.f4253a, f4251y, strM4266a, str);
            return c4081aM3343b.m2799a();
        }
        this.f4257e = new C4140c(f4251y, Executors.newSingleThreadExecutor());
        this.f4260h = new C4174c(f4251y, this.f4259g.mo4222f(), this.f4270r);
        C4093b c4093b = new C4093b(f4251y, this.f4259g, this.f4257e);
        C4113h c4113h = new C4113h(this.f4253a, this.f4259g, strM4266a, c4093b, this.f4257e, this.f4260h, this.f4270r);
        this.f4267o = c4113h;
        C4193k c4193k = new C4193k(strM4266a, this.f4253a, this.f4259g, this.f4260h, this.f4257e, c4093b, this.f4270r, c4113h);
        this.f4258f = new C4137b(c4193k, this.f4259g.m4238o());
        this.f4256d = AbstractC4200f.m3489a(f4251y, this.f4253a);
        AbstractC4280e abstractC4280eM3910a = AbstractC4280e.m3910a(f4251y, this.f4253a);
        this.f4263k = C4273a.m3855a(f4251y, this.f4259g, this.f4253a.notificationCustomizationOptions(), c4113h);
        this.f4261i = new C4263a(this.f4253a, this.f4259g, strM4266a, this.f4257e, c4093b, this.f4260h, this.f4270r, c4113h);
        InitializationStatus.C4081a c4081a2 = c4081aM3343b;
        try {
            this.f4265m = new C4236d(f4251y, this.f4253a, this.f4259g, strM4266a, this.f4256d, abstractC4280eM3910a, this.f4257e, c4093b, this.f4260h, this.f4263k, this.f4270r, c4113h);
            this.f4264l = new C4268a(f4251y, this.f4259g, this.f4263k, c4093b, this.f4253a.senderId());
            C4311f c4311f = new C4311f(strM4266a, this.f4253a.applicationId(), C4389h.m4319a(f4251y));
            this.f4262j = new C4309d(f4251y, this.f4253a, this.f4259g, c4311f, this.f4257e, c4093b, this.f4260h, this.f4264l, this.f4270r, this.f4255c);
            C4143a c4143a = new C4143a(c4193k, this.f4259g, c4113h);
            Context context = f4251y;
            C4374j c4374j2 = this.f4259g;
            this.f4269q = new InAppMessageComponent(context, c4374j2, c4093b, c4193k, this.f4257e, C4217o.m3562a(context, c4374j2), this.f4253a.urlHandler(), this.f4270r, c4113h, this.f4255c, c4143a);
            this.f4266n = new C4152c(f4251y, c4311f, this.f4259g, c4193k, this.f4257e, c4113h, this.f4270r, this.f4255c, c4143a, this.f4269q);
            this.f4254b.add(this.f4257e);
            this.f4254b.add(LifecycleManager.m3032a((Application) f4251y.getApplicationContext()));
            this.f4254b.add(this.f4260h);
            this.f4254b.add(c4093b);
            this.f4254b.add(c4113h);
            this.f4254b.add(c4193k);
            this.f4254b.add(this.f4258f);
            this.f4254b.add(this.f4256d);
            this.f4254b.add(abstractC4280eM3910a);
            this.f4254b.add(this.f4261i);
            this.f4254b.add(this.f4263k);
            this.f4254b.add(this.f4265m);
            this.f4254b.add(this.f4264l);
            this.f4254b.add(this.f4262j);
            this.f4254b.add(c4143a);
            this.f4254b.add(this.f4269q);
            this.f4254b.add(this.f4266n);
            int iM3028a = this.f4258f.m3028a();
            C4170g.m3213d(f4247u, "Initializing all components with control channel flag [%d]", Integer.valueOf(iM3028a));
            for (InterfaceC4146d interfaceC4146d : this.f4254b) {
                C4170g.m3213d(f4247u, "init called for %s", interfaceC4146d.componentName());
                if (interfaceC4146d instanceof InterfaceC4147e) {
                    c4081a = c4081a2;
                    try {
                        ((InterfaceC4147e) interfaceC4146d).init(c4081a, iM3028a);
                    } catch (Exception e2) {
                        e = e2;
                        c4081a.m2803a(e);
                        C4170g.m3207b(f4247u, e, "Something wrong with internal init", new Object[0]);
                        return c4081a.m2799a();
                    }
                } else {
                    c4081a = c4081a2;
                    if (interfaceC4146d instanceof AbstractC4169f) {
                        ((AbstractC4169f) interfaceC4146d).mo2859a(c4081a);
                    }
                }
                c4081a.m2801a(interfaceC4146d);
                c4081a2 = c4081a;
            }
            c4081a = c4081a2;
        } catch (Exception e3) {
            e = e3;
            c4081a = c4081a2;
        }
        return c4081a.m2799a();
    }

    /* JADX INFO: renamed from: a */
    private void m2832a(boolean z) {
        m2834b(z);
        f4252z = false;
    }

    /* JADX INFO: renamed from: a */
    private void m2831a(InitializationStatus initializationStatus) {
        this.f4268p = initializationStatus;
    }
}
