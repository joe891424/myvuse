package com.yoti.mobile.android.documentcapture.view.navigation;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavController;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", ExifInterface.LONGITUDE_EAST, "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "", "getNavigator", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;", "navController", "Landroidx/navigation/NavController;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IUploadNavigatorProvider<E extends IDocumentViewData> {
    IUploadNavigator<E> getNavigator(NavController navController);
}
