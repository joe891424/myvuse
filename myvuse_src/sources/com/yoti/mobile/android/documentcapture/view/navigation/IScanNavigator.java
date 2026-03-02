package com.yoti.mobile.android.documentcapture.view.navigation;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigator;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "", "isCameraPermissionRequired", "", "()Z", "navigateToScan", "", "scanConfiguration", "(Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;)V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IScanNavigator<T extends IScanConfigurationViewData> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static <T extends IScanConfigurationViewData> boolean isCameraPermissionRequired(IScanNavigator<T> iScanNavigator) {
            return true;
        }
    }

    boolean isCameraPermissionRequired();

    void navigateToScan(T scanConfiguration);
}
