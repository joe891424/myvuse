package com.salesforce.marketingcloud.storage;

import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.util.Date;
import java.util.List;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.h */
/* JADX INFO: loaded from: classes6.dex */
public interface InterfaceC4372h {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.h$a */
    public enum a {
        UNREAD,
        READ,
        DELETED,
        NOT_DELETED
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.h$b */
    public static class b {

        /* JADX INFO: renamed from: a */
        public final String f5716a;

        /* JADX INFO: renamed from: b */
        public final String f5717b;

        /* JADX INFO: renamed from: c */
        public final Date f5718c;

        /* JADX INFO: renamed from: d */
        public final boolean f5719d;

        /* JADX INFO: renamed from: e */
        public final boolean f5720e;

        /* JADX INFO: renamed from: f */
        public final boolean f5721f;

        public b(String str, String str2, Date date, boolean z, boolean z2, boolean z3) {
            this.f5716a = str;
            this.f5717b = str2;
            this.f5718c = date;
            this.f5719d = z;
            this.f5720e = z2;
            this.f5721f = z3;
        }
    }

    /* JADX INFO: renamed from: a */
    int mo4092a(a aVar);

    /* JADX INFO: renamed from: a */
    int mo4093a(List<String> list);

    /* JADX INFO: renamed from: a */
    InboxMessage mo4094a(String str, InterfaceC4384c interfaceC4384c);

    /* JADX INFO: renamed from: a */
    List<InboxMessage> mo4095a(InterfaceC4384c interfaceC4384c, a aVar);

    /* JADX INFO: renamed from: a */
    void mo4096a(InboxMessage inboxMessage, InterfaceC4384c interfaceC4384c);

    /* JADX INFO: renamed from: b */
    void mo4097b();

    /* JADX INFO: renamed from: b */
    void mo4098b(String[] strArr);

    /* JADX INFO: renamed from: c */
    void mo4099c(String str);

    /* JADX INFO: renamed from: d */
    void mo4100d(String str);

    /* JADX INFO: renamed from: e */
    boolean mo4101e(String str);

    /* JADX INFO: renamed from: f */
    b mo4102f(String str);

    /* JADX INFO: renamed from: h */
    int mo4103h();

    /* JADX INFO: renamed from: i */
    List<b> mo4104i();

    /* JADX INFO: renamed from: j */
    void mo4105j();

    /* JADX INFO: renamed from: n */
    List<InboxMessage> mo4106n(InterfaceC4384c interfaceC4384c);
}
