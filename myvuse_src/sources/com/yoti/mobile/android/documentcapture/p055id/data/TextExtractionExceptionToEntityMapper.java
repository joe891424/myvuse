package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.TextExtractionException;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.TextExtractionResponse;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.TextExtractionError;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/TextExtractionExceptionToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionException;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError;", "()V", "map", "from", "mapCause", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/TextExtractionError$TextExtractionErrorTypeEntity;", "errorCause", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$DetailType;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TextExtractionExceptionToEntityMapper implements Mapper<TextExtractionException, TextExtractionError> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextExtractionResponse.Recommendation.Reason.DetailType.values().length];
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.DUPLICATED_DOCUMENT.ordinal()] = 1;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.WRONG_DOCUMENT_UPLOADED.ordinal()] = 2;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.UNSUPPORTED_DOCUMENT.ordinal()] = 3;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.WRONG_NUMBER_OF_PAGES.ordinal()] = 4;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.DOCUMENT_IS_EXPIRED.ordinal()] = 5;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.NO_DOCUMENT.ordinal()] = 6;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.FACE_NOT_FOUND.ordinal()] = 7;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.OUT_OF_BOUNDS.ordinal()] = 8;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.BAD_ANGLE.ordinal()] = 9;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.SCREEN_CAPTURE.ordinal()] = 10;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.OUT_OF_FOCUS.ordinal()] = 11;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.LOW_RESOLUTION.ordinal()] = 12;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.GLARE_OBSTRUCTION.ordinal()] = 13;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.NO_COLOR.ordinal()] = 14;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.UNABLE_TO_READ_BARCODE.ordinal()] = 15;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.NO_BARCODE.ordinal()] = 16;
            iArr[TextExtractionResponse.Recommendation.Reason.DetailType.MISSING_BACK_PAGE.ordinal()] = 17;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public TextExtractionExceptionToEntityMapper() {
    }

    private final TextExtractionError.TextExtractionErrorTypeEntity mapCause(TextExtractionResponse.Recommendation.Reason.DetailType errorCause) {
        switch (WhenMappings.$EnumSwitchMapping$0[errorCause.ordinal()]) {
            case 1:
                return TextExtractionError.TextExtractionErrorTypeEntity.DUPLICATED;
            case 2:
            case 3:
                return TextExtractionError.TextExtractionErrorTypeEntity.INVALID;
            case 4:
                return TextExtractionError.TextExtractionErrorTypeEntity.WRONG_PAGES;
            case 5:
                return TextExtractionError.TextExtractionErrorTypeEntity.EXPIRED;
            case 6:
                return TextExtractionError.TextExtractionErrorTypeEntity.NO_DOCUMENT;
            case 7:
                return TextExtractionError.TextExtractionErrorTypeEntity.FACE_NOT_FOUND;
            case 8:
            case 9:
                return TextExtractionError.TextExtractionErrorTypeEntity.INCORRECTLY_FRAMED;
            case 10:
                return TextExtractionError.TextExtractionErrorTypeEntity.SCREEN_CAPTURE;
            case 11:
            case 12:
                return TextExtractionError.TextExtractionErrorTypeEntity.BLURRY;
            case 13:
                return TextExtractionError.TextExtractionErrorTypeEntity.GLARE_OBSTRUCTION;
            case 14:
                return TextExtractionError.TextExtractionErrorTypeEntity.NO_COLOR;
            case 15:
                return TextExtractionError.TextExtractionErrorTypeEntity.UNABLE_TO_READ_BARCODE;
            case 16:
                return TextExtractionError.TextExtractionErrorTypeEntity.NO_BARCODE;
            case 17:
                return TextExtractionError.TextExtractionErrorTypeEntity.MISSING_BACK_PAGE;
            default:
                return TextExtractionError.TextExtractionErrorTypeEntity.UNKNOWN;
        }
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public TextExtractionError map(TextExtractionException from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new TextExtractionError(mapCause(from.getDetail()), from.getIsRetryPossible(), from);
    }
}
