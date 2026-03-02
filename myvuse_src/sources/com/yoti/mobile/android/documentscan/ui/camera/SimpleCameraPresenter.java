package com.yoti.mobile.android.documentscan.ui.camera;

import android.content.Context;
import android.graphics.RectF;
import com.brentvatne.react.ReactVideoView;
import com.tinder.StateMachine;
import com.yoti.mobile.android.commons.async.LooperThreadScheduler;
import com.yoti.mobile.android.commons.async.ThreadScheduler;
import com.yoti.mobile.android.commons.image.ImageBuffer;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.documentscan.domain.C4721j;
import com.yoti.mobile.android.documentscan.domain.C4722k;
import com.yoti.mobile.android.documentscan.domain.C4724m;
import com.yoti.mobile.android.documentscan.domain.C4727p;
import com.yoti.mobile.android.documentscan.domain.C4728q;
import com.yoti.mobile.android.documentscan.domain.transformer.InterfaceC4730a;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.documentscan.ui.camera.Event;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.C4803d;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.e, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u00015B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J.\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0017J\u000e\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020%J\u0006\u00100\u001a\u00020%J\b\u00101\u001a\u00020%H\u0002J\u000e\u00102\u001a\u00020%2\u0006\u00103\u001a\u000204R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraPresenter;", "", "applicationContext", "Landroid/content/Context;", "view", "Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraView;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "cameraCropHelper", "Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/CameraCropHelper;", "frameStore", "Lcom/yoti/mobile/android/documentscan/domain/PreviewFrameStore;", "imageTransformer", "Lcom/yoti/mobile/android/documentscan/domain/transformer/IScanResultToImageTransformer;", "(Landroid/content/Context;Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraView;Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/CameraCropHelper;Lcom/yoti/mobile/android/documentscan/domain/PreviewFrameStore;Lcom/yoti/mobile/android/documentscan/domain/transformer/IScanResultToImageTransformer;)V", "mainThreadHandler", "Lcom/yoti/mobile/android/commons/async/ThreadScheduler;", "resultBuilderInteractor", "Lcom/yoti/mobile/android/documentscan/domain/ResultBuilderInteractor;", "documentCaptureInteractor", "Lcom/yoti/mobile/android/documentscan/domain/DocumentCaptureInteractor;", "(Lcom/yoti/mobile/android/documentscan/ui/camera/SimpleCameraView;Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;Lcom/yoti/mobile/android/commons/async/ThreadScheduler;Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/CameraCropHelper;Lcom/yoti/mobile/android/documentscan/domain/ResultBuilderInteractor;Lcom/yoti/mobile/android/documentscan/domain/DocumentCaptureInteractor;)V", "currentPage", "", "resultObserver", "Lio/reactivex/observers/DisposableSingleObserver;", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "stateMachine", "Lcom/tinder/StateMachine;", "Lcom/yoti/mobile/android/documentscan/ui/camera/State;", "Lcom/yoti/mobile/android/documentscan/ui/camera/Event;", "Lcom/yoti/mobile/android/documentscan/ui/camera/SideEffect;", "getStateMachine$documentscan_release", "()Lcom/tinder/StateMachine;", "subscriptions", "Lio/reactivex/disposables/CompositeDisposable;", "onCameraPreviewReady", "", "width", "height", "visiblePart", "Landroid/graphics/RectF;", "scanWindowPosition", ReactVideoView.EVENT_PROP_ORIENTATION, "onDocumentPageReviewed", "approved", "", "onManualCaptureClick", "onStop", "prepareDocumentCaptureResult", "processFrame", "image", "Lcom/yoti/mobile/android/commons/image/ImageBuffer;", "ScanResultConversionObserver", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class SimpleCameraPresenter {

    /* JADX INFO: renamed from: a */
    private final CompositeDisposable f7065a;

    /* JADX INFO: renamed from: b */
    private DisposableSingleObserver<DocumentCaptureResult> f7066b;

    /* JADX INFO: renamed from: c */
    private int f7067c;

    /* JADX INFO: renamed from: d */
    private final StateMachine<State, Event, SideEffect> f7068d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC4793x f7069e;

    /* JADX INFO: renamed from: f */
    private final DocumentScanDetailedConfig f7070f;

    /* JADX INFO: renamed from: g */
    private final ThreadScheduler f7071g;

    /* JADX INFO: renamed from: h */
    private final C4803d f7072h;

    /* JADX INFO: renamed from: i */
    private final C4727p f7073i;

    /* JADX INFO: renamed from: j */
    private final C4722k f7074j;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.camera.e$a */
    private final class a extends DisposableSingleObserver<DocumentCaptureResult> {
        public a() {
        }

        @Override // io.reactivex.SingleObserver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DocumentCaptureResult documentCaptureResult) {
            Intrinsics.checkParameterIsNotNull(documentCaptureResult, "documentCaptureResult");
            C4588L.logDebug("SimpleCameraPresenter", "Capture page " + SimpleCameraPresenter.this.f7067c + " result: " + documentCaptureResult);
            if (SimpleCameraPresenter.this.f7067c == 0) {
                SimpleCameraPresenter.this.f7074j.m4807b(documentCaptureResult);
                SimpleCameraPresenter.this.f7069e.onFrontSideScanned(documentCaptureResult);
            } else {
                SimpleCameraPresenter.this.f7074j.m4802a(documentCaptureResult);
                SimpleCameraPresenter.this.f7069e.onBackSideScanned(documentCaptureResult);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable throwable) {
            Intrinsics.checkParameterIsNotNull(throwable, "throwable");
            C4588L.logError("SimpleCameraPresenter", "Building scan result failed", throwable);
            SimpleCameraPresenter.this.f7069e.mo4969a(new DocumentCaptureException.ScanResultConversionException(null, 1, null));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleCameraPresenter(Context applicationContext, InterfaceC4793x view, DocumentScanDetailedConfig scanConfig, C4803d cameraCropHelper, C4724m frameStore, InterfaceC4730a imageTransformer) {
        this(view, scanConfig, new LooperThreadScheduler(null, 1, null), cameraCropHelper, new C4727p(applicationContext, imageTransformer, cameraCropHelper, frameStore, new C4721j()), new C4722k(frameStore, new C4728q()));
        Intrinsics.checkParameterIsNotNull(applicationContext, "applicationContext");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(scanConfig, "scanConfig");
        Intrinsics.checkParameterIsNotNull(cameraCropHelper, "cameraCropHelper");
        Intrinsics.checkParameterIsNotNull(frameStore, "frameStore");
        Intrinsics.checkParameterIsNotNull(imageTransformer, "imageTransformer");
    }

    public SimpleCameraPresenter(InterfaceC4793x view, DocumentScanDetailedConfig scanConfig, ThreadScheduler mainThreadHandler, C4803d cameraCropHelper, C4727p resultBuilderInteractor, C4722k documentCaptureInteractor) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(scanConfig, "scanConfig");
        Intrinsics.checkParameterIsNotNull(mainThreadHandler, "mainThreadHandler");
        Intrinsics.checkParameterIsNotNull(cameraCropHelper, "cameraCropHelper");
        Intrinsics.checkParameterIsNotNull(resultBuilderInteractor, "resultBuilderInteractor");
        Intrinsics.checkParameterIsNotNull(documentCaptureInteractor, "documentCaptureInteractor");
        this.f7069e = view;
        this.f7070f = scanConfig;
        this.f7071g = mainThreadHandler;
        this.f7072h = cameraCropHelper;
        this.f7073i = resultBuilderInteractor;
        this.f7074j = documentCaptureInteractor;
        this.f7065a = new CompositeDisposable();
        this.f7068d = StateMachine.INSTANCE.create(new C4792w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public final void m4978c() {
        if (!this.f7070f.getPageConfigs().get(this.f7067c).getShouldCaptureDocumentImage()) {
            this.f7074j.m4798a();
        }
        this.f7066b = new a();
        Disposable disposable = (Disposable) this.f7073i.m4838a(this.f7070f.getPageConfigs().get(this.f7067c).getPageNumber(), null).observeOn(AndroidSchedulers.mainThread()).subscribeWith(this.f7066b);
        if (disposable != null) {
            this.f7065a.add(disposable);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m4982a() {
        this.f7068d.transition(Event.a.f7057a);
    }

    /* JADX INFO: renamed from: a */
    public final void m4983a(int i, int i2, RectF visiblePart, RectF scanWindowPosition, int i3) {
        Intrinsics.checkParameterIsNotNull(visiblePart, "visiblePart");
        Intrinsics.checkParameterIsNotNull(scanWindowPosition, "scanWindowPosition");
        this.f7072h.m5009a(i, i2, visiblePart, scanWindowPosition, i3);
    }

    /* JADX INFO: renamed from: a */
    public final void m4984a(ImageBuffer image) {
        Intrinsics.checkParameterIsNotNull(image, "image");
        this.f7068d.transition(new Event.d(image));
    }

    /* JADX INFO: renamed from: a */
    public final void m4985a(boolean z) {
        StateMachine<State, Event, SideEffect> stateMachine;
        Event event;
        this.f7074j.m4811e();
        if (z) {
            stateMachine = this.f7068d;
            event = Event.b.f7058a;
        } else {
            stateMachine = this.f7068d;
            event = Event.c.f7059a;
        }
        stateMachine.transition(event);
    }

    /* JADX INFO: renamed from: b */
    public final void m4986b() {
        this.f7065a.clear();
        DisposableSingleObserver<DocumentCaptureResult> disposableSingleObserver = this.f7066b;
        if (disposableSingleObserver != null) {
            if (disposableSingleObserver.isDisposed()) {
                disposableSingleObserver = null;
            }
            if (disposableSingleObserver != null) {
                disposableSingleObserver.dispose();
            }
        }
    }
}
