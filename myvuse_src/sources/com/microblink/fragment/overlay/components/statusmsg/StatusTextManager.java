package com.microblink.fragment.overlay.components.statusmsg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.microblink.library.C3714R;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class StatusTextManager {
    private boolean IIlIIIllIl;
    private CharSequence IlIllIlIIl;
    private Runnable IlIllIlllI;
    private boolean IllIIIIllI;
    private CharSequence IllIIIllII;
    private Animation lIIIIIllll;
    private Handler lIlIIIIlIl;
    private AtomicBoolean llIIIlllll;
    private boolean llIIlIIlll;
    private TextSwitcher llIIlIlIIl;
    private Animation lllIIIlIlI;

    public StatusTextManager(TextSwitcher textSwitcher, final StatusTextStyler statusTextStyler, int i, int i2) {
        this.IlIllIlIIl = null;
        this.IllIIIllII = null;
        this.llIIIlllll = new AtomicBoolean(false);
        this.IllIIIIllI = true;
        this.lIlIIIIlIl = new Handler(Looper.getMainLooper());
        this.llIIlIIlll = false;
        this.IIlIIIllIl = false;
        this.IlIllIlllI = new Runnable() { // from class: com.microblink.fragment.overlay.components.statusmsg.StatusTextManager.2
            @Override // java.lang.Runnable
            public void run() {
                StatusTextManager.llIIlIlIIl(StatusTextManager.this);
            }
        };
        this.llIIlIlIIl = textSwitcher;
        final Context context = textSwitcher.getContext();
        this.llIIlIlIIl.setFactory(new ViewSwitcher.ViewFactory(this) { // from class: com.microblink.fragment.overlay.components.statusmsg.StatusTextManager.1
            @Override // android.widget.ViewSwitcher.ViewFactory
            public View makeView() {
                TextView textView = new TextView(context);
                textView.setGravity(17);
                statusTextStyler.applyStyle(textView);
                return textView;
            }
        });
        this.lllIIIlIlI = AnimationUtils.loadAnimation(context, i);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, i2);
        this.lIIIIIllll = animationLoadAnimation;
        if (this.IIlIIIllIl) {
            return;
        }
        animationLoadAnimation.setStartOffset(this.lllIIIlIlI.getDuration() + 150);
    }

    private void llIIlIlIIl(CharSequence charSequence, boolean z) {
        if (this.IllIIIIllI) {
            CharSequence charSequence2 = this.IlIllIlIIl;
            if (charSequence2 == null) {
                z = true;
            }
            this.IllIIIllII = charSequence;
            if (z) {
                this.lIlIIIIlIl.removeCallbacks(this.IlIllIlllI);
                this.lIlIIIIlIl.post(this.IlIllIlllI);
            } else {
                if (charSequence.equals(charSequence2) || !this.llIIIlllll.compareAndSet(false, true)) {
                    return;
                }
                this.lIlIIIIlIl.postDelayed(this.IlIllIlllI, 1500L);
            }
        }
    }

    public void setShouldAnimate(boolean z) {
        this.llIIlIIlll = z;
        if (z) {
            this.llIIlIlIIl.setInAnimation(this.lIIIIIllll);
            this.llIIlIlIIl.setOutAnimation(this.lllIIIlIlI);
        } else {
            this.llIIlIlIIl.setInAnimation(null);
            this.llIIlIlIIl.setOutAnimation(null);
        }
    }

    public void setSimultaneouslyStartAnimations(boolean z) {
        this.IIlIIIllIl = z;
        if (z) {
            this.lIIIIIllll.setStartOffset(0L);
        } else {
            this.lIIIIIllll.setStartOffset(this.lllIIIlIlI.getDuration() + 150);
        }
    }

    public void setStatusMessagesEnabled(boolean z) {
        this.IllIIIIllI = z;
        if (z) {
            this.llIIlIlIIl.setVisibility(0);
        } else {
            this.llIIlIlIIl.setVisibility(4);
        }
    }

    public boolean shouldAnimate() {
        return this.llIIlIIlll;
    }

    public void updateStatus(int i) {
        if (i == 0) {
            updateStatus("");
        } else {
            updateStatus(this.llIIlIlIIl.getContext().getString(i));
        }
    }

    public void updateStatusImmediately(int i) {
        if (i == 0) {
            updateStatusImmediately("");
        } else {
            updateStatusImmediately(this.llIIlIlIIl.getContext().getString(i));
        }
    }

    public void updateStatus(String str) {
        llIIlIlIIl(str, false);
    }

    public void updateStatusImmediately(CharSequence charSequence) {
        llIIlIlIIl(charSequence, true);
    }

    static void llIIlIlIIl(StatusTextManager statusTextManager) {
        if (!statusTextManager.IllIIIllII.equals(statusTextManager.IlIllIlIIl)) {
            if (statusTextManager.IlIllIlIIl != null) {
                statusTextManager.llIIlIlIIl.setText(statusTextManager.IllIIIllII);
            } else {
                statusTextManager.llIIlIlIIl.setCurrentText(statusTextManager.IllIIIllII);
            }
            statusTextManager.IlIllIlIIl = statusTextManager.IllIIIllII;
        }
        statusTextManager.llIIIlllll.set(false);
        if (TextUtils.isEmpty(statusTextManager.IlIllIlIIl)) {
            statusTextManager.llIIlIlIIl.setVisibility(4);
        } else {
            statusTextManager.llIIlIlIIl.setVisibility(0);
        }
    }

    public StatusTextManager(TextSwitcher textSwitcher, StatusTextStyler statusTextStyler) {
        this(textSwitcher, statusTextStyler, C3714R.anim.mb_hide_text, C3714R.anim.mb_show_text);
    }
}
