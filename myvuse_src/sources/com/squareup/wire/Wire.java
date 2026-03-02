package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: Wire.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0004\n\u0002\b\u0006\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\u0010\u0002\u001a\u0004\u0018\u0001H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"get", ExifInterface.GPS_DIRECTION_TRUE, "value", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "wire-runtime"}, m5599k = 2, m5600mv = {1, 4, 0})
public final class Wire {
    public static final <T> T get(T t, T t2) {
        return t != null ? t : t2;
    }
}
