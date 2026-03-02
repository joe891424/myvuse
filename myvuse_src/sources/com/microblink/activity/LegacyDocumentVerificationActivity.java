package com.microblink.activity;

import android.content.Intent;
import com.microblink.fragment.overlay.ScanningOverlay;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayController;
import com.microblink.uisettings.LegacyDocumentVerificationUISettings;
import com.microblink.uisettings.UISettings;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class LegacyDocumentVerificationActivity extends BaseScanActivity<LegacyDocumentVerificationUISettings, BlinkIdOverlayController> {
    @Override // com.microblink.activity.BaseScanActivity
    protected void IlIllIlIIl(Intent intent) {
        ((BlinkIdOverlayController) this.IllIIIllII).getHighResImagesBundle().saveToIntent(intent);
        ((BlinkIdOverlayController) this.IllIIIllII).getRecognizerBundle().saveToIntent(intent);
    }

    @Override // com.microblink.activity.BaseScanActivity, com.microblink.fragment.RecognizerRunnerFragment.ScanningOverlayBinder
    public /* bridge */ /* synthetic */ ScanningOverlay getScanningOverlay() {
        return super.getScanningOverlay();
    }

    @Override // com.microblink.activity.BaseScanActivity
    protected UISettings llIIlIlIIl(Intent intent) {
        return new LegacyDocumentVerificationUISettings(intent);
    }

    @Override // com.microblink.activity.BaseScanActivity, androidx.activity.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }
}
