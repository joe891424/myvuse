package com.yoti.mobile.android.documentscan.ui.wrapper;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microblink.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.documentscan.C4695R;
import com.yoti.mobile.android.documentscan.domain.BlinkIdRecognizerSettingsFactory;
import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.BlinkIDLicense;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedPageConfig;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.documentscan.ui.IScanDocument;
import com.yoti.mobile.android.documentscan.ui.IScanViewConfiguration;
import com.yoti.mobile.android.documentscan.ui.ScanDocumentMultiSideFragment;
import com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener;
import com.yoti.mobile.android.documentscan.ui.camera.SimpleCameraFragment;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.a.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002()B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0001H\u0002J\f\u0010'\u001a\u00020\u0007*\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/wrapper/ScanWrapperFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "()V", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "isAutofocusSupported", "", "()Z", "value", "Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "setListener", "(Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;)V", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "scanLayout", "", "viewConfig", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "wrappedFragment", "documentPageReviewed", "", "approved", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupListenerForWrappedFragment", "showFragment", "fragment", "isAadhaarQrCode", "Companion", "ErrorInterceptorListener", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class ScanWrapperFragment extends Fragment implements IScanDocument, TraceFieldInterface {
    private static final String ARG_PARAM_BLINKID_LICENSE = "ARG_PARAM_BLINKID_LICENSE";
    private static final String ARG_PARAM_IMAGE_FORMAT = "ARG_PARAM_IMAGE_FORMAT";
    private static final String ARG_PARAM_SCAN_CONFIGURATION = "ARG_PARAM_SCAN_CONFIGURATION";
    private static final String ARG_PARAM_VIEW_CONFIGURATION = "ARG_PARAM_VIEW_CONFIGURATION";
    private static final String ARG_PARAM_VIEW_LAYOUT_RES = "ARG_PARAM_VIEW_LAYOUT_RES";

    /* JADX INFO: renamed from: a */
    public static final a f7024a = new a(null);
    public Trace _nr_trace;

    /* JADX INFO: renamed from: b */
    private DocumentScanDetailedConfig f7025b;

    /* JADX INFO: renamed from: c */
    private IScanViewConfiguration f7026c;

    /* JADX INFO: renamed from: d */
    private ImageFormat f7027d;

    /* JADX INFO: renamed from: e */
    private int f7028e = -1;

    /* JADX INFO: renamed from: f */
    private IScanDocument f7029f;

    /* JADX INFO: renamed from: g */
    private ScanMultiSideDocumentListener f7030g;

    /* JADX INFO: renamed from: h */
    private HashMap f7031h;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.a.a$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final ScanWrapperFragment m4946a(DocumentScanDetailedConfig scanConfig, IScanViewConfiguration iScanViewConfiguration, BlinkIDLicense blinkIdLicense, int i, ImageFormat imageFormat) {
            Intrinsics.checkParameterIsNotNull(scanConfig, "scanConfig");
            Intrinsics.checkParameterIsNotNull(blinkIdLicense, "blinkIdLicense");
            Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
            ScanWrapperFragment scanWrapperFragment = new ScanWrapperFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PARAM_SCAN_CONFIGURATION", scanConfig);
            bundle.putParcelable(ScanWrapperFragment.ARG_PARAM_VIEW_CONFIGURATION, iScanViewConfiguration);
            bundle.putParcelable("ARG_PARAM_BLINKID_LICENSE", blinkIdLicense);
            bundle.putInt(ScanWrapperFragment.ARG_PARAM_VIEW_LAYOUT_RES, i);
            bundle.putSerializable("ARG_PARAM_IMAGE_FORMAT", imageFormat);
            scanWrapperFragment.setArguments(bundle);
            return scanWrapperFragment;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.a.a$b */
    private final class b implements ScanMultiSideDocumentListener {

        /* JADX INFO: renamed from: a */
        private final DocumentScanDetailedConfig f7032a;

        /* JADX INFO: renamed from: b */
        private final IScanViewConfiguration f7033b;

        /* JADX INFO: renamed from: c */
        private final int f7034c;

        /* JADX INFO: renamed from: d */
        private final ScanMultiSideDocumentListener f7035d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ ScanWrapperFragment f7036e;

        public b(ScanWrapperFragment scanWrapperFragment, DocumentScanDetailedConfig scanConfig, IScanViewConfiguration viewConfig, int i, ScanMultiSideDocumentListener baseListener) {
            Intrinsics.checkParameterIsNotNull(scanConfig, "scanConfig");
            Intrinsics.checkParameterIsNotNull(viewConfig, "viewConfig");
            Intrinsics.checkParameterIsNotNull(baseListener, "baseListener");
            this.f7036e = scanWrapperFragment;
            this.f7032a = scanConfig;
            this.f7033b = viewConfig;
            this.f7034c = i;
            this.f7035d = baseListener;
        }

        @Override // com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener
        public void onBackSideScanned(DocumentCaptureResult capture) {
            Intrinsics.checkParameterIsNotNull(capture, "capture");
            this.f7035d.onBackSideScanned(capture);
        }

        @Override // com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener
        public void onError(DocumentCaptureException t) {
            Intrinsics.checkParameterIsNotNull(t, "t");
            if (!(t.getCause() instanceof AutoFocusRequiredButNotSupportedException)) {
                ScanMultiSideDocumentListener f7030g = this.f7036e.getF7030g();
                if (f7030g != null) {
                    f7030g.onError(t);
                    return;
                }
                return;
            }
            ScanWrapperFragment scanWrapperFragment = this.f7036e;
            scanWrapperFragment.f7029f = SimpleCameraFragment.f7044a.newInstance(this.f7032a, this.f7033b, this.f7034c, ScanWrapperFragment.m4937a(scanWrapperFragment));
            ScanWrapperFragment scanWrapperFragment2 = this.f7036e;
            Object objM4942b = ScanWrapperFragment.m4942b(scanWrapperFragment2);
            if (objM4942b == null) {
                throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
            }
            scanWrapperFragment2.m4938a((Fragment) objM4942b);
            ScanWrapperFragment.m4942b(this.f7036e).setListener(this.f7035d);
        }

        @Override // com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener
        public void onFrontSideScanned(DocumentCaptureResult capture) {
            Intrinsics.checkParameterIsNotNull(capture, "capture");
            this.f7035d.onFrontSideScanned(capture);
        }

        @Override // com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener
        public void onScanCompleted(DocumentCaptureResult resultFront, DocumentCaptureResult documentCaptureResult) {
            Intrinsics.checkParameterIsNotNull(resultFront, "resultFront");
            this.f7035d.onScanCompleted(resultFront, documentCaptureResult);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ ImageFormat m4937a(ScanWrapperFragment scanWrapperFragment) {
        ImageFormat imageFormat = scanWrapperFragment.f7027d;
        if (imageFormat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageFormat");
        }
        return imageFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4938a(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(C4695R.id.rootContainer, fragment);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: renamed from: a */
    private final boolean m4941a(DocumentScanDetailedConfig documentScanDetailedConfig) {
        return Intrinsics.areEqual(((DocumentScanDetailedPageConfig) CollectionsKt.first((List) documentScanDetailedConfig.getPageConfigs())).getBlinkRecognizerId(), BlinkIdRecognizerSettingsFactory.a.AADHAAR_QRCODE.m4779a());
    }

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ IScanDocument m4942b(ScanWrapperFragment scanWrapperFragment) {
        IScanDocument iScanDocument = scanWrapperFragment.f7029f;
        if (iScanDocument == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wrappedFragment");
        }
        return iScanDocument;
    }

    /* JADX INFO: renamed from: b */
    private final boolean m4943b() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkExpressionValueIsNotNull(contextRequireContext, "requireContext()");
        return contextRequireContext.getPackageManager().hasSystemFeature("android.hardware.camera.autofocus");
    }

    /* JADX INFO: renamed from: c */
    private final void m4944c() {
        ScanMultiSideDocumentListener f7030g = getF7030g();
        if (f7030g != null) {
            IScanDocument iScanDocument = this.f7029f;
            if (iScanDocument == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wrappedFragment");
            }
            if (!(iScanDocument instanceof ScanDocumentMultiSideFragment)) {
                IScanDocument iScanDocument2 = this.f7029f;
                if (iScanDocument2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wrappedFragment");
                }
                iScanDocument2.setListener(f7030g);
                return;
            }
            IScanDocument iScanDocument3 = this.f7029f;
            if (iScanDocument3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wrappedFragment");
            }
            DocumentScanDetailedConfig documentScanDetailedConfig = this.f7025b;
            if (documentScanDetailedConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanConfig");
            }
            IScanViewConfiguration iScanViewConfiguration = this.f7026c;
            if (iScanViewConfiguration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            }
            iScanDocument3.setListener(new b(this, documentScanDetailedConfig, iScanViewConfiguration, this.f7028e, f7030g));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4945a() {
        HashMap map = this.f7031h;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void documentPageReviewed(boolean approved) {
        IScanDocument iScanDocument = this.f7029f;
        if (iScanDocument == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wrappedFragment");
        }
        iScanDocument.documentPageReviewed(approved);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    /* JADX INFO: renamed from: getListener, reason: from getter */
    public ScanMultiSideDocumentListener getF7030g() {
        return this.f7030g;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "a#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "a#onCreateView", null);
        }
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        View viewInflate = inflater.inflate(C4695R.layout.fragment_scan_wrapper, container, false);
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        m4945a();
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

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e1  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentscan.ui.wrapper.ScanWrapperFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    @Override // com.yoti.mobile.android.documentscan.ui.IScanDocument
    public void setListener(ScanMultiSideDocumentListener scanMultiSideDocumentListener) {
        this.f7030g = scanMultiSideDocumentListener;
        IScanDocument iScanDocument = this.f7029f;
        if (iScanDocument != null) {
            if (scanMultiSideDocumentListener != null) {
                m4944c();
                return;
            }
            if (iScanDocument == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wrappedFragment");
            }
            iScanDocument.setListener(scanMultiSideDocumentListener);
        }
    }
}
