package com.salesforce.marketingcloud.media;

import com.salesforce.marketingcloud.media.AbstractC4223u;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.j */
/* JADX INFO: loaded from: classes6.dex */
public class C4212j extends AbstractC4203a<Object> {

    /* JADX INFO: renamed from: f */
    private InterfaceC4208f f5057f;

    C4212j(C4217o c4217o, C4221s c4221s, InterfaceC4208f interfaceC4208f) {
        super(c4217o, null, c4221s);
        this.f5057f = interfaceC4208f;
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4203a
    /* JADX INFO: renamed from: a */
    void mo3498a() {
        super.mo3498a();
        this.f5057f = null;
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4203a
    /* JADX INFO: renamed from: a */
    void mo3499a(AbstractC4223u.b bVar) {
        InterfaceC4208f interfaceC4208f = this.f5057f;
        if (interfaceC4208f != null) {
            interfaceC4208f.mo3508a();
        }
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4203a
    /* JADX INFO: renamed from: a */
    void mo3500a(Exception exc) {
        InterfaceC4208f interfaceC4208f = this.f5057f;
        if (interfaceC4208f != null) {
            interfaceC4208f.mo3510a(exc);
        }
    }
}
