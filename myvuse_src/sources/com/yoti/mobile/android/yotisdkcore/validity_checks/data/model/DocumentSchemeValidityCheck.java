package com.yoti.mobile.android.yotisdkcore.validity_checks.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.e.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck;", "", "requirements", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$Requirements;", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$Requirements;)V", "getRequirements", "()Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$Requirements;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DateRequirement", "Requirements", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentSchemeValidityCheck {

    /* JADX INFO: renamed from: a */
    @SerializedName("requirements")
    private final b f7886a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.e.a$a */
    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement;", "", "_constraint", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement$ConstraintType;", "timeInMonths", "", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement$ConstraintType;I)V", "constraint", "getConstraint", "()Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement$ConstraintType;", "getTimeInMonths", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ConstraintType", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a */
        @SerializedName("constraint")
        private final EnumC6029a f7887a;

        /* JADX INFO: renamed from: b */
        @SerializedName("number_of_months")
        private final int f7888b;

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.e.a$a$a, reason: collision with other inner class name */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement$ConstraintType;", "", "(Ljava/lang/String;I)V", "WITHIN_X_MONTHS_OF_BIRTH", "WITHIN_X_MONTHS", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public enum EnumC6029a {
            WITHIN_X_MONTHS_OF_BIRTH,
            WITHIN_X_MONTHS,
            UNKNOWN
        }

        /* JADX INFO: renamed from: a */
        public final EnumC6029a m5353a() {
            EnumC6029a enumC6029a = this.f7887a;
            return enumC6029a == null ? EnumC6029a.UNKNOWN : enumC6029a;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getF7888b() {
            return this.f7888b;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return this.f7887a == aVar.f7887a && this.f7888b == aVar.f7888b;
        }

        public int hashCode() {
            EnumC6029a enumC6029a = this.f7887a;
            return ((enumC6029a == null ? 0 : enumC6029a.hashCode()) * 31) + Integer.hashCode(this.f7888b);
        }

        public String toString() {
            return "DateRequirement(_constraint=" + this.f7887a + ", timeInMonths=" + this.f7888b + ')';
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.data.e.a$b */
    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$Requirements;", "", "issueDate", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement;", "expiryDate", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement;Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement;)V", "getExpiryDate", "()Lcom/yoti/mobile/android/yotisdkcore/validity_checks/data/model/DocumentSchemeValidityCheck$DateRequirement;", "getIssueDate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class b {

        /* JADX INFO: renamed from: a */
        @SerializedName("issue_date")
        private final a f7890a;

        /* JADX INFO: renamed from: b */
        @SerializedName("expiry_date")
        private final a f7891b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public b(a aVar, a aVar2) {
            this.f7890a = aVar;
            this.f7891b = aVar2;
        }

        public /* synthetic */ b(a aVar, a aVar2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : aVar, (i & 2) != 0 ? null : aVar2);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final a getF7891b() {
            return this.f7891b;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final a getF7890a() {
            return this.f7890a;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            return Intrinsics.areEqual(this.f7890a, bVar.f7890a) && Intrinsics.areEqual(this.f7891b, bVar.f7891b);
        }

        public int hashCode() {
            a aVar = this.f7890a;
            int iHashCode = (aVar == null ? 0 : aVar.hashCode()) * 31;
            a aVar2 = this.f7891b;
            return iHashCode + (aVar2 != null ? aVar2.hashCode() : 0);
        }

        public String toString() {
            return "Requirements(issueDate=" + this.f7890a + ", expiryDate=" + this.f7891b + ')';
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final b getF7886a() {
        return this.f7886a;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DocumentSchemeValidityCheck) && Intrinsics.areEqual(this.f7886a, ((DocumentSchemeValidityCheck) other).f7886a);
    }

    public int hashCode() {
        return this.f7886a.hashCode();
    }

    public String toString() {
        return "DocumentSchemeValidityCheck(requirements=" + this.f7886a + ')';
    }
}
