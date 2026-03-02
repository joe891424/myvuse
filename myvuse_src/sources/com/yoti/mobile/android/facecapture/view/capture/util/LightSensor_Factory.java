package com.yoti.mobile.android.facecapture.view.capture.util;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LightSensor_Factory implements Factory<LightSensor> {
    private final Provider<Context> contextProvider;

    public LightSensor_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static LightSensor_Factory create(Provider<Context> provider) {
        return new LightSensor_Factory(provider);
    }

    public static LightSensor newInstance(Context context) {
        return new LightSensor(context);
    }

    @Override // javax.inject.Provider
    public LightSensor get() {
        return newInstance(this.contextProvider.get());
    }
}
