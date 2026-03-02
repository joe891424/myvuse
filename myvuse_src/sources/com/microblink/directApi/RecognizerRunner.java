package com.microblink.directApi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.Toast;
import com.microblink.blinkid.secured.IlIlIlllIl;
import com.microblink.blinkid.secured.IlIllllllI;
import com.microblink.blinkid.secured.lIIlIIIIlI;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.geometry.Rectangle;
import com.microblink.hardware.MicroblinkDeviceManager;
import com.microblink.hardware.camera.memory.BitmapCameraFrame;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.image.ImageFrame;
import com.microblink.licence.exception.InvalidLicenceKeyException;
import com.microblink.metadata.MetadataCallbacks;
import com.microblink.recognition.FrameAnalyzers;
import com.microblink.recognition.NativeRecognizerWrapper;
import com.microblink.recognition.RecognitionSuccessType;
import com.microblink.recognition.Right;
import com.microblink.recognition.RightsManager;
import com.microblink.recognition.callback.RecognitionProcessCallback;
import com.microblink.settings.NativeLibraryInfo;
import com.microblink.util.Log;
import com.microblink.view.recognition.ScanResultListener;
import com.newrelic.agent.android.util.Constants;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class RecognizerRunner {
    private static RecognizerRunner IllIIlIIII = new RecognizerRunner();
    private NativeRecognizerWrapper llIIlIlIIl = null;
    private ScanResultListener IlIllIlIIl = null;
    private DirectApiErrorListener IllIIIllII = null;
    private RecognizerBundle llIIIlllll = null;
    private FrameAnalyzers IllIIIIllI = null;
    private MicroblinkDeviceManager lIlIIIIlIl = null;
    private MetadataCallbacks llIIlIIlll = new MetadataCallbacks();
    private long IIlIIIllIl = Constants.Network.MAX_PAYLOAD_SIZE;
    private Context lIIIIIllll = null;
    private RecognitionLicenseAndErrorCallback lllIIIlIlI = new RecognitionLicenseAndErrorCallback();
    private RecognitionProcessCallback IlIllIlllI = new RecognitionProcessCallback(this.lllIIIlIlI, this.llIIlIIlll, Rectangle.getDefaultROI(), RecognizerBundle.RecognitionDebugMode.RECOGNITION);
    private State lllIlIlIIl = State.OFFLINE;

    /* JADX INFO: compiled from: line */
    private class RecognitionLicenseAndErrorCallback implements NativeRecognizerWrapper.lllIIIlIlI, NativeRecognizerWrapper.lllIlIlIIl, IlIlIlllIl {
        private RecognitionLicenseAndErrorCallback() {
        }

        @Override // com.microblink.blinkid.secured.IlIlIlllIl
        public void onLicenseInformation(String str) {
            if (RecognizerRunner.this.lIIIIIllll != null) {
                Toast.makeText(RecognizerRunner.this.lIIIIIllll, str, 1).show();
            }
        }

        @Override // com.microblink.recognition.NativeRecognizerWrapper.lllIlIlIIl
        public void onRecognitionDone(RecognitionSuccessType recognitionSuccessType) {
            RecognizerRunner.llIIlIlIIl(RecognizerRunner.this, recognitionSuccessType);
        }

        @Override // com.microblink.recognition.NativeRecognizerWrapper.lllIlIlIIl
        public void onRecognitionDoneWithTimeout(RecognitionSuccessType recognitionSuccessType) {
            RecognizerRunner.llIIlIlIIl(RecognizerRunner.this, recognitionSuccessType);
        }

        @Override // com.microblink.recognition.NativeRecognizerWrapper.lllIIIlIlI
        public void onRecognizerError(Throwable th) {
            RecognizerRunner.this.IllIIIllII.onRecognizerError(th);
            synchronized (RecognizerRunner.this) {
                if (RecognizerRunner.this.lllIlIlIIl == State.WORKING) {
                    RecognizerRunner.this.lllIlIlIIl = State.READY;
                }
            }
        }
    }

    /* JADX INFO: compiled from: line */
    public enum State {
        OFFLINE,
        READY,
        WORKING
    }

    private RecognizerRunner() {
    }

    public static RecognizerRunner getSingletonInstance() {
        return IllIIlIIII;
    }

    public synchronized void cancel() {
        if (this.lllIlIlIIl == State.WORKING) {
            this.IlIllIlllI.getCancelDelegate().llIIlIlIIl(true);
            this.llIIlIlIIl.llIIlIIlll();
            this.lllIlIlIIl = State.READY;
        }
    }

    public final synchronized State getCurrentState() {
        return this.lllIlIlIIl;
    }

    public final synchronized void initialize(Context context, RecognizerBundle recognizerBundle, DirectApiErrorListener directApiErrorListener) {
        if (this.lllIlIlIIl != State.OFFLINE) {
            throw new IllegalStateException("Cannot initialize already initialized recognizer!");
        }
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        if (directApiErrorListener == null) {
            throw new NullPointerException("Error listener cannot be null!");
        }
        if (recognizerBundle == null) {
            recognizerBundle = new RecognizerBundle(new Recognizer[0]);
        }
        llIIlIlIIl(recognizerBundle);
        if (NativeLibraryInfo.isProtectionEnabled() && !RightsManager.llIIlIlIIl(Right.ALLOW_CUSTOM_UI)) {
            Log.m2709e(this, "Direct API requires license key that allows creation of custom UI!", new Object[0]);
            throw new InvalidLicenceKeyException("Direct API requires license key that allows creation of custom UI!");
        }
        this.llIIIlllll = recognizerBundle;
        this.IllIIIllII = directApiErrorListener;
        this.llIIlIlIIl = NativeRecognizerWrapper.INSTANCE;
        this.lIIIIIllll = context;
        this.lIlIIIIlIl = MicroblinkDeviceManager.llIIlIlIIl(context);
        this.IllIIIIllI = new FrameAnalyzers(this.llIIIlllll, this.lIlIIIIlIl.IlIllIlIIl());
        if (NativeLibraryInfo.isProtectionEnabled() && !RightsManager.llIIlIlIIl(Right.ALLOW_REMOVE_DEMO_OVERLAY)) {
            Toast.makeText(this.lIIIIIllll, "Powered by Microblink SDK", 1).show();
        }
        this.llIIlIlIIl.llIIlIlIIl(context, recognizerBundle, this.lllIIIlIlI);
        this.lllIlIlIIl = State.READY;
    }

    public final void recognizeBitmap(Bitmap bitmap, Orientation orientation, ScanResultListener scanResultListener) {
        recognizeBitmapWithRecognizers(bitmap, orientation, new Rectangle(0.0f, 0.0f, 1.0f, 1.0f), scanResultListener, this.llIIIlllll);
    }

    public final void recognizeBitmapWithRecognizers(Bitmap bitmap, Orientation orientation, ScanResultListener scanResultListener, RecognizerBundle recognizerBundle) {
        recognizeBitmapWithRecognizers(bitmap, orientation, new Rectangle(0.0f, 0.0f, 1.0f, 1.0f), scanResultListener, recognizerBundle);
    }

    public final void recognizeImage(Image image, boolean z, ScanResultListener scanResultListener) {
        recognizeImageWithRecognizers(image, z, scanResultListener, this.llIIIlllll);
    }

    public final void recognizeImageWithRecognizers(Image image, boolean z, ScanResultListener scanResultListener, RecognizerBundle recognizerBundle) {
        if (this.lllIlIlIIl != State.READY) {
            throw new IllegalStateException("Cannot recognize image. RecognizerRunner not ready!");
        }
        if (scanResultListener == null) {
            throw new NullPointerException("Result listener cannot be null!");
        }
        if (recognizerBundle != this.llIIIlllll) {
            if (recognizerBundle == null) {
                recognizerBundle = new RecognizerBundle(new Recognizer[0]);
            }
            llIIlIlIIl(recognizerBundle);
        }
        RecognizerBundle recognizerBundle2 = recognizerBundle;
        this.IlIllIlIIl = scanResultListener;
        this.IlIllIlllI.getCancelDelegate().llIIlIlIIl(false);
        this.llIIlIlIIl.IlIllIlIIl(false);
        Rect rawROI = image.getRawROI();
        this.IlIllIlllI.setScanningRegion(new Rectangle(rawROI.left / image.getRawWidth(), rawROI.top / image.getRawHeight(), rawROI.width() / image.getRawWidth(), rawROI.height() / image.getRawHeight()));
        this.IllIIIIllI.llIIlIlIIl(this.llIIIlllll);
        NativeRecognizerWrapper nativeRecognizerWrapper = this.llIIlIlIIl;
        if (image.isDisposed()) {
            throw new IllegalStateException("Cannot recognize disposed image!");
        }
        long j = this.IIlIIIllIl;
        this.IIlIIIllIl = 1 + j;
        ImageFrame imageFrame = new ImageFrame(image, z, j);
        if (!imageFrame.llIIlIlIIl(this.IllIIIIllI.IlIllIlIIl())) {
            imageFrame.IllIIIllII();
            throw new RuntimeException("Failed to process given image. See ADB log for more info.");
        }
        RecognitionProcessCallback recognitionProcessCallback = this.IlIllIlllI;
        RecognitionLicenseAndErrorCallback recognitionLicenseAndErrorCallback = this.lllIIIlIlI;
        nativeRecognizerWrapper.llIIlIlIIl(imageFrame, recognizerBundle2, recognitionProcessCallback, recognitionLicenseAndErrorCallback, recognitionLicenseAndErrorCallback, true);
        this.lllIlIlIIl = State.WORKING;
    }

    public final void recognizeString(String str, ScanResultListener scanResultListener) {
        recognizeStringWithRecognizers(str, scanResultListener, this.llIIIlllll);
    }

    public final void recognizeStringWithRecognizers(String str, ScanResultListener scanResultListener, RecognizerBundle recognizerBundle) {
        if (this.lllIlIlIIl != State.READY) {
            throw new IllegalStateException("Cannot recognize string. RecognizerRunner not ready!");
        }
        if (scanResultListener == null) {
            throw new NullPointerException("Result listener cannot be null!");
        }
        if (recognizerBundle != this.llIIIlllll) {
            if (recognizerBundle == null) {
                recognizerBundle = new RecognizerBundle(new Recognizer[0]);
            }
            llIIlIlIIl(recognizerBundle);
        }
        this.IlIllIlIIl = scanResultListener;
        this.IlIllIlllI.getCancelDelegate().llIIlIlIIl(false);
        this.llIIlIlIIl.IlIllIlIIl(false);
        NativeRecognizerWrapper nativeRecognizerWrapper = this.llIIlIlIIl;
        RecognitionProcessCallback recognitionProcessCallback = this.IlIllIlllI;
        RecognitionLicenseAndErrorCallback recognitionLicenseAndErrorCallback = this.lllIIIlIlI;
        nativeRecognizerWrapper.llIIlIlIIl(str, recognizerBundle, recognitionProcessCallback, recognitionLicenseAndErrorCallback, recognitionLicenseAndErrorCallback);
        this.lllIlIlIIl = State.WORKING;
    }

    public final void resetRecognitionState() {
        resetRecognitionState(true);
    }

    public void setMetadataCallbacks(MetadataCallbacks metadataCallbacks) {
        if (metadataCallbacks == null) {
            metadataCallbacks = new MetadataCallbacks();
        }
        this.llIIlIIlll = metadataCallbacks;
        this.IlIllIlllI.setMetadataCallbacks(metadataCallbacks);
    }

    public synchronized void terminate() {
        State state = this.lllIlIlIIl;
        State state2 = State.OFFLINE;
        if (state != state2) {
            this.IlIllIlllI.getCancelDelegate().llIIlIlIIl(true);
            this.llIIlIlIIl.llIIIlllll();
            this.lllIlIlIIl = state2;
            this.llIIlIlIIl = null;
            this.llIIIlllll = null;
            this.IlIllIlIIl = null;
            this.IllIIIllII = null;
            this.llIIlIIlll = new MetadataCallbacks();
            this.IllIIIIllI.llIIlIlIIl();
            this.IllIIIIllI = null;
            this.lIIIIIllll = null;
            this.IlIllIlllI.setMetadataCallbacks(this.llIIlIIlll);
        }
    }

    public final void recognizeBitmap(Bitmap bitmap, Orientation orientation, Rectangle rectangle, ScanResultListener scanResultListener) {
        recognizeBitmapWithRecognizers(bitmap, orientation, rectangle, scanResultListener, this.llIIIlllll);
    }

    public final synchronized void recognizeBitmapWithRecognizers(Bitmap bitmap, Orientation orientation, Rectangle rectangle, ScanResultListener scanResultListener, RecognizerBundle recognizerBundle) {
        if (this.lllIlIlIIl != State.READY) {
            throw new IllegalStateException("Cannot recognize image. RecognizerRunner not ready!");
        }
        if (scanResultListener == null) {
            throw new NullPointerException("Result listener cannot be null!");
        }
        if (rectangle == null) {
            throw new NullPointerException("Scan region cannot be null!");
        }
        if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
            throw new IllegalArgumentException("Bitmap orientation cannot be null nor unknown!");
        }
        if (!rectangle.isRelative()) {
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f");
        }
        if (recognizerBundle != this.llIIIlllll) {
            if (recognizerBundle == null) {
                recognizerBundle = new RecognizerBundle(new Recognizer[0]);
            }
            llIIlIlIIl(recognizerBundle);
        }
        RecognizerBundle recognizerBundle2 = recognizerBundle;
        this.IlIllIlIIl = scanResultListener;
        this.IlIllIlllI.getCancelDelegate().llIIlIlIIl(false);
        this.llIIlIlIIl.IlIllIlIIl(false);
        this.IlIllIlllI.setScanningRegion(rectangle);
        this.IllIIIIllI.llIIlIlIIl(this.llIIIlllll);
        NativeRecognizerWrapper nativeRecognizerWrapper = this.llIIlIlIIl;
        long j = this.IIlIIIllIl;
        this.IIlIIIllIl = 1 + j;
        BitmapCameraFrame bitmapCameraFrame = new BitmapCameraFrame(bitmap, j);
        bitmapCameraFrame.llIIlIlIIl(rectangle.toRectF());
        bitmapCameraFrame.llIIlIlIIl(orientation);
        if (!bitmapCameraFrame.llIIlIlIIl(this.IllIIIIllI.IlIllIlIIl())) {
            bitmapCameraFrame.IllIIIllII();
            throw new RuntimeException("Failed to process given bitmap. See ADB log for more info.");
        }
        RecognitionProcessCallback recognitionProcessCallback = this.IlIllIlllI;
        RecognitionLicenseAndErrorCallback recognitionLicenseAndErrorCallback = this.lllIIIlIlI;
        nativeRecognizerWrapper.llIIlIlIIl(bitmapCameraFrame, recognizerBundle2, recognitionProcessCallback, recognitionLicenseAndErrorCallback, recognitionLicenseAndErrorCallback, true);
        this.lllIlIlIIl = State.WORKING;
    }

    public final void resetRecognitionState(boolean z) {
        if (this.llIIlIlIIl != null) {
            Log.m2707d(this, "Resetting recognizer state!", new Object[0]);
            this.llIIlIlIIl.llIIlIlIIl(z);
        }
    }

    private void llIIlIlIIl(RecognizerBundle recognizerBundle) {
        Recognizer<Recognizer.Result>[] recognizers = recognizerBundle.getRecognizers();
        if (recognizers == null || recognizers.length == 0) {
            throw new NullPointerException("RecognizerRunner recognizer array inside RecognizerBundle cannot be null nor empty!");
        }
    }

    static void llIIlIlIIl(RecognizerRunner recognizerRunner, RecognitionSuccessType recognitionSuccessType) {
        if (!recognizerRunner.IlIllIlllI.getCancelDelegate().IlIllIlIIl()) {
            synchronized (recognizerRunner) {
                if (recognizerRunner.llIIlIlIIl != null) {
                    recognizerRunner.lllIlIlIIl = State.READY;
                }
            }
        }
        IlIllllllI.llIIlIlIIl().llIIlIlIIl(recognizerRunner.llIIIlllll, lIIlIIIIlI.DIRECT_API);
        recognizerRunner.IlIllIlIIl.onScanningDone(recognitionSuccessType);
        recognizerRunner.llIIlIlIIl.IllIIIllII();
    }
}
