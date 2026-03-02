package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;

/* JADX INFO: loaded from: classes.dex */
final class ImageAnalysisBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    ImageAnalysisBlockingAnalyzer() {
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        final ImageProxy imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
        if (imageProxyAcquireNextImage == null) {
            return;
        }
        Futures.addCallback(analyzeImage(imageProxyAcquireNextImage), new FutureCallback<Void>() { // from class: androidx.camera.core.ImageAnalysisBlockingAnalyzer.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void result) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable t) {
                imageProxyAcquireNextImage.close();
            }
        }, CameraXExecutors.directExecutor());
    }
}
