package com.salesforce.marketingcloud.registration;

import com.salesforce.marketingcloud.C4170g;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface RegistrationManager {

    /* JADX INFO: renamed from: a */
    public static final String f5454a = C4170g.m3197a("RegistrationManager");

    /* JADX INFO: renamed from: b */
    public static final String f5455b = "Android";

    /* JADX INFO: renamed from: c */
    public static final int f5456c = 128;

    public interface Editor {
        Editor addTag(String str);

        Editor addTags(Iterable<String> iterable);

        Editor addTags(String... strArr);

        Editor clearAttribute(String str);

        Editor clearAttributes(Iterable<String> iterable);

        Editor clearAttributes(String... strArr);

        Editor clearTags();

        boolean commit();

        Editor removeTag(String str);

        Editor removeTags(Iterable<String> iterable);

        Editor removeTags(String... strArr);

        Editor setAttribute(String str, String str2);

        Editor setContactKey(String str);

        Editor setSignedString(String str);
    }

    public interface RegistrationEventListener {
        void onRegistrationReceived(Registration registration);
    }

    Editor edit();

    Map<String, String> getAttributes();

    String getContactKey();

    String getDeviceId();

    String getSignedString();

    String getSystemToken();

    Set<String> getTags();

    void registerForRegistrationEvents(RegistrationEventListener registrationEventListener);

    void unregisterForRegistrationEvents(RegistrationEventListener registrationEventListener);
}
