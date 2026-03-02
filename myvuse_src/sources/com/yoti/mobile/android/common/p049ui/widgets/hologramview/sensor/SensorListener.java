package com.yoti.mobile.android.common.p049ui.widgets.hologramview.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/hologramview/sensor/SensorListener;", "", "", "azimuth", "pitch", "roll", "", "onOrientationChanged", "(FFF)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public interface SensorListener {
    void onOrientationChanged(float azimuth, float pitch, float roll);
}
