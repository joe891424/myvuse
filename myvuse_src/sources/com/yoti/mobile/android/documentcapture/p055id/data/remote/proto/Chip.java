package com.yoti.mobile.android.documentcapture.p055id.data.remote.proto;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class Chip extends AndroidMessage<Chip, Builder> {
    public static final ProtoAdapter<Chip> ADAPTER;
    public static final Parcelable.Creator<Chip> CREATOR;
    public static final ByteString DEFAULT_PAYLOAD;
    public static final Type DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 2)
    public final ByteString payload;

    @WireField(adapter = "com.yoti.docregpubapi_v1.Chip$Type#ADAPTER", tag = 1)
    public final Type type;

    public static final class Builder extends Message.Builder<Chip, Builder> {
        public ByteString payload;
        public Type type;

        public Builder payload(ByteString byteString) {
            this.payload = byteString;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Chip build() {
            return new Chip(this.type, this.payload, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Chip extends ProtoAdapter<Chip> {
        ProtoAdapter_Chip() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Chip.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Chip decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    try {
                        builder.type(Type.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                        builder.addUnknownField(iNextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                    }
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.getNextFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.payload(ProtoAdapter.BYTES.decode(protoReader));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Chip chip) throws IOException {
            Type type = chip.type;
            if (type != null) {
                Type.ADAPTER.encodeWithTag(protoWriter, 1, type);
            }
            ByteString byteString = chip.payload;
            if (byteString != null) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 2, byteString);
            }
            protoWriter.writeBytes(chip.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Chip chip) {
            Type type = chip.type;
            int iEncodedSizeWithTag = type != null ? Type.ADAPTER.encodedSizeWithTag(1, type) : 0;
            ByteString byteString = chip.payload;
            return iEncodedSizeWithTag + (byteString != null ? ProtoAdapter.BYTES.encodedSizeWithTag(2, byteString) : 0) + chip.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Chip redact(Chip chip) throws IOException {
            Builder builderNewBuilder = chip.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    public enum Type implements WireEnum {
        UNDEFINED(0),
        MRTD_LDS(1);

        public static final ProtoAdapter<Type> ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type fromValue(int i) {
            if (i == 0) {
                return UNDEFINED;
            }
            if (i != 1) {
                return null;
            }
            return MRTD_LDS;
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    static {
        ProtoAdapter_Chip protoAdapter_Chip = new ProtoAdapter_Chip();
        ADAPTER = protoAdapter_Chip;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Chip);
        DEFAULT_TYPE = Type.UNDEFINED;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public Chip(Type type, ByteString byteString) {
        this(type, byteString, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Chip)) {
            return false;
        }
        Chip chip = (Chip) obj;
        return unknownFields().equals(chip.unknownFields()) && Internal.equals(this.type, chip.type) && Internal.equals(this.payload, chip.payload);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Type type = this.type;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 37;
        ByteString byteString = this.payload;
        int iHashCode3 = iHashCode2 + (byteString != null ? byteString.hashCode() : 0);
        this.hashCode = iHashCode3;
        return iHashCode3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=").append(this.type);
        }
        if (this.payload != null) {
            sb.append(", payload=").append(this.payload);
        }
        return sb.replace(0, 2, "Chip{").append('}').toString();
    }

    public Chip(Type type, ByteString byteString, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.type = type;
        this.payload = byteString;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() throws IOException {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.payload = this.payload;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
