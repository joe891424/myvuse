package com.yoti.mobile.android.facecapture.data;

import com.google.gson.Gson;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureUploadResponseCode;
import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureValidationException;
import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureValidationErrorCodeEntity;
import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureValidationErrorEntity;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/FaceCaptureValidationExceptionToEntityMapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/DataExceptionToEntityMapper;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "map", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "from", "", "mapLivenessUploadResponseCode", "Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureValidationErrorCodeEntity;", "code", "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureUploadResponseCode;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureValidationExceptionToEntityMapper extends DataExceptionToEntityMapper {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FaceCaptureUploadResponseCode.values().length];
            iArr[FaceCaptureUploadResponseCode.FACE_NOT_FOUND.ordinal()] = 1;
            iArr[FaceCaptureUploadResponseCode.MULTIPLE_FACES.ordinal()] = 2;
            iArr[FaceCaptureUploadResponseCode.FACE_POSITION.ordinal()] = 3;
            iArr[FaceCaptureUploadResponseCode.IMAGE_TOO_BRIGHT.ordinal()] = 4;
            iArr[FaceCaptureUploadResponseCode.IMAGE_TOO_DARK.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public FaceCaptureValidationExceptionToEntityMapper(Gson gson) {
        super(gson);
        Intrinsics.checkNotNullParameter(gson, "gson");
    }

    private final FaceCaptureValidationErrorCodeEntity mapLivenessUploadResponseCode(FaceCaptureUploadResponseCode code) {
        int i = code == null ? -1 : WhenMappings.$EnumSwitchMapping$0[code.ordinal()];
        if (i == -1) {
            return null;
        }
        if (i == 1) {
            return FaceCaptureValidationErrorCodeEntity.FACE_NOT_FOUND;
        }
        if (i == 2) {
            return FaceCaptureValidationErrorCodeEntity.MULTIPLE_FACES;
        }
        if (i == 3) {
            return FaceCaptureValidationErrorCodeEntity.FACE_POSITION;
        }
        if (i == 4) {
            return FaceCaptureValidationErrorCodeEntity.IMAGE_TOO_BRIGHT;
        }
        if (i == 5) {
            return FaceCaptureValidationErrorCodeEntity.IMAGE_TOO_DARK;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yoti.mobile.android.yotisdkcore.core.data.DataExceptionToEntityMapper, com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper, com.yoti.mobile.android.yotidocs.common.Mapper
    public YotiDocsError map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (!(from instanceof FaceCaptureValidationException)) {
            return super.map(from);
        }
        FaceCaptureValidationException faceCaptureValidationException = (FaceCaptureValidationException) from;
        return new FaceCaptureValidationErrorEntity(faceCaptureValidationException.getAttemptsLeft(), from, mapLivenessUploadResponseCode(faceCaptureValidationException.getCode()));
    }
}
