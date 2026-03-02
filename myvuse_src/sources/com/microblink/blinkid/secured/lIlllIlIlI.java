package com.microblink.blinkid.secured;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.WindowManager;
import com.microblink.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIlllIlIlI implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, IIllIlIIII {
    private IIIIIlIIII IlIllIlIIl;
    private llIIIlllll IllIIIllII;
    private lIlIllIIlI llIIlIlIIl;
    private int llIIIlllll = 0;
    private int IllIIIIllI = 0;
    private SurfaceHolder lIlIIIIlIl = null;
    private SurfaceTexture llIIlIIlll = null;

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Runnable {
        final /* synthetic */ int IlIllIlIIl;
        final /* synthetic */ int IllIIIllII;
        final /* synthetic */ SurfaceTexture llIIlIlIIl;

        IlIllIlIIl(SurfaceTexture surfaceTexture, int i, int i2) {
            this.llIIlIlIIl = surfaceTexture;
            this.IlIllIlIIl = i;
            this.IllIIIllII = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            lIlllIlIlI.this.llIIlIIlll = this.llIIlIlIIl;
            lIlllIlIlI.this.llIIIlllll = this.IlIllIlIIl;
            lIlllIlIlI.this.IllIIIIllI = this.IllIIIllII;
            ((lIIIIIlIlI) lIlllIlIlI.this.IllIIIllII).llIIlIlIIl();
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements Runnable {
        IllIIIllII() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lIlllIlIlI.this.llIIlIIlll != null) {
                Log.m2711i(this, "Releasing SurfaceTexture", new Object[0]);
                lIlllIlIlI.this.llIIlIIlll.release();
                lIlllIlIlI.this.llIIlIIlll = null;
            }
        }
    }

    /* JADX INFO: compiled from: line */
    public interface llIIIlllll {
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        final /* synthetic */ int IlIllIlIIl;
        final /* synthetic */ int IllIIIllII;
        final /* synthetic */ SurfaceTexture llIIlIlIIl;

        llIIlIlIIl(SurfaceTexture surfaceTexture, int i, int i2) {
            this.llIIlIlIIl = surfaceTexture;
            this.IlIllIlIIl = i;
            this.IllIIIllII = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            lIlllIlIlI.this.llIIlIIlll = this.llIIlIlIIl;
            lIlllIlIlI.this.llIIIlllll = this.IlIllIlIIl;
            lIlllIlIlI.this.IllIIIIllI = this.IllIIIllII;
            ((lIIIIIlIlI) lIlllIlIlI.this.IllIIIllII).llIIlIlIIl();
        }
    }

    lIlllIlIlI(lIlIllIIlI lililliili, IIIIIlIIII iIIIIlIIII, llIIIlllll lliiilllll) {
        this.llIIlIlIIl = lililliili;
        this.IlIllIlIIl = iIIIIlIIII;
        this.IllIIIllII = lliiilllll;
    }

    @Override // com.microblink.blinkid.secured.IIllIlIIII
    public TextureView.SurfaceTextureListener IlIllIlIIl() {
        return this;
    }

    boolean IllIIIIllI() {
        return !(this.lIlIIIIlIl == null && this.llIIlIIlll == null) && this.llIIIlllll > 0 && this.IllIIIIllI > 0;
    }

    int IllIIIllII() {
        return this.IllIIIIllI;
    }

    int llIIIlllll() {
        return this.llIIIlllll;
    }

    @Override // com.microblink.blinkid.secured.IIllIlIIII
    public SurfaceHolder.Callback llIIlIlIIl() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.m2711i(this, "SurfaceTexture has become available (size: {}x{})", Integer.valueOf(i), Integer.valueOf(i2));
        if (((lIIIIIlIlI) this.IllIIIllII).llIIlIlIIl.lIlIIIIlIl) {
            return;
        }
        this.IlIllIlIIl.llIIlIlIIl(new llIIlIlIIl(surfaceTexture, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.m2711i(this, "SurfaceTexture is about to be destroyed", new Object[0]);
        IIIIIlIIII iIIIIlIIII = this.IlIllIlIIl;
        if (iIIIIlIIII != null) {
            iIIIIlIIII.llIIlIlIIl(new IllIIIllII());
            return false;
        }
        Log.m2711i(this, "Immediately releasing SurfaceTexture", new Object[0]);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.m2711i(this, "SurfaceTexture has changed size (new size: {}x{})", Integer.valueOf(i), Integer.valueOf(i2));
        if (((lIIIIIlIlI) this.IllIIIllII).llIIlIlIIl.lIlIIIIlIl) {
            return;
        }
        this.IlIllIlIIl.llIIlIlIIl(new IlIllIlIIl(surfaceTexture, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.m2707d(this, "Surface changed to size: {}x{}, format: {}", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.m2711i(this, "Surface has been created!", new Object[0]);
        Display defaultDisplay = ((WindowManager) this.llIIlIlIIl.llIIIlllll().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        int i2 = point.y;
        this.lIlIIIIlIl = surfaceHolder;
        this.llIIIlllll = i;
        this.IllIIIIllI = i2;
        ((lIIIIIlIlI) this.IllIIIllII).llIIlIlIIl();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.m2711i(this, "Surface is being destroyed", new Object[0]);
        if (this.lIlIIIIlIl != null) {
            Log.m2711i(this, "Removing callback from surface holder", new Object[0]);
            this.lIlIIIIlIl.removeCallback(this);
            this.lIlIIIIlIl = null;
        }
    }

    void llIIlIlIIl(Camera camera) throws IOException {
        SurfaceHolder surfaceHolder = this.lIlIIIIlIl;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else {
            camera.setPreviewTexture(this.llIIlIIlll);
        }
    }
}
