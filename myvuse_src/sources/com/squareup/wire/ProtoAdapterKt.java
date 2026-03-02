package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import com.squareup.wire.WireField;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Utf8;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: ProtoAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0000\u001a\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0000\u001a\u0012\u0010\u000b\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u0005H\u0000\u001a\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0000\u001a\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005H\u0000\u001a\u0012\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0016j\u0002`\u00170\u0005H\u0000\u001a\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001aC\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001d0\u001b0\u0005\"\u0004\b\u0000\u0010\u001c\"\u0004\b\u0001\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0005H\u0080\b\u001a\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005H\u0000\u001a\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010'0\u0005H\u0000\u001a\u001a\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0002\b\u0003\u0018\u00010\u001b0\u0005H\u0000\u001a\u0010\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0005H\u0000\u001a\u0010\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0005H\u0000\u001a\u001c\u0010-\u001a\u00020%\"\u0004\b\u0000\u0010.2\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u00100\u001a\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0000\u001a0\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H40\u0005\"\b\b\u0000\u00104*\u00020,2\f\u00105\u001a\b\u0012\u0004\u0012\u0002H40\u00052\u0006\u00106\u001a\u00020%H\u0000\u001a%\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0'0\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u0005H\u0080\b\u001a%\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H.0'0\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u0005H\u0080\b\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010:\u001a\u00020;H\u0080\b¢\u0006\u0002\u0010<\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010=\u001a\u00020>H\u0080\b¢\u0006\u0002\u0010?\u001a&\u00109\u001a\u0002H.\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010:\u001a\u00020\bH\u0080\b¢\u0006\u0002\u0010@\u001a&\u0010A\u001a\u00020;\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u0010B\u001a.\u0010A\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010C\u001a\u00020D2\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u0010E\u001a&\u0010F\u001a\u00020\b\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010/\u001a\u0002H.H\u0080\b¢\u0006\u0002\u0010G\u001a8\u0010H\u001a\u00020\u000f\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\u0080\b¢\u0006\u0002\u0010L\u001a0\u0010M\u001a\u00020\u0001\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010K\u001a\u00020\u00012\b\u0010/\u001a\u0004\u0018\u0001H.H\u0080\b¢\u0006\u0002\u0010N\u001a%\u0010O\u001a\u0006\u0012\u0002\b\u00030\u0005\"\u0004\b\u0000\u0010.*\b\u0012\u0004\u0012\u0002H.0\u00052\u0006\u0010P\u001a\u00020QH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006R"}, m5598d2 = {"FIXED_32_SIZE", "", "FIXED_64_SIZE", "FIXED_BOOL_SIZE", "commonBool", "Lcom/squareup/wire/ProtoAdapter;", "", "commonBytes", "Lokio/ByteString;", "commonDouble", "", "commonDuration", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "commonEmpty", "", "commonFixed32", "commonFixed64", "", "commonFloat", "", "commonInstant", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "commonInt32", "commonInt64", "commonNewMapAdapter", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "keyAdapter", "valueAdapter", "commonSfixed32", "commonSfixed64", "commonSint32", "commonSint64", "commonString", "", "commonStructList", "", "commonStructMap", "commonStructNull", "", "commonStructValue", "", "commonToString", ExifInterface.LONGITUDE_EAST, "value", "(Ljava/lang/Object;)Ljava/lang/String;", "commonUint32", "commonUint64", "commonWrapper", ExifInterface.GPS_DIRECTION_TRUE, "delegate", "typeUrl", "commonCreatePacked", "commonCreateRepeated", "commonDecode", "bytes", "", "(Lcom/squareup/wire/ProtoAdapter;[B)Ljava/lang/Object;", "source", "Lokio/BufferedSource;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSource;)Ljava/lang/Object;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)Ljava/lang/Object;", "commonEncode", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)[B", "sink", "Lokio/BufferedSink;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/BufferedSink;Ljava/lang/Object;)V", "commonEncodeByteString", "(Lcom/squareup/wire/ProtoAdapter;Ljava/lang/Object;)Lokio/ByteString;", "commonEncodeWithTag", "writer", "Lcom/squareup/wire/ProtoWriter;", HeaderParameterNames.AUTHENTICATION_TAG, "(Lcom/squareup/wire/ProtoAdapter;Lcom/squareup/wire/ProtoWriter;ILjava/lang/Object;)V", "commonEncodedSizeWithTag", "(Lcom/squareup/wire/ProtoAdapter;ILjava/lang/Object;)I", "commonWithLabel", Constants.ScionAnalytics.PARAM_LABEL, "Lcom/squareup/wire/WireField$Label;", "wire-runtime"}, m5599k = 2, m5600mv = {1, 4, 0})
public final class ProtoAdapterKt {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;

    public static final <E> int commonEncodedSizeWithTag(ProtoAdapter<E> commonEncodedSizeWithTag, int i, E e) {
        Intrinsics.checkNotNullParameter(commonEncodedSizeWithTag, "$this$commonEncodedSizeWithTag");
        if (e == null) {
            return 0;
        }
        int iEncodedSize = commonEncodedSizeWithTag.encodedSize(e);
        if (commonEncodedSizeWithTag.getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
            iEncodedSize += ProtoWriter.INSTANCE.varint32Size$wire_runtime(iEncodedSize);
        }
        return iEncodedSize + ProtoWriter.INSTANCE.tagSize$wire_runtime(i);
    }

    public static final <E> void commonEncodeWithTag(ProtoAdapter<E> commonEncodeWithTag, ProtoWriter writer, int i, E e) throws IOException {
        Intrinsics.checkNotNullParameter(commonEncodeWithTag, "$this$commonEncodeWithTag");
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (e == null) {
            return;
        }
        writer.writeTag(i, commonEncodeWithTag.getFieldEncoding());
        if (commonEncodeWithTag.getFieldEncoding() == FieldEncoding.LENGTH_DELIMITED) {
            writer.writeVarint32(commonEncodeWithTag.encodedSize(e));
        }
        commonEncodeWithTag.encode(writer, e);
    }

    public static final <E> void commonEncode(ProtoAdapter<E> commonEncode, BufferedSink sink, E e) throws IOException {
        Intrinsics.checkNotNullParameter(commonEncode, "$this$commonEncode");
        Intrinsics.checkNotNullParameter(sink, "sink");
        commonEncode.encode(new ProtoWriter(sink), e);
    }

    public static final <E> byte[] commonEncode(ProtoAdapter<E> commonEncode, E e) throws IOException {
        Intrinsics.checkNotNullParameter(commonEncode, "$this$commonEncode");
        Buffer buffer = new Buffer();
        commonEncode.encode(buffer, e);
        return buffer.readByteArray();
    }

    public static final <E> ByteString commonEncodeByteString(ProtoAdapter<E> commonEncodeByteString, E e) throws IOException {
        Intrinsics.checkNotNullParameter(commonEncodeByteString, "$this$commonEncodeByteString");
        Buffer buffer = new Buffer();
        commonEncodeByteString.encode(buffer, e);
        return buffer.readByteString();
    }

    public static final <E> E commonDecode(ProtoAdapter<E> commonDecode, byte[] bytes) {
        Intrinsics.checkNotNullParameter(commonDecode, "$this$commonDecode");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return commonDecode.decode(new Buffer().write(bytes));
    }

    public static final <E> E commonDecode(ProtoAdapter<E> commonDecode, ByteString bytes) {
        Intrinsics.checkNotNullParameter(commonDecode, "$this$commonDecode");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return commonDecode.decode(new Buffer().write(bytes));
    }

    public static final <E> E commonDecode(ProtoAdapter<E> commonDecode, BufferedSource source) {
        Intrinsics.checkNotNullParameter(commonDecode, "$this$commonDecode");
        Intrinsics.checkNotNullParameter(source, "source");
        return commonDecode.decode(new ProtoReader(source));
    }

    public static final <E> String commonToString(E e) {
        return String.valueOf(e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> ProtoAdapter<?> commonWithLabel(ProtoAdapter<E> commonWithLabel, WireField.Label label) {
        Intrinsics.checkNotNullParameter(commonWithLabel, "$this$commonWithLabel");
        Intrinsics.checkNotNullParameter(label, "label");
        return label.isRepeated() ? label.isPacked() ? commonWithLabel.asPacked() : commonWithLabel.asRepeated() : commonWithLabel;
    }

    public static final <E> ProtoAdapter<List<E>> commonCreatePacked(ProtoAdapter<E> commonCreatePacked) {
        Intrinsics.checkNotNullParameter(commonCreatePacked, "$this$commonCreatePacked");
        if (!(commonCreatePacked.getFieldEncoding() != FieldEncoding.LENGTH_DELIMITED)) {
            throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
        }
        return new PackedProtoAdapter(commonCreatePacked);
    }

    public static final <E> ProtoAdapter<List<E>> commonCreateRepeated(ProtoAdapter<E> commonCreateRepeated) {
        Intrinsics.checkNotNullParameter(commonCreateRepeated, "$this$commonCreateRepeated");
        return new RepeatedProtoAdapter(commonCreateRepeated);
    }

    public static final <K, V> ProtoAdapter<Map<K, V>> commonNewMapAdapter(ProtoAdapter<K> keyAdapter, ProtoAdapter<V> valueAdapter) {
        Intrinsics.checkNotNullParameter(keyAdapter, "keyAdapter");
        Intrinsics.checkNotNullParameter(valueAdapter, "valueAdapter");
        return new MapProtoAdapter(keyAdapter, valueAdapter);
    }

    public static final ProtoAdapter<Boolean> commonBool() {
        return new ProtoAdapter<Boolean>(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Boolean.TYPE), null, Syntax.PROTO_2, false) { // from class: com.squareup.wire.ProtoAdapterKt.commonBool.1
            public int encodedSize(boolean value) {
                return 1;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Boolean bool) throws IOException {
                encode(protoWriter, bool.booleanValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Boolean bool) {
                return encodedSize(bool.booleanValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Boolean redact(Boolean bool) {
                return redact(bool.booleanValue());
            }

            public void encode(ProtoWriter writer, boolean value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(value ? 1 : 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Boolean decode(ProtoReader reader) throws IOException {
                boolean z;
                Intrinsics.checkNotNullParameter(reader, "reader");
                int varint32 = reader.readVarint32();
                if (varint32 != 0) {
                    z = true;
                    if (varint32 != 1) {
                        StringBuilder sb = new StringBuilder("Invalid boolean value 0x");
                        String string = Integer.toString(varint32, CharsKt.checkRadix(16));
                        Intrinsics.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                        throw new IOException(sb.append(StringsKt.padStart(string, 2, '0')).toString());
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            public Boolean redact(boolean value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Integer> commonInt32() {
        return new ProtoAdapter<Integer>(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), null, Syntax.PROTO_2, 0) { // from class: com.squareup.wire.ProtoAdapterKt.commonInt32.1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            public int encodedSize(int value) {
                return ProtoWriter.INSTANCE.int32Size$wire_runtime(value);
            }

            public void encode(ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeSignedVarint32$wire_runtime(value);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readVarint32());
            }

            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Integer> commonUint32() {
        return new ProtoAdapter<Integer>(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), null, Syntax.PROTO_2, 0) { // from class: com.squareup.wire.ProtoAdapterKt.commonUint32.1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            public int encodedSize(int value) {
                return ProtoWriter.INSTANCE.varint32Size$wire_runtime(value);
            }

            public void encode(ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(value);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readVarint32());
            }

            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Integer> commonSint32() {
        return new ProtoAdapter<Integer>(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Integer.TYPE), null, Syntax.PROTO_2, 0) { // from class: com.squareup.wire.ProtoAdapterKt.commonSint32.1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            public int encodedSize(int value) {
                return ProtoWriter.INSTANCE.varint32Size$wire_runtime(ProtoWriter.INSTANCE.encodeZigZag32$wire_runtime(value));
            }

            public void encode(ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(ProtoWriter.INSTANCE.encodeZigZag32$wire_runtime(value));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(ProtoWriter.INSTANCE.decodeZigZag32$wire_runtime(reader.readVarint32()));
            }

            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Integer> commonFixed32() {
        return new ProtoAdapter<Integer>(FieldEncoding.FIXED32, Reflection.getOrCreateKotlinClass(Integer.TYPE), null, Syntax.PROTO_2, 0) { // from class: com.squareup.wire.ProtoAdapterKt.commonFixed32.1
            public int encodedSize(int value) {
                return 4;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Integer num) throws IOException {
                encode(protoWriter, num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Integer num) {
                return encodedSize(num.intValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Integer redact(Integer num) {
                return redact(num.intValue());
            }

            public void encode(ProtoWriter writer, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed32(value);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Integer decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Integer.valueOf(reader.readFixed32());
            }

            public Integer redact(int value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Integer> commonSfixed32() {
        return commonFixed32();
    }

    public static final ProtoAdapter<Long> commonInt64() {
        return new ProtoAdapter<Long>(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), null, Syntax.PROTO_2, 0L) { // from class: com.squareup.wire.ProtoAdapterKt.commonInt64.1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l) throws IOException {
                encode(protoWriter, l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }

            public int encodedSize(long value) {
                return ProtoWriter.INSTANCE.varint64Size$wire_runtime(value);
            }

            public void encode(ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(value);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readVarint64());
            }

            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Long> commonUint64() {
        return new ProtoAdapter<Long>(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), null, Syntax.PROTO_2, 0L) { // from class: com.squareup.wire.ProtoAdapterKt.commonUint64.1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l) throws IOException {
                encode(protoWriter, l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }

            public int encodedSize(long value) {
                return ProtoWriter.INSTANCE.varint64Size$wire_runtime(value);
            }

            public void encode(ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(value);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readVarint64());
            }

            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Long> commonSint64() {
        return new ProtoAdapter<Long>(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Long.TYPE), null, Syntax.PROTO_2, 0L) { // from class: com.squareup.wire.ProtoAdapterKt.commonSint64.1
            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l) throws IOException {
                encode(protoWriter, l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }

            public int encodedSize(long value) {
                return ProtoWriter.INSTANCE.varint64Size$wire_runtime(ProtoWriter.INSTANCE.encodeZigZag64$wire_runtime(value));
            }

            public void encode(ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint64(ProtoWriter.INSTANCE.encodeZigZag64$wire_runtime(value));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(ProtoWriter.INSTANCE.decodeZigZag64$wire_runtime(reader.readVarint64()));
            }

            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Long> commonFixed64() {
        return new ProtoAdapter<Long>(FieldEncoding.FIXED64, Reflection.getOrCreateKotlinClass(Long.TYPE), null, Syntax.PROTO_2, 0L) { // from class: com.squareup.wire.ProtoAdapterKt.commonFixed64.1
            public int encodedSize(long value) {
                return 8;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Long l) throws IOException {
                encode(protoWriter, l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Long l) {
                return encodedSize(l.longValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Long redact(Long l) {
                return redact(l.longValue());
            }

            public void encode(ProtoWriter writer, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed64(value);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Long decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return Long.valueOf(reader.readFixed64());
            }

            public Long redact(long value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Long> commonSfixed64() {
        return commonFixed64();
    }

    public static final ProtoAdapter<Float> commonFloat() {
        return new ProtoAdapter<Float>(FieldEncoding.FIXED32, Reflection.getOrCreateKotlinClass(Float.TYPE), null, Syntax.PROTO_2, Float.valueOf(0.0f)) { // from class: com.squareup.wire.ProtoAdapterKt.commonFloat.1
            public int encodedSize(float value) {
                return 4;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Float f) throws IOException {
                encode(protoWriter, f.floatValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Float f) {
                return encodedSize(f.floatValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Float redact(Float f) {
                return redact(f.floatValue());
            }

            public void encode(ProtoWriter writer, float value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed32(Float.floatToIntBits(value));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Float decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                return Float.valueOf(Float.intBitsToFloat(reader.readFixed32()));
            }

            public Float redact(float value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Double> commonDouble() {
        return new ProtoAdapter<Double>(FieldEncoding.FIXED64, Reflection.getOrCreateKotlinClass(Double.TYPE), null, Syntax.PROTO_2, Double.valueOf(0.0d)) { // from class: com.squareup.wire.ProtoAdapterKt.commonDouble.1
            public int encodedSize(double value) {
                return 8;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Double d) throws IOException {
                encode(protoWriter, d.doubleValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Double d) {
                return encodedSize(d.doubleValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Double redact(Double d) {
                return redact(d.doubleValue());
            }

            public void encode(ProtoWriter writer, double value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeFixed64(Double.doubleToLongBits(value));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Double decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
                return Double.valueOf(Double.longBitsToDouble(reader.readFixed64()));
            }

            public Double redact(double value) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<String> commonString() {
        return new ProtoAdapter<String>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(String.class), null, Syntax.PROTO_2, "") { // from class: com.squareup.wire.ProtoAdapterKt.commonString.1
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return (int) Utf8.size$default(value, 0, 0, 3, null);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, String value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.writeString(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public String decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return reader.readString();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public String redact(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<ByteString> commonBytes() {
        return new ProtoAdapter<ByteString>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ByteString.class), null, Syntax.PROTO_2, ByteString.EMPTY) { // from class: com.squareup.wire.ProtoAdapterKt.commonBytes.1
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ByteString value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value.size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, ByteString value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.writeBytes(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ByteString decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                return reader.readBytes();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ByteString redact(ByteString value) {
                Intrinsics.checkNotNullParameter(value, "value");
                throw new UnsupportedOperationException();
            }
        };
    }

    public static final ProtoAdapter<Duration> commonDuration() {
        return new ProtoAdapter<Duration>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Duration.class), "type.googleapis.com/google.protobuf.Duration", Syntax.PROTO_3) { // from class: com.squareup.wire.ProtoAdapterKt.commonDuration.1
            @Override // com.squareup.wire.ProtoAdapter
            public Duration redact(Duration value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Duration value) {
                Intrinsics.checkNotNullParameter(value, "value");
                long sameSignSeconds = getSameSignSeconds(value);
                int iEncodedSizeWithTag = sameSignSeconds != 0 ? ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(sameSignSeconds)) : 0;
                int sameSignNanos = getSameSignNanos(value);
                return sameSignNanos != 0 ? iEncodedSizeWithTag + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(sameSignNanos)) : iEncodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, Duration value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                long sameSignSeconds = getSameSignSeconds(value);
                if (sameSignSeconds != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(sameSignSeconds));
                }
                int sameSignNanos = getSameSignNanos(value);
                if (sameSignNanos != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(sameSignNanos));
                }
            }

            private final long getSameSignSeconds(Duration duration) {
                return (duration.getSeconds() >= 0 || duration.getNano() == 0) ? duration.getSeconds() : duration.getSeconds() + 1;
            }

            private final int getSameSignNanos(Duration duration) {
                return (duration.getSeconds() >= 0 || duration.getNano() == 0) ? duration.getNano() : duration.getNano() - 1000000000;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Duration decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long jBeginMessage = reader.beginMessage();
                long jLongValue = 0;
                int iIntValue = 0;
                while (true) {
                    int iNextTag = reader.nextTag();
                    if (iNextTag == -1) {
                        reader.endMessageAndGetUnknownFields(jBeginMessage);
                        Duration durationOfSeconds = Duration.ofSeconds(jLongValue, iIntValue);
                        Intrinsics.checkNotNullExpressionValue(durationOfSeconds, "Duration.ofSeconds(seconds, nano)");
                        return durationOfSeconds;
                    }
                    if (iNextTag == 1) {
                        jLongValue = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (iNextTag == 2) {
                        iIntValue = ProtoAdapter.INT32.decode(reader).intValue();
                    } else {
                        reader.readUnknownField(iNextTag);
                    }
                }
            }
        };
    }

    public static final ProtoAdapter<Instant> commonInstant() {
        return new ProtoAdapter<Instant>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Instant.class), "type.googleapis.com/google.protobuf.Timestamp", Syntax.PROTO_3) { // from class: com.squareup.wire.ProtoAdapterKt.commonInstant.1
            @Override // com.squareup.wire.ProtoAdapter
            public Instant redact(Instant value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return value;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Instant value) {
                Intrinsics.checkNotNullParameter(value, "value");
                long epochSecond = value.getEpochSecond();
                int iEncodedSizeWithTag = epochSecond != 0 ? ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(epochSecond)) : 0;
                int nano = value.getNano();
                return nano != 0 ? iEncodedSizeWithTag + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(nano)) : iEncodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, Instant value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                long epochSecond = value.getEpochSecond();
                if (epochSecond != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(epochSecond));
                }
                int nano = value.getNano();
                if (nano != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(nano));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Instant decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long jBeginMessage = reader.beginMessage();
                long jLongValue = 0;
                int iIntValue = 0;
                while (true) {
                    int iNextTag = reader.nextTag();
                    if (iNextTag == -1) {
                        reader.endMessageAndGetUnknownFields(jBeginMessage);
                        Instant instantOfEpochSecond = Instant.ofEpochSecond(jLongValue, iIntValue);
                        Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, "Instant.ofEpochSecond(epochSecond, nano)");
                        return instantOfEpochSecond;
                    }
                    if (iNextTag == 1) {
                        jLongValue = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (iNextTag == 2) {
                        iIntValue = ProtoAdapter.INT32.decode(reader).intValue();
                    } else {
                        reader.readUnknownField(iNextTag);
                    }
                }
            }
        };
    }

    public static final ProtoAdapter<Unit> commonEmpty() {
        return new ProtoAdapter<Unit>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Unit.class), "type.googleapis.com/google.protobuf.Empty", Syntax.PROTO_3) { // from class: com.squareup.wire.ProtoAdapterKt.commonEmpty.1
            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, Unit value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Unit value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return 0;
            }

            /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
            public void redact2(Unit value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Unit decode(ProtoReader protoReader) throws IOException {
                decode2(protoReader);
                return Unit.INSTANCE;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Unit redact(Unit unit) {
                redact2(unit);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
            public void decode2(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long jBeginMessage = reader.beginMessage();
                while (true) {
                    int iNextTag = reader.nextTag();
                    if (iNextTag != -1) {
                        reader.readUnknownField(iNextTag);
                    } else {
                        reader.endMessageAndGetUnknownFields(jBeginMessage);
                        return;
                    }
                }
            }
        };
    }

    public static final ProtoAdapter<Map<String, ?>> commonStructMap() {
        return new ProtoAdapter<Map<String, ?>>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Map.class), "type.googleapis.com/google.protobuf.Struct", Syntax.PROTO_3) { // from class: com.squareup.wire.ProtoAdapterKt.commonStructMap.1
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Map<String, ?> value) {
                int iTagSize$wire_runtime = 0;
                if (value == null) {
                    return 0;
                }
                for (Map.Entry<String, ?> entry : value.entrySet()) {
                    int iEncodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, entry.getKey()) + ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(2, entry.getValue());
                    iTagSize$wire_runtime += ProtoWriter.INSTANCE.tagSize$wire_runtime(1) + ProtoWriter.INSTANCE.varint32Size$wire_runtime(iEncodedSizeWithTag) + iEncodedSizeWithTag;
                }
                return iTagSize$wire_runtime;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, Map<String, ?> value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    return;
                }
                for (Map.Entry<String, ?> entry : value.entrySet()) {
                    String key = entry.getKey();
                    Object value2 = entry.getValue();
                    int iEncodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, key) + ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(2, value2);
                    writer.writeTag(1, FieldEncoding.LENGTH_DELIMITED);
                    writer.writeVarint32(iEncodedSizeWithTag);
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, key);
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(writer, 2, value2);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Map<String, ?> decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                long jBeginMessage = reader.beginMessage();
                while (true) {
                    int iNextTag = reader.nextTag();
                    if (iNextTag == -1) {
                        reader.endMessageAndGetUnknownFields(jBeginMessage);
                        return linkedHashMap;
                    }
                    if (iNextTag != 1) {
                        reader.skip();
                    } else {
                        String strDecode = null;
                        long jBeginMessage2 = reader.beginMessage();
                        Object objDecode = null;
                        while (true) {
                            int iNextTag2 = reader.nextTag();
                            if (iNextTag2 == -1) {
                                break;
                            }
                            if (iNextTag2 == 1) {
                                strDecode = ProtoAdapter.STRING.decode(reader);
                            } else if (iNextTag2 == 2) {
                                objDecode = ProtoAdapter.STRUCT_VALUE.decode(reader);
                            } else {
                                reader.readUnknownField(iNextTag2);
                            }
                        }
                        reader.endMessageAndGetUnknownFields(jBeginMessage2);
                        if (strDecode != null) {
                            Intrinsics.checkNotNull(strDecode);
                            linkedHashMap.put(strDecode, objDecode);
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Map<String, Object> redact(Map<String, ?> value) {
                if (value == null) {
                    return null;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(value.size()));
                Iterator<T> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    linkedHashMap.put(entry.getKey(), ProtoAdapter.STRUCT_VALUE.redact(entry));
                }
                return linkedHashMap;
            }
        };
    }

    public static final ProtoAdapter<List<?>> commonStructList() {
        return new ProtoAdapter<List<?>>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Map.class), "type.googleapis.com/google.protobuf.ListValue", Syntax.PROTO_3) { // from class: com.squareup.wire.ProtoAdapterKt.commonStructList.1
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(List<?> value) {
                int iEncodedSizeWithTag = 0;
                if (value == null) {
                    return 0;
                }
                Iterator<?> it2 = value.iterator();
                while (it2.hasNext()) {
                    iEncodedSizeWithTag += ProtoAdapter.STRUCT_VALUE.encodedSizeWithTag(1, it2.next());
                }
                return iEncodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, List<?> value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    return;
                }
                Iterator<?> it2 = value.iterator();
                while (it2.hasNext()) {
                    ProtoAdapter.STRUCT_VALUE.encodeWithTag(writer, 1, it2.next());
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public List<?> decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long jBeginMessage = reader.beginMessage();
                while (true) {
                    int iNextTag = reader.nextTag();
                    if (iNextTag == -1) {
                        reader.endMessageAndGetUnknownFields(jBeginMessage);
                        return arrayList;
                    }
                    if (iNextTag != 1) {
                        reader.skip();
                    } else {
                        arrayList.add(ProtoAdapter.STRUCT_VALUE.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public List<Object> redact(List<?> value) {
                if (value == null) {
                    return null;
                }
                List<?> list = value;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(ProtoAdapter.STRUCT_VALUE.redact(it2.next()));
                }
                return arrayList;
            }
        };
    }

    public static final ProtoAdapter commonStructNull() {
        return new ProtoAdapter(FieldEncoding.VARINT, Reflection.getOrCreateKotlinClass(Void.class), "type.googleapis.com/google.protobuf.NullValue", Syntax.PROTO_3) { // from class: com.squareup.wire.ProtoAdapterKt.commonStructNull.1
            @Override // com.squareup.wire.ProtoAdapter
            public Void redact(Void value) {
                return null;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Void value) {
                return ProtoWriter.INSTANCE.varint32Size$wire_runtime(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int tag, Void value) {
                return ProtoWriter.INSTANCE.tagSize$wire_runtime(tag) + ProtoWriter.INSTANCE.varint32Size$wire_runtime(encodedSize(value));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, Void value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeVarint32(0);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(ProtoWriter writer, int tag, Void value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                writer.writeTag(tag, getFieldEncoding());
                encode(writer, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Void decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                int varint32 = reader.readVarint32();
                if (varint32 == 0) {
                    return null;
                }
                throw new IOException("expected 0 but was " + varint32);
            }
        };
    }

    public static final ProtoAdapter<Object> commonStructValue() {
        return new ProtoAdapter<Object>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Object.class), "type.googleapis.com/google.protobuf.Value", Syntax.PROTO_3) { // from class: com.squareup.wire.ProtoAdapterKt.commonStructValue.1
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Object value) {
                if (value == null) {
                    return ProtoAdapter.STRUCT_NULL.encodedSizeWithTag(1, value);
                }
                if (value instanceof Number) {
                    return ProtoAdapter.DOUBLE.encodedSizeWithTag(2, Double.valueOf(((Number) value).doubleValue()));
                }
                if (value instanceof String) {
                    return ProtoAdapter.STRING.encodedSizeWithTag(3, value);
                }
                if (value instanceof Boolean) {
                    return ProtoAdapter.BOOL.encodedSizeWithTag(4, value);
                }
                if (!(value instanceof Map)) {
                    if (value instanceof List) {
                        return ProtoAdapter.STRUCT_LIST.encodedSizeWithTag(6, value);
                    }
                    throw new IllegalArgumentException("unexpected struct value: " + value);
                }
                ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
                if (value != null) {
                    return protoAdapter.encodedSizeWithTag(5, (Map) value);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int tag, Object value) {
                if (value == null) {
                    int iEncodedSize = encodedSize(value);
                    return ProtoWriter.INSTANCE.tagSize$wire_runtime(tag) + ProtoWriter.INSTANCE.varint32Size$wire_runtime(iEncodedSize) + iEncodedSize;
                }
                return super.encodedSizeWithTag(tag, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, Object value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    ProtoAdapter.STRUCT_NULL.encodeWithTag(writer, 1, value);
                    return;
                }
                if (value instanceof Number) {
                    ProtoAdapter.DOUBLE.encodeWithTag(writer, 2, Double.valueOf(((Number) value).doubleValue()));
                    return;
                }
                if (value instanceof String) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value);
                    return;
                }
                if (value instanceof Boolean) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 4, value);
                    return;
                }
                if (!(value instanceof Map)) {
                    if (!(value instanceof List)) {
                        throw new IllegalArgumentException("unexpected struct value: " + value);
                    }
                    ProtoAdapter.STRUCT_LIST.encodeWithTag(writer, 6, value);
                } else {
                    ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
                    if (value == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                    }
                    protoAdapter.encodeWithTag(writer, 5, (Map) value);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(ProtoWriter writer, int tag, Object value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value == null) {
                    writer.writeTag(tag, getFieldEncoding());
                    writer.writeVarint32(encodedSize(value));
                    encode(writer, value);
                    return;
                }
                super.encodeWithTag(writer, tag, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Object redact(Object value) {
                if (value == null) {
                    return ProtoAdapter.STRUCT_NULL.redact(value);
                }
                if (value instanceof Number) {
                    return value;
                }
                if (value instanceof String) {
                    return null;
                }
                if (value instanceof Boolean) {
                    return value;
                }
                if (!(value instanceof Map)) {
                    if (value instanceof List) {
                        return ProtoAdapter.STRUCT_LIST.redact(value);
                    }
                    throw new IllegalArgumentException("unexpected struct value: " + value);
                }
                ProtoAdapter<Map<String, ?>> protoAdapter = ProtoAdapter.STRUCT_MAP;
                if (value != null) {
                    return protoAdapter.redact((Map) value);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Object decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long jBeginMessage = reader.beginMessage();
                Object objDecode = null;
                while (true) {
                    int iNextTag = reader.nextTag();
                    if (iNextTag != -1) {
                        switch (iNextTag) {
                            case 1:
                                objDecode = ProtoAdapter.STRUCT_NULL.decode(reader);
                                break;
                            case 2:
                                objDecode = ProtoAdapter.DOUBLE.decode(reader);
                                break;
                            case 3:
                                objDecode = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 4:
                                objDecode = ProtoAdapter.BOOL.decode(reader);
                                break;
                            case 5:
                                objDecode = ProtoAdapter.STRUCT_MAP.decode(reader);
                                break;
                            case 6:
                                objDecode = ProtoAdapter.STRUCT_LIST.decode(reader);
                                break;
                            default:
                                reader.skip();
                                break;
                        }
                    } else {
                        reader.endMessageAndGetUnknownFields(jBeginMessage);
                        return objDecode;
                    }
                }
            }
        };
    }

    public static final <T> ProtoAdapter<T> commonWrapper(final ProtoAdapter<T> delegate, final String typeUrl) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(typeUrl, "typeUrl");
        return new ProtoAdapter<T>(FieldEncoding.LENGTH_DELIMITED, delegate.getType(), typeUrl, Syntax.PROTO_3, null) { // from class: com.squareup.wire.ProtoAdapterKt.commonWrapper.1
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(T value) {
                if (value == null) {
                    return 0;
                }
                return delegate.encodedSizeWithTag(1, value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, T value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                if (value != null) {
                    delegate.encodeWithTag(writer, 1, value);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public T redact(T value) {
                if (value == null) {
                    return null;
                }
                return (T) delegate.redact(value);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public T decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                long jBeginMessage = reader.beginMessage();
                T t = null;
                while (true) {
                    int iNextTag = reader.nextTag();
                    if (iNextTag == -1) {
                        reader.endMessageAndGetUnknownFields(jBeginMessage);
                        return t;
                    }
                    if (iNextTag == 1) {
                        t = (T) delegate.decode(reader);
                    } else {
                        reader.readUnknownField(iNextTag);
                    }
                }
            }
        };
    }
}
