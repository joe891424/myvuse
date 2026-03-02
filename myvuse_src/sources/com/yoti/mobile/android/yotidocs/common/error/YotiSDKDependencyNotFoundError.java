package com.yoti.mobile.android.yotidocs.common.error;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YotiSDKDependencyNotFoundError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "error", "", "(Ljava/lang/Throwable;)V", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class YotiSDKDependencyNotFoundError extends YotiDocsError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YotiSDKDependencyNotFoundError(Throwable error) {
        super(error, false, 2, null);
        Intrinsics.checkNotNullParameter(error, "error");
    }
}
