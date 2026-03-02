package com.microblink.blinkid.secured;

import android.media.Image;
import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import com.microblink.blinkid.secured.IIlIIIllIl;
import com.microblink.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlllllIIll {
    private IIIIIlIIII IlIllIlIIl;
    private lIllIIlIIl IllIIIllII;
    private IllIIIllII llIIIlllll;
    private ImageReader llIIlIlIIl;
    private AtomicInteger IllIIIIllI = new AtomicInteger(0);
    private AtomicBoolean lIlIIIIlIl = new AtomicBoolean(false);
    private long llIIlIIlll = 0;
    private ImageReader.OnImageAvailableListener IIlIIIllIl = new llIIlIlIIl();
    private IIlIIIllIl.llIIlIlIIl lIIIIIllll = new IlIllIlIIl();

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements IIlIIIllIl.llIIlIlIIl {
        IlIllIlIIl() {
        }

        @Override // com.microblink.blinkid.secured.IIlIIIllIl.llIIlIlIIl
        public void llIIlIlIIl(Image image) {
            image.close();
            int iDecrementAndGet = IlllllIIll.this.IllIIIIllI.decrementAndGet();
            Log.m2713v(this, "[close] Active images: {}", Integer.valueOf(iDecrementAndGet));
            if (iDecrementAndGet != 0 || !IlllllIIll.this.lIlIIIIlIl.get()) {
                IlllllIIll.this.llIIIlllll.IllIIIllII();
            } else {
                Log.m2711i(this, "Closing image reader", new Object[0]);
                IlllllIIll.this.llIIlIlIIl();
            }
        }
    }

    /* JADX INFO: compiled from: line */
    interface IllIIIllII {
        boolean IlIllIlIIl();

        void IllIIIllII();

        boolean canReceiveFrame();

        void llIIlIlIIl(IIllIllIII iIllIllIII);

        boolean llIIlIlIIl();
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements ImageReader.OnImageAvailableListener {

        /* JADX INFO: renamed from: com.microblink.blinkid.secured.IlllllIIll$llIIlIlIIl$llIIlIlIIl, reason: collision with other inner class name */
        /* JADX INFO: compiled from: line */
        class RunnableC5987llIIlIlIIl implements Runnable {
            final /* synthetic */ IIlIIIllIl llIIlIlIIl;

            RunnableC5987llIIlIlIIl(IIlIIIllIl iIlIIIllIl) {
                this.llIIlIlIIl = iIlIIIllIl;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (IlllllIIll.this.llIIIlllll.canReceiveFrame()) {
                    IlllllIIll.this.llIIIlllll.llIIlIlIIl(this.llIIlIlIIl);
                } else {
                    this.llIIlIlIIl.IllIIIllII();
                }
            }
        }

        llIIlIlIIl() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image imageAcquireNextImage;
            try {
                imageAcquireNextImage = imageReader.acquireNextImage();
                if (imageAcquireNextImage == null) {
                    return;
                }
                try {
                    Log.m2713v(this, "[acquire] Active images: {}", Integer.valueOf(IlllllIIll.this.IllIIIIllI.incrementAndGet()));
                    if (!IlllllIIll.this.llIIIlllll.canReceiveFrame()) {
                        ((IlIllIlIIl) IlllllIIll.this.lIIIIIllll).llIIlIlIIl(imageAcquireNextImage);
                        return;
                    }
                    IIlIIIllIl iIlIIIllIlLlIIlIlIIl = IlllllIIll.this.IllIIIllII.llIIlIlIIl();
                    iIlIIIllIlLlIIlIlIIl.llIIlIlIIl(imageAcquireNextImage, IlllllIIll.this.lIIIIIllll);
                    iIlIIIllIlLlIIlIlIIl.IlIllIlIIl(IlllllIIll.this.llIIIlllll.llIIlIlIIl());
                    iIlIIIllIlLlIIlIlIIl.llIIlIlIIl(IlllllIIll.this.llIIIlllll.IlIllIlIIl());
                    iIlIIIllIlLlIIlIlIIl.llIIIlllll(IlllllIIll.IllIIIIllI(IlllllIIll.this));
                    IlllllIIll.this.IlIllIlIIl.llIIlIlIIl(new RunnableC5987llIIlIlIIl(iIlIIIllIlLlIIlIlIIl));
                } catch (Exception e) {
                    e = e;
                    Log.m2710e(this, e, "Failed to acquire latest image!", new Object[0]);
                    if (imageAcquireNextImage != null) {
                        ((IlIllIlIIl) IlllllIIll.this.lIIIIIllll).llIIlIlIIl(imageAcquireNextImage);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                imageAcquireNextImage = null;
            }
        }
    }

    IlllllIIll(IIIIIlIIII iIIIIlIIII, IllIIIllII illIIIllII) {
        this.llIIIlllll = illIIIllII;
        this.IlIllIlIIl = iIIIIlIIII;
    }

    static /* synthetic */ long IllIIIIllI(IlllllIIll illlllIIll) {
        long j = illlllIIll.llIIlIIlll;
        illlllIIll.llIIlIIlll = 1 + j;
        return j;
    }

    void IlIllIlIIl(IIlIlIIlll iIlIlIIlll, int i, lIIIlIIllI liiiliilli) {
        llIIlIlIIl(iIlIlIIlll.IllIIIllII(), 35, i, liiiliilli);
    }

    void IllIIIllII() {
        this.lIlIIIIlIl.set(true);
        if (this.IllIIIIllI.get() == 0) {
            llIIlIlIIl();
        }
    }

    void llIIIlllll() {
        this.lIlIIIIlIl = new AtomicBoolean(false);
    }

    void llIIlIlIIl(IIlIlIIlll iIlIlIIlll, int i, lIIIlIIllI liiiliilli) {
        llIIlIlIIl(iIlIlIIlll.IlIllIlIIl(), iIlIlIIlll.llIIlIlIIl(), i, liiiliilli);
    }

    Surface IlIllIlIIl() {
        ImageReader imageReader = this.llIIlIlIIl;
        if (imageReader == null) {
            return null;
        }
        return imageReader.getSurface();
    }

    private void llIIlIlIIl(Size size, int i, int i2, lIIIlIIllI liiiliilli) {
        ImageReader imageReaderNewInstance = ImageReader.newInstance(size.getWidth(), size.getHeight(), i, i2);
        this.llIIlIlIIl = imageReaderNewInstance;
        imageReaderNewInstance.setOnImageAvailableListener(this.IIlIIIllIl, this.IlIllIlIIl.llIIlIlIIl());
        this.IllIIIllII = new lIllIIlIIl(i2, liiiliilli);
    }

    void llIIlIlIIl() {
        ImageReader imageReader = this.llIIlIlIIl;
        if (imageReader != null) {
            imageReader.close();
            this.llIIlIlIIl = null;
        }
    }
}
