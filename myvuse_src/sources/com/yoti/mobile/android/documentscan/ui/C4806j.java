package com.yoti.mobile.android.documentscan.ui;

import com.microblink.hardware.orientation.Orientation;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.j */
/* JADX INFO: loaded from: classes5.dex */
final class C4806j<T, R> implements Function<T, R> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ImageScanFragment f7119a;

    C4806j(ImageScanFragment imageScanFragment) {
        this.f7119a = imageScanFragment;
    }

    /* JADX INFO: renamed from: a */
    public final void m5010a(Long it2) {
        Intrinsics.checkParameterIsNotNull(it2, "it");
        ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModelAccess$getViewModel$p = ImageScanFragment.access$getViewModel$p(this.f7119a);
        Image imageBuildImageFromJpegBytes = ImageBuilder.buildImageFromJpegBytes(ImageScanFragment.access$getCurrentImageData$p(this.f7119a), Orientation.ORIENTATION_PORTRAIT.intValue());
        Intrinsics.checkExpressionValueIsNotNull(imageBuildImageFromJpegBytes, "ImageBuilder.buildImageF…e()\n                    )");
        scanDocumentMultiSideViewModelAccess$getViewModel$p.m4930a(imageBuildImageFromJpegBytes);
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        m5010a((Long) obj);
        return Unit.INSTANCE;
    }
}
