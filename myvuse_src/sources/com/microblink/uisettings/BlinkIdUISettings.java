package com.microblink.uisettings;

import android.content.Intent;
import com.microblink.activity.BlinkIdActivity;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayStrings;
import com.microblink.fragment.overlay.blinkid.reticleui.ReticleOverlayView;
import com.microblink.uisettings.options.FlashlightWarningUIOptions;
import com.microblink.uisettings.options.StringsUIOptions;
import com.microblink.uisettings.options.StyleUIOptions;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class BlinkIdUISettings extends BaseBlinkIdUiSettings implements StringsUIOptions<ReticleOverlayStrings>, StyleUIOptions, FlashlightWarningUIOptions {
    private static final String llIllIIlll = UISettings.llIIlIlIIl("BlinkIdUISettings", "style");
    private static final String lllllIlIll = UISettings.llIIlIlIIl("BlinkIdUISettings", "strings");
    private static final String lIlllIlIlI = UISettings.llIIlIlIIl("BlinkIdUISettings", "showFlashlightWarning");

    public BlinkIdUISettings(RecognizerBundle recognizerBundle) {
        super(recognizerBundle);
    }

    @Override // com.microblink.uisettings.BaseBlinkIdUiSettings
    protected BlinkIdOverlayView createOverlayView() {
        return new ReticleOverlayView(true, getShowFlashlightWarning(), getStrings(), getStyle());
    }

    protected boolean getShowFlashlightWarning() {
        return IlIllIlIIl(lIlllIlIlI, true);
    }

    protected ReticleOverlayStrings getStrings() {
        return (ReticleOverlayStrings) llIIlIlIIl(lllllIlIll);
    }

    protected int getStyle() {
        return IlIllIlIIl(llIllIIlll, 0);
    }

    @Override // com.microblink.uisettings.UISettings
    public Class<?> getTargetActivity() {
        return BlinkIdActivity.class;
    }

    @Override // com.microblink.uisettings.BaseBlinkIdUiSettings
    protected boolean isLockedToPortrait() {
        return false;
    }

    @Override // com.microblink.uisettings.options.StyleUIOptions
    public void setOverlayViewStyle(int i) {
        llIIlIlIIl(llIllIIlll, i);
    }

    @Override // com.microblink.uisettings.options.FlashlightWarningUIOptions
    public void setShowFlashlightWarning(boolean z) {
        llIIlIlIIl(lIlllIlIlI, z);
    }

    public BlinkIdUISettings(Intent intent) {
        super(intent);
    }

    @Override // com.microblink.uisettings.options.StringsUIOptions
    public void setStrings(ReticleOverlayStrings reticleOverlayStrings) {
        llIIlIlIIl(lllllIlIll, reticleOverlayStrings);
    }
}
