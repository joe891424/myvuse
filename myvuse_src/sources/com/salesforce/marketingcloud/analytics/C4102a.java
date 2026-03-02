package com.salesforce.marketingcloud.analytics;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.storage.InterfaceC4338a;
import com.salesforce.marketingcloud.util.InterfaceC4384c;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4102a extends AbstractRunnableC4184g {

    /* JADX INFO: renamed from: b */
    private final InterfaceC4338a f4353b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC4384c f4354c;

    /* JADX INFO: renamed from: d */
    private final C4103b f4355d;

    public C4102a(InterfaceC4338a interfaceC4338a, InterfaceC4384c interfaceC4384c, C4103b c4103b) {
        super("add_analytic", new Object[0]);
        this.f4353b = interfaceC4338a;
        this.f4354c = interfaceC4384c;
        this.f4355d = c4103b;
    }

    @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
    /* JADX INFO: renamed from: a */
    protected void mo2882a() {
        try {
            this.f4353b.mo3984a(this.f4355d, this.f4354c);
        } catch (Exception e) {
            C4170g.m3207b(AnalyticsManager.TAG, e, "Unable to record analytic [%d].", Integer.valueOf(this.f4355d.m2888a()));
        }
    }
}
