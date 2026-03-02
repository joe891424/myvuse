package com.yoti.mobile.android.documentscan.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microblink.directApi.RecognizerRunner;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.entities.recognizers.framegrabber.FrameGrabberRecognizer;
import com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.recognition.FeatureNotSupportedException;
import com.microblink.view.NotSupportedReason;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
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
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4803d;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.FilesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0013\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020'2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00106\u001a\u00020'H\u0016J\u001a\u00107\u001a\u00020'2\u0006\u00108\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00109\u001a\u00020'H\u0002J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\u0010\u0010<\u001a\u00020'2\u0006\u0010+\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020'2\u0006\u0010+\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000¨\u0006D"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ImageScanFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "()V", "backImageFilePath", "", "blinkIdLicense", "Lcom/yoti/mobile/android/documentscan/model/BlinkIDLicense;", "blinkIdRecognizerSettingsFactory", "Lcom/yoti/mobile/android/documentscan/domain/BlinkIdRecognizerSettingsFactory;", "blinkRecognizerRunner", "Lcom/microblink/directApi/RecognizerRunner;", "cameraCropHelper", "Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/CameraCropHelper;", "currentImageData", "", "currentPage", "", "frameCallback", "com/yoti/mobile/android/documentscan/ui/ImageScanFragment$frameCallback$1", "Lcom/yoti/mobile/android/documentscan/ui/ImageScanFragment$frameCallback$1;", "frontImageFilePath", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "getListener", "()Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "setListener", "(Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;)V", "recognizerBundle", "Lcom/microblink/entities/recognizers/RecognizerBundle;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "successFrameGrabber", "Lcom/microblink/entities/recognizers/successframe/SuccessFrameGrabberRecognizer;", "viewModel", "Lcom/yoti/mobile/android/documentscan/ui/ScanDocumentMultiSideViewModel;", "documentPageReviewed", "", "approved", "", "handleScanningState", "state", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStop", "onViewCreated", "view", "setupMetadataCallbacks", "setupRecognizer", "simulateHologramFrameCapture", "startBackPageReview", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$ReviewBack;", "startFrontPageReview", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState$ReviewFront;", "startOCR", "page", "imageFilePath", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class ImageScanFragment extends Fragment implements IScanDocument, TraceFieldInterface {
    public static final String ARG_PARAM_BACK_IMAGE_FILE_PATH = "ARG_PARAM_BACK_IMAGE_FILE_PATH";
    public static final String ARG_PARAM_BLINKID_LICENSE = "ARG_PARAM_BLINKID_LICENSE";
    public static final String ARG_PARAM_FRONT_IMAGE_FILE_PATH = "ARG_PARAM_FRONT_IMAGE_FILE_PATH";
    public static final String ARG_PARAM_IMAGE_FORMAT = "ARG_PARAM_IMAGE_FORMAT";
    public static final String ARG_PARAM_SCAN_CONFIGURATION = "ARG_PARAM_SCAN_CONFIGURATION";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ImageScanFragment";
    private HashMap _$_findViewCache;
    public Trace _nr_trace;
    private String backImageFilePath;
    private BlinkIDLicense blinkIdLicense;
    private RecognizerRunner blinkRecognizerRunner;
    private byte[] currentImageData;
    private int currentPage;
    private String frontImageFilePath;
    private ImageFormat imageFormat;
    private ScanMultiSideDocumentListener listener;
    private RecognizerBundle recognizerBundle;
    private DocumentScanDetailedConfig scanConfig;
    private SuccessFrameGrabberRecognizer successFrameGrabber;
    private ScanDocumentMultiSideViewModel viewModel;
    private final C4803d cameraCropHelper = new C4803d();
    private final C4796e frameCallback = new C4796e(this);
    private final BlinkIdRecognizerSettingsFactory blinkIdRecognizerSettingsFactory = new BlinkIdRecognizerSettingsFactory();

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ImageScanFragment$Companion;", "", "()V", ImageScanFragment.ARG_PARAM_BACK_IMAGE_FILE_PATH, "", ImageScanFragment.ARG_PARAM_BLINKID_LICENSE, ImageScanFragment.ARG_PARAM_FRONT_IMAGE_FILE_PATH, ImageScanFragment.ARG_PARAM_IMAGE_FORMAT, ImageScanFragment.ARG_PARAM_SCAN_CONFIGURATION, "TAG", "newInstance", "Lcom/yoti/mobile/android/documentscan/ui/ImageScanFragment;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "blinkIdLicense", "Lcom/yoti/mobile/android/documentscan/model/BlinkIDLicense;", "frontImageFilePath", "backImageFilePath", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ImageScanFragment newInstance$default(Companion companion, DocumentScanDetailedConfig documentScanDetailedConfig, BlinkIDLicense blinkIDLicense, String str, String str2, ImageFormat imageFormat, int i, Object obj) {
            if ((i & 16) != 0) {
                imageFormat = ImageFormat.INSTANCE.m4840a();
            }
            return companion.newInstance(documentScanDetailedConfig, blinkIDLicense, str, str2, imageFormat);
        }

        @JvmStatic
        public final ImageScanFragment newInstance(DocumentScanDetailedConfig scanConfig, BlinkIDLicense blinkIdLicense, String frontImageFilePath, String backImageFilePath, ImageFormat imageFormat) {
            Intrinsics.checkParameterIsNotNull(frontImageFilePath, "frontImageFilePath");
            Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
            ImageScanFragment imageScanFragment = new ImageScanFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ImageScanFragment.ARG_PARAM_SCAN_CONFIGURATION, scanConfig);
            bundle.putParcelable(ImageScanFragment.ARG_PARAM_BLINKID_LICENSE, blinkIdLicense);
            bundle.putString(ImageScanFragment.ARG_PARAM_FRONT_IMAGE_FILE_PATH, frontImageFilePath);
            bundle.putString(ImageScanFragment.ARG_PARAM_BACK_IMAGE_FILE_PATH, backImageFilePath);
            bundle.putSerializable(ImageScanFragment.ARG_PARAM_IMAGE_FORMAT, imageFormat);
            imageScanFragment.setArguments(bundle);
            return imageScanFragment;
        }
    }

    public static final /* synthetic */ byte[] access$getCurrentImageData$p(ImageScanFragment imageScanFragment) {
        byte[] bArr = imageScanFragment.currentImageData;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentImageData");
        }
        return bArr;
    }

    public static final /* synthetic */ SuccessFrameGrabberRecognizer access$getSuccessFrameGrabber$p(ImageScanFragment imageScanFragment) {
        SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = imageScanFragment.successFrameGrabber;
        if (successFrameGrabberRecognizer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successFrameGrabber");
        }
        return successFrameGrabberRecognizer;
    }

    public static final /* synthetic */ ScanDocumentMultiSideViewModel access$getViewModel$p(ImageScanFragment imageScanFragment) {
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel = imageScanFragment.viewModel;
        if (scanDocumentMultiSideViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return scanDocumentMultiSideViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleScanningState(ScanningState scanningState) {
        Unit unit;
        String str;
        int i;
        if (scanningState instanceof ScanningState.j) {
            str = this.frontImageFilePath;
            if (str == null) {
                return;
            } else {
                i = 0;
            }
        } else {
            if (!(scanningState instanceof ScanningState.i)) {
                if (scanningState instanceof ScanningState.h) {
                    startFrontPageReview((ScanningState.h) scanningState);
                    return;
                }
                if (scanningState instanceof ScanningState.g) {
                    startBackPageReview((ScanningState.g) scanningState);
                    return;
                }
                if (scanningState instanceof ScanningState.c) {
                    simulateHologramFrameCapture();
                    return;
                }
                if (scanningState instanceof ScanningState.b) {
                    ScanningState.b bVar = (ScanningState.b) scanningState;
                    DocumentCaptureResult documentCaptureResultM4898b = bVar.m4898b();
                    if (documentCaptureResultM4898b != null) {
                        ScanMultiSideDocumentListener listener = getListener();
                        if (listener != null) {
                            listener.onScanCompleted(documentCaptureResultM4898b, bVar.m4897a());
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit != null) {
                            return;
                        }
                    }
                    ScanMultiSideDocumentListener listener2 = getListener();
                    if (listener2 != null) {
                        listener2.onError(new DocumentCaptureException.DocumentCaptureFailedException("The capture result of the front page is null", null, 2, null));
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
                return;
            }
            str = this.backImageFilePath;
            if (str == null) {
                return;
            } else {
                i = 1;
            }
        }
        startOCR(i, str);
    }

    @JvmStatic
    public static final ImageScanFragment newInstance(DocumentScanDetailedConfig documentScanDetailedConfig, BlinkIDLicense blinkIDLicense, String str, String str2, ImageFormat imageFormat) {
        return INSTANCE.newInstance(documentScanDetailedConfig, blinkIDLicense, str, str2, imageFormat);
    }

    private final void setupMetadataCallbacks() {
        MetadataCallbacks metadataCallbacks = new MetadataCallbacks();
        metadataCallbacks.setQuadDetectionCallback(new C4798g(this));
        metadataCallbacks.setFirstSideRecognitionCallback(new C4799h(this));
        RecognizerRunner recognizerRunner = this.blinkRecognizerRunner;
        if (recognizerRunner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerRunner");
        }
        recognizerRunner.setMetadataCallbacks(metadataCallbacks);
    }

    private final void setupRecognizer() {
        try {
            RecognizerRunner singletonInstance = RecognizerRunner.getSingletonInstance();
            Intrinsics.checkExpressionValueIsNotNull(singletonInstance, "RecognizerRunner.getSingletonInstance()");
            this.blinkRecognizerRunner = singletonInstance;
        } catch (FeatureNotSupportedException e) {
            StringBuilder sb = new StringBuilder("Feature not supported because : ");
            NotSupportedReason reason = e.getReason();
            Intrinsics.checkExpressionValueIsNotNull(reason, "e.reason");
            LogInstrumentation.m2729e(TAG, sb.append(reason.getDescription()).toString(), e);
            ScanMultiSideDocumentListener listener = getListener();
            if (listener != null) {
                StringBuilder sb2 = new StringBuilder("Feature not supported because : ");
                NotSupportedReason reason2 = e.getReason();
                Intrinsics.checkExpressionValueIsNotNull(reason2, "e.reason");
                listener.onError(new DocumentCaptureException.DocumentCaptureFailedException(sb2.append(reason2.getDescription()).toString(), e));
            }
        }
        BlinkIdRecognizerSettingsFactory blinkIdRecognizerSettingsFactory = this.blinkIdRecognizerSettingsFactory;
        DocumentScanDetailedConfig documentScanDetailedConfig = this.scanConfig;
        if (documentScanDetailedConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        this.successFrameGrabber = new SuccessFrameGrabberRecognizer(blinkIdRecognizerSettingsFactory.m4778a(documentScanDetailedConfig.getPageConfigs().get(0).getBlinkRecognizerId()));
        FrameGrabberRecognizer frameGrabberRecognizer = new FrameGrabberRecognizer(this.frameCallback);
        frameGrabberRecognizer.setGrabUnfocusedFrames(false);
        Recognizer[] recognizerArr = new Recognizer[2];
        SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = this.successFrameGrabber;
        if (successFrameGrabberRecognizer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("successFrameGrabber");
        }
        recognizerArr[0] = successFrameGrabberRecognizer;
        recognizerArr[1] = frameGrabberRecognizer;
        this.recognizerBundle = new RecognizerBundle(recognizerArr);
        RecognizerRunner recognizerRunner = this.blinkRecognizerRunner;
        if (recognizerRunner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerRunner");
        }
        Context contextRequireContext = requireContext();
        RecognizerBundle recognizerBundle = this.recognizerBundle;
        if (recognizerBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recognizerBundle");
        }
        recognizerRunner.initialize(contextRequireContext, recognizerBundle, C4805i.f7118a);
    }

    private final void simulateHologramFrameCapture() {
        if (this.scanConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        Observable.intervalRange(1L, r0.getPageConfigs().get(this.currentPage).getWantedNbOfHolograms(), 300L, 300L, TimeUnit.MILLISECONDS).map(new C4806j(this)).subscribeOn(Schedulers.m5595io()).subscribe();
    }

    private final void startBackPageReview(ScanningState.g gVar) {
        ScanMultiSideDocumentListener listener;
        DocumentCaptureResult documentCaptureResultM4900a = gVar.m4900a();
        if (documentCaptureResultM4900a == null || (listener = getListener()) == null) {
            return;
        }
        listener.onBackSideScanned(documentCaptureResultM4900a);
    }

    private final void startFrontPageReview(ScanningState.h hVar) {
        ScanMultiSideDocumentListener listener;
        DocumentCaptureResult documentCaptureResultM4901a = hVar.m4901a();
        if (documentCaptureResultM4901a == null || (listener = getListener()) == null) {
            return;
        }
        listener.onFrontSideScanned(documentCaptureResultM4901a);
    }

    private final void startOCR(int page, String imageFilePath) {
        this.currentPage = page;
        byte[] bytes = FilesKt.readBytes(new File(imageFilePath));
        this.currentImageData = bytes;
        if (bytes == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentImageData");
        }
        byte[] bArr = this.currentImageData;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentImageData");
        }
        Bitmap image = BitmapFactoryInstrumentation.decodeByteArray(bytes, 0, bArr.length);
        C4803d c4803d = this.cameraCropHelper;
        Intrinsics.checkExpressionValueIsNotNull(image, "image");
        c4803d.m5009a(image.getWidth(), image.getHeight(), new RectF(0.0f, 0.0f, 0.99f, 0.99f), new RectF(0.0f, 0.0f, image.getHeight() * 0.99f, image.getWidth() * 0.99f), Orientation.ORIENTATION_PORTRAIT.intValue());
        RecognizerRunner recognizerRunner = this.blinkRecognizerRunner;
        if (recognizerRunner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerRunner");
        }
        recognizerRunner.recognizeBitmap(image, Orientation.ORIENTATION_PORTRAIT, new C4807k(this));
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View viewFindViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void documentPageReviewed(boolean approved) {
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel = this.viewModel;
        if (scanDocumentMultiSideViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        scanDocumentMultiSideViewModel.m4933a(approved);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public ScanMultiSideDocumentListener getListener() {
        return this.listener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing(TAG);
        try {
            TraceMachine.enterMethod(this._nr_trace, "ImageScanFragment#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ImageScanFragment#onCreate", null);
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable(ARG_PARAM_SCAN_CONFIGURATION);
            if (parcelable == null) {
                Intrinsics.throwNpe();
            }
            this.scanConfig = (DocumentScanDetailedConfig) parcelable;
            this.blinkIdLicense = (BlinkIDLicense) arguments.getParcelable(ARG_PARAM_BLINKID_LICENSE);
            this.frontImageFilePath = arguments.getString(ARG_PARAM_FRONT_IMAGE_FILE_PATH);
            this.backImageFilePath = arguments.getString(ARG_PARAM_BACK_IMAGE_FILE_PATH);
            Serializable serializable = arguments.getSerializable(ARG_PARAM_IMAGE_FORMAT);
            ImageFormat imageFormatM4840a = (ImageFormat) (serializable instanceof ImageFormat ? serializable : null);
            if (imageFormatM4840a == null) {
                imageFormatM4840a = ImageFormat.INSTANCE.m4840a();
            }
            this.imageFormat = imageFormatM4840a;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext, "requireContext()");
        DocumentScanDetailedConfig documentScanDetailedConfig = this.scanConfig;
        if (documentScanDetailedConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        DocumentScanDetailedConfig documentScanDetailedConfig2 = this.scanConfig;
        if (documentScanDetailedConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
        }
        C4724m c4724m = new C4724m(documentScanDetailedConfig2.getPageConfigs().get(0).getWantedNbOfHolograms());
        C4803d c4803d = this.cameraCropHelper;
        ImageFormat imageFormat = this.imageFormat;
        if (imageFormat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageFormat");
        }
        ViewModel viewModel = ViewModelProviders.m1220of(this, new C4761E(contextRequireContext, documentScanDetailedConfig, c4724m, c4803d, imageFormat)).get((Class<ViewModel>) ScanDocumentMultiSideViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(th…ideViewModel::class.java]");
        this.viewModel = (ScanDocumentMultiSideViewModel) viewModel;
        BlinkIDLicenseHelper.a aVar = BlinkIDLicenseHelper.f7023a;
        BlinkIDLicense blinkIDLicense = this.blinkIdLicense;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext2, "requireContext()");
        aVar.m4936a(blinkIDLicense, contextRequireContext2);
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ImageScanFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ImageScanFragment#onCreateView", null);
        }
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        View viewInflate = inflater.inflate(C4695R.layout.fragment_image_scan, container, false);
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        RecognizerRunner recognizerRunner = this.blinkRecognizerRunner;
        if (recognizerRunner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blinkRecognizerRunner");
        }
        recognizerRunner.terminate();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupRecognizer();
        setupMetadataCallbacks();
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel = this.viewModel;
        if (scanDocumentMultiSideViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        scanDocumentMultiSideViewModel.m4929a().observe(getViewLifecycleOwner(), new C4797f(this));
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void setListener(ScanMultiSideDocumentListener scanMultiSideDocumentListener) {
        this.listener = scanMultiSideDocumentListener;
    }
}
