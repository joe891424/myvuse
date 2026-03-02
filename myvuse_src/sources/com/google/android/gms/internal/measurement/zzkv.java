package com.google.android.gms.internal.measurement;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkv {
    private static final char[] zza;

    static String zza(zzkq zzkqVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzkqVar, sb, 0);
        return sb.toString();
    }

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, SafeJsonPrimitive.NULL_CHAR);
    }

    private static void zza(int i, StringBuilder sb) {
        while (i > 0) {
            char[] cArr = zza;
            int length = i > cArr.length ? cArr.length : i;
            sb.append(cArr, 0, length);
            i -= length;
        }
    }

    static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                zza(sb, i, str, it2.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it3 = ((Map) obj).entrySet().iterator();
            while (it3.hasNext()) {
                zza(sb, i, str, (Map.Entry) it3.next());
            }
            return;
        }
        sb.append('\n');
        zza(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(zzly.zza(zzhx.zza((String) obj))).append(Typography.quote);
            return;
        }
        if (obj instanceof zzhx) {
            sb.append(": \"").append(zzly.zza((zzhx) obj)).append(Typography.quote);
            return;
        }
        if (obj instanceof zzjk) {
            sb.append(" {");
            zza((zzjk) obj, sb, i + 2);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            zza(i, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i3 = i + 2;
            zza(sb, i3, "key", entry.getKey());
            zza(sb, i3, "value", entry.getValue());
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            zza(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": ").append(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.measurement.zzkq r20, java.lang.StringBuilder r21, int r22) {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkv.zza(com.google.android.gms.internal.measurement.zzkq, java.lang.StringBuilder, int):void");
    }
}
