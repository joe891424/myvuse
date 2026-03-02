package com.microblink.uisettings;

import android.content.Intent;
import com.microblink.activity.DocumentScanActivity;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.fragment.overlay.blinkid.document.DocumentOverlayStrings;
import com.microblink.fragment.overlay.blinkid.document.DocumentOverlayView;
import com.microblink.uisettings.options.StringsUIOptions;
import com.microblink.uisettings.options.StyleUIOptions;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentUISettings extends BaseBlinkIdUiSettings implements StyleUIOptions, StringsUIOptions<DocumentOverlayStrings> {
    private static final String llIllIIlll = UISettings.llIIlIlIIl("DocumentScanActivity", "style");
    private static final String lllllIlIll = UISettings.llIIlIlIIl("DocumentScanActivity", "strings");

    public DocumentUISettings(RecognizerBundle recognizerBundle) {
        super(recognizerBundle);
    }

    @Override // com.microblink.uisettings.BaseBlinkIdUiSettings
    protected BlinkIdOverlayView createOverlayView() {
        return new DocumentOverlayView((DocumentOverlayStrings) llIIlIlIIl(lllllIlIll), IlIllIlIIl(llIllIIlll, 0));
    }

    @Override // com.microblink.uisettings.UISettings
    public Class<?> getTargetActivity() {
        return DocumentScanActivity.class;
    }

    @Override // com.microblink.uisettings.BaseBlinkIdUiSettings
    protected boolean isLockedToPortrait() {
        return false;
    }

    @Override // com.microblink.uisettings.options.StyleUIOptions
    public void setOverlayViewStyle(int i) {
        llIIlIlIIl(llIllIIlll, i);
    }

    public DocumentUISettings(Intent intent) {
        super(intent);
    }

    @Override // com.microblink.uisettings.options.StringsUIOptions
    public void setStrings(DocumentOverlayStrings documentOverlayStrings) {
        llIIlIlIIl(lllllIlIll, documentOverlayStrings);
    }
}
