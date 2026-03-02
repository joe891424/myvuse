package com.yoti.mobile.android.documentscan.ui;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.image.Image;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.view.recognition.DetectionStatus;
import com.yoti.mobile.android.documentscan.domain.C4715d;
import com.yoti.mobile.android.documentscan.domain.C4722k;
import com.yoti.mobile.android.documentscan.domain.C4727p;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedPageConfig;
import com.yoti.mobile.android.documentscan.ui.DocumentAction;
import com.yoti.mobile.android.documentscan.ui.PageAction;
import com.yoti.mobile.android.documentscan.ui.PageState;
import com.yoti.mobile.android.documentscan.ui.ScanningState;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020\u0017J\u0016\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0017H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ScanDocumentMultiSideViewModel;", "Landroidx/lifecycle/ViewModel;", "blinkImageConverter", "Lcom/yoti/mobile/android/documentscan/domain/BlinkImageConverter;", "stateManager", "Lcom/yoti/mobile/android/documentscan/ui/DocumentScanningStateManager;", "documentCaptureInteractor", "Lcom/yoti/mobile/android/documentscan/domain/DocumentCaptureInteractor;", "resultBuilderInteractor", "Lcom/yoti/mobile/android/documentscan/domain/ResultBuilderInteractor;", "(Lcom/yoti/mobile/android/documentscan/domain/BlinkImageConverter;Lcom/yoti/mobile/android/documentscan/ui/DocumentScanningStateManager;Lcom/yoti/mobile/android/documentscan/domain/DocumentCaptureInteractor;Lcom/yoti/mobile/android/documentscan/domain/ResultBuilderInteractor;)V", "_captureState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/documentscan/ui/ScanningState;", "captureState", "Landroidx/lifecycle/LiveData;", "getCaptureState", "()Landroidx/lifecycle/LiveData;", "manualCaptureHandler", "Landroid/os/Handler;", "subscriptions", "Lio/reactivex/disposables/CompositeDisposable;", "cancelManualTimer", "", "observeDocumentStates", "observeHologramFrameCapture", "observePageCompletion", "onCleared", "onDocumentDetected", "detectionStatus", "Lcom/microblink/view/recognition/DetectionStatus;", "onDocumentPageReviewed", "approved", "", "onFrameCaptured", "image", "Lcom/microblink/image/Image;", "onFrontSideRecognitionCompleted", "onManualCaptureRequested", "onScanCompleted", "recognitionType", "Lcom/microblink/recognition/RecognitionSuccessType;", "result", "Lcom/microblink/entities/recognizers/Recognizer$Result;", "startManualCaptureTimer", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class ScanDocumentMultiSideViewModel extends ViewModel {

    /* JADX INFO: renamed from: a */
    private final MutableLiveData<ScanningState> f7015a;

    /* JADX INFO: renamed from: b */
    private final LiveData<ScanningState> f7016b;

    /* JADX INFO: renamed from: c */
    private final CompositeDisposable f7017c;

    /* JADX INFO: renamed from: d */
    private final Handler f7018d;

    /* JADX INFO: renamed from: e */
    private final C4715d f7019e;

    /* JADX INFO: renamed from: f */
    private final C4769c f7020f;

    /* JADX INFO: renamed from: g */
    private final C4722k f7021g;

    /* JADX INFO: renamed from: h */
    private final C4727p f7022h;

    public ScanDocumentMultiSideViewModel(C4715d blinkImageConverter, C4769c stateManager, C4722k documentCaptureInteractor, C4727p resultBuilderInteractor) {
        Intrinsics.checkParameterIsNotNull(blinkImageConverter, "blinkImageConverter");
        Intrinsics.checkParameterIsNotNull(stateManager, "stateManager");
        Intrinsics.checkParameterIsNotNull(documentCaptureInteractor, "documentCaptureInteractor");
        Intrinsics.checkParameterIsNotNull(resultBuilderInteractor, "resultBuilderInteractor");
        this.f7019e = blinkImageConverter;
        this.f7020f = stateManager;
        this.f7021g = documentCaptureInteractor;
        this.f7022h = resultBuilderInteractor;
        MutableLiveData<ScanningState> mutableLiveData = new MutableLiveData<>();
        this.f7015a = mutableLiveData;
        this.f7016b = mutableLiveData;
        this.f7017c = new CompositeDisposable();
        this.f7018d = new Handler();
        m4927g();
        m4925f();
        m4924e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public final void m4922d() {
        this.f7018d.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: renamed from: e */
    private final void m4924e() {
        this.f7017c.add(this.f7020f.m4956a().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C4828w(this)));
    }

    /* JADX INFO: renamed from: f */
    private final void m4925f() {
        this.f7017c.add(this.f7020f.m4960c().filter(C4829x.f7165a).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C4830y(this)));
    }

    /* JADX INFO: renamed from: g */
    private final void m4927g() {
        this.f7017c.add(this.f7020f.m4960c().filter(C4831z.f7167a).flatMapSingle(new C4757A(this)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C4758B(this), new C4759C(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public final void m4928h() {
        DocumentScanDetailedPageConfig documentScanDetailedPageConfigM4959b = this.f7020f.m4959b();
        if (documentScanDetailedPageConfigM4959b.getAllowManualCapture()) {
            this.f7018d.postDelayed(new RunnableC4760D(this, documentScanDetailedPageConfigM4959b), documentScanDetailedPageConfigM4959b.getManualScanTimerMs());
        }
    }

    /* JADX INFO: renamed from: a */
    public final LiveData<ScanningState> m4929a() {
        return this.f7016b;
    }

    /* JADX INFO: renamed from: a */
    public final void m4930a(Image image) {
        C4769c c4769c;
        PageAction pageAction;
        Intrinsics.checkParameterIsNotNull(image, "image");
        PageState value = this.f7020f.m4960c().getValue();
        if (Intrinsics.areEqual(value, PageState.d.f7130a)) {
            this.f7021g.m4809c(this.f7019e.m4793b(image));
            this.f7021g.m4812f();
            c4769c = this.f7020f;
            pageAction = PageAction.d.f7124a;
        } else {
            if (!Intrinsics.areEqual(value, PageState.c.f7129a) || !this.f7021g.m4804a(this.f7019e.m4793b(image))) {
                return;
            }
            c4769c = this.f7020f;
            pageAction = PageAction.c.f7123a;
        }
        c4769c.m4958a(pageAction);
    }

    /* JADX INFO: renamed from: a */
    public final void m4931a(RecognitionSuccessType recognitionType, Recognizer.Result result) {
        Intrinsics.checkParameterIsNotNull(recognitionType, "recognitionType");
        Intrinsics.checkParameterIsNotNull(result, "result");
        if (recognitionType == RecognitionSuccessType.SUCCESSFUL) {
            this.f7021g.m4801a(result);
            this.f7020f.m4958a(PageAction.f.f7126a);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m4932a(DetectionStatus detectionStatus) {
        MutableLiveData<ScanningState> mutableLiveData;
        ScanningState scanningState;
        Intrinsics.checkParameterIsNotNull(detectionStatus, "detectionStatus");
        if (detectionStatus == DetectionStatus.SUCCESS) {
            this.f7020f.m4958a(PageAction.a.f7121a);
            mutableLiveData = this.f7015a;
            scanningState = ScanningState.d.f6993a;
        } else {
            mutableLiveData = this.f7015a;
            scanningState = ScanningState.e.f6994a;
        }
        mutableLiveData.postValue(scanningState);
    }

    /* JADX INFO: renamed from: a */
    public final void m4933a(boolean z) {
        C4769c c4769c;
        DocumentAction documentAction;
        this.f7021g.m4811e();
        if (z) {
            c4769c = this.f7020f;
            documentAction = DocumentAction.c.f7039a;
        } else {
            c4769c = this.f7020f;
            documentAction = DocumentAction.a.f7037a;
        }
        c4769c.m4957a(documentAction);
    }

    /* JADX INFO: renamed from: b */
    public final void m4934b() {
        this.f7020f.m4958a(PageAction.b.f7122a);
    }

    /* JADX INFO: renamed from: c */
    public final void m4935c() {
        this.f7020f.m4958a(PageAction.e.f7125a);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.f7017c.dispose();
        super.onCleared();
    }
}
