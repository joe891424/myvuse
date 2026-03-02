package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class ImageAnalysisNonBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    private static final String TAG = "NonBlockingCallback";
    final Executor mBackgroundExecutor;
    private ImageProxy mCachedImage;
    private final AtomicReference<CacheAnalyzingImageProxy> mPostedImage = new AtomicReference<>();
    private final AtomicLong mPostedImageTimestamp = new AtomicLong();

    ImageAnalysisNonBlockingAnalyzer(Executor executor) {
        this.mBackgroundExecutor = executor;
        open();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (imageProxyAcquireLatestImage == null) {
            return;
        }
        analyze(imageProxyAcquireLatestImage);
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    synchronized void open() {
        super.open();
        ImageProxy imageProxy = this.mCachedImage;
        if (imageProxy != null) {
            imageProxy.close();
            this.mCachedImage = null;
        }
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    synchronized void close() {
        super.close();
        ImageProxy imageProxy = this.mCachedImage;
        if (imageProxy != null) {
            imageProxy.close();
            this.mCachedImage = null;
        }
    }

    synchronized void analyzeCachedImage() {
        ImageProxy imageProxy = this.mCachedImage;
        if (imageProxy != null) {
            this.mCachedImage = null;
            analyze(imageProxy);
        }
    }

    private synchronized void analyze(ImageProxy imageProxy) {
        if (isClosed()) {
            imageProxy.close();
            return;
        }
        CacheAnalyzingImageProxy cacheAnalyzingImageProxy = this.mPostedImage.get();
        if (cacheAnalyzingImageProxy != null && imageProxy.getImageInfo().getTimestamp() <= this.mPostedImageTimestamp.get()) {
            imageProxy.close();
            return;
        }
        if (cacheAnalyzingImageProxy != null && !cacheAnalyzingImageProxy.isClosed()) {
            ImageProxy imageProxy2 = this.mCachedImage;
            if (imageProxy2 != null) {
                imageProxy2.close();
            }
            this.mCachedImage = imageProxy;
            return;
        }
        final CacheAnalyzingImageProxy cacheAnalyzingImageProxy2 = new CacheAnalyzingImageProxy(imageProxy, this);
        this.mPostedImage.set(cacheAnalyzingImageProxy2);
        this.mPostedImageTimestamp.set(cacheAnalyzingImageProxy2.getImageInfo().getTimestamp());
        Futures.addCallback(analyzeImage(cacheAnalyzingImageProxy2), new FutureCallback<Void>() { // from class: androidx.camera.core.ImageAnalysisNonBlockingAnalyzer.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void result) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable t) {
                cacheAnalyzingImageProxy2.close();
            }
        }, CameraXExecutors.directExecutor());
    }

    static class CacheAnalyzingImageProxy extends ForwardingImageProxy {
        private boolean mClosed;
        WeakReference<ImageAnalysisNonBlockingAnalyzer> mNonBlockingAnalyzerWeakReference;

        CacheAnalyzingImageProxy(ImageProxy image, ImageAnalysisNonBlockingAnalyzer nonBlockingAnalyzer) {
            super(image);
            this.mClosed = false;
            this.mNonBlockingAnalyzerWeakReference = new WeakReference<>(nonBlockingAnalyzer);
            addOnImageCloseListener(new ForwardingImageProxy.OnImageCloseListener() { // from class: androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$$ExternalSyntheticLambda1
                @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
                public final void onImageClose(ImageProxy imageProxy) {
                    this.f$0.m1132x3a140058(imageProxy);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$new$0$androidx-camera-core-ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy */
        /* synthetic */ void m1132x3a140058(ImageProxy imageProxy) {
            this.mClosed = true;
            final ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer = this.mNonBlockingAnalyzerWeakReference.get();
            if (imageAnalysisNonBlockingAnalyzer != null) {
                Executor executor = imageAnalysisNonBlockingAnalyzer.mBackgroundExecutor;
                Objects.requireNonNull(imageAnalysisNonBlockingAnalyzer);
                executor.execute(new Runnable() { // from class: androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        imageAnalysisNonBlockingAnalyzer.analyzeCachedImage();
                    }
                });
            }
        }

        boolean isClosed() {
            return this.mClosed;
        }
    }
}
