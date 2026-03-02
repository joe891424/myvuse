package com.yoti.mobile.android.yotidocs.common.error;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsFeatureError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "error", "", "isRetryAllowed", "", "(Ljava/lang/Throwable;Z)V", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class YotiDocsFeatureError extends YotiDocsError {
    /* JADX WARN: Multi-variable type inference failed */
    public YotiDocsFeatureError() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public YotiDocsFeatureError(Throwable th, boolean z) {
        super(th, z, null);
    }

    public /* synthetic */ YotiDocsFeatureError(Throwable th, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th, (i & 2) != 0 ? false : z);
    }
}
