package com.yoti.mobile.android.scan.p077b;

import com.yoti.mobile.android.scan.p076a.C4932a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.b.a */
/* JADX INFO: loaded from: classes4.dex */
public final class C4935a {

    /* JADX INFO: renamed from: a */
    private final C4932a f7419a;

    public C4935a(C4932a scanPreferences) {
        Intrinsics.checkParameterIsNotNull(scanPreferences, "scanPreferences");
        this.f7419a = scanPreferences;
    }

    /* JADX INFO: renamed from: a */
    public final void m5064a() {
        C4932a c4932a = this.f7419a;
        c4932a.m5059a(c4932a.m5058a() + 1);
    }
}
