package com.salesforce.marketingcloud.events.predicates;

import com.salesforce.marketingcloud.events.C4156g;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.d */
/* JADX INFO: loaded from: classes6.dex */
public class C4161d extends AbstractC4165h<Integer> {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.d$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4772a;

        static {
            int[] iArr = new int[C4156g.a.values().length];
            f4772a = iArr;
            try {
                iArr[C4156g.a.f4748a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4772a[C4156g.a.f4749b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4772a[C4156g.a.f4750c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4772a[C4156g.a.f4751d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4772a[C4156g.a.f4752e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4772a[C4156g.a.f4753f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public C4161d(Object obj, C4156g.a aVar, Object obj2) {
        super(obj, aVar, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4165h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer mo3188a(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4165h
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3189a(Integer num, C4156g.a aVar, Integer num2) throws UnsupportedOperationException {
        if (num == null || num2 == null) {
            return false;
        }
        switch (a.f4772a[aVar.ordinal()]) {
            case 1:
                return num.equals(num2);
            case 2:
                return !num.equals(num2);
            case 3:
                if (num.intValue() >= num2.intValue()) {
                    return false;
                }
                break;
            case 4:
                if (num.intValue() <= num2.intValue()) {
                    return false;
                }
                break;
            case 5:
                if (num.intValue() > num2.intValue()) {
                    return false;
                }
                break;
            case 6:
                if (num.intValue() < num2.intValue()) {
                    return false;
                }
                break;
            default:
                throw new UnsupportedOperationException(String.format(Locale.ENGLISH, "Operator %s not supported for Integer data types.", aVar));
        }
        return true;
    }
}
