package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.BlinkIDLicense;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.ui.wrapper.ScanWrapperFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/ScanFragmentFactory;", "", "()V", "getScanFragmentInstance", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "viewConfig", "Lcom/yoti/mobile/android/documentscan/ui/IScanViewConfiguration;", "blinkIdLicense", "Lcom/yoti/mobile/android/documentscan/model/BlinkIDLicense;", "scanLayout", "", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class ScanFragmentFactory {
    public static final ScanFragmentFactory INSTANCE = new ScanFragmentFactory();

    private ScanFragmentFactory() {
    }

    public static /* synthetic */ IScanDocument getScanFragmentInstance$default(ScanFragmentFactory scanFragmentFactory, DocumentScanDetailedConfig documentScanDetailedConfig, IScanViewConfiguration iScanViewConfiguration, BlinkIDLicense blinkIDLicense, int i, ImageFormat imageFormat, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            iScanViewConfiguration = null;
        }
        IScanViewConfiguration iScanViewConfiguration2 = iScanViewConfiguration;
        if ((i2 & 16) != 0) {
            imageFormat = ImageFormat.INSTANCE.m4840a();
        }
        return scanFragmentFactory.getScanFragmentInstance(documentScanDetailedConfig, iScanViewConfiguration2, blinkIDLicense, i, imageFormat);
    }

    public final IScanDocument getScanFragmentInstance(DocumentScanDetailedConfig scanConfig, IScanViewConfiguration viewConfig, BlinkIDLicense blinkIdLicense, int scanLayout, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(scanConfig, "scanConfig");
        Intrinsics.checkParameterIsNotNull(blinkIdLicense, "blinkIdLicense");
        Intrinsics.checkParameterIsNotNull(imageFormat, "imageFormat");
        return ScanWrapperFragment.f7024a.m4946a(scanConfig, viewConfig, blinkIdLicense, scanLayout, imageFormat);
    }
}
