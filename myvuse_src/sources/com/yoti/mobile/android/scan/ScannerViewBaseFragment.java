package com.yoti.mobile.android.scan;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commons.lifecycle.CameraLifecycle;
import com.yoti.mobile.android.scan.p076a.C4933b;
import java.util.HashMap;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010 \u001a\u00020\u0010J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m5598d2 = {"Lcom/yoti/mobile/android/scan/ScannerViewBaseFragment;", "Landroidx/fragment/app/Fragment;", "layout", "", "(I)V", "cameraLifecycle", "Lcom/yoti/mobile/android/commons/lifecycle/CameraLifecycle;", "mainThreadHandler", "Landroid/os/Handler;", "previewView", "Landroidx/camera/view/PreviewView;", "qrCodeErrorListener", "Lcom/yoti/mobile/android/scan/OnQrCodeErrorListener;", "qrCodeFoundListener", "Lcom/yoti/mobile/android/scan/OnQrCodeFoundListener;", "configureCameraView", "", "doesDeviceHaveBackFacingCamera", "", "onAttach", "activity", "Landroid/content/Context;", "onCodeFound", "code", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", "view", "Landroid/view/View;", "restart", "setupCamera", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "startCamera", "stopCamera", "Companion", "scan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public class ScannerViewBaseFragment extends Fragment implements TraceFieldInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    private PreviewView f7399a;

    /* JADX INFO: renamed from: b */
    private Handler f7400b;

    /* JADX INFO: renamed from: c */
    private CameraLifecycle f7401c;

    /* JADX INFO: renamed from: d */
    private OnQrCodeFoundListener f7402d;

    /* JADX INFO: renamed from: e */
    private InterfaceC4931a f7403e;

    /* JADX INFO: renamed from: f */
    private HashMap f7404f;

    /* JADX INFO: renamed from: com.yoti.mobile.android.scan.ScannerViewBaseFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ ScannerViewBaseFragment m5042a(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.m5043a(z);
        }

        @JvmStatic
        /* JADX INFO: renamed from: a */
        public final ScannerViewBaseFragment m5043a(boolean z) {
            ScannerViewBaseFragment scannerViewBaseFragment = new ScannerViewBaseFragment(0, 1, null);
            Bundle bundle = new Bundle();
            ScannerViewBaseFragment.INSTANCE.m5044a(bundle, z);
            scannerViewBaseFragment.setArguments(bundle);
            return scannerViewBaseFragment;
        }

        /* JADX INFO: renamed from: a */
        public final void m5044a(Bundle args, boolean z) {
            Intrinsics.checkParameterIsNotNull(args, "args");
            args.putBoolean(C4939e.f7424b, z);
        }
    }

    public ScannerViewBaseFragment() {
        this(0, 1, null);
    }

    public ScannerViewBaseFragment(int i) {
        super(i);
    }

    public /* synthetic */ ScannerViewBaseFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C4928R.layout.yoti_lib_scan_base_fragment : i);
    }

    /* JADX INFO: renamed from: a */
    private final void m5038a() {
        ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(requireActivity());
        Intrinsics.checkExpressionValueIsNotNull(processCameraProvider, "ProcessCameraProvider.ge…stance(requireActivity())");
        processCameraProvider.addListener(new RunnableC4934b(this, processCameraProvider), ContextCompat.getMainExecutor(requireContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5039a(ProcessCameraProvider processCameraProvider) {
        if (isAdded()) {
            Preview previewBuild = new Preview.Builder().build();
            Intrinsics.checkExpressionValueIsNotNull(previewBuild, "Preview.Builder().build()");
            CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(m5041b() ? 1 : 0).build();
            Intrinsics.checkExpressionValueIsNotNull(cameraSelectorBuild, "CameraSelector.Builder()…\n                .build()");
            ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
            Intrinsics.checkExpressionValueIsNotNull(imageAnalysisBuild, "ImageAnalysis.Builder()\n…KEEP_ONLY_LATEST).build()");
            imageAnalysisBuild.setAnalyzer(Executors.newSingleThreadExecutor(), new C4933b(new C4938d(this)));
            LifecycleOwner lifecycleOwner = this.f7401c;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cameraLifecycle");
            }
            processCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelectorBuild, previewBuild, imageAnalysisBuild);
            PreviewView previewView = this.f7399a;
            if (previewView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewView");
            }
            previewBuild.setSurfaceProvider(previewView.getSurfaceProvider());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5040a(String str) {
        Handler handler = this.f7400b;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainThreadHandler");
        }
        handler.post(new RunnableC4937c(this, str));
    }

    public static final /* synthetic */ CameraLifecycle access$getCameraLifecycle$p(ScannerViewBaseFragment scannerViewBaseFragment) {
        CameraLifecycle cameraLifecycle = scannerViewBaseFragment.f7401c;
        if (cameraLifecycle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraLifecycle");
        }
        return cameraLifecycle;
    }

    /* JADX INFO: renamed from: b */
    private final boolean m5041b() throws CameraAccessException {
        Object systemService = requireContext().getSystemService("camera");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        }
        CameraManager cameraManager = (CameraManager) systemService;
        String[] cameraIdList = cameraManager.getCameraIdList();
        Intrinsics.checkExpressionValueIsNotNull(cameraIdList, "cameraManager.cameraIdList");
        for (String str : cameraIdList) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
            if (num != null && num.intValue() == 1) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final ScannerViewBaseFragment init() {
        return Companion.m5042a(INSTANCE, false, 1, null);
    }

    @JvmStatic
    public static final ScannerViewBaseFragment init(boolean z) {
        return INSTANCE.m5043a(z);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this.f7404f;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f7404f == null) {
            this.f7404f = new HashMap();
        }
        View view = (View) this.f7404f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View viewFindViewById = view2.findViewById(i);
        this.f7404f.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        super.onAttach(activity);
        ActivityResultCaller parentFragment = getParentFragment();
        if (!(parentFragment instanceof OnQrCodeFoundListener)) {
            parentFragment = null;
        }
        OnQrCodeFoundListener onQrCodeFoundListener = (OnQrCodeFoundListener) parentFragment;
        if (onQrCodeFoundListener == null) {
            onQrCodeFoundListener = (OnQrCodeFoundListener) (!(activity instanceof OnQrCodeFoundListener) ? null : activity);
        }
        this.f7402d = onQrCodeFoundListener;
        ActivityResultCaller parentFragment2 = getParentFragment();
        if (!(parentFragment2 instanceof InterfaceC4931a)) {
            parentFragment2 = null;
        }
        InterfaceC4931a interfaceC4931a = (InterfaceC4931a) parentFragment2;
        if (interfaceC4931a == null) {
            if (!(activity instanceof InterfaceC4931a)) {
                activity = null;
            }
            interfaceC4931a = (InterfaceC4931a) activity;
        }
        this.f7403e = interfaceC4931a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("ScannerViewBaseFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ScannerViewBaseFragment#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ScannerViewBaseFragment#onCreate", null);
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        boolean z = arguments != null ? arguments.getBoolean(C4939e.f7424b) : false;
        this.f7400b = new Handler();
        this.f7401c = new CameraLifecycle(this, z);
        m5038a();
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.f7402d = null;
        this.f7403e = null;
        super.onDetach();
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
        View viewFindViewById = view.findViewById(C4928R.id.cameraPreview);
        Intrinsics.checkExpressionValueIsNotNull(viewFindViewById, "view.findViewById(R.id.cameraPreview)");
        this.f7399a = (PreviewView) viewFindViewById;
    }

    public final void restart() {
        if (isVisible()) {
            startCamera();
        }
    }

    public final void startCamera() {
        CameraLifecycle cameraLifecycle = this.f7401c;
        if (cameraLifecycle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraLifecycle");
        }
        cameraLifecycle.startCamera();
    }

    public final void stopCamera() {
        CameraLifecycle cameraLifecycle = this.f7401c;
        if (cameraLifecycle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraLifecycle");
        }
        cameraLifecycle.stopCamera();
    }
}
