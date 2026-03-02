package com.salesforce.marketingcloud.media;

import android.widget.ImageView;
import com.salesforce.marketingcloud.media.AbstractC4223u;
import java.lang.ref.Reference;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.p */
/* JADX INFO: loaded from: classes6.dex */
public class C4218p extends AbstractC4203a<ImageView> {

    /* JADX INFO: renamed from: f */
    InterfaceC4208f f5099f;

    public C4218p(C4217o c4217o, C4224v<ImageView> c4224v, C4221s c4221s, InterfaceC4208f interfaceC4208f) {
        super(c4217o, c4224v, c4221s);
        this.f5099f = interfaceC4208f;
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4203a
    /* JADX INFO: renamed from: a */
    void mo3498a() {
        super.mo3498a();
        this.f5099f = null;
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4203a
    /* JADX INFO: renamed from: a */
    void mo3499a(AbstractC4223u.b bVar) {
        Reference reference = this.f5012b;
        ImageView imageView = reference != null ? (ImageView) reference.get() : null;
        if (imageView == null) {
            return;
        }
        C4214l.m3540a(imageView, m3501b().f5083a, bVar);
        InterfaceC4208f interfaceC4208f = this.f5099f;
        if (interfaceC4208f != null) {
            interfaceC4208f.mo3508a();
        }
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4203a
    /* JADX INFO: renamed from: a */
    void mo3500a(Exception exc) {
        InterfaceC4208f interfaceC4208f = this.f5099f;
        if (interfaceC4208f != null) {
            interfaceC4208f.mo3510a(exc);
        }
    }
}
