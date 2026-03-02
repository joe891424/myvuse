package com.salesforce.marketingcloud.events.predicates;

import com.facebook.hermes.intl.Constants;
import com.salesforce.marketingcloud.events.C4156g;
import java.util.Locale;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.b */
/* JADX INFO: loaded from: classes6.dex */
public class C4159b extends AbstractC4165h<Boolean> {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.b$a */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f4770a;

        static {
            int[] iArr = new int[C4156g.a.values().length];
            f4770a = iArr;
            try {
                iArr[C4156g.a.f4748a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4770a[C4156g.a.f4749b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C4159b(Object obj, C4156g.a aVar, Object obj2) {
        super(obj, aVar, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4165h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean mo3188a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if (Constants.CASEFIRST_FALSE.equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4165h
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3189a(Boolean bool, C4156g.a aVar, Boolean bool2) throws UnsupportedOperationException {
        if (bool == null || bool2 == null) {
            return false;
        }
        int i = a.f4770a[aVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new UnsupportedOperationException(String.format(Locale.ENGLISH, "Operator %s not supported for Boolean data types.", aVar));
            }
            if (bool == bool2) {
                return false;
            }
        } else if (bool != bool2) {
            return false;
        }
        return true;
    }
}
