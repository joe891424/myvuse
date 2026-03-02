package com.salesforce.marketingcloud.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.util.InterfaceC4384c;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.GeneralSecurityException;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.c */
/* JADX INFO: loaded from: classes6.dex */
public interface InterfaceC4340c {

    /* JADX INFO: renamed from: a */
    public static final String f5559a = "mcsdk_custprefs_%s";

    /* JADX INFO: renamed from: b */
    public static final String f5560b = "et_attributes_cache";

    /* JADX INFO: renamed from: c */
    public static final String f5561c = "et_tags_cache";

    /* JADX INFO: renamed from: d */
    public static final String f5562d = "et_subscriber_cache";

    /* JADX INFO: renamed from: e */
    public static final String f5563e = "gcm_reg_id_key";

    /* JADX INFO: renamed from: f */
    public static final String f5564f = "et_session_id_cache";

    /* JADX INFO: renamed from: g */
    public static final String f5565g = "et_user_id_cache";

    /* JADX INFO: renamed from: h */
    public static final String f5566h = "mc_last_sent_registration";

    /* JADX INFO: renamed from: i */
    public static final String f5567i = "sender_id";

    /* JADX INFO: renamed from: j */
    public static final String f5568j = "subscriber_jwt";

    /* JADX INFO: renamed from: k */
    public static final String f5569k = "predictive_intelligence_identifier";

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.c$a */
    public static class a implements InterfaceC4340c {

        /* JADX INFO: renamed from: l */
        private final SharedPreferences f5570l;

        /* JADX INFO: renamed from: m */
        private final InterfaceC4384c f5571m;

        a(Context context, InterfaceC4384c interfaceC4384c, String str) {
            this.f5570l = context.getSharedPreferences(m4003b(str), 0);
            this.f5571m = interfaceC4384c;
            m4004b();
        }

        /* JADX INFO: renamed from: b */
        private void m4004b() {
            if (this.f5570l.contains("gcm_sender_id")) {
                this.f5570l.edit().remove("gcm_sender_id").apply();
            }
        }

        /* JADX INFO: renamed from: c */
        private String m4005c(String str, String str2) {
            String strMo4260b = null;
            String string = this.f5570l.getString(str, null);
            if (string != null) {
                try {
                    strMo4260b = this.f5571m.mo4260b(string);
                } catch (Exception e) {
                    C4170g.m3217e(AbstractC4367e.f5690c, e, "Failed to encrypt %s", str);
                }
            }
            return strMo4260b == null ? str2 : strMo4260b;
        }

        /* JADX INFO: renamed from: d */
        private void m4006d(String str, String str2) throws GeneralSecurityException, UnsupportedEncodingException {
            this.f5570l.edit().putString(str, this.f5571m.mo4259a(str2)).apply();
        }

        @Override // com.salesforce.marketingcloud.storage.InterfaceC4340c
        /* JADX INFO: renamed from: a */
        public final void mo3928a() {
            this.f5570l.edit().clear().apply();
        }

        @Override // com.salesforce.marketingcloud.storage.InterfaceC4340c
        /* JADX INFO: renamed from: a */
        public final void mo3930a(String str, String str2) {
            try {
                m4006d(str, str2);
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                C4170g.m3216e(AbstractC4367e.f5690c, String.format(Locale.ENGLISH, "Value for key %s not stored.", str), e);
            }
        }

        @Override // com.salesforce.marketingcloud.storage.InterfaceC4340c
        /* JADX INFO: renamed from: b */
        public final String mo3931b(String str, String str2) {
            return m4005c(str, str2);
        }

        /* JADX INFO: renamed from: b */
        static String m4003b(String str) {
            return String.format(Locale.ENGLISH, InterfaceC4340c.f5559a, str);
        }

        @Override // com.salesforce.marketingcloud.storage.InterfaceC4340c
        /* JADX INFO: renamed from: a */
        public final void mo3929a(String str) {
            this.f5570l.edit().remove(str).apply();
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.storage.c$b */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    /* JADX INFO: renamed from: a */
    void mo3928a();

    /* JADX INFO: renamed from: a */
    void mo3929a(String str);

    /* JADX INFO: renamed from: a */
    void mo3930a(String str, String str2);

    /* JADX INFO: renamed from: b */
    String mo3931b(String str, String str2);
}
