package com.microblink.fragment.overlay.blinkid.document;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.microblink.fragment.overlay.OverlayResources;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class DocumentOverlayResources extends OverlayResources {
    final Drawable IllIIIIllI;
    final Drawable IllIIIllII;
    final Drawable llIIIlllll;

    DocumentOverlayResources(Context context, int i) {
        super(context, i, C3714R.style.MB_default_simple_box_overlay_style);
        this.IllIIIllII = IlIllIlIIl(C3714R.styleable.BlinkIdSimpleBoxOverlay_mb_torchOnDrawable);
        this.llIIIlllll = IlIllIlIIl(C3714R.styleable.BlinkIdSimpleBoxOverlay_mb_torchOffDrawable);
        this.IllIIIIllI = IlIllIlIIl(C3714R.styleable.BlinkIdSimpleBoxOverlay_mb_exitScanDrawable);
    }

    @Override // com.microblink.fragment.overlay.OverlayResources
    protected int[] IlIllIlIIl() {
        return C3714R.styleable.BlinkIdSimpleBoxOverlay;
    }
}
