package com.yoti.mobile.android.documentscan.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.framegrabber.FrameGrabberRecognizer;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.view.CameraEventsListener;
import com.microblink.view.recognition.RecognizerRunnerView;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.documentscan.C4695R;
import com.yoti.mobile.android.documentscan.domain.BlinkIdRecognizerSettingsFactory;
import com.yoti.mobile.android.documentscan.domain.C4724m;
import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.BlinkIDLicense;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.ui.BlinkIDLicenseHelper;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.documentscan.ui.ScanningState;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4800a;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4802c;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4803d;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000f\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002ABB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\u0012\u0010)\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020-2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00104\u001a\u00020\"H\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u00107\u001a\u00020\"2\n\u00108\u001a\u0006\u0012\u0002\b\u000309H\u0002J\b\u0010:\u001a\u00020\"H\u0002J\u0010\u0010;\u001a\u00020\"2\u0006\u0010&\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\"2\u0006\u0010&\u001a\u00020>H\u0002J\f\u0010?\u001a\u00020@*\u000206H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000¨\u0006C"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ScanDocumentMultiSideFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "()V", "blinkIdLicense", "Lcom/yoti/mobile/android/documentscan/model/BlinkIDLicense;", "blinkIdRecognizerSettingsFactory", "Lcom/yoti/mobile/android/documentscan/domain/BlinkIdRecognizerSettingsFactory;", "blinkRecognizerView", "Lcom/microblink/view/recognition/RecognizerRunnerView;", "cameraCropHelper", "Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/CameraCropHelper;", "documentOverlay", "Lcom/yoti/mobile/android/documentscan/ui/IScanView;", "frameCallback", "com/yoti/mobile/android/documentscan/ui/ScanDocumentMultiSideFragment$frameCallback$1", "Lcom/yoti/mobile/android/documentscan/ui/ScanDocumentMultiSideFragment$frameCallback$1;", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "getListener", "()Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "setListener", "(Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;)V", "overlayLayoutRes", "", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "viewConfig", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "viewModel", "Lcom/yoti/mobile/android/documentscan/ui/ScanDocumentMultiSideViewModel;", "documentPageReviewed", "", "approved", "", "handleScanningState", "state", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState;", "notifyBlinkReady", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "pauseDetection", "scanAreaAsFraction", "Landroid/graphics/RectF;", "setupBlinkRecognizer", "documentRecognizer", "Lcom/microblink/entities/recognizers/Recognizer;", "setupMetadataCallbacks", "startBackPageReview", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$ReviewBack;", "startFrontPageReview", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$ReviewFront;", "toRectangle", "Lcom/microblink/geometry/Rectangle;", "BlinkCameraEventsListener", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class ScanDocumentMultiSideFragment extends Fragment implements IScanDocument, TraceFieldInterface {
    private static final String ARG_PARAM_BLINKID_LICENSE = "ARG_PARAM_BLINKID_LICENSE";
    private static final String ARG_PARAM_IMAGE_FORMAT = "ARG_PARAM_IMAGE_FORMAT";
    private static final String ARG_PARAM_SCAN_CONFIGURATION = "ARG_PARAM_SCAN_CONFIGURATION";
    private static final String ARG_PARAM_VIEW_CONFIGURATION = "ARG_PARAM_VIEW_CONFIGURATION";
    private static final String ARG_PARAM_VIEW_LAYOUT_RES = "ARG_PARAM_VIEW_LAYOUT_RES";

    /* JADX INFO: renamed from: a */
    public static final Companion f7000a = new Companion(null);
    public Trace _nr_trace;

    /* JADX INFO: renamed from: b */
    private ScanMultiSideDocumentListener f7001b;

    /* JADX INFO: renamed from: c */
    private int f7002c;

    /* JADX INFO: renamed from: d */
    private DocumentScanDetailedConfig f7003d;

    /* JADX INFO: renamed from: e */
    private IScanView f7004e;

    /* JADX INFO: renamed from: f */
    private ScanDocumentMultiSideViewModel f7005f;

    /* JADX INFO: renamed from: g */
    private IScanViewConfiguration f7006g;

    /* JADX INFO: renamed from: h */
    private ImageFormat f7007h;

    /* JADX INFO: renamed from: j */
    private BlinkIDLicense f7009j;

    /* JADX INFO: renamed from: k */
    private RecognizerRunnerView f7010k;

    /* JADX INFO: renamed from: n */
    private HashMap f7013n;

    /* JADX INFO: renamed from: i */
    private final C4803d f7008i = new C4803d();

    /* JADX INFO: renamed from: l */
    private final BlinkIdRecognizerSettingsFactory f7011l = new BlinkIdRecognizerSettingsFactory();

    /* JADX INFO: renamed from: m */
    private final C4810n f7012m = new C4810n(this);

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ScanDocumentMultiSideFragment$Companion;", "", "()V", "ARG_PARAM_BLINKID_LICENSE", "", "ARG_PARAM_IMAGE_FORMAT", "ARG_PARAM_SCAN_CONFIGURATION", ScanDocumentMultiSideFragment.ARG_PARAM_VIEW_CONFIGURATION, ScanDocumentMultiSideFragment.ARG_PARAM_VIEW_LAYOUT_RES, "newInstance", "Lcom/yoti/mobile/android/documentscan/ui/ScanDocumentMultiSideFragment;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "viewConfig", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "blinkIdLicense", "Lcom/yoti/mobile/android/documentscan/model/BlinkIDLicense;", "scanLayout", "", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ScanDocumentMultiSideFragment newInstance(DocumentScanDetailedConfig scanConfig, IScanViewConfiguration viewConfig, BlinkIDLicense blinkIdLicense, int scanLayout, ImageFormat imageFormat) {
            Intrinsics.checkParameterIsNotNull(scanConfig, "scanConfig");
            Intrinsics.checkParameterIsNotNull(viewConfig, "viewConfig");
            Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
            ScanDocumentMultiSideFragment scanDocumentMultiSideFragment = new ScanDocumentMultiSideFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PARAM_SCAN_CONFIGURATION", scanConfig);
            bundle.putParcelable("ARG_PARAM_BLINKID_LICENSE", blinkIdLicense);
            bundle.putInt(ScanDocumentMultiSideFragment.ARG_PARAM_VIEW_LAYOUT_RES, scanLayout);
            bundle.putParcelable(ScanDocumentMultiSideFragment.ARG_PARAM_VIEW_CONFIGURATION, viewConfig);
            bundle.putSerializable("ARG_PARAM_IMAGE_FORMAT", imageFormat);
            scanDocumentMultiSideFragment.setArguments(bundle);
            return scanDocumentMultiSideFragment;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.ScanDocumentMultiSideFragment$a */
    private final class C4765a implements CameraEventsListener {
        public C4765a() {
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusFailed() {
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusStarted(Rect[] rectArr) {
        }

        @Override // com.microblink.hardware.camera.AutofocusListener
        public void onAutofocusStopped(Rect[] rectArr) {
        }

        @Override // com.microblink.view.CameraEventsListener
        public void onCameraPermissionDenied() {
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onCameraPreviewStarted() {
            Lifecycle lifecycle = ScanDocumentMultiSideFragment.this.getLifecycle();
            Intrinsics.checkExpressionValueIsNotNull(lifecycle, "lifecycle");
            if (lifecycle.getState().isAtLeast(Lifecycle.State.CREATED)) {
                ScanDocumentMultiSideFragment.this.m4912b();
            }
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onCameraPreviewStopped() {
        }

        @Override // com.microblink.view.BaseCameraEventsListener
        public void onError(Throwable throwable) {
            Intrinsics.checkParameterIsNotNull(throwable, "throwable");
            ScanMultiSideDocumentListener f7001b = ScanDocumentMultiSideFragment.this.getListener();
            if (f7001b != null) {
                f7001b.onError(new DocumentCaptureException.BlinkCameraEventException(throwable));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private final RectF m4904a(IScanView iScanView) {
        if (!(iScanView instanceof View)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        View view = (View) iScanView;
        return new RectF(iScanView.getScanArea().left / view.getRight(), iScanView.getScanArea().top / view.getBottom(), iScanView.getScanArea().right / view.getRight(), iScanView.getScanArea().bottom / view.getBottom());
    }

    /* JADX INFO: renamed from: a */
    private final Rectangle m4905a(RectF rectF) {
        float f = rectF.left;
        float f2 = rectF.top;
        return new Rectangle(f, f2, rectF.right - f, rectF.bottom - f2);
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ ScanDocumentMultiSideViewModel m4906a(ScanDocumentMultiSideFragment scanDocumentMultiSideFragment) {
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel = scanDocumentMultiSideFragment.f7005f;
        if (scanDocumentMultiSideViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return scanDocumentMultiSideViewModel;
    }

    /* JADX INFO: renamed from: a */
    private final void m4907a(Recognizer<?> recognizer) {
        FrameGrabberRecognizer frameGrabberRecognizer = new FrameGrabberRecognizer(this.f7012m);
        frameGrabberRecognizer.setGrabUnfocusedFrames(false);
        RecognizerRunnerView recognizerRunnerView = this.f7010k;
        if (recognizerRunnerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        recognizerRunnerView.setRecognizerBundle(new RecognizerBundle(frameGrabberRecognizer, recognizer));
        recognizerRunnerView.setScanResultListener(new C4824s(this, frameGrabberRecognizer, recognizer));
        recognizerRunnerView.setCameraEventsListener(new C4765a());
        recognizerRunnerView.setOrientationAllowedListener(C4825t.f7161a);
        recognizerRunnerView.setLifecycle(getLifecycle());
        m4915d();
    }

    /* JADX INFO: renamed from: a */
    private final void m4908a(ScanningState.g gVar) {
        ScanMultiSideDocumentListener f7001b;
        m4914c();
        DocumentCaptureResult documentCaptureResultM4900a = gVar.m4900a();
        if (documentCaptureResultM4900a == null || (f7001b = getListener()) == null) {
            return;
        }
        f7001b.onBackSideScanned(documentCaptureResultM4900a);
    }

    /* JADX INFO: renamed from: a */
    private final void m4909a(ScanningState.h hVar) {
        ScanMultiSideDocumentListener f7001b;
        m4914c();
        DocumentCaptureResult documentCaptureResultM4901a = hVar.m4901a();
        if (documentCaptureResultM4901a == null || (f7001b = getListener()) == null) {
            return;
        }
        f7001b.onFrontSideScanned(documentCaptureResultM4901a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4910a(ScanningState scanningState) {
        Unit unit;
        if (scanningState instanceof ScanningState.j) {
            RecognizerRunnerView recognizerRunnerView = this.f7010k;
            if (recognizerRunnerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
            }
            recognizerRunnerView.resumeScanning(true);
            IScanView iScanView = this.f7004e;
            if (iScanView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
            }
            DocumentScanDetailedConfig documentScanDetailedConfig = this.f7003d;
            if (documentScanDetailedConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
            }
            iScanView.updateForPage(0, documentScanDetailedConfig.getPageConfigs().get(0).getDocumentConfigKey());
            return;
        }
        if (scanningState instanceof ScanningState.i) {
            RecognizerRunnerView recognizerRunnerView2 = this.f7010k;
            if (recognizerRunnerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
            }
            recognizerRunnerView2.resumeScanning(!((ScanningState.i) scanningState).m4902a());
            IScanView iScanView2 = this.f7004e;
            if (iScanView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
            }
            DocumentScanDetailedConfig documentScanDetailedConfig2 = this.f7003d;
            if (documentScanDetailedConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
            }
            iScanView2.updateForPage(1, documentScanDetailedConfig2.getPageConfigs().get(1).getDocumentConfigKey());
            return;
        }
        if (scanningState instanceof ScanningState.c) {
            ((RecognizerRunnerView) m4916a(C4695R.id.documentScanView)).setTorchState(true, C4811o.f7133a);
            return;
        }
        if (scanningState instanceof ScanningState.h) {
            m4909a((ScanningState.h) scanningState);
            return;
        }
        if (scanningState instanceof ScanningState.g) {
            m4908a((ScanningState.g) scanningState);
            return;
        }
        if (scanningState instanceof ScanningState.d) {
            IScanView iScanView3 = this.f7004e;
            if (iScanView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
            }
            iScanView3.displayDocumentDetected();
            return;
        }
        if (scanningState instanceof ScanningState.e) {
            IScanView iScanView4 = this.f7004e;
            if (iScanView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
            }
            iScanView4.hideDocumentDetected();
            return;
        }
        if (!(scanningState instanceof ScanningState.b)) {
            if (scanningState instanceof ScanningState.f) {
                ScanMultiSideDocumentListener f7001b = getListener();
                if (f7001b != null) {
                    f7001b.onError(((ScanningState.f) scanningState).m4899a());
                    return;
                }
                return;
            }
            if (scanningState instanceof ScanningState.a) {
                IScanView iScanView5 = this.f7004e;
                if (iScanView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
                }
                iScanView5.displayManualCaptureMode(((ScanningState.a) scanningState).m4896a(), true, new C4812p(this));
                return;
            }
            return;
        }
        ScanningState.b bVar = (ScanningState.b) scanningState;
        DocumentCaptureResult documentCaptureResultM4898b = bVar.m4898b();
        if (documentCaptureResultM4898b != null) {
            ScanMultiSideDocumentListener f7001b2 = getListener();
            if (f7001b2 != null) {
                f7001b2.onScanCompleted(documentCaptureResultM4898b, bVar.m4897a());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        ScanMultiSideDocumentListener f7001b3 = getListener();
        if (f7001b3 != null) {
            f7001b3.onError(new DocumentCaptureException.DocumentCaptureFailedException("The capture result of the front page is null", null, 2, null));
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m4912b() {
        RecognizerRunnerView recognizerRunnerView = (RecognizerRunnerView) m4916a(C4695R.id.documentScanView);
        IScanView iScanView = this.f7004e;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
        }
        recognizerRunnerView.setScanningRegion(m4905a(m4904a(iScanView)), true);
        C4803d c4803d = this.f7008i;
        RecognizerRunnerView recognizerRunnerView2 = this.f7010k;
        if (recognizerRunnerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        int width = recognizerRunnerView2.getWidth();
        RecognizerRunnerView recognizerRunnerView3 = this.f7010k;
        if (recognizerRunnerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        int height = recognizerRunnerView3.getHeight();
        RecognizerRunnerView recognizerRunnerView4 = this.f7010k;
        if (recognizerRunnerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        RectF visiblePart = recognizerRunnerView4.getVisiblePart();
        Intrinsics.checkExpressionValueIsNotNull(visiblePart, "blinkRecognizerView.visiblePart");
        IScanView iScanView2 = this.f7004e;
        if (iScanView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
        }
        RectF scanArea = iScanView2.getScanArea();
        C4802c c4802c = new C4802c();
        RecognizerRunnerView recognizerRunnerView5 = this.f7010k;
        if (recognizerRunnerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        c4803d.m5009a(width, height, visiblePart, scanArea, c4802c.m5007a(recognizerRunnerView5.getCurrentOrientation()));
    }

    /* JADX INFO: renamed from: c */
    private final void m4914c() {
        IScanView iScanView = this.f7004e;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
        }
        iScanView.reset();
        ((RecognizerRunnerView) m4916a(C4695R.id.documentScanView)).setTorchState(false, C4823r.f7157a);
        RecognizerRunnerView recognizerRunnerView = this.f7010k;
        if (recognizerRunnerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        recognizerRunnerView.pauseScanning();
    }

    /* JADX INFO: renamed from: d */
    private final void m4915d() {
        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        metadataCallbacks.setQuadDetectionCallback(new C4826u(this));
        metadataCallbacks.setFirstSideRecognitionCallback(new C4827v(this));
        RecognizerRunnerView recognizerRunnerView = this.f7010k;
        if (recognizerRunnerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        recognizerRunnerView.setMetadataCallbacks(metadataCallbacks);
    }

    /* JADX INFO: renamed from: a */
    public View m4916a(int i) {
        if (this.f7013n == null) {
            this.f7013n = new HashMap();
        }
        View view = (View) this.f7013n.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View viewFindViewById = view2.findViewById(i);
        this.f7013n.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX INFO: renamed from: a */
    public void m4917a() {
        HashMap map = this.f7013n;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void documentPageReviewed(boolean approved) {
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel = this.f7005f;
        if (scanDocumentMultiSideViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        scanDocumentMultiSideViewModel.m4933a(approved);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public ScanMultiSideDocumentListener getListener() {
        return this.f7001b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("ScanDocumentMultiSideFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ScanDocumentMultiSideFragment#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ScanDocumentMultiSideFragment#onCreate", null);
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable("ARG_PARAM_SCAN_CONFIGURATION");
            if (parcelable == null) {
                Intrinsics.throwNpe();
            }
            this.f7003d = (DocumentScanDetailedConfig) parcelable;
            Parcelable parcelable2 = arguments.getParcelable(ARG_PARAM_VIEW_CONFIGURATION);
            if (parcelable2 == null) {
                Intrinsics.throwNpe();
            }
            this.f7006g = (IScanViewConfiguration) parcelable2;
            this.f7009j = (BlinkIDLicense) arguments.getParcelable("ARG_PARAM_BLINKID_LICENSE");
            this.f7002c = arguments.getInt(ARG_PARAM_VIEW_LAYOUT_RES);
            Serializable serializable = arguments.getSerializable("ARG_PARAM_IMAGE_FORMAT");
            ImageFormat imageFormatM4840a = (ImageFormat) (serializable instanceof ImageFormat ? serializable : null);
            if (imageFormatM4840a == null) {
                imageFormatM4840a = ImageFormat.INSTANCE.m4840a();
            }
            this.f7007h = imageFormatM4840a;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext, "requireContext()");
        DocumentScanDetailedConfig documentScanDetailedConfig = this.f7003d;
        if (documentScanDetailedConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        DocumentScanDetailedConfig documentScanDetailedConfig2 = this.f7003d;
        if (documentScanDetailedConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        C4724m c4724m = new C4724m(documentScanDetailedConfig2.getPageConfigs().get(0).getWantedNbOfHolograms());
        C4803d c4803d = this.f7008i;
        ImageFormat imageFormat = this.f7007h;
        if (imageFormat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageFormat");
        }
        ViewModel viewModel = ViewModelProviders.m1220of(this, new C4761E(contextRequireContext, documentScanDetailedConfig, c4724m, c4803d, imageFormat)).get((Class<ViewModel>) ScanDocumentMultiSideViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(th…ideViewModel::class.java]");
        this.f7005f = (ScanDocumentMultiSideViewModel) viewModel;
        BlinkIDLicenseHelper.a aVar = BlinkIDLicenseHelper.f7023a;
        BlinkIDLicense blinkIDLicense = this.f7009j;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext2, "requireContext()");
        aVar.m4936a(blinkIDLicense, contextRequireContext2);
        TraceMachine.exitMethod();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ScanDocumentMultiSideFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ScanDocumentMultiSideFragment#onCreateView", null);
        }
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        View viewInflate = inflater.inflate(C4695R.layout.fragment_scan_multi_side_document, container, false);
        if (viewInflate == null) {
            TypeCastException typeCastException = new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            TraceMachine.exitMethod();
            throw typeCastException;
        }
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(C4695R.id.documentScanOverlayContainer);
        View viewInflate2 = inflater.inflate(this.f7002c, (ViewGroup) frameLayout, false);
        Intrinsics.checkExpressionValueIsNotNull(viewInflate2, "inflater.inflate(overlay…nOverlayContainer, false)");
        frameLayout.addView(viewInflate2);
        if (!(viewInflate2 instanceof IScanView)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The root view of the layout provided to the library must be an IScanView");
            TraceMachine.exitMethod();
            throw illegalArgumentException;
        }
        IScanView iScanView = (IScanView) viewInflate2;
        this.f7004e = iScanView;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentOverlay");
        }
        IScanViewConfiguration iScanViewConfiguration = this.f7006g;
        if (iScanViewConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        }
        iScanView.setupView(iScanViewConfiguration);
        View viewFindViewById = viewGroup.findViewById(C4695R.id.documentScanView);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById, "rootView.findViewById(R.id.documentScanView)");
        RecognizerRunnerView recognizerRunnerView = (RecognizerRunnerView) viewFindViewById;
        this.f7010k = recognizerRunnerView;
        if (recognizerRunnerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        recognizerRunnerView.setInitialOrientation(Orientation.ORIENTATION_PORTRAIT);
        RecognizerRunnerView recognizerRunnerView2 = this.f7010k;
        if (recognizerRunnerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerView");
        }
        recognizerRunnerView2.setForceUseLegacyCamera(C4800a.f7113c.m5006a());
        BlinkIdRecognizerSettingsFactory blinkIdRecognizerSettingsFactory = this.f7011l;
        DocumentScanDetailedConfig documentScanDetailedConfig = this.f7003d;
        if (documentScanDetailedConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        m4907a(blinkIdRecognizerSettingsFactory.m4778a(documentScanDetailedConfig.getPageConfigs().get(0).getBlinkRecognizerId()));
        TraceMachine.exitMethod();
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        m4917a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel = this.f7005f;
        if (scanDocumentMultiSideViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        scanDocumentMultiSideViewModel.m4929a().observe(getViewLifecycleOwner(), new C4813q(this));
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void setListener(ScanMultiSideDocumentListener scanMultiSideDocumentListener) {
        this.f7001b = scanMultiSideDocumentListener;
    }
}
