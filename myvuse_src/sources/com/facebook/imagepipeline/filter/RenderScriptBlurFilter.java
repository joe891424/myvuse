package com.facebook.imagepipeline.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.common.internal.Preconditions;
import com.surajit.rnrg.RadialGradientManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RenderScriptBlurFilter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5598d2 = {"Lcom/facebook/imagepipeline/filter/RenderScriptBlurFilter;", "", "()V", "BLUR_MAX_RADIUS", "", "blurBitmap", "", "dest", "Landroid/graphics/Bitmap;", ReactVideoViewManager.PROP_SRC, "context", "Landroid/content/Context;", RadialGradientManager.PROP_RADIUS, "canUseRenderScript", "", "imagepipeline_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class RenderScriptBlurFilter {
    public static final int BLUR_MAX_RADIUS = 25;
    public static final RenderScriptBlurFilter INSTANCE = new RenderScriptBlurFilter();

    @JvmStatic
    public static final boolean canUseRenderScript() {
        return true;
    }

    private RenderScriptBlurFilter() {
    }

    @JvmStatic
    public static final void blurBitmap(Bitmap dest, Bitmap src, Context context, int radius) throws Throwable {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(context, "context");
        Preconditions.checkArgument(Boolean.valueOf(radius > 0 && radius <= 25));
        RenderScript renderScript = null;
        try {
            RenderScript renderScriptCreate = RenderScript.create(context);
            if (renderScriptCreate == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            try {
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, src);
                if (allocationCreateFromBitmap == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, dest);
                if (allocationCreateFromBitmap2 == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                scriptIntrinsicBlurCreate.setRadius(radius);
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                allocationCreateFromBitmap2.copyTo(dest);
                scriptIntrinsicBlurCreate.destroy();
                allocationCreateFromBitmap.destroy();
                allocationCreateFromBitmap2.destroy();
                if (renderScriptCreate != null) {
                    renderScriptCreate.destroy();
                    return;
                }
                return;
            } catch (Throwable th) {
                th = th;
                renderScript = renderScriptCreate;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (renderScript != null) {
            renderScript.destroy();
        }
        throw th;
    }
}
