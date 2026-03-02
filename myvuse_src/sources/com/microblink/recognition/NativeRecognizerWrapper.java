package com.microblink.recognition;

import android.content.Context;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.IIllIllIII;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.blinkid.secured.IllIIlllIl;
import com.microblink.blinkid.secured.lIIlIIlIll;
import com.microblink.blinkid.secured.llllIIIIIl;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.hardware.MicroblinkDeviceManager;
import com.microblink.recognition.callback.RecognitionProcessCallback;
import com.microblink.settings.NativeLibraryInfo;
import com.microblink.util.FileLog;
import com.microblink.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public enum NativeRecognizerWrapper {
    INSTANCE;

    private lIIlIIlIll IllIIIIllI;
    private IlIllIlllI lIIIIIllll;
    private volatile NativeLibraryInfo llIIIlllll;
    private lIIIIIlIlI lllIIIlIlI;
    private AtomicReference<llllIIIIIl> llIIlIlIIl = new AtomicReference<>(llllIIIIIl.UNINITIALIZED);
    private volatile boolean IlIllIlIIl = false;
    private Timer IllIIIllII = null;
    private com.microblink.recognition.llIIlIlIIl lIlIIIIlIl = null;
    private RecognizerBundle llIIlIIlll = null;
    private AtomicBoolean IIlIIIllIl = new AtomicBoolean(false);
    private int IlIllIlllI = 0;
    private long lllIlIlIIl = 0;

    /* JADX INFO: compiled from: line */
    class IIlIIIllIl implements Runnable {
        final /* synthetic */ CountDownLatch llIIlIlIIl;

        IIlIIIllIl(CountDownLatch countDownLatch) {
            this.llIIlIlIIl = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeRecognizerWrapper.this.IllIIIIllI();
            this.llIIlIlIIl.countDown();
        }
    }

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Runnable {
        final /* synthetic */ lllIIIlIlI IlIllIlIIl;
        final /* synthetic */ RecognizerBundle llIIlIlIIl;

        IlIllIlIIl(RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili) {
            this.llIIlIlIIl = recognizerBundle;
            this.IlIllIlIIl = llliiilili;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, this.llIIlIlIIl, this.IlIllIlIIl);
        }
    }

    /* JADX INFO: compiled from: line */
    private class IlIllIlllI implements IllIIlIIII {
        private IIllIllIII llIIlIlIIl;

        private IlIllIlllI() {
        }

        public void llIIlIlIIl(IIllIllIII iIllIllIII) {
            this.llIIlIlIIl = iIllIllIII;
        }

        /* synthetic */ IlIllIlllI(NativeRecognizerWrapper nativeRecognizerWrapper, llIIlIlIIl lliililiil) {
            this();
        }

        @Override // com.microblink.recognition.NativeRecognizerWrapper.IllIIlIIII
        public int llIIlIlIIl(RecognitionProcessCallback recognitionProcessCallback) {
            Log.m2713v(this, IIllIllIIl.llIIlIlIIl("Recognizing frame ID ").append(this.llIIlIlIIl.lIlIIIIlIl()).toString(), new Object[0]);
            int iRecognize = NativeRecognizerWrapper.recognize(NativeRecognizerWrapper.this.lllIlIlIIl, this.llIIlIlIIl.IlIllIlIIl(), recognitionProcessCallback.getNativeContext(), recognitionProcessCallback.getCancelDelegate().llIIlIlIIl());
            Log.m2713v(this, IIllIllIIl.llIIlIlIIl("Finished recognizing frame ID ").append(this.llIIlIlIIl.lIlIIIIlIl()).toString(), new Object[0]);
            this.llIIlIlIIl.IllIIIllII();
            return iRecognize;
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIIllI implements Runnable {
        IllIIIIllI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NativeRecognizerWrapper.this.llIIlIlIIl.get() == llllIIIIIl.DONE) {
                NativeRecognizerWrapper.this.lIlIIIIlIl();
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements Runnable {
        final /* synthetic */ RecognizerBundle IlIllIlIIl;
        final /* synthetic */ RecognitionProcessCallback IllIIIIllI;
        final /* synthetic */ lllIIIlIlI IllIIIllII;
        final /* synthetic */ lllIlIlIIl lIlIIIIlIl;
        final /* synthetic */ IIllIllIII llIIIlllll;
        final /* synthetic */ boolean llIIlIlIIl;

        IllIIIllII(boolean z, RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili, IIllIllIII iIllIllIII, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil) {
            this.llIIlIlIIl = z;
            this.IlIllIlIIl = recognizerBundle;
            this.IllIIIllII = llliiilili;
            this.llIIIlllll = iIllIllIII;
            this.IllIIIIllI = recognitionProcessCallback;
            this.lIlIIIIlIl = lllililiil;
        }

        @Override // java.lang.Runnable
        public void run() {
            llllIIIIIl lllliiiiil = (llllIIIIIl) NativeRecognizerWrapper.this.llIIlIlIIl.get();
            if (lllliiiiil == llllIIIIIl.READY || lllliiiiil == llllIIIIIl.DISPATCH_READY || (this.llIIlIlIIl && lllliiiiil == llllIIIIIl.DONE)) {
                if (!this.IlIllIlIIl.equals(NativeRecognizerWrapper.this.llIIlIIlll)) {
                    NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, this.IlIllIlIIl, this.IllIIIllII);
                    NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.lllIlIlIIl, true);
                }
                NativeRecognizerWrapper.this.lIIIIIllll.llIIlIlIIl(this.llIIIlllll);
                NativeRecognizerWrapper nativeRecognizerWrapper = NativeRecognizerWrapper.this;
                NativeRecognizerWrapper.llIIlIlIIl(nativeRecognizerWrapper, nativeRecognizerWrapper.lIIIIIllll, this.IllIIIIllI, this.lIlIIIIlIl);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    private interface IllIIlIIII {
        int llIIlIlIIl(RecognitionProcessCallback recognitionProcessCallback);
    }

    /* JADX INFO: compiled from: line */
    private class lIIIIIlIlI implements IllIIlIIII {
        private String llIIlIlIIl;

        private lIIIIIlIlI() {
        }

        void llIIlIlIIl(String str) {
            this.llIIlIlIIl = str;
        }

        /* synthetic */ lIIIIIlIlI(NativeRecognizerWrapper nativeRecognizerWrapper, llIIlIlIIl lliililiil) {
            this();
        }

        @Override // com.microblink.recognition.NativeRecognizerWrapper.IllIIlIIII
        public int llIIlIlIIl(RecognitionProcessCallback recognitionProcessCallback) {
            Log.m2713v(this, IIllIllIIl.llIIlIlIIl("Recognizing from string ").append(this.llIIlIlIIl).toString(), new Object[0]);
            int iRecognizeString = NativeRecognizerWrapper.recognizeString(NativeRecognizerWrapper.this.lllIlIlIIl, this.llIIlIlIIl, recognitionProcessCallback.getNativeContext());
            Log.m2713v(this, IIllIllIIl.llIIlIlIIl("Finished recognizing from string ").append(this.llIIlIlIIl).toString(), new Object[0]);
            return iRecognizeString;
        }
    }

    /* JADX INFO: compiled from: line */
    class lIIIIIllll extends TimerTask {
        lIIIIIllll() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            NativeRecognizerWrapper.this.IlIllIlIIl = true;
            NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, (Timer) null);
        }
    }

    /* JADX INFO: compiled from: line */
    class lIlIIIIlIl implements Runnable {
        final /* synthetic */ boolean llIIlIlIIl;

        lIlIIIIlIl(boolean z) {
            this.llIIlIlIIl = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NativeRecognizerWrapper.this.IIlIIIllIl.get()) {
                return;
            }
            Log.m2707d(NativeRecognizerWrapper.class, "RESETTING RECOGNIZERS", new Object[0]);
            NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.lllIlIlIIl, this.llIIlIlIIl);
            NativeRecognizerWrapper.this.llIIlIlIIl();
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIIlllll implements Runnable {
        final /* synthetic */ lllIIIlIlI IlIllIlIIl;
        final /* synthetic */ lllIlIlIIl IllIIIIllI;
        final /* synthetic */ String IllIIIllII;
        final /* synthetic */ RecognitionProcessCallback llIIIlllll;
        final /* synthetic */ RecognizerBundle llIIlIlIIl;

        llIIIlllll(RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili, String str, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil) {
            this.llIIlIlIIl = recognizerBundle;
            this.IlIllIlIIl = llliiilili;
            this.IllIIIllII = str;
            this.llIIIlllll = recognitionProcessCallback;
            this.IllIIIIllI = lllililiil;
        }

        @Override // java.lang.Runnable
        public void run() {
            llllIIIIIl lllliiiiil = (llllIIIIIl) NativeRecognizerWrapper.this.llIIlIlIIl.get();
            if (lllliiiiil == llllIIIIIl.READY || lllliiiiil == llllIIIIIl.DISPATCH_READY || lllliiiiil == llllIIIIIl.DONE) {
                if (!this.llIIlIlIIl.equals(NativeRecognizerWrapper.this.llIIlIIlll)) {
                    NativeRecognizerWrapper.llIIlIlIIl(NativeRecognizerWrapper.this, this.llIIlIlIIl, this.IlIllIlIIl);
                    NativeRecognizerWrapper.resetRecognizers(NativeRecognizerWrapper.this.lllIlIlIIl, true);
                }
                NativeRecognizerWrapper.this.lllIIIlIlI.llIIlIlIIl(this.IllIIIllII);
                NativeRecognizerWrapper nativeRecognizerWrapper = NativeRecognizerWrapper.this;
                NativeRecognizerWrapper.llIIlIlIIl(nativeRecognizerWrapper, nativeRecognizerWrapper.lllIIIlIlI, this.llIIIlllll, this.IllIIIIllI);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIIlll implements Runnable {
        final /* synthetic */ CountDownLatch llIIlIlIIl;

        llIIlIIlll(NativeRecognizerWrapper nativeRecognizerWrapper, CountDownLatch countDownLatch) {
            this.llIIlIlIIl = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.llIIlIlIIl.countDown();
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        final /* synthetic */ lllIIIlIlI IlIllIlIIl;
        final /* synthetic */ RecognizerBundle IllIIIllII;
        final /* synthetic */ Context llIIlIlIIl;

        llIIlIlIIl(Context context, lllIIIlIlI llliiilili, RecognizerBundle recognizerBundle) {
            this.llIIlIlIIl = context;
            this.IlIllIlIIl = llliiilili;
            this.IllIIIllII = recognizerBundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                IllIIlllIl.llIIlIlIIl().llIIlIlIIl(this.llIIlIlIIl);
                NativeRecognizerWrapper nativeRecognizerWrapper = NativeRecognizerWrapper.this;
                Log.m2707d(nativeRecognizerWrapper, "Initializing library from state: {}", ((llllIIIIIl) nativeRecognizerWrapper.llIIlIlIIl.get()).name());
                if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(NativeRecognizerWrapper.this.llIIlIlIIl, llllIIIIIl.PRE_INIT, llllIIIIIl.INITIALIZING)) {
                    NativeRecognizerWrapper nativeRecognizerWrapper2 = NativeRecognizerWrapper.this;
                    Log.m2715w(nativeRecognizerWrapper2, "Library is already initialized (state: {})", ((llllIIIIIl) nativeRecognizerWrapper2.llIIlIlIIl.get()).name());
                    return;
                }
                Log.m2713v(NativeRecognizerWrapper.this, "Calling native init...", new Object[0]);
                Log.m2711i(this, "Native context ptr: {}", Long.valueOf(NativeRecognizerWrapper.this.lllIlIlIIl));
                NativeRecognizerWrapper.this.llIIIlllll = new NativeLibraryInfo(NativeRecognizerWrapper.initNativeRecognizers(NativeRecognizerWrapper.this.lllIlIlIIl, NativeRecognizerWrapper.llIIlIlIIl(this.IllIIIllII.getRecognizers()), this.IllIIIllII.shouldAllowMultipleScanResultsOnSingleImage(), FileLog.getLogFolder(this.llIIlIlIIl), "microblink"));
                NativeRecognizerWrapper.this.llIIlIIlll = this.IllIIIllII;
                if (NativeRecognizerWrapper.this.llIIIlllll.IlIllIlIIl()) {
                    Log.m2707d(NativeRecognizerWrapper.this, "Native library has initialized.", new Object[0]);
                    NativeRecognizerWrapper.this.lIlIIIIlIl();
                    return;
                }
                Log.m2709e(NativeRecognizerWrapper.this, "Failed to initialize native library!", new Object[0]);
                NativeRecognizerWrapper nativeRecognizerWrapper3 = NativeRecognizerWrapper.this;
                Log.m2709e(nativeRecognizerWrapper3, "Reason: {}", nativeRecognizerWrapper3.llIIIlllll.llIIlIlIIl());
                synchronized (NativeRecognizerWrapper.this) {
                    NativeRecognizerWrapper.this.IlIllIlllI = 0;
                }
                NativeRecognizerWrapper.this.IllIIIIllI();
                this.IlIllIlIIl.onRecognizerError(new RecognizerError(NativeRecognizerWrapper.this.llIIIlllll.llIIlIlIIl()));
            } catch (Exception e) {
                this.IlIllIlIIl.onRecognizerError(e);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    public interface lllIIIlIlI {
        void onRecognizerError(Throwable th);
    }

    /* JADX INFO: compiled from: line */
    public interface lllIlIlIIl {
        void onRecognitionDone(RecognitionSuccessType recognitionSuccessType);

        void onRecognitionDoneWithTimeout(RecognitionSuccessType recognitionSuccessType);
    }

    static {
        IIIlIllllI.IllIIIllII();
    }

    NativeRecognizerWrapper() {
        llIIlIlIIl lliililiil = null;
        this.IllIIIIllI = null;
        this.lIIIIIllll = new IlIllIlllI(this, lliililiil);
        this.lllIIIlIlI = new lIIIIIlIlI(this, lliililiil);
        lIIlIIlIll liiliilill = new lIIlIIlIll("Recognition");
        this.IllIIIIllI = liiliilill;
        liiliilill.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long initNativeRecognizers(long j, long[] jArr, boolean z, String str, String str2);

    private static native long nativeConstruct();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int recognize(long j, long j2, long j3, long j4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int recognizeString(long j, String str, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void resetRecognizers(long j, boolean z);

    private static native void terminateNativeRecognizers(long j);

    private static native String updateRecognizers(long j, long[] jArr, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public void IllIIIIllI() {
        Log.m2713v(this, "Terminating native library, state was: {}", this.llIIlIlIIl.get().name());
        this.llIIlIIlll = null;
        llllIIIIIl lllliiiiil = this.llIIlIlIIl.get();
        llllIIIIIl lllliiiiil2 = llllIIIIIl.UNINITIALIZED;
        if (lllliiiiil != lllliiiiil2) {
            Log.m2713v(this, "Calling native terminate...", new Object[0]);
            terminateNativeRecognizers(this.lllIlIlIIl);
            this.lllIlIlIIl = 0L;
            this.llIIlIlIIl.set(lllliiiiil2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lIlIIIIlIl() {
        com.microblink.recognition.llIIlIlIIl lliililiil = this.lIlIIIIlIl;
        if (lliililiil != null) {
            IIllIllIII iIllIllIIILlIIlIlIIl = lliililiil.llIIlIlIIl();
            if (iIllIllIIILlIIlIlIIl != null) {
                Log.m2707d(this, "Obtained already best frame ID {} from provider. Starting recognition...", Long.valueOf(iIllIllIIILlIIlIlIIl.lIlIIIIlIl()));
                this.llIIlIlIIl.set(llllIIIIIl.DISPATCH_READY);
                llIIlIlIIl(iIllIllIIILlIIlIlIIl, this.lIlIIIIlIl.IlIllIlIIl(), this.lIlIIIIlIl.IllIIIIllI(), this.lIlIIIIlIl.IllIIIllII(), this.lIlIIIIlIl.llIIIlllll(), false);
                return;
            }
            Log.m2707d(this, "Provider still does not have best frame available. Will wait for it to dispatch a frame", new Object[0]);
        }
        Log.m2707d(this, "Transitioned to state READY", new Object[0]);
        this.llIIlIlIIl.set(llllIIIIIl.READY);
    }

    public void IlIllIlIIl(boolean z) {
        this.IIlIIIllIl.set(z);
    }

    public void IllIIIllII() {
        lIIlIIlIll liiliilill = this.IllIIIIllI;
        if (liiliilill != null) {
            liiliilill.llIIlIlIIl(new IllIIIIllI());
        } else {
            Log.wtf(this, "Processing thread is null! Unable to prepare for next recognition!", new Object[0]);
        }
    }

    public void llIIIlllll() {
        int i = this.IlIllIlllI - 1;
        this.IlIllIlllI = i;
        if (i > 0) {
            Log.m2711i(this, "Still having {} instances running, will not terminate native recognizer", Integer.valueOf(i));
            return;
        }
        this.IIlIIIllIl.set(true);
        llIIlIlIIl();
        if (this.IllIIIIllI == null) {
            Log.m2715w(this, "Library is already terminated or is terminating. State: {}", this.llIIlIlIIl);
            return;
        }
        Log.m2713v(this, "Dispatching termination task. State was: {}", this.llIIlIlIIl);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.IllIIIIllI.llIIlIlIIl(new IIlIIIllIl(countDownLatch));
        Log.m2711i(this, "Waiting for native library to terminate...", new Object[0]);
        try {
            countDownLatch.await();
            Log.m2711i(this, "Native library has terminated.", new Object[0]);
        } catch (InterruptedException e) {
            Log.m2716w(this, e, "Interrupted while waiting for native library to terminate.", new Object[0]);
        }
    }

    public void llIIlIIlll() {
        if (this.IllIIIIllI == null) {
            Log.wtf(this, "Cannot wait for recognition, processing thread is null", new Object[0]);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.IllIIIIllI.llIIlIlIIl(new llIIlIIlll(this, countDownLatch));
        try {
            Log.m2711i(this, "Waiting for recognition...", new Object[0]);
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.m2716w(this, e, "Interrupted while waiting for recognition", new Object[0]);
        }
    }

    public llllIIIIIl IlIllIlIIl() {
        return this.llIIlIlIIl.get();
    }

    static /* synthetic */ Timer llIIlIlIIl(NativeRecognizerWrapper nativeRecognizerWrapper, Timer timer) {
        nativeRecognizerWrapper.IllIIIllII = null;
        return null;
    }

    public void llIIlIlIIl(com.microblink.recognition.llIIlIlIIl lliililiil) {
        this.lIlIIIIlIl = lliililiil;
    }

    public static long[] llIIlIlIIl(Recognizer[] recognizerArr) {
        long[] jArr = new long[recognizerArr.length];
        for (int i = 0; i < recognizerArr.length; i++) {
            Recognizer recognizer = recognizerArr[i];
            if (recognizer != null) {
                jArr[i] = recognizer.getNativeContext();
            } else {
                jArr[i] = 0;
            }
        }
        return jArr;
    }

    public void llIIlIlIIl(Context context, RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili) {
        int i = this.IlIllIlllI + 1;
        this.IlIllIlllI = i;
        Log.m2707d(this, "Active instances: {}", Integer.valueOf(i));
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m1161m(this.llIIlIlIIl, llllIIIIIl.UNINITIALIZED, llllIIIIIl.PRE_INIT)) {
            Log.m2715w(this, "Will not initialize native recognizer because it is already initialized, state is {}", this.llIIlIlIIl);
            lIIlIIlIll liiliilill = this.IllIIIIllI;
            if (liiliilill != null) {
                liiliilill.llIIlIlIIl(new IlIllIlIIl(recognizerBundle, llliiilili));
                return;
            }
            throw new IllegalStateException("Cannot reconfigure recognizers when they are not active. Please initialize first!");
        }
        IIIlIllllI.llIIlIlIIl();
        if (this.lllIlIlIIl == 0) {
            this.lllIlIlIIl = nativeConstruct();
        }
        if (MicroblinkDeviceManager.llIIlIlIIl(context) != null) {
            this.IIlIIIllIl.set(false);
            Log.m2707d(this, "Posting init task to RecognitionQueue...", new Object[0]);
            this.IllIIIIllI.llIIlIlIIl(new llIIlIlIIl(context, llliiilili, recognizerBundle));
            return;
        }
        throw new NullPointerException("Device manager was not initialised!");
    }

    static void llIIlIlIIl(NativeRecognizerWrapper nativeRecognizerWrapper, RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili) {
        llllIIIIIl lllliiiiil = nativeRecognizerWrapper.llIIlIlIIl.get();
        if (lllliiiiil == llllIIIIIl.UNINITIALIZED || lllliiiiil == llllIIIIIl.PRE_INIT || lllliiiiil == llllIIIIIl.INITIALIZING) {
            return;
        }
        String strUpdateRecognizers = updateRecognizers(nativeRecognizerWrapper.lllIlIlIIl, llIIlIlIIl(recognizerBundle.getRecognizers()), recognizerBundle.shouldAllowMultipleScanResultsOnSingleImage());
        nativeRecognizerWrapper.llIIlIIlll = recognizerBundle;
        if (strUpdateRecognizers != null) {
            Log.m2709e(nativeRecognizerWrapper, "Failed to reconfigure native recognizers!", new Object[0]);
            Log.m2709e(nativeRecognizerWrapper, "Reason: {}", strUpdateRecognizers);
            nativeRecognizerWrapper.IllIIIIllI();
            llliiilili.onRecognizerError(new RecognizerError(strUpdateRecognizers));
        }
    }

    public void llIIlIlIIl(RecognizerBundle recognizerBundle, lllIIIlIlI llliiilili) {
        lIIlIIlIll liiliilill = this.IllIIIIllI;
        if (liiliilill != null) {
            liiliilill.llIIlIlIIl(new IlIllIlIIl(recognizerBundle, llliiilili));
            return;
        }
        throw new IllegalStateException("Cannot reconfigure recognizers when they are not active. Please initialize first!");
    }

    static void llIIlIlIIl(NativeRecognizerWrapper nativeRecognizerWrapper, IllIIlIIII illIIlIIII, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil) {
        if (nativeRecognizerWrapper.lllIlIlIIl == 0) {
            Log.m2715w(nativeRecognizerWrapper, "Reconfiguration or initialisation has failed. Cannot recognise input data!", new Object[0]);
            return;
        }
        nativeRecognizerWrapper.llIIlIlIIl.set(llllIIIIIl.WORKING);
        recognitionProcessCallback.setNativeRecognizerWrapper(nativeRecognizerWrapper);
        int iLlIIlIlIIl = illIIlIIII.llIIlIlIIl(recognitionProcessCallback);
        recognitionProcessCallback.setNativeRecognizerWrapper(null);
        nativeRecognizerWrapper.llIIlIlIIl.set(llllIIIIIl.DONE);
        if (lllililiil != null) {
            RecognitionSuccessType recognitionSuccessTypeFromNativeRecognitionState = RecognitionSuccessType.fromNativeRecognitionState(iLlIIlIlIIl);
            if (nativeRecognizerWrapper.IlIllIlIIl) {
                lllililiil.onRecognitionDoneWithTimeout(recognitionSuccessTypeFromNativeRecognitionState);
                return;
            } else {
                lllililiil.onRecognitionDone(recognitionSuccessTypeFromNativeRecognitionState);
                return;
            }
        }
        nativeRecognizerWrapper.lIlIIIIlIl();
    }

    public void llIIlIlIIl(IIllIllIII iIllIllIII, RecognizerBundle recognizerBundle, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil, lllIIIlIlI llliiilili, boolean z) {
        lIIlIIlIll liiliilill = this.IllIIIIllI;
        if (liiliilill != null) {
            liiliilill.llIIlIlIIl(new IllIIIllII(z, recognizerBundle, llliiilili, iIllIllIII, recognitionProcessCallback, lllililiil));
        } else {
            Log.wtf(this, "Processing thread is null! Unable to perform recognition!", new Object[0]);
        }
    }

    public void llIIlIlIIl(String str, RecognizerBundle recognizerBundle, RecognitionProcessCallback recognitionProcessCallback, lllIlIlIIl lllililiil, lllIIIlIlI llliiilili) {
        lIIlIIlIll liiliilill = this.IllIIIIllI;
        if (liiliilill != null) {
            liiliilill.llIIlIlIIl(new llIIIlllll(recognizerBundle, llliiilili, str, recognitionProcessCallback, lllililiil));
        } else {
            Log.wtf(this, "Processing thread is null! Unable to perform recognition!", new Object[0]);
        }
    }

    public void llIIlIlIIl(boolean z) {
        lIIlIIlIll liiliilill = this.IllIIIIllI;
        if (liiliilill != null) {
            liiliilill.llIIlIlIIl(new lIlIIIIlIl(z));
        } else {
            Log.wtf(this, "Unable to reset recognizers: processing thread is null", new Object[0]);
        }
    }

    public void llIIlIlIIl() {
        Timer timer = this.IllIIIllII;
        if (timer != null) {
            timer.cancel();
        }
        this.IlIllIlIIl = false;
        this.IllIIIllII = null;
    }

    public void llIIlIlIIl(int i) {
        if (i == 0) {
            llIIlIlIIl();
        } else if (this.IllIIIllII == null) {
            Log.m2707d(this, "Scheduling timeout after {} miliseconds", Integer.valueOf(i));
            this.IllIIIllII = new Timer();
            this.IlIllIlIIl = false;
            this.IllIIIllII.schedule(new lIIIIIllll(), i);
        }
    }
}
