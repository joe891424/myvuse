package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: ProtoAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J.\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J&\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016J(\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lcom/squareup/wire/MapProtoAdapter;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/squareup/wire/ProtoAdapter;", "", "keyAdapter", "valueAdapter", "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoAdapter;)V", "entryAdapter", "Lcom/squareup/wire/MapEntryProtoAdapter;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodeWithTag", HeaderParameterNames.AUTHENTICATION_TAG, "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, ? extends V>> {
    private final MapEntryProtoAdapter<K, V> entryAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapProtoAdapter(ProtoAdapter<K> keyAdapter, ProtoAdapter<V> valueAdapter) {
        super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(Map.class), (String) null, valueAdapter.getSyntax(), MapsKt.emptyMap());
        Intrinsics.checkNotNullParameter(keyAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(valueAdapter, "valueAdapter");
        this.entryAdapter = new MapEntryProtoAdapter<>(keyAdapter, valueAdapter);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSizeWithTag(int tag, Map<K, ? extends V> value) {
        int iEncodedSizeWithTag = 0;
        if (value == null) {
            return 0;
        }
        Iterator<Map.Entry<K, ? extends V>> it2 = value.entrySet().iterator();
        while (it2.hasNext()) {
            iEncodedSizeWithTag += this.entryAdapter.encodedSizeWithTag(tag, it2.next());
        }
        return iEncodedSizeWithTag;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter writer, Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(ProtoWriter writer, int tag, Map<K, ? extends V> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == null) {
            return;
        }
        Iterator<Map.Entry<K, ? extends V>> it2 = value.entrySet().iterator();
        while (it2.hasNext()) {
            this.entryAdapter.encodeWithTag(writer, tag, it2.next());
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map<K, V> decode(ProtoReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        long jBeginMessage = reader.beginMessage();
        K kDecode = null;
        V vDecode = null;
        while (true) {
            int iNextTag = reader.nextTag();
            if (iNextTag == -1) {
                break;
            }
            if (iNextTag == 1) {
                kDecode = this.entryAdapter.getKeyAdapter$wire_runtime().decode(reader);
            } else if (iNextTag == 2) {
                vDecode = this.entryAdapter.getValueAdapter$wire_runtime().decode(reader);
            }
        }
        reader.endMessageAndGetUnknownFields(jBeginMessage);
        if (!(kDecode != null)) {
            throw new IllegalStateException("Map entry with null key".toString());
        }
        if (!(vDecode != null)) {
            throw new IllegalStateException("Map entry with null value".toString());
        }
        return MapsKt.mapOf(TuplesKt.m5605to(kDecode, vDecode));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public Map<K, V> redact(Map<K, ? extends V> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return MapsKt.emptyMap();
    }
}
