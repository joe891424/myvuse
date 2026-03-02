package io.ktor.utils.p098io.internal.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Errors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¨\u0006\u0007"}, m5598d2 = {"limitChangeError", "", "negativeShiftError", "delta", "", "wrongBufferPositionChangeError", "size", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ErrorsKt {
    public static final Void negativeShiftError(int i) {
        throw new IllegalStateException(Intrinsics.stringPlus("Wrong buffer position change: negative shift ", Integer.valueOf(i)));
    }

    public static final Void limitChangeError() {
        throw new IllegalStateException("Limit change is now allowed");
    }

    public static final Void wrongBufferPositionChangeError(int i, int i2) {
        throw new IllegalStateException("Wrong buffer position change: " + i + ". Position should be moved forward only by at most size bytes (size = " + i2 + ')');
    }
}
