package com.yoti.mobile.android.documentcapture.sup.view.scan.automation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationChooser;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/ICaptureChooser;", "supDocFileUriProvider", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationSupDocFileUriProvider;", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationSupDocFileUriProvider;)V", "showAutomationCapture", "", "activity", "Landroid/app/Activity;", "isCameraEnabled", "", "showCameraAndFilePickerChooser", "Landroid/net/Uri;", "showFilePicker", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationChooser implements ICaptureChooser {
    private final AutomationSupDocFileUriProvider supDocFileUriProvider;

    @Inject
    public AutomationChooser(AutomationSupDocFileUriProvider supDocFileUriProvider) {
        Intrinsics.checkNotNullParameter(supDocFileUriProvider, "supDocFileUriProvider");
        this.supDocFileUriProvider = supDocFileUriProvider;
    }

    private final void showAutomationCapture(Activity activity, boolean isCameraEnabled) {
        Intent intent = new Intent(activity, (Class<?>) AutomationCaptureActivity.class);
        intent.putExtra(AutomationCaptureActivityKt.EXTRA_CAMERA_ENABLED, isCameraEnabled);
        activity.startActivityForResult(intent, 2);
    }

    static /* synthetic */ void showAutomationCapture$default(AutomationChooser automationChooser, Activity activity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        automationChooser.showAutomationCapture(activity, z);
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser
    public Uri showCameraAndFilePickerChooser(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showAutomationCapture(activity, true);
        return this.supDocFileUriProvider.getImageUri();
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser
    public void showFilePicker(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showAutomationCapture$default(this, activity, false, 2, null);
    }
}
