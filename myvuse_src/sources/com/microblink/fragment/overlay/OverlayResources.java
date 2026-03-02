package com.microblink.fragment.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OverlayResources {
    private TypedArray IlIllIlIIl;
    private TypedArray llIIlIlIIl;

    public OverlayResources(Context context, int i, int i2) {
        this.llIIlIlIIl = context.obtainStyledAttributes(i, IlIllIlIIl());
        this.IlIllIlIIl = context.obtainStyledAttributes(i2, IlIllIlIIl());
    }

    protected Drawable IlIllIlIIl(int i) {
        Drawable drawable = this.llIIlIlIIl.getDrawable(i);
        return drawable != null ? drawable : this.IlIllIlIIl.getDrawable(i);
    }

    protected abstract int[] IlIllIlIIl();

    protected int IllIIIllII(int i) {
        int resourceId = this.llIIlIlIIl.getResourceId(i, 0);
        return resourceId != 0 ? resourceId : this.IlIllIlIIl.getResourceId(i, 0);
    }

    protected int llIIlIlIIl(int i) {
        int color = this.llIIlIlIIl.getColor(i, 0);
        return color != 0 ? color : this.IlIllIlIIl.getColor(i, 0);
    }

    protected void llIIlIlIIl() {
        this.llIIlIlIIl.recycle();
        this.IlIllIlIIl.recycle();
    }
}
