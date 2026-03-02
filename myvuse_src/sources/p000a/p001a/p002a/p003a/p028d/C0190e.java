package p000a.p001a.p002a.p003a.p028d;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;

/* JADX INFO: renamed from: a.a.a.a.d.e */
/* JADX INFO: loaded from: classes.dex */
public class C0190e {

    /* JADX INFO: renamed from: a */
    public Map<String, Object> f1674a;

    /* JADX INFO: renamed from: b */
    public String[] f1675b;

    /* JADX INFO: renamed from: c */
    public List<Integer> f1676c;

    public C0190e(List<Integer> list) {
        this.f1676c = list;
        m1047a();
    }

    /* JADX INFO: renamed from: a */
    public static String m1046a(Map<String, Object> map, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (map.containsKey(str)) {
                sb.append((String) map.get(str));
            } else {
                OTLogger.m2743a(6, "GPPHeader", "encodeToBitString: field not found " + str);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m1047a() {
        StringBuilder sbAppend;
        String strM163a;
        HashMap map = new HashMap();
        this.f1674a = map;
        map.put("Id", C0191f.m1048a(3, 6));
        this.f1674a.put("Version", C0191f.m1048a(1, 6));
        Map<String, Object> map2 = this.f1674a;
        List<Integer> list = this.f1676c;
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            int i2 = i;
            while (i2 < list.size() - 1) {
                int i3 = i2 + 1;
                if (list.get(i2).intValue() + 1 == list.get(i3).intValue()) {
                    i2 = i3;
                }
            }
            int i4 = i2 + 1;
            arrayList.add(list.subList(i, i4));
            i = i4;
        }
        String strM1048a = C0191f.m1048a(arrayList.size(), 12);
        int iIntValue = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            if (((List) arrayList.get(i5)).size() == 1) {
                int iIntValue2 = ((Integer) ((List) arrayList.get(i5)).get(0)).intValue() - iIntValue;
                iIntValue = ((Integer) ((List) arrayList.get(i5)).get(0)).intValue();
                sbAppend = new StringBuilder().append(strM1048a).append("0");
                strM163a = C0026u.m163a(iIntValue2);
            } else {
                int iIntValue3 = ((Integer) ((List) arrayList.get(i5)).get(0)).intValue() - iIntValue;
                int iIntValue4 = ((Integer) ((List) arrayList.get(i5)).get(((List) arrayList.get(i5)).size() - 1)).intValue() - ((Integer) ((List) arrayList.get(i5)).get(0)).intValue();
                iIntValue = ((Integer) ((List) arrayList.get(i5)).get(((List) arrayList.get(i5)).size() - 1)).intValue();
                sbAppend = new StringBuilder().append(strM1048a).append("1").append(C0026u.m163a(iIntValue3));
                strM163a = C0026u.m163a(iIntValue4);
            }
            strM1048a = sbAppend.append(strM163a).toString();
        }
        map2.put("SectionIds", strM1048a);
        this.f1675b = new String[]{"Id", "Version", "SectionIds"};
    }
}
