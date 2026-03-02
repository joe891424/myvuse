package com.squareup.wire;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.wire.Message;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: compiled from: AnyMessage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0017J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u001f\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, m5598d2 = {"Lcom/squareup/wire/AnyMessage;", "Lcom/squareup/wire/Message;", "", "typeUrl", "", "value", "Lokio/ByteString;", "(Ljava/lang/String;Lokio/ByteString;)V", "getTypeUrl", "()Ljava/lang/String;", "getValue", "()Lokio/ByteString;", "copy", "equals", "", "other", "", "hashCode", "", "newBuilder", "toString", "unpack", ExifInterface.GPS_DIRECTION_TRUE, "adapter", "Lcom/squareup/wire/ProtoAdapter;", "(Lcom/squareup/wire/ProtoAdapter;)Ljava/lang/Object;", "unpackOrNull", "Companion", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
public final class AnyMessage extends Message {
    public static final ProtoAdapter<AnyMessage> ADAPTER;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String typeUrl;
    private final ByteString value;

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return (Message.Builder) m6742newBuilder();
    }

    public final String getTypeUrl() {
        return this.typeUrl;
    }

    public /* synthetic */ AnyMessage(String str, ByteString byteString, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? ByteString.EMPTY : byteString);
    }

    public final ByteString getValue() {
        return this.value;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnyMessage(String typeUrl, ByteString value) {
        super(ADAPTER, ByteString.EMPTY);
        Intrinsics.checkNotNullParameter(typeUrl, "typeUrl");
        Intrinsics.checkNotNullParameter(value, "value");
        this.typeUrl = typeUrl;
        this.value = value;
    }

    public final <T> T unpack(ProtoAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (!Intrinsics.areEqual(this.typeUrl, adapter.getTypeUrl())) {
            throw new IllegalStateException(("type mismatch: " + this.typeUrl + " != " + adapter.getTypeUrl()).toString());
        }
        return adapter.decode(this.value);
    }

    public final <T> T unpackOrNull(ProtoAdapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (Intrinsics.areEqual(this.typeUrl, adapter.getTypeUrl())) {
            return adapter.decode(this.value);
        }
        return null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Shouldn't be used in Kotlin")
    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* synthetic */ Void m6742newBuilder() {
        throw new AssertionError();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AnyMessage)) {
            return false;
        }
        AnyMessage anyMessage = (AnyMessage) other;
        return Intrinsics.areEqual(this.typeUrl, anyMessage.typeUrl) && Intrinsics.areEqual(this.value, anyMessage.value);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = (((i * 37) + this.typeUrl.hashCode()) * 37) + this.value.hashCode();
        this.hashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return "Any{type_url=" + this.typeUrl + ", value=" + this.value + '}';
    }

    public static /* synthetic */ AnyMessage copy$default(AnyMessage anyMessage, String str, ByteString byteString, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anyMessage.typeUrl;
        }
        if ((i & 2) != 0) {
            byteString = anyMessage.value;
        }
        return anyMessage.copy(str, byteString);
    }

    public final AnyMessage copy(String typeUrl, ByteString value) {
        Intrinsics.checkNotNullParameter(typeUrl, "typeUrl");
        Intrinsics.checkNotNullParameter(value, "value");
        return new AnyMessage(typeUrl, value);
    }

    /* JADX INFO: compiled from: AnyMessage.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/squareup/wire/AnyMessage$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/squareup/wire/AnyMessage;", "pack", "message", "Lcom/squareup/wire/Message;", "wire-runtime"}, m5599k = 1, m5600mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnyMessage pack(Message<?, ?> message) {
            Intrinsics.checkNotNullParameter(message, "message");
            String typeUrl = message.adapter().getTypeUrl();
            if (typeUrl == null) {
                throw new IllegalStateException(("recompile " + Reflection.getOrCreateKotlinClass(message.getClass()) + " to use it with AnyMessage").toString());
            }
            return new AnyMessage(typeUrl, message.encodeByteString());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AnyMessage.class);
        final String str = "type.googleapis.com/google.protobuf.Any";
        final Syntax syntax = Syntax.PROTO_3;
        ADAPTER = new ProtoAdapter<AnyMessage>(fieldEncoding, orCreateKotlinClass, str, syntax) { // from class: com.squareup.wire.AnyMessage$Companion$ADAPTER$1
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AnyMessage value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return ProtoAdapter.STRING.encodedSizeWithTag(1, value.getTypeUrl()) + ProtoAdapter.BYTES.encodedSizeWithTag(2, value.getValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, AnyMessage value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTypeUrl());
                ProtoAdapter.BYTES.encodeWithTag(writer, 2, value.getValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AnyMessage decode(ProtoReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                ByteString byteStringDecode = ByteString.EMPTY;
                long jBeginMessage = reader.beginMessage();
                String strDecode = "";
                while (true) {
                    int iNextTag = reader.nextTag();
                    if (iNextTag == -1) {
                        reader.endMessageAndGetUnknownFields(jBeginMessage);
                        return new AnyMessage(strDecode, byteStringDecode);
                    }
                    if (iNextTag == 1) {
                        strDecode = ProtoAdapter.STRING.decode(reader);
                    } else if (iNextTag == 2) {
                        byteStringDecode = ProtoAdapter.BYTES.decode(reader);
                    } else {
                        reader.readUnknownField(iNextTag);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AnyMessage redact(AnyMessage value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new AnyMessage("square.github.io/wire/redacted", ByteString.EMPTY);
            }
        };
    }
}
