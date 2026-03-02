package com.salesforce.marketingcloud.events.predicates;

import com.salesforce.marketingcloud.events.C4156g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4160c extends AbstractC4165h<Double> {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.c$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4771a;

        static {
            int[] iArr = new int[C4156g.a.values().length];
            f4771a = iArr;
            try {
                iArr[C4156g.a.f4748a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4771a[C4156g.a.f4749b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4771a[C4156g.a.f4750c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4771a[C4156g.a.f4751d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4771a[C4156g.a.f4752e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4771a[C4156g.a.f4753f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public C4160c(Object obj, C4156g.a aVar, Object obj2) {
        super(obj, aVar, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4165h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Double mo3188a(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047 A[ORIG_RETURN, RETURN] */
    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4165h
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo3189a(java.lang.Double r6, com.salesforce.marketingcloud.events.C4156g.a r7, java.lang.Double r8) throws java.lang.UnsupportedOperationException {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L48
            if (r8 == 0) goto L48
            double r1 = r6.doubleValue()
            double r3 = r8.doubleValue()
            int[] r6 = com.salesforce.marketingcloud.events.predicates.C4160c.a.f4771a
            int r8 = r7.ordinal()
            r6 = r6[r8]
            switch(r6) {
                case 1: goto L43;
                case 2: goto L3e;
                case 3: goto L39;
                case 4: goto L34;
                case 5: goto L2f;
                case 6: goto L2a;
                default: goto L18;
            }
        L18:
            java.lang.UnsupportedOperationException r6 = new java.lang.UnsupportedOperationException
            java.util.Locale r8 = java.util.Locale.ENGLISH
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r0 = "Operator %s not supported for Double data types."
            java.lang.String r7 = java.lang.String.format(r8, r0, r7)
            r6.<init>(r7)
            throw r6
        L2a:
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 < 0) goto L48
            goto L47
        L2f:
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L48
            goto L47
        L34:
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L48
            goto L47
        L39:
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 >= 0) goto L48
            goto L47
        L3e:
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L48
            goto L47
        L43:
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L48
        L47:
            r0 = 1
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.events.predicates.C4160c.mo3189a(java.lang.Double, com.salesforce.marketingcloud.events.g$a, java.lang.Double):boolean");
    }
}
