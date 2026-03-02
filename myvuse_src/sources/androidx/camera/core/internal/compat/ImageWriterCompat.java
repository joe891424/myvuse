package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class ImageWriterCompat {
    public static ImageWriter newInstance(Surface surface, int maxImages, int format) {
        return ImageWriterCompatApi26Impl.newInstance(surface, maxImages, format);
    }

    private ImageWriterCompat() {
    }
}
