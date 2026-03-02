package com.microblink.fragment.overlay.blinkid.reticleui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class ReticleView extends AppCompatImageView {
    private static long llIIIlllll = 200;
    private Drawable IlIllIlIIl;
    private Drawable IllIIIllII;
    private Drawable llIIlIlIIl;

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.reticleui.ReticleView$2 */
    /* JADX INFO: compiled from: line */
    static /* synthetic */ class C36932 {
        static final /* synthetic */ int[] llIIlIlIIl;

        static {
            int[] iArr = new int[Type.values().length];
            llIIlIlIIl = iArr;
            try {
                iArr[Type.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                llIIlIlIIl[Type.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                llIIlIlIIl[Type.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                llIIlIlIIl[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: line */
    public enum Type {
        HIDDEN,
        DEFAULT,
        SUCCESS,
        ERROR
    }

    public ReticleView(Context context) {
        this(context, null, 0);
    }

    public void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.llIIlIlIIl = drawable;
        this.IlIllIlIIl = drawable2;
        this.IllIIIllII = drawable3;
        setImageDrawable(drawable);
    }

    public void setType(Type type) {
        int i = C36932.llIIlIlIIl[type.ordinal()];
        if (i == 1) {
            animate().cancel();
            animate().alpha(0.0f).setDuration(100L).start();
        } else if (i == 2) {
            llIIlIlIIl(this.llIIlIlIIl);
        } else if (i == 3) {
            llIIlIlIIl(this.IlIllIlIIl);
        } else {
            if (i != 4) {
                return;
            }
            llIIlIlIIl(this.IllIIIllII);
        }
    }

    public ReticleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void llIIlIlIIl(final Drawable drawable) {
        animate().cancel();
        if (drawable != getDrawable()) {
            animate().alpha(0.0f).setDuration(llIIIlllll).setListener(new AnimationEndListener() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.ReticleView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ReticleView.this.setImageDrawable(drawable);
                    ReticleView.this.animate().alpha(1.0f).setDuration(ReticleView.llIIIlllll).setListener(null).start();
                }
            }).start();
        } else {
            animate().alpha(1.0f).setDuration(400L).start();
        }
    }

    public ReticleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
