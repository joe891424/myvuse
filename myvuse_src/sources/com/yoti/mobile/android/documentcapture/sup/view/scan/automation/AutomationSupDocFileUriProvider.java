package com.yoti.mobile.android.documentcapture.sup.view.scan.automation;

import android.net.Uri;
import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationSupDocFileUriProvider;", "", "assetToFileConverter", "Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;", "(Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;)V", "getImageUri", "Landroid/net/Uri;", "getPdfUri", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationSupDocFileUriProvider {
    private final AssetToFileConverter assetToFileConverter;

    @Inject
    public AutomationSupDocFileUriProvider(AssetToFileConverter assetToFileConverter) {
        Intrinsics.checkNotNullParameter(assetToFileConverter, "assetToFileConverter");
        this.assetToFileConverter = assetToFileConverter;
    }

    public final Uri getImageUri() {
        Uri uriFromFile = Uri.fromFile(AssetToFileConverter.getFile$default(this.assetToFileConverter, "sample.jpg", false, 2, null));
        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(assetToFileConv…er.getFile(SAMPLE_IMAGE))");
        return uriFromFile;
    }

    public final Uri getPdfUri() {
        Uri uriFromFile = Uri.fromFile(AssetToFileConverter.getFile$default(this.assetToFileConverter, "sample.pdf", false, 2, null));
        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(assetToFileConverter.getFile(SAMPLE_PDF))");
        return uriFromFile;
    }
}
