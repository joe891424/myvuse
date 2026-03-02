package com.yoti.mobile.android.yotidocs.common;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageDimensionsReader_Factory implements Factory<ImageDimensionsReader> {

    /* JADX INFO: renamed from: a */
    private final Provider<BitmapFileDecoder> f7467a;

    public ImageDimensionsReader_Factory(Provider<BitmapFileDecoder> provider) {
        this.f7467a = provider;
    }

    public static ImageDimensionsReader_Factory create(Provider<BitmapFileDecoder> provider) {
        return new ImageDimensionsReader_Factory(provider);
    }

    public static ImageDimensionsReader newInstance(BitmapFileDecoder bitmapFileDecoder) {
        return new ImageDimensionsReader(bitmapFileDecoder);
    }

    @Override // javax.inject.Provider
    public ImageDimensionsReader get() {
        return newInstance(this.f7467a.get());
    }
}
