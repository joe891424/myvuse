package com.yoti.mobile.documentscanconfig;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/documentscanconfig/CountryCode;", "", "type", "Lcom/yoti/mobile/documentscanconfig/CountryCode$Type;", "code", "", "(Lcom/yoti/mobile/documentscanconfig/CountryCode$Type;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getType", "()Lcom/yoti/mobile/documentscanconfig/CountryCode$Type;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Type", "documentscanconfig_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class CountryCode {

    /* JADX INFO: renamed from: a */
    private final Type f7902a;

    /* JADX INFO: renamed from: b */
    private final String f7903b;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/documentscanconfig/CountryCode$Type;", "", "(Ljava/lang/String;I)V", "ISO_ALPHA_2", "ISO_ALPHA_3", "documentscanconfig_release"}, m5599k = 1, m5600mv = {1, 1, 15})
    public enum Type {
        ISO_ALPHA_2,
        ISO_ALPHA_3
    }

    public CountryCode(Type type, String code) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(code, "code");
        this.f7902a = type;
        this.f7903b = code;
        int i = C5059a.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            if (code.length() != 2) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        } else if (i == 2 && code.length() != 3) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public /* synthetic */ CountryCode(Type type, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Type.ISO_ALPHA_2 : type, str);
    }

    public static /* synthetic */ CountryCode copy$default(CountryCode countryCode, Type type, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            type = countryCode.f7902a;
        }
        if ((i & 2) != 0) {
            str = countryCode.f7903b;
        }
        return countryCode.copy(type, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Type getF7902a() {
        return this.f7902a;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getF7903b() {
        return this.f7903b;
    }

    public final CountryCode copy(Type type, String code) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(code, "code");
        return new CountryCode(type, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryCode)) {
            return false;
        }
        CountryCode countryCode = (CountryCode) other;
        return Intrinsics.areEqual(this.f7902a, countryCode.f7902a) && Intrinsics.areEqual(this.f7903b, countryCode.f7903b);
    }

    public final String getCode() {
        return this.f7903b;
    }

    public final Type getType() {
        return this.f7902a;
    }

    public int hashCode() {
        Type type = this.f7902a;
        int iHashCode = (type != null ? type.hashCode() : 0) * 31;
        String str = this.f7903b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "CountryCode(type=" + this.f7902a + ", code=" + this.f7903b + ")";
    }
}
