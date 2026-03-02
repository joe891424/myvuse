package com.yoti.mobile.mpp.mrtddump.p096j;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.j.b */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, m5598d2 = {"defaultCryptoDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefaultCryptoDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "defaultReadDispatcher", "getDefaultReadDispatcher", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5118b {

    /* JADX INFO: renamed from: a */
    private static final CoroutineDispatcher f8134a = Dispatchers.getMain();

    /* JADX INFO: renamed from: b */
    private static final CoroutineDispatcher f8135b = Dispatchers.getDefault();

    /* JADX INFO: renamed from: a */
    public static final CoroutineDispatcher m5528a() {
        return f8135b;
    }

    /* JADX INFO: renamed from: b */
    public static final CoroutineDispatcher m5529b() {
        return f8134a;
    }
}
