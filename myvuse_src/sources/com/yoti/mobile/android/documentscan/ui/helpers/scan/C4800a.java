package com.yoti.mobile.android.documentscan.ui.helpers.scan;

import android.os.Build;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.helpers.scan.a */
/* JADX INFO: loaded from: classes5.dex */
public final class C4800a {

    /* JADX INFO: renamed from: a */
    private static final C4804e f7111a;

    /* JADX INFO: renamed from: b */
    private static final Set<C4804e> f7112b;

    /* JADX INFO: renamed from: c */
    public static final C4800a f7113c = new C4800a();

    static {
        String str = Build.MANUFACTURER;
        Intrinsics.checkExpressionValueIsNotNull(str, "android.os.Build.MANUFACTURER");
        String str2 = Build.MODEL;
        Intrinsics.checkExpressionValueIsNotNull(str2, "android.os.Build.MODEL");
        f7111a = new C4804e(str, str2);
        f7112b = SetsKt.setOf((Object[]) new C4804e[]{new C4804e("samsung", "SM-T390"), new C4804e("samsung", "SM-T395"), new C4804e("samsung", "SM-A505FN")});
    }

    private C4800a() {
    }

    /* JADX INFO: renamed from: a */
    public final boolean m5006a() {
        return f7112b.contains(f7111a);
    }
}
