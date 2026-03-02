package com.yoti.mobile.android.yotisdkcore.p082c.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.c.a.b.a, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity;", "", "issueDate", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity;", "expiryDate", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity;Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity;)V", "getExpiryDate", "()Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity;", "getIssueDate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DateRequirementEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class RequirementsEntity {

    /* JADX INFO: renamed from: a */
    private final a f7599a;

    /* JADX INFO: renamed from: b */
    private final a f7600b;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.c.a.b.a$a */
    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity;", "", "constraint", "Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity$ConstraintTypeEntity;", "timeInMonths", "", "(Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity$ConstraintTypeEntity;I)V", "getConstraint", "()Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity$ConstraintTypeEntity;", "getTimeInMonths", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ConstraintTypeEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a */
        private final EnumC6025a f7601a;

        /* JADX INFO: renamed from: b */
        private final int f7602b;

        /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.c.a.b.a$a$a, reason: collision with other inner class name */
        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/validity_checks/domain/model/RequirementsEntity$DateRequirementEntity$ConstraintTypeEntity;", "", "(Ljava/lang/String;I)V", "WITHIN_X_MONTHS_OF_BIRTH", "WITHIN_X_MONTHS", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public enum EnumC6025a {
            WITHIN_X_MONTHS_OF_BIRTH,
            WITHIN_X_MONTHS,
            UNKNOWN
        }

        public a(EnumC6025a constraint, int i) {
            Intrinsics.checkNotNullParameter(constraint, "constraint");
            this.f7601a = constraint;
            this.f7602b = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return this.f7601a == aVar.f7601a && this.f7602b == aVar.f7602b;
        }

        public int hashCode() {
            return (this.f7601a.hashCode() * 31) + Integer.hashCode(this.f7602b);
        }

        public String toString() {
            return "DateRequirementEntity(constraint=" + this.f7601a + ", timeInMonths=" + this.f7602b + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequirementsEntity() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public RequirementsEntity(a aVar, a aVar2) {
        this.f7599a = aVar;
        this.f7600b = aVar2;
    }

    public /* synthetic */ RequirementsEntity(a aVar, a aVar2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : aVar, (i & 2) != 0 ? null : aVar2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequirementsEntity)) {
            return false;
        }
        RequirementsEntity requirementsEntity = (RequirementsEntity) other;
        return Intrinsics.areEqual(this.f7599a, requirementsEntity.f7599a) && Intrinsics.areEqual(this.f7600b, requirementsEntity.f7600b);
    }

    public int hashCode() {
        a aVar = this.f7599a;
        int iHashCode = (aVar == null ? 0 : aVar.hashCode()) * 31;
        a aVar2 = this.f7600b;
        return iHashCode + (aVar2 != null ? aVar2.hashCode() : 0);
    }

    public String toString() {
        return "RequirementsEntity(issueDate=" + this.f7599a + ", expiryDate=" + this.f7600b + ')';
    }
}
