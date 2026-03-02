package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceTecResultProcessor_Factory implements Factory<FaceTecResultProcessor> {
    private final Provider<Context> contextProvider;

    public FaceTecResultProcessor_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static FaceTecResultProcessor_Factory create(Provider<Context> provider) {
        return new FaceTecResultProcessor_Factory(provider);
    }

    public static FaceTecResultProcessor newInstance(Context context) {
        return new FaceTecResultProcessor(context);
    }

    @Override // javax.inject.Provider
    public FaceTecResultProcessor get() {
        return newInstance(this.contextProvider.get());
    }
}
