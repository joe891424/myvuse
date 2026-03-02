package com.yoti.mobile.android.capture.face.p048ui.analyzers;

import android.media.Image;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureConfiguration;
import com.yoti.mobile.android.commons.functional.Either;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IFaceDetection.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/capture/face/ui/analyzers/IFaceDetection;", "", "analyse", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceDetectionError;", "", "Lcom/yoti/mobile/android/capture/face/ui/analyzers/FaceResult;", "image", "Landroid/media/Image;", "rotationDegrees", "", "onConfigChanged", "", "config", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureConfiguration;", "face_bundledRelease"}, m5599k = 1, m5600mv = {1, 4, 1})
public interface IFaceDetection {
    Either<FaceDetectionError, List<FaceResult>> analyse(Image image, int rotationDegrees);

    void onConfigChanged(FaceCaptureConfiguration config);
}
