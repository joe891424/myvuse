package com.microblink.uisettings;

import android.content.Intent;
import com.microblink.activity.LegacyDocumentVerificationActivity;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayStrings;
import com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayView;
import com.microblink.uisettings.options.StringsUIOptions;
import com.microblink.uisettings.options.StyleUIOptions;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class LegacyDocumentVerificationUISettings extends BaseBlinkIdUiSettings implements StyleUIOptions, StringsUIOptions<LegacyDocumentVerificationOverlayStrings> {
    private static final String llIllIIlll = UISettings.llIIlIlIIl("LegacyDocumentVerificationUISettings", "style");
    private static final String lllllIlIll = UISettings.llIIlIlIIl("LegacyDocumentVerificationUISettings", "strings");

    public LegacyDocumentVerificationUISettings(RecognizerBundle recognizerBundle) {
        super(recognizerBundle);
    }

    @Override // com.microblink.uisettings.BaseBlinkIdUiSettings
    protected BlinkIdOverlayView createOverlayView() {
        return new LegacyDocumentVerificationOverlayView(true, (LegacyDocumentVerificationOverlayStrings) llIIlIlIIl(lllllIlIll), IlIllIlIIl(llIllIIlll, 0), null);
    }

    @Override // com.microblink.uisettings.UISettings
    public Class<?> getTargetActivity() {
        return LegacyDocumentVerificationActivity.class;
    }

    @Override // com.microblink.uisettings.BaseBlinkIdUiSettings
    protected boolean isLockedToPortrait() {
        return true;
    }

    @Override // com.microblink.uisettings.options.StyleUIOptions
    public void setOverlayViewStyle(int i) {
        llIIlIlIIl(llIllIIlll, i);
    }

    public LegacyDocumentVerificationUISettings(Intent intent) {
        super(intent);
    }

    @Override // com.microblink.uisettings.options.StringsUIOptions
    public void setStrings(LegacyDocumentVerificationOverlayStrings legacyDocumentVerificationOverlayStrings) {
        llIIlIlIIl(lllllIlIll, legacyDocumentVerificationOverlayStrings);
    }
}
