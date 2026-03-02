package com.yoti.mobile.android.capture.face.p048ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.camera.core.Camera;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.util.concurrent.ListenableFuture;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.yoti.mobile.android.capture.face.databinding.FaceCaptureBinding;
import com.yoti.mobile.android.capture.face.p048ui.analyzers.FaceAnalyzer;
import com.yoti.mobile.android.capture.face.p048ui.mappers.CameraInitializationErrorMapper;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraConfiguration;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraState;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraStateListener;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureConfiguration;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceCapture.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J&\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u001cJ\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0003J\b\u0010,\u001a\u00020#H\u0003J\u0016\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0018J&\u00101\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u00100\u001a\u0004\u0018\u0001022\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007J\u0006\u00103\u001a\u00020#J\b\u00104\u001a\u00020#H\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/FaceCapture;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_cameraState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "binding", "Lcom/yoti/mobile/android/capture/face/databinding/FaceCaptureBinding;", "cameraInitErrorMapper", "Lcom/yoti/mobile/android/capture/face/ui/mappers/CameraInitializationErrorMapper;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "cameraState", "Landroidx/lifecycle/LiveData;", "getCameraState", "()Landroidx/lifecycle/LiveData;", "faceAnalyzer", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceAnalyzer;", "faceCaptureListener", "Lcom/yoti/mobile/android/capture/face/ui/FaceCaptureListener;", "imageAnalyzer", "Landroidx/camera/core/ImageAnalysis;", "arePermissionsGranted", "", "buildCameraPreview", "Landroidx/camera/core/Preview;", "cameraConfiguration", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraConfiguration;", "buildFaceAnalyzer", "initCamera", "", "cameraProviderFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isAnalysing", "isCameraRunning", "onCameraReady", "onPause", "onResume", "startAnalysing", "configuration", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startCamera", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraStateListener;", "stopAnalysing", "stopCamera", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public final class FaceCapture extends ConstraintLayout implements LifecycleObserver {
    private final MutableLiveData<CameraState> _cameraState;
    private final FaceCaptureBinding binding;
    private final CameraInitializationErrorMapper cameraInitErrorMapper;
    private ProcessCameraProvider cameraProvider;
    private final LiveData<CameraState> cameraState;
    private final FaceAnalyzer faceAnalyzer;
    private FaceCaptureListener faceCaptureListener;
    private ImageAnalysis imageAnalyzer;

    public final void startCamera(LifecycleOwner lifecycleOwner) {
        startCamera$default(this, lifecycleOwner, null, null, 6, null);
    }

    public final void startCamera(LifecycleOwner lifecycleOwner, CameraStateListener cameraStateListener) {
        startCamera$default(this, lifecycleOwner, cameraStateListener, null, 4, null);
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.capture.face.ui.FaceCapture$startCamera$1 */
    /* JADX INFO: compiled from: FaceCapture.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, m5598d2 = {"<anonymous>", "", "p1", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "invoke"}, m5599k = 3, m5600mv = {1, 4, 1})
    static final /* synthetic */ class C44661 extends FunctionReferenceImpl implements Function1<CameraState, Unit> {
        C44661(CameraStateListener cameraStateListener) {
            super(1, cameraStateListener, CameraStateListener.class, "onCameraState", "onCameraState(Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CameraState cameraState) {
            invoke2(cameraState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CameraState p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((CameraStateListener) this.receiver).onCameraState(p1);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FaceCapture(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceCapture(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        FaceCaptureBinding faceCaptureBindingInflate = FaceCaptureBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(faceCaptureBindingInflate, "FaceCaptureBinding.infla…ater.from(context), this)");
        this.binding = faceCaptureBindingInflate;
        this.cameraInitErrorMapper = new CameraInitializationErrorMapper();
        this.faceAnalyzer = new FaceAnalyzer(context, null, null, null, null, 30, null);
        MutableLiveData<CameraState> mutableLiveData = new MutableLiveData<>(CameraState.CameraStopped.INSTANCE);
        this._cameraState = mutableLiveData;
        this.cameraState = mutableLiveData;
    }

    public final LiveData<CameraState> getCameraState() {
        return this.cameraState;
    }

    public static /* synthetic */ void startCamera$default(FaceCapture faceCapture, LifecycleOwner lifecycleOwner, CameraStateListener cameraStateListener, CameraConfiguration cameraConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            cameraStateListener = null;
        }
        if ((i & 4) != 0) {
            cameraConfiguration = new CameraConfiguration(null, 1, null);
        }
        faceCapture.startCamera(lifecycleOwner, cameraStateListener, cameraConfiguration);
    }

    public final void startCamera(final LifecycleOwner lifecycleOwner, CameraStateListener listener, final CameraConfiguration cameraConfiguration) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraConfiguration, "cameraConfiguration");
        if (listener != null) {
            LiveData<CameraState> liveData = this.cameraState;
            final C44661 c44661 = new C44661(listener);
            liveData.observe(lifecycleOwner, new Observer() { // from class: com.yoti.mobile.android.capture.face.ui.FaceCaptureKt$sam$androidx_lifecycle_Observer$0
                @Override // androidx.lifecycle.Observer
                public final /* synthetic */ void onChanged(Object obj) {
                    Intrinsics.checkNotNullExpressionValue(c44661.invoke(obj), "invoke(...)");
                }
            });
        }
        if (!arePermissionsGranted()) {
            LogInstrumentation.m2726d("FaceCapture", "Permissions not granted.");
            this._cameraState.setValue(CameraState.MissingPermissions.INSTANCE);
        } else {
            if (isCameraRunning()) {
                LogInstrumentation.m2726d("FaceCapture", "Camera already running.");
                return;
            }
            final ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(getContext());
            processCameraProvider.addListener(new Runnable() { // from class: com.yoti.mobile.android.capture.face.ui.FaceCapture$startCamera$$inlined$with$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    FaceCapture faceCapture = this;
                    ListenableFuture listenableFuture = processCameraProvider;
                    Intrinsics.checkNotNullExpressionValue(listenableFuture, "this");
                    faceCapture.initCamera(listenableFuture, lifecycleOwner, cameraConfiguration);
                }
            }, ContextCompat.getMainExecutor(getContext()));
            lifecycleOwner.getLifecycle().addObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initCamera(ListenableFuture<ProcessCameraProvider> cameraProviderFuture, LifecycleOwner lifecycleOwner, CameraConfiguration cameraConfiguration) {
        try {
            ProcessCameraProvider processCameraProvider = cameraProviderFuture.get();
            ProcessCameraProvider processCameraProvider2 = processCameraProvider;
            processCameraProvider2.unbindAll();
            Camera cameraBindToLifecycle = processCameraProvider2.bindToLifecycle(lifecycleOwner, cameraConfiguration.getFacing().getSelector(), buildCameraPreview(cameraConfiguration), buildFaceAnalyzer(cameraConfiguration));
            Intrinsics.checkNotNullExpressionValue(cameraBindToLifecycle, "bindToLifecycle(\n       …ration)\n                )");
            cameraBindToLifecycle.getCameraControl().setLinearZoom(cameraConfiguration.getFacing().getDefaultZoomLevel());
            Unit unit = Unit.INSTANCE;
            this.cameraProvider = processCameraProvider;
            LogInstrumentation.m2726d("FaceCapture", "Camera running.");
            onCameraReady();
        } catch (Exception e) {
            this._cameraState.setValue(this.cameraInitErrorMapper.invoke(e));
        }
    }

    private final Preview buildCameraPreview(CameraConfiguration cameraConfiguration) {
        Preview previewBuild = new Preview.Builder().setTargetResolution(cameraConfiguration.getTargetResolution()).build();
        PreviewView previewView = this.binding.cameraPreview;
        Intrinsics.checkNotNullExpressionValue(previewView, "binding.cameraPreview");
        previewBuild.setSurfaceProvider(previewView.getSurfaceProvider());
        Intrinsics.checkNotNullExpressionValue(previewBuild, "Preview.Builder()\n      …review.surfaceProvider) }");
        return previewBuild;
    }

    private final ImageAnalysis buildFaceAnalyzer(CameraConfiguration cameraConfiguration) {
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).setTargetResolution(cameraConfiguration.getTargetResolution()).build();
        imageAnalysisBuild.setAnalyzer(Executors.newSingleThreadExecutor(), this.faceAnalyzer);
        this.imageAnalyzer = imageAnalysisBuild;
        Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "ImageAnalysis.Builder()\n…alyzer = it\n            }");
        return imageAnalysisBuild;
    }

    public final void stopCamera() {
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
        this.cameraProvider = null;
        LogInstrumentation.m2726d("FaceCapture", "Camera stopped.");
        this._cameraState.setValue(CameraState.CameraStopped.INSTANCE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        if (isCameraRunning()) {
            onCameraReady();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        if (isCameraRunning()) {
            this._cameraState.setValue(CameraState.CameraStopped.INSTANCE);
        }
    }

    public final void startAnalysing(FaceCaptureConfiguration configuration, FaceCaptureListener listener) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.faceCaptureListener = listener;
        this.faceAnalyzer.startAnalysing(configuration, listener);
        if (isCameraRunning()) {
            this._cameraState.setValue(CameraState.Analyzing.INSTANCE);
        }
    }

    public final void stopAnalysing() {
        this.faceAnalyzer.stopAnalysing();
        if (Intrinsics.areEqual(this.cameraState.getValue(), CameraState.Analyzing.INSTANCE)) {
            this._cameraState.setValue(CameraState.CameraReady.INSTANCE);
        }
    }

    private final void onCameraReady() {
        if (isAnalysing()) {
            this._cameraState.setValue(CameraState.Analyzing.INSTANCE);
        } else {
            this._cameraState.setValue(CameraState.CameraReady.INSTANCE);
        }
    }

    private final boolean arePermissionsGranted() {
        for (String str : FaceCaptureConfiguration.INSTANCE.getREQUIRED_PERMISSIONS()) {
            if (ContextCompat.checkSelfPermission(getContext(), str) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean isCameraRunning() {
        return this.cameraProvider != null;
    }

    public final boolean isAnalysing() {
        return this.faceAnalyzer.isAnalysing();
    }
}
