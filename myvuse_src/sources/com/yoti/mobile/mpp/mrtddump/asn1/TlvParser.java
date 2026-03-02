package com.yoti.mobile.mpp.mrtddump.asn1;

import com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.ByteReadPacketExtensionsKt;
import io.ktor.utils.p098io.core.Input;
import io.ktor.utils.p098io.core.InputArraysKt;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.e, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u0012J\b\u0010\u0013\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/asn1/TlvParser;", "", "parent", "Lcom/yoti/mobile/mpp/mrtddump/asn1/TlvObject;", "(Lcom/yoti/mobile/mpp/mrtddump/asn1/TlvObject;)V", "input", "", "([B)V", "stream", "Lio/ktor/utils/io/core/ByteReadPacket;", "buildObject", "Lcom/yoti/mobile/mpp/mrtddump/asn1/PartialTlvObject;", HeaderParameterNames.AUTHENTICATION_TAG, "", "length", "readLength", "readObject", "readObjects", "", "readTagNumber", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TlvParser {

    /* JADX INFO: renamed from: a */
    private final ByteReadPacket f8038a;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.e$a */
    @Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, m5598d2 = {"<anonymous>", "Lcom/yoti/mobile/mpp/mrtddump/asn1/PartialTlvObject;", "invoke"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    static final class a extends Lambda implements Function0<PartialTlvObject> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PartialTlvObject invoke() {
            return TlvParser.this.m5447b();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.e$b */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¨\u0006\u0005"}, m5598d2 = {"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "io/ktor/utils/io/core/ByteReadPacketExtensionsKt$ByteReadPacket$1", "io/ktor/utils/io/core/ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class b extends Lambda implements Function1<ByteBuffer, Unit> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ byte[] f8040a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(byte[] bArr) {
            super(1);
            this.f8040a = bArr;
        }

        /* JADX INFO: renamed from: a */
        public final void m5450a(ByteBuffer it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
            m5450a(byteBuffer);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TlvParser(TlvObject parent) {
        this(parent.getF8037b());
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public TlvParser(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(input, 0, input.length);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(array, offset, length)");
        this.f8038a = ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap, new b(input));
    }

    /* JADX INFO: renamed from: a */
    private final int m5444a() throws MrtdUnexpectedDataFormatException {
        int iM5452b = C5089f.m5452b(this.f8038a);
        if (iM5452b < 0) {
            throw new MrtdUnexpectedDataFormatException("Invalid TLV: EOF found when length expected", null, 2, null);
        }
        if (iM5452b == 128) {
            return -1;
        }
        if (iM5452b <= 127) {
            return iM5452b;
        }
        int i = iM5452b & 127;
        if (i > 4) {
            throw new MrtdUnexpectedDataFormatException(Intrinsics.stringPlus("Invalid TLV: DER length more than 4 bytes: ", Integer.valueOf(i)), null, 2, null);
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            i3++;
            int iM5452b2 = C5089f.m5452b(this.f8038a);
            if (iM5452b2 < 0) {
                throw new MrtdUnexpectedDataFormatException("Invalid TLV: EOF found reading length", null, 2, null);
            }
            i2 = (i2 << 8) + iM5452b2;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw new MrtdUnexpectedDataFormatException("Invalid TLV: negative length found", null, 2, null);
    }

    /* JADX INFO: renamed from: a */
    private final PartialTlvObject m5445a(int i, int i2) {
        byte[] bArrSliceArray = new byte[i2];
        int available$default = InputArraysKt.readAvailable$default((Input) this.f8038a, bArrSliceArray, 0, 0, 6, (Object) null);
        if (available$default >= 0 && available$default < i2) {
            bArrSliceArray = ArraysKt.sliceArray(bArrSliceArray, RangesKt.until(0, available$default));
        }
        return new PartialTlvObject(i, i2, bArrSliceArray);
    }

    /* JADX INFO: renamed from: d */
    private final int m5446d() throws MrtdUnexpectedDataFormatException {
        int i;
        int iM5452b;
        int iM5452b2 = C5089f.m5452b(this.f8038a);
        if (iM5452b2 <= 0) {
            return -1;
        }
        if ((iM5452b2 & 31) != 31) {
            return iM5452b2;
        }
        while (true) {
            i = iM5452b2 << 8;
            iM5452b = C5089f.m5452b(this.f8038a);
            if (iM5452b < 0 || (iM5452b & 128) == 0) {
                break;
            }
            iM5452b2 = i | (iM5452b & 127);
        }
        if (iM5452b >= 0) {
            return i | (iM5452b & 127);
        }
        throw new MrtdUnexpectedDataFormatException("Invalid TLV: EOF found inside tag value.", null, 2, null);
    }

    /* JADX INFO: renamed from: b */
    public final PartialTlvObject m5447b() throws MrtdUnexpectedDataFormatException {
        int iM5446d = m5446d();
        if (iM5446d < 0) {
            return null;
        }
        int iM5444a = m5444a();
        if (iM5444a >= 0) {
            return m5445a(iM5446d, iM5444a);
        }
        throw new MrtdUnexpectedDataFormatException("Invalid TLV: indefinite-length primitive encoding encountered", null, 2, null);
    }

    /* JADX INFO: renamed from: c */
    public final Map<Integer, PartialTlvObject> m5448c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (PartialTlvObject partialTlvObject : SequencesKt.generateSequence(new a())) {
            linkedHashMap.put(Integer.valueOf(partialTlvObject.getF8036a()), partialTlvObject);
        }
        return linkedHashMap;
    }
}
