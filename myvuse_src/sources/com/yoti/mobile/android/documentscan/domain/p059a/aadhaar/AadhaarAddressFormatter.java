package com.yoti.mobile.android.documentscan.domain.p059a.aadhaar;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.a.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0002\b\b¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/domain/extractors/aadhaar/AadhaarAddressFormatter;", "", "()V", "parseAddress", "Lcom/yoti/mobile/android/documentscan/domain/extractors/aadhaar/AadhaarAddressFormatter$AadhaarAddressCandidate;", "attributeValues", "", "", "parseAddress$documentscan_release", "AadhaarAddressCandidate", "Companion", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class AadhaarAddressFormatter {
    public static final String ATTR_CARE_OF = "co";
    public static final String ATTR_DISTRICT = "dist";
    public static final String ATTR_HOUSE = "house";
    public static final String ATTR_LANDMARK = "lm";
    public static final String ATTR_LOCALITY = "loc";
    public static final String ATTR_POSTAL_PIN_CODE = "pc";
    public static final String ATTR_POST_OFFICE = "po";
    public static final String ATTR_STATE = "state";
    public static final String ATTR_STREET = "street";
    public static final String ATTR_SUBDISTRICT = "subdist";
    public static final String ATTR_VILLAGE_TOWN_CITY = "vtc";

    /* JADX INFO: renamed from: b */
    public static final b f6856b = new b(null);

    /* JADX INFO: renamed from: a */
    private static final String[] f6855a = {"C/O,", "C/O", "W/O,", "W/O", "S/O,", "S/O", "D/O,", "D/O"};

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.a.a$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        private String f6857a;

        /* JADX INFO: renamed from: b */
        private final String f6858b;

        /* JADX INFO: renamed from: c */
        private final String f6859c;

        /* JADX INFO: renamed from: d */
        private final String f6860d;

        /* JADX INFO: renamed from: e */
        private final String f6861e;

        /* JADX INFO: renamed from: f */
        private String f6862f;

        /* JADX INFO: renamed from: g */
        private String f6863g;

        /* JADX INFO: renamed from: h */
        private final String f6864h;

        /* JADX INFO: renamed from: i */
        private final String f6865i;

        /* JADX INFO: renamed from: j */
        private final String f6866j;

        /* JADX INFO: renamed from: k */
        private final String f6867k;

        /* JADX INFO: renamed from: l */
        private final String f6868l;

        /* JADX INFO: renamed from: m */
        private final String f6869m;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
            this.f6857a = str;
            this.f6858b = str2;
            this.f6859c = str3;
            this.f6860d = str4;
            this.f6861e = str5;
            this.f6862f = str6;
            this.f6863g = str7;
            this.f6864h = str8;
            this.f6865i = str9;
            this.f6866j = str10;
            this.f6867k = str11;
            this.f6868l = str12;
            this.f6869m = str13;
            m4713n();
        }

        public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13);
        }

        /* JADX INFO: renamed from: a */
        private final StringBuilder m4712a(StringBuilder sb, String str) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(str);
            return sb;
        }

        /* JADX INFO: renamed from: n */
        private final void m4713n() {
            if (ArraysKt.contains(AadhaarAddressFormatter.f6855a, this.f6857a)) {
                this.f6857a = null;
            }
            String str = this.f6862f;
            if (str != null && str.equals(this.f6864h)) {
                this.f6862f = null;
            }
            String str2 = this.f6862f;
            if (str2 != null && str2.equals(this.f6863g)) {
                this.f6862f = null;
            }
            String str3 = this.f6864h;
            if (str3 == null || !str3.equals(this.f6863g)) {
                return;
            }
            this.f6863g = null;
        }

        /* JADX INFO: renamed from: a */
        public final String m4714a() {
            return this.f6857a;
        }

        /* JADX INFO: renamed from: b */
        public final String m4715b() {
            return this.f6868l;
        }

        /* JADX INFO: renamed from: c */
        public final String m4716c() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.f6857a;
            if (str2 != null) {
                m4712a(sb, str2);
            }
            String str3 = this.f6858b;
            if (str3 != null) {
                m4712a(sb, str3);
            }
            String str4 = this.f6859c;
            if (str4 != null) {
                m4712a(sb, str4);
            }
            String str5 = this.f6861e;
            if (str5 != null) {
                m4712a(sb, str5);
            }
            String str6 = this.f6862f;
            if (str6 != null) {
                m4712a(sb, str6);
            }
            String str7 = this.f6863g;
            if (str7 != null) {
                m4712a(sb, str7);
            }
            String str8 = this.f6864h;
            if (str8 != null) {
                m4712a(sb, str8);
            }
            String str9 = this.f6865i;
            if (str9 != null) {
                m4712a(sb, str9);
            }
            String str10 = this.f6866j;
            if (str10 != null) {
                m4712a(sb, str10);
            }
            if (sb.length() > 0 && (str = this.f6869m) != null) {
                m4712a(sb, str);
            }
            String string = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply {\n…\n            }.toString()");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = string.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }

        /* JADX INFO: renamed from: d */
        public final String m4717d() {
            return this.f6864h;
        }

        /* JADX INFO: renamed from: e */
        public final String m4718e() {
            return this.f6858b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f6857a, aVar.f6857a) && Intrinsics.areEqual(this.f6858b, aVar.f6858b) && Intrinsics.areEqual(this.f6859c, aVar.f6859c) && Intrinsics.areEqual(this.f6860d, aVar.f6860d) && Intrinsics.areEqual(this.f6861e, aVar.f6861e) && Intrinsics.areEqual(this.f6862f, aVar.f6862f) && Intrinsics.areEqual(this.f6863g, aVar.f6863g) && Intrinsics.areEqual(this.f6864h, aVar.f6864h) && Intrinsics.areEqual(this.f6865i, aVar.f6865i) && Intrinsics.areEqual(this.f6866j, aVar.f6866j) && Intrinsics.areEqual(this.f6867k, aVar.f6867k) && Intrinsics.areEqual(this.f6868l, aVar.f6868l) && Intrinsics.areEqual(this.f6869m, aVar.f6869m);
        }

        /* JADX INFO: renamed from: f */
        public final String m4719f() {
            return this.f6860d;
        }

        /* JADX INFO: renamed from: g */
        public final String m4720g() {
            return this.f6861e;
        }

        /* JADX INFO: renamed from: h */
        public final String m4721h() {
            return this.f6866j;
        }

        public int hashCode() {
            String str = this.f6857a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f6858b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f6859c;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f6860d;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f6861e;
            int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.f6862f;
            int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.f6863g;
            int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.f6864h;
            int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.f6865i;
            int iHashCode9 = (iHashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.f6866j;
            int iHashCode10 = (iHashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.f6867k;
            int iHashCode11 = (iHashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.f6868l;
            int iHashCode12 = (iHashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
            String str13 = this.f6869m;
            return iHashCode12 + (str13 != null ? str13.hashCode() : 0);
        }

        /* JADX INFO: renamed from: i */
        public final String m4722i() {
            return this.f6867k;
        }

        /* JADX INFO: renamed from: j */
        public final String m4723j() {
            return this.f6865i;
        }

        /* JADX INFO: renamed from: k */
        public final String m4724k() {
            return this.f6859c;
        }

        /* JADX INFO: renamed from: l */
        public final String m4725l() {
            return this.f6863g;
        }

        /* JADX INFO: renamed from: m */
        public final String m4726m() {
            return this.f6862f;
        }

        public String toString() {
            return "AadhaarAddressCandidate(careOf=" + this.f6857a + ", house=" + this.f6858b + ", street=" + this.f6859c + ", landmark=" + this.f6860d + ", locality=" + this.f6861e + ", villageTownCity=" + this.f6862f + ", subdist=" + this.f6863g + ", dist=" + this.f6864h + ", state=" + this.f6865i + ", pinCode=" + this.f6866j + ", postOffice=" + this.f6867k + ", countryAlpha3=" + this.f6868l + ", country=" + this.f6869m + ")";
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.a.a.a.a$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: a */
    public final a m4711a(Map<String, String> attributeValues) {
        Intrinsics.checkParameterIsNotNull(attributeValues, "attributeValues");
        return new a(attributeValues.get("co"), attributeValues.get(ATTR_HOUSE), attributeValues.get(ATTR_STREET), attributeValues.get(ATTR_LANDMARK), attributeValues.get(ATTR_LOCALITY), attributeValues.get(ATTR_VILLAGE_TOWN_CITY), attributeValues.get(ATTR_SUBDISTRICT), attributeValues.get(ATTR_DISTRICT), attributeValues.get("state"), attributeValues.get(ATTR_POSTAL_PIN_CODE), attributeValues.get(ATTR_POST_OFFICE), null, null, 6144, null);
    }
}
