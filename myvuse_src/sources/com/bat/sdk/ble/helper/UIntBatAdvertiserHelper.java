package com.bat.sdk.ble.helper;

import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
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

/* JADX INFO: compiled from: UIntBatAdvertiserHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u0001:\u00018B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010\u0013J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180!J\r\u0010\"\u001a\u00020\u0018¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0018¢\u0006\u0004\b&\u0010$J\r\u0010'\u001a\u00020\u0018¢\u0006\u0004\b(\u0010$J\r\u0010)\u001a\u00020\u0003¢\u0006\u0004\b*\u0010\u0013J\u0006\u0010+\u001a\u00020,J#\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00030/j\b\u0012\u0004\u0012\u00020\u0003`.2\u0006\u00100\u001a\u00020\u0007¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020\u0007J\u0013\u00103\u001a\u00020\u0007*\u00020\u0018H\u0002¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u00020\u0007*\u00020\u0018H\u0002¢\u0006\u0004\b7\u00105R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00069"}, m5598d2 = {"Lcom/bat/sdk/ble/helper/UIntBatAdvertiserHelper;", "", "raw", "Lkotlin/UIntArray;", "<init>", "([ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "TAG", "", "HEADER_LEN", "", "CH_LEN", "SEQ_LEN", "NUM_LEN", "DATA_LEN", "PACKET_LEN", "HEADER", "[I", "rawDataPackage", "getRawDataPackage--hP7Qyg", "()[I", "setRawDataPackage--ajY-9A", "([I)V", "fromValues", "channel", "Lkotlin/UInt;", "seq", "num", "data", "fromValues-fAcvDqA", "(III[I)Lcom/bat/sdk/ble/helper/UIntBatAdvertiserHelper;", "getRaw", "getRaw--hP7Qyg", "getHeader", "", "getChannel", "getChannel-pVg5ArA", "()I", "getSeq", "getSeq-pVg5ArA", "getNum", "getNum-pVg5ArA", "getData", "getData--hP7Qyg", "isValid", "", "convertData", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "message", "(Ljava/lang/String;)Ljava/util/ArrayList;", "toUUID", "hex8", "hex8-WZ4Q5Ns", "(I)Ljava/lang/String;", "hex16", "hex16-WZ4Q5Ns", "Companion", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class UIntBatAdvertiserHelper {
    private final int CH_LEN;
    private final int DATA_LEN;
    private final int[] HEADER;
    private final int HEADER_LEN;
    private final int NUM_LEN;
    private final int PACKET_LEN;
    private final int SEQ_LEN;
    private final String TAG;
    private int[] rawDataPackage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] CHALLENGE_REQ_PAYLOAD = {16, 17, 18, 19, 20, 21, 22, 23};
    private static final int[] SIGNATURE_RES_PAYLOAD_OK = {32, 33, 34, 35, 36, 37, 38, 39};
    private static final int[] SIGNATURE_RES_PAYLOAD_KO = {48, 49, 50, 51, 52, 53, 54, 55};
    private static final int[] CHALLENGE_RES_ALREADY_UNLOCKED = {17, 16, 15, 14, 13, 12, 11, 10};
    private static final int[] UNLOCK_ACK = {24, 25, 26, 27, 28, 29, 30, 31};

    public /* synthetic */ UIntBatAdvertiserHelper(int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr);
    }

    private UIntBatAdvertiserHelper(int[] iArr) {
        this.TAG = "BatAdvertiserHelper";
        this.HEADER_LEN = 4;
        this.CH_LEN = 2;
        this.SEQ_LEN = 1;
        this.NUM_LEN = 1;
        this.DATA_LEN = 8;
        int i = 4 + 2;
        int i2 = i + 10;
        this.PACKET_LEN = i2;
        this.HEADER = new int[]{116, 104, 105, OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED};
        int[] iArrM7382constructorimpl = UIntArray.m7382constructorimpl(i2);
        UArraysKt.m7861fill2fe2U9s(iArrM7382constructorimpl, 0, 0, i + 9);
        this.rawDataPackage = iArrM7382constructorimpl;
        if (iArr != null) {
            this.rawDataPackage = iArr;
        }
    }

    public /* synthetic */ UIntBatAdvertiserHelper(int[] iArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iArr, null);
    }

    /* JADX INFO: renamed from: getRawDataPackage--hP7Qyg, reason: not valid java name */
    public final int[] m5905getRawDataPackagehP7Qyg() {
        return this.rawDataPackage;
    }

    /* JADX INFO: renamed from: setRawDataPackage--ajY-9A, reason: not valid java name */
    public final void m5907setRawDataPackageajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.rawDataPackage = iArr;
    }

    /* JADX INFO: compiled from: UIntBatAdvertiserHelper.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, m5598d2 = {"Lcom/bat/sdk/ble/helper/UIntBatAdvertiserHelper$Companion;", "", "<init>", "()V", "CHALLENGE_REQ_PAYLOAD", "Lkotlin/UIntArray;", "getCHALLENGE_REQ_PAYLOAD--hP7Qyg", "()[I", "[I", "SIGNATURE_RES_PAYLOAD_OK", "getSIGNATURE_RES_PAYLOAD_OK--hP7Qyg", "SIGNATURE_RES_PAYLOAD_KO", "getSIGNATURE_RES_PAYLOAD_KO--hP7Qyg", "CHALLENGE_RES_ALREADY_UNLOCKED", "getCHALLENGE_RES_ALREADY_UNLOCKED--hP7Qyg", "UNLOCK_ACK", "getUNLOCK_ACK--hP7Qyg", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getCHALLENGE_REQ_PAYLOAD--hP7Qyg, reason: not valid java name */
        public final int[] m5908getCHALLENGE_REQ_PAYLOADhP7Qyg() {
            return UIntBatAdvertiserHelper.CHALLENGE_REQ_PAYLOAD;
        }

        /* JADX INFO: renamed from: getSIGNATURE_RES_PAYLOAD_OK--hP7Qyg, reason: not valid java name */
        public final int[] m5911getSIGNATURE_RES_PAYLOAD_OKhP7Qyg() {
            return UIntBatAdvertiserHelper.SIGNATURE_RES_PAYLOAD_OK;
        }

        /* JADX INFO: renamed from: getSIGNATURE_RES_PAYLOAD_KO--hP7Qyg, reason: not valid java name */
        public final int[] m5910getSIGNATURE_RES_PAYLOAD_KOhP7Qyg() {
            return UIntBatAdvertiserHelper.SIGNATURE_RES_PAYLOAD_KO;
        }

        /* JADX INFO: renamed from: getCHALLENGE_RES_ALREADY_UNLOCKED--hP7Qyg, reason: not valid java name */
        public final int[] m5909getCHALLENGE_RES_ALREADY_UNLOCKEDhP7Qyg() {
            return UIntBatAdvertiserHelper.CHALLENGE_RES_ALREADY_UNLOCKED;
        }

        /* JADX INFO: renamed from: getUNLOCK_ACK--hP7Qyg, reason: not valid java name */
        public final int[] m5912getUNLOCK_ACKhP7Qyg() {
            return UIntBatAdvertiserHelper.UNLOCK_ACK;
        }
    }

    /* JADX INFO: renamed from: fromValues-fAcvDqA, reason: not valid java name */
    public final UIntBatAdvertiserHelper m5900fromValuesfAcvDqA(int channel, int seq, int num, int[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.rawDataPackage = UIntArray.m7383constructorimpl(ArraysKt.plus(UIntArray.m7383constructorimpl(ArraysKt.plus(this.HEADER, new int[]{UInt.m7328constructorimpl(channel >>> 8), UInt.m7328constructorimpl(channel & 255), seq, num})), data));
        return this;
    }

    /* JADX INFO: renamed from: getRaw--hP7Qyg, reason: not valid java name and from getter */
    public final int[] getRawDataPackage() {
        return this.rawDataPackage;
    }

    public final List<UInt> getHeader() {
        return UArraysKt.m8304slicetAntMlw(this.rawDataPackage, new IntRange(0, this.HEADER_LEN - 1));
    }

    /* JADX INFO: renamed from: getChannel-pVg5ArA, reason: not valid java name */
    public final int m5901getChannelpVg5ArA() {
        int[] iArr = this.rawDataPackage;
        int i = this.HEADER_LEN;
        int iM7328constructorimpl = UInt.m7328constructorimpl(UArraysKt.m8304slicetAntMlw(iArr, new IntRange(i, (this.CH_LEN + i) - 1)).get(0).getData() << 8);
        int[] iArr2 = this.rawDataPackage;
        int i2 = this.HEADER_LEN;
        return UInt.m7328constructorimpl(iM7328constructorimpl | UArraysKt.m8304slicetAntMlw(iArr2, new IntRange(i2, (this.CH_LEN + i2) - 1)).get(1).getData());
    }

    /* JADX INFO: renamed from: getSeq-pVg5ArA, reason: not valid java name */
    public final int m5906getSeqpVg5ArA() {
        return UArraysKt.m8304slicetAntMlw(this.rawDataPackage, new IntRange(this.HEADER_LEN + this.CH_LEN, ((r2 + r3) + this.SEQ_LEN) - 1)).get(0).getData();
    }

    /* JADX INFO: renamed from: getNum-pVg5ArA, reason: not valid java name */
    public final int m5903getNumpVg5ArA() {
        int[] iArr = this.rawDataPackage;
        int i = this.HEADER_LEN;
        int i2 = this.CH_LEN;
        return UArraysKt.m8304slicetAntMlw(iArr, new IntRange(i + i2 + this.SEQ_LEN, (((i + i2) + r5) + this.NUM_LEN) - 1)).get(0).getData();
    }

    /* JADX INFO: renamed from: getData--hP7Qyg, reason: not valid java name */
    public final int[] m5902getDatahP7Qyg() {
        return UCollectionsKt.toUIntArray(UArraysKt.m8304slicetAntMlw(this.rawDataPackage, new IntRange(this.HEADER_LEN + this.CH_LEN + this.SEQ_LEN + this.NUM_LEN, UIntArray.m7389getSizeimpl(this.rawDataPackage) - 1)));
    }

    public final boolean isValid() {
        if (UIntArray.m7389getSizeimpl(this.rawDataPackage) != this.PACKET_LEN) {
            return false;
        }
        int iM7389getSizeimpl = UIntArray.m7389getSizeimpl(this.HEADER);
        for (int i = 0; i < iM7389getSizeimpl; i++) {
            if (UIntArray.m7388getpVg5ArA(this.rawDataPackage, i) != UIntArray.m7388getpVg5ArA(this.HEADER, i)) {
                return false;
            }
        }
        return true;
    }

    public final ArrayList<UIntArray> convertData(String message) {
        int size;
        Intrinsics.checkNotNullParameter(message, "message");
        ArrayList arrayList = new ArrayList();
        ArrayList<UIntArray> arrayList2 = new ArrayList<>();
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
                int[] iArrM7382constructorimpl = UIntArray.m7382constructorimpl(this.DATA_LEN);
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
                    UIntArray.m7393setVXSXFK8(iArrM7382constructorimpl, i6, UInt.m7328constructorimpl(((Number) mutableList.get(i6)).intValue()));
                }
                arrayList2.add(UIntArray.m7381boximpl(iArrM7382constructorimpl));
                if (i3 == progressionLastElement2) {
                    break;
                }
                i3 += i2;
            }
        }
        return arrayList2;
    }

    public final String toUUID() {
        StringBuilder sbAppend = new StringBuilder().append(m5899hex8WZ4Q5Ns(UIntArray.m7388getpVg5ArA(this.rawDataPackage, 0))).append(m5899hex8WZ4Q5Ns(UIntArray.m7388getpVg5ArA(this.rawDataPackage, 1))).append(m5899hex8WZ4Q5Ns(UIntArray.m7388getpVg5ArA(this.rawDataPackage, 2))).append(m5899hex8WZ4Q5Ns(UIntArray.m7388getpVg5ArA(this.rawDataPackage, 3))).append('-').append(m5898hex16WZ4Q5Ns(m5901getChannelpVg5ArA())).append('-').append(m5899hex8WZ4Q5Ns(m5906getSeqpVg5ArA())).append(m5899hex8WZ4Q5Ns(m5903getNumpVg5ArA())).append('-');
        List listSlice = CollectionsKt.slice((List) UArraysKt.m8241reversedajY9A(m5902getDatahP7Qyg()), new IntRange(0, 1));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSlice, 10));
        Iterator it2 = listSlice.iterator();
        while (it2.hasNext()) {
            arrayList.add(m5899hex8WZ4Q5Ns(((UInt) it2.next()).getData()));
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
        List listSlice2 = CollectionsKt.slice((List) UArraysKt.m8241reversedajY9A(m5902getDatahP7Qyg()), new IntRange(2, UIntArray.m7389getSizeimpl(m5902getDatahP7Qyg()) - 1));
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSlice2, 10));
        Iterator it4 = listSlice2.iterator();
        while (it4.hasNext()) {
            arrayList2.add(m5899hex8WZ4Q5Ns(((UInt) it4.next()).getData()));
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

    /* JADX INFO: renamed from: hex8-WZ4Q5Ns, reason: not valid java name */
    private final String m5899hex8WZ4Q5Ns(int i) {
        return StringsKt.padStart(UStringsKt.m8547toStringV7xB4Y4(i, 16), 2, '0');
    }

    /* JADX INFO: renamed from: hex16-WZ4Q5Ns, reason: not valid java name */
    private final String m5898hex16WZ4Q5Ns(int i) {
        return StringsKt.padStart(UStringsKt.m8547toStringV7xB4Y4(i, 16), 4, '0');
    }
}
