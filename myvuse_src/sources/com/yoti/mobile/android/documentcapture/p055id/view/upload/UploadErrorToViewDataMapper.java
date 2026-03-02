package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import com.yoti.mobile.android.documentcapture.p055id.domain.model.TextExtractionError;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/UploadErrorToViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "documentCaptureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "exceptionToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;)V", "map", "from", "mapError", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "error", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError;", "mapTextExtractionError", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class UploadErrorToViewDataMapper implements Mapper<Throwable, YdsFailure> {
    private final DocumentCaptureConfiguration documentCaptureConfiguration;
    private final ExceptionToFailureMapper exceptionToFailureMapper;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TextExtractionError.TextExtractionErrorTypeEntity.values().length];
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.DUPLICATED.ordinal()] = 1;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.INVALID.ordinal()] = 2;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.WRONG_PAGES.ordinal()] = 3;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.EXPIRED.ordinal()] = 4;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.NO_DOCUMENT.ordinal()] = 5;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.FACE_NOT_FOUND.ordinal()] = 6;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.INCORRECTLY_FRAMED.ordinal()] = 7;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.SCREEN_CAPTURE.ordinal()] = 8;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.BLURRY.ordinal()] = 9;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.GLARE_OBSTRUCTION.ordinal()] = 10;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.NO_COLOR.ordinal()] = 11;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.UNABLE_TO_READ_BARCODE.ordinal()] = 12;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.NO_BARCODE.ordinal()] = 13;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.MISSING_BACK_PAGE.ordinal()] = 14;
            iArr[TextExtractionError.TextExtractionErrorTypeEntity.UNKNOWN.ordinal()] = 15;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TextExtractionError.TextExtractionErrorCauseType.values().length];
            iArr2[TextExtractionError.TextExtractionErrorCauseType.RECLASSIFICATION.ordinal()] = 1;
            iArr2[TextExtractionError.TextExtractionErrorCauseType.EXPIRATION.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public UploadErrorToViewDataMapper(DocumentCaptureConfiguration documentCaptureConfiguration, ExceptionToFailureMapper exceptionToFailureMapper) {
        Intrinsics.checkNotNullParameter(documentCaptureConfiguration, "documentCaptureConfiguration");
        Intrinsics.checkNotNullParameter(exceptionToFailureMapper, "exceptionToFailureMapper");
        this.documentCaptureConfiguration = documentCaptureConfiguration;
        this.exceptionToFailureMapper = exceptionToFailureMapper;
    }

    private final TextExtractionUploadFailureType mapError(TextExtractionError error) {
        boolean isSelectableDocumentFlow = this.documentCaptureConfiguration.getIsSelectableDocumentFlow();
        if (!error.isRetryPossible()) {
            int i = WhenMappings.$EnumSwitchMapping$1[error.getType().getCause().ordinal()];
            return i != 1 ? i != 2 ? TextExtractionUploadFailureType.NoMoreAttempts.NoMoreAttemptsQuality.INSTANCE : TextExtractionUploadFailureType.NoMoreAttempts.NoMoreAttemptsExpiration.INSTANCE : TextExtractionUploadFailureType.NoMoreAttempts.NoMoreAttemptsReclassification.INSTANCE;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[error.getType().ordinal()]) {
            case 1:
                return new TextExtractionUploadFailureType.DuplicatedDocument(isSelectableDocumentFlow);
            case 2:
                return new TextExtractionUploadFailureType.InvalidDocument(isSelectableDocumentFlow);
            case 3:
                return new TextExtractionUploadFailureType.WrongNumberOfPages(isSelectableDocumentFlow);
            case 4:
                return new TextExtractionUploadFailureType.DocumentExpired(isSelectableDocumentFlow);
            case 5:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.NoDocument.INSTANCE;
            case 6:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.FaceNotFound.INSTANCE;
            case 7:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.IncorrectlyFramed.INSTANCE;
            case 8:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.ScreenCapture.INSTANCE;
            case 9:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.Blurry.INSTANCE;
            case 10:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.GlareObstruction.INSTANCE;
            case 11:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.NoColor.INSTANCE;
            case 12:
            case 13:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.UnableToReadBarcode.INSTANCE;
            case 14:
                return TextExtractionUploadFailureType.DocumentTextExtractionError.MissingBackPage.INSTANCE;
            case 15:
                return new TextExtractionUploadFailureType.DocumentTextExtractionError.Generic(isSelectableDocumentFlow);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final YdsFailure mapTextExtractionError(TextExtractionError error) {
        return new YdsFailure(mapError(error), error.getF7491a(), error);
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public YdsFailure map(Throwable from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return from instanceof TextExtractionError ? mapTextExtractionError((TextExtractionError) from) : this.exceptionToFailureMapper.map(from);
    }
}
