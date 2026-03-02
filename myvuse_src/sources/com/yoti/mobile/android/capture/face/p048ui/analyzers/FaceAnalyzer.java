package com.yoti.mobile.android.capture.face.p048ui.analyzers;

import android.content.Context;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.yoti.mobile.android.capture.face.p048ui.FaceCaptureListener;
import com.yoti.mobile.android.capture.face.p048ui.mappers.FaceCaptureResultMapper;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureInvalid;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureResult;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureState;
import com.yoti.mobile.android.commons.functional.Either;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceAnalyzer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0003J\u001e\u0010\u001e\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J\u0016\u0010\"\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0012R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "context", "Landroid/content/Context;", "luminosityValidator", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/LuminosityValidator;", "faceDetector", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/IFaceDetection;", "faceResultMapper", "Lcom/yoti/mobile/android/capture/face/ui/mappers/FaceCaptureResultMapper;", "mainHandler", "Landroid/os/Handler;", "(Landroid/content/Context;Lcom/yoti/mobile/android/capture/face/ui/analyzers/LuminosityValidator;Lcom/yoti/mobile/android/capture/face/ui/analyzers/IFaceDetection;Lcom/yoti/mobile/android/capture/face/ui/mappers/FaceCaptureResultMapper;Landroid/os/Handler;)V", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/capture/face/ui/FaceCaptureListener;", "analyze", "", "imageProxy", "Landroidx/camera/core/ImageProxy;", "isAnalysing", "", "onCaptureResult", "result", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "onFailure", "exception", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceDetectionError;", "originalImage", "onSuccess", "faces", "", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "startAnalysing", "stopAnalysing", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final class FaceAnalyzer implements ImageAnalysis.Analyzer {
    private FaceCaptureConfiguration configuration;
    private final IFaceDetection faceDetector;
    private final FaceCaptureResultMapper faceResultMapper;
    private FaceCaptureListener listener;
    private final LuminosityValidator luminosityValidator;
    private final Handler mainHandler;

    public FaceAnalyzer(Context context, LuminosityValidator luminosityValidator, IFaceDetection faceDetector, FaceCaptureResultMapper faceResultMapper, Handler mainHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(luminosityValidator, "luminosityValidator");
        Intrinsics.checkNotNullParameter(faceDetector, "faceDetector");
        Intrinsics.checkNotNullParameter(faceResultMapper, "faceResultMapper");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        this.luminosityValidator = luminosityValidator;
        this.faceDetector = faceDetector;
        this.faceResultMapper = faceResultMapper;
        this.mainHandler = mainHandler;
        this.configuration = new FaceCaptureConfiguration(null, null, false, false, false, 0, 63, null);
    }

    public /* synthetic */ FaceAnalyzer(Context context, LuminosityValidator luminosityValidator, IFaceDetection iFaceDetection, FaceCaptureResultMapper faceCaptureResultMapper, Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new LuminosityValidator(context) : luminosityValidator, (i & 4) != 0 ? new MlkitFaceDetection(null, 1, null) : iFaceDetection, (i & 8) != 0 ? new FaceCaptureResultMapper(null, null, null, 7, null) : faceCaptureResultMapper, (i & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image != null) {
            IFaceDetection iFaceDetection = this.faceDetector;
            Intrinsics.checkNotNullExpressionValue(image, "image");
            ImageInfo imageInfo = imageProxy.getImageInfo();
            Intrinsics.checkNotNullExpressionValue(imageInfo, "imageProxy.imageInfo");
            Either<FaceDetectionError, List<FaceResult>> eitherAnalyse = iFaceDetection.analyse(image, imageInfo.getRotationDegrees());
            if (eitherAnalyse instanceof Either.Failure) {
                onFailure((FaceDetectionError) ((Either.Failure) eitherAnalyse).getFailResult(), imageProxy);
            } else if (eitherAnalyse instanceof Either.Success) {
                onSuccess((List) ((Either.Success) eitherAnalyse).getSuccessResult(), imageProxy);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        imageProxy.close();
    }

    private final void onSuccess(List<FaceResult> faces, ImageProxy imageProxy) {
        ImageBuffer bufferInternal = FaceAnalyzerKt.toBufferInternal(imageProxy);
        if (this.configuration.getRequireBrightEnvironment() && !this.luminosityValidator.isValid()) {
            onCaptureResult(new FaceCaptureResult(bufferInternal, new FaceCaptureState.InvalidFace(FaceCaptureInvalid.EnvironmentTooDark.INSTANCE)));
        } else {
            onCaptureResult(this.faceResultMapper.mapDetectionResult(bufferInternal, faces, this.configuration));
        }
    }

    private final void onCaptureResult(final FaceCaptureResult result) {
        this.mainHandler.post(new Runnable() { // from class: com.yoti.mobile.android.capture.face.ui.analyzers.FaceAnalyzer.onCaptureResult.1
            @Override // java.lang.Runnable
            public final void run() {
                FaceCaptureListener faceCaptureListener = FaceAnalyzer.this.listener;
                if (faceCaptureListener != null) {
                    faceCaptureListener.onFaceCaptureResult(result);
                }
            }
        });
    }

    private final void onFailure(FaceDetectionError exception, ImageProxy originalImage) {
        LogInstrumentation.m2728e("FaceAnalyzer", "Face detection failure: " + exception);
        final FaceCaptureResult faceCaptureResultMapError = this.faceResultMapper.mapError(FaceAnalyzerKt.toBufferInternal(originalImage));
        this.mainHandler.post(new Runnable() { // from class: com.yoti.mobile.android.capture.face.ui.analyzers.FaceAnalyzer.onFailure.1
            @Override // java.lang.Runnable
            public final void run() {
                FaceCaptureListener faceCaptureListener = FaceAnalyzer.this.listener;
                if (faceCaptureListener != null) {
                    faceCaptureListener.onFaceCaptureResult(faceCaptureResultMapError);
                }
            }
        });
    }

    public final void startAnalysing(FaceCaptureConfiguration configuration, FaceCaptureListener listener) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LogInstrumentation.m2726d("FaceAnalyzer", "Started analyzing. ImageQuality=[" + configuration.getImageQuality() + ']');
        this.configuration = configuration;
        this.listener = listener;
        if (configuration.getRequireBrightEnvironment()) {
            this.luminosityValidator.start();
        }
        this.faceDetector.onConfigChanged(configuration);
    }

    public final void stopAnalysing() {
        LogInstrumentation.m2726d("FaceAnalyzer", "Stopped analyzing.");
        if (this.configuration.getRequireBrightEnvironment()) {
            this.luminosityValidator.stop();
        }
        this.listener = null;
    }

    public final boolean isAnalysing() {
        return this.listener != null;
    }
}
