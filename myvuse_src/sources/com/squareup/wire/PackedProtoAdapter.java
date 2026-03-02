package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: ProtoAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/squareup/wire/PackedProtoAdapter;", ExifInterface.LONGITUDE_EAST, "Lcom/squareup/wire/ProtoAdapter;", "", "originalAdapter", "(Lcom/squareup/wire/ProtoAdapter;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodeWithTag", HeaderParameterNames.AUTHENTICATION_TAG, "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public final class PackedProtoAdapter<E> extends ProtoAdapter<List<? extends E>> {
    private final ProtoAdapter<E> originalAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackedProtoAdapter(ProtoAdapter<E> originalAdapter) {
        super(FieldEncoding.LENGTH_DELIMITED, (KClass<?>) Reflection.getOrCreateKotlinClass(List.class), (String) null, originalAdapter.getSyntax(), CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(originalAdapter, "originalAdapter");
        this.originalAdapter = originalAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public void encodeWithTag(ProtoWriter writer, int tag, List<? extends E> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value == 0 || value.isEmpty()) {
            return;
        }
        super.encodeWithTag(writer, tag, value);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(List<? extends E> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size();
        int iEncodedSize = 0;
        for (int i = 0; i < size; i++) {
            iEncodedSize += this.originalAdapter.encodedSize(value.get(i));
        }
        return iEncodedSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSizeWithTag(int tag, List<? extends E> value) {
        if (value == 0 || value.isEmpty()) {
            return 0;
        }
        return super.encodedSizeWithTag(tag, value);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter writer, List<? extends E> value) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size();
        for (int i = 0; i < size; i++) {
            this.originalAdapter.encode(writer, value.get(i));
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public List<E> decode(ProtoReader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        return CollectionsKt.listOf(this.originalAdapter.decode(reader));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public List<E> redact(List<? extends E> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return CollectionsKt.emptyList();
    }
}
