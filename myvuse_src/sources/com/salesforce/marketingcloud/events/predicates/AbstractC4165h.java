package com.salesforce.marketingcloud.events.predicates;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.events.C4156g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.h */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4165h<T> extends AbstractC4163f {

    /* JADX INFO: renamed from: i */
    private static final String f4779i = C4170g.m3197a("ValuePredicate");

    /* JADX INFO: renamed from: e */
    private final Object f4780e;

    /* JADX INFO: renamed from: f */
    private final C4156g.a f4781f;

    /* JADX INFO: renamed from: g */
    private final Object f4782g;

    /* JADX INFO: renamed from: h */
    private final String f4783h;

    AbstractC4165h(Object obj, C4156g.a aVar, Object obj2) {
        this.f4780e = obj;
        this.f4781f = aVar;
        this.f4782g = obj2;
        this.f4783h = String.format("%s %s %s", obj, aVar, obj2);
    }

    /* JADX INFO: renamed from: a */
    protected abstract T mo3188a(Object obj);

    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
    /* JADX INFO: renamed from: a */
    protected final boolean mo3186a() {
        try {
            return mo3189a(mo3188a(this.f4780e), this.f4781f, mo3188a(this.f4782g));
        } catch (Exception e) {
            C4170g.m3207b(f4779i, e, "Unable to evaluate predicate.  Returning default value of 'false'", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo3189a(T t, C4156g.a aVar, T t2) throws UnsupportedOperationException;

    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
    /* JADX INFO: renamed from: c */
    protected String mo3187c() {
        return this.f4783h;
    }
}
