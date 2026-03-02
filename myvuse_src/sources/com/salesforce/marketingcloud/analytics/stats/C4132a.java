package com.salesforce.marketingcloud.analytics.stats;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.storage.InterfaceC4341d;
import com.salesforce.marketingcloud.util.InterfaceC4384c;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4132a extends AbstractRunnableC4184g {

    /* JADX INFO: renamed from: b */
    private final InterfaceC4341d f4498b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC4384c f4499c;

    /* JADX INFO: renamed from: d */
    private final C4133b f4500d;

    public C4132a(InterfaceC4341d interfaceC4341d, InterfaceC4384c interfaceC4384c, C4133b c4133b) {
        super("add_device_stat", new Object[0]);
        this.f4498b = interfaceC4341d;
        this.f4499c = interfaceC4384c;
        this.f4500d = c4133b;
    }

    @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
    /* JADX INFO: renamed from: a */
    protected void mo2882a() {
        try {
            this.f4498b.mo4008a(this.f4500d, this.f4499c);
        } catch (Exception e) {
            C4170g.m3207b(AnalyticsManager.TAG, e, "Unable to record device stat [%d].", Integer.valueOf(this.f4500d.m2990d()));
        }
    }
}
