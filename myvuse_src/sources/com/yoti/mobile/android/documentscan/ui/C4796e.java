package com.yoti.mobile.android.documentscan.ui;

import android.os.Parcel;
import com.microblink.entities.recognizers.framegrabber.FrameCallback;
import com.microblink.image.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.e */
/* JADX INFO: loaded from: classes5.dex */
public final class C4796e implements FrameCallback {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ImageScanFragment f7107a;

    C4796e(ImageScanFragment imageScanFragment) {
        this.f7107a = imageScanFragment;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.microblink.entities.recognizers.framegrabber.FrameCallback
    public void onFrameAvailable(Image image, boolean z, double d) {
        if (image != null) {
            ImageScanFragment.access$getViewModel$p(this.f7107a).m4930a(image);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkParameterIsNotNull(dest, "dest");
    }
}
