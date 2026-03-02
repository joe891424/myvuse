package com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DeleteSessionTokenService_Factory implements Factory<DeleteSessionTokenService> {

    /* JADX INFO: renamed from: a */
    private final Provider<DeleteSessionTokenApiService> f7624a;

    public DeleteSessionTokenService_Factory(Provider<DeleteSessionTokenApiService> provider) {
        this.f7624a = provider;
    }

    public static DeleteSessionTokenService_Factory create(Provider<DeleteSessionTokenApiService> provider) {
        return new DeleteSessionTokenService_Factory(provider);
    }

    public static DeleteSessionTokenService newInstance(DeleteSessionTokenApiService deleteSessionTokenApiService) {
        return new DeleteSessionTokenService(deleteSessionTokenApiService);
    }

    @Override // javax.inject.Provider
    public DeleteSessionTokenService get() {
        return newInstance(this.f7624a.get());
    }
}
