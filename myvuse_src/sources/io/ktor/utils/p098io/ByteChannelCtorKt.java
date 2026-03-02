package io.ktor.utils.p098io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.utils.p098io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: ByteChannelCtor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\f\b\u0002\u0010\r\u001a\u00060\u000ej\u0002`\u000f\"\u001a\u0010\u0000\u001a\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, m5598d2 = {"EmptyByteReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "getEmptyByteReadChannel$annotations", "()V", "getEmptyByteReadChannel", "()Lio/ktor/utils/io/ByteReadChannel;", "ByteReadChannel", "content", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "text", "", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteChannelCtorKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use ByteReadChannel.Empty instead", replaceWith = @ReplaceWith(expression = "ByteReadChannel.Empty", imports = {}))
    public static /* synthetic */ void getEmptyByteReadChannel$annotations() {
    }

    public static final ByteReadChannel ByteReadChannel(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return ByteChannelKt.ByteReadChannel(content, 0, content.length);
    }

    public static final ByteReadChannel ByteReadChannel(byte[] content, int i) {
        Intrinsics.checkNotNullParameter(content, "content");
        return ByteChannelKt.ByteReadChannel(content, i, content.length);
    }

    public static /* synthetic */ ByteReadChannel ByteReadChannel$default(String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return ByteReadChannel(str, charset);
    }

    public static final ByteReadChannel getEmptyByteReadChannel() {
        return ByteReadChannel.INSTANCE.getEmpty();
    }

    public static final ByteReadChannel ByteReadChannel(String text, Charset charset) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        return ByteReadChannel(CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, text, 0, text.length()));
    }
}
