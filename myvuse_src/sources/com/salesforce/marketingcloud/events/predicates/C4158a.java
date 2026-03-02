package com.salesforce.marketingcloud.events.predicates;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.predicates.a */
/* JADX INFO: loaded from: classes6.dex */
public class C4158a extends AbstractC4163f {

    /* JADX INFO: renamed from: e */
    private final AbstractC4163f[] f4769e;

    public C4158a(AbstractC4163f... abstractC4163fArr) {
        this.f4769e = abstractC4163fArr;
    }

    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
    /* JADX INFO: renamed from: a */
    protected boolean mo3186a() {
        for (AbstractC4163f abstractC4163f : this.f4769e) {
            if (!abstractC4163f.m3193b()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.salesforce.marketingcloud.events.predicates.AbstractC4163f
    /* JADX INFO: renamed from: c */
    protected String mo3187c() {
        return "And";
    }
}
