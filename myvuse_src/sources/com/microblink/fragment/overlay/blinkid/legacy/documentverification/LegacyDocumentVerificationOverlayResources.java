package com.microblink.fragment.overlay.blinkid.legacy.documentverification;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.microblink.fragment.overlay.OverlayResources;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class LegacyDocumentVerificationOverlayResources extends OverlayResources {
    final Drawable IIlIIIllIl;
    final Drawable IllIIIIllI;
    final Drawable IllIIIllII;
    final Drawable lIIIIIllll;
    final Drawable lIlIIIIlIl;
    final Drawable llIIIlllll;
    final Drawable llIIlIIlll;

    LegacyDocumentVerificationOverlayResources(Context context, int i) {
        super(context, i, C3714R.style.MB_default_scan_box_overlay_style);
        this.IllIIIllII = IlIllIlIIl(C3714R.styleable.BlinkIdScanBoxOverlay_mb_torchOnDrawable);
        this.llIIIlllll = IlIllIlIIl(C3714R.styleable.BlinkIdScanBoxOverlay_mb_torchOffDrawable);
        this.IllIIIIllI = IlIllIlIIl(C3714R.styleable.BlinkIdScanBoxOverlay_mb_exitScanDrawable);
        this.lIlIIIIlIl = IlIllIlIIl(C3714R.styleable.BlinkIdScanBoxOverlay_mb_frontSideSplashDrawable);
        this.llIIlIIlll = IlIllIlIIl(C3714R.styleable.BlinkIdScanBoxOverlay_mb_backSideSplashDrawable);
        this.IIlIIIllIl = IlIllIlIIl(C3714R.styleable.BlinkIdScanBoxOverlay_mb_frontSideInstructionsDrawable);
        this.lIIIIIllll = IlIllIlIIl(C3714R.styleable.BlinkIdScanBoxOverlay_mb_backSideInstructionsDrawable);
    }

    @Override // com.microblink.fragment.overlay.OverlayResources
    protected int[] IlIllIlIIl() {
        return C3714R.styleable.BlinkIdScanBoxOverlay;
    }
}
