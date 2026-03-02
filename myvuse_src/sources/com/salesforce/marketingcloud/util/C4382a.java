package com.salesforce.marketingcloud.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.salesforce.marketingcloud.tozny.AesCbcWithIntegrity;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4382a extends AesCbcWithIntegrity implements InterfaceC4384c {

    /* JADX INFO: renamed from: b */
    private static final String f5747b = "F6389234-1024-481F-9173-37D9D7F5051F";

    /* JADX INFO: renamed from: c */
    private static final String f5748c = "com.salesforce.marketingcloud.storagePrefs";

    /* JADX INFO: renamed from: d */
    private static final String f5749d = "install_date_enc";

    /* JADX INFO: renamed from: e */
    private static final int f5750e = 500;

    /* JADX INFO: renamed from: a */
    private final AesCbcWithIntegrity.SecretKeys f5751a;

    public C4382a(Context context, String str, String str2, String str3) throws GeneralSecurityException, UnsupportedEncodingException {
        this(context, str, str2, str3, 500);
    }

    @Override // com.salesforce.marketingcloud.util.InterfaceC4384c
    /* JADX INFO: renamed from: a */
    public String mo4259a(String str) throws GeneralSecurityException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return AesCbcWithIntegrity.encrypt(str, this.f5751a).toString();
    }

    @Override // com.salesforce.marketingcloud.util.InterfaceC4384c
    /* JADX INFO: renamed from: b */
    public String mo4260b(String str) throws GeneralSecurityException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return AesCbcWithIntegrity.decryptString(new AesCbcWithIntegrity.CipherTextIvMac(str), this.f5751a);
    }

    protected C4382a(Context context, String str, String str2, String str3, int i) throws GeneralSecurityException, UnsupportedEncodingException {
        this.f5751a = AesCbcWithIntegrity.generateKeyFromPassword(m4256a(str, str2, str3), mo4258a(context, str), i);
        m4257a();
    }

    /* JADX INFO: renamed from: a */
    private String m4256a(String str, String str2, String str3) {
        return Base64.encodeToString(C4393l.m4352e(str + "--" + C4393l.m4352e(str2) + "__" + C4393l.m4352e(str3)).getBytes(C4393l.f5818b), 2);
    }

    /* JADX INFO: renamed from: a */
    protected String mo4258a(Context context, String str) throws GeneralSecurityException {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f5748c, 0);
        String string = sharedPreferences.getString(f5749d, null);
        if (string != null) {
            return string;
        }
        String strSaltString = AesCbcWithIntegrity.saltString(AesCbcWithIntegrity.generateSalt());
        sharedPreferences.edit().putString(f5749d, strSaltString).apply();
        return strSaltString;
    }

    /* JADX INFO: renamed from: a */
    private void m4257a() throws GeneralSecurityException, UnsupportedEncodingException {
        if (!f5747b.equals(mo4260b(mo4259a(f5747b)))) {
            throw new GeneralSecurityException("Encryption/decryption test failed");
        }
    }
}
