package com.salesforce.marketingcloud.analytics;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.l */
/* JADX INFO: loaded from: classes6.dex */
public interface InterfaceC4117l {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.l$a */
    public enum a {
        SYNC_API("deviceSyncCallTimeMs"),
        TRIGGER_PROCESS("inAppMsgProcessingTimeMs");


        /* JADX INFO: renamed from: a */
        private final String f4443a;

        a(String str) {
            this.f4443a = str;
        }

        /* JADX INFO: renamed from: b */
        public String m2951b() {
            return this.f4443a;
        }
    }

    /* JADX INFO: renamed from: a */
    void mo2945a(a aVar, JSONObject jSONObject);
}
