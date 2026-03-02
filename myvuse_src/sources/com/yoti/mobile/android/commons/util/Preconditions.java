package com.yoti.mobile.android.commons.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: Preconditions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, m5598d2 = {"", "condition", "", "errorMessage", "", "checkArgument", "(ZLjava/lang/Object;)V", "checkState", "commons-utils_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class Preconditions {
    public static final void checkArgument(boolean z, Object obj) {
        if (z) {
        } else {
            throw new IllegalArgumentException(obj != null ? obj.toString() : null);
        }
    }

    public static /* synthetic */ void checkArgument$default(boolean z, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        checkArgument(z, obj);
    }

    public static final void checkState(boolean z, Object obj) {
        if (z) {
        } else {
            throw new IllegalStateException(obj != null ? obj.toString() : null);
        }
    }

    public static /* synthetic */ void checkState$default(boolean z, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        checkState(z, obj);
    }
}
