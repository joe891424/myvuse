package com.salesforce.marketingcloud.messages;

import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.location.LatLon;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.c */
/* JADX INFO: loaded from: classes6.dex */
public interface InterfaceC4235c {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.c$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo3646a(Region region);

        /* JADX INFO: renamed from: a */
        void mo3647a(Region region, Message message);

        /* JADX INFO: renamed from: b */
        void mo3648b(Region region);
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.c$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo3649a(MessageResponse messageResponse);
    }

    /* JADX INFO: renamed from: a */
    void mo3642a();

    /* JADX INFO: renamed from: a */
    void mo3643a(LatLon latLon, String str, MarketingCloudConfig marketingCloudConfig, b bVar);

    /* JADX INFO: renamed from: b */
    void mo3644b();

    /* JADX INFO: renamed from: c */
    void mo3645c();
}
