package com.yoti.mobile.android.documentscan.domain;

import com.microblink.entities.recognizers.Recognizer;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import java.util.concurrent.Callable;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.n */
/* JADX INFO: loaded from: classes5.dex */
final class CallableC4725n<V, T> implements Callable<T> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C4727p f6923a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Recognizer.Result f6924b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ int f6925c;

    CallableC4725n(C4727p c4727p, Recognizer.Result result, int i) {
        this.f6923a = c4727p;
        this.f6924b = result;
        this.f6925c = i;
    }

    @Override // java.util.concurrent.Callable
    public final DocumentCaptureResult call() {
        Class<?> cls;
        KClass<? extends Recognizer.Result> kotlinClass;
        Recognizer.Result result = this.f6924b;
        AbstractC4696a<Recognizer.Result> abstractC4696aM4797a = (result == null || (cls = result.getClass()) == null || (kotlinClass = JvmClassMappingKt.getKotlinClass(cls)) == null) ? null : this.f6923a.f6932f.m4797a(kotlinClass);
        return new DocumentCaptureResult(abstractC4696aM4797a != null ? abstractC4696aM4797a.mo4706a(this.f6924b) : null, this.f6923a.m4837b(this.f6925c, this.f6924b), abstractC4696aM4797a != null ? abstractC4696aM4797a.mo4709d(this.f6924b) : null, abstractC4696aM4797a != null ? abstractC4696aM4797a.mo4708c(this.f6924b) : null, abstractC4696aM4797a != null ? abstractC4696aM4797a.mo4707b(this.f6924b) : null);
    }
}
