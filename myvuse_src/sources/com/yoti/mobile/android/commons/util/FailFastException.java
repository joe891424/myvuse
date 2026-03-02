package com.yoti.mobile.android.commons.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FailFast.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B!\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/util/FailFastException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "message", "", "error", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "commons-utils_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class FailFastException extends RuntimeException {
    /* JADX WARN: Multi-variable type inference failed */
    public FailFastException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FailFastException(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ FailFastException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
    }

    public FailFastException(String str, Throwable th) {
        super(str, th);
    }
}
