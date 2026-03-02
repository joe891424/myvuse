package com.salesforce.marketingcloud.messages.inbox;

import android.os.Bundle;
import com.salesforce.marketingcloud.C4137b;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.InterfaceC4147e;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.InterfaceC4112g;
import com.salesforce.marketingcloud.behaviors.C4140c;
import com.salesforce.marketingcloud.behaviors.EnumC4138a;
import com.salesforce.marketingcloud.behaviors.InterfaceC4139b;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.inbox.InboxMessageManager;
import com.salesforce.marketingcloud.notifications.C4273a;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.toggles.EnumC4380a;
import com.salesforce.marketingcloud.util.C4391j;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4263a implements InterfaceC4147e, InboxMessageManager, InterfaceC4139b, C4174c.c, C4093b.b {

    /* JADX INFO: renamed from: n */
    private static final String f5296n = "InboxMessagingEnabled";

    /* JADX INFO: renamed from: o */
    private static final String f5297o = "8";

    /* JADX INFO: renamed from: p */
    private static final Object f5298p = new Object();

    /* JADX INFO: renamed from: d */
    private final MarketingCloudConfig f5299d;

    /* JADX INFO: renamed from: e */
    private final C4374j f5300e;

    /* JADX INFO: renamed from: f */
    private final String f5301f;

    /* JADX INFO: renamed from: g */
    private final C4140c f5302g;

    /* JADX INFO: renamed from: h */
    private final C4093b f5303h;

    /* JADX INFO: renamed from: i */
    private final C4174c f5304i;

    /* JADX INFO: renamed from: j */
    private final InterfaceC4112g f5305j;

    /* JADX INFO: renamed from: k */
    private C4265c f5306k;

    /* JADX INFO: renamed from: l */
    private C4189l f5307l;

    /* JADX INFO: renamed from: m */
    private EnumC4380a f5308m;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.a$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f5309a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f5310b;

        /* JADX INFO: renamed from: c */
        static final /* synthetic */ int[] f5311c;

        static {
            int[] iArr = new int[AbstractC4092a.a.values().length];
            f5311c = iArr;
            try {
                iArr[AbstractC4092a.a.f4321f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[EnumC4172a.values().length];
            f5310b = iArr2;
            try {
                iArr2[EnumC4172a.f4818j.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5310b[EnumC4172a.f4819k.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5310b[EnumC4172a.f4820l.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[EnumC4138a.values().length];
            f5309a = iArr3;
            try {
                iArr3[EnumC4138a.BEHAVIOR_APP_FOREGROUNDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5309a[EnumC4138a.BEHAVIOR_APP_BACKGROUNDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5309a[EnumC4138a.BEHAVIOR_SDK_PUSH_RECEIVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5309a[EnumC4138a.BEHAVIOR_SDK_NOTIFICATION_OPENED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public C4263a(MarketingCloudConfig marketingCloudConfig, C4374j c4374j, String str, C4140c c4140c, C4093b c4093b, C4174c c4174c, C4189l c4189l, InterfaceC4112g interfaceC4112g) {
        this.f5299d = (MarketingCloudConfig) C4391j.m4326a(marketingCloudConfig, "MarketingCloudConfig is null.");
        this.f5300e = (C4374j) C4391j.m4326a(c4374j, "Storage is null.");
        this.f5301f = (String) C4391j.m4325a(str, "You must provide the Device ID.");
        this.f5302g = (C4140c) C4391j.m4326a(c4140c, "BehaviorManager is null.");
        this.f5303h = (C4093b) C4391j.m4326a(c4093b, "AlarmScheduler is null.");
        this.f5304i = (C4174c) C4391j.m4326a(c4174c, "RequestManager is null.");
        this.f5305j = (InterfaceC4112g) C4391j.m4326a(interfaceC4112g, "InboxAnalyticEventListener is null.");
        this.f5307l = c4189l;
    }

    /* JADX INFO: renamed from: a */
    private void m3796a() {
        this.f5306k = new C4265c(this.f5299d, this.f5300e, this.f5301f, this.f5303h, this.f5304i, this.f5305j, this.f5307l);
        this.f5304i.m3297a(EnumC4172a.f4818j, this);
        this.f5304i.m3297a(EnumC4172a.f4819k, this);
        this.f5304i.m3297a(EnumC4172a.f4820l, this);
        this.f5303h.m2861a(this, AbstractC4092a.a.f4321f);
        this.f5302g.m3037a(this, EnumSet.of(EnumC4138a.BEHAVIOR_APP_FOREGROUNDED, EnumC4138a.BEHAVIOR_SDK_PUSH_RECEIVED, EnumC4138a.BEHAVIOR_APP_BACKGROUNDED, EnumC4138a.BEHAVIOR_SDK_NOTIFICATION_OPENED));
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public final String componentName() {
        return "InboxMessageManager";
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public JSONObject componentState() {
        try {
            C4265c c4265c = this.f5306k;
            JSONObject jSONObjectM3815c = c4265c != null ? c4265c.m3815c() : new JSONObject();
            jSONObjectM3815c.put("inboxEnabled", isInboxEnabled());
            return jSONObjectM3815c;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void controlChannelInit(int i) {
        if (!C4137b.m3024a(i, 128)) {
            if (this.f5306k == null && isInboxEnabled()) {
                m3796a();
                return;
            }
            return;
        }
        this.f5306k = null;
        C4265c.m3802a(this.f5300e, this.f5303h, this.f5307l, C4137b.m3027c(i, 128));
        this.f5302g.m3036a(this);
        this.f5303h.m2869e(AbstractC4092a.a.f4321f);
        this.f5304i.m3296a(EnumC4172a.f4818j);
        this.f5304i.m3296a(EnumC4172a.f4819k);
        this.f5304i.m3296a(EnumC4172a.f4820l);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void deleteMessage(InboxMessage inboxMessage) {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.deleteMessage(inboxMessage);
        } else {
            C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to deleteMessage() was ignored.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void disableInbox() {
        synchronized (f5298p) {
            EnumC4380a enumC4380a = EnumC4380a.f5740c;
            this.f5308m = enumC4380a;
            this.f5300e.mo4222f().edit().putString(f5296n, this.f5308m.name()).apply();
            C4170g.m3202a(InboxMessageManager.TAG, "Inbox runtime toggle set to " + enumC4380a.name(), new Object[0]);
            this.f5306k = null;
            tearDown(false);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void enableInbox() {
        synchronized (f5298p) {
            if (C4137b.m3024a(C4137b.m3022a(this.f5300e.m4238o()), 128)) {
                return;
            }
            String str = InboxMessageManager.TAG;
            StringBuilder sb = new StringBuilder("Inbox runtime toggle set to ");
            EnumC4380a enumC4380a = EnumC4380a.f5739b;
            C4170g.m3202a(str, sb.append(enumC4380a.name()).toString(), new Object[0]);
            this.f5308m = enumC4380a;
            this.f5300e.mo4222f().edit().putString(f5296n, this.f5308m.name()).apply();
            m3796a();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getDeletedMessageCount() {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            return c4265c.getDeletedMessageCount();
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to getDeletedMessageCount() was ignored.", new Object[0]);
        return 0;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getDeletedMessages() {
        List<InboxMessage> listEmptyList = Collections.emptyList();
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            return c4265c.getDeletedMessages();
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to getDeletedMessages() was ignored.", new Object[0]);
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getMessageCount() {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            return c4265c.getMessageCount();
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to getMessageCount() was ignored.", new Object[0]);
        return 0;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getMessages() {
        List<InboxMessage> listEmptyList = Collections.emptyList();
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            return c4265c.getMessages();
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to getMessages() was ignored.", new Object[0]);
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getReadMessageCount() {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            return c4265c.getReadMessageCount();
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to getReadMessageCount() was ignored.", new Object[0]);
        return 0;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getReadMessages() {
        List<InboxMessage> listEmptyList = Collections.emptyList();
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            return c4265c.getReadMessages();
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to getReadMessages() was ignored.", new Object[0]);
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public int getUnreadMessageCount() {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            return c4265c.getUnreadMessageCount();
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to getUnreadMessageCount() was ignored.", new Object[0]);
        return 0;
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public List<InboxMessage> getUnreadMessages() {
        List<InboxMessage> listEmptyList = Collections.emptyList();
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            return c4265c.getUnreadMessages();
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to getUnreadMessages() was ignored.", new Object[0]);
        return listEmptyList;
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4147e
    public void init(InitializationStatus.C4081a c4081a, int i) {
        if (m3797a(i)) {
            m3796a();
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public boolean isInboxEnabled() {
        return m3797a(C4137b.m3022a(this.f5300e.m4238o()));
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void markAllMessagesDeleted() {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.markAllMessagesDeleted();
        } else {
            C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to markAllMessagesDeleted() was ignored.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void markAllMessagesRead() {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.markAllMessagesRead();
        } else {
            C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to markAllMessagesRead() was ignored.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.behaviors.InterfaceC4139b
    public void onBehavior(EnumC4138a enumC4138a, Bundle bundle) {
        NotificationMessage notificationMessage;
        if (this.f5306k != null) {
            int i = a.f5309a[enumC4138a.ordinal()];
            if (i == 1) {
                this.f5306k.m3811b();
                return;
            }
            if (i == 2) {
                this.f5306k.m3804a();
                return;
            }
            if (i != 3) {
                if (i == 4 && (notificationMessage = (NotificationMessage) bundle.get(C4273a.f5396p)) != null) {
                    this.f5306k.m3809a(notificationMessage);
                    return;
                }
                return;
            }
            if (m3798a(bundle)) {
                try {
                    this.f5306k.m3808a(new InboxMessage(bundle));
                } catch (Exception e) {
                    C4170g.m3207b(InboxMessageManager.TAG, e, "Failed to seed inbox_messages table with message: %s.", bundle.getString(NotificationMessage.NOTIF_KEY_ID));
                }
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void refreshInbox(InboxMessageManager.InboxRefreshListener inboxRefreshListener) {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.refreshInbox(inboxRefreshListener);
            return;
        }
        C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to refreshInbox() was ignored.", new Object[0]);
        if (inboxRefreshListener != null) {
            try {
                inboxRefreshListener.onRefreshComplete(false);
            } catch (Exception unused) {
                C4170g.m3206b(InboxMessageManager.TAG, "InboxRefreshListener threw an exception.", new Object[0]);
            }
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void registerInboxResponseListener(InboxMessageManager.InboxResponseListener inboxResponseListener) {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.registerInboxResponseListener(inboxResponseListener);
        } else {
            C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to registerInboxResponseListener() was ignored.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void setMessageRead(InboxMessage inboxMessage) {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.setMessageRead(inboxMessage);
        } else {
            C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to setMessageRead() was ignored.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.InterfaceC4146d
    public void tearDown(boolean z) {
        C4093b c4093b = this.f5303h;
        if (c4093b != null) {
            c4093b.m2869e(AbstractC4092a.a.f4321f);
        }
        C4140c c4140c = this.f5302g;
        if (c4140c != null) {
            c4140c.m3036a(this);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void unregisterInboxResponseListener(InboxMessageManager.InboxResponseListener inboxResponseListener) {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.unregisterInboxResponseListener(inboxResponseListener);
        } else {
            C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to unregisterInboxResponseListener() was ignored.", new Object[0]);
        }
    }

    C4263a(C4265c c4265c) {
        this.f5299d = null;
        this.f5300e = null;
        this.f5301f = null;
        this.f5302g = null;
        this.f5303h = null;
        this.f5304i = null;
        this.f5305j = null;
        this.f5306k = c4265c;
    }

    /* JADX INFO: renamed from: a */
    private EnumC4380a m3795a(EnumC4380a enumC4380a) {
        if (enumC4380a != null) {
            return enumC4380a;
        }
        String string = this.f5300e.mo4222f().getString(f5296n, null);
        return string == null ? EnumC4380a.f5738a : EnumC4380a.valueOf(string);
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void deleteMessage(String str) {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.deleteMessage(str);
        } else {
            C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to deleteMessage() was ignored.", new Object[0]);
        }
    }

    @Override // com.salesforce.marketingcloud.messages.inbox.InboxMessageManager
    public void setMessageRead(String str) {
        C4265c c4265c = this.f5306k;
        if (c4265c != null) {
            c4265c.setMessageRead(str);
        } else {
            C4170g.m3216e(InboxMessageManager.TAG, "Inbox messaging is disabled.  Call to setMessageRead() was ignored.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3797a(int i) {
        if (C4137b.m3024a(i, 128)) {
            return false;
        }
        if (this.f5308m == null) {
            this.f5308m = m3795a((EnumC4380a) null);
        }
        EnumC4380a enumC4380a = this.f5308m;
        return enumC4380a == EnumC4380a.f5739b || (enumC4380a == EnumC4380a.f5738a && this.f5299d.inboxEnabled());
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3798a(Bundle bundle) {
        return f5297o.equals(bundle.getString(NotificationMessage.NOTIF_KEY_MESSAGE_TYPE));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3799a(Map<String, String> map) {
        return f5297o.equals(map.get(NotificationMessage.NOTIF_KEY_MESSAGE_TYPE));
    }

    @Override // com.salesforce.marketingcloud.alarms.C4093b.b
    /* JADX INFO: renamed from: a */
    public void mo2870a(AbstractC4092a.a aVar) {
        if (this.f5306k == null || a.f5311c[aVar.ordinal()] != 1) {
            return;
        }
        this.f5306k.m3816d();
    }

    @Override // com.salesforce.marketingcloud.http.C4174c.c
    /* JADX INFO: renamed from: a */
    public void mo2932a(C4173b c4173b, C4175d c4175d) {
        if (this.f5306k != null) {
            int i = a.f5310b[c4173b.m3278p().ordinal()];
            if (i == 1 || i == 2) {
                if (c4175d.m3307g()) {
                    this.f5306k.m3807a(c4175d);
                    return;
                } else {
                    this.f5306k.m3805a(c4175d.m3302b(), c4175d.m3305e());
                    return;
                }
            }
            if (i != 3) {
                return;
            }
            if (c4175d.m3307g()) {
                this.f5306k.m3806a(c4173b);
            } else {
                this.f5306k.m3812b(c4175d.m3302b(), c4175d.m3305e());
            }
        }
    }
}
