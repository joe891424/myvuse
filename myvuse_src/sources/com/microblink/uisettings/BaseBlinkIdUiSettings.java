package com.microblink.uisettings;

import android.app.Activity;
import android.content.Intent;
import com.microblink.blinkid.secured.llIIllllIl;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayController;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlaySettings;
import com.microblink.fragment.overlay.blinkid.BlinkIdOverlayView;
import com.microblink.image.CurrentImageListener;
import com.microblink.image.DebugImageListener;
import com.microblink.uisettings.options.BackSideScanningTimeoutUIOptions;
import com.microblink.uisettings.options.BeepSoundUIOptions;
import com.microblink.uisettings.options.CurrentImageListenerUIOptions;
import com.microblink.uisettings.options.DebugImageListenerUIOptions;
import com.microblink.uisettings.options.DocumentDataMatchUIOptions;
import com.microblink.uisettings.options.DocumentNotSupportedDialogUIOptions;
import com.microblink.uisettings.options.HighResSuccessFrameCaptureUIOptions;
import com.microblink.uisettings.options.MrzDetectionUIOptions;
import com.microblink.uisettings.options.OcrResultDisplayMode;
import com.microblink.uisettings.options.OcrResultDisplayUIOptions;
import com.microblink.uisettings.options.SplashScreenUIOptions;
import com.microblink.view.recognition.ScanResultListener;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseBlinkIdUiSettings extends UISettings<BlinkIdOverlayController> implements BeepSoundUIOptions, DebugImageListenerUIOptions, CurrentImageListenerUIOptions, HighResSuccessFrameCaptureUIOptions, SplashScreenUIOptions, OcrResultDisplayUIOptions, DocumentDataMatchUIOptions, MrzDetectionUIOptions, DocumentNotSupportedDialogUIOptions, BackSideScanningTimeoutUIOptions {
    private final RecognizerBundle lIlIIIIlIl;
    private static final long llIIlIIlll = BlinkIdOverlaySettings.DEFAULT_TIMEOUT_MS;
    private static final String IIlIIIllIl = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "beepResource");
    private static final String lIIIIIllll = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "debugImageListener");
    private static final String lllIIIlIlI = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "currentImageListener");
    private static final String IlIllIlllI = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "highResCapture");
    private static final String lllIlIlIIl = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "splashResource");
    private static final String IllIIlIIII = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "requireDocumentDataMatch");
    private static final String lIIIIIlIlI = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "showOcrResultMode");
    private static final String IlIlllllII = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "showMrzDetection");
    private static final String llIIlIIIll = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "showNotSupportedDialog");
    private static final String IlIIlllIIl = UISettings.llIIlIlIIl("BaseBlinkIdUISettings", "backSideScanningTimeoutMs");

    protected BaseBlinkIdUiSettings(RecognizerBundle recognizerBundle) {
        this.lIlIIIIlIl = recognizerBundle;
    }

    protected abstract BlinkIdOverlayView createOverlayView();

    @Override // com.microblink.uisettings.options.HighResSuccessFrameCaptureUIOptions
    public void enableHighResSuccessFrameCapture(boolean z) {
        llIIlIlIIl(IlIllIlllI, z);
    }

    protected abstract boolean isLockedToPortrait();

    @Override // com.microblink.uisettings.UISettings
    public void saveToIntent(Intent intent) {
        super.saveToIntent(intent);
        RecognizerBundle recognizerBundle = this.lIlIIIIlIl;
        if (recognizerBundle != null) {
            recognizerBundle.saveToIntent(intent);
        }
    }

    @Override // com.microblink.uisettings.options.BackSideScanningTimeoutUIOptions
    public void setBackSideScanningTimeoutMs(long j) {
        llIIlIlIIl(IlIIlllIIl, j);
    }

    @Override // com.microblink.uisettings.options.BeepSoundUIOptions
    public void setBeepSoundResourceID(int i) {
        llIIlIlIIl(IIlIIIllIl, i);
    }

    @Override // com.microblink.uisettings.options.CurrentImageListenerUIOptions
    public void setCurrentImageListener(CurrentImageListener currentImageListener) {
        llIIlIlIIl(lllIIIlIlI, currentImageListener);
    }

    @Override // com.microblink.uisettings.options.DebugImageListenerUIOptions
    public void setDebugImageListener(DebugImageListener debugImageListener) {
        llIIlIlIIl(lIIIIIllll, debugImageListener);
    }

    @Override // com.microblink.uisettings.options.DocumentDataMatchUIOptions
    public void setDocumentDataMatchRequired(boolean z) {
        llIIlIlIIl(IllIIlIIII, z);
    }

    @Override // com.microblink.uisettings.options.OcrResultDisplayUIOptions
    public void setOcrResultDisplayMode(OcrResultDisplayMode ocrResultDisplayMode) {
        llIIlIlIIl(lIIIIIlIlI, ocrResultDisplayMode);
    }

    @Override // com.microblink.uisettings.options.MrzDetectionUIOptions
    public void setShowMrzDetection(boolean z) {
        llIIlIlIIl(IlIlllllII, z);
    }

    @Override // com.microblink.uisettings.options.DocumentNotSupportedDialogUIOptions
    public void setShowNotSupportedDialog(boolean z) {
        llIIlIlIIl(llIIlIIIll, z);
    }

    @Override // com.microblink.uisettings.options.SplashScreenUIOptions
    public void setSplashScreenLayoutResourceID(int i) {
        llIIlIlIIl(lllIlIlIIl, i);
    }

    @Override // com.microblink.uisettings.UISettings
    public BlinkIdOverlayController createOverlayController(Activity activity, ScanResultListener scanResultListener) {
        return new BlinkIdOverlayController(new BlinkIdOverlaySettings.Builder(this.lIlIIIIlIl).setSplashResourceId(IlIllIlIIl(lllIlIlIIl, llIIllllIl.lIlIIIIlIl)).setBeepResourceId(IlIllIlIIl(IIlIIIllIl, 0)).setCameraSettings(llIIlIlIIl()).isHighResSuccessFrameCaptureEnabled(IlIllIlIIl(IlIllIlllI, false)).setDebugImageListener((DebugImageListener) llIIlIlIIl(lIIIIIllll)).setCurrentImageListener((CurrentImageListener) llIIlIlIIl(lllIIIlIlI)).setDocumentDataMatchRequired(IlIllIlIIl(IllIIlIIII, true)).setOcrResultDisplayMode((OcrResultDisplayMode) IlIllIlIIl(lIIIIIlIlI, OcrResultDisplayMode.ANIMATED_DOTS)).setShowMrzDots(IlIllIlIIl(IlIlllllII, true)).setLockedToPortrait(isLockedToPortrait()).setShowNotSupportedDialog(IlIllIlIIl(llIIlIIIll, true)).setBackSideScanningTimeoutMs(IlIllIlIIl(IlIIlllIIl, llIIlIIlll)).build(), scanResultListener, createOverlayView());
    }

    protected BaseBlinkIdUiSettings(Intent intent) {
        super(intent);
        RecognizerBundle recognizerBundle = new RecognizerBundle(new Recognizer[0]);
        this.lIlIIIIlIl = recognizerBundle;
        recognizerBundle.loadFromIntent(intent);
    }
}
