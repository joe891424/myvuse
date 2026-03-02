package com.microblink.entities.recognizers.framegrabber;

import android.os.Parcelable;
import com.microblink.image.Image;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public interface FrameCallback extends Parcelable {
    void onFrameAvailable(Image image, boolean z, double d);
}
