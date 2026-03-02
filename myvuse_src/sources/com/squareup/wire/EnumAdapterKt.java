package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.wire.ProtoAdapter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnumAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u0080\b¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u0002H\u0080\b¢\u0006\u0002\u0010\n\u001a \u0010\u000b\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u0002H\u0080\b¢\u0006\u0002\u0010\f\u001aC\u0010\r\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0012H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, m5598d2 = {"commonEncode", "", ExifInterface.LONGITUDE_EAST, "Lcom/squareup/wire/WireEnum;", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/WireEnum;)V", "commonEncodedSize", "", "(Lcom/squareup/wire/WireEnum;)I", "commonRedact", "(Lcom/squareup/wire/WireEnum;)Lcom/squareup/wire/WireEnum;", "commonDecode", "Lcom/squareup/wire/EnumAdapter;", "reader", "Lcom/squareup/wire/ProtoReader;", "fromValue", "Lkotlin/Function1;", "(Lcom/squareup/wire/EnumAdapter;Lcom/squareup/wire/ProtoReader;Lkotlin/jvm/functions/Function1;)Lcom/squareup/wire/WireEnum;", "wire-runtime"}, m5599k = 2, m5600mv = {1, 4, 0})
public final class EnumAdapterKt {
    public static final <E extends WireEnum> int commonEncodedSize(E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ProtoWriter.INSTANCE.varint32Size$wire_runtime(value.getValue());
    }

    public static final <E extends WireEnum> void commonEncode(ProtoWriter writer, E value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        writer.writeVarint32(value.getValue());
    }

    public static final <E extends WireEnum> E commonDecode(EnumAdapter<E> commonDecode, ProtoReader reader, Function1<? super Integer, ? extends E> fromValue) throws IOException {
        Intrinsics.checkNotNullParameter(commonDecode, "$this$commonDecode");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(fromValue, "fromValue");
        int varint32 = reader.readVarint32();
        E eInvoke = fromValue.invoke(Integer.valueOf(varint32));
        if (eInvoke != null) {
            return eInvoke;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(varint32, commonDecode.getType());
    }

    public static final <E extends WireEnum> E commonRedact(E value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException();
    }
}
