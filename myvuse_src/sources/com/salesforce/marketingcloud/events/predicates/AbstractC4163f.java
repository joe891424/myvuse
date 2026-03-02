package com.salesforce.marketingcloud.events.predicates;

import com.facebook.hermes.intl.Constants;
import com.salesforce.marketingcloud.C4170g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.f */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4163f {

    /* JADX INFO: renamed from: b */
    public static final AbstractC4163f f4774b = new a();

    /* JADX INFO: renamed from: c */
    public static final AbstractC4163f f4775c = new b();

    /* JADX INFO: renamed from: d */
    private static final String f4776d = C4170g.m3197a("Predicate");

    /* JADX INFO: renamed from: a */
    private Boolean f4777a;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.f$a */
    class a extends AbstractC4163f {
        a() {
        }

        @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
        /* JADX INFO: renamed from: a */
        protected boolean mo3186a() {
            return true;
        }

        @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
        /* JADX INFO: renamed from: c */
        protected String mo3187c() {
            return "true";
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.f$b */
    class b extends AbstractC4163f {
        b() {
        }

        @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
        /* JADX INFO: renamed from: a */
        protected boolean mo3186a() {
            return false;
        }

        @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
        /* JADX INFO: renamed from: c */
        protected String mo3187c() {
            return Constants.CASEFIRST_FALSE;
        }
    }

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo3186a();

    /* JADX INFO: renamed from: b */
    public final boolean m3193b() {
        if (this.f4777a == null) {
            this.f4777a = Boolean.valueOf(mo3186a());
        }
        C4170g.m3213d(f4776d, "%s %s", mo3187c(), this.f4777a.booleanValue() ? "passed" : "failed");
        return this.f4777a.booleanValue();
    }

    /* JADX INFO: renamed from: c */
    protected abstract String mo3187c();
}
