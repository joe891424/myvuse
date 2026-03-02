package io.ktor.utils.p098io.core.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Numbers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0081\b¨\u0006\b"}, m5598d2 = {"failLongToIntConversion", "", "value", "", "name", "", "toIntOrFail", "", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class NumbersKt {
    public static final int toIntOrFail(long j, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (j < 2147483647L) {
            return (int) j;
        }
        failLongToIntConversion(j, name);
        throw new KotlinNothingValueException();
    }

    public static final Void failLongToIntConversion(long j, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        throw new IllegalArgumentException("Long value " + j + " of " + name + " doesn't fit into 32-bit integer");
    }
}
