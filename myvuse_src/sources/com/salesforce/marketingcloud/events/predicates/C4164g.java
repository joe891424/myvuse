package com.salesforce.marketingcloud.events.predicates;

import com.salesforce.marketingcloud.events.C4156g;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.g */
/* JADX INFO: loaded from: classes6.dex */
public class C4164g extends AbstractC4165h<String> {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.g$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4778a;

        static {
            int[] iArr = new int[C4156g.a.values().length];
            f4778a = iArr;
            try {
                iArr[C4156g.a.f4748a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4778a[C4156g.a.f4749b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4778a[C4156g.a.f4754g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C4164g(Object obj, C4156g.a aVar, Object obj2) {
        super(obj, aVar, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4165h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String mo3188a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4165h
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3189a(String str, C4156g.a aVar, String str2) throws UnsupportedOperationException {
        if (str == null || str2 == null) {
            return false;
        }
        int i = a.f4778a[aVar.ordinal()];
        if (i == 1) {
            return str.equalsIgnoreCase(str2);
        }
        if (i == 2) {
            return !str.equalsIgnoreCase(str2);
        }
        if (i == 3) {
            return str.matches(str2);
        }
        throw new UnsupportedOperationException(String.format(Locale.ENGLISH, "Operator %s not supported for String data types.", aVar));
    }
}
