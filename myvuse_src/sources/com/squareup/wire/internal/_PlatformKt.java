package com.squareup.wire.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: -Platform.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0086\b\u001a1\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\f*\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\f0\rH\u0086\b*\n\u0010\u000e\"\u00020\u000f2\u00020\u000f*\n\u0010\u0010\"\u00020\u00112\u00020\u0011*\n\u0010\u0012\"\u00020\u00132\u00020\u0013*\n\u0010\u0014\"\u00020\u00152\u00020\u0015¨\u0006\u0016"}, m5598d2 = {"camelCase", "", TypedValues.Custom.S_STRING, "upperCamel", "", "toUnmodifiableList", "", ExifInterface.GPS_DIRECTION_TRUE, "", "toUnmodifiableMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "ObjectStreamException", "Ljava/io/ObjectStreamException;", "ProtocolException", "Ljava/net/ProtocolException;", "Serializable", "Ljava/io/Serializable;", "Throws", "Lkotlin/jvm/Throws;", "wire-runtime"}, m5599k = 2, m5600mv = {1, 4, 0})
public final class _PlatformKt {
    public static /* synthetic */ String camelCase$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return camelCase(str, z);
    }

    public static final <T> List<T> toUnmodifiableList(List<T> toUnmodifiableList) {
        Intrinsics.checkNotNullParameter(toUnmodifiableList, "$this$toUnmodifiableList");
        List<T> listUnmodifiableList = Collections.unmodifiableList(toUnmodifiableList);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "Collections.unmodifiableList(this)");
        return listUnmodifiableList;
    }

    public static final <K, V> Map<K, V> toUnmodifiableMap(Map<K, V> toUnmodifiableMap) {
        Intrinsics.checkNotNullParameter(toUnmodifiableMap, "$this$toUnmodifiableMap");
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(toUnmodifiableMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(this)");
        return mapUnmodifiableMap;
    }

    public static final String camelCase(String string, boolean z) {
        Intrinsics.checkNotNullParameter(string, "string");
        StringBuilder sb = new StringBuilder(string.length());
        int iCharCount = 0;
        while (iCharCount < string.length()) {
            int iCodePointAt = string.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            if (iCodePointAt == 95) {
                z = true;
            } else {
                if (z && 97 <= iCodePointAt && 122 >= iCodePointAt) {
                    iCodePointAt -= 32;
                }
                sb.appendCodePoint(iCodePointAt);
                z = false;
            }
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder(capacity).…builderAction).toString()");
        return string2;
    }
}
