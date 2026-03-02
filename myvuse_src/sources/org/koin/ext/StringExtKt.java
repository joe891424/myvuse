package org.koin.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StringExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, m5598d2 = {"quoted", "", "koin-core"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class StringExtKt {
    public static final String quoted(String quoted) {
        Intrinsics.checkParameterIsNotNull(quoted, "$this$quoted");
        return StringsKt.replace$default(quoted, "\"", "", false, 4, (Object) null);
    }
}
