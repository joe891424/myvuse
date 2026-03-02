package com.salesforce.marketingcloud.messages.inbox;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.InterfaceC4112g;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4179b;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.inbox.InboxMessageManager;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.storage.InterfaceC4372h;
import com.salesforce.marketingcloud.storage.p047db.C4348g;
import com.salesforce.marketingcloud.storage.p047db.C4350i;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c */
/* JADX INFO: loaded from: classes6.dex */
class C4265c implements InboxMessageManager {

    /* JADX INFO: renamed from: d */
    final C4374j f5312d;

    /* JADX INFO: renamed from: e */
    final InterfaceC4112g f5313e;

    /* JADX INFO: renamed from: f */
    final C4174c f5314f;

    /* JADX INFO: renamed from: g */
    final MarketingCloudConfig f5315g;

    /* JADX INFO: renamed from: h */
    final String f5316h;

    /* JADX INFO: renamed from: j */
    private final C4093b f5318j;

    /* JADX INFO: renamed from: k */
    private final C4189l f5319k;

    /* JADX INFO: renamed from: m */
    private InboxMessageManager.InboxRefreshListener f5321m;

    /* JADX INFO: renamed from: n */
    private boolean f5322n;

    /* JADX INFO: renamed from: i */
    private final Set<InboxMessageManager.InboxResponseListener> f5317i = new ArraySet();

    /* JADX INFO: renamed from: l */
    private final Object f5320l = new Object();

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$a */
    class a extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5323b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.f5323b = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4265c.this.f5312d.m4240q().mo4098b(TextUtils.split(this.f5323b, ","));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$b */
    class b implements MarketingCloudSdk.WhenReadyListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ EnumC4172a f5325a;

        b(EnumC4172a enumC4172a) {
            this.f5325a = enumC4172a;
        }

        @Override // com.salesforce.marketingcloud.MarketingCloudSdk.WhenReadyListener
        public void ready(MarketingCloudSdk marketingCloudSdk) {
            C4265c c4265c = C4265c.this;
            c4265c.f5314f.m3298a(this.f5325a.m3252a(c4265c.f5315g, c4265c.f5312d.mo4220c(), EnumC4172a.m3247b(C4265c.this.f5315g.applicationId(), C4265c.this.f5316h)));
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$c */
    class c extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ InterfaceC4372h f5327b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, InterfaceC4372h interfaceC4372h) {
            super(str, objArr);
            this.f5327b = interfaceC4372h;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            this.f5327b.mo4103h();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$d */
    class d extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ InboxMessage f5328b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, InboxMessage inboxMessage) {
            super(str, objArr);
            this.f5328b = inboxMessage;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4265c.this.f5312d.m4240q().mo4096a(this.f5328b, C4265c.this.f5312d.mo4218b());
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$e */
    class e extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5330b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.f5330b = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4265c.this.setMessageRead(this.f5330b);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$f */
    class f extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5332b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.f5332b = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4265c.this.f5312d.m4240q().mo4099c(this.f5332b);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$g */
    class g extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f5334b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Object[] objArr, String str2) {
            super(str, objArr);
            this.f5334b = str2;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4265c.this.f5312d.m4240q().mo4100d(this.f5334b);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$h */
    class h extends AbstractRunnableC4184g {
        h(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4265c.this.f5312d.m4240q().mo4105j();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$i */
    class i extends AbstractRunnableC4184g {
        i(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            C4265c.this.f5312d.m4240q().mo4097b();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$j */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4265c.this.m3814b(false);
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$k */
    class k extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ List f5339b;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.c$k$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k kVar = k.this;
                C4265c.this.m3810a(kVar.f5339b);
                C4265c.this.m3814b(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, Object[] objArr, List list) {
            super(str, objArr);
            this.f5339b = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void mo2882a() {
            /*
                r9 = this;
                com.salesforce.marketingcloud.messages.inbox.c r0 = com.salesforce.marketingcloud.messages.inbox.C4265c.this
                com.salesforce.marketingcloud.storage.j r0 = r0.f5312d
                com.salesforce.marketingcloud.storage.h r0 = r0.m4240q()
                com.salesforce.marketingcloud.messages.inbox.c r1 = com.salesforce.marketingcloud.messages.inbox.C4265c.this
                com.salesforce.marketingcloud.storage.j r1 = r1.f5312d
                com.salesforce.marketingcloud.util.c r1 = r1.mo4218b()
                java.util.ArrayList r2 = new java.util.ArrayList
                java.util.List r3 = r9.f5339b
                int r3 = r3.size()
                r2.<init>(r3)
                java.util.List r3 = r9.f5339b
                boolean r3 = r3.isEmpty()
                if (r3 != 0) goto L9f
                java.util.List r3 = r9.f5339b
                java.util.Iterator r3 = r3.iterator()
            L29:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L9f
                java.lang.Object r4 = r3.next()
                com.salesforce.marketingcloud.messages.inbox.InboxMessage r4 = (com.salesforce.marketingcloud.messages.inbox.InboxMessage) r4
                java.lang.String r5 = r4.m3794id()
                r2.add(r5)
                java.lang.String r5 = r4.m3794id()
                com.salesforce.marketingcloud.storage.h$b r5 = r0.mo4102f(r5)
                r6 = 1
                if (r5 == 0) goto L92
                java.lang.String r7 = r5.f5717b
                if (r7 != 0) goto L56
                boolean r7 = r5.f5720e
                com.salesforce.marketingcloud.internal.C4179b.m3331a(r4, r7)
                boolean r7 = r5.f5719d
                com.salesforce.marketingcloud.internal.C4179b.m3335c(r4, r7)
                goto L71
            L56:
                java.lang.String r8 = com.salesforce.marketingcloud.internal.C4179b.m3330a(r4)
                boolean r7 = r7.equals(r8)
                if (r7 == 0) goto L71
                boolean r7 = r5.f5720e
                com.salesforce.marketingcloud.internal.C4179b.m3331a(r4, r7)
                boolean r7 = r5.f5719d
                com.salesforce.marketingcloud.internal.C4179b.m3335c(r4, r7)
                java.util.Date r7 = r5.f5718c
                if (r7 != 0) goto L6f
                goto L71
            L6f:
                r7 = 0
                goto L72
            L71:
                r7 = r6
            L72:
                boolean r8 = r5.f5721f
                com.salesforce.marketingcloud.internal.C4179b.m3333b(r4, r8)
                int r8 = com.salesforce.marketingcloud.internal.C4179b.m3334c(r4)
                if (r8 <= 0) goto L80
                com.salesforce.marketingcloud.internal.C4179b.m3335c(r4, r6)
            L80:
                boolean r8 = r5.f5720e
                if (r8 != 0) goto L8e
                boolean r5 = r5.f5719d
                if (r5 == 0) goto L91
                int r5 = com.salesforce.marketingcloud.internal.C4179b.m3334c(r4)
                if (r5 != 0) goto L91
            L8e:
                com.salesforce.marketingcloud.internal.C4179b.m3333b(r4, r6)
            L91:
                r6 = r7
            L92:
                r0.mo4096a(r4, r1)
                if (r6 == 0) goto L29
                com.salesforce.marketingcloud.messages.inbox.c r5 = com.salesforce.marketingcloud.messages.inbox.C4265c.this
                com.salesforce.marketingcloud.analytics.g r5 = r5.f5313e
                r5.mo2916a(r4)
                goto L29
            L9f:
                r0.mo4093a(r2)
                android.os.Handler r0 = new android.os.Handler
                android.os.Looper r1 = android.os.Looper.getMainLooper()
                r0.<init>(r1)
                com.salesforce.marketingcloud.messages.inbox.c$k$a r1 = new com.salesforce.marketingcloud.messages.inbox.c$k$a
                r1.<init>()
                r0.post(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.inbox.C4265c.k.mo2882a():void");
        }
    }

    C4265c(MarketingCloudConfig marketingCloudConfig, C4374j c4374j, String str, C4093b c4093b, C4174c c4174c, InterfaceC4112g interfaceC4112g, C4189l c4189l) {
        this.f5315g = marketingCloudConfig;
        this.f5312d = c4374j;
        this.f5316h = str;
        this.f5318j = c4093b;
        this.f5314f = c4174c;
        this.f5313e = interfaceC4112g;
        this.f5319k = c4189l;
    }

    /* JADX INFO: renamed from: a */
    void m3804a() {
        this.f5322n = false;
        m3816d();
    }

    /* JADX INFO: renamed from: b */
    void m3811b() {
        this.f5322n = true;
        m3803a(false);
    }

    /* JADX INFO: renamed from: c */
    JSONObject m3815c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C4348g.f5600e, this.f5312d.m4240q().mo4106n(this.f5312d.mo4218b()));
            return jSONObject;
        } catch (JSONException e2) {
            C4170g.m3207b(InboxMessageManager.TAG, e2, "Failed to create our component state JSONObject.", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    void m3816d() {
        String string;
        List<InterfaceC4372h.b> listMo4104i = this.f5312d.m4240q().mo4104i();
        int size = listMo4104i.size();
        if (size > 0) {
            ArrayList arrayList = new ArrayList(size);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", this.f5316h);
                String strM4336a = C4393l.m4336a(new Date());
                for (InterfaceC4372h.b bVar : listMo4104i) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("actionParameters", jSONObject);
                    jSONObject2.put("messageId", bVar.f5716a);
                    jSONObject2.put("actionDate", strM4336a);
                    jSONObject2.put(UrlHandler.ACTION, bVar.f5720e ? "Deleted" : "Viewed");
                    jSONArray.put(jSONObject2);
                    arrayList.add(bVar.f5716a);
                }
                EnumC4172a enumC4172a = EnumC4172a.f4820l;
                MarketingCloudConfig marketingCloudConfig = this.f5315g;
                InterfaceC4340c interfaceC4340cMo4220c = this.f5312d.mo4220c();
                Object[] objArrM3244a = EnumC4172a.m3244a(this.f5315g.applicationId());
                if (jSONArray instanceof JSONArray) {
                    string = JSONArrayInstrumentation.toString(jSONArray);
                } else {
                    string = jSONArray.toString();
                }
                C4173b c4173bM3253a = enumC4172a.m3253a(marketingCloudConfig, interfaceC4340cMo4220c, objArrM3244a, string);
                c4173bM3253a.m3264a(TextUtils.join(",", arrayList));
                this.f5314f.m3298a(c4173bM3253a);
            } catch (JSONException e2) {
                C4170g.m3207b(InboxMessageManager.TAG, e2, "Failed to create Inbox status payload.  Status updates not sent to Marketing Cloud", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void deleteMessage(InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            C4170g.m3206b(InboxMessageManager.TAG, "InboxMessage was null and could not be updated.  Call to deleteMessage() ignored.", new Object[0]);
        } else {
            C4179b.m3331a(inboxMessage, true);
            deleteMessage(inboxMessage.m3794id());
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void disableInbox() {
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void enableInbox() {
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getDeletedMessageCount() {
        return this.f5312d.m4240q().mo4092a(InterfaceC4372h.a.DELETED);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getDeletedMessages() {
        return this.f5312d.m4240q().mo4095a(this.f5312d.mo4218b(), InterfaceC4372h.a.DELETED);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getMessageCount() {
        return this.f5312d.m4240q().mo4092a(InterfaceC4372h.a.NOT_DELETED);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getMessages() {
        return this.f5312d.m4240q().mo4095a(this.f5312d.mo4218b(), InterfaceC4372h.a.NOT_DELETED);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getReadMessageCount() {
        return this.f5312d.m4240q().mo4092a(InterfaceC4372h.a.READ);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getReadMessages() {
        return this.f5312d.m4240q().mo4095a(this.f5312d.mo4218b(), InterfaceC4372h.a.READ);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getUnreadMessageCount() {
        return this.f5312d.m4240q().mo4092a(InterfaceC4372h.a.UNREAD);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getUnreadMessages() {
        return this.f5312d.m4240q().mo4095a(this.f5312d.mo4218b(), InterfaceC4372h.a.UNREAD);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public boolean isInboxEnabled() {
        return true;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void markAllMessagesDeleted() {
        this.f5319k.m3399b().execute(new i("delete_all", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void markAllMessagesRead() {
        this.f5319k.m3399b().execute(new h("mark_all_read", new Object[0]));
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void refreshInbox(InboxMessageManager.InboxRefreshListener inboxRefreshListener) {
        synchronized (this.f5320l) {
            if (this.f5321m == null) {
                this.f5321m = inboxRefreshListener;
                C4170g.m3213d(InboxMessageManager.TAG, "Refreshing inbox messages", new Object[0]);
                m3803a(true);
            } else {
                C4170g.m3213d(InboxMessageManager.TAG, "Refresh already in progress.", new Object[0]);
                try {
                    inboxRefreshListener.onRefreshComplete(false);
                } catch (Exception e2) {
                    C4170g.m3207b(InboxMessageManager.TAG, e2, "Error delivering Refresh Complete result to %s", inboxRefreshListener.getClass().getName());
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void registerInboxResponseListener(InboxMessageManager.InboxResponseListener inboxResponseListener) {
        if (inboxResponseListener != null) {
            synchronized (this.f5317i) {
                this.f5317i.add(inboxResponseListener);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void setMessageRead(InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            C4170g.m3206b(InboxMessageManager.TAG, "InboxMessage was null and could not be updated.  Call to setMessageRead() ignored.", new Object[0]);
        } else {
            C4179b.m3335c(inboxMessage, true);
            setMessageRead(inboxMessage.m3794id());
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void unregisterInboxResponseListener(InboxMessageManager.InboxResponseListener inboxResponseListener) {
        synchronized (this.f5317i) {
            this.f5317i.remove(inboxResponseListener);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3803a(boolean z) {
        MarketingCloudSdk.requestSdk(new b(z ? EnumC4172a.f4819k : EnumC4172a.f4818j));
    }

    /* JADX INFO: renamed from: b */
    void m3814b(boolean z) {
        synchronized (this.f5320l) {
            InboxMessageManager.InboxRefreshListener inboxRefreshListener = this.f5321m;
            if (inboxRefreshListener != null) {
                try {
                    inboxRefreshListener.onRefreshComplete(z);
                } catch (Exception e2) {
                    C4170g.m3207b(InboxMessageManager.TAG, e2, "InboxRefreshListener threw an exception", new Object[0]);
                }
                this.f5321m = null;
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void deleteMessage(String str) {
        this.f5319k.m3399b().execute(new f("inbox_delete", new Object[0], str));
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void setMessageRead(String str) {
        this.f5319k.m3399b().execute(new g("mark_read", new Object[0], str));
    }

    /* JADX INFO: renamed from: a */
    void m3808a(InboxMessage inboxMessage) {
        this.f5319k.m3399b().execute(new d("inbox_push_received", new Object[0], inboxMessage));
        if (this.f5322n) {
            m3803a(false);
        }
    }

    /* JADX INFO: renamed from: b */
    void m3813b(List<InboxMessage> list) {
        this.f5319k.m3399b().execute(new k("inbox_updated", new Object[0], list));
    }

    /* JADX INFO: renamed from: a */
    void m3809a(NotificationMessage notificationMessage) {
        if (this.f5315g.markMessageReadOnInboxNotificationOpen()) {
            this.f5319k.m3399b().execute(new e("inbox_notification_opened", new Object[0], notificationMessage.m3845id()));
        }
    }

    /* JADX INFO: renamed from: b */
    void m3812b(int i2, String str) {
        C4170g.m3210c(InboxMessageManager.TAG, "Request failed: %d - %s", Integer.valueOf(i2), str);
        this.f5318j.m2865b(AbstractC4092a.a.f4321f);
    }

    /* JADX INFO: renamed from: a */
    void m3810a(List<InboxMessage> list) {
        synchronized (this.f5317i) {
            if (!this.f5317i.isEmpty()) {
                for (InboxMessageManager.InboxResponseListener inboxResponseListener : this.f5317i) {
                    if (inboxResponseListener != null) {
                        try {
                            inboxResponseListener.onInboxMessagesChanged(list);
                        } catch (Exception e2) {
                            C4170g.m3207b(InboxMessageManager.TAG, e2, "%s threw an exception while processing the inbox messages response", inboxResponseListener.getClass().getName());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m3805a(int i2, String str) {
        C4170g.m3210c(InboxMessageManager.TAG, "Request failed: %d - %s", Integer.valueOf(i2), str);
        new Handler(Looper.getMainLooper()).post(new j());
    }

    /* JADX INFO: renamed from: a */
    void m3806a(C4173b c4173b) {
        if (c4173b.m3279q() != null) {
            this.f5318j.m2866c(AbstractC4092a.a.f4321f);
            this.f5319k.m3399b().execute(new a("inbox_status_updated", new Object[0], c4173b.m3279q()));
        }
    }

    /* JADX INFO: renamed from: a */
    void m3807a(C4175d c4175d) {
        int length;
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(c4175d.m3301a()).optJSONArray(C4350i.f5612e);
            List<InboxMessage> listEmptyList = Collections.emptyList();
            if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
                listEmptyList = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        listEmptyList.add(new InboxMessage(jSONArrayOptJSONArray.getJSONObject(i2)));
                    } catch (Exception e2) {
                        C4170g.m3207b(InboxMessageManager.TAG, e2, "Failed to parse inbox message", new Object[0]);
                    }
                }
            }
            m3813b(listEmptyList);
        } catch (Exception e3) {
            C4170g.m3207b(InboxMessageManager.TAG, e3, "Failed to parse inbox messages response", new Object[0]);
            m3805a(-1, "Failed to parse response");
        }
    }

    /* JADX INFO: renamed from: a */
    static void m3802a(C4374j c4374j, C4093b c4093b, C4189l c4189l, boolean z) {
        c4093b.m2868d(AbstractC4092a.a.f4321f);
        if (z) {
            c4189l.m3399b().execute(new c("inbox_shutdown", new Object[0], c4374j.m4240q()));
        }
    }
}
