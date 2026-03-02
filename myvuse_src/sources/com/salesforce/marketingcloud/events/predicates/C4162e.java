package com.salesforce.marketingcloud.events.predicates;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.e */
/* JADX INFO: loaded from: classes6.dex */
public final class C4162e extends AbstractC4163f {

    /* JADX INFO: renamed from: e */
    private AbstractC4163f[] f4773e;

    public C4162e(AbstractC4163f... predicates) {
        Intrinsics.checkNotNullParameter(predicates, "predicates");
        this.f4773e = predicates;
    }

    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
    /* JADX INFO: renamed from: a */
    protected boolean mo3186a() {
        for (AbstractC4163f abstractC4163f : this.f4773e) {
            if (abstractC4163f.m3193b()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
    /* JADX INFO: renamed from: c */
    protected String mo3187c() {
        return "Or";
    }
}
