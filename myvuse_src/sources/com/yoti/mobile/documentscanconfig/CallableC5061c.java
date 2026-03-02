package com.yoti.mobile.documentscanconfig;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.c */
/* JADX INFO: loaded from: classes4.dex */
final class CallableC5061c<V, T> implements Callable<T> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5063e f7911a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ CountryCode f7912b;

    CallableC5061c(C5063e c5063e, CountryCode countryCode) {
        this.f7911a = c5063e;
        this.f7912b = countryCode;
    }

    @Override // java.util.concurrent.Callable
    public final List<String> call() {
        return this.f7911a.m5365b(this.f7912b);
    }
}
