package org.koin.android.error;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MissingAndroidContextException.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lorg/koin/android/error/MissingAndroidContextException;", "", "s", "", "(Ljava/lang/String;)V", "koin-android_release"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class MissingAndroidContextException extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingAndroidContextException(String s) {
        super(s);
        Intrinsics.checkParameterIsNotNull(s, "s");
    }
}
