package com.yoti.mobile.android.facecapture.view.upload;

import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureValidationErrorCodeEntity;
import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureValidationErrorEntity;
import com.yoti.mobile.android.facecapture.view.upload.FaceCaptureUploadValidationFailure;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadErrorToFailureMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "exceptionToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "(Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;)V", "map", "from", "mapFaceCaptureValidationErrorEntity", "Lcom/yoti/mobile/android/facecapture/view/upload/FaceCaptureUploadValidationFailure;", "entity", "Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureValidationErrorEntity;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureUploadErrorToFailureMapper implements Mapper<Throwable, YdsFailure> {
    private final ExceptionToFailureMapper exceptionToFailureMapper;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FaceCaptureValidationErrorCodeEntity.values().length];
            iArr[FaceCaptureValidationErrorCodeEntity.FACE_NOT_FOUND.ordinal()] = 1;
            iArr[FaceCaptureValidationErrorCodeEntity.MULTIPLE_FACES.ordinal()] = 2;
            iArr[FaceCaptureValidationErrorCodeEntity.FACE_POSITION.ordinal()] = 3;
            iArr[FaceCaptureValidationErrorCodeEntity.IMAGE_TOO_BRIGHT.ordinal()] = 4;
            iArr[FaceCaptureValidationErrorCodeEntity.IMAGE_TOO_DARK.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public FaceCaptureUploadErrorToFailureMapper(ExceptionToFailureMapper exceptionToFailureMapper) {
        Intrinsics.checkNotNullParameter(exceptionToFailureMapper, "exceptionToFailureMapper");
        this.exceptionToFailureMapper = exceptionToFailureMapper;
    }

    private final FaceCaptureUploadValidationFailure mapFaceCaptureValidationErrorEntity(FaceCaptureValidationErrorEntity entity) {
        int i = WhenMappings.$EnumSwitchMapping$0[entity.getCode().ordinal()];
        if (i == 1) {
            return FaceCaptureUploadValidationFailure.FaceNotFound.INSTANCE;
        }
        if (i == 2) {
            return FaceCaptureUploadValidationFailure.MultipleFaces.INSTANCE;
        }
        if (i == 3) {
            return FaceCaptureUploadValidationFailure.FacePosition.INSTANCE;
        }
        if (i == 4) {
            return FaceCaptureUploadValidationFailure.ImageTooBright.INSTANCE;
        }
        if (i == 5) {
            return FaceCaptureUploadValidationFailure.ImageTooDark.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public YdsFailure map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return from instanceof FaceCaptureValidationErrorEntity ? new YdsFailure(mapFaceCaptureValidationErrorEntity((FaceCaptureValidationErrorEntity) from), false, from, 2, null) : this.exceptionToFailureMapper.map(from);
    }
}
