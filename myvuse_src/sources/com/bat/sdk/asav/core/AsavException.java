package com.bat.sdk.asav.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsavException.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00060\u0002j\u0002`\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00060\u0002j\u0002`\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavException;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "status", "Lcom/bat/sdk/asav/core/AsavStatus;", "wrappedException", "<init>", "(Lcom/bat/sdk/asav/core/AsavStatus;Ljava/lang/Exception;)V", "getStatus", "()Lcom/bat/sdk/asav/core/AsavStatus;", "getWrappedException", "()Ljava/lang/Exception;", "Ljava/lang/Exception;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavException extends Exception {
    private final AsavStatus status;
    private final Exception wrappedException;

    public AsavException(AsavStatus status, Exception wrappedException) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(wrappedException, "wrappedException");
        this.status = status;
        this.wrappedException = wrappedException;
    }

    public final AsavStatus getStatus() {
        return this.status;
    }

    public final Exception getWrappedException() {
        return this.wrappedException;
    }
}
