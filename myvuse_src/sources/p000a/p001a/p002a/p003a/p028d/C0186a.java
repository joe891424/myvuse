package p000a.p001a.p002a.p003a.p028d;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: a.a.a.a.d.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0186a {

    /* JADX INFO: renamed from: a */
    public static final Pattern f1663a = Pattern.compile("^[0-1]*$", 2);

    /* JADX INFO: renamed from: a */
    public static String m1028a(String str) {
        if (!f1663a.matcher(str).matches()) {
            OTLogger.m2743a(6, "GPPBase64UrlEncoder", "Base64Url encoding failed");
        }
        while (str.length() % 6 > 0) {
            str = str + 0;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i <= str.length() - 6) {
            int i2 = i + 6;
            String strSubstring = str.substring(i, i2);
            try {
                if (!C0191f.f1677a.matcher(strSubstring).matches()) {
                    OTLogger.m2743a(6, "GPPIntegerEncoder", "Integer decode failed");
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < strSubstring.length()) {
                    int i5 = i3 + 1;
                    if (strSubstring.charAt(strSubstring.length() - i5) == '1') {
                        i4 += 1 << i3;
                    }
                    i3 = i5;
                }
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i4));
                i = i2;
            } catch (Exception unused) {
                OTLogger.m2743a(6, "GPPBase64UrlEncoder", "Base64Url encoding failed");
            }
        }
        return sb.toString();
    }
}
