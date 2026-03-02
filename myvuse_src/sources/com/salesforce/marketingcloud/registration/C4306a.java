package com.salesforce.marketingcloud.registration;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.storage.InterfaceC4377m;
import com.salesforce.marketingcloud.util.InterfaceC4384c;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.registration.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4306a extends AbstractRunnableC4184g {

    /* JADX INFO: renamed from: b */
    private final InterfaceC4377m f5457b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC4384c f5458c;

    /* JADX INFO: renamed from: d */
    private final Registration f5459d;

    /* JADX INFO: renamed from: e */
    private final boolean f5460e;

    C4306a(InterfaceC4377m interfaceC4377m, InterfaceC4384c interfaceC4384c, Registration registration, boolean z) {
        super(z ? "update_registration" : "add_registration", new Object[0]);
        this.f5457b = interfaceC4377m;
        this.f5458c = interfaceC4384c;
        this.f5459d = registration;
        this.f5460e = z;
    }

    @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
    /* JADX INFO: renamed from: a */
    protected void mo2882a() {
        try {
            if (this.f5460e) {
                this.f5457b.mo4152b(this.f5459d, this.f5458c);
            } else {
                this.f5457b.mo4151a(this.f5459d, this.f5458c);
            }
        } catch (Exception e) {
            C4170g.m3207b(RegistrationManager.f5454a, e, "Unable to %s registration", this.f5460e ? "update" : "add");
        }
    }
}
