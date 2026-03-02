package com.salesforce.marketingcloud.analytics.etanalytics;

import android.text.TextUtils;
import com.salesforce.marketingcloud.analytics.AbstractC4114i;
import com.salesforce.marketingcloud.analytics.C4102a;
import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4179b;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.storage.C4374j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4107a extends AbstractC4114i {

    /* JADX INFO: renamed from: f */
    private static final int f4395f = 0;

    /* JADX INFO: renamed from: d */
    private final C4374j f4396d;

    /* JADX INFO: renamed from: e */
    private final C4189l f4397e;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.a$a */
    class a extends AbstractRunnableC4184g {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ C4374j f4398b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, C4374j c4374j) {
            super(str, objArr);
            this.f4398b = c4374j;
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            this.f4398b.m4236m().mo3985b(0);
        }
    }

    public C4107a(C4374j c4374j, C4189l c4189l) {
        this.f4396d = c4374j;
        this.f4397e = c4189l;
    }

    /* JADX INFO: renamed from: a */
    private static void m2914a(C4189l c4189l, C4374j c4374j) {
        c4189l.m3399b().execute(new a("delete_analytics", new Object[0], c4374j));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: b */
    public void mo2919b(NotificationMessage notificationMessage) {
        Region region = notificationMessage.region();
        if (TextUtils.isEmpty(notificationMessage.m3845id()) || region == null) {
            return;
        }
        this.f4397e.m3399b().execute(new C4102a(this.f4396d.m4236m(), this.f4396d.mo4218b(), C4103b.m2885a(new Date(), 0, 3, Arrays.asList(notificationMessage.m3845id(), region.m3630id()), notificationMessage.requestId(), true)));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4112g
    /* JADX INFO: renamed from: a */
    public void mo2916a(InboxMessage inboxMessage) {
        this.f4397e.m3399b().execute(new C4102a(this.f4396d.m4236m(), this.f4396d.mo4218b(), C4103b.m2885a(new Date(), 0, 14, Collections.singletonList(inboxMessage.m3794id()), C4179b.m3332b(inboxMessage), true)));
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i, com.salesforce.marketingcloud.analytics.InterfaceC4115j
    /* JADX INFO: renamed from: a */
    public void mo2917a(NotificationMessage notificationMessage, boolean z) {
        if (notificationMessage.region() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(notificationMessage.m3845id());
            arrayList.add(notificationMessage.region().m3630id());
            C4103b c4103bM2885a = C4103b.m2885a(new Date(), 0, 17, arrayList, notificationMessage.requestId(), true);
            c4103bM2885a.m2892b(z ? 1 : 0);
            this.f4397e.m3399b().execute(new C4102a(this.f4396d.m4236m(), this.f4396d.mo4218b(), c4103bM2885a));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2915a(C4374j c4374j, C4189l c4189l, boolean z) {
        if (z) {
            m2914a(c4189l, c4374j);
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.AbstractC4114i
    /* JADX INFO: renamed from: a */
    public void mo2918a(boolean z) {
        if (z) {
            m2914a(this.f4397e, this.f4396d);
        }
    }
}
