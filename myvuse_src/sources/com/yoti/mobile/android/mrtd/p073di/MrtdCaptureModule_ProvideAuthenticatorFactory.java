package com.yoti.mobile.android.mrtd.p073di;

import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import com.yoti.mobile.mpp.mrtddump.auth.MrtdAuthentication;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdCaptureModule_ProvideAuthenticatorFactory implements Factory<MrtdAuthentication> {
    private final Provider<BacCredential> credentialProvider;
    private final MrtdCaptureModule module;

    public MrtdCaptureModule_ProvideAuthenticatorFactory(MrtdCaptureModule mrtdCaptureModule, Provider<BacCredential> provider) {
        this.module = mrtdCaptureModule;
        this.credentialProvider = provider;
    }

    public static MrtdCaptureModule_ProvideAuthenticatorFactory create(MrtdCaptureModule mrtdCaptureModule, Provider<BacCredential> provider) {
        return new MrtdCaptureModule_ProvideAuthenticatorFactory(mrtdCaptureModule, provider);
    }

    public static MrtdAuthentication provideAuthenticator(MrtdCaptureModule mrtdCaptureModule, BacCredential bacCredential) {
        return (MrtdAuthentication) Preconditions.checkNotNullFromProvides(mrtdCaptureModule.provideAuthenticator(bacCredential));
    }

    @Override // javax.inject.Provider
    public MrtdAuthentication get() {
        return provideAuthenticator(this.module, this.credentialProvider.get());
    }
}
