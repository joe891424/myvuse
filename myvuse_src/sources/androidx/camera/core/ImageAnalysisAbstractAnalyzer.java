package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private final Object mAnalyzerLock = new Object();
    private AtomicBoolean mIsClosed = new AtomicBoolean(false);
    private volatile int mRelativeRotation;
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    private Executor mUserExecutor;

    ImageAnalysisAbstractAnalyzer() {
    }

    ListenableFuture<Void> analyzeImage(final ImageProxy imageProxy) {
        final Executor executor;
        final ImageAnalysis.Analyzer analyzer;
        synchronized (this.mAnalyzerLock) {
            executor = this.mUserExecutor;
            analyzer = this.mSubscribedAnalyzer;
        }
        if (analyzer != null && executor != null) {
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f$0.m1131x9959ff20(executor, imageProxy, analyzer, completer);
                }
            });
        }
        return Futures.immediateFailedFuture(new OperationCanceledException("No analyzer or executor currently set."));
    }

    /* JADX INFO: renamed from: lambda$analyzeImage$1$androidx-camera-core-ImageAnalysisAbstractAnalyzer */
    /* synthetic */ Object m1131x9959ff20(Executor executor, final ImageProxy imageProxy, final ImageAnalysis.Analyzer analyzer, final CallbackToFutureAdapter.Completer completer) throws Exception {
        executor.execute(new Runnable() { // from class: androidx.camera.core.ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1130x6b8164c1(imageProxy, analyzer, completer);
            }
        });
        return "analyzeImage";
    }

    /* JADX INFO: renamed from: lambda$analyzeImage$0$androidx-camera-core-ImageAnalysisAbstractAnalyzer */
    /* synthetic */ void m1130x6b8164c1(ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (!isClosed()) {
            analyzer.analyze(new SettableImageProxy(imageProxy, ImmutableImageInfo.create(imageProxy.getImageInfo().getTagBundle(), imageProxy.getImageInfo().getTimestamp(), this.mRelativeRotation)));
            completer.set(null);
        } else {
            completer.setException(new OperationCanceledException("Closed before analysis"));
        }
    }

    void setRelativeRotation(int relativeRotation) {
        this.mRelativeRotation = relativeRotation;
    }

    void setAnalyzer(Executor userExecutor, ImageAnalysis.Analyzer subscribedAnalyzer) {
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = subscribedAnalyzer;
            this.mUserExecutor = userExecutor;
        }
    }

    void open() {
        this.mIsClosed.set(false);
    }

    void close() {
        this.mIsClosed.set(true);
    }

    boolean isClosed() {
        return this.mIsClosed.get();
    }
}
