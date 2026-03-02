package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: compiled from: MessageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/squareup/wire/MessageSource;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/io/Closeable;", "read", "()Ljava/lang/Object;", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public interface MessageSource<T> extends Closeable {
    T read() throws IOException;
}
