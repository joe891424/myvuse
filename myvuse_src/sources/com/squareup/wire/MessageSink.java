package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: compiled from: MessageSink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/squareup/wire/MessageSink;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/io/Closeable;", "cancel", "", "write", "message", "(Ljava/lang/Object;)V", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public interface MessageSink<T> extends Closeable {
    void cancel() throws IOException;

    void write(T message) throws IOException;
}
