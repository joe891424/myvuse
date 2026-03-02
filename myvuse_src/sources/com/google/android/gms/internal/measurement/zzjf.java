package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzjf {
    DOUBLE(0, zzjh.SCALAR, zzjv.DOUBLE),
    FLOAT(1, zzjh.SCALAR, zzjv.FLOAT),
    INT64(2, zzjh.SCALAR, zzjv.LONG),
    UINT64(3, zzjh.SCALAR, zzjv.LONG),
    INT32(4, zzjh.SCALAR, zzjv.INT),
    FIXED64(5, zzjh.SCALAR, zzjv.LONG),
    FIXED32(6, zzjh.SCALAR, zzjv.INT),
    BOOL(7, zzjh.SCALAR, zzjv.BOOLEAN),
    STRING(8, zzjh.SCALAR, zzjv.STRING),
    MESSAGE(9, zzjh.SCALAR, zzjv.MESSAGE),
    BYTES(10, zzjh.SCALAR, zzjv.BYTE_STRING),
    UINT32(11, zzjh.SCALAR, zzjv.INT),
    ENUM(12, zzjh.SCALAR, zzjv.ENUM),
    SFIXED32(13, zzjh.SCALAR, zzjv.INT),
    SFIXED64(14, zzjh.SCALAR, zzjv.LONG),
    SINT32(15, zzjh.SCALAR, zzjv.INT),
    SINT64(16, zzjh.SCALAR, zzjv.LONG),
    GROUP(17, zzjh.SCALAR, zzjv.MESSAGE),
    DOUBLE_LIST(18, zzjh.VECTOR, zzjv.DOUBLE),
    FLOAT_LIST(19, zzjh.VECTOR, zzjv.FLOAT),
    INT64_LIST(20, zzjh.VECTOR, zzjv.LONG),
    UINT64_LIST(21, zzjh.VECTOR, zzjv.LONG),
    INT32_LIST(22, zzjh.VECTOR, zzjv.INT),
    FIXED64_LIST(23, zzjh.VECTOR, zzjv.LONG),
    FIXED32_LIST(24, zzjh.VECTOR, zzjv.INT),
    BOOL_LIST(25, zzjh.VECTOR, zzjv.BOOLEAN),
    STRING_LIST(26, zzjh.VECTOR, zzjv.STRING),
    MESSAGE_LIST(27, zzjh.VECTOR, zzjv.MESSAGE),
    BYTES_LIST(28, zzjh.VECTOR, zzjv.BYTE_STRING),
    UINT32_LIST(29, zzjh.VECTOR, zzjv.INT),
    ENUM_LIST(30, zzjh.VECTOR, zzjv.ENUM),
    SFIXED32_LIST(31, zzjh.VECTOR, zzjv.INT),
    SFIXED64_LIST(32, zzjh.VECTOR, zzjv.LONG),
    SINT32_LIST(33, zzjh.VECTOR, zzjv.INT),
    SINT64_LIST(34, zzjh.VECTOR, zzjv.LONG),
    DOUBLE_LIST_PACKED(35, zzjh.PACKED_VECTOR, zzjv.DOUBLE),
    FLOAT_LIST_PACKED(36, zzjh.PACKED_VECTOR, zzjv.FLOAT),
    INT64_LIST_PACKED(37, zzjh.PACKED_VECTOR, zzjv.LONG),
    UINT64_LIST_PACKED(38, zzjh.PACKED_VECTOR, zzjv.LONG),
    INT32_LIST_PACKED(39, zzjh.PACKED_VECTOR, zzjv.INT),
    FIXED64_LIST_PACKED(40, zzjh.PACKED_VECTOR, zzjv.LONG),
    FIXED32_LIST_PACKED(41, zzjh.PACKED_VECTOR, zzjv.INT),
    BOOL_LIST_PACKED(42, zzjh.PACKED_VECTOR, zzjv.BOOLEAN),
    UINT32_LIST_PACKED(43, zzjh.PACKED_VECTOR, zzjv.INT),
    ENUM_LIST_PACKED(44, zzjh.PACKED_VECTOR, zzjv.ENUM),
    SFIXED32_LIST_PACKED(45, zzjh.PACKED_VECTOR, zzjv.INT),
    SFIXED64_LIST_PACKED(46, zzjh.PACKED_VECTOR, zzjv.LONG),
    SINT32_LIST_PACKED(47, zzjh.PACKED_VECTOR, zzjv.INT),
    SINT64_LIST_PACKED(48, zzjh.PACKED_VECTOR, zzjv.LONG),
    GROUP_LIST(49, zzjh.VECTOR, zzjv.MESSAGE),
    MAP(50, zzjh.MAP, zzjv.VOID);

    private static final zzjf[] zzaz;
    private final int zzbb;

    public final int zza() {
        return this.zzbb;
    }

    static {
        zzjf[] zzjfVarArrValues = values();
        zzaz = new zzjf[zzjfVarArrValues.length];
        for (zzjf zzjfVar : zzjfVarArrValues) {
            zzaz[zzjfVar.zzbb] = zzjfVar;
        }
    }

    zzjf(int i, zzjh zzjhVar, zzjv zzjvVar) {
        this.zzbb = i;
        int iOrdinal = zzjhVar.ordinal();
        if (iOrdinal == 1 || iOrdinal == 3) {
            zzjvVar.zza();
        }
        if (zzjhVar == zzjh.SCALAR) {
            int i2 = zzje.zza[zzjvVar.ordinal()];
        }
    }
}
