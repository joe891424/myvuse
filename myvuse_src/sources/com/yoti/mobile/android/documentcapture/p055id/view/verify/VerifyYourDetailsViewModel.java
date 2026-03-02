package com.yoti.mobile.android.documentcapture.p055id.view.verify;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.ScreenState;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u00142\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bj\u0002`\u001e2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/verify/VerifyYourDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "bacCredentialMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/DocumentScanResultViewDataToBacCredentialMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/view/verify/DocumentScanResultViewDataToBacCredentialMapper;)V", "_screenState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;", "screenState", "Landroidx/lifecycle/LiveData;", "getScreenState$documentcapture_id_productionRelease", "()Landroidx/lifecycle/LiveData;", "value", "screenStateValue", "getScreenStateValue", "()Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;", "setScreenStateValue", "(Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;)V", "cancel", "", "cancelConfirmed", "captureNfc", "documentScanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "setNfcPayload", "chip", "", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "upload", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class VerifyYourDetailsViewModel extends ViewModel {
    private final MutableLiveData<SingleEvent<ScreenState>> _screenState;
    private final DocumentScanResultViewDataToBacCredentialMapper bacCredentialMapper;
    private final LiveData<SingleEvent<ScreenState>> screenState;

    @Inject
    public VerifyYourDetailsViewModel(DocumentScanResultViewDataToBacCredentialMapper bacCredentialMapper) {
        Intrinsics.checkNotNullParameter(bacCredentialMapper, "bacCredentialMapper");
        this.bacCredentialMapper = bacCredentialMapper;
        MutableLiveData<SingleEvent<ScreenState>> mutableLiveData = new MutableLiveData<>();
        this._screenState = mutableLiveData;
        this.screenState = mutableLiveData;
    }

    private final ScreenState getScreenStateValue() {
        SingleEvent<ScreenState> value = this._screenState.getValue();
        ScreenState screenStatePeekContent = value != null ? value.peekContent() : null;
        Intrinsics.checkNotNull(screenStatePeekContent);
        return screenStatePeekContent;
    }

    private final void setScreenStateValue(ScreenState screenState) {
        this._screenState.setValue(new SingleEvent<>(screenState));
    }

    public final void cancel() {
        setScreenStateValue(ScreenState.Cancel.INSTANCE);
    }

    public final void cancelConfirmed() {
        setScreenStateValue(ScreenState.CaptureDocument.INSTANCE);
    }

    public final void captureNfc(DocumentScanResultViewData documentScanResultViewData) {
        Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
        setScreenStateValue(new ScreenState.CaptureNfc(this.bacCredentialMapper.map(documentScanResultViewData)));
    }

    public final LiveData<SingleEvent<ScreenState>> getScreenState$documentcapture_id_productionRelease() {
        return this.screenState;
    }

    public final void setNfcPayload(Map<Integer, byte[]> chip, DocumentScanResultViewData documentScanResultViewData) {
        Intrinsics.checkNotNullParameter(chip, "chip");
        Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
        documentScanResultViewData.setMrtdCaptureResult(chip);
        setScreenStateValue(new ScreenState.Upload(documentScanResultViewData));
    }

    public final void upload(DocumentScanResultViewData documentScanResultViewData) {
        Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
        setScreenStateValue(new ScreenState.Upload(documentScanResultViewData));
    }
}
