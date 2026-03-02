package com.yoti.mobile.android.yotidocs.common.file;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class AssetToFileConverter_Factory implements Factory<AssetToFileConverter> {

    /* JADX INFO: renamed from: a */
    private final Provider<Context> f7508a;

    public AssetToFileConverter_Factory(Provider<Context> provider) {
        this.f7508a = provider;
    }

    public static AssetToFileConverter_Factory create(Provider<Context> provider) {
        return new AssetToFileConverter_Factory(provider);
    }

    public static AssetToFileConverter newInstance(Context context) {
        return new AssetToFileConverter(context);
    }

    @Override // javax.inject.Provider
    public AssetToFileConverter get() {
        return newInstance(this.f7508a.get());
    }
}
