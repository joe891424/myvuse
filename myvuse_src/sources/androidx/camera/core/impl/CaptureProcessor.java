package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public interface CaptureProcessor {
    void onOutputSurface(Surface surface, int imageFormat);

    void onResolutionUpdate(Size size);

    void process(ImageProxyBundle bundle);
}
