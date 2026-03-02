package com.salesforce.marketingcloud.util;

import android.content.Context;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerModule;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.NumberFormat;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.i */
/* JADX INFO: loaded from: classes6.dex */
public class C4390i extends C4382a {

    /* JADX INFO: renamed from: f */
    private static final String f5808f = "ETPush";

    public C4390i(Context context, String str, String str2, String str3) throws GeneralSecurityException, UnsupportedEncodingException {
        super(context, str, str2, str3, AndroidLocationEnablerModule.DEFAULT_INTERVAL_DURATION);
    }

    @Override // com.salesforce.marketingcloud.util.C4382a
    /* JADX INFO: renamed from: a */
    protected final String mo4258a(Context context, String str) throws GeneralSecurityException {
        int iIntValue;
        String string = context.getSharedPreferences(f5808f, 0).getString("install_date_enc", null);
        if (string == null) {
            throw new GeneralSecurityException("Unable to get old salt.");
        }
        try {
            iIntValue = NumberFormat.getInstance().parse(C4393l.m4352e(str + "29200FA5-DF79-4C3F-BC0F-E2FF3CE6199A")).intValue();
        } catch (Exception unused) {
            iIntValue = 200;
        }
        return C4393l.m4352e(string.substring(Integer.valueOf(String.valueOf(iIntValue).substring(0, 1)).intValue()));
    }
}
