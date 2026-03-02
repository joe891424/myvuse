package com.yoti.mobile.android.scan.p077b;

import com.yoti.mobile.android.scan.p076a.C4932a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.b.b */
/* JADX INFO: loaded from: classes4.dex */
public final class C4936b {

    /* JADX INFO: renamed from: a */
    private final C4932a f7420a;

    public C4936b(C4932a scanPreferences) {
        Intrinsics.checkParameterIsNotNull(scanPreferences, "scanPreferences");
        this.f7420a = scanPreferences;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m5065a() {
        return this.f7420a.m5058a() < 2;
    }
}
