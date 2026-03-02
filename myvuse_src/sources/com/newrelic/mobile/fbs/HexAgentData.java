package com.newrelic.mobile.fbs;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.flatbuffers.Table;
import com.newrelic.mobile.fbs.hex.HandledException;
import com.newrelic.mobile.fbs.jserror.JsError;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes6.dex */
public final class HexAgentData extends Table {
    public static HexAgentData getRootAsHexAgentData(ByteBuffer byteBuffer) {
        return getRootAsHexAgentData(byteBuffer, new HexAgentData());
    }

    public static HexAgentData getRootAsHexAgentData(ByteBuffer byteBuffer, HexAgentData hexAgentData) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return hexAgentData.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f4047bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f4047bb.getInt(this.bb_pos);
        this.vtable_size = this.f4047bb.getShort(this.vtable_start);
    }

    public HexAgentData __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public StringSessionAttribute stringAttributes(int i) {
        return stringAttributes(new StringSessionAttribute(), i);
    }

    public StringSessionAttribute stringAttributes(StringSessionAttribute stringSessionAttribute, int i) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return stringSessionAttribute.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int stringAttributesLength() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public StringSessionAttribute stringAttributesByKey(String str) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return StringSessionAttribute.__lookup_by_key(null, __vector(i__offset), str, this.f4047bb);
        }
        return null;
    }

    public StringSessionAttribute stringAttributesByKey(StringSessionAttribute stringSessionAttribute, String str) {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return StringSessionAttribute.__lookup_by_key(stringSessionAttribute, __vector(i__offset), str, this.f4047bb);
        }
        return null;
    }

    public LongSessionAttribute longAttributes(int i) {
        return longAttributes(new LongSessionAttribute(), i);
    }

    public LongSessionAttribute longAttributes(LongSessionAttribute longSessionAttribute, int i) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return longSessionAttribute.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int longAttributesLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public LongSessionAttribute longAttributesByKey(String str) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return LongSessionAttribute.__lookup_by_key(null, __vector(i__offset), str, this.f4047bb);
        }
        return null;
    }

    public LongSessionAttribute longAttributesByKey(LongSessionAttribute longSessionAttribute, String str) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return LongSessionAttribute.__lookup_by_key(longSessionAttribute, __vector(i__offset), str, this.f4047bb);
        }
        return null;
    }

    public DoubleSessionAttribute doubleAttributes(int i) {
        return doubleAttributes(new DoubleSessionAttribute(), i);
    }

    public DoubleSessionAttribute doubleAttributes(DoubleSessionAttribute doubleSessionAttribute, int i) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return doubleSessionAttribute.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int doubleAttributesLength() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public DoubleSessionAttribute doubleAttributesByKey(String str) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return DoubleSessionAttribute.__lookup_by_key(null, __vector(i__offset), str, this.f4047bb);
        }
        return null;
    }

    public DoubleSessionAttribute doubleAttributesByKey(DoubleSessionAttribute doubleSessionAttribute, String str) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return DoubleSessionAttribute.__lookup_by_key(doubleSessionAttribute, __vector(i__offset), str, this.f4047bb);
        }
        return null;
    }

    public BoolSessionAttribute boolAttributes(int i) {
        return boolAttributes(new BoolSessionAttribute(), i);
    }

    public BoolSessionAttribute boolAttributes(BoolSessionAttribute boolSessionAttribute, int i) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return boolSessionAttribute.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int boolAttributesLength() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public BoolSessionAttribute boolAttributesByKey(String str) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return BoolSessionAttribute.__lookup_by_key(null, __vector(i__offset), str, this.f4047bb);
        }
        return null;
    }

    public BoolSessionAttribute boolAttributesByKey(BoolSessionAttribute boolSessionAttribute, String str) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return BoolSessionAttribute.__lookup_by_key(boolSessionAttribute, __vector(i__offset), str, this.f4047bb);
        }
        return null;
    }

    public HandledException handledExceptions(int i) {
        return handledExceptions(new HandledException(), i);
    }

    public HandledException handledExceptions(HandledException handledException, int i) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return handledException.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int handledExceptionsLength() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public ApplicationInfo applicationInfo() {
        return applicationInfo(new ApplicationInfo());
    }

    public ApplicationInfo applicationInfo(ApplicationInfo applicationInfo) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return applicationInfo.__assign(__indirect(i__offset + this.bb_pos), this.f4047bb);
        }
        return null;
    }

    public RequestInformation requestInfo() {
        return requestInfo(new RequestInformation());
    }

    public RequestInformation requestInfo(RequestInformation requestInformation) {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return requestInformation.__assign(__indirect(i__offset + this.bb_pos), this.f4047bb);
        }
        return null;
    }

    public JsError jsErrors(int i) {
        return jsErrors(new JsError(), i);
    }

    public JsError jsErrors(JsError jsError, int i) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return jsError.__assign(__indirect(__vector(i__offset) + (i * 4)), this.f4047bb);
        }
        return null;
    }

    public int jsErrorsLength() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public static int createHexAgentData(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        flatBufferBuilder.startObject(8);
        addJsErrors(flatBufferBuilder, i8);
        addRequestInfo(flatBufferBuilder, i7);
        addApplicationInfo(flatBufferBuilder, i6);
        addHandledExceptions(flatBufferBuilder, i5);
        addBoolAttributes(flatBufferBuilder, i4);
        addDoubleAttributes(flatBufferBuilder, i3);
        addLongAttributes(flatBufferBuilder, i2);
        addStringAttributes(flatBufferBuilder, i);
        return endHexAgentData(flatBufferBuilder);
    }

    public static void startHexAgentData(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(8);
    }

    public static void addStringAttributes(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static int createStringAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startStringAttributesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addLongAttributes(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int createLongAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startLongAttributesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addDoubleAttributes(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static int createDoubleAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startDoubleAttributesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addBoolAttributes(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static int createBoolAttributesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startBoolAttributesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addHandledExceptions(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static int createHandledExceptionsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startHandledExceptionsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addApplicationInfo(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static void addRequestInfo(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addJsErrors(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static int createJsErrorsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startJsErrorsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endHexAgentData(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }

    public static void finishHexAgentDataBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedHexAgentDataBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }
}
