package com.squareup.wire.internal;

import kotlin.Metadata;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0080\f¨\u0006\u0005"}, m5598d2 = {"and", "", "", "other", "shl", "wire-runtime"}, m5599k = 2, m5600mv = {1, 4, 0})
public final class RuntimeUtils {
    public static final int and(byte b, int i) {
        return b & i;
    }

    public static final int shl(byte b, int i) {
        return b << i;
    }
}
