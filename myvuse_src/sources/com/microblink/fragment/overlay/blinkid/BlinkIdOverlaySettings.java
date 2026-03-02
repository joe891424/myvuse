package com.microblink.fragment.overlay.blinkid;

import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions;
import com.microblink.fragment.overlay.components.settings.OverlayCameraSettings;
import com.microblink.image.CurrentImageListener;
import com.microblink.image.DebugImageListener;
import com.microblink.uisettings.options.OcrResultDisplayMode;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class BlinkIdOverlaySettings {
    public static final long DEFAULT_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(17);
    public static final int TIMEOUT_INFINITY = 0;
    private boolean IIlIIIllIl;
    private RecognizerBundle IlIllIlIIl;
    private boolean IlIllIlllI;
    private boolean IllIIIIllI;
    private DebugImageListener IllIIIllII;
    private long IllIIlIIII;
    private OcrResultDisplayMode lIIIIIllll;
    private int lIlIIIIlIl;
    private CurrentImageListener llIIIlllll;
    private int llIIlIIlll;
    private OverlayCameraSettings llIIlIlIIl;
    private boolean lllIIIlIlI;
    private boolean lllIlIlIIl;

    /* JADX INFO: compiled from: line */
    public static class Builder implements BlinkIdOverlaySettingsOptions<Builder> {
        RecognizerBundle IlIllIlIIl;
        boolean IlIllIlllI;
        DebugImageListener IllIIIllII;
        int lIlIIIIlIl;
        CurrentImageListener llIIIlllll;
        int llIIlIIlll;
        OverlayCameraSettings llIIlIlIIl = new OverlayCameraSettings.Builder().build();
        boolean IllIIIIllI = false;
        boolean IIlIIIllIl = true;
        OcrResultDisplayMode lIIIIIllll = OcrResultDisplayMode.ANIMATED_DOTS;
        boolean lllIIIlIlI = true;
        boolean lllIlIlIIl = true;
        long IllIIlIIII = BlinkIdOverlaySettings.DEFAULT_TIMEOUT_MS;

        public Builder(RecognizerBundle recognizerBundle) {
            this.IlIllIlIIl = recognizerBundle;
        }

        public BlinkIdOverlaySettings build() {
            return new BlinkIdOverlaySettings(this.llIIlIIlll, this.llIIlIlIIl, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll, this.IllIIIIllI, this.lIlIIIIlIl, this.IIlIIIllIl, this.lIIIIIllll, this.lllIIIlIlI, this.IlIllIlllI, this.lllIlIlIIl, this.IllIIlIIII);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder isHighResSuccessFrameCaptureEnabled(boolean z) {
            this.IllIIIIllI = z;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setBackSideScanningTimeoutMs(long j) {
            this.IllIIlIIII = j;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setBeepResourceId(int i) {
            this.lIlIIIIlIl = i;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setCameraSettings(OverlayCameraSettings overlayCameraSettings) {
            this.llIIlIlIIl = overlayCameraSettings;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setCurrentImageListener(CurrentImageListener currentImageListener) {
            this.llIIIlllll = currentImageListener;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setDebugImageListener(DebugImageListener debugImageListener) {
            this.IllIIIllII = debugImageListener;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setDocumentDataMatchRequired(boolean z) {
            this.IIlIIIllIl = z;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setLockedToPortrait(boolean z) {
            this.IlIllIlllI = z;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setOcrResultDisplayMode(OcrResultDisplayMode ocrResultDisplayMode) {
            this.lIIIIIllll = ocrResultDisplayMode;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setShowMrzDots(boolean z) {
            this.lllIIIlIlI = z;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setShowNotSupportedDialog(boolean z) {
            this.lllIlIlIIl = z;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microblink.fragment.overlay.blinkid.settings.options.BlinkIdOverlaySettingsOptions
        public Builder setSplashResourceId(int i) {
            this.llIIlIIlll = i;
            return this;
        }
    }

    boolean IIlIIIllIl() {
        return this.IIlIIIllIl;
    }

    int IlIllIlIIl() {
        return this.lIlIIIIlIl;
    }

    boolean IlIllIlllI() {
        return this.lllIIIlIlI;
    }

    DebugImageListener IllIIIIllI() {
        return this.IllIIIllII;
    }

    OverlayCameraSettings IllIIIllII() {
        return this.llIIlIlIIl;
    }

    public RecognizerBundle getRecognizerBundle() {
        return this.IlIllIlIIl;
    }

    boolean lIIIIIllll() {
        return this.IllIIIIllI;
    }

    OcrResultDisplayMode lIlIIIIlIl() {
        return this.lIIIIIllll;
    }

    CurrentImageListener llIIIlllll() {
        return this.llIIIlllll;
    }

    int llIIlIIlll() {
        return this.llIIlIIlll;
    }

    long llIIlIlIIl() {
        return this.IllIIlIIII;
    }

    boolean lllIIIlIlI() {
        return this.IlIllIlllI;
    }

    boolean lllIlIlIIl() {
        return this.lllIlIlIIl;
    }

    private BlinkIdOverlaySettings(int i, OverlayCameraSettings overlayCameraSettings, RecognizerBundle recognizerBundle, DebugImageListener debugImageListener, CurrentImageListener currentImageListener, boolean z, int i2, boolean z2, OcrResultDisplayMode ocrResultDisplayMode, boolean z3, boolean z4, boolean z5, long j) {
        this.llIIlIlIIl = overlayCameraSettings;
        this.IlIllIlIIl = recognizerBundle;
        this.IllIIIllII = debugImageListener;
        this.llIIIlllll = currentImageListener;
        this.IllIIIIllI = z;
        this.lIlIIIIlIl = i2;
        this.llIIlIIlll = i;
        this.IIlIIIllIl = z2;
        this.lIIIIIllll = ocrResultDisplayMode;
        this.lllIIIlIlI = z3;
        this.IlIllIlllI = z4;
        this.lllIlIlIIl = z5;
        this.IllIIlIIII = j;
    }
}
