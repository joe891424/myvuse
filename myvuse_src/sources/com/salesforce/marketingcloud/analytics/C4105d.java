package com.salesforce.marketingcloud.analytics;

import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.storage.InterfaceC4338a;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.d */
/* JADX INFO: loaded from: classes6.dex */
public class C4105d extends AbstractRunnableC4184g {

    /* JADX INFO: renamed from: b */
    private final InterfaceC4338a f4389b;

    /* JADX INFO: renamed from: c */
    private final String[] f4390c;

    public C4105d(InterfaceC4338a interfaceC4338a, String[] strArr) {
        super("delete_analytics", new Object[0]);
        this.f4389b = interfaceC4338a;
        this.f4390c = strArr;
    }

    @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
    /* JADX INFO: renamed from: a */
    protected void mo2882a() {
        this.f4389b.mo3983a(this.f4390c);
    }
}
