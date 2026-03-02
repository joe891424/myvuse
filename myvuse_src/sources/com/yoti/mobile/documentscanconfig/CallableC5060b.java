package com.yoti.mobile.documentscanconfig;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.b */
/* JADX INFO: loaded from: classes4.dex */
final class CallableC5060b<V, T> implements Callable<T> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5063e f7910a;

    CallableC5060b(C5063e c5063e) {
        this.f7910a = c5063e;
    }

    @Override // java.util.concurrent.Callable
    public final List<CountryCode> call() {
        return this.f7910a.m5364b();
    }
}
