package com.yoti.mobile.android.liveness.view.navigation;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavController;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "", "getNavigator", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigator;", "navController", "Landroidx/navigation/NavController;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ILivenessEducationalNavigatorProvider<T extends ILivenessResourceEntity> {
    ILivenessEducationalNavigator<T> getNavigator(NavController navController);
}
