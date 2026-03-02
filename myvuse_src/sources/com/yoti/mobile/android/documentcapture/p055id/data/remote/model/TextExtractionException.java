package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.TextExtractionResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionException;", "", "isRetryPossible", "", "detail", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$DetailType;", "(ZLcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$DetailType;)V", "getDetail", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/TextExtractionResponse$Recommendation$Reason$DetailType;", "()Z", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TextExtractionException extends Throwable {
    private final TextExtractionResponse.Recommendation.Reason.DetailType detail;
    private final boolean isRetryPossible;

    /* JADX WARN: Multi-variable type inference failed */
    public TextExtractionException() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ TextExtractionException(boolean z, TextExtractionResponse.Recommendation.Reason.DetailType detailType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? TextExtractionResponse.Recommendation.Reason.DetailType.UNKNOWN : detailType);
    }

    public final TextExtractionResponse.Recommendation.Reason.DetailType getDetail() {
        return this.detail;
    }

    /* JADX INFO: renamed from: isRetryPossible, reason: from getter */
    public final boolean getIsRetryPossible() {
        return this.isRetryPossible;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextExtractionException(boolean z, TextExtractionResponse.Recommendation.Reason.DetailType detail) {
        super("TextExtractionException: retry Possible: " + z + ", detail: " + detail);
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.isRetryPossible = z;
        this.detail = detail;
    }
}
