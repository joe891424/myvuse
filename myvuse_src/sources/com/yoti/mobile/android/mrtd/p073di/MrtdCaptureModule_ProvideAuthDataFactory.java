package com.yoti.mobile.android.mrtd.p073di;

import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdCaptureModule_ProvideAuthDataFactory implements Factory<BacCredential> {
    private final MrtdCaptureModule module;

    public MrtdCaptureModule_ProvideAuthDataFactory(MrtdCaptureModule mrtdCaptureModule) {
        this.module = mrtdCaptureModule;
    }

    public static MrtdCaptureModule_ProvideAuthDataFactory create(MrtdCaptureModule mrtdCaptureModule) {
        return new MrtdCaptureModule_ProvideAuthDataFactory(mrtdCaptureModule);
    }

    public static BacCredential provideAuthData(MrtdCaptureModule mrtdCaptureModule) {
        return (BacCredential) Preconditions.checkNotNullFromProvides(mrtdCaptureModule.getAuthData());
    }

    @Override // javax.inject.Provider
    public BacCredential get() {
        return provideAuthData(this.module);
    }
}
