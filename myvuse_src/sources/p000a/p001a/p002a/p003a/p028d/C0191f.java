package p000a.p001a.p002a.p003a.p028d;

import java.util.regex.Pattern;

/* JADX INFO: renamed from: a.a.a.a.d.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0191f {

    /* JADX INFO: renamed from: a */
    public static final Pattern f1677a = Pattern.compile("^[0-1]*$", 2);

    /* JADX INFO: renamed from: a */
    public static String m1048a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = "0";
            if (i <= 0) {
                break;
            }
            if ((i & 1) == 1) {
                str = "1";
            }
            sb.insert(0, str);
            i >>= 1;
        }
        while (sb.length() < i2) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
