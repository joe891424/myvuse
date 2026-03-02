package com.yoti.mobile.android.commons.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FailFast.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0007¨\u0006\b"}, m5598d2 = {"", "message", "", "error", "", "failFast", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "commons-utils_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class FailFast {
    public static final void failFast() {
        failFast$default(null, null, 3, null);
    }

    public static final void failFast(String str) {
        failFast$default(str, null, 2, null);
    }

    public static final void failFast(String str, Throwable th) {
        throw new FailFastException(str, th);
    }

    public static /* synthetic */ void failFast$default(String str, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            th = null;
        }
        failFast(str, th);
    }

    public static final void failFast(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        throw new FailFastException(null, error, 1, null);
    }
}
