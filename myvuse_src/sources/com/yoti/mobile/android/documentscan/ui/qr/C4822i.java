package com.yoti.mobile.android.documentscan.ui.qr;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.qr.i */
/* JADX INFO: loaded from: classes5.dex */
public final class C4822i {

    /* JADX INFO: renamed from: a */
    private final CompositeDisposable f7154a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC4818e f7155b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC4817d f7156c;

    public C4822i(InterfaceC4818e view, InterfaceC4817d aadhaarQrCodeProcessorInteractor) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(aadhaarQrCodeProcessorInteractor, "aadhaarQrCodeProcessorInteractor");
        this.f7155b = view;
        this.f7156c = aadhaarQrCodeProcessorInteractor;
        this.f7154a = new CompositeDisposable();
    }

    /* JADX INFO: renamed from: a */
    public final void m5030a() {
        this.f7154a.clear();
    }

    /* JADX INFO: renamed from: a */
    public final void m5031a(String payload) {
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        this.f7154a.clear();
        Disposable disposableSubscribe = this.f7156c.mo5018a(payload).subscribeOn(Schedulers.m5595io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C4820g(this), new C4821h(this));
        Intrinsics.checkExpressionValueIsNotNull(disposableSubscribe, "aadhaarQrCodeProcessorIn…         }\n            })");
        this.f7154a.add(disposableSubscribe);
    }
}
