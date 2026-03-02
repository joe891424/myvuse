package com.yoti.mobile.android.documentscan.domain.validator;

import com.yoti.mobile.android.documentscan.domain.validator.UKDrivingLicenceValidator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.domain.validator.v */
/* JADX INFO: loaded from: classes5.dex */
public final class C4756v {

    /* JADX INFO: renamed from: a */
    private final boolean f6976a;

    /* JADX INFO: renamed from: b */
    private final UKDrivingLicenceValidator.UKDrivingLicenceValidationResult f6977b;

    public C4756v(boolean z, UKDrivingLicenceValidator.UKDrivingLicenceValidationResult cause) {
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        this.f6976a = z;
        this.f6977b = cause;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4892a() {
        return this.f6976a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4756v)) {
            return false;
        }
        C4756v c4756v = (C4756v) obj;
        return this.f6976a == c4756v.f6976a && Intrinsics.areEqual(this.f6977b, c4756v.f6977b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f6976a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        UKDrivingLicenceValidator.UKDrivingLicenceValidationResult uKDrivingLicenceValidationResult = this.f6977b;
        return i + (uKDrivingLicenceValidationResult != null ? uKDrivingLicenceValidationResult.hashCode() : 0);
    }

    public String toString() {
        return "ValidationResult(isValid=" + this.f6976a + ", cause=" + this.f6977b + ")";
    }
}
