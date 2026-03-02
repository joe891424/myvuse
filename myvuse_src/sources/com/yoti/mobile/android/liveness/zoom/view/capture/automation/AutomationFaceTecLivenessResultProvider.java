package com.yoti.mobile.android.liveness.zoom.view.capture.automation;

import com.yoti.mobile.android.yotidocs.common.file.AssetToFileConverter;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/automation/AutomationFaceTecLivenessResultProvider;", "", "assetToFileConverter", "Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;", "(Lcom/yoti/mobile/android/yotidocs/common/file/AssetToFileConverter;)V", "getFacemapPath", "", "getFramesPath", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationFaceTecLivenessResultProvider {
    private final AssetToFileConverter assetToFileConverter;

    @Inject
    public AutomationFaceTecLivenessResultProvider(AssetToFileConverter assetToFileConverter) {
        Intrinsics.checkNotNullParameter(assetToFileConverter, "assetToFileConverter");
        this.assetToFileConverter = assetToFileConverter;
    }

    public final String getFacemapPath() {
        String path = AssetToFileConverter.getFile$default(this.assetToFileConverter, "facemap", false, 2, null).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "assetToFileConverter.getFile(FACEMAP).path");
        return path;
    }

    public final List<String> getFramesPath() {
        String path = AssetToFileConverter.getFile$default(this.assetToFileConverter, "frame_0.jpg", false, 2, null).getPath();
        return CollectionsKt.listOf((Object[]) new String[]{path, path, path});
    }
}
