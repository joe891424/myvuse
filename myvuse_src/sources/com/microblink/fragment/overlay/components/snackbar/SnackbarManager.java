package com.microblink.fragment.overlay.components.snackbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.microblink.blinkid.secured.llIIllllIl;
import com.microblink.fragment.overlay.components.statusmsg.StatusTextStyler;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class SnackbarManager {
    private Handler IlIllIlIIl;
    private boolean IllIIIllII;
    private Runnable llIIIlllll;
    private ViewSwitcher llIIlIlIIl;

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.components.snackbar.SnackbarManager$2 */
    /* JADX INFO: compiled from: line */
    class RunnableC37072 implements Runnable {
        RunnableC37072() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SnackbarManager.this.llIIlIlIIl.setDisplayedChild(0);
        }
    }

    public SnackbarManager(ViewSwitcher viewSwitcher, String str, Drawable drawable, StatusTextStyler statusTextStyler, int i, int i2) {
        this.IlIllIlIIl = new Handler(Looper.getMainLooper());
        this.IllIIIllII = false;
        this.llIIIlllll = new Runnable() { // from class: com.microblink.fragment.overlay.components.snackbar.SnackbarManager.3
            @Override // java.lang.Runnable
            public void run() {
                SnackbarManager.IlIllIlIIl(SnackbarManager.this);
            }
        };
        this.llIIlIlIIl = viewSwitcher;
        Context context = viewSwitcher.getContext();
        this.llIIlIlIIl.removeAllViews();
        viewSwitcher.addView(new View(context), new ViewGroup.LayoutParams(0, 0));
        View viewInflate = LayoutInflater.from(context).inflate(llIIllllIl.llIIlIIlll, (ViewGroup) viewSwitcher, false);
        viewSwitcher.addView(viewInflate);
        TextView textView = (TextView) viewInflate.findViewById(C3714R.id.tvSnackbarMessage);
        textView.setText(str);
        textView.setBackground(drawable);
        statusTextStyler.applyStyle(textView);
        viewSwitcher.setInAnimation(AnimationUtils.loadAnimation(context, i));
        viewSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context, i2));
    }

    static void IlIllIlIIl(SnackbarManager snackbarManager) {
        snackbarManager.IllIIIllII = false;
        snackbarManager.IlIllIlIIl.post(snackbarManager.new RunnableC37072());
    }

    public void hideSnackbar() {
        this.IlIllIlIIl.removeCallbacks(this.llIIIlllll);
        this.IllIIIllII = false;
        this.IlIllIlIIl.post(new RunnableC37072());
    }

    public boolean isSnackbarShown() {
        return this.IllIIIllII;
    }

    public void showSnackbar() {
        this.IlIllIlIIl.removeCallbacks(this.llIIIlllll);
        this.IllIIIllII = true;
        this.IlIllIlIIl.post(new Runnable() { // from class: com.microblink.fragment.overlay.components.snackbar.SnackbarManager.1
            @Override // java.lang.Runnable
            public void run() {
                SnackbarManager.this.llIIlIlIIl.setDisplayedChild(1);
            }
        });
        this.IlIllIlIIl.postDelayed(this.llIIIlllll, 5000L);
    }

    public SnackbarManager(ViewSwitcher viewSwitcher, String str, Drawable drawable, StatusTextStyler statusTextStyler) {
        this(viewSwitcher, str, drawable, statusTextStyler, C3714R.anim.mb_snackbar_in, C3714R.anim.mb_snackbar_out);
    }
}
