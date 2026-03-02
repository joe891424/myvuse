package com.microblink.fragment.overlay.blinkid.reticleui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.microblink.fragment.overlay.OverlayResources;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class ReticleOverlayResources extends OverlayResources {
    final Drawable IIlIIIllIl;
    final int IlIIlllIIl;
    final Drawable IlIllIlllI;
    final int IlIlllllII;
    final Drawable IllIIIIllI;
    final Drawable IllIIIllII;
    final int IllIIlIIII;
    final Drawable lIIIIIlIlI;
    final Drawable lIIIIIllll;
    final Drawable lIlIIIIlIl;
    final Drawable llIIIlllll;
    final int llIIlIIIll;
    final Drawable llIIlIIlll;
    final Drawable lllIIIlIlI;
    final Drawable lllIlIlIIl;

    ReticleOverlayResources(Context context, int i) {
        super(context, i, C3714R.style.MB_default_reticle_overlay_style);
        this.IllIIIllII = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_reticleDefaultDrawable);
        this.llIIIlllll = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_reticleSuccessDrawable);
        this.IllIIIIllI = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_reticleErrorDrawable);
        this.lIlIIIIlIl = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_progressDrawable);
        this.llIIlIIlll = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_torchOnDrawable);
        this.IIlIIIllIl = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_torchOffDrawable);
        this.lIIIIIllll = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_exitScanDrawable);
        this.lllIIIlIlI = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_cardFrontDrawable);
        this.IlIllIlllI = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_cardBackDrawable);
        this.lllIlIlIIl = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_instructionsBackgroundDrawable);
        this.IllIIlIIII = IllIIIllII(C3714R.styleable.BlinkIdReticleOverlay_mb_instructionsTextAppearance);
        this.llIIlIIIll = llIIlIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_pulseColor);
        this.IlIIlllIIl = llIIlIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_successFlashColor);
        this.lIIIIIlIlI = IlIllIlIIl(C3714R.styleable.BlinkIdReticleOverlay_mb_flashlightWarningBackgroundDrawable);
        this.IlIlllllII = IllIIIllII(C3714R.styleable.BlinkIdReticleOverlay_mb_flashlightWarningTextAppearance);
        llIIlIlIIl();
    }

    @Override // com.microblink.fragment.overlay.OverlayResources
    protected int[] IlIllIlIIl() {
        return C3714R.styleable.BlinkIdReticleOverlay;
    }
}
