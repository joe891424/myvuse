package com.yoti.mobile.android.documentscan.ui.camera;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.util.concurrent.ListenableFuture;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commons.image.CameraxBuffer;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.commons.lifecycle.CameraLifecycle;
import com.yoti.mobile.android.core.image.RotationBufferKt;
import com.yoti.mobile.android.documentscan.C4695R;
import com.yoti.mobile.android.documentscan.domain.C4724m;
import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedPageConfig;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.documentscan.ui.IScanDocument;
import com.yoti.mobile.android.documentscan.ui.IScanView;
import com.yoti.mobile.android.documentscan.ui.IScanViewConfiguration;
import com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4803d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001IB\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\"H\u0016J\b\u0010(\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010'\u001a\u00020\"H\u0002J\u0010\u0010/\u001a\u00020&2\u0006\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u000104H\u0016J$\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010;\u001a\u00020&2\u0006\u00100\u001a\u000201H\u0016J\u001a\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u000101H\u0016J\b\u0010?\u001a\u00020&H\u0016J\u001a\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u0002062\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020&H\u0016J\b\u0010F\u001a\u00020&H\u0016J\u0010\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\u00020!*\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006J"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraView;", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "()V", "camera", "Landroidx/camera/core/Camera;", "cameraLifecycle", "Lcom/yoti/mobile/android/commons/lifecycle/CameraLifecycle;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "documentOverlay", "Lcom/yoti/mobile/android/documentscan/ui/IScanView;", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "getListener", "()Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "setListener", "(Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;)V", "overlayLayout", "", "presenter", "Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraPresenter;", "presenterInitialised", "", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "viewConfig", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "normalizedCropRect", "Landroid/graphics/RectF;", "Landroidx/camera/core/ImageProxy;", "getNormalizedCropRect", "(Landroidx/camera/core/ImageProxy;)Landroid/graphics/RectF;", "analyze", "", "image", "configureCameraView", "displayErrorState", "throwable", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", "documentPageReviewed", "approved", "initialisePresenter", "onBackSideScanned", "documentCaptureResult", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFrontSideScanned", "onScanCompleted", "resultFront", "resultBack", "onStop", "onViewCreated", "view", "setupCamera", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "turnOffTorchLight", "turnOnTorchLight", "updateForPage", "pageNumber", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class SimpleCameraFragment extends Fragment implements InterfaceC4793x, IScanDocument, ImageAnalysis.Analyzer, TraceFieldInterface {
    private static final String ARG_IMAGE_FORMAT = "ARG_IMAGE_FORMAT";
    private static final String ARG_PARAM_SCAN_CONFIGURATION = "ARG_PARAM_SCAN_CONFIGURATION";
    private static final String ARG_PARAM_VIEW_CONFIGURATION = "ARG_PARAM_VIEW_CONFIGURATION";
    private static final String ARG_PARAM_VIEW_LAYOUT_RES = "ARG_PARAM_VIEW_LAYOUT_RES";

    /* JADX INFO: renamed from: a */
    public static final Companion f7044a = new Companion(null);
    public Trace _nr_trace;

    /* JADX INFO: renamed from: b */
    private ScanMultiSideDocumentListener f7045b;

    /* JADX INFO: renamed from: c */
    private SimpleCameraPresenter f7046c;

    /* JADX INFO: renamed from: d */
    private DocumentScanDetailedConfig f7047d;

    /* JADX INFO: renamed from: e */
    private IScanViewConfiguration f7048e;

    /* JADX INFO: renamed from: f */
    private ImageFormat f7049f;

    /* JADX INFO: renamed from: g */
    private int f7050g = -1;

    /* JADX INFO: renamed from: h */
    private IScanView f7051h;

    /* JADX INFO: renamed from: i */
    private CameraLifecycle f7052i;

    /* JADX INFO: renamed from: j */
    private Camera f7053j;

    /* JADX INFO: renamed from: k */
    private CameraSelector f7054k;

    /* JADX INFO: renamed from: l */
    private boolean f7055l;

    /* JADX INFO: renamed from: m */
    private HashMap f7056m;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraFragment$Companion;", "", "()V", SimpleCameraFragment.ARG_IMAGE_FORMAT, "", "ARG_PARAM_SCAN_CONFIGURATION", SimpleCameraFragment.ARG_PARAM_VIEW_CONFIGURATION, SimpleCameraFragment.ARG_PARAM_VIEW_LAYOUT_RES, "newInstance", "Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraFragment;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "viewConfig", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "scanLayout", "", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SimpleCameraFragment newInstance$default(Companion companion, DocumentScanDetailedConfig documentScanDetailedConfig, IScanViewConfiguration iScanViewConfiguration, int i, ImageFormat imageFormat, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                imageFormat = ImageFormat.INSTANCE.m4840a();
            }
            return companion.newInstance(documentScanDetailedConfig, iScanViewConfiguration, i, imageFormat);
        }

        @JvmStatic
        public final SimpleCameraFragment newInstance(DocumentScanDetailedConfig scanConfig, IScanViewConfiguration viewConfig, int scanLayout, ImageFormat imageFormat) {
            Intrinsics.checkParameterIsNotNull(scanConfig, "scanConfig");
            Intrinsics.checkParameterIsNotNull(viewConfig, "viewConfig");
            Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
            SimpleCameraFragment simpleCameraFragment = new SimpleCameraFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PARAM_SCAN_CONFIGURATION", scanConfig);
            bundle.putParcelable(SimpleCameraFragment.ARG_PARAM_VIEW_CONFIGURATION, viewConfig);
            bundle.putInt(SimpleCameraFragment.ARG_PARAM_VIEW_LAYOUT_RES, scanLayout);
            bundle.putSerializable(SimpleCameraFragment.ARG_IMAGE_FORMAT, imageFormat);
            simpleCameraFragment.setArguments(bundle);
            return simpleCameraFragment;
        }
    }

    /* JADX INFO: renamed from: a */
    private final RectF m4961a(ImageProxy imageProxy) {
        return new RectF(imageProxy.getCropRect().left / imageProxy.getWidth(), imageProxy.getCropRect().top / imageProxy.getHeight(), imageProxy.getCropRect().right / imageProxy.getWidth(), imageProxy.getCropRect().bottom / imageProxy.getHeight());
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ SimpleCameraPresenter m4962a(SimpleCameraFragment simpleCameraFragment) {
        SimpleCameraPresenter simpleCameraPresenter = simpleCameraFragment.f7046c;
        if (simpleCameraPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return simpleCameraPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4963a(ProcessCameraProvider processCameraProvider) {
        if (isAdded()) {
            Preview previewBuild = new Preview.Builder().build();
            Intrinsics.checkExpressionValueIsNotNull(previewBuild, "Preview.Builder()\n                .build()");
            CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(1).build();
            Intrinsics.checkExpressionValueIsNotNull(cameraSelectorBuild, "CameraSelector.Builder()…\n                .build()");
            this.f7054k = cameraSelectorBuild;
            ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
            Intrinsics.checkExpressionValueIsNotNull(imageAnalysisBuild, "ImageAnalysis.Builder()\n…KEEP_ONLY_LATEST).build()");
            imageAnalysisBuild.setAnalyzer(Executors.newSingleThreadExecutor(), this);
            UseCaseGroup.Builder builder = new UseCaseGroup.Builder();
            PreviewView previewView = (PreviewView) m4970b(C4695R.id.previewView);
            Intrinsics.checkExpressionValueIsNotNull(previewView, "previewView");
            ViewPort viewPort = previewView.getViewPort();
            if (viewPort != null) {
                builder.setViewPort(viewPort);
            }
            builder.addUseCase(previewBuild);
            builder.addUseCase(imageAnalysisBuild);
            UseCaseGroup useCaseGroupBuild = builder.build();
            Intrinsics.checkExpressionValueIsNotNull(useCaseGroupBuild, "UseCaseGroup.Builder().a…alysis)\n        }.build()");
            CameraLifecycle cameraLifecycle = this.f7052i;
            if (cameraLifecycle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraLifecycle");
            }
            CameraSelector cameraSelector = this.f7054k;
            if (cameraSelector == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraSelector");
            }
            Camera cameraBindToLifecycle = processCameraProvider.bindToLifecycle(cameraLifecycle, cameraSelector, useCaseGroupBuild);
            Intrinsics.checkExpressionValueIsNotNull(cameraBindToLifecycle, "cameraProvider.bindToLif…ector, useCases\n        )");
            this.f7053j = cameraBindToLifecycle;
            PreviewView previewView2 = (PreviewView) m4970b(C4695R.id.previewView);
            Intrinsics.checkExpressionValueIsNotNull(previewView2, "previewView");
            previewBuild.setSurfaceProvider(previewView2.getSurfaceProvider());
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m4965b(ImageProxy imageProxy) {
        SimpleCameraPresenter simpleCameraPresenter = this.f7046c;
        if (simpleCameraPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        PreviewView previewView = (PreviewView) m4970b(C4695R.id.previewView);
        Intrinsics.checkExpressionValueIsNotNull(previewView, "previewView");
        int width = previewView.getWidth();
        PreviewView previewView2 = (PreviewView) m4970b(C4695R.id.previewView);
        Intrinsics.checkExpressionValueIsNotNull(previewView2, "previewView");
        int height = previewView2.getHeight();
        RectF rectFM4961a = m4961a(imageProxy);
        IScanView iScanView = this.f7051h;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
        }
        RectF scanArea = iScanView.getScanArea();
        ImageInfo imageInfo = imageProxy.getImageInfo();
        Intrinsics.checkExpressionValueIsNotNull(imageInfo, "image.imageInfo");
        simpleCameraPresenter.m4983a(width, height, rectFM4961a, scanArea, imageInfo.getRotationDegrees());
        this.f7055l = true;
    }

    /* JADX INFO: renamed from: d */
    private final void m4966d() {
        ScanMultiSideDocumentListener f7045b;
        DocumentCaptureException.CameraViewException cameraViewException;
        try {
            ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(requireActivity());
            Intrinsics.checkExpressionValueIsNotNull(processCameraProvider, "ProcessCameraProvider.ge…stance(requireActivity())");
            processCameraProvider.addListener(new RunnableC4772c(this, processCameraProvider), ContextCompat.getMainExecutor(requireContext()));
        } catch (InitializationException e) {
            f7045b = getF7001b();
            if (f7045b != null) {
                cameraViewException = new DocumentCaptureException.CameraViewException(e);
                f7045b.onError(cameraViewException);
            }
        } catch (IllegalStateException e2) {
            f7045b = getF7001b();
            if (f7045b != null) {
                cameraViewException = new DocumentCaptureException.CameraViewException(e2);
                f7045b.onError(cameraViewException);
            }
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.camera.InterfaceC4793x
    /* JADX INFO: renamed from: a */
    public void mo4967a() {
        Camera camera = this.f7053j;
        if (camera == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        if (camera.getCameraInfo().hasFlashUnit()) {
            Camera camera2 = this.f7053j;
            if (camera2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("camera");
            }
            camera2.getCameraControl().enableTorch(false);
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.camera.InterfaceC4793x
    /* JADX INFO: renamed from: a */
    public void mo4968a(int i) {
        IScanView iScanView = this.f7051h;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
        }
        DocumentScanDetailedConfig documentScanDetailedConfig = this.f7047d;
        if (documentScanDetailedConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        iScanView.updateForPage(i, documentScanDetailedConfig.getPageConfigs().get(i).getDocumentConfigKey());
        IScanView iScanView2 = this.f7051h;
        if (iScanView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
        }
        IScanView.C4764a.m4903a(iScanView2, i, false, new C4773d(this), 2, null);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.camera.InterfaceC4793x
    /* JADX INFO: renamed from: a */
    public void mo4969a(DocumentCaptureException throwable) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        ScanMultiSideDocumentListener f7045b = getF7001b();
        if (f7045b != null) {
            f7045b.onError(throwable);
        }
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(ImageProxy image) throws Exception {
        Intrinsics.checkParameterIsNotNull(image, "image");
        try {
            if (!this.f7055l) {
                m4965b(image);
            }
            SimpleCameraPresenter simpleCameraPresenter = this.f7046c;
            if (simpleCameraPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            ImageBuffer buffer = CameraxBuffer.toBuffer(image);
            ImageInfo imageInfo = image.getImageInfo();
            Intrinsics.checkExpressionValueIsNotNull(imageInfo, "it.imageInfo");
            simpleCameraPresenter.m4984a(RotationBufferKt.rotateBy(buffer, imageInfo.getRotationDegrees()));
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(image, null);
        } finally {
        }
    }

    /* JADX INFO: renamed from: b */
    public View m4970b(int i) {
        if (this.f7056m == null) {
            this.f7056m = new HashMap();
        }
        View view = (View) this.f7056m.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View viewFindViewById = view2.findViewById(i);
        this.f7056m.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.camera.InterfaceC4793x
    /* JADX INFO: renamed from: b */
    public void mo4971b() {
        Camera camera = this.f7053j;
        if (camera == null) {
            Intrinsics.throwUninitializedPropertyAccessException("camera");
        }
        if (camera.getCameraInfo().hasFlashUnit()) {
            Camera camera2 = this.f7053j;
            if (camera2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("camera");
            }
            camera2.getCameraControl().enableTorch(true);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m4972c() {
        HashMap map = this.f7056m;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void documentPageReviewed(boolean approved) {
        SimpleCameraPresenter simpleCameraPresenter = this.f7046c;
        if (simpleCameraPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        simpleCameraPresenter.m4985a(approved);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    /* JADX INFO: renamed from: getListener, reason: from getter */
    public ScanMultiSideDocumentListener getF7001b() {
        return this.f7045b;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.camera.InterfaceC4793x
    public void onBackSideScanned(DocumentCaptureResult documentCaptureResult) {
        Intrinsics.checkParameterIsNotNull(documentCaptureResult, "documentCaptureResult");
        ScanMultiSideDocumentListener f7045b = getF7001b();
        if (f7045b != null) {
            f7045b.onBackSideScanned(documentCaptureResult);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("SimpleCameraFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SimpleCameraFragment#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "SimpleCameraFragment#onCreate", null);
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        Parcelable parcelable = arguments.getParcelable("ARG_PARAM_SCAN_CONFIGURATION");
        if (parcelable == null) {
            Intrinsics.throwNpe();
        }
        this.f7047d = (DocumentScanDetailedConfig) parcelable;
        Parcelable parcelable2 = arguments.getParcelable(ARG_PARAM_VIEW_CONFIGURATION);
        if (parcelable2 == null) {
            Intrinsics.throwNpe();
        }
        this.f7048e = (IScanViewConfiguration) parcelable2;
        this.f7050g = arguments.getInt(ARG_PARAM_VIEW_LAYOUT_RES);
        Serializable serializable = arguments.getSerializable(ARG_IMAGE_FORMAT);
        if (!(serializable instanceof ImageFormat)) {
            serializable = null;
        }
        ImageFormat imageFormatM4840a = (ImageFormat) serializable;
        if (imageFormatM4840a == null) {
            imageFormatM4840a = ImageFormat.INSTANCE.m4840a();
        }
        this.f7049f = imageFormatM4840a;
        this.f7052i = new CameraLifecycle(this, false, 2, null);
        C4803d c4803d = new C4803d();
        DocumentScanDetailedConfig documentScanDetailedConfig = this.f7047d;
        if (documentScanDetailedConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        C4724m c4724m = new C4724m(((DocumentScanDetailedPageConfig) CollectionsKt.first((List) documentScanDetailedConfig.getPageConfigs())).getWantedNbOfHolograms());
        Context contextRequireContext = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext, "requireContext()");
        DocumentScanDetailedConfig documentScanDetailedConfig2 = this.f7047d;
        if (documentScanDetailedConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        ImageFormat imageFormat = this.f7049f;
        if (imageFormat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageFormat");
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext2, "requireContext()");
        this.f7046c = new SimpleCameraPresenter(contextRequireContext, this, documentScanDetailedConfig2, c4803d, c4724m, imageFormat.getScanResultToImageTransformer$documentscan_release(contextRequireContext2, c4724m));
        m4966d();
        TraceMachine.exitMethod();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "SimpleCameraFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "SimpleCameraFragment#onCreateView", null);
        }
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        View viewInflate = inflater.inflate(C4695R.layout.fragment_simple_camera, container, false);
        if (viewInflate == null) {
            TypeCastException typeCastException = new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            TraceMachine.exitMethod();
            throw typeCastException;
        }
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(C4695R.id.documentScanOverlayContainer);
        View viewInflate2 = inflater.inflate(this.f7050g, (ViewGroup) frameLayout, false);
        Intrinsics.checkExpressionValueIsNotNull(viewInflate2, "inflater.inflate(overlay…nOverlayContainer, false)");
        frameLayout.addView(viewInflate2);
        if (!(viewInflate2 instanceof IScanView)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The root view of the layout provided to the library must be an IScanView");
            TraceMachine.exitMethod();
            throw illegalArgumentException;
        }
        IScanView iScanView = (IScanView) viewInflate2;
        this.f7051h = iScanView;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
        }
        IScanViewConfiguration iScanViewConfiguration = this.f7048e;
        if (iScanViewConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        }
        iScanView.setupView(iScanViewConfiguration);
        TraceMachine.exitMethod();
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        m4972c();
    }

    @Override // com.yoti.mobile.android.documentscan.ui.camera.InterfaceC4793x
    public void onFrontSideScanned(DocumentCaptureResult documentCaptureResult) {
        Intrinsics.checkParameterIsNotNull(documentCaptureResult, "documentCaptureResult");
        ScanMultiSideDocumentListener f7045b = getF7001b();
        if (f7045b != null) {
            f7045b.onFrontSideScanned(documentCaptureResult);
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.camera.InterfaceC4793x
    public void onScanCompleted(DocumentCaptureResult resultFront, DocumentCaptureResult resultBack) {
        Intrinsics.checkParameterIsNotNull(resultFront, "resultFront");
        ScanMultiSideDocumentListener f7045b = getF7001b();
        if (f7045b != null) {
            f7045b.onScanCompleted(resultFront, resultBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        SimpleCameraPresenter simpleCameraPresenter = this.f7046c;
        if (simpleCameraPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        simpleCameraPresenter.m4986b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        mo4968a(0);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void setListener(ScanMultiSideDocumentListener scanMultiSideDocumentListener) {
        this.f7045b = scanMultiSideDocumentListener;
    }
}
