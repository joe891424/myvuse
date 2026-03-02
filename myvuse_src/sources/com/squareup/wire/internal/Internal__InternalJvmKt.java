package com.squareup.wire.internal;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalJvm.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\u001a,\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\b0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"'\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, m5598d2 = {"identityOrNull", ExifInterface.LONGITUDE_EAST, "Lcom/squareup/wire/WireEnum;", "Ljava/lang/Class;", "getIdentityOrNull", "(Ljava/lang/Class;)Lcom/squareup/wire/WireEnum;", "redactElements", "", ExifInterface.GPS_DIRECTION_TRUE, "list", "Ljava/util/List;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "map", "Ljava/util/Map;", "wire-runtime"}, m5599k = 5, m5600mv = {1, 4, 0}, m5603xs = "com/squareup/wire/internal/Internal")
final /* synthetic */ class Internal__InternalJvmKt {
    public static final <T> void redactElements(List<T> list, ProtoAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, adapter.redact(list.get(i)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void redactElements(Map<?, T> map, ProtoAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        for (Map.Entry entry : map.entrySet()) {
            entry.setValue(adapter.redact(entry.getValue()));
        }
    }

    public static final <E extends WireEnum> E getIdentityOrNull(Class<E> identityOrNull) {
        E e;
        Intrinsics.checkNotNullParameter(identityOrNull, "$this$identityOrNull");
        E[] enumConstants = identityOrNull.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, "enumConstants");
        int length = enumConstants.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                e = null;
                break;
            }
            e = enumConstants[i];
            E e2 = e;
            if (e2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.WireEnum");
            }
            if (e2.getValue() == 0) {
                break;
            }
            i++;
        }
        return e;
    }
}
