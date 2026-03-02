package com.bat.sdk.ble.helper;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.UCollectionsKt;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: compiled from: BatAdvertiserHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b \u0010\u0013J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\"J\r\u0010#\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u001a¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u001a¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u0003¢\u0006\u0004\b,\u0010\u0013J\u0006\u0010-\u001a\u00020.J#\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u000301j\b\u0012\u0004\u0012\u00020\u0003`02\u0006\u00102\u001a\u00020\u0007¢\u0006\u0002\u00103J\u0006\u00104\u001a\u00020\u0007J\u0013\u00105\u001a\u00020\u0007*\u00020\u001aH\u0002¢\u0006\u0004\b6\u00107J\u0013\u00108\u001a\u00020\u0007*\u00020\u0018H\u0002¢\u0006\u0004\b9\u0010:R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006<"}, m5598d2 = {"Lcom/bat/sdk/ble/helper/BatAdvertiserHelper;", "", "raw", "Lkotlin/UByteArray;", "<init>", "([BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "TAG", "", "HEADER_LEN", "", "CH_LEN", "SEQ_LEN", "NUM_LEN", "DATA_LEN", "PACKET_LEN", "HEADER", "[B", "rawDataPackage", "getRawDataPackage-TcUX1vc", "()[B", "setRawDataPackage-GBYM_sE", "([B)V", "fromValues", "channel", "Lkotlin/UInt;", "seq", "Lkotlin/UByte;", "num", "data", "fromValues-aqvSOvw", "(IBB[B)Lcom/bat/sdk/ble/helper/BatAdvertiserHelper;", "getRaw", "getRaw-TcUX1vc", "getHeader", "", "getChannel", "getChannel-pVg5ArA", "()I", "getSeq", "getSeq-w2LRezQ", "()B", "getNum", "getNum-w2LRezQ", "getData", "getData-TcUX1vc", "isValid", "", "convertData", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "message", "(Ljava/lang/String;)Ljava/util/ArrayList;", "toUUID", "hex8", "hex8-7apg3OU", "(B)Ljava/lang/String;", "hex16", "hex16-WZ4Q5Ns", "(I)Ljava/lang/String;", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class BatAdvertiserHelper {
    private final int CH_LEN;
    private final int DATA_LEN;
    private final byte[] HEADER;
    private final int HEADER_LEN;
    private final int NUM_LEN;
    private final int PACKET_LEN;
    private final int SEQ_LEN;
    private final String TAG;
    private byte[] rawDataPackage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] CHALLENGE_REQ_PAYLOAD = {Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB};
    private static final byte[] SIGNATURE_RES_PAYLOAD_OK = {32, 33, 34, 35, 36, 37, 38, 39};
    private static final byte[] SIGNATURE_RES_PAYLOAD_KO = {48, 49, 50, 51, 52, 53, 54, 55};
    private static final byte[] CHALLENGE_RES_ALREADY_UNLOCKED = {17, Ascii.DLE, Ascii.f3756SI, Ascii.f3757SO, Ascii.f3747CR, Ascii.f3749FF, Ascii.f3760VT, 10};
    private static final byte[] UNLOCK_ACK = {Ascii.CAN, Ascii.f3748EM, Ascii.SUB, Ascii.ESC, Ascii.f3750FS, Ascii.f3751GS, Ascii.f3755RS, Ascii.f3759US};

    public /* synthetic */ BatAdvertiserHelper(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    private BatAdvertiserHelper(byte[] bArr) {
        this.TAG = "BatAdvertiserHelper";
        this.HEADER_LEN = 4;
        this.CH_LEN = 2;
        this.SEQ_LEN = 1;
        this.NUM_LEN = 1;
        this.DATA_LEN = 8;
        int i = 2 + 4;
        int i2 = i + 10;
        this.PACKET_LEN = i2;
        this.HEADER = new byte[]{116, 104, 105, 110};
        byte[] bArrM7303constructorimpl = UByteArray.m7303constructorimpl(i2);
        UArraysKt.m7867fillWpHrYlw(bArrM7303constructorimpl, (byte) 0, 0, i + 9);
        this.rawDataPackage = bArrM7303constructorimpl;
        if (bArr != null) {
            this.rawDataPackage = bArr;
        }
    }

    public /* synthetic */ BatAdvertiserHelper(byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr, null);
    }

    /* JADX INFO: renamed from: getRawDataPackage-TcUX1vc, reason: not valid java name */
    public final byte[] m5890getRawDataPackageTcUX1vc() {
        return this.rawDataPackage;
    }

    /* JADX INFO: renamed from: setRawDataPackage-GBYM_sE, reason: not valid java name */
    public final void m5892setRawDataPackageGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.rawDataPackage = bArr;
    }

    /* JADX INFO: compiled from: BatAdvertiserHelper.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/ble/helper/BatAdvertiserHelper$Companion;", "", "<init>", "()V", "CHALLENGE_REQ_PAYLOAD", "Lkotlin/UByteArray;", "getCHALLENGE_REQ_PAYLOAD-TcUX1vc", "()[B", "[B", "SIGNATURE_RES_PAYLOAD_OK", "getSIGNATURE_RES_PAYLOAD_OK-TcUX1vc", "SIGNATURE_RES_PAYLOAD_KO", "getSIGNATURE_RES_PAYLOAD_KO-TcUX1vc", "CHALLENGE_RES_ALREADY_UNLOCKED", "getCHALLENGE_RES_ALREADY_UNLOCKED-TcUX1vc", "UNLOCK_ACK", "getUNLOCK_ACK-TcUX1vc", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getCHALLENGE_REQ_PAYLOAD-TcUX1vc, reason: not valid java name */
        public final byte[] m5893getCHALLENGE_REQ_PAYLOADTcUX1vc() {
            return BatAdvertiserHelper.CHALLENGE_REQ_PAYLOAD;
        }

        /* JADX INFO: renamed from: getSIGNATURE_RES_PAYLOAD_OK-TcUX1vc, reason: not valid java name */
        public final byte[] m5896getSIGNATURE_RES_PAYLOAD_OKTcUX1vc() {
            return BatAdvertiserHelper.SIGNATURE_RES_PAYLOAD_OK;
        }

        /* JADX INFO: renamed from: getSIGNATURE_RES_PAYLOAD_KO-TcUX1vc, reason: not valid java name */
        public final byte[] m5895getSIGNATURE_RES_PAYLOAD_KOTcUX1vc() {
            return BatAdvertiserHelper.SIGNATURE_RES_PAYLOAD_KO;
        }

        /* JADX INFO: renamed from: getCHALLENGE_RES_ALREADY_UNLOCKED-TcUX1vc, reason: not valid java name */
        public final byte[] m5894getCHALLENGE_RES_ALREADY_UNLOCKEDTcUX1vc() {
            return BatAdvertiserHelper.CHALLENGE_RES_ALREADY_UNLOCKED;
        }

        /* JADX INFO: renamed from: getUNLOCK_ACK-TcUX1vc, reason: not valid java name */
        public final byte[] m5897getUNLOCK_ACKTcUX1vc() {
            return BatAdvertiserHelper.UNLOCK_ACK;
        }
    }

    /* JADX INFO: renamed from: fromValues-aqvSOvw, reason: not valid java name */
    public final BatAdvertiserHelper m5885fromValuesaqvSOvw(int channel, byte seq, byte num, byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.rawDataPackage = UByteArray.m7304constructorimpl(ArraysKt.plus(UByteArray.m7304constructorimpl(ArraysKt.plus(this.HEADER, new byte[]{UByte.m7251constructorimpl((byte) UInt.m7328constructorimpl(channel >>> 8)), UByte.m7251constructorimpl((byte) UInt.m7328constructorimpl(UInt.m7328constructorimpl(channel << 24) >>> 24)), seq, num})), data));
        return this;
    }

    /* JADX INFO: renamed from: getRaw-TcUX1vc, reason: not valid java name and from getter */
    public final byte[] getRawDataPackage() {
        return this.rawDataPackage;
    }

    public final List<UByte> getHeader() {
        return UArraysKt.m8303slicec0bezYM(this.rawDataPackage, new IntRange(0, this.HEADER_LEN - 1));
    }

    /* JADX INFO: renamed from: getChannel-pVg5ArA, reason: not valid java name */
    public final int m5886getChannelpVg5ArA() {
        byte[] bArr = this.rawDataPackage;
        int i = this.HEADER_LEN;
        int iM7328constructorimpl = UInt.m7328constructorimpl(UInt.m7328constructorimpl(UArraysKt.m8303slicec0bezYM(bArr, new IntRange(i, (this.CH_LEN + i) - 1)).get(0).getData() & 255) << 8);
        byte[] bArr2 = this.rawDataPackage;
        int i2 = this.HEADER_LEN;
        return UInt.m7328constructorimpl(iM7328constructorimpl + UInt.m7328constructorimpl(UArraysKt.m8303slicec0bezYM(bArr2, new IntRange(i2, (this.CH_LEN + i2) - 1)).get(1).getData() & 255));
    }

    /* JADX INFO: renamed from: getSeq-w2LRezQ, reason: not valid java name */
    public final byte m5891getSeqw2LRezQ() {
        return UArraysKt.m8303slicec0bezYM(this.rawDataPackage, new IntRange(this.HEADER_LEN + this.CH_LEN, ((r2 + r3) + this.SEQ_LEN) - 1)).get(0).getData();
    }

    /* JADX INFO: renamed from: getNum-w2LRezQ, reason: not valid java name */
    public final byte m5888getNumw2LRezQ() {
        byte[] bArr = this.rawDataPackage;
        int i = this.HEADER_LEN;
        int i2 = this.CH_LEN;
        return UArraysKt.m8303slicec0bezYM(bArr, new IntRange(i + i2 + this.SEQ_LEN, (((i + i2) + r5) + this.NUM_LEN) - 1)).get(0).getData();
    }

    /* JADX INFO: renamed from: getData-TcUX1vc, reason: not valid java name */
    public final byte[] m5887getDataTcUX1vc() {
        return UCollectionsKt.toUByteArray(UArraysKt.m8303slicec0bezYM(this.rawDataPackage, new IntRange(this.HEADER_LEN + this.CH_LEN + this.SEQ_LEN + this.NUM_LEN, UByteArray.m7310getSizeimpl(this.rawDataPackage) - 1)));
    }

    public final boolean isValid() {
        if (UByteArray.m7310getSizeimpl(this.rawDataPackage) != this.PACKET_LEN) {
            return false;
        }
        int iM7310getSizeimpl = UByteArray.m7310getSizeimpl(this.HEADER);
        for (int i = 0; i < iM7310getSizeimpl; i++) {
            if (UByteArray.m7309getw2LRezQ(this.rawDataPackage, i) != UByteArray.m7309getw2LRezQ(this.HEADER, i)) {
                return false;
            }
        }
        return true;
    }

    public final ArrayList<UByteArray> convertData(String message) {
        int size;
        Intrinsics.checkNotNullParameter(message, "message");
        ArrayList arrayList = new ArrayList();
        ArrayList<UByteArray> arrayList2 = new ArrayList<>();
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, message.length() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                arrayList.add(Integer.valueOf(Integer.parseInt(StringsKt.slice(message, new IntRange(i, i + 1)), CharsKt.checkRadix(16))));
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        int size2 = arrayList.size() - 1;
        int i2 = this.DATA_LEN;
        if (i2 <= 0) {
            throw new IllegalArgumentException("Step must be positive, was: " + i2 + '.');
        }
        int progressionLastElement2 = ProgressionUtilKt.getProgressionLastElement(0, size2, i2);
        if (progressionLastElement2 >= 0) {
            int i3 = 0;
            while (true) {
                int size3 = this.DATA_LEN + i3 < arrayList.size() ? this.DATA_LEN + i3 : arrayList.size();
                byte[] bArrM7303constructorimpl = UByteArray.m7303constructorimpl(this.DATA_LEN);
                List mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.slice((List) arrayList, new IntRange(i3, size3 - 1)));
                int size4 = mutableList.size();
                int i4 = this.DATA_LEN;
                if (size4 < i4 && (size = i4 - mutableList.size()) >= 0) {
                    int i5 = 0;
                    while (true) {
                        mutableList.add(0);
                        if (i5 == size) {
                            break;
                        }
                        i5++;
                    }
                }
                int size5 = mutableList.size();
                for (int i6 = 0; i6 < size5; i6++) {
                    UByteArray.m7314setVurrAj0(bArrM7303constructorimpl, i6, UByte.m7251constructorimpl((byte) ((Number) mutableList.get(i6)).intValue()));
                }
                arrayList2.add(UByteArray.m7302boximpl(bArrM7303constructorimpl));
                if (i3 == progressionLastElement2) {
                    break;
                }
                i3 += i2;
            }
        }
        return arrayList2;
    }

    public final String toUUID() {
        StringBuilder sbAppend = new StringBuilder().append(m5884hex87apg3OU(UByteArray.m7309getw2LRezQ(this.rawDataPackage, 0))).append(m5884hex87apg3OU(UByteArray.m7309getw2LRezQ(this.rawDataPackage, 1))).append(m5884hex87apg3OU(UByteArray.m7309getw2LRezQ(this.rawDataPackage, 2))).append(m5884hex87apg3OU(UByteArray.m7309getw2LRezQ(this.rawDataPackage, 3))).append('-').append(m5883hex16WZ4Q5Ns(m5886getChannelpVg5ArA())).append('-').append(m5884hex87apg3OU(m5891getSeqw2LRezQ())).append(m5884hex87apg3OU(m5888getNumw2LRezQ())).append('-');
        List listSlice = CollectionsKt.slice((List) UArraysKt.m8242reversedGBYM_sE(m5887getDataTcUX1vc()), new IntRange(0, 1));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSlice, 10));
        Iterator it2 = listSlice.iterator();
        while (it2.hasNext()) {
            arrayList.add(m5884hex87apg3OU(((UByte) it2.next()).getData()));
        }
        Iterator it3 = arrayList.iterator();
        if (!it3.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it3.next();
        while (it3.hasNext()) {
            next = ((String) next) + ((String) it3.next());
        }
        StringBuilder sbAppend2 = sbAppend.append((String) next).append('-');
        List listSlice2 = CollectionsKt.slice((List) UArraysKt.m8242reversedGBYM_sE(m5887getDataTcUX1vc()), new IntRange(2, UByteArray.m7310getSizeimpl(m5887getDataTcUX1vc()) - 1));
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSlice2, 10));
        Iterator it4 = listSlice2.iterator();
        while (it4.hasNext()) {
            arrayList2.add(m5884hex87apg3OU(((UByte) it4.next()).getData()));
        }
        Iterator it5 = arrayList2.iterator();
        if (!it5.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next2 = it5.next();
        while (it5.hasNext()) {
            next2 = ((String) next2) + ((String) it5.next());
        }
        return sbAppend2.append((String) next2).toString();
    }

    /* JADX INFO: renamed from: hex8-7apg3OU, reason: not valid java name */
    private final String m5884hex87apg3OU(byte b) {
        return StringsKt.padStart(UStringsKt.m8546toStringLxnNnR4(b, 16), 2, '0');
    }

    /* JADX INFO: renamed from: hex16-WZ4Q5Ns, reason: not valid java name */
    private final String m5883hex16WZ4Q5Ns(int i) {
        return UStringsKt.m8547toStringV7xB4Y4(i, 16);
    }
}
