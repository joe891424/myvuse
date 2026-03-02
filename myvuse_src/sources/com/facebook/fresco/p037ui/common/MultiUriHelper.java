package com.facebook.fresco.p037ui.common;

import android.net.Uri;
import com.facebook.common.internal.InterfaceC1689Fn;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MultiUriHelper {
    @Nullable
    public static <T> Uri getMainUri(@Nullable T t, @Nullable T t2, @Nullable T[] tArr, InterfaceC1689Fn<T, Uri> interfaceC1689Fn) {
        T t3;
        Uri uriApply;
        Uri uriApply2;
        if (t != null && (uriApply2 = interfaceC1689Fn.apply(t)) != null) {
            return uriApply2;
        }
        if (tArr != null && tArr.length > 0 && (t3 = tArr[0]) != null && (uriApply = interfaceC1689Fn.apply(t3)) != null) {
            return uriApply;
        }
        if (t2 != null) {
            return interfaceC1689Fn.apply(t2);
        }
        return null;
    }
}
