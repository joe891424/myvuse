package com.microblink.blinkid.secured;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.microblink.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIIlIIlIll extends Thread implements IIIIIlIIII {
    private Looper IlIllIlIIl;
    private String llIIIlllll;
    private Handler llIIlIlIIl;
    private AtomicBoolean IllIIIllII = new AtomicBoolean(false);
    private AtomicBoolean IllIIIIllI = new AtomicBoolean(false);
    private CountDownLatch lIlIIIIlIl = new CountDownLatch(1);
    private CountDownLatch llIIlIIlll = new CountDownLatch(1);

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Runnable {
        IlIllIlIIl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            lIIlIIlIll.this.IlIllIlIIl.quitSafely();
        }
    }

    /* JADX INFO: compiled from: line */
    private static class IllIIIllII extends Handler {
        public IllIIIllII(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Throwable th) {
                Throwable cause = th;
                while (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) message.obj;
                StackTraceElement[] stackTrace = cause.getStackTrace();
                ArrayList arrayList = new ArrayList(stackTrace.length + stackTraceElementArr.length);
                Collections.addAll(arrayList, stackTrace);
                arrayList.add(new StackTraceElement("********************* Posted to handler", "at: ", null, -2));
                for (int i = 5; i < stackTraceElementArr.length; i++) {
                    arrayList.add(stackTraceElementArr[i]);
                }
                StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[arrayList.size()];
                arrayList.toArray(stackTraceElementArr2);
                cause.setStackTrace(stackTraceElementArr2);
                throw th;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            message.obj = Thread.currentThread().getStackTrace();
            return super.sendMessageAtTime(message, j);
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        final /* synthetic */ Throwable llIIlIlIIl;

        llIIlIlIIl(Throwable th) {
            this.llIIlIlIIl = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new RuntimeException(IIllIllIIl.llIIlIlIIl("Processing queue ").append(lIIlIIlIll.this.llIIIlllll).append(" halted due to an error. ").append(this.llIIlIlIIl.getMessage()).toString(), this.llIIlIlIIl);
        }
    }

    public lIIlIIlIll(String str) {
        this.llIIIlllll = "";
        this.llIIIlllll = str;
        setName(this.llIIIlllll);
    }

    private void IllIIIllII() {
        try {
            this.lIlIIIIlIl.await();
        } catch (InterruptedException e) {
            Log.m2710e(this, e, "Interrupted while waiting for processing queue {} to start", this.llIIIlllll);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Looper.prepare();
            Log.m2713v(this, "Booting processing queue {}", this.llIIIlllll);
            this.IlIllIlIIl = Looper.myLooper();
            this.llIIlIlIIl = new IllIIIllII(this.IlIllIlIIl);
            this.lIlIIIIlIl.countDown();
            Looper.loop();
            this.IllIIIllII.set(true);
            this.llIIlIIlll.countDown();
            Log.m2707d(this, "Processing queue {} terminated gracefully", this.llIIIlllll);
        } catch (Throwable th) {
            new Handler(Looper.getMainLooper()).post(new llIIlIlIIl(th));
        }
    }

    public void IlIllIlIIl() {
        if (this.IllIIIIllI.getAndSet(true)) {
            return;
        }
        this.llIIlIlIIl.post(new IlIllIlIIl());
        this.llIIlIlIIl = null;
    }

    @Override // com.microblink.blinkid.secured.IIIIIlIIII
    public void llIIlIlIIl(Runnable runnable) {
        IllIIIllII();
        if (this.IllIIIIllI.get()) {
            Log.m2715w(this, "Processing queue {} is exiting, unable to post job to it", this.llIIIlllll);
        } else {
            this.llIIlIlIIl.post(runnable);
        }
    }

    @Override // com.microblink.blinkid.secured.IIIIIlIIII
    public void llIIlIlIIl(Runnable runnable, long j) {
        IllIIIllII();
        if (!this.IllIIIIllI.get()) {
            this.llIIlIlIIl.postDelayed(runnable, j);
        } else {
            Log.m2715w(this, "Processing queue {} is exiting, unable to post job to it", this.llIIIlllll);
        }
    }

    @Override // com.microblink.blinkid.secured.IIIIIlIIII
    public Handler llIIlIlIIl() {
        IllIIIllII();
        return this.llIIlIlIIl;
    }
}
