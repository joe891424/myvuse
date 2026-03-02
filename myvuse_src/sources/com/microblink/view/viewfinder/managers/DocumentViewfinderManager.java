package com.microblink.view.viewfinder.managers;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.microblink.view.viewfinder.ViewfinderShapeView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentViewfinderManager {
    private ViewfinderShapeView IlIllIlIIl;
    private TextView IllIIIllII;
    private ImageView llIIIlllll;
    private final Handler llIIlIlIIl = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Runnable {
        final /* synthetic */ Runnable IlIllIlIIl;
        final /* synthetic */ long llIIlIlIIl;

        /* JADX INFO: compiled from: line */
        class llIIlIlIIl implements Runnable {
            llIIlIlIIl() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DocumentViewfinderManager.this.IlIllIlIIl.setInnerAlpha(0.0f);
                DocumentViewfinderManager.this.llIIIlllll.setVisibility(4);
                DocumentViewfinderManager.this.IllIIIllII.setVisibility(4);
                Runnable runnable = IlIllIlIIl.this.IlIllIlIIl;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        IlIllIlIIl(long j, Runnable runnable) {
            this.llIIlIlIIl = j;
            this.IlIllIlIIl = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewfinderAnimationUtil.createSplashAnimation(this.llIIlIlIIl, new llIIlIlIIl(), DocumentViewfinderManager.this.IlIllIlIIl, DocumentViewfinderManager.this.IllIIIllII, DocumentViewfinderManager.this.llIIIlllll).start();
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        final /* synthetic */ CharSequence IlIllIlIIl;
        final /* synthetic */ int IllIIIllII;
        final /* synthetic */ Drawable llIIlIlIIl;

        llIIlIlIIl(Drawable drawable, CharSequence charSequence, int i) {
            this.llIIlIlIIl = drawable;
            this.IlIllIlIIl = charSequence;
            this.IllIIIllII = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            DocumentViewfinderManager.this.llIIIlllll.setImageDrawable(this.llIIlIlIIl);
            DocumentViewfinderManager.this.IllIIIllII.setText(this.IlIllIlIIl);
            DocumentViewfinderManager.this.IllIIIllII.setVisibility(0);
            DocumentViewfinderManager.this.llIIIlllll.setVisibility(0);
            DocumentViewfinderManager.this.IlIllIlIIl.setInnerColor(ContextCompat.getColor(DocumentViewfinderManager.this.IlIllIlIIl.getContext(), this.IllIIIllII));
            DocumentViewfinderManager.this.IlIllIlIIl.setInnerAlpha(0.67f);
            DocumentViewfinderManager.this.IllIIIllII.setAlpha(1.0f);
            DocumentViewfinderManager.this.llIIIlllll.setAlpha(1.0f);
        }
    }

    public DocumentViewfinderManager(ViewfinderShapeView viewfinderShapeView, TextView textView, ImageView imageView) {
        this.IlIllIlIIl = viewfinderShapeView;
        this.IllIIIllII = textView;
        this.llIIIlllll = imageView;
    }

    public void clearSplashScreen(long j, long j2) {
        clearSplashScreen(j, j2, null);
    }

    public void showSplashScreen(CharSequence charSequence, Drawable drawable, int i) {
        this.llIIlIlIIl.post(new llIIlIlIIl(drawable, charSequence, i));
    }

    public void clearSplashScreen(long j, long j2, Runnable runnable) {
        this.llIIlIlIIl.postDelayed(new IlIllIlIIl(j2, runnable), j);
    }
}
