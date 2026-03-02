package com.yoti.mobile.android.documentcapture.sup.view.review.transformer;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class PdfRendererFactory_Factory implements Factory<PdfRendererFactory> {
    private final Provider<Context> contextProvider;

    public PdfRendererFactory_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static PdfRendererFactory_Factory create(Provider<Context> provider) {
        return new PdfRendererFactory_Factory(provider);
    }

    public static PdfRendererFactory newInstance(Context context) {
        return new PdfRendererFactory(context);
    }

    @Override // javax.inject.Provider
    public PdfRendererFactory get() {
        return newInstance(this.contextProvider.get());
    }
}
