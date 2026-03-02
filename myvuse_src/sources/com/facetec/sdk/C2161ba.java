package com.facetec.sdk;

import android.content.Context;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.util.Size;
import android.view.Surface;

/* JADX INFO: renamed from: com.facetec.sdk.ba */
/* JADX INFO: loaded from: classes3.dex */
final class C2161ba implements Allocation.OnBufferAvailableListener {

    /* JADX INFO: renamed from: C */
    private static RenderScript f2697C;
    private I Code;

    /* JADX INFO: renamed from: F */
    private final ScriptIntrinsicYuvToRGB f2700F;

    /* JADX INFO: renamed from: I */
    private final Allocation f2701I;

    /* JADX INFO: renamed from: V */
    private final Size f2702V;

    /* JADX INFO: renamed from: Z */
    private final Allocation f2703Z;

    /* JADX INFO: renamed from: B */
    private byte[] f2698B = null;

    /* JADX INFO: renamed from: D */
    private final Allocation.OnBufferAvailableListener f2699D = this;

    /* JADX INFO: renamed from: com.facetec.sdk.ba$I */
    interface I {
        void Code(byte[] bArr, Size size);
    }

    /* JADX INFO: renamed from: Z */
    static void m1807Z(Context context) {
        if (f2697C == null) {
            f2697C = RenderScript.create(context);
        }
    }

    C2161ba(Context context, Size size) {
        m1807Z(context);
        RenderScript renderScript = f2697C;
        Type.Builder builder = new Type.Builder(renderScript, Element.YUV(renderScript));
        builder.setX(size.getWidth());
        builder.setY(size.getHeight());
        builder.setYuvFormat(35);
        Allocation allocationCreateTyped = Allocation.createTyped(f2697C, builder.create(), 33);
        this.f2701I = allocationCreateTyped;
        allocationCreateTyped.setOnBufferAvailableListener(this);
        this.f2702V = size;
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGBCreate = ScriptIntrinsicYuvToRGB.create(f2697C, Element.createPixel(f2697C, Element.DataType.UNSIGNED_8, Element.DataKind.PIXEL_YUV));
        this.f2700F = scriptIntrinsicYuvToRGBCreate;
        scriptIntrinsicYuvToRGBCreate.setInput(allocationCreateTyped);
        RenderScript renderScript2 = f2697C;
        this.f2703Z = Allocation.createTyped(f2697C, new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(size.getWidth()).setY(size.getHeight()).create(), 1);
    }

    /* JADX INFO: renamed from: I */
    final Surface m1809I() {
        return this.f2701I.getSurface();
    }

    /* JADX INFO: renamed from: B */
    final void m1808B() {
        this.Code = null;
    }

    /* JADX INFO: renamed from: V */
    final void m1810V(I i) {
        this.Code = i;
    }

    @Override // android.renderscript.Allocation.OnBufferAvailableListener
    public final synchronized void onBufferAvailable(Allocation allocation) {
        this.f2701I.ioReceive();
        I i = this.Code;
        if (i != null) {
            this.f2700F.forEach(this.f2703Z);
            int bytesSize = this.f2703Z.getBytesSize();
            if (this.f2698B == null || bytesSize != this.f2698B.length) {
                this.f2698B = new byte[bytesSize];
            }
            this.f2703Z.copyTo(this.f2698B);
            i.Code(this.f2698B, this.f2702V);
        }
    }
}
