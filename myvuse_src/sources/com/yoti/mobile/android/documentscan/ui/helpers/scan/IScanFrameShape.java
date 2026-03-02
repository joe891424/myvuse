package com.yoti.mobile.android.documentscan.ui.helpers.scan;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/IScanFrameShape;", "", RemoteConfigComponent.ACTIVATE_FILE_NAME, "", "deactivate", "draw", "canvas", "Landroid/graphics/Canvas;", "getShape", "Landroid/graphics/Path;", "setCorners", "windowRect", "Landroid/graphics/RectF;", "setRatio", "ratio", "", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public interface IScanFrameShape {
    void activate();

    void deactivate();

    void draw(Canvas canvas);

    Path getShape();

    void setCorners(RectF windowRect);

    void setRatio(float ratio);
}
