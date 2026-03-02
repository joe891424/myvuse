package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import io.branch.referral.Defines;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class AppStoreReferrer {
    private static String installID_ = "bnc_no_value";

    public static void processReferrerInfo(Context context, String str, long j, long j2, String str2) {
        PrefHelper prefHelper = PrefHelper.getInstance(context);
        if (!TextUtils.isEmpty(str2)) {
            prefHelper.setAppStoreSource(str2);
        }
        if (j > 0) {
            prefHelper.setLong("bnc_referrer_click_ts", j);
        }
        if (j2 > 0) {
            prefHelper.setLong("bnc_install_begin_ts", j2);
        }
        if (str != null) {
            try {
                String strDecode = URLDecoder.decode(str, "UTF-8");
                HashMap map = new HashMap();
                String[] strArrSplit = strDecode.split("&");
                prefHelper.setAppStoreReferrer(strDecode);
                for (String str3 : strArrSplit) {
                    if (!TextUtils.isEmpty(str3)) {
                        String[] strArrSplit2 = str3.split((str3.contains("=") || !str3.contains("-")) ? "=" : "-");
                        if (strArrSplit2.length > 1) {
                            map.put(URLDecoder.decode(strArrSplit2[0], "UTF-8"), URLDecoder.decode(strArrSplit2[1], "UTF-8"));
                        }
                    }
                }
                if (map.containsKey(Defines.Jsonkey.LinkClickID.getKey())) {
                    String str4 = (String) map.get(Defines.Jsonkey.LinkClickID.getKey());
                    installID_ = str4;
                    prefHelper.setLinkClickIdentifier(str4);
                }
                if (map.containsKey(Defines.Jsonkey.IsFullAppConv.getKey()) && map.containsKey(Defines.Jsonkey.ReferringLink.getKey())) {
                    prefHelper.setIsFullAppConversion(Boolean.parseBoolean((String) map.get(Defines.Jsonkey.IsFullAppConv.getKey())));
                    prefHelper.setAppLink((String) map.get(Defines.Jsonkey.ReferringLink.getKey()));
                }
                if (map.containsKey(Defines.Jsonkey.GoogleSearchInstallReferrer.getKey())) {
                    prefHelper.setGoogleSearchInstallIdentifier((String) map.get(Defines.Jsonkey.GoogleSearchInstallReferrer.getKey()));
                }
                if (map.containsValue(Defines.Jsonkey.PlayAutoInstalls.getKey())) {
                    BranchPreinstall.setBranchPreInstallGoogleReferrer(context, map);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                BranchLogger.m5578v("Illegal characters in url encoded string");
            }
        }
    }

    public static String getInstallationID() {
        return installID_;
    }
}
