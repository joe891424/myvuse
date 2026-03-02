package com.yoti.mobile.android.scan;

import androidx.lifecycle.Observer;
import com.yoti.mobile.android.scan.p078ui.C4946b;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.g */
/* JADX INFO: loaded from: classes4.dex */
public final class C4941g<T> implements Observer<T> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScannerViewFragment f7426a;

    public C4941g(ScannerViewFragment scannerViewFragment) {
        this.f7426a = scannerViewFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        this.f7426a.m5049a((C4946b) t);
    }
}
