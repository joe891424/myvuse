package com.yoti.mobile.android.documentcapture.sup.view.review.transformer;

import android.content.Context;
import com.yoti.mobile.android.remote.MimeTypeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class CaptureToBitmapTransformerFactory_Factory implements Factory<CaptureToBitmapTransformerFactory> {
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineContext> ioContextProvider;
    private final Provider<MimeTypeProvider> mimeTypeProvider;
    private final Provider<PdfRendererFactory> pdfRendererFactoryProvider;

    public CaptureToBitmapTransformerFactory_Factory(Provider<Context> provider, Provider<PdfRendererFactory> provider2, Provider<MimeTypeProvider> provider3, Provider<CoroutineContext> provider4) {
        this.contextProvider = provider;
        this.pdfRendererFactoryProvider = provider2;
        this.mimeTypeProvider = provider3;
        this.ioContextProvider = provider4;
    }

    public static CaptureToBitmapTransformerFactory_Factory create(Provider<Context> provider, Provider<PdfRendererFactory> provider2, Provider<MimeTypeProvider> provider3, Provider<CoroutineContext> provider4) {
        return new CaptureToBitmapTransformerFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static CaptureToBitmapTransformerFactory newInstance(Context context, PdfRendererFactory pdfRendererFactory, MimeTypeProvider mimeTypeProvider, CoroutineContext coroutineContext) {
        return new CaptureToBitmapTransformerFactory(context, pdfRendererFactory, mimeTypeProvider, coroutineContext);
    }

    @Override // javax.inject.Provider
    public CaptureToBitmapTransformerFactory get() {
        return newInstance(this.contextProvider.get(), this.pdfRendererFactoryProvider.get(), this.mimeTypeProvider.get(), this.ioContextProvider.get());
    }
}
