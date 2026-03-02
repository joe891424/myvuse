package com.yoti.mobile.android.documentscan.ui.qr;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.documentscan.C4695R;
import com.yoti.mobile.android.documentscan.domain.p059a.aadhaar.AadhaarAddressFormatter;
import com.yoti.mobile.android.documentscan.domain.p059a.aadhaar.C4698b;
import com.yoti.mobile.android.documentscan.domain.utils.BlinkDateUtils;
import com.yoti.mobile.android.documentscan.domain.utils.DateChecker;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.documentscan.ui.IScanDocument;
import com.yoti.mobile.android.documentscan.ui.IScanView;
import com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener;
import com.yoti.mobile.android.documentscan.ui.ScanViewConfiguration;
import com.yoti.mobile.android.scan.OnQrCodeFoundListener;
import com.yoti.mobile.android.scan.ScannerViewBaseFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00010B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\u001a\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u00061"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/qr/QrCodeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/yoti/mobile/android/documentscan/ui/qr/QrCodeContract$View;", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "Lcom/yoti/mobile/android/scan/OnQrCodeFoundListener;", "()V", "errorStatusHandler", "Landroid/os/Handler;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "getListener", "()Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "setListener", "(Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;)V", "presenter", "Lcom/yoti/mobile/android/documentscan/ui/qr/QrCodePresenter;", "scanOverlayView", "Lcom/yoti/mobile/android/documentscan/ui/IScanView;", "scannerViewFragment", "Lcom/yoti/mobile/android/scan/ScannerViewBaseFragment;", "displayErrorState", "", "throwable", "", "documentPageReviewed", "approved", "", "finishWithScanResult", "documentCaptureResult", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onQrCodeFound", "qrText", "", "onStop", "onViewCreated", "view", "showWrongDocumentScannedError", "exception", "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException$AadhaarQrCodeNotRecognizedException;", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class QrCodeFragment extends Fragment implements InterfaceC4818e, IScanDocument, OnQrCodeFoundListener, TraceFieldInterface {
    private static final String ARG_DOCUMENT_CONFIG_KEY = "ARG_DOCUMENT_CONFIG_KEY";
    private static final String ARG_PARAM_VIEW_LAYOUT_RES = "ARG_PARAM_VIEW_LAYOUT_RES";
    private static final long CAMERA_RESTART_DELAY_MS = 2000;
    private static final String TAG_SCANNER_VIEW_FRAGMENT = "TAG_SCANNER_VIEW_FRAGMENT";

    /* JADX INFO: renamed from: a */
    public static final Companion f7136a = new Companion(null);
    public Trace _nr_trace;

    /* JADX INFO: renamed from: b */
    private ScanMultiSideDocumentListener f7137b;

    /* JADX INFO: renamed from: c */
    private IScanView f7138c;

    /* JADX INFO: renamed from: d */
    private ScannerViewBaseFragment f7139d;

    /* JADX INFO: renamed from: e */
    private C4822i f7140e;

    /* JADX INFO: renamed from: f */
    private final Handler f7141f = new Handler();

    /* JADX INFO: renamed from: g */
    private HashMap f7142g;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/qr/QrCodeFragment$Companion;", "", "()V", QrCodeFragment.ARG_DOCUMENT_CONFIG_KEY, "", QrCodeFragment.ARG_PARAM_VIEW_LAYOUT_RES, "CAMERA_RESTART_DELAY_MS", "", QrCodeFragment.TAG_SCANNER_VIEW_FRAGMENT, "newInstance", "Lcom/yoti/mobile/android/documentscan/ui/qr/QrCodeFragment;", "viewLayoutRes", "", "documentConfigKey", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final QrCodeFragment newInstance(int viewLayoutRes, String documentConfigKey) {
            Intrinsics.checkParameterIsNotNull(documentConfigKey, "documentConfigKey");
            QrCodeFragment qrCodeFragment = new QrCodeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(QrCodeFragment.ARG_PARAM_VIEW_LAYOUT_RES, viewLayoutRes);
            bundle.putString(QrCodeFragment.ARG_DOCUMENT_CONFIG_KEY, documentConfigKey);
            qrCodeFragment.setArguments(bundle);
            return qrCodeFragment;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ IScanView m5012a(QrCodeFragment qrCodeFragment) {
        IScanView iScanView = qrCodeFragment.f7138c;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlayView");
        }
        return iScanView;
    }

    /* JADX INFO: renamed from: a */
    public void m5013a() {
        HashMap map = this.f7142g;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.qr.InterfaceC4818e
    /* JADX INFO: renamed from: a */
    public void mo5014a(DocumentCaptureResult documentCaptureResult) {
        Intrinsics.checkParameterIsNotNull(documentCaptureResult, "documentCaptureResult");
        IScanView iScanView = this.f7138c;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlayView");
        }
        iScanView.displayDocumentDetected();
        ScanMultiSideDocumentListener f7137b = getF7137b();
        if (f7137b != null) {
            f7137b.onScanCompleted(documentCaptureResult, null);
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.qr.InterfaceC4818e
    /* JADX INFO: renamed from: a */
    public void mo5015a(DocumentCaptureException.AadhaarQrCodeNotRecognizedException exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        ScannerViewBaseFragment scannerViewBaseFragment = this.f7139d;
        if (scannerViewBaseFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scannerViewFragment");
        }
        scannerViewBaseFragment.restart();
        IScanView iScanView = this.f7138c;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlayView");
        }
        iScanView.displayErrorState();
        ScanMultiSideDocumentListener f7137b = getF7137b();
        if (f7137b != null) {
            f7137b.onError(exception);
        }
        this.f7141f.postDelayed(new RunnableC4819f(this), 2000L);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.qr.InterfaceC4818e
    /* JADX INFO: renamed from: a */
    public void mo5016a(Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        ScanMultiSideDocumentListener f7137b = getF7137b();
        if (f7137b != null) {
            f7137b.onError(new DocumentCaptureException.DocumentCaptureFailedException("", throwable));
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void documentPageReviewed(boolean approved) {
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    /* JADX INFO: renamed from: getListener, reason: from getter */
    public ScanMultiSideDocumentListener getF7137b() {
        return this.f7137b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("QrCodeFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "QrCodeFragment#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "QrCodeFragment#onCreate", null);
        }
        super.onCreate(savedInstanceState);
        this.f7140e = new C4822i(this, new C4815b(new AadhaarQrCodeResultExtractor(new C4698b(), new BlinkDateUtils(new DateChecker()), new AadhaarAddressFormatter())));
        TraceMachine.exitMethod();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "QrCodeFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "QrCodeFragment#onCreateView", null);
        }
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        View viewInflate = inflater.inflate(C4695R.layout.fragment_qr_code, container, false);
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt(ARG_PARAM_VIEW_LAYOUT_RES, -1) : -1;
        if (i == -1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You need to provide a valid layout resource id");
            TraceMachine.exitMethod();
            throw illegalArgumentException;
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C4695R.id.overlayContainer);
        View viewInflate2 = inflater.inflate(i, (ViewGroup) frameLayout, false);
        Intrinsics.checkExpressionValueIsNotNull(viewInflate2, "inflater.inflate(layoutR…rlayContainerView, false)");
        frameLayout.addView(viewInflate2);
        if (viewInflate2 instanceof IScanView) {
            this.f7138c = (IScanView) viewInflate2;
            TraceMachine.exitMethod();
            return viewInflate;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("The root view of the layout provided to the library must be an IScanView");
        TraceMachine.exitMethod();
        throw illegalArgumentException2;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        m5013a();
    }

    @Override // com.yoti.mobile.android.scan.OnQrCodeFoundListener
    public void onQrCodeFound(String qrText) {
        Intrinsics.checkParameterIsNotNull(qrText, "qrText");
        C4822i c4822i = this.f7140e;
        if (c4822i == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        c4822i.m5031a(qrText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        C4822i c4822i = this.f7140e;
        if (c4822i == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        c4822i.m5030a();
        this.f7141f.removeCallbacksAndMessages(null);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_DOCUMENT_CONFIG_KEY)) == null) {
            string = "AADHAAR";
        }
        this.f7139d = ScannerViewBaseFragment.Companion.init$default(ScannerViewBaseFragment.Companion, false, 1, (Object) null);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        int i = C4695R.id.rootView;
        ScannerViewBaseFragment scannerViewBaseFragment = this.f7139d;
        if (scannerViewBaseFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scannerViewFragment");
        }
        fragmentTransactionBeginTransaction.add(i, scannerViewBaseFragment, TAG_SCANNER_VIEW_FRAGMENT).commit();
        IScanView iScanView = this.f7138c;
        if (iScanView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlayView");
        }
        iScanView.setupView(new ScanViewConfiguration(1.0f));
        IScanView iScanView2 = this.f7138c;
        if (iScanView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanOverlayView");
        }
        iScanView2.updateForPage(0, string);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void setListener(ScanMultiSideDocumentListener scanMultiSideDocumentListener) {
        this.f7137b = scanMultiSideDocumentListener;
    }
}
