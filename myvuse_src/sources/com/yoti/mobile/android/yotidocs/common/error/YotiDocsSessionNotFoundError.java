package com.yoti.mobile.android.yotidocs.common.error;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsSessionNotFoundError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class YotiDocsSessionNotFoundError extends YotiDocsError {

    /* JADX INFO: renamed from: b */
    private final Throwable f7496b;

    /* JADX WARN: Multi-variable type inference failed */
    public YotiDocsSessionNotFoundError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public YotiDocsSessionNotFoundError(Throwable th) {
        super(th, false, 2, null);
        this.f7496b = th;
    }

    public /* synthetic */ YotiDocsSessionNotFoundError(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th);
    }

    public static /* synthetic */ YotiDocsSessionNotFoundError copy$default(YotiDocsSessionNotFoundError yotiDocsSessionNotFoundError, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = yotiDocsSessionNotFoundError.f7496b;
        }
        return yotiDocsSessionNotFoundError.copy(th);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Throwable getF7496b() {
        return this.f7496b;
    }

    public final YotiDocsSessionNotFoundError copy(Throwable error) {
        return new YotiDocsSessionNotFoundError(error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof YotiDocsSessionNotFoundError) && Intrinsics.areEqual(this.f7496b, ((YotiDocsSessionNotFoundError) other).f7496b);
    }

    public final Throwable getError() {
        return this.f7496b;
    }

    public int hashCode() {
        Throwable th = this.f7496b;
        if (th == null) {
            return 0;
        }
        return th.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "YotiDocsSessionNotFoundError(error=" + this.f7496b + ')';
    }
}
