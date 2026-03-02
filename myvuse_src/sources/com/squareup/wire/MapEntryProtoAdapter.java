package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ProtoAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0016"}, m5598d2 = {"Lcom/squareup/wire/MapEntryProtoAdapter;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/squareup/wire/ProtoAdapter;", "", "keyAdapter", "valueAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "getKeyAdapter$wire_runtime", "()Lcom/squareup/wire/ProtoAdapter;", "getValueAdapter$wire_runtime", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<? extends K, ? extends V>> {
    private final ProtoAdapter<K> keyAdapter;
    private final ProtoAdapter<V> valueAdapter;

    public final ProtoAdapter<K> getKeyAdapter$wire_runtime() {
        return this.keyAdapter;
    }

    public final ProtoAdapter<V> getValueAdapter$wire_runtime() {
        return this.valueAdapter;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapEntryProtoAdapter(ProtoAdapter<K> keyAdapter, ProtoAdapter<V> valueAdapter) {
        super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(Map.Entry.class), (String) null, valueAdapter.getSyntax());
        Intrinsics.checkNotNullParameter(keyAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(valueAdapter, "valueAdapter");
        this.keyAdapter = keyAdapter;
        this.valueAdapter = valueAdapter;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(Map.Entry<? extends K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.keyAdapter.encodedSizeWithTag(1, value.getKey()) + this.valueAdapter.encodedSizeWithTag(2, value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter writer, Map.Entry<? extends K, ? extends V> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        this.keyAdapter.encodeWithTag(writer, 1, value.getKey());
        this.valueAdapter.encodeWithTag(writer, 2, value.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map.Entry<K, V> decode(ProtoReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map.Entry<K, V> redact(Map.Entry<? extends K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException();
    }
}
