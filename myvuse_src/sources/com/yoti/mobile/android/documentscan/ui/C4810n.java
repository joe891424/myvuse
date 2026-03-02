package com.yoti.mobile.android.documentscan.ui;

import android.os.Parcel;
import com.microblink.entities.recognizers.framegrabber.FrameCallback;
import com.microblink.image.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.n */
/* JADX INFO: loaded from: classes5.dex */
public final class C4810n implements FrameCallback {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideFragment f7132a;

    C4810n(ScanDocumentMultiSideFragment scanDocumentMultiSideFragment) {
        this.f7132a = scanDocumentMultiSideFragment;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.microblink.entities.recognizers.framegrabber.FrameCallback
    public void onFrameAvailable(Image image, boolean z, double d) {
        if (image != null) {
            ScanDocumentMultiSideFragment.m4906a(this.f7132a).m4930a(image);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkParameterIsNotNull(dest, "dest");
    }
}
