package com.microblink.blinkid.secured;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlllIIIllI implements IIllIlIIII {
    private llIIIlllll IlIllIlIIl;
    private lIllllIlll lIlIIIIlIl;
    private IIIIIlIIII llIIlIlIIl;
    private SurfaceHolder IllIIIllII = null;
    private boolean llIIIlllll = false;
    private SurfaceTexture IllIIIIllI = null;
    private SurfaceHolder.Callback llIIlIIlll = new IlIllIlIIl();
    private TextureView.SurfaceTextureListener IIlIIIllIl = new IllIIIllII();

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements SurfaceHolder.Callback {

        /* JADX INFO: compiled from: line */
        class llIIlIlIIl implements Runnable {
            llIIlIlIIl() {
            }

            @Override // java.lang.Runnable
            public void run() {
                lllIIlIIlI.this.lIIIIIlIlI();
            }
        }

        IlIllIlIIl() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Log.m2707d(this, "Surface changed to size: {}x{}, format: {}", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
            if (IlllIIIllI.this.lIlIIIIlIl == null || !IlllIIIllI.this.lIlIIIIlIl.llIIlIlIIl(i2, i3) || IlllIIIllI.this.IllIIIllII == null) {
                return;
            }
            Log.m2707d(this, "Setting surface holder fixed size to {}", IlllIIIllI.this.lIlIIIIlIl);
            IlllIIIllI.this.IllIIIllII.setFixedSize(IlllIIIllI.this.lIlIIIIlIl.IlIllIlIIl(), IlllIIIllI.this.lIlIIIIlIl.llIIlIlIIl());
            IlllIIIllI.this.llIIIlllll = true;
            IlllIIIllI.this.llIIlIlIIl.llIIlIlIIl(new llIIlIlIIl());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.m2711i(this, "Surface has been created!", new Object[0]);
            IlllIIIllI.this.IllIIIllII = surfaceHolder;
            if (IlllIIIllI.this.lIlIIIIlIl != null) {
                IlllIIIllI.this.IllIIIllII.setFixedSize(IlllIIIllI.this.lIlIIIIlIl.IlIllIlIIl(), IlllIIIllI.this.lIlIIIIlIl.llIIlIlIIl());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Log.m2711i(this, "Surface is being destroyed", new Object[0]);
            if (IlllIIIllI.this.IllIIIllII != null) {
                Log.m2711i(this, "Removing callback from surface holder", new Object[0]);
                IlllIIIllI.this.IllIIIllII.removeCallback(this);
                IlllIIIllI.this.IllIIIllII = null;
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements TextureView.SurfaceTextureListener {

        /* JADX INFO: compiled from: line */
        class IlIllIlIIl implements Runnable {
            final /* synthetic */ SurfaceTexture llIIlIlIIl;

            IlIllIlIIl(SurfaceTexture surfaceTexture) {
                this.llIIlIlIIl = surfaceTexture;
            }

            @Override // java.lang.Runnable
            public void run() {
                IlllIIIllI.this.IllIIIIllI = this.llIIlIlIIl;
                lllIIlIIlI.this.lIIIIIlIlI();
            }
        }

        /* JADX INFO: renamed from: com.microblink.blinkid.secured.IlllIIIllI$IllIIIllII$IllIIIllII, reason: collision with other inner class name */
        /* JADX INFO: compiled from: line */
        class RunnableC5986IllIIIllII implements Runnable {
            RunnableC5986IllIIIllII() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IllIIIllII illIIIllII = IllIIIllII.this;
                if (IlllIIIllI.this.IllIIIIllI != null) {
                    Log.m2711i(illIIIllII, "Releasing SurfaceTexture", new Object[0]);
                    IlllIIIllI.this.IllIIIIllI.release();
                    IlllIIIllI.this.IllIIIIllI = null;
                }
            }
        }

        /* JADX INFO: compiled from: line */
        class llIIlIlIIl implements Runnable {
            final /* synthetic */ SurfaceTexture llIIlIlIIl;

            llIIlIlIIl(SurfaceTexture surfaceTexture) {
                this.llIIlIlIIl = surfaceTexture;
            }

            @Override // java.lang.Runnable
            public void run() {
                IlllIIIllI.this.IllIIIIllI = this.llIIlIlIIl;
            }
        }

        IllIIIllII() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.m2711i(this, "SurfaceTexture has become available (size: {}x{})", Integer.valueOf(i), Integer.valueOf(i2));
            if (lllIIlIIlI.this.IlIlIlIIlI.get()) {
                return;
            }
            IlllIIIllI.this.llIIlIlIIl.llIIlIlIIl(new llIIlIlIIl(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Log.m2711i(this, "SurfaceTexture is about to be destroyed", new Object[0]);
            if (IlllIIIllI.this.llIIlIlIIl == null) {
                Log.m2711i(this, "Immediately releasing SurfaceTexture", new Object[0]);
                return true;
            }
            IlllIIIllI.this.llIIlIlIIl.llIIlIlIIl(new RunnableC5986IllIIIllII());
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.m2711i(this, "SurfaceTexture has changed size (new size: {}x{})", Integer.valueOf(i), Integer.valueOf(i2));
            if (lllIIlIIlI.this.IlIlIlIIlI.get()) {
                return;
            }
            IlllIIIllI.this.llIIlIlIIl.llIIlIlIIl(new IlIllIlIIl(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: compiled from: line */
    public interface llIIIlllll {
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        llIIlIlIIl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IlllIIIllI.this.IllIIIllII != null) {
                IlllIIIllI.this.IllIIIllII.setFixedSize(IlllIIIllI.this.lIlIIIIlIl.IlIllIlIIl(), IlllIIIllI.this.lIlIIIIlIl.llIIlIlIIl());
            }
        }
    }

    IlllIIIllI(IIIIIlIIII iIIIIlIIII, llIIIlllll lliiilllll) {
        this.llIIlIlIIl = iIIIIlIIII;
        this.IlIllIlIIl = lliiilllll;
    }

    @Override // com.microblink.blinkid.secured.IIllIlIIII
    public TextureView.SurfaceTextureListener IlIllIlIIl() {
        return this.IIlIIIllIl;
    }

    Surface IllIIIllII() {
        SurfaceHolder surfaceHolder = this.IllIIIllII;
        if (surfaceHolder != null) {
            return surfaceHolder.getSurface();
        }
        this.IllIIIIllI.setDefaultBufferSize(this.lIlIIIIlIl.IlIllIlIIl(), this.lIlIIIIlIl.llIIlIlIIl());
        return new Surface(this.IllIIIIllI);
    }

    boolean llIIIlllll() {
        return (this.IllIIIllII != null && this.llIIIlllll) || this.IllIIIIllI != null;
    }

    void llIIlIlIIl(lIllllIlll lillllilll, IIIIIlIIII iIIIIlIIII) {
        this.lIlIIIIlIl = lillllilll;
        if (this.IllIIIllII != null) {
            iIIIIlIIII.llIIlIlIIl(new llIIlIlIIl());
        }
    }

    @Override // com.microblink.blinkid.secured.IIllIlIIII
    public SurfaceHolder.Callback llIIlIlIIl() {
        return this.llIIlIIlll;
    }
}
