package com.yoti.mobile.android.mrtd.domain;

import com.yoti.mobile.android.mrtd.domain.model.MrtdError;
import com.yoti.mobile.android.mrtd.domain.model.MrtdReadState;
import com.yoti.mobile.android.mrtd.domain.model.StateReadFailed;
import com.yoti.mobile.android.mrtd.domain.model.StateReadFailedFinal;
import com.yoti.mobile.android.mrtd.domain.model.StateTimeout;
import com.yoti.mobile.android.mrtd.domain.model.StateTimeoutFinal;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/MrtdErrorHandler;", "", "()V", "detectErrors", "", "readErrors", "handleDetectError", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "handleDetection", "", "handleReadError", "error", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdError;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdErrorHandler {
    private int detectErrors;
    private int readErrors;

    @Inject
    public MrtdErrorHandler() {
    }

    public final MrtdReadState handleDetectError() {
        int i = this.detectErrors + 1;
        this.detectErrors = i;
        return i > 2 ? StateTimeoutFinal.INSTANCE : StateTimeout.INSTANCE;
    }

    public final void handleDetection() {
        this.detectErrors = 0;
    }

    public final MrtdReadState handleReadError(MrtdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.getIsFatal()) {
            return new StateReadFailedFinal(error);
        }
        int i = this.readErrors + 1;
        this.readErrors = i;
        return i > 2 ? new StateReadFailedFinal(error) : new StateReadFailed(error);
    }
}
