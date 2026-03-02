package com.yoti.mobile.android.documentscan.domain;

import com.yoti.mobile.android.documentscan.domain.p059a.p064e.C4707a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.e */
/* JADX INFO: loaded from: classes5.dex */
final class C4716e extends Lambda implements Function0<C4707a> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4721j f6901a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4716e(C4721j c4721j) {
        super(0);
        this.f6901a = c4721j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C4707a invoke() {
        return new C4707a(this.f6901a.f6907b, this.f6901a.f6909d);
    }
}
