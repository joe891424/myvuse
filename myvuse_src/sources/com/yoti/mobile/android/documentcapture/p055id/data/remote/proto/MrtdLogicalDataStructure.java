package com.yoti.mobile.android.documentcapture.p055id.data.remote.proto;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class MrtdLogicalDataStructure extends AndroidMessage<MrtdLogicalDataStructure, Builder> {
    public static final ProtoAdapter<MrtdLogicalDataStructure> ADAPTER;
    public static final Parcelable.Creator<MrtdLogicalDataStructure> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.yoti.docpubapi_v1.MrtdLogicalDataStructure$FileEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<FileEntry> files;

    public static final class Builder extends Message.Builder<MrtdLogicalDataStructure, Builder> {
        public List<FileEntry> files = Internal.newMutableList();

        public Builder files(List<FileEntry> list) {
            Internal.checkElementsNotNull(list);
            this.files = list;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public MrtdLogicalDataStructure build() {
            return new MrtdLogicalDataStructure(this.files, super.buildUnknownFields());
        }
    }

    public static final class FileEntry extends AndroidMessage<FileEntry, Builder> {
        public static final ProtoAdapter<FileEntry> ADAPTER;
        public static final Parcelable.Creator<FileEntry> CREATOR;
        public static final ByteString DEFAULT_FILE;
        public static final Integer DEFAULT_KEY;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.REQUIRED, tag = 2)
        public final ByteString file;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 1)
        public final Integer key;

        public static final class Builder extends Message.Builder<FileEntry, Builder> {
            public ByteString file;
            public Integer key;

            public Builder file(ByteString byteString) {
                this.file = byteString;
                return this;
            }

            public Builder key(Integer num) {
                this.key = num;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            public FileEntry build() {
                Integer num = this.key;
                if (num == null || this.file == null) {
                    throw Internal.missingRequiredFields(num, "key", this.file, "file");
                }
                return new FileEntry(this.key, this.file, super.buildUnknownFields());
            }
        }

        private static final class ProtoAdapter_FileEntry extends ProtoAdapter<FileEntry> {
            ProtoAdapter_FileEntry() {
                super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) FileEntry.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FileEntry decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long jBeginMessage = protoReader.beginMessage();
                while (true) {
                    int iNextTag = protoReader.nextTag();
                    if (iNextTag == -1) {
                        protoReader.endMessage(jBeginMessage);
                        return builder.build();
                    }
                    if (iNextTag == 1) {
                        builder.key(ProtoAdapter.INT32.decode(protoReader));
                    } else if (iNextTag != 2) {
                        FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.getNextFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.file(ProtoAdapter.BYTES.decode(protoReader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, FileEntry fileEntry) throws IOException {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, fileEntry.key);
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 2, fileEntry.file);
                protoWriter.writeBytes(fileEntry.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(FileEntry fileEntry) {
                return ProtoAdapter.INT32.encodedSizeWithTag(1, fileEntry.key) + ProtoAdapter.BYTES.encodedSizeWithTag(2, fileEntry.file) + fileEntry.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public FileEntry redact(FileEntry fileEntry) throws IOException {
                Builder builderNewBuilder = fileEntry.newBuilder();
                builderNewBuilder.clearUnknownFields();
                return builderNewBuilder.build();
            }
        }

        static {
            ProtoAdapter_FileEntry protoAdapter_FileEntry = new ProtoAdapter_FileEntry();
            ADAPTER = protoAdapter_FileEntry;
            CREATOR = AndroidMessage.newCreator(protoAdapter_FileEntry);
            DEFAULT_KEY = 0;
            DEFAULT_FILE = ByteString.EMPTY;
        }

        public FileEntry(Integer num, ByteString byteString) {
            this(num, byteString, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileEntry)) {
                return false;
            }
            FileEntry fileEntry = (FileEntry) obj;
            return unknownFields().equals(fileEntry.unknownFields()) && this.key.equals(fileEntry.key) && this.file.equals(fileEntry.file);
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int iHashCode = (((unknownFields().hashCode() * 37) + this.key.hashCode()) * 37) + this.file.hashCode();
            this.hashCode = iHashCode;
            return iHashCode;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(", key=").append(this.key);
            sb.append(", file=").append(this.file);
            return sb.replace(0, 2, "FileEntry{").append('}').toString();
        }

        public FileEntry(Integer num, ByteString byteString, ByteString byteString2) {
            super(ADAPTER, byteString2);
            this.key = num;
            this.file = byteString;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() throws IOException {
            Builder builder = new Builder();
            builder.key = this.key;
            builder.file = this.file;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    private static final class ProtoAdapter_MrtdLogicalDataStructure extends ProtoAdapter<MrtdLogicalDataStructure> {
        ProtoAdapter_MrtdLogicalDataStructure() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MrtdLogicalDataStructure.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MrtdLogicalDataStructure decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag != 1) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.getNextFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.files.add(FileEntry.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, MrtdLogicalDataStructure mrtdLogicalDataStructure) throws IOException {
            FileEntry.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, mrtdLogicalDataStructure.files);
            protoWriter.writeBytes(mrtdLogicalDataStructure.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(MrtdLogicalDataStructure mrtdLogicalDataStructure) {
            return FileEntry.ADAPTER.asRepeated().encodedSizeWithTag(1, mrtdLogicalDataStructure.files) + mrtdLogicalDataStructure.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public MrtdLogicalDataStructure redact(MrtdLogicalDataStructure mrtdLogicalDataStructure) throws IOException {
            Builder builderNewBuilder = mrtdLogicalDataStructure.newBuilder();
            Internal.redactElements(builderNewBuilder.files, FileEntry.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_MrtdLogicalDataStructure protoAdapter_MrtdLogicalDataStructure = new ProtoAdapter_MrtdLogicalDataStructure();
        ADAPTER = protoAdapter_MrtdLogicalDataStructure;
        CREATOR = AndroidMessage.newCreator(protoAdapter_MrtdLogicalDataStructure);
    }

    public MrtdLogicalDataStructure(List<FileEntry> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MrtdLogicalDataStructure)) {
            return false;
        }
        MrtdLogicalDataStructure mrtdLogicalDataStructure = (MrtdLogicalDataStructure) obj;
        return unknownFields().equals(mrtdLogicalDataStructure.unknownFields()) && this.files.equals(mrtdLogicalDataStructure.files);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = (unknownFields().hashCode() * 37) + this.files.hashCode();
        this.hashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.files.isEmpty()) {
            sb.append(", files=").append(this.files);
        }
        return sb.replace(0, 2, "MrtdLogicalDataStructure{").append('}').toString();
    }

    public MrtdLogicalDataStructure(List<FileEntry> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.files = Internal.immutableCopyOf("files", list);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() throws IOException {
        Builder builder = new Builder();
        builder.files = Internal.copyOf("files", this.files);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
