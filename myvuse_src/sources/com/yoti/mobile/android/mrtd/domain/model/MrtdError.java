package com.yoti.mobile.android.mrtd.domain.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/domain/model/MrtdError;", "", "isFatal", "", "(Ljava/lang/String;IZ)V", "()Z", "BAD_AUTH", "INVALID_DATA", "CHIP_LOST", "OTHER", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum MrtdError {
    BAD_AUTH(true),
    INVALID_DATA(true),
    CHIP_LOST(false),
    OTHER(false);

    private final boolean isFatal;

    MrtdError(boolean z) {
        this.isFatal = z;
    }

    /* JADX INFO: renamed from: isFatal, reason: from getter */
    public final boolean getIsFatal() {
        return this.isFatal;
    }
}
