package io.ktor.utils.p098io.core.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Require.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, m5598d2 = {"require", "", "condition", "", "message", "Lkotlin/Function0;", "", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class RequireKt {
    public static final void require(boolean z, final Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (z) {
            return;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.internal.RequireKt$require$m$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(message.invoke());
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }
}
