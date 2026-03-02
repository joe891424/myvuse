package com.yoti.mobile.android.yotisdkcore.core.view.upload;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadableViewData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/ViewDataUploader;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadableViewData;", "", "upload", "", "viewData", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadableViewData;)V", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ViewDataUploader<T extends UploadableViewData> {
    void upload(T viewData);
}
