package com.yoti.mobile.android.yotidocs.common.error;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001b\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006\u0082\u0001\r\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "", "error", "isRetryAllowed", "", "(Ljava/lang/Throwable;Z)V", "()Z", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsNoNetworkError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsNetworkError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsSessionNotFoundError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsSessionNotReadyError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsUnauthorizedSessionError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsExpiredSessionError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsServerError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsUnexpectedError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsUnprocessableMediaError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiSdkIncompatibleError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiSdkResourceLockedError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiSDKDependencyNotFoundError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsFeatureError;", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class YotiDocsError extends Throwable {

    /* JADX INFO: renamed from: a */
    private final boolean f7491a;

    private YotiDocsError(Throwable th, boolean z) {
        super(th);
        this.f7491a = z;
    }

    public /* synthetic */ YotiDocsError(Throwable th, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? false : z, null);
    }

    public /* synthetic */ YotiDocsError(Throwable th, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, z);
    }

    /* JADX INFO: renamed from: isRetryAllowed, reason: from getter */
    public final boolean getF7491a() {
        return this.f7491a;
    }
}
