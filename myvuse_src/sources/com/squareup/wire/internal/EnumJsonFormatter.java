package com.squareup.wire.internal;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireEnumConstant;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.proto.Chip;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: EnumJsonFormatter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/squareup/wire/internal/EnumJsonFormatter;", ExifInterface.LONGITUDE_EAST, "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/internal/JsonFormatter;", "adapter", "Lcom/squareup/wire/EnumAdapter;", "(Lcom/squareup/wire/EnumAdapter;)V", "stringToValue", "", "", "valueToString", "fromString", "value", "(Ljava/lang/String;)Lcom/squareup/wire/WireEnum;", "toStringOrNumber", "(Lcom/squareup/wire/WireEnum;)Ljava/lang/String;", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public final class EnumJsonFormatter<E extends WireEnum> implements JsonFormatter<E> {
    private final Map<String, E> stringToValue;
    private final Map<E, String> valueToString;

    /* JADX WARN: Multi-variable type inference failed */
    public EnumJsonFormatter(EnumAdapter<E> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        KClass<?> type = adapter.getType();
        Intrinsics.checkNotNull(type);
        Class javaClass = JvmClassMappingKt.getJavaClass((KClass) type);
        if (javaClass == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<E>");
        }
        for (Chip.Type type2 : (WireEnum[]) javaClass.getEnumConstants()) {
            if (type2 != 0) {
                String strName = type2.name();
                linkedHashMap.put(strName, type2);
                linkedHashMap.put(String.valueOf(type2.getValue()), type2);
                linkedHashMap2.put(type2, strName);
                WireEnumConstant wireEnumConstant = (WireEnumConstant) javaClass.getDeclaredField(strName).getAnnotation(WireEnumConstant.class);
                if (wireEnumConstant != null && wireEnumConstant.declaredName().length() > 0) {
                    linkedHashMap.put(wireEnumConstant.declaredName(), type2);
                    linkedHashMap2.put(type2, wireEnumConstant.declaredName());
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
            }
        }
        this.stringToValue = linkedHashMap;
        this.valueToString = linkedHashMap2;
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public E fromString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.stringToValue.get(value);
    }

    @Override // com.squareup.wire.internal.JsonFormatter
    public String toStringOrNumber(E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = this.valueToString.get(value);
        Intrinsics.checkNotNull(str);
        return str;
    }
}
