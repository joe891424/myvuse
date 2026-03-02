package com.squareup.wire.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: JsonFormatter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/squareup/wire/internal/JsonFormatter;", ExifInterface.LONGITUDE_WEST, "", "fromString", "value", "", "(Ljava/lang/String;)Ljava/lang/Object;", "toStringOrNumber", "(Ljava/lang/Object;)Ljava/lang/Object;", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public interface JsonFormatter<W> {
    W fromString(String value);

    Object toStringOrNumber(W value);
}
