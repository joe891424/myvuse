package com.yoti.mobile.android.commons.async;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.commons.async.a */
/* JADX INFO: compiled from: LooperThreadScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC4567a implements Runnable {

    /* JADX INFO: renamed from: a */
    private final /* synthetic */ Function0 f6501a;

    RunnableC4567a(Function0 function0) {
        this.f6501a = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.f6501a.invoke(), "invoke(...)");
    }
}
