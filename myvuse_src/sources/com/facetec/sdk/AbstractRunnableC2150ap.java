package com.facetec.sdk;

import android.app.Fragment;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facetec.sdk.ap */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractRunnableC2150ap implements Runnable {
    private final WeakReference<Fragment> Code;

    abstract void Code();

    AbstractRunnableC2150ap(Fragment fragment) {
        this.Code = new WeakReference<>(fragment);
    }

    @Override // java.lang.Runnable
    public void run() {
        Fragment fragment = this.Code.get();
        if (fragment == null || !fragment.isAdded() || fragment.getActivity() == null || fragment.getActivity().isFinishing()) {
            return;
        }
        Code();
    }
}
