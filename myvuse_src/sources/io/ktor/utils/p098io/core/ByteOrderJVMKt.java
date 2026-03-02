package io.ktor.utils.p098io.core;

import java.nio.ByteOrder;
import kotlin.Metadata;

/* JADX INFO: compiled from: ByteOrderJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, m5598d2 = {"orderOf", "Lio/ktor/utils/io/core/ByteOrder;", "nioOrder", "Ljava/nio/ByteOrder;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteOrderJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteOrder orderOf(ByteOrder byteOrder) {
        return byteOrder == ByteOrder.BIG_ENDIAN ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
    }
}
