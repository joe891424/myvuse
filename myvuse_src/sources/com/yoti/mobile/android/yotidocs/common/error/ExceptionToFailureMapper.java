package com.yoti.mobile.android.yotidocs.common.error;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0017¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "()V", "map", "from", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class ExceptionToFailureMapper implements Mapper<Throwable, YdsFailure> {
    @Inject
    public ExceptionToFailureMapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public YdsFailure map(Throwable from) {
        YdsFailureType ydsFailureType;
        Intrinsics.checkNotNullParameter(from, "from");
        YotiDocsError yotiDocsError = from instanceof YotiDocsError ? (YotiDocsError) from : null;
        boolean f7491a = yotiDocsError != null ? yotiDocsError.getF7491a() : false;
        if (from instanceof YotiDocsNoNetworkError) {
            ydsFailureType = YdsFailureType.NetworkNotAvailable.INSTANCE;
        } else if (from instanceof YotiDocsExpiredSessionError) {
            ydsFailureType = YdsFailureType.SessionExpired.INSTANCE;
        } else {
            ydsFailureType = from instanceof YotiDocsUnauthorizedSessionError ? true : from instanceof YotiDocsSessionNotFoundError ? true : from instanceof YotiDocsSessionNotReadyError ? YdsFailureType.SessionError.INSTANCE : f7491a ? YdsFailureType.TechnicalProblem.INSTANCE : YdsFailureType.SomethingWentWrong.INSTANCE;
        }
        return new YdsFailure(ydsFailureType, f7491a, from);
    }
}
