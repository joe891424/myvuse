package io.ktor.utils.p098io.jvm.javaio;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: Pollers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\r\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lio/ktor/utils/io/jvm/javaio/Parking;", ExifInterface.GPS_DIRECTION_TRUE, "", "park", "", "timeNanos", "", "token", "()Ljava/lang/Object;", "unpark", "(Ljava/lang/Object;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface Parking<T> {
    void park(long timeNanos);

    T token();

    void unpark(T token);
}
