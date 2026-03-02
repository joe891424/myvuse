package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.core.internal.RequireFailureCapture;
import java.io.EOFException;
import kotlin.Metadata;

/* JADX INFO: renamed from: io.ktor.utils.io.core.BufferPrimitivesKt$readExact$lambda-56$$inlined$require$1, reason: invalid class name */
/* JADX INFO: compiled from: Require.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, m5598d2 = {"io/ktor/utils/io/core/internal/RequireKt$require$m$1", "Lio/ktor/utils/io/core/internal/RequireFailureCapture;", "doFail", "", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class BufferPrimitivesKt$readExact$lambda56$$inlined$require$1 extends RequireFailureCapture {
    final /* synthetic */ String $name$inlined;
    final /* synthetic */ int $size$inlined;

    public BufferPrimitivesKt$readExact$lambda56$$inlined$require$1(String str, int i) {
        this.$name$inlined = str;
        this.$size$inlined = i;
    }

    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
    public Void doFail() throws EOFException {
        throw new EOFException("Not enough bytes to read a " + this.$name$inlined + " of size " + this.$size$inlined + '.');
    }
}
