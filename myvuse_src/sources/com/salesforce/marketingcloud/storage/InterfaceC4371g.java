package com.salesforce.marketingcloud.storage;

import com.salesforce.marketingcloud.messages.iam.InAppMessage;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.g */
/* JADX INFO: loaded from: classes6.dex */
public interface InterfaceC4371g {

    /* JADX INFO: renamed from: a */
    public static final int f5709a = 1;

    /* JADX INFO: renamed from: b */
    public static final int f5710b = 2;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.g$a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX INFO: renamed from: a */
    int mo4076a(InAppMessage inAppMessage, InterfaceC4384c interfaceC4384c) throws Exception;

    /* JADX INFO: renamed from: a */
    int mo4077a(Collection<String> collection);

    /* JADX INFO: renamed from: a */
    InAppMessage mo4078a(String str, InterfaceC4384c interfaceC4384c);

    /* JADX INFO: renamed from: a */
    InAppMessage mo4079a(Collection<String> collection, InterfaceC4384c interfaceC4384c);

    /* JADX INFO: renamed from: a */
    void mo4080a(InAppMessage inAppMessage);

    /* JADX INFO: renamed from: b */
    void mo4081b(String str, int i);

    /* JADX INFO: renamed from: d */
    JSONArray mo4082d(InterfaceC4384c interfaceC4384c);

    /* JADX INFO: renamed from: e */
    List<String> mo4083e(InterfaceC4384c interfaceC4384c);
}
